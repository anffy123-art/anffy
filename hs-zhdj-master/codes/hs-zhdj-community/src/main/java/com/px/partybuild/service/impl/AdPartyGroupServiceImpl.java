package com.px.partybuild.service.impl;

import com.px.partybuild.mapper.AdPartyGroupCQuery;
import com.px.partybuild.mapper.AdPartygroupMapper;
import com.px.partybuild.model.AdPartygroup;
import com.px.partybuild.model.AdPartygroupExample;
import com.px.partybuild.service.AdPartyGroupService;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.vo.AdPartyGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service("AdPartyGroupService")
public class AdPartyGroupServiceImpl implements AdPartyGroupService {

    @Autowired
    private AdPartygroupMapper adPartygroupMapper;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private AdPartyGroupCQuery adPartyGroupCQuery;

    @Override
    public List<AdPartyGroupVo> getList(String parentId) {
        List<AdPartyGroupVo> list = adPartyGroupCQuery.selectList(parentId);
        return list;
    }

    @Override
    public AdPartygroup get(String id) {
        return adPartygroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(AdPartygroup data, String userId, String userName) {
        int result = 0;
        AdPartygroup dbModel = get(data.getId());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getId()))) {
            data.setName(data.getName().trim());
            data.setId(getGroupNo(data.getParentid()));
            data.setCreatetime(new Date());
            data.setCreateuserid(userId);

            result = adPartygroupMapper.insert(data);
        } else {
            data.setName(data.getName().trim());
            data.setModifytime(new Date());
            data.setModifyuserid(userId);

            result = adPartygroupMapper.updateByPrimaryKey(data);
        }

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(String id) {
        return adPartyGroupCQuery.deleteGroup(id);
    }

    @Override
    public List<AdPartyGroupVo> getTree(String parentid) {
        List<AdPartyGroupVo> result = new ArrayList<>();

        List<AdPartyGroupVo> dataList = adPartyGroupCQuery.selectList(parentid);

        result = dataList.stream().filter(it -> it.getParentid() == null).collect(Collectors.toList());

        result.forEach(item -> {
            item.setFullids(item.getId());
            item.setChildList(getChildList(dataList, item));
        });

        return result;
    }

    public List<AdPartyGroupVo> getChildList(List<AdPartyGroupVo> dataList, AdPartyGroupVo parent) {
        List<AdPartyGroupVo> result = dataList.stream().filter(d -> parent.getId().equals(d.getParentid())).collect(Collectors.toList());
        result.forEach(item ->
        {
            item.setFullids(parent.getFullids() + "." + item.getId());
            item.setChildList(getChildList(dataList, item));
        });

        return result;
    }


    private String getGroupNo(String parentId) {
        String no = "";
        AdPartygroupExample exp = new AdPartygroupExample();
        AdPartygroupExample.Criteria cri = exp.or();
        if (stringUtils.IsNullOrEmpty(parentId)) {
            cri.andParentidIsNull();
            exp.setOrderByClause("ID");
            List<AdPartygroup> list = adPartygroupMapper.selectByExample(exp);
            if (list.size() > 0) {
                no = getNextUpEn(list.get(list.size() - 1).getId().substring(0, 1)) + String.format("%03d", list.size() + 1);
            } else {
                no = "A001";
            }
        } else {
            cri.andParentidEqualTo(parentId);
            exp.setOrderByClause("ID");
            List<AdPartygroup> list = adPartygroupMapper.selectByExample(exp);
            if (list.size() > 0) {
                AdPartygroup adPartygroup = list.get(list.size() - 1);
                no = parentId + String.format("%03d", Integer.parseInt(adPartygroup.getId().substring(adPartygroup.getId().length()-3,adPartygroup.getId().length())) + 1);
            } else {
                no = parentId + "001";
            }
        }

        return no;
    }

    public String getNextUpEn(String en) {
        char lastE = 'a';
        char st = en.toCharArray()[0];
        if (Character.isUpperCase(st)) {
            if (en.equals("Z")) {
                return "A";
            }
            if (en == null || en.equals("")) {
                return "A";
            }
            lastE = 'Z';
        } else {
            if (en.equals("z")) {
                return "a";
            }
            if (en == null || en.equals("")) {
                return "a";
            }
            lastE = 'z';
        }
        int lastEnglish = (int) lastE;
        char[] c = en.toCharArray();
        if (c.length > 1) {
            return null;
        } else {
            int now = (int) c[0];
            if (now >= lastEnglish)
                return null;
            char uppercase = (char) (now + 1);
            return String.valueOf(uppercase);
        }
    }

}
