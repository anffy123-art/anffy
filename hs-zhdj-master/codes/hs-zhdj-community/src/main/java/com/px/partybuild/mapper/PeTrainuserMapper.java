package com.px.partybuild.mapper;

import com.px.partybuild.model.PeTrainuser;
import com.px.partybuild.model.PeTrainuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeTrainuserMapper {
    long countByExample(PeTrainuserExample example);

    int deleteByExample(PeTrainuserExample example);

    int deleteByPrimaryKey(String trainuserid);

    int insert(PeTrainuser record);

    int insertSelective(PeTrainuser record);

    List<PeTrainuser> selectByExample(PeTrainuserExample example);

    PeTrainuser selectByPrimaryKey(String trainuserid);

    int updateByExampleSelective(@Param("record") PeTrainuser record, @Param("example") PeTrainuserExample example);

    int updateByExample(@Param("record") PeTrainuser record, @Param("example") PeTrainuserExample example);

    int updateByPrimaryKeySelective(PeTrainuser record);

    int updateByPrimaryKey(PeTrainuser record);
}