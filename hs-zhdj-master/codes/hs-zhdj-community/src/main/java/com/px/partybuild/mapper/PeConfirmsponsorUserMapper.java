package com.px.partybuild.mapper;

import com.px.partybuild.model.PeConfirmsponsorUser;
import com.px.partybuild.model.PeConfirmsponsorUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeConfirmsponsorUserMapper {
    long countByExample(PeConfirmsponsorUserExample example);

    int deleteByExample(PeConfirmsponsorUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeConfirmsponsorUser record);

    int insertSelective(PeConfirmsponsorUser record);

    List<PeConfirmsponsorUser> selectByExample(PeConfirmsponsorUserExample example);

    PeConfirmsponsorUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeConfirmsponsorUser record, @Param("example") PeConfirmsponsorUserExample example);

    int updateByExample(@Param("record") PeConfirmsponsorUser record, @Param("example") PeConfirmsponsorUserExample example);

    int updateByPrimaryKeySelective(PeConfirmsponsorUser record);

    int updateByPrimaryKey(PeConfirmsponsorUser record);
}