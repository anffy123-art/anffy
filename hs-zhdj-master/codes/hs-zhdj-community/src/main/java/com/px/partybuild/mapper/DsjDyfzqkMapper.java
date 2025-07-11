package com.px.partybuild.mapper;

import com.px.partybuild.model.DsjDyfzqk;
import com.px.partybuild.model.DsjDyfzqkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsjDyfzqkMapper {
    long countByExample(DsjDyfzqkExample example);

    int deleteByExample(DsjDyfzqkExample example);

    int deleteByPrimaryKey(String dyfzqkid);

    int insert(DsjDyfzqk record);

    int insertSelective(DsjDyfzqk record);

    List<DsjDyfzqk> selectByExample(DsjDyfzqkExample example);

    DsjDyfzqk selectByPrimaryKey(String dyfzqkid);

    int updateByExampleSelective(@Param("record") DsjDyfzqk record, @Param("example") DsjDyfzqkExample example);

    int updateByExample(@Param("record") DsjDyfzqk record, @Param("example") DsjDyfzqkExample example);

    int updateByPrimaryKeySelective(DsjDyfzqk record);

    int updateByPrimaryKey(DsjDyfzqk record);
}