package com.px.partybuild.mapper;

import com.px.partybuild.model.DsjCzqk;
import com.px.partybuild.model.DsjCzqkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsjCzqkMapper {
    long countByExample(DsjCzqkExample example);

    int deleteByExample(DsjCzqkExample example);

    int deleteByPrimaryKey(String czqkbs);

    int insert(DsjCzqk record);

    int insertSelective(DsjCzqk record);

    List<DsjCzqk> selectByExample(DsjCzqkExample example);

    DsjCzqk selectByPrimaryKey(String czqkbs);

    int updateByExampleSelective(@Param("record") DsjCzqk record, @Param("example") DsjCzqkExample example);

    int updateByExample(@Param("record") DsjCzqk record, @Param("example") DsjCzqkExample example);

    int updateByPrimaryKeySelective(DsjCzqk record);

    int updateByPrimaryKey(DsjCzqk record);
}