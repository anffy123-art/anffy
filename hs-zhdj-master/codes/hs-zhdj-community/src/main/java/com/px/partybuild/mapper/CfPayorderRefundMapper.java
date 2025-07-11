package com.px.partybuild.mapper;

import com.px.partybuild.model.CfPayorderRefund;
import com.px.partybuild.model.CfPayorderRefundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfPayorderRefundMapper {
    long countByExample(CfPayorderRefundExample example);

    int deleteByExample(CfPayorderRefundExample example);

    int deleteByPrimaryKey(String refundId);

    int insert(CfPayorderRefund record);

    int insertSelective(CfPayorderRefund record);

    List<CfPayorderRefund> selectByExample(CfPayorderRefundExample example);

    CfPayorderRefund selectByPrimaryKey(String refundId);

    int updateByExampleSelective(@Param("record") CfPayorderRefund record, @Param("example") CfPayorderRefundExample example);

    int updateByExample(@Param("record") CfPayorderRefund record, @Param("example") CfPayorderRefundExample example);

    int updateByPrimaryKeySelective(CfPayorderRefund record);

    int updateByPrimaryKey(CfPayorderRefund record);
}