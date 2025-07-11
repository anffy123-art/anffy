package com.px.partybuild.controller;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.DjzzrsJgfz;
import com.px.partybuild.service.PartyOrgService;
import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/partyOrg")
public class PartyOrgController {

    @Autowired
    PartyOrgService partyOrgService;

    @Autowired
    private StringUtils stringUtils;

    @ResponseBody
    @PostMapping("/saveDjzzrsJgfz")
    public RequsetData<Integer> SaveDjzzrsJgfz(@RequestBody DjzzrsJgfz model) {

        RequsetData<Integer> result = new RequsetData<>();

        int row = partyOrgService.saveDjzzrsJgfz(model);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("保存失败！");
        } else {
            result.setMsg("保存成功！");
        }
        return result;
    }

    @ResponseBody
    @GetMapping("/getPartyOrgTree")
    public RequsetData<List<Map<String, Object>>> getPartyOrgTree(@RequestParam(required = false) String jgfzid) {
        RequsetData<List<Map<String, Object>>> result = new RequsetData<>();

        List<Map<String, Object>> list = partyOrgService.selectPartyOrgTree();
        result.setItem(list);

        return result;
    }

    @ResponseBody
    @RequestMapping("/getDjzzrsJgfz")
    public RequsetData<DjzzrsJgfz> getDjzzrsJgfz(@RequestParam("jgfzid") String jgfzid) {
        RequsetData<DjzzrsJgfz> res = new RequsetData<>();

        DjzzrsJgfz model = partyOrgService.getDjzzrsJgfz(jgfzid);
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getJgfzid()))) {
            UUID uuid = UUID.randomUUID();
            model = new DjzzrsJgfz();
            model.setJgfzid(uuid.toString());
        }
        res.setItem(model);
        return res;
    }

    @ResponseBody
    @RequestMapping("/saveFzjggl")
    public RequsetData<String> saveFzjggl(@RequestBody Map<String, Object> reqMap) {
        RequsetData<String> res = partyOrgService.saveFzjggl(reqMap);
        return res;
    }

    @ResponseBody
    @GetMapping("/getSelectDzzdmList")
    public RequsetData<List<String>> getSelectDzzdmList(@RequestParam(required = false) String jgfzid) {
        RequsetData<List<String>> result = new RequsetData<>();

        List<String> list = partyOrgService.selectFzjgglList(jgfzid);
        result.setItem(list);

        return result;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public RequsetData<String> delete(@RequestParam("jgfzid") String jgfzid) {
        RequsetData<String> res = partyOrgService.delete(jgfzid);
        return res;
    }
}
