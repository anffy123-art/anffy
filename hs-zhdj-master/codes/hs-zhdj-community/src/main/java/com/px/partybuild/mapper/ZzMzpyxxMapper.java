package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzMzpyxx;
import com.px.partybuild.model.ZzMzpyxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzMzpyxxMapper {
    long countByExample(ZzMzpyxxExample example);

    int deleteByExample(ZzMzpyxxExample example);

    int insert(ZzMzpyxx record);

    int insertSelective(ZzMzpyxx record);

    List<ZzMzpyxx> selectByExample(ZzMzpyxxExample example);

    int updateByExampleSelective(@Param("record") ZzMzpyxx record, @Param("example") ZzMzpyxxExample example);

    int updateByExample(@Param("record") ZzMzpyxx record, @Param("example") ZzMzpyxxExample example);
}