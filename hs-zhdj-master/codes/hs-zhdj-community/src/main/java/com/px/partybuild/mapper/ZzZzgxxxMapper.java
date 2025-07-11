package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzZzgxxx;
import com.px.partybuild.model.ZzZzgxxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzZzgxxxMapper {
    long countByExample(ZzZzgxxxExample example);

    int deleteByExample(ZzZzgxxxExample example);

    int insert(ZzZzgxxx record);

    int insertSelective(ZzZzgxxx record);

    List<ZzZzgxxx> selectByExample(ZzZzgxxxExample example);

    int updateByExampleSelective(@Param("record") ZzZzgxxx record, @Param("example") ZzZzgxxxExample example);

    int updateByExample(@Param("record") ZzZzgxxx record, @Param("example") ZzZzgxxxExample example);
}