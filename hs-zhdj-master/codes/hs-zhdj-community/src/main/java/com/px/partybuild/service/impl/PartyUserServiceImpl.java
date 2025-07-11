package com.px.partybuild.service.impl;

import com.px.partybuild.AppConfig;
import com.px.partybuild.mapper.*;
import com.px.partybuild.model.*;
import com.px.partybuild.service.LeaderAdminService;
import com.px.partybuild.service.PartyDicService;
import com.px.partybuild.service.PartyService;
import com.px.partybuild.service.PartyUserService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.vo.PartyUserInfoVo;
import com.px.partybuild.vo.UserInfoVo;
import com.px.partybuild.vo.UserLeaderTotalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 党员信息
 *
 * @author H
 */
@Service("partyUserService")
public class PartyUserServiceImpl implements PartyUserService {

    @Autowired
    private PartyUserCQuery partyUserCquery;
    @Autowired
    private ZzRyjbxxMapper zzRyjbxxMapper;
    @Autowired
    private GgZgjbxxMapper ggZgjbxxMapper;
    @Autowired
    private ZzRyjbxxLwMapper zzRyjbxxLwMapper;
    @Autowired
    private MapUtils mapUtils;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private ZzZzgxxxMapper zzZzgxxxMapper;
    @Autowired
    private RsRyjbxxfbMapper rsRyjbxxfbMapper;
    @Autowired
    private ZzDjxxMapper zzDjxxMapper;
    @Autowired
    private ZzDjxxfbMapper zzDjxxfbMapper;
    @Autowired
    private UsUsercontactpointMapper usUsercontactpointMapper;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private PartyService partyService;
    @Autowired
    private LeaderAdminService leaderAdminService;
    @Autowired
    private ZzZzqkxxMapper zzZzqkxxMapper;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private PartyDicService partyDicService;
    @Autowired
    private CfUsersMapper cfUsersMapper;
    @Autowired
    private CfUserrolesMapper cfUserrolesMapper;

    @Override
    public PageInfo<HashMap<String, Object>> getPartyUserList(int pageNum, int pageSize, String xb,
                                                              String dzzdm, String rybm, String xm, String zzlb,
                                                              String zwjb, String sqrdrq_begin, String sqrdrq_end, String szdzb, String szdxz, List<String> userIdList, List<String> ryztList, List<String> removeUserList, String szdzbdm,
                                                              List<String> removeUsersOfRybmList, List<String> rybmList, Integer zzfbType,
                                                              String mz, String dnzw, String xl, Integer age_begin, Integer age_end, Integer sfsldry,
                                                              String zwmc, Integer sfzg, String jczzfl, String curUserId, String partyGroupId, String mobile,Integer isStudent,Integer leaderTeamUserType) {

        /*boolean isLead = true;
        //包括领导人信息为空就不是相对接口
        if (curUserId != null) {
            isLead = appConfig.leadUids.contains(curUserId);
        }*/
        final boolean isAdmin = leaderAdminService.isAdmin(curUserId);

        PageHelper.startPage(pageNum, pageSize);

        List<HashMap<String, Object>> list = partyUserCquery.selectPartyUserList(dzzdm, rybm, xb, xm, zzlb, zwjb, sqrdrq_begin, sqrdrq_end, szdzb, szdxz, userIdList, ryztList, removeUserList, szdzbdm, removeUsersOfRybmList, rybmList, zzfbType, mz, dnzw, xl, age_begin, age_end, sfsldry, zwmc, sfzg, jczzfl, null, partyGroupId, mobile, null,isStudent,leaderTeamUserType);

        list.forEach(it -> {
            it.put("isAdmin", isAdmin);
            if ("1".equals(it.get("LEADTYPE").toString()) && !isAdmin) {
                it.put("RDSJ", "***");
                it.put("AGE", "***");
                it.put("JG", "***");
                it.put("MZMC", "***");
                it.put("CSRQ", "***");
                it.put("XLMC", "***");
                it.put("JSZWMC", "***");
                it.put("MOBILE", "***");
            }
        });

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);


        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getAllUserList(int pageNum, int pageSize, String dzzdm, String szdzbdm, String zzlb, String rybm, String xm, String xb, String mz, String xl, String mobile, List<String> ryztList,String userNo) {
        PageHelper.startPage(pageNum, pageSize);

        List<HashMap<String, Object>> list = partyUserCquery.selectAllUserList(dzzdm, szdzbdm, zzlb, rybm, xm, xb, mz, xl, mobile, ryztList,userNo);

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);


        return result;
    }


    @Override
    public HashMap<String, Object> getPartyUserInfoByRybm(String rybm) {
        HashMap<String, Object> result = new HashMap<>();
        if (!stringUtils.IsNullOrEmpty(rybm)) {
            PageHelper.startPage(1, 1);
            List<HashMap<String, Object>> list = partyUserCquery.selectPartyUserList(null, rybm, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                    null, null, null, null, null, null, null, null, null, true, null, null,null,null,null);
            if (list.size() > 0) {
                result = list.get(0);
            }
        }
        return result;
    }

    @Override
    public HashMap<String, Object> getPartyUserInfoByNameAndSfzh(String name, String sfzh) {
        HashMap<String, Object> result = new HashMap<>();
        if (!stringUtils.IsNullOrEmpty(name) && !stringUtils.IsNullOrEmpty(sfzh)) {
            PageHelper.startPage(1, 1);
            List<HashMap<String, Object>> list = partyUserCquery.selectPartyUserList(null, null, null, name, null, null, null, null, null, null, null, null, null, null, null, null, null,
                    null, null, null, null, null, null, null, null, null, true, null, null,sfzh,null,null);
            if (list.size() > 0) {
                result = list.get(0);
            }
        }
        return result;
    }

    @Override
    public HashMap<String, Object> getPartyUserExt(String rybm) {
        HashMap<String, Object> result = new HashMap<>();
        if (!stringUtils.IsNullOrEmpty(rybm)) {
            result = partyUserCquery.selectPartyUserSingleExt(rybm);
        }
        return result;
    }

    @Override
    public String getUserDzzdm(String rybm) {
        String dzzdm = "";
        HashMap<String, Object> result = getPartyUserInfoByRybm(rybm);
        if (result != null && result.get("SZDZBDM") != null) {
            dzzdm = result.get("SZDZBDM").toString();
        }
        return dzzdm;
    }

    @Override
    public ZzRyjbxx getPartyUserByIdZn(String id) {
        ZzRyjbxx zzRyjbxx = new ZzRyjbxx();
        ZzRyjbxxExample exp = new ZzRyjbxxExample();
        ZzRyjbxxExample.Criteria cri = exp.or();
        cri.andRyjbxxbsEqualTo(id);
        List<ZzRyjbxx> list = zzRyjbxxMapper.selectByExample(exp);
        if (list.size() > 0) {
            zzRyjbxx = list.get(0);
        }
        return zzRyjbxx;
    }

    @Override
    public ZzRyjbxx getPartyUserByRybmZn(String rybm) {
        ZzRyjbxx zzRyjbxx = new ZzRyjbxx();
        ZzRyjbxxExample exp = new ZzRyjbxxExample();
        ZzRyjbxxExample.Criteria cri = exp.or();
        cri.andRybmEqualTo(rybm);
        List<ZzRyjbxx> list = zzRyjbxxMapper.selectByExample(exp);
        if (list.size() > 0) {
            zzRyjbxx = list.get(0);
        }
        return zzRyjbxx;
    }

    @Override
    public GgZgjbxx getPartyUserByIdRs(String id) {
        GgZgjbxx rsRyjbxx = new GgZgjbxx();
        GgZgjbxxExample exp = new GgZgjbxxExample();
        GgZgjbxxExample.Criteria cri = exp.or();
        cri.andRybmEqualTo(id);
        List<GgZgjbxx> list = ggZgjbxxMapper.selectByExample(exp);
        if (list.size() > 0) {
            rsRyjbxx = list.get(0);
        }
        return rsRyjbxx;
    }

    @Override
    public ZzRyjbxxLw getPartyUserByIdLw(String id) {
        ZzRyjbxxLw zzRyjbxxLw = new ZzRyjbxxLw();
        ZzRyjbxxLwExample exp = new ZzRyjbxxLwExample();
        ZzRyjbxxLwExample.Criteria cri = exp.or();
        cri.andLwryjbxxbsEqualTo(id);
        List<ZzRyjbxxLw> list = zzRyjbxxLwMapper.selectByExample(exp);
        if (list.size() > 0) {
            zzRyjbxxLw = list.get(0);
        }
        return zzRyjbxxLw;
    }

    @Override
    public ZzRyjbxxLw getPartyUserByRybmLw(String rybm) {
        ZzRyjbxxLw zzRyjbxxLw = new ZzRyjbxxLw();
        ZzRyjbxxLwExample exp = new ZzRyjbxxLwExample();
        ZzRyjbxxLwExample.Criteria cri = exp.or();
        cri.andRybmEqualTo(rybm);
        List<ZzRyjbxxLw> list = zzRyjbxxLwMapper.selectByExample(exp);
        if (list.size() > 0) {
            zzRyjbxxLw = list.get(0);
        }
        return zzRyjbxxLw;
    }

    @Override
    public int savePartyUserZn(ZzRyjbxx zzRyjbxx) {
        int result = 0;
        ZzRyjbxx model = getPartyUserByIdZn(zzRyjbxx.getRyjbxxbs());
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getRyjbxxbs()))) {
            result = zzRyjbxxMapper.insert(zzRyjbxx);
        } else {
            ZzRyjbxxExample exp = new ZzRyjbxxExample();
            ZzRyjbxxExample.Criteria cri = exp.or();
            cri.andRyjbxxbsEqualTo(zzRyjbxx.getRyjbxxbs());
            result = zzRyjbxxMapper.updateByExampleSelective(zzRyjbxx, exp);
        }

        /*GgZgjbxx model_rs = getPartyUserByIdRs(rsRyjbxx.getRybm());
        if (model_rs == null || (model_rs != null && stringUtils.IsNullOrEmpty(model_rs.getRybm()))) {
            result = ggZgjbxxMapper.insert(rsRyjbxx);
        } else {
            GgZgjbxxExample exp = new GgZgjbxxExample();
            GgZgjbxxExample.Criteria cri = exp.or();
            cri.andRybmEqualTo(rsRyjbxx.getRybm());
            result = ggZgjbxxMapper.updateByExampleSelective(rsRyjbxx, exp);
        }*/

        return result;
    }

    @Override
    public int savePartyUserLw(ZzRyjbxxLw zzRyjbxxLw) {
        int result = 0;
        ZzRyjbxxLw model = getPartyUserByIdLw(zzRyjbxxLw.getLwryjbxxbs());
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getLwryjbxxbs()))) {
            result = zzRyjbxxLwMapper.insert(zzRyjbxxLw);
        } else {
            ZzRyjbxxLwExample exp = new ZzRyjbxxLwExample();
            ZzRyjbxxLwExample.Criteria cri = exp.or();
            cri.andLwryjbxxbsEqualTo(zzRyjbxxLw.getLwryjbxxbs());
            result = zzRyjbxxLwMapper.updateByExampleSelective(zzRyjbxxLw, exp);
        }

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deletePartyUser(String rybm) {
        partyUserCquery.deleteDjxx(rybm);
        partyUserCquery.deleteRyjbxxfb(rybm);
        partyUserCquery.deleteZzRyjbxx(rybm);
        partyUserCquery.deleteUserRole(rybm);
        partyUserCquery.deleteUser(rybm);
        return partyUserCquery.deleteGgZgjbxx(rybm);
    }


    @Override
    public PageInfo<HashMap<String, Object>> getDxzUserList(int pageNum, int pageSize,
                                                            String dzzdm, String rybm, String xm, String zzlb,
                                                            String zwjb, String sqrdrq_begin, String sqrdrq_end, String szdzb, String szdxz, List<String> removeUserList, List<String> removeUsersOfRybmList) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyUserCquery.selectDxzUserList(dzzdm, rybm, xm, zzlb, zwjb, sqrdrq_begin, sqrdrq_end, szdzb, szdxz, removeUserList, removeUsersOfRybmList);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getUserChangeDzzList(int pageNum, int pageSize,
                                                                  String rybm, String xm, String zlzbrq_begin, String zlzbrq_end, String dzzdm, Integer zzfbType) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyUserCquery.selectUserChangeDzzList(rybm, xm, zlzbrq_begin, zlzbrq_end, dzzdm, zzfbType);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public ZzZzgxxx getUserChangeById(String id) {
        ZzZzgxxx zzZzgxxx = new ZzZzgxxx();
        ZzZzgxxxExample exp = new ZzZzgxxxExample();
        ZzZzgxxxExample.Criteria cri = exp.or();
        cri.andZzgxxxbsEqualTo(id);
        List<ZzZzgxxx> list = zzZzgxxxMapper.selectByExample(exp);
        if (list.size() > 0) {
            zzZzgxxx = list.get(0);
        }
        return zzZzgxxx;
    }

    @Override
    public int saveUserChange(ZzZzgxxx zzZzgxxx) {
        int result = 0;
        ZzZzgxxx model = getUserChangeById(zzZzgxxx.getZzgxxxbs());
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getZzgxxxbs()))) {
            result = zzZzgxxxMapper.insert(zzZzgxxx);
        } else {
            ZzZzgxxxExample exp = new ZzZzgxxxExample();
            ZzZzgxxxExample.Criteria cri = exp.or();
            cri.andZzgxxxbsEqualTo(zzZzgxxx.getZzgxxxbs());
            result = zzZzgxxxMapper.updateByExampleSelective(zzZzgxxx, exp);
        }

        return result;
    }

    @Override
    public int auditChange(List<String> idList, Boolean isPass) {
        int result = 0;

        for (int i = 0; i < idList.size(); i++) {
            String id = idList.get(i);
            ZzZzgxxx model = getUserChangeById(id);
            model.setUserpartychangestatus(isPass ? 2 : 3);
            model.setAudittime(new Date());
            if (isPass) {
                //更新成员党组织代码
                ZzRyjbxx zzRyjbxx = getPartyUserByRybmZn(model.getRybm());
                if (zzRyjbxx != null && !stringUtils.IsNullOrEmpty(zzRyjbxx.getRyjbxxbs())) {
                    zzRyjbxx.setSzdzbdm(model.getNewdzzdm());

                    ZzRyjbxxExample exp = new ZzRyjbxxExample();
                    ZzRyjbxxExample.Criteria cri = exp.or();
                    cri.andRybmEqualTo(model.getRybm());
                    zzRyjbxxMapper.updateByExampleSelective(zzRyjbxx, exp);
                }
            }

            ZzZzgxxxExample exp = new ZzZzgxxxExample();
            ZzZzgxxxExample.Criteria cri = exp.or();
            cri.andZzgxxxbsEqualTo(model.getZzgxxxbs());

            result += zzZzgxxxMapper.updateByExampleSelective(model, exp);
        }

        return result;
    }

    @Override
    public int deleteUserChangeById(String id) {
        ZzZzgxxxExample exp = new ZzZzgxxxExample();
        ZzZzgxxxExample.Criteria cri = exp.or();
        cri.andZzgxxxbsEqualTo(id);
        return zzZzgxxxMapper.deleteByExample(exp);
    }

    @Override
    /**
     * @Description //TODO 查询未入党的职工基本信息
     * @date 2024-08
     * @Param [pageNum, pageSize, rybm, xm]
     **/
    public PageInfo<HashMap<String, Object>> getWsdzgjbxxList(int pageNum, int pageSize,
                                                              String rybm, String xm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyUserCquery.selectWsdzgjbxxList(rybm, xm);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }


    /**
     * @Description //TODO 支委会开会领导成员
     * @date 2024-08
     * @Param [pageNum, pageSize, szdzbdm, rybm, xm, userIdList, removeUserList, removeUsersOfRybmList]
     **/
    @Override
    public PageInfo<HashMap<String, Object>> getLeaderUserList(int pageNum, int pageSize,
                                                               String dzzdm,
                                                               String szdzbdm, String rybm, String xm,
                                                               List<String> userIdList, List<String> removeUserList, List<String> removeUsersOfRybmList) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyUserCquery.selectLeaderUserList(dzzdm, szdzbdm, rybm, xm, userIdList, removeUserList, removeUsersOfRybmList);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    /**
     * @Description //TODO 党员副表信息
     * @date 2024-08
     * @Param [rybm:人员编码]
     **/
    @Override
    public RsRyjbxxfb getUserFbInfo(String rybm) {
        return rsRyjbxxfbMapper.selectByPrimaryKey(rybm);
    }

    /**
     * @Description //TODO 党员党籍信息
     * @date 2024-08
     * @Param [rybm:人员编码]
     **/
    @Override
    public ZzDjxx getUserDjxxById(String rybm) {
        ZzDjxx zzDjxx = new ZzDjxx();
        if (!stringUtils.IsNullOrEmpty(rybm)) {
            ZzDjxxExample exp = new ZzDjxxExample();
            ZzDjxxExample.Criteria cri = exp.or();
            cri.andRybmEqualTo(rybm);
            List<ZzDjxx> list = zzDjxxMapper.selectByExample(exp);
            if (list.size() > 0) {
                zzDjxx = list.get(0);
            }
        }
        return zzDjxx;
    }

    /**
     * @Description //TODO 党员党籍信息_副表
     * @date 2024-08
     * @Param [rybm:人员编码]
     **/
    @Override
    public ZzDjxxfb getUserDjxxFBById(String rybm) {
        ZzDjxxfb zzDjxx = new ZzDjxxfb();
        if (!stringUtils.IsNullOrEmpty(rybm)) {
            ZzDjxxfbExample exp = new ZzDjxxfbExample();
            ZzDjxxfbExample.Criteria cri = exp.or();
            cri.andRybmEqualTo(rybm);
            List<ZzDjxxfb> list = zzDjxxfbMapper.selectByExample(exp);
            if (list.size() > 0) {
                zzDjxx = list.get(0);
            }
        }
        return zzDjxx;
    }

    @Override
    public int savePartyUser(GgZgjbxx ggZgjbxx, ZzRyjbxx zzRyjbxx, RsRyjbxxfb rsRyjbxxfb, ZzDjxx zzDjxx) {
        int result = 0;

        GgZgjbxx model_rs = getPartyUserByIdRs(ggZgjbxx.getRybm());
        if (model_rs == null || (model_rs != null && stringUtils.IsNullOrEmpty(model_rs.getRybm()))) {
            result = ggZgjbxxMapper.insert(ggZgjbxx);
        } else {
            GgZgjbxxExample exp = new GgZgjbxxExample();
            GgZgjbxxExample.Criteria cri = exp.or();
            cri.andRybmEqualTo(ggZgjbxx.getRybm());
            result = ggZgjbxxMapper.updateByExample(ggZgjbxx, exp);
        }

        ZzRyjbxx model = getPartyUserByIdZn(zzRyjbxx.getRyjbxxbs());
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getRyjbxxbs()))) {
            result = zzRyjbxxMapper.insert(zzRyjbxx);
        } else {
            ZzRyjbxxExample exp = new ZzRyjbxxExample();
            ZzRyjbxxExample.Criteria cri = exp.or();
            cri.andRyjbxxbsEqualTo(zzRyjbxx.getRyjbxxbs());
            result = zzRyjbxxMapper.updateByExampleSelective(zzRyjbxx, exp);
        }

        RsRyjbxxfb fbDbModel = getUserFbInfo(rsRyjbxxfb.getRybm());
        if (fbDbModel == null || (fbDbModel != null && stringUtils.IsNullOrEmpty(fbDbModel.getRybm()))) {
            rsRyjbxxfb.setApplyapprovestatus(2);
            rsRyjbxxfbMapper.insert(rsRyjbxxfb);
        } else {
            rsRyjbxxfbMapper.updateByPrimaryKey(rsRyjbxxfb);
        }

        ZzDjxx djModel = getUserDjxxById(zzDjxx.getRybm());
        if (djModel == null || (djModel != null && stringUtils.IsNullOrEmpty(djModel.getRybm()))) {
            zzDjxx.setDjxxbs(UUID.randomUUID().toString());
            zzDjxxMapper.insert(zzDjxx);
        } else {
            ZzDjxxExample exp = new ZzDjxxExample();
            ZzDjxxExample.Criteria cri = exp.or();
            cri.andRybmEqualTo(zzDjxx.getRybm());
            zzDjxxMapper.updateByExampleSelective(zzDjxx, exp);
        }

        /*ZzDjxxfb fbDjModel = getUserDjxxFBById(zzDjxx.getRybm());
        if (fbDjModel == null || (fbDjModel != null && stringUtils.IsNullOrEmpty(fbDjModel.getRybm()))) {
            result = zzDjxxfbMapper.insert(zzDjxxfb);
        } else {
            result = zzDjxxfbMapper.updateByPrimaryKey(zzDjxxfb);
        }*/

        //保存联系点

       /* deleteUserContactpoint(rsRyjbxxfb.getRybm());

        for (String lxdDzzdm : lxdDzzdmList) {
            if (!stringUtils.IsNullOrEmpty(lxdDzzdm)) {
                UsUsercontactpoint usUsercontactpoint = new UsUsercontactpoint();
                usUsercontactpoint.setId(UUID.randomUUID().toString());
                usUsercontactpoint.setRybm(rsRyjbxxfb.getRybm());
                usUsercontactpoint.setDzzdm(lxdDzzdm);

                usUsercontactpointMapper.insert(usUsercontactpoint);

            }
        }*/

        return result;
    }

    public void deleteUserContactpoint(String rybm) {
        if (!stringUtils.IsNullOrEmpty(rybm)) {
            UsUsercontactpointExample exp = new UsUsercontactpointExample();
            UsUsercontactpointExample.Criteria cri = exp.or();
            cri.andRybmEqualTo(rybm);

            usUsercontactpointMapper.deleteByExample(exp);
        }
    }

    @Override
    public List<HashMap<String, Object>> getUserContactpoint(String rybm) {
        return partyUserCquery.selectUserContactpoint(rybm);
    }

    @Override
    public HashMap<String, Object> getzzzdZzqkName(String bm) {
        return partyUserCquery.getZZZD_ZZQK_Name(bm);
    }

    @Override
    public PageInfo<HashMap<String, Object>> getMzpyList(int pageNum, int pageSize, String rybm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyUserCquery.selectMZPYList(rybm);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getPxqkList(int pageNum, int pageSize, String rybm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = partyUserCquery.selectPXQKList(rybm);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }


    @Override
    public PageInfo<HashMap<String, Object>> getPartyUserListForSearch(int pageNum, int pageSize,
                                                                       String dzzdm, String dzzmc, String xm, String csrq_begin, String csrq_end,
                                                                       String rdsj_begin, String rdsj_end, String zzsj_begin, String zzsj_end,
                                                                       String jg, List<String> dnzw, List<String> xzzw, List<String> jszw,
                                                                       List<String> xl, List<String> xb, List<String> gwzt,
                                                                       List<String> zzmm, List<String> mz, Integer pxpy_year, Integer pxpy_level, List<Integer> pxpy_type, Integer sfzyxq, String curUserId, Integer age_begin, Integer age_end) {

        PageHelper.startPage(pageNum, pageSize);

        /*boolean isLead = true;
        //包括领导人信息为空就不是相对接口
        if (curUserId != null) {
            isLead = appConfig.leadUids.contains(curUserId);
        }*/
        List<HashMap<String, Object>> list = partyUserCquery.selectPartyUserListForSearch(dzzdm, dzzmc, xm, csrq_begin, csrq_end, rdsj_begin, rdsj_end, zzsj_begin, zzsj_end, jg, dnzw, xzzw, jszw, xl, xb, gwzt, zzmm, mz, pxpy_year, pxpy_level, pxpy_type, sfzyxq, null, age_begin, age_end);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;

    }


    @Override
    public HashMap<String, Object> getAllUserInfoByRybm(String rybm) {
        HashMap<String, Object> result = new HashMap<>();
        if (!stringUtils.IsNullOrEmpty(rybm)) {
            PageHelper.startPage(1, 1);
            List<HashMap<String, Object>> list = partyUserCquery.selectAllUserList(null, null, null, rybm, null, null, null, null, null, null,null);
            if (list.size() > 0) {
                result = list.get(0);
            }
        }
        return result;
    }

    @Override
    public PartyUserInfoVo getUserInfo(String rybm) {
        PartyUserInfoVo data = partyUserCquery.selectUserInfo(rybm);
        ZzZzqkxx dwModel = partyService.getUserDwInfo(data.getSzdzbdm());
        data.setContactpoint(String.join(",", getUserContactpoint(rybm).stream().filter(it -> it.get("DZZMC") != null).map(it -> it.get("DZZMC").toString()).collect(Collectors.toList())));
        data.setDwname(dwModel != null ? dwModel.getDzzmc() : "");
        return data;
    }

    @Override
    public List<UserLeaderTotalVo> getUserLeaderTotalList(String rybm, Integer year, Integer quarter) {
        return partyUserCquery.selectUserLeaderTotalList(rybm, year, quarter);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<UserInfoVo> importUser(List<UserInfoVo> dataList) throws Exception {
        if (dataList.size() <= 0) {
            throw new Exception("请添加导入数据");
        }
        List<UserInfoVo> errorList = new ArrayList<>();
        List<CfUsers> cfUsersList = new ArrayList<>();
        List<GgZgjbxx> ggZgjbxxList = new ArrayList<>();
        List<ZzRyjbxx> zzRyjbxxList = new ArrayList<>();
        List<ZzDjxx> zzDjxxList = new ArrayList<>();
        List<RsRyjbxxfb> rsRyjbxxfbList = new ArrayList<>();

        List<String> userLoginIdList = dataList.stream().filter(it -> !stringUtils.IsNullOrEmpty(it.getMobile())).map(it -> it.getMobile().trim()).collect(Collectors.toList());
        List<String> userCodes = dataList.stream().filter(it -> !stringUtils.IsNullOrEmpty(it.getUserCode())).map(it -> it.getUserCode().trim()).collect(Collectors.toList());
        List<String> partyNames = dataList.stream().filter(it -> !stringUtils.IsNullOrEmpty(it.getPartyName())).map(it -> it.getPartyName().trim()).collect(Collectors.toList());
        List<HashMap<String, Object>> educationList = partyDicService.getEducationList();
        List<HashMap<String, Object>> nationList = partyDicService.getNationList();
        List<ZzzdRyzt> ryztList = partyDicService.getRyztList();
        List<ZzZzqkxx> zzZzqkxxList = getZzZzqkxxByNameList(partyNames);
        List<CfUsers> dbCfUsersList = getCfUsersList(userCodes);
        List<GgZgjbxx> dbGgZgjbxxList = getGgZgjbxxList(userCodes);
        List<ZzRyjbxx> dbZzRyjbxxList = getZzRyjbxxList(userCodes);
        List<ZzDjxx> dbZzDjxxList = getZzDjxxList(userCodes);
        List<RsRyjbxxfb> dbRsRyjbxxfbList = getRsRyjbxxfbList(userCodes);

        List<CfUsers> dbLoginUserList = getCfUsersListByLoginId(userLoginIdList);

        if (userLoginIdList.stream().distinct().count() != userLoginIdList.size()) {
            throw new Exception("导入数据存在相同学号/工号，请修改后重新导入！");
        }
        if (userCodes.stream().distinct().count() != userCodes.size()) {
            throw new Exception("导入数据存在相同党员编码，请修改后重新导入！");
        }

        for (int i = 0; i < dataList.size(); i++) {
            UserInfoVo item = dataList.get(i);

            GgZgjbxx ggZgjbxx = dbGgZgjbxxList.stream().filter(it -> it.getRybm().equals(item.getUserCode())).findFirst().orElse(new GgZgjbxx());
            ZzRyjbxx zzRyjbxx = dbZzRyjbxxList.stream().filter(it -> it.getRybm().equals(item.getUserCode())).findFirst().orElse(new ZzRyjbxx());
            ZzDjxx zzDjxx = dbZzDjxxList.stream().filter(it -> it.getRybm().equals(item.getUserCode())).findFirst().orElse(new ZzDjxx());
            CfUsers cfUsers = dbCfUsersList.stream().filter(it -> it.getUserid().equals(item.getUserCode())).findFirst().orElse(new CfUsers());
            RsRyjbxxfb rsRyjbxxfb = dbRsRyjbxxfbList.stream().filter(it -> it.getRybm().equals(item.getUserCode())).findFirst().orElse(new RsRyjbxxfb());
            ZzZzqkxx party = zzZzqkxxList.stream().filter(it -> it.getDzzmc().equals(item.getPartyName())).findFirst().orElse(null);

            String errorInfo = "";
            Date birthDate = dateUtils.strToDateExt(item.getBirthDate());
            Date inPartyDate = dateUtils.strToDateExt(item.getInPartyDate());
            Date enrollmentDate = dateUtils.strToDateExt(item.getEnrollmentDate());
            Date graduateDate = dateUtils.strToDateExt(item.getGraduateDate());
            Date workDate = dateUtils.strToDateExt(item.getWorkDate());

            if (stringUtils.IsNullOrEmpty(item.getUserName()))
                errorInfo += "请填写党员姓名!";
            if (stringUtils.IsNullOrEmpty(item.getUserCode()))
                errorInfo += "请填写党员编码!";
            if (stringUtils.IsNullOrEmpty(item.getMobile()))
                errorInfo += "请填写学号/工号!";
            if (stringUtils.IsNullOrEmpty(item.getPartyName()))
                errorInfo += "请填写所属党支部名称!";
            if (stringUtils.IsNullOrEmpty(item.getBirthDate()))
                errorInfo += "请填写出生日期!";
            if (stringUtils.IsNullOrEmpty(item.getInPartyDate()))
                errorInfo += "请填写入党日期!";
            if (stringUtils.IsNullOrEmpty(item.getPoliticalStatus()))
                errorInfo += "请填写政治面貌!";
            if (stringUtils.IsNullOrEmpty(item.getIsStudent()))
                errorInfo += "请填写是否学生身份!";
            if (!stringUtils.IsNullOrEmpty(item.getMobile()) && dbLoginUserList.stream().filter(e -> !e.getUserid().equals(item.getUserCode()) && e.getUsername().equals(item.getMobile())).count() > 0)
                errorInfo += "该学号/工号已关联其他用户!";
            if (party == null)
                errorInfo += "所属党支部名称匹配失败!";
            if (!stringUtils.IsNullOrEmpty(item.getBirthDate()) && birthDate == null)
                errorInfo += "出生日期格式错误!";
            if (!stringUtils.IsNullOrEmpty(item.getInPartyDate()) && inPartyDate == null)
                errorInfo += "入党日期格式错误!";
            if (!stringUtils.IsNullOrEmpty(item.getEnrollmentDate()) && enrollmentDate == null)
                errorInfo += "最高学历入学日期格式错误!";
            if (!stringUtils.IsNullOrEmpty(item.getGraduateDate()) && graduateDate == null)
                errorInfo += "最高学历毕业日期格式错误!";
            if (!stringUtils.IsNullOrEmpty(item.getWorkDate()) && workDate == null)
                errorInfo += "工作时间格式错误!";
            if (ryztList.size() > 0 && !stringUtils.IsNullOrEmpty(item.getPoliticalStatus())) {
                List<ZzzdRyzt> ryzt = ryztList.stream().filter(it -> it.getHzmc().equals(item.getPoliticalStatus().trim())).collect(Collectors.toList());
                if (ryzt.size() > 0) {
                    zzRyjbxx.setRyzt(ryzt.get(0).getBm());
                }
            }
            if (educationList.size() > 0 && !stringUtils.IsNullOrEmpty(item.getEducation())) {
                List<HashMap<String, Object>> education = educationList.stream().filter(it -> it.get("HZMC").toString().equals(item.getEducation().trim())).collect(Collectors.toList());
                if (education.size() > 0) {
                    ggZgjbxx.setQrzxl(education.get(0).get("BM").toString());
                }
            }
            if (nationList.size() > 0 && !stringUtils.IsNullOrEmpty(item.getNational())) {
                List<HashMap<String, Object>> nation = nationList.stream().filter(it -> it.get("HZMC").toString().equals(item.getNational().trim())).collect(Collectors.toList());
                if (nation.size() > 0) {
                    ggZgjbxx.setMz(nation.get(0).get("BM").toString());
                }
            }

            if (stringUtils.IsNullOrEmpty(errorInfo)) {
                ggZgjbxx.setRybm(item.getUserCode());
                ggZgjbxx.setXm(item.getUserName().replaceAll("\\s+",""));
                ggZgjbxx.setJg(item.getNativePlace());
                ggZgjbxx.setXb(item.getSex().equals("男") ? "1" : "2");
                ggZgjbxx.setCsrq(birthDate);
                ggZgjbxx.setSfzh(item.getIdCard());

                if (stringUtils.IsNullOrEmpty(zzRyjbxx.getRyjbxxbs()))
                    zzRyjbxx.setRyjbxxbs(UUID.randomUUID().toString());
                zzRyjbxx.setRybm(item.getUserCode());
                zzRyjbxx.setSzdzbdm(party.getDzzdm());

                if (stringUtils.IsNullOrEmpty(zzDjxx.getDjxxbs()))
                    zzDjxx.setDjxxbs(UUID.randomUUID().toString());
                zzDjxx.setRybm(item.getUserCode());
                if (inPartyDate != null)
                    zzDjxx.setJrzgzzrq(dateUtils.dateToStrFormat(inPartyDate, "yyyyMMdd"));

                cfUsers.setUserid(item.getUserCode());
                cfUsers.setUsername(item.getMobile());
                cfUsers.setApplicationid("f0c4fa7f9f3c4fb6bd56aac608b7ad3f");
                cfUsers.setIsanonymous(1);
                if (stringUtils.IsNullOrEmpty(cfUsers.getUserpwd()))
                    cfUsers.setUserpwd("D6FB6D8741F9AF9E7BC1C39E79D73944");

                rsRyjbxxfb.setRybm(item.getUserCode());
                rsRyjbxxfb.setGradename(item.getGradeName());
                rsRyjbxxfb.setClassname(item.getClassName());
                rsRyjbxxfb.setEnrollmentdate(enrollmentDate);
                rsRyjbxxfb.setGraduatedate(graduateDate);
                rsRyjbxxfb.setWorkdate(workDate);
                rsRyjbxxfb.setMobile(item.getContactMobile());
                rsRyjbxxfb.setTechnologyposition(item.getTechnologyPosition());
                rsRyjbxxfb.setIsstudent(item.getIsStudent().equals("是") ? true : false);
                rsRyjbxxfb.setApplyapprovestatus(2);

                ggZgjbxxList.add(ggZgjbxx);
                zzRyjbxxList.add(zzRyjbxx);
                zzDjxxList.add(zzDjxx);
                cfUsersList.add(cfUsers);
                rsRyjbxxfbList.add(rsRyjbxxfb);
            } else {
                item.setErrorInfo("第" + (i + 1) + "行，" + errorInfo);
                errorList.add(item);
            }
        }

        if (errorList.size() <= 0) {
            ggZgjbxxList.forEach(item -> {
                if (dbGgZgjbxxList.stream().filter(it -> it.getRybm().equals(item.getRybm())).count() == 0) {
                    ggZgjbxxMapper.insert(item);
                } else {
                    GgZgjbxxExample exp = new GgZgjbxxExample();
                    GgZgjbxxExample.Criteria cri = exp.or().andRybmEqualTo(item.getRybm());
                    ggZgjbxxMapper.updateByExample(item, exp);
                }
            });
            zzRyjbxxList.forEach(item -> {
                if (dbZzRyjbxxList.stream().filter(it -> it.getRybm().equals(item.getRybm())).count() == 0) {
                    zzRyjbxxMapper.insert(item);
                } else {
                    ZzRyjbxxExample exp = new ZzRyjbxxExample();
                    ZzRyjbxxExample.Criteria cri = exp.or().andRybmEqualTo(item.getRybm());
                    zzRyjbxxMapper.updateByExample(item, exp);
                }
            });
            zzDjxxList.forEach(item -> {
                if (dbZzDjxxList.stream().filter(it -> it.getRybm().equals(item.getRybm())).count() == 0) {
                    zzDjxxMapper.insert(item);
                } else {
                    ZzDjxxExample exp = new ZzDjxxExample();
                    ZzDjxxExample.Criteria cri = exp.or().andRybmEqualTo(item.getRybm());
                    zzDjxxMapper.updateByExample(item, exp);
                }
            });
            cfUsersList.forEach(item -> {
                if (dbCfUsersList.stream().filter(it -> it.getUserid().equals(item.getUserid())).count() == 0) {
                    cfUsersMapper.insert(item);
                } else {
                    cfUsersMapper.updateByPrimaryKey(item);
                }
            });
            rsRyjbxxfbList.forEach(item -> {
                if (dbRsRyjbxxfbList.stream().filter(it -> it.getRybm().equals(item.getRybm())).count() == 0) {
                    rsRyjbxxfbMapper.insert(item);
                } else {
                    rsRyjbxxfbMapper.updateByPrimaryKey(item);
                }
            });
        }

        return errorList;
    }

    public List<CfUsers> getCfUsersList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        CfUsersExample exp = new CfUsersExample();
        CfUsersExample.Criteria cri = exp.or().andUseridIn(ids);
        return cfUsersMapper.selectByExample(exp);
    }

    public List<CfUsers> getCfUsersListByLoginId(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        CfUsersExample exp = new CfUsersExample();
        CfUsersExample.Criteria cri = exp.or().andUsernameIn(ids);
        return cfUsersMapper.selectByExample(exp);
    }

    public List<GgZgjbxx> getGgZgjbxxList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        GgZgjbxxExample exp = new GgZgjbxxExample();
        GgZgjbxxExample.Criteria cri = exp.or().andRybmIn(ids);
        return ggZgjbxxMapper.selectByExample(exp);
    }

    public List<ZzRyjbxx> getZzRyjbxxList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        ZzRyjbxxExample exp = new ZzRyjbxxExample();
        ZzRyjbxxExample.Criteria cri = exp.or().andRybmIn(ids);
        return zzRyjbxxMapper.selectByExample(exp);
    }

    public List<ZzDjxx> getZzDjxxList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        ZzDjxxExample exp = new ZzDjxxExample();
        ZzDjxxExample.Criteria cri = exp.or().andRybmIn(ids);
        return zzDjxxMapper.selectByExample(exp);
    }

    public List<ZzZzqkxx> getZzZzqkxxList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        ZzZzqkxxExample exp = new ZzZzqkxxExample();
        ZzZzqkxxExample.Criteria cri = exp.or().andDzzdmIn(ids);
        return zzZzqkxxMapper.selectByExample(exp);
    }

    public List<ZzZzqkxx> getZzZzqkxxByNameList(List<String> names){
        if (names.size() == 0)
            return new ArrayList<>();
        ZzZzqkxxExample exp = new ZzZzqkxxExample();
        ZzZzqkxxExample.Criteria cri = exp.or().andDzzmcIn(names);
        return zzZzqkxxMapper.selectByExample(exp);
    }

    public List<RsRyjbxxfb> getRsRyjbxxfbList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        RsRyjbxxfbExample exp = new RsRyjbxxfbExample();
        RsRyjbxxfbExample.Criteria cri = exp.or().andRybmIn(ids);
        return rsRyjbxxfbMapper.selectByExample(exp);
    }

    public List<CfUserrolesKey> getCfUserroleList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        CfUserrolesExample exp = new CfUserrolesExample();
        CfUserrolesExample.Criteria cri = exp.or().andUseridIn(ids);
        return cfUserrolesMapper.selectByExample(exp);
    }


    @Override
    public Integer batchInsertUserPartyOfMonth(Integer yearMonth){
        return partyUserCquery.batchInsertUserPartyOfMonth(yearMonth);
    }

    /*@Override
    public Integer batchUpdateUserPartyOfMonth(Integer yearMonth){
        return partyUserCquery.batchUpdateUserPartyOfMonth(yearMonth);
    }*/
}
