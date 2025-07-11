package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.ZzBzcyxx;
import com.px.partybuild.model.ZzBzjcxx;
import com.px.partybuild.model.ZzBzjcxxfb;

import java.util.HashMap;
import java.util.List;

/**
 * 领导班子
 *
 * @author H
 */
public interface GradeService {

    /**
     * 查询换届选举配置
     * @param pageNum
     * @param pageSize
     * @param dzzdm 党组织代码
     * @param ldjtjc 领导集体届次
     * @param dzzmc 党支部名称
     * @param xjfs 选举方式
     * @param gjjmrqBegin 该届届满日期
     * @param gjjmrqEnd 该届届满日期
     * @param zzfbType
     * @param ssdzzdm
     * @param zzlb
     * @param jczzfl
     * @param sfzdjc
     * @return
     */
    PageInfo<HashMap<String, Object>> getGradeList(int pageNum, int pageSize, String dzzdm, String ldjtjc, String dzzmc, String xjfs,
                                                   String gjjmrqBegin, String gjjmrqEnd, Integer zzfbType, String ssdzzdm, List<String> zzlb, List<String> jczzfl, Integer sfzdjc);

    /**
     * 根据党组织代码查询配置的届次信息
     * @param dzzdm
     * @return
     */
    List<ZzBzjcxx> getGradeListByDzzdm(String dzzdm);

    /**
     * 查询届次信息
     * @param id
     * @return
     */
    ZzBzjcxx getGradeById(String id);

    /**
     * 查询副表信息
     * @param id
     * @return
     */
    ZzBzjcxxfb getGradeFbById(String id);


    /**
     * 保存届次信息
     * @param zzBzjcxx
     * @param zzBzjcxxfb
     * @return
     */
    int saveGrade(ZzBzjcxx zzBzjcxx, ZzBzjcxxfb zzBzjcxxfb) throws Exception;

    /**
     * 删除届次信息
     * @param id
     * @return
     */
    int deleteGradeById(String id);

    /**
     * 查询领导班子成员
     * @param pageNum
     * @param pageSize
     * @param dzzdm
     * @param ldjtjc
     * @param dzzmc
     * @param xm
     * @param zwmc
     * @param rzfs
     * @param onlyshowDw
     * @param zzfbType
     * @param ssdzzdm
     * @param zzjzqk
     * @param isMaxJc
     * @return
     */
    PageInfo<HashMap<String, Object>> getGradeUserList(int pageNum, int pageSize, String dzzdm, String ldjtjc, String dzzmc, String xm,
                                                       List<String> zwmc, String rzfs, Integer onlyshowDw, Integer zzfbType, String ssdzzdm, String zzjzqk, Integer isMaxJc);

    /**
     * 查询最大届次领导班子成员
     * @param pageNum
     * @param pageSize
     * @param dzzdm
     * @param ldjtjc
     * @param dzzmc
     * @param xm
     * @param zwmc
     * @param rzfs
     * @param onlyshowDw
     * @param zzfbType
     * @param ssdzzdm
     * @param rybm
     * @return
     */
    PageInfo<HashMap<String, Object>> getMaxGradeUserList(int pageNum, int pageSize, String dzzdm, String ldjtjc, String dzzmc, String xm,
                                                       String zwmc, String rzfs, Integer onlyshowDw,Integer zzfbType,String ssdzzdm,String rybm);

    /**
     * 查询班子成员信息
     * @param id
     * @return
     */
    ZzBzcyxx getGradeUserById(String id);

    /**
     * 保存班子成员信息
     * @param zzBzcyxx
     * @return
     */
    int saveGradeUser(ZzBzcyxx zzBzcyxx);

    /**
     * 删除班子届次成员
     * @param id
     * @return
     */
    int deleteGradeUserById(String id);


    /**
     * 更新
     * @return
     */
    int updatePartySchjsj();

    PageInfo<HashMap<String, Object>> getMaxGradeList(int pageNum, int pageSize, String dzzdm, Integer year,String childDzzdm);

    List<HashMap<String, Object>> getReplaceTotalList(String dzzdm, Integer year);


}
