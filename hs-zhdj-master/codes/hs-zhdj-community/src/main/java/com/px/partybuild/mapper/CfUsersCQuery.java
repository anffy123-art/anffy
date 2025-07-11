package com.px.partybuild.mapper;

import com.px.partybuild.model.CfUsers;
import com.px.partybuild.model.CfUsersinfo;
import com.px.partybuild.vo.UserMobileVo;
import com.px.partybuild.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface CfUsersCQuery {
    List<HashMap<String, Object>> selectUserAll(@Param("username") String userName);

    List<HashMap<String, Object>> getMenuByUid(@Param("userid") String userID, @Param("appid") String appID);

    /**
     * 用角色获取导航
     * appid：字段无用
     * @param roleId
     * @return
     */
    List<HashMap<String, Object>> getMenuByRoles(@Param("roleId") String roleId,@Param("menuDwids") List<String> menuDwids);

    //List<CfUsersinfo> GetUserByRoleName(String roleName);

    /*List<HashMap<String, Object>> selectUserList(@Param("username") String username);*/

    List<CfUsers> selectEnableUserList(@Param("UserLoginId") String UserLoginId);

    List<CfUsersinfo> getUserList(@Param("username") String userName, @Param("dpid") String dpid);

    List<CfUsersinfo> getUserByParams(@Param("username") String userName, @Param("dpid") String dpid, @Param("dzzmc") String dzzmc);

    Integer getPowerByMenu(@Param("menuIds") List<String> menuIds, @Param("userName") String userName,@Param("roleId") String roleId,@Param("menuDwids") List<String> menuDwids);

    List<HashMap<String, Object>> GetPartyUserInfo(@Param("id") String id);

    List<HashMap<String,Object>> GetPartyUserInfoMore(@Param("userId") String userId);

    List<HashMap<String,Object>> GetPartyGroup(@Param("groupId") String groupId);

    List<HashMap<String, Object>> GetRoleByUserId(@Param("userId") String userId);

    List<HashMap<String,Object>> GetUserDxzInfo(@Param("userId") String userId);

    List<CfUsers> getCfUserByMobile(@Param("mobile") String mobile);

    List<CfUsers> getCfUserByUsername(@Param("name") String name);

    int batchUpdateUserMobile(@Param("userList") List<UserMobileVo> userList);

    List<UserVo> selectUserMobileList(@Param("dzzdm") String dzzdm);

    List<Map<String,Object>> getUserOnline(@Param("userName") String userName,@Param("beforeTime") Date beforeTime);

    int UpdatePartyusercount();

    int updateUserage();

    int UpdatePartyusercountOfMonth();


    List<UserVo> selectUserByMobileList(@Param("mobileList") List<String> mobileList);



}


