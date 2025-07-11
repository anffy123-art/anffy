package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;

public interface IntegratedQueryService {

    PageInfo<HashMap<String, Object>> getDepartmentAdvanceList(int pageNum, int pageSize, String dzzmc, String[] zzlb, String[] jczzfl,
                                                               String jldzzrqStart, String jldzzrqEnd, String gjjmrqStart,
                                                               String gjjmrqEnd, Integer memberCountStart, Integer memberCountEnd,
                                                               Integer djkpxxYear, Integer[] judgeLevel, Integer honourYear,
                                                               Integer honourlevel, Integer[] honourType, Integer djkpxxYearDzb, Integer[] judgeLevelDzb,String dzzdm);

}
