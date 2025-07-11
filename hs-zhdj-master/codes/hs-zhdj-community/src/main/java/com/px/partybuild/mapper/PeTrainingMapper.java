package com.px.partybuild.mapper;

import com.px.partybuild.model.PeTraining;
import com.px.partybuild.model.PeTrainingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeTrainingMapper {
    long countByExample(PeTrainingExample example);

    int deleteByExample(PeTrainingExample example);

    int deleteByPrimaryKey(String trainingid);

    int insert(PeTraining record);

    int insertSelective(PeTraining record);

    List<PeTraining> selectByExample(PeTrainingExample example);

    PeTraining selectByPrimaryKey(String trainingid);

    int updateByExampleSelective(@Param("record") PeTraining record, @Param("example") PeTrainingExample example);

    int updateByExample(@Param("record") PeTraining record, @Param("example") PeTrainingExample example);

    int updateByPrimaryKeySelective(PeTraining record);

    int updateByPrimaryKey(PeTraining record);
}