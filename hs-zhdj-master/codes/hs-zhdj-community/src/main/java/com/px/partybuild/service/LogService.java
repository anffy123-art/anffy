package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.CfLog;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface LogService {
    /**
     * 日志
     * @param OPMODULE
     * @param LOGTEXT
     * @param logTitle
     */
    void log(String OPMODULE, String LOGTEXT,String logTitle);

    /**
     * 异步日志
     * @param OPMODULE
     * @param LOGTEXT
     * @param userLid
     * @param ip
     * @param logTitle
     * @param Clientinfo
     * @param beginTime
     * @param isError
     */
    void asyncLog(String OPMODULE, String LOGTEXT, String userLid, String ip, String logTitle, String Clientinfo, Date beginTime, int isError);

    /**
     * 日志列表
     * @param page
     * @param rows
     * @param beginTime
     * @param endTime
     * @param userName
     * @return
     */
    PageInfo<HashMap<String, Object>> getLogList(int page, int rows, String beginTime, String endTime, String userName);

    String getIpAddress(HttpServletRequest request);


    /**
     * 登录日志
     * @param page
     * @param rows
     * @param dzzdm
     * @param userName
     * @return
     */
    PageInfo<HashMap<String, Object>> getLoginLogList(int page, int rows,String dzzdm,String userName, String beginTime, String endTime,Integer loginType);

    boolean SaveLog(CfLog log);

}
