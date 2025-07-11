package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.ZzDxzcy;
import com.px.partybuild.model.ZzDzzzly;
import com.px.partybuild.model.ZzZzqkxx;
import com.px.partybuild.model.ZzZzqkxxfb;
import com.px.partybuild.vo.PartyInfoVo;
import com.px.partybuild.vo.TreeVo;

import java.util.HashMap;
import java.util.List;

/**
 * 党组织信息
 *
 * @author H
 */
public interface PartyService {

    /**
     * 获取组织架构
     * @param parentCode
     * @param dzzdm
     * @param showlevel
     * @return
     */
    List<HashMap<String, Object>> getPartyTreeList(String parentCode,String dzzdm, Integer showlevel);

    /**
     * 获取组织架构树
     * @return
     */
    List<TreeVo> getPartyTree(String parentId);

    List<TreeVo> getChildParty(String parentId);

    /**
     * 查询组织信息
     * @param pageNum
     * @param pageSize
     * @param parentCode
     * @param dzzmc
     * @param dzzdm
     * @param zzlb
     * @param jczzfl
     * @param jldzzrqBegin
     * @param jldzzrqEnd
     * @param isContainParent
     * @param zzfbType
     * @param hjYear 换届年度
     * @param zzlbStrList
     * @param ssdzzmc
     * @param dwjb
     * @param jmrqBegintime
     * @param jmrqEndtime
     * @return
     */
    PageInfo<HashMap<String, Object>> getPartyList(int pageNum, int pageSize, String parentCode, String dzzmc, String dzzdm, String zzlb, String jczzfl, String jldzzrqBegin, String jldzzrqEnd, String isContainParent, Integer zzfbType
            , Integer hjYear, List<String> zzlbStrList, String ssdzzmc, Integer dwjb, String jmrqBegintime, String jmrqEndtime,List<String> jczzflList,String partyGroupId,List<String> notIncludeDzzdmList);


    /**
     * 获取党组织信息
     * @param dzzdm
     * @return
     */
    ZzZzqkxx getPartyByDm(String dzzdm);


    /**
     * 查询党组织信息
     * @param id
     * @return
     */
    ZzZzqkxx getPartyById(String id);

    /**
     * 保存党组织信息
     * @param zzZzqkxx
     * @param zzZzqkxxfb
     * @param zzDzzzlyList
     * @return
     */
    int saveParty(ZzZzqkxx zzZzqkxx, ZzZzqkxxfb zzZzqkxxfb, List<ZzDzzzly> zzDzzzlyList) throws Exception;

    /**
     * 删除党组织信息
     * @param id
     * @return
     */
    int deletePartyById(String id);

    /**
     * 保存党小组
     * @param zzZzqkxx
     * @param zzDxzcies
     * @return
     */
    int savepartydxz(ZzZzqkxx zzZzqkxx, List<ZzDxzcy> zzDxzcies);

    /**
     * 根据yhbm获取党组织基本情况
     * @param userCode
     * @return
     */
    ZzZzqkxx getPartyByUserCode(String userCode);

    /**
     * 判断当前组织是否为支部
     * @param dzzdm
     * @return 0否，1是
     */
    int isPartyZb(String dzzdm);

    /**
     * 查询组织类型树
     * @param dzzdm
     * @param onlyshowDw
     * @return
     */
    List<HashMap<String, Object>> getPartyGroupTreeList(String dzzdm, Integer onlyshowDw);

    /**
     * 组织情况副表信息
     * @param id
     * @return
     */
    ZzZzqkxxfb getPartyFbById(String id);

    /**
     * 查询助理员信息
     * @param pageNum
     * @param pageSize
     * @param dzzdm
     * @return
     */
    PageInfo<HashMap<String, Object>> getPartyZlyList(int pageNum, int pageSize, String dzzdm);

    /**
     * 查询组织数
     * @param dzzdm
     * @param ssdzzdm
     * @return
     */
    List<HashMap<String, Object>> getChildPartyCount(String dzzdm, String ssdzzdm);

    /**
     * 获取组织树
     * @param parentCode
     * @param dzzdm
     * @param userId
     * @param onlyshowDw
     * @param showdxz
     * @return
     */
    List<HashMap<String, Object>> getNewPartyTreeList(String parentCode, String dzzdm, String userId, Integer onlyshowDw,Integer showdxz);

    /**
     * 获取党委信息
     * @param dzzdm
     * @return
     */
    ZzZzqkxx getUserDwInfo(String dzzdm);

    ZzZzqkxx getUserDZZInfo(String dzzdm);

    /**
     * 获取党组织名称
     * @param dzzdm
     * @return
     */
    String getPartyName(String dzzdm);

    /**
     * 获取党组织
     * @param dzzmc
     * @return
     */
    ZzZzqkxx getPartyByMc(String dzzmc);

    /**
     * 后台处理党组织数据
     * @return
     */
    int handlePartyData();


    HashMap<String, Object> getPartyTreeForApp(String id, Integer onlyshowDw, Integer showdxz);

    PartyInfoVo getPartyInfo(String dzzdm);

    /**
     * 用户所属党总支信息
     * @param dzzdm
     * @return
     */
    ZzZzqkxx getUserGeneralPartyInfo(String dzzdm);

}
