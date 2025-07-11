package com.px.partybuild.mapper;

import com.px.partybuild.model.DjWorkresourcelibrarytype;
import com.px.partybuild.model.DjWorkresourcelibrarytypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjWorkresourcelibrarytypeMapper {
    long countByExample(DjWorkresourcelibrarytypeExample example);

    int deleteByExample(DjWorkresourcelibrarytypeExample example);

    int deleteByPrimaryKey(String filetypeid);

    int insert(DjWorkresourcelibrarytype record);

    int insertSelective(DjWorkresourcelibrarytype record);

    List<DjWorkresourcelibrarytype> selectByExample(DjWorkresourcelibrarytypeExample example);

    DjWorkresourcelibrarytype selectByPrimaryKey(String filetypeid);

    int updateByExampleSelective(@Param("record") DjWorkresourcelibrarytype record, @Param("example") DjWorkresourcelibrarytypeExample example);

    int updateByExample(@Param("record") DjWorkresourcelibrarytype record, @Param("example") DjWorkresourcelibrarytypeExample example);

    int updateByPrimaryKeySelective(DjWorkresourcelibrarytype record);

    int updateByPrimaryKey(DjWorkresourcelibrarytype record);
}