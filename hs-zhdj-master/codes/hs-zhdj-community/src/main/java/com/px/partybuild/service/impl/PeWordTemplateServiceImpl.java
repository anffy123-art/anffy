package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.PeFlowMapper;
import com.px.partybuild.mapper.PeWordtemplateCQuery;
import com.px.partybuild.mapper.PeWordtemplateMapper;
import com.px.partybuild.model.*;
import com.px.partybuild.service.PeWordTemplateService;
import com.px.partybuild.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("peWordTemplate")
public class PeWordTemplateServiceImpl implements PeWordTemplateService {

    @Autowired
    PeWordtemplateCQuery peWordtemplateCQuery;

    @Autowired
    PeWordtemplateMapper peWordtemplateMapper;

    @Autowired
    private UserService userService;

    @Autowired
    PeFlowMapper peFlowMapper;


    @Override
    public PageInfo<Map<String, Object>> findList(String title, String flowId, String pflowId, int pageIndex, int pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        List<Map<String, Object>> list = peWordtemplateCQuery.getList(title, flowId, pflowId);

        PageInfo<Map<String, Object>> plist = new PageInfo(list);

        return plist;
    }

    @Override
    public PeWordtemplate getWord(String id) {

        PeWordtemplate item = null;

        if (StringUtils.isNotBlank(id)) {
            item = peWordtemplateMapper.selectByPrimaryKey(id);
        }

        if (item == null) {

            item = new PeWordtemplate();
            item.setSort(1);
            item.setCreatetime(new Date());
            item.setUpdatetime(item.getCreatetime());
            CfUsers curUser = userService.getLoginUser();
            item.setCreateuserid(curUser.getUserid());
            item.setCreateusername(curUser.getUsername());
            item.setUpdateuserid(curUser.getUserid());
            item.setUpdateusername(curUser.getUsername());

        }


        return item;
    }

    @Override
    public PeWordtemplate getWordByFlowId(String flowId) {

        PeWordtemplate item = null;

        if (StringUtils.isNotBlank(flowId)) {
            PeWordtemplateExample exp = new PeWordtemplateExample();
            exp.or().andFlowidEqualTo(flowId);
            List<PeWordtemplate> items = peWordtemplateMapper.selectByExampleWithBLOBs(exp);
            if (items != null && items.size() > 0) {
                return items.get(0);
            }
        }
        item = new PeWordtemplate();
        item.setSort(1);
        item.setCreatetime(new Date());
        item.setUpdatetime(item.getCreatetime());
        CfUsers curUser = userService.getLoginUser();
        item.setCreateuserid(curUser.getUserid());
        item.setCreateusername(curUser.getUsername());
        item.setUpdateuserid(curUser.getUserid());
        item.setUpdateusername(curUser.getUsername());
        return item;
    }

    @Override
    public int saveWord(PeWordtemplate model) {

        int result = 0;

        model.setOperatetime(new Date());
        model.setSyncstate("Y");

        if (StringUtils.isBlank(model.getWordtemplateid())) {

            model.setWordtemplateid(UUID.randomUUID().toString());
            model.setOperatestate("A");

            peWordtemplateMapper.insert(model);

        } else {
            CfUsers curUser = userService.getLoginUser();

            model.setUpdatetime(new Date());
            model.setUpdateusername(curUser.getUsername());
            model.setUpdateuserid(curUser.getUserid());

            model.setOperatestate("M");

            result = peWordtemplateMapper.updateByPrimaryKeyWithBLOBs(model);
        }

        return result;
    }

    @Override
    public int deleteWord(String id) {

        int result = 0;

        PeWordtemplate item = new PeWordtemplate();

        item.setWordtemplateid(id);

        item.setOperatestate("D");
        item.setOperatetime(new Date());
        item.setSyncstate("Y");

        result = peWordtemplateMapper.updateByPrimaryKeySelective(item);

        return result;
    }

    @Override
    public List<PeFlow> getDicFlowParentList() {
        PeFlowExample exp = new PeFlowExample();

        exp.or().andParentidIsNull();

        List<PeFlow> list = peFlowMapper.selectByExample(exp);
        return list;
    }

    @Override
    public List<PeFlow> getDicFlowByParentId(String pFlowId) {
        PeFlowExample exp = new PeFlowExample();

        exp.or().andParentidEqualTo(pFlowId);

        List<PeFlow> list = peFlowMapper.selectByExample(exp);
        return list;
    }

    @Override
    public String getDicFlowParentId(String cFlowId) {

        String pid = "";
        if (StringUtils.isNotBlank(cFlowId)) {
            PeFlow it = peFlowMapper.selectByPrimaryKey(cFlowId);
            if (it != null) {
                pid = it.getParentid();
            }
        }

        return pid;
    }
}
