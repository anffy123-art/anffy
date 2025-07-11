package com.px.partybuild.controller;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.CfMenu;
import com.px.partybuild.model.CfRoles;
import com.px.partybuild.service.MenuManageService;
import com.px.partybuild.service.RoleService;
import com.px.partybuild.service.UserService;
import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/userrole")
public class UserRoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuManageService menuManageService;
    @Autowired
    private UserService userService;
    @Autowired
    private StringUtils stringUtils;

    @ResponseBody
    @GetMapping("/GetRoleList")
    public RequsetData<PageInfo<CfRoles>> GetRoleList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam("appid") String appId, @RequestParam("rolename") String roleName, @RequestParam("userId") String userId) {
        RequsetData<PageInfo<CfRoles>> res = new RequsetData<>();
        res.setItem(roleService.getRoleList(pageIndex, pageSize, appId, roleName, userId));
        return res;
    }

    @ResponseBody
    @GetMapping("/GetRolesById")
    public RequsetData<List<CfRoles>> GetRolesById(@RequestParam("appid") String appId, @RequestParam("userId") String userId) {
        RequsetData<List<CfRoles>> res = new RequsetData<>();
        //res.setItem(roleService.GetRoleList(pageIndex, pageSize, appId, roleName,userId));
        res.setItem(roleService.getRolesByUid(userId));
        return res;
    }


    @ResponseBody
    @GetMapping("/getMenuList")
    public RequsetData<List<CfMenu>> GetMenuList(@RequestParam("appid") String appId) {
        RequsetData<List<CfMenu>> res = new RequsetData<List<CfMenu>>();
        res.setItem(menuManageService.getMenuList(appId));
        return res;
    }

    @ResponseBody
    @GetMapping("/getRoleMenu")
    public RequsetData<CfRoles> GetRoleMenu(@RequestParam("id") String Id) {
        RequsetData<CfRoles> res = new RequsetData<CfRoles>();
        res.setItem(roleService.getRoleById(Id));
        Map<String, Object> extData = new HashMap<String, Object>();
        extData.put("array", roleService.getMenuIdsByRoleId(Id));
        res.setExtdata(extData);
        //GetRoleUserList
        return res;
    }

    @ResponseBody
    @GetMapping("/GetRoleUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> GetRoleUserList(@RequestParam("roleId") String roleId, @RequestParam("name") String name, @RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize) {
        RequsetData<PageInfo<HashMap<String, Object>>> res = new RequsetData<>();
        res.setItem(roleService.getRoleUserList(roleId, name, pageIndex, pageSize));
        //GetRoleUserList
        return res;
    }

    @ResponseBody
    @PostMapping("/SaveRoleList")
    public RequsetData<String> SaveRoleList(@RequestBody HashMap<String, Object> form) {
        RequsetData<String> res = new RequsetData<String>();
        String roleId = "", menuIds = "";
        if (form.get("roleId") != null) {
            roleId = form.get("roleId").toString();
        }
        if (form.get("menuIds") != null) {
            menuIds = form.get("menuIds").toString();
        }

        CfRoles roles = new CfRoles();
        roles.setRoleid(roleId);
        roles.setApplicationid(form.get("applicationId").toString());
        roles.setRolename(form.get("roleName").toString());
        roles.setDescription(form.get("description").toString());
        roles.setGroupby(form.get("groupby").toString());
        roles.setOrderby(form.get("orderby") != null ? Integer.parseInt(form.get("orderby").toString()) : null);
        roles.setDictionaryid(form.get("dictionaryid").toString());
        roleId = roleService.saveRole(roles);

        int addCount = roleService.SaveRoleList(roleId, menuIds);
        if (addCount > 0) {
            res.setMsg("添加成功了" + addCount + "条！");
            res.setSuccess(true);
        } else {
            res.setSuccess(false);
            res.setMsg("添加失败！");
        }
        return res;
    }

    //deleteRole
    @ResponseBody
    @GetMapping("/deleteRole")
    public RequsetData<String> deleteRole(@RequestParam("roleId") String roleId) {
        RequsetData<String> res = new RequsetData<>();

        String delMsg = roleService.deleteRole(roleId);
        if (stringUtils.IsNullOrEmpty(delMsg)) {
            res.setMsg("删除成功");
            res.setSuccess(true);
        } else {
            res.setMsg(delMsg);
            res.setSuccess(false);
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/GetRoleNameByUserId")
    public List<String> GetRoleNameByUserId(@RequestParam("userId") String userId) {
        return this.roleService.getRoleNameByUserId(userId);
    }

    @ResponseBody
    @GetMapping("/GetRoleByUserName")
    public List<HashMap<String, Object>> GetRoleNameByUserName(@RequestParam("userName") String userName) {
        return this.roleService.getRoleByUserName(userName);
    }

    @ResponseBody
    @GetMapping("/getRoleByUserId")
    public RequsetData<List<HashMap<String, Object>>> GetRoleByUserId(@RequestParam("userId") String userId) {
        RequsetData<List<HashMap<String, Object>>> res = new RequsetData<>();
        res.setItem(userService.getRoleByUserId(userId));
        return res;
    }
}
