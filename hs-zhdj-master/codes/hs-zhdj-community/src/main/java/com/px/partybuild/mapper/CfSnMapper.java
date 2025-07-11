package com.px.partybuild.mapper;

import com.px.partybuild.model.CfSn;
import com.px.partybuild.model.CfSnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfSnMapper {
    long countByExample(CfSnExample example);

    int deleteByExample(CfSnExample example);

    int deleteByPrimaryKey(String snid);

    int insert(CfSn record);

    int insertSelective(CfSn record);

    List<CfSn> selectByExample(CfSnExample example);

    CfSn selectByPrimaryKey(String snid);

    int updateByExampleSelective(@Param("record") CfSn record, @Param("example") CfSnExample example);

    int updateByExample(@Param("record") CfSn record, @Param("example") CfSnExample example);

    int updateByPrimaryKeySelective(CfSn record);

    int updateByPrimaryKey(CfSn record);
}