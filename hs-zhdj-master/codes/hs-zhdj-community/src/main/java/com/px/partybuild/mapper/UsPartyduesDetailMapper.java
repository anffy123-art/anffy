package com.px.partybuild.mapper;

import com.px.partybuild.model.UsPartyduesDetail;
import com.px.partybuild.model.UsPartyduesDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsPartyduesDetailMapper {
    long countByExample(UsPartyduesDetailExample example);

    int deleteByExample(UsPartyduesDetailExample example);

    int deleteByPrimaryKey(String detailid);

    int insert(UsPartyduesDetail record);

    int insertSelective(UsPartyduesDetail record);

    List<UsPartyduesDetail> selectByExample(UsPartyduesDetailExample example);

    UsPartyduesDetail selectByPrimaryKey(String detailid);

    int updateByExampleSelective(@Param("record") UsPartyduesDetail record, @Param("example") UsPartyduesDetailExample example);

    int updateByExample(@Param("record") UsPartyduesDetail record, @Param("example") UsPartyduesDetailExample example);

    int updateByPrimaryKeySelective(UsPartyduesDetail record);

    int updateByPrimaryKey(UsPartyduesDetail record);
}