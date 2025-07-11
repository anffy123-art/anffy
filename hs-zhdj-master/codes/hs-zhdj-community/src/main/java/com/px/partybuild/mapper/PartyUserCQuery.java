package com.px.partybuild.mapper;

import com.px.partybuild.vo.PartyUserInfoVo;
import com.px.partybuild.vo.UserLeaderTotalVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 党员信息
 *
 * @author H
 */
@Repository
public interface PartyUserCQuery {

    /**
     * 党员信息
     *
     * @param dzzdm
     * @param rybm
     * @param xb
     * @param xm
     * @param zzlb
     * @param zwjb
     * @param sqrdrq_begin
     * @param sqrdrq_end
     * @param szdzb
     * @param szdxz
     * @param userIdList
     * @param ryztList
     * @param removeUserList
     * @param szdzbdm
     * @param removeUsersOfRybmList
     * @param rybmList
     * @param zzfbType
     * @param mz
     * @param dnzw
     * @param xl
     * @param age_begin
     * @param age_end
     * @param sfsldry
     * @param zwmc
     * @param sfzg
     * @param jczzfl
     * @param islead
     * @return
     */
    List<HashMap<String, Object>> selectPartyUserList(@Param("dzzdm") String dzzdm, @Param("rybm") String rybm, @Param("xb") String xb, @Param("xm") String xm, @Param("zzlb") String zzlb,
                                                      @Param("zwjb") String zwjb, @Param("sqrdrq_begin") String sqrdrq_begin, @Param("sqrdrq_end") String sqrdrq_end,
                                                      @Param("szdzb") String szdzb, @Param("szdxz") String szdxz,
                                                      @Param("userIdList") List<String> userIdList, @Param("ryztList") List<String> ryztList, @Param("removeUserList") List<String> removeUserList,
                                                      @Param("szdzbdm") String szdzbdm, @Param("removeUsersOfRybmList") List<String> removeUsersOfRybmList, @Param("rybmList") List<String> rybmList
            , @Param("zzfbType") Integer zzfbType,
                                                      @Param("mz") String mz, @Param("dnzw") String dnzw, @Param("xl") String xl, @Param("age_begin") Integer age_begin, @Param("age_end") Integer age_end,
                                                      @Param("sfsldry") Integer sfsldry, @Param("zwmc") String zwmc, @Param("sfzg") Integer sfzg,
                                                      @Param("jczzfl") String jczzfl, @Param("islead") Boolean islead, @Param("partyGroupId") String partyGroupId, @Param("mobile") String mobile, @Param("sfzh") String sfzh,@Param("isStudent")Integer isStudent,@Param("leaderTeamUserType") Integer leaderTeamUserType);

    /**
     * 所有党员信息
     *
     * @param dzzdm
     * @param rybm
     * @param xm
     * @param szdzbdm
     * @return
     */
    List<HashMap<String, Object>> selectAllUserList(@Param("dzzdm") String dzzdm, @Param("szdzbdm") String szdzbdm, @Param("zzlb") String zzlb, @Param("rybm") String rybm, @Param("xm") String xm, @Param("xb") String xb, @Param("mz") String mz, @Param("xl") String xl, @Param("mobile") String mobile, @Param("ryztList") List<String> ryztList,@Param("userNo")String userNo);


    List<HashMap<String,Object>> selectAllUserByNameAndMobileList(@Param("userNameAndMobileList") List<String> userNameAndMobileList);


    /**
     * 党小组成员
     *
     * @param dzzdm
     * @param rybm
     * @param xm
     * @param zzlb
     * @param zwjb
     * @param sqrdrq_begin
     * @param sqrdrq_end
     * @param szdzb
     * @param szdxz
     * @param removeUserList
     * @param removeUsersOfRybmList
     * @return
     */
    List<HashMap<String, Object>> selectDxzUserList(@Param("dzzdm") String dzzdm, @Param("rybm") String rybm, @Param("xm") String xm, @Param("zzlb") String zzlb,
                                                    @Param("zwjb") String zwjb, @Param("sqrdrq_begin") String sqrdrq_begin, @Param("sqrdrq_end") String sqrdrq_end,
                                                    @Param("szdzb") String szdzb, @Param("szdxz") String szdxz, @Param("removeUserList") List<String> removeUserList,
                                                    @Param("removeUsersOfRybmList") List<String> removeUsersOfRybmList);

    /**
     * 党组织变更
     *
     * @param rybm
     * @param xm
     * @param zlzbrq_begin
     * @param zlzbrq_end
     * @param dzzdm
     * @param zzfbType
     * @return
     */
    List<HashMap<String, Object>> selectUserChangeDzzList(@Param("rybm") String rybm, @Param("xm") String xm, @Param("zlzbrq_begin") String zlzbrq_begin, @Param("zlzbrq_end") String zlzbrq_end, @Param("dzzdm") String dzzdm, @Param("zzfbType") Integer zzfbType);


    /**
     * 查询未入党的职工基本信息
     *
     * @param rybm
     * @param xm
     * @return
     */
    List<HashMap<String, Object>> selectWsdzgjbxxList(@Param("rybm") String rybm, @Param("xm") String xm);


    /**
     * 支委会开会领导成员
     *
     * @param dzzdm
     * @param szdzbdm
     * @param rybm
     * @param xm
     * @param userIdList
     * @param removeUserList
     * @param removeUsersOfRybmList
     * @return
     */
    List<HashMap<String, Object>> selectLeaderUserList(@Param("dzzdm") String dzzdm, @Param("szdzbdm") String szdzbdm, @Param("rybm") String rybm, @Param("xm") String xm,
                                                       @Param("userIdList") List<String> userIdList, @Param("removeUserList") List<String> removeUserList,
                                                       @Param("removeUsersOfRybmList") List<String> removeUsersOfRybmList);

    /**
     * 查询下级组织人员数量
     *
     * @param parentCode
     * @return
     */
    List<HashMap<String, Object>> selectPatyUserNumber(@Param("parentCode") String parentCode);


    /**
     * 查询下级组织人员数量
     *
     * @param rybm
     * @return
     */
    List<HashMap<String, Object>> selectMZPYList(@Param("rybm") String rybm);

    /**
     * 查询培训情况
     *
     * @param rybm
     * @return
     */
    List<HashMap<String, Object>> selectPXQKList(@Param("rybm") String rybm);


    /**
     * 党员信息
     *
     * @param dzzdm
     * @param dzzmc
     * @param xm
     * @param csrq_begin
     * @param csrq_end
     * @param rdsj_begin
     * @param rdsj_end
     * @param zzsj_begin
     * @param zzsj_end
     * @param jg
     * @param dnzw
     * @param xzzw
     * @param jszw
     * @param xl
     * @param xb
     * @param gwzt
     * @param zzmm
     * @param mz
     * @param pxpy_year
     * @param pxpy_level
     * @param pxpy_type
     * @param sfzyxq
     * @param islead
     * @return
     */
    List<HashMap<String, Object>> selectPartyUserListForSearch(@Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc, @Param("xm") String xm, @Param("csrq_begin") String csrq_begin, @Param("csrq_end") String csrq_end,
                                                               @Param("rdsj_begin") String rdsj_begin, @Param("rdsj_end") String rdsj_end, @Param("zzsj_begin") String zzsj_begin, @Param("zzsj_end") String zzsj_end,
                                                               @Param("jg") String jg, @Param("dnzw") List<String> dnzw, @Param("xzzw") List<String> xzzw, @Param("jszw") List<String> jszw,
                                                               @Param("xl") List<String> xl, @Param("xb") List<String> xb, @Param("gwzt") List<String> gwzt,
                                                               @Param("zzmm") List<String> zzmm, @Param("mz") List<String> mz, @Param("pxpy_year") Integer pxpy_year, @Param("pxpy_level") Integer pxpy_level, @Param("pxpy_type") List<Integer> pxpy_type, @Param("sfzyxq") Integer sfzyxq
            , @Param("islead") Boolean islead, @Param("age_begin") Integer age_begin, @Param("age_end") Integer age_end);


    /**
     * 领导人员联系点信息
     *
     * @param rybm
     * @return
     */
    List<HashMap<String, Object>> selectUserContactpoint(@Param("rybm") String rybm);

    /**
     * 组织名称
     *
     * @param bm
     * @return
     */
    HashMap<String, Object> getZZZD_ZZQK_Name(@Param("bm") String bm);

    List<HashMap<String, Object>> selectUserListByName(@Param("userNameList") List<String> userNameList);

    PartyUserInfoVo selectUserInfo(@Param("rybm") String rybm);

    List<UserLeaderTotalVo> selectUserLeaderTotalList(@Param("rybm") String rybm, @Param("year") Integer year, @Param("quarter") Integer quarter);

    int deleteZzRyjbxx(@Param("userCode") String userCode);

    int deleteDjxx(@Param("userCode") String userCode);

    int deleteGgZgjbxx(@Param("userCode") String userCode);

    int deleteRyjbxxfb(@Param("userCode") String userCode);

    int deleteUserRole(@Param("userCode") String userCode);

    int deleteUser(@Param("userCode") String userCode);

    HashMap<String, Object> selectPartyUserSingleExt(@Param("rybm") String rybm);

    Integer batchInsertUserPartyOfMonth(@Param("yearMonth") Integer yearMonth);

    Integer batchUpdateUserPartyOfMonth(@Param("yearMonth") Integer yearMonth);

}
