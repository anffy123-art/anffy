package com.px.partybuild.mapper;

import com.px.partybuild.model.PeRdxs;
import com.px.partybuild.model.PeRdxsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeRdxsMapper {
    long countByExample(PeRdxsExample example);

    int deleteByExample(PeRdxsExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeRdxs record);

    int insertSelective(PeRdxs record);

    List<PeRdxs> selectByExample(PeRdxsExample example);

    PeRdxs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeRdxs record, @Param("example") PeRdxsExample example);

    int updateByExample(@Param("record") PeRdxs record, @Param("example") PeRdxsExample example);

    int updateByPrimaryKeySelective(PeRdxs record);

    int updateByPrimaryKey(PeRdxs record);
}