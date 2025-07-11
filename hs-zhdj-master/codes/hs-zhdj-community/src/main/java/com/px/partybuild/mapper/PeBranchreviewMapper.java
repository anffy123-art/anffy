package com.px.partybuild.mapper;

import com.px.partybuild.model.PeBranchreview;
import com.px.partybuild.model.PeBranchreviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeBranchreviewMapper {
    long countByExample(PeBranchreviewExample example);

    int deleteByExample(PeBranchreviewExample example);

    int deleteByPrimaryKey(String branchreviewid);

    int insert(PeBranchreview record);

    int insertSelective(PeBranchreview record);

    List<PeBranchreview> selectByExampleWithBLOBs(PeBranchreviewExample example);

    List<PeBranchreview> selectByExample(PeBranchreviewExample example);

    PeBranchreview selectByPrimaryKey(String branchreviewid);

    int updateByExampleSelective(@Param("record") PeBranchreview record, @Param("example") PeBranchreviewExample example);

    int updateByExampleWithBLOBs(@Param("record") PeBranchreview record, @Param("example") PeBranchreviewExample example);

    int updateByExample(@Param("record") PeBranchreview record, @Param("example") PeBranchreviewExample example);

    int updateByPrimaryKeySelective(PeBranchreview record);

    int updateByPrimaryKeyWithBLOBs(PeBranchreview record);

    int updateByPrimaryKey(PeBranchreview record);
}