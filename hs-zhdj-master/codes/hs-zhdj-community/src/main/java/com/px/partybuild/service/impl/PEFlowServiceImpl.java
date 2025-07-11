package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.*;
import com.px.partybuild.model.*;
import com.px.partybuild.service.PEFlowService;
import com.px.partybuild.service.PEUserFlowService;
import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service("peFlowService")
public class PEFlowServiceImpl implements PEFlowService {
    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private PeSuperiorappMapper peSuperiorappMapper;

    @Autowired
    private PEUserFlowService peUserFlowService;

    @Autowired
    private PeZzbmbaMapper peZzbmbaMapper;

    @Autowired
    private PeBrdzbMapper peBrdzbMapper;

    @Autowired
    private PeRdxsMapper peRdxsMapper;

    @Autowired
    private PeJxjykcMapper peJxjykcMapper;

    @Autowired
    private PeJxjykcqkMapper peJxjykcqkMapper;

    @Autowired
    private PEUserCQuery peUserCQuery;

    @Autowired
    private PeTczzsqMapper peTczzsqMapper;

    @Autowired
    private PeZbdhtlMapper peZbdhtlMapper;

    @Autowired
    private PeSjdwspMapper peSjdwspMapper;

    @Autowired
    private PeZlgdMapper peZlgdMapper;

    @Autowired
    private PeSjprthMapper peSjprthMapper;

    @Autowired
    private PeSjprthmxMapper peSjprthmxMapper;

    @Override
    public int savegSuperiorapp(PeSuperiorapp model, String flowId, String userId, String userName) {
        int result = 0;
        PeSuperiorapp dbModel = getSuperiorappById(model.getTalkid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getTalkid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peSuperiorappMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peSuperiorappMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }
    @Override
    public PeSuperiorapp getSuperiorappByUserId(String joinUserId) {
        PeSuperiorapp model = new PeSuperiorapp();

        PeSuperiorappExample exp = new PeSuperiorappExample();
        PeSuperiorappExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeSuperiorapp> list = peSuperiorappMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }
    @Override
    public PeSuperiorapp getSuperiorappById(String putrecordId) {
        return peSuperiorappMapper.selectByPrimaryKey(putrecordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delsuperiorTalk(String joinUserId, String flowId) {

        PeSuperiorappExample exp = new PeSuperiorappExample();
        PeSuperiorappExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);
        int count = peSuperiorappMapper.deleteByExample(exp);
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }
        return count;

    }

    @Override
    public int saveZzbmba(PeZzbmba model, String flowId, String userId, String userName) {
        int result = 0;
        PeZzbmba dbModel = getZzbmbaById(model.getId());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getId()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peZzbmbaMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peZzbmbaMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }
    @Override
    public PeZzbmba getZzbmbaByUserId(String joinUserId) {
        PeZzbmba model = new PeZzbmba();

        PeZzbmbaExample exp = new PeZzbmbaExample();
        PeZzbmbaExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeZzbmba> list = peZzbmbaMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }
    @Override
    public PeZzbmba getZzbmbaById(String putrecordId) {
        return peZzbmbaMapper.selectByPrimaryKey(putrecordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delZzbmba(String joinUserId, String flowId) {

        PeZzbmbaExample exp = new PeZzbmbaExample();
        PeZzbmbaExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);
        int count = peZzbmbaMapper.deleteByExample(exp);
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }
        return count;

    }


    @Override
    public int saveBrdzb(PeBrdzb model, String flowId, String userId, String userName) {
        int result = 0;
        PeBrdzb dbModel = getBrdzbById(model.getId());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getId()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peBrdzbMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peBrdzbMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }
    @Override
    public PeBrdzb getBrdzbByUserId(String joinUserId) {
        PeBrdzb model = new PeBrdzb();

        PeBrdzbExample exp = new PeBrdzbExample();
        PeBrdzbExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeBrdzb> list = peBrdzbMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }
    @Override
    public PeBrdzb getBrdzbById(String putrecordId) {
        return peBrdzbMapper.selectByPrimaryKey(putrecordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delBrdzb(String joinUserId, String flowId) {

        PeBrdzbExample exp = new PeBrdzbExample();
        PeBrdzbExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);
        int count = peBrdzbMapper.deleteByExample(exp);
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }
        return count;

    }


    @Override
    public int saveRdxs(PeRdxs model, String flowId, String userId, String userName) {
        int result = 0;
        PeRdxs dbModel = getRdxsById(model.getId());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getId()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peRdxsMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peRdxsMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }
    @Override
    public PeRdxs getRdxsByUserId(String joinUserId) {
        PeRdxs model = new PeRdxs();

        PeRdxsExample exp = new PeRdxsExample();
        PeRdxsExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeRdxs> list = peRdxsMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }
    @Override
    public PeRdxs getRdxsById(String putrecordId) {
        return peRdxsMapper.selectByPrimaryKey(putrecordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delRdxs(String joinUserId, String flowId) {

        PeRdxsExample exp = new PeRdxsExample();
        PeRdxsExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);
        int count = peRdxsMapper.deleteByExample(exp);
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }
        return count;

    }

    @Override
    public PeJxjykc getJxjykcByUserId(String joinUserId) {
        PeJxjykc model = new PeJxjykc();

        PeJxjykcExample exp = new PeJxjykcExample();
        PeJxjykcExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeJxjykc> list = peJxjykcMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }

    public PeJxjykc getJxjykcById(String Id) {
        return peJxjykcMapper.selectByPrimaryKey(Id);
    }
    public PeJxjykcqkWithBLOBs getJxjykcqkById(String Id) {
        return peJxjykcqkMapper.selectByPrimaryKey(Id);
    }
    @Override
    public int saveJxjykc(PeJxjykc model, List<PeJxjykcqkWithBLOBs> recordList, String flowId, String userId, String userName){
        int result = 0;
        PeJxjykc dbModel = getJxjykcById(model.getId());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getId()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peJxjykcMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peJxjykcMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        PeJxjykcqkExample example = new PeJxjykcqkExample();
        example.or().andKcidEqualTo(model.getId()).andOperatestateNotEqualTo("D");
        PeJxjykcqkWithBLOBs record=new PeJxjykcqkWithBLOBs();
        record.setOperatestate("D");
        record.setOperatetime(new Date());
        record.setSyncstate("N");

        peJxjykcqkMapper.updateByExampleSelective(record,example);

        for (PeJxjykcqkWithBLOBs item : recordList) {
            PeJxjykcqkWithBLOBs uModel = getJxjykcqkById(item.getId());
            if (uModel == null || (uModel != null && stringUtils.IsNullOrEmpty(uModel.getId()))) {
                item.setId(UUID.randomUUID().toString());
                item.setKcid(model.getId());
                item.setCreateuserid(userId);
                item.setCreateusername(userName);
                item.setCreatetime(new Date());
                //同步数据
                item.setOperatetime(new Date());
                item.setOperatestate("A");
                item.setSyncstate("N");
                peJxjykcqkMapper.insert(item);
            } else {
                item.setUpdateuserid(userId);
                item.setUpdateusername(userName);
                item.setUpdatetime(new Date());

                item.setOperatetime(new Date());
                item.setOperatestate("M");
                item.setSyncstate("N");
                peJxjykcqkMapper.updateByPrimaryKeySelective(item);
            }
        }

        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getJxjykcqkList(int page, int rows, String kcid) {
        PageHelper.startPage(page, rows);
        PeJxjykcqkExample exp= new PeJxjykcqkExample();
        exp.or().andKcidEqualTo(kcid).andOperatestateNotEqualTo("D");
        List<HashMap<String, Object>>  list = peUserCQuery.selectJxjykcqkList(kcid);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delJxjykc(String joinUserId, String flowId) {
        PeJxjykc model = getJxjykcByUserId(joinUserId);

        PeJxjykcqkExample rExp = new PeJxjykcqkExample();
        PeJxjykcqkExample.Criteria rCri = rExp.or();
        rCri.andKcidEqualTo(model.getId());
        peJxjykcqkMapper.deleteByExample(rExp);

        int count = peJxjykcMapper.deleteByPrimaryKey(model.getId());
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }

        return count;

    }


    @Override
    public int saveTczzsq(PeTczzsq model, String flowId, String userId, String userName) {
        int result = 0;
        PeTczzsq dbModel = getTczzsqById(model.getId());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getId()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peTczzsqMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peTczzsqMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }
    @Override
    public PeTczzsq getTczzsqByUserId(String joinUserId) {
        PeTczzsq model = new PeTczzsq();

        PeTczzsqExample exp = new PeTczzsqExample();
        PeTczzsqExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeTczzsq> list = peTczzsqMapper.selectByExampleWithBLOBs(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }
    @Override
    public PeTczzsq getTczzsqById(String putrecordId) {
        return peTczzsqMapper.selectByPrimaryKey(putrecordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delTczzsq(String joinUserId, String flowId) {

        PeTczzsqExample exp = new PeTczzsqExample();
        PeTczzsqExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);
        int count = peTczzsqMapper.deleteByExample(exp);
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }
        return count;

    }

    @Override
    public int saveZbdhtl(PeZbdhtl model, String flowId, String userId, String userName) {
        int result = 0;
        PeZbdhtl dbModel = getZbdhtlById(model.getId());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getId()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peZbdhtlMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peZbdhtlMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }
    @Override
    public PeZbdhtl getZbdhtlByUserId(String joinUserId) {
        PeZbdhtl model = new PeZbdhtl();

        PeZbdhtlExample exp = new PeZbdhtlExample();
        PeZbdhtlExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeZbdhtl> list = peZbdhtlMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }
    @Override
    public PeZbdhtl getZbdhtlById(String putrecordId) {
        return peZbdhtlMapper.selectByPrimaryKey(putrecordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delZbdhtl(String joinUserId, String flowId) {

        PeZbdhtlExample exp = new PeZbdhtlExample();
        PeZbdhtlExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);
        int count = peZbdhtlMapper.deleteByExample(exp);
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }
        return count;
    }

    @Override
    public int saveSjdwsp(PeSjdwsp model, String flowId, String userId, String userName) {
        int result = 0;
        PeSjdwsp dbModel = getSjdwspById(model.getId());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getId()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peSjdwspMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peSjdwspMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }
    @Override
    public PeSjdwsp getSjdwspByUserId(String joinUserId) {
        PeSjdwsp model = new PeSjdwsp();

        PeSjdwspExample exp = new PeSjdwspExample();
        PeSjdwspExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeSjdwsp> list = peSjdwspMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }
    @Override
    public PeSjdwsp getSjdwspById(String putrecordId) {
        return peSjdwspMapper.selectByPrimaryKey(putrecordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delSjdwsp(String joinUserId, String flowId) {

        PeSjdwspExample exp = new PeSjdwspExample();
        PeSjdwspExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);
        int count = peSjdwspMapper.deleteByExample(exp);
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }
        return count;

    }



    @Override
    public int saveZlgd(PeZlgd model, String flowId, String userId, String userName) {
        int result = 0;
        PeZlgd dbModel = getZlgdById(model.getId());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getId()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peZlgdMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peZlgdMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        return result;
    }
    @Override
    public PeZlgd getZlgdByUserId(String joinUserId) {
        PeZlgd model = new PeZlgd();

        PeZlgdExample exp = new PeZlgdExample();
        PeZlgdExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeZlgd> list = peZlgdMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }
    @Override
    public PeZlgd getZlgdById(String putrecordId) {
        return peZlgdMapper.selectByPrimaryKey(putrecordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delZlgd(String joinUserId, String flowId) {

        PeZlgdExample exp = new PeZlgdExample();
        PeZlgdExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);
        int count = peZlgdMapper.deleteByExample(exp);
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }
        return count;

    }

    @Override
    public PageInfo<HashMap<String, Object>> getSjprthmxList(int page, int rows, String sjprthId){
        PageHelper.startPage(page, rows);
        List<HashMap<String, Object>> list = peUserCQuery.selectSjprthmxList(sjprthId);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }
    @Override
    public int saveSjprth(PeSjprth model,List<PeSjprthmx> userList, String flowId, String userId, String userName) {
        int result = 0;
        PeSjprth dbModel = getSjprthById(model.getSjprthid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getSjprthid()))) {
            model.setCreatetime(new Date());
            model.setCreateuserid(userId);
            model.setCreateusername(userName);

            //同步数据
            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peSjprthMapper.insert(model);
        } else {
            model.setUpdatetime(new Date());
            model.setUpdateuserid(userId);
            model.setUpdateusername(userName);

            //同步数据
            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = peSjprthMapper.updateByPrimaryKey(model);
        }

        peUserFlowService.addUserFlow(model.getJoinuserid(), flowId, model.getProgresstime(), userId, userName);

        PeSjprthmxExample example = new PeSjprthmxExample();
        example.or().andSjprthidEqualTo(model.getSjprthid());
        peSjprthmxMapper.deleteByExample(example);

        for (PeSjprthmx item : userList) {
            PeSjprthmx uModel = peSjprthmxMapper.selectByPrimaryKey(item.getId());
            if (uModel == null || (uModel != null && stringUtils.IsNullOrEmpty(uModel.getId()))) {
                item.setId(UUID.randomUUID().toString());
                item.setSjprthid(model.getSjprthid());
                item.setCreateuserid(userId);
                item.setCreateusername(userName);
                item.setCreatetime(new Date());
                //同步数据
                item.setOperatetime(new Date());
                item.setOperatestate("A");
                item.setSyncstate("N");
                peSjprthmxMapper.insert(item);
            } else {
                item.setUpdateuserid(userId);
                item.setUpdateusername(userName);
                item.setUpdatetime(new Date());

                item.setOperatetime(new Date());
                item.setOperatestate("M");
                item.setSyncstate("N");
                peSjprthmxMapper.updateByPrimaryKeySelective(item);
            }
        }
        return result;
    }
    @Override
    public PeSjprth getSjprthByUserId(String joinUserId) {
        PeSjprth model = new PeSjprth();

        PeSjprthExample exp = new PeSjprthExample();
        PeSjprthExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);

        List<PeSjprth> list = peSjprthMapper.selectByExample(exp);
        if (list.size() > 0) {
            model = list.get(0);
        }

        return model;
    }
    @Override
    public PeSjprth getSjprthById(String putrecordId) {
        return peSjprthMapper.selectByPrimaryKey(putrecordId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delSjprth(String joinUserId, String flowId) {

        PeSjprthExample exp = new PeSjprthExample();
        PeSjprthExample.Criteria cri = exp.or();
        cri.andJoinuseridEqualTo(joinUserId);
        int count = peSjprthMapper.deleteByExample(exp);
        if (count > 0) {
            peUserFlowService.delUserFlow(joinUserId, flowId);
        }
        return count;

    }
}
