package com.px.partybuild.mapper;

import com.px.partybuild.model.PeTraininspect;
import com.px.partybuild.model.PeTraininspectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeTraininspectMapper {
    long countByExample(PeTraininspectExample example);

    int deleteByExample(PeTraininspectExample example);

    int deleteByPrimaryKey(String traininspectid);

    int insert(PeTraininspect record);

    int insertSelective(PeTraininspect record);

    List<PeTraininspect> selectByExample(PeTraininspectExample example);

    PeTraininspect selectByPrimaryKey(String traininspectid);

    int updateByExampleSelective(@Param("record") PeTraininspect record, @Param("example") PeTraininspectExample example);

    int updateByExample(@Param("record") PeTraininspect record, @Param("example") PeTraininspectExample example);

    int updateByPrimaryKeySelective(PeTraininspect record);

    int updateByPrimaryKey(PeTraininspect record);
}