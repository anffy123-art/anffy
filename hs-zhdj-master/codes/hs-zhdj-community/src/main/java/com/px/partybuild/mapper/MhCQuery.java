package com.px.partybuild.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Repository
public interface MhCQuery {
    List<Map<String, Object>> SelectFlOneMcList(@Param("flmc") String flmc);

    List<HashMap<String, Object>> selectLinkList(@Param("title") String title);

    List<HashMap<String, Object>> selectSubjectList();
}
