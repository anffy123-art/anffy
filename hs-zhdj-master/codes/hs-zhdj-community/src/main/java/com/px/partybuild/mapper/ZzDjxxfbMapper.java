package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzDjxxfb;
import com.px.partybuild.model.ZzDjxxfbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzDjxxfbMapper {
    long countByExample(ZzDjxxfbExample example);

    int deleteByExample(ZzDjxxfbExample example);

    int deleteByPrimaryKey(String rybm);

    int insert(ZzDjxxfb record);

    int insertSelective(ZzDjxxfb record);

    List<ZzDjxxfb> selectByExample(ZzDjxxfbExample example);

    ZzDjxxfb selectByPrimaryKey(String rybm);

    int updateByExampleSelective(@Param("record") ZzDjxxfb record, @Param("example") ZzDjxxfbExample example);

    int updateByExample(@Param("record") ZzDjxxfb record, @Param("example") ZzDjxxfbExample example);

    int updateByPrimaryKeySelective(ZzDjxxfb record);

    int updateByPrimaryKey(ZzDjxxfb record);
}