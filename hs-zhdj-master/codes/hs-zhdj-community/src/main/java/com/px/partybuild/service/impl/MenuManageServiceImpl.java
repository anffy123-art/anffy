package com.px.partybuild.service.impl;

import com.px.partybuild.mapper.CfMenuMapper;
import com.px.partybuild.mapper.CfMenuRoleMapper;
import com.px.partybuild.model.CfMenu;
import com.px.partybuild.model.CfMenuExample;
import com.px.partybuild.model.CfMenuRoleExample;
import com.px.partybuild.service.MenuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author H
 * @date 2024-08
 */
@Service("menuManageService")
public class MenuManageServiceImpl implements MenuManageService {

    @Autowired
    private CfMenuMapper cfMenuMapper;

    @Autowired
    private CfMenuRoleMapper cfMenuRoleMapper;
    @Override
    public List<CfMenu> findAllTopParentMenus(String appid, String menuName, String menuNo) {

        CfMenuExample mexp = new CfMenuExample();
        CfMenuExample.Criteria cri = mexp.or();
        cri.andApplicationidEqualTo(appid).andParentmenuidIsNull();

        if (menuName != null && menuName.length() > 0) {
            cri.andMenunameLike("%" + menuName.trim() + "%");
        }

        if (menuNo != null && menuNo.length() > 0) {
            cri.andMenunoLike("%" + menuNo.trim() + "%");
        }
        mexp.setOrderByClause("MenuOrder ASC");
        return cfMenuMapper.selectByExample(mexp);
    }

    @Override
    public List<CfMenu> getChildMenuByParentId(String appid, String parentId) {

        CfMenuExample mexp = new CfMenuExample();
        mexp.or().andApplicationidEqualTo(appid)
                .andParentmenuidEqualTo(parentId);
        mexp.setOrderByClause("MenuOrder ASC");
        return cfMenuMapper.selectByExample(mexp);
    }

    @Override
    public List<CfMenu> findMenubyMenuNo(String menuNo) {

        CfMenuExample mexp = new CfMenuExample();
        mexp.or().andMenunoEqualTo(menuNo);

        return cfMenuMapper.selectByExample(mexp);
    }

    @Override
    public CfMenu findMenubyMenuid(String menuId) {

        return cfMenuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public String saveMenu(CfMenu menu) {

        if (menu.getMenuid() == null || menu.getMenuid() == "") {
            menu.setMenuid(UUID.randomUUID().toString());
            cfMenuMapper.insert(menu);
        } else {
            cfMenuMapper.updateByPrimaryKey(menu);
        }
        return menu.getMenuid();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int deleteMenuById(String menuId) {
        CfMenuRoleExample example = new CfMenuRoleExample();
        example.or().andMenuidEqualTo(menuId);
        cfMenuRoleMapper.deleteByExample(example);
        return cfMenuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public List<CfMenu> getMenuList(String appid) {
        CfMenuExample mexp = new CfMenuExample();
        mexp.or().andApplicationidEqualTo(appid).andIsvisibleEqualTo(1);
        mexp.or().andApplicationidEqualTo(appid).andMenunoNotLike("home.%");
        mexp.setOrderByClause("MenuOrder ASC");
        return cfMenuMapper.selectByExample(mexp);
    }

    @Override
    @Cacheable(value = "tabMenuList")
    public List<CfMenu> tabMenuList(){
        CfMenuExample mexp = new CfMenuExample();
        mexp.or().andMenunoLike("home.%");

        return cfMenuMapper.selectByExample(mexp);
    }
}
