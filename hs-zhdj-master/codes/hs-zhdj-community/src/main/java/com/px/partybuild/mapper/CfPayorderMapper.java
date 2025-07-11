package com.px.partybuild.mapper;

import com.px.partybuild.model.CfPayorder;
import com.px.partybuild.model.CfPayorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfPayorderMapper {
    long countByExample(CfPayorderExample example);

    int deleteByExample(CfPayorderExample example);

    int deleteByPrimaryKey(String payOrderId);

    int insert(CfPayorder record);

    int insertSelective(CfPayorder record);

    List<CfPayorder> selectByExample(CfPayorderExample example);

    CfPayorder selectByPrimaryKey(String payOrderId);

    int updateByExampleSelective(@Param("record") CfPayorder record, @Param("example") CfPayorderExample example);

    int updateByExample(@Param("record") CfPayorder record, @Param("example") CfPayorderExample example);

    int updateByPrimaryKeySelective(CfPayorder record);

    int updateByPrimaryKey(CfPayorder record);
}