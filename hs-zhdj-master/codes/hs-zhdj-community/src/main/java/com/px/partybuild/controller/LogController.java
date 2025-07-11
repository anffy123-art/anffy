package com.px.partybuild.controller;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.service.LogService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/log")
public class LogController {

    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private LogService logService;

    @ResponseBody
    @GetMapping("/getLogList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getLogList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                     @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime, @RequestParam(required = false) String userName) {

        beginTime = dateUtils.strFormat_short(beginTime);
        endTime = dateUtils.strFormat_short(endTime);

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(logService.getLogList(pageIndex, pageSize, beginTime, endTime, userName));
        return result;
    }


    @ResponseBody
    @GetMapping("/getLoginLogList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getLoginLogList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                     @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String userName,@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,@RequestParam(required = false) Integer loginType) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(logService.getLoginLogList(pageIndex, pageSize, dzzdm, userName, beginTime, endTime,loginType));
        return result;
    }

    @RequestMapping(value = "/exportLoginLog", method = RequestMethod.GET)
    public void exportPartyUser(HttpServletResponse response,
                                String dzzdm, @RequestParam(required = false) String userName,@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,@RequestParam(required = false) Integer loginType) throws Exception {



        /**查询数据**/
        List<HashMap<String, Object>> dataList = logService.getLoginLogList(1, 1000000, dzzdm, userName, beginTime, endTime,loginType).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("党员登录情况");
        List<String> titles = new ArrayList();
        titles.add("登录人姓名");
        titles.add("所在组织");
        titles.add("登录端");
        titles.add("登录时间");
        titles.add("请求IP");
        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (HashMap<String, Object> item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.get("XM"));
            row.add(item.get("DZZMC"));
            row.add(item.get("LOGINTYPENAME"));
            row.add(item.get("LOGTIME"));
            row.add(item.get("REQUESTIP"));

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "党员登录情况.xlsx", data);
    }



}
