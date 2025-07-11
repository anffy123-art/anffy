package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.*;
import com.px.partybuild.model.*;
import com.px.partybuild.service.GradeService;
import com.px.partybuild.service.PartyService;
import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 领导班子
 *
 * @author H
 */
@Service("gradeService")
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeCQuery gradeCquery;
    @Autowired
    private ZzBzcyxxMapper zzBzcyxxMapper;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private ZzBzjcxxMapper zzBzjcxxMapper;
    @Autowired
    private ZzBzjcxxfbMapper zzBzjcxxfbMapper;
    @Autowired
    private PartyService partyService;
    @Autowired
    private ZzZzqkxxfbMapper zzZzqkxxfbMapper;

    @Override
    public PageInfo<HashMap<String, Object>> getGradeList(int pageNum, int pageSize, String dzzdm, String ldjtjc, String dzzmc, String xjfs,
                                                          String gjjmrqBegin, String gjjmrqEnd, Integer zzfbType, String ssdzzdm, List<String> zzlb, List<String> jczzfl, Integer sfzdjc) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = gradeCquery.selectGradeList(dzzdm, ldjtjc, dzzmc, xjfs, gjjmrqBegin, gjjmrqEnd, zzfbType, ssdzzdm, zzlb, jczzfl, sfzdjc);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public List<ZzBzjcxx> getGradeListByDzzdm(String dzzdm) {
        ZzBzjcxxExample exp = new ZzBzjcxxExample();
        ZzBzjcxxExample.Criteria cri = exp.or();
        cri.andDzzdmEqualTo(dzzdm);

        return zzBzjcxxMapper.selectByExample(exp);
    }

    @Override
    public ZzBzjcxx getGradeById(String id) {
        ZzBzjcxx zzBzjcxx = new ZzBzjcxx();
        ZzBzjcxxExample exp = new ZzBzjcxxExample();
        ZzBzjcxxExample.Criteria cri = exp.or();
        cri.andBzjcxxbsEqualTo(id);
        List<ZzBzjcxx> list = zzBzjcxxMapper.selectByExample(exp);
        if (list.size() > 0) {
            zzBzjcxx = list.get(0);
        }
        return zzBzjcxx;
    }

    @Override
    public ZzBzjcxxfb getGradeFbById(String id) {
        return zzBzjcxxfbMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveGrade(ZzBzjcxx zzBzjcxx, ZzBzjcxxfb zzBzjcxxfb) throws Exception {

        ZzBzjcxxExample expJc = new ZzBzjcxxExample();
        ZzBzjcxxExample.Criteria criJc = expJc.or();
        criJc.andDzzdmEqualTo(zzBzjcxx.getDzzdm()).andLdjtjcEqualTo(zzBzjcxx.getLdjtjc()).andBzjcxxbsNotEqualTo(zzBzjcxx.getBzjcxxbs());

        List<ZzBzjcxx> dbList = zzBzjcxxMapper.selectByExample(expJc);
        if (dbList.size() > 0) {
            throw new Exception("该届次已存在，请修改届次！");
        }

        int result = 0;
        ZzBzjcxx model = getGradeById(zzBzjcxx.getBzjcxxbs());
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getBzjcxxbs()))) {
            result = zzBzjcxxMapper.insert(zzBzjcxx);
        } else {
            ZzBzjcxxExample exp = new ZzBzjcxxExample();
            ZzBzjcxxExample.Criteria cri = exp.or();
            cri.andBzjcxxbsEqualTo(zzBzjcxx.getBzjcxxbs());
            result = zzBzjcxxMapper.updateByExampleSelective(zzBzjcxx, exp);
        }

        //副表信息
        ZzBzjcxxfb fbModel = getGradeFbById(zzBzjcxx.getBzjcxxbs());
        if (fbModel == null || (fbModel != null && stringUtils.IsNullOrEmpty(fbModel.getBzjcxxbs()))) {
            result = zzBzjcxxfbMapper.insert(zzBzjcxxfb);
        } else {
            result = zzBzjcxxfbMapper.updateByPrimaryKey(zzBzjcxxfb);
        }

        updateMaxjc(zzBzjcxx.getDzzdm());

        return result;
    }

    @Override
    public int deleteGradeById(String id) {
        int result = 0;

        ZzBzjcxx model = getGradeById(id);

        ZzBzjcxxExample exp = new ZzBzjcxxExample();
        ZzBzjcxxExample.Criteria cri = exp.or();
        cri.andBzjcxxbsEqualTo(id);
        result = zzBzjcxxMapper.deleteByExample(exp);

        if (result > 0 && model != null) {
            updateMaxjc(model.getDzzdm());
        }

        return result;
    }

    public void updateMaxjc(String dzzdm) {
        if (!stringUtils.IsNullOrEmpty(dzzdm)) {
            String jc = "";

            List<HashMap<String, Object>> gradeList = gradeCquery.selectMaxJCList(dzzdm);
            if (gradeList.size() > 0) {
                jc = gradeList.get(0).get("JC").toString();
            }

            ZzZzqkxxfb zzfbModel = partyService.getPartyFbById(dzzdm);
            if (zzfbModel == null || (zzfbModel != null && stringUtils.IsNullOrEmpty(zzfbModel.getDzzdm()))) {
                zzfbModel = new ZzZzqkxxfb();
                zzfbModel.setDzzdm(dzzdm);
                zzfbModel.setLdjtjc(jc);
                zzZzqkxxfbMapper.insert(zzfbModel);
            } else {
                zzfbModel.setLdjtjc(jc);
                zzZzqkxxfbMapper.updateByPrimaryKey(zzfbModel);
            }
        }
    }

    @Override
    public PageInfo<HashMap<String, Object>> getGradeUserList(int pageNum, int pageSize, String dzzdm, String ldjtjc, String dzzmc, String xm,
                                                              List<String> zwmc, String rzfs, Integer onlyshowDw, Integer zzfbType, String ssdzzdm, String zzjzqk, Integer isMaxJc) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = gradeCquery.selectGradeUserList(dzzdm, ldjtjc, dzzmc, xm, zwmc, rzfs, onlyshowDw, zzfbType, ssdzzdm, zzjzqk, isMaxJc);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public PageInfo<HashMap<String, Object>> getMaxGradeUserList(int pageNum, int pageSize, String dzzdm, String ldjtjc, String dzzmc, String xm,
                                                                 String zwmc, String rzfs, Integer onlyshowDw, Integer zzfbType, String ssdzzdm, String rybm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = gradeCquery.selectMaxGradeUserList(dzzdm, ldjtjc, dzzmc, xm, zwmc, rzfs, onlyshowDw, zzfbType, ssdzzdm, rybm);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public ZzBzcyxx getGradeUserById(String id) {
        ZzBzcyxx zzBzcyxx = new ZzBzcyxx();
        ZzBzcyxxExample exp = new ZzBzcyxxExample();
        ZzBzcyxxExample.Criteria cri = exp.or();
        cri.andBzcyxxbsEqualTo(id);
        List<ZzBzcyxx> list = zzBzcyxxMapper.selectByExample(exp);
        if (list.size() > 0) {
            zzBzcyxx = list.get(0);
        }
        return zzBzcyxx;
    }

    @Override
    public int saveGradeUser(ZzBzcyxx zzBzcyxx) {
        int result = 0;
        ZzBzcyxx model = getGradeUserById(zzBzcyxx.getBzcyxxbs());
        if (model == null || (model != null && stringUtils.IsNullOrEmpty(model.getBzcyxxbs()))) {
            result = zzBzcyxxMapper.insert(zzBzcyxx);
        } else {
            ZzBzcyxxExample exp = new ZzBzcyxxExample();
            ZzBzcyxxExample.Criteria cri = exp.or();
            cri.andBzcyxxbsEqualTo(zzBzcyxx.getBzcyxxbs());
            result = zzBzcyxxMapper.updateByExampleSelective(zzBzcyxx, exp);
        }

        return result;
    }

    @Override
    public int deleteGradeUserById(String id) {
        ZzBzcyxxExample exp = new ZzBzcyxxExample();
        ZzBzcyxxExample.Criteria cri = exp.or();
        cri.andBzcyxxbsEqualTo(id);
        return zzBzcyxxMapper.deleteByExample(exp);
    }

    @Override
    public int updatePartySchjsj() {
        int count = 0;
        List<HashMap<String, Object>> gradeList = gradeCquery.selectMaxJCList(null);
        for (HashMap<String, Object> it : gradeList) {
            ZzZzqkxxfb zzfbModel = partyService.getPartyFbById(it.get("DZZDM").toString());

            if (zzfbModel == null || (zzfbModel != null && stringUtils.IsNullOrEmpty(zzfbModel.getDzzdm()))) {
                zzfbModel = new ZzZzqkxxfb();
                zzfbModel.setDzzdm(zzfbModel.getDzzdm());
                zzfbModel.setLdjtjc(gradeList.get(0).get("JC").toString());
                count += zzZzqkxxfbMapper.insert(zzfbModel);
            } else {
                zzfbModel.setLdjtjc(gradeList.get(0).get("JC").toString());
                count += zzZzqkxxfbMapper.updateByPrimaryKey(zzfbModel);
            }
        }

        return count;
    }


    @Override
    public PageInfo<HashMap<String, Object>> getMaxGradeList(int pageNum, int pageSize, String dzzdm, Integer year, String childDzzdm) {
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String, Object>> list = gradeCquery.selectMaxGradeList(dzzdm, year, childDzzdm);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public List<HashMap<String, Object>> getReplaceTotalList(String dzzdm, Integer year) {
        List<HashMap<String, Object>> list = gradeCquery.selectReplaceTotalList(dzzdm, year);
        return list;
    }

}
