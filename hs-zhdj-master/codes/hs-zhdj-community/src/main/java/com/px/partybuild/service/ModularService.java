package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.ApModular;
import com.px.partybuild.model.ApRolemodular;
import com.px.partybuild.model.ApUserusemodular;

import java.util.HashMap;
import java.util.List;

public interface ModularService {

    /**
     * 根据角色id查询对应的模块
     * @param roleId
     * @return
     */
    List<HashMap<String, Object>> selectModularByRoleId(String roleId);

    PageInfo<HashMap<String, Object>> selectModularList(int pageIndex, int pageSize, String roleId, String modularname);

    HashMap<String, Object> selectModularByMid(String MID);

    int deleteModular(String MID);

    int deleteModularRole(String MODULARID,String ROLEID);

    int saveModular(ApModular apModular);

    int saveModularRole(ApRolemodular apRolemodular);

    /**
     * 获取用户的常用模块
     * @param roleId
     * @return
     */
    List<HashMap<String, Object>> getUseModularList(String userId,String roleId);

    /**
     * 设置用户常用模块
     * @param items
     * @return
     */
    int batchUserusemodular(List<ApUserusemodular> items, String userId,String roleId);

    List<HashMap<String,Object>> getButtonByRoleId(String roleId);
}
