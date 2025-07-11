package com.px.partybuild.mapper;

import com.px.partybuild.model.DsjCgjq;
import com.px.partybuild.model.DsjCgjqExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsjCgjqMapper {
    long countByExample(DsjCgjqExample example);

    int deleteByExample(DsjCgjqExample example);

    int deleteByPrimaryKey(String cgjqbs);

    int insert(DsjCgjq record);

    int insertSelective(DsjCgjq record);

    List<DsjCgjq> selectByExample(DsjCgjqExample example);

    DsjCgjq selectByPrimaryKey(String cgjqbs);

    int updateByExampleSelective(@Param("record") DsjCgjq record, @Param("example") DsjCgjqExample example);

    int updateByExample(@Param("record") DsjCgjq record, @Param("example") DsjCgjqExample example);

    int updateByPrimaryKeySelective(DsjCgjq record);

    int updateByPrimaryKey(DsjCgjq record);
}