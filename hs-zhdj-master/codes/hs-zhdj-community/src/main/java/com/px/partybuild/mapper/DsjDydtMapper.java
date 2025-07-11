package com.px.partybuild.mapper;

import com.px.partybuild.model.DsjDydt;
import com.px.partybuild.model.DsjDydtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsjDydtMapper {
    long countByExample(DsjDydtExample example);

    int deleteByExample(DsjDydtExample example);

    int deleteByPrimaryKey(String dydtbs);

    int insert(DsjDydt record);

    int insertSelective(DsjDydt record);

    List<DsjDydt> selectByExample(DsjDydtExample example);

    DsjDydt selectByPrimaryKey(String dydtbs);

    int updateByExampleSelective(@Param("record") DsjDydt record, @Param("example") DsjDydtExample example);

    int updateByExample(@Param("record") DsjDydt record, @Param("example") DsjDydtExample example);

    int updateByPrimaryKeySelective(DsjDydt record);

    int updateByPrimaryKey(DsjDydt record);
}