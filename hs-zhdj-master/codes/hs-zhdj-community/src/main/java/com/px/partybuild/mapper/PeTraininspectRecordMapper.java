package com.px.partybuild.mapper;

import com.px.partybuild.model.PeTraininspectRecord;
import com.px.partybuild.model.PeTraininspectRecordExample;
import com.px.partybuild.model.PeTraininspectRecordWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeTraininspectRecordMapper {
    long countByExample(PeTraininspectRecordExample example);

    int deleteByExample(PeTraininspectRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeTraininspectRecordWithBLOBs record);

    int insertSelective(PeTraininspectRecordWithBLOBs record);

    List<PeTraininspectRecordWithBLOBs> selectByExampleWithBLOBs(PeTraininspectRecordExample example);

    List<PeTraininspectRecord> selectByExample(PeTraininspectRecordExample example);

    PeTraininspectRecordWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeTraininspectRecordWithBLOBs record, @Param("example") PeTraininspectRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") PeTraininspectRecordWithBLOBs record, @Param("example") PeTraininspectRecordExample example);

    int updateByExample(@Param("record") PeTraininspectRecord record, @Param("example") PeTraininspectRecordExample example);

    int updateByPrimaryKeySelective(PeTraininspectRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PeTraininspectRecordWithBLOBs record);

    int updateByPrimaryKey(PeTraininspectRecord record);
}