package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzzdJczzflnew;
import com.px.partybuild.model.ZzzdJczzflnewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzzdJczzflnewMapper {
    long countByExample(ZzzdJczzflnewExample example);

    int deleteByExample(ZzzdJczzflnewExample example);

    int deleteByPrimaryKey(String bm);

    int insert(ZzzdJczzflnew record);

    int insertSelective(ZzzdJczzflnew record);

    List<ZzzdJczzflnew> selectByExample(ZzzdJczzflnewExample example);

    ZzzdJczzflnew selectByPrimaryKey(String bm);

    int updateByExampleSelective(@Param("record") ZzzdJczzflnew record, @Param("example") ZzzdJczzflnewExample example);

    int updateByExample(@Param("record") ZzzdJczzflnew record, @Param("example") ZzzdJczzflnewExample example);

    int updateByPrimaryKeySelective(ZzzdJczzflnew record);

    int updateByPrimaryKey(ZzzdJczzflnew record);
}