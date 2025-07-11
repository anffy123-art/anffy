package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.AppConfig;
import com.px.partybuild.mapper.CfRolesMapper;
import com.px.partybuild.mapper.CfUserrolesMapper;
import com.px.partybuild.mapper.ZzDzzglyMapper;
import com.px.partybuild.model.*;
import com.px.partybuild.service.DzzglyService;
import com.px.partybuild.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("dzzglyService")
public class DzzglyServiceImpl implements DzzglyService {

    @Autowired
    private ZzDzzglyMapper zzDzzglyMapper;

    @Resource
    private UserService userService;

    @Resource
    private CfUserrolesMapper cfUserrolesMapper;

    @Resource
    private CfRolesMapper cfRolesMapper;

    @Autowired
    AppConfig appConfig;

    @Override
    public PageInfo<ZzDzzgly> list( String dwName) {
        //List<ZzDzzgly> list = zzDzzglyMapper.list(dwName);
        //PageInfo<ZzDzzgly> page = new PageInfo<>(list);
        //return page;
        return null;
    }
    @Override
    public PageInfo<ZzDzzgly> listChooseDW() {
        //List<ZzDzzgly> list = zzDzzglyMapper.listChooseDW();
        //PageInfo<ZzDzzgly> page = new PageInfo<>(list);
        //return page;
        return null;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(ZzDzzgly dzzgly) {
        CfUsers user = userService.getLoginUser();
        //ZzDzzgly model = this.zzDzzglyMapper.selectDzzglyInfo(null, dzzgly.getDzzdm());
        ZzDzzgly model=null;
        int successCount = 0;
        if (dzzgly != null && model == null) {
            successCount = this.zzDzzglyMapper.insert(dzzgly);
            saveUserRole(dzzgly.getLeader());
        } else {
            //编辑
            successCount = this.zzDzzglyMapper.updateByPrimaryKey(dzzgly);
            /**
             * 人员变动删除原角色授权
             * 再新增变更人员授权
             */
            if (!dzzgly.getLeader().equals(model.getLeader())) {
                String roleid = getLeaderRoleId();
                if (roleid != null) {
                    CfUserrolesExample expUr = new CfUserrolesExample();
                    expUr.or().andRoleidEqualTo(roleid).andUseridEqualTo(model.getLeader());
                    cfUserrolesMapper.deleteByExample(expUr);
                }
                saveUserRole(dzzgly.getLeader());
            }
        }
        return successCount;
    }

    /**
     * 授权党委负责人角色
     *
     * @param userId
     */
    private void saveUserRole(String userId) {

        String roleid = getLeaderRoleId();
        if (roleid != null) {
            CfUserrolesKey userRole = new CfUserrolesKey();
            userRole.setUserid(userId);
            userRole.setRoleid(roleid);
            cfUserrolesMapper.insert(userRole);
        }
    }

    /**
     * 获取党委负责人角色ID
     * @return w
     */
    private String getLeaderRoleId() {
        CfRolesExample example = new CfRolesExample();
        example.or().andRolenameEqualTo("基层投稿负责人");
        List<CfRoles> roles = cfRolesMapper.selectByExample(example);
        if (roles.size() > 0) {
            return roles.get(0).getRoleid();
        }
        return null;
    }

    @Override
    public PageInfo<ZzDzzgly> selectUser(int pageIndex, int pageSize, String dzzdm, String userName) {
        PageHelper.startPage(pageIndex, pageSize);
        //List<ZzDzzgly> list = zzDzzglyMapper.selectUser(dzzdm, userName);
        //PageInfo<ZzDzzgly> page = new PageInfo<>(list);
        //return page;
        return null;
    }
    @Override
    public ZzDzzgly selectDzzglyByLoader( String loader){

        //ZzDzzgly model = zzDzzglyMapper.selectDzzglyInfo(loader,null);

        //return model;
        return null;
    }

}
