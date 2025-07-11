package com.px.partybuild.mapper;

import com.px.partybuild.model.CfRoles;
import com.px.partybuild.model.CfRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfRolesMapper {
    long countByExample(CfRolesExample example);

    int deleteByExample(CfRolesExample example);

    int deleteByPrimaryKey(String roleid);

    int insert(CfRoles record);

    int insertSelective(CfRoles record);

    List<CfRoles> selectByExample(CfRolesExample example);

    CfRoles selectByPrimaryKey(String roleid);

    int updateByExampleSelective(@Param("record") CfRoles record, @Param("example") CfRolesExample example);

    int updateByExample(@Param("record") CfRoles record, @Param("example") CfRolesExample example);

    int updateByPrimaryKeySelective(CfRoles record);

    int updateByPrimaryKey(CfRoles record);
}