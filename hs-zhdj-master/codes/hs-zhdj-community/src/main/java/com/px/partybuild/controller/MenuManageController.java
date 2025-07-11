package com.px.partybuild.controller;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.CfMenu;
import com.px.partybuild.service.MenuManageService;
import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/menumanage")
public class MenuManageController {

    @Autowired
    private MenuManageService menuManage;
    @Autowired
    private StringUtils stringUtils;

    @ResponseBody
    @GetMapping("/alltopparentmenus")
    public RequsetData<List<CfMenu>> getAllTopParentMenus(@RequestParam("appid") String appid, @RequestParam("menuname") String menuName, @RequestParam("menuno") String menuNo) {
        List<CfMenu> menuListenus = menuManage.findAllTopParentMenus(appid, menuName, menuNo);
        RequsetData<List<CfMenu>> res = new RequsetData<List<CfMenu>>();
        res.setItem(menuListenus);
        res.setMsg("成功！");
        return res;
    }

    @ResponseBody
    @GetMapping("/childmenubyparentid")
    public RequsetData<List<CfMenu>> getChildMenuById(@RequestParam("appid") String appid, @RequestParam("parentid") String parentId) {
        List<CfMenu> menuListenus = menuManage.getChildMenuByParentId(appid, parentId);
        RequsetData<List<CfMenu>> res = new RequsetData<List<CfMenu>>();
        res.setItem(menuListenus);
        res.setMsg("成功！");
        return res;
    }

    @ResponseBody
    @PostMapping("/savemenu")
    public RequsetData<Object> saveMenu(@RequestBody CfMenu menu) {

        RequsetData<Object> res = new RequsetData<Object>();
        res.setItem(menuManage.saveMenu(menu));

        res.setMsg("保存成功！");
        return res;
    }

    @ResponseBody
    @GetMapping("/findmenubymenuid")
    public RequsetData<CfMenu> findMenubyMenuid(@RequestParam("menuid") String menuId) {
        RequsetData<CfMenu> res = new RequsetData<CfMenu>();
        CfMenu it = menuManage.findMenubyMenuid(menuId);
        res.setItem(it);
        return res;
    }

    @ResponseBody
    @GetMapping("/deletemenubyid")
    public RequsetData<String> deleteMenuByParentid(@RequestParam("menuid") String menuId) {
        RequsetData<String> res = new RequsetData<String>();
        int delrow = menuManage.deleteMenuById(menuId);
        if (delrow > 0) {
            res.setMsg("删除成功！");
            res.setItem(menuId);
        } else {
            res.setMsg("删除失败！");
            res.setSuccess(false);
        }
        return res;
    }

    @ResponseBody
    @PostMapping("/FindMenus")
    public RequsetData<List<CfMenu>> findMenus(@RequestBody Map<String, Object> reqMap) {
        String menuNo = reqMap.get("menuno").toString();
        String parentNo = reqMap.get("parentNo").toString();
        RequsetData<List<CfMenu>> res = new RequsetData<List<CfMenu>>();
        List<CfMenu> it = menuManage.findMenubyMenuNo(menuNo);
        if (it.size() > 0) {
            String parentId = it.get(0).getParentmenuid();
            if (!stringUtils.IsNullOrEmpty(parentNo)) {
                List<CfMenu> pmenuList = menuManage.findMenubyMenuNo(parentNo);
                if (pmenuList.size() > 0) {
                    parentId = pmenuList.get(0).getMenuid();
                }
            }
            while (parentId != null && parentId.length() > 0) {
                CfMenu parent = menuManage.findMenubyMenuid(parentId);
                parentId = parent.getParentmenuid();
                it.add(parent);
            }
        }
        res.setItem(it);
        return res;
    }

    @ResponseBody
    @GetMapping("/tabMenuList")
    public RequsetData<List<CfMenu>> tabMenuList() {
        RequsetData<List<CfMenu>> res = new RequsetData<>();
        try{
            res.setItem(menuManage.tabMenuList());
        }catch (Exception ex){
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }

        return res;
    }

}
