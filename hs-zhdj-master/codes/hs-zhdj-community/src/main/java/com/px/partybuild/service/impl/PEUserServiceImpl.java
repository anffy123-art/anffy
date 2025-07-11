package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.AppConfig;
import com.px.partybuild.mapper.*;
import com.px.partybuild.model.*;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.service.PEUserFlowService;
import com.px.partybuild.service.PEUserService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service("peUserService")
public class PEUserServiceImpl implements PEUserService {

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private PEUserCQuery peUserCquery;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private PeJoinuserMapper peJoinuserMapper;
    @Autowired
    private MapUtils mapUtils;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private PeJoinapplyMapper peJoinapplyMapper;
    @Autowired
    private PeJoinapplyResumeMapper peJoinapplyResumeMapper;
    @Autowired
    private PeJoinapplyRelationMapper peJoinapplyRelationMapper;
    @Autowired
    private PeJoinuserFlowMapper peJoinuserFlowMapper;
    @Autowired
    private PEUserFlowService peUserFlowService;
    @Autowired
    private PeTalkMapper peTalkMapper;
    @Autowired
    private PeTalkUserMapper peTalkUserMapper;
    @Autowired
    private PeRecommendMapper peRecommendMapper;
    @Autowired
    private PePutrecordMapper pePutrecordMapper;
    @Autowired
    private PeTrainuserMapper peTrainuserMapper;
    @Autowired
    private PeTrainuserDetailMapper peTrainuserDetailMapper;
    @Autowired
    private PeTraininspectMapper peTraininspectMapper;
    @Autowired
    private PeTraininspectRecordMapper peTraininspectRecordMapper;

    @Autowired
    private PeConfirmuserMapper peConfirmuserMapper;
    @Autowired
    private PeAgainputrecordMapper peAgainputrecordMapper;
    @Autowired
    private PeConfirmsponsorMapper peConfirmsponsorMapper;
    @Autowired
    private PeConfirmsponsorUserMapper peConfirmsponsorUserMapper;
    @Autowired
    private PePoliticalreviewMapper pePoliticalreviewMapper;
    @Autowired
    private PeTrainingMapper peTrainingMapper;

    @Autowired
    private PeBranchreviewMapper peBranchreviewMapper;
    @Autowired
    private PePartyreviewMapper pePartyreviewMapper;
    @Autowired
    private PeJoinbookMapper peJoinbookMapper;
    @Autowired
    private PeBranchtalkMapper peBranchtalkMapper;
    @Autowired
    private PartyCQuery partyCquery;

    @Autowired
    private PartyTotalCQuery partyTotalCquery;

    @Override
    public PageInfo<HashMap<String, Object>> getJoinUserList(int page, int rows, String partyCode, String name, Integer isLateDay, String flowId, List<String> pflowid, Integer zzfbType,
                                                             Integer beginSort, Integer endSort, List<Integer> ryztList) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = peUserCquery.selectJoinUserList(null, partyCode, name, isLateDay, flowId, pflowid, zzfbType, beginSort, endSort, ryztList);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getJoinUserListForApp(int page, int rows, String partyCode, String name, Integer isLateDay, String flowId, List<String> pflowid, Integer zzfbType,
                                                             Integer beginSort, Integer endSort, List<Integer> ryztList,String szdzbdm) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = peUserCquery.selectJoinUserListForApp(null, partyCode, name, isLateDay, flowId, pflowid, zzfbType, beginSort, endSort, ryztList,szdzbdm);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public PeJoinuser getJoinuserById(String id) {
        return peJoinuserMapper.selectByPrimaryKey(id);
    }

    @Override
    public PeJoinuser getJoinuserByRybm(String rybm) {
        PeJoinuser model = new PeJoinuser();
        if (!stringUtils.IsNullOrEmpty(rybm)) {
            PeJoinuserExample exp = new PeJoinuserExample();
            PeJoinuserExample.Criteria cri = exp.or().andUsercodeEqualTo(rybm);
            List<PeJoinuser> list = peJoinuserMapper.selectByExample(exp);

            if (list.size() > 0) {
                model = list.get(0);
            } else {
                UUID uuid = UUID.randomUUID();
                model = new PeJoinuser();
                model.setJoinuserid(uuid.toString());
                model.setUsercode(rybm);
                saveJoinuser(model);
            }
        }
        return model;
    }

    @Override
    public HashMap<String, Object> getJoinuserInfoById(String id) {
        HashMap<String, Object> result = new HashMap<>();
        List<HashMap<String, Object>> list = peUserCquery.selectJoinUserList(id, null, null, null, null, null, null, null, null, null);
        if (list.size() > 0) {
            result = list.get(0);
        }
        return result;
    }

    @Override
    public int saveJoinuser(PeJoinuser model) {
        int result = 0;
        PeJoinuser dbModel = getJoinuserById(model.getJoinuserid());
        if (!stringUtils.IsNullOrEmpty(model.getIdcard())) {
            model.setIdcard(model.getIdcard().toUpperCase());
        }
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getJoinuserid()))) {
            model.setCreatetime(new Date());

            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peJoinuserMapper.insert(model);
        } else {
            PeJoinuserExample exp = new PeJoinuserExample();
            PeJoinuserExample.Criteria cri = exp.or();
            cri.andJoinuseridEqualTo(model.getJoinuserid());

            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peJoinuserMapper.updateByExample(model, exp);
        }

        return result;
    }

    @Override
    public int deleteJoinUserById(String id) {
        return peJoinuserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<HashMap<String, Object>> getUserFlowList(String joinUserId) {
        List<HashMap<String, Object>> list = peUserCquery.selectUserFlowList(joinUserId);
        return list;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getJoinUserTotalList(int page, int rows, String dzzdm, Integer zzfbType, String ssdzzdm,Integer isOnduty) {
        /*PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = peUserCquery.selectJoinUserTotalList(appConfig.gddwdm, dzzdm, zzfbType);
        for (HashMap<String, Object> item : list) {
            if (item.get("DZZDM") != null) {
                item.put("TOTALCOUNT", partyCquery.selectPartyUserCount(item.get("DZZDM").toString()));
            }
        }
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);

        return result;*/

        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = partyCquery.selectPartyList(appConfig.gddwdm, null, null, dzzdm, null, null, null, null, null, zzfbType, null, null, ssdzzdm, null, null, null,null,null,null);

        List<String> dzzdmList = list.stream().map(it -> it.get("DZZDM").toString()).collect(Collectors.toList());

        List<HashMap<String, Object>> zgUserlList = new ArrayList<>();

        if (dzzdmList.size() > 0) {
            zgUserlList = partyTotalCquery.selectZgUsertotalList(dzzdmList,isOnduty);
        }

        for (HashMap<String, Object> item : list) {
            if (item.get("DZZDM") != null) {
                /*String TOTALCOUNT = partyCquery.selectPartyUserCount(item.get("DZZDM").toString());
                item.put("TOTALCOUNT", !stringUtils.IsNullOrEmpty(TOTALCOUNT) ? TOTALCOUNT : 0);*/

                item.put("TOTALCOUNT", item.get("USERCOUNT"));

                /*HashMap<String, Object> peData = peUserCquery.selectJoinUserTotalList_New(item.get("DZZDM").toString());
                item.put("TYPE1", (peData != null && peData.get("TYPE1") != null) ? peData.get("TYPE1") : 0);
                item.put("TYPE2", (peData != null && peData.get("TYPE2") != null) ? peData.get("TYPE2") : 0);
                item.put("TYPE3", (peData != null && peData.get("TYPE3") != null) ? peData.get("TYPE3") : 0);
                item.put("TYPE4", (peData != null && peData.get("TYPE4") != null) ? peData.get("TYPE4") : 0);
                item.put("TYPE5", (peData != null && peData.get("TYPE5") != null) ? peData.get("TYPE5") : 0);*/

                String itDzzdm = item.get("DZZDM").toString();

                List<HashMap<String, Object>> zgList = zgUserlList.stream().filter(it -> it.get("DZZDM").toString().equals(itDzzdm)).collect(Collectors.toList());

                Object numSqrd = 0, numJjfz = 0, numFzdx = 0, numYbdy = 0,numZsdy=0;

                if (zgList.size() > 0) {
                    numSqrd = zgList.get(0).get("NUM_SQRD");
                    numJjfz = zgList.get(0).get("NUM_JJFZ");
                    numFzdx = zgList.get(0).get("NUM_FZDX");
                    numYbdy = zgList.get(0).get("NUM_YBDY");
                    numZsdy = zgList.get(0).get("NUM_ZSDY");
                }

                item.put("SQRD", numSqrd);//申请入党数
                item.put("JJFZ", numJjfz);//积极分子数
                item.put("FZDX", numFzdx);//发展对象数
                item.put("YBDY", numYbdy);//预备党员数
                item.put("ZSDY", numZsdy);//预备党员数
            }
        }

        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    /**
     * region 1.递交入党申请书
     * @param joinUserId userId
     * @return m
     */
    @Override
    public PeJoinapplyWithBLOBs getJoinuserApplyByUserId(String joinUserId) {
        PeJoinapplyWithBLOBs model = new PeJoinapplyWithBLOBs();

        PeJoinapplyExample exp = new PeJoinapplyExample();
        PeJoinapplyExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeJoinapplyWithBLOBs> list = peJoinapplyMapper.selectByExampleWithBLOBs(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeJoinapplyWithBLOBs getJoinuserApplyById(String id) {
        return peJoinapplyMapper.selectByPrimaryKey(id);
    }

    private PeJoinapplyResume getPeJoinapplyResumeById(String id) {
        return peJoinapplyResumeMapper.selectByPrimaryKey(id);
    }

    private PeJoinapplyRelation getPeJoinapplyRelationById(String id) {
        return peJoinapplyRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * @param page
     * @param rows
     * @param applyId
     * @Description: 个人简历
     * @Date: 2020/1/8
     */
    @Override
    public PageInfo<HashMap<String, Object>> getPeJoinapplyResumeList(int page, int rows, String applyId) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = peUserCquery.selectPeJoinapplyResumeList(applyId);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    /**
     * @param page
     * @param rows
     * @param applyId
     * @Description: 社会关系
     * @Date: 2020/1/8
     */
    @Override
    public PageInfo<HashMap<String, Object>> getPeJoinapplyRelationList(int page, int rows, String applyId) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = peUserCquery.selectPeJoinapplyRelationList(applyId);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    /**
     * @param model
     * @param resumeList
     * @param relationListList
     * @param flowId
     * @param userId
     * @param userName
     * @Description: 保存党员申请书信息
     * @return: int
     * @Date: 2020/1/8
     */
    @Override
    public int saveJoinuserApply(PeJoinapplyWithBLOBs model, List<PeJoinapplyResume> resumeList, List<PeJoinapplyRelation> relationListList, String flowId, String userId, String userName) {
        int result = 0;
        PeJoinapplyWithBLOBs dbModel = getJoinuserApplyById(model.getApplyid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getApplyid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peJoinapplyMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peJoinapplyMapper.updateByPrimaryKeyWithBLOBs(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);


        peUserCquery.deletePeJoinapplyResume(model.getApplyid());
        peUserCquery.deletePeJoinapplyRelation(model.getApplyid());

        for (PeJoinapplyResume item : resumeList) {
            PeJoinapplyResume uModel = getPeJoinapplyResumeById(item.getId());
            if (uModel == null || (uModel != null && stringUtils.IsNullOrEmpty(uModel.getId()))) {
                item.setId(UUID.randomUUID().toString());
                item.setApplyid(model.getApplyid());
                item.setCreateuserid(userId);
                item.setCreateusername(userName);
                item.setCreatetime(new Date());
                //同步数据
                item.setOperatetime(new Date());
                item.setOperatestate("A");
                item.setSyncstate("N");
                peJoinapplyResumeMapper.insert(item);
            } else {
                item.setUpdateuserid(userId);
                item.setUpdateusername(userName);
                item.setUpdatetime(new Date());

                item.setOperatetime(new Date());
                item.setOperatestate("M");
                item.setSyncstate("N");
                peJoinapplyResumeMapper.updateByPrimaryKeySelective(item);
            }
        }

        for (PeJoinapplyRelation item : relationListList) {
            PeJoinapplyRelation pModel = getPeJoinapplyRelationById(item.getId());
            if (pModel == null || (pModel != null && stringUtils.IsNullOrEmpty(pModel.getId()))) {
                item.setId(UUID.randomUUID().toString());
                item.setApplyid(model.getApplyid());
                item.setCreateuserid(userId);
                item.setCreateusername(userName);
                item.setCreatetime(new Date());
                //同步数据
                item.setOperatetime(new Date());
                item.setOperatestate("A");
                item.setSyncstate("N");
                peJoinapplyRelationMapper.insert(item);
            } else {
                item.setUpdateuserid(userId);
                item.setUpdateusername(userName);
                item.setUpdatetime(new Date());

                item.setOperatetime(new Date());
                item.setOperatestate("M");
                item.setSyncstate("N");
                peJoinapplyRelationMapper.updateByPrimaryKeySelective(item);
            }
        }

        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delPeJoinUserApply(String joinUserId, String flowId) {
        PeJoinapplyWithBLOBs model = getJoinuserApplyByUserId(joinUserId);

        PeJoinapplyResumeExample rExp = new PeJoinapplyResumeExample();
        PeJoinapplyResumeExample.Criteria rCri = rExp.or();
        rCri.andApplyidEqualTo(model.getApplyid());
        peJoinapplyResumeMapper.deleteByExample(rExp);

        PeJoinapplyRelationExample rlExp = new PeJoinapplyRelationExample();
        PeJoinapplyRelationExample.Criteria rlCri = rlExp.or();
        rlCri.andApplyidEqualTo(model.getApplyid());
        peJoinapplyRelationMapper.deleteByExample(rlExp);

        int count = peJoinapplyMapper.deleteByPrimaryKey(model.getApplyid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }
    //endregion

    /**
     * region 2.党组织派人谈话
     * @param joinUserId userId
     * @return m
     */
    @Override
    public PeTalkWithBLOBs getTalkByUserId(String joinUserId) {
        PeTalkWithBLOBs model = new PeTalkWithBLOBs();

        PeTalkExample exp = new PeTalkExample();
        PeTalkExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeTalkWithBLOBs> list = peTalkMapper.selectByExampleWithBLOBs(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeTalkWithBLOBs getTalkById(String taskId) {
        return peTalkMapper.selectByPrimaryKey(taskId);
    }

    @Override
    public int saveTalk(PeTalkWithBLOBs model, List<PeTalkUser> userList, String flowId, String userId, String userName) {
        int result = 0;
        PeTalkWithBLOBs dbModel = getTalkById(model.getTalkid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getTalkid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peTalkMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peTalkMapper.updateByPrimaryKeyWithBLOBs(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);


        peUserCquery.deleteTaskUser(model.getTalkid());

        for (PeTalkUser item : userList) {
            PeTalkUser uModel = getTaskUserById(item.getId());
            if (uModel == null || (uModel != null && stringUtils.IsNullOrEmpty(uModel.getId()))) {
                item.setId(UUID.randomUUID().toString());
                item.setTalkid(model.getTalkid());
                item.setCreateuserid(userId);
                item.setCreateusername(userName);
                item.setCreatetime(new Date());
                //同步数据
                item.setOperatetime(new Date());
                item.setOperatestate("A");
                item.setSyncstate("N");
                peTalkUserMapper.insert(item);
            } else {
                item.setUpdateuserid(userId);
                item.setUpdateusername(userName);
                item.setUpdatetime(new Date());

                item.setOperatetime(new Date());
                item.setOperatestate("M");
                item.setSyncstate("N");
                peTalkUserMapper.updateByPrimaryKeySelective(item);
            }
        }

        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getTalkUserList(int page, int rows, String talkId) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = peUserCquery.selectTalkUserList(talkId);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    private PeTalkUser getTaskUserById(String id) {
        return peTalkUserMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delTalkUser(String joinUserId, String flowId) {
        PeTalkWithBLOBs model = getTalkByUserId(joinUserId);

        PeTalkUserExample rExp = new PeTalkUserExample();
        PeTalkUserExample.Criteria rCri = rExp.or();
        rCri.andTalkidEqualTo(model.getTalkid());
        peTalkUserMapper.deleteByExample(rExp);

        int count = peTalkMapper.deleteByPrimaryKey(model.getTalkid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }
    //endregion

    /**
     * region 3.推荐和确定入党积极分子
     * @param joinUserId userId
     * @return m
     */
    @Override
    public PeRecommendWithBLOBs getRecommendByUserId(String joinUserId) {
        PeRecommendWithBLOBs model = new PeRecommendWithBLOBs();

        PeRecommendExample exp = new PeRecommendExample();
        PeRecommendExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeRecommendWithBLOBs> list = peRecommendMapper.selectByExampleWithBLOBs(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeRecommendWithBLOBs getRecommendById(String recommendId) {
        return peRecommendMapper.selectByPrimaryKey(recommendId);
    }

    @Override
    public int saveRecommend(PeRecommendWithBLOBs model, String flowId, String userId, String userName) {
        int result = 0;
        PeRecommendWithBLOBs dbModel = getRecommendById(model.getRecommendid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getRecommendid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peRecommendMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peRecommendMapper.updateByPrimaryKeyWithBLOBs(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delRecommend(String joinUserId, String flowId) {
        PeRecommendWithBLOBs model = getRecommendByUserId(joinUserId);

        int count = peRecommendMapper.deleteByPrimaryKey(model.getRecommendid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }
    //endregion

    //region 4.上级党委备案情况

    @Override
    public PePutrecord getPutrecordByUserId(String joinUserId) {
        PePutrecord model = new PePutrecord();

        PePutrecordExample exp = new PePutrecordExample();
        PePutrecordExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PePutrecord> list = pePutrecordMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PePutrecord getPutrecordById(String putrecordId) {
        return pePutrecordMapper.selectByPrimaryKey(putrecordId);
    }

    @Override
    public int savePutrecord(PePutrecord model, String flowId, String userId, String userName) {
        int result = 0;
        PePutrecord dbModel = getPutrecordById(model.getPutrecordid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getPutrecordid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = pePutrecordMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = pePutrecordMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delPutrecord(String joinUserId, String flowId) {
        PePutrecord model = getPutrecordByUserId(joinUserId);

        int count = pePutrecordMapper.deleteByPrimaryKey(model.getPutrecordid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion

    //region 5.指定培养人

    @Override
    public PeTrainuser getTrainuserByUserId(String joinUserId) {
        PeTrainuser model = new PeTrainuser();

        PeTrainuserExample exp = new PeTrainuserExample();
        PeTrainuserExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeTrainuser> list = peTrainuserMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeTrainuser getTrainuserById(String trainuserId) {
        return peTrainuserMapper.selectByPrimaryKey(trainuserId);
    }

    @Override
    public int saveTrainuser(PeTrainuser model, List<PeTrainuserDetail> userList, String flowId, String userId, String userName) {
        int result = 0;
        PeTrainuser dbModel = getTrainuserById(model.getTrainuserid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getTrainuserid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peTrainuserMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peTrainuserMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        peUserCquery.deleteTrainuserDetail(model.getTrainuserid());

        for (PeTrainuserDetail item : userList) {
            PeTrainuserDetail uModel = getTrainuserDetailById(item.getId());
            if (uModel == null || (uModel != null && stringUtils.IsNullOrEmpty(uModel.getId()))) {
                item.setId(UUID.randomUUID().toString());
                item.setTrainuserid(model.getTrainuserid());
                item.setCreateuserid(userId);
                item.setCreateusername(userName);
                item.setCreatetime(new Date());
                //同步数据
                item.setOperatetime(new Date());
                item.setOperatestate("A");
                item.setSyncstate("N");
                peTrainuserDetailMapper.insert(item);
            } else {
                item.setUpdateuserid(userId);
                item.setUpdateusername(userName);
                item.setUpdatetime(new Date());

                item.setOperatetime(new Date());
                item.setOperatestate("M");
                item.setSyncstate("N");
                peTrainuserDetailMapper.updateByPrimaryKeySelective(item);
            }
        }

        return result;
    }

    private PeTrainuserDetail getTrainuserDetailById(String id) {
        return peTrainuserDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<HashMap<String, Object>> getTrainuserDetailList(int page, int rows, String trainUserId) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = peUserCquery.selectTrainuserDetailList(trainUserId);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delTrainuser(String joinUserId, String flowId) {
        PeTrainuser model = getTrainuserByUserId(joinUserId);

        PeTrainuserDetailExample rExp = new PeTrainuserDetailExample();
        PeTrainuserDetailExample.Criteria rCri = rExp.or();
        rCri.andTrainuseridEqualTo(model.getTrainuserid());
        peTrainuserDetailMapper.deleteByExample(rExp);

        int count = peTrainuserMapper.deleteByPrimaryKey(model.getTrainuserid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion

    //region 6.培养教育考察

    @Override
    public PeTraininspect getTraininspectByUserId(String joinUserId) {
        PeTraininspect model = new PeTraininspect();

        PeTraininspectExample exp = new PeTraininspectExample();
        PeTraininspectExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeTraininspect> list = peTraininspectMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    private PeTraininspect getTraininspectById(String id) {
        return peTraininspectMapper.selectByPrimaryKey(id);
    }

    public PeTraininspectRecordWithBLOBs getTrainInspectRecordById(String trainInspectId) {
        return peTraininspectRecordMapper.selectByPrimaryKey(trainInspectId);
    }

    @Override
    public int saveTraininspect(PeTraininspect model, List<PeTraininspectRecordWithBLOBs> recordList, String flowId, String userId, String userName) {
        int result = 0;
        PeTraininspect dbModel = getTraininspectById(model.getTraininspectid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getTraininspectid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peTraininspectMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peTraininspectMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        peUserCquery.deleteTraininspectRecord(model.getTraininspectid());

        for (PeTraininspectRecordWithBLOBs item : recordList) {
            PeTraininspectRecordWithBLOBs uModel = getTrainInspectRecordById(item.getId());
            if (uModel == null || (uModel != null && stringUtils.IsNullOrEmpty(uModel.getId()))) {
                item.setId(UUID.randomUUID().toString());
                item.setTraininspectid(model.getTraininspectid());
                item.setCreateuserid(userId);
                item.setCreateusername(userName);
                item.setCreatetime(new Date());
                //同步数据
                item.setOperatetime(new Date());
                item.setOperatestate("A");
                item.setSyncstate("N");
                peTraininspectRecordMapper.insert(item);
            } else {
                item.setUpdateuserid(userId);
                item.setUpdateusername(userName);
                item.setUpdatetime(new Date());

                item.setOperatetime(new Date());
                item.setOperatestate("M");
                item.setSyncstate("N");
                peTraininspectRecordMapper.updateByPrimaryKeySelective(item);
            }
        }

        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getTraininspectRecordList(int page, int rows, String trainInspectId) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = peUserCquery.selectTraininspectRecordList(trainInspectId);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delTraininspect(String joinUserId, String flowId) {
        PeTraininspect model = getTraininspectByUserId(joinUserId);

        PeTraininspectRecordExample rExp = new PeTraininspectRecordExample();
        PeTraininspectRecordExample.Criteria rCri = rExp.or();
        rCri.andTraininspectidEqualTo(model.getTraininspectid());
        peTraininspectRecordMapper.deleteByExample(rExp);

        int count = peTraininspectMapper.deleteByPrimaryKey(model.getTraininspectid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion


    //region 7.确定发展对象

    @Override
    public PeConfirmuserWithBLOBs getConfirmuserByUserId(String joinUserId) {
        PeConfirmuserWithBLOBs model = new PeConfirmuserWithBLOBs();

        PeConfirmuserExample exp = new PeConfirmuserExample();
        PeConfirmuserExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeConfirmuserWithBLOBs> list = peConfirmuserMapper.selectByExampleWithBLOBs(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeConfirmuserWithBLOBs getConfirmuserById(String confirmuserId) {
        return peConfirmuserMapper.selectByPrimaryKey(confirmuserId);
    }

    @Override
    public int saveConfirmuser(PeConfirmuserWithBLOBs model, String flowId, String userId, String userName) {
        int result = 0;
        PeConfirmuserWithBLOBs dbModel = getConfirmuserById(model.getConfirmuserid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getConfirmuserid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peConfirmuserMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peConfirmuserMapper.updateByPrimaryKeyWithBLOBs(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delConfirmuser(String joinUserId, String flowId) {
        PeConfirmuserWithBLOBs model = getConfirmuserByUserId(joinUserId);

        int count = peConfirmuserMapper.deleteByPrimaryKey(model.getConfirmuserid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion

    //region 8.上级党委报备

    @Override
    public PeAgainputrecord getAgainputrecordByUserId(String joinUserId) {
        PeAgainputrecord model = new PeAgainputrecord();

        PeAgainputrecordExample exp = new PeAgainputrecordExample();
        PeAgainputrecordExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeAgainputrecord> list = peAgainputrecordMapper.selectByExampleWithBLOBs(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeAgainputrecord getAgainputrecordById(String againPutrecordId) {
        return peAgainputrecordMapper.selectByPrimaryKey(againPutrecordId);
    }

    @Override
    public int saveAgainputrecord(PeAgainputrecord model, String flowId, String userId, String userName) {
        int result = 0;
        PeAgainputrecord dbModel = getAgainputrecordById(model.getAgainputrecordid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getAgainputrecordid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peAgainputrecordMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peAgainputrecordMapper.updateByPrimaryKeyWithBLOBs(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delAgainputrecord(String joinUserId, String flowId) {
        PeAgainputrecord model = getAgainputrecordByUserId(joinUserId);

        int count = peAgainputrecordMapper.deleteByPrimaryKey(model.getAgainputrecordid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion

    //region 9.确定入党介绍人

    @Override
    public PeConfirmsponsor getConfirmsponsorByUserId(String joinUserId) {
        PeConfirmsponsor model = new PeConfirmsponsor();

        PeConfirmsponsorExample exp = new PeConfirmsponsorExample();
        PeConfirmsponsorExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeConfirmsponsor> list = peConfirmsponsorMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeConfirmsponsor getConfirmsponsorById(String confirmSponsorId) {
        return peConfirmsponsorMapper.selectByPrimaryKey(confirmSponsorId);
    }

    @Override
    public int saveConfirmsponsor(PeConfirmsponsor model, List<PeConfirmsponsorUser> userList, String flowId, String userId, String userName) {
        int result = 0;
        PeConfirmsponsor dbModel = getConfirmsponsorById(model.getConfirmsponsorid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getConfirmsponsorid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peConfirmsponsorMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peConfirmsponsorMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        peUserCquery.deleteConfirmsponsorUser(model.getConfirmsponsorid());

        for (PeConfirmsponsorUser item : userList) {
            PeConfirmsponsorUser uModel = getConfirmsponsorUserById(item.getId());
            if (uModel == null || (uModel != null && stringUtils.IsNullOrEmpty(uModel.getId()))) {
                item.setId(UUID.randomUUID().toString());
                item.setConfirmsponsorid(model.getConfirmsponsorid());
                item.setCreateuserid(userId);
                item.setCreateusername(userName);
                item.setCreatetime(new Date());
                //同步数据
                item.setOperatetime(new Date());
                item.setOperatestate("A");
                item.setSyncstate("N");
                peConfirmsponsorUserMapper.insert(item);
            } else {
                item.setUpdateuserid(userId);
                item.setUpdateusername(userName);
                item.setUpdatetime(new Date());

                item.setOperatetime(new Date());
                item.setOperatestate("M");
                item.setSyncstate("N");
                peConfirmsponsorUserMapper.updateByPrimaryKeySelective(item);
            }
        }

        return result;
    }

    private PeConfirmsponsorUser getConfirmsponsorUserById(String id) {
        return peConfirmsponsorUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<HashMap<String, Object>> getConfirmsponsorUserList(int page, int rows, String confirmSponsorId, String joinUserId) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = peUserCquery.selectConfirmsponsorUserList(confirmSponsorId);
        if (list.size() <= 0) {
            PeTrainuser peTrainuser = getTrainuserByUserId(joinUserId);

            list = getTrainuserDetailList(1, 10000, peTrainuser.getTrainuserid()).getList();

        }
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delConfirmsponsor(String joinUserId, String flowId) {
        PeConfirmsponsor model = getConfirmsponsorByUserId(joinUserId);

        int count = peConfirmsponsorMapper.deleteByPrimaryKey(model.getConfirmsponsorid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion

    //region 10.进行政治审查

    @Override
    public PePoliticalreview getPoliticalreviewByUserId(String joinUserId) {
        PePoliticalreview model = new PePoliticalreview();

        PePoliticalreviewExample exp = new PePoliticalreviewExample();
        PePoliticalreviewExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PePoliticalreview> list = pePoliticalreviewMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PePoliticalreview getPoliticalreviewById(String politicalReviewId) {
        return pePoliticalreviewMapper.selectByPrimaryKey(politicalReviewId);
    }

    @Override
    public int savePoliticalreview(PePoliticalreview model, String flowId, String userId, String userName) {
        int result = 0;
        PePoliticalreview dbModel = getPoliticalreviewById(model.getPoliticalreviewid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getPoliticalreviewid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = pePoliticalreviewMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = pePoliticalreviewMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delPoliticalreview(String joinUserId, String flowId) {
        PePoliticalreview model = getPoliticalreviewByUserId(joinUserId);

        int count = pePoliticalreviewMapper.deleteByPrimaryKey(model.getPoliticalreviewid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion

    //region 11.开展短期集中培训

    @Override
    public PeTraining getTrainingByUserId(String joinUserId) {
        PeTraining model = new PeTraining();

        PeTrainingExample exp = new PeTrainingExample();
        PeTrainingExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeTraining> list = peTrainingMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeTraining getTrainingById(String trainingId) {
        return peTrainingMapper.selectByPrimaryKey(trainingId);
    }

    @Override
    public int saveTraining(PeTraining model, String flowId, String userId, String userName) {
        int result = 0;
        PeTraining dbModel = getTrainingById(model.getTrainingid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getTrainingid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peTrainingMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peTrainingMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delTraining(String joinUserId, String flowId) {
        PeTraining model = getTrainingByUserId(joinUserId);

        int count = peTrainingMapper.deleteByPrimaryKey(model.getTrainingid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion


    //region 12.支委会审查

    @Override
    public PeBranchreview getBranchreviewByUserId(String joinUserId) {
        PeBranchreview model = new PeBranchreview();

        PeBranchreviewExample exp = new PeBranchreviewExample();
        PeBranchreviewExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeBranchreview> list = peBranchreviewMapper.selectByExampleWithBLOBs(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeBranchreview getBranchreviewById(String branchReviewId) {
        return peBranchreviewMapper.selectByPrimaryKey(branchReviewId);
    }

    @Override
    public int saveBranchreview(PeBranchreview model, String flowId, String userId, String userName) {
        int result = 0;
        PeBranchreview dbModel = getBranchreviewById(model.getBranchreviewid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getBranchreviewid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peBranchreviewMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peBranchreviewMapper.updateByPrimaryKeyWithBLOBs(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delBranchreview(String joinUserId, String flowId) {
        PeBranchreview model = getBranchreviewByUserId(joinUserId);

        int count = peBranchreviewMapper.deleteByPrimaryKey(model.getBranchreviewid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion

    //region 13.上级党委预审

    @Override
    public PePartyreview getPartyreviewByUserId(String joinUserId) {
        PePartyreview model = new PePartyreview();

        PePartyreviewExample exp = new PePartyreviewExample();
        PePartyreviewExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PePartyreview> list = pePartyreviewMapper.selectByExampleWithBLOBs(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PePartyreview getPartyreviewById(String partyReviewId) {
        return pePartyreviewMapper.selectByPrimaryKey(partyReviewId);
    }

    @Override
    public int savePartyreview(PePartyreview model, String flowId, String userId, String userName) {
        int result = 0;
        PePartyreview dbModel = getPartyreviewById(model.getPartyreviewid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getPartyreviewid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = pePartyreviewMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = pePartyreviewMapper.updateByPrimaryKeyWithBLOBs(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delPartyreview(String joinUserId, String flowId) {
        PePartyreview model = getPartyreviewByUserId(joinUserId);

        int count = pePartyreviewMapper.deleteByPrimaryKey(model.getPartyreviewid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion

    //region 14.填写入党志愿书

    @Override
    public PeJoinbook getJoinbookByUserId(String joinUserId) {
        PeJoinbook model = new PeJoinbook();

        PeJoinbookExample exp = new PeJoinbookExample();
        PeJoinbookExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeJoinbook> list = peJoinbookMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeJoinbook getJoinbookById(String joinBookId) {
        return peJoinbookMapper.selectByPrimaryKey(joinBookId);
    }

    @Override
    public int saveJoinbook(PeJoinbook model, String flowId, String userId, String userName) {
        int result = 0;
        PeJoinbook dbModel = getJoinbookById(model.getJoinbookid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getJoinbookid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peJoinbookMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peJoinbookMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delJoinbook(String joinUserId, String flowId) {
        PeJoinbook model = getJoinbookByUserId(joinUserId);

        int count = peJoinbookMapper.deleteByPrimaryKey(model.getJoinbookid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion

    //region 15.支部大会讨论

    @Override
    public PeBranchtalkWithBLOBs getBranchtalkByUserId(String joinUserId) {
        PeBranchtalkWithBLOBs model = new PeBranchtalkWithBLOBs();

        PeBranchtalkExample exp = new PeBranchtalkExample();
        PeBranchtalkExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeBranchtalkWithBLOBs> list = peBranchtalkMapper.selectByExampleWithBLOBs(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeBranchtalkWithBLOBs getBranchtalkById(String trainingId) {
        return peBranchtalkMapper.selectByPrimaryKey(trainingId);
    }

    @Override
    public int saveBranchtalk(PeBranchtalkWithBLOBs model, String flowId, String userId, String userName) {
        int result = 0;
        PeBranchtalkWithBLOBs dbModel = getBranchtalkById(model.getBranchtalkid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getBranchtalkid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peBranchtalkMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peBranchtalkMapper.updateByPrimaryKeyWithBLOBs(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delBranchtalk(String joinUserId, String flowId) {
        PeBranchtalkWithBLOBs model = getBranchtalkByUserId(joinUserId);

        int count = peBranchtalkMapper.deleteByPrimaryKey(model.getBranchtalkid());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }

    //endregion


    @Override
    public int updateJoinuserCode(){
        return peUserCquery.updateJoinuserCode();
    }


    @Override
    public PageInfo<HashMap<String, Object>> getJoinuserForUpdateList(int page, int rows, String partyCode, String name,String startDate, String endDate) {
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = peUserCquery.selectJoinuserForUpdateList(partyCode, name,startDate,endDate);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

}
