package com.px.partybuild.controller;


import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.YsHdbz;
import com.px.partybuild.service.JfysService;
import com.px.partybuild.util.ExcelHelper;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.vo.YsJfysmxVo;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JfysController
 *
 * @author H
 * @date 2024-08
 */
@RestController
@RequestMapping(value = "/api/jfys")
public class JfysController {

    @Autowired
    JfysService jfysService;

    @Autowired
    private MapUtils mapUtils;
    @ResponseBody
    @GetMapping("/HdbzList")
    public RequsetData<PageInfo<Map<String, Object>>> hdbzList(@RequestParam(required = false) Integer nd, @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {

        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();


        PageInfo<Map<String, Object>> list = jfysService.selectHdbzList(nd, pageIndex, pageSize);
        res.setItem(list);
        return res;
    }

    @ResponseBody
    @GetMapping("/YsjybList")
    public RequsetData<PageInfo<Map<String, Object>>> ysjybList(@RequestParam(required = false) Integer nd, @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {

        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();


        PageInfo<Map<String, Object>> list = jfysService.selectYsjybList(nd, pageIndex, pageSize);
        res.setItem(list);
        return res;
    }

    @ResponseBody
    @GetMapping("/getHdbz")
    public RequsetData<YsHdbz> getHdbz(@RequestParam(required = false) Integer nd) {
        RequsetData<YsHdbz> result = new RequsetData<>();
        YsHdbz model = new YsHdbz();
        model.setNd(nd);
        List<YsHdbz> list = jfysService.selectByExample(model);
        if (list.size() > 0) {
            result.setSuccess(true);
            result.setItem(list.get(0));
        } else {
            result.setSuccess(false);
            result.setMsg("该年度未设置核定标准，请先设置！");
        }
        return result;
    }

    @ResponseBody
    @GetMapping("/YsjybmxList")
    public RequsetData<List<YsJfysmxVo>> ysjybmxList(@RequestParam(required = false) Integer nd) {

        RequsetData<List<YsJfysmxVo>> res = new RequsetData<>();


        List<YsJfysmxVo> list = jfysService.selectYsjybmxList(nd);
        res.setItem(list);
        return res;
    }

    @ResponseBody
    @PostMapping("/SaveHdbz")
    public RequsetData<Integer> saveHdbz(@RequestBody YsHdbz model) {

        RequsetData<Integer> result = new RequsetData<>();
        List<YsHdbz> list = jfysService.selectByExample(model);
        if (list.size() > 0) {
            result.setSuccess(false);
            result.setMsg("该年度记录已经存在，不允许重复添加！");
            return result;
        }
        int row = jfysService.saveHdbz(model);
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
    @GetMapping("/DelHdbz")
    public RequsetData<Integer> delHdbz(@RequestParam("hdbzid") String hdbzid) {

        RequsetData<Integer> result = new RequsetData<>();
        int row = jfysService.removeHdbz(hdbzid);
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
    @GetMapping("/DelJfysb")
    public RequsetData<Integer> delJfysb(@RequestParam("jfysbid") String jfysbid) {

        RequsetData<Integer> result = new RequsetData<>();
        int row = jfysService.deleteJfysb(jfysbid);
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
    @RequestMapping("/saveYsjybmx")
    public RequsetData<String> saveYsjybmx(@RequestBody Map<String, Object> reqMap) {

        RequsetData<String> res = jfysService.saveYsjybmx(reqMap);

        return res;
    }

    @RequestMapping(value = "/exportJfysb", method = RequestMethod.GET)
    public void exportJfysb(HttpServletResponse response, @RequestParam(required = false) Integer nd) throws Exception {

        RequsetData<List<Map<String, Object>>> res = new RequsetData<>();
        YsHdbz model = new YsHdbz();
        model.setNd(nd);
        List<YsHdbz> ysHdbzlist = jfysService.selectByExample(model);
        if (ysHdbzlist.size() == 0) {
            throw new Exception("该年度未设置核定标准");
        }
        List<YsJfysmxVo> list = jfysService.selectYsjybmxList(nd);
        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党组织工作经费预算建议表信息");
        List<Map<String, CellRangeAddress>> colspanTitles = new ArrayList();
        Map<String, CellRangeAddress> titles = new HashMap<>(8);

        titles.put("单位", new CellRangeAddress(0, 1, 0, 0));
        titles.put("车间级党(总)支部数", new CellRangeAddress(0, 0, 1, 4));
        titles.put("党支部经费小计", new CellRangeAddress(0, 1, 5, 5));
        titles.put("核定标准", new CellRangeAddress(0, 0, 6, 9));
        titles.put("在岗党员人数", new CellRangeAddress(0, 1, 10, 10));
        titles.put("核定标准(" + ysHdbzlist.get(0).getHdbz()+"/人)", new CellRangeAddress(0, 1, 11, 11));
        titles.put("系统预算总额", new CellRangeAddress(0, 1, 12, 12));
        titles.put("实际预算总额", new CellRangeAddress(0, 1, 13, 13));

        List<String> titles2 = new ArrayList();
        titles2.add("");
        titles2.add("50人及以下");
        titles2.add("51-100人");
        titles2.add("101-300人");
        titles2.add("300人以上");
        titles2.add("");
        titles2.add("50人及以下(" + ysHdbzlist.get(0).getV1() + "/个)");
        titles2.add("51-100人(" + ysHdbzlist.get(0).getV2() + "/个)");
        titles2.add("101-300人(" + ysHdbzlist.get(0).getV3() + "/个)");
        titles2.add("300人以上(" + ysHdbzlist.get(0).getV4() + "/个)");
        titles2.add("");
        titles2.add("");
        titles2.add("");
        titles2.add("");
        colspanTitles.add(titles);
        data.setColspanTitles(colspanTitles);
        data.setTitles(titles2);
        //数据
        List<List<Object>> rows = new ArrayList();
        for (YsJfysmxVo vo : list) {
            List<Object> row = new ArrayList();
            Map<String, Object> item=mapUtils.objectToMap(vo);
            row.add(item.get("dzzmc"));
            row.add(item.get("v1sl"));
            row.add(item.get("v2sl"));
            row.add(item.get("v3sl"));
            row.add(item.get("v4sl"));
            row.add(item.get("dzbjfxj"));
            row.add(item.get("v1hdbz"));
            row.add(item.get("v2hdbz"));
            row.add(item.get("v3hdbz"));
            row.add(item.get("v4hdbz"));
            row.add(item.get("zgdyrs"));
            row.add(item.get("hdbz"));
            row.add(item.get("xtysze"));
            row.add(item.get("sjysze"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党组织工作经费预算建议表信息.xlsx", data);
    }
}
