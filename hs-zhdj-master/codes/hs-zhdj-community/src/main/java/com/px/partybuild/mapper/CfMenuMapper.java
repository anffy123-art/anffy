package com.px.partybuild.mapper;

import com.px.partybuild.model.CfMenu;
import com.px.partybuild.model.CfMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfMenuMapper {
    long countByExample(CfMenuExample example);

    int deleteByExample(CfMenuExample example);

    int deleteByPrimaryKey(String menuid);

    int insert(CfMenu record);

    int insertSelective(CfMenu record);

    List<CfMenu> selectByExample(CfMenuExample example);

    CfMenu selectByPrimaryKey(String menuid);

    int updateByExampleSelective(@Param("record") CfMenu record, @Param("example") CfMenuExample example);

    int updateByExample(@Param("record") CfMenu record, @Param("example") CfMenuExample example);

    int updateByPrimaryKeySelective(CfMenu record);

    int updateByPrimaryKey(CfMenu record);
}