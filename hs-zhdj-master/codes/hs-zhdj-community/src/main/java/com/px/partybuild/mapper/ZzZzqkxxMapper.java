package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzZzqkxx;
import com.px.partybuild.model.ZzZzqkxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzZzqkxxMapper {
    long countByExample(ZzZzqkxxExample example);

    int deleteByExample(ZzZzqkxxExample example);

    int insert(ZzZzqkxx record);

    int insertSelective(ZzZzqkxx record);

    List<ZzZzqkxx> selectByExample(ZzZzqkxxExample example);

    int updateByExampleSelective(@Param("record") ZzZzqkxx record, @Param("example") ZzZzqkxxExample example);

    int updateByExample(@Param("record") ZzZzqkxx record, @Param("example") ZzZzqkxxExample example);
}