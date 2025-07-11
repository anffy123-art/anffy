package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.CfDictionary;

import java.util.List;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface DictionaryService {
    /**
     * 获取字典列表
     * @param appId id
     * @param dicTypeKey key
     * @param dicvalue key
     * @param pageIndex 1
     * @param pageSize 10
     * @return list
     */
    PageInfo<CfDictionary> getDictionaryList(String appId, String dicTypeKey, String dicvalue, int pageIndex, int pageSize);

    /**
     * 字典实体
     * @param dictionaryId id
     * @return m
     */
    CfDictionary getDictionaryById(String dictionaryId);

    /**
     * 保存
     * @param model m
     * @return row
     */
    int saveDictionary(CfDictionary model);

    /**
     * 删除
     * @param dictionaryid id
     * @return row
     */
    int delDictionary(String dictionaryid);

    /**
     * 字典列表
     * @param dicTypeKey key
     * @return list
     */
    List<CfDictionary> getDictionaryListByDicTypeKey(String dicTypeKey);

    /**
     * 查找字典
     * @param dicTypeKey key
     * @param DicType dt
     * @param pageIndex 1
     * @param pageSize 10
     * @return list
     */
    PageInfo<CfDictionary> findDictionaryList(String dicTypeKey, String DicType, int pageIndex, int pageSize);

    /**
     * 字典对象
     * @param dicKey key
     * @param dicList list
     * @return m
     */
    CfDictionary getDicByKey(Integer dicKey, List<CfDictionary> dicList);

    /**
     * 字典对象
     * @param name name
     * @param dataList list
     * @return m
     */
    Integer getDickeyByName(String name, List<CfDictionary> dataList);

}
