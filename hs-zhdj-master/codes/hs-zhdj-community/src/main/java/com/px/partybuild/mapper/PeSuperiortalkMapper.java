package com.px.partybuild.mapper;

import com.px.partybuild.model.PeSuperiortalk;
import com.px.partybuild.model.PeSuperiortalkExample;
import com.px.partybuild.model.PeSuperiortalkWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeSuperiortalkMapper {
    long countByExample(PeSuperiortalkExample example);

    int deleteByExample(PeSuperiortalkExample example);

    int deleteByPrimaryKey(String talkid);

    int insert(PeSuperiortalkWithBLOBs record);

    int insertSelective(PeSuperiortalkWithBLOBs record);

    List<PeSuperiortalkWithBLOBs> selectByExampleWithBLOBs(PeSuperiortalkExample example);

    List<PeSuperiortalk> selectByExample(PeSuperiortalkExample example);

    PeSuperiortalkWithBLOBs selectByPrimaryKey(String talkid);

    int updateByExampleSelective(@Param("record") PeSuperiortalkWithBLOBs record, @Param("example") PeSuperiortalkExample example);

    int updateByExampleWithBLOBs(@Param("record") PeSuperiortalkWithBLOBs record, @Param("example") PeSuperiortalkExample example);

    int updateByExample(@Param("record") PeSuperiortalk record, @Param("example") PeSuperiortalkExample example);

    int updateByPrimaryKeySelective(PeSuperiortalkWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PeSuperiortalkWithBLOBs record);

    int updateByPrimaryKey(PeSuperiortalk record);
}