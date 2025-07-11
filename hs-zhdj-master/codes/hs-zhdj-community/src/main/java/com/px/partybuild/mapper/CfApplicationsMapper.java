package com.px.partybuild.mapper;

import com.px.partybuild.model.CfApplications;
import com.px.partybuild.model.CfApplicationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfApplicationsMapper {
    long countByExample(CfApplicationsExample example);

    int deleteByExample(CfApplicationsExample example);

    int deleteByPrimaryKey(String applicationid);

    int insert(CfApplications record);

    int insertSelective(CfApplications record);

    List<CfApplications> selectByExample(CfApplicationsExample example);

    CfApplications selectByPrimaryKey(String applicationid);

    int updateByExampleSelective(@Param("record") CfApplications record, @Param("example") CfApplicationsExample example);

    int updateByExample(@Param("record") CfApplications record, @Param("example") CfApplicationsExample example);

    int updateByPrimaryKeySelective(CfApplications record);

    int updateByPrimaryKey(CfApplications record);
}