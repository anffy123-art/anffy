package com.px.partybuild.mapper;

import com.px.partybuild.model.PeSjdwsp;
import com.px.partybuild.model.PeSjdwspExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeSjdwspMapper {
    long countByExample(PeSjdwspExample example);

    int deleteByExample(PeSjdwspExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeSjdwsp record);

    int insertSelective(PeSjdwsp record);

    List<PeSjdwsp> selectByExample(PeSjdwspExample example);

    PeSjdwsp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeSjdwsp record, @Param("example") PeSjdwspExample example);

    int updateByExample(@Param("record") PeSjdwsp record, @Param("example") PeSjdwspExample example);

    int updateByPrimaryKeySelective(PeSjdwsp record);

    int updateByPrimaryKey(PeSjdwsp record);
}