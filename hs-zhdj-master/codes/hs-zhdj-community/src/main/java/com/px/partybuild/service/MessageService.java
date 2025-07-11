package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.CfMessage;
import com.px.partybuild.model.CfUsers;
import com.px.partybuild.model.CfUsersinfo;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface MessageService {
    /**
     * 消息列表
     * @param userId
     * @param title
     * @param state
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<HashMap<String, Object>> selectMessageList(String userId, String title, int state, int pageIndex, int pageSize);

    /**
     * 查找
     * @param userId
     * @param title
     * @param day
     * @param state
     * @return
     */
    List<CfMessage> selectMessageList(String userId, String title, String day,Integer state);

    /**
     * send
     * @param message
     * @return
     */
    int sendMessage(CfMessage message);

    /**
     * get
     * @param messageId
     * @return
     */
    int clearMessage(String messageId);


    /**
     * 添加通知接口
     * @param title 通知标题
     * @param content 通知内容
     * @param messageType 通知类型（字典表配置）
     * @param url 通知地址
     * @param businessId 业务id
     * @param fromUser 推送人
     * @param toUser 接收人
     * @return
     * @date 2024-08
     */
    int iSendMessage(String title, String content, int messageType, String url, String businessId, String fromUser, String toUser);


    /**
     * 获取通知信息
     * @date 2024-08
     * @param businessId
     * @param toUser
     * @param messageType
     * @return
     */
    CfMessage getMessageByBusinessId(String businessId, String toUser, Integer messageType);


    /**
     * 删除通知
     * @date 2024-08
     * @param messageId
     * @return
     */
    int deleteMessageById(String messageId);

    /**
     * 通过业务id和消息类型删除通知
     * @date 2024-08
     * @param businessId
     * @param messageType
     * @return
     */
    int deleteMessageByBusinessId(String businessId, Integer messageType);

    /**
     * clear
     * @param businessId
     * @param userId
     * @param messageType
     * @return
     */
    int clearMessageByBusinessId(String businessId, String userId, Integer messageType);

    /**
     * syncRemoteMsg
     * @return
     */
    int syncRemoteMsg();

    /**
     * async msg
     */
    void asyncRemoteMsg();
}
