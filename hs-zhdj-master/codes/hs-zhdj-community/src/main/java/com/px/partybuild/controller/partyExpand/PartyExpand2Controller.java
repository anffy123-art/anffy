package com.px.partybuild.controller.partyExpand;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.*;
import com.px.partybuild.service.PEFlowService;
import com.px.partybuild.service.PeWordTemplateService;
import com.px.partybuild.service.UserService;
import com.px.partybuild.util.JsonMapper;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.util.WordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/partyExpand")
public class PartyExpand2Controller {

    @Autowired
    private PEFlowService peFlowService;

    @Autowired
    private UserService userService;

    @Autowired
    private MapUtils mapUtils;
    @Autowired
    private StringUtils stringUtils;

    @Autowired
    PeWordTemplateService peWordTemplateService;
    @Autowired
    private WordUtil wordUtil;

    @ResponseBody
    @RequestMapping("/getSuperiorapp")
    public RequsetData<PeSuperiorapp> getSuperiorapp(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeSuperiorapp> res = new RequsetData<>();

        PeSuperiorapp model = peFlowService.getSuperiorappByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getTalkid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeSuperiorapp();
            model.setTalkid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/savegSuperiorapp")
    public RequsetData<String> savegSuperiorapp(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeSuperiorapp dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeSuperiorapp.class);

            String flowId = reqMap.get("flowId").toString();

            count = peFlowService.savegSuperiorapp(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delsuperiorTalk")
    public RequsetData<Integer> delsuperiorTalk(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peFlowService.delsuperiorTalk(joinUserId, flowId);
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
    @RequestMapping("/getZzbmba")
    public RequsetData<PeZzbmba> getZzbmba(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeZzbmba> res = new RequsetData<>();

        PeZzbmba model = peFlowService.getZzbmbaByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getId()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeZzbmba();
            model.setId(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveZzbmba")
    public RequsetData<String> savegZzbmba(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeZzbmba dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeZzbmba.class);

            String flowId = reqMap.get("flowId").toString();

            count = peFlowService.saveZzbmba(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delzzbmba")
    public RequsetData<Integer> delZzbmba(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peFlowService.delZzbmba(joinUserId, flowId);
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
    @RequestMapping("/getBrdzb")
    public RequsetData<PeBrdzb> getBrdzb(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeBrdzb> res = new RequsetData<>();

        PeBrdzb model = peFlowService.getBrdzbByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getId()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeBrdzb();
            model.setId(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveBrdzb")
    public RequsetData<String> savegBrdzb(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeBrdzb dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeBrdzb.class);

            String flowId = reqMap.get("flowId").toString();

            count = peFlowService.saveBrdzb(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delbrdzb")
    public RequsetData<Integer> delBrdzb(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peFlowService.delBrdzb(joinUserId, flowId);
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
    @RequestMapping("/getRdxs")
    public RequsetData<PeRdxs> getRdxs(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeRdxs> res = new RequsetData<>();

        PeRdxs model = peFlowService.getRdxsByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getId()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeRdxs();
            model.setId(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveRdxs")
    public RequsetData<String> savegRdxs(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeRdxs dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeRdxs.class);

            String flowId = reqMap.get("flowId").toString();

            count = peFlowService.saveRdxs(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delrdxs")
    public RequsetData<Integer> delRdxs(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peFlowService.delRdxs(joinUserId, flowId);
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
    @RequestMapping("/getjxjykcById")
    public RequsetData<PeJxjykc> getjxjykcById(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeJxjykc> res = new RequsetData<>();

        PeJxjykc model = peFlowService.getJxjykcByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getId()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeJxjykc();
            model.setId(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveJxjykc")
    public RequsetData<String> saveJxjykc(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeJxjykc dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeJxjykc.class);
            List<PeJxjykcqkWithBLOBs> recordList = JsonMapper.jsonToObject(reqMap.get("recordList").toString(), new TypeReference<List<PeJxjykcqkWithBLOBs>>() {
            });

            String flowId = reqMap.get("flowId").toString();

            count = peFlowService.saveJxjykc(dataModel, recordList, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/getJxjykcqkList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getJxjykcqkList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                          @RequestParam(required = false) String kcid) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(peFlowService.getJxjykcqkList(pageIndex, pageSize, kcid));
        return result;
    }

    @ResponseBody
    @GetMapping("/deljxjykc")
    public RequsetData<Integer> delJxjykc(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peFlowService.delJxjykc(joinUserId, flowId);
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
    @RequestMapping("/getTczzsqById")
    public RequsetData<PeTczzsq> getTczzsqById(@RequestParam("joinUserId") String joinUserId, @RequestParam("flowId") String flowId) {
        RequsetData<PeTczzsq> res = new RequsetData<>();

        PeTczzsq model = peFlowService.getTczzsqByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getId()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeTczzsq();
            model.setId(uuid.toString());
            model.setJoinuserid(joinUserId);

            PeWordtemplate it = peWordTemplateService.getWordByFlowId(flowId);
            model.setPeriodcontent(it.getTemplate());

        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveTczzsq")
    public RequsetData<String> savegTczzsq(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeTczzsq dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeTczzsq.class);

            String flowId = reqMap.get("flowId").toString();

            count = peFlowService.saveTczzsq(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/deltczzsq")
    public RequsetData<Integer> delTczzsq(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peFlowService.delTczzsq(joinUserId, flowId);
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
    @RequestMapping("/getzbdhtl")
    public RequsetData<PeZbdhtl> getZbdhtl(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeZbdhtl> res = new RequsetData<>();

        PeZbdhtl model = peFlowService.getZbdhtlByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getId()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeZbdhtl();
            model.setId(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        //获取编入的党支部，选取三会一课的时候只能选择当前编入党支部的会议
        Map<String, Object> extdata = new HashMap<>();
        PeBrdzb brdzb = peFlowService.getBrdzbByUserId(joinUserId);
        if (brdzb != null && brdzb.getDzzdm() != null) {
            extdata.put("dzzdm", brdzb.getDzzdm());
        }
        res.setExtdata(extdata);
        return res;
    }

    @ResponseBody
    @RequestMapping("/savezbdhtl")
    public RequsetData<String> savegZbdhtl(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeZbdhtl dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeZbdhtl.class);

            String flowId = reqMap.get("flowId").toString();

            count = peFlowService.saveZbdhtl(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delzbdhtl")
    public RequsetData<Integer> delZbdhtl(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peFlowService.delZbdhtl(joinUserId, flowId);
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
    @RequestMapping("/getSjdwsp")
    public RequsetData<PeSjdwsp> getSjdwsp(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeSjdwsp> res = new RequsetData<>();

        PeSjdwsp model = peFlowService.getSjdwspByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getId()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeSjdwsp();
            model.setId(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveSjdwsp")
    public RequsetData<String> savegSjdwsp(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeSjdwsp dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeSjdwsp.class);

            String flowId = reqMap.get("flowId").toString();

            count = peFlowService.saveSjdwsp(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delsjdwsp")
    public RequsetData<Integer> delSjdwsp(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peFlowService.delSjdwsp(joinUserId, flowId);
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
    @RequestMapping("/getzlgd")
    public RequsetData<PeZlgd> getZlgd(@RequestParam("joinUserId") String joinUserId,@RequestParam("userName") String userName) {
        RequsetData<PeZlgd> res = new RequsetData<>();

        PeZlgd model = peFlowService.getZlgdByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getId()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeZlgd();
            model.setId(uuid.toString());
            model.setJoinuserid(joinUserId);
            model.setArchiveuser(userName);
        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/savezlgd")
    public RequsetData<String> savegZlgd(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeZlgd dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeZlgd.class);

            String flowId = reqMap.get("flowId").toString();

            count = peFlowService.saveZlgd(dataModel, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/delzlgd")
    public RequsetData<Integer> delZlgd(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peFlowService.delZlgd(joinUserId, flowId);
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
    @RequestMapping("/getSjprth")
    public RequsetData<PeSjprth> getSjprth(@RequestParam("joinUserId") String joinUserId) {
        RequsetData<PeSjprth> res = new RequsetData<>();

        PeSjprth model = peFlowService.getSjprthByUserId(joinUserId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getSjprthid()))) {
            UUID uuid = UUID.randomUUID();
            model = new PeSjprth();
            model.setSjprthid(uuid.toString());
            model.setJoinuserid(joinUserId);

        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveSjprth")
    public RequsetData<String> saveSjprth(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            PeSjprth dataModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), PeSjprth.class);
            List<PeSjprthmx> userList = JsonMapper.jsonToObject(reqMap.get("userList").toString(), new TypeReference<List<PeSjprthmx>>() {
            });

            String flowId = reqMap.get("flowId").toString();

            count = peFlowService.saveSjprth(dataModel, userList, flowId, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

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
    @GetMapping("/getSjprthmxList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getSjprthmxList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                          @RequestParam(required = false) String sjprthId) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(peFlowService.getSjprthmxList(pageIndex, pageSize, sjprthId));
        return result;
    }

    @ResponseBody
    @GetMapping("/delsjprth")
    public RequsetData<Integer> delSjprth(@RequestParam("flowId") String flowId, @RequestParam("joinUserId") String joinUserId) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = peFlowService.delSjprth(joinUserId, flowId);
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
    @RequestMapping(value = "/createWord_tczzsq", method = RequestMethod.GET)
    public void createWord_tczzsq(HttpServletResponse response, @RequestParam("joinUserId") String joinUserId) {

        try {
            PeTczzsq model = peFlowService.getTczzsqByUserId(joinUserId);
            /** 用于组装word页面需要的数据 */
            Map<String, Object> dataMap = new HashMap<String, Object>();
            // 组装数据
            dataMap.put("content", model.getPeriodcontent());

            /** 生成word **/
            wordUtil.createWord(response, dataMap, "转正申请书", "转正申请书");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
