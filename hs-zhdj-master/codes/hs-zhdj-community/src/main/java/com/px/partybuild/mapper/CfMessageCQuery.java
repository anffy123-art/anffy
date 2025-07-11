package com.px.partybuild.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface CfMessageCQuery {
    List<HashMap<String, Object>> selectMessageList(@Param("userId") String userId, @Param("state") Integer state, @Param("title") String title);

    int DeleteMessageByBusinessId(@Param("businessId") String businessId, @Param("messageType") Integer messageType);
}
