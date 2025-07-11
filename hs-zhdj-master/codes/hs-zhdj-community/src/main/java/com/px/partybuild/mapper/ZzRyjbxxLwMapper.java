package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzRyjbxxLw;
import com.px.partybuild.model.ZzRyjbxxLwExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzRyjbxxLwMapper {
    long countByExample(ZzRyjbxxLwExample example);

    int deleteByExample(ZzRyjbxxLwExample example);

    int insert(ZzRyjbxxLw record);

    int insertSelective(ZzRyjbxxLw record);

    List<ZzRyjbxxLw> selectByExample(ZzRyjbxxLwExample example);

    int updateByExampleSelective(@Param("record") ZzRyjbxxLw record, @Param("example") ZzRyjbxxLwExample example);

    int updateByExample(@Param("record") ZzRyjbxxLw record, @Param("example") ZzRyjbxxLwExample example);
}