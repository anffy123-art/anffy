package com.px.partybuild.mapper;

import com.px.partybuild.model.PeTalk;
import com.px.partybuild.model.PeTalkExample;
import com.px.partybuild.model.PeTalkWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeTalkMapper {
    long countByExample(PeTalkExample example);

    int deleteByExample(PeTalkExample example);

    int deleteByPrimaryKey(String talkid);

    int insert(PeTalkWithBLOBs record);

    int insertSelective(PeTalkWithBLOBs record);

    List<PeTalkWithBLOBs> selectByExampleWithBLOBs(PeTalkExample example);

    List<PeTalk> selectByExample(PeTalkExample example);

    PeTalkWithBLOBs selectByPrimaryKey(String talkid);

    int updateByExampleSelective(@Param("record") PeTalkWithBLOBs record, @Param("example") PeTalkExample example);

    int updateByExampleWithBLOBs(@Param("record") PeTalkWithBLOBs record, @Param("example") PeTalkExample example);

    int updateByExample(@Param("record") PeTalk record, @Param("example") PeTalkExample example);

    int updateByPrimaryKeySelective(PeTalkWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PeTalkWithBLOBs record);

    int updateByPrimaryKey(PeTalk record);
}