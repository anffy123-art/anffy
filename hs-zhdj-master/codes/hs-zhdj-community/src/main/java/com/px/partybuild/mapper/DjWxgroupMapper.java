package com.px.partybuild.mapper;

import com.px.partybuild.model.DjWxgroup;
import com.px.partybuild.model.DjWxgroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjWxgroupMapper {
    long countByExample(DjWxgroupExample example);

    int deleteByExample(DjWxgroupExample example);

    int deleteByPrimaryKey(String wxgroupid);

    int insert(DjWxgroup record);

    int insertSelective(DjWxgroup record);

    List<DjWxgroup> selectByExample(DjWxgroupExample example);

    DjWxgroup selectByPrimaryKey(String wxgroupid);

    int updateByExampleSelective(@Param("record") DjWxgroup record, @Param("example") DjWxgroupExample example);

    int updateByExample(@Param("record") DjWxgroup record, @Param("example") DjWxgroupExample example);

    int updateByPrimaryKeySelective(DjWxgroup record);

    int updateByPrimaryKey(DjWxgroup record);
}