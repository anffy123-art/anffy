package com.px.partybuild.mapper;

import com.px.partybuild.model.PeZzbmba;
import com.px.partybuild.model.PeZzbmbaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeZzbmbaMapper {
    long countByExample(PeZzbmbaExample example);

    int deleteByExample(PeZzbmbaExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeZzbmba record);

    int insertSelective(PeZzbmba record);

    List<PeZzbmba> selectByExample(PeZzbmbaExample example);

    PeZzbmba selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeZzbmba record, @Param("example") PeZzbmbaExample example);

    int updateByExample(@Param("record") PeZzbmba record, @Param("example") PeZzbmbaExample example);

    int updateByPrimaryKeySelective(PeZzbmba record);

    int updateByPrimaryKey(PeZzbmba record);
}