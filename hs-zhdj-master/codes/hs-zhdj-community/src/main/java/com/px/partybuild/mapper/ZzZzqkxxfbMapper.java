package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzZzqkxxfb;
import com.px.partybuild.model.ZzZzqkxxfbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzZzqkxxfbMapper {
    long countByExample(ZzZzqkxxfbExample example);

    int deleteByExample(ZzZzqkxxfbExample example);

    int deleteByPrimaryKey(String dzzdm);

    int insert(ZzZzqkxxfb record);

    int insertSelective(ZzZzqkxxfb record);

    List<ZzZzqkxxfb> selectByExample(ZzZzqkxxfbExample example);

    ZzZzqkxxfb selectByPrimaryKey(String dzzdm);

    int updateByExampleSelective(@Param("record") ZzZzqkxxfb record, @Param("example") ZzZzqkxxfbExample example);

    int updateByExample(@Param("record") ZzZzqkxxfb record, @Param("example") ZzZzqkxxfbExample example);

    int updateByPrimaryKeySelective(ZzZzqkxxfb record);

    int updateByPrimaryKey(ZzZzqkxxfb record);
}