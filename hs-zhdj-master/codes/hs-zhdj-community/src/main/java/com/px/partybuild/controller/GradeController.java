package com.px.partybuild.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.ZzBzcyxx;
import com.px.partybuild.model.ZzBzjcxx;
import com.px.partybuild.model.ZzBzjcxxfb;
import com.px.partybuild.model.ZzZzqkxx;
import com.px.partybuild.service.GradeService;
import com.px.partybuild.service.PartyService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.ExcelHelper;
import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping(value = "/api/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private PartyService partyService;


    @ResponseBody
    @GetMapping("/getGradeList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getGradeList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String ldjtjc, @RequestParam(required = false) String dzzmc, @RequestParam(required = false) String xjfs,
                                                                       @RequestParam(required = false) String gjjmrq_begin, @RequestParam(required = false) String gjjmrq_end, @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) String ssdzzdm,
                                                                       @RequestParam(required = false) List<String> zzlb, @RequestParam(required = false) List<String> jczzfl, @RequestParam(required = false) Integer sfzdjc) {

        gjjmrq_begin = dateUtils.strFormat_short(gjjmrq_begin);
        gjjmrq_end = dateUtils.strFormat_short(gjjmrq_end);

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(gradeService.getGradeList(pageIndex, pageSize, dzzdm, ldjtjc, dzzmc, xjfs, gjjmrq_begin, gjjmrq_end, zzfbType, ssdzzdm, zzlb, jczzfl, sfzdjc));
        return result;
    }

    /**
     * @return void
     * @Description //TODO 导出班子届次
     * @date 2024-08
     * @Param [response, dzzdm, ldjtjc, dzzmc, xjfs, gjjmrq_begin, gjjmrq_end]
     **/
    @RequestMapping(value = "/exportGrade", method = RequestMethod.GET)
    public void exportGrade(HttpServletResponse response,
                            @RequestParam(required = false) String dzzdm,
                            @RequestParam(required = false) String ldjtjc, @RequestParam(required = false) String dzzmc, @RequestParam(required = false) String xjfs,
                            @RequestParam(required = false) String gjjmrq_begin, @RequestParam(required = false) String gjjmrq_end, @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) String ssdzzdm, @RequestParam(required = false) List<String> zzlb, @RequestParam(required = false) List<String> jczzfl,
                            @RequestParam(required = false) Integer sfzdjc) throws Exception {

        gjjmrq_begin = dateUtils.strFormat_short(gjjmrq_begin);
        gjjmrq_end = dateUtils.strFormat_short(gjjmrq_end);

        /**查询数据**/
        List<HashMap<String, Object>> dataList = gradeService.getGradeList(1, 100000, dzzdm, ldjtjc, dzzmc, xjfs, gjjmrq_begin, gjjmrq_end, zzfbType, ssdzzdm, zzlb, jczzfl, sfzdjc).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("班子届次信息");
        List<String> titles = new ArrayList();
        titles.add("领导集体届次");
        titles.add("党组织名称");
        titles.add("选举方式");
        titles.add("该届届满日期");
        titles.add("领导集体当选日期");
        titles.add("应到会人数");
        titles.add("实到会人数");
        titles.add("全委人数");
        titles.add("全委实到人数");
        titles.add("批准委员名额");
        titles.add("批准常委名额");
        titles.add("是否当届");
        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (HashMap<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("LDJTJC"));
            row.add(item.get("DZZMC"));
            row.add(item.get("XJFSMC"));
            row.add(item.get("GJJMRQ"));
            row.add(item.get("LDJTDXRQ"));
            row.add(item.get("YDHRS"));
            row.add(item.get("SDHRS"));
            row.add(item.get("QWRS"));
            row.add(item.get("QWSDRS"));
            row.add(item.get("PZWYME"));
            row.add(item.get("PZCWME"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "班子届次信息.xlsx", data);
    }


    @ResponseBody
    @GetMapping("/getGradeListByDzzdm")
    public List<ZzBzjcxx> getGradeListByDzzdm(@RequestParam("dzzdm") String dzzdm) {
        return gradeService.getGradeListByDzzdm(dzzdm);
    }


    @ResponseBody
    @RequestMapping("/getGradeById")
    public RequsetData<ZzBzjcxx> getGradeById(@RequestParam("id") String id, @RequestParam(required = false) String dzzdm) {
        RequsetData<ZzBzjcxx> res = new RequsetData<>();
        ZzBzjcxx model = gradeService.getGradeById(id);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getBzjcxxbs()))) {
            UUID uuid = UUID.randomUUID();
            model = new ZzBzjcxx();
            model.setBzjcxxbs(uuid.toString());
            model.setDzzdm(dzzdm);
        }
        model.setGjjmrq(dateUtils.strFormat_long(model.getGjjmrq()));
        model.setLdjtdxrq(dateUtils.strFormat_long(model.getLdjtdxrq()));

        ZzZzqkxx zzZzqkxx = new ZzZzqkxx();
        if (!stringUtils.IsNullOrEmpty(model.getDzzdm())) {
            zzZzqkxx = partyService.getPartyByDm(model.getDzzdm());
        }

        //副表信息
        ZzBzjcxxfb zzBzjcxxfb = gradeService.getGradeFbById(model.getBzjcxxbs());
        if (zzBzjcxxfb == null || (zzBzjcxxfb != null && stringUtils.IsNullOrEmpty(zzBzjcxxfb.getBzjcxxbs()))) {
            zzBzjcxxfb = new ZzBzjcxxfb();
            zzBzjcxxfb.setBzjcxxbs(model.getBzjcxxbs());
        }


        HashMap<String, Object> extData = new HashMap<String, Object>();
        extData.put("party", zzZzqkxx);

        extData.put("gradeFbModel", zzBzjcxxfb);

        res.setExtdata(extData);
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveGrade")
    public RequsetData<String> saveGrade(@RequestBody Map<String, Object> reqMap) {
       /* RequsetData<String> res = new RequsetData<String>();
        model.setGjjmrq(dateUtils.strFormat_short(model.getGjjmrq()));
        model.setLdjtdxrq(dateUtils.strFormat_short(model.getLdjtdxrq()));

        int count = gradeService.saveGrade(model);
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！");
        }
        return res;*/

        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            ZzBzjcxx model = mapper.readValue(mapper.writeValueAsString(reqMap.get("gradeModel")).toString(), ZzBzjcxx.class);
            ZzBzjcxxfb fbModel = mapper.readValue(mapper.writeValueAsString(reqMap.get("gradeFbModel")).toString(), ZzBzjcxxfb.class);

            model.setGjjmrq(dateUtils.strFormat_short(model.getGjjmrq()));
            model.setLdjtdxrq(dateUtils.strFormat_short(model.getLdjtdxrq()));

            count = gradeService.saveGrade(model, fbModel);

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
    @RequestMapping("/deleteGradeById")
    public RequsetData<String> deleteGradeById(@RequestParam("id") String id) {
        RequsetData<String> res = new RequsetData<>();
        int count = gradeService.deleteGradeById(id);
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
    @GetMapping("/getGradeUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getGradeUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam(required = false) String dzzdm,
                                                                           @RequestParam(required = false) String ldjtjc, @RequestParam(required = false) String dzzmc,
                                                                           @RequestParam(required = false) String xm, @RequestParam(required = false) List<String> zwmc, @RequestParam(required = false) String rzfs,
                                                                           @RequestParam(required = false) Integer onlyshow_dw, @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) String ssdzzdm, @RequestParam(required = false) String zzjzqk,
                                                                           @RequestParam(required = false) Integer isMaxJc) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(gradeService.getGradeUserList(pageIndex, pageSize, dzzdm, ldjtjc, dzzmc, xm, zwmc, rzfs, onlyshow_dw, zzfbType, ssdzzdm, zzjzqk, isMaxJc));
        return result;
    }

    @ResponseBody
    @GetMapping("/getMaxGradeUserList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getMaxGradeUserList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam(required = false) String dzzdm,
                                                                              @RequestParam(required = false) String ldjtjc, @RequestParam(required = false) String dzzmc,
                                                                              @RequestParam(required = false) String xm, @RequestParam(required = false) String zwmc, @RequestParam(required = false) String rzfs,
                                                                              @RequestParam(required = false) Integer onlyshow_dw, @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) String ssdzzdm
            , @RequestParam(required = false) String rybm) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(gradeService.getMaxGradeUserList(pageIndex, pageSize, dzzdm, ldjtjc, dzzmc, xm, zwmc, rzfs, onlyshow_dw, zzfbType, ssdzzdm, rybm));
        return result;
    }

    /**
     * @return void
     * @Description //TODO 导出班子届次成员
     * @date 2024-08
     * @Param [response, dzzdm, ldjtjc, dzzmc, xm, zwmc, rzfs]
     **/
    @RequestMapping(value = "/exportGradeUser", method = RequestMethod.GET)
    public void exportGradeUser(HttpServletResponse response,
                                @RequestParam(required = false) String dzzdm,
                                @RequestParam(required = false) String ldjtjc, @RequestParam(required = false) String dzzmc,
                                @RequestParam(required = false) String xm, @RequestParam(required = false) List<String> zwmc, @RequestParam(required = false) String rzfs,
                                @RequestParam(required = false) Integer onlyshow_dw, @RequestParam(required = false) Integer zzfbType, @RequestParam(required = false) String ssdzzdm, @RequestParam(required = false) String zzjzqk, @RequestParam(required = false) Integer isMaxJc) throws Exception {

        /**查询数据**/
        List<HashMap<String, Object>> dataList = gradeService.getGradeUserList(1, 100000, dzzdm, ldjtjc, dzzmc, xm, zwmc, rzfs, onlyshow_dw, zzfbType, ssdzzdm, zzjzqk, isMaxJc).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党组织委员信息");
        List<String> titles = new ArrayList();
        titles.add("人员编码");
        titles.add("姓名");
        titles.add("届次");
        titles.add("换届时间");
        titles.add("任职党组织");
        titles.add("党内职务");
        titles.add("任职方式");
        titles.add("专职或兼职情况");
        titles.add("职务说明");
        titles.add("该职务级别");
        titles.add("批准任职日期");
        titles.add("批准免职日期");
        titles.add("委员得票");
        titles.add("常委得票");
        titles.add("书记得票");
        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (HashMap<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("RYBM"));
            row.add(item.get("XM"));
            row.add((item.get("ZZLB") != null && (item.get("ZZLB").toString().equals("100") || item.get("ZZLB").toString().equals("200"))) ? item.get("JC") : "");
            row.add(item.get("LDJTDXRQ"));
            row.add(item.get("DZZMC"));
            row.add(item.get("ZWMCMC"));
            row.add(item.get("RZFSMC"));
            row.add(item.get("ZZJZQKMC"));
            row.add(item.get("ZWSM"));
            row.add(item.get("ZWJBMC"));
            row.add(item.get("PZRZRQ"));
            row.add(item.get("PZMZRQ"));
            row.add(item.get("DP_WY"));
            row.add(item.get("DP_CW"));
            row.add(item.get("DP_SJ"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党组织委员信息.xlsx", data);
    }

    @ResponseBody
    @RequestMapping("/getGradeUserByID")
    public RequsetData<ZzBzcyxx> getGradeUserById(@RequestParam("id") String id, @RequestParam(required = false) String dzzdm) {
        RequsetData<ZzBzcyxx> res = new RequsetData<>();
        ZzBzcyxx model = gradeService.getGradeUserById(id);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getBzcyxxbs()))) {
            UUID uuid = UUID.randomUUID();
            model = new ZzBzcyxx();
            model.setBzcyxxbs(uuid.toString());
            model.setDzzdm(dzzdm);
        }
        model.setPzmzrq(dateUtils.strFormat_long(model.getPzmzrq()));
        model.setPzrzrq(dateUtils.strFormat_long(model.getPzrzrq()));

        ZzZzqkxx zzZzqkxx = new ZzZzqkxx();
        if (!stringUtils.IsNullOrEmpty(model.getDzzdm())) {
            zzZzqkxx = partyService.getPartyByDm(model.getDzzdm());
        }

        HashMap<String, Object> extData = new HashMap<String, Object>();
        extData.put("party", zzZzqkxx);

        res.setExtdata(extData);
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveGradeUser")
    public RequsetData<String> saveGradeUser(@RequestBody ZzBzcyxx model) {
        RequsetData<String> res = new RequsetData<String>();
        model.setPzmzrq(dateUtils.strFormat_short(model.getPzmzrq()));
        model.setPzrzrq(dateUtils.strFormat_short(model.getPzrzrq()));

        int count = gradeService.saveGradeUser(model);
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
    @RequestMapping("/deleteGradeUserById")
    public RequsetData<String> deleteGradeUserById(@RequestParam("id") String id) {
        RequsetData<String> res = new RequsetData<>();
        int count = gradeService.deleteGradeUserById(id);
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
    @GetMapping("/updateSchjsj")
    public int updateSchjsj() {
        return gradeService.updatePartySchjsj();
    }
}
