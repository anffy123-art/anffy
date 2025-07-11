package com.px.partybuild.service.impl;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.mapper.PeFlowMapper;
import com.px.partybuild.model.*;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.service.FlowConfigService;
import com.px.partybuild.util.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("FlowConfigService")
public class FlowConfigServiceImpl implements FlowConfigService {

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private PeFlowMapper peFlowMapper;

    @Autowired
    private MapUtils mapUtils;

    @Override
    public  List<Map<String, Object>> getFlowList(String parentId){
        PeFlowExample exp = new PeFlowExample();
        PeFlowExample.Criteria criteria1 = exp.or();
        if (parentId != null) {
            criteria1.andParentidEqualTo(parentId);
        }else {
            criteria1.andParentidIsNull();
        }

        exp.setOrderByClause("sort");
        List<PeFlowWithBLOBs> flows = peFlowMapper.selectByExampleWithBLOBs(exp);
        List<Map<String, Object>> list = new ArrayList<>();
        for (PeFlowWithBLOBs it : flows) {
            Map<String, Object> map = mapUtils.objectToMap(it);
            exp = new PeFlowExample();
            criteria1 = exp.or();
            criteria1.andParentidEqualTo(it.getFlowid());
            exp.setOrderByClause("sort");
            List<PeFlowWithBLOBs>  nodes = peFlowMapper.selectByExampleWithBLOBs(exp);
            map.put("nodes",nodes) ;
            list.add(map);
        }
        return list;
    }
    @Override
    public PeFlowWithBLOBs getFlowByid(String id){
        return  peFlowMapper.selectByPrimaryKey(id);
    }

    @Override
    public  List<PeFlow> getSubFlowList(String parentId,Integer orderby){
        PeFlowExample exp = new PeFlowExample();
        PeFlowExample.Criteria criteria1 = exp.or();
        if (parentId != null) {
            criteria1.andParentidEqualTo(parentId);
        }
        criteria1.andParentidIsNotNull();
        if(orderby!=null) {
            criteria1.andSortLessThan(orderby);
        }
        exp.setOrderByClause("sort");
        List<PeFlow> flows = peFlowMapper.selectByExample(exp);

        return flows;
    }
    @Override
    public RequsetData<String> save(PeFlowWithBLOBs model) {
        int result = 0;
        PeFlowWithBLOBs flow = peFlowMapper.selectByPrimaryKey(model.getFlowid());
        if (flow == null) {
            model.setFlowid(UUID.randomUUID().toString());
            model.setCreatetime(new Date());
            model.setUpdatetime(new Date());
            result = peFlowMapper.insert(model);
        } else {
            flow.setSort(model.getSort());
            flow.setFlowname(model.getFlowname());
            flow.setWarnupflowid(model.getWarnupflowid());
            flow.setUrl(model.getUrl());
            flow.setGuidelines(model.getGuidelines());
            flow.setWarndays(model.getWarndays());
            flow.setAppguidelines(model.getAppguidelines());
            result = peFlowMapper.updateByPrimaryKeyWithBLOBs(flow);
        }
        RequsetData<String> res = new RequsetData<String>();
        if (result > 0) {
            res.setSuccess(true);
            res.setMsg("操作成功");
        } else {
            res.setSuccess(false);
            res.setMsg("操作失败");
        }
        return res;
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(String flowid) {
        peFlowMapper.deleteByPrimaryKey(flowid);

        return 1;
    }
}
