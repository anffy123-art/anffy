package com.px.partybuild.mapper;

import com.px.partybuild.model.ApUserusemodular;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ApModularCQuery {
    /**
     * 查询角色关联的模块
     * @return
     */
    List<HashMap<String, Object>> selectModularByRoleId(@Param("roleId") String roleId);
    /**
     * 查询用户设置的常用模块
     * @return
     */
    List<HashMap<String, Object>> selectUserUseModularList(@Param("userId") String userId,@Param("roleId") String roleId);
    /**
     * 查询角色默认的常用模块
     * @return
     */
    List<HashMap<String, Object>> selectRoleUseModularList(@Param("roleId") String roleId);

    List<HashMap<String, Object>> selectModularList(@Param("roleId") String roleId,@Param("modularname")String modularname,@Param("parentIdList") List<String> parentIdList);

    HashMap<String, Object> selectModularByMid(@Param("MID") String MID);

    int deleteModularRole(@Param("MODULARID") String MODULARID,@Param("ROLEID") String ROLEID);

   int batchUserusemodular(@Param("list") List<ApUserusemodular>  list);


   List<HashMap<String,Object>> selectButtonByRoleId(@Param("roleId") String roleId);
}
