package com.px.partybuild.controller;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.MhLink;
import com.px.partybuild.model.MhMhfl;
import com.px.partybuild.model.MhSylm;
import com.px.partybuild.service.MhService;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.service.UserService;
import com.px.partybuild.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/mh")
public class MhController {

    @Autowired
    MhService mhService;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private com.px.partybuild.util.StringUtils stringUtils;
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/SylmList")
    public RequsetData<PageInfo<Map<String, Object>>> FindSylmList(@RequestParam("lmbt") String lmbt, @RequestParam(value = "zt", required = false) String zt, @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {

        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();

        int no_zt = 0;
        if (StringUtils.isNoneBlank(zt)) {
            no_zt = new Integer(zt);
        }

        PageInfo<Map<String, Object>> list = mhService.SelectSylmList(lmbt, no_zt, pageIndex, pageSize);
        res.setItem(list);
        return res;
    }

    @ResponseBody
    @PostMapping("/SaveSylm")
    public RequsetData<Integer> SaveSylm(@RequestBody MhSylm model) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = mhService.SaveSylm(model);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("保存失败！");
        } else {
            result.setMsg("保存成功！");
        }

        return result;
    }

    @ResponseBody
    @GetMapping("/DelSylm")
    public RequsetData<Integer> DelSylm(@RequestParam("sylmbs") String sylmbs) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = mhService.RemoveSylm(sylmbs);
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
    @GetMapping("/FindFlList")
    public RequsetData<List<Map<String, Object>>> FindFlList(@RequestParam("searchFlmc") String flmc) {

        RequsetData<List<Map<String, Object>>> res = new RequsetData<>();

        List<Map<String, Object>> list = mhService.SelectFlOneMcList(flmc);
        res.setItem(list);
        return res;
    }

    @ResponseBody
    @PostMapping("/SaveMhfL")
    public RequsetData<Integer> SaveMhfL(@RequestBody MhMhfl model) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = mhService.SaveMHFL(model);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("保存失败！");
        } else {
            result.setMsg("保存成功！");
        }

        return result;
    }

    @ResponseBody
    @GetMapping("/DelMhfl")
    public RequsetData<Integer> DelMhfl(@RequestParam("mhflbs") String mhflbs) {

        RequsetData<Integer> result = new RequsetData<>();

        String msg = mhService.RemoveMHFL(mhflbs);
        if (StringUtils.isBlank(msg)) {
            result.setItem(1);
            result.setMsg("删除成功！");
        } else {
            result.setItem(0);
            result.setSuccess(false);
            result.setMsg(msg);
        }
        return result;
    }

    @ResponseBody
    @GetMapping("/SelectMhfLParent")
    public RequsetData<PageInfo<MhMhfl>> SelectMhfLParent(@RequestParam("flmc") String flmc, @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {
        RequsetData<PageInfo<MhMhfl>> result = new RequsetData<>();

        PageInfo<MhMhfl> list = mhService.SelectMhfLParent(flmc, pageIndex, pageSize);
        result.setItem(list);

        return result;
    }

    @ResponseBody
    @GetMapping("/LoadSylm")
    public RequsetData<MhSylm> LoadSylm(@RequestParam("id") String id) {

        RequsetData<MhSylm> result = new RequsetData<MhSylm>();

        if (StringUtils.isBlank(id)) {
            MhSylm model = new MhSylm();
            model.setSylmbs(UUID.randomUUID().toString());
            model.setZt(1);
            model.setSx(1);

            result.setItem(model);
        }

        return result;
    }


    @ResponseBody
    @GetMapping("/getLinkList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getLinkList(int pageindex, int pagesize, @RequestParam(required = false) String title) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(mhService.getLinkList(pageindex, pagesize, title));
        return result;
    }

    @ResponseBody
    @GetMapping("/getLinkById")
    public RequsetData<MhLink> getLinkById(@RequestParam(required = false) String id) {
        RequsetData<MhLink> res = new RequsetData<>();

        MhLink model = mhService.getLinkById(id);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getLinkid()))) {
            UUID uuid = UUID.randomUUID();
            model = new MhLink();
            model.setLinkid(uuid.toString());
            model.setRecordstatus(1);
        }

        res.setItem(model);
        return res;
    }

    @ResponseBody
    @PostMapping("/saveLink")
    public RequsetData<String> saveLink(@RequestBody MhLink data) {
        RequsetData<String> res = new RequsetData<String>();

        int count = mhService.saveLink(data, userService.getLoginUser().getUserid());
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
    @GetMapping("/deleteLink")
    public RequsetData<Integer> deleteLink(String id) {
        RequsetData<Integer> result = new RequsetData<>();

        int row = mhService.deleteLink(id);
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
    @GetMapping("/getSubjectList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getSubjectList(int pageindex, int pagesize) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(mhService.getSubjectList(pageindex, pagesize));
        return result;
    }


}
