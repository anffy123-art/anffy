package com.px.partybuild.mapper;

import com.px.partybuild.model.PeConfirmuser;
import com.px.partybuild.model.PeConfirmuserExample;
import com.px.partybuild.model.PeConfirmuserWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeConfirmuserMapper {
    long countByExample(PeConfirmuserExample example);

    int deleteByExample(PeConfirmuserExample example);

    int deleteByPrimaryKey(String confirmuserid);

    int insert(PeConfirmuserWithBLOBs record);

    int insertSelective(PeConfirmuserWithBLOBs record);

    List<PeConfirmuserWithBLOBs> selectByExampleWithBLOBs(PeConfirmuserExample example);

    List<PeConfirmuser> selectByExample(PeConfirmuserExample example);

    PeConfirmuserWithBLOBs selectByPrimaryKey(String confirmuserid);

    int updateByExampleSelective(@Param("record") PeConfirmuserWithBLOBs record, @Param("example") PeConfirmuserExample example);

    int updateByExampleWithBLOBs(@Param("record") PeConfirmuserWithBLOBs record, @Param("example") PeConfirmuserExample example);

    int updateByExample(@Param("record") PeConfirmuser record, @Param("example") PeConfirmuserExample example);

    int updateByPrimaryKeySelective(PeConfirmuserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PeConfirmuserWithBLOBs record);

    int updateByPrimaryKey(PeConfirmuser record);
}