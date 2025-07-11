package com.px.partybuild.controller;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.DjFundsincome;
import com.px.partybuild.model.DjFundsuseWithBLOBs;
import com.px.partybuild.model.ZzZzqkxx;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.service.FundsService;
import com.px.partybuild.service.PartyService;
import com.px.partybuild.service.UserService;
import com.px.partybuild.util.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 党组织经费
 *
 * @author H
 */
@RestController
@RequestMapping(value = "/api/funds")
public class FundsController {

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private PartyService partyService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    private UserService userService;

    @Autowired
    private WordUtil wordUtil;

    @Autowired
    private FundsService fundsService;


    @ResponseBody
    @GetMapping("/getFundsUseList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getFundsUseList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                          @RequestParam(required = false) String dzzmc,@RequestParam(required = false) String partyCode, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
                                                                          @RequestParam(required = false) Integer expendScope, @RequestParam(required = false) Integer expendType) {
        beginTime = dateUtils.strFormat_short(beginTime);
        endTime = dateUtils.strFormat_short(endTime);

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(fundsService.getFundsUseList(pageIndex, pageSize, dzzmc,partyCode, beginTime, endTime, expendScope, expendType));
        return result;
    }


    @ResponseBody
    @RequestMapping("/getFundsuseById")
    public RequsetData<DjFundsuseWithBLOBs> getFundsuseById(@RequestParam("id") String id, @RequestParam(required = false) String dzzdm) {
        RequsetData<DjFundsuseWithBLOBs> res = new RequsetData<>();
        HashMap<String, Object> extData = new HashMap<>();

        DjFundsuseWithBLOBs model = fundsService.getFundsuseById(id);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getFundsuseid()))) {
            UUID uuid = UUID.randomUUID();
            model = new DjFundsuseWithBLOBs();
            model.setFundsuseid(uuid.toString());
            model.setPartycode(dzzdm);
            model.setHandleuserid(userService.getLoginUser().getUserid());
            model.setHandleusername(userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());
        }

        if (!stringUtils.IsNullOrEmpty(model.getPartycode())) {
            ZzZzqkxx zzZzqkxx = partyService.getPartyByDm(model.getPartycode());
            if (zzZzqkxx != null && !stringUtils.IsNullOrEmpty(zzZzqkxx.getDzzdm())) {
                extData.put("partyName", zzZzqkxx.getDzzmc());
            }
        }

        res.setExtdata(extData);
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveFundsuse")
    public RequsetData<String> saveFundsuse(@RequestBody DjFundsuseWithBLOBs model) {
        RequsetData<String> res = new RequsetData<String>();

        int count = fundsService.saveFundsuse(model, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());
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
    @GetMapping("/deleteFundsuseById")
    public RequsetData<Integer> deleteFundsuseById(@RequestParam("id") String id) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = fundsService.deleteFundsuseById(id);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }


    /**
     * @Description //TODO 生成word文档
     * @date 2024-08
     * @Param [id]
     **/
    @RequestMapping(value = "/fundsuseCreateWord", method = RequestMethod.GET)
    public void createWord(HttpServletResponse response, @RequestParam("id") String id) {

        try {
            DjFundsuseWithBLOBs model = fundsService.getFundsuseById(id);

            String partyName = "";

            if (!stringUtils.IsNullOrEmpty(model.getPartycode())) {
                ZzZzqkxx zzZzqkxx = partyService.getPartyByDm(model.getPartycode());
                if (zzZzqkxx != null && !stringUtils.IsNullOrEmpty(zzZzqkxx.getDzzdm())) {
                    partyName = zzZzqkxx.getDzzmc();
                }
            }

            /** 用于组装word页面需要的数据 */
            Map<String, Object> dataMap = new HashMap<String, Object>();
            // 组装数据
            dataMap.put("year", String.valueOf(dateUtils.dateToLocalDate(model.getExpendtime()).getYear()));
            dataMap.put("month", dateUtils.dateToLocalDate(model.getExpendtime()).getMonthValue());
            dataMap.put("day", dateUtils.dateToLocalDate(model.getExpendtime()).getDayOfMonth());
            dataMap.put("dzzmc", partyName);
            dataMap.put("username", model.getHandleusername());
            dataMap.put("expendreason", stringUtils.IsNullOrEmpty(model.getExpendreason()) ? "" : model.getExpendreason().replace("\n", "<w:br/>"));
            dataMap.put("expenddetail", stringUtils.IsNullOrEmpty(model.getExpenddetail()) ? "" : model.getExpenddetail().replace("\n", "<w:br/>"));
            dataMap.put("expendmoney", model.getExpendmoney());


            /** 生成word */
            String fileName = "党组织工作费（管理费用）使用审批表";//文件名称
            wordUtil.createWord(response, dataMap, fileName, fileName);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    @ResponseBody
    @GetMapping("/getFundsUsageSummary")
    public RequsetData<PageInfo<HashMap<String, Object>>> getFundsUsageSummary(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                                @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(fundsService.getFundsUsageSummary(pageIndex, pageSize, dzzdm,null, year,false));
        return result;
    }

    @RequestMapping(value = "/exportFundsUsageSummary", method = RequestMethod.GET)
    public void exportFundsUsageSummary(HttpServletResponse response,
                                         @RequestParam(required = false) String dzzdm,
                                         @RequestParam(required = false) Integer year) throws Exception {


        /**查询数据**/
        List<HashMap<String, Object>> dataList = fundsService.getFundsUsageDetails(1, 100000, dzzdm, year).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党组织工作经费使用情况");
        List<Map<String, CellRangeAddress>> colspanTitles = new ArrayList();
        Map<String, CellRangeAddress> titles = new HashMap<>(5);
      /*  titles.put("序号", new CellRangeAddress(0, 1, 0, 0));
        titles.put("党组织名称", new CellRangeAddress(0, 1, 1, 1));
        titles.put("预算费用（元）", new CellRangeAddress(0, 0, 2, 4));
        titles.put("实际支出（元", new CellRangeAddress(0, 0, 5, 20));
*/
        titles.put("序号", new CellRangeAddress(0, 2, 0, 0));
        titles.put("党组织名称", new CellRangeAddress(0, 2, 1, 1));
        titles.put("预算费用（万元）", new CellRangeAddress(0, 1, 2, 4));
        titles.put("实际支出（万元)", new CellRangeAddress(0, 0, 5, 20));

        Map<String, CellRangeAddress> titles3 = new HashMap<>(5); 
        titles3.put("总支出", new CellRangeAddress(1, 2, 5, 5));
        titles3.put("活动经费", new CellRangeAddress(1, 1, 6, 14));
        titles3.put("奖励经费", new CellRangeAddress(1, 1, 15, 20));

        List<String> titles2 = new ArrayList();
        titles2.add("");
        titles2.add("");
        titles2.add("总预算");
        titles2.add("活动经费");
        titles2.add("奖励经费");
        titles2.add("");
        titles2.add("活动支出");
        titles2.add("学习教育活动");
        titles2.add("党内主题活动");
        titles2.add("宣传活动");
        titles2.add("会议活动");
        titles2.add("党建日常工作");
        titles2.add("走访慰问活动");
        titles2.add("设备设施");
        titles2.add("其他");
        titles2.add("奖励支出");
        titles2.add("综合考评奖励");
        titles2.add("七一表彰奖励");
        titles2.add("创岗建区表彰奖励");
        titles2.add("党建工作成果奖励");
        titles2.add("主题竞赛活动奖励");

        colspanTitles.add(titles);
        colspanTitles.add(titles3);
        data.setColspanTitles(colspanTitles);
        data.setTitles(titles2);
        //数据
        List<List<Object>> rows = new ArrayList();
        int index=0;
        for (HashMap<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(++index);
            row.add(item.get("DZZMC"));
            row.add(item.get("总预算"));
            row.add(item.get("活动经费"));
            row.add(item.get("奖励经费"));
            row.add(item.get("总支出"));
            row.add(item.get("活动支出")+"("+item.get("活动支出占比")+"%"+")");
            row.add(item.get("学习教育活动")+"("+item.get("学习教育活动占比")+"%"+")");
            row.add(item.get("党内主题活动")+"("+item.get("党内主题活动占比")+"%"+")");
            row.add(item.get("宣传活动")+"("+item.get("宣传活动占比")+"%"+")");
            row.add(item.get("会议活动")+"("+item.get("会议活动占比")+"%"+")");
            row.add(item.get("党建日常工作")+"("+item.get("党建日常工作占比")+"%"+")");
            row.add(item.get("走访慰问活动")+"("+item.get("走访慰问活动占比")+"%"+")");
            row.add(item.get("设备设施")+"("+item.get("设备设施占比")+"%"+")");
            row.add(item.get("其他")+"("+item.get("其他占比")+"%"+")");
            row.add(item.get("奖励支出")+"("+item.get("奖励支出占比")+"%"+")");
            row.add(item.get("综合考评奖励")+"("+item.get("综合考评奖励占比")+"%"+")");
            row.add(item.get("七一表彰奖励")+"("+item.get("七一表彰奖励占比")+"%"+")");
            row.add(item.get("创岗建区表彰奖励")+"("+item.get("创岗建区表彰奖励占比")+"%"+")");
            row.add(item.get("党建工作成果奖励")+"("+item.get("党建工作成果奖励占比")+"%"+")");
            row.add(item.get("主题竞赛活动奖励")+"("+item.get("主题竞赛活动奖励占比")+"%"+")");
            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党组织工作经费使用情况.xlsx", data);
    }

    @ResponseBody
    @GetMapping("/getPartyFundsUsage")
    public RequsetData<List<HashMap<String, Object>>> getPartyFundsUsage( @RequestParam(required = false) String partyCode, @RequestParam(required = false) Integer expendscope,@RequestParam(required = false) Integer year) {

        RequsetData<List<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(fundsService.getPartyFundsUsage( partyCode, expendscope,year));
        return result;
    }
}
