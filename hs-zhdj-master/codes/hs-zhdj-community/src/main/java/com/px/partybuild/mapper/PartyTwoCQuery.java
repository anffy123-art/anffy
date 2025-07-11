package com.px.partybuild.mapper;

import com.px.partybuild.model.DjDnghbf;
import com.px.partybuild.model.DjDnghbfmx;
import com.px.partybuild.vo.DjJlcfxxVo;
import com.px.partybuild.vo.DjZtdrxxVo;
import com.px.partybuild.vo.DjZzsrVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PartyTwoCQuery {

    List<HashMap<String, Object>> selectDnpxxxList(@Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc, @Param("username") String username,
                                                   @Param("userid") String userid,
                                                   @Param("honourLevel") Integer honourLevel,
                                                   @Param("honourName") String honourName, @Param("beginTime") String beginTime,
                                                   @Param("endTime") String endTime, @Param("zzfbType") Integer zzfbType, @Param("pxlx") Integer pxlx, @Param("ssdzzdm") String ssdzzdm, @Param("honourType") Integer honourType);

    List<HashMap<String, Object>> selectDnghbfList(@Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc, @Param("username") String username,
                                                   @Param("userid") String userid,
                                                   @Param("careType") Integer careType, @Param("zzfbType") Integer zzfbType,
                                                   @Param("beginTime") String beginTime,
                                                   @Param("endTime") String endTime, @Param("helpformType") Integer helpformType);

    List<HashMap<String, Object>> selectDnghbfDetailsList(@Param("dnbfid") String dnbfid, @Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc, @Param("username") String username,
                                                          @Param("userid") String userid,
                                                          @Param("careType") Integer careType, @Param("zzfbType") Integer zzfbType);

    HashMap<String, Object> getDnghbfDetails(@Param("dnbfmxid") String dnbfmxid);

    List<DjZtdrxxVo> selectZtdrxxList(@Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc, @Param("title") String title,
                                      @Param("location") String location,
                                      @Param("subjectType") Integer subjectType, @Param("beginTime") String beginTime,
                                      @Param("endTime") String endTime, @Param("zzfbType") Integer zzfbType);

    List<DjZzsrVo> selectZzsrList(@Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc, @Param("title") String title,
                                  @Param("location") String location,
                                  @Param("subjectType") Integer subjectType, @Param("beginTime") String beginTime,
                                  @Param("endTime") String endTime, @Param("zzfbType") Integer zzfbType);

    List<HashMap<String, Object>> selectDjkpxxList(@Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc,
                                                   @Param("judgeLevel") Integer judgeLevel,
                                                   @Param("year") Integer year,
                                                   @Param("zzfbType") Integer zzfbType, @Param("ssdzzdm") String ssdzzdm, @Param("showdw") Integer showdw);

    List<HashMap<String, Object>> selectParyDjkpList(@Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc,
                                                     @Param("showdxz") Integer showdxz,
                                                     @Param("year") Integer year, @Param("showdw") Integer showdw, @Param("showdzb") Integer showdzb, @Param("selectdzzdmList") List<String> selectdzzdmList);

    List<DjJlcfxxVo> selectJlcfxxList(@Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc, @Param("username") String username,
                                      @Param("userid") String userid,
                                      @Param("offenceType") Integer offenceType,
                                      @Param("punishType") Integer punishType,
                                      @Param("beginTime") String beginTime,
                                      @Param("endTime") String endTime, @Param("zzfbType") Integer zzfbType);

    List<HashMap<String, Object>> selectTask(@Param("username") String username,
                                             @Param("taskuserid") String taskuserid,
                                             @Param("taskName") String taskName,
                                             @Param("beginTime") String beginTime,
                                             @Param("endTime") String endTime,
                                             @Param("day") String day,
                                             @Param("userid") String userid,
                                             @Param("isreceive") Integer isreceive);

    List<HashMap<String, Object>> selectPartyTotalInfo(@Param("dzzdm") String dzzdm,
                                                       @Param("yearMonth") String yearMonth,
                                                       @Param("year") String year);

    List<HashMap<String, Object>> selectfundsBudgetList(@Param("dzzdm") String dzzdm,
                                                        @Param("dzzmc") String dzzmc,
                                                        @Param("year") Integer year);

    List<HashMap<String, Object>> selectZtdrSummary(@Param("partyCode") String partyCode, @Param("year") Integer year);

    List<HashMap<String, Object>> selectMzpyxxList(@Param("username") String username,
                                                   @Param("rybm") String rybm,
                                                   @Param("dzzdm") String dzzdm,
                                                   @Param("beginTime") String beginTime,
                                                   @Param("endTime") String endTime,
                                                   @Param("pyjg") String pyjg);

    List<HashMap<String, Object>> selectMzpyjgList();

    List<HashMap<String, Object>> selectleaderUserList(@Param("username") String username,
                                                       @Param("usertype") Integer usertype);

    int batchInsertDnghbf(@Param("dnghbfList") List<DjDnghbf> dnghbfList);

    int batchInsertDnghbfmx(@Param("dnghbfmxList") List<DjDnghbfmx> dnghbfmxList);
}
