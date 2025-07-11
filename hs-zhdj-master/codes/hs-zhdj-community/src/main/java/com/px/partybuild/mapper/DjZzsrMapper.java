package com.px.partybuild.mapper;

import com.px.partybuild.model.DjZzsr;
import com.px.partybuild.model.DjZzsrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjZzsrMapper {
    long countByExample(DjZzsrExample example);

    int deleteByExample(DjZzsrExample example);

    int deleteByPrimaryKey(String id);

    int insert(DjZzsr record);

    int insertSelective(DjZzsr record);

    List<DjZzsr> selectByExampleWithBLOBs(DjZzsrExample example);

    List<DjZzsr> selectByExample(DjZzsrExample example);

    DjZzsr selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DjZzsr record, @Param("example") DjZzsrExample example);

    int updateByExampleWithBLOBs(@Param("record") DjZzsr record, @Param("example") DjZzsrExample example);

    int updateByExample(@Param("record") DjZzsr record, @Param("example") DjZzsrExample example);

    int updateByPrimaryKeySelective(DjZzsr record);

    int updateByPrimaryKeyWithBLOBs(DjZzsr record);

    int updateByPrimaryKey(DjZzsr record);
}