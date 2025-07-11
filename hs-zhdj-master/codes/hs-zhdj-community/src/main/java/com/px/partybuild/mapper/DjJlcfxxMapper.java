package com.px.partybuild.mapper;

import com.px.partybuild.model.DjJlcfxx;
import com.px.partybuild.model.DjJlcfxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjJlcfxxMapper {
    long countByExample(DjJlcfxxExample example);

    int deleteByExample(DjJlcfxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(DjJlcfxx record);

    int insertSelective(DjJlcfxx record);

    List<DjJlcfxx> selectByExampleWithBLOBs(DjJlcfxxExample example);

    List<DjJlcfxx> selectByExample(DjJlcfxxExample example);

    DjJlcfxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DjJlcfxx record, @Param("example") DjJlcfxxExample example);

    int updateByExampleWithBLOBs(@Param("record") DjJlcfxx record, @Param("example") DjJlcfxxExample example);

    int updateByExample(@Param("record") DjJlcfxx record, @Param("example") DjJlcfxxExample example);

    int updateByPrimaryKeySelective(DjJlcfxx record);

    int updateByPrimaryKeyWithBLOBs(DjJlcfxx record);

    int updateByPrimaryKey(DjJlcfxx record);
}