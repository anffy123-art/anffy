package com.px.partybuild.mapper;

import com.px.partybuild.model.DjPartyactivityroomgroup;
import com.px.partybuild.model.DjPartyactivityroomgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjPartyactivityroomgroupMapper {
    long countByExample(DjPartyactivityroomgroupExample example);

    int deleteByExample(DjPartyactivityroomgroupExample example);

    int deleteByPrimaryKey(String groupid);

    int insert(DjPartyactivityroomgroup record);

    int insertSelective(DjPartyactivityroomgroup record);

    List<DjPartyactivityroomgroup> selectByExample(DjPartyactivityroomgroupExample example);

    DjPartyactivityroomgroup selectByPrimaryKey(String groupid);

    int updateByExampleSelective(@Param("record") DjPartyactivityroomgroup record, @Param("example") DjPartyactivityroomgroupExample example);

    int updateByExample(@Param("record") DjPartyactivityroomgroup record, @Param("example") DjPartyactivityroomgroupExample example);

    int updateByPrimaryKeySelective(DjPartyactivityroomgroup record);

    int updateByPrimaryKey(DjPartyactivityroomgroup record);
}