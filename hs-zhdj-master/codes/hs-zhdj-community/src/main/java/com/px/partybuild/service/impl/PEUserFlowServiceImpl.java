package com.px.partybuild.service.impl;

import com.px.partybuild.mapper.PeJoinuserFlowMapper;
import com.px.partybuild.model.PeJoinuserFlow;
import com.px.partybuild.model.PeJoinuserFlowExample;
import com.px.partybuild.service.PEUserFlowService;
import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 发展党员步骤
 *
 * @author H
 */
@Service("peUserFlowService")
public class PEUserFlowServiceImpl implements PEUserFlowService {

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private PeJoinuserFlowMapper peJoinuserFlowMapper;

    /**
     * @param joinUserId
     * @param flowId
     * @param accomplishtime
     * @Description: 每个环节内容填写完成需记录
     * @return: void
     * @Date: 2020/1/9
     */
    @Override
    public int addUserFlow(String joinUserId, String flowId, Date accomplishtime, String userId, String userName) {
        int result=0;

        //环节记录
        PeJoinuserFlow dbFlow = getPeJoinuserFlowByUserId(joinUserId, flowId);
        if (dbFlow == null || (dbFlow != null && stringUtils.IsNullOrEmpty(dbFlow.getId()))) {
            dbFlow = new PeJoinuserFlow();
            dbFlow.setId(UUID.randomUUID().toString());
            dbFlow.setAccomplishtime(accomplishtime);
            dbFlow.setJoinuserid(joinUserId);
            dbFlow.setFlowid(flowId);
            dbFlow.setCreatetime(new Date());
            dbFlow.setCreateuserid(userId);
            dbFlow.setCreateusername(userName);

            //同步数据
            dbFlow.setOperatestate("A");
            dbFlow.setOperatetime(new Date());
            dbFlow.setSyncstate("N");

            result= peJoinuserFlowMapper.insert(dbFlow);
        } else {
            dbFlow.setAccomplishtime(accomplishtime);
            dbFlow.setUpdatetime(new Date());
            dbFlow.setUpdateuserid(userId);
            dbFlow.setUpdateusername(userName);

            //同步数据
            dbFlow.setOperatestate("M");
            dbFlow.setOperatetime(new Date());
            dbFlow.setSyncstate("N");

            result= peJoinuserFlowMapper.updateByPrimaryKey(dbFlow);
        }

        return result;
    }


    @Override
    public int delUserFlow(String joinUserId, String flowId){
        PeJoinuserFlowExample exp = new PeJoinuserFlowExample();
        PeJoinuserFlowExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);
        cri.andFlowidEqualTo(flowId);

        return peJoinuserFlowMapper.deleteByExample(exp);
    }

    /**
     * @param joinUserId 申请人id
     * @param flowId     环节id
     * @Description: 查询环节进度信息
     * @return: com.px.partybuild.model.PeJoinuserFlow
     * @Date: 2020/1/8
     */
    public PeJoinuserFlow getPeJoinuserFlowByUserId(String joinUserId, String flowId) {
        PeJoinuserFlow model = new PeJoinuserFlow();

        PeJoinuserFlowExample exp = new PeJoinuserFlowExample();
        PeJoinuserFlowExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);
        cri.andFlowidEqualTo(flowId);

        List<PeJoinuserFlow> list = peJoinuserFlowMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }
}
