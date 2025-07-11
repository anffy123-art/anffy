package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzzdJczzfl;
import com.px.partybuild.model.ZzzdJczzflExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzzdJczzflMapper {
    long countByExample(ZzzdJczzflExample example);

    int deleteByExample(ZzzdJczzflExample example);

    int insert(ZzzdJczzfl record);

    int insertSelective(ZzzdJczzfl record);

    List<ZzzdJczzfl> selectByExample(ZzzdJczzflExample example);

    int updateByExampleSelective(@Param("record") ZzzdJczzfl record, @Param("example") ZzzdJczzflExample example);

    int updateByExample(@Param("record") ZzzdJczzfl record, @Param("example") ZzzdJczzflExample example);
}