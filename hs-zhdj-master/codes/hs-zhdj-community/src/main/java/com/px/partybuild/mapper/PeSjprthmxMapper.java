package com.px.partybuild.mapper;

import com.px.partybuild.model.PeSjprthmx;
import com.px.partybuild.model.PeSjprthmxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeSjprthmxMapper {
    long countByExample(PeSjprthmxExample example);

    int deleteByExample(PeSjprthmxExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeSjprthmx record);

    int insertSelective(PeSjprthmx record);

    List<PeSjprthmx> selectByExample(PeSjprthmxExample example);

    PeSjprthmx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeSjprthmx record, @Param("example") PeSjprthmxExample example);

    int updateByExample(@Param("record") PeSjprthmx record, @Param("example") PeSjprthmxExample example);

    int updateByPrimaryKeySelective(PeSjprthmx record);

    int updateByPrimaryKey(PeSjprthmx record);
}