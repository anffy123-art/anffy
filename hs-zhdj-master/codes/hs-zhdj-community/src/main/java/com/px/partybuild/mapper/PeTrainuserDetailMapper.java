package com.px.partybuild.mapper;

import com.px.partybuild.model.PeTrainuserDetail;
import com.px.partybuild.model.PeTrainuserDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeTrainuserDetailMapper {
    long countByExample(PeTrainuserDetailExample example);

    int deleteByExample(PeTrainuserDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeTrainuserDetail record);

    int insertSelective(PeTrainuserDetail record);

    List<PeTrainuserDetail> selectByExampleWithBLOBs(PeTrainuserDetailExample example);

    List<PeTrainuserDetail> selectByExample(PeTrainuserDetailExample example);

    PeTrainuserDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeTrainuserDetail record, @Param("example") PeTrainuserDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") PeTrainuserDetail record, @Param("example") PeTrainuserDetailExample example);

    int updateByExample(@Param("record") PeTrainuserDetail record, @Param("example") PeTrainuserDetailExample example);

    int updateByPrimaryKeySelective(PeTrainuserDetail record);

    int updateByPrimaryKeyWithBLOBs(PeTrainuserDetail record);

    int updateByPrimaryKey(PeTrainuserDetail record);
}