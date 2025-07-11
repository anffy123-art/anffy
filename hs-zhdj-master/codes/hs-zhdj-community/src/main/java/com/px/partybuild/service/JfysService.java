package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.YsHdbz;
import com.px.partybuild.vo.YsJfysmxVo;

import java.util.List;
import java.util.Map;

public interface JfysService {
    int saveHdbz(YsHdbz model);

    PageInfo<Map<String, Object>> selectHdbzList(Integer nd, int pageIndex, int pageSize);

    PageInfo<Map<String, Object>> selectYsjybList(Integer nd, int pageIndex, int pageSize);

    int removeHdbz(String id);

    List<YsHdbz>  selectByExample(YsHdbz model);

    List<YsJfysmxVo> selectYsjybmxList(Integer nd);

    RequsetData<String> saveYsjybmx(Map<String, Object> reqMap);

    int deleteJfysb(String jfysbid);
}
