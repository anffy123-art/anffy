package com.px.partybuild.service;

import com.px.partybuild.model.AdPartygroup;
import com.px.partybuild.vo.AdPartyGroupVo;

import java.util.List;

public interface AdPartyGroupService {

    List<AdPartyGroupVo> getList(String parentId);

    AdPartygroup get(String id);

    int save(AdPartygroup data, String userId, String userName);

    int delete(String id);

    List<AdPartyGroupVo> getTree(String parentid);
}
