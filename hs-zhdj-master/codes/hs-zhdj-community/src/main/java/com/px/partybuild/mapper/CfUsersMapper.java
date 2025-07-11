package com.px.partybuild.mapper;

import com.px.partybuild.model.CfUsers;
import com.px.partybuild.model.CfUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfUsersMapper {
    long countByExample(CfUsersExample example);

    int deleteByExample(CfUsersExample example);

    int deleteByPrimaryKey(String userid);

    int insert(CfUsers record);

    int insertSelective(CfUsers record);

    List<CfUsers> selectByExample(CfUsersExample example);

    CfUsers selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") CfUsers record, @Param("example") CfUsersExample example);

    int updateByExample(@Param("record") CfUsers record, @Param("example") CfUsersExample example);

    int updateByPrimaryKeySelective(CfUsers record);

    int updateByPrimaryKey(CfUsers record);
}