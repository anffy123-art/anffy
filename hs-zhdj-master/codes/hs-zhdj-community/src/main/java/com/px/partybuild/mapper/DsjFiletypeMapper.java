package com.px.partybuild.mapper;

import com.px.partybuild.model.DsjFiletype;
import com.px.partybuild.model.DsjFiletypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsjFiletypeMapper {
    long countByExample(DsjFiletypeExample example);

    int deleteByExample(DsjFiletypeExample example);

    int deleteByPrimaryKey(String filetypeid);

    int insert(DsjFiletype record);

    int insertSelective(DsjFiletype record);

    List<DsjFiletype> selectByExample(DsjFiletypeExample example);

    DsjFiletype selectByPrimaryKey(String filetypeid);

    int updateByExampleSelective(@Param("record") DsjFiletype record, @Param("example") DsjFiletypeExample example);

    int updateByExample(@Param("record") DsjFiletype record, @Param("example") DsjFiletypeExample example);

    int updateByPrimaryKeySelective(DsjFiletype record);

    int updateByPrimaryKey(DsjFiletype record);
}