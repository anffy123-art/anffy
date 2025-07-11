package com.px.partybuild.mapper;

import com.px.partybuild.model.UsUserleaderDetail;
import com.px.partybuild.model.UsUserleaderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsUserleaderDetailMapper {
    long countByExample(UsUserleaderDetailExample example);

    int deleteByExample(UsUserleaderDetailExample example);

    int deleteByPrimaryKey(String detailid);

    int insert(UsUserleaderDetail record);

    int insertSelective(UsUserleaderDetail record);

    List<UsUserleaderDetail> selectByExample(UsUserleaderDetailExample example);

    UsUserleaderDetail selectByPrimaryKey(String detailid);

    int updateByExampleSelective(@Param("record") UsUserleaderDetail record, @Param("example") UsUserleaderDetailExample example);

    int updateByExample(@Param("record") UsUserleaderDetail record, @Param("example") UsUserleaderDetailExample example);

    int updateByPrimaryKeySelective(UsUserleaderDetail record);

    int updateByPrimaryKey(UsUserleaderDetail record);
}