package com.px.partybuild.mapper;

import com.px.partybuild.vo.DsjTreeFiletype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface CfFileCQuery {
    List<DsjTreeFiletype> selectTreeFiles(@Param("pFileId") String pFileId,@Param("typename") String typename,@Param("typeIds") List<String> typeIds,@Param("passTypeIds") List<String> passTypeIds);

    List<Map<String,Object>> FindDSJ_File(@Param("fileName") String fileName,@Param("typeIds") List<String> typeIds);

    List<Map<String,Object>> FindTestResult(@Param("fileRefId") String fileRefId);
}
