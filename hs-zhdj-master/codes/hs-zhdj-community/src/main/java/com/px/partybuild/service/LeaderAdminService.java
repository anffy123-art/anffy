package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

public interface LeaderAdminService {

    PageInfo<HashMap<String, Object>> getLeaderadminList(int pageIndex, int pageSize, String userName);

    int save(List<String> userIdList, String userId);

    int delete(List<String> userIdList);

    boolean isAdmin(String userId);
}
