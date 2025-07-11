package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzDjxx;
import com.px.partybuild.model.ZzDjxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzDjxxMapper {
    long countByExample(ZzDjxxExample example);

    int deleteByExample(ZzDjxxExample example);

    int insert(ZzDjxx record);

    int insertSelective(ZzDjxx record);

    List<ZzDjxx> selectByExample(ZzDjxxExample example);

    int updateByExampleSelective(@Param("record") ZzDjxx record, @Param("example") ZzDjxxExample example);

    int updateByExample(@Param("record") ZzDjxx record, @Param("example") ZzDjxxExample example);
}