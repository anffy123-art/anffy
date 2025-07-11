package com.px.partybuild.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.AppConfig;
import com.px.partybuild.mapper.CfMessageCQuery;
import com.px.partybuild.mapper.CfMessageMapper;
import com.px.partybuild.model.*;
import com.px.partybuild.service.CommonService;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.service.MessageService;
import com.px.partybuild.service.UserService;
import com.px.partybuild.util.JsonMapper;
import com.px.partybuild.util.RemoteHelper;
import com.px.partybuild.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private CfMessageMapper cfMessageMapper;

    @Autowired
    private CfMessageCQuery cfMessageCQuery;

    @Autowired
    private UserService userService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private RemoteHelper remoteHelper;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private CommonService commonService;


    @Override
    public PageInfo<HashMap<String, Object>> selectMessageList(String userId, String title, int state, int pageIndex, int pageSize) {
        List<CfDictionary> dic_messageType = dictionaryService.getDictionaryListByDicTypeKey("messageType");

        PageHelper.startPage(pageIndex, pageSize);
        List<HashMap<String, Object>> list = cfMessageCQuery.selectMessageList(userId, state, title);
        for (HashMap<String, Object> item : list) {
            if (item.get("MESSAGETYPE") != null) {
                item.put("MESSAGETYPENAME", dictionaryService.getDicByKey(Integer.parseInt(item.get("MESSAGETYPE").toString()), dic_messageType).getDicvalue());
            }
        }
        PageInfo result = new PageInfo(list);
        return result;
    }

    @Override
    public List<CfMessage> selectMessageList(String userId, String title, String day, Integer state) {
        CfMessageExample exp = new CfMessageExample();
        CfMessageExample.Criteria criteria1 = exp.or().andTouserEqualTo(userId);
        if (state != null) {
            criteria1.andStateEqualTo(state);
        }
        criteria1.andOperatestateNotEqualTo("D");

        if (title != null && title.length() > 0) {
            criteria1.andMsgtitleLike(title.trim());
        }
        if (day != null && day.length() > 0) {
            try {
                criteria1.andSendtimeBetween(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(day + " 00:01"), new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(day + " 23:59"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        exp.setOrderByClause("sendtime desc");
        List<CfMessage> roles = cfMessageMapper.selectByExample(exp);
        return roles;
    }

    /**
     * 发送信息
     * @param message 信息
     * @return row
     */
    @Override
    public int sendMessage(CfMessage message) {
        int result = 0;
        CfMessage model = cfMessageMapper.selectByPrimaryKey(message.getMessageid());
        message.setSyncstate("N");
        message.setOperatestate("A");
        message.setState(1);
        message.setSendtime(new Date());
        message.setOperatetime(new Date());
        if (model == null) {
            result = cfMessageMapper.insert(message);
        } else {
            result = cfMessageMapper.updateByPrimaryKey(message);
        }
        return result;
    }

    /**
     * 清除消息
     * @param messageId id
     * @return row
     */
    @Override
    public int clearMessage(String messageId) {
        CfMessage message = new CfMessage();
        message.setMessageid(messageId);
        message.setSyncstate("N");
        message.setOperatestate("M");
        message.setState(0);
        message.setOperatetime(new Date());
        return cfMessageMapper.updateByPrimaryKeySelective(message);
    }

    @Override
    public int iSendMessage(String title, String content, int messageType, String url, String businessId, String fromUser, String toUser) {
        CfMessage model = new CfMessage();
        model.setMessageid(UUID.randomUUID().toString());
        model.setMsgtitle(title);
        model.setMsgcontent(content);
        model.setUrl(url);
        model.setMessagetype(messageType);
        model.setBusinessid(businessId);
        model.setFromuser(fromUser);
        model.setTouser(toUser);
        model.setState(1);//未读
        model.setSendtime(new Date());

        model.setOperatestate("A");
        model.setOperatetime(new Date());
        model.setSyncstate("N");

        return cfMessageMapper.insert(model);
    }

    @Override
    public CfMessage getMessageByBusinessId(String businessId, String toUser, Integer messageType) {
        CfMessage message = new CfMessage();

        CfMessageExample exp = new CfMessageExample();
        CfMessageExample.Criteria cri = exp.or();
        cri.andBusinessidEqualTo(businessId);
        cri.andTouserEqualTo(toUser);
        cri.andMessagetypeEqualTo(messageType);
        cri.andOperatestateNotEqualTo("D");

        List<CfMessage> messageList = cfMessageMapper.selectByExample(exp);
        if (messageList.size() > 0) {
            message = messageList.get(0);
        }
        return message;
    }

    @Override
    public int deleteMessageById(String messageId) {
        CfMessage message = new CfMessage();
        message.setMessageid(messageId);

        message.setOperatestate("D");
        message.setOperatetime(new Date());
        message.setSyncstate("N");

        return cfMessageMapper.updateByPrimaryKeySelective(message);
    }

    @Override
    public int deleteMessageByBusinessId(String businessId, Integer messageType) {
        return cfMessageCQuery.DeleteMessageByBusinessId(businessId, messageType);
    }

    @Override
    public int clearMessageByBusinessId(String businessId, String userId, Integer messageType) {
        int count = 0;
        CfMessage message = getMessageByBusinessId(businessId, userId, messageType);
        if (message != null && !stringUtils.IsNullOrEmpty(message.getMessageid()) && message.getState() == 1) {
            count = clearMessage(message.getMessageid());
        }

        return count;
    }

    @Override
    public int syncRemoteMsg() {
        //1.查询未发送信息
        CfMessageExample exp = new CfMessageExample();
        exp.or().andServiceidIsNull();
        List<CfMessage> unSendMsgs = cfMessageMapper.selectByExample(exp);
        //2.发送短信
        unSendMsgs.forEach(msg -> {
            try {

                Map<String, Object> mapMsg = getRemoteMsgParams(msg);

                String appReqData = remoteHelper.postJson(JsonMapper.objectToJson(mapMsg), appConfig.appSaveCheckMessageUrl, "utf-8");

                if (org.apache.commons.lang3.StringUtils.isNotBlank(appReqData)) {
                    JsonNode reqJson = JsonMapper.GetJsonNode(appReqData);
                    if (reqJson.findPath("success").asBoolean()) {
                        msg.setServiceid(reqJson.findPath("data").asText());
                        msg.setServicestate(1);
                        msg.setServiceupdatatime(new Date());

                        cfMessageMapper.updateByPrimaryKey(msg);
                    }
                }

            } catch (Exception ex) {
                log.error("syncRemoteMsg，发送短信出错,信息ID：" + msg.getMessageid(), ex);
            }
        });

        //3.查找更新信息
        CfMessageExample exp1 = new CfMessageExample();
        exp1.or().andServicestateEqualTo(1).andStateEqualTo(0);
        List<CfMessage> readedMsgs = cfMessageMapper.selectByExample(exp1);

        //4.更新信息数据
        readedMsgs.forEach(msg -> {
            try {
                Map<String, Object> mapMsg = new HashMap<>();
                String fromMobile = userService.userIdToMobile(msg.getFromuser());
                String apikey = commonService.AppDesEncode(fromMobile + "_" + System.currentTimeMillis(), appConfig.appDesSecret, appConfig.appDesVi);
                mapMsg.put("id", msg.getServiceid());
                mapMsg.put("fromSys", appConfig.appFromSys);
                mapMsg.put("apikey", apikey);
                mapMsg.put("readStatus", 1);
                mapMsg.put("formUserInfo", fromMobile);

                String appReqData = remoteHelper.postJson(JsonMapper.objectToJson(mapMsg), appConfig.appUpdateCheckMessageUrl, "utf-8");
                if (org.apache.commons.lang3.StringUtils.isNotBlank(appReqData)) {
                    JsonNode reqJson = JsonMapper.GetJsonNode(appReqData);
                    if (reqJson.findPath("success").asBoolean()) {
                        msg.setServicestate(2);
                        msg.setServiceupdatatime(new Date());
                        cfMessageMapper.updateByPrimaryKey(msg);
                    }
                }
            } catch (Exception ex) {
                log.error("更新信息数据出错，id:" + msg.getMessageid(), ex);
            }
        });

        return unSendMsgs.size() + readedMsgs.size();
    }

    @Override
    @Async
    public void asyncRemoteMsg() {
        int rows = syncRemoteMsg();
        log.info("asyncRemoteMsg,RemoteMsg异步结果，row:" + rows);
    }

    protected Map<String, Object> getRemoteMsgParams(CfMessage cfMessage) {

        String fromUserMobile = userService.userIdToMobile(cfMessage.getFromuser());
        String toUserMobile = userService.userIdToMobile(cfMessage.getTouser());

        String apikey = commonService.AppDesEncode(fromUserMobile + "_" + System.currentTimeMillis(), appConfig.appDesSecret, appConfig.appDesVi);

        Map<String, Object> mapMsg = new HashMap<>();
        mapMsg.put("fromSys", appConfig.appFromSys);
        mapMsg.put("apikey", apikey);
        mapMsg.put("title", cfMessage.getMsgtitle());
        mapMsg.put("receiveTime", DateFormatUtils.format(cfMessage.getSendtime(), "yyyy-MM-dd HH:mm"));
        mapMsg.put("receiveUserInfo", toUserMobile);
        mapMsg.put("formUserInfo", fromUserMobile);

        return mapMsg;
    }

}
