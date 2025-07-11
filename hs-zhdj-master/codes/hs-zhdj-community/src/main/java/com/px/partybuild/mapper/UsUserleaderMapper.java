package com.px.partybuild.mapper;

import com.px.partybuild.model.UsUserleader;
import com.px.partybuild.model.UsUserleaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsUserleaderMapper {
    long countByExample(UsUserleaderExample example);

    int deleteByExample(UsUserleaderExample example);

    int deleteByPrimaryKey(String userleaderid);

    int insert(UsUserleader record);

    int insertSelective(UsUserleader record);

    List<UsUserleader> selectByExampleWithBLOBs(UsUserleaderExample example);

    List<UsUserleader> selectByExample(UsUserleaderExample example);

    UsUserleader selectByPrimaryKey(String userleaderid);

    int updateByExampleSelective(@Param("record") UsUserleader record, @Param("example") UsUserleaderExample example);

    int updateByExampleWithBLOBs(@Param("record") UsUserleader record, @Param("example") UsUserleaderExample example);

    int updateByExample(@Param("record") UsUserleader record, @Param("example") UsUserleaderExample example);

    int updateByPrimaryKeySelective(UsUserleader record);

    int updateByPrimaryKeyWithBLOBs(UsUserleader record);

    int updateByPrimaryKey(UsUserleader record);
}