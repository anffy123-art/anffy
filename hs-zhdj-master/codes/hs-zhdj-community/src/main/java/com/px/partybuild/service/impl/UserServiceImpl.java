package com.px.partybuild.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.AppConfig;
import com.px.partybuild.mapper.*;
import com.px.partybuild.model.*;
import com.px.partybuild.service.*;
import com.px.partybuild.util.JsonMapper;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.util.RemoteHelper;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.vo.PartyUserInfoVo;
import com.px.partybuild.vo.UserInfoVo;
import com.px.partybuild.vo.UserMobileVo;
import com.px.partybuild.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author H
 * @date 2024-08
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private CfUsersMapper cfUsersMapper;

    @Autowired
    private CfUsersCQuery cfUsersCQuery;

    @Autowired
    private CfUsersinfoMapper cfUsersinfoMapper;

    @Autowired
    private CfOudetailMapper cfOudetailMapper;

    @Autowired
    private CfUserrolesMapper cfUserrolesMapper;

    @Autowired
    protected AppConfig appConfig;

    @Autowired
    protected StringUtils stringUtils;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private CfMenuMapper cfMenuMapper;

    @Autowired
    private PartyService partyService;

    /*
    @Autowired
    RedisTemplate redisTemplate;*/

    @Autowired
    private CfUserappinfoMapper cfUserappinfoMapper;

    @Autowired
    private MapUtils mapUtils;

    private org.apache.commons.lang3.StringUtils stringUtils3;

    @Autowired
    private CfRolesCQuery rolesCQuery;
    @Autowired
    private PartyUserCQuery partyUserCQuery;
    @Autowired
    private PartyCQuery partyCQuery;

    @Autowired
    private RemoteHelper remoteHelper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private PartyUserService partyUserService;
    @Autowired
    private PartyUserCQuery partyUserCquery;
    @Autowired
    private com.px.partybuild.util.DateUtils dateUtils;
    @Autowired
    private GgZgjbxxMapper ggZgjbxxMapper;
    @Autowired
    private RsRyjbxxfbMapper rsRyjbxxfbMapper;
    @Autowired
    private ZzRyjbxxMapper zzRyjbxxMapper;

    private String massesRoleId = "b2db297b-333f-4575-8da1-f5534e23a133";


    @Override
    public int addUser(CfUsers cfUser) {
        return cfUsersMapper.insert(cfUser);
    }

    @Override
    public CfUsers getUser(String userId) {
        CfUsers user = cfUsersMapper.selectByPrimaryKey(userId);
        if (user == null) {
            user = new CfUsers();
            user.setUserid("");
            user.setUsername("");
        }
        return user;
    }

    @Override
    public List<HashMap<String, Object>> selectUserAll(String userName) {
        return cfUsersCQuery.selectUserAll(userName);
    }

    @Override
    /*@Cacheable(value = "getUserInfobyId", key = "#p0")*/
    public CfUsersinfo getUserInfobyId(String userId) {
        CfUsersinfo user = new CfUsersinfo();//

        PartyUserInfoVo userInfoVo = partyUserCquery.selectUserInfo(userId);

        if (userInfoVo == null) {
            user = new CfUsersinfo();
            user.setName("");
            user.setId("");
        } else {
            user.setId(userInfoVo.getRybm());
            user.setName(userInfoVo.getXm());
        }
        return user;
    }

    /**
     * 把机构用户切换成园区
     *
     * @param userinfo
     */
    @Override
    public void addUserInfoWithPark(CfUsersinfo userinfo) {
        /*
        List<HashMap<String, Object>> parkList = this.GetUserParkList(userinfo.getId());
        String dpName = "", dpId = "";

        for (HashMap<String, Object> park : parkList) {
            dpName += park.get("parkName") + ",";
            dpId += park.get("parkID") + ",";
        }

        if (dpName.length() > 0) {
            dpName = dpName.substring(0, dpName.length() - 1);
            dpId = dpId.substring(0, dpId.length() - 1);
        }

        userinfo.setDpname(dpName);
        userinfo.setDpid(dpId);*/
    }

    @Override
    public CfUsers getLoginUser() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String loginId = requestAttributes.getRequest().getAttribute("UserLoginId").toString();
        //return getUserByKey(loginId);
        return getUser(loginId);
    }


    @Override
    @Cacheable(value = "GetMenuByUserId", key = "#p0+'-'+#p1")
    public List<HashMap<String, Object>> getMenuByUserId(String userId, String appid) {

        return cfUsersCQuery.getMenuByUid(userId, appid);
    }

    @Override
    public List<HashMap<String, Object>> getMenuByRoleId(String roleId, String appid, String dwId) {

        List<String> menuDwids = new ArrayList<>();
        try {
            if (!stringUtils.IsNullOrEmpty(appConfig.menuDwids) && !stringUtils.IsNullOrEmpty(dwId)) {
                menuDwids = java.util.Arrays.asList(appConfig.menuDwids.split(","));

                menuDwids = menuDwids.stream().filter(it -> !it.contains(dwId)).collect(Collectors.toList());
            }
        } catch (Exception e) {
        }

        return cfUsersCQuery.getMenuByRoles(roleId, menuDwids);
    }


    @Override
    public List<CfOudetail> getDpListByParentID(String parentID) {
        CfOudetailExample exp = new CfOudetailExample();
        exp.or().andParentdpidEqualTo(parentID);
        return cfOudetailMapper.selectByExample(exp);
    }

    @Override
    public List<CfUsersinfo> getUserListByDpID(String dpId, String userName) {
        return cfUsersCQuery.getUserList(userName, dpId);
    }

    @Override
    public List<CfUsersinfo> getUserByParams(String dpId, String dzzmc, String userName) {
        return cfUsersCQuery.getUserByParams(userName, dpId, dzzmc);
    }

    @Override
    public int saveUserRoleList(String roleIds, String userIds, boolean isRemoveRole) {

        String[] userIdArray = userIds.split(",");
        String[] roleIdArray = roleIds.split(",");
        List<String> userIdList = Arrays.asList(userIdArray);
        //不在cf_users存在的用户，先初始化数据
        CfUsersExample uexm = new CfUsersExample();
        uexm.or().andUseridIn(userIdList);
        List<CfUsers> users = cfUsersMapper.selectByExample(uexm);
        for (String uid : userIdList) {
            if (users.stream().filter(x -> x.getUserid().equals(uid)).count() == 0) {
                HashMap<String, Object> userinfo = partyUserService.getPartyUserInfoByRybm(uid);
                if (userinfo != null && userinfo.get("RYBM") != null) {
                    String xm = userinfo.get("XM") == null ? "" : userinfo.get("XM").toString();

                    CfUsers user = new CfUsers();
                    user.setUserid(uid);
                    user.setUsername(null);
                    user.setApplicationid("f0c4fa7f9f3c4fb6bd56aac608b7ad3f");
                    user.setUserpwd("D6FB6D8741F9AF9E7BC1C39E79D73944");
                    user.setIsanonymous(1);
                    user.setLastactivitydate(new Date());
                    cfUsersMapper.insert(user);

                    /*CfUsersinfo info = new CfUsersinfo();
                     *//*info.setId(uid);
                info.setDguserid(uid);
                info.setIsenable(new BigDecimal(1));*//*
                    info.setId(uid);
                    info.setDguserid(uid);
                    info.setName(xm);
                    info.setUserligion(xm);
                    info.setIsenable(new BigDecimal("1"));
                    cfUsersinfoMapper.insert(info);*/
                }
            }
        }
        int addItemCount = 0;
        if (roleIds.length() > 0) {
            for (String roleId : roleIdArray) {
                CfUserrolesExample expUr = new CfUserrolesExample();
                expUr.or().andRoleidEqualTo(roleId).andUseridIn(userIdList);
                List<CfUserrolesKey> existlist = cfUserrolesMapper.selectByExample(expUr);

                for (String uid : userIdList) {
                    if (existlist.stream().filter(x -> x.getUserid().equals(uid)).count() == 0) {
                        CfUserrolesKey cfUserrolesKey = new CfUserrolesKey();
                        cfUserrolesKey.setRoleid(roleId);
                        cfUserrolesKey.setUserid(uid);
                        addItemCount = addItemCount + cfUserrolesMapper.insert(cfUserrolesKey);
                    }
                }
            }
        }
        //删除剔除掉的角色
        if (isRemoveRole == true) {
            CfUserrolesExample expUr2 = new CfUserrolesExample();

            if (roleIds.length() > 0) {
                expUr2.or().andUseridIn(userIdList).andRoleidNotIn(Arrays.asList(roleIdArray));
            } else//如果没有选择角色，则清空用户所有角色
            {
                expUr2.or().andUseridIn(userIdList);
            }
            cfUserrolesMapper.deleteByExample(expUr2);
        }
        return addItemCount;
    }

    @Override
    public int deleteUserRole(String roleId, String userId) {
        CfUserrolesExample expUr = new CfUserrolesExample();
        expUr.or().andRoleidEqualTo(roleId).andUseridEqualTo(userId);
        return cfUserrolesMapper.deleteByExample(expUr);
    }

    @Override
    @Cacheable(value = "getUserByKey", key = "#p0")
    public CfUsers getUserByKey(String userLoginId) {
        CfUsers user = new CfUsers();
        CfUsersExample exp = new CfUsersExample();
        exp.or().andUsernameEqualTo(userLoginId);
        List<CfUsers> cfUsers = cfUsersMapper.selectByExample(exp);
        if (cfUsers.size() > 0) {
            user = cfUsers.get(0);
        } else {
            user = new CfUsers();
            user.setUsername("");
            user.setUserid("");
            user.setUserpwd("");
        }

        //redisTemplate.opsForValue().set("test1","t1234");
        //redisTemplate.opsForSet().add("user_GetUserByKey_"+user.getUserid(),user);
        return user;
    }

    @Override
    public CfUsers getUserByMobile(String mobile) {

        CfUsers user = null;

        //if()

        List<CfUsers> users = cfUsersCQuery.getCfUserByMobile(mobile);
        if (users.size() > 0) {
            user = users.get(0);
            user.setUserpwd("");
        } else {
            user = new CfUsers();
            user.setUsername("");
            user.setUserid("");
            user.setUserpwd("");
        }
        return user;
    }

    @Override
    public CfUsers getUserByOAName(String oaName) {
        CfUsers user = null;
        if (org.apache.commons.lang3.StringUtils.isNotBlank(oaName)) {
            CfUsersExample exp = new CfUsersExample();
            exp.or().andOauseridEqualTo(oaName);
            List<CfUsers> users = cfUsersMapper.selectByExample(exp);
            if (users.size() > 0) {

                user = users.get(0);
            }
        }

        if (user == null) {
            user = new CfUsers();
            user.setUsername("");
            user.setUserid("");
            user.setUserpwd("");
        }

        return user;
    }

    @Override
    public CfUsers getCfuserByUsername(String name) {

        CfUsers user = null;


        List<CfUsers> users = cfUsersCQuery.getCfUserByUsername(name);
        if (users.size() > 0) {
            user = users.get(0);
            user.setUserpwd("");
        } else {
            user = new CfUsers();
            user.setUsername("");
            user.setUserid("");
            user.setUserpwd("");
        }
        return user;
    }


    @Override
    public CfUsers getEnableUserByKey(String UserLoginId) {

        CfUsers user = new CfUsers();
        List<CfUsers> cfUsers = cfUsersCQuery.selectEnableUserList(UserLoginId);
        if (cfUsers.size() > 0) {
            user = cfUsers.get(0);
        } else {
            user = new CfUsers();
            user.setUsername("");
            user.setUserid("");
        }
        return user;
    }

    /*@Override
    public List<CfUsersinfo> getUserByRoleName(String roleName) {
        return cfUsersCQuery.GetUserByRoleName(roleName);
    }*/


   /* @Override
    public PageInfo<HashMap<String, Object>> getUserList(int pageNum, int pageSize, String username) {
        PageHelper.startPage(pageNum, pageSize);

        List<HashMap<String, Object>> list = cfUsersCQuery.selectUserList(username);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);

        return result;
    }*/

    @Override
    public int saveUser(CfUsers cfUsers, CfUsersinfo cfUsersinfo, String parkIds) {
        int result = 0;
        int userType = cfUsersinfo.getUsertype().intValue();

        CfUsers user = getLoginUser();
        CfUsers model = getUser(cfUsers.getUserid());
        if (model == null || stringUtils.IsNullOrEmpty(model.getUserid())) {
            cfUsers.setUsername(cfUsersinfo.getUserligion());
            result = cfUsersMapper.insert(cfUsers);
        } else {
            result = cfUsersMapper.updateByPrimaryKey(cfUsers);
        }

        CfUsersinfo usermodel = getUserInfobyId(cfUsersinfo.getId());

        if (usermodel == null || stringUtils.IsNullOrEmpty(usermodel.getId())) {

            //cfUsersinfo.setCreateby(user.getUserid());
            //cfUsersinfo.setCreatetime(new Date());
            //result = cfUsersinfoMapper.insert(cfUsersinfo);
        } else {
            //cfUsersinfo.setUpdateby(user.getUserid());
            //cfUsersinfo.setUpdatetime(new Date());
            //result = cfUsersinfoMapper.updateByPrimaryKey(cfUsersinfo);
        }

        /*删除园区关联*/
        /*
        CfUserparksExample exp = new CfUserparksExample();
        CfUserparksExample.Criteria cri = exp.or().andUseridEqualTo(cfUsers.getUserid());
        cfUserparksMapper.deleteByExample(exp);

        if (!stringUtils.IsNullOrEmpty(parkIds)) {
            List<String> parkidList = java.util.Arrays.asList(parkIds.split(","));
            parkidList.forEach(item -> {
                CfUserparksKey userpark = new CfUserparksKey();
                userpark.setParkid(item);
                userpark.setUserid(cfUsers.getUserid());

                cfUserparksMapper.insert(userpark);
            });
        }
        */
        return result;
    }

    @Override
    public int sendPassword(String userLogin, String email) throws Exception {
        int count = 0;
        CfUsersinfoExample exp = new CfUsersinfoExample();
        exp.or().andUserligionEqualTo(userLogin);
        /*List<CfUsersinfo> usersinfoList = cfUsersinfoMapper.selectByExample(exp);
        if (usersinfoList.size() == 0) {
            throw new Exception("该用户不存在！");
        } else {
            CfUsersinfo usersinfo = usersinfoList.get(0);
            ObjectMapper mapper = new ObjectMapper();
            *//*
            if (usersinfo.getEmail().equals(email)) {
                int password = (int) (1000 + Math.random() * (9999 - 1000 + 1));
                String newPassword = "PD" + String.valueOf(password);
                try {
                    CfUsersExample usersexp = new CfUsersExample();
                    usersexp.or().andUsernameEqualTo(userLogin);
                    List<CfUsers> cfUsersList = cfUsersMapper.selectByExample(usersexp);
                    CfUsers cfUsers = cfUsersList.get(0);
                    cfUsers.setUserpwd(DigestUtils.md5DigestAsHex(newPassword.getBytes()).toUpperCase());
                    count = cfUsersMapper.updateByPrimaryKey(cfUsers);
                    SendEmail(email, "", newPassword);
                } catch (Exception e) {
                }
            } else {
                throw new Exception("用户名与邮箱不匹配！");
            }*//*
        }*/
        return count;
    }

    @Override
    public Timestamp getLastActivityDate(String uid) {

        return null;
    }

    @Override
    public String getUserByUserName(String username) {
        //String userid = cfUsersMapper.selectByUsername(username);
        CfUsersExample exp = new CfUsersExample();
        exp.or().andUsernameEqualTo(username);
        cfUsersMapper.selectByExample(exp);
        String userid = "";
        if (userid == null) {
            userid = "";
        }
        return userid;
    }

    @Override
    @Cacheable(value = "userServer", key = "#p0")
    public String testCache(String Id) {
        String result = "OK" + Id;
        return result;
    }

    @Override
    public int updateLastActivityDate(CfUsers cfUsers) {
        //return cfUsersMapper.updateLastActivityDate(cfUsers);

        //cfUsersMapper.updateByExampleSelective()
        return 0;
    }

    @Override
    public int changeOnlineActivityDate(String uid, Date activityDate) {

        CfUsers cfUsers = new CfUsers();

        if (org.apache.commons.lang3.StringUtils.isBlank(uid)) {
            return 0;
        }

        cfUsers.setUserid(uid);
        cfUsers.setLastactivitydate(activityDate);

        return cfUsersMapper.updateByPrimaryKeySelective(cfUsers);
    }

    @Override
    public PageInfo<Map<String, Object>> getUserOnline(int pageNum, int pageSize, String userName) {

        //getUserOnline

        Date beforeTime = DateUtils.addMinutes(new Date(), -2);

        PageHelper.startPage(pageNum, pageSize);

        List<Map<String, Object>> list = cfUsersCQuery.getUserOnline(userName, beforeTime);

        PageInfo<Map<String, Object>> result = new PageInfo(list);

        return result;
    }

    @Override
    @Cacheable(value = "isUrlInRole", key = "#p0+'-'+#p1")
    public boolean isUrlInRole(String url, String userName) {
        boolean isPower = true;

        String[] paramUrls = url.split("/");

        //String userId=mobiltToUserId(userName);

        //只处理/api/{controller}/{action}
        if (paramUrls.length >= 4) {
            List<String> pUrls = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                pUrls.add(paramUrls[i]);
            }

            String newUrl = String.join("/", pUrls);
            CfMenuExample menuExp = new CfMenuExample();
            menuExp.or().andMenunoEqualTo(newUrl);
            List<CfMenu> menus = cfMenuMapper.selectByExample(menuExp);
            //只处理有配置url要管理权限，无配置直接不限制
            if (menus.size() > 0) {
                List<String> menuIds = menus.stream().map(menu -> menu.getMenuid()).collect(Collectors.toList());
                int powerRow = cfUsersCQuery.getPowerByMenu(menuIds, userName, "", null);

                if (powerRow == 0) {
                    isPower = false;
                }
            }

        }
        return isPower;
    }

    @Override
    @Cacheable(value = "userPermissionByCode", key = "#p0+'-'+#p1+'-'+#p2+'-'+#p3")
    public boolean userPermissionByCode(String Code, String userName, String roleId, String userDwid) {
        boolean isPower = true;

        CfMenuExample menuExp = new CfMenuExample();
        menuExp.or().andMenunoEqualTo(Code);

        List<CfMenu> menus = cfMenuMapper.selectByExample(menuExp);
        //只处理有配置url要管理权限，无配置直接不限制
        if (menus.size() > 0) {
            List<String> menuIds = menus.stream().map(menu -> menu.getMenuid()).collect(Collectors.toList());

            List<String> menuDwids = new ArrayList<>();
            try {
                if (!stringUtils.IsNullOrEmpty(appConfig.menuDwids) && !stringUtils.IsNullOrEmpty(userDwid)) {
                    menuDwids = java.util.Arrays.asList(appConfig.menuDwids.split(","));
                    menuDwids = menuDwids.stream().filter(it -> !it.contains(userDwid)).collect(Collectors.toList());
                }
            } catch (Exception e) {
            }

            int powerRow = cfUsersCQuery.getPowerByMenu(menuIds, userName, roleId, menuDwids);
            if (powerRow == 0) {
                isPower = false;
            }
        }

        return isPower;
    }

    @Override
    @Cacheable(value = "ExtendUserPartyInfo", key = "#p0")
    public Map<String, Object> extendUserPartyInfo(String userId) {

        Map<String, Object> partInfo = new HashMap<String, Object>();
        List<HashMap<String, Object>> partyInfoList = cfUsersCQuery.GetPartyUserInfo(userId);

        if (partyInfoList.size() > 0) {
            partInfo = partyInfoList.get(0);
        }

        return partInfo;
    }

    @Override
    public Map<String, Object> extendUserPartyMore(String userId) {

        Map<String, Object> result = null;
        List<HashMap<String, Object>> partyMores = cfUsersCQuery.GetPartyUserInfoMore(userId);
        if (partyMores.size() > 0) {
            result = partyMores.get(0);
            Map<String, Object> groupInfo = extendUserPartyInfo(userId);

            List<String> listFullGName = new ArrayList<>();

            GetUseFullGroupName((String) groupInfo.get("DZZDM"), listFullGName);

            Collections.reverse(listFullGName);

            result.put("FULLDZZMC", String.join(">", listFullGName));
        }

        return result;
    }

    protected void GetUseFullGroupName(String groupId, List<String> listGroupNames) {
        if (listGroupNames != null && org.apache.commons.lang3.StringUtils.isNotBlank(groupId)) {

            List<HashMap<String, Object>> rows = cfUsersCQuery.GetPartyGroup(groupId);
            if (rows.size() > 0) {
                String parentId = (String) rows.get(0).get("PARENTCODE");
                listGroupNames.add((String) rows.get(0).get("DZZMC"));
                if (org.apache.commons.lang3.StringUtils.isNotBlank(parentId) && parentId.length() >= appConfig.gddwdm.length()) {
                    this.GetUseFullGroupName(parentId, listGroupNames);
                }

            }

        }
    }

    @Override
    public List<HashMap<String, Object>> getRoleByUserId(String userId) {

        List<HashMap<String, Object>> roleList = cfUsersCQuery.GetRoleByUserId(userId);

        return roleList;
    }

    /**
     * @Description //TODO 用户党小组信息
     * @date 2024-08
     * @Param [userId]
     **/
    @Override
    public Map<String, Object> extendUserDxzInfo(String userId) {
        Map<String, Object> dxzInfo = new HashMap<String, Object>();
        List<HashMap<String, Object>> dxzInfoList = cfUsersCQuery.GetUserDxzInfo(userId);

        if (dxzInfoList.size() > 0) {
            dxzInfo = dxzInfoList.get(0);
        }
        return dxzInfo;
    }

    @Override
    public Map<String, Object> canLoginApp(String userAppId) {

        HashMap<String, Object> result = new HashMap<>();

       /* CfUsersinfoExample exp = new CfUsersinfoExample();
        exp.or().andMobileEqualTo(userAppId);
        List<CfUsersinfo> users = cfUsersinfoMapper.selectByExample(exp);
        if (users.size() > 0) {
            result = mapUtils.objectToMap(users.get(0));
        }*/
        if (org.apache.commons.lang3.StringUtils.isNotBlank(userAppId)) {
            CfUsersExample exp = new CfUsersExample();
            exp.or().andUsernameEqualTo(userAppId);
            List<CfUsers> users = cfUsersMapper.selectByExample(exp);
            if (users.size() > 0) {
                /*result = mapUtils.objectToMap(users.get(0));*/
                result.put("id", users.get(0).getUserid());
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> canLoginAppbyOAId(String oaId) {
        HashMap<String, Object> result = new HashMap<>();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(oaId)) {
            CfUsers user = this.getUserByMobile(oaId);
            result.put("id", user.getUserid());
        }
        return result;
    }

    @Override
    public String getUserDzzdmForShowData(String userId, String roleId) {
        String dzzdm = "党组织权限";
        if (userId != null && userId.length() > 0) {
            String jtbm = appConfig.gddwdm;
            /*HashMap<String, Object> userinfo = partyUserService.getPartyUserInfoByRybm(userId);*/
            HashMap<String, Object> userinfo = partyUserService.getPartyUserExt(userId);
            Integer dataScope = rolesCQuery.getUserDataScope(userId, roleId);
            //dataScope=1=全集团=可全集团所有组织
            //dataScope=2=本党委=可查看本党委及以下
            //dataScope=3=本总支=可查看本总支及以下
            //dataScope=4=本支部=可查看本支部及以下
            //dataScope=5=本党小组=可查看本党小组
            //dataScope=6=未定义=忽略
            //dataScope=7=二级党委=可查看二级党委及以下
            if (userinfo != null && userinfo.get("RYBM") != null) {
                String zzlbmc = userinfo.get("ZZLBMC") != null ? userinfo.get("ZZLBMC").toString() : "";

                switch (dataScope) {
                    case 1:
                        dzzdm = jtbm;
                        break;
                    case 2:
                        //截取集团公司编号+后3位为党委编码
                        dzzdm = userinfo.get("SZDZBDM").toString();
                        if (dzzdm.length() >= (jtbm.length() + 3)) {
                            dzzdm = dzzdm.substring(0, (jtbm.length() + 3));
                        }
                        break;
                    case 3://本总支
                        dzzdm = userinfo.get("SZDZBDM").toString();
                        String dmResult = dzzdm;
                        while (dmResult.length() >= 15) {
                            List<HashMap<String, Object>> parent = partyCQuery.selectPartyInfoList(dmResult);

                            if (parent.size() == 0) {
                                break;
                            }

                            zzlbmc = parent.get(0).get("ZZLBMC") != null ? parent.get(0).get("ZZLBMC").toString() : "";

                            if (zzlbmc.contains("党总支")) {
                                dzzdm = dmResult;
                            }

                            dmResult = dmResult.substring(0, dmResult.length() - 3);
                        }
                        break;
                    case 4://本支部
                        dzzdm = userinfo.get("SZDZBDM").toString();
                        //如果查询的党组织类别名称不是党支部，则循环向上级查找
                        while (!zzlbmc.contains("党支部") && dzzdm.length() >= 10) {
                            dzzdm = dzzdm.substring(0, dzzdm.length() - 3);
                            //List<HashMap<String, Object>> parent = partyCQuery.selectPartyList(null, null, dzzdm, null, null, null, null, null, null);

                            List<HashMap<String, Object>> parent = partyCQuery.selectPartyInfoList(dzzdm);

                            if (parent == null || parent.size() <= 0) {
                                break;
                            }
                            ;
                            zzlbmc = parent.get(0).get("ZZLBMC") != null ? parent.get(0).get("ZZLBMC").toString() : "";
                        }
                        //如果查询异常，则还原为当前组织
                        if (!zzlbmc.contains("党支部")) {
                            dzzdm = userinfo.get("SZDZBDM").toString();
                        }
                        break;
                    case 5://本党小组
                        //查看本党小组
                        dzzdm = userinfo.get("SZDZBDM").toString();
                        break;
                    case 6://未定义
                        //查看本组织
                        dzzdm = userinfo.get("SZDZBDM").toString();
                        break;
                    case 7://二级党委书记
                        //截取集团公司编号+后6位为党委编码
                        dzzdm = userinfo.get("SZDZBDM").toString();
                        if (dzzdm.length() >= (jtbm.length() + 6)) {
                            String dataDzzdm = dzzdm.substring(0, (jtbm.length() + 6));

                            ZzZzqkxxfb zzZzqkxxfb = partyService.getPartyFbById(dataDzzdm);

                            if (zzZzqkxxfb != null && ("100".equals(zzZzqkxxfb.getZzlb()) || "200".equals(zzZzqkxxfb.getZzlb()))) {
                                dzzdm = dataDzzdm;
                            }
                        }
                        break;
                    case 8://二级总支
                        dzzdm = userinfo.get("SZDZBDM").toString();
                        //如果查询的党组织类别名称不是党支部，则循环向上级查找
                        while (!zzlbmc.contains("党总支") && dzzdm.length() >= 10) {
                            dzzdm = dzzdm.substring(0, dzzdm.length() - 3);
                            //List<HashMap<String, Object>> parent = partyCQuery.selectPartyList(null, null, dzzdm, null, null, null, null, null, null);

                            List<HashMap<String, Object>> parent = partyCQuery.selectPartyInfoList(dzzdm);

                            if (parent == null || parent.size() <= 0) {
                                break;
                            }
                            ;
                            zzlbmc = parent.get(0).get("ZZLBMC") != null ? parent.get(0).get("ZZLBMC").toString() : "";
                        }
                        //如果查询异常，则还原为当前组织
                        if (!zzlbmc.contains("党总支")) {
                            dzzdm = userinfo.get("SZDZBDM").toString();
                        }
                        break;
                    default:
                        //查看本组织
                        dzzdm = userinfo.get("SZDZBDM").toString();
                        break;
                }
            } else {
                dzzdm = dataScope == 1 ? jtbm : "";//查询不到该组织成员
            }
        }

        return dzzdm;
    }

    @Override
    public Integer getUserDataScope(String userId, String roleId) {
        return rolesCQuery.getUserDataScope(userId, roleId);
    }

    @Override
    public int procUpdatePartyusercount() {

        return cfUsersCQuery.UpdatePartyusercount();
    }

    @Override
    public int updateUserage() {

        return cfUsersCQuery.updateUserage();
    }

    @Override
    public int procUpdatePartyusercountOfMonth() {

        return cfUsersCQuery.UpdatePartyusercountOfMonth();
    }

    @Override
    public CfUsers loginApiToUserId(String id, String pwd) throws Exception {

        CfUsers result = null;

        Map<String, Object> mapData = new HashMap<>();

        mapData.put("loginId", id);
        String desPwd = commonService.AppDesEncode(pwd, appConfig.appDesSecret, appConfig.appDesVi);
        mapData.put("password", desPwd);
        mapData.put("fromSys", appConfig.appFromSys);

        String reqStr = remoteHelper.postJson(JsonMapper.objectToJson(mapData), appConfig.appLoginUrl, "utf-8");

        JsonNode loginJson = JsonMapper.GetJsonNode(reqStr);

        if (loginJson.findPath("success").asBoolean()) {

            String mobile = loginJson.findPath("data").findPath("mobile").asText();
            String name = loginJson.findPath("data").findPath("name").asText();
            if (org.apache.commons.lang3.StringUtils.isNotBlank(mobile)) {
                CfUsers user = getUserByMobile(mobile);
                if (org.apache.commons.lang3.StringUtils.isNotBlank(user.getUsername())) {
                    result = user;
                } else {
                    //手机号匹配失败，使用人名
                    result = getUserByMobile(name);
                }
            } else {
                //无手机号直接使用人名
                result = getUserByMobile(name);

            }


        } else {
            throw new Exception(loginJson.findPath("errorCode").asText() + ":" + loginJson.findPath("error").asText());
        }

        return result;
    }

    @Override
    public String userIdToMobile(String userId) {

        String mobile = "";

        /*CfUsersinfo user = cfUsersinfoMapper.selectByPrimaryKey(userId);*/
        CfUsers user = cfUsersMapper.selectByPrimaryKey(userId);

        if (user != null) {
            mobile = user.getUsername();
        }

        return mobile;
    }

    @Override
    public String mobiltToUserId(String mobile) {
        String userId = "";
        /*CfUsersinfoExample exp = new CfUsersinfoExample();
        exp.or().andMobileEqualTo(mobile);
        List<CfUsersinfo> users = cfUsersinfoMapper.selectByExample(exp);
        if (users.size() > 0) {
            userId = users.get(0).getId();
        }*/

        CfUsersExample exp = new CfUsersExample();
        exp.or().andUsernameEqualTo(mobile);
        List<CfUsers> users = cfUsersMapper.selectByExample(exp);
        if (users.size() > 0) {
            userId = users.get(0).getUserid();
        }

        return userId;
    }

    @Override
    public int saveUserMobile(String userId, String mobile) {
        int count = 0;

        HashMap<String, Object> userinfo = partyUserService.getPartyUserInfoByRybm(userId);
        if (userinfo != null && userinfo.get("RYBM") != null) {
            CfUsers cfUsers = getUser(userId);
            CfUsersinfo cfUsersinfo = getUserInfobyId(userId);
            String xm = userinfo.get("XM") == null ? "" : userinfo.get("XM").toString();
            if (cfUsers == null || stringUtils.IsNullOrEmpty(cfUsers.getUserid())) {
                cfUsers = new CfUsers();
                cfUsers.setUserid(userId);
                cfUsers.setUsername(mobile);
                cfUsers.setApplicationid(appConfig.appId);
                cfUsers.setIsanonymous(1);
                cfUsers.setUserpwd("D6FB6D8741F9AF9E7BC1C39E79D73944");//zxc@qq

                cfUsersMapper.insert(cfUsers);
            } else {
                cfUsers.setUsername(mobile);
                cfUsersMapper.updateByPrimaryKey(cfUsers);
            }
            /*if (cfUsersinfo == null || stringUtils.IsNullOrEmpty(cfUsersinfo.getId())) {
                cfUsersinfo = new CfUsersinfo();
                cfUsersinfo.setId(userId);
                cfUsersinfo.setDguserid(userId);
                cfUsersinfo.setName(xm);
                cfUsersinfo.setUserligion(xm);
                cfUsersinfo.setMobile(mobile);
                cfUsersinfo.setIsenable(new BigDecimal("1"));

                count = cfUsersinfoMapper.insert(cfUsersinfo);
            } else {
                cfUsersinfo.setMobile(mobile);
                count = cfUsersinfoMapper.updateByPrimaryKey(cfUsersinfo);
            }*/

        }

        return count;
    }


    @Override
    public List<UserVo> getUserList(String dzzdm) {
        return cfUsersCQuery.selectUserMobileList(dzzdm);
    }


    @Override
    public int batchUpdateUserMobile(List<UserMobileVo> userList) {
        return cfUsersCQuery.batchUpdateUserMobile(userList);
    }


    @Override
    public List<UserVo> getUserByMobileList(List<String> mobileList) {
        return cfUsersCQuery.selectUserByMobileList(mobileList);
    }

    @Override
    public int loginForceStatu(String uid, int state) {

        CfUsers user = new CfUsers();
        user.setUserid(uid);
        user.setLastactivitydate(new Date());
        user.setForceloginout(state);

        return cfUsersMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int checkForceStatu(String uid) {
        int result = 0;

        CfUsers user = cfUsersMapper.selectByPrimaryKey(uid);

        if (user != null) {

            result = user.getForceloginout() == null ? 0 : user.getForceloginout();
        }

        return result;
    }

    @Override
    public int deleteUserById(String userId) {
        CfUserrolesExample expUr = new CfUserrolesExample();
        expUr.or().andUseridEqualTo(userId);
        cfUserrolesMapper.deleteByExample(expUr);

        cfUsersinfoMapper.deleteByPrimaryKey(userId);

        GgZgjbxxExample ggexz = new GgZgjbxxExample();
        ggexz.or().andRybmEqualTo(userId);
        ggZgjbxxMapper.deleteByExample(ggexz);

        return cfUsersMapper.deleteByPrimaryKey(userId);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<UserInfoVo> importUser(List<UserInfoVo> dataList) throws Exception {
        if (dataList.size() <= 0) {
            throw new Exception("请添加导入数据");
        }
        List<UserInfoVo> errorList = new ArrayList<>();
        List<GgZgjbxx> ggZgjbxxList = new ArrayList<>();
        List<ZzRyjbxx> zzRyjbxxList = new ArrayList<>();
        List<RsRyjbxxfb> rsRyjbxxfbList = new ArrayList<>();
        List<CfUsers> cfUsersList = new ArrayList<>();

        List<String> userCodes = dataList.stream().filter(it -> !stringUtils.IsNullOrEmpty(it.getUserCode())).map(it -> it.getUserCode().trim()).collect(Collectors.toList());
        List<String> partyNames = dataList.stream().filter(it -> !stringUtils.IsNullOrEmpty(it.getPartyName())).map(it -> it.getPartyName().trim()).collect(Collectors.toList());
        List<ZzZzqkxx> zzZzqkxxList = partyUserService.getZzZzqkxxByNameList(partyNames);
        List<GgZgjbxx> dbGgZgjbxxList = partyUserService.getGgZgjbxxList(userCodes);
        List<ZzRyjbxx> dbZzRyjbxxList = partyUserService.getZzRyjbxxList(userCodes);
        List<RsRyjbxxfb> dbRsRyjbxxfbList = partyUserService.getRsRyjbxxfbList(userCodes);
        List<CfUsers> dbCfUsersList = partyUserService.getCfUsersList(userCodes);
        List<CfUserrolesKey> dbCfUserroleList = partyUserService.getCfUserroleList(userCodes);

        if (userCodes.stream().distinct().count() != userCodes.size()) {
            throw new Exception("导入数据存在相同学号/工号，请修改后重新导入！");
        }

        for (int i = 0; i < dataList.size(); i++) {
            UserInfoVo item = dataList.get(i);

            GgZgjbxx ggZgjbxx = dbGgZgjbxxList.stream().filter(it -> it.getRybm().equals(item.getUserCode())).findFirst().orElse(new GgZgjbxx());
            ZzRyjbxx zzRyjbxx = dbZzRyjbxxList.stream().filter(it -> it.getRybm().equals(item.getUserCode())).findFirst().orElse(new ZzRyjbxx());
            RsRyjbxxfb rsRyjbxxfb = dbRsRyjbxxfbList.stream().filter(it -> it.getRybm().equals(item.getUserCode())).findFirst().orElse(new RsRyjbxxfb());
            ZzZzqkxx party = zzZzqkxxList.stream().filter(it -> it.getDzzmc().equals(item.getPartyName())).findFirst().orElse(null);
            CfUsers cfUsers = dbCfUsersList.stream().filter(it -> it.getUserid().equals(item.getUserCode())).findFirst().orElse(new CfUsers());

            String errorInfo = "";
            Date birthDate = dateUtils.strToDateExt(item.getBirthDate());

            if (stringUtils.IsNullOrEmpty(item.getUserName()))
                errorInfo += "请填写姓名!";
            if (stringUtils.IsNullOrEmpty(item.getUserCode()))
                errorInfo += "请填写学号/工号!";
            if (stringUtils.IsNullOrEmpty(item.getPartyName()))
                errorInfo += "请填写所属党支部名称!";
            if (stringUtils.IsNullOrEmpty(item.getBirthDate()))
                errorInfo += "请填写出生日期!";
            if (party == null)
                errorInfo += "所属党支部名称匹配失败!";
            if (!stringUtils.IsNullOrEmpty(item.getBirthDate()) && birthDate == null)
                errorInfo += "出生日期格式错误!";

            if (stringUtils.IsNullOrEmpty(errorInfo)) {
                ggZgjbxx.setRybm(item.getUserCode());
                ggZgjbxx.setXm(item.getUserName().replaceAll("\\s+", ""));
                ggZgjbxx.setXb(item.getSex().equals("男") ? "1" : "2");
                ggZgjbxx.setCsrq(birthDate);

                if (stringUtils.IsNullOrEmpty(zzRyjbxx.getRyjbxxbs()))
                    zzRyjbxx.setRyjbxxbs(UUID.randomUUID().toString());
                zzRyjbxx.setRybm(item.getUserCode());
                zzRyjbxx.setSzdzbdm(party.getDzzdm());
                if (stringUtils.IsNullOrEmpty(zzRyjbxx.getRyzt()))
                    zzRyjbxx.setRyzt("9");

                rsRyjbxxfb.setRybm(item.getUserCode());
                rsRyjbxxfb.setMobile(item.getContactMobile());

                cfUsers.setUserid(item.getUserCode());
                cfUsers.setApplicationid("f0c4fa7f9f3c4fb6bd56aac608b7ad3f");
                cfUsers.setIsanonymous(1);
                if (stringUtils.IsNullOrEmpty(cfUsers.getUserpwd()))
                    cfUsers.setUserpwd("D6FB6D8741F9AF9E7BC1C39E79D73944");
                if (stringUtils.IsNullOrEmpty(cfUsers.getUsername()))
                    cfUsers.setUsername(item.getUserCode());

                ggZgjbxxList.add(ggZgjbxx);
                zzRyjbxxList.add(zzRyjbxx);
                rsRyjbxxfbList.add(rsRyjbxxfb);
                cfUsersList.add(cfUsers);

            } else {
                item.setErrorInfo("第" + (i + 1) + "行，" + errorInfo);
                errorList.add(item);
            }
        }

        if (errorList.size() <= 0) {
            ggZgjbxxList.forEach(item -> {
                if (dbGgZgjbxxList.stream().filter(it -> it.getRybm().equals(item.getRybm())).count() == 0) {
                    ggZgjbxxMapper.insert(item);
                } else {
                    GgZgjbxxExample exp = new GgZgjbxxExample();
                    GgZgjbxxExample.Criteria cri = exp.or().andRybmEqualTo(item.getRybm());
                    ggZgjbxxMapper.updateByExample(item, exp);
                }
            });
            zzRyjbxxList.forEach(item -> {
                if (dbZzRyjbxxList.stream().filter(it -> it.getRybm().equals(item.getRybm())).count() == 0) {
                    zzRyjbxxMapper.insert(item);
                } else {
                    ZzRyjbxxExample exp = new ZzRyjbxxExample();
                    ZzRyjbxxExample.Criteria cri = exp.or().andRybmEqualTo(item.getRybm());
                    zzRyjbxxMapper.updateByExample(item, exp);
                }
            });
            rsRyjbxxfbList.forEach(item -> {
                if (dbRsRyjbxxfbList.stream().filter(it -> it.getRybm().equals(item.getRybm())).count() == 0) {
                    rsRyjbxxfbMapper.insert(item);
                } else {
                    rsRyjbxxfbMapper.updateByPrimaryKey(item);
                }
            });
            cfUsersList.forEach(item -> {
                if (dbCfUsersList.stream().filter(it -> it.getUserid().equals(item.getUserid())).count() == 0) {
                    cfUsersMapper.insert(item);
                } else {
                    cfUsersMapper.updateByPrimaryKey(item);
                }

                if (dbCfUserroleList.stream().filter(it -> it.getUserid().equals(item.getUserid()) && it.getRoleid().equals(this.massesRoleId)).count() == 0) {
                    CfUserrolesKey cfUserrolesKey = new CfUserrolesKey();
                    cfUserrolesKey.setUserid(item.getUserid());
                    cfUserrolesKey.setRoleid(this.massesRoleId);
                    cfUserrolesMapper.insert(cfUserrolesKey);
                }
            });
        }

        return errorList;
    }

    public CfUsers login(String account, String password) {
        CfUsersExample exp = new CfUsersExample();
        CfUsersExample.Criteria cri = exp.or();
        cri.andUsernameEqualTo(account.trim());
        cri.andUserpwdEqualTo(password.trim());

        return cfUsersMapper.selectByExample(exp).stream().findFirst().orElse(null);
    }

    public CfUsers loginByWxUserId(String wxUserId) {
        CfUsersExample exp = new CfUsersExample();
        CfUsersExample.Criteria cri = exp.or();
        cri.andWxuseridEqualTo(wxUserId.trim());

        return cfUsersMapper.selectByExample(exp).stream().findFirst().orElse(null);
    }

    public void bindWxUserId(String userId, String wxUserId) {
        CfUsers cfUsers = cfUsersMapper.selectByPrimaryKey(userId);
        cfUsers.setWxuserid(wxUserId);

        cfUsersMapper.updateByPrimaryKey(cfUsers);
    }
}
