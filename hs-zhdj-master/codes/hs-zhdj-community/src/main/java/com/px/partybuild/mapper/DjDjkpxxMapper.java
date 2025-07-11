package com.px.partybuild.mapper;

import com.px.partybuild.model.DjDjkpxx;
import com.px.partybuild.model.DjDjkpxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjDjkpxxMapper {
    long countByExample(DjDjkpxxExample example);

    int deleteByExample(DjDjkpxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(DjDjkpxx record);

    int insertSelective(DjDjkpxx record);

    List<DjDjkpxx> selectByExample(DjDjkpxxExample example);

    DjDjkpxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DjDjkpxx record, @Param("example") DjDjkpxxExample example);

    int updateByExample(@Param("record") DjDjkpxx record, @Param("example") DjDjkpxxExample example);

    int updateByPrimaryKeySelective(DjDjkpxx record);

    int updateByPrimaryKey(DjDjkpxx record);
}