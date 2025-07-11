package com.px.partybuild.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.*;
import com.px.partybuild.service.FileMgrService;
import com.px.partybuild.service.PartyService;
import com.px.partybuild.service.PartyTwoExtService;
import com.px.partybuild.shiro.RolePermissionCode;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.ExcelHelper;
import com.px.partybuild.util.JsonMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/partyTowExt")
public class PartyTwoExtController {

    @Autowired
    PartyTwoExtService partyTwoExtService;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private PartyService partyService;

    @Autowired
    private FileMgrService fileMgrService;

    @ResponseBody
    @RequestMapping("/getResultmgList")
    @RolePermissionCode("DjResultMgList.btnSearch")
    public RequsetData<PageInfo<Map<String, Object>>> getResultmgList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                      @RequestParam(required = false) String partyCode,
                                                                      @RequestParam(required = false) String name, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
                                                                      @RequestParam(required = false) Integer zzfbType) {


        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();

        beginTime = dateUtils.strFormat_short(beginTime);
        endTime = dateUtils.strFormat_short(endTime);

        PageInfo<Map<String, Object>> plist = partyTwoExtService.resultmgList(pageIndex, pageSize, partyCode, name, beginTime, endTime, zzfbType);
        res.setItem(plist);

        return res;
    }

    @ResponseBody
    @GetMapping("/getResultmgData")
    public RequsetData<DjResultmg> getResultmgData(@RequestParam() String id, @RequestParam(required = false) String pcode) {
        RequsetData<DjResultmg> res = new RequsetData<>();

        try {
            DjResultmg it = partyTwoExtService.getDjresultmgItem(id);
            if (StringUtils.isBlank(it.getPartycode())) {
                it.setPartycode(pcode);
                ZzZzqkxx party = partyService.getPartyByDm(pcode);
                it.setPartyname(party.getDzzmc());
            }
            res.setItem(it);
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("读取数据失败：" + ex.getMessage());
        }

        return res;
    }

    @ResponseBody
    @PostMapping("/ResultmgSave")
    public RequsetData<Integer> ResultmgSave(@RequestBody DjResultmg item) {
        RequsetData<Integer> res = new RequsetData<>();
        try {
            int id = partyTwoExtService.djresultmgSave(item);
            res.setItem(id);
            res.setMsg("保存成功！");
        } catch (Exception ex) {
            res.setMsg("保存失败：" + ex.getMessage());
            res.setSuccess(false);
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/resultmgDel")
    public RequsetData<Integer> resultmgDel(@RequestParam() String id) {
        RequsetData<Integer> res = new RequsetData<>();

        try {
            int rows = partyTwoExtService.djresultmgDel(id);
            res.setItem(rows);
            res.setMsg("删除成功！");
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("删除失败：" + ex.getMessage());
        }

        return res;
    }

    @RequestMapping(value = "/exportResultmg", method = RequestMethod.GET)
    public void exportresultmg(HttpServletResponse response,
                               @RequestParam(required = false) String partyCode,
                               @RequestParam(required = false) String name, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
                               @RequestParam(required = false) Integer zzfbType) throws Exception {

        beginTime = dateUtils.strFormat_short(beginTime);
        endTime = dateUtils.strFormat_short(endTime);

        /**查询数据**/
        List<Map<String, Object>> dataList = partyTwoExtService.resultmgList(1, 10000, partyCode, name, beginTime, endTime, zzfbType).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党建工作成果信息");
        List<String> titles = new ArrayList();
        titles.add("所在党组织");
        titles.add("党建成果名称");
        titles.add("认定时间");
        titles.add("主要做法及成效");

        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (Map<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("PARTYNAME"));
            row.add(item.get("RESULTNAME"));
            row.add(dateUtils.strFormat(item.get("SCORETIME").toString()));
            row.add(item.get("SCORETEXT"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党建成果信息.xlsx", data);
    }

    @ResponseBody
    @RequestMapping("/getBrandList")
    public RequsetData<PageInfo<Map<String, Object>>> getBrandList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                   @RequestParam(required = false) String partyCode,
                                                                   @RequestParam(required = false) String pbrandName, @RequestParam(required = false) Integer creatType, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
                                                                   @RequestParam(required = false) Integer zzfbType) {


        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();

        beginTime = dateUtils.strFormat_short(beginTime);
        endTime = dateUtils.strFormat_short(endTime);

        PageInfo<Map<String, Object>> plist = partyTwoExtService.djBrandList(pageIndex, pageSize, partyCode, pbrandName, creatType, beginTime, endTime, zzfbType);
        res.setItem(plist);

        return res;
    }

    @ResponseBody
    @GetMapping("/getBrandData")
    public RequsetData<DjBrand> getBrandData(@RequestParam() String id, @RequestParam(required = false) String pcode) {
        RequsetData<DjBrand> res = new RequsetData<>();

        try {
            DjBrand it = partyTwoExtService.getDjBrandItem(id);
            if (StringUtils.isBlank(it.getPartycode())) {
                it.setPartycode(pcode);
                ZzZzqkxx party = partyService.getPartyByDm(pcode);
                it.setPartyname(party.getDzzmc());
            }
            res.setItem(it);
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("读取数据失败：" + ex.getMessage());
        }

        return res;
    }

    @ResponseBody
    @PostMapping("/BrandSave")
    public RequsetData<Integer> BrandSave(@RequestBody DjBrand item) {
        RequsetData<Integer> res = new RequsetData<>();
        try {

            if (fileMgrService.getFileList(item.getBrandid(), 3, 1, 10).getTotal() <= 0) {
                throw new Exception("请上传附件");
            }

            int id = partyTwoExtService.djBrandSave(item);
            res.setItem(id);
            res.setMsg("保存成功！");
        } catch (Exception ex) {
            res.setMsg("保存失败：" + ex.getMessage());
            res.setSuccess(false);
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/BrandDel")
    public RequsetData<Integer> BrandDel(@RequestParam() String id) {
        RequsetData<Integer> res = new RequsetData<>();

        try {
            int rows = partyTwoExtService.djBrandDel(id);
            res.setItem(rows);
            res.setMsg("删除成功！");
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("删除失败：" + ex.getMessage());
        }

        return res;
    }

    @RequestMapping(value = "/exportBrand", method = RequestMethod.GET)
    public void exportBrand(HttpServletResponse response,
                            @RequestParam(required = false) String partyCode,
                            @RequestParam(required = false) String pbrandName, @RequestParam(required = false) Integer creatType,
                            @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
                            @RequestParam(required = false) Integer zzfbType) throws Exception {

        beginTime = dateUtils.strFormat_short(beginTime);
        endTime = dateUtils.strFormat_short(endTime);

        /**查询数据**/
        List<Map<String, Object>> dataList = partyTwoExtService.djBrandList(1, 10000, partyCode, pbrandName, creatType, beginTime, endTime, zzfbType).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党内品牌信息");
        List<String> titles = new ArrayList();
        titles.add("所在党组织");
        titles.add("党内品牌名称");
        titles.add("创建类别");
        titles.add("挂牌时间");


        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (Map<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("PARTYNAME"));
            row.add(item.get("PBRANDNAME"));
            row.add(item.get("CREATTYPENAME"));
            row.add(dateUtils.strFormat(item.get("BRANDTIME").toString()));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党内品牌信息.xlsx", data);
    }


    @ResponseBody
    @RequestMapping("/getBrandCount")
    public long getBrandCount(
            @RequestParam(required = false) String partyCode,
            @RequestParam(required = false) Integer creatType) {
        return partyTwoExtService.getBrandCount(partyCode, creatType);
    }


    @ResponseBody
    @RequestMapping("/getPartyActivityRoomList")
    public RequsetData<PageInfo<Map<String, Object>>> getPartyActivityRoomList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                               @RequestParam(required = false) String partyCode,
                                                                               @RequestParam(required = false) String addr, @RequestParam(required = false) Integer useRange,
                                                                               @RequestParam(required = false) Integer zzfbType) {


        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();


        PageInfo<Map<String, Object>> plist = partyTwoExtService.djPartyActivityRoomList(pageIndex, pageSize, partyCode, addr, useRange, zzfbType);
        res.setItem(plist);

        return res;
    }

    @ResponseBody
    @GetMapping("/GetPartyActivityRoomData")
    public RequsetData<DjPartyactivityroom> GetPartyActivityRoomData(@RequestParam() String id, @RequestParam(required = false) String pcode) {
        RequsetData<DjPartyactivityroom> res = new RequsetData<>();

        try {
            DjPartyactivityroom it = partyTwoExtService.getDjPartyActivityRoomItem(id);
            if (StringUtils.isBlank(it.getPartycode())) {
                it.setPartycode(pcode);
                ZzZzqkxx party = partyService.getPartyByDm(pcode);
                it.setPartyname(party.getDzzmc());
            } else {
                List<DjPartyactivityroomgroup> rylist = partyTwoExtService.getDjPartyactivityroomgroupList(it.getPartyactivityroomid());
                List<String> dzzzdm = new ArrayList<>();
                List<String> dzzmc = new ArrayList<>();
                Map<String, Object> extdata = new HashMap<>();
                for (DjPartyactivityroomgroup ry : rylist) {
                    dzzzdm.add(ry.getDzzdm());
                    dzzmc.add(ry.getDzzmc());
                }
                extdata.put("dzzdm", String.join(",", dzzzdm));
                extdata.put("dzzmc", String.join(",", dzzmc));
                res.setExtdata(extdata);
            }
            res.setItem(it);
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("读取数据失败：" + ex.getMessage());
        }

        return res;
    }

    @ResponseBody
    @PostMapping("/PartyActivityRoomSave")
    public RequsetData<Integer> PartyActivityRoomSave(@RequestBody Map<String, Object> reqMap) {
        RequsetData<Integer> res = new RequsetData<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            DjPartyactivityroom model = mapper.readValue(mapper.writeValueAsString(reqMap.get("dataModel")).toString(), DjPartyactivityroom.class);
            DjPartyactivityroomgroup[] recordList = JsonMapper.jsonToObject(reqMap.get("partyList").toString(), new TypeReference<DjPartyactivityroomgroup[]>() {
            });

            int id = partyTwoExtService.djPartyActivityRoomSave(model, recordList);
            res.setItem(id);
            res.setMsg("保存成功！");
        } catch (Exception ex) {
            res.setMsg("保存失败：" + ex.getMessage());
            res.setSuccess(false);
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/PartyactivityroomDel")
    public RequsetData<Integer> PartyactivityroomDel(@RequestParam() String id) {
        RequsetData<Integer> res = new RequsetData<>();

        try {
            int rows = partyTwoExtService.djPartyActivityRoomDel(id);
            res.setItem(rows);
            res.setMsg("删除成功！");
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("删除失败：" + ex.getMessage());
        }

        return res;
    }

    @RequestMapping(value = "/exportPartyactivityroom", method = RequestMethod.GET)
    public void exportPartyactivityroom(HttpServletResponse response,
                                        @RequestParam(required = false) String partyCode,
                                        @RequestParam(required = false) String addr, @RequestParam(required = false) Integer useRange,
                                        @RequestParam(required = false) Integer zzfbType) throws Exception {


        /**查询数据**/
        List<Map<String, Object>> dataList = partyTwoExtService.djPartyActivityRoomList(1, 10000, partyCode, addr, useRange, zzfbType).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党员活动室信息");
        List<String> titles = new ArrayList();
        titles.add("所在党组织");
        titles.add("地址");
        titles.add("面积（平方）");
        titles.add("党员人数");
        titles.add("使用范围");

        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (Map<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("PARTYNAME"));
            row.add(item.get("ADDR"));
            row.add(item.get("USEAREA"));
            row.add(item.get("PCOUNT"));
            row.add(item.get("USERANGENAME"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党员活动室信息.xlsx", data);
    }

    @ResponseBody
    @RequestMapping("/GetWxGroupList")
    public RequsetData<PageInfo<Map<String, Object>>> GetWxGroupList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                     @RequestParam(required = false) String partyCode,
                                                                     @RequestParam(required = false) String groupName, @RequestParam(required = false) String partyName, @RequestParam(required = false) Integer implatform,
                                                                     @RequestParam(required = false) String grouperName, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
                                                                     @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) String scaleBegin, @RequestParam(required = false) String scaleEnd) {


        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();

        Integer i_scaleBegin = null, i_scaleEnd = null;

        if (StringUtils.isNumeric(scaleBegin)) {
            i_scaleBegin = Integer.parseInt(scaleBegin);
        }

        if (StringUtils.isNumeric(scaleEnd)) {
            i_scaleEnd = Integer.parseInt(scaleEnd);
        }

        PageInfo<Map<String, Object>> plist = partyTwoExtService.djWxGroupList(pageIndex, pageSize, partyCode, groupName, partyName, implatform, grouperName, beginTime, endTime, zzfbType, i_scaleBegin, i_scaleEnd);
        res.setItem(plist);

        return res;
    }

    @ResponseBody
    @GetMapping("/GetWxGroupData")
    public RequsetData<DjWxgroup> GetWxGroupData(@RequestParam() String id, @RequestParam(required = false) String pcode) {
        RequsetData<DjWxgroup> res = new RequsetData<>();

        try {
            DjWxgroup it = partyTwoExtService.getDjWxGroupItem(id);
            if (StringUtils.isBlank(it.getPartycode())) {
                it.setPartycode(pcode);
                ZzZzqkxx party = partyService.getPartyByDm(pcode);
                it.setPartyname(party.getDzzmc());
            }
            res.setItem(it);
            Map<String, Object> extData = new HashMap<>();
            PageInfo<Map<String, Object>> users = partyTwoExtService.wxGroupUserList(1, 10000, it.getWxgroupid());
            extData.put("userList", users.getList());
            res.setExtdata(extData);

        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("读取数据失败：" + ex.getMessage());
        }

        return res;
    }

    @ResponseBody
    @PostMapping("/WxGroupSave")
    public RequsetData<Integer> WxGroupSave(@RequestBody Map<String, Object> mJson) {
        RequsetData<Integer> res = new RequsetData<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            DjWxgroup item = mapper.readValue(mapper.writeValueAsString(mJson.get("dataModel")), DjWxgroup.class);

            CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Map.class);
            List<Map<String, Object>> details = mapper.readValue(mapper.writeValueAsString(mJson.get("details")), listType);

            int id = partyTwoExtService.djWxGroupSave(item);
            id += partyTwoExtService.wxGroupUserBatchSave(details, item.getWxgroupid(), item.getUpdateuserid(), item.getUpdateusername());

            res.setItem(id);
            res.setMsg("保存成功！");
        } catch (Exception ex) {
            res.setMsg("保存失败：" + ex.getMessage());
            res.setSuccess(false);
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/WxGroupDel")
    public RequsetData<Integer> WxGroupDel(@RequestParam() String id) {
        RequsetData<Integer> res = new RequsetData<>();

        try {
            int rows = partyTwoExtService.djWxGroupDel(id);
            res.setItem(rows);
            res.setMsg("删除成功！");
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("删除失败：" + ex.getMessage());
        }

        return res;
    }

    @RequestMapping(value = "/exportWxGroup", method = RequestMethod.GET)
    public void exportWxGroup(HttpServletResponse response,
                              @RequestParam(required = false) String partyCode,
                              @RequestParam(required = false) String groupName, @RequestParam(required = false) String partyName, @RequestParam(required = false) Integer implatform,
                              @RequestParam(required = false) String grouperName, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
                              @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) String scaleBegin, @RequestParam(required = false) String scaleEnd) throws Exception {


        Integer i_scaleBegin = null, i_scaleEnd = null;

        if (StringUtils.isNumeric(scaleBegin)) {
            i_scaleBegin = Integer.parseInt(scaleBegin);
        }

        if (StringUtils.isNumeric(scaleEnd)) {
            i_scaleEnd = Integer.parseInt(scaleEnd);
        }
        /**查询数据**/
        List<Map<String, Object>> dataList = partyTwoExtService.djWxGroupList(1, 10000, partyCode, groupName, partyName, implatform, grouperName, beginTime, endTime, zzfbType, i_scaleBegin, i_scaleEnd).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("微信工作群信息");
        List<String> titles = new ArrayList();
        titles.add("所在党组织");
        titles.add("群名称");
        titles.add("规模（人数）");
        titles.add("所在平台");
        titles.add("成立时间");
        titles.add("群主");
        titles.add("更新时间");
        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (Map<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("PARTYNAME"));
            row.add(item.get("GROUPNAME"));
            row.add(item.get("SCALENUMBER"));
            row.add(item.get("IMPLATFORMNAME"));
            row.add(item.get("BUILDTIME") == null ? "" : dateUtils.strFormat_long(item.get("BUILDTIME").toString()));
            row.add(item.get("GROUPERNAME"));
            row.add(item.get("UPDATETIME") == null ? "" : dateUtils.strFormat_long(item.get("UPDATETIME").toString()));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "微信工作群信息.xlsx", data);
    }
    @ResponseBody
    @RequestMapping("/importWxGroup")
    public RequsetData<List<Map<String, Object>>> importDnghbf(HttpServletResponse response,@RequestBody Map<String, Object> reqMap) {
        ArrayList<Map<String, Object>> list = JsonMapper.jsonToObject(reqMap.get("userList").toString(), new TypeReference<ArrayList<Map<String, Object>>>() {
        });
        RequsetData<List<Map<String, Object>>> result = new RequsetData<>();
        try {
            List<Map<String, Object>> errorInfo = partyTwoExtService.importWxGroup(list);
            if (errorInfo.size() == 0) {
                result.setSuccess(true);
                result.setMsg("导入成功。");
            } else {
                result.setSuccess(false);
                result.setMsg("导入失败，详情请下载错误提示文件查看。");
                result.setItem(errorInfo);
            }
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMsg("导入失败，" + ex.getMessage());
        }
        return result;
    }
    @ResponseBody
    @RequestMapping("/getGdwydqkList")
    public RequsetData<PageInfo<Map<String, Object>>> getGdwydqkList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                      @RequestParam(required = false) String dzzmc,
                                                                      @RequestParam(required = false) String yearmonth,
                                                                      @RequestParam(required = false) String groupId) {


        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();

        PageInfo<Map<String, Object>> plist = partyTwoExtService.getGdwydqkList(pageIndex, pageSize, dzzmc, yearmonth,groupId);
        res.setItem(plist);

        return res;
    }
    @RequestMapping(value = "/exportGdwydqk", method = RequestMethod.GET)
    public void exportGdwydqk(HttpServletResponse response,
                              @RequestParam(required = false) String dzzmc,
                              @RequestParam(required = false) String yearmonth,@RequestParam(required = false) String groupId) throws Exception {
        /**查询数据**/
        List<Map<String, Object>> dataList = partyTwoExtService.getGdwydqkList(1, 99999, dzzmc, yearmonth,groupId).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("各单位企业号阅读情况");
        List<String> titles = new ArrayList();
        titles.add("单位名称");
        titles.add("年月");
        titles.add("单位总人数");
        titles.add("单位关注总人数");
        titles.add("阅读量");
        titles.add("点赞量");
        titles.add("篇均阅读量");
        titles.add("篇均点赞量");
        titles.add("到达率");
        titles.add("阅读率");
        titles.add("点赞率");
        titles.add("到达率得分");
        titles.add("领导班子阅读量");
        titles.add("党支部书记阅读量");
        titles.add("党员阅读量");
        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (Map<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("DZZMC"));
            row.add(item.get("YEARMONTH"));
            row.add(item.get("DWZRS"));
            row.add(item.get("DWGZZRS"));
            row.add(item.get("YDL"));
            row.add(item.get("DZL"));
            row.add(item.get("PJYDL"));
            row.add(item.get("PJDZL"));
            row.add(item.get("DDL")+"%");
            row.add(item.get("YDLV")+"%");
            row.add(item.get("DZLV")+"%");
            row.add(item.get("DDLDF"));
            row.add(item.get("LDBZYDL"));
            row.add(item.get("DZBSJYDL"));
            row.add(item.get("DYYDL"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "各单位企业号阅读情况.xlsx", data);
    }
    @ResponseBody
    @RequestMapping("/importGdwydqk")
    public RequsetData<List<Map<String, Object>>> importGdwydqk(HttpServletResponse response,@RequestBody Map<String, Object> reqMap) {
        ArrayList<Map<String, Object>> list = JsonMapper.jsonToObject(reqMap.get("userList").toString(), new TypeReference<ArrayList<Map<String, Object>>>() {
        });
        RequsetData<List<Map<String, Object>>> result = new RequsetData<>();
        try {
            List<Map<String, Object>> errorInfo = partyTwoExtService.importGdwydqk(list);
            if (errorInfo.size() == 0) {
                result.setSuccess(true);
                result.setMsg("导入成功。");
            } else {
                result.setSuccess(false);
                result.setMsg("导入失败，详情请下载错误提示文件查看。");
                result.setItem(errorInfo);
            }
        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMsg("导入失败，" + ex.getMessage());
        }
        return result;
    }
    @ResponseBody
    @PostMapping("/deleteGdwydqkList")
    public RequsetData<Integer> deleteGdwydqkList(@RequestBody Map<String, Object> mJson) {
        RequsetData<Integer> res = new RequsetData<>();
        try {

            List<String> ids=JsonMapper.jsonToObject(mJson.get("ids").toString(), new TypeReference<List<String>>() {
            });
            int id = partyTwoExtService.deleteGdwydqkList(ids);
            res.setItem(id);
            res.setMsg("删除成功！");
        } catch (Exception ex) {
            res.setMsg("删除失败：" + ex.getMessage());
            res.setSuccess(false);
        }

        return res;
    }
}
