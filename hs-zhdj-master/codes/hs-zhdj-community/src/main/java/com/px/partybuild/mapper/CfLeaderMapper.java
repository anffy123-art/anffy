package com.px.partybuild.mapper;

import com.px.partybuild.model.CfLeader;
import com.px.partybuild.model.CfLeaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfLeaderMapper {
    long countByExample(CfLeaderExample example);

    int deleteByExample(CfLeaderExample example);

    int deleteByPrimaryKey(String leaderguid);

    int insert(CfLeader record);

    int insertSelective(CfLeader record);

    List<CfLeader> selectByExample(CfLeaderExample example);

    CfLeader selectByPrimaryKey(String leaderguid);

    int updateByExampleSelective(@Param("record") CfLeader record, @Param("example") CfLeaderExample example);

    int updateByExample(@Param("record") CfLeader record, @Param("example") CfLeaderExample example);

    int updateByPrimaryKeySelective(CfLeader record);

    int updateByPrimaryKey(CfLeader record);
}