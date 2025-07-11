package com.px.partybuild.mapper;

import com.px.partybuild.model.PeRecommend;
import com.px.partybuild.model.PeRecommendExample;
import com.px.partybuild.model.PeRecommendWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeRecommendMapper {
    long countByExample(PeRecommendExample example);

    int deleteByExample(PeRecommendExample example);

    int deleteByPrimaryKey(String recommendid);

    int insert(PeRecommendWithBLOBs record);

    int insertSelective(PeRecommendWithBLOBs record);

    List<PeRecommendWithBLOBs> selectByExampleWithBLOBs(PeRecommendExample example);

    List<PeRecommend> selectByExample(PeRecommendExample example);

    PeRecommendWithBLOBs selectByPrimaryKey(String recommendid);

    int updateByExampleSelective(@Param("record") PeRecommendWithBLOBs record, @Param("example") PeRecommendExample example);

    int updateByExampleWithBLOBs(@Param("record") PeRecommendWithBLOBs record, @Param("example") PeRecommendExample example);

    int updateByExample(@Param("record") PeRecommend record, @Param("example") PeRecommendExample example);

    int updateByPrimaryKeySelective(PeRecommendWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PeRecommendWithBLOBs record);

    int updateByPrimaryKey(PeRecommend record);
}