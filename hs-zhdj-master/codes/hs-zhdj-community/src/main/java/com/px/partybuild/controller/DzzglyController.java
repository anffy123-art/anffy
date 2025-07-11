package com.px.partybuild.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.ZzDzzgly;
import com.px.partybuild.service.DzzglyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/dzzgly")
public class DzzglyController {

    @Resource
    private DzzglyService dzzglyService;

    @PostMapping("/save")
    public RequsetData<String> save(@RequestBody ZzDzzgly dzzgly) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            count = this.dzzglyService.save(dzzgly);
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            if (count == -1) {
                message = "重复添加";
            }
            res.setMsg("保存失败！" + message);
        }
        return res;
    }


    @GetMapping("/list")
    public RequsetData<PageInfo<ZzDzzgly>> list(String dwName) {

        PageInfo<ZzDzzgly> pageInfo = this.dzzglyService.list( dwName);
        RequsetData<PageInfo<ZzDzzgly>> page = new RequsetData<>();
        page.setItem(pageInfo);
        return page;
    }

    @GetMapping("/selectUser")
    public RequsetData<PageInfo<ZzDzzgly>> selectUser(@Param("pageindex") Integer pageindex, @Param("pagesize") Integer pagesize, String dzzdm, String userName) {

        PageInfo<ZzDzzgly> pageInfo = this.dzzglyService.selectUser(pageindex, pagesize, dzzdm, userName);
        RequsetData<PageInfo<ZzDzzgly>> page = new RequsetData<>();
        page.setItem(pageInfo);
        return page;
    }

    @GetMapping("/chooseDw")
    public RequsetData<PageInfo<ZzDzzgly>> listChooseDw() {

        PageInfo<ZzDzzgly> page = this.dzzglyService.listChooseDW();
        RequsetData requsetData = new RequsetData();
        requsetData.setItem(page);
        return requsetData;
    }
}
