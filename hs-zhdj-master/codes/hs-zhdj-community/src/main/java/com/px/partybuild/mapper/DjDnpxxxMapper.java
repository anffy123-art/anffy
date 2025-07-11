package com.px.partybuild.mapper;

import com.px.partybuild.model.DjDnpxxx;
import com.px.partybuild.model.DjDnpxxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjDnpxxxMapper {
    long countByExample(DjDnpxxxExample example);

    int deleteByExample(DjDnpxxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(DjDnpxxx record);

    int insertSelective(DjDnpxxx record);

    List<DjDnpxxx> selectByExample(DjDnpxxxExample example);

    DjDnpxxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DjDnpxxx record, @Param("example") DjDnpxxxExample example);

    int updateByExample(@Param("record") DjDnpxxx record, @Param("example") DjDnpxxxExample example);

    int updateByPrimaryKeySelective(DjDnpxxx record);

    int updateByPrimaryKey(DjDnpxxx record);
}