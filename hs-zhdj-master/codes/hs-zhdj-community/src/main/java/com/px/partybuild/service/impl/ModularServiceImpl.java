package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.ApModularCQuery;
import com.px.partybuild.mapper.ApModularMapper;
import com.px.partybuild.mapper.ApRolemodularMapper;
import com.px.partybuild.mapper.ApUserusemodularMapper;
import com.px.partybuild.model.*;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.service.ModularService;
import com.px.partybuild.util.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("ModularServiceImpl")
public class ModularServiceImpl implements ModularService {
    @Autowired
    private ApModularMapper apModularMapper;

    @Autowired
    private ApRolemodularMapper apRolemodularMapper;

    @Autowired
    private ApUserusemodularMapper apUserusemodularMapper;

    @Autowired
    private ApModularCQuery apModularCQuery;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public List<HashMap<String, Object>> selectModularByRoleId(String roleId) {

        List<HashMap<String, Object>> list = apModularCQuery.selectModularByRoleId(roleId);

        return list;
    }

    @Override
    public List<HashMap<String, Object>> getUseModularList(String userId, String roleId) {

        List<HashMap<String, Object>> userlist = apModularCQuery.selectUserUseModularList(userId, roleId);

        //查找用户设定的常用模块，如果没设置，则查找角色默认的常用
        if (userlist.size() == 0) {
            userlist = apModularCQuery.selectRoleUseModularList(roleId);
        }

        return userlist;
    }

    @Override
    public int batchUserusemodular(List<ApUserusemodular> items, String userId, String roleId) {

        items.forEach(x -> {
            x.setUumid(UUID.randomUUID().toString());
        });
        ApUserusemodularExample example = new ApUserusemodularExample();
        example.or().andUseridEqualTo(userId).andRoleidEqualTo(roleId);
        apUserusemodularMapper.deleteByExample(example);
        return apModularCQuery.batchUserusemodular(items);
    }

    @Override
    public PageInfo<HashMap<String, Object>> selectModularList(int pageIndex, int pageSize, String roleId, String modularname) {

        PageHelper.startPage(pageIndex, pageSize);
        List<HashMap<String, Object>> list = apModularCQuery.selectModularList(roleId, modularname,null);

        List<String> parentIds = list.stream().map(item -> item.get("MID").toString()).collect(Collectors.toList());
        List<HashMap<String, Object>> childList =  apModularCQuery.selectModularList(roleId, modularname,parentIds);

        list.forEach(item -> {
            item.put("childList", childList.stream().filter(child -> child.get("PARENTID").toString().equals(item.get("MID").toString())).collect(Collectors.toList()));
        });

        PageInfo<HashMap<String, Object>> pList = new PageInfo(list);

        return pList;
    }

    @Override
    public HashMap<String, Object> selectModularByMid(String MID) {
        return apModularCQuery.selectModularByMid(MID);
    }

    @Override
    public int deleteModular(String MID) {
        return apModularMapper.deleteByPrimaryKey(MID);
    }

    @Override
    public int saveModular(ApModular apModular) {
        if (apModular.getMid() == null || apModular.getMid() == "") {
            apModular.setMid(UUID.randomUUID().toString());
            return apModularMapper.insertSelective(apModular);
        } else {
            return apModularMapper.updateByPrimaryKeySelective(apModular);
        }
    }

    @Override
    public int deleteModularRole(String MODULARID, String ROLEID) {
        return apModularCQuery.deleteModularRole(MODULARID, ROLEID);
    }

    @Override
    public int saveModularRole(ApRolemodular apRolemodular) {
        if (apRolemodular.getRmid() == null || apRolemodular.getRmid() == "") {
            apRolemodular.setRmid(UUID.randomUUID().toString());
            apRolemodular.setOrderby(10);
            apRolemodular.setIscommonuse(0);
            return apRolemodularMapper.insertSelective(apRolemodular);
        } else {
            return apRolemodularMapper.updateByPrimaryKeySelective(apRolemodular);
        }

    }

    @Override
    public List<HashMap<String,Object>> getButtonByRoleId(String roleId){
        return  apModularCQuery.selectButtonByRoleId(roleId);
    }
}
