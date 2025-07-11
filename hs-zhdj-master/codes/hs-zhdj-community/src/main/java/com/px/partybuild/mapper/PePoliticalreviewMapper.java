package com.px.partybuild.mapper;

import com.px.partybuild.model.PePoliticalreview;
import com.px.partybuild.model.PePoliticalreviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PePoliticalreviewMapper {
    long countByExample(PePoliticalreviewExample example);

    int deleteByExample(PePoliticalreviewExample example);

    int deleteByPrimaryKey(String politicalreviewid);

    int insert(PePoliticalreview record);

    int insertSelective(PePoliticalreview record);

    List<PePoliticalreview> selectByExample(PePoliticalreviewExample example);

    PePoliticalreview selectByPrimaryKey(String politicalreviewid);

    int updateByExampleSelective(@Param("record") PePoliticalreview record, @Param("example") PePoliticalreviewExample example);

    int updateByExample(@Param("record") PePoliticalreview record, @Param("example") PePoliticalreviewExample example);

    int updateByPrimaryKeySelective(PePoliticalreview record);

    int updateByPrimaryKey(PePoliticalreview record);
}