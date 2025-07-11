package com.px.partybuild.service;

import com.px.partybuild.model.CfMenu;

import java.util.List;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface MenuManageService {
    /**
     * find top parent menus
     * @param appid
     * @param menuName
     * @param menuNo
     * @return
     */
    List<CfMenu> findAllTopParentMenus(String appid, String menuName, String menuNo);

    /**
     * get child meun by p id
     * @param appid
     * @param parentId
     * @return
     */
    List<CfMenu> getChildMenuByParentId(String appid, String parentId);

    /**
     * fild menu by id
     * @param menuId
     * @return
     */
    CfMenu findMenubyMenuid(String menuId);

    /**
     * menu save
     * @param menu
     * @return
     */
    String saveMenu(CfMenu menu);

    /**
     * menu delete
     * @param menuId
     * @return
     */
    int deleteMenuById(String menuId);

    /**
     * menu list
     * @param appid
     * @return
     */
    List<CfMenu> getMenuList(String appid);

    /**
     * find menu by no
     * @param MenuNo
     * @return
     */
    List<CfMenu> findMenubyMenuNo(String MenuNo);

    /**
     * menu list
     * @return
     */
    List<CfMenu> tabMenuList();
}
