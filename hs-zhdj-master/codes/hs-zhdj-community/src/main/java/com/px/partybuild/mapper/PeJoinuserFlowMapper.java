package com.px.partybuild.mapper;

import com.px.partybuild.model.PeJoinuserFlow;
import com.px.partybuild.model.PeJoinuserFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeJoinuserFlowMapper {
    long countByExample(PeJoinuserFlowExample example);

    int deleteByExample(PeJoinuserFlowExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeJoinuserFlow record);

    int insertSelective(PeJoinuserFlow record);

    List<PeJoinuserFlow> selectByExample(PeJoinuserFlowExample example);

    PeJoinuserFlow selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeJoinuserFlow record, @Param("example") PeJoinuserFlowExample example);

    int updateByExample(@Param("record") PeJoinuserFlow record, @Param("example") PeJoinuserFlowExample example);

    int updateByPrimaryKeySelective(PeJoinuserFlow record);

    int updateByPrimaryKey(PeJoinuserFlow record);
}