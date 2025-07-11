package com.px.partybuild.mapper;

import com.px.partybuild.model.DjTask;
import com.px.partybuild.model.DjTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjTaskMapper {
    long countByExample(DjTaskExample example);

    int deleteByExample(DjTaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(DjTask record);

    int insertSelective(DjTask record);

    List<DjTask> selectByExample(DjTaskExample example);

    DjTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DjTask record, @Param("example") DjTaskExample example);

    int updateByExample(@Param("record") DjTask record, @Param("example") DjTaskExample example);

    int updateByPrimaryKeySelective(DjTask record);

    int updateByPrimaryKey(DjTask record);
}