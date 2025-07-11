package com.px.partybuild.mapper;

import com.px.partybuild.model.PeTczzsq;
import com.px.partybuild.model.PeTczzsqExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeTczzsqMapper {
    long countByExample(PeTczzsqExample example);

    int deleteByExample(PeTczzsqExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeTczzsq record);

    int insertSelective(PeTczzsq record);

    List<PeTczzsq> selectByExampleWithBLOBs(PeTczzsqExample example);

    List<PeTczzsq> selectByExample(PeTczzsqExample example);

    PeTczzsq selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeTczzsq record, @Param("example") PeTczzsqExample example);

    int updateByExampleWithBLOBs(@Param("record") PeTczzsq record, @Param("example") PeTczzsqExample example);

    int updateByExample(@Param("record") PeTczzsq record, @Param("example") PeTczzsqExample example);

    int updateByPrimaryKeySelective(PeTczzsq record);

    int updateByPrimaryKeyWithBLOBs(PeTczzsq record);

    int updateByPrimaryKey(PeTczzsq record);
}