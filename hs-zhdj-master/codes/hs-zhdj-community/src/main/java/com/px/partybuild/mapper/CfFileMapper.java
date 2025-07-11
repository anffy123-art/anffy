package com.px.partybuild.mapper;

import com.px.partybuild.model.CfFile;
import com.px.partybuild.model.CfFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfFileMapper {
    long countByExample(CfFileExample example);

    int deleteByExample(CfFileExample example);

    int deleteByPrimaryKey(String fileid);

    int insert(CfFile record);

    int insertSelective(CfFile record);

    List<CfFile> selectByExampleWithBLOBs(CfFileExample example);

    List<CfFile> selectByExample(CfFileExample example);

    CfFile selectByPrimaryKey(String fileid);

    int updateByExampleSelective(@Param("record") CfFile record, @Param("example") CfFileExample example);

    int updateByExampleWithBLOBs(@Param("record") CfFile record, @Param("example") CfFileExample example);

    int updateByExample(@Param("record") CfFile record, @Param("example") CfFileExample example);

    int updateByPrimaryKeySelective(CfFile record);

    int updateByPrimaryKeyWithBLOBs(CfFile record);

    int updateByPrimaryKey(CfFile record);
}