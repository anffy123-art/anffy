package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzBzcyxx;
import com.px.partybuild.model.ZzBzcyxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzBzcyxxMapper {
    long countByExample(ZzBzcyxxExample example);

    int deleteByExample(ZzBzcyxxExample example);

    int insert(ZzBzcyxx record);

    int insertSelective(ZzBzcyxx record);

    List<ZzBzcyxx> selectByExample(ZzBzcyxxExample example);

    int updateByExampleSelective(@Param("record") ZzBzcyxx record, @Param("example") ZzBzcyxxExample example);

    int updateByExample(@Param("record") ZzBzcyxx record, @Param("example") ZzBzcyxxExample example);
}