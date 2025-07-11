package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.*;
import com.px.partybuild.vo.PartyUserInfoVo;
import com.px.partybuild.vo.UserInfoVo;
import com.px.partybuild.vo.UserLeaderTotalVo;

import java.util.HashMap;
import java.util.List;

/**
 * 党员信息
 *
 * @author H
 */
public interface PartyUserService {

    /**
     * 获取党员信息
     * @param pageNum
     * @param pageSize
     * @param xb
     * @param dzzdm
     * @param rybm
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
     * @param curUserId
     * @return
     */
    PageInfo<HashMap<String, Object>> getPartyUserList(int pageNum, int pageSize, String xb,
                                                       String dzzdm, String rybm, String xm, String zzlb,
                                                       String zwjb, String sqrdrq_begin, String sqrdrq_end, String szdzb, String szdxz,
                                                       List<String> userIdList, List<String> ryztList, List<String> removeUserList, String szdzbdm, List<String> removeUsersOfRybmList, List<String> rybmList, Integer zzfbType,
                                                       String mz, String dnzw, String xl,
                                                       Integer age_begin, Integer age_end, Integer sfsldry, String zwmc, Integer sfzg, String jczzfl, String curUserId,String partyGroupId,String mobile,Integer isStudent,Integer leaderTeamUserType);

    PageInfo<HashMap<String, Object>> getAllUserList(int pageNum, int pageSize, String dzzdm, String szdzbdm, String zzlb, String rybm, String xm, String xb, String mz, String xl, String mobile,List<String> ryztList,String userNo);


    /**
     * 党员信息（预备党员、正式党员）
     * @param rybm
     * @return
     */
    HashMap<String, Object> getPartyUserInfoByRybm(String rybm);

    /**
     * 党员信息（预备党员、正式党员）
     * @param name
     * @param sfzh
     * @return
     */
    HashMap<String, Object> getPartyUserInfoByNameAndSfzh(String name, String sfzh);

    /**
     * 党员信息（包含入党申请人）
     * @param rybm
     * @return
     */
    HashMap<String, Object> getPartyUserExt(String rybm);

    /**
     * 查询人员党组织代码
     * @param rybm
     * @return
     */
    String getUserDzzdm(String rybm);

    /**
     * 查询党员基本信息（站内）
     * @param id
     * @return
     */
    ZzRyjbxx getPartyUserByIdZn(String id);

    /**
     * 查询党员基本信息
     * @param rybm
     * @return
     */
    ZzRyjbxx getPartyUserByRybmZn(String rybm);

    /**
     * 查询党员基本信息（站内）
     * @param id
     * @return
     */
    GgZgjbxx getPartyUserByIdRs(String id);

    /**
     * 查询党员基本信息（路外）
     * @param id
     * @return
     */
    ZzRyjbxxLw getPartyUserByIdLw(String id);

    /**
     * 查询党员基本信息（路外）
     * @param rybm
     * @return
     */
    ZzRyjbxxLw getPartyUserByRybmLw(String rybm);

    /**
     * 保存党员基本信息（站内）
     * @param zzRyjbxx
     * @return
     */
    int savePartyUserZn(ZzRyjbxx zzRyjbxx);

    /**
     * 保存党员基本信息（路外）
     * @param zzRyjbxxLw
     * @return
     */
    int savePartyUserLw(ZzRyjbxxLw zzRyjbxxLw);

    /**
     * 删除党员基本信息（站内）
     * @param rybm
     * @return
     */
    int deletePartyUser(String rybm);


    /**
     * 获取小组成员信息
     * @param pageNum
     * @param pageSize
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
    PageInfo<HashMap<String, Object>> getDxzUserList(int pageNum, int pageSize,
                                                     String dzzdm, String rybm, String xm, String zzlb,
                                                     String zwjb, String sqrdrq_begin, String sqrdrq_end, String szdzb, String szdxz, List<String> removeUserList, List<String> removeUsersOfRybmList);

    /**
     * 查询成员党组织转接信息
     * @param pageNum
     * @param pageSize
     * @param rybm
     * @param xm
     * @param zlzbrq_begin
     * @param zlzbrq_end
     * @param dzzdm
     * @param zzfbType
     * @return
     */
    PageInfo<HashMap<String, Object>> getUserChangeDzzList(int pageNum, int pageSize,
                                                           String rybm, String xm, String zlzbrq_begin, String zlzbrq_end, String dzzdm, Integer zzfbType);


    /**
     * 变更组织信息
     * @param id
     * @return
     */
    ZzZzgxxx getUserChangeById(String id);

    /**
     * 保存变更组织信息
     * @param zzZzgxxx
     * @return
     */
    int saveUserChange(ZzZzgxxx zzZzgxxx);

    int auditChange(List<String> idList,Boolean isPass);

    /**
     * 删除变更信息
     * @param id
     * @return
     */
    int deleteUserChangeById(String id);

    /**
     * 查询未入党的职工基本信息
     * @param pageNum
     * @param pageSize
     * @param rybm
     * @param xm
     * @return
     */
    PageInfo<HashMap<String, Object>> getWsdzgjbxxList(int pageNum, int pageSize,
                                                       String rybm, String xm);


    /**
     * 支委会开会领导成员
     * @param pageNum
     * @param pageSize
     * @param dzzdm
     * @param szdzbdm
     * @param rybm
     * @param xm
     * @param userIdList
     * @param removeUserList
     * @param removeUsersOfRybmList
     * @return
     */
    PageInfo<HashMap<String, Object>> getLeaderUserList(int pageNum, int pageSize,
                                                        String dzzdm,
                                                        String szdzbdm, String rybm, String xm,
                                                        List<String> userIdList, List<String> removeUserList, List<String> removeUsersOfRybmList);

    /**
     * 人员副表信息
     * @param rybm
     * @return
     */
    RsRyjbxxfb getUserFbInfo(String rybm);

    /**
     * 党籍信息
     * @param rybm
     * @return
     */
    ZzDjxx getUserDjxxById(String rybm);

    /**
     * 党籍信息
     * @param rybm
     * @return
     */
    ZzDjxxfb getUserDjxxFBById(String rybm);


    /**
     * 保存党员信息
     * @param rsRyjbxxfb
     * @param zzDjxx
     * @param zzDjxxfb
     * @param lxdDzzdmList
     * @return
     */
    int savePartyUser(GgZgjbxx ggZgjbxx,ZzRyjbxx zzRyjbxx ,RsRyjbxxfb rsRyjbxxfb, ZzDjxx zzDjxx);

    /**
     * 民主评议
     * @param pageNum
     * @param pageSize
     * @param rybm
     * @return
     */
    PageInfo<HashMap<String, Object>> getMzpyList(int pageNum, int pageSize, String rybm);

    /**
     * 获取培训情况列表
     * @param pageIndex
     * @param pageSize
     * @param rybm
     * @return
     */
    PageInfo<HashMap<String, Object>> getPxqkList(int pageIndex, int pageSize, String rybm);

    /**
     * 党员信息
     * @param pageNum
     * @param pageSize
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
     * @param curUserId
     * @return
     */
    PageInfo<HashMap<String, Object>> getPartyUserListForSearch(int pageNum, int pageSize,
                                                                String dzzdm,String dzzmc, String xm, String csrq_begin, String csrq_end,
                                                                String rdsj_begin, String rdsj_end, String zzsj_begin, String zzsj_end,
                                                                String jg, List<String> dnzw, List<String> xzzw, List<String> jszw,
                                                                List<String> xl, List<String> xb, List<String> gwzt,
                                                                List<String> zzmm, List<String> mz, Integer pxpy_year, Integer pxpy_level, List<Integer> pxpy_type, Integer sfzyxq,String curUserId,Integer age_begin, Integer age_end);


    /**
     * 联系点信息
     * @param rybm
     * @return
     */
    List<HashMap<String, Object>> getUserContactpoint(String rybm);

    /**
     * 转正情况
     * @param bm
     * @return
     */
    HashMap<String,Object> getzzzdZzqkName(String bm );


    /**
     * 所有党员信息
     * @param rybm
     * @return
     */
    HashMap<String, Object> getAllUserInfoByRybm(String rybm);


    PartyUserInfoVo getUserInfo(String rybm);

    List<UserLeaderTotalVo> getUserLeaderTotalList(String rybm, Integer year, Integer quarter);

    List<UserInfoVo> importUser(List<UserInfoVo> dataList) throws Exception;

    List<CfUsers> getCfUsersList(List<String> ids);
    List<CfUsers> getCfUsersListByLoginId(List<String> ids);
    List<GgZgjbxx> getGgZgjbxxList(List<String> ids);
    List<ZzRyjbxx> getZzRyjbxxList(List<String> ids);
    List<ZzDjxx> getZzDjxxList(List<String> ids);
    List<ZzZzqkxx> getZzZzqkxxList(List<String> ids);
    List<ZzZzqkxx> getZzZzqkxxByNameList(List<String> names);
    List<RsRyjbxxfb> getRsRyjbxxfbList(List<String> ids);
    List<CfUserrolesKey> getCfUserroleList(List<String> ids);

    Integer batchInsertUserPartyOfMonth(Integer yearMonth);

    /*Integer batchUpdateUserPartyOfMonth(Integer yearMonth);*/

}
