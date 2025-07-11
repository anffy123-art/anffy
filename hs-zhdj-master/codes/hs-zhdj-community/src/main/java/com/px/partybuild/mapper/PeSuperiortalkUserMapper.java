package com.px.partybuild.mapper;

import com.px.partybuild.model.PeSuperiortalkUser;
import com.px.partybuild.model.PeSuperiortalkUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeSuperiortalkUserMapper {
    long countByExample(PeSuperiortalkUserExample example);

    int deleteByExample(PeSuperiortalkUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeSuperiortalkUser record);

    int insertSelective(PeSuperiortalkUser record);

    List<PeSuperiortalkUser> selectByExample(PeSuperiortalkUserExample example);

    PeSuperiortalkUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeSuperiortalkUser record, @Param("example") PeSuperiortalkUserExample example);

    int updateByExample(@Param("record") PeSuperiortalkUser record, @Param("example") PeSuperiortalkUserExample example);

    int updateByPrimaryKeySelective(PeSuperiortalkUser record);

    int updateByPrimaryKey(PeSuperiortalkUser record);
}