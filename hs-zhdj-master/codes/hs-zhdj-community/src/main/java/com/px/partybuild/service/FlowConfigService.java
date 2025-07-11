package com.px.partybuild.service;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.PeFlow;
import com.px.partybuild.model.PeFlowWithBLOBs;

import java.util.List;
import java.util.Map;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface FlowConfigService {

    /**
     * flow list
     * @param parentId
     * @return
     */
    List<Map<String, Object>> getFlowList(String parentId);

    /**
     *  get sub list
     * @param parentId
     * @param orderby
     * @return
     */
    List<PeFlow> getSubFlowList(String parentId,Integer orderby);

    /**
     * save
     * @param model
     * @return
     */
    RequsetData<String> save(PeFlowWithBLOBs model);

    /**
     * delete
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * getFlowByid
     * @param id
     * @return
     */
    PeFlowWithBLOBs getFlowByid(String id);
}
