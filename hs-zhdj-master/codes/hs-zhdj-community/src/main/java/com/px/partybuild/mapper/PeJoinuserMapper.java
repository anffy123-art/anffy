package com.px.partybuild.mapper;

import com.px.partybuild.model.PeJoinuser;
import com.px.partybuild.model.PeJoinuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeJoinuserMapper {
    long countByExample(PeJoinuserExample example);

    int deleteByExample(PeJoinuserExample example);

    int deleteByPrimaryKey(String joinuserid);

    int insert(PeJoinuser record);

    int insertSelective(PeJoinuser record);

    List<PeJoinuser> selectByExample(PeJoinuserExample example);

    PeJoinuser selectByPrimaryKey(String joinuserid);

    int updateByExampleSelective(@Param("record") PeJoinuser record, @Param("example") PeJoinuserExample example);

    int updateByExample(@Param("record") PeJoinuser record, @Param("example") PeJoinuserExample example);

    int updateByPrimaryKeySelective(PeJoinuser record);

    int updateByPrimaryKey(PeJoinuser record);
}