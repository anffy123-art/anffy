package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzzdGzgw;
import com.px.partybuild.model.ZzzdGzgwExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzzdGzgwMapper {
    long countByExample(ZzzdGzgwExample example);

    int deleteByExample(ZzzdGzgwExample example);

    int insert(ZzzdGzgw record);

    int insertSelective(ZzzdGzgw record);

    List<ZzzdGzgw> selectByExample(ZzzdGzgwExample example);

    int updateByExampleSelective(@Param("record") ZzzdGzgw record, @Param("example") ZzzdGzgwExample example);

    int updateByExample(@Param("record") ZzzdGzgw record, @Param("example") ZzzdGzgwExample example);
}