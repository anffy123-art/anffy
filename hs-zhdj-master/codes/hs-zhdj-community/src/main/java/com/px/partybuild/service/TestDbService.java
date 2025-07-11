package com.px.partybuild.service;

import com.px.partybuild.model.CfApplications;

import java.util.List;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface TestDbService {
    int AddData();

    List<CfApplications> getAppList();
}
