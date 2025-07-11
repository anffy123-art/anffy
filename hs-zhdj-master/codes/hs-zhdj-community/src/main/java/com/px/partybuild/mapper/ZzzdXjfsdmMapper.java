package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzzdXjfsdm;
import com.px.partybuild.model.ZzzdXjfsdmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzzdXjfsdmMapper {
    long countByExample(ZzzdXjfsdmExample example);

    int deleteByExample(ZzzdXjfsdmExample example);

    int insert(ZzzdXjfsdm record);

    int insertSelective(ZzzdXjfsdm record);

    List<ZzzdXjfsdm> selectByExample(ZzzdXjfsdmExample example);

    int updateByExampleSelective(@Param("record") ZzzdXjfsdm record, @Param("example") ZzzdXjfsdmExample example);

    int updateByExample(@Param("record") ZzzdXjfsdm record, @Param("example") ZzzdXjfsdmExample example);
}