package com.px.partybuild.controller;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.AdPartygroup;
import com.px.partybuild.service.AdPartyGroupService;
import com.px.partybuild.service.UserService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.vo.AdPartyGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/adPartyGroup")
public class AdPartyGroupController {

    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private AdPartyGroupService adPartyGroupService;

    @ResponseBody
    @GetMapping("/getList")
    public RequsetData<List<AdPartyGroupVo>> getList(String parentId) {
        RequsetData<List<AdPartyGroupVo>> result = new RequsetData<>();
        result.setItem(adPartyGroupService.getList(parentId));
        return result;
    }

    @ResponseBody
    @GetMapping("/get")
    public RequsetData<AdPartygroup> get(@RequestParam(required = false) String id) {
        RequsetData<AdPartygroup> res = new RequsetData<>();

        AdPartygroup model = adPartyGroupService.get(id);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getId()))) {
            /*UUID uuid = UUID.randomUUID();*/
            model = new AdPartygroup();
           /* model.setId(uuid.toString());*/
        }

        res.setItem(model);
        return res;
    }

    @ResponseBody
    @PostMapping("/save")
    public RequsetData<String> save(@RequestBody AdPartygroup data) {
        RequsetData<String> res = new RequsetData<String>();

        int count = adPartyGroupService.save(data, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());
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
    @GetMapping("/delete")
    public RequsetData<Integer> delete(String id) {
        RequsetData<Integer> result = new RequsetData<>();

        int row = adPartyGroupService.delete(id);
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
    @GetMapping("/getTree")
    public RequsetData<List<AdPartyGroupVo>> getTree(String parentId) {
        RequsetData<List<AdPartyGroupVo>> result = new RequsetData<>();
        result.setItem(adPartyGroupService.getTree(parentId));
        return result;
    }
}
