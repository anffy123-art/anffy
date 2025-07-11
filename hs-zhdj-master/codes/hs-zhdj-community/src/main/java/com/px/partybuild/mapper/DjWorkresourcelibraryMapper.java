package com.px.partybuild.mapper;

import com.px.partybuild.model.DjWorkresourcelibrary;
import com.px.partybuild.model.DjWorkresourcelibraryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjWorkresourcelibraryMapper {
    long countByExample(DjWorkresourcelibraryExample example);

    int deleteByExample(DjWorkresourcelibraryExample example);

    int deleteByPrimaryKey(String fileid);

    int insert(DjWorkresourcelibrary record);

    int insertSelective(DjWorkresourcelibrary record);

    List<DjWorkresourcelibrary> selectByExample(DjWorkresourcelibraryExample example);

    DjWorkresourcelibrary selectByPrimaryKey(String fileid);

    int updateByExampleSelective(@Param("record") DjWorkresourcelibrary record, @Param("example") DjWorkresourcelibraryExample example);

    int updateByExample(@Param("record") DjWorkresourcelibrary record, @Param("example") DjWorkresourcelibraryExample example);

    int updateByPrimaryKeySelective(DjWorkresourcelibrary record);

    int updateByPrimaryKey(DjWorkresourcelibrary record);
}