package com.px.partybuild.mapper;

import com.px.partybuild.model.PeJoinapplyResume;
import com.px.partybuild.model.PeJoinapplyResumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeJoinapplyResumeMapper {
    long countByExample(PeJoinapplyResumeExample example);

    int deleteByExample(PeJoinapplyResumeExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeJoinapplyResume record);

    int insertSelective(PeJoinapplyResume record);

    List<PeJoinapplyResume> selectByExample(PeJoinapplyResumeExample example);

    PeJoinapplyResume selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeJoinapplyResume record, @Param("example") PeJoinapplyResumeExample example);

    int updateByExample(@Param("record") PeJoinapplyResume record, @Param("example") PeJoinapplyResumeExample example);

    int updateByPrimaryKeySelective(PeJoinapplyResume record);

    int updateByPrimaryKey(PeJoinapplyResume record);
}