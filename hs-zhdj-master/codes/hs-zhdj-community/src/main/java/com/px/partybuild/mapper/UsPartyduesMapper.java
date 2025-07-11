package com.px.partybuild.mapper;

import com.px.partybuild.model.UsPartydues;
import com.px.partybuild.model.UsPartyduesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsPartyduesMapper {
    long countByExample(UsPartyduesExample example);

    int deleteByExample(UsPartyduesExample example);

    int deleteByPrimaryKey(String partyduesid);

    int insert(UsPartydues record);

    int insertSelective(UsPartydues record);

    List<UsPartydues> selectByExample(UsPartyduesExample example);

    UsPartydues selectByPrimaryKey(String partyduesid);

    int updateByExampleSelective(@Param("record") UsPartydues record, @Param("example") UsPartyduesExample example);

    int updateByExample(@Param("record") UsPartydues record, @Param("example") UsPartyduesExample example);

    int updateByPrimaryKeySelective(UsPartydues record);

    int updateByPrimaryKey(UsPartydues record);
}