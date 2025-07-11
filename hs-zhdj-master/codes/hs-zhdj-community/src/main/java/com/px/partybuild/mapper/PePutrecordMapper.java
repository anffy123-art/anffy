package com.px.partybuild.mapper;

import com.px.partybuild.model.PePutrecord;
import com.px.partybuild.model.PePutrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PePutrecordMapper {
    long countByExample(PePutrecordExample example);

    int deleteByExample(PePutrecordExample example);

    int deleteByPrimaryKey(String putrecordid);

    int insert(PePutrecord record);

    int insertSelective(PePutrecord record);

    List<PePutrecord> selectByExample(PePutrecordExample example);

    PePutrecord selectByPrimaryKey(String putrecordid);

    int updateByExampleSelective(@Param("record") PePutrecord record, @Param("example") PePutrecordExample example);

    int updateByExample(@Param("record") PePutrecord record, @Param("example") PePutrecordExample example);

    int updateByPrimaryKeySelective(PePutrecord record);

    int updateByPrimaryKey(PePutrecord record);
}