package com.px.partybuild.mapper;

import com.px.partybuild.model.CfUserrolesExample;
import com.px.partybuild.model.CfUserrolesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfUserrolesMapper {
    long countByExample(CfUserrolesExample example);

    int deleteByExample(CfUserrolesExample example);

    int deleteByPrimaryKey(CfUserrolesKey key);

    int insert(CfUserrolesKey record);

    int insertSelective(CfUserrolesKey record);

    List<CfUserrolesKey> selectByExample(CfUserrolesExample example);

    int updateByExampleSelective(@Param("record") CfUserrolesKey record, @Param("example") CfUserrolesExample example);

    int updateByExample(@Param("record") CfUserrolesKey record, @Param("example") CfUserrolesExample example);
}