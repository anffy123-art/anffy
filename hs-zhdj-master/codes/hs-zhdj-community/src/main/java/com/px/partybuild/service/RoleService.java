package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.CfRoles;
import com.px.partybuild.model.CfUserrolesKey;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface RoleService {
    /**
     * role save
     * @param cfRoles
     * @return
     */
    String saveRole(CfRoles cfRoles);

    /**
     * role list
     * @param pageNum
     * @param pageSize
     * @param appid
     * @param roleName
     * @return
     */
    PageInfo<CfRoles> getRoleList(int pageNum, int pageSize, String appid, String roleName);

    /**
     * role list
     * @param pageNum
     * @param pageSize
     * @param appid
     * @param roleName
     * @param userId
     * @return
     */
    PageInfo<CfRoles> getRoleList(int pageNum, int pageSize, String appid, String roleName, String userId);

    /**
     *  role by uid
     * @param uid
     * @return
     */
    List<CfRoles> getRolesByUid(String uid);

    /**
     * menu role id
     * @param roleId
     * @return
     */
    List<String> getMenuIdsByRoleId(String roleId);

    /**
     * role by id
     * @param roleId
     * @return
     */
    CfRoles getRoleById(String roleId);

    /**
     * role user list
     * @param roleId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<HashMap<String, Object>> getRoleUserList(String roleId,String username,  int pageIndex, int pageSize);

    /**
     * role save
     * @param roleId
     * @param menuIds
     * @return
     */
    int SaveRoleList(String roleId, String menuIds);

    /**
     * role delete
     * @param roleId
     * @return
     */
    String deleteRole(String roleId);

    /**
     * rolename by ueseid
     * @param userId
     * @return
     */
    List<String> getRoleNameByUserId(String userId);

    /**
     * role by user name
     * @param userName
     * @return
     */
    List<HashMap<String, Object>> getRoleByUserName(String userName);

    /**
     * user role
     * @param userName
     * @param roleId
     * @return
     */
    int insertUserRole(String userName, String roleId);

    /**
     * role user by name
     * @param roleName
     * @return
     */
    List<CfUserrolesKey> getRoleUsersByRoleName(String roleName);
}
