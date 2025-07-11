package com.px.partybuild.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PeWordtemplateCQuery {
    List<Map<String,Object>> getList(@Param("title")String title, @Param("flowid")String flowid,@Param("pflowid") String pflowid);
}
