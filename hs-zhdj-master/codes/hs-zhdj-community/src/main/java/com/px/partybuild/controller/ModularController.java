package com.px.partybuild.controller;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.ApModular;
import com.px.partybuild.model.ApRolemodular;
import com.px.partybuild.service.ModularService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/modular")
public class ModularController {
    @Autowired
    private ModularService modularService;

    @ResponseBody
    @GetMapping("/getModularListByRoleId")
    public RequsetData<List<HashMap<String, Object>>> getModularListByRoleId(@RequestParam(required = true) String roleId) {
        RequsetData<List<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(modularService.selectModularByRoleId(roleId));
        return result;
    }

    @ResponseBody
    @GetMapping("/selectModularList")
    public RequsetData<PageInfo<HashMap<String, Object>>> selectModularList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam(required = false) String roleId, @RequestParam(required = false) String modularname) {
        RequsetData<PageInfo<HashMap<String, Object>>> res = new RequsetData<>();
        PageInfo<HashMap<String, Object>> list = modularService.selectModularList(pageIndex,pageSize,roleId,modularname);
        res.setItem(list);
        return res;
    }

    @ResponseBody
    @GetMapping("/selectModularByMid")
    public RequsetData<HashMap<String, Object>> selectModularByMid(@RequestParam("MID") String MID) {
        RequsetData<HashMap<String, Object>> result = new RequsetData<>();
        HashMap<String, Object> map = modularService.selectModularByMid(MID);
        result.setItem(map);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @PostMapping("/saveModular")
    public RequsetData<Integer> saveModular(@RequestBody ApModular model) {
        RequsetData<Integer> result = new RequsetData<>();
        int row = modularService.saveModular(model);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("添加失败！");
        } else {
            result.setSuccess(true);
            result.setMsg("添加成功！");
        }
        return result;
    }

    @ResponseBody
    @GetMapping("/deleteModular")
    public RequsetData<Integer> deleteModular(@RequestParam("MID") String MID) {

        RequsetData<Integer> result = new RequsetData<>();
        int row = modularService.deleteModular(MID);
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
    @GetMapping("/deleteModularRole")
    public RequsetData<Integer> deleteModularRole(@RequestParam("MODULARID") String MODULARID,@RequestParam("ROLEID") String ROLEID) {

        RequsetData<Integer> result = new RequsetData<>();
        int row = modularService.deleteModularRole(MODULARID, ROLEID);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("修改失败！");
        } else {
            result.setMsg("修改成功！");
        }
        return result;
    }

    @ResponseBody
    @PostMapping("/saveModularRole")
    public RequsetData<Integer> saveModularRole(@RequestBody ApRolemodular model) {

        RequsetData<Integer> result = new RequsetData<>();
        int row = modularService.saveModularRole(model);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("修改失败！");
        } else {
            result.setMsg("修改成功！");
        }
        return result;
    }

}
