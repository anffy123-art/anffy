package com.px.partybuild.mapper;

import com.px.partybuild.model.CfMenuRoleExample;
import com.px.partybuild.model.CfMenuRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfMenuRoleMapper {
    long countByExample(CfMenuRoleExample example);

    int deleteByExample(CfMenuRoleExample example);

    int deleteByPrimaryKey(CfMenuRoleKey key);

    int insert(CfMenuRoleKey record);

    int insertSelective(CfMenuRoleKey record);

    List<CfMenuRoleKey> selectByExample(CfMenuRoleExample example);

    int updateByExampleSelective(@Param("record") CfMenuRoleKey record, @Param("example") CfMenuRoleExample example);

    int updateByExample(@Param("record") CfMenuRoleKey record, @Param("example") CfMenuRoleExample example);
}