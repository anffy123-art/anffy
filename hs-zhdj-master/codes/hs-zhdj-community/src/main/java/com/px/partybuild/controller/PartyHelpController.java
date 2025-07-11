package com.px.partybuild.controller;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.service.PartyHelpService;
import com.px.partybuild.service.UserService;
import com.px.partybuild.util.ExcelHelper;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.vo.PartyHelpImportVo;
import com.px.partybuild.vo.PartyHelpVo;
import com.px.partybuild.vo.UserInfoVo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/partyHelp")
public class PartyHelpController {

    @Autowired
    public PartyHelpService partyHelpService;

    @Autowired
    public StringUtils stringUtils;

    @Autowired
    private UserService userService;

    @GetMapping("/getList")
    public PageInfo<PartyHelpVo> getList(HttpServletResponse response, @RequestParam("pageindex") int page, @RequestParam("pagesize") int rows, @RequestParam("partyCode") String partyCode, @RequestParam(required = false) String userName, @RequestParam(required = false) String userCode,
                                         @RequestParam(required = false) Integer year, @RequestParam(required = false) Integer recordStatus, @RequestParam(required = false) Integer getType) throws Exception {

        PageInfo<PartyHelpVo> result = partyHelpService.getList(page, rows, partyCode, userName, userCode, year, recordStatus);

        if (getType == null || !getType.equals(2))
            return result;
        else {
            ExcelHelper excelHelper = new ExcelHelper();
            ExcelHelper.ExcelData data = excelHelper.new ExcelData();
            data.setTitles(Arrays.asList(new String[]{"姓名", "所在党组织", "年份", "帮扶原因", "审核状态", "审核人"}));

            List<List<Object>> rowDatas = new ArrayList();
            for (PartyHelpVo item : result.getList()) {
                List<Object> row = new ArrayList();
                row.add(item.userName);
                row.add(item.partyName);
                row.add(item.getYear());
                row.add(item.getHelpReason());
                row.add(item.recordStatusName);
                row.add(item.approveUserName);

                rowDatas.add(row);
            }

            data.setRows(rowDatas);
            excelHelper.exportExcel(response, "帮扶名单导出.xlsx", data);

            return null;
        }
    }


    @GetMapping("/get")
    public RequsetData<PartyHelpVo> get(@RequestParam(required = false) String helpId) {
        RequsetData<PartyHelpVo> res = new RequsetData<>();

        PartyHelpVo model = partyHelpService.get(helpId);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getPartyHelpID()))) {
            UUID uuid = UUID.randomUUID();
            model = new PartyHelpVo();
            model.setPartyHelpID(uuid.toString());
        }

        res.setItem(model);
        return res;
    }

    @PostMapping("/save")
    public RequsetData<String> save(@RequestBody PartyHelpVo data) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        try {
            count = partyHelpService.save(data, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("提交成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("提交失败！" + message);
        }
        return res;
    }

    @PostMapping("/delete")
    public RequsetData<Integer> delete(@RequestBody List<String> helpIdList) {
        RequsetData<Integer> result = new RequsetData<>();

        int row = partyHelpService.delete(helpIdList);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }

    @PostMapping("/approve")
    public RequsetData<Integer> delete(@RequestBody PartyHelpApproveVo data) {
        RequsetData<Integer> result = new RequsetData<>();

        int row = partyHelpService.approve(data.helpIdList, userService.getLoginUser().getUserid(), data.isPass ? 2 : 3);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("审核失败！");
        } else {
            result.setMsg("审核成功！");
        }
        return result;
    }

    @Data
    public static class PartyHelpApproveVo {
        public List<String> helpIdList;
        public Boolean isPass;
    }

    @PostMapping("import")
    public RequsetData<List<PartyHelpImportVo>> importData(@RequestBody List<PartyHelpImportVo> dataList) {
        RequsetData<List<PartyHelpImportVo>> res = new RequsetData<>();
        List<PartyHelpImportVo> errorInfo = new ArrayList<>();
        String message = "";
        try {

            errorInfo = partyHelpService.importData(dataList, userService.getLoginUser().getUserid(), userService.getUserInfobyId(userService.getLoginUser().getUserid()).getName());

        } catch (Exception e) {
            e.printStackTrace();
            message = e.toString();
        }
        if (errorInfo.size() <= 0 && stringUtils.IsNullOrEmpty(message)) {
            res.setSuccess(true);
            res.setMsg("操作成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("操作失败！" + message);
            res.setItem(errorInfo);
        }
        return res;
    }


}
