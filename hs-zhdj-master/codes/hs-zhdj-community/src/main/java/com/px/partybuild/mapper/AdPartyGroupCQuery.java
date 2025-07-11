package com.px.partybuild.mapper;

import com.px.partybuild.vo.AdPartyGroupVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdPartyGroupCQuery {

    List<AdPartyGroupVo> selectList(@Param("parentId") String parentId);

    int deleteGroup(@Param("id") String id);
}
