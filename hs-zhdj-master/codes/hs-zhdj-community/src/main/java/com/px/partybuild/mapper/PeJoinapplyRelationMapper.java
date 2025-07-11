package com.px.partybuild.mapper;

import com.px.partybuild.model.PeJoinapplyRelation;
import com.px.partybuild.model.PeJoinapplyRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeJoinapplyRelationMapper {
    long countByExample(PeJoinapplyRelationExample example);

    int deleteByExample(PeJoinapplyRelationExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeJoinapplyRelation record);

    int insertSelective(PeJoinapplyRelation record);

    List<PeJoinapplyRelation> selectByExample(PeJoinapplyRelationExample example);

    PeJoinapplyRelation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeJoinapplyRelation record, @Param("example") PeJoinapplyRelationExample example);

    int updateByExample(@Param("record") PeJoinapplyRelation record, @Param("example") PeJoinapplyRelationExample example);

    int updateByPrimaryKeySelective(PeJoinapplyRelation record);

    int updateByPrimaryKey(PeJoinapplyRelation record);
}