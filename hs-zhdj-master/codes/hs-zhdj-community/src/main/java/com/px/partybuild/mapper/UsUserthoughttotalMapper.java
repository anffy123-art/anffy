package com.px.partybuild.mapper;

import com.px.partybuild.model.UsUserthoughttotal;
import com.px.partybuild.model.UsUserthoughttotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsUserthoughttotalMapper {
    long countByExample(UsUserthoughttotalExample example);

    int deleteByExample(UsUserthoughttotalExample example);

    int deleteByPrimaryKey(String userthoughttotalid);

    int insert(UsUserthoughttotal record);

    int insertSelective(UsUserthoughttotal record);

    List<UsUserthoughttotal> selectByExampleWithBLOBs(UsUserthoughttotalExample example);

    List<UsUserthoughttotal> selectByExample(UsUserthoughttotalExample example);

    UsUserthoughttotal selectByPrimaryKey(String userthoughttotalid);

    int updateByExampleSelective(@Param("record") UsUserthoughttotal record, @Param("example") UsUserthoughttotalExample example);

    int updateByExampleWithBLOBs(@Param("record") UsUserthoughttotal record, @Param("example") UsUserthoughttotalExample example);

    int updateByExample(@Param("record") UsUserthoughttotal record, @Param("example") UsUserthoughttotalExample example);

    int updateByPrimaryKeySelective(UsUserthoughttotal record);

    int updateByPrimaryKeyWithBLOBs(UsUserthoughttotal record);

    int updateByPrimaryKey(UsUserthoughttotal record);
}