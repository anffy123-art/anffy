package com.px.partybuild.mapper;

import com.px.partybuild.model.PeBrdzb;
import com.px.partybuild.model.PeBrdzbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeBrdzbMapper {
    long countByExample(PeBrdzbExample example);

    int deleteByExample(PeBrdzbExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeBrdzb record);

    int insertSelective(PeBrdzb record);

    List<PeBrdzb> selectByExample(PeBrdzbExample example);

    PeBrdzb selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeBrdzb record, @Param("example") PeBrdzbExample example);

    int updateByExample(@Param("record") PeBrdzb record, @Param("example") PeBrdzbExample example);

    int updateByPrimaryKeySelective(PeBrdzb record);

    int updateByPrimaryKey(PeBrdzb record);
}