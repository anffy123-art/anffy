package com.px.partybuild.controller.partyExpand;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.PeFlow;
import com.px.partybuild.model.PeWordtemplate;
import com.px.partybuild.service.PeWordTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/pe/wordTemplate")
public class WordTemplateController {

    @Autowired
    PeWordTemplateService peWordTemplateService;

    @ResponseBody
    @GetMapping("/getTemplateList")
    public RequsetData<PageInfo<Map<String,Object>>> getTemplateList(@RequestParam(required = false) String title, @RequestParam(required = false) String flowid,@RequestParam(required = false) String pflowid, @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {
        RequsetData<PageInfo<Map<String,Object>>> res=new RequsetData<>();

        PageInfo<Map<String,Object>> pList=peWordTemplateService.findList(title,flowid,pflowid,pageIndex,pageSize);
        res.setItem(pList);

        return res;
    }

    @ResponseBody
    @GetMapping("/getTemplateItem")
    public RequsetData<PeWordtemplate> getTemplateItem(@RequestParam("id") String id) {
        RequsetData<PeWordtemplate> res=new RequsetData<>();

        PeWordtemplate it=peWordTemplateService.getWord(id);
        res.setItem(it);
        Map<String,Object> edata=new HashMap<>();
        if(it!=null) {
            String pId = peWordTemplateService.getDicFlowParentId(it.getFlowid());
            edata.put("flowpid", pId);
        }
        res.setExtdata(edata);

        return res;
    }
    @ResponseBody
    @GetMapping("/getTemplateItemByFlowId")
    public RequsetData<PeWordtemplate> getTemplateItemByFlowId(@RequestParam("flowId") String flowId) {
        RequsetData<PeWordtemplate> res=new RequsetData<>();

        PeWordtemplate it=peWordTemplateService.getWordByFlowId(flowId);
        res.setItem(it);

        return res;
    }
    @ResponseBody
    @PostMapping("/saveWord")
    public RequsetData<Integer> saveWord(@RequestBody PeWordtemplate model){
        RequsetData<Integer> res=new RequsetData<>();

        try {
            int rows = peWordTemplateService.saveWord(model);
            res.setItem(rows);
            res.setMsg("保存成功！");
        }catch (Exception ex){
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/delWord")
    public RequsetData<Integer> delWord(@RequestParam() String id){
        RequsetData<Integer> res=new RequsetData<>();

        try{
            int rows=peWordTemplateService.deleteWord(id);
            res.setItem(rows);
            res.setMsg("删除成功！");
        }catch (Exception ex){
            res.setSuccess(false);
            res.setMsg("删除失败："+ex.getMessage());
        }


        return res;
    }

    @ResponseBody
    @GetMapping("/getPFlowDicList")
    public RequsetData<List<PeFlow>> getPFlowDicList() {
        RequsetData<List<PeFlow>> res=new RequsetData<>();

        List<PeFlow> pList=peWordTemplateService.getDicFlowParentList();
        res.setItem(pList);

        return res;
    }

    @ResponseBody
    @GetMapping("/getFlowDicList")
    public RequsetData<List<PeFlow>> getFlowDicList(@RequestParam() String pid) {
        RequsetData<List<PeFlow>> res=new RequsetData<>();

        List<PeFlow> pList=peWordTemplateService.getDicFlowByParentId(pid);
        res.setItem(pList);

        return res;
    }


}
