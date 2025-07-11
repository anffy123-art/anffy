package com.px.partybuild.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.ZzDxzcy;
import com.px.partybuild.model.ZzDzzzly;
import com.px.partybuild.model.ZzZzqkxx;
import com.px.partybuild.model.ZzZzqkxxfb;
import com.px.partybuild.service.PartyService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.ExcelHelper;
import com.px.partybuild.util.JsonMapper;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.vo.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 党组织信息
 *
 * @author H
 */
@RestController
@RequestMapping(value = "/api/party")
public class PartyController {

    @Autowired
    PartyService partyService;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private DateUtils dateUtils;

    @ResponseBody
    @GetMapping("/getPartyTreeList")
    public RequsetData<List<HashMap<String, Object>>> getPartyTreeList(@RequestParam("parentCode") String parentCode,  @RequestParam(required = false) String dzzdm,@RequestParam(required = false) Integer showlevel) {
        List<HashMap<String, Object>> partyList = partyService.getPartyTreeList(parentCode, dzzdm, showlevel);
        RequsetData<List<HashMap<String, Object>>> res = new RequsetData<>();
        res.setItem(partyList);
        return res;
    }

    @ResponseBody
    @GetMapping("/getPartyList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getPartyList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam(required = false) String parentcode,
                                                                       @RequestParam(required = false) String dzzmc, @RequestParam(required = false) String dzzdm,
                                                                       @RequestParam(required = false) String zzlb, @RequestParam(required = false) String jczzfl, @RequestParam(required = false) String jldzzrq_begin,
                                                                       @RequestParam(required = false) String jldzzrq_end, @RequestParam(required = false) String isContainParent, @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) Integer hjYear,
                                                                       @RequestParam(required = false) String zzlbList, @RequestParam(required = false) String ssdzzdm, @RequestParam(required = false) Integer dwjb
            , @RequestParam(required = false) String jmrq_begintime, @RequestParam(required = false) String jmrq_endtime,@RequestParam(required = false) String partyGroupId,@RequestParam(required = false)String notIncludeDzzdmStr) {

        jldzzrq_begin = dateUtils.strFormat_short(jldzzrq_begin);
        jldzzrq_end = dateUtils.strFormat_short(jldzzrq_end);

        jmrq_begintime = dateUtils.strFormat_short(jmrq_begintime);
        jmrq_endtime = dateUtils.strFormat_short(jmrq_endtime);

        List<String> zzlbStrList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(zzlbList)) {
            zzlbStrList = Arrays.asList(zzlbList.split(","));
        }
        List<String> notIncludeDzzdmList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(notIncludeDzzdmStr)) {
            notIncludeDzzdmList = Arrays.asList(notIncludeDzzdmStr.split(","));
        }
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyService.getPartyList(pageIndex, pageSize, parentcode, dzzmc, dzzdm, zzlb, jczzfl, jldzzrq_begin, jldzzrq_end, isContainParent, zzfbType, hjYear, zzlbStrList, ssdzzdm, dwjb,jmrq_begintime,jmrq_endtime,null,partyGroupId,notIncludeDzzdmList));
        return result;
    }

    @RequestMapping(value = "/exportParty", method = RequestMethod.GET)
    public void exportParty(HttpServletResponse response,
                            @RequestParam(required = false) String parentcode,
                            @RequestParam(required = false) String dzzmc, @RequestParam(required = false) String dzzdm,
                            @RequestParam(required = false) String zzlb, @RequestParam(required = false) String jczzfl, @RequestParam(required = false) String jldzzrq_begin,
                            @RequestParam(required = false) String jldzzrq_end, @RequestParam(required = false) String isContainParent, @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) Integer sfhj, @RequestParam(required = false) String zzlbList
            , @RequestParam(required = false) String ssdzzdm, @RequestParam(required = false) Integer dwjb, @RequestParam(required = false) String jmrq_begintime, @RequestParam(required = false) String jmrq_endtime,@RequestParam(required = false) String partyGroupId) throws Exception {

        jldzzrq_begin = dateUtils.strFormat_short(jldzzrq_begin);
        jldzzrq_end = dateUtils.strFormat_short(jldzzrq_end);

        jmrq_begintime = dateUtils.strFormat_short(jmrq_begintime);
        jmrq_endtime = dateUtils.strFormat_short(jmrq_endtime);

        List<String> zzlbStrList = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(zzlbList)) {
            zzlbStrList = Arrays.asList(zzlbList.split(","));
        }

        /**查询数据**/
        List<HashMap<String, Object>> dataList = partyService.getPartyList(1, 1000000, parentcode, dzzmc, dzzdm, zzlb, jczzfl, jldzzrq_begin, jldzzrq_end, isContainParent, zzfbType, sfhj, zzlbStrList, ssdzzdm, dwjb,jmrq_begintime,jmrq_endtime,null,partyGroupId,null).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党组织架构信息");
        List<String> titles = new ArrayList();
        titles.add("党组织名称");
        titles.add("党组织代码");
        titles.add("组织类别");
        titles.add("基层组织分类");
        titles.add("建立党组织日期");
        titles.add("开展评议日期");
        titles.add("结束评议日期");
        titles.add("“三乘一体”党支部标识");
        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (HashMap<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("DZZMC"));
            row.add(item.get("DZZDM"));
            row.add(item.get("ZZLBMC"));
            row.add(item.get("JCZZFLMC"));
            row.add(item.get("JLDZZRQ"));
            row.add(item.get("KZPYRQ"));
            row.add(item.get("JSPYRQ"));
            row.add(item.get("SCYTDZB"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党组织架构信息.xlsx", data);
    }


    @ResponseBody
    @RequestMapping("/getPartyById")
    public RequsetData<ZzZzqkxx> getPartyById(@RequestParam("id") String id, @RequestParam(required = false) String parent_dzzdm, @RequestParam(required = false) String dzzdm) {
        RequsetData<ZzZzqkxx> res = new RequsetData<>();
        ZzZzqkxx model = partyService.getPartyById(id);

        if (!stringUtils.IsNullOrEmpty(dzzdm)) {
            model = partyService.getPartyByDm(dzzdm);
        }

        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getZzqkxxbs()))) {
            UUID uuid = UUID.randomUUID();
            model = new ZzZzqkxx();
            model.setZzqkxxbs(uuid.toString());
        } else {
            if (!stringUtils.IsNullOrEmpty(model.getDzzdm())) {
                parent_dzzdm = model.getDzzdm().substring(0, model.getDzzdm().length() - 3);
            }
        }

        model.setJldzzrq(dateUtils.strFormat_long(model.getJldzzrq()));
        model.setKzpyrq(dateUtils.strFormat_long(model.getKzpyrq()));
        model.setJspyrq(dateUtils.strFormat_long(model.getJspyrq()));


        ZzZzqkxx parentDZZ = new ZzZzqkxx();
        if (!stringUtils.IsNullOrEmpty(parent_dzzdm)) {
            parentDZZ = partyService.getPartyByDm(parent_dzzdm);
        }

        //副表信息
        ZzZzqkxxfb zzZzqkxxfb = partyService.getPartyFbById(model.getDzzdm());
        if (zzZzqkxxfb == null || (zzZzqkxxfb != null && stringUtils.IsNullOrEmpty(zzZzqkxxfb.getDzzdm()))) {
            zzZzqkxxfb = new ZzZzqkxxfb();
            //zzZzqkxxfb.setZzlb("400"); //默认党支部
        }

        HashMap<String, Object> extData = new HashMap<String, Object>();
        extData.put("parentParty", parentDZZ);
        extData.put("partyFBModel", zzZzqkxxfb);

        res.setExtdata(extData);
        res.setItem(model);
        return res;
    }

    @GetMapping("/getByDzzdm")
    public RequsetData<ZzZzqkxx> getByDzzdm(@RequestParam("dzzdm") String dzzdm) {
        RequsetData<ZzZzqkxx> res = new RequsetData<>();
        ZzZzqkxx zzZzqkxx = this.partyService.getPartyByDm(dzzdm);
        res.setItem(zzZzqkxx);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveParty")
    public RequsetData<String> saveParty(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            String parentDzzdm = reqMap.get("parentDzzdm").toString();
            String dzzdm_short = reqMap.get("dzzdm_short").toString();

            ZzZzqkxx model = mapper.readValue(mapper.writeValueAsString(reqMap.get("partyModel")).toString(), ZzZzqkxx.class);
            ZzZzqkxxfb fbModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("partyFBModel")).toString(), ZzZzqkxxfb.class);
            List<ZzDzzzly> zlyUserList = JsonMapper.jsonToObject(reqMap.get("zlyUserList").toString(), new TypeReference<List<ZzDzzzly>>() {
            });

            model.setDzzdm(parentDzzdm + dzzdm_short);
            model.setJldzzrq(dateUtils.strFormat_short(model.getJldzzrq()));
            model.setKzpyrq(dateUtils.strFormat_short(model.getKzpyrq()));
            model.setJspyrq(dateUtils.strFormat_short(model.getJspyrq()));

            fbModel.setDzzdm(model.getDzzdm());

            count = partyService.saveParty(model, fbModel, zlyUserList);

        } catch (Exception e) {

            e.printStackTrace();
            message = e.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！" + message);
        }
        return res;
    }

    @ResponseBody
    @RequestMapping("/deletePartyById")
    public RequsetData<String> deletePartyById(@RequestParam("id") String id) {
        RequsetData<String> res = new RequsetData<>();
        int count = partyService.deletePartyById(id);
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("删除成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("删除失败！");
        }
        return res;
    }


    @ResponseBody
    @RequestMapping("/savePartyDXZ")
    public RequsetData<String> savePartyDxz(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            ZzZzqkxx zzZzqkxx = mapper.readValue(mapper.writeValueAsString(reqMap.get("party")).toString(), ZzZzqkxx.class);
            List<DXZUSER> userList = JsonMapper.jsonToObject(reqMap.get("userList").toString(), new TypeReference<List<DXZUSER>>() {
            });

            //验证编码
            ZzZzqkxx dzz = partyService.getPartyByDm(zzZzqkxx.getDzzdm());
            if (dzz != null && !stringUtils.IsNullOrEmpty(dzz.getZzqkxxbs()) && !dzz.getZzqkxxbs().equals(zzZzqkxx.getZzqkxxbs())) {
                throw new Exception("党小组编号重复！");
            }

            List<ZzDxzcy> zzDxzcies = new ArrayList<>();
            if (userList.size() > 0) {
                for (DXZUSER dxzuser : userList) {
                    ZzDxzcy zzDxzcy = new ZzDxzcy();
                    zzDxzcy.setDxzcybs(UUID.randomUUID().toString().substring(0, 12));
                    zzDxzcy.setDzzdm(zzZzqkxx.getDzzdm());
                    zzDxzcy.setRybm(dxzuser.getRybm());
                    zzDxzcies.add(zzDxzcy);
                }
            }

            count = partyService.savepartydxz(zzZzqkxx, zzDxzcies);

        } catch (Exception e) {

            e.printStackTrace();
            message = e.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！" + message);
        }
        return res;
    }

    @RequestMapping(value = "/exportPartyDXZ", method = RequestMethod.GET)
    public void exportPartyDxz(HttpServletResponse response,
                               @RequestParam(required = false) String parentcode,
                               @RequestParam(required = false) String dzzmc, @RequestParam(required = false) String dzzdm,
                               @RequestParam(required = false) String zzlb, @RequestParam(required = false) String jczzfl, @RequestParam(required = false) String jldzzrq_begin,
                               @RequestParam(required = false) String jldzzrq_end, @RequestParam(required = false) String isContainParent
            , @RequestParam(required = false) String ssdzzdm,@RequestParam(required = false) String partyGroupId) throws Exception {

        jldzzrq_begin = dateUtils.strFormat_short(jldzzrq_begin);
        jldzzrq_end = dateUtils.strFormat_short(jldzzrq_end);

        /**查询数据**/
        List<HashMap<String, Object>> dataList = partyService.getPartyList(1, 1000000, parentcode, dzzmc, dzzdm, zzlb, jczzfl, jldzzrq_begin, jldzzrq_end, isContainParent, null, null, null, ssdzzdm, null,null,null,null,partyGroupId,null).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党小组信息");
        List<String> titles = new ArrayList();
        titles.add("党小组名称");
        titles.add("党小组代码");
        titles.add("党小组成员数量");
        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (HashMap<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("DZZMC"));
            row.add(item.get("DZZDM"));
            row.add(item.get("DXZCYSL"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党小组信息.xlsx", data);
    }


    @ResponseBody
    @RequestMapping("/isPartyZB")
    public int isPartyZb(@RequestParam("dzzdm") String dzzdm) {
        return partyService.isPartyZb(dzzdm);
    }

    @ResponseBody
    @RequestMapping("/getPartyGroupTreeList")
    public List<HashMap<String, Object>> getPartyGroupTreeList(@RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer onlyshow_dw) {
        return partyService.getPartyGroupTreeList(dzzdm, onlyshow_dw);
    }

    @ResponseBody
    @RequestMapping("/getPartyZLYList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getPartyZlyList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam("dzzdm") String dzzdm) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyService.getPartyZlyList(pageIndex, pageSize, dzzdm));
        return result;
    }

    @ResponseBody
    @RequestMapping("/getChildPartyCount")
    public List<HashMap<String, Object>> getChildPartyCount(@RequestParam("dzzdm") String dzzdm, @RequestParam(required = false) String ssdzzdm) {
        return partyService.getChildPartyCount(dzzdm, ssdzzdm);
    }

    @ResponseBody
    @GetMapping("/getNewPartyTreeList")
    public RequsetData<List<HashMap<String, Object>>> getNewPartyTreeList(@RequestParam("parentCode") String parentCode, @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String userId,
                                                                          @RequestParam(required = false) Integer onlyshow_dw,
                                                                          @RequestParam(required = false) Integer showdxz) {
        List<HashMap<String, Object>> partyList = partyService.getNewPartyTreeList(parentCode, dzzdm, userId, onlyshow_dw, showdxz);
        RequsetData<List<HashMap<String, Object>>> res = new RequsetData<>();
        res.setItem(partyList);
        return res;
    }

    @ResponseBody
    @GetMapping("/getTree")
    public RequsetData<List<TreeVo>> getTree(String parentId) {
        RequsetData<List<TreeVo>> result = new RequsetData<>();
        result.setItem(partyService.getPartyTree(parentId));
        return result;
    }
    @ResponseBody
    @GetMapping("/getChildParty")
    public RequsetData<List<TreeVo>> getChildParty(String parentId) {
        RequsetData<List<TreeVo>> result = new RequsetData<>();
        result.setItem(partyService.getChildParty(parentId));
        return result;
    }
}

class DXZUSER {
    public DXZUSER() {
    }

    private String ryjbxxbs;
    private String rybm;

    public String getRyjbxxbs() {
        return ryjbxxbs;
    }

    public void setRyjbxxbs(String ryjbxxbs) {
        this.ryjbxxbs = ryjbxxbs;
    }

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm;
    }
}
