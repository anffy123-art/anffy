package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.PeFlow;
import com.px.partybuild.model.PeWordtemplate;

import java.util.List;
import java.util.Map;

public interface PeWordTemplateService {
    PageInfo<Map<String,Object>> findList(String title, String flowId,String pflowId,int pageIndex, int pageSize);
    PeWordtemplate getWord(String id);
    int saveWord(PeWordtemplate model);
    PeWordtemplate getWordByFlowId(String flowId);
    int deleteWord(String id);
    List<PeFlow> getDicFlowParentList();
    List<PeFlow> getDicFlowByParentId(String pFlowId);
    String getDicFlowParentId(String cFlowId);
}
