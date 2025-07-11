package com.px.partybuild.controller;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.*;
import com.px.partybuild.service.BigDataService;
import com.px.partybuild.service.PartyUserService;
import com.px.partybuild.util.JsonMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.px.partybuild.vo.UserLeaderTotalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 大数据
 *
 * @author H
 */
@RestController
@RequestMapping(value = "/api/bigdata")
public class BigDataController {

    @Autowired
    private BigDataService bigDataService;
    @Autowired
    PartyUserService partyUserService;

    @ResponseBody
    @GetMapping("/getDsjDydtList")
    public List<DsjDydt> getDsjDydtList(@RequestParam(required = false) Integer nd, @RequestParam(required = false) Integer nd_OrderBy) {
        return bigDataService.getDsjDydtList(nd, nd_OrderBy);
    }

    @ResponseBody
    @RequestMapping("/saveDsjDydt")
    public RequsetData<String> saveDsjDydt(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        try {
            List<DsjDydt> dataList = JsonMapper.jsonToObject(reqMap.get("dataList").toString(), new TypeReference<List<DsjDydt>>() {
            });

            count = bigDataService.saveDsjDydt(dataList);
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
    @GetMapping("/getDsjPxpyList")
    public List<DsjPxpy> getDsjPxpyList(@RequestParam(required = false) Integer nd) {
        return bigDataService.getDsjPxpyList(nd);
    }

    @ResponseBody
    @RequestMapping("/saveDsjPxpy")
    public RequsetData<String> saveDsjPxpy(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        try {
            List<DsjPxpy> dataList = JsonMapper.jsonToObject(reqMap.get("dataList").toString(), new TypeReference<List<DsjPxpy>>() {
            });

            count = bigDataService.saveDsjPxpy(dataList);
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
    @GetMapping("/getDsjCzqkList")
    public List<DsjCzqk> getDsjCzqkList(@RequestParam(required = false) Integer nd) {
        return bigDataService.getDsjCzqkList(nd);
    }

    @ResponseBody
    @RequestMapping("/saveDsjCzqk")
    public RequsetData<String> saveDsjCzqk(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        try {
            List<DsjCzqk> dataList = JsonMapper.jsonToObject(reqMap.get("dataList").toString(), new TypeReference<List<DsjCzqk>>() {
            });

            count = bigDataService.saveDsjCzqk(dataList);
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
    @GetMapping("/getDsjDnppList")
    public List<DsjDnpp> getDsjDnppList() {
        return bigDataService.getDsjDnppList();
    }

    @ResponseBody
    @RequestMapping("/saveDsjDnpp")
    public RequsetData<String> saveDsjDnpp(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        try {
            List<DsjDnpp> dataList = JsonMapper.jsonToObject(reqMap.get("dataList").toString(), new TypeReference<List<DsjDnpp>>() {
            });

            count = bigDataService.saveDsjDnpp(dataList);
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
    @GetMapping("/getDsjCgjqList")
    public List<DsjCgjq> getDsjCgjqList() {
        return bigDataService.getDsjCgjqList();
    }

    @ResponseBody
    @RequestMapping("/saveDsjCgjq")
    public RequsetData<String> saveDsjCgjq(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        try {
            List<DsjCgjq> dataList = JsonMapper.jsonToObject(reqMap.get("dataList").toString(), new TypeReference<List<DsjCgjq>>() {
            });

            count = bigDataService.saveDsjCgjq(dataList);
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
    @GetMapping("/getDsjFzdyqkList")
    public List<DsjFzdyqk> getDsjFzdyqkList() {
        return bigDataService.getDsjFzdyqkList();
    }

    @ResponseBody
    @RequestMapping("/saveDsjFzdyqk")
    public RequsetData<String> saveDsjFzdyqk(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        try {
            List<DsjFzdyqk> dataList = JsonMapper.jsonToObject(reqMap.get("dataList").toString(), new TypeReference<List<DsjFzdyqk>>() {
            });

            count = bigDataService.saveDsjFzdyqk(dataList);
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
    @GetMapping("/getDsjNdkpjgList")
    public List<DsjNdkpjg> getDsjNdkpjgList(@RequestParam(required = false) Integer nd) {
        return bigDataService.getDsjNdkpjgList(nd);
    }

    @ResponseBody
    @RequestMapping("/saveDsjNdkpjg")
    public RequsetData<String> saveDsjNdkpjg(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        try {
            List<DsjNdkpjg> dataList = JsonMapper.jsonToObject(reqMap.get("dataList").toString(), new TypeReference<List<DsjNdkpjg>>() {
            });

            count = bigDataService.saveDsjNdkpjg(dataList);
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
    @GetMapping("/getDzzfbqkList")
    public List<HashMap<String, Object>> getDzzfbqkList() {
        return bigDataService.getDzzfbqkList();
    }


    @ResponseBody
    @GetMapping("/getDzzxxCount")
    public HashMap<String, Object> getDzzxxCount(@RequestParam(required = false) String province) {
        return bigDataService.getDzzxxCount(province);
    }

    @ResponseBody
    @GetMapping("/getDwxxCount")
    public HashMap<String, Object> getDwxxCount(@RequestParam(required = false) String province) {
        return bigDataService.getDwxxCount(province);
    }

    @ResponseBody
    @GetMapping("/getDyCount")
    public List<HashMap<String, Object>> getDyCount(@RequestParam(required = false) String province) {
        return bigDataService.getDyCount(province);
    }

    @ResponseBody
    @GetMapping("/getDyxbCount")
    public List<HashMap<String, Object>> getDyxbCount(@RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer dwgzzlb, @RequestParam(required = false) Integer isOnduty) {
        return bigDataService.getDyxbCount(dzzdm, dwgzzlb, isOnduty);
    }

    @ResponseBody
    @GetMapping("/getDynlCount")
    public List<HashMap<String, Object>> getDynlCount(@RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer dwgzzlb, @RequestParam(required = false) Integer isOnduty) {
        return bigDataService.getDynlCount(dzzdm, dwgzzlb, isOnduty);
    }

    @ResponseBody
    @GetMapping("/getDydlCount")
    public List<HashMap<String, Object>> getDydlCount(@RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer dwgzzlb, @RequestParam(required = false) Integer isOnduty) {
        return bigDataService.getDydlCount(dzzdm, dwgzzlb, isOnduty);
    }

    @ResponseBody
    @GetMapping("/getZgzwCount")
    public List<HashMap<String, Object>> getZgzwCount(@RequestParam(required = false) String dzzdm, @RequestParam(required = false) Integer dwgzzlb) {
        return bigDataService.getZgzwCount(dzzdm, dwgzzlb);
    }

    @ResponseBody
    @GetMapping("/CountRYZT")
    public RequsetData<List<Map<String, Object>>> countRyzt(@RequestParam("pg") String pg, @RequestParam(required = false) Integer isOnduty) {
        RequsetData<List<Map<String, Object>>> res = new RequsetData<>();
        try {
            res.setItem(bigDataService.countryzt(pg, isOnduty));
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }
        return res;
    }


    @ResponseBody
    @GetMapping("/getUserEducationList")
    public RequsetData<List<Map<String, Object>>> getUserEducationList(@RequestParam("dzzdm") String dzzdm, @RequestParam(required = false) Integer dwgzzlb, @RequestParam(required = false) Integer isOnduty) {
        RequsetData<List<Map<String, Object>>> res = new RequsetData<>();
        try {
            res.setItem(bigDataService.getUserEducationList(dzzdm, dwgzzlb, isOnduty));
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }
        return res;
    }

    @ResponseBody
    @GetMapping("/getShykCount")
    public RequsetData<List<HashMap<String, Object>>> getShykCount(@RequestParam("dzzdm") String dzzdm) {
        RequsetData<List<HashMap<String, Object>>> res = new RequsetData<>();
        try {
            res.setItem(bigDataService.getShykCount(dzzdm));
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }
        return res;
    }

    @ResponseBody
    @GetMapping("/getDzzxxList")
    public RequsetData<List<HashMap<String, Object>>> getDzzxxList(@RequestParam("dzzdm") String dzzdm) {
        RequsetData<List<HashMap<String, Object>>> res = new RequsetData<>();
        try {
            res.setItem(bigDataService.getDzzxxList(dzzdm));
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }
        return res;
    }

    @ResponseBody
    @GetMapping("/getDyxxList")
    public RequsetData<List<HashMap<String, Object>>> getDyxxList(@RequestParam("dzzdm") String dzzdm) {
        RequsetData<List<HashMap<String, Object>>> res = new RequsetData<>();
        try {
            res.setItem(bigDataService.getDyxxList(dzzdm));
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }
        return res;
    }

    @ResponseBody
    @GetMapping("/getAllDataTotal")
    public RequsetData<PageInfo<HashMap<String, Object>>> getAllDataTotal(@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize,
                                                                          @RequestParam(required = false) Integer zzfbType,
                                                                          @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        result.setItem(bigDataService.getAllDataTotal(pageIndex, pageSize, zzfbType, beginTime, endTime));
        return result;
    }

    @ResponseBody
    @GetMapping("/getDsjDYFZQKList")
    public List<DsjDyfzqk> getDsjDyfzqkList(@RequestParam(required = false) Integer nd) {
        return bigDataService.getdsjdyfzqklist(nd);
    }

    @ResponseBody
    @RequestMapping("/saveDsjDYFZQK")
    public RequsetData<String> saveDsjDyfzqk(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int count = 0;
        String message = "";
        try {
            List<DsjDyfzqk> dataList = JsonMapper.jsonToObject(reqMap.get("dataList").toString(), new TypeReference<List<DsjDyfzqk>>() {
            });

            count = bigDataService.savedsjdyfzqk(dataList);
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
    @GetMapping("/getDYFZQKTotalList")
    public RequsetData<List<HashMap<String, Object>>> getDyfzqkTotalList(@RequestParam("nd") Integer nd) {
        RequsetData<List<HashMap<String, Object>>> res = new RequsetData<>();
        //noinspection AlibabaRemoveCommentedCode
        try {
            List<Integer> ndList = new ArrayList<Integer>();
            ndList.add(nd);
            ndList.add(nd - 1);
            ndList.add(nd - 2);
            List<HashMap<String, Object>> list = bigDataService.getdyfzqktotallist(ndList);
           /* List<HashMap<String, Object>> data = new ArrayList<>();
            HashMap<String, Object> jhfzdysl=new HashMap<>();
            HashMap<String, Object> gr=new HashMap<>();
            HashMap<String, Object> scgzdyx=new HashMap<>();
            HashMap<String, Object> gtly=new HashMap<>();
            HashMap<String, Object> xjmfrw=new HashMap<>();
            HashMap<String, Object> gzsqt=new HashMap<>();
            HashMap<String, Object> gqty=new HashMap<>();
            jhfzdysl.put("product","发展党员总数");
            for (HashMap<String, Object> item:data){
                jhfzdysl.put(item.get("nd").toString(),item.get("jhfzdysl"));
                gr.put(item.get("nd").toString(),item.get("gr"));
                scgzdyx.put(item.get("nd").toString(),item.get("scgzdyx"));
                gtly.put(item.get("nd").toString(),item.get("gtly"));
                xjmfrw.put(item.get("nd").toString(),item.get("xjmfrw"));
                gzsqt.put(item.get("nd").toString(),item.get("gzsqt"));
                gqty.put(item.get("nd").toString(),item.get("gqty"));
            }*/
            res.setItem(list);
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }
        return res;
    }

    @ResponseBody
    @GetMapping("/getPartyCountList")
    public List<HashMap<String, Object>> getPartyCountList(@RequestParam(required = false) String dzzdm, @RequestParam(required = false) String ssdzzdm) {
        return bigDataService.getPartyCountList(dzzdm, ssdzzdm);
    }

    @ResponseBody
    @GetMapping("/getUserLeaderTotalList")
    public List<HashMap<String, Object>> getUserLeaderTotalList(@RequestParam("userCode") String userCode, @RequestParam(required = false) String year) {
        return bigDataService.getUserLeaderTotalList(userCode, year);
    }

    @ResponseBody
    @GetMapping("/getUserLeaderTotalListNew")
    public List<UserLeaderTotalVo> getUserLeaderTotalListNew(@RequestParam("rybm") String rybm, @RequestParam("year") Integer year, @RequestParam("quarter") Integer quarter) {
        return partyUserService.getUserLeaderTotalList(rybm, year, quarter);
    }


    @ResponseBody
    @GetMapping("/getPartyUserTotalList")
    public HashMap<String, Object> getPartyUserTotalList(@RequestParam("dzzdm") String dzzdm) {
        return bigDataService.getPartyUserTotalList(dzzdm);
    }


    @ResponseBody
    @GetMapping("/getCGJQTotal")
    public HashMap<String, Object> getCgjqTotal(@RequestParam(required = false) String dzzdm, @RequestParam(required = false) String ssdzzdm, @RequestParam(required = false) Integer year) {
        return bigDataService.getcgjqtotal(dzzdm, ssdzzdm, year);
    }

    @ResponseBody
    @GetMapping("/getCGJQTotalList")
    public List<HashMap<String, Object>> getCgjqotalList(@RequestParam("year") Integer year,@RequestParam(required = false) String dzzdm, @RequestParam(required = false) String ssdzzdm) {
        return bigDataService.getcgjqtotallist(dzzdm, ssdzzdm, year);
    }

    @ResponseBody
    @GetMapping("/getPartyUserExpendTotalList")
    public List<HashMap<String, Object>> getPartyUserExpendTotalList(@RequestParam(required = false) String dzzdm) {
        return bigDataService.getPartyUserExpendTotalList(dzzdm);
    }


    @ResponseBody
    @GetMapping("/getZXZXXTotal")
    public List<HashMap<String, Object>> getZxzxxTotal(@RequestParam(required = false) String dzzdm, @RequestParam(required = false) String ssdzzdm, @RequestParam(required = false) Integer year) {
        return bigDataService.getzxzxxtotal(dzzdm, ssdzzdm, year);
    }

    @ResponseBody
    @GetMapping("/getDjkpxxTotalList")
    public List<HashMap<String, Object>> getDjkpxxTotalList(@RequestParam(required = false) Integer year) {
        return bigDataService.getDjkpxxTotalList(year);
    }

    @ResponseBody
    @GetMapping("/getBrandTotalList")
    public List<HashMap<String, Object>> getBrandTotalList() {
        return bigDataService.getBrandTotalList();
    }

    @ResponseBody
    @GetMapping("/getJlcfxxTotalList")
    public List<HashMap<String, Object>> getJlcfxxTotalList() {
        return bigDataService.getJlcfxxTotalList();
    }

    @GetMapping("/getPartyUserStatusTotalList")
    public List<HashMap<String, Object>> getPartyUserStatusTotalList(){
        return bigDataService.getPartyUserStatusTotalList();
    }

    @GetMapping("/getZzpxqkList")
    public List<HashMap<String, Object>> getZzpxqkList() {
        return bigDataService.getZzpxqkList();
    }

    @GetMapping("/getDnpxxxTotalList")
    public List<HashMap<String, Object>> getDnpxxxTotalList() {
        return bigDataService.getDnpxxxTotalList();
    }

    @GetMapping("/getPartyBrandTotalList")
    public List<HashMap<String, Object>> getPartyBrandTotalList() {
        return bigDataService.getPartyBrandTotalList();
    }

    @GetMapping("/getSzpyTotalList")
    public List<HashMap<String, Object>> getSzpyTotalList() {
        return bigDataService.getSzpyTotalList();
    }

    @GetMapping("/getDnghbfTotalList")
    public List<HashMap<String, Object>> getDnghbfTotalList() {
        return bigDataService.getDnghbfTotalList();
    }

    @GetMapping("/getZtdrTotalList")
    public List<HashMap<String, Object>> getZtdrTotalList(Integer year) {
        return bigDataService.getZtdrTotalList(year);
    }


}
