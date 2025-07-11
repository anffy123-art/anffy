package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzzdRyzt;
import com.px.partybuild.model.ZzzdRyztExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzzdRyztMapper {
    long countByExample(ZzzdRyztExample example);

    int deleteByExample(ZzzdRyztExample example);

    int insert(ZzzdRyzt record);

    int insertSelective(ZzzdRyzt record);

    List<ZzzdRyzt> selectByExample(ZzzdRyztExample example);

    int updateByExampleSelective(@Param("record") ZzzdRyzt record, @Param("example") ZzzdRyztExample example);

    int updateByExample(@Param("record") ZzzdRyzt record, @Param("example") ZzzdRyztExample example);
}