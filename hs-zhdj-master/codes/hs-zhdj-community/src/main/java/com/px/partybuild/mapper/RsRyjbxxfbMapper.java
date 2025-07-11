package com.px.partybuild.mapper;

import com.px.partybuild.model.RsRyjbxxfb;
import com.px.partybuild.model.RsRyjbxxfbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RsRyjbxxfbMapper {
    long countByExample(RsRyjbxxfbExample example);

    int deleteByExample(RsRyjbxxfbExample example);

    int deleteByPrimaryKey(String rybm);

    int insert(RsRyjbxxfb record);

    int insertSelective(RsRyjbxxfb record);

    List<RsRyjbxxfb> selectByExample(RsRyjbxxfbExample example);

    RsRyjbxxfb selectByPrimaryKey(String rybm);

    int updateByExampleSelective(@Param("record") RsRyjbxxfb record, @Param("example") RsRyjbxxfbExample example);

    int updateByExample(@Param("record") RsRyjbxxfb record, @Param("example") RsRyjbxxfbExample example);

    int updateByPrimaryKeySelective(RsRyjbxxfb record);

    int updateByPrimaryKey(RsRyjbxxfb record);
}