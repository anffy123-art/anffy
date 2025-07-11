package com.px.partybuild.mapper;

import com.px.partybuild.model.UsUserthought;
import com.px.partybuild.model.UsUserthoughtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsUserthoughtMapper {
    long countByExample(UsUserthoughtExample example);

    int deleteByExample(UsUserthoughtExample example);

    int deleteByPrimaryKey(String userthoughtid);

    int insert(UsUserthought record);

    int insertSelective(UsUserthought record);

    List<UsUserthought> selectByExample(UsUserthoughtExample example);

    UsUserthought selectByPrimaryKey(String userthoughtid);

    int updateByExampleSelective(@Param("record") UsUserthought record, @Param("example") UsUserthoughtExample example);

    int updateByExample(@Param("record") UsUserthought record, @Param("example") UsUserthoughtExample example);

    int updateByPrimaryKeySelective(UsUserthought record);

    int updateByPrimaryKey(UsUserthought record);
}