package com.px.partybuild.mapper;

import com.px.partybuild.model.CfUsersinfo;
import com.px.partybuild.model.CfUsersinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface
CfUsersinfoMapper {
    long countByExample(CfUsersinfoExample example);

    int deleteByExample(CfUsersinfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfUsersinfo record);

    int insertSelective(CfUsersinfo record);

    List<CfUsersinfo> selectByExample(CfUsersinfoExample example);

    CfUsersinfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfUsersinfo record, @Param("example") CfUsersinfoExample example);

    int updateByExample(@Param("record") CfUsersinfo record, @Param("example") CfUsersinfoExample example);

    int updateByPrimaryKeySelective(CfUsersinfo record);

    int updateByPrimaryKey(CfUsersinfo record);
}