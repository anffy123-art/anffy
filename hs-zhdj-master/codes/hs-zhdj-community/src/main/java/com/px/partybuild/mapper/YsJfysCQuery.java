package com.px.partybuild.mapper;

import com.px.partybuild.vo.YsJfysmxVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface YsJfysCQuery {

    List<Map<String,Object>> selectPartyAndUserTotal(@Param("gddwdm") String gddwdm);

    List<YsJfysmxVo> selectYsjybmxList(@Param("Jfysid") String Jfysid);

}
