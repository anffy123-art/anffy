package com.px.partybuild.mapper;

import com.px.partybuild.model.UsUsercontactpoint;
import com.px.partybuild.model.UsUsercontactpointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsUsercontactpointMapper {
    long countByExample(UsUsercontactpointExample example);

    int deleteByExample(UsUsercontactpointExample example);

    int deleteByPrimaryKey(String id);

    int insert(UsUsercontactpoint record);

    int insertSelective(UsUsercontactpoint record);

    List<UsUsercontactpoint> selectByExample(UsUsercontactpointExample example);

    UsUsercontactpoint selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UsUsercontactpoint record, @Param("example") UsUsercontactpointExample example);

    int updateByExample(@Param("record") UsUsercontactpoint record, @Param("example") UsUsercontactpointExample example);

    int updateByPrimaryKeySelective(UsUsercontactpoint record);

    int updateByPrimaryKey(UsUsercontactpoint record);
}