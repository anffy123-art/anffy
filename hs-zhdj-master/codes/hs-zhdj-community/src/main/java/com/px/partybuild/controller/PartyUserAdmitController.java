package com.px.partybuild.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.service.CommonService;
import com.px.partybuild.service.PartyUserAdmitService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.ExcelHelper;
import com.px.partybuild.util.JsonMapper;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.vo.ApplyProgressVo;
import com.px.partybuild.vo.PartyUserAdmitVo;
import com.px.partybuild.vo.RegisterVo;
import com.px.partybuild.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping(value = "/api/partyUserAdmit")
public class PartyUserAdmitController {
    @Autowired
    private PartyUserAdmitService partyUserAdmitService;
    @Autowired
    private StringUtils stringUtils;
    private static final String dateTimeFormat = "yyyy-MM-dd";
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private CommonService commonService;

    @ResponseBody
    @GetMapping("/getList")
    public RequsetData<PageInfo<PartyUserAdmitVo>> getList(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String userCode, @RequestParam(required = false) String userName,
                                                           @RequestParam(required = false) Integer userStatus,
                                                           @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date applyStartDate, @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date applyEndDate,
                                                           @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date activeStartDate, @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date activeEndDate,
                                                           @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date passStartDate, @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date passEndDate,
                                                           @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date inPatyStartDate, @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date inPatyEndDate,
                                                           @RequestParam(required = false) Integer isArchive, @RequestParam(required = false) Integer applyApproveStatus
            , @RequestParam(required = false) String gradeName, @RequestParam(required = false) String className, @RequestParam(required = false) Integer sexId, @RequestParam(required = false) Integer isStudent, @RequestParam(required = false) Integer educationalId
            , @RequestParam(required = false) String userNo) {


        RequsetData<PageInfo<PartyUserAdmitVo>> result = new RequsetData<>();
        result.setItem(this.partyUserAdmitService.getPartyUserAdmitList(pageIndex, pageSize, dzzdm, userCode, userName, userStatus, applyStartDate, applyEndDate, activeStartDate, activeEndDate, passStartDate, passEndDate, inPatyStartDate, inPatyEndDate, isArchive, applyApproveStatus, gradeName, className, sexId, isStudent, educationalId, userNo));
        return result;
    }

    @ResponseBody
    @GetMapping("/getPartyUserByCode")
    public RequsetData<PartyUserAdmitVo> getPartyUserByCode(@RequestParam(required = false) String userCode) {
        RequsetData<PartyUserAdmitVo> res = new RequsetData<>();

        PartyUserAdmitVo model = !stringUtils.IsNullOrEmpty(userCode) ? partyUserAdmitService.getPartyUserByCode(userCode) : null;

        if (model == null)
            model = new PartyUserAdmitVo();

        res.setItem(model);
        return res;
    }

    @ResponseBody
    @PostMapping("/saveUser")
    public RequsetData<String> saveUser(@RequestBody PartyUserAdmitVo data) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String errorMsg = "";

        try {
            data.setApplyApproveStatus(2);
            count = partyUserAdmitService.save(data);
        } catch (Exception e) {
            errorMsg = e.getMessage();
        }

        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！" + errorMsg);
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/delete")
    public RequsetData<Integer> delete(String userCode) {
        RequsetData<Integer> result = new RequsetData<>();

        int row = partyUserAdmitService.delete(userCode);
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
    @RequestMapping("/importApplyUser")
    public RequsetData<List<UserInfoVo>> importApplyUser(@RequestBody Map<String, Object> reqMap) {
        RequsetData<List<UserInfoVo>> res = new RequsetData<>();
        List<UserInfoVo> errorInfo = new ArrayList<>();
        String message = "";
        try {

            List<UserInfoVo> userList = JsonMapper.jsonToObject(reqMap.get("userList").toString(), new TypeReference<List<UserInfoVo>>() {
            });

            errorInfo = partyUserAdmitService.importApplyUser(userList, 1);

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

    @RequestMapping(value = "/exportPartyUserAdmit", method = RequestMethod.GET)
    public void exportPartyUserAdmit(HttpServletResponse response,
                                     @RequestParam(required = false) String dzzdm, @RequestParam(required = false) String userCode, @RequestParam(required = false) String userName,
                                     @RequestParam(required = false) Integer userStatus,
                                     @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date applyStartDate, @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date applyEndDate,
                                     @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date activeStartDate, @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date activeEndDate,
                                     @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date passStartDate, @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date passEndDate,
                                     @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date inPatyStartDate, @RequestParam(required = false) @DateTimeFormat(pattern = dateTimeFormat) Date inPatyEndDate,
                                     @RequestParam(required = false) Integer isArchive, @RequestParam(required = false) Integer getType, @RequestParam(required = false) Integer applyApproveStatus
            , @RequestParam(required = false) String gradeName, @RequestParam(required = false) String className, @RequestParam(required = false) Integer sexId, @RequestParam(required = false) Integer isStudent, @RequestParam(required = false) Integer educationalId, @RequestParam(required = false) String userNo
    ) throws Exception {

        /**查询数据**/
        List<PartyUserAdmitVo> dataList = partyUserAdmitService.getPartyUserAdmitList(1, 10000, dzzdm, userCode, userName, userStatus, applyStartDate, applyEndDate, activeStartDate, activeEndDate, passStartDate, passEndDate, inPatyStartDate, inPatyEndDate, isArchive, applyApproveStatus, gradeName, className, sexId, isStudent, educationalId, userNo).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("人员基本信息");
        List<String> titles = new ArrayList();
        String tempName = "";

        titles.add("姓名");
        titles.add("学号/工号");
        titles.add("所属党组织");
        titles.add("是否学生身份");
        titles.add("人员类别");
        titles.add("性别");
        titles.add("民族");
        titles.add("出生日期");
        titles.add("籍贯");
        titles.add("身份证号");
        titles.add("年级");
        titles.add("班级");
        titles.add("联系电话");
        titles.add("学历");
        titles.add("最高学历入学日期");
        titles.add("最高学历毕业日期");
        if (getType != null) {
            switch (getType) {
                case 1: //申请入党人
                    titles.add("入党申请日期");
                    tempName = "入党申请人信息导出";
                    break;
                case 5://入党积极分子
                    titles.add("确定积极分子时间");
                    titles.add("培养联系人1");
                    titles.add("培养联系人2");
                    tempName = "积极分子信息导出";
                    break;
                case 6://发展对象
                    titles.add("确认发展对象日期");
                    tempName = "发展对象信息导出";
                    break;
                case 2://预备党员
                    titles.add("入党日期");
                    tempName = "预备党员导出";
                    break;
                case 3://正式党员
                    titles.add("入党日期");
                    tempName = "正式党员信息导出";
                    break;
                default:
                    break;
            }
        } else {
            titles.add("入党申请日期");
            titles.add("确定积极分子时间");
            titles.add("确认发展对象日期");
            titles.add("入党日期");
            titles.add("转正日期");
            titles.add("培养联系人");
            titles.add("培养联系人电话");
            tempName = "发展党员信息导出";
        }

        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (PartyUserAdmitVo item : dataList) {
            List<Object> row = new ArrayList();
            row.add(item.getUserName());
            row.add(item.getUserCode());
            row.add(item.getPartyName());
            row.add(item.getIsStudentName());
            row.add(item.getUserStatusName());
            row.add(item.getSex());
            row.add(item.getNational());
            row.add(dateUtils.dateToStr(item.getBirthDate()));
            row.add(item.getNativePlace());
            row.add(item.getIdCard());
            row.add(item.getGradeName());
            row.add(item.getClassName());
            row.add(item.getContactMobile());
            row.add(item.getEducational());
            row.add(dateUtils.dateToStr(item.getEnrollmentDate()));
            row.add(dateUtils.dateToStr(item.getGraduateDate()));

            if (getType != null) {
                switch (getType) {
                    case 1: //申请入党人
                        row.add(dateUtils.dateToStr(item.getApplyDate()));
                        break;
                    case 5://入党积极分子
                        row.add(dateUtils.dateToStr(item.getActiveDate()));
                        row.add(item.getTrainUser1());
                        row.add(item.getTrainUser2());
                        break;
                    case 6://发展对象
                        row.add(dateUtils.dateToStr(item.getPassDate()));
                        break;
                    case 2://预备党员
                        row.add(dateUtils.dateToStr(item.getInPartyDate()));
                        break;
                    default:
                        break;
                }
            } else {
                row.add(dateUtils.dateToStr(item.getApplyDate()));
                row.add(dateUtils.dateToStr(item.getActiveDate()));
                row.add(dateUtils.dateToStr(item.getPassDate()));
                row.add(dateUtils.dateToStr(item.getInPartyDate()));
                row.add(dateUtils.dateToStr(item.getBecomeFullDate()));
                row.add(item.getTrainUser1());
                row.add(item.getTrainUser2());
            }

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, tempName + ".xlsx", data);
    }

    @RequestMapping(value = "/exportPartyUserAdmitTemp", method = RequestMethod.GET)
    public void exportPartyUserAdmitTemp(HttpServletResponse response,
                                         @RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer userStatus) throws Exception {

        /**查询数据**/
        List<PartyUserAdmitVo> dataList = partyUserAdmitService.getPartyUserAdmitList(1, 10000, dzzdm, null, null, userStatus, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null).getList();
        String tempName = "";
        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("人员基本信息");
        List<String> titles = new ArrayList();

        titles.add("姓名");
        titles.add("学号/工号");
        titles.add("所属党支部");
        switch (userStatus) {
            case 1: //申请入党人
                titles.add("确定积极分子时间");
                titles.add("培养联系人1");
                titles.add("培养联系人2");
                titles.add("联系电话");
                tempName = "积极分子";
                break;
            case 5://入党积极分子
                titles.add("确认发展对象日期");
                tempName = "发展对象";
                break;
            case 6://发展对象
                titles.add("入党日期");
                tempName = "预备党员";
                break;
            case 2://预备党员
                titles.add("转正日期");
                tempName = "正式党员";
                break;
        }

        data.setTitles(titles);

        //数据
        List<List<Object>> rows = new ArrayList();
        for (PartyUserAdmitVo item : dataList) {
            List<Object> row = new ArrayList();

            row.add(item.getUserName());
            row.add(item.getUserCode());
            row.add(item.getPartyName());
            if (userStatus.equals(1)) {
                row.add("");
                row.add("");
                row.add("");
                row.add(item.getContactMobile());
            }
            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, tempName + "导入模板.xlsx", data);
    }

    @ResponseBody
    @RequestMapping("/updateUserProgress")
    public RequsetData<List<UserInfoVo>> updateUserProgress(@RequestBody Map<String, Object> reqMap) {
        RequsetData<List<UserInfoVo>> res = new RequsetData<>();
        List<UserInfoVo> errorInfo = new ArrayList<>();
        String message = "";
        try {

            List<UserInfoVo> userList = JsonMapper.jsonToObject(reqMap.get("userList").toString(), new TypeReference<List<UserInfoVo>>() {
            });
            Integer userStatus = Integer.parseInt(reqMap.get("userStatus").toString());

            errorInfo = partyUserAdmitService.updateUserProgress(userList, userStatus);

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

    @ResponseBody
    @PostMapping("/archive")
    public RequsetData<String> archive(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String errorMsg = "";

        try {
            List<String> userCodeList = JsonMapper.jsonToObject(reqMap.get("userCodes").toString(), new TypeReference<List<String>>() {
            });

            Date exportDate = reqMap.get("exportDate") != null ? dateUtils.strToDateExt(reqMap.get("exportDate").toString()) : null;
            String exportPartyName = reqMap.get("exportPartyName") != null ? reqMap.get("exportPartyName").toString() : "";
            Date archiveDate = reqMap.get("archiveDate") != null ? dateUtils.strToDateExt(reqMap.get("archiveDate").toString()) : null;

            count = partyUserAdmitService.archive(userCodeList, exportDate, exportPartyName, archiveDate);
        } catch (Exception e) {
            errorMsg = e.toString();
        }

        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！" + errorMsg);
        }

        return res;
    }

    @ResponseBody
    @PostMapping("/unArchive")
    public RequsetData<String> unArchive(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String errorMsg = "";

        try {
            List<String> userCodeList = JsonMapper.jsonToObject(reqMap.get("userCodes").toString(), new TypeReference<List<String>>() {
            });

            count = partyUserAdmitService.unArchive(userCodeList);
        } catch (Exception e) {
            errorMsg = e.toString();
        }

        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败！" + errorMsg);
        }

        return res;
    }

    @ResponseBody
    @PostMapping("/register")
    public RequsetData<String> register(@RequestBody RegisterVo data) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String errorMsg = "";

        try {

            String pwd = commonService.DesTokenData(data.getDesData().getToken(), dateUtils.DateToDateTime(data.getDesData().getTm()));
            String[] pwdList = pwd.split("\\|");
            if (pwdList.length != 2 || !pwdList[0].equals(pwdList[1]))
                throw new Exception("两次输入的密码不一致");

            data.getUserData().setPassword(DigestUtils.md5DigestAsHex(pwdList[1].getBytes()).toUpperCase());
            data.getUserData().setUserStatus("1");
            data.getUserData().setApplyApproveStatus(1);

            count = partyUserAdmitService.save(data.getUserData());
        } catch (Exception e) {
            errorMsg = e.getMessage();
        }

        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("申请成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("申请失败！" + errorMsg);
        }

        return res;
    }

    @ResponseBody
    @PostMapping("/audit")
    public RequsetData<String> audit(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String errorMsg = "";

        try {
            List<String> userCodeList = JsonMapper.jsonToObject(reqMap.get("userCodes").toString(), new TypeReference<List<String>>() {
            });
            Integer applyApproveStatus = Integer.parseInt(reqMap.get("applyApproveStatus").toString());

            count = partyUserAdmitService.audit(userCodeList, applyApproveStatus);
        } catch (Exception e) {
            errorMsg = e.toString();
        }

        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("审核成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("审核失败！" + errorMsg);
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/getApplyProgressList")
    public RequsetData<List<ApplyProgressVo>> getApplyProgressList(@RequestParam("userCode") String userCode) {
        RequsetData<List<ApplyProgressVo>> result = new RequsetData<>();
        result.setItem(this.partyUserAdmitService.getApplyProgressList(userCode));
        return result;
    }

}
