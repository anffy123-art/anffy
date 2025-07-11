package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.CfPayorder;
import com.px.partybuild.vo.PayorderVo;
import com.px.partybuild.vo.RequestPayVo;

import java.util.List;

public interface PayOrderService {

    CfPayorder createOrder(RequestPayVo data, String userId) throws Exception;

    int updatePayResult(CfPayorder cfPayorder) throws Exception;

    PageInfo<PayorderVo> getPayorderList(int pageNum, int pageSize, Integer payState);

    CfPayorder getSuccessPayOrderByRefId(String refId);

    CfPayorder getPayorderByNo(String no);
}
