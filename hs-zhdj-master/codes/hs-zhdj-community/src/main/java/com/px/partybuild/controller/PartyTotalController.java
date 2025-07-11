package com.px.partybuild.controller;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.AppConfig;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.ZzZzqkxx;
import com.px.partybuild.service.PartyService;
import com.px.partybuild.service.PartyTotalService;
import com.px.partybuild.util.ExcelHelper;
import com.px.partybuild.util.WordUtil;
import com.px.partybuild.util.excel.CellItem;
import com.px.partybuild.util.excel.ListItem;
import com.px.partybuild.util.excel.PageItem;
import com.px.partybuild.vo.PartyduesAlreadyPayDetailVo;
import com.px.partybuild.vo.PartyduesDidnotPayDetailVo;
import com.px.partybuild.vo.PartyduesTotalByYearVo;
import com.px.partybuild.vo.PartyduesTotalVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 党组织统计
 *
 * @author H
 */
@RestController
@RequestMapping(value = "/api/partyTotal")
@Slf4j
public class PartyTotalController {

    @Autowired
    private PartyTotalService partyTotalService;

    @Autowired
    private WordUtil wordUtil;

    @Autowired
    private PartyService partyService;

    @Autowired
    private AppConfig appConfig;

    @ResponseBody
    @GetMapping("/getPartyTotalList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getPartyTotalList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                            @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyTotalService.getPartyTotalList(pageIndex, pageSize, dzzdm, year));
        return result;
    }


    @ResponseBody
    @GetMapping("/getPartyDetailList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getPartyDetailList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                             @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyTotalService.getPartyDetailList(pageIndex, pageSize, dzzdm, year, null));
        return result;
    }

    @ResponseBody
    @GetMapping("/getUserTotalList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getUserTotalList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                           @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyTotalService.getUserTotalList(pageIndex, pageSize, dzzdm, year, null));
        return result;
    }

    @RequestMapping(value = "/exportUserTotal", method = RequestMethod.GET)
    public void exportUserTotal(HttpServletResponse response,
                                @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year) throws Exception {


        /**查询数据**/
        List<HashMap<String, Object>> dataList = partyTotalService.getUserTotalList(1, 100000, dzzdm, year, null).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党员情况统计信息");
        List<String> titles = new ArrayList();

        titles.add("组织名称");
        titles.add("职工数");
        titles.add("党员数");
        titles.add("在岗党员数");
        titles.add("离退休党员数");
        titles.add("申请入党数");
        titles.add("积极分子数");
        titles.add("发展对象数");
        titles.add("预备党员数");
        titles.add("困难党员数");

        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (HashMap<String, Object> item : dataList) {
            List<Object> row = new ArrayList();

            row.add(item.get("DZZMC"));
            row.add(item.get("ZGRS"));
            row.add(item.get("USERCOUNT"));
            row.add(item.get("NUM_ZGUSER"));
            row.add(item.get("NUM_LTX"));
            row.add(item.get("NUM_SQRD"));
            row.add(item.get("NUM_JJFZ"));
            row.add(item.get("NUM_FZDX"));
            row.add(item.get("NUM_YBDY"));
            row.add(item.get("NUM_KN"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党员情况统计信息.xlsx", data);
    }


    @ResponseBody
    @GetMapping("/getZxzxxFaTotalList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getZxzxxFaTotalList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                              @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year, @RequestParam(required = false) String ssdzzdm) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyTotalService.getZxzxxFaTotalList(pageIndex, pageSize, dzzdm, year, ssdzzdm));
        return result;
    }

    @ResponseBody
    @GetMapping("/getZxzxxCqlDetailList")
    public RequsetData<List<HashMap<String, Object>>> getZxzxxCqlDetailList(@RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year) {
        RequsetData<List<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyTotalService.getZxzxxCqlDetailList(dzzdm, year));
        return result;
    }


    @ResponseBody
    @GetMapping("/getZxzxxUserStudyList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getZxzxxUserStudyList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                                @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyTotalService.getZxzxxUserStudyList(pageIndex, pageSize, dzzdm, year));
        return result;
    }


    /*@ResponseBody
    @GetMapping("/getPartyduesTotalList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getPartyduesTotalList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                                @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyTotalService.getPartyduesTotalList(pageIndex, pageSize, dzzdm, year, month, null));
        return result;
    }*/

    @ResponseBody
    @GetMapping("/getPartyduesTotalList")
    public RequsetData<PageInfo<PartyduesTotalVo>> getPartyduesTotalList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                         @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month) {
        RequsetData<PageInfo<PartyduesTotalVo>> result = new RequsetData<>();
        result.setItem(partyTotalService.getPartyduesTotalListV2(pageIndex, pageSize, dzzdm, null, year, month));
        return result;
    }

    @RequestMapping(value = "/exportPartyduesUser", method = RequestMethod.GET)
    public void exportPartyduesUser(HttpServletRequest request, HttpServletResponse response, @RequestParam("dzzdm") String dzzdm, @RequestParam("year") Integer year, @RequestParam("month") Integer month) {
        try {
            ZzZzqkxx model = partyService.getPartyByDm(dzzdm);
            PartyduesTotalVo totalData = partyTotalService.getPartyduesTotalListV2(1, 1, null, dzzdm, year, month).getList().stream().findFirst().orElse(null);
            /*List<HashMap<String, Object>> alreadyPayUserList = partyTotalService.getPartyduesUserList2(dzzdm, year, month);
            List<HashMap<String, Object>> notPayUserList = partyTotalService.getNotPartyduesUserList(dzzdm, year, month);*/
            List<PartyduesAlreadyPayDetailVo> alreadyPayUserList = partyTotalService.getAlreadyPayUserList(dzzdm, year, month);
            List<PartyduesDidnotPayDetailVo> notPayUserList = partyTotalService.getDidnotPayUserList(dzzdm, year, month);

            String title = "党总支（支部）" + year + "年" + month + "月党费交纳名单";

            ExcelHelper excelHelper = new ExcelHelper();
            InputStream input = new FileInputStream(new File(appConfig.staticLocations.replace("file:", "") + "doc/template/党费交纳名单导出模板.xlsx"));
            List<PageItem> pageList = new ArrayList<>();
            PageItem page = new PageItem();
            List<CellItem> cellItems = new ArrayList<>();
            List<ListItem> listItem = new ArrayList<>();
            cellItems.add(new CellItem(1, 0, model.getDzzmc()));
            cellItems.add(new CellItem(1, 3, "交" + year.toString() + "年" + month.toString() + "月份党费"));
            cellItems.add(new CellItem(2, 1, totalData.userCount.toString()));
            cellItems.add(new CellItem(2, 3, totalData.alreadyPayUserCount.toString()));
            cellItems.add(new CellItem(2, 5, totalData.didnotPayUserCount.toString()));
            cellItems.add(new CellItem(3, 2, totalData.alreadyPayAmount.stripTrailingZeros().toPlainString()));
            cellItems.add(new CellItem(3, 5, totalData.didnotPayAmount.stripTrailingZeros().toPlainString()));

            ListItem item = new ListItem();
            item.setStartRow(6);
            item.setStartColumn(0);
            item.setEndColumn(5);

            int rows = alreadyPayUserList.size() > notPayUserList.size() ? alreadyPayUserList.size() : notPayUserList.size();

            String[][] itemValues = new String[rows][];

            for (int i = 0; i < rows; i++) {
                PartyduesAlreadyPayDetailVo alreadyPayUser = alreadyPayUserList.size() > i ? alreadyPayUserList.get(i) : null;
                PartyduesDidnotPayDetailVo notPayUser = notPayUserList.size() > i ? notPayUserList.get(i) : null;
                String[] values = new String[6];

                if (alreadyPayUser != null) {
                    values[0] = alreadyPayUser.userName;
                    values[1] = alreadyPayUser.payAmount.stripTrailingZeros().toPlainString();
                }

                if (notPayUser != null) {
                    values[3] = notPayUser.userName;
                    values[4] = notPayUser.didNotPayAmount.stripTrailingZeros().toPlainString();
                }

                itemValues[i] = values;
            }

            item.setValues(itemValues);

            listItem.add(item);

            page.setCellItemList(cellItems);
            page.setListItem(listItem);
            pageList.add(page);

            excelHelper.exportExcelToTemp(response, input, pageList, title + ".xlsx", null, null);

        } catch (Exception e) {
            log.error("exportPartyduesUser,Exception was: " + e.toString() + ",message was: " + e.getMessage());
            e.printStackTrace();

        }
    }


    @RequestMapping(value = "/exportPartyduesTotal", method = RequestMethod.GET)
    public void exportPartyduesTotal(HttpServletRequest request, HttpServletResponse response, @RequestParam("dzzdm") String dzzdm, @RequestParam("year") Integer year, @RequestParam("month") Integer month) {
        try {

            ZzZzqkxx model = partyService.getPartyByDm(dzzdm);

            /*List<HashMap<String, Object>> dataList = partyTotalService.getPartyduesTotalList(1, 10000, dzzdm, year, month, null).getList();*/

            List<PartyduesTotalVo> dataList = partyTotalService.getPartyduesTotalListV2(1, 1000, dzzdm, null, year, month).getList();

            String title = "党支部（" + year.toString() + "年" + month.toString() + "月份）党费收缴报告单";

            ExcelHelper excelHelper = new ExcelHelper();
            InputStream input = new FileInputStream(new File(appConfig.staticLocations.replace("file:", "") + "doc/template/党费交纳报告单导出模板.xlsx"));
            List<PageItem> pageList = new ArrayList<>();
            PageItem page = new PageItem();
            List<CellItem> cellItems = new ArrayList<>();
            List<ListItem> listItem = new ArrayList<>();
            cellItems.add(new CellItem(0, 0, title));

            ListItem item = new ListItem();
            item.setStartRow(3);
            item.setStartColumn(0);
            item.setEndColumn(7);
            String[][] itemValues = new String[dataList.size()][];

            for (int i = 0; i < dataList.size(); i++) {
                PartyduesTotalVo data = dataList.get(i);
                String[] values = new String[8];
                values[0] = new Integer(i + 1).toString();
                values[1] = data.partyName;
                values[2] = data.userCount.toString();
                values[3] = data.alreadyPayUserCount.toString();
                values[4] = data.didnotPayUserCount.toString();
                values[5] = data.alreadyPayAmount.stripTrailingZeros().toPlainString();
                values[6] = data.didnotPayAmount.stripTrailingZeros().toPlainString();
                values[7] = data.alreadyPayAmount.add(data.didnotPayAmount).stripTrailingZeros().toPlainString();

                itemValues[i] = values;
            }

            item.setValues(itemValues);

            listItem.add(item);

            page.setCellItemList(cellItems);
            page.setListItem(listItem);
            pageList.add(page);

            excelHelper.exportExcelToTemp(response, input, pageList, title + ".xlsx", null, null);

        } catch (Exception e) {
            log.error("exportPartyduesTotal,Exception was: " + e.toString() + ",message was: " + e.getMessage());
            e.printStackTrace();

        }
    }


    @ResponseBody
    @GetMapping("/getPartyduesMonthTotalList")
    public RequsetData<List<PartyduesTotalByYearVo>> getPartyduesMonthTotalList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                                @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year) {
        RequsetData<List<PartyduesTotalByYearVo>> result = new RequsetData<>();
        result.setItem(partyTotalService.getPartyduesMonthTotalList(pageIndex, pageSize, year, dzzdm));
        return result;
    }


    @ResponseBody
    @GetMapping("/getPartyduesQuarterTotalList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getPartyduesQuarterTotalList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                                       @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer year, @RequestParam(required = false) String ssdzzdm) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyTotalService.getPartyduesQuarterTotalList(pageIndex, pageSize, year, dzzdm, ssdzzdm));
        return result;
    }


    @RequestMapping(value = "/exportPartyduesMonthTotal", method = RequestMethod.GET)
    public void exportPartyduesMonthTotal(HttpServletRequest request, HttpServletResponse response, @RequestParam("dzzdm") String dzzdm, @RequestParam("year") Integer year) {
        try {

            /* *//**查询数据**//*
            List<PartyduesTotalByYearVo> dataList = partyTotalService.getPartyduesMonthTotalList(1, 1000, year, dzzdm).getList();
            List<HashMap<String, Object>> totalList = partyTotalService.getPartyduesQuarterTotalList(1, 1, year, dzzdm, dzzdm).getList();

            ExcelHelper excelHelper = new ExcelHelper();
            ExcelHelper.ExcelData data = excelHelper.new ExcelData();
            XSSFWorkbook wb = new XSSFWorkbook();
            List<CellRangeAddress> cellRangeList = new ArrayList<>();
            List<List<XSSFCellStyle>> cellStyles = new ArrayList();

            //列名
            data.setName("单位党费收缴登记本");
            List<String> titles = new ArrayList();
            titles.add("组织名称");
            titles.add("年度");
            titles.add("1月");
            titles.add("2月");
            titles.add("3月");
            titles.add("4月");
            titles.add("5月");
            titles.add("6月");
            titles.add("7月");
            titles.add("8月");
            titles.add("9月");
            titles.add("10月");
            titles.add("11月");
            titles.add("12月");
            titles.add("合计");
            data.setTitles(titles);

            //数据
            List<List<Object>> rows = new ArrayList();
            for (HashMap<String, Object> item : dataList) {
                List<Object> row = new ArrayList();
                row.add(item.get("DZZMC"));
                row.add(item.get("year"));
                row.add(item.get("month1"));
                row.add(item.get("month2"));
                row.add(item.get("month3"));
                row.add(item.get("month4"));
                row.add(item.get("month5"));
                row.add(item.get("month6"));
                row.add(item.get("month7"));
                row.add(item.get("month8"));
                row.add(item.get("month9"));
                row.add(item.get("month10"));
                row.add(item.get("month11"));
                row.add(item.get("month12"));
                row.add(item.get("total"));
                rows.add(row);

                cellStyles.add(new ArrayList());
            }

            if (totalList.size() > 0) {
                List<Object> totalRow = new ArrayList();
                totalRow.add("季度合计");
                totalRow.add("");
                totalRow.add(totalList.get(0).get("quarter1"));
                totalRow.add("");
                totalRow.add("");
                totalRow.add(totalList.get(0).get("quarter2"));
                totalRow.add("");
                totalRow.add("");
                totalRow.add(totalList.get(0).get("quarter3"));
                totalRow.add("");
                totalRow.add("");
                totalRow.add(totalList.get(0).get("quarter4"));
                totalRow.add("");
                totalRow.add("");
                totalRow.add(totalList.get(0).get("total"));
                rows.add(totalRow);

                Double upQuarter1 = Math.ceil(new BigDecimal(totalList.get(0).get("quarter1").toString()).divide(new BigDecimal(2)).doubleValue());
                Double upQuarter2 = Math.ceil(new BigDecimal(totalList.get(0).get("quarter2").toString()).divide(new BigDecimal(2)).doubleValue());
                Double upQuarter3 = Math.ceil(new BigDecimal(totalList.get(0).get("quarter3").toString()).divide(new BigDecimal(2)).doubleValue());
                Double upQuarter4 = Math.ceil(new BigDecimal(totalList.get(0).get("quarter4").toString()).divide(new BigDecimal(2)).doubleValue());

                totalRow = new ArrayList();
                totalRow.add("上缴学院");
                totalRow.add("");
                totalRow.add(upQuarter1);
                totalRow.add("");
                totalRow.add("");
                totalRow.add(upQuarter2);
                totalRow.add("");
                totalRow.add("");
                totalRow.add(upQuarter3);
                totalRow.add("");
                totalRow.add("");
                totalRow.add(upQuarter4);
                totalRow.add("");
                totalRow.add("");
                totalRow.add(upQuarter1 + upQuarter2 + upQuarter3 + upQuarter4);
                rows.add(totalRow);

                //合并列
                for (int i = 1; i <= 2; i++) {
                    Integer firstRow = dataList.size() + i;
                    Integer lastRow = dataList.size() + i;

                    cellRangeList.add(new CellRangeAddress(firstRow, lastRow, 0, 1));
                    cellRangeList.add(new CellRangeAddress(firstRow, lastRow, 2, 4));
                    cellRangeList.add(new CellRangeAddress(firstRow, lastRow, 5, 7));
                    cellRangeList.add(new CellRangeAddress(firstRow, lastRow, 8, 10));
                    cellRangeList.add(new CellRangeAddress(firstRow, lastRow, 11, 13));
                }

                XSSFFont font = wb.createFont();
                font.setFontHeightInPoints((short) 12);
                font.setColor(new XSSFColor(new java.awt.Color(0, 0, 0), new DefaultIndexedColorMap()));
                font.setFontName("宋体");

                //合计行样式
                XSSFCellStyle totalStyle = wb.createCellStyle();
                totalStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255), new DefaultIndexedColorMap()));
                totalStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                excelHelper.setBorder(totalStyle, BorderStyle.THIN, new XSSFColor(new java.awt.Color(188, 188, 188), new DefaultIndexedColorMap()));
                totalStyle.setAlignment(HorizontalAlignment.CENTER);
                totalStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                totalStyle.setFont(font);

                List<XSSFCellStyle> styles = new ArrayList();
                for (int i = 1; i <= 14; i++) {
                    styles.add(totalStyle);
                }

                cellStyles.add(styles);
                cellStyles.add(styles);

            }

            data.setRows(rows);
            data.setCellRangeList(cellRangeList);
            data.setStyleList(cellStyles);

            excelHelper.exportExcelNew(wb, response, "单位党费收缴登记本.xlsx", data);*/

            partyTotalService.exportPartyduesMonthTotal(request, response, year, dzzdm);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }


    @ResponseBody
    @GetMapping("/getLeaderUserTotalList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getLeaderUserTotalList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                                 @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String yearMonth,
                                                                                 @RequestParam(required = false) String xm) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyTotalService.getLeaderUserTotalList(pageIndex, pageSize, dzzdm, yearMonth, xm));
        return result;
    }

    @RequestMapping(value = "/exportLeaderUserTotal", method = RequestMethod.GET)
    public void exportLeaderUserTotal(HttpServletRequest request, HttpServletResponse response,
                                      @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String yearMonth,
                                      @RequestParam(required = false) String xm) {
        try {

            /**查询数据**/
            List<HashMap<String, Object>> dataList = partyTotalService.getLeaderUserTotalList(1, 1000000, dzzdm, yearMonth, xm).getList();

            ExcelHelper excelHelper = new ExcelHelper();
            ExcelHelper.ExcelData data = excelHelper.new ExcelData();

            //列名
            data.setName("领导人员5+3落实情况");
            List<String> titles = new ArrayList();
            titles.add("姓名");
            titles.add("所在党委");
            titles.add("年月");
            titles.add("是否已录入");

            data.setTitles(titles);

            //数据
            List<List<Object>> rows = new ArrayList();
            for (HashMap<String, Object> item : dataList) {
                List<Object> row = new ArrayList();
                row.add(item.get("XM"));
                row.add(item.get("DWMC"));
                row.add(item.get("YEARMONTH"));
                row.add(item.get("ISWRITE"));

                rows.add(row);
            }
            data.setRows(rows);

            excelHelper.exportExcel(response, "领导人员5+3落实情况.xlsx", data);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }


    @ResponseBody
    @GetMapping("/getSystemUseTotalList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getSystemUseTotalList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                                @RequestParam(required = false) String dzzdm, String fundYear, String duesYearMonth, String meetingYearMonth, String partydayYearMonth, String positionYearMonth) {
        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(partyTotalService.getSystemUseTotalList(pageIndex, pageSize, dzzdm, fundYear, duesYearMonth, meetingYearMonth, partydayYearMonth, positionYearMonth));
        return result;
    }

    @RequestMapping(value = "/exportSystemUseTotalList", method = RequestMethod.GET)
    public void exportSystemUseTotalList(HttpServletRequest request, HttpServletResponse response,
                                         @RequestParam(required = false) String dzzdm, String fundYear, String duesYearMonth, String meetingYearMonth, String partydayYearMonth, String positionYearMonth) {
        try {

            /**查询数据**/
            List<HashMap<String, Object>> dataList = partyTotalService.getSystemUseTotalList(1, 1000000, dzzdm, fundYear, duesYearMonth, meetingYearMonth, partydayYearMonth, positionYearMonth).getList();

            ExcelHelper excelHelper = new ExcelHelper();
            ExcelHelper.ExcelData data = excelHelper.new ExcelData();

            //列名
            data.setName("各单位运维情况");
            List<Map<String, CellRangeAddress>> colspanTitles = new ArrayList();
            Map<String, CellRangeAddress> titles = new HashMap<>(8);

            titles.put("所属党委", new CellRangeAddress(0, 1, 0, 0));
            titles.put("党组织名称", new CellRangeAddress(0, 1, 1, 1));
            titles.put("组织类别", new CellRangeAddress(0, 1, 2, 2));
            titles.put("基层分类名称", new CellRangeAddress(0, 1, 3, 3));
            titles.put("党组织维护情况", new CellRangeAddress(0, 0, 4, 6));
            titles.put("党组织工作经费预算维护情况", new CellRangeAddress(0, 0, 7, 9));
            titles.put("党费收缴情况", new CellRangeAddress(0, 0, 10, 11));
            titles.put("三会一课情况", new CellRangeAddress(0, 0, 12, 14));
            titles.put("主题党日开展情况", new CellRangeAddress(0, 0, 15, 16));
            titles.put("宣传阵地情况", new CellRangeAddress(0, 0, 17, 18));

            List<String> titles2 = new ArrayList();
            titles2.add("");
            titles2.add("");
            titles2.add("");
            titles2.add("");

            titles2.add("组织类别");
            titles2.add("基层分类");
            titles2.add("职工数");

            titles2.add("年度");
            titles2.add("录入预算");
            titles2.add("大于100万");

            titles2.add("年月");
            titles2.add("是否缴费");

            titles2.add("年月");
            titles2.add("是否开展");
            titles2.add("指标是否录入");

            titles2.add("年月");
            titles2.add("是否开展");

            titles2.add("年月");
            titles2.add("是否更新");

            colspanTitles.add(titles);
            data.setColspanTitles(colspanTitles);
            data.setTitles(titles2);
            //数据
            List<List<Object>> rows = new ArrayList();
            int index = 0;
            for (HashMap<String, Object> item : dataList) {
                List<Object> row = new ArrayList();
                row.add(item.get("DWMC"));
                row.add(item.get("DZZMC"));
                row.add(item.get("ZZLBMC"));
                row.add(item.get("JCZZFLMC"));

                row.add(item.get("ISZZLB"));
                row.add(item.get("ISJCZZFL"));
                row.add(item.get("ISZGS"));

                row.add(item.get("FUNDYEAR"));
                row.add(item.get("ISFUND"));
                row.add(item.get("IS100"));

                row.add(item.get("DUESMONTH"));
                row.add(item.get("ISDUES"));

                row.add(item.get("MEETINGMONTH"));
                row.add(item.get("ISMEETING"));
                row.add(item.get("ISPLAN"));

                row.add(item.get("PARTYDAYMONTH"));
                row.add(item.get("ISPARTYDAY"));

                row.add(item.get("POSITIONMONTH"));
                row.add(item.get("ISPOSITION"));

                rows.add(row);
            }
            data.setRows(rows);

            excelHelper.exportExcel(response, "各单位运维情况.xlsx", data);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
