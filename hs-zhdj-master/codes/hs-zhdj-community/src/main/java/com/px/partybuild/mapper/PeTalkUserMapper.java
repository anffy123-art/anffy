package com.px.partybuild.mapper;

import com.px.partybuild.model.PeTalkUser;
import com.px.partybuild.model.PeTalkUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeTalkUserMapper {
    long countByExample(PeTalkUserExample example);

    int deleteByExample(PeTalkUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeTalkUser record);

    int insertSelective(PeTalkUser record);

    List<PeTalkUser> selectByExample(PeTalkUserExample example);

    PeTalkUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeTalkUser record, @Param("example") PeTalkUserExample example);

    int updateByExample(@Param("record") PeTalkUser record, @Param("example") PeTalkUserExample example);

    int updateByPrimaryKeySelective(PeTalkUser record);

    int updateByPrimaryKey(PeTalkUser record);
}