package com.px.partybuild.mapper;

import com.px.partybuild.model.PeJxjykcqk;
import com.px.partybuild.model.PeJxjykcqkExample;
import com.px.partybuild.model.PeJxjykcqkWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeJxjykcqkMapper {
    long countByExample(PeJxjykcqkExample example);

    int deleteByExample(PeJxjykcqkExample example);

    int deleteByPrimaryKey(String id);

    int insert(PeJxjykcqkWithBLOBs record);

    int insertSelective(PeJxjykcqkWithBLOBs record);

    List<PeJxjykcqkWithBLOBs> selectByExampleWithBLOBs(PeJxjykcqkExample example);

    List<PeJxjykcqk> selectByExample(PeJxjykcqkExample example);

    PeJxjykcqkWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PeJxjykcqkWithBLOBs record, @Param("example") PeJxjykcqkExample example);

    int updateByExampleWithBLOBs(@Param("record") PeJxjykcqkWithBLOBs record, @Param("example") PeJxjykcqkExample example);

    int updateByExample(@Param("record") PeJxjykcqk record, @Param("example") PeJxjykcqkExample example);

    int updateByPrimaryKeySelective(PeJxjykcqkWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PeJxjykcqkWithBLOBs record);

    int updateByPrimaryKey(PeJxjykcqk record);
}