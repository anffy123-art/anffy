package com.px.partybuild.service;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.DjzzrsJgfz;

import java.util.List;
import java.util.Map;


public interface PartyOrgService {

    int saveDjzzrsJgfz(DjzzrsJgfz model);

    List<Map<String, Object>> selectPartyOrgTree();

    DjzzrsJgfz getDjzzrsJgfz(String id);

    RequsetData<String> saveFzjggl(Map<String, Object> reqMap);

    List<String> selectFzjgglList(String jgfzid);

    RequsetData<String> delete(String jgfzid);
}
