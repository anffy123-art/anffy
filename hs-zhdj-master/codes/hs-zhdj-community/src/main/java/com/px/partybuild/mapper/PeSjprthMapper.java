package com.px.partybuild.mapper;

import com.px.partybuild.model.PeSjprth;
import com.px.partybuild.model.PeSjprthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeSjprthMapper {
    long countByExample(PeSjprthExample example);

    int deleteByExample(PeSjprthExample example);

    int deleteByPrimaryKey(String sjprthid);

    int insert(PeSjprth record);

    int insertSelective(PeSjprth record);

    List<PeSjprth> selectByExample(PeSjprthExample example);

    PeSjprth selectByPrimaryKey(String sjprthid);

    int updateByExampleSelective(@Param("record") PeSjprth record, @Param("example") PeSjprthExample example);

    int updateByExample(@Param("record") PeSjprth record, @Param("example") PeSjprthExample example);

    int updateByPrimaryKeySelective(PeSjprth record);

    int updateByPrimaryKey(PeSjprth record);
}