package com.px.partybuild.service.impl;

import com.px.partybuild.mapper.CfDictionaryMapper;
import com.px.partybuild.model.CfDictionary;
import com.px.partybuild.model.CfDictionaryExample;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author H
 * @date 2024-08
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private CfDictionaryMapper cfDictionaryMapper;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private MapUtils mapUtils;


    @Override
    public PageInfo<CfDictionary> getDictionaryList(String appId, String dicTypeKey, String dicvalue, int pageIndex, int pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        CfDictionaryExample exp = new CfDictionaryExample();
        CfDictionaryExample.Criteria cri = exp.or();
        exp.setOrderByClause("DicTypeKey ASC,DicKey ASC");

        cri.andOperatestateNotEqualTo("D");

        if (!stringUtils.IsNullOrEmpty(dicTypeKey)) {
            cri.andDictypekeyLike("%" + dicTypeKey + "%");
        }
        if (!stringUtils.IsNullOrEmpty(dicvalue)) {
            cri.andDicvalueLike("%" + dicvalue + "%");
        }

        List<CfDictionary> ListDic = cfDictionaryMapper.selectByExample(exp);

        PageInfo<CfDictionary> result = new PageInfo(ListDic);

        return result;
    }

    @Override
    public CfDictionary getDictionaryById(String dictionaryId) {

        return cfDictionaryMapper.selectByPrimaryKey(dictionaryId);
    }

    @Override
    public int saveDictionary(CfDictionary model) {

        int result = 0;
        if (stringUtils.IsNullOrEmpty(model.getDictionaryid())) {
            model.setDictionaryid(UUID.randomUUID().toString());

            model.setOperatestate("A");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = cfDictionaryMapper.insert(model);
        } else {

            model.setOperatestate("M");
            model.setOperatetime(new Date());
            model.setSyncstate("N");

            result = cfDictionaryMapper.updateByPrimaryKeyWithBLOBs(model);
        }

        return result;
    }

    @Override
    public int delDictionary(String dictionaryid) {
        //return cfDictionaryMapper.deleteByPrimaryKey(dictionaryid);

        CfDictionary model = getDictionaryById(dictionaryid);

        model.setOperatestate("D");
        model.setOperatetime(new Date());
        model.setSyncstate("N");

        return cfDictionaryMapper.updateByPrimaryKey(model);
    }

    @Override
    @Cacheable(value = "dictionary",key="#p0")
    public List<CfDictionary> getDictionaryListByDicTypeKey(String dicTypeKey) {
        CfDictionaryExample exp = new CfDictionaryExample();
        CfDictionaryExample.Criteria cri = exp.or().andDictypekeyEqualTo(dicTypeKey);

        cri.andOperatestateNotEqualTo("D");

        exp.setOrderByClause("DicKey ASC");
        List<CfDictionary> list = cfDictionaryMapper.selectByExampleWithBLOBs(exp);

        return list;
    }

    @Override
    public PageInfo<CfDictionary> findDictionaryList(String dicTypeKey, String DicType, int pageIndex, int pageSize) {

        CfDictionaryExample exp = new CfDictionaryExample();

        exp.or().andOperatestateNotEqualTo("D");

        PageHelper.startPage(pageIndex, pageSize);

        if (!stringUtils.IsNullOrEmpty(dicTypeKey)) {
            exp.or().andDictypekeyLike("%" + dicTypeKey + "%");
        }

        if (!stringUtils.IsNullOrEmpty(DicType)) {
            exp.or().andDicvalueLike("%" + DicType + "%");
        }

        List<CfDictionary> list = cfDictionaryMapper.selectByExample(exp);

        PageInfo<CfDictionary> result = new PageInfo(list);
        return result;
    }

    @Override
    public CfDictionary getDicByKey(Integer dicKey, List<CfDictionary> dicList) {
        CfDictionary dic = new CfDictionary();

        if(dicKey == null){
            return dic;
        }

        for (CfDictionary tIt : dicList) {
            /*
            CfDictionary tIt=null;
            if(it.getClass().equals(CfDictionary.class)){
                tIt=(CfDictionary)it;
            } else {
                tIt=mapUtils.mapToObject((Map<String,Object>)it,CfDictionary.class);
            }*/

            if (dicKey.equals(tIt.getDickey().intValue())) {
                dic = tIt;
            }
        }

        return dic;
    }

    @Override
    public Integer getDickeyByName(String name, List<CfDictionary> dataList) {
        if (stringUtils.IsNullOrEmpty(name))
            return null;
        CfDictionary cfDictionary = dataList.stream().filter(it -> it.getDicvalue().equals(name)).findFirst().orElse(null);

        return cfDictionary != null ? cfDictionary.getDickey() : null;
    }

}
