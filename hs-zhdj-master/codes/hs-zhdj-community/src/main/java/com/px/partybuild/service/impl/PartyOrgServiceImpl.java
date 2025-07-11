package com.px.partybuild.service.impl;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.mapper.DjzzrsFzjgglMapper;
import com.px.partybuild.mapper.DjzzrsJgfzMapper;
import com.px.partybuild.model.DjzzrsFzjggl;
import com.px.partybuild.model.DjzzrsFzjgglExample;
import com.px.partybuild.model.DjzzrsJgfz;
import com.px.partybuild.model.DjzzrsJgfzExample;
import com.px.partybuild.service.PartyOrgService;
import com.px.partybuild.service.UserService;
import com.px.partybuild.util.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service("partyOrgService")
public class PartyOrgServiceImpl implements PartyOrgService {

    @Autowired
    private DjzzrsFzjgglMapper fzjgglMapper;

    @Autowired
    private DjzzrsJgfzMapper jgfzMapper;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    private UserService userService;

    @Override
    public int saveDjzzrsJgfz(DjzzrsJgfz model) {
        int result = 0;
        if (StringUtils.isBlank(model.getJgfzid())) {
            model.setJgfzid(UUID.randomUUID().toString());
            model.setCreateTime(new Date());
            model.setUpdateTime(new Date());
            model.setComeFrom("1");
            result = jgfzMapper.insert(model);
        } else {
            result = jgfzMapper.updateByPrimaryKeySelective(model);
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> selectPartyOrgTree() {
        DjzzrsJgfzExample exp = new DjzzrsJgfzExample();
        DjzzrsJgfzExample.Criteria criteria = exp.or();
        criteria.andFjgfzidIsNull();
        List<DjzzrsJgfz> list = jgfzMapper.selectByExample(exp);

        List<Map<String, Object>> parents = new ArrayList<>();
        for (DjzzrsJgfz it : list) {
            Map<String, Object> parent = mapUtils.objectToMap(it);
            selectChildPartyOrg(parent, it.getJgfzid());
            parents.add(parent);
        }
        return parents;
    }

    @Override
    public DjzzrsJgfz getDjzzrsJgfz(String id) {
        return jgfzMapper.selectByPrimaryKey(id);
    }

    public void selectChildPartyOrg(Map<String, Object> parent, String jgfzid) {
        DjzzrsJgfzExample exp = new DjzzrsJgfzExample();
        exp.or().andFjgfzidEqualTo(jgfzid);
        List<DjzzrsJgfz> list = jgfzMapper.selectByExample(exp);

        List<Map<String, Object>> childs = new ArrayList<>();
        for (DjzzrsJgfz it : list) {
            Map<String, Object> child = mapUtils.objectToMap(it);
            selectChildPartyOrg(child, it.getJgfzid());
            childs.add(child);
            parent.put("childs", childs);
        }
        parent.put("childCount", childs.size());
    }

    public void selectChilds(List<String> jgfzidList, String jgfzid) {
        DjzzrsJgfzExample exp = new DjzzrsJgfzExample();
        exp.or().andFjgfzidEqualTo(jgfzid);
        List<DjzzrsJgfz> list = jgfzMapper.selectByExample(exp);

        for (DjzzrsJgfz it : list) {
            Map<String, Object> child = mapUtils.objectToMap(it);
            selectChilds(jgfzidList, it.getJgfzid());
            jgfzidList.add(it.getJgfzid());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public RequsetData<String> saveFzjggl(Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int result = 0;
        String jgfzid = reqMap.get("jgfzid").toString();
        ArrayList<String> dzzdmArray = (ArrayList<String>) reqMap.get("dzzdmArray");
        List<String> dzzdmList = dzzdmArray.stream().distinct().collect(Collectors.toList());
        DjzzrsFzjgglExample exp = new DjzzrsFzjgglExample();
        DjzzrsFzjgglExample.Criteria criteria = exp.or();
        criteria.andJgfzidEqualTo(jgfzid);
        fzjgglMapper.deleteByExample(exp);

        for (String dzzdm : dzzdmList) {
            DjzzrsFzjggl model = new DjzzrsFzjggl();
            model.setGlid(UUID.randomUUID().toString());
            model.setDzzbm(dzzdm);
            model.setCreateTime(new Date());
            model.setUpdateTime(new Date());
            model.setCreatePerson(userService.getLoginUser().getUserid());
            model.setUpdatePerson(userService.getLoginUser().getUserid());
            model.setComeFrom("1");
            model.setFzzt("1");
            model.setJgfzid(jgfzid);
            fzjgglMapper.insert(model);
            result++;
        }
        if (result > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存成功");
        }
        return res;
    }

    @Override
    public List<String> selectFzjgglList(String jgfzid) {
        DjzzrsFzjgglExample exp = new DjzzrsFzjgglExample();
        DjzzrsFzjgglExample.Criteria criteria = exp.or();
        criteria.andJgfzidEqualTo(jgfzid);
        List<DjzzrsFzjggl> list = fzjgglMapper.selectByExample(exp);
        List<String> dzzdmList = new ArrayList<>();
        for (DjzzrsFzjggl it : list) {
            dzzdmList.add(it.getDzzbm());
        }
        return dzzdmList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public RequsetData<String> delete(String jgfzid) {
        RequsetData<String> res = new RequsetData<String>();
        List<String> jgfzidList = new ArrayList<>();
        jgfzidList.add(jgfzid);
        try {
            //获取子分组
            selectChilds(jgfzidList, jgfzid);
            //删除分组组织关联
            DjzzrsFzjgglExample exp = new DjzzrsFzjgglExample();
            DjzzrsFzjgglExample.Criteria criteria = exp.or();
            criteria.andJgfzidIn(jgfzidList);
            fzjgglMapper.deleteByExample(exp);

            //删除分组表
            DjzzrsJgfzExample exp2 = new DjzzrsJgfzExample();
            DjzzrsJgfzExample.Criteria criteria2 = exp2.or();
            criteria2.andJgfzidIn(jgfzidList);

            jgfzMapper.deleteByExample(exp2);

            res.setSuccess(true);
            res.setMsg("删除成功！");
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("删除出错," + ex.getMessage());
        }
        return res;
    }
}
