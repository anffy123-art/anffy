package com.px.partybuild.mapper;

import com.px.partybuild.model.CfMessage;
import com.px.partybuild.model.CfMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfMessageMapper {
    long countByExample(CfMessageExample example);

    int deleteByExample(CfMessageExample example);

    int deleteByPrimaryKey(String messageid);

    int insert(CfMessage record);

    int insertSelective(CfMessage record);

    List<CfMessage> selectByExampleWithBLOBs(CfMessageExample example);

    List<CfMessage> selectByExample(CfMessageExample example);

    CfMessage selectByPrimaryKey(String messageid);

    int updateByExampleSelective(@Param("record") CfMessage record, @Param("example") CfMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") CfMessage record, @Param("example") CfMessageExample example);

    int updateByExample(@Param("record") CfMessage record, @Param("example") CfMessageExample example);

    int updateByPrimaryKeySelective(CfMessage record);

    int updateByPrimaryKeyWithBLOBs(CfMessage record);

    int updateByPrimaryKey(CfMessage record);
}