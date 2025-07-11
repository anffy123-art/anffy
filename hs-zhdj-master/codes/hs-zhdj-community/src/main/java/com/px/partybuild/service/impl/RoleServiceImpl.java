package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.CfMenuRoleMapper;
import com.px.partybuild.mapper.CfRolesCQuery;
import com.px.partybuild.mapper.CfRolesMapper;
import com.px.partybuild.mapper.CfUserrolesMapper;
import com.px.partybuild.model.*;
import com.px.partybuild.service.RoleService;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private CfRolesMapper cfRolesMapper;

    @Autowired
    private CfMenuRoleMapper cfMenuRoleMapper;

    @Autowired
    private CfRolesCQuery cfRolesCQuery;

    @Autowired
    private CfUserrolesMapper cfUserrolesMapper;

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private MapUtils mapUtils;

    @Override
    public String saveRole(CfRoles cfRoles) {
        if (stringUtils.IsNullOrEmpty(cfRoles.getRoleid())) {
            cfRoles.setRoleid(UUID.randomUUID().toString());
            cfRolesMapper.insert(cfRoles);
        } else {
            cfRolesMapper.updateByPrimaryKey(cfRoles);
        }

        return cfRoles.getRoleid();
    }

    @Override
    public PageInfo<CfRoles> getRoleList(int pageNum, int pageSize, String appid, String roleName) {
        PageHelper.startPage(pageNum, pageSize);
        CfRolesExample exp = new CfRolesExample();
        CfRolesExample.Criteria criteria1 = exp.or().andApplicationidEqualTo(appid);

        if (roleName != null && roleName.length() > 0) {
            criteria1.andRolenameLike(roleName.trim());
        }
        List<CfRoles> roles = cfRolesMapper.selectByExample(exp);
        PageInfo result = new PageInfo(roles);
        return result;
    }

    @Override
    public PageInfo<CfRoles> getRoleList(int pageNum, int pageSize, String appid, String roleName, String userId) {
        //如果非管理员GetRoleList
        List<HashMap<String, Object>> roleList = cfRolesCQuery.valUserRole(userId, "管理员");

        String roleCondition = "";
        if (roleList.size() == 0) {
            //获取用户所有分组的角色和最大等级
            List<HashMap<String, Object>> userRoles = cfRolesCQuery.getUserRoles(userId);
            if (userRoles.size() > 0) {
                roleCondition = " and (1=2";
                for (HashMap<String, Object> r : userRoles) {
                    roleCondition += " or (GROUPBY='" + r.get("GROUPBY") + "' and orderby<=" + r.get("ORDERBY") + ")";
                }
                roleCondition += ")";
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("groupby asc,orderby desc");
        List<CfRoles> roles = cfRolesCQuery.selectRoleByExample(roleName, roleCondition);
        PageInfo result = new PageInfo(roles);
        return result;
    }

    @Override
    public List<CfRoles> getRolesByUid(String uid) {

        List<CfRoles> roles = cfRolesCQuery.selectRoleByUserid(uid);

        return roles;
    }


    @Override
    public List<String> getMenuIdsByRoleId(String roleId) {
        CfMenuRoleExample exp = new CfMenuRoleExample();
        exp.or().andRoleidEqualTo(roleId);
        List<String> menulist = new ArrayList<String>();
        cfMenuRoleMapper.selectByExample(exp).forEach(it -> menulist.add(it.getMenuid()));
        return menulist;
    }

    @Override
    public CfRoles getRoleById(String roleId) {
        return cfRolesMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public PageInfo<HashMap<String, Object>> getRoleUserList(String roleId,String username, int pageIndex, int pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        List<HashMap<String, Object>> users = cfRolesCQuery.selectRoleUserList(roleId,username);

        return new PageInfo(users);
    }

    @Override
    public int SaveRoleList(String roleId, String menuIds) {

        String[] menuIdArray = menuIds == null ? new String[]{} : menuIds.split(",");
        List<String> menuIdList = Arrays.asList(menuIdArray);
        CfMenuRoleExample expMR = new CfMenuRoleExample();
        expMR.or().andRoleidEqualTo(roleId);
        List<CfMenuRoleKey> exitMR = cfMenuRoleMapper.selectByExample(expMR);

        List<String> exitMRKeyList = new ArrayList<>();
        int changeCount = 1;
        //清除掉差异数据
        for (CfMenuRoleKey exitKey : exitMR) {
            exitMRKeyList.add(exitKey.getMenuid());
            if (!menuIdList.contains(exitKey.getMenuid())) {
                int drow = cfMenuRoleMapper.deleteByPrimaryKey(exitKey);
                if (drow > 0) {
                    changeCount++;
                }
            }
        }
        //新增添加数据
        for (String menuId : menuIdList) {
            if (!exitMRKeyList.contains(menuId)) {
                CfMenuRoleKey cfMenuRole = new CfMenuRoleKey();
                cfMenuRole.setRoleid(roleId);
                cfMenuRole.setMenuid(menuId);
                int irow = cfMenuRoleMapper.insert(cfMenuRole);
                if (irow > 0) {
                    changeCount++;
                }
            }
        }

        return changeCount;
    }

    @Override
    public String deleteRole(String roleId) {
        String result;
        CfUserrolesExample expUr = new CfUserrolesExample();
        expUr.or().andRoleidEqualTo(roleId);
        List<CfUserrolesKey> cfURModel = cfUserrolesMapper.selectByExample(expUr);
        if (cfURModel.isEmpty()) {
            CfMenuRoleExample expMr = new CfMenuRoleExample();
            expMr.or().andRoleidEqualTo(roleId);
            int drowUr = cfMenuRoleMapper.deleteByExample(expMr);
            int drowRole = cfRolesMapper.deleteByPrimaryKey(roleId);
            result = "";

        } else {
            result = "删除角色必需先清理角色下相关人员！";
        }

        return result;
    }

    @Override
    public List<String> getRoleNameByUserId(String userId) {
       // return this.cfUserrolesMapper.GetRoleNameByUserId(userId);
        return null;
    }

    @Override
    public  List<CfUserrolesKey> getRoleUsersByRoleName(String roleName){
        String roleid=getRoleId(roleName);
        CfUserrolesExample expUr = new CfUserrolesExample();
        expUr.or().andRoleidEqualTo(roleid);
        List<CfUserrolesKey> cfURModel = cfUserrolesMapper.selectByExample(expUr);
        return cfURModel;
    }
    private String getRoleId(String roleName) {
        CfRolesExample example = new CfRolesExample();
        example.or().andRolenameEqualTo(roleName);
        List<CfRoles> roles = cfRolesMapper.selectByExample(example);
        if (roles.size() > 0) {
            return roles.get(0).getRoleid();
        }
        return null;
    }

    @Override
    public List<HashMap<String, Object>> getRoleByUserName(String userName) {
        return this.cfRolesCQuery.GetRoleByUserName(userName);
    }

    @Override
    public int insertUserRole(String userName, String roleId) {
        return this.cfRolesCQuery.insertUserRole(userName, roleId);
    }
}
