package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.CfPayorderCQuery;
import com.px.partybuild.mapper.CfPayorderMapper;
import com.px.partybuild.model.CfPayorder;
import com.px.partybuild.model.CfPayorderExample;
import com.px.partybuild.service.PayOrderService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.RandomStringUtil;
import com.px.partybuild.vo.PayorderVo;
import com.px.partybuild.vo.RequestPayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service("payOrderService")
public class PayOrderServiceImpl implements PayOrderService {
    @Autowired
    private CfPayorderMapper cfPayorderMapper;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private RandomStringUtil randomStringUtil;
    @Autowired
    private CfPayorderCQuery cfPayorderCQuery;

    public CfPayorder createOrder(RequestPayVo data, String userId) throws Exception {
        CfPayorderExample exp = new CfPayorderExample();
        CfPayorderExample.Criteria cri = exp.or();
        cri.andPayRelIdEqualTo(data.payRelId);

        List<CfPayorder> orderList = cfPayorderMapper.selectByExample(exp);
        if (orderList.stream().filter(it -> it.getPayState() !=null && it.getPayState().equals(2)).count() > 0)
            throw new Exception("该笔费用已有支付成功记录，请勿重复操作");

        CfPayorder cfPayorder = orderList.stream().filter(it -> (it.getPayState()==null || it.getPayState().equals(1))).findFirst().orElse(null);

        if (cfPayorder == null) {
            cfPayorder = new CfPayorder();
            cfPayorder.setPayOrderId(UUID.randomUUID().toString());
            cfPayorder.setPayRelId(data.payRelId);
            cfPayorder.setPayAmount(data.payAmount);
            cfPayorder.setTitle(data.title);
            cfPayorder.setPayNo("P" + dateUtils.dateToStrFormat(new Date(), "yyyyMMddHHmmss") + randomStringUtil.getRandomCode(5, 0) + UUID.randomUUID().toString().substring(0,8));
            cfPayorder.setPayState(1);
            cfPayorder.setCreateTime(new Date());
            cfPayorder.setCreateUserId(userId);
            cfPayorder.setModifyTime(new Date());
            cfPayorder.setModifyUserId(userId);
            cfPayorder.setTradeType(data.tradeType);
            cfPayorder.setOpenID(data.openId);

            cfPayorderMapper.insert(cfPayorder);
        } else {
            cfPayorder.setModifyTime(new Date());
            cfPayorder.setModifyUserId(userId);

            cfPayorderMapper.updateByPrimaryKey(cfPayorder);
        }

        return cfPayorder;
    }

    public int updatePayResult(CfPayorder cfPayorder) throws Exception {
        CfPayorder dbData = getPayorderByNo(cfPayorder.getPayNo());
        if (dbData == null)
            throw new Exception("订单不存在");
        if (cfPayorder.getPayState() != null)
            dbData.setPayState(cfPayorder.getPayState());
        dbData.setPayFallMessage(cfPayorder.getPayFallMessage());
        dbData.setPayTime(cfPayorder.getPayTime());
        dbData.setQueryTime(new Date());
        dbData.setTradeState(cfPayorder.getTradeState());

        return cfPayorderMapper.updateByPrimaryKey(dbData);
    }

    public CfPayorder getPayorderByNo(String no) {
        CfPayorderExample exp = new CfPayorderExample();
        CfPayorderExample.Criteria cri = exp.or();
        cri.andPayNoEqualTo(no);

        return cfPayorderMapper.selectByExample(exp).stream().findFirst().orElse(null);
    }

    public PageInfo<PayorderVo> getPayorderList(int pageIndex, int pageSize, Integer payState){
        PageHelper.startPage(pageIndex, pageSize);

        List<PayorderVo> list = cfPayorderCQuery.selectPayorderList(payState);

        PageInfo<PayorderVo> result = new PageInfo(list);

        return result;
    }

    @Override
    public CfPayorder getSuccessPayOrderByRefId(String refId){
        CfPayorderExample exp = new CfPayorderExample();
        CfPayorderExample.Criteria cri = exp.or();
        cri.andPayRelIdEqualTo(refId).andPayStateEqualTo(2);//查询支付成功数据

        return cfPayorderMapper.selectByExample(exp).stream().findFirst().orElse(null);
    }
}
