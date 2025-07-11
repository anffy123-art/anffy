package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzzdRzfs;
import com.px.partybuild.model.ZzzdRzfsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzzdRzfsMapper {
    long countByExample(ZzzdRzfsExample example);

    int deleteByExample(ZzzdRzfsExample example);

    int insert(ZzzdRzfs record);

    int insertSelective(ZzzdRzfs record);

    List<ZzzdRzfs> selectByExample(ZzzdRzfsExample example);

    int updateByExampleSelective(@Param("record") ZzzdRzfs record, @Param("example") ZzzdRzfsExample example);

    int updateByExample(@Param("record") ZzzdRzfs record, @Param("example") ZzzdRzfsExample example);
}