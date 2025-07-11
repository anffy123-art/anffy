package com.px.partybuild.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.*;
import com.px.partybuild.service.*;
import com.px.partybuild.util.*;
import com.px.partybuild.vo.UserInfoVo;
import com.px.partybuild.vo.UserMobileVo;
import com.px.partybuild.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/partyUser")
public class PartyUserController {

    @Autowired
    PartyUserService partyUserService;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private PartyService partyService;
    @Autowired
    private UserService userService;
    @Autowired
    private PartyDicService partyDicService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private MapUtils mapUtils;
    @Autowired
    private RandomStringUtil randomStringUtil;

    private Pattern mobilePattern = Pattern.compile("\\s*|\t|\r|\n");

    /**
     * @Description //TODO 查询党员信息(手机端共用方法)
     * @date 2024-08
     * @Param [pageIndex, pageSize, dzzdm, rybm, xm, zzlb, zwjb, sqrdrq_begin, sqrdrq_end, szdzb, szdxz, userIds]
     **/
    @ResponseBody
    @GetMapping("/getPartyUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getPartyUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam(required = false) String xb,
                                                                           @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String rybm, @RequestParam(required = false) String xm, @RequestParam(required = false) String zzlb,
                                                                           @RequestParam(required = false) String zwjb, @RequestParam(required = false) String sqrdrq_begin, @RequestParam(required = false) String sqrdrq_end
            , @RequestParam(required = false) String szdzb, @RequestParam(required = false) String szdxz,
                                                                           @RequestParam(required = false) String userIds, @RequestParam(required = false) String ryzt, @RequestParam(required = false) String removeUsers, @RequestParam(required = false) String szdzbdm, @RequestParam(required = false) String rybm_list,
                                                                           @RequestParam(required = false) Integer zzfbType,
                                                                           @RequestParam(required = false) String removeUserRybm,
                                                                           @RequestParam(required = false) String mz, @RequestParam(required = false) String dnzw, @RequestParam(required = false) String xl,
                                                                           @RequestParam(required = false) Integer age_begin, @RequestParam(required = false) Integer age_end, @RequestParam(required = false) Integer sfsldry,
                                                                           @RequestParam(required = false) String zwmc, @RequestParam(required = false) Integer sfzg, @RequestParam(required = false) String jczzfl, @RequestParam(required = false) String leadId, @RequestParam(required = false) String partyGroupId
            , @RequestParam(required = false) String mobile,@RequestParam(required = false) Integer isStudent,@RequestParam(required = false) Integer leaderTeamUserType) {

        sqrdrq_begin = dateUtils.strFormat_short(sqrdrq_begin);
        sqrdrq_end = dateUtils.strFormat_short(sqrdrq_end);

        List<String> userIdList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(userIds)) {
            userIdList = Arrays.asList(userIds.split(","));
        }

        List<String> ryztList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(ryzt)) {
            ryztList = Arrays.asList(ryzt.split(","));
        }

        //需排除的人员id
        List<String> removeUserList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(removeUsers)) {
            removeUserList = Arrays.asList(removeUsers.split(","));
        }

        //指定查询的人员编码
        List<String> rybmList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(rybm_list)) {
            rybmList = Arrays.asList(rybm_list.split(","));
        }

        //需排除的人员编码
        List<String> removeUserRybmList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(removeUserRybm)) {
            removeUserRybmList = Arrays.asList(removeUserRybm.split(","));
        }


        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getPartyUserList(pageIndex, pageSize, xb, dzzdm, rybm, xm, zzlb, zwjb, sqrdrq_begin, sqrdrq_end, szdzb, szdxz,
                userIdList, ryztList, removeUserList, szdzbdm, removeUserRybmList, rybmList, zzfbType, mz, dnzw, xl, age_begin, age_end, sfsldry, zwmc, sfzg, jczzfl, leadId, partyGroupId, mobile,isStudent,leaderTeamUserType));
        return result;
    }

    @ResponseBody
    @GetMapping("/getAllUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getAllUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam(required = false) String dzzdm
            , @RequestParam(required = false) String szdzbdm, @RequestParam(required = false) String zzlb, @RequestParam(required = false) String rybm, @RequestParam(required = false) String xm
            , @RequestParam(required = false) String xb, @RequestParam(required = false) String mz, @RequestParam(required = false) String xl, @RequestParam(required = false) String mobile, @RequestParam(required = false) String ryzt
            , @RequestParam(required = false) String userNo) {

        List<String> ryztList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(ryzt)) {
            ryztList = Arrays.asList(ryzt.split(","));
        }

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getAllUserList(pageIndex, pageSize, dzzdm, szdzbdm, zzlb, rybm, xm, xb, mz, xl, mobile,ryztList,userNo));
        return result;
    }


    @RequestMapping(value = "/exportPartyUser", method = RequestMethod.GET)
    public void exportPartyUser(HttpServletResponse response,
                                @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String rybm, @RequestParam(required = false) String xm, @RequestParam(required = false) String zzlb,
                                @RequestParam(required = false) String zwjb, @RequestParam(required = false) String sqrdrq_begin, @RequestParam(required = false) String sqrdrq_end
            , @RequestParam(required = false) String szdzb, @RequestParam(required = false) String szdxz, @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) String mz, @RequestParam(required = false) String dnzw, @RequestParam(required = false) String xl,
                                @RequestParam(required = false) Integer age_begin, @RequestParam(required = false) Integer age_end, @RequestParam(required = false) Integer sfsldry, @RequestParam(required = false) String zwmc, @RequestParam(required = false) Integer sfzg, @RequestParam(required = false) String jczzfl, @RequestParam(required = false) String leadId, @RequestParam(required = false) String partyGroupId
            , @RequestParam(required = false) String mobile,@RequestParam(required = false) Integer isStudent) throws Exception {

        sqrdrq_begin = dateUtils.strFormat_short(sqrdrq_begin);
        sqrdrq_end = dateUtils.strFormat_short(sqrdrq_end);

        /**查询数据**/
        List<HashMap<String, Object>> dataList = partyUserService.getPartyUserList(1, 1000000, null, dzzdm, rybm, xm, zzlb, zwjb, sqrdrq_begin, sqrdrq_end, szdzb, szdxz, null, null, null, null, null, null, zzfbType
                , mz, dnzw, xl, age_begin, age_end, sfsldry, zwmc, sfzg, jczzfl, leadId, null, mobile,isStudent,null).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党员基本信息");
        List<String> titles = new ArrayList();

        titles.add("姓名");
        titles.add("学号/工号");
        titles.add("政治面貌");
        titles.add("所在党组织");
        titles.add("入党时间");
        titles.add("性别");
        titles.add("民族");
        titles.add("出生日期");
        titles.add("籍贯");
        titles.add("身份证号");
        titles.add("年级");
        titles.add("班级");
        titles.add("学历");
        titles.add("最高学历入学日期");
        titles.add("最高学历毕业日期");
        titles.add("工作时间");
        titles.add("联系电话");
        titles.add("技术职务");

        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (HashMap<String, Object> item : dataList) {
            List<Object> row = new ArrayList();

            row.add(item.get("XM"));
            row.add(item.get("userNo"));
            row.add(item.get("RYZTMC"));
            row.add(item.get("DZZMC"));
            row.add(item.get("RDSJ"));
            row.add(item.get("XBMC"));
            row.add(item.get("MZMC"));
            row.add(item.get("CSRQ"));
            row.add(item.get("JG"));
            row.add(item.get("SFZH"));
            row.add(item.get("gradeName"));
            row.add(item.get("className"));
            row.add(item.get("XLMC"));
            row.add(item.get("enrollmentDate") != null ? dateUtils.strFormat(item.get("enrollmentDate").toString()) : "");
            row.add(item.get("graduateDate") != null ? dateUtils.strFormat(item.get("graduateDate").toString()) : "");
            row.add(item.get("workDate") != null ? dateUtils.strFormat(item.get("workDate").toString()) : "");
            row.add(item.get("contactMobile"));
            row.add(item.get("technologyPosition"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党员基本信息.xlsx", data);
    }

    @ResponseBody
    @RequestMapping("/getPartyUserByType")
    public RequsetData<Object> getPartyUserByType(@RequestParam("ut") String ut) {

        CfUsers user = userService.getLoginUser();

        RequsetData<Object> res = null;

        String rybm = user.getUserid();

        /*if ("1".equals(ut)) {
            res = this.getpartyuserbyidZn(rybm);
        } else {

            res = this.getpartyuserbyidLw(rybm);
        }*/

        res = this.getpartyuserbyidZn(rybm);

        return res;

    }


    @ResponseBody
    @RequestMapping("/getPartyUserById_ZN")
    public RequsetData<Object> getpartyuserbyidZn(@RequestParam("rybm") String rybm) {
        RequsetData<Object> res = new RequsetData<>();

        try {
            ZzRyjbxx model = partyUserService.getPartyUserByRybmZn(rybm);

            if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getRyjbxxbs()))) {
                UUID uuid = UUID.randomUUID();
                model = new ZzRyjbxx();
                model.setRyjbxxbs(uuid.toString());
                model.setRybm((dateUtils.getStringDateShort().replace("-", "") + randomStringUtil.getRandomCode(2, 4)));
            }

            model.setCgcjrq(dateUtils.strFormat_long(model.getCgcjrq()));
            model.setSqrdrq(dateUtils.strFormat_long(model.getSqrdrq()));
            model.setZjpxrq(dateUtils.strFormat_long(model.getZjpxrq()));
            model.setLwjjfzrq(dateUtils.strFormat_long(model.getLwjjfzrq()));
            model.setLwfzdxrq(dateUtils.strFormat_long(model.getLwfzdxrq()));
            model.setZbdhtgrq(dateUtils.strFormat_long(model.getZbdhtgrq()));
            model.setSjzzpzrq(dateUtils.strFormat_long(model.getSjzzpzrq()));

            GgZgjbxx model_rs = partyUserService.getPartyUserByIdRs(model.getRybm() == null ? "" : model.getRybm());
            if (model_rs == null || (model_rs != null && stringUtils.IsNullOrEmpty(model_rs.getRybm()))) {
                model_rs = new GgZgjbxx();
                model_rs.setRybm("");
                model_rs.setRybm(model.getRybm());
            }

            ZzZzqkxx zzZzqkxx = partyService.getPartyByDm(model.getSzdzbdm() == null ? "" : model.getSzdzbdm());

            HashMap<String, Object> extData = new HashMap<String, Object>();
            extData.put("user_rs", model_rs);
            extData.put("zzZzqkxx", zzZzqkxx);

            HashMap<String, Object> userInfo = partyUserService.getPartyUserInfoByRybm(model.getRybm());

            if (userInfo != null && userInfo.get("RYBM") != null) {
                extData.put("XBMC", userInfo.get("XBMC"));
                extData.put("MZMC", userInfo.get("MZMC"));
                extData.put("XLMC", userInfo.get("XLMC"));
                extData.put("ZWMC", userInfo.get("ZWMC"));
                extData.put("JSZWMC", userInfo.get("JSZWMC"));
                extData.put("DNZW", userInfo.get("DNZW"));
            }

            extData.put("mobile", userService.userIdToMobile(model.getRybm()));

            //副表信息
            RsRyjbxxfb fbModel = partyUserService.getUserFbInfo(model.getRybm());
            if (fbModel == null || (fbModel != null && stringUtils.IsNullOrEmpty(fbModel.getRybm()))) {
                fbModel = new RsRyjbxxfb();
            }

            //党籍信息
            ZzDjxx djxxModel = partyUserService.getUserDjxxById(model.getRybm());
            if (djxxModel == null || (djxxModel != null && stringUtils.IsNullOrEmpty(djxxModel.getRybm()))) {
                djxxModel = new ZzDjxx();
            }

            //党籍信息副表
            ZzDjxxfb djxxFBModel = partyUserService.getUserDjxxFBById(model.getRybm());
            if (djxxFBModel == null || (djxxFBModel != null && stringUtils.IsNullOrEmpty(djxxFBModel.getRybm()))) {
                djxxFBModel = new ZzDjxxfb();
            }

            djxxModel.setJrzgzzrq(dateUtils.strFormat_long(djxxModel.getJrzgzzrq()));
            djxxModel.setZzrq(dateUtils.strFormat_long(djxxModel.getZzrq()));
            djxxFBModel.setJrzbrq(dateUtils.strFormat_long(djxxFBModel.getJrzbrq()));

            String dwName = "";
            String dwid = "";
            if (!stringUtils.IsNullOrEmpty(model.getSzdzbdm())) {
                String dzzdm = model.getSzdzbdm().trim();
                if (!stringUtils.IsNullOrEmpty(dzzdm)) {
                    //ZzZzqkxx dwModel = partyService.getPartyByDm(dzzdm.length() > 12 ? dzzdm.substring(0, 12) : dzzdm);
                    ZzZzqkxx dwModel = partyService.getUserDwInfo(dzzdm);
                    if (dwModel != null) {
                        dwName = dwModel.getDzzmc();
                        dwid = dwModel.getDzzdm();
                    }
                }
            }

            if (djxxModel != null && org.apache.commons.lang3.StringUtils.isNotBlank(djxxModel.getZzqk())) {
                Map<String, Object> m_HZMC = partyUserService.getzzzdZzqkName(djxxModel.getZzqk());
                if (m_HZMC != null) {
                    extData.put("zzqkMC", m_HZMC.get("HZMC"));
                }
            }

            extData.put("dwName", dwName);//所属党委
            extData.put("dwid", dwid);//所属党委
            extData.put("fbModel", fbModel);//副表信息
            extData.put("djxxModel", djxxModel);//党籍信息
            extData.put("djxxFBModel", djxxFBModel);//党籍信息副表


            res.setExtdata(extData);
            res.setItem(model);

        } catch (Exception e) {
            res.setSuccess(false);
            res.setMsg(e.getMessage());
        }

        return res;
    }

    @ResponseBody
    @RequestMapping("/savePartyUser")
    public RequsetData<String> savePartyUser(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            GgZgjbxx ggZgjbxx = mapper.readValue(mapper.writeValueAsString(reqMap.get("ggZgjbxx")).toString(), GgZgjbxx.class);
            ZzRyjbxx zzRyjbxx = mapper.readValue(mapper.writeValueAsString(reqMap.get("dyModel")).toString(), ZzRyjbxx.class);

            zzRyjbxx.setCgcjrq(dateUtils.strFormat_short(zzRyjbxx.getCgcjrq()));
            zzRyjbxx.setSqrdrq(dateUtils.strFormat_short(zzRyjbxx.getSqrdrq()));
            zzRyjbxx.setZjpxrq(dateUtils.strFormat_short(zzRyjbxx.getZjpxrq()));
            zzRyjbxx.setLwjjfzrq(dateUtils.strFormat_short(zzRyjbxx.getLwjjfzrq()));
            zzRyjbxx.setLwfzdxrq(dateUtils.strFormat_short(zzRyjbxx.getLwfzdxrq()));
            zzRyjbxx.setZbdhtgrq(dateUtils.strFormat_short(zzRyjbxx.getZbdhtgrq()));
            zzRyjbxx.setSjzzpzrq(dateUtils.strFormat_short(zzRyjbxx.getSjzzpzrq()));

            String rybm = reqMap.get("rybm").toString();
            String mobile = reqMap.get("mobile") == null ? "" : reqMap.get("mobile").toString();

            if (!stringUtils.IsNullOrEmpty(mobile)) {
                String dbUserId = userService.mobiltToUserId(mobile);
                if (!stringUtils.IsNullOrEmpty(dbUserId) && !dbUserId.equals(rybm)) {
                    throw new Exception("学号/工号重复!");
                }
            }

            RsRyjbxxfb rsRyjbxxfb = mapper.readValue(mapper.writeValueAsString(reqMap.get("fbModel")).toString(), RsRyjbxxfb.class);
            ZzDjxx zzDjxx = mapper.readValue(mapper.writeValueAsString(reqMap.get("djxxModel")).toString(), ZzDjxx.class);

            zzDjxx.setJrzgzzrq(dateUtils.strFormat_short(zzDjxx.getJrzgzzrq()));
            zzDjxx.setZzrq(dateUtils.strFormat_short(zzDjxx.getZzrq()));


            rsRyjbxxfb.setRybm(rybm);
            zzDjxx.setRybm(rybm);

            count = partyUserService.savePartyUser(ggZgjbxx, zzRyjbxx, rsRyjbxxfb, zzDjxx);

            userService.saveUserMobile(rybm, mobile);

        } catch (Exception e) {

            e.printStackTrace();
            message = e.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！" + message);
        }
        return res;
    }

    @ResponseBody
    @RequestMapping("/deletePartyById_ZN")
    public RequsetData<String> deletePartyUser(@RequestParam("rybm") String rybm) {
        RequsetData<String> res = new RequsetData<>();
        int count = partyUserService.deletePartyUser(rybm);
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("删除成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("删除失败！");
        }
        return res;
    }

    /**
     * @Description //TODO 查询党小组成员
     * @date 2024-08
     * @Param [pageIndex, pageSize, dzzdm, rybm, xm, zzlb, zwjb, sqrdrq_begin, sqrdrq_end, szdzb, szdxz]
     **/
    @ResponseBody
    @GetMapping("/getDxzUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getDxzUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                         @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String rybm, @RequestParam(required = false) String xm, @RequestParam(required = false) String zzlb,
                                                                         @RequestParam(required = false) String zwjb, @RequestParam(required = false) String sqrdrq_begin, @RequestParam(required = false) String sqrdrq_end
            , @RequestParam(required = false) String szdzb, @RequestParam(required = false) String szdxz, @RequestParam(required = false) String removeUsers) {

        sqrdrq_begin = dateUtils.strFormat_short(sqrdrq_begin);
        sqrdrq_end = dateUtils.strFormat_short(sqrdrq_end);

        List<String> removeUserList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(removeUsers)) {
            removeUserList = Arrays.asList(removeUsers.split(","));
        }

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getDxzUserList(pageIndex, pageSize, dzzdm, rybm, xm, zzlb, zwjb, sqrdrq_begin, sqrdrq_end, szdzb, szdxz, removeUserList, null));
        return result;
    }


    /**
     * @Description //TODO 查询成员组织关系转接信息
     * @date 2024-08
     * @Param [pageIndex, pageSize, rybm, xm, zlzbrq_begin, zlzbrq_end]
     **/
    @ResponseBody
    @GetMapping("/getUserChangeDzzList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getUserChangeDzzList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                               @RequestParam(required = false) String rybm, @RequestParam(required = false) String xm, @RequestParam(required = false) String zlzbrq_begin, @RequestParam(required = false) String zlzbrq_end,
                                                                               @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer zzfbType) {

        zlzbrq_begin = dateUtils.strFormat_short(zlzbrq_begin);
        zlzbrq_end = dateUtils.strFormat_short(zlzbrq_end);

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getUserChangeDzzList(pageIndex, pageSize, rybm, xm, zlzbrq_begin, zlzbrq_end, dzzdm, zzfbType));
        return result;
    }

    @RequestMapping(value = "/exportUserChangeDzz", method = RequestMethod.GET)
    public void exportUserChangeDzz(HttpServletResponse response,
                                    @RequestParam(required = false) String rybm, @RequestParam(required = false) String xm, @RequestParam(required = false) String zlzbrq_begin, @RequestParam(required = false) String zlzbrq_end,
                                    @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer zzfbType) throws Exception {

        zlzbrq_begin = dateUtils.strFormat_short(zlzbrq_begin);
        zlzbrq_end = dateUtils.strFormat_short(zlzbrq_end);

        /**查询数据**/
        List<HashMap<String, Object>> dataList = partyUserService.getUserChangeDzzList(1, 100000, rybm, xm, zlzbrq_begin, zlzbrq_end, dzzdm, zzfbType).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党员组织关系转接信息");
        List<String> titles = new ArrayList();
        titles.add("党员编码");
        titles.add("姓名");
        titles.add("学号/工号");
        titles.add("调离前党支部名称");
        titles.add("转入党支部名称");
        titles.add("转支部日期");
        titles.add("转离支部类型");
        titles.add("进入支部类型");
        titles.add("状态");
        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (HashMap<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("RYBM"));
            row.add(item.get("XM"));
            row.add(item.get("userNo"));
            row.add(item.get("oldDzzmc"));
            row.add(item.get("newDzzmc"));
            row.add(item.get("ZLZBRQ"));
            row.add(item.get("ZLZBLX"));
            row.add(item.get("JRZBLX"));
            row.add(item.get("userPartyChangeStatusDesc"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党员组织关系转接信息.xlsx", data);
    }


    @ResponseBody
    @RequestMapping("/getUserChangeById")
    public RequsetData<ZzZzgxxx> getUserChangeById(@RequestParam("id") String id, @RequestParam(required = false) String parent_dzzdm) {
        RequsetData<ZzZzgxxx> res = new RequsetData<>();
        ZzZzgxxx model = partyUserService.getUserChangeById(id);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getZzgxxxbs()))) {
            UUID uuid = UUID.randomUUID();
            model = new ZzZzgxxx();
            model.setZzgxxxbs(uuid.toString());
            model.setUserpartychangestatus(1);
        }

        model.setJrzbrq(dateUtils.strFormat_long(model.getJrzbrq()));
        model.setZlzbrq(dateUtils.strFormat_long(model.getZlzbrq()));

        HashMap<String, Object> extData = new HashMap<String, Object>();

        HashMap<String, Object> userModel = new HashMap<>();
        if (!stringUtils.IsNullOrEmpty(model.getRybm())) {
            List<HashMap<String, Object>> users = partyUserService.getPartyUserList(1, 100, null, null, model.getRybm(), null, null, null, null, null, null, null,
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,null,null).getList();
            if (users.size() > 0) {
                userModel = users.get(0);
            }
        }
        extData.put("userModel", userModel);
        res.setExtdata(extData);

        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveUserChange")
    public RequsetData<String> saveUserChange(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            ZzZzgxxx model = mapper.readValue(mapper.writeValueAsString(reqMap.get("userChangeModel")), ZzZzgxxx.class);

            model.setJrzbrq(dateUtils.strFormat_short(model.getJrzbrq()));
            model.setZlzbrq(dateUtils.strFormat_short(model.getZlzbrq()));

            count = partyUserService.saveUserChange(model);
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("操作成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("操作失败！" + message);
        }
        return res;
    }

    @ResponseBody
    @RequestMapping("/auditChange")
    public RequsetData<String> auditChange(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<String> idList = JsonMapper.jsonToObject(reqMap.get("ids").toString(), new TypeReference<List<String>>() {
            });
            boolean isPass = mapper.readValue(mapper.writeValueAsString(reqMap.get("isPass")), boolean.class);
            count = partyUserService.auditChange(idList, isPass);
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("审核成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("审核失败！" + message);
        }
        return res;
    }

    @ResponseBody
    @RequestMapping("/deleteUserChange")
    public RequsetData<String> deleteUserChange(@RequestParam("id") String id) {
        RequsetData<String> res = new RequsetData<>();
        int count = partyUserService.deleteUserChangeById(id);
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("删除成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("删除失败！");
        }
        return res;
    }

    /**
     * @Description //TODO 查询未入党的职工基本信息
     * @date 2024-08
     * @Param [pageIndex, pageSize, rybm, xm]
     **/
    @ResponseBody
    @GetMapping("/getWsdzgjbxxList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getWsdzgjbxxList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                           @RequestParam(required = false) String rybm, @RequestParam(required = false) String xm) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getWsdzgjbxxList(pageIndex, pageSize, rybm, xm));
        return result;
    }

    /**
     * @Description //TODO 查询职工基本信息
     * @date 2024-08
     * @Param [rybm]
     **/
    @ResponseBody
    @RequestMapping("/getZgUserByRybm")
    public RequsetData<GgZgjbxx> getpartyuserbyidRs(@RequestParam("rybm") String rybm) {
        RequsetData<GgZgjbxx> res = new RequsetData<>();

        GgZgjbxx model = partyUserService.getPartyUserByIdRs(rybm);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getRybm()))) {
            model = new GgZgjbxx();
            model.setRybm("");
        }
        HashMap<String, Object> extData = new HashMap<String, Object>();

        HashMap<String, Object> userInfo = partyUserService.getPartyUserInfoByRybm(model.getRybm());

        if (userInfo != null && userInfo.get("RYBM") != null) {
            extData.put("XBMC", userInfo.get("XBMC"));
            extData.put("MZMC", userInfo.get("MZMC"));
            extData.put("XLMC", userInfo.get("XLMC"));
            extData.put("ZWMC", userInfo.get("ZWMC"));
            extData.put("JSZWMC", userInfo.get("JSZWMC"));
        }

        res.setExtdata(extData);

        res.setItem(model);
        return res;
    }


    /**
     * @Description //TODO 查询支委会开会领导信息
     * @date 2024-08
     * @Param [pageIndex, pageSize, rybm, xm, szdzbdm, userIds, removeUsers]
     **/
    @ResponseBody
    @GetMapping("/getLeaderUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getLeaderUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                            @RequestParam(required = false) String dzzdm,
                                                                            @RequestParam(required = false) String szdzbdm, @RequestParam(required = false) String rybm, @RequestParam(required = false) String xm,
                                                                            @RequestParam(required = false) String userIds, @RequestParam(required = false) String removeUsers) {

        List<String> userIdList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(userIds)) {
            userIdList = Arrays.asList(userIds.split(","));
        }
        List<String> removeUserList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(removeUsers)) {
            removeUserList = Arrays.asList(removeUsers.split(","));
        }

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getLeaderUserList(pageIndex, pageSize, dzzdm, szdzbdm, rybm, xm, userIdList, removeUserList, null));
        return result;
    }

    @ResponseBody
    @RequestMapping("/importUserInfo")
    public RequsetData<List<UserInfoVo>> importUserInfo(@RequestBody Map<String, Object> reqMap) {
        RequsetData<List<UserInfoVo>> res = new RequsetData<>();
        List<UserInfoVo> errorInfo = new ArrayList<>();
        String message = "";
        try {
            List<UserInfoVo> userList = JsonMapper.jsonToObject(reqMap.get("userList").toString(), new TypeReference<List<UserInfoVo>>() {
            });
            errorInfo = partyUserService.importUser(userList);
        } catch (Exception e) {
            e.printStackTrace();
            message = e.toString();
        }
        if (errorInfo.size() <= 0 && stringUtils.IsNullOrEmpty(message)) {
            res.setSuccess(true);
            res.setMsg("操作成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("操作失败！" + message);
            res.setItem(errorInfo);
        }
        return res;
    }

    @ResponseBody
    @RequestMapping("/importUserMobile")
    public RequsetData<String> importUserMobile(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<>();
        int count = 0;
        String message = "";
        try {

            List<UserMobileVo> userList = JsonMapper.jsonToObject(reqMap.get("userList").toString(), new TypeReference<List<UserMobileVo>>() {
            });

            userList = userList.stream().filter(it -> !stringUtils.IsNullOrEmpty(it.getUserCode()) && !stringUtils.IsNullOrEmpty(it.getMobile())).collect(Collectors.toList());

            List<String> mobileList = userList.stream().map(it -> it.getMobile()).distinct().collect(Collectors.toList());

            if (mobileList.size() != userList.size()) {
                throw new Exception("附件中存在重复登录账号，请修改后重新导入！");
            }

            //验证电话号码
            List<UserVo> dbUserList = userService.getUserByMobileList(mobileList);
            if (dbUserList.size() > 0) {
                String sameMobile = vaildMobile(userList, dbUserList);
                if (!stringUtils.IsNullOrEmpty(sameMobile)) {
                    throw new Exception("导入后存在重复登录账号[" + sameMobile + "]，请修改后重新导入！");
                }
            }

            List<UserMobileVo> resultList = new ArrayList<>();

            //String patternRex="\\s*|\t|\r|\n";

            for (int i = 0; i < userList.size(); i++) {
                UserMobileVo userMobileVo = userList.get(i);
                //Pattern p = Pattern.compile(patternRex);
                Matcher m = mobilePattern.matcher(userMobileVo.getMobile());
                userMobileVo.setMobile(m.replaceAll(""));

                resultList.add(userMobileVo);
                count++;

            }

            userService.batchUpdateUserMobile(resultList);


        } catch (Exception e) {

            count = 0;
            e.printStackTrace();
            message = e.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("操作成功！导入成功" + count + "个用户登录账号！");
        } else {
            res.setSuccess(false);
            res.setMsg("操作失败！" + message);
        }
        return res;
    }

    //验证登录账号重复性
    public String vaildMobile(List<UserMobileVo> importList, List<UserVo> dbUserList) {

        //导入的登录账号
        List<String> importMobiles = importList.stream().map(it -> it.getMobile()).distinct().collect(Collectors.toList());

        List<UserMobileVo> list = dbUserList.stream().filter(it -> importMobiles.contains(it.getMobile())).map(temp -> {
            UserMobileVo obj = new UserMobileVo();
            obj.setMobile(temp.getMobile());
            obj.setUserCode(temp.getUserCode());
            return obj;
        }).collect(Collectors.toList());


        list.addAll(importList);

        List<UserMobileVo> dataList = list.stream().distinct().collect(Collectors.toList());

        List<String> mobileList = dataList.stream().map(it -> it.getMobile()).collect(Collectors.toList());

        Map<String, Long> map = mobileList.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        return map.entrySet().stream().filter(it -> it.getValue() > 1).map(e -> e.getKey()).collect(Collectors.joining(","));

    }


    @ResponseBody
    @RequestMapping("/getPartyUserInfo")
    public RequsetData<Map<String, Object>> getPartyUserInfo(@RequestParam("rybm") String rybm, @RequestParam("roleId") String roleId, @RequestParam(required = false) Integer dataScope, @RequestParam(required = false) String dataDzzdm) {
        RequsetData<Map<String, Object>> res = new RequsetData<>();

        /*HashMap<String, Object> userInfo = partyUserService.getPartyUserInfoByRybm(rybm);*/
        HashMap<String, Object> userInfo = partyUserService.getPartyUserExt(rybm);

        if (userInfo != null && userInfo.get("RYBM") != null) {

            String szdzzdm = userInfo.get("SZDZBDM") != null ? userInfo.get("SZDZBDM").toString() : "";

            //个人党组织信息
            if (!stringUtils.IsNullOrEmpty(szdzzdm)) {

                //党员所属组织信息
                userInfo.put("partyInfo", partyService.getPartyByDm(szdzzdm));

                userInfo.put("partyInfoFb", partyService.getPartyFbById(szdzzdm));


                //个人所属党委
                ZzZzqkxx dwModel = partyService.getUserDwInfo(szdzzdm);//递归获取党委，先屏蔽待发布
                //ZzZzqkxx dwModel = partyService.getPartyByDm(szdzzdm.length() > 12 ? szdzzdm.substring(0, 12) : szdzzdm);
                if (dwModel != null) {
                    userInfo.put("dwName", dwModel.getDzzmc());
                }
            }

            //管理党组织信息
            if (!stringUtils.IsNullOrEmpty(dataDzzdm)) {
                switch (dataScope) {
                    case 1:
                    case 2:
                    case 7:
                        //查询党委信息
                        ZzZzqkxx zzZzqkxxDw = partyService.getPartyByDm(dataDzzdm);
                        ZzZzqkxxfb zzZzqkxxfbDw = partyService.getPartyFbById(dataDzzdm);
                        if (zzZzqkxxDw != null && zzZzqkxxfbDw != null && ("100".equals(zzZzqkxxfbDw.getZzlb()) || "200".equals(zzZzqkxxfbDw.getZzlb()))) {
                            String dwbm = zzZzqkxxDw.getDzzdm();

                            //党组织数
                            List<HashMap<String, Object>> dwChildList = partyService.getChildPartyCount(dwbm, dwbm);
                            if (dwChildList.size() > 0) {
                                userInfo.put("dw_partyChildCount", dwChildList.get(0).get("CHILDCOUNT"));
                            }

                            //组织类别名称
                            List<ZzzdZzlbdmnew> dwZzlbList = partyDicService.getZzlbdmList().stream().filter(it -> it.getBm().equals(zzZzqkxxfbDw.getZzlb())).collect(Collectors.toList());
                            if (dwZzlbList.size() > 0) {
                                userInfo.put("dw_partyZZLBMC", dwZzlbList.get(0).getHzmc());
                            }

                            //上次换届时间
                            //List<HashMap<String, Object>> dwGradeList = gradeService.getGradeList(1, 1, null, null, null, null, null, null, null, dwbm, null, null, null).getList();
                            List<HashMap<String, Object>> dwGradeList = gradeService.getMaxGradeList(1, 1, dwbm, null, null).getList();
                            if (dwGradeList.size() > 0) {
                                userInfo.put("dw_schjsj", dwGradeList.get(0).get("LDJTDXRQ"));
                            }

                            userInfo.put("dw_partyInfo", zzZzqkxxDw);
                            userInfo.put("dw_partyInfoFb", zzZzqkxxfbDw);
                        }

                        break;
                    case 3:
                    case 4:
                    case 8:
                        //查询支部总支信息
                        ZzZzqkxx zzZzqkxxDzz = partyService.getPartyByDm(dataDzzdm);
                        ZzZzqkxxfb zzZzqkxxfbDzz = partyService.getPartyFbById(dataDzzdm);
                        if (zzZzqkxxDzz != null && zzZzqkxxfbDzz != null && ("300".equals(zzZzqkxxfbDzz.getZzlb()) || "400".equals(zzZzqkxxfbDzz.getZzlb()))) {
                            String dzzbm = zzZzqkxxDzz.getDzzdm();

                            //党组织数
                            List<HashMap<String, Object>> dwChildList = partyService.getChildPartyCount(dzzbm, dzzbm);
                            if (dwChildList.size() > 0) {
                                userInfo.put("dzz_partyChildCount", dwChildList.get(0).get("CHILDCOUNT"));
                            }

                            //组织类别名称
                            List<ZzzdZzlbdmnew> dwZzlbList = partyDicService.getZzlbdmList().stream().filter(it -> it.getBm().equals(zzZzqkxxfbDzz.getZzlb())).collect(Collectors.toList());
                            if (dwZzlbList.size() > 0) {
                                userInfo.put("dzz_partyZZLBMC", dwZzlbList.get(0).getHzmc());
                            }

                            //上次换届时间
                            //List<HashMap<String, Object>> dwGradeList = gradeService.getGradeList(1, 1, null, null, null, null, null, null, null, dzzbm, null, null, null).getList();
                            List<HashMap<String, Object>> dwGradeList = gradeService.getMaxGradeList(1, 1, dzzbm, null, null).getList();
                            if (dwGradeList.size() > 0) {
                                userInfo.put("dzz_schjsj", dwGradeList.get(0).get("LDJTDXRQ"));
                                userInfo.put("dzz_gjjmrq", dwGradeList.get(0).get("GJJMRQ"));
                            }

                            userInfo.put("dzz_partyInfo", zzZzqkxxDzz);
                            userInfo.put("dzz_partyInfoFb", zzZzqkxxfbDzz);

                        }
                        break;
                }
            }

            //副表信息
            userInfo.put("fbModel", partyUserService.getUserFbInfo(rybm));
            //党籍信息
            userInfo.put("djxxModel", partyUserService.getUserDjxxById(rybm));

            //党籍信息副表
            userInfo.put("djxxFBModel", partyUserService.getUserDjxxFBById(rybm));

            userInfo.put("ldrylxdmc", String.join(",", partyUserService.getUserContactpoint(rybm).stream().map(it -> it.get("DZZMC").toString()).collect(Collectors.toList())));

            res.setItem(userInfo);
        }

        return res;
    }


    @ResponseBody
    @GetMapping("/getMZPYList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getmzpylist(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                      @RequestParam(required = false) String rybm) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getMzpyList(pageIndex, pageSize, rybm));
        return result;
    }


    //党员大数据查询
    @ResponseBody
    @GetMapping("/getUserBigSearchParam")
    public HashMap<String, Object> getUserBigSearchParam() {
        HashMap<String, Object> result = new HashMap<>();

        List<HashMap<String, Object>> userDicList = partyDicService.getUserDicList();

        result.put("dnzwList", userDicList.stream().filter(it -> Integer.parseInt(it.get("TYPE").toString()) == 1).collect(Collectors.toList()));
        result.put("xzzwList", userDicList.stream().filter(it -> Integer.parseInt(it.get("TYPE").toString()) == 2).collect(Collectors.toList()));
        result.put("jszwList", userDicList.stream().filter(it -> Integer.parseInt(it.get("TYPE").toString()) == 3).collect(Collectors.toList()));
        result.put("xlList", userDicList.stream().filter(it -> Integer.parseInt(it.get("TYPE").toString()) == 4).collect(Collectors.toList()));
        result.put("xbList", userDicList.stream().filter(it -> Integer.parseInt(it.get("TYPE").toString()) == 5).collect(Collectors.toList()));
        result.put("zzmmList", userDicList.stream().filter(it -> Integer.parseInt(it.get("TYPE").toString()) == 6).collect(Collectors.toList()));
        result.put("mzList", userDicList.stream().filter(it -> Integer.parseInt(it.get("TYPE").toString()) == 7).collect(Collectors.toList()));

        return result;
    }

    @ResponseBody
    @GetMapping("/getPXQKList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getpxqklist(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                      @RequestParam(required = false) String rybm) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getPxqkList(pageIndex, pageSize, rybm));
        return result;
    }

    @ResponseBody
    @GetMapping("/getPartyUserListForSearch")
    public RequsetData<PageInfo<HashMap<String, Object>>> getPartyUserListForSearch(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                                    @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String dzzmc, @RequestParam(required = false) String xm, @RequestParam(required = false) String csrq_begin, @RequestParam(required = false) String csrq_end,
                                                                                    @RequestParam(required = false) String rdsj_begin, @RequestParam(required = false) String rdsj_end, @RequestParam(required = false) String zzsj_begin, @RequestParam(required = false) String zzsj_end,
                                                                                    @RequestParam(required = false) String jg, @RequestParam(required = false) List<String> dnzw, @RequestParam(required = false) List<String> xzzw, @RequestParam(required = false) List<String> jszw,
                                                                                    @RequestParam(required = false) List<String> xl, @RequestParam(required = false) List<String> xb, @RequestParam(required = false) List<String> gwzt,
                                                                                    @RequestParam(required = false) List<String> zzmm, @RequestParam(required = false) List<String> mz, @RequestParam(required = false) Integer pxpy_year, @RequestParam(required = false) Integer pxpy_level, @RequestParam(required = false) List<Integer> pxpy_type, @RequestParam(required = false) Integer sfzyxq, @RequestParam(required = false) String leadId,
                                                                                    @RequestParam(required = false) Integer age_begin, @RequestParam(required = false) Integer age_end) {

        csrq_begin = dateUtils.strFormat_short(csrq_begin);
        csrq_end = dateUtils.strFormat_short(csrq_end);

        rdsj_begin = dateUtils.strFormat_short(rdsj_begin);
        rdsj_end = dateUtils.strFormat_short(rdsj_end);

        zzsj_begin = dateUtils.strFormat_short(zzsj_begin);
        zzsj_end = dateUtils.strFormat_short(zzsj_end);

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyUserService.getPartyUserListForSearch(pageIndex, pageSize, dzzdm, dzzmc, xm, csrq_begin, csrq_end, rdsj_begin, rdsj_end, zzsj_begin, zzsj_end, jg, dnzw, xzzw, jszw, xl, xb, gwzt, zzmm, mz, pxpy_year, pxpy_level, pxpy_type, sfzyxq, leadId, age_begin, age_end));
        return result;
    }

    @RequestMapping(value = "/exportPartyUserListForSearch", method = RequestMethod.GET)
    public void exportPartyUserListForSearch(HttpServletResponse response,
                                             @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String dzzmc, @RequestParam(required = false) String xm, @RequestParam(required = false) String csrq_begin, @RequestParam(required = false) String csrq_end,
                                             @RequestParam(required = false) String rdsj_begin, @RequestParam(required = false) String rdsj_end, @RequestParam(required = false) String zzsj_begin, @RequestParam(required = false) String zzsj_end,
                                             @RequestParam(required = false) String jg, @RequestParam(required = false) List<String> dnzw, @RequestParam(required = false) List<String> xzzw, @RequestParam(required = false) List<String> jszw,
                                             @RequestParam(required = false) List<String> xl, @RequestParam(required = false) List<String> xb, @RequestParam(required = false) List<String> gwzt,
                                             @RequestParam(required = false) List<String> zzmm, @RequestParam(required = false) List<String> mz, @RequestParam(required = false) Integer pxpy_year, @RequestParam(required = false) Integer pxpy_level, @RequestParam(required = false) List<Integer> pxpy_type, @RequestParam(required = false) Integer sfzyxq, @RequestParam(required = false) String leadId,
                                             @RequestParam(required = false) Integer age_begin, @RequestParam(required = false) Integer age_end) throws Exception {

        csrq_begin = dateUtils.strFormat_short(csrq_begin);
        csrq_end = dateUtils.strFormat_short(csrq_end);

        rdsj_begin = dateUtils.strFormat_short(rdsj_begin);
        rdsj_end = dateUtils.strFormat_short(rdsj_end);

        zzsj_begin = dateUtils.strFormat_short(zzsj_begin);
        zzsj_end = dateUtils.strFormat_short(zzsj_end);

        /**查询数据**/
        List<HashMap<String, Object>> dataList = partyUserService.getPartyUserListForSearch(1, 1000000, dzzdm, dzzmc, xm, csrq_begin, csrq_end, rdsj_begin, rdsj_end, zzsj_begin, zzsj_end, jg, dnzw, xzzw, jszw, xl, xb, gwzt, zzmm, mz, pxpy_year, pxpy_level, pxpy_type, sfzyxq, leadId, age_begin, age_end).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党员基本信息");
        List<String> titles = new ArrayList();

        titles.add("姓名");
        titles.add("性别");
        titles.add("年龄");
        titles.add("所在党委");
        titles.add("所在党支部");
        titles.add("岗位状态");
        titles.add("现任职务");
        titles.add("专业职务");
        titles.add("政治面貌");
        titles.add("入党时间");
        titles.add("转正时间");
        titles.add("籍贯");
        titles.add("民族");
        titles.add("是否在处分影响期");
        titles.add("学历");

        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (HashMap<String, Object> item : dataList) {
            List<Object> row = new ArrayList();

            row.add(item.get("XM"));
            row.add(item.get("XBMC"));
            row.add(item.get("AGE"));
            row.add(item.get("DWMC"));
            row.add(item.get("DZZMC"));
            row.add(item.get("SFZG") != null && "1".equals(item.get("SFZG").toString()) ? "在岗" : "退休");
            row.add(item.get("ZWMC"));
            row.add(item.get("JSZWMC"));
            row.add(item.get("RYZTMC"));
            row.add(item.get("RDSJ"));
            row.add(item.get("ZZRQ"));
            row.add(item.get("JG"));
            row.add(item.get("MZMC"));
            row.add(item.get("SFZYXQ") != null && "1".equals(item.get("SFZYXQ").toString()) ? "是" : "否");
            row.add(item.get("XLMC"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党员基本信息.xlsx", data);
    }


    @ResponseBody
    @RequestMapping("/getUserContactpoint")
    public List<HashMap<String, Object>> getUserContactpoint(@RequestParam("rybm") String rybm) {
        return partyUserService.getUserContactpoint(rybm);
    }

}

