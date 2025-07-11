package com.px.partybuild.mapper;

import com.px.partybuild.model.DjGdwydqk;
import com.px.partybuild.model.DjGdwydqkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjGdwydqkMapper {
    long countByExample(DjGdwydqkExample example);

    int deleteByExample(DjGdwydqkExample example);

    int deleteByPrimaryKey(String id);

    int insert(DjGdwydqk record);

    int insertSelective(DjGdwydqk record);

    List<DjGdwydqk> selectByExample(DjGdwydqkExample example);

    DjGdwydqk selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DjGdwydqk record, @Param("example") DjGdwydqkExample example);

    int updateByExample(@Param("record") DjGdwydqk record, @Param("example") DjGdwydqkExample example);

    int updateByPrimaryKeySelective(DjGdwydqk record);

    int updateByPrimaryKey(DjGdwydqk record);
}