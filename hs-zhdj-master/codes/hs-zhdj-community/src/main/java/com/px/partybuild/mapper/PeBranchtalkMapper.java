package com.px.partybuild.mapper;

import com.px.partybuild.model.PeBranchtalk;
import com.px.partybuild.model.PeBranchtalkExample;
import com.px.partybuild.model.PeBranchtalkWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeBranchtalkMapper {
    long countByExample(PeBranchtalkExample example);

    int deleteByExample(PeBranchtalkExample example);

    int deleteByPrimaryKey(String branchtalkid);

    int insert(PeBranchtalkWithBLOBs record);

    int insertSelective(PeBranchtalkWithBLOBs record);

    List<PeBranchtalkWithBLOBs> selectByExampleWithBLOBs(PeBranchtalkExample example);

    List<PeBranchtalk> selectByExample(PeBranchtalkExample example);

    PeBranchtalkWithBLOBs selectByPrimaryKey(String branchtalkid);

    int updateByExampleSelective(@Param("record") PeBranchtalkWithBLOBs record, @Param("example") PeBranchtalkExample example);

    int updateByExampleWithBLOBs(@Param("record") PeBranchtalkWithBLOBs record, @Param("example") PeBranchtalkExample example);

    int updateByExample(@Param("record") PeBranchtalk record, @Param("example") PeBranchtalkExample example);

    int updateByPrimaryKeySelective(PeBranchtalkWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PeBranchtalkWithBLOBs record);

    int updateByPrimaryKey(PeBranchtalk record);
}