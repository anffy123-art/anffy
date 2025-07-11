package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.AppConfig;
import com.px.partybuild.mapper.GradeCQuery;
import com.px.partybuild.mapper.PartyCQuery;
import com.px.partybuild.mapper.PartyTotalCQuery;
import com.px.partybuild.service.PartyTotalService;
import com.px.partybuild.util.ExcelHelper;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.util.excel.CellItem;
import com.px.partybuild.util.excel.ListItem;
import com.px.partybuild.util.excel.PageItem;
import com.px.partybuild.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 党建统计
 *
 * @author H
 */
@Service("partyTotalService")
public class PartyTotalServiceImpl implements PartyTotalService {

    @Autowired
    private PartyCQuery partyCquery;

    @Autowired
    protected AppConfig appConfig;

    @Autowired
    private PartyTotalCQuery partyTotalCquery;

    @Autowired
    private GradeCQuery gradeCquery;

    @Autowired
    private StringUtils stringUtils;


    @Override
    public PageInfo<HashMap<String, Object>> getPartyTotalList(int pageNum, int pageSize, String dzzdm, Integer year) {

        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyCquery.selectPartyList(appConfig.gddwdm, null, null, dzzdm, null, null, null, null, null, null, null, null, null, null, null, null, null, null,null);

        List<String> dzzdmList = list.stream().map(it -> it.get("DZZDM").toString()).collect(Collectors.toList());

        List<HashMap<String, Object>> partytotalList = new ArrayList<>();
        List<HashMap<String, Object>> cgjqtotalList = new ArrayList<>();
        List<HashMap<String, Object>> dnpptotalList = new ArrayList<>();
        List<HashMap<String, Object>> activityroomtotalList = new ArrayList<>();
        List<HashMap<String, Object>> pubpositiontotalList = new ArrayList<>();
        List<HashMap<String, Object>> wxgrouptotalList = new ArrayList<>();
        List<HashMap<String, Object>> groupReplacelList = new ArrayList<>();
        List<HashMap<String, Object>> zgUserlList = new ArrayList<>();

        if (dzzdmList.size() > 0) {
            partytotalList = partyTotalCquery.selectPartytotalList(dzzdmList);
            cgjqtotalList = partyTotalCquery.selectCgjqtotalList(year, dzzdmList);
            dnpptotalList = partyTotalCquery.selectDnpptotalList(year, dzzdmList);
            activityroomtotalList = partyTotalCquery.selectActivityroomtotalList(year, dzzdmList);
            pubpositiontotalList = partyTotalCquery.selectPubpositiontotalList(year, dzzdmList);
            wxgrouptotalList = partyTotalCquery.selectWxgrouptotalList(year, dzzdmList);
            groupReplacelList = partyTotalCquery.selectGroupReplacetotalList(year == null ? LocalDate.now().getYear() : year, dzzdmList);
            zgUserlList = partyTotalCquery.selectZgUsertotalList(dzzdmList, null);
        }


        for (HashMap<String, Object> item : list) {
            String itDzzdm = item.get("DZZDM").toString();

            List<HashMap<String, Object>> ptList = partytotalList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> gqList = cgjqtotalList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> dpList = dnpptotalList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> arList = activityroomtotalList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> ppList = pubpositiontotalList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> wgList = wxgrouptotalList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> grList = groupReplacelList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> zgList = zgUserlList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());

            Object numDw = 0, numDzz = 0, numDzb = 0, numDxz = 0, numXfg = 0, numZrq = 0, numZd = 0, numJt = 0, numGt = 0, numRoom = 0, numPosition = 0, numWx = 0,
                    numYhjdzb = 0, numZguser = 0, userRate = 0;

            if (ptList.size() > 0) {
                numDw = ptList.get(0).get("NUM_DW");
                numDzz = ptList.get(0).get("NUM_DZZ");
                numDzb = ptList.get(0).get("NUM_DZB");
                numDxz = ptList.get(0).get("NUM_DXZ");
            }

            if (gqList.size() > 0) {
                numXfg = gqList.get(0).get("NUM_XFG");
                numZrq = gqList.get(0).get("NUM_ZRQ");
            }

            if (dpList.size() > 0) {
                numZd = dpList.get(0).get("NUM_ZD");//学院
                numJt = dpList.get(0).get("NUM_JT");//省级
                numGt = dpList.get(0).get("NUM_GT");//国家
            }

            if (arList.size() > 0) {
                numRoom = arList.get(0).get("NUM");
            }

            if (ppList.size() > 0) {
                numPosition = ppList.get(0).get("NUM");
            }

            if (wgList.size() > 0) {
                numWx = wgList.get(0).get("NUM");
            }

            if (grList.size() > 0) {
                numYhjdzb = grList.get(0).get("NUM_YHJDZB");
            }

            if (zgList.size() > 0) {
                numZguser = zgList.get(0).get("NUM_ZGUSER");
            }

            if (item.get("ZGRS") != null) {
                Integer userCount = Integer.parseInt(item.get("ZGRS").toString());
                if (userCount > 0) {
                    userRate = (new BigDecimal((float) Integer.parseInt(numZguser.toString()) / userCount).setScale(4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue());

                }
            }

            //党组织
            item.put("NUM_DW", numDw);//党委数
            item.put("NUM_DZZ", numDzz);//党总支数
            item.put("NUM_DZB", numDzb);//党支部数
            item.put("NUM_DXZ", numDxz);//党小组数
            item.put("NUM_YHJDZB", numYhjdzb);//应换届党支部数

            //党员数
            item.put("NUM_ZGUSER", numZguser);//在岗党员数

            //创岗建区
            item.put("NUM_XFG", numXfg);//党员先锋岗数
            item.put("NUM_ZRQ", numZrq);//红旗责任区数

            //党内品牌
            item.put("NUM_ZD", numZd);//红旗责任区数
            item.put("NUM_JT", numJt);//红旗责任区数
            item.put("NUM_GT", numGt);//红旗责任区数


            item.put("NUM_ROOM", numRoom);//党员活动室数
            item.put("NUM_POSITION", numPosition);//宣传阵地数
            item.put("NUM_WX", numWx);//互联网工作群数

            item.put("USERRATE", userRate);//互联网工作群数
        }

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }


    @Override
    public PageInfo<HashMap<String, Object>> getPartyDetailList(int pageNum, int pageSize, String dzzdm, Integer year, String dzzmc) {

        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyCquery.selectPartyList(appConfig.gddwdm, null, dzzmc, dzzdm, null, null, null, null, null, null, null, null, null, null, null, null, null, null,null);

        List<String> dzzdmList = list.stream().map(it -> it.get("DZZDM").toString()).collect(Collectors.toList());

        List<HashMap<String, Object>> partytotalList = new ArrayList<>();
        List<HashMap<String, Object>> groupReplacelList = new ArrayList<>();
        List<HashMap<String, Object>> dzbsjlList = new ArrayList<>();
        List<HashMap<String, Object>> alreadyReplaceList = new ArrayList<>();

        if (dzzdmList.size() > 0) {
            partytotalList = partyTotalCquery.selectPartytotalList(dzzdmList);
            groupReplacelList = partyTotalCquery.selectGroupReplacetotalList(year == null ? LocalDate.now().getYear() : year, dzzdmList);
            dzbsjlList = partyTotalCquery.selectDZBSJtotalList(dzzdmList);
            alreadyReplaceList = partyTotalCquery.selectGroupAlreadyReplacetotalList(year == null ? LocalDate.now().getYear() : year, dzzdmList);
        }


        for (HashMap<String, Object> item : list) {
            String itDzzdm = item.get("DZZDM").toString();

            List<HashMap<String, Object>> ptList = partytotalList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> grList = groupReplacelList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> dzbsjList = dzbsjlList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> replaceList = alreadyReplaceList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());

            Object numDzzCj = 0, numDzzLtx = 0, numDzbCj = 0, numDzbKs = 0, numDzbBz = 0, numDzbLtx = 0, numZz = 0, numJz = 0, numGz = 0,
                    numYhjdzb = 0, partyCount = 0, replaceCount = 0, numReplacerate = 0;

            if (ptList.size() > 0) {
                numDzzCj = ptList.get(0).get("NUM_DZZ_CJ");
                numDzzLtx = ptList.get(0).get("NUM_DZZ_LTX");
                numDzbCj = ptList.get(0).get("NUM_DZB_CJ");
                numDzbKs = ptList.get(0).get("NUM_DZB_KS");
                numDzbBz = ptList.get(0).get("NUM_DZB_BZ");
                numDzbLtx = ptList.get(0).get("NUM_DZB_LTX");

                partyCount = ptList.get(0).get("PARTYCOUNT");//党组织总数
            }

            if (grList.size() > 0) {
                numYhjdzb = grList.get(0).get("NUM_YHJDZB");//应换届党支部数
            }
            if (replaceList.size() > 0) {
                replaceCount = replaceList.get(0).get("NUM_DZBHJS");//已换届党支部数
            }

            if (dzbsjList.size() > 0) {
                numZz = dzbsjList.get(0).get("NUM_ZZ");
                numJz = dzbsjList.get(0).get("NUM_JZ");
                numGz = dzbsjList.get(0).get("NUM_GZ");
            }


            //党组织
            item.put("NUM_DZZ_CJ", numDzzCj);//车间党总支
            item.put("NUM_DZZ_LTX", numDzzLtx);//离退休党总支
            item.put("NUM_DZB_CJ", numDzbCj);//车间党支部
            item.put("NUM_DZB_KS", numDzbKs);//科室党支部
            item.put("NUM_DZB_BZ", numDzbBz);//班组党支部
            item.put("NUM_DZB_LTX", numDzbLtx);//离退休党支部

            item.put("NUM_YHJDZB", numYhjdzb);//应换届党支部数
            item.put("NUM_DZBHJS", replaceCount);//已换届党支部数

            if (Integer.parseInt(numYhjdzb.toString()) > 0) {
                numReplacerate = (new BigDecimal((float) Integer.parseInt(replaceCount.toString()) / Integer.parseInt(numYhjdzb.toString())).setScale(4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue());
            }
            item.put("NUM_REPLACERATE", numReplacerate);

            //党支部书记
            item.put("NUM_ZZ", numZz);//专职
            item.put("NUM_JZ", numJz);//兼职
            item.put("NUM_GZ", numGz);//挂职

        }

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }


    @Override
    public PageInfo<HashMap<String, Object>> getUserTotalList(int pageNum, int pageSize, String dzzdm, Integer year, String dzzmc) {

        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyCquery.selectPartyList(appConfig.gddwdm, null, dzzmc, dzzdm, null, null, null, null, null, null, null, null, null, null, null, null, null, null,null);

        List<String> dzzdmList = list.stream().map(it -> it.get("DZZDM").toString()).collect(Collectors.toList());

        List<HashMap<String, Object>> zgUserlList = new ArrayList<>();
        List<HashMap<String, Object>> knUserlList = new ArrayList<>();

        if (dzzdmList.size() > 0) {
            zgUserlList = partyTotalCquery.selectZgUsertotalList(dzzdmList, null);
            knUserlList = partyTotalCquery.selectGHBFtotalList(dzzdmList, year);
        }


        for (HashMap<String, Object> item : list) {
            String itDzzdm = item.get("DZZDM").toString();

            List<HashMap<String, Object>> zgList = zgUserlList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> knList = knUserlList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());

            Object numZguser = 0, numLtx = 0, numSqrd = 0, numJjfz = 0, numFzdx = 0, numYbdy = 0, numDzz = 0, numKn = 0;

            if (zgList.size() > 0) {
                numZguser = zgList.get(0).get("NUM_ZGUSER");
                numLtx = zgList.get(0).get("NUM_LTX");
                numSqrd = zgList.get(0).get("NUM_SQRD");
                numJjfz = zgList.get(0).get("NUM_JJFZ");
                numFzdx = zgList.get(0).get("NUM_FZDX");
                numYbdy = zgList.get(0).get("NUM_YBDY");
            }
            if (knList.size() > 0) {
                numKn = knList.get(0).get("NUM");
            }


            item.put("NUM_ZGUSER", numZguser);//在岗党员数
            item.put("NUM_LTX", numLtx);//离退休党员数
            item.put("NUM_SQRD", numSqrd);//申请入党数
            item.put("NUM_JJFZ", numJjfz);//积极分子数
            item.put("NUM_FZDX", numFzdx);//发展对象数
            item.put("NUM_YBDY", numYbdy);//预备党员数
            item.put("NUM_DZZ", numDzz);//年度待转正党员数
            item.put("NUM_KN", numKn);//困难党员数

        }

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }


    @Override
    public PageInfo<HashMap<String, Object>> getZxzxxFaTotalList(int pageNum, int pageSize, String dzzdm, Integer year, String ssdzzdm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyCquery.selectPartyList(appConfig.gddwdm, null, null, dzzdm, null, null, null, null, null, null, null, null, ssdzzdm, null, null, null, null, null,null);

        List<String> dzzdmList = list.stream().map(it -> it.get("DZZDM").toString()).collect(Collectors.toList());

        List<HashMap<String, Object>> zxzxxlList = new ArrayList<>();
        List<HashMap<String, Object>> cqllList = new ArrayList<>();

        if (dzzdmList.size() > 0) {
            zxzxxlList = partyTotalCquery.selectZxzxxFaTotalList(year, dzzdmList);
            cqllList = partyTotalCquery.selectZxzxxCqlList(year, dzzdmList);
        }


        for (HashMap<String, Object> item : list) {

            String itDzzdm = item.get("DZZDM").toString();

            List<HashMap<String, Object>> faList = zxzxxlList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());
            List<HashMap<String, Object>> cqList = cqllList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());

            Object numJzxx = 0, numZtyt = 0, numDxjl = 0, jzxxCql = 0;

            if (faList.size() > 0) {
                numJzxx = faList.get(0).get("NUM_JZXX");
                numZtyt = faList.get(0).get("NUM_ZTYT");
                numDxjl = faList.get(0).get("NUM_DXJL");
            }

            if (cqList.size() > 0) {
                jzxxCql = cqList.get(0).get("JZXXCQL");
            }


            item.put("NUM_JZXX", numJzxx);//集中学习数
            item.put("NUM_ZTYT", numZtyt);//专题研讨数
            item.put("NUM_DXJL", numDxjl);//督学交流数
            item.put("JZXXCQL", jzxxCql);//集中学习出勤率

            //item.put("USERCOUNT",  gradeCquery.selectMaxGradeUserList(itDzzdm, null, null, null, null, null, null, null, itDzzdm, null).size());//中心组成员数

        }

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public List<HashMap<String, Object>> getZxzxxCqlDetailList(String dzzdm, Integer year) {
        return partyTotalCquery.selectZxzxxCqlDetailList(year, dzzdm);
    }

    @Override
    public PageInfo<HashMap<String, Object>> getZxzxxUserStudyList(int pageNum, int pageSize, String dzzdm, Integer year) {

        List<HashMap<String, Object>> list = new ArrayList<>();

        if (!stringUtils.IsNullOrEmpty(dzzdm)) {
            PageHelper.startPage(pageNum, pageSize);
            list = gradeCquery.selectMaxGradeUserList(dzzdm, null, null, null, null, null, null, null, dzzdm, null);

            List<HashMap<String, Object>> dwStudyList = partyTotalCquery.selectZxzxxCqlDetailList(year, dzzdm);
            List<HashMap<String, Object>> userStudyList = partyTotalCquery.selectZxzxxUserStudyList(year, dzzdm);

            for (HashMap<String, Object> item : list) {
                String rybm = item.get("RYBM").toString();

                long total = userStudyList.stream().filter(it -> it.get("rybm").toString().equals(rybm)).count();
                int studyCount = 0;

                List<Map<String, Object>> userStudy = new ArrayList<>();

                for (HashMap<String, Object> dwstudy : dwStudyList) {
                    HashMap<String, Object> studyItem = new HashMap<>();

                    String studytime = dwstudy.get("STUDY_START_TIME").toString();

                    List<HashMap<String, Object>> usList = userStudyList.stream().filter(it -> it.get("rybm").toString().equals(rybm) && it.get("STUDY_START_TIME").toString().equals(studytime)).collect(Collectors.toList());

                    boolean absent = (usList.size() > 0 && (usList.get(0).get("ABSENT") == null || "0".equals(usList.get(0).get("ABSENT").toString())));

                    studyItem.put("STUDY_START_TIME", studytime);
                    studyItem.put("STUDYSTATE", usList.size() > 0 ? (absent ? "参加" : "缺席") : "/");
                    userStudy.add(studyItem);

                    studyCount += absent ? 1 : 0;
                }

                item.put("userStudyList", userStudy);
                item.put("STUDYRATE", total > 0 ? new BigDecimal((float) studyCount / total).setScale(4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue() : 0);
            }
        }

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }


    /*@Override
    public PageInfo<HashMap<String, Object>> getPartyduesTotalList(int pageNum, int pageSize, String dzzdm, Integer year, Integer month, String ssdzzdm) {

        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyCquery.selectPartyList(appConfig.gddwdm, null, null, dzzdm, null, null, null, null, null, null, null, null, ssdzzdm, null, null, null, null, null);

        List<String> dzzdmList = list.stream().map(it -> it.get("DZZDM").toString()).collect(Collectors.toList());

        List<HashMap<String, Object>> partyduesTotalList = new ArrayList<>();
        List<HashMap<String, Object>> partyDuesUserCount = new ArrayList<>();

        if (dzzdmList.size() > 0) {
            Integer yearMonth = Integer.parseInt(year.toString() + String.format("%02d", month));
            partyduesTotalList = partyTotalCquery.selectPartyduesTotalList(year, month, dzzdm, dzzdmList,yearMonth);
            partyDuesUserCount = partyTotalCquery.selectPartyDuesUserCount(yearMonth, dzzdmList);
        }


        for (HashMap<String, Object> item : list) {
            String itDzzdm = item.get("DZZDM").toString();

            List<HashMap<String, Object>> ptList = partyduesTotalList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());

            HashMap<String, Object> userCount = partyDuesUserCount.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).findFirst().orElse(null);

            Object totalMoney = 0, notDuesCount = 0, totalUser = 0, notDuesMoney = 0;
            *//*Integer totalUser = 0;*//*
     *//*Integer userCount = Integer.parseInt(item.get("USERCOUNT").toString());*//*

            if (ptList.size() > 0) {
                totalMoney = ptList.get(0).get("totalMoney");
                *//*totalUser = Integer.parseInt(ptList.get(0).get("TOTALUSER").toString());*//*
                totalUser = ptList.get(0).get("totalUser");
                notDuesCount = ptList.get(0).get("notDuesCount");
                notDuesMoney = ptList.get(0).get("notDuesMoney");
            }


            //党组织
            item.put("totalMoney", totalMoney);
            item.put("totalUser", totalUser);
            item.put("year", year);
            item.put("month", month);
            item.put("notDuesCount", notDuesCount);
            item.put("notDuesMoney", notDuesMoney);
            *//*item.put("notpayUser", userCount.compareTo(totalUser) >= 0 ? (userCount - totalUser) : 0);*//*

            item.put("USERCOUNT", userCount == null ? 0 : userCount.get("USERCOUNT"));

        }

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }*/

    @Override
    public PageInfo<PartyduesTotalVo> getPartyduesTotalListV2(int pageNum, int pageSize, String parentPartyCode, String partyCode, Integer year, Integer month) {
        Integer yearMonth = Integer.parseInt(year.toString() + String.format("%02d", month));

        PageHelper.startPage(pageNum, pageSize);

        List<PartyduesTotalVo> list = partyTotalCquery.selectPartyduesTotalListV2(appConfig.gddwdm, parentPartyCode, partyCode, year, month, yearMonth);
        PageInfo<PartyduesTotalVo> result = new PageInfo(list);
        return result;
    }


    @Override
    public List<HashMap<String, Object>> getPartyduesUserList(String dzzdm, Integer year, Integer month) {
        return partyTotalCquery.selectPartyduesUserList(dzzdm, year, month);
    }

    /*@Override
    public List<HashMap<String, Object>> getPartyduesUserList2(String dzzdm, Integer year, Integer month) {
        return partyTotalCquery.selectPartyduesUserList2(dzzdm, year, month);
    }

    @Override
    public List<HashMap<String, Object>> getNotPartyduesUserList(String dzzdm, Integer year, Integer month) {
        Integer yearMonth = Integer.parseInt(year.toString() + String.format("%02d", month));
        return partyTotalCquery.selectNotPartyduesUserList(dzzdm, year, month, yearMonth);
    }*/

    @Override
    public List<PartyduesAlreadyPayDetailVo> getAlreadyPayUserList(String partyCode, Integer year, Integer month) {
        Integer yearMonth = Integer.parseInt(year.toString() + String.format("%02d", month));
        return partyTotalCquery.selectAlreadyPayUserList(partyCode, year, month, yearMonth);
    }

    @Override
    public List<PartyduesDidnotPayDetailVo> getDidnotPayUserList(String partyCode, Integer year, Integer month) {
        Integer yearMonth = Integer.parseInt(year.toString() + String.format("%02d", month));

        return partyTotalCquery.selectDidnotPayUserList(partyCode, year, month, yearMonth);
    }

    @Override
    public List<PartyduesTotalByYearVo> getPartyduesMonthTotalList(int pageNum, int pageSize, Integer year, String dzzdm) {

        List<PartyduesTotalByYearVo> resultList = new ArrayList<>();
        List<PartyduesTotalDetailVo> partyduesTotalList = partyTotalCquery.selectPartyduesMonthTotalListV2(appConfig.gddwdm, year, dzzdm);

        Map<List<Object>, List<PartyduesTotalDetailVo>> groupMap = partyduesTotalList.stream().collect(Collectors.groupingBy(e -> Arrays.asList(e.partyCode, e.partyName)));

        groupMap.forEach((key, totalPoint) -> {
            PartyduesTotalByYearVo data = new PartyduesTotalByYearVo();
            data.partyCode = stringUtils.valueOf(key.get(0));
            data.partyName = stringUtils.valueOf(key.get(1));
            data.year = year;
            data.detailList = partyduesTotalList.stream().filter(it -> it.partyCode.equals(data.partyCode)).collect(Collectors.toList());

            resultList.add(data);
        });

        return resultList.stream().sorted(Comparator.comparing((PartyduesTotalByYearVo e) -> e.partyCode.length()).thenComparing(PartyduesTotalByYearVo::getPartyCode)).collect(Collectors.toList());
    }

    @Override
    public void exportPartyduesMonthTotal(HttpServletRequest request, HttpServletResponse response, Integer year, String dzzdm) throws IOException {
        List<PartyduesTotalByYearVo> dataList = this.getPartyduesMonthTotalList(1, 1000, year, dzzdm);
        PartyDuesTotalByQuarterVo totalData = this.getPartyDuesTotalByQuarter(dataList);

        ExcelHelper excelHelper = new ExcelHelper();
        InputStream input = new FileInputStream(new File(appConfig.staticLocations.replace("file:", "") + "doc/template/党费年度统计导出模板.xlsx"));
        List<PageItem> pageList = new ArrayList<>();
        PageItem page = new PageItem();
        List<CellItem> cellItems = new ArrayList<>();
        List<ListItem> listItem = new ArrayList<>();
        cellItems.add(new CellItem(2, 2, totalData.q1.stripTrailingZeros().toPlainString()));
        cellItems.add(new CellItem(2, 5, totalData.q2.stripTrailingZeros().toPlainString()));
        cellItems.add(new CellItem(2, 8, totalData.q3.stripTrailingZeros().toPlainString()));
        cellItems.add(new CellItem(2, 11, totalData.q4.stripTrailingZeros().toPlainString()));
        cellItems.add(new CellItem(2, 14, totalData.getTotal().stripTrailingZeros().toPlainString()));

        cellItems.add(new CellItem(3, 2, new BigDecimal(totalData.getUp_q1().toString()).stripTrailingZeros().toPlainString()));
        cellItems.add(new CellItem(3, 5, new BigDecimal(totalData.getUp_q2().toString()).stripTrailingZeros().toPlainString()));
        cellItems.add(new CellItem(3, 8, new BigDecimal(totalData.getUp_q3().toString()).stripTrailingZeros().toPlainString()));
        cellItems.add(new CellItem(3, 11, new BigDecimal(totalData.getUp_q4().toString()).stripTrailingZeros().toPlainString()));
        cellItems.add(new CellItem(3, 14, new BigDecimal(totalData.getUp_total().toString()).stripTrailingZeros().toPlainString()));

        ListItem item = new ListItem();
        item.setStartRow(1);
        item.setStartColumn(0);
        item.setEndColumn(14);
        String[][] itemValues = new String[dataList.size()][];

        for (int i = 0; i < dataList.size(); i++) {
            PartyduesTotalByYearVo data = dataList.get(i);
            String[] values = new String[15];
            values[0] = data.partyName;
            values[1] = data.year.toString();

            for (int j = 0; j < data.detailList.size(); j++) {
                values[2 + j] = data.detailList.get(j).amount.stripTrailingZeros().toPlainString();
            }

            values[14] = data.detailList.stream().map(PartyduesTotalDetailVo::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add).stripTrailingZeros().toPlainString();

            itemValues[i] = values;
        }

        item.setValues(itemValues);

        listItem.add(item);

        page.setCellItemList(cellItems);
        page.setListItem(listItem);
        pageList.add(page);

        excelHelper.exportExcelToTemp(response, input, pageList, "单位党费收缴登记本" + ".xlsx", null, null);
    }

    public class PartyDuesTotalByQuarterVo {
        public BigDecimal q1;
        public BigDecimal q2;
        public BigDecimal q3;
        public BigDecimal q4;
        private BigDecimal total;

        private Double up_q1;
        private Double up_q2;
        private Double up_q3;
        private Double up_q4;
        private Double up_total;

        public PartyDuesTotalByQuarterVo() {
            this.q1 = new BigDecimal(0);
            this.q2 = new BigDecimal(0);
            this.q3 = new BigDecimal(0);
            this.q4 = new BigDecimal(0);
        }

        public BigDecimal getTotal() {
            return this.q1.add(this.q2).add(this.q3).add(this.q4);
        }

        public Double getUp_q1() {
            return Math.ceil(this.q1.divide(new BigDecimal(2)).doubleValue());
        }

        public Double getUp_q2() {
            return Math.ceil(this.q2.divide(new BigDecimal(2)).doubleValue());
        }

        public Double getUp_q3() {
            return Math.ceil(this.q3.divide(new BigDecimal(2)).doubleValue());
        }

        public Double getUp_q4() {
            return Math.ceil(this.q4.divide(new BigDecimal(2)).doubleValue());
        }

        public Double getUp_total() {
            return this.getUp_q1() + this.getUp_q2() + this.getUp_q3() + this.getUp_q4();
        }
    }

    private PartyDuesTotalByQuarterVo getPartyDuesTotalByQuarter(List<PartyduesTotalByYearVo> dataList) {
        PartyDuesTotalByQuarterVo data = new PartyDuesTotalByQuarterVo();
        if (dataList.size() > 0) {
            dataList.get(0).detailList.forEach(e -> {
                switch (e.month) {
                    case 1:
                    case 2:
                    case 3:
                        data.q1 = data.q1.add(e.amount);
                        break;
                    case 4:
                    case 5:
                    case 6:
                        data.q2 = data.q2.add(e.amount);
                        break;
                    case 7:
                    case 8:
                    case 9:
                        data.q3 = data.q3.add(e.amount);
                        break;
                    case 10:
                    case 11:
                    case 12:
                        data.q4 = data.q4.add(e.amount);
                        break;
                }
            });
        }
        return data;

    }

    @Override
    public PageInfo<HashMap<String, Object>> getPartyduesQuarterTotalList(int pageNum, int pageSize, Integer year, String dzzdm, String ssdzzdm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyCquery.selectPartyList(appConfig.gddwdm, null, null, dzzdm, null, null, null, null, null, null, null, null, ssdzzdm, null, null, null, null, null,null);

        List<String> dzzdmList = list.stream().map(it -> it.get("DZZDM").toString()).collect(Collectors.toList());

        List<HashMap<String, Object>> partyduesTotalList = new ArrayList<>();

        if (dzzdmList.size() > 0) {
            partyduesTotalList = partyTotalCquery.selectPartyduesQuarterTotalList(year, dzzdm, dzzdmList);
        }


        for (HashMap<String, Object> item : list) {
            String itDzzdm = item.get("DZZDM").toString();

            List<HashMap<String, Object>> ptList = partyduesTotalList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());

            Object quarter1 = 0, quarter2 = 0, quarter3 = 0, quarter4 = 0, total = 0;

            if (ptList.size() > 0) {
                quarter1 = ptList.get(0).get("quarter1");
                quarter2 = ptList.get(0).get("quarter2");
                quarter3 = ptList.get(0).get("quarter3");
                quarter4 = ptList.get(0).get("quarter4");
                total = ptList.get(0).get("total");
            }


            item.put("year", year);
            item.put("quarter1", quarter1);
            item.put("quarter2", quarter2);
            item.put("quarter3", quarter3);
            item.put("quarter4", quarter4);
            item.put("total", total);

        }

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getZtdrTotalList(int pageNum, int pageSize, Integer year, Integer month, String dzzdm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyTotalCquery.selectZtdrTotalList(year, month, dzzdm);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getLeaderUserTotalList(int pageNum, int pageSize, String dzzdm, String yearMonth, String xm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyTotalCquery.selectLeaderUserTotalList(dzzdm, yearMonth, xm);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }


    @Override
    public PageInfo<HashMap<String, Object>> getSystemUseTotalList(int pageNum, int pageSize, String dzzdm, String fundYear, String duesYearMonth, String meetingYearMonth, String partydayYearMonth, String positionYearMonth) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyTotalCquery.selectSystemUseTotalList(dzzdm, fundYear, duesYearMonth, meetingYearMonth, partydayYearMonth, positionYearMonth);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }


    @Override
    public PageInfo<HashMap<String, Object>> getPartyLifeTotalList(int pageNum, int pageSize, Integer year, String dzzdm, String dzzmc) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyTotalCquery.selectPartyLifeTotalList(year, dzzdm, dzzmc);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getPartyLifeMonthTotalList(int pageNum, int pageSize, Integer year, String dzzdm, String dzzmc) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyTotalCquery.selectPartyLifeMonthTotalList(year, dzzdm, dzzmc);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }


    @Override
    public PageInfo<HashMap<String, Object>> getPartyActivityTotalList(int pageNum, int pageSize, Integer year, String dzzdm, String dzzmc) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyTotalCquery.selectPartyActivityTotalList(year, dzzdm, dzzmc);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getPartyActivityMonthTotalList(int pageNum, int pageSize, Integer year, String dzzdm, String dzzmc) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyTotalCquery.selectPartyActivityMonthTotalList(year, dzzdm, dzzmc);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getZxzxxWarnList(int pageNum, int pageSize, Integer year, Integer quarter, Integer month, String dzzdm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyTotalCquery.selectZxzxxWarnList(year, quarter, month, dzzdm);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

}
