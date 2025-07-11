package com.px.partybuild.mapper;

import com.px.partybuild.model.PeJoinapply;
import com.px.partybuild.model.PeJoinapplyExample;
import com.px.partybuild.model.PeJoinapplyWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeJoinapplyMapper {
    long countByExample(PeJoinapplyExample example);

    int deleteByExample(PeJoinapplyExample example);

    int deleteByPrimaryKey(String applyid);

    int insert(PeJoinapplyWithBLOBs record);

    int insertSelective(PeJoinapplyWithBLOBs record);

    List<PeJoinapplyWithBLOBs> selectByExampleWithBLOBs(PeJoinapplyExample example);

    List<PeJoinapply> selectByExample(PeJoinapplyExample example);

    PeJoinapplyWithBLOBs selectByPrimaryKey(String applyid);

    int updateByExampleSelective(@Param("record") PeJoinapplyWithBLOBs record, @Param("example") PeJoinapplyExample example);

    int updateByExampleWithBLOBs(@Param("record") PeJoinapplyWithBLOBs record, @Param("example") PeJoinapplyExample example);

    int updateByExample(@Param("record") PeJoinapply record, @Param("example") PeJoinapplyExample example);

    int updateByPrimaryKeySelective(PeJoinapplyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PeJoinapplyWithBLOBs record);

    int updateByPrimaryKey(PeJoinapply record);
}