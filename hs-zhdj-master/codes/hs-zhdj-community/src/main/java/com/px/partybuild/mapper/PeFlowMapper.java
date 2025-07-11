package com.px.partybuild.mapper;

import com.px.partybuild.model.PeFlow;
import com.px.partybuild.model.PeFlowExample;
import com.px.partybuild.model.PeFlowWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeFlowMapper {
    long countByExample(PeFlowExample example);

    int deleteByExample(PeFlowExample example);

    int deleteByPrimaryKey(String flowid);

    int insert(PeFlowWithBLOBs record);

    int insertSelective(PeFlowWithBLOBs record);

    List<PeFlowWithBLOBs> selectByExampleWithBLOBs(PeFlowExample example);

    List<PeFlow> selectByExample(PeFlowExample example);

    PeFlowWithBLOBs selectByPrimaryKey(String flowid);

    int updateByExampleSelective(@Param("record") PeFlowWithBLOBs record, @Param("example") PeFlowExample example);

    int updateByExampleWithBLOBs(@Param("record") PeFlowWithBLOBs record, @Param("example") PeFlowExample example);

    int updateByExample(@Param("record") PeFlow record, @Param("example") PeFlowExample example);

    int updateByPrimaryKeySelective(PeFlowWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PeFlowWithBLOBs record);

    int updateByPrimaryKey(PeFlow record);
}