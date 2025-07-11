package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.AppConfig;
import com.px.partybuild.mapper.*;
import com.px.partybuild.model.*;
import com.px.partybuild.service.GradeService;
import com.px.partybuild.service.PEUserService;
import com.px.partybuild.service.PartyService;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.vo.PartyInfoVo;
import com.px.partybuild.vo.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 党组织信息
 *
 * @author H
 */
@Service("partyService")
public class PartyServiceImpl implements PartyService {

    @Autowired
    private ZzZzqkxxMapper zzZzqkxxMapper;
    @Autowired
    private PartyCQuery partyCquery;
    @Autowired
    private PartyUserCQuery partyUserCquery;
    @Autowired
    private MapUtils mapUtils;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private ZzDxzcyMapper zzDxzcyMapper;
    @Autowired
    private CfRolesCQuery rolesCquery;
    @Autowired
    protected AppConfig appConfig;
    @Autowired
    private ZzZzqkxxfbMapper zzZzqkxxfbMapper;
    @Autowired
    private ZzDzzzlyMapper zzDzzzlyMapper;
    @Autowired
    private GradeCQuery gradeCquery;
    @Autowired
    private DjzzrsJgfzMapper DjzzrsJgfzMapper;
    @Autowired
    private DjzzrsFzjgglMapper DjzzrsFzjgglMapper;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private PEUserService peUserService;
    @Autowired
    private BigDataCQuery bigDataCquery;
    @Autowired
    private PartyTwoCQuery partyTwoCquery;

    private static Integer[] levelType = new Integer[]{100, 200, 300, 400, 500};

    @Override
    public List<HashMap<String, Object>> getPartyTreeList(String parentCode, String dzzdm, Integer showlevel) {
        List<Integer> levelParent = new ArrayList<>();
        if (showlevel != null) {
            levelParent = Arrays.asList(levelType).stream().filter(it -> it <= showlevel).collect(Collectors.toList());
        }
        return partyCquery.selectPartyTreeList(parentCode, dzzdm, showlevel, levelParent);
    }

    @Override
    public List<TreeVo> getPartyTree(String parentId) {

        List<TreeVo> result = new ArrayList<>();

        List<TreeVo> dataList = partyCquery.selectPartyForTreeList(appConfig.gddwdm,parentId);

        result = dataList.stream().filter(it -> it.getParentid().equals(appConfig.gddwdm)).collect(Collectors.toList());

        result.forEach(item -> {
            item.setFullids(item.getId());
            item.setChlidShow(1);
            item.setChildList(getChildList(dataList, item));
        });

        return result;
    }
    @Override
    public List<TreeVo> getChildParty(String parentId) {

        List<TreeVo> dataList = partyCquery.selectPartyForTreeList(appConfig.gddwdm,parentId);

        return dataList;
    }
    private List<TreeVo> getChildList(List<TreeVo> dataList, TreeVo parent) {
        List<TreeVo> result = dataList.stream().filter(d -> parent.getId().equals(d.getParentid())).collect(Collectors.toList());
        result.forEach(item ->
        {
            item.setFullids(parent.getFullids() + "." + item.getId());
            item.setChildList(getChildList(dataList, item));
        });

        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getPartyList(int pageNum, int pageSize, String parentCode, String dzzmc, String dzzdm, String zzlb, String jczzfl, String jldzzrqBegin, String jldzzrqEnd,
                                                          String isContainParent, Integer zzfbType, Integer hjYear, List<String> zzlbStrList, String ssdzzmc, Integer dwjb, String jmrqBegintime, String jmrqEndtime,
                                                          List<String> jczzflList, String partyGroupId,List<String> notIncludeDzzdmList) {


        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyCquery.selectPartyList(appConfig.gddwdm, parentCode, dzzmc, dzzdm, zzlb, jczzfl, jldzzrqBegin, jldzzrqEnd, isContainParent, zzfbType, hjYear, zzlbStrList, ssdzzmc, dwjb, jmrqBegintime, jmrqEndtime, jczzflList, partyGroupId,notIncludeDzzdmList);


        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    /*@Cacheable(value = "getPartyByDm", key = "#p0")*/
    public ZzZzqkxx getPartyByDm(String dzzdm) {
        ZzZzqkxx zzZzqkxx = new ZzZzqkxx();
        ZzZzqkxxExample exp = new ZzZzqkxxExample();
        ZzZzqkxxExample.Criteria cri = exp.or();
        cri.andDzzdmEqualTo(dzzdm);
        List<ZzZzqkxx> list = zzZzqkxxMapper.selectByExample(exp);
        if (list.size() > 0) {
            zzZzqkxx = list.get(0);
        }

        if (zzZzqkxx != null && !stringUtils.IsNullOrEmpty(zzZzqkxx.getDzzdm())) {
            //zzZzqkxx zzlb已经取消，查询ZZ_ZZQKXXFB表
            ZzZzqkxxfbExample example = new ZzZzqkxxfbExample();
            example.or().andDzzdmEqualTo(zzZzqkxx.getDzzdm());
            List<ZzZzqkxxfb> fb = zzZzqkxxfbMapper.selectByExample(example);
            if (fb.size() > 0) {
                zzZzqkxx.setZzlb(fb.get(0).getZzlb());
            }
        }
        return zzZzqkxx;
    }

    @Override
    public ZzZzqkxx getPartyByMc(String dzzmc) {
        ZzZzqkxx zzZzqkxx = new ZzZzqkxx();
        ZzZzqkxxExample exp = new ZzZzqkxxExample();
        ZzZzqkxxExample.Criteria cri = exp.or();
        cri.andDzzmcEqualTo(dzzmc);
        List<ZzZzqkxx> list = zzZzqkxxMapper.selectByExample(exp);
        if (list.size() > 0) {
            zzZzqkxx = list.get(0);
        }

        if (zzZzqkxx != null && !stringUtils.IsNullOrEmpty(zzZzqkxx.getDzzdm())) {
            //zzZzqkxx zzlb已经取消，查询ZZ_ZZQKXXFB表
            ZzZzqkxxfbExample example = new ZzZzqkxxfbExample();
            example.or().andDzzdmEqualTo(zzZzqkxx.getDzzdm());
            List<ZzZzqkxxfb> fb = zzZzqkxxfbMapper.selectByExample(example);
            if (fb.size() > 0) {
                zzZzqkxx.setZzlb(fb.get(0).getZzlb());
            }
        }
        return zzZzqkxx;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ZzZzqkxx getPartyById(String id) {
        ZzZzqkxx zzBzjcxx = new ZzZzqkxx();
        ZzZzqkxxExample exp = new ZzZzqkxxExample();
        ZzZzqkxxExample.Criteria cri = exp.or();
        cri.andZzqkxxbsEqualTo(id);
        List<ZzZzqkxx> list = zzZzqkxxMapper.selectByExample(exp);
        if (list.size() > 0) {
            zzBzjcxx = list.get(0);
        }
        return zzBzjcxx;
    }

    @Override
    public ZzZzqkxxfb getPartyFbById(String id) {
        return zzZzqkxxfbMapper.selectByPrimaryKey(id);
    }

    /**
     * @param zzZzqkxx
     * @param zzZzqkxxfb
     * @param zzDzzzlyList
     * @return
     */
    @Override
    public int saveParty(ZzZzqkxx zzZzqkxx, ZzZzqkxxfb zzZzqkxxfb, List<ZzDzzzly> zzDzzzlyList) throws Exception {

        ZzZzqkxx dbModel = getPartyByDm(zzZzqkxx.getDzzdm());
        if (dbModel != null && !stringUtils.IsNullOrEmpty(dbModel.getZzqkxxbs()) && !dbModel.getZzqkxxbs().equals(zzZzqkxx.getZzqkxxbs())) {
            throw new Exception("该机构编码已有其他机构关联，请修改");
        }

        int result = 0;

        //组织结构信息
        ZzZzqkxx model = getPartyById(zzZzqkxx.getZzqkxxbs());
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getZzqkxxbs()))) {
            result = zzZzqkxxMapper.insert(zzZzqkxx);
        } else {
            ZzZzqkxxExample exp = new ZzZzqkxxExample();
            ZzZzqkxxExample.Criteria cri = exp.or();
            cri.andZzqkxxbsEqualTo(zzZzqkxx.getZzqkxxbs());
            result = zzZzqkxxMapper.updateByExampleSelective(zzZzqkxx, exp);
        }

        //副表信息
        ZzZzqkxxfb fbModel = getPartyFbById(zzZzqkxxfb.getDzzdm());
        if (fbModel == null || (fbModel != null && stringUtils.IsNullOrEmpty(fbModel.getDzzdm()))) {
            zzZzqkxxfbMapper.insert(zzZzqkxxfb);
        } else {
            zzZzqkxxfbMapper.updateByPrimaryKey(zzZzqkxxfb);
        }

        //助理员信息
        ZzDzzzlyExample dzzzlyExample = new ZzDzzzlyExample();
        ZzDzzzlyExample.Criteria zlyCri = dzzzlyExample.or();
        zlyCri.andDzzdmEqualTo(zzZzqkxx.getDzzdm());
        zzDzzzlyMapper.deleteByExample(dzzzlyExample);
        for (ZzDzzzly item : zzDzzzlyList) {
            if (!stringUtils.IsNullOrEmpty(item.getRybm())) {
                item.setDzzzlyid(UUID.randomUUID().toString());
                item.setDzzdm(zzZzqkxx.getDzzdm());
                item.setDzzmc(zzZzqkxx.getDzzmc());

                zzDzzzlyMapper.insert(item);
            }
        }

        return result;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int deletePartyById(String id) {
        ZzZzqkxx model = getPartyById(id);

        ZzZzqkxxExample exp = new ZzZzqkxxExample();
        ZzZzqkxxExample.Criteria cri = exp.or();
        cri.andZzqkxxbsEqualTo(id);

        zzZzqkxxfbMapper.deleteByPrimaryKey(model.getDzzdm());

        ZzDzzzlyExample dzzzlyExample = new ZzDzzzlyExample();
        ZzDzzzlyExample.Criteria zlyCri = dzzzlyExample.or();
        zlyCri.andDzzdmEqualTo(model.getDzzdm());
        zzDzzzlyMapper.deleteByExample(dzzzlyExample);

        return zzZzqkxxMapper.deleteByExample(exp);
    }

    @Override
    public int savepartydxz(ZzZzqkxx zzZzqkxx, List<ZzDxzcy> zzDxzcies) {
        int result = 0;
        ZzZzqkxx model = getPartyById(zzZzqkxx.getZzqkxxbs());
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getZzqkxxbs()))) {
            zzZzqkxx.setZzlb("711");
            /*result = zzZzqkxxMapper.insert(zzZzqkxx);*/
        } else {
            ZzZzqkxxExample exp = new ZzZzqkxxExample();
            ZzZzqkxxExample.Criteria cri = exp.or();
            cri.andZzqkxxbsEqualTo(zzZzqkxx.getZzqkxxbs());
            /*result = zzZzqkxxMapper.updateByExampleSelective(zzZzqkxx, exp);*/
        }

        ZzDxzcyExample exp = new ZzDxzcyExample();
        ZzDxzcyExample.Criteria cri = exp.or().andDzzdmEqualTo(zzZzqkxx.getDzzdm());
        zzDxzcyMapper.deleteByExample(exp);
        zzDxzcies.forEach(item -> {
            zzDxzcyMapper.insert(item);
        });

        return result;
    }

    @Override
    public ZzZzqkxx getPartyByUserCode(String userCode) {
        //return this.zzZzqkxxMapper.getPartyByUserCode(userCode);
        return null;
    }

    @Override
    public int isPartyZb(String dzzdm) {
        int result = 0;
        ZzZzqkxx model = getPartyByDm(dzzdm);
        if (model != null && !stringUtils.IsNullOrEmpty(model.getZzqkxxbs())) {

            ZzZzqkxxfb zzZzqkxxfb = getPartyFbById(dzzdm);

            if (zzZzqkxxfb != null && !stringUtils.IsNullOrEmpty(zzZzqkxxfb.getDzzdm())) {
                String[] dblx = new String[]{"300", "400", "500"};

                if (Arrays.asList(dblx).contains(zzZzqkxxfb.getZzlb())) {
                    result = 1;
                }
            }
        }
        return result;
    }

    @Override
    /*@Cacheable(value = "partyTreeGroupData",key="#p0+'-'+#p1")*/
    public List<HashMap<String, Object>> getPartyGroupTreeList(String dzzdm, Integer onlyshowDw) {
        List<HashMap<String, Object>> dataList = partyCquery.selectPartyGroupTreeList(dzzdm, onlyshowDw, null);
        List<HashMap<String, Object>> result = dataList.stream().filter(it -> it.get("parentId") == null).collect(Collectors.toList());

        for (HashMap<String, Object> item : result) {
            item.put("childs", getChildPartyGroupList(dataList, item.get("id").toString(), item.get("id").toString()));
            item.put("fullcode", item.get("id").toString());
            //item.put("isexpand", false);
        }

        return result;

    }

    private List<HashMap<String, Object>> getChildPartyGroupList(List<HashMap<String, Object>> partyGroupList, String parentId, String parentFullCode) {
        List<HashMap<String, Object>> childList = partyGroupList.stream().filter(it -> it.get("parentId") != null && it.get("parentId").toString().equals(parentId)).collect(Collectors.toList());

        for (HashMap<String, Object> item : childList) {
            String fullCode = parentFullCode + "." + item.get("id").toString();
            item.put("childs", getChildPartyGroupList(partyGroupList, item.get("id").toString(), fullCode));
            item.put("fullcode", fullCode);
            //item.put("isexpand", false);
        }
        return childList;

    }

    @Override
    public PageInfo<HashMap<String, Object>> getPartyZlyList(int pageNum, int pageSize, String dzzdm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyCquery.selectPartyZLYList(dzzdm);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public List<HashMap<String, Object>> getChildPartyCount(String dzzdm, String ssdzzdm) {
        return partyCquery.selectChildPartyCount(dzzdm, ssdzzdm);
    }

    @Override
    /*@Cacheable(value = "partyTreePartyData",key="#p0+'-'+#p1+'-'+#p2+'-'+#p3+'-'+#p4+'-'+#p5")*/
    public List<HashMap<String, Object>> getNewPartyTreeList(String parentCode, String dzzdm, String userId, Integer onlyshowDw, Integer showdxz) {
        return partyCquery.selectNewPartyTreeList(parentCode, dzzdm, onlyshowDw, showdxz);
    }

    /**
     * 党员所属党委
     *
     * @param dzzdm id
     * @return m
     */
    @Override
    public ZzZzqkxx getUserDwInfo(String dzzdm) {
        ZzZzqkxx zzZzqkxx = new ZzZzqkxx();

        try {
            if (!stringUtils.IsNullOrEmpty(dzzdm)) {
                ZzZzqkxx result = getPartyByDm(dzzdm);
                if (result != null && !stringUtils.IsNullOrEmpty(result.getDzzdm())) {
                    ZzZzqkxxfb zzZzqkxxfb = getPartyFbById(result.getDzzdm());

                    if (zzZzqkxxfb != null && ("100".equals(zzZzqkxxfb.getZzlb()) || "200".equals(zzZzqkxxfb.getZzlb()))) {
                        zzZzqkxx = result;
                    } else {
                        if (dzzdm.length() >= 12) {
                            zzZzqkxx = getUserDwInfo(dzzdm.substring(0, dzzdm.length() - 3));
                        }
                    }
                }
            }
        } catch (Exception e) {

        }

        return zzZzqkxx;
    }

    /**
     * 党员所属支部总支
     *
     * @param dzzdm id
     * @return m
     */
    @Override
    public ZzZzqkxx getUserDZZInfo(String dzzdm) {
        ZzZzqkxx zzZzqkxx = new ZzZzqkxx();

        try {
            if (!stringUtils.IsNullOrEmpty(dzzdm)) {
                ZzZzqkxx result = getPartyByDm(dzzdm);
                if (result != null && !stringUtils.IsNullOrEmpty(result.getDzzdm())) {
                    ZzZzqkxxfb zzZzqkxxfb = getPartyFbById(result.getDzzdm());

                    if (zzZzqkxxfb != null && ("300".equals(zzZzqkxxfb.getZzlb()) || "400".equals(zzZzqkxxfb.getZzlb()))) {
                        zzZzqkxx = result;
                    } else {
                        if (dzzdm.length() >= 15) {
                            zzZzqkxx = getUserDZZInfo(dzzdm.substring(0, dzzdm.length() - 3));
                        }
                    }
                }
            }
        } catch (Exception e) {

        }

        return zzZzqkxx;
    }

    @Override
    public String getPartyName(String dzzdm) {
        String name = "";
        try {
            if (!stringUtils.IsNullOrEmpty(dzzdm)) {
                ZzZzqkxx zzZzqkxx = getPartyByDm(dzzdm);

                name = zzZzqkxx != null ? zzZzqkxx.getDzzmc() : "";
            }
        } catch (Exception e) {
        }
        return name;
    }


    /**
     * 后台处理党组织数据
     *
     * @return
     */
    @Override
    public int handlePartyData() {
        return partyCquery.handlePartyData();
    }


    public HashMap<String, Object> getPartyTreeForApp(String id, Integer onlyshowDw, Integer showdxz) {
        HashMap<String, Object> result = new HashMap<>();

        String name = "", parentId = "";
        Integer nodeType = 1;
        List<HashMap<String, Object>> childList = null;

        if (stringUtils.IsNullOrEmpty(id) || id.equals(appConfig.gddwdm)) {
            childList = partyCquery.selectPartyGroupTreeList(null, onlyshowDw, "0");
        } else {
            DjzzrsJgfz DjzzrsJgfz = getDjzzrsJgfzById(id);
            if (DjzzrsJgfz != null && !stringUtils.IsNullOrEmpty(DjzzrsJgfz.getJgfzid())) {
                id = DjzzrsJgfz.getJgfzid();
                name = DjzzrsJgfz.getFzmc();
                parentId = DjzzrsJgfz.getFjgfzid();

                childList = partyCquery.selectPartyGroupTreeList(null, onlyshowDw, id);

            } else {
                ZzZzqkxx zzZzqkxx = getPartyByDm(id);
                if (zzZzqkxx != null && !stringUtils.IsNullOrEmpty(zzZzqkxx.getDzzdm())) {
                    nodeType = 2;
                    id = zzZzqkxx.getDzzdm();
                    name = zzZzqkxx.getDzzmc();
                    if (zzZzqkxx.getDzzdm().length() == 12) {
                        DjzzrsFzjggl DjzzrsFzjggl = getDjzzrsFzjgglByDzzdm(id);
                        if (DjzzrsFzjggl != null) {
                            parentId = DjzzrsFzjggl.getJgfzid();
                        }
                    } else {
                        parentId = zzZzqkxx.getDzzdm().substring(0, zzZzqkxx.getDzzdm().length() - 3);
                    }

                    childList = partyCquery.selectNewPartyTreeList(id, null, onlyshowDw, showdxz);

                }
            }
        }

        result.put("id", id);
        result.put("name", name);
        result.put("parentId", parentId == null ? "" : parentId);
        result.put("childList", childList);
        result.put("nodetype", nodeType);

        return result;
    }

    public DjzzrsJgfz getDjzzrsJgfzById(String id) {
        return DjzzrsJgfzMapper.selectByPrimaryKey(id);
    }

    public DjzzrsFzjggl getDjzzrsFzjgglByDzzdm(String dzzdm) {
        DjzzrsFzjggl data = null;
        DjzzrsFzjgglExample exp = new DjzzrsFzjgglExample();
        DjzzrsFzjgglExample.Criteria cri = exp.or();
        cri.andDzzbmEqualTo(dzzdm);

        List<DjzzrsFzjggl> DjzzrsFzjgglList = DjzzrsFzjgglMapper.selectByExample(exp);
        if (DjzzrsFzjgglList.size() > 0) {
            data = DjzzrsFzjgglList.get(0);
        }
        return data;
    }


    public PartyInfoVo getPartyInfo(String dzzdm) {
        PartyInfoVo data = partyCquery.selectPartyInfo(dzzdm);

        long leaderCount = 0;
        int ybdy = 0, jjfz = 0, sqrd = 0, fzdx = 0;
        int zgcount = 0;

        leaderCount = gradeService.getMaxGradeUserList(1, 1, data.getDzzdm(), null, null, null, null, null, null, null, data.getDzzdm(), null).getTotal();
        List<HashMap<String, Object>> userExpandList = peUserService.getJoinUserTotalList(1, 1, dzzdm, null, null, null).getList();
        HashMap<String, Object> userTotal = bigDataCquery.selectPartyUserTotalList(dzzdm);
        if (userExpandList.size() > 0) {
            try {
                ybdy = Integer.parseInt(userExpandList.get(0).get("YBDY").toString());
                jjfz = Integer.parseInt(userExpandList.get(0).get("JJFZ").toString());
                sqrd = Integer.parseInt(userExpandList.get(0).get("SQRD").toString());
                fzdx = Integer.parseInt(userExpandList.get(0).get("FZDX").toString());
            } catch (Exception ex) {
            }
        }
        if (userTotal != null) {
            try {
                zgcount = Integer.parseInt(userTotal.get("ZGCOUNT").toString());
            } catch (Exception ex) {

            }
        }

        List<HashMap<String, Object>> djkpList = partyTwoCquery.selectDjkpxxList(dzzdm, null, null, null, null, dzzdm, null);

        if (djkpList.size() > 0) {
            data.setDjkpLevel(djkpList.get(0).get("JUDGELEVELNAME") != null ? djkpList.get(0).get("JUDGELEVELNAME").toString() : "");
        }

        data.setYbdy(ybdy);
        data.setJjfz(jjfz);
        data.setSqrd(sqrd);
        data.setFzdx(fzdx);
        data.setLeaderCount(leaderCount);
        data.setZgcount(zgcount);

        return data;
    }

    @Override
    public ZzZzqkxx getUserGeneralPartyInfo(String dzzdm) {
        ZzZzqkxx zzZzqkxx = new ZzZzqkxx();
        try {
            if (!stringUtils.IsNullOrEmpty(dzzdm)) {
                ZzZzqkxx result = getPartyByDm(dzzdm);
                if (result != null && !stringUtils.IsNullOrEmpty(result.getDzzdm())) {
                    ZzZzqkxxfb zzZzqkxxfb = getPartyFbById(result.getDzzdm());
                    if (zzZzqkxxfb != null && "300".equals(zzZzqkxxfb.getZzlb())) {
                        zzZzqkxx = result;
                    } else {
                        if (dzzdm.length() >= 15) {
                            zzZzqkxx = getUserGeneralPartyInfo(dzzdm.substring(0, dzzdm.length() - 3));
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return zzZzqkxx;
    }

}
