package com.px.partybuild.mapper;

import com.px.partybuild.model.DjDnghbf;
import com.px.partybuild.model.DjDnghbfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjDnghbfMapper {
    long countByExample(DjDnghbfExample example);

    int deleteByExample(DjDnghbfExample example);

    int deleteByPrimaryKey(String id);

    int insert(DjDnghbf record);

    int insertSelective(DjDnghbf record);

    List<DjDnghbf> selectByExample(DjDnghbfExample example);

    DjDnghbf selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DjDnghbf record, @Param("example") DjDnghbfExample example);

    int updateByExample(@Param("record") DjDnghbf record, @Param("example") DjDnghbfExample example);

    int updateByPrimaryKeySelective(DjDnghbf record);

    int updateByPrimaryKey(DjDnghbf record);
}