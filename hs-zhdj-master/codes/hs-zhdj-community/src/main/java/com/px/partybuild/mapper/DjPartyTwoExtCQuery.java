package com.px.partybuild.mapper;

import com.px.partybuild.model.DjGdwydqk;
import com.px.partybuild.model.DjWxgroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DjPartyTwoExtCQuery {

    List<Map<String,Object>> resultmgListQuery(@Param("partyCode")String partyCode ,@Param("name") String name,@Param("beginTime") String beginTime,@Param("endTime") String endTime,@Param("zzfbType") Integer zzfbType);

    List<Map<String,Object>> DjBrandListQuery(@Param("partyCode")String partyCode ,@Param("pbrandName") String pbrandName,@Param("creatType") Integer creatType,@Param("beginTime") String beginTime,@Param("endTime") String endTime,@Param("zzfbType") Integer zzfbType);

    List<Map<String,Object>> DjPartyActivityRoomListQuery(@Param("partyCode")String partyCode ,@Param("addr") String addr,@Param("useRange") Integer useRange,@Param("zzfbType") Integer zzfbType);

    List<Map<String,Object>> DjWxGroupListQuery(@Param("partyCode") String partyCode,@Param("groupName") String groupName,@Param("partyName") String partyName,@Param("implatform") Integer implatform,@Param("grouperName")String grouperName,@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("zzfbType") Integer zzfbType,@Param("scaleBegin")Integer scaleBegin,@Param("scaleEnd") Integer scaleEnd);

    List<Map<String,Object>> DjWxGroupUserListQuery(@Param("wxGroupId") String wxGroupId);

    long selectBrandCount(@Param("partyCode")String partyCode ,@Param("creatType") Integer creatType);

    int batchInsertWxgroup(@Param("wxgroupList") List<DjWxgroup> wxgroupList);

    List<Map<String,Object>> selectGdwydqkList(@Param("dzzmc") String dzzmc,@Param("yearmonth") String yearmonth,@Param("groupId") String groupId);

    int batchInsertGdwydqk(@Param("gdwydqkList") List<DjGdwydqk> gdwydqkList);
}
