package com.px.partybuild.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.px.partybuild.AppConfig;
import com.px.partybuild.controller.jsonmodel.DesModel;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.mapper.CfUsersMapper;
import com.px.partybuild.mapper.CfUsersinfoMapper;
import com.px.partybuild.model.CfOudetail;
import com.px.partybuild.model.CfUsers;
import com.px.partybuild.model.CfUsersinfo;
import com.px.partybuild.model.ZzZzqkxx;
import com.px.partybuild.service.CommonService;
import com.px.partybuild.service.PartyService;
import com.px.partybuild.service.PartyUserService;
import com.px.partybuild.service.UserService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.JsonMapper;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private CfUsersinfoMapper cfUsersinfoMapper;

    @Autowired
    private CfUsersMapper cfUsersMapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    private PartyService partyService;

    @Autowired
    PartyUserService partyUserService;

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int AddUser(CfUsers cUser) {
        return userService.addUser(cUser);
    }

    @RequestMapping(value = "/get/{id}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public CfUsers getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }

    @GetMapping("/addtest")
    @ResponseBody
    public int addTest() {

        CfUsers cfUsers = new CfUsers();

        cfUsers.setUserid(UUID.randomUUID().toString());
        cfUsers.setApplicationid("7465c53e-831d-11e8-baaa-001517ca1f2c");
        cfUsers.setUsername("admin");
        cfUsers.setIsanonymous(0);
        cfUsers.setLastactivitydate(new Date());
        return userService.addUser(cfUsers);
    }

    @GetMapping("/testlist")
    @ResponseBody
    public int getlist() {

        return userService.procUpdatePartyusercount();
    }

    @GetMapping("/curloginuser")
    @ResponseBody
    public RequsetData<CfUsersinfo> GetCurloginUser(ServletRequest request, @RequestParam("appkey") String appkey) {

        RequsetData<CfUsersinfo> res = new RequsetData<CfUsersinfo>();

        try {

            Map<String, Object> extData = new HashMap<>();

            //UserLoginId字符串拿的JwtFilter设置值
            //Map<String,Object> curMapUser=userService.canLoginApp(request.getAttribute("UserLoginId").toString());
            //CfUsersinfo curUser = mapUtils.mapToObject(curMapUser,CfUsersinfo.class);
            CfUsers loginUser = userService.getUser(request.getAttribute("UserLoginId").toString());
            CfUsersinfo curUser = userService.getUserInfobyId(loginUser.getUserid());

            //String companyId = userService.GetUserCompanyIdByUserId(loginUser.getUserid());
            //String companyId=userService.GetUserCompanyIdByUserId(loginUser.getUserid());
            //List<HashMap<String, Object>> companys = companyService.SelectCompanyBysUserId(loginUser.getUserid());
            Map<String, Object> userPartyInfo = userService.extendUserPartyInfo(loginUser.getUserid());
            if (userPartyInfo.size() > 0) {
                curUser.setDpcode(userPartyInfo.get("DZZDM") != null ? userPartyInfo.get("DZZDM").toString() : "");//所属组织代码
                curUser.setDpname(userPartyInfo.get("DZZMC") != null ? userPartyInfo.get("DZZMC").toString() : "");//所属组织名称
                curUser.setParentdpid(userPartyInfo.get("PARENTCODE") != null ? userPartyInfo.get("PARENTCODE").toString() : "");//组织父级代码

                if (!stringUtils.IsNullOrEmpty(curUser.getParentdpid())) {
                    ZzZzqkxx zzZzqkxx = partyService.getPartyByDm(curUser.getParentdpid());
                    if (zzZzqkxx != null) {
                        curUser.setDpfullname(zzZzqkxx.getDzzmc());//组织父级名称
                    }
                }


                if (!stringUtils.IsNullOrEmpty(curUser.getDpcode())) {
                    ZzZzqkxx zzZzqkxx = partyService.getUserDwInfo(curUser.getDpcode());
                    extData.put("dwId", zzZzqkxx != null ? zzZzqkxx.getDzzdm() : "");//所属党委id
                    extData.put("dwName", zzZzqkxx != null ? zzZzqkxx.getDzzmc() : "");//所属党委
                }

            }



            /*
            if (companys.size() > 0 && appkey.equals("appId")) {
                //限制企业用户登陆园区端
                res.setSuccess(false);
                res.setMsg("企业用户只能登陆到企业端！");
                extData.put("reEnt", 1);
                res.setExtdata(extData);
                return res;
            }
            //companyId
            if (companys.size() > 0) {
                extData.put("companys", companys);
            }
            */

            /*extData.put("dataDzzdm", userService.getUserDzzdmForShowData(curUser.getId(), roleId));//数据范围*/
            extData.put("gddwdm", appConfig.gddwdm);//广东党委代码
            /*extData.put("dataScope", userService.getUserDataScope(curUser.getId(), roleId));//数据范围*/
            extData.put("oaUserId", loginUser.getOauserid());
            extData.put("oaIdCard", loginUser.getOausersfz());

            //HashMap<String, Object> partyUserInfo = partyUserService.getPartyUserInfoByRybm(curUser.getId());
            HashMap<String, Object> partyUserInfo = partyUserService.getPartyUserExt(curUser.getId());
            if (partyUserInfo != null) {
                extData.put("userType", partyUserInfo.get("USERTYPE"));//1站内，2路外
                ZzZzqkxx generalParty = partyUserInfo.get("SZDZBDM") != null ? partyService.getUserGeneralPartyInfo(partyUserInfo.get("SZDZBDM").toString()) : null;
                extData.put("generalPartyCode", generalParty == null ? "" : generalParty.getDzzdm());//1站内，2路外
            }

            if (curUser != null) {
                //extData.put("isServerMan", gsIMsgService.isServerMan(curUser.getId()));
                res.setItem(curUser);

                res.setMsg("用户登陆成功！");
            } else {
                res.setSuccess(false);
                res.setMsg("用户未登陆！");
            }

            res.setExtdata(extData);

            //更新lastActivityDate
            loginUser.setLastactivitydate(new Date());
            userService.updateLastActivityDate(loginUser);

        } catch (Exception ex) {
            res.setMsg("错误：" + ex.getMessage());
            res.setSuccess(false);
        }

        return res;
    }


    @PostMapping("/getmenubyuid")
    @ResponseBody
    public RequsetData<List<HashMap<String, Object>>> GetMenuByUid(@RequestBody Map<String, Object> reqMap) throws NoSuchFieldException {

        RequsetData<List<HashMap<String, Object>>> res = new RequsetData<List<HashMap<String, Object>>>();
        String appId = appConfig.getConfig(reqMap.get("appkey").toString());
        //List<HashMap<String, Object>> items = userService.getMenuByUserId(reqMap.get("uid").toString(), appId);
        List<HashMap<String, Object>> items = userService.getMenuByRoleId(reqMap.get("roleId").toString(), appId, reqMap.get("dwId") != null ? reqMap.get("dwId").toString() : "");
        res.setItem(items);

        return res;
    }



    @PostMapping("/GetDpListByParentID")
    @ResponseBody
    public RequsetData<List<CfOudetail>> GetDpListByParentID(@RequestBody HashMap<String, Object> form) {
        RequsetData<List<CfOudetail>> res = new RequsetData<List<CfOudetail>>();

        String parentDPID = "";

        if (form.get("parentDPID") != null) {
            parentDPID = form.get("parentDPID").toString();

        }
        res.setItem(userService.getDpListByParentID(parentDPID));

        return res;
    }

    @GetMapping("/GetUserListByDpID")
    @ResponseBody
    public RequsetData<List<CfUsersinfo>> GetUserListByDpID(@RequestParam(required = false) String dpId, @RequestParam(required = false) String userName) {
        RequsetData<List<CfUsersinfo>> res = new RequsetData<List<CfUsersinfo>>();
        res.setItem(userService.getUserListByDpID(dpId, userName));

        return res;
    }


    @GetMapping("/SaveUserRoleList")
    @ResponseBody
    public RequsetData<String> SaveUserRoleList(@RequestParam("roleId") String roleId, @RequestParam("userIds") String userIds, @RequestParam(required = false) boolean isRemoveRole) {
        RequsetData<String> res = new RequsetData<String>();

        int addCount = userService.saveUserRoleList(roleId, userIds, isRemoveRole);

        if (addCount > 0) {
            res.setSuccess(true);
            res.setMsg("添加成功了" + addCount + "条数据!");
        } else {
            res.setSuccess(false);
            res.setMsg("添加失败！");
        }

        return res;
    }


    //deleteUserRole

    @GetMapping("/deleteUserRole")
    @ResponseBody
    public RequsetData<String> DeleteUserRole(@RequestParam("roleId") String roleId, @RequestParam("userId") String userId) {
        RequsetData<String> res = new RequsetData<String>();
        int delCount = userService.deleteUserRole(roleId, userId);
        if (delCount > 0) {
            res.setSuccess(true);
            res.setMsg("删除成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("删除失败！");
        }
        return res;
    }

    /*@ResponseBody
    @RequestMapping("/getUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getUserList(@RequestParam(required = false) int pageindex, @RequestParam(required = false) int pagesize,
                                                                      @RequestParam(required = false) String username) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(userService.getUserList(pageindex, pagesize, username));
        return result;
    }*/

    @ResponseBody
    @RequestMapping("/getUserByID")
    public RequsetData<CfUsersinfo> getUserByID(@RequestParam("id") String id) {
        RequsetData<CfUsersinfo> res = new RequsetData<>();
        CfUsersinfo model = userService.getUserInfobyId(id);
        if (model == null || stringUtils.IsNullOrEmpty(model.getId())) {
            UUID uuid = UUID.randomUUID();
            model = new CfUsersinfo();
            model.setId(uuid.toString());
            model.setIsenable(1);
        }

        CfUsers user = userService.getUser(model.getId());
        if (user == null || stringUtils.IsNullOrEmpty(user.getUserid())) {
            UUID uuid = UUID.randomUUID();
            user = new CfUsers();
            user.setUserid(model.getId());
        }
        Map<String, Object> extData = new HashMap<String, Object>();
        extData.put("userModel", user);
        //extData.put("userParks", userService.GetUserParkList(model.getId()));
        res.setExtdata(extData);

        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/getUserByUserName")
    public RequsetData<CfUsersinfo> getUserByUserName(@RequestParam("username") String userName) {
        String uid = userService.getUserByUserName(userName);
        return getUserByID(uid);
    }

    @ResponseBody
    @RequestMapping("/saveUser")
    public RequsetData<String> saveUser(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String msg = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            CfUsersinfo cfUsersinfo = mapper.readValue(mapper.writeValueAsString(reqMap.get("userInfoModel")).toString(), CfUsersinfo.class);
            CfUsers cfUsers = mapper.readValue(mapper.writeValueAsString(reqMap.get("userModel")).toString(), CfUsers.class);
            String parkIds = reqMap.get("parkIds").toString();
            Integer type = Integer.parseInt(reqMap.get("type").toString());

            cfUsersinfo.setUserligion(cfUsers.getUsername());
            if (type == 0) {
                cfUsers.setUserpwd(DigestUtils.md5DigestAsHex(cfUsers.getUserpwd().getBytes()).toUpperCase());
            }
            CfUsers userModel = userService.getUserByKey(cfUsers.getUsername());
            if (userModel != null && !stringUtils.IsNullOrEmpty(userModel.getUserid()) && !userModel.getUserid().equals(cfUsers.getUserid())) {
                throw new Exception("账号已存在，请修改！");
            }

            count = userService.saveUser(cfUsers, cfUsersinfo, parkIds);


        } catch (Exception e) {

            e.printStackTrace();
            msg = e.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！" + msg);
        }
        return res;
    }

    @ResponseBody
    @RequestMapping("/enableUser")
    public RequsetData<String> enableUser(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String msg = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            String id = reqMap.get("id").toString();
            Integer enable = Integer.parseInt(reqMap.get("enable").toString());

            CfUsersinfo cfUsersinfo = userService.getUserInfobyId(id);
            if (cfUsersinfo != null && !stringUtils.IsNullOrEmpty(cfUsersinfo.getId())) {
                cfUsersinfo.setIsenable(enable);
                count = cfUsersinfoMapper.updateByPrimaryKey(cfUsersinfo);
            }

        } catch (Exception e) {

            e.printStackTrace();
            msg = e.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！" + msg);
        }
        return res;
    }

    @ResponseBody
    @RequestMapping("/updatePassword")
    public RequsetData<String> updatePassword(HttpServletResponse response, @RequestBody DesModel model, HttpServletRequest request) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String msg = "";
        ObjectMapper mapper = new ObjectMapper();

        try {

            String data = commonService.DesTokenData(model.getToken(), dateUtils.DateToDateTime(model.getTm()));
            String[] loginData = data.split("\\|");

            CfUsers cfUsers = new CfUsers();
            cfUsers.setUserid(loginData[0]);
            cfUsers.setUserpwd(DigestUtils.md5DigestAsHex(loginData[1].getBytes()).toUpperCase());

           /* CfUsers cfUsers = mapper.readValue(mapper.writeValueAsString(reqMap.get("userModel")).toString(), CfUsers.class);
            cfUsers.setUserpwd(DigestUtils.md5DigestAsHex(cfUsers.getUserpwd().getBytes()).toUpperCase());*/

            count = cfUsersMapper.updateByPrimaryKeySelective(cfUsers);


        } catch (Exception e) {

            e.printStackTrace();
            msg = e.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！" + msg);
        }
        return res;
    }

    @ResponseBody
    @GetMapping("/testredis")
    public RequsetData<String> updatePassword(@RequestParam("id") String id) {
        RequsetData<String> res = new RequsetData<>();

        res.setItem(userService.testCache(id));

        return res;
    }

    @ResponseBody
    @GetMapping("/UserPermissionStatus")
    public RequsetData<Boolean> UserPermissionStatus(@RequestParam("code") String code, @RequestParam(value = "roleId", required = false) String roleId, @RequestParam(value = "userDwid", required = false) String userDwid, ServletRequest request) {
        RequsetData<Boolean> res = new RequsetData<>();
        String userName = request.getAttribute("UserLoginId").toString();
        //String userName="";
        if (org.apache.commons.lang3.StringUtils.isNotBlank(userName)) {
            res.setSuccess(userService.userPermissionByCode(code, "", roleId, userDwid));
            res.setItem(res.getSuccess());
        } else {
            res.setSuccess(false);
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/ValidUserInfo")
    public RequsetData<Map<String, Object>> ValidUserInfo(@RequestParam("id") String id) {

        RequsetData<Map<String, Object>> res = new RequsetData<>();

        try {
            //CfUsers user = userService.getUserByKey(id);
            Map<String, Object> user = userService.canLoginApp(id);
            if (user != null) {
                //CfUsers userlogin = userService.getUserByKey(user.get("id").toString());
                user.putAll(userService.extendUserPartyInfo((String) user.get("id")));
                //user.putAll(userService.extendUserDxzInfo((String) user.get("userappinfoid")));
                user.put("userid", user.get("id"));
                user.put("username", user.get("name"));
                res.setItem(user);

            } else {
                res.setSuccess(false);
                res.setMsg("无相关用户！");
            }
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("读取用户信息报错：" + ex.getMessage());
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/getUserByUserid")
    public RequsetData<Map<String, Object>> getUserByUserid(@RequestParam("userid") String userid) {

        RequsetData<Map<String, Object>> res = new RequsetData<>();

        try {
            CfUsersinfo user = userService.getUserInfobyId(userid);
            if (user != null) {
                res.setItem(mapUtils.objectToMap(user));
            } else {
                res.setSuccess(false);
                res.setMsg("无相关用户！");
            }
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("读取用户信息报错：" + ex.getMessage());
        }

        return res;
    }


    @ResponseBody
    @GetMapping("/getPartyUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> GetPartyUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                           @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String rybm, @RequestParam(required = false) String xm,
                                                                           @RequestParam(required = false) String userIds, @RequestParam(required = false) String removeUsers, @RequestParam(required = false) String szdzbdm
            , @RequestParam(required = false) String removeUsers_rybm, @RequestParam(required = false) String rybm_list, @RequestParam(required = false) String partyGroupId) {

        List<String> userIdList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(userIds)) {
            userIdList = java.util.Arrays.asList(userIds.split(","));
        }

        List<String> removeUserList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(removeUsers)) {
            removeUserList = java.util.Arrays.asList(removeUsers.split(","));
        }

        List<String> removeUsersOfRybmList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(removeUsers_rybm)) {
            removeUsersOfRybmList = java.util.Arrays.asList(removeUsers_rybm.split(","));
        }

        List<String> rybmList = new ArrayList<>();

        if (!stringUtils.IsNullOrEmpty(rybm_list)) {
            rybmList = java.util.Arrays.asList(rybm_list.split(","));
        }

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getPartyUserList(pageIndex, pageSize, null, dzzdm, rybm, xm, null, null, null, null, null, null,
                userIdList, null, removeUserList, szdzbdm, removeUsersOfRybmList, rybmList, null, null, null, null, null, null, null, null, null, null, rybm, partyGroupId, null,null,null));
        return result;
    }

    /**
     * @Description //TODO 查询党小组成员
     * @date 2024-08
     * @Param [pageIndex, pageSize, dzzdm, rybm, xm, zzlb, zwjb, sqrdrq_begin, sqrdrq_end, szdzb, szdxz]
     **/
    @ResponseBody
    @GetMapping("/getDxzUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> GetDxzUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                         @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String rybm, @RequestParam(required = false) String xm, @RequestParam(required = false) String zzlb,
                                                                         @RequestParam(required = false) String zwjb, @RequestParam(required = false) String sqrdrq_begin, @RequestParam(required = false) String sqrdrq_end
            , @RequestParam(required = false) String szdzb, @RequestParam(required = false) String szdxz, @RequestParam(required = false) String removeUsers
            , @RequestParam(required = false) String removeUsers_rybm) {

        sqrdrq_begin = dateUtils.strFormat_short(sqrdrq_begin);
        sqrdrq_end = dateUtils.strFormat_short(sqrdrq_end);

        List<String> removeUserList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(removeUsers)) {
            removeUserList = java.util.Arrays.asList(removeUsers.split(","));
        }

        List<String> removeUsersOfRybmList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(removeUsers_rybm)) {
            removeUsersOfRybmList = java.util.Arrays.asList(removeUsers_rybm.split(","));
        }

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getDxzUserList(pageIndex, pageSize, dzzdm, rybm, xm, zzlb, zwjb, sqrdrq_begin, sqrdrq_end, szdzb, szdxz, removeUserList, removeUsersOfRybmList));
        return result;
    }

    /**
     * @Description //TODO 查询支委会开会领导信息
     * @date 2024-08
     * @Param [pageIndex, pageSize, rybm, xm, szdzbdm, removeUsers_rybm]
     **/
    @ResponseBody
    @GetMapping("/getLeaderUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> GetLeaderUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                            @RequestParam(required = false) String dzzdm,
                                                                            @RequestParam(required = false) String szdzbdm, @RequestParam(required = false) String rybm, @RequestParam(required = false) String xm,
                                                                            @RequestParam(required = false) String removeUsers_rybm) {

        List<String> removeUsersOfRybmList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(removeUsers_rybm)) {
            removeUsersOfRybmList = java.util.Arrays.asList(removeUsers_rybm.split(","));
        }

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getLeaderUserList(pageIndex, pageSize, dzzdm, szdzbdm, rybm, xm, null, null, removeUsersOfRybmList));
        return result;
    }

    @ResponseBody
    @GetMapping("/getPartyInfo")
    public RequsetData<Map<String, Object>> getPartyInfo(@RequestParam("id") String id) {

        RequsetData<Map<String, Object>> res = new RequsetData<>();

        try {
            Map<String, Object> item = userService.extendUserPartyMore(id);
            res.setItem(item);
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/getPartyTreeList")
    public RequsetData<List<HashMap<String, Object>>> GetPartyTreeList(@RequestParam("parentCode") String parentCode, @RequestParam(required = false) String isshowxz, @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String userId,
                                                                       @RequestParam(required = false) Integer onlyshow_dw, @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) Integer showlevel) {
        List<HashMap<String, Object>> partyList = partyService.getPartyTreeList(parentCode, dzzdm, showlevel);
        RequsetData<List<HashMap<String, Object>>> res = new RequsetData<>();
        res.setItem(partyList);
        return res;
    }

    @GetMapping("/getUserDataScope")
    @ResponseBody
    public Map<String, Object> getUserDataScope(@RequestParam("userId") String userId, @RequestParam(required = false) String roleId) {
        Map<String, Object> result = new HashMap<>();
        result.put("dataDzzdm", userService.getUserDzzdmForShowData(userId, roleId));//数据范围
        result.put("dataScope", userService.getUserDataScope(userId, roleId));//数据范围
        return result;
    }

    @GetMapping("/getUserOnline")
    @ResponseBody
    public RequsetData<PageInfo<Map<String, Object>>> getUserOnline(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam(required = false) String username) {
        RequsetData<PageInfo<Map<String, Object>>> result = new RequsetData<>();
        try {
            PageInfo<Map<String, Object>> list = userService.getUserOnline(pageIndex, pageSize, username);
            result.setItem(list);
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMsg("列表获取失败");
            log.error("getUserOnline错误！", ex);
        }

        return result;
    }

    @PostMapping("/forceLoginOut")
    @ResponseBody
    public RequsetData<Integer> forceLoginOut(@RequestBody Map<String, Object> reqMap) {
        RequsetData<Integer> res = new RequsetData<>();

        try {
            //查看登录用户上次登录日期
            String uid = reqMap.get("uid").toString();
            int row = userService.loginForceStatu(uid, 1);
            res.setItem(row);


        } catch (Exception ex) {
            log.error("getUserOnline错误！", ex);
            res.setMsg("数据库异常：" + ex.getMessage());
            res.setSuccess(false);
        }


        return res;
    }


    @ResponseBody
    @RequestMapping("/deleteUserInfo")
    public RequsetData<String> deleteUserInfo(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String msg = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            String mobile = reqMap.get("mobile").toString();

            String userId = userService.mobiltToUserId(mobile);

            HashMap<String, Object> userInfo = partyUserService.getPartyUserInfoByRybm(userId);
            if (userInfo != null && userInfo.get("RYBM") != null) {
                throw new Exception("党员信息未删除");
            }

            count = userService.deleteUserById(userId);

        } catch (Exception e) {

            e.printStackTrace();
            msg = e.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("清除成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("清除失败！" + msg);
        }
        return res;
    }


    @ResponseBody
    @RequestMapping("/importUser")
    public RequsetData<List<UserInfoVo>> importUser(@RequestBody Map<String, Object> reqMap) {
        RequsetData<List<UserInfoVo>> res = new RequsetData<>();
        List<UserInfoVo> errorInfo = new ArrayList<>();
        String message = "";
        try {

            List<UserInfoVo> userList = JsonMapper.jsonToObject(reqMap.get("userList").toString(), new TypeReference<List<UserInfoVo>>() {
            });

            errorInfo = userService.importUser(userList);

        } catch (Exception e) {
            e.printStackTrace();
            message = e.toString();
        }
        if (errorInfo.size() <= 0 && stringUtils.IsNullOrEmpty(message)) {
            res.setSuccess(true);
            res.setMsg("操作成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("操作失败！" + message);
            res.setItem(errorInfo);
        }
        return res;
    }


}
