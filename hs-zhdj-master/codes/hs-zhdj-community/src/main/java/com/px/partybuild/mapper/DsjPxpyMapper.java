package com.px.partybuild.mapper;

import com.px.partybuild.model.DsjPxpy;
import com.px.partybuild.model.DsjPxpyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsjPxpyMapper {
    long countByExample(DsjPxpyExample example);

    int deleteByExample(DsjPxpyExample example);

    int deleteByPrimaryKey(String pxpybs);

    int insert(DsjPxpy record);

    int insertSelective(DsjPxpy record);

    List<DsjPxpy> selectByExample(DsjPxpyExample example);

    DsjPxpy selectByPrimaryKey(String pxpybs);

    int updateByExampleSelective(@Param("record") DsjPxpy record, @Param("example") DsjPxpyExample example);

    int updateByExample(@Param("record") DsjPxpy record, @Param("example") DsjPxpyExample example);

    int updateByPrimaryKeySelective(DsjPxpy record);

    int updateByPrimaryKey(DsjPxpy record);
}