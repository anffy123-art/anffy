package com.px.partybuild.controller;

import com.px.partybuild.model.*;
import com.px.partybuild.service.PartyDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 党建字典
 *
 * @author H
 */

@RestController
@RequestMapping(value = "/api/partyDic")
public class PartyDicController {

    @Autowired
    private PartyDicService partyDicService;

    /**
     * 组织类别
     **/
    @ResponseBody
    @GetMapping("/getZzlbdmList")
    public List<ZzzdZzlbdmnew> getZzlbdmList() {
        return partyDicService.getZzlbdmList();
    }

    /**
     * 基层组织分类
     **/
    @ResponseBody
    @GetMapping("/getJczzflList")
    public List<ZzzdJczzflnew> getJczzflList() {
        return partyDicService.getJczzflList();
    }

    /**
     * 选举方式
     **/
    @ResponseBody
    @GetMapping("/getXjfslList")
    public List<ZzzdXjfsdm> getXjfslList() {
        return partyDicService.getXjfslList();
    }

    /**
     * 党内职务
     **/
    @ResponseBody
    @GetMapping("/getZwmcList")
    public List<ZzzdZwmc> getZwmcList() {
        return partyDicService.getZwmcList();
    }

    /**
     * 任职方式
     **/
    @ResponseBody
    @GetMapping("/getRzfsList")
    public List<ZzzdRzfs> getRzfsList() {
        return partyDicService.getRzfsList();
    }

    /**
     * 职务级别
     **/
    @ResponseBody
    @GetMapping("/getdzzwjbmList")
    public List<ZdDzzwjbm> getdzzwjbmList() {
        return partyDicService.getdzzwjbmList();
    }

    /**
     * 职务级别
     **/
    @ResponseBody
    @GetMapping("/getRyztList")
    public List<ZzzdRyzt> getRyztList() {
        return partyDicService.getRyztList();
    }

    /**
     * 职务级别
     **/
    @ResponseBody
    @GetMapping("/getGzgwList")
    public List<ZzzdGzgw> getGzgwList() {
        return partyDicService.getGzgwList();
    }

    /**
     * 出国出境原因
     **/
    @ResponseBody
    @GetMapping("/getCglbList")
    public List<HashMap<String, Object>> getCglbList() {
        return partyDicService.getCglbList();
    }

    /**
     * 出国出境类别
     **/
    @ResponseBody
    @GetMapping("/getCgcjlbList")
    public List<HashMap<String, Object>> getCgcjlbList() {
        return partyDicService.getCgcjlbList();
    }

    /**
     * 培训情况
     **/
    @ResponseBody
    @GetMapping("/getPxqkList")
    public List<HashMap<String, Object>> getPxqkList() {
        return partyDicService.getPxqkList();
    }

    /**
     * 一线情况
     **/
    @ResponseBody
    @GetMapping("/getYxqkList")
    public List<HashMap<String, Object>> getYxqkList() {
        return partyDicService.getYxqkList();
    }

    /**
     * 最近培训结果
     **/
    @ResponseBody
    @GetMapping("/getZjpxjgList")
    public List<HashMap<String, Object>> getZjpxjgList() {
        return partyDicService.getZjpxjgList();
    }

    /**
     * 专职或兼职情况
     **/
    @ResponseBody
    @GetMapping("/getZzjzqkList")
    public List<HashMap<String, Object>> getZzjzqkList() {
        return partyDicService.getZzjzqkList();
    }


    /**
     * @Description //TODO 职务级别2
     * @date 2024-08
     * @Param []
     **/
    @ResponseBody
    @GetMapping("/getDzzwjbm2List")
    public List<HashMap<String, Object>> getDzzwjbm2List() {
        return partyDicService.getdzzwjbm2List();
    }

    /**
     * @Description //TODO 学历
     * @date 2024-08
     * @Param []
     **/
    @ResponseBody
    @GetMapping("/getEducationList")
    public List<HashMap<String, Object>> getEducationList() {
        return partyDicService.getEducationList();
    }

    /**
     * @Description //TODO 民族
     * @date 2024-08
     * @Param []
     **/
    @ResponseBody
    @GetMapping("/getNationList")
    public List<HashMap<String, Object>> getNationList() {
        return partyDicService.getNationList();
    }

}
