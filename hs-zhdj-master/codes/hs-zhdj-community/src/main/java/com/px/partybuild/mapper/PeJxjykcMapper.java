package com.px.partybuild.mapper;

import com.px.partybuild.model.PeJxjykc;
import com.px.partybuild.model.PeJxjykcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeJxjykcMapper {
    long countByExample(PeJxjykcExample example);

    int deleteByExample(PeJxjykcExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeJxjykc record);

    int insertSelective(PeJxjykc record);

    List<PeJxjykc> selectByExample(PeJxjykcExample example);

    PeJxjykc selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeJxjykc record, @Param("example") PeJxjykcExample example);

    int updateByExample(@Param("record") PeJxjykc record, @Param("example") PeJxjykcExample example);

    int updateByPrimaryKeySelective(PeJxjykc record);

    int updateByPrimaryKey(PeJxjykc record);
}