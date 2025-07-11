package com.px.partybuild.mapper;

import com.px.partybuild.model.CfLog;
import com.px.partybuild.model.CfLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfLogMapper {
    long countByExample(CfLogExample example);

    int deleteByExample(CfLogExample example);

    int deleteByPrimaryKey(String logid);

    int insert(CfLog record);

    int insertSelective(CfLog record);

    List<CfLog> selectByExampleWithBLOBs(CfLogExample example);

    List<CfLog> selectByExample(CfLogExample example);

    CfLog selectByPrimaryKey(String logid);

    int updateByExampleSelective(@Param("record") CfLog record, @Param("example") CfLogExample example);

    int updateByExampleWithBLOBs(@Param("record") CfLog record, @Param("example") CfLogExample example);

    int updateByExample(@Param("record") CfLog record, @Param("example") CfLogExample example);

    int updateByPrimaryKeySelective(CfLog record);

    int updateByPrimaryKeyWithBLOBs(CfLog record);

    int updateByPrimaryKey(CfLog record);
}