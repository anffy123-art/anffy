package com.px.partybuild.mapper;

import com.px.partybuild.model.PeZbdhtl;
import com.px.partybuild.model.PeZbdhtlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeZbdhtlMapper {
    long countByExample(PeZbdhtlExample example);

    int deleteByExample(PeZbdhtlExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeZbdhtl record);

    int insertSelective(PeZbdhtl record);

    List<PeZbdhtl> selectByExample(PeZbdhtlExample example);

    PeZbdhtl selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeZbdhtl record, @Param("example") PeZbdhtlExample example);

    int updateByExample(@Param("record") PeZbdhtl record, @Param("example") PeZbdhtlExample example);

    int updateByPrimaryKeySelective(PeZbdhtl record);

    int updateByPrimaryKey(PeZbdhtl record);
}