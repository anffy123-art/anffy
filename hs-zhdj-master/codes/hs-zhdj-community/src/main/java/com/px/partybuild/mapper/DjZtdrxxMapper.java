package com.px.partybuild.mapper;

import com.px.partybuild.model.DjZtdrxx;
import com.px.partybuild.model.DjZtdrxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjZtdrxxMapper {
    long countByExample(DjZtdrxxExample example);

    int deleteByExample(DjZtdrxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(DjZtdrxx record);

    int insertSelective(DjZtdrxx record);

    List<DjZtdrxx> selectByExampleWithBLOBs(DjZtdrxxExample example);

    List<DjZtdrxx> selectByExample(DjZtdrxxExample example);

    DjZtdrxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DjZtdrxx record, @Param("example") DjZtdrxxExample example);

    int updateByExampleWithBLOBs(@Param("record") DjZtdrxx record, @Param("example") DjZtdrxxExample example);

    int updateByExample(@Param("record") DjZtdrxx record, @Param("example") DjZtdrxxExample example);

    int updateByPrimaryKeySelective(DjZtdrxx record);

    int updateByPrimaryKeyWithBLOBs(DjZtdrxx record);

    int updateByPrimaryKey(DjZtdrxx record);
}