package com.px.partybuild.service.impl;

import com.px.partybuild.mapper.CfApplicationsMapper;
import com.px.partybuild.model.CfApplications;
import com.px.partybuild.model.CfApplicationsExample;
import com.px.partybuild.service.TestDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author H
 * @date 2024-08
 */
@Service("testDbService")
public class TestDbServiceImpl implements TestDbService {

    @Autowired
    private CfApplicationsMapper cfApplicationsMapper;

    @Override
    public int AddData() {
        CfApplications model = new CfApplications();

        model.setApplicationid(UUID.randomUUID().toString());
        model.setApplicationname("测试");
        model.setDescription("数据库操作");

        return cfApplicationsMapper.insert(model);
    }

    @Override
    public List<CfApplications> getAppList() {

        CfApplicationsExample exp = new CfApplicationsExample();

        List<CfApplications> lists = cfApplicationsMapper.selectByExample(exp);
        return lists;
    }
}
