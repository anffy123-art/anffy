package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.CFLeaderAdminCQuery;
import com.px.partybuild.mapper.CfLeaderadminMapper;
import com.px.partybuild.model.CfLeaderadmin;
import com.px.partybuild.model.CfLeaderadminExample;
import com.px.partybuild.service.LeaderAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("LeaderAdminService")
public class LeaderAdminServiceImpl implements LeaderAdminService {

    @Autowired
    private CFLeaderAdminCQuery cfLeaderAdminCQuery;

    @Autowired
    private CfLeaderadminMapper cfLeaderadminMapper;

    @Override
    public PageInfo<HashMap<String, Object>> getLeaderadminList(int pageIndex, int pageSize, String userName) {

        PageHelper.startPage(pageIndex, pageSize);
        List<HashMap<String, Object>> list = cfLeaderAdminCQuery.selectLeaderadminList(userName);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);

        return result;
    }

    @Override
    public int save(List<String> userIdList, String userId) {
        int result = 0;

        CfLeaderadminExample exp = new CfLeaderadminExample();
        CfLeaderadminExample.Criteria cri = exp.or();
        cri.andUseridIn(userIdList);
        List<CfLeaderadmin> dbList = cfLeaderadminMapper.selectByExample(exp);

        for (int i = 0; i < userIdList.size(); i++) {
            String rybm = userIdList.get(i);

            if (dbList.stream().filter(e -> e.getUserid().equals(rybm)).count() <= 0) {
                CfLeaderadmin cfLeaderadmin = new CfLeaderadmin();
                cfLeaderadmin.setUserid(rybm);
                cfLeaderadmin.setCreatetime(new Date());
                result += cfLeaderadminMapper.insert(cfLeaderadmin);
            }
        }

        return result;
    }

    @Override
    public int delete(List<String> userIdList) {
        CfLeaderadminExample exp = new CfLeaderadminExample();
        CfLeaderadminExample.Criteria cri = exp.or();
        cri.andUseridIn(userIdList);

        return cfLeaderadminMapper.deleteByExample(exp);
    }

    @Override
    public boolean isAdmin(String userId){
        return cfLeaderadminMapper.selectByPrimaryKey(userId)!=null;
    }

}
