package com.px.partybuild.service;

import com.px.partybuild.model.MhLink;
import com.px.partybuild.model.MhMhfl;
import com.px.partybuild.model.MhSylm;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MhService {

    List<Map<String, Object>> SelectFlOneMcList(String flmc);

    List<Map<String, Object>> SelectFlChildList(String sjfl);

    int SaveMHFL(MhMhfl model);

    String RemoveMHFL(String id);

    PageInfo<Map<String, Object>> SelectSylmList(String lmbt, int zt, int pageIndex, int pageSize);

    int SaveSylm(MhSylm model);

    int RemoveSylm(String id);

    PageInfo<MhMhfl> SelectMhfLParent(String flmc, int pageIndex, int pageSize);


    PageInfo<HashMap<String, Object>> getLinkList(int pageIndex, int pageSize, String title);

    MhLink getLinkById(String id);

    int saveLink(MhLink data, String userId);

    int deleteLink(String id);

    PageInfo<HashMap<String, Object>> getSubjectList(int pageIndex, int pageSize);
}
