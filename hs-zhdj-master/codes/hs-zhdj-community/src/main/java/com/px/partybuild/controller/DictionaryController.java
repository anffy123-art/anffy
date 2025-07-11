package com.px.partybuild.controller;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.controller.jsonmodel.SelectTagView;
import com.px.partybuild.model.CfDictionary;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/dictionaryList")
    public RequsetData<PageInfo<CfDictionary>> FindDictionaryList(@RequestParam("appId") String appId, @RequestParam("dicTypeKey") String dicTypeKey, @RequestParam("dicvalue") String dicvalue, @RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize) {

        RequsetData<PageInfo<CfDictionary>> res = new RequsetData<>();
        res.setItem(dictionaryService.getDictionaryList(appId, dicTypeKey, dicvalue, pageIndex, pageSize));
        return res;
    }

    //GetDictionary

    @ResponseBody
    @GetMapping("/getDictionaryByID")
    public RequsetData<CfDictionary> GetDictionary(@RequestParam("id") String id) {

        RequsetData<CfDictionary> res = new RequsetData<>();
        res.setItem(dictionaryService.getDictionaryById(id));
        return res;
    }

    @ResponseBody
    @PostMapping("/dictionarySave")
    public RequsetData<String> saveDictionary(@RequestBody CfDictionary model) {

        RequsetData<String> res = new RequsetData<>();
        int saverow = dictionaryService.saveDictionary(model);
        if (saverow > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！");
        }
        return res;
    }

    @ResponseBody
    @GetMapping("/delDictionary")
    public RequsetData<String> delDictionary(@RequestParam("dictionaryid") String dictionaryid) {

        RequsetData<String> res = new RequsetData<>();
        int drow = dictionaryService.delDictionary(dictionaryid);

        if (drow > 0) {
            res.setSuccess(true);
            res.setMsg("删除成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("删除失败！");
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/getDictionaryListByDicTypeKey")
    public List<CfDictionary> GetDictionaryListByDicTypeKey(@RequestParam("dicTypeKey") String dicTypeKey) {
        List<CfDictionary> result = dictionaryService.getDictionaryListByDicTypeKey(dicTypeKey);

        return result;
    }

    @ResponseBody
    @GetMapping("/GetDictionaryList")
    public RequsetData<PageInfo<List<SelectTagView>>> GetDictionaryList(@RequestParam(required = false) String dicTypeKey) {
        List<CfDictionary> list = dictionaryService.getDictionaryListByDicTypeKey(dicTypeKey);
        List<SelectTagView> result = new ArrayList<SelectTagView>();
        for (CfDictionary dic : list) {
            SelectTagView item = new SelectTagView();
            item.setLabel(dic.getDicvalue());
            item.setVal(dic.getDickey().toString());
            result.add(item);
        }
        PageInfo<List<SelectTagView>> pages = new PageInfo(result);
        RequsetData<PageInfo<List<SelectTagView>>> res = new RequsetData<>();
        res.setItem(pages);
        return res;
    }

    @ResponseBody
    @GetMapping("/getMonthList")
    public List<HashMap<String, Object>> GetMonthList() {
        List<HashMap<String, Object>> result = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("dickey", i);
            map.put("dicvalue", i);
            result.add(map);
        }
        return result;
    }

    @ResponseBody
    @GetMapping("/getYearsList")
    public List<HashMap<String, Object>> GetYearsList() {
        List<HashMap<String, Object>> result = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        for (int i = year; i >= year - 5; i--) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("dickey", i);
            map.put("dicvalue", i);
            result.add(map);
        }
        return result;
    }

    @ResponseBody
    @GetMapping("/geDaysList")
    public List<HashMap<String, Object>> geDaysList() {
        List<HashMap<String, Object>> result = new ArrayList<>();

        for (int i = 1; i <= 31; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("dickey", i);
            map.put("dicvalue", i);
            result.add(map);
        }
        return result;
    }

    @ResponseBody
    @GetMapping("/getQuartersList")
    public List<HashMap<String, Object>> getQuartersList() {
        List<HashMap<String, Object>> result = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("dickey", i);
            map.put("dicvalue", i);
            result.add(map);
        }
        return result;
    }

}
