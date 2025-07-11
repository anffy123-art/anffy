package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.*;

import java.util.List;
import java.util.Map;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface PartyTwoExtService {

    /**
     * result list
     * @param pageIndex
     * @param pageSize
     * @param partyCode
     * @param name
     * @param beginTime
     * @param endTime
     * @param zzfbType
     * @return
     */
    PageInfo<Map<String,Object>> resultmgList(int pageIndex,int pageSize,String partyCode, String name, String beginTime,String endTime,Integer zzfbType);

    /**
     * reslut item
     * @param id
     * @return
     */
    DjResultmg getDjresultmgItem(String id);

    /**
     * result save
     * @param it
     * @return
     */
    int djresultmgSave(DjResultmg it);

    /**
     * result delete
     * @param id
     * @return
     */
    int djresultmgDel(String id);

    /**
     * brand list
     * @param pageIndex
     * @param pageSize
     * @param partyCode
     * @param pbrandName
     * @param creatType
     * @param beginTime
     * @param endTime
     * @param zzfbType
     * @return
     */
    PageInfo<Map<String,Object>> djBrandList(int pageIndex, int pageSize, String partyCode, String pbrandName, Integer creatType, String beginTime, String endTime, Integer zzfbType);

    /**
     * brand item
     * @param id
     * @return
     */
    DjBrand getDjBrandItem(String id);

    /**
     * brand save
     * @param it
     * @return
     */
    int djBrandSave(DjBrand it);

    /**
     * brand delete
     * @param id
     * @return
     */
    int djBrandDel(String id);

    /**
     * brand count
     * @param partyCode
     * @param creatType
     * @return
     */
    long getBrandCount(String partyCode, Integer creatType);

    /**
     * party room list
     * @param partyactivityroomid
     * @return
     */
    List<DjPartyactivityroomgroup> getDjPartyactivityroomgroupList(String partyactivityroomid);

    /**
     * party room list
     * @param pageIndex
     * @param pageSize
     * @param partyCode
     * @param addr
     * @param useRange
     * @param zzfbType
     * @return
     */
    PageInfo<Map<String,Object>> djPartyActivityRoomList(int pageIndex, int pageSize, String partyCode, String addr, Integer useRange, Integer zzfbType);

    /**
     * party room item
     * @param id
     * @return
     */
    DjPartyactivityroom getDjPartyActivityRoomItem(String id);

    /**
     * party room save
     * @param it
     * @param recordList
     * @return
     */
    int djPartyActivityRoomSave(DjPartyactivityroom it, DjPartyactivityroomgroup[] recordList);

    /**
     * party room delete
     * @param id
     * @return
     */
    int djPartyActivityRoomDel(String id);

    /**
     * wx group list
     * @param pageIndex
     * @param pageSize
     * @param partyCode
     * @param groupName
     * @param partyName
     * @param implatform
     * @param grouperName
     * @param beginTime
     * @param endTime
     * @param zzfbType
     * @param scaleBegin
     * @param scaleEnd
     * @return
     */
    PageInfo<Map<String,Object>> djWxGroupList(int pageIndex, int pageSize, String partyCode, String groupName, String partyName, Integer implatform, String grouperName, String beginTime, String endTime, Integer zzfbType, Integer scaleBegin, Integer scaleEnd);

    /**
     * wx group item
     * @param id
     * @return
     */
    DjWxgroup getDjWxGroupItem(String id);

    /**
     * wx group save
     * @param it
     * @return
     */
    int djWxGroupSave(DjWxgroup it);

    /**
     * wx group delete
     * @param id
     * @return
     */
    int djWxGroupDel(String id);

    /**
     * wx group user list
     * @param pageIndex
     * @param pageSize
     * @param wxGroupId
     * @return
     */
    PageInfo<Map<String,Object>> wxGroupUserList(int pageIndex, int pageSize, String wxGroupId);

    /**
     * wx group batch save
     * @param users
     * @param pid
     * @param updaterId
     * @param updaterName
     * @return
     */
    int wxGroupUserBatchSave(List<Map<String,Object>> users, String pid, String updaterId, String updaterName);

    /**
     * wx group item
     * @param id
     * @return
     */
    DjWxgroupuser getDjWxGroupUserItem(String id);

    /**
     * wx group user save
     * @param it
     * @return
     */
    int wxGroupUserSave(DjWxgroupuser it);

    /**
     * wx group user delete
     * @param id
     * @return
     */
    int wxGroupUserDel(String id);

    /**
     * wx group user delete
     * @param list
     * @return
     */
    List<Map<String, Object>> importWxGroup(List<Map<String, Object>> list) throws Exception;

    /**
     * getGdwydqkList
     * @param dzzmc
     * @return
     */
    PageInfo<Map<String,Object>> getGdwydqkList(int pageIndex,int pageSize,String dzzmc, String yearmonth,String groupId);

    /**
     * importGdwydqk
     * @param gdwydqklist
     * @return
     */
    List<Map<String, Object>> importGdwydqk(List<Map<String, Object>> gdwydqklist) throws Exception;

    /**
     * deleteGdwydqkList
     * @param ids
     * @return
     */
    int deleteGdwydqkList(List<String> ids);

    DjGdwydqk getGdwydqkById(String id);

}
