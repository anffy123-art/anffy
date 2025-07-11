package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.*;
import com.px.partybuild.model.*;
import com.px.partybuild.service.*;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author H
 * @date 2024-08
 */
@Service("partyTwoExtServiceImpl")
public class PartyTwoExtServiceImpl implements PartyTwoExtService {

    @Autowired
    private DjPartyTwoExtCQuery djPartyTwoExtCQuery;

    @Autowired
    DjResultmgMapper djResultmgMapper;

    @Autowired
    DjBrandMapper djBrandMapper;

    @Autowired
    DjPartyactivityroomMapper djPartyactivityroomMapper;

    @Autowired
    DjPartyactivityroomgroupMapper djPartyactivityroomgroupMapper;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    DjWxgroupMapper djWxgroupMapper;

    @Autowired
    DjGdwydqkMapper gdwydqkMapper;

    @Autowired
    DjWxgroupuserMapper djWxgroupuserMapper;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    private FileService fileService;
    @Autowired
    private UserService userService;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private PartyService partyService;

    @Override
    public PageInfo<Map<String, Object>> resultmgList(int pageIndex, int pageSize, String partyCode, String name, String beginTime, String endTime, Integer zzfbType) {

        PageHelper.startPage(pageIndex, pageSize);

        List<Map<String, Object>> list = djPartyTwoExtCQuery.resultmgListQuery(partyCode, name, beginTime, endTime, zzfbType);

        PageInfo<Map<String, Object>> result = new PageInfo(list);

        return result;
    }

    @Override
    public DjResultmg getDjresultmgItem(String id) {
        DjResultmg it = djResultmgMapper.selectByPrimaryKey(id);
        if (it == null || StringUtils.isBlank(id)) {
            it = new DjResultmg();
            it.setDjResultmgid(UUID.randomUUID().toString());
        }
        return it;
    }

    @Override
    public int djresultmgSave(DjResultmg it) {

        int result = 0;

        it.setOperatetime(new Date());
        it.setUpdatetime(new Date());
        it.setSyncstate("N");

        DjResultmg oIt = djResultmgMapper.selectByPrimaryKey(it.getDjResultmgid());

        if (oIt == null) {
            it.setCreatetime(new Date());
            it.setCreateuserid(it.getUpdateuserid());
            it.setCreateusername(it.getUpdateusername());
            it.setOperatestate("A");
            result = djResultmgMapper.insert(it);
        } else {
            it.setOperatestate("M");
            result = djResultmgMapper.updateByPrimaryKey(it);
        }


        return result;
    }

    @Override
    public int djresultmgDel(String id) {

        DjResultmg it = new DjResultmg();
        it.setDjResultmgid(id);
        it.setOperatestate("D");
        it.setOperatetime(new Date());

        int row = djResultmgMapper.updateByPrimaryKeySelective(it);

        return row;
    }

    @Override
    public PageInfo<Map<String, Object>> djBrandList(int pageIndex, int pageSize, String partyCode, String pbrandName, Integer creatType, String beginTime, String endTime, Integer zzfbType) {

        List<CfDictionary> dic_creatType = dictionaryService.getDictionaryListByDicTypeKey("djBrand_creatType");

        PageHelper.startPage(pageIndex, pageSize);

        List<Map<String, Object>> list = djPartyTwoExtCQuery.DjBrandListQuery(partyCode, pbrandName, creatType, beginTime, endTime, zzfbType);

        PageInfo<Map<String, Object>> result = new PageInfo(list);

        for (Map<String, Object> it : result.getList()) {

            it.put("CREATTYPENAME", it.get("CREATTYPE") != null ? dictionaryService.getDicByKey(((BigDecimal) it.get("CREATTYPE")).intValue(), dic_creatType).getDicvalue() : "");
        }

        return result;
    }

    @Override
    public DjBrand getDjBrandItem(String id) {
        DjBrand it = djBrandMapper.selectByPrimaryKey(id);
        if (it == null || StringUtils.isBlank(id)) {
            it = new DjBrand();
            it.setBrandid(UUID.randomUUID().toString());
        }
        return it;
    }

    @Override
    public int djBrandSave(DjBrand it) {
        int result = 0;

        it.setOperatetime(new Date());
        it.setUpdatetime(new Date());
        it.setSyncstate("N");

        DjBrand oIt = djBrandMapper.selectByPrimaryKey(it.getBrandid());

        if (oIt == null) {
            it.setCreatetime(new Date());
            it.setCreateuserid(it.getUpdateuserid());
            it.setCreateusername(it.getUpdateusername());
            it.setOperatestate("A");
            result = djBrandMapper.insert(it);
        } else {
            it.setOperatestate("M");
            result = djBrandMapper.updateByPrimaryKeyWithBLOBs(it);
        }

        return result;
    }

    @Override
    public int djBrandDel(String id) {
        DjBrand it = new DjBrand();
        it.setBrandid(id);
        it.setOperatestate("D");
        it.setOperatetime(new Date());

        int row = djBrandMapper.updateByPrimaryKeySelective(it);

        return row;
    }


    @Override
    public long getBrandCount(String partyCode, Integer creatType) {

        return djPartyTwoExtCQuery.selectBrandCount(partyCode, creatType);
    }


    @Override
    public PageInfo<Map<String, Object>> djPartyActivityRoomList(int pageIndex, int pageSize, String partyCode, String addr, Integer useRange, Integer zzfbType) {
        List<CfDictionary> dic_useRange = dictionaryService.getDictionaryListByDicTypeKey("djPartyActivityRoom_useRange");

        PageHelper.startPage(pageIndex, pageSize);

        List<Map<String, Object>> list = djPartyTwoExtCQuery.DjPartyActivityRoomListQuery(partyCode, addr, useRange, zzfbType);

        PageInfo<Map<String, Object>> result = new PageInfo(list);

        for (Map<String, Object> it : result.getList()) {

            it.put("USERANGENAME", it.get("USERANGE") != null ? dictionaryService.getDicByKey(((BigDecimal) it.get("USERANGE")).intValue(), dic_useRange).getDicvalue() : "");

            PageInfo<Map<String, Object>> pics = fileService.getFileList(it.get("PARTYACTIVITYROOMID").toString(), 2, 1, 1);
            if (pics.getTotal() > 0) {

            }
            it.put("FILEID", pics.getTotal() > 0 ? pics.getList().get(0).get("fileid").toString() : "");
        }

        return result;
    }

    @Override
    public DjPartyactivityroom getDjPartyActivityRoomItem(String id) {
        DjPartyactivityroom it = djPartyactivityroomMapper.selectByPrimaryKey(id);
        if (it == null || StringUtils.isBlank(id)) {
            it = new DjPartyactivityroom();
            it.setPartyactivityroomid(UUID.randomUUID().toString());
        }
        return it;
    }

    @Override
    public int djPartyActivityRoomSave(DjPartyactivityroom it, DjPartyactivityroomgroup[] partyList) {
        int result = 0;

        it.setOperatetime(new Date());
        it.setUpdatetime(new Date());
        it.setSyncstate("N");

        DjPartyactivityroom oIt = djPartyactivityroomMapper.selectByPrimaryKey(it.getPartyactivityroomid());

        if (oIt == null) {
            it.setCreatetime(new Date());
            it.setCreateuserid(it.getUpdateuserid());
            it.setCreateusername(it.getUpdateusername());
            it.setOperatestate("A");

            result = djPartyactivityroomMapper.insert(it);
        } else {
            it.setOperatestate("M");

            result = djPartyactivityroomMapper.updateByPrimaryKey(it);

            DjPartyactivityroomgroupExample exam = new DjPartyactivityroomgroupExample();
            exam.or().andPartyactivityroomidEqualTo(it.getPartyactivityroomid());
            djPartyactivityroomgroupMapper.deleteByExample(exam);
        }
        if (it.getUserange() == 1) {
            for (DjPartyactivityroomgroup party : partyList) {
                party.setGroupid(UUID.randomUUID().toString());
                party.setPartyactivityroomid(it.getPartyactivityroomid());
                djPartyactivityroomgroupMapper.insert(party);
            }
        }

        return result;
    }

    @Override
    public List<DjPartyactivityroomgroup> getDjPartyactivityroomgroupList(String partyactivityroomid) {
        DjPartyactivityroomgroupExample exam = new DjPartyactivityroomgroupExample();
        exam.or().andPartyactivityroomidEqualTo(partyactivityroomid);
        return djPartyactivityroomgroupMapper.selectByExample(exam);
    }

    @Override
    public int djPartyActivityRoomDel(String id) {
        DjPartyactivityroom it = new DjPartyactivityroom();
        it.setPartyactivityroomid(id);
        it.setOperatestate("D");
        it.setOperatetime(new Date());

        int row = djPartyactivityroomMapper.updateByPrimaryKeySelective(it);

        return row;
    }

    @Override
    public PageInfo<Map<String, Object>> djWxGroupList(int pageIndex, int pageSize, String partyCode, String groupName, String partyName, Integer implatform, String grouperName,
                                                       String beginTime, String endTime, Integer zzfbType, Integer scaleBegin, Integer scaleEnd) {

        List<CfDictionary> dic_implatform = dictionaryService.getDictionaryListByDicTypeKey("djWxGroup_implatform");
        //List<CfDictionary> dic_msgType = dictionaryService.getDictionaryListByDicTypeKey("djWxGroup_msgType");

        PageHelper.startPage(pageIndex, pageSize);
        PageHelper.orderBy(" CREATETIME desc ");

        List<Map<String, Object>> list = djPartyTwoExtCQuery.DjWxGroupListQuery(partyCode, groupName, partyName, implatform, grouperName, beginTime, endTime, zzfbType, scaleBegin, scaleEnd);

        PageInfo<Map<String, Object>> result = new PageInfo(list);

        for (Map<String, Object> it : result.getList()) {
            it.put("IMPLATFORMNAME", it.get("IMPLATFORM") != null ? dictionaryService.getDicByKey(((BigDecimal) it.get("IMPLATFORM")).intValue(), dic_implatform).getDicvalue() : "");
            //it.put("MSGTYPEMNAME",it.get("MSGTYPE")!=null? dictionaryService.getDicByKey(((BigDecimal) it.get("MSGTYPE")).intValue(), dic_msgType).getDicvalue():"");
        }

        return result;
    }

    @Override
    public DjWxgroup getDjWxGroupItem(String id) {
        DjWxgroup it = djWxgroupMapper.selectByPrimaryKey(id);
        if (it == null || StringUtils.isBlank(id)) {
            it = new DjWxgroup();
            it.setWxgroupid(UUID.randomUUID().toString());
        }
        return it;
    }

    @Override
    public int djWxGroupSave(DjWxgroup it) {
        int result = 0;

        it.setOperatetime(new Date());
        it.setUpdatetime(new Date());
        it.setSyncstate("N");

        DjWxgroup oIt = djWxgroupMapper.selectByPrimaryKey(it.getWxgroupid());

        if (oIt == null) {
            it.setCreatetime(new Date());
            it.setCreateuserid(it.getUpdateuserid());
            it.setCreateusername(it.getUpdateusername());
            it.setOperatestate("A");

            result = djWxgroupMapper.insert(it);
        } else {
            it.setOperatestate("M");
            it.setUpdateuserid(it.getUpdateuserid());
            it.setUpdateusername(it.getUpdateusername());
            result = djWxgroupMapper.updateByPrimaryKey(it);
        }

        return result;
    }

    @Override
    public int djWxGroupDel(String id) {
        DjWxgroup it = new DjWxgroup();
        it.setWxgroupid(id);
        it.setOperatestate("D");
        it.setOperatetime(new Date());

        int row = djWxgroupMapper.updateByPrimaryKeySelective(it);

        return row;
    }

    @Override
    public PageInfo<Map<String, Object>> wxGroupUserList(int pageIndex, int pageSize, String wxGroupId) {

        List<CfDictionary> dic_sex = dictionaryService.getDictionaryListByDicTypeKey("dic_sex");


        PageHelper.startPage(pageIndex, pageSize);

        PageHelper.orderBy(" CREATETIME desc ");

        List<Map<String, Object>> list = djPartyTwoExtCQuery.DjWxGroupUserListQuery(wxGroupId);

        PageInfo<Map<String, Object>> result = new PageInfo(list);

        for (Map<String, Object> it : result.getList()) {
            it.put("SEXNAME", it.get("SEX") != null ? dictionaryService.getDicByKey(((BigDecimal) it.get("SEX")).intValue(), dic_sex).getDicvalue() : "");
            //it.put("MSGTYPEMNAME",it.get("MSGTYPE")!=null? dictionaryService.getDicByKey(((BigDecimal) it.get("MSGTYPE")).intValue(), dic_msgType).getDicvalue():"");
        }

        return result;
    }

    @Override
    public int wxGroupUserBatchSave(List<Map<String, Object>> users, String pid, String updaterId, String updaterName) {

        int result = 0;
        DjWxgroupuserExample expUpate = new DjWxgroupuserExample();

        expUpate.or().andWxgroupidEqualTo(pid);
        DjWxgroupuser delUser = new DjWxgroupuser();
        delUser.setOperatestate("D");
        delUser.setOperatetime(new Date());
        int delNo = djWxgroupuserMapper.updateByExampleSelective(delUser, expUpate);

        for (Map<String, Object> user : users) {

            DjWxgroupuser saveUser = new DjWxgroupuser();

            saveUser.setWxgroupuserid(user.get("WXGROUPUSERID").toString());
            saveUser.setWxgroupid(pid);
            saveUser.setUsername(user.get("USERNAME").toString());
            saveUser.setSex(Integer.parseInt(user.get("SEX").toString()));
            saveUser.setMobile(user.get("MOBILE").toString());
            saveUser.setUpdateuserid(updaterId);
            saveUser.setUpdateusername(updaterName);

            result += this.wxGroupUserSave(saveUser);

        }

        return result;
    }

    @Override
    public DjWxgroupuser getDjWxGroupUserItem(String id) {
        DjWxgroupuser it = djWxgroupuserMapper.selectByPrimaryKey(id);
        if (it == null || StringUtils.isBlank(id)) {
            it = new DjWxgroupuser();
            it.setWxgroupuserid(UUID.randomUUID().toString());

        }
        return it;
    }

    @Override
    public int wxGroupUserSave(DjWxgroupuser it) {
        int result = 0;

        it.setOperatetime(new Date());
        it.setUpdatetime(new Date());
        it.setSyncstate("N");
        DjWxgroupuser oIt = null;
        if (StringUtils.isNotBlank(it.getWxgroupuserid())) {
            oIt = djWxgroupuserMapper.selectByPrimaryKey(it.getWxgroupuserid());
        } else {
            it.setWxgroupuserid(UUID.randomUUID().toString());
        }

        if (oIt == null) {
            it.setCreatetime(new Date());
            it.setCreateuserid(it.getUpdateuserid());
            it.setCreateusername(it.getUpdateusername());
            it.setOperatestate("A");

            result = djWxgroupuserMapper.insert(it);
        } else {
            it.setOperatestate("M");

            result = djWxgroupuserMapper.updateByPrimaryKey(it);
        }

        return result;
    }

    @Override
    public int wxGroupUserDel(String id) {
        DjWxgroupuser it = new DjWxgroupuser();
        it.setWxgroupid(id);
        it.setOperatestate("D");
        it.setOperatetime(new Date());

        int row = djWxgroupuserMapper.updateByPrimaryKeySelective(it);

        return row;
    }

    @Override
    public List<Map<String, Object>> importWxGroup(List<Map<String, Object>> wxgrouplist) throws Exception {
        List<Map<String, Object>> errorList = new ArrayList<>();
        wxgrouplist.forEach(x -> {
            Object partyname = x.get("partyname");
            Object groupname = x.get("groupname");
            Object buildtime = x.get("buildtime");
            Object msgtype = x.get("msgtype");
            Object implatformname = x.get("implatformname");
            Object mirror = x.get("mirror");
            Object groupername = x.get("groupername");
            Object grouperduty = x.get("grouperduty");
            Object groupertel = x.get("groupertel");
            Object scalenumber = x.get("scalenumber");
            String errorMsg = "";
            if (partyname == null || partyname == "") {
                errorMsg += "所在组织不能为空。";
            }
            if (groupname == null || groupname == "") {
                errorMsg += "群名称不能为空。";
            }
            if (buildtime == null || buildtime == "") {
                errorMsg += "成立时间不能为空。";
            }
            if (msgtype == null || msgtype == "") {
                errorMsg += "拟发布信息主要类型不能为空。";
            }
            if (implatformname == null || implatformname == "") {
                errorMsg += "所在平台不能为空。";
            }
            if (mirror == null || mirror == "") {
                errorMsg += "监管人不能为空。";
            }
            if (groupername == null || groupername == "") {
                errorMsg += "群主姓名不能为空。";
            }
            if (grouperduty == null || grouperduty == "") {
                errorMsg += "群主职务不能为空。";
            }
            if (groupertel == null || groupertel == "") {
                errorMsg += "群主电话不能为空。";
            }
            if (scalenumber == null || scalenumber == "") {
                errorMsg += "规模(人数)不能为空。";
            }
            if (!errorMsg.equals("")) {
                Map<String, Object> errorItem = new HashMap<>(x);
                errorItem.put("errorInfo", errorMsg);
                errorList.add(errorItem);
                return;
            }
            ZzZzqkxx zz = partyService.getPartyByMc(partyname.toString());

            if (zz == null) {
                errorMsg += "组织不存在。";
                Map<String, Object> errorItem = new HashMap<>(x);
                errorItem.put("errorInfo", errorMsg);
                errorList.add(errorItem);
                return;
            }
            CfDictionary dictionary = dictionaryService.getDictionaryListByDicTypeKey("djWxGroup_implatform").stream().filter(q -> q.getDicvalue().equals(implatformname)).findFirst().orElse(null);
            if (dictionary == null) {
                errorMsg += "所在平台不存在。";
                Map<String, Object> errorItem = new HashMap<>(x);
                errorItem.put("errorInfo", errorMsg);
                errorList.add(errorItem);
                return;
            }
            x.put("partycode", zz.getDzzdm());
            x.put("implatform", dictionary.getDickey());
        });

        if (errorList.size() == 0) {
            List<DjWxgroup> list = new ArrayList<>();
            wxgrouplist.forEach(x -> {
                DjWxgroup add = mapUtils.mapToObject(x, DjWxgroup.class);
                add.setCreatetime(new Date());
                add.setCreateuserid(userService.getLoginUser().getUserid());
                add.setCreateusername(userService.getLoginUser().getUsername());
                add.setWxgroupid(UUID.randomUUID().toString());
                add.setOperatetime(new Date());
                add.setUpdatetime(new Date());
                add.setUpdateuserid(userService.getLoginUser().getUserid());
                add.setUpdateusername(userService.getLoginUser().getUsername());

                //同步数据
                add.setOperatestate("M");
                add.setOperatetime(new Date());
                add.setSyncstate("N");
                list.add(add);
            });

            djPartyTwoExtCQuery.batchInsertWxgroup(list);
        }

        return errorList;
    }

    @Override
    public PageInfo<Map<String, Object>> getGdwydqkList(int pageIndex, int pageSize, String dzzmc, String yearmonth,String groupId) {

        PageHelper.startPage(pageIndex, pageSize);

        List<Map<String, Object>> list = djPartyTwoExtCQuery.selectGdwydqkList(dzzmc, yearmonth,groupId);

        PageInfo<Map<String, Object>> result = new PageInfo(list);

        return result;
    }

    @Override
    public List<Map<String, Object>> importGdwydqk(List<Map<String, Object>> gdwydqklist) throws Exception {
        List<Map<String, Object>> errorList = new ArrayList<>();
        gdwydqklist.forEach(x -> {
            Object partyname = x.get("dzzmc");
            Object ny = x.get("ny");

            String errorMsg = "";
            if (partyname == null || partyname == "") {
                errorMsg += "单位名称不能为空。";
            }
            if (ny == null || ny == "") {
                errorMsg += "年月不能为空。";
            }
            x.put("ddl",x.get("ddl").toString().replace("%",""));
            x.put("ydlv",x.get("ydlv").toString().replace("%",""));
            x.put("dzlv",x.get("dzlv").toString().replace("%",""));
            if (!errorMsg.equals("")) {
                Map<String, Object> errorItem = new HashMap<>(x);
                errorItem.put("errorInfo", errorMsg);
                errorList.add(errorItem);
                return;
            }
        });

        if (errorList.size() == 0) {
            List<DjGdwydqk> list = new ArrayList<>();
            int i = 0;
            for (Map<String, Object> x : gdwydqklist) {
                DjGdwydqk add = mapUtils.mapToObject(x, DjGdwydqk.class);
                add.setNy(dateUtils.StrToDate(x.get("ny").toString() + "01", "yyyyMMdd"));
                add.setCreateuserid(userService.getLoginUser().getUserid());
                add.setCreateusername(userService.getLoginUser().getUsername());
                add.setId(UUID.randomUUID().toString());
                add.setOperatetime(new Date());
                add.setUpdatetime(new Date());
                add.setUpdateuserid(userService.getLoginUser().getUserid());
                add.setUpdateusername(userService.getLoginUser().getUsername());
               /* add.setDdl(new BigDecimal(add.getDdl().floatValue() * 100));
                add.setYdlv( new BigDecimal(add.getYdlv().floatValue()*100));
                add.setDzlv( new BigDecimal(add.getDzlv().floatValue()*100));*/
                add.setOrderby(i++);
                //同步数据
                add.setOperatestate("M");
                add.setOperatetime(new Date());
                add.setSyncstate("N");
                list.add(add);
            }

            djPartyTwoExtCQuery.batchInsertGdwydqk(list);
        }

        return errorList;
    }
    @Override
    public int deleteGdwydqkList(List<String> ids) {
        DjGdwydqkExample example=new DjGdwydqkExample();
        example.or().andIdIn(ids);
        int row =  gdwydqkMapper.deleteByExample(example);
        return row;
    }

    @Override
    public DjGdwydqk getGdwydqkById(String id){
        return gdwydqkMapper.selectByPrimaryKey(id);
    }

}
