package com.px.partybuild.mapper;

import com.px.partybuild.vo.LogVo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface CfLogCQuery {

    List<LogVo> selectLogList(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("userName") String userName);


    /**
     * 登录日志查询
     * @param dzzdm
     * @param userName
     * @return
     */
    List<HashMap<String,Object>> selectLoginLogList(@Param("dzzdm") String dzzdm, @Param("userName") String userName,@Param("beginTime") String beginTime, @Param("endTime") String endTime,@Param("logClient") String logClient);

}
