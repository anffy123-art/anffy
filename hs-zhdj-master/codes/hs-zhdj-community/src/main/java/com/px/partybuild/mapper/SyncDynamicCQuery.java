package com.px.partybuild.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SyncDynamicCQuery {
    int InsertDynamicTable(@Param("tableName")String tableName,@Param("row") Map<String,Object> row);
    List<Map<String,Object>> FindDataRowsByPK(@Param("tableName")String tableName, @Param("primaryKey")String primaryKey,@Param("ids")List<String> ids);
    List<Map<String,Object>> GetNewDataRows(@Param("tableName")String tableName);
    int UpdateLocalDataRow(@Param("tableName")String tableName,@Param("primaryKey") String primaryKey,@Param("row")Map<String,Object> row);
    int UpdateDataRowState(@Param("tableName")String tableName, @Param("primaryKey")String primaryKey,@Param("ids")List<String> ids);

}
