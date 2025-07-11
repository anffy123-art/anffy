package com.px.partybuild.mapper;

import com.px.partybuild.model.YsJfysmx;
import com.px.partybuild.model.YsJfysmxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsJfysmxMapper {
    long countByExample(YsJfysmxExample example);

    int deleteByExample(YsJfysmxExample example);

    int deleteByPrimaryKey(String ysmxid);

    int insert(YsJfysmx record);

    int insertSelective(YsJfysmx record);

    List<YsJfysmx> selectByExample(YsJfysmxExample example);

    YsJfysmx selectByPrimaryKey(String ysmxid);

    int updateByExampleSelective(@Param("record") YsJfysmx record, @Param("example") YsJfysmxExample example);

    int updateByExample(@Param("record") YsJfysmx record, @Param("example") YsJfysmxExample example);

    int updateByPrimaryKeySelective(YsJfysmx record);

    int updateByPrimaryKey(YsJfysmx record);
}