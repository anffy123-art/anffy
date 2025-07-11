package com.px.partybuild.mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 字典
 *
 * @author H
 */
public interface PartyDictionaryCQuery {

    /**
     * 出国出境原因
     * @return
     */
    List<HashMap<String, Object>> selectCglbList();

    /**
     * 出国出境类别
     * @return
     */
    List<HashMap<String, Object>> selectCgcjlbList();

    /**
     * 培训情况
     * @return
     */
    List<HashMap<String, Object>> selectPxqkList();

    /**
     * 一线情况
     * @return
     */
    List<HashMap<String, Object>> selectYxqkList();

    /**
     * 最近培训结果
     * @return
     */
    List<HashMap<String, Object>> selectZjpxjgList();

    /**
     * 专职或兼职情况
     * @return
     */
    List<HashMap<String, Object>> selectZzjzqkList();

    /**
     * 职务级别2
     * @return
     */
    List<HashMap<String, Object>> selectDzzwjbm2List();

    /**
     * 学历
     * @return
     */
    List<HashMap<String, Object>> selectEducationList();

    /**
     * 民族
     * @return
     */
    List<HashMap<String, Object>> selectNationList();

    /**
     * 行政职务
     * @return
     */
    List<HashMap<String, Object>> selectXzzwList();

    /**
     * 合并字典
     * @return
     */
    List<HashMap<String, Object>> selectUserDicList();

}
