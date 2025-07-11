package com.px.partybuild.mapper;

import com.px.partybuild.model.ApRolemodular;
import com.px.partybuild.model.ApRolemodularExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApRolemodularMapper {
    long countByExample(ApRolemodularExample example);

    int deleteByExample(ApRolemodularExample example);

    int deleteByPrimaryKey(String rmid);

    int insert(ApRolemodular record);

    int insertSelective(ApRolemodular record);

    List<ApRolemodular> selectByExample(ApRolemodularExample example);

    ApRolemodular selectByPrimaryKey(String rmid);

    int updateByExampleSelective(@Param("record") ApRolemodular record, @Param("example") ApRolemodularExample example);

    int updateByExample(@Param("record") ApRolemodular record, @Param("example") ApRolemodularExample example);

    int updateByPrimaryKeySelective(ApRolemodular record);

    int updateByPrimaryKey(ApRolemodular record);
}