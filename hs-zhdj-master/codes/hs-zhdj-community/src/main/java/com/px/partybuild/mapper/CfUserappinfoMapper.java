package com.px.partybuild.mapper;

import com.px.partybuild.model.CfUserappinfo;
import com.px.partybuild.model.CfUserappinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfUserappinfoMapper {
    long countByExample(CfUserappinfoExample example);

    int deleteByExample(CfUserappinfoExample example);

    int deleteByPrimaryKey(String userappinfoid);

    int insert(CfUserappinfo record);

    int insertSelective(CfUserappinfo record);

    List<CfUserappinfo> selectByExample(CfUserappinfoExample example);

    CfUserappinfo selectByPrimaryKey(String userappinfoid);

    int updateByExampleSelective(@Param("record") CfUserappinfo record, @Param("example") CfUserappinfoExample example);

    int updateByExample(@Param("record") CfUserappinfo record, @Param("example") CfUserappinfoExample example);

    int updateByPrimaryKeySelective(CfUserappinfo record);

    int updateByPrimaryKey(CfUserappinfo record);
}