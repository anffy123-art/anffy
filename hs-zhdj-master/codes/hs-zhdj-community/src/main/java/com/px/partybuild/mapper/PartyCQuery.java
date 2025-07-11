package com.px.partybuild.mapper;

import com.px.partybuild.vo.PartyInfoVo;
import com.px.partybuild.vo.TreeVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 党组织信息
 *
 * @author H
 */
@Repository
public interface PartyCQuery {

    /**
     * 党组织树
     * @param parentCode
     * @param dzzdm
     * @param showlevel
     * @param levelParent
     * @return
     */
    List<HashMap<String, Object>> selectPartyTreeList(@Param("parentCode") String parentCode, @Param("dzzdm") String dzzdm, @Param("showlevel") Integer showlevel,
                                                      @Param("levelParent") List<Integer> levelParent);

    /**
     * 党组织信息
     * @param gddwdm
     * @param parentCode
     * @param dzzmc
     * @param dzzdm
     * @param zzlb
     * @param jczzfl
     * @param jldzzrq_begin
     * @param jldzzrq_end
     * @param isContainParent
     * @param zzfbType
     * @param hjYear 换届年度
     * @param zzlbStrList
     * @param ssdzzdm
     * @param dwjb
     * @param jmrq_begintime
     * @param jmrq_endtime
     * @return
     */
    List<HashMap<String, Object>> selectPartyList(@Param("gddwdm") String gddwdm, @Param("parentCode") String parentCode, @Param("dzzmc") String dzzmc, @Param("dzzdm") String dzzdm,
                                                  @Param("zzlb") String zzlb, @Param("jczzfl") String jczzfl, @Param("jldzzrq_begin") String jldzzrq_begin,
                                                  @Param("jldzzrq_end") String jldzzrq_end, @Param("isContainParent") String isContainParent, @Param("zzfbType") Integer zzfbType, @Param("hjYear") Integer hjYear, @Param("zzlbStrList") List<String> zzlbStrList,
                                                  @Param("ssdzzdm") String ssdzzdm, @Param("dwjb") Integer dwjb, @Param("jmrq_begintime") String jmrq_begintime, @Param("jmrq_endtime") String jmrq_endtime,
                                                  @Param("jczzflList") List<String> jczzflList,@Param("partyGroupId") String partyGroupId,@Param("notIncludeDzzdmList") List<String> notIncludeDzzdmList);

    /**
     * 党组织信息
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> selectPartyInfoList(@Param("dzzdm") String dzzdm);

    /**
     * 党组织分组信息
     * @param dzzdm
     * @param onlyshow_dw
     * @return
     */
    List<HashMap<String, Object>> selectPartyGroupTreeList(@Param("dzzdm") String dzzdm, @Param("onlyshow_dw") Integer onlyshow_dw,@Param("parentId") String parentId);

    /**
     * 助理员信息
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> selectPartyZLYList(@Param("dzzdm") String dzzdm);

    /**
     * 下级党组织信息
     * @param dzzdm
     * @param ssdzzdm
     * @return
     */
    List<HashMap<String, Object>> selectChildPartyCount(@Param("dzzdm") String dzzdm, @Param("ssdzzdm") String ssdzzdm);

    /**
     * 党组织人员
     * @param dzzdm
     * @return
     */
    String selectPartyUserCount(@Param("dzzdm") String dzzdm);

    /**
     * 党组织树
     * @param parentCode
     * @param dzzdm
     * @param onlyshow_dw
     * @param showdxz
     * @return
     */
    List<HashMap<String, Object>> selectNewPartyTreeList(@Param("parentCode") String parentCode, @Param("dzzdm") String dzzdm,
                                                         @Param("onlyshow_dw") Integer onlyshow_dw, @Param("showdxz") Integer showdxz);

    /**
     * 党组织信息
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectPartyByDzzdm(@Param("dzzdmList") List<String> dzzdmList);


    /**
     * 后台处理党组织数据
     * @return
     */
    int handlePartyData();

    PartyInfoVo selectPartyInfo(@Param("dzzdm") String dzzdm);

    List<TreeVo> selectPartyForTreeList(@Param("gddwdm") String gddwdm,@Param("parentId") String parentId);

}
