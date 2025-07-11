package com.px.partybuild.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface CFLeaderAdminCQuery {

    List<HashMap<String,Object>> selectLeaderadminList(@Param("xm") String xm);

}
