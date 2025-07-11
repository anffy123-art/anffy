package com.px.partybuild.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 领导班子
 *
 * @author H
 */
@Repository
public interface GradeCQuery {

    /**
     * 查询换届选举配置
     * @param dzzdm
     * @param ldjtjc
     * @param dzzmc
     * @param xjfs
     * @param gjjmrq_begin
     * @param gjjmrq_end
     * @param zzfbType
     * @param ssdzzdm
     * @param zzlb
     * @param jczzfl
     * @param sfzdjc
     * @return
     */
    List<HashMap<String, Object>> selectGradeList(@Param("dzzdm") String dzzdm, @Param("ldjtjc") String ldjtjc, @Param("dzzmc") String dzzmc, @Param("xjfs") String xjfs,
                                                  @Param("gjjmrq_begin") String gjjmrq_begin, @Param("gjjmrq_end") String gjjmrq_end, @Param("zzfbType") Integer zzfbType, @Param("ssdzzdm") String ssdzzdm
            , @Param("zzlb") List<String> zzlb, @Param("jczzfl") List<String> jczzfl, @Param("sfzdjc") Integer sfzdjc);

    /**
     * 领导成员
     * @param dzzdm
     * @param ldjtjc
     * @param dzzmc
     * @param xm
     * @param zwmc
     * @param rzfs
     * @param onlyshow_dw
     * @param zzfbType
     * @param ssdzzdm
     * @param zzjzqk
     * @param isMaxJc
     * @return
     */
    List<HashMap<String, Object>> selectGradeUserList(@Param("dzzdm") String dzzdm, @Param("ldjtjc") String ldjtjc, @Param("dzzmc") String dzzmc,
                                                      @Param("xm") String xm, @Param("zwmc") List<String> zwmc, @Param("rzfs") String rzfs,
                                                      @Param("onlyshow_dw") Integer onlyshow_dw, @Param("zzfbType") Integer zzfbType, @Param("ssdzzdm") String ssdzzdm, @Param("zzjzqk") String zzjzqk, @Param("isMaxJc") Integer isMaxJc);

    /**
     * 最大届次成员
     * @param dzzdm
     * @param ldjtjc
     * @param dzzmc
     * @param xm
     * @param zwmc
     * @param rzfs
     * @param onlyshow_dw
     * @param zzfbType
     * @param ssdzzdm
     * @param rybm
     * @return
     */
    List<HashMap<String, Object>> selectMaxGradeUserList(@Param("dzzdm") String dzzdm, @Param("ldjtjc") String ldjtjc, @Param("dzzmc") String dzzmc,
                                                         @Param("xm") String xm, @Param("zwmc") String zwmc, @Param("rzfs") String rzfs,
                                                         @Param("onlyshow_dw") Integer onlyshow_dw, @Param("zzfbType") Integer zzfbType, @Param("ssdzzdm") String ssdzzdm, @Param("rybm") String rybm);

    /**
     * 最大届次时间
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> selectMaxJCSJList(@Param("dzzdm") String dzzdm);

    /**
     * 最大届次信息
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> selectMaxJCList(@Param("dzzdm") String dzzdm);

    List<HashMap<String,Object>> selectMaxGradeList(@Param("dzzdm") String dzzdm,@Param("year") Integer year,@Param("childDzzdm")String childDzzdm);

    List<HashMap<String,Object>> selectReplaceTotalList(@Param("dzzdm") String dzzdm,@Param("year") Integer year);

}
