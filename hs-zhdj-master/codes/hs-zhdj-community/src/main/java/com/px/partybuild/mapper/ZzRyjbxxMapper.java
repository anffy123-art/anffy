package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzRyjbxx;
import com.px.partybuild.model.ZzRyjbxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzRyjbxxMapper {
    long countByExample(ZzRyjbxxExample example);

    int deleteByExample(ZzRyjbxxExample example);

    int insert(ZzRyjbxx record);

    int insertSelective(ZzRyjbxx record);

    List<ZzRyjbxx> selectByExample(ZzRyjbxxExample example);

    int updateByExampleSelective(@Param("record") ZzRyjbxx record, @Param("example") ZzRyjbxxExample example);

    int updateByExample(@Param("record") ZzRyjbxx record, @Param("example") ZzRyjbxxExample example);
}