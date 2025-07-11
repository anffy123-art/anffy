package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.IntegratedQueryCQuery;
import com.px.partybuild.service.IntegratedQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("integrateQueryService")
public class IntegratedQueryServiceImpl implements IntegratedQueryService {
    @Autowired
    private IntegratedQueryCQuery integratedQueryCquery;

    @Override
    public PageInfo<HashMap<String, Object>> getDepartmentAdvanceList(int pageNum, int pageSize, String dzzmc, String[] zzlb, String[] jczzfl, String jldzzrqStart, String jldzzrqEnd, String gjjmrqStart, String gjjmrqEnd, Integer memberCountStart, Integer memberCountEnd, Integer djkpxxYear, Integer[] judgeLevel, Integer honourYear, Integer honourlevel, Integer[] honourType
            , Integer djkpxxYearDzb, Integer[] judgeLevelDzb,String dzzdm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = integratedQueryCquery.departmentAdvanceList(dzzmc, zzlb, jczzfl, jldzzrqStart, jldzzrqEnd, gjjmrqStart, gjjmrqEnd, memberCountStart, memberCountEnd,
                djkpxxYear, judgeLevel, honourYear, honourlevel, honourType, djkpxxYearDzb, judgeLevelDzb,dzzdm);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }
}
