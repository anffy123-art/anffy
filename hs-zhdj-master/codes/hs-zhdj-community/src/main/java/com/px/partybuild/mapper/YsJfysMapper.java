package com.px.partybuild.mapper;

import com.px.partybuild.model.YsJfys;
import com.px.partybuild.model.YsJfysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsJfysMapper {
    long countByExample(YsJfysExample example);

    int deleteByExample(YsJfysExample example);

    int deleteByPrimaryKey(String jfysid);

    int insert(YsJfys record);

    int insertSelective(YsJfys record);

    List<YsJfys> selectByExample(YsJfysExample example);

    YsJfys selectByPrimaryKey(String jfysid);

    int updateByExampleSelective(@Param("record") YsJfys record, @Param("example") YsJfysExample example);

    int updateByExample(@Param("record") YsJfys record, @Param("example") YsJfysExample example);

    int updateByPrimaryKeySelective(YsJfys record);

    int updateByPrimaryKey(YsJfys record);
}