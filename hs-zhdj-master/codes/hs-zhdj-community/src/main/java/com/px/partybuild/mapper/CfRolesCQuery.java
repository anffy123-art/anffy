package com.px.partybuild.mapper;

import com.px.partybuild.model.CfRoles;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface CfRolesCQuery {
    List<HashMap<String, Object>> selectRoleUserList(@Param("roleId") String roleId,@Param("username") String username);

    /**
     * 获取用户所有分组的角色和最大等级
     * @param userId
     * @return
     */
    List<HashMap<String, Object>> getUserRoles(@Param("userId") String userId);

    //验证用户是否拥有某个角色
    List<HashMap<String, Object>> valUserRole(@Param("userId") String userId, @Param("roleName") String roleName);


    List<CfRoles> selectRoleByExample(@Param("roleName") String roleName, @Param("roleCondition") String roleCondition);

    List<CfRoles> selectRoleByUserid(@Param("userId") String userId);

    //获取用户角色最大数据范围
    Integer getUserDataScope(@Param("userId") String userId, @Param("roleId") String roleId);

    List<HashMap<String, Object>> GetRoleByUserName(@Param("userName") String userName);

    int insertUserRole(@Param("userName") String userName, @Param("roleId") String roleId);
}
