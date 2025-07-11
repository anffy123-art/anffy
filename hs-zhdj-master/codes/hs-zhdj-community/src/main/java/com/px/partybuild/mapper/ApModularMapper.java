package com.px.partybuild.mapper;

import com.px.partybuild.model.ApModular;
import com.px.partybuild.model.ApModularExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApModularMapper {
    long countByExample(ApModularExample example);

    int deleteByExample(ApModularExample example);

    int deleteByPrimaryKey(String mid);

    int insert(ApModular record);

    int insertSelective(ApModular record);

    List<ApModular> selectByExample(ApModularExample example);

    ApModular selectByPrimaryKey(String mid);

    int updateByExampleSelective(@Param("record") ApModular record, @Param("example") ApModularExample example);

    int updateByExample(@Param("record") ApModular record, @Param("example") ApModularExample example);

    int updateByPrimaryKeySelective(ApModular record);

    int updateByPrimaryKey(ApModular record);
}