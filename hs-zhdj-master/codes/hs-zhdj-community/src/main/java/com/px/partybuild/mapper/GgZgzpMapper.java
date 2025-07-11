package com.px.partybuild.mapper;

import com.px.partybuild.model.GgZgzp;
import com.px.partybuild.model.GgZgzpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GgZgzpMapper {
    long countByExample(GgZgzpExample example);

    int deleteByExample(GgZgzpExample example);

    int insert(GgZgzp record);

    int insertSelective(GgZgzp record);

    List<GgZgzp> selectByExampleWithBLOBs(GgZgzpExample example);

    List<GgZgzp> selectByExample(GgZgzpExample example);

    int updateByExampleSelective(@Param("record") GgZgzp record, @Param("example") GgZgzpExample example);

    int updateByExampleWithBLOBs(@Param("record") GgZgzp record, @Param("example") GgZgzpExample example);

    int updateByExample(@Param("record") GgZgzp record, @Param("example") GgZgzpExample example);
}