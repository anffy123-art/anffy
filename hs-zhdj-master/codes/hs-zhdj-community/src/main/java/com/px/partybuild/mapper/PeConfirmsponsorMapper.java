package com.px.partybuild.mapper;

import com.px.partybuild.model.PeConfirmsponsor;
import com.px.partybuild.model.PeConfirmsponsorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeConfirmsponsorMapper {
    long countByExample(PeConfirmsponsorExample example);

    int deleteByExample(PeConfirmsponsorExample example);

    int deleteByPrimaryKey(String confirmsponsorid);

    int insert(PeConfirmsponsor record);

    int insertSelective(PeConfirmsponsor record);

    List<PeConfirmsponsor> selectByExample(PeConfirmsponsorExample example);

    PeConfirmsponsor selectByPrimaryKey(String confirmsponsorid);

    int updateByExampleSelective(@Param("record") PeConfirmsponsor record, @Param("example") PeConfirmsponsorExample example);

    int updateByExample(@Param("record") PeConfirmsponsor record, @Param("example") PeConfirmsponsorExample example);

    int updateByPrimaryKeySelective(PeConfirmsponsor record);

    int updateByPrimaryKey(PeConfirmsponsor record);
}