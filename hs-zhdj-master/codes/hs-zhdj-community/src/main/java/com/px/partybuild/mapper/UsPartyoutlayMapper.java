package com.px.partybuild.mapper;

import com.px.partybuild.model.UsPartyoutlay;
import com.px.partybuild.model.UsPartyoutlayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsPartyoutlayMapper {
    long countByExample(UsPartyoutlayExample example);

    int deleteByExample(UsPartyoutlayExample example);

    int deleteByPrimaryKey(String partyoutlayid);

    int insert(UsPartyoutlay record);

    int insertSelective(UsPartyoutlay record);

    List<UsPartyoutlay> selectByExample(UsPartyoutlayExample example);

    UsPartyoutlay selectByPrimaryKey(String partyoutlayid);

    int updateByExampleSelective(@Param("record") UsPartyoutlay record, @Param("example") UsPartyoutlayExample example);

    int updateByExample(@Param("record") UsPartyoutlay record, @Param("example") UsPartyoutlayExample example);

    int updateByPrimaryKeySelective(UsPartyoutlay record);

    int updateByPrimaryKey(UsPartyoutlay record);
}