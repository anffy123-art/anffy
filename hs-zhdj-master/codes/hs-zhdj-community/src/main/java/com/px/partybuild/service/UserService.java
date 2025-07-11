package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.CfOudetail;
import com.px.partybuild.model.CfUsers;
import com.px.partybuild.model.CfUsersinfo;
import com.px.partybuild.vo.UserInfoVo;
import com.px.partybuild.vo.UserMobileVo;
import com.px.partybuild.vo.UserVo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface UserService {

    /**
     *  add user
     * @param cfUser
     * @return
     */
    int addUser(CfUsers cfUser);

    /**
     * user
     * @param userId
     * @return
     */
    CfUsers getUser(String userId);

    /**
     * 添加自定查询示例
     * @param userName n
     * @return list
     */
    List<HashMap<String, Object>> selectUserAll(String userName);

    /**
     * get userinfo by id
     * @param userId
     * @return
     */
    CfUsersinfo getUserInfobyId(String userId);

    /**
     * 把机构用户切换成园区
     *
     * @param userinfo
     */
    void addUserInfoWithPark(CfUsersinfo userinfo);

    /**
     * login usesr
     * @return
     */
    CfUsers getLoginUser();

    /**
     * menu user id
     * @param userId
     * @param appid
     * @return
     */
    List<HashMap<String, Object>> getMenuByUserId(String userId, String appid);

    /**
     * menu role id
     * @param roleId
     * @param appid
     * @param dwId 党员所属党委id
     * @return
     */
    List<HashMap<String, Object>> getMenuByRoleId(String roleId, String appid,String dwId);



    /**
     * dp parent id
     * @param parentID
     * @return
     */
    List<CfOudetail> getDpListByParentID(String parentID);

    /**
     * user list by dpid
     * @param dpId
     * @param userName
     * @return
     */
    List<CfUsersinfo> getUserListByDpID(String dpId, String userName);

    /**
     * user role list save
     * @param roleId
     * @param userIds
     * @param isRemoveRole
     * @return
     */
    int saveUserRoleList(String roleId, String userIds, boolean isRemoveRole);

    /**
     * user role save
     * @param roleId
     * @param userId
     * @return
     */
    int deleteUserRole(String roleId, String userId);

    /**
     * user by key
     * @param UserLoginId
     * @return
     */
    CfUsers getUserByKey(String UserLoginId);

    /**
     * user by mobile
     * @param mobile
     * @return
     */
    CfUsers getUserByMobile(String mobile);

    /**
     * getUserByOAName
     * @param oaName
     * @return
     */
    CfUsers getUserByOAName(String oaName);

    /**
     * user by name
     * @param name
     * @return
     */
    CfUsers getCfuserByUsername(String name);

    /**
     * enable user by key
     * @param UserLoginId
     * @return
     */
    CfUsers getEnableUserByKey(String UserLoginId);

    /**
     * user by role name
     * @param roleName
     * @return
     */
     /* List<CfUsersinfo> getUserByRoleName(String roleName);*/

    /**
     * user list
     * @param dpId
     * @param dzzmc
     * @param userName
     * @return
     */
    List<CfUsersinfo> getUserByParams(String dpId, String dzzmc, String userName);
    /**
     * user list
     * @param pageNum
     * @param pageSize
     * @param username
     * @return
     */
    /*PageInfo<HashMap<String, Object>> getUserList(int pageNum, int pageSize, String username);*/

    /**
     * user save
     * @param cfUsers
     * @param cfUsersinfo
     * @param parkIds
     * @return
     */
    int saveUser(CfUsers cfUsers, CfUsersinfo cfUsersinfo, String parkIds);

    /**
     * send pwd
     * @param userLogin
     * @param email
     * @return
     * @throws Exception
     */
    int sendPassword(String userLogin, String email) throws Exception;

    /**
     * last activity date
     * @param uid
     * @return
     */
    Timestamp getLastActivityDate(String uid);

    /**
     * change activity date
     * @param uid
     * @param activityDate
     * @return
     */
    int changeOnlineActivityDate(String uid, Date activityDate);

    /**
     * user online
     * @param pageNum
     * @param pageSize
     * @param userName
     * @return
     */
    PageInfo<Map<String,Object>> getUserOnline(int pageNum, int pageSize,String userName);

    /**
     * user by username
     * @param userName
     * @return
     */
    String getUserByUserName(String userName);

    /**
     * test cache
     * @param Id
     * @return
     */
    String testCache(String Id);

    /**
     * update activity date
     * @param cfUsers
     * @return
     */
    int updateLastActivityDate(CfUsers cfUsers);

    /**
     * url和登陆名权限判断
     *
     * @param url
     * @param userName
     * @return
     */
    boolean isUrlInRole(String url, String userName);

    /**
     * user permission by code
     * @param Code
     * @param userName
     * @param roleId
     * @param userDwid
     * @return
     */
    boolean userPermissionByCode(String Code, String userName, String roleId,String userDwid);

    /**
     * 扩展党建系统信息
     *
     * @param userId
     * @return
     */
    Map<String, Object> extendUserPartyInfo(String userId);


    /**
     * 获取人员基本信息
     *
     * @param userId
     * @return
     */
    Map<String, Object> extendUserPartyMore(String userId);

    /**
     * role by userid
     * @param userId
     * @return
     */
    List<HashMap<String, Object>> getRoleByUserId(String userId);

    /**
     * can login app?
     * @param userAppId
     * @return
     */
    Map<String, Object> canLoginApp(String userAppId);

    /**
     * can login app by oaId
     * @param oaId
     * @return
     */
    Map<String, Object> canLoginAppbyOAId(String oaId);
    /**
     * 用户党小组信息
     * @date 2024-08
     * @param userId
     * @return
     */
    Map<String, Object> extendUserDxzInfo(String userId);

    /**
     * user dzzdm
     * @param userId
     * @param roleId
     * @return
     */
    String getUserDzzdmForShowData(String userId, String roleId);

    /**
     * login api to userid
     * @param id
     * @param pwd
     * @return
     * @throws Exception
     */
    CfUsers loginApiToUserId(String id, String pwd) throws Exception;

    /**
     * userid to mobile
     * @param userId
     * @return
     */
    String userIdToMobile(String userId);

    /**
     * mobile to userid
     * @param mobile
     * @return
     */
    String mobiltToUserId(String mobile);

    /**
     * 更新用户登录账号
     * @date 2024-08
     * @param userId
     * @param mobile
     * @return
     */
    int saveUserMobile(String userId, String mobile);

    /**
     * batch update mobile
     * @param userList
     * @return
     */
    int batchUpdateUserMobile(List<UserMobileVo> userList);

    /**
     * user list
     * @param dzzdm
     * @return
     */
    List<UserVo> getUserList(String dzzdm);

    /**
     * user scope
     * @param userId
     * @param roleId
     * @return
     */
    Integer getUserDataScope(String userId, String roleId);

    /**
     * update partyuser count
     * @return
     */
    int procUpdatePartyusercount();

    /**
     * update user age
     * @return
     */
    int updateUserage();

    int procUpdatePartyusercountOfMonth();

    /**
     * user by mobile list
     * @param mobileList
     * @return
     */
    List<UserVo> getUserByMobileList(List<String> mobileList);

    /**
     * login force statue
     * @param uid
     * @param state
     * @return
     */
    int loginForceStatu(String uid,int state);

    /**
     *  check force statue
     * @param uid
     * @return
     */
    int checkForceStatu(String uid);

    int deleteUserById(String userId);


    List<UserInfoVo> importUser(List<UserInfoVo> dataList) throws Exception;

    CfUsers login(String account,String password);

    CfUsers loginByWxUserId(String wxUserId);

    void bindWxUserId(String userId,String wxUserId);

}
