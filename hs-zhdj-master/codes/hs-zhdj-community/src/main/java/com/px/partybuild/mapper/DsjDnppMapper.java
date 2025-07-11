package com.px.partybuild.mapper;

import com.px.partybuild.model.DsjDnpp;
import com.px.partybuild.model.DsjDnppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsjDnppMapper {
    long countByExample(DsjDnppExample example);

    int deleteByExample(DsjDnppExample example);

    int deleteByPrimaryKey(String dnppbs);

    int insert(DsjDnpp record);

    int insertSelective(DsjDnpp record);

    List<DsjDnpp> selectByExample(DsjDnppExample example);

    DsjDnpp selectByPrimaryKey(String dnppbs);

    int updateByExampleSelective(@Param("record") DsjDnpp record, @Param("example") DsjDnppExample example);

    int updateByExample(@Param("record") DsjDnpp record, @Param("example") DsjDnppExample example);

    int updateByPrimaryKeySelective(DsjDnpp record);

    int updateByPrimaryKey(DsjDnpp record);
}