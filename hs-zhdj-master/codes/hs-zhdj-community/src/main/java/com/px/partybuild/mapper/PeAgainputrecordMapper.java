package com.px.partybuild.mapper;

import com.px.partybuild.model.PeAgainputrecord;
import com.px.partybuild.model.PeAgainputrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeAgainputrecordMapper {
    long countByExample(PeAgainputrecordExample example);

    int deleteByExample(PeAgainputrecordExample example);

    int deleteByPrimaryKey(String againputrecordid);

    int insert(PeAgainputrecord record);

    int insertSelective(PeAgainputrecord record);

    List<PeAgainputrecord> selectByExampleWithBLOBs(PeAgainputrecordExample example);

    List<PeAgainputrecord> selectByExample(PeAgainputrecordExample example);

    PeAgainputrecord selectByPrimaryKey(String againputrecordid);

    int updateByExampleSelective(@Param("record") PeAgainputrecord record, @Param("example") PeAgainputrecordExample example);

    int updateByExampleWithBLOBs(@Param("record") PeAgainputrecord record, @Param("example") PeAgainputrecordExample example);

    int updateByExample(@Param("record") PeAgainputrecord record, @Param("example") PeAgainputrecordExample example);

    int updateByPrimaryKeySelective(PeAgainputrecord record);

    int updateByPrimaryKeyWithBLOBs(PeAgainputrecord record);

    int updateByPrimaryKey(PeAgainputrecord record);
}