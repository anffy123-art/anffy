package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzDxzcy;
import com.px.partybuild.model.ZzDxzcyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzDxzcyMapper {
    long countByExample(ZzDxzcyExample example);

    int deleteByExample(ZzDxzcyExample example);

    int deleteByPrimaryKey(String dxzcybs);

    int insert(ZzDxzcy record);

    int insertSelective(ZzDxzcy record);

    List<ZzDxzcy> selectByExample(ZzDxzcyExample example);

    ZzDxzcy selectByPrimaryKey(String dxzcybs);

    int updateByExampleSelective(@Param("record") ZzDxzcy record, @Param("example") ZzDxzcyExample example);

    int updateByExample(@Param("record") ZzDxzcy record, @Param("example") ZzDxzcyExample example);

    int updateByPrimaryKeySelective(ZzDxzcy record);

    int updateByPrimaryKey(ZzDxzcy record);
}