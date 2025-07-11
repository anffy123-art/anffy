package com.px.partybuild.controller;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.service.IntegratedQueryService;
import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/integratequery")
public class IntegratedQueryController {
    @Autowired
    private IntegratedQueryService integratedQueryService;
    @Autowired
    private StringUtils stringUtils;

    @ResponseBody
    @GetMapping("/getDepAdvanceList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getDepartmentAdvanceList(
            @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
            @RequestParam(value = "dzzmc", required = false) String dzzmc, @RequestParam(value = "zzlb", required = false) String zzlb,
            @RequestParam(value = "jczzfl", required = false) String jczzfl, @RequestParam(value = "jldzzrqStart", required = false) String jldzzrqStart,
            @RequestParam(value = "jldzzrqEnd", required = false) String jldzzrqEnd, @RequestParam(value = "gjjmrqStart", required = false) String gjjmrqStart,
            @RequestParam(value = "gjjmrqEnd", required = false) String gjjmrqEnd, @RequestParam(value = "memberCountStart", required = false) Integer memberCountStart,
            @RequestParam(value = "memberCountEnd", required = false) Integer memberCountEnd, @RequestParam(value = "djkpxxYear", required = false) Integer djkpxxYear,
            @RequestParam(value = "judgeLevel", required = false) String judgeLevel, @RequestParam(value = "honourYear", required = false) Integer honourYear,
            @RequestParam(value = "honourlevel", required = false) Integer honourlevel, @RequestParam(value = "honourType", required = false) String honourType,
            @RequestParam(value = "djkpxxYear_dzb", required = false) Integer djkpxxYearDzb,
            @RequestParam(value = "judgeLevel_dzb", required = false) Integer[] judgeLevelDzb,
            @RequestParam(value = "dzzdm", required = false) String dzzdm) {
        String[] zzlbArr = new String[0];
        String[] jczzflArr = new String[0];
        Integer[] judgeLevelArr = new Integer[0];
        Integer[] honourTypeArr = new Integer[0];

        if (!stringUtils.IsNullOrEmpty(zzlb)) {
            zzlbArr = zzlb.split(",");
        }
        if (!stringUtils.IsNullOrEmpty(jczzfl)) {
            jczzflArr = jczzfl.split(",");
        }
        if (!stringUtils.IsNullOrEmpty(judgeLevel)) {
            judgeLevelArr = Arrays.stream(judgeLevel.split(",")).map(o -> Integer.parseInt(o)).toArray(Integer[]::new);
        }
        if (!stringUtils.IsNullOrEmpty(honourType)) {
            honourTypeArr = Arrays.stream(honourType.split(",")).map(o -> Integer.parseInt(o)).toArray(Integer[]::new);
        }
        PageInfo<HashMap<String, Object>> departmentAdvanceList = integratedQueryService.getDepartmentAdvanceList(
                pageIndex, pageSize, dzzmc, zzlbArr, jczzflArr, jldzzrqStart, jldzzrqEnd, gjjmrqStart, gjjmrqEnd, memberCountStart, memberCountEnd,
                djkpxxYear, judgeLevelArr, honourYear, honourlevel, honourTypeArr, djkpxxYearDzb, judgeLevelDzb,dzzdm);
        RequsetData<PageInfo<HashMap<String, Object>>> res = new RequsetData<>();
        res.setItem(departmentAdvanceList);
        return res;
    }
}
