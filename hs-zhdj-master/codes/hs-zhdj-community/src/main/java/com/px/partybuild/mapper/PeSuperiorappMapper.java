package com.px.partybuild.mapper;

import com.px.partybuild.model.PeSuperiorapp;
import com.px.partybuild.model.PeSuperiorappExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeSuperiorappMapper {
    long countByExample(PeSuperiorappExample example);

    int deleteByExample(PeSuperiorappExample example);

    int deleteByPrimaryKey(String talkid);

    int insert(PeSuperiorapp record);

    int insertSelective(PeSuperiorapp record);

    List<PeSuperiorapp> selectByExample(PeSuperiorappExample example);

    PeSuperiorapp selectByPrimaryKey(String talkid);

    int updateByExampleSelective(@Param("record") PeSuperiorapp record, @Param("example") PeSuperiorappExample example);

    int updateByExample(@Param("record") PeSuperiorapp record, @Param("example") PeSuperiorappExample example);

    int updateByPrimaryKeySelective(PeSuperiorapp record);

    int updateByPrimaryKey(PeSuperiorapp record);
}