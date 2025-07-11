package com.px.partybuild.mapper;

import com.px.partybuild.model.DjDnpxry;
import com.px.partybuild.model.DjDnpxryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjDnpxryMapper {
    long countByExample(DjDnpxryExample example);

    int deleteByExample(DjDnpxryExample example);

    int deleteByPrimaryKey(String id);

    int insert(DjDnpxry record);

    int insertSelective(DjDnpxry record);

    List<DjDnpxry> selectByExample(DjDnpxryExample example);

    DjDnpxry selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DjDnpxry record, @Param("example") DjDnpxryExample example);

    int updateByExample(@Param("record") DjDnpxry record, @Param("example") DjDnpxryExample example);

    int updateByPrimaryKeySelective(DjDnpxry record);

    int updateByPrimaryKey(DjDnpxry record);
}