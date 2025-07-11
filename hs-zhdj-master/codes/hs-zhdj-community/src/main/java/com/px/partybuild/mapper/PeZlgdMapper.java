package com.px.partybuild.mapper;

import com.px.partybuild.model.PeZlgd;
import com.px.partybuild.model.PeZlgdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeZlgdMapper {
    long countByExample(PeZlgdExample example);

    int deleteByExample(PeZlgdExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeZlgd record);

    int insertSelective(PeZlgd record);

    List<PeZlgd> selectByExample(PeZlgdExample example);

    PeZlgd selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeZlgd record, @Param("example") PeZlgdExample example);

    int updateByExample(@Param("record") PeZlgd record, @Param("example") PeZlgdExample example);

    int updateByPrimaryKeySelective(PeZlgd record);

    int updateByPrimaryKey(PeZlgd record);
}