package com.px.partybuild.controller.partyExpand;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.*;
import com.px.partybuild.service.*;
import com.px.partybuild.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 发展党员
 *
 * @author H
 */
@RestController
@RequestMapping(value = "/api/partyExpand")
public class PartyExpandController {

    @Autowired
    private PEUserService peUserService;

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private PartyService partyService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private WordUtil wordUtil;

    @Autowired
    private PartyUserService partyUserService;

    @ResponseBody
    @GetMapping("/getJoinUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getJoinUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                          @RequestParam(required = false) Integer isLateDay, @RequestParam(required = false) String name,
                                                                          @RequestParam(required = false) String flowid, @RequestParam(required = false) List<String> pflowid,
                                                                          @RequestParam(required = false) String partyCode, @RequestParam(required = false) Integer zzfbType,
                                                                          @RequestParam(required = false) Integer beginSort, @RequestParam(required = false) Integer endSort, @RequestParam(required = false) List<Integer> ryzt) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(peUserService.getJoinUserList(pageIndex, pageSize, partyCode, name, isLateDay, flowid, pflowid, zzfbType, beginSort, endSort, ryzt));
        return result;
    }


    @ResponseBody
    @RequestMapping("/getJoinuserById")
    public RequsetData<PeJoinuser> getJoinuserById(@RequestParam("id") String id, @RequestParam(required = false) String dzzdm) {
        RequsetData<PeJoinuser> res = new RequsetData<>();

        PeJoinuser model = peUserService.getJoinuserById(id);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getJoinuserid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeJoinuser();
            model.setJoinuserid(uuid.toString());

            model.setPartycode(dzzdm);

        }

        if (!stringUtils.IsNullOrEmpty(model.getPartycode())) {
            ZzZzqkxx zzZzqkxx = partyService.getPartyByDm(model.getPartycode());
            if (zzZzqkxx != null && !stringUtils.IsNullOrEmpty(zzZzqkxx.getDzzdm())) {

                model.setPartyname(zzZzqkxx.getDzzmc());
            }
        }

        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveJoinuser")
    public RequsetData<String> saveJoinuser(@RequestBody PeJoinuser model) {
        RequsetData<String> res = new RequsetData<String>();

        int count = peUserService.saveJoinuser(model);
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！");
        }
        return res;
    }

    @ResponseBody
    @GetMapping("/deleteJoinUserById")
    public RequsetData<Integer> deleteJoinUserById(@RequestParam("id") String id) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.deleteJoinUserById(id);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("/getJoinuserInfoById")
    public RequsetData<Map<String, Object>> getJoinuserInfoById(@RequestParam(required = false) String id, @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String rybm) {
        RequsetData<Map<String, Object>> res = new RequsetData<>();
        PeJoinuser model = new PeJoinuser();

        if (!stringUtils.IsNullOrEmpty(id)) {
            model = peUserService.getJoinuserById(id);
        }

        if (!stringUtils.IsNullOrEmpty(rybm)) {
            model = peUserService.getJoinuserByRybm(rybm);
        }

        /*Map<String, Object> user = mapUtils.objectToMap(model);

        user.put("genderName", model.getGender() == 1 ? "男" : "女");

        HashMap<String, Object> userInfo = peUserService.getJoinuserInfoById(id);

        if (userInfo != null && userInfo.get("JOINUSERID") != null) {
            user.put("educationName", userInfo.get("EDUCATIONNAME"));
        }

        res.setItem(user);*/
        HashMap<String, Object> userInfo = partyUserService.getAllUserInfoByRybm(model.getUsercode());


        Map<String, Object> user = mapUtils.objectToMap(model);
        user.put("name", userInfo.get("XM"));
        user.put("partycode", userInfo.get("SZDZBDM"));
        user.put("partyname", userInfo.get("DZZMC"));
        user.put("birthday", userInfo.get("CSRQ"));
        user.put("nationality", userInfo.get("MZMC"));
        user.put("nativeplace", userInfo.get("JG"));
        user.put("education", userInfo.get("XLMC"));
        user.put("position", userInfo.get("ZWMC"));
        user.put("idcard", userInfo.get("SFZH"));
        /*user.put("address", "");
        user.put("joingrouptime", "");*/
        user.put("mobile", userInfo.get("MOBILE"));
        user.put("genderName", userInfo.get("XBMC"));
        user.put("educationName", userInfo.get("XLMC"));

        res.setItem(user);

        return res;
    }

    @ResponseBody
    @GetMapping("/getUserFlowList")
    public List<HashMap<String, Object>> getUserFlowList(@RequestParam("joinUserId") String joinUserId) {
        return peUserService.getUserFlowList(joinUserId);
    }

    @ResponseBody
    @GetMapping("/getJoinUserTotalList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getJoinUserTotalList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                               @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) String ssdzzdm,@RequestParam(required = false) Integer isOnduty) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(peUserService.getJoinUserTotalList(pageIndex, pageSize, dzzdm, zzfbType, ssdzzdm,isOnduty));
        return result;
    }

    @RequestMapping(value = "/exportJoinUserTotal", method = RequestMethod.GET)
    public void exportJoinUserTotal(HttpServletResponse response,
                                    @RequestParam(required = false) String dzzdm,
                                    @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) String ssdzzdm,@RequestParam(required = false) Integer isOnduty) throws Exception {

        /**查询数据**/
        List<HashMap<String, Object>> dataList = peUserService.getJoinUserTotalList(1, 100000, dzzdm, zzfbType, ssdzzdm,isOnduty).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("发展党员统计信息");
        List<String> titles = new ArrayList();
        titles.add("组织名称");
        titles.add("党员总数");

        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (HashMap<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("DZZMC"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "发展党员统计信息.xlsx", data);
    }

    //region 1.递交入党申请书

    /**
     * @param joinUserId
     * @Description: 党员申请书信息
     * @return:
     * @Date: 2020/1/8
     */
    @ResponseBody
    @RequestMapping("/getJoinuserApplyById")
    public RequsetData<PeJoinapplyWithBLOBs> getJoinuserApplyById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeJoinapplyWithBLOBs> res = new RequsetData<>();

        PeJoinapplyWithBLOBs model = peUserService.getJoinuserApplyByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getApplyid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeJoinapplyWithBLOBs();
            model.setApplyid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/saveJoinuserApply")
    public RequsetData<String> saveJoinuserApply(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeJoinapplyWithBLOBs dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeJoinapplyWithBLOBs.class);
            List<PeJoinapplyResume> resumeList = JsonMapper.jsonToObject(reqMap.get("resumeList").toString(), new TypeReference<List<PeJoinapplyResume>>() {
            });
            List<PeJoinapplyRelation> relationListList = JsonMapper.jsonToObject(reqMap.get("relationList").toString(), new TypeReference<List<PeJoinapplyRelation>>() {
            });
            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveJoinuserApply(dataModel, resumeList, relationListList, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/getResumeList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getResumeList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                        @RequestParam(required = false) String applyId) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(peUserService.getPeJoinapplyResumeList(pageIndex, pageSize, applyId));
        return result;
    }

    @ResponseBody
    @GetMapping("/getRelationList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getRelationList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                          @RequestParam(required = false) String applyId) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(peUserService.getPeJoinapplyRelationList(pageIndex, pageSize, applyId));
        return result;
    }

    @ResponseBody
    @GetMapping("/delpeJoinUserApply")
    public RequsetData<Integer> delpeJoinUserApply(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delPeJoinUserApply(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    /**
     * @Description //TODO 生成word文档
     * @date 2024-08
     * @Param [id]
     **/
    @RequestMapping(value = "/createWord_JoinUserApply", method = RequestMethod.GET)
    public void createWordJoinUserApply(HttpServletResponse response, @RequestParam("joinUserId") String joinUserId) {

        try {
            PeJoinapplyWithBLOBs model = peUserService.getJoinuserApplyByUserId(joinUserId);

            /** 用于组装word页面需要的数据 */
            Map<String, Object> dataMap = new HashMap<String, Object>();
            // 组装数据
            dataMap.put("content", model.getContent());

            /** 生成word **/
            wordUtil.createWord(response, dataMap, "入党申请书", "入党申请书");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    //endregion

    //region 2.党组织派人谈话

    @ResponseBody
    @RequestMapping("/getTalkById")
    public RequsetData<PeTalkWithBLOBs> getTalkById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeTalkWithBLOBs> res = new RequsetData<>();

        PeTalkWithBLOBs model = peUserService.getTalkByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getTalkid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeTalkWithBLOBs();
            model.setTalkid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/saveTalk")
    public RequsetData<String> saveTalk(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeTalkWithBLOBs dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeTalkWithBLOBs.class);
            List<PeTalkUser> userList = JsonMapper.jsonToObject(reqMap.get("talkuserList").toString(), new TypeReference<List<PeTalkUser>>() {
            });

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveTalk(dataModel, userList, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/getTalkUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getTalkUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                          @RequestParam(required = false) String talkId) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(peUserService.getTalkUserList(pageIndex, pageSize, talkId));
        return result;
    }

    @ResponseBody
    @GetMapping("/delpeTalk")
    public RequsetData<Integer> delpeTalk(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delTalkUser(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    @RequestMapping(value = "/createWord_Talk", method = RequestMethod.GET)
    public void createWordTalk(HttpServletResponse response, @RequestParam("joinUserId") String joinUserId) {

        try {
            PeTalkWithBLOBs model = peUserService.getTalkByUserId(joinUserId);

            /** 用于组装word页面需要的数据 */
            Map<String, Object> dataMap = new HashMap<String, Object>();
            // 组装数据
            dataMap.put("content", model.getTalkcontent());

            /** 生成word **/
            wordUtil.createWord(response, dataMap, "派人谈话记录", "派人谈话记录");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    //endregion

    //region 3.推荐和确定入党积极分子

    @ResponseBody
    @RequestMapping("/getRecommendById")
    public RequsetData<PeRecommendWithBLOBs> getRecommendById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeRecommendWithBLOBs> res = new RequsetData<>();

        PeRecommendWithBLOBs model = peUserService.getRecommendByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getRecommendid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeRecommendWithBLOBs();
            model.setRecommendid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveRecommend")
    public RequsetData<String> saveRecommend(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeRecommendWithBLOBs dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeRecommendWithBLOBs.class);


            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveRecommend(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delpeRecommend")
    public RequsetData<Integer> delpeRecommend(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delRecommend(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    @RequestMapping(value = "/createWord_Recommend", method = RequestMethod.GET)
    public void createWordRecommend(HttpServletResponse response, @RequestParam("joinUserId") String joinUserId) {

        try {
            PeRecommendWithBLOBs model = peUserService.getRecommendByUserId(joinUserId);

            /** 用于组装word页面需要的数据 */
            Map<String, Object> dataMap = new HashMap<String, Object>();
            // 组装数据
            dataMap.put("content", model.getDecisioncontent());

            /** 生成word **/
            wordUtil.createWord(response, dataMap, "积极分子决议", "积极分子决议");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    //endregion

    //region 4.上级党委备案情况

    @ResponseBody
    @RequestMapping("/getPutrecordById")
    public RequsetData<PePutrecord> getPutrecordById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PePutrecord> res = new RequsetData<>();

        PePutrecord model = peUserService.getPutrecordByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getPutrecordid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PePutrecord();
            model.setPutrecordid(uuid.toString());
            model.setJoinuserid(joinUserId);
            model.setAuditresult(1);
            model.setHasprecedure(1);

        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/savePutrecord")
    public RequsetData<String> savePutrecord(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PePutrecord dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PePutrecord.class);


            String flowId = reqMap.get("flowId").toString();

            count = peUserService.savePutrecord(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delpePutRecord")
    public RequsetData<Integer> delpePutRecord(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delPutrecord(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    //endregion

    //region 5.指定培养人

    @ResponseBody
    @RequestMapping("/getTrainuserById")
    public RequsetData<PeTrainuser> getTrainuserById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeTrainuser> res = new RequsetData<>();

        PeTrainuser model = peUserService.getTrainuserByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getTrainuserid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeTrainuser();
            model.setTrainuserid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/saveTrainuser")
    public RequsetData<String> saveTrainuser(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeTrainuser dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeTrainuser.class);
            List<PeTrainuserDetail> userList = JsonMapper.jsonToObject(reqMap.get("userList").toString(), new TypeReference<List<PeTrainuserDetail>>() {
            });

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveTrainuser(dataModel, userList, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/getTrainuserDetailList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getTrainuserDetailList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                                 @RequestParam(required = false) String trainUserId) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(peUserService.getTrainuserDetailList(pageIndex, pageSize, trainUserId));
        return result;
    }

    @ResponseBody
    @GetMapping("/delpeTrainUser")
    public RequsetData<Integer> delpeTrainUser(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delTrainuser(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    //endregion

    //region 6.培养教育考察

    @ResponseBody
    @RequestMapping("/getTrainInspectById")
    public RequsetData<PeTraininspect> getTrainInspectById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeTraininspect> res = new RequsetData<>();

        PeTraininspect model = peUserService.getTraininspectByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getTraininspectid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeTraininspect();
            model.setTraininspectid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/saveTrainInspect")
    public RequsetData<String> saveTrainInspect(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeTraininspect dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeTraininspect.class);
            List<PeTraininspectRecordWithBLOBs> recordList = JsonMapper.jsonToObject(reqMap.get("recordList").toString(), new TypeReference<List<PeTraininspectRecordWithBLOBs>>() {
            });

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveTraininspect(dataModel, recordList, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/getTrainInspectRecordList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getTrainInspectRecordList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                                    @RequestParam(required = false) String trainInspectId) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(peUserService.getTraininspectRecordList(pageIndex, pageSize, trainInspectId));
        return result;
    }

    @ResponseBody
    @GetMapping("/delpeTrainInspect")
    public RequsetData<Integer> delpeTrainInspect(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delTraininspect(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    //endregion


    //region 7.确定发展对象

    @ResponseBody
    @RequestMapping("/getConfirmuserById")
    public RequsetData<PeConfirmuserWithBLOBs> getConfirmuserById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeConfirmuserWithBLOBs> res = new RequsetData<>();

        PeConfirmuserWithBLOBs model = peUserService.getConfirmuserByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getConfirmuserid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeConfirmuserWithBLOBs();
            model.setConfirmuserid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/saveConfirmuser")
    public RequsetData<String> saveConfirmuser(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeConfirmuserWithBLOBs dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeConfirmuserWithBLOBs.class);

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveConfirmuser(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delpeConfirmUser")
    public RequsetData<Integer> delpeConfirmUser(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delConfirmuser(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    @RequestMapping(value = "/createWord_Confirmuser", method = RequestMethod.GET)
    public void createWordConfirmuser(HttpServletResponse response, @RequestParam("joinUserId") String joinUserId) {

        try {
            PeConfirmuserWithBLOBs model = peUserService.getConfirmuserByUserId(joinUserId);

            /** 用于组装word页面需要的数据 */
            Map<String, Object> dataMap = new HashMap<String, Object>();
            // 组装数据
            dataMap.put("content", model.getDecisioncontent());

            /** 生成word **/
            wordUtil.createWord(response, dataMap, "确定发展对象决议", "确定发展对象决议");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    //endregion

    //region 8.上级党委报备

    @ResponseBody
    @RequestMapping("/getAgainPutrecordById")
    public RequsetData<PeAgainputrecord> getAgainPutrecordById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeAgainputrecord> res = new RequsetData<>();

        PeAgainputrecord model = peUserService.getAgainputrecordByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getAgainputrecordid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeAgainputrecord();
            model.setAgainputrecordid(uuid.toString());
            model.setJoinuserid(joinUserId);
            model.setPartyopintionstate(1);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/saveAgainPutrecord")
    public RequsetData<String> saveAgainPutrecord(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeAgainputrecord dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeAgainputrecord.class);

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveAgainputrecord(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delpeAgainPutRecord")
    public RequsetData<Integer> delpeAgainPutRecord(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delAgainputrecord(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    @RequestMapping(value = "/createWord_AgainPutRecord", method = RequestMethod.GET)
    public void createWordAgainPutRecord(HttpServletResponse response, @RequestParam("joinUserId") String joinUserId) {

        try {
            PeAgainputrecord model = peUserService.getAgainputrecordByUserId(joinUserId);

            /** 用于组装word页面需要的数据 */
            Map<String, Object> dataMap = new HashMap<String, Object>();
            // 组装数据
            dataMap.put("content", model.getOpintion());

            /** 生成word **/
            wordUtil.createWord(response, dataMap, "党委意见", "党委意见");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    //endregion

    //region 9.确定入党介绍人

    @ResponseBody
    @RequestMapping("/getConfirmsponsorById")
    public RequsetData<PeConfirmsponsor> getConfirmsponsorById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeConfirmsponsor> res = new RequsetData<>();

        PeConfirmsponsor model = peUserService.getConfirmsponsorByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getConfirmsponsorid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeConfirmsponsor();
            model.setConfirmsponsorid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/saveConfirmsponsor")
    public RequsetData<String> saveConfirmsponsor(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeConfirmsponsor dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeConfirmsponsor.class);
            List<PeConfirmsponsorUser> userList = JsonMapper.jsonToObject(reqMap.get("userList").toString(), new TypeReference<List<PeConfirmsponsorUser>>() {
            });

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveConfirmsponsor(dataModel, userList, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/getConfirmSponsorUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getConfirmSponsorUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                                    @RequestParam(required = false) String confirmSponsorId, @RequestParam(required = false) String joinUserId) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(peUserService.getConfirmsponsorUserList(pageIndex, pageSize, confirmSponsorId, joinUserId));
        return result;
    }

    @ResponseBody
    @GetMapping("/delpeConfirmSponsor")
    public RequsetData<Integer> delpeConfirmSponsor(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delConfirmsponsor(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    //endregion

    //region 10.进行政治审查

    @ResponseBody
    @RequestMapping("/getPoliticalreviewById")
    public RequsetData<PePoliticalreview> getPoliticalreviewById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PePoliticalreview> res = new RequsetData<>();

        PePoliticalreview model = peUserService.getPoliticalreviewByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getPoliticalreviewid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PePoliticalreview();
            model.setPoliticalreviewid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/savePoliticalreview")
    public RequsetData<String> savePoliticalreview(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PePoliticalreview dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PePoliticalreview.class);

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.savePoliticalreview(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delpePoliticalReview")
    public RequsetData<Integer> delpePoliticalReview(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delPoliticalreview(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    //endregion

    //region 11.开展短期集中培训

    @ResponseBody
    @RequestMapping("/getTrainingById")
    public RequsetData<PeTraining> getTrainingById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeTraining> res = new RequsetData<>();

        PeTraining model = peUserService.getTrainingByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getTrainingid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeTraining();
            model.setTrainingid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/saveTraining")
    public RequsetData<String> saveTraining(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeTraining dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeTraining.class);

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveTraining(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delpeTraining")
    public RequsetData<Integer> delpeTraining(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delTraining(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    //endregion


    //region 12.支委会审查

    @ResponseBody
    @RequestMapping("/getBranchReviewById")
    public RequsetData<PeBranchreview> getBranchReviewById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeBranchreview> res = new RequsetData<>();

        PeBranchreview model = peUserService.getBranchreviewByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getBranchreviewid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeBranchreview();
            model.setBranchreviewid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/saveBranchReview")
    public RequsetData<String> saveBranchReview(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeBranchreview dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeBranchreview.class);

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveBranchreview(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delpeBranchReview")
    public RequsetData<Integer> delpeBranchReview(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delBranchreview(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    @RequestMapping(value = "/createWord_BranchReview", method = RequestMethod.GET)
    public void createWordBranchReview(HttpServletResponse response, @RequestParam("joinUserId") String joinUserId) {

        try {
            PeBranchreview model = peUserService.getBranchreviewByUserId(joinUserId);

            /** 用于组装word页面需要的数据 */
            Map<String, Object> dataMap = new HashMap<String, Object>();
            // 组装数据
            dataMap.put("content", model.getOpintion());

            /** 生成word **/
            wordUtil.createWord(response, dataMap, "小组意见", "小组意见");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    //endregion

    //region 13.上级党委预审

    @ResponseBody
    @RequestMapping("/getPartyReviewById")
    public RequsetData<PePartyreview> getPartyReviewById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PePartyreview> res = new RequsetData<>();

        PePartyreview model = peUserService.getPartyreviewByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getPartyreviewid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PePartyreview();
            model.setPartyreviewid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/savePartyReview")
    public RequsetData<String> savePartyReview(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PePartyreview dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PePartyreview.class);

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.savePartyreview(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delpePartyReview")
    public RequsetData<Integer> delpePartyReview(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delPartyreview(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    @RequestMapping(value = "/createWord_PartyReview", method = RequestMethod.GET)
    public void createWordPartyReview(HttpServletResponse response, @RequestParam("joinUserId") String joinUserId) {

        try {
            PePartyreview model = peUserService.getPartyreviewByUserId(joinUserId);

            /** 用于组装word页面需要的数据 */
            Map<String, Object> dataMap = new HashMap<String, Object>();
            // 组装数据
            dataMap.put("content", model.getReviewopintion());

            /** 生成word **/
            wordUtil.createWord(response, dataMap, "预审意见", "预审意见");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    //endregion

    //region 14.填写入党志愿书

    @ResponseBody
    @RequestMapping("/getJoinBookById")
    public RequsetData<PeJoinbook> getJoinBookById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeJoinbook> res = new RequsetData<>();

        PeJoinbook model = peUserService.getJoinbookByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getJoinbookid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeJoinbook();
            model.setJoinbookid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/saveJoinBook")
    public RequsetData<String> saveJoinBook(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeJoinbook dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeJoinbook.class);

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveJoinbook(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delpeJoinBook")
    public RequsetData<Integer> delpeJoinBook(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delJoinbook(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    //endregion

    //region 15.支部大会讨论

    @ResponseBody
    @RequestMapping("/getBranchTalkById")
    public RequsetData<PeBranchtalkWithBLOBs> getBranchTalkById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeBranchtalkWithBLOBs> res = new RequsetData<>();

        PeBranchtalkWithBLOBs model = peUserService.getBranchtalkByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getBranchtalkid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeBranchtalkWithBLOBs();
            model.setBranchtalkid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }


    @ResponseBody
    @RequestMapping("/saveBranchTalk")
    public RequsetData<String> saveBranchTalk(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeBranchtalkWithBLOBs dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeBranchtalkWithBLOBs.class);

            String flowId = reqMap.get("flowId").toString();

            count = peUserService.saveBranchtalk(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delpeBranchTalk")
    public RequsetData<Integer> delpeBranchTalk(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peUserService.delBranchtalk(joinUserId, flowId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    @RequestMapping(value = "/createWord_BranchTalk", method = RequestMethod.GET)
    public void createWordBranchTalk(HttpServletResponse response, @RequestParam("joinUserId") String joinUserId) {

        try {
            PeBranchtalkWithBLOBs model = peUserService.getBranchtalkByUserId(joinUserId);

            /** 用于组装word页面需要的数据 */
            Map<String, Object> dataMap = new HashMap<String, Object>();
            // 组装数据
            dataMap.put("content", model.getDecisioncontent());

            /** 生成word **/
            wordUtil.createWord(response, dataMap, "预备党员支部大会决议", "预备党员支部大会决议");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    //endregion


    @GetMapping("/updateJoinuserCode")
    @ResponseBody
    public int updateJoinuserCode() {

        return peUserService.updateJoinuserCode();
    }


    @ResponseBody
    @GetMapping("/getJoinuserForUpdateList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getJoinuserForUpdateList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam(required = false) String partyCode,
                                                                                   @RequestParam(required = false) String name,String startDate, String endDate) {
        startDate = dateUtils.strFormat_short(startDate);
        endDate = dateUtils.strFormat_short(endDate);
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(peUserService.getJoinuserForUpdateList(pageIndex, pageSize, partyCode, name,startDate,endDate));
        return result;
    }

}
