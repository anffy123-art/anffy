package com.px.partybuild.mapper;

import com.px.partybuild.model.DjDnghbfmx;
import com.px.partybuild.model.DjDnghbfmxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjDnghbfmxMapper {
    long countByExample(DjDnghbfmxExample example);

    int deleteByExample(DjDnghbfmxExample example);

    int deleteByPrimaryKey(String id);

    int insert(DjDnghbfmx record);

    int insertSelective(DjDnghbfmx record);

    List<DjDnghbfmx> selectByExample(DjDnghbfmxExample example);

    DjDnghbfmx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DjDnghbfmx record, @Param("example") DjDnghbfmxExample example);

    int updateByExample(@Param("record") DjDnghbfmx record, @Param("example") DjDnghbfmxExample example);

    int updateByPrimaryKeySelective(DjDnghbfmx record);

    int updateByPrimaryKey(DjDnghbfmx record);
}