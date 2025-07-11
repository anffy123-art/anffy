package com.px.partybuild.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface SyncService {
    /**
     * db rows
     * @param tableName
     * @param withBlog
     * @param DBRows
     * @param beginTime
     * @return
     */
    List<Object> dbdatarows(String tableName, Boolean withBlog, List<String> DBRows, Date beginTime);

    /**
     * db row result
     * @param tableName
     * @param withBlog
     * @param ids
     * @return
     */
    Integer dbdatarowresult(String tableName, Boolean withBlog, List<String> ids);

    /**
     * is valid
     * @param word
     * @param dt
     * @return
     */
    Boolean isValid(String word, Date dt);

}
