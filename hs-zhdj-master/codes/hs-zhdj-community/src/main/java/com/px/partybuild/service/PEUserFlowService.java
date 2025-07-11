package com.px.partybuild.service;

import java.util.Date;

/**
 * 发展党员步骤
 *
 * @author H
 */
public interface PEUserFlowService  {

   /**
    * 添加进度操作记录
    * @param joinUserId
    * @param flowId
    * @param accomplishtime
    * @param userId
    * @param userName
    * @return
    */
   int addUserFlow(String joinUserId, String flowId, Date accomplishtime, String userId, String userName);

   /**
    * 删除进度操作记录
    * @param joinUserId
    * @param flowId
    * @return
    */
   int delUserFlow(String joinUserId, String flowId);

}
