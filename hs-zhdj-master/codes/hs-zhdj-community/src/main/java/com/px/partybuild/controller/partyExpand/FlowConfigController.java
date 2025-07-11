package com.px.partybuild.controller.partyExpand;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.*;
import com.px.partybuild.service.FlowConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/flowConfig")
public class FlowConfigController {

    @Autowired
    FlowConfigService FlowConfigService;

    @ResponseBody
    @GetMapping("/getFlowList")
    public RequsetData< List<Map<String, Object>>> getFlowList(@RequestParam(required = false) String parentId) {

        RequsetData< List<Map<String, Object>>> result = new RequsetData<>();
        List<Map<String, Object>> list = FlowConfigService.getFlowList(parentId);
        result.setItem(list);
        return result;
    }
    @ResponseBody
    @GetMapping("/getSubFlowList")
    public RequsetData<List<PeFlow>> getSubFlowList(@RequestParam(required = false) String parentId,@RequestParam(required = false) Integer orderby) {

        RequsetData<List<PeFlow>> result = new RequsetData<>();
        List<PeFlow> list = FlowConfigService.getSubFlowList(parentId,orderby);
        result.setItem(list);
        return result;
    }

    @ResponseBody
    @RequestMapping("/getFlowByid")
    public RequsetData<PeFlowWithBLOBs> getFlowByid(@RequestParam(required = false) String id,@RequestParam(required = false) String parentid) {
        RequsetData<PeFlowWithBLOBs> res = new RequsetData<>();

        PeFlowWithBLOBs model = FlowConfigService.getFlowByid(id);
        if (model == null) {
            UUID uuid = UUID.randomUUID();
            model = new PeFlowWithBLOBs();
            model.setFlowid(uuid.toString());
            model.setParentid(parentid);
        }
        res.setItem(model);
        return res;
    }
    @ResponseBody
    @RequestMapping("/save")
    public RequsetData<String> save(@RequestBody PeFlowWithBLOBs model) {

        RequsetData<String> res = FlowConfigService.save(model);

        return res;
    }
    @ResponseBody
    @GetMapping("/delete")
    public RequsetData<Integer> delete(@RequestParam("flowid") String flowid) {

        RequsetData<Integer> result = new RequsetData<>();
        int row = FlowConfigService.delete(flowid);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }
}
