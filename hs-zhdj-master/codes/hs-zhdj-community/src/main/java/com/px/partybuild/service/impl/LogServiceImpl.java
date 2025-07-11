package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.AppConfig;
import com.px.partybuild.mapper.CfLogCQuery;
import com.px.partybuild.mapper.CfLogMapper;
import com.px.partybuild.model.CfDictionary;
import com.px.partybuild.model.CfLog;
import com.px.partybuild.model.CfUsers;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.service.LogService;
import com.px.partybuild.service.UserService;
import com.px.partybuild.vo.LogVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author H
 * @date 2024-08
 */
@Service("logService")
public class LogServiceImpl implements LogService {

    private final Logger logger;

    public LogServiceImpl() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Autowired
    private CfLogMapper cfLogMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private CfLogCQuery cfLogCQuery;

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    AppConfig appConfig;

    @Override
    //@Async
    /**
     * log
     */
    public void log(String OPMODULE, String LOGTEXT,String logTitle) {
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String loginId = requestAttributes.getRequest().getAttribute("UserLoginId").toString();
            CfUsers user = userService.getUserByKey(loginId);
            String ip = getIpAddress(requestAttributes.getRequest());

            String Clientinfo=requestAttributes.getRequest().getHeader("User-Agent");

            CfLog cfLog = new CfLog();
            cfLog.setLogid(UUID.randomUUID().toString());
            cfLog.setOpmodule(OPMODULE);
            cfLog.setLogtext(LOGTEXT);
            cfLog.setLogtitle(logTitle);
            cfLog.setLogtime(new Date());
            cfLog.setRequestip(ip);
            cfLog.setUserid(user.getUserid());
            cfLog.setClientinfo(Clientinfo);
            if(StringUtils.isNotBlank(user.getUserid())) {
                cfLogMapper.insert(cfLog);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

    }

    @Override
    @Async
    public void asyncLog(String OPMODULE, String LOGTEXT, String userLid, String ip, String logTitle, String Clientinfo, Date beginTime, int isError) {
        try {
            CfLog cfLog = new CfLog();
            cfLog.setLogid(UUID.randomUUID().toString());
            cfLog.setOpmodule(OPMODULE);
            cfLog.setLogtext(LOGTEXT);
            cfLog.setLogtime(new Date());
            cfLog.setRequestip(ip);
            cfLog.setLogtitle(logTitle);
            cfLog.setIserror(isError);
            cfLog.setClientinfo(Clientinfo);
            Long between = cfLog.getLogtime().getTime() - beginTime.getTime();
            cfLog.setResponsetime(between.intValue());
            if ("true".equals(appConfig.canLog.toLowerCase())) {
                CfUsers user = userService.getUserByKey(userLid);
                if(StringUtils.isNotBlank(user.getUserid())) {
                    cfLog.setUserid(user.getUserid());
                    cfLogMapper.insert(cfLog);
                }

            }
            //DateUtils.get
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public PageInfo<HashMap<String, Object>> getLogList(int page, int rows, String beginTime, String endTime, String userName){
        PageHelper.startPage(page, rows);
        PageHelper.orderBy("LOGTIME DESC");
        List<LogVo> list =  cfLogCQuery.selectLogList(beginTime,endTime,userName);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址。
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串
     * @param request
     * @return
     */
    @Override
    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if("127.0.0.1".equals(ip)||"0:0:0:0:0:0:0:1".equals(ip)){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }
        return ip;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getLoginLogList(int page, int rows,String dzzdm,String userName, String beginTime, String endTime,Integer loginType){
        List<CfDictionary> dic_ztType=dictionaryService.getDictionaryListByDicTypeKey("loginType");

        String logClient="";

        if(loginType!=null){
            if(loginType==1){
                logClient="Web";
            }
            if(loginType==2){
                logClient="App";
            }
        }
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = cfLogCQuery.selectLoginLogList(dzzdm, userName, beginTime, endTime,logClient);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);

        for(HashMap<String, Object> it : result.getList()){

            if(it.get("CLIENTINFO")!=null &&it.get("CLIENTINFO").toString().equals("App")){

                CfDictionary dic=dictionaryService.getDicByKey(2,dic_ztType);
                it.put("LOGINTYPENAME",dic.getDicvalue());
            } else{
                CfDictionary dic=dictionaryService.getDicByKey(1,dic_ztType);
                it.put("LOGINTYPENAME",dic.getDicvalue());
            }

        }

        return result;
    }

    @Override
    public boolean SaveLog(CfLog log) {
        log.setLogid(UUID.randomUUID().toString());
        log.setLogtime(new Date());
        cfLogMapper.insert(log);
        return false;
    }


}
