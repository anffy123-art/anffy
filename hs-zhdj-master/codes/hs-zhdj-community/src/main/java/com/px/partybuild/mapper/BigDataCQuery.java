package com.px.partybuild.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 大数据
 *
 * @author H
 */
@Repository
public interface BigDataCQuery {
    /**
     * 统计党分布信息
     *
     * @return
     */
    List<HashMap<String, Object>> selectDzzfbqkList();

    /**
     * 统计党组织信息
     *
     * @param gddwdm
     * @param province
     * @return
     */
    HashMap<String, Object> selectDzzxxCount(@Param("gddwdm") String gddwdm, @Param("province") String province);

    /**
     * 统计党委信息
     *
     * @param gddwdm
     * @return
     */
    HashMap<String, Object> selectDwxxCount(@Param("gddwdm") String gddwdm);

    /**
     * 统计党员数量
     *
     * @param gddwdm
     * @return
     */
    List<HashMap<String, Object>> selectDyCount(@Param("gddwdm") String gddwdm);

    /**
     * 统计党员性别
     *
     * @param gddwdm
     * @param dzzdm
     * @param dwgzzlb
     * @param isOnduty
     * @return
     */
    List<HashMap<String, Object>> selectDyxbCount(@Param("gddwdm") String gddwdm, @Param("dzzdm") String dzzdm, @Param("dwgzzlb") Integer dwgzzlb, @Param("isOnduty") Integer isOnduty);

    /**
     * 统计党员年龄
     *
     * @param gddwdm
     * @param dzzdm
     * @param dwgzzlb
     * @param isOnduty
     * @return
     */
    List<HashMap<String, Object>> selectDynlCount(@Param("gddwdm") String gddwdm, @Param("dzzdm") String dzzdm, @Param("dwgzzlb") Integer dwgzzlb, @Param("isOnduty") Integer isOnduty);

    /**
     * 统计党员党龄
     *
     * @param gddwdm
     * @param dzzdm
     * @param dwgzzlb
     * @param isOnduty
     * @return
     */
    List<HashMap<String, Object>> selectDydlCount(@Param("gddwdm") String gddwdm, @Param("dzzdm") String dzzdm, @Param("dwgzzlb") Integer dwgzzlb, @Param("isOnduty") Integer isOnduty);

    /**
     * 统计政工职务党员
     *
     * @param dzzdm
     * @param dwgzzlb
     * @return
     */
    List<HashMap<String, Object>> selectZgzwCount(@Param("dzzdm") String dzzdm, @Param("dwgzzlb") Integer dwgzzlb);

    /**
     * 正式和预备党员统计图
     *
     * @param partyGroup
     * @param isOnduty
     * @return
     */
    List<Map<String, Object>> CountRYZT(@Param("partyGroup") String partyGroup, @Param("isOnduty") Integer isOnduty);

    /**
     * 统计党员学历
     *
     * @param dzzdm
     * @param dwgzzlb
     * @param isOnduty
     * @return
     */
    List<Map<String, Object>> selectUserEducationList(@Param("dzzdm") String dzzdm, @Param("dwgzzlb") Integer dwgzzlb, @Param("isOnduty") Integer isOnduty);

    /**
     * 统计三会一课
     *
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> selectShykCount(@Param("dzzdm") String dzzdm);

    /**
     * 党组织信息
     *
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> selectDzzxxList(@Param("dzzdm") String dzzdm);

    /**
     * 党员信息
     *
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> selectDyxxList(@Param("dzzdm") String dzzdm);


    /**
     * 统计数据（党员数量、三会一课数量、中心组学习数量）
     *
     * @param gddwdm
     * @param zzfbType
     * @param beginTime
     * @param endTime
     * @return
     */
    List<HashMap<String, Object>> selectAllDataTotal(@Param("gddwdm") String gddwdm, @Param("zzfbType") Integer zzfbType, @Param("beginTime") String beginTime, @Param("endTime") String endTime);

    /**
     * 发展党员
     *
     * @param ndList
     * @return
     */
    List<HashMap<String, Object>> selectDYFZQKTotalList(@Param("ndList") List<Integer> ndList);

    /**
     * 党组织数量
     *
     * @param gddwdm
     * @param dzzdm
     * @param ssdzzdm
     * @return
     */
    List<HashMap<String, Object>> selectPartyCountList(@Param("gddwdm") String gddwdm, @Param("dzzdm") String dzzdm, @Param("ssdzzdm") String ssdzzdm);

    /**
     * 领导人员5+3
     *
     * @param userCode
     * @param year
     * @return
     */
    List<HashMap<String, Object>> selectUserLeaderTotalList(@Param("userCode") String userCode, @Param("year") String year);

    /**
     * 中心组学习
     *
     * @param userCode
     * @return
     */
    List<HashMap<String, Object>> selectUserZXZXXTotalList(@Param("userCode") String userCode);

    /**
     * 党员统计
     *
     * @param dzzdm
     * @return
     */
    HashMap<String, Object> selectPartyUserTotalList(@Param("dzzdm") String dzzdm);

    /**
     * 创岗建区
     *
     * @param dzzdm
     * @param ssdzzdm
     * @param year
     * @return
     */
    HashMap<String, Object> selectCGJQTotal(@Param("dzzdm") String dzzdm, @Param("ssdzzdm") String ssdzzdm, @Param("year") Integer year);

    /**
     * 创岗建区
     *
     * @param dzzdm
     * @param ssdzzdm
     * @param year
     * @return
     */
    List<HashMap<String, Object>> selectCGJQTotalList(@Param("dzzdm") String dzzdm, @Param("ssdzzdm") String ssdzzdm, @Param("year") Integer year);

    /**
     * 发展党员
     *
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> selectPartyUserExpendTotalList(@Param("dzzdm") String dzzdm);

    /**
     * 中心组学习
     *
     * @param dzzdm
     * @param ssdzzdm
     * @param year
     * @return
     */
    List<HashMap<String, Object>> selectZXZXXTotal(@Param("dzzdm") String dzzdm, @Param("ssdzzdm") String ssdzzdm, @Param("year") Integer year);

    //考评信息统计
    List<HashMap<String, Object>> selectDjkpxxTotalList(@Param("year") Integer year);

    //品牌信息统计
    List<HashMap<String, Object>> selectBrandTotalList();

    //纪律处分信息
    List<HashMap<String, Object>> selectJlcfxxTotalList();

    List<HashMap<String, Object>> selectPartyUserStatusTotalList();

    List<HashMap<String, Object>> selectZzpxqkList();

    List<HashMap<String, Object>> selectDnpxxxTotalList();

    List<HashMap<String, Object>> selectPartyBrandTotalList();

    List<HashMap<String, Object>> selectSzpyTotalList();

    List<HashMap<String, Object>> selectDnghbfTotalList();

    List<HashMap<String, Object>> selectZtdrTotalList(Integer year);

}
