package com.px.partybuild.mapper;

import com.px.partybuild.model.DjPartyactivityroom;
import com.px.partybuild.model.DjPartyactivityroomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjPartyactivityroomMapper {
    long countByExample(DjPartyactivityroomExample example);

    int deleteByExample(DjPartyactivityroomExample example);

    int deleteByPrimaryKey(String partyactivityroomid);

    int insert(DjPartyactivityroom record);

    int insertSelective(DjPartyactivityroom record);

    List<DjPartyactivityroom> selectByExample(DjPartyactivityroomExample example);

    DjPartyactivityroom selectByPrimaryKey(String partyactivityroomid);

    int updateByExampleSelective(@Param("record") DjPartyactivityroom record, @Param("example") DjPartyactivityroomExample example);

    int updateByExample(@Param("record") DjPartyactivityroom record, @Param("example") DjPartyactivityroomExample example);

    int updateByPrimaryKeySelective(DjPartyactivityroom record);

    int updateByPrimaryKey(DjPartyactivityroom record);
}