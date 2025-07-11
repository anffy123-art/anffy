package com.px.partybuild.mapper;

import com.px.partybuild.vo.DjWorkresourcelibraryVo;
import com.px.partybuild.vo.DsjTreeFiletype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DjWorkresourcelibraryCQuery {
    List<DsjTreeFiletype> selectTreeFiles(@Param("pFileId") String pFileId,@Param("typename") String typename,@Param("typeIds") List<String> typeIds,@Param("passTypeIds") List<String> passTypeIds);

    List<Map<String,Object>> FindDSJ_File(@Param("fileName") String fileName,@Param("typeIds") List<String> typeIds);

    List<DjWorkresourcelibraryVo> getFilesByKey(@Param("fileName") String fileName, @Param("typeIds") List<String> typeIds);
}
