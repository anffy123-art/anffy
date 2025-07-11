package com.px.partybuild.mapper;

import com.px.partybuild.model.DsjFzdyqk;
import com.px.partybuild.model.DsjFzdyqkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsjFzdyqkMapper {
    long countByExample(DsjFzdyqkExample example);

    int deleteByExample(DsjFzdyqkExample example);

    int deleteByPrimaryKey(String fzdyqkbs);

    int insert(DsjFzdyqk record);

    int insertSelective(DsjFzdyqk record);

    List<DsjFzdyqk> selectByExample(DsjFzdyqkExample example);

    DsjFzdyqk selectByPrimaryKey(String fzdyqkbs);

    int updateByExampleSelective(@Param("record") DsjFzdyqk record, @Param("example") DsjFzdyqkExample example);

    int updateByExample(@Param("record") DsjFzdyqk record, @Param("example") DsjFzdyqkExample example);

    int updateByPrimaryKeySelective(DsjFzdyqk record);

    int updateByPrimaryKey(DsjFzdyqk record);
}