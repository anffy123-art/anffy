package com.px.partybuild.service.impl;

import com.px.partybuild.util.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.AppConfig;
import com.px.partybuild.mapper.*;
import com.px.partybuild.model.*;
import com.px.partybuild.service.BigDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 大数据
 *
 * @author H
 */
@Service("bigDataService")
public class BigDataServiceImpl implements BigDataService {

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private DsjDydtMapper dsjDydtMapper;
    @Autowired
    private DsjPxpyMapper dsjPxpyMapper;
    @Autowired
    private DsjCzqkMapper dsjCzqkMapper;
    @Autowired
    private DsjDnppMapper dsjDnppMapper;
    @Autowired
    private DsjCgjqMapper dsjCgjqMapper;
    @Autowired
    private DsjFzdyqkMapper dsjFzdyqkMapper;
    @Autowired
    private DsjNdkpjgMapper dsjNdkpjgMapper;
    @Autowired
    private BigDataCQuery bigDataCquery;

    @Autowired
    private DsjDyfzqkMapper dsjDyfzqkMapper;

    @Autowired
    private DateUtils dateUtils;

    /**
     * @return java.util.List<com.px.partybuild.model.DsjDydt>
     * @Description //TODO 查询大数据-党员动态
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<DsjDydt> getDsjDydtList(Integer nd, Integer ndOrderBy) {
        DsjDydtExample exp = new DsjDydtExample();
        exp.setOrderByClause("ND " + (ndOrderBy != null && ndOrderBy.equals(1) ? "ASC" : "DESC"));
        DsjDydtExample.Criteria cri = exp.or();
        if (nd != null) {
            cri.andNdEqualTo(nd);
        }
        return dsjDydtMapper.selectByExample(exp);
    }

    /**
     * @return int
     * @Description //TODO 保存大数据-党员动态
     * @date 2024-08
     * @Param [dsjDydtList]
     **/
    @Override
    public int saveDsjDydt(List<DsjDydt> dsjDydtList) {
        dsjDydtMapper.deleteByExample(null);
        int count = 0;
        for (DsjDydt item : dsjDydtList) {
            item.setDydtbs(UUID.randomUUID().toString());
            count += dsjDydtMapper.insert(item);
        }

        return count;
    }

    /**
     * @return java.util.List<com.px.partybuild.model.DsjPxpy>
     * @Description //TODO 查询大数据-评先评优
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<DsjPxpy> getDsjPxpyList(Integer nd) {
        DsjPxpyExample exp = new DsjPxpyExample();
        exp.setOrderByClause("ND DESC");
        DsjPxpyExample.Criteria cri = exp.or();
        if (nd != null) {
            cri.andNdEqualTo(nd);
        }
        return dsjPxpyMapper.selectByExample(exp);
    }

    /**
     * @return int
     * @Description //TODO 保存大数据-评先评优
     * @date 2024-08
     * @Param [dsjPxpyList]
     **/
    @Override
    public int saveDsjPxpy(List<DsjPxpy> dsjPxpyList) {
        dsjPxpyMapper.deleteByExample(null);
        int count = 0;
        for (DsjPxpy item : dsjPxpyList) {
            item.setPxpybs(UUID.randomUUID().toString());
            count += dsjPxpyMapper.insert(item);
        }

        return count;
    }

    /**
     * @return java.util.List<com.px.partybuild.model.DsjCzqk>
     * @Description //TODO 查询大数据-处置情况
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<DsjCzqk> getDsjCzqkList(Integer nd) {
        DsjCzqkExample exp = new DsjCzqkExample();
        exp.setOrderByClause("ND DESC");
        DsjCzqkExample.Criteria cri = exp.or();
        if (nd != null) {
            cri.andNdEqualTo(nd);
        }
        return dsjCzqkMapper.selectByExample(exp);
    }

    /**
     * @return int
     * @Description //TODO 保存大数据-处置情况
     * @date 2024-08
     * @Param [dsjCzqkList]
     **/
    @Override
    public int saveDsjCzqk(List<DsjCzqk> dsjCzqkList) {
        dsjCzqkMapper.deleteByExample(null);
        int count = 0;
        for (DsjCzqk item : dsjCzqkList) {
            item.setCzqkbs(UUID.randomUUID().toString());
            count += dsjCzqkMapper.insert(item);
        }

        return count;
    }

    /**
     * @return java.util.List<com.px.partybuild.model.DsjCzqk>
     * @Description //TODO 查询大数据-党内品牌
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<DsjDnpp> getDsjDnppList() {
        return dsjDnppMapper.selectByExample(null);
    }

    /**
     * @return int
     * @Description //TODO 保存大数据-党内品牌
     * @date 2024-08
     * @Param [dsjDnppList]
     **/
    @Override
    public int saveDsjDnpp(List<DsjDnpp> dsjDnppList) {
        dsjDnppMapper.deleteByExample(null);
        int count = 0;
        for (DsjDnpp item : dsjDnppList) {
            item.setDnppbs(UUID.randomUUID().toString());
            count += dsjDnppMapper.insert(item);
        }

        return count;
    }

    /**
     * @return java.util.List<com.px.partybuild.model.DsjCzqk>
     * @Description //TODO 查询大数据-创岗建区
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<DsjCgjq> getDsjCgjqList() {
        return dsjCgjqMapper.selectByExample(null);
    }

    /**
     * @return int
     * @Description //TODO 保存大数据-创岗建区
     * @date 2024-08
     * @Param [dsjCgjqList]
     **/
    @Override
    public int saveDsjCgjq(List<DsjCgjq> dsjCgjqList) {
        dsjCgjqMapper.deleteByExample(null);
        int count = 0;
        for (DsjCgjq item : dsjCgjqList) {
            item.setCgjqbs(UUID.randomUUID().toString());
            count += dsjCgjqMapper.insert(item);
        }

        return count;
    }

    /**
     * @return java.util.List<com.px.partybuild.model.DsjCzqk>
     * @Description //TODO 查询大数据-发展党员情况
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<DsjFzdyqk> getDsjFzdyqkList() {
        return dsjFzdyqkMapper.selectByExample(null);
    }

    /**
     * @return int
     * @Description //TODO 保存大数据-发展党员情况
     * @date 2024-08
     * @Param [dsjFzdyqkList]
     **/
    @Override
    public int saveDsjFzdyqk(List<DsjFzdyqk> dsjFzdyqkList) {
        dsjFzdyqkMapper.deleteByExample(null);
        int count = 0;
        for (DsjFzdyqk item : dsjFzdyqkList) {
            item.setFzdyqkbs(UUID.randomUUID().toString());
            count += dsjFzdyqkMapper.insert(item);
        }

        return count;
    }

    /**
     * @return java.util.List<com.px.partybuild.model.DsjNdkpjg>
     * @Description //TODO 查询大数据-年度考评结果
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<DsjNdkpjg> getDsjNdkpjgList(Integer nd) {
        DsjNdkpjgExample exp = new DsjNdkpjgExample();
        exp.setOrderByClause("ND DESC");
        DsjNdkpjgExample.Criteria cri = exp.or();
        if (nd != null) {
            cri.andNdEqualTo(nd);
        }
        return dsjNdkpjgMapper.selectByExample(exp);
    }

    /**
     * @return int
     * @Description //TODO 保存大数据-年度考评结果
     * @date 2024-08
     * @Param [dsjNdkpjgList]
     **/
    @Override
    public int saveDsjNdkpjg(List<DsjNdkpjg> dsjNdkpjgList) {
        dsjNdkpjgMapper.deleteByExample(null);
        int count = 0;
        for (DsjNdkpjg item : dsjNdkpjgList) {
            item.setNdkpjgbs(UUID.randomUUID().toString());
            count += dsjNdkpjgMapper.insert(item);
        }

        return count;
    }

    @Override
    public List<DsjDyfzqk> getdsjdyfzqklist(Integer nd) {
        DsjDyfzqkExample exp = new DsjDyfzqkExample();
        exp.setOrderByClause("ND DESC");
        DsjDyfzqkExample.Criteria cri = exp.or();
        if (nd != null) {
            cri.andNdEqualTo(nd);
        }
        return dsjDyfzqkMapper.selectByExample(exp);
    }

    @Override
    public int savedsjdyfzqk(List<DsjDyfzqk> dsjNdkpjgList) {
        dsjDyfzqkMapper.deleteByExample(null);
        int count = 0;
        for (DsjDyfzqk item : dsjNdkpjgList) {
            item.setDyfzqkid(UUID.randomUUID().toString());
            count += dsjDyfzqkMapper.insert(item);
        }

        return count;
    }

    @Override
    public List<HashMap<String, Object>> getDzzfbqkList() {
        return bigDataCquery.selectDzzfbqkList();
    }

    @Override
    public HashMap<String, Object> getDzzxxCount(String province) {
        return bigDataCquery.selectDzzxxCount(appConfig.gddwdm, province);
    }

    @Override
    public HashMap<String, Object> getDwxxCount(String province) {
        return bigDataCquery.selectDwxxCount(appConfig.gddwdm);
    }

    @Override
    public List<HashMap<String, Object>> getDyCount(String province) {
        return bigDataCquery.selectDyCount(appConfig.gddwdm);
    }

    /**
     * @return java.util.HashMap<java.lang.String, java.lang.Object>
     * @Description //TODO 统计党员性别
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getDyxbCount(String dzzdm, Integer dwgzzlb, Integer isOnduty) {
        return bigDataCquery.selectDyxbCount(appConfig.gddwdm, dzzdm, dwgzzlb, isOnduty);
    }

    /**
     * @return java.util.HashMap<java.lang.String, java.lang.Object>
     * @Description //TODO 统计党员年龄
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getDynlCount(String dzzdm, Integer dwgzzlb, Integer isOnduty) {
        return bigDataCquery.selectDynlCount(appConfig.gddwdm, dzzdm, dwgzzlb, isOnduty);
    }

    /**
     * @return java.util.HashMap<java.lang.String, ava.lang.Object>
     * @Description //TODO 统计党员党龄
     * @date 2024-08
     * @Param [dzzdm]
     **/
    @Override
    public List<HashMap<String, Object>> getDydlCount(String dzzdm, Integer dwgzzlb, Integer isOnduty) {
        return bigDataCquery.selectDydlCount(appConfig.gddwdm, dzzdm, dwgzzlb, isOnduty);
    }

    /**
     * @return java.util.HashMap<java.lang.String, java.lang.Object>
     * @Description //TODO 统计政工职务党员
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getZgzwCount(String dzzdm, Integer dwgzzlb) {
        return bigDataCquery.selectZgzwCount(dzzdm, dwgzzlb);
    }

    @Override
    public List<Map<String, Object>> countryzt(String partyGroup, Integer isOnduty) {
        return bigDataCquery.CountRYZT(partyGroup, isOnduty);
    }

    @Override
    public List<Map<String, Object>> getUserEducationList(String dzzdm, Integer dwgzzlb, Integer isOnduty) {
        return bigDataCquery.selectUserEducationList(dzzdm, dwgzzlb, isOnduty);
    }

    @Override
    public List<HashMap<String, Object>> getShykCount(String dzzdm) {
        return bigDataCquery.selectShykCount(dzzdm);
    }


    @Override
    public List<HashMap<String, Object>> getDzzxxList(String dzzdm) {
        return bigDataCquery.selectDzzxxList(dzzdm);
    }

    @Override
    public List<HashMap<String, Object>> getDyxxList(String dzzdm) {
        return bigDataCquery.selectDyxxList(dzzdm);
    }

    @Override
    public PageInfo<HashMap<String, Object>> getAllDataTotal(int page, int rows, Integer zzfbType, String beginTime, String endTime) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = bigDataCquery.selectAllDataTotal(appConfig.gddwdm, zzfbType, beginTime, endTime);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);

        return result;
    }

    @Override
    public List<HashMap<String, Object>> getdyfzqktotallist(List<Integer> ndList) {
        return bigDataCquery.selectDYFZQKTotalList(ndList);
    }

    @Override
    public List<HashMap<String, Object>> getPartyCountList(String dzzdm, String ssdzzdm) {
        return bigDataCquery.selectPartyCountList(appConfig.gddwdm, dzzdm, ssdzzdm);
    }


    @Override
    public List<HashMap<String, Object>> getUserLeaderTotalList(String userCode, String year) {
        return bigDataCquery.selectUserLeaderTotalList(userCode, year);
    }





    @Override
    public HashMap<String, Object> getPartyUserTotalList(String dzzdm) {
        return bigDataCquery.selectPartyUserTotalList(dzzdm);
    }

    @Override
    public HashMap<String, Object> getcgjqtotal(String dzzdm, String ssdzzdm, Integer year) {
        return bigDataCquery.selectCGJQTotal(dzzdm, ssdzzdm, year);
    }

    @Override
    public List<HashMap<String, Object>> getcgjqtotallist(String dzzdm, String ssdzzdm, Integer year) {
        return bigDataCquery.selectCGJQTotalList(dzzdm, ssdzzdm, year);
    }

    @Override
    public List<HashMap<String, Object>> getPartyUserExpendTotalList(String dzzdm) {
        return bigDataCquery.selectPartyUserExpendTotalList(dzzdm);
    }

    @Override
    public List<HashMap<String, Object>> getzxzxxtotal(String dzzdm, String ssdzzdm, Integer year) {
        return bigDataCquery.selectZXZXXTotal(dzzdm, ssdzzdm, year);
    }

    @Override
    public List<HashMap<String, Object>> getDjkpxxTotalList(Integer year) {
        return bigDataCquery.selectDjkpxxTotalList(year);
    }

    @Override
    public List<HashMap<String, Object>> getBrandTotalList() {
        return bigDataCquery.selectBrandTotalList();
    }

    @Override
    public List<HashMap<String, Object>> getJlcfxxTotalList() {
        return bigDataCquery.selectJlcfxxTotalList();
    }

    @Override
    public List<HashMap<String, Object>> getPartyUserStatusTotalList() {
        return bigDataCquery.selectPartyUserStatusTotalList();
    }

    @Override
    public List<HashMap<String, Object>> getZzpxqkList() {
        List<HashMap<String, Object>> list = bigDataCquery.selectZzpxqkList();

        List<HashMap<String, Object>> result = new ArrayList<>();

        Integer nowYear = dateUtils.dateToLocalDate(new Date()).getYear();
        Integer startYear = nowYear - 4;

        for (Integer year = startYear; year <= nowYear; year++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("year", year);

            Integer finalYear = year;
            HashMap<String, Object> dbData = list.stream().filter(e -> e.get("year").toString().equals(finalYear.toString())).findFirst().orElse(null);
            if (dbData != null) {
                data.put("count", dbData.get("count"));
            } else {
                data.put("count", 0);
            }

            result.add(data);
        }

        return result;
    }

    @Override
    public List<HashMap<String, Object>> getDnpxxxTotalList() {
        List<HashMap<String, Object>> list = bigDataCquery.selectDnpxxxTotalList();

        List<HashMap<String, Object>> result = new ArrayList<>();

        Integer nowYear = dateUtils.dateToLocalDate(new Date()).getYear();
        Integer startYear = nowYear - 4;

        for (Integer year = startYear; year <= nowYear; year++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("year", year);

            Integer finalYear = year;
            HashMap<String, Object> dbData = list.stream().filter(e -> e.get("year").toString().equals(finalYear.toString())).findFirst().orElse(null);
            if (dbData != null) {
                data.put("count_partyUser", dbData.get("count_partyUser"));
                data.put("count_workUser", dbData.get("count_workUser"));
            } else {
                data.put("count_partyUser", 0);
                data.put("count_workUser", 0);
            }

            result.add(data);
        }

        return result;
    }

    @Override
    public List<HashMap<String, Object>> getPartyBrandTotalList() {
        List<HashMap<String, Object>> list = bigDataCquery.selectPartyBrandTotalList();

        List<HashMap<String, Object>> result = new ArrayList<>();

        Integer nowYear = dateUtils.dateToLocalDate(new Date()).getYear();
        Integer startYear = nowYear - 4;

        for (Integer year = startYear; year <= nowYear; year++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("year", year);

            Integer finalYear = year;
            HashMap<String, Object> dbData = list.stream().filter(e -> e.get("year").toString().equals(finalYear.toString())).findFirst().orElse(null);
            if (dbData != null) {
                data.put("count", dbData.get("count"));
            } else {
                data.put("count", 0);
            }

            result.add(data);
        }

        return result;
    }

    @Override
    public List<HashMap<String, Object>> getSzpyTotalList() {
        List<HashMap<String, Object>> list = bigDataCquery.selectSzpyTotalList();
        return list;
    }

    @Override
    public List<HashMap<String, Object>> getDnghbfTotalList() {
        List<HashMap<String, Object>> list = bigDataCquery.selectDnghbfTotalList();

        List<HashMap<String, Object>> result = new ArrayList<>();

        Integer nowYear = dateUtils.dateToLocalDate(new Date()).getYear();
        Integer startYear = nowYear - 4;

        for (Integer year = startYear; year <= nowYear; year++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("year", year);

            Integer finalYear = year;
            HashMap<String, Object> dbData = list.stream().filter(e -> e.get("year").toString().equals(finalYear.toString())).findFirst().orElse(null);
            if (dbData != null) {
                data.put("count", dbData.get("count"));
            } else {
                data.put("count", 0);
            }

            result.add(data);
        }

        return result;
    }

    @Override
    public List<HashMap<String, Object>> getZtdrTotalList(Integer year) {
        List<HashMap<String, Object>> list = bigDataCquery.selectZtdrTotalList(year);

        List<HashMap<String, Object>> result = new ArrayList<>();

        for (Integer month = 1; month <= 12; month++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("month", month + "月");

            Integer finalMonth = month;
            HashMap<String, Object> dbData = list.stream().filter(e -> e.get("month").toString().equals(finalMonth.toString())).findFirst().orElse(null);
            if (dbData != null) {
                data.put("count", dbData.get("count"));
            } else {
                data.put("count", 0);
            }

            result.add(data);
        }

        return result;
    }

}
