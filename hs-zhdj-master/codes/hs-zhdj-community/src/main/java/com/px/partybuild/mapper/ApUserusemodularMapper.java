package com.px.partybuild.mapper;

import com.px.partybuild.model.ApUserusemodular;
import com.px.partybuild.model.ApUserusemodularExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApUserusemodularMapper {
    long countByExample(ApUserusemodularExample example);

    int deleteByExample(ApUserusemodularExample example);

    int deleteByPrimaryKey(String uumid);

    int insert(ApUserusemodular record);

    int insertSelective(ApUserusemodular record);

    List<ApUserusemodular> selectByExample(ApUserusemodularExample example);

    ApUserusemodular selectByPrimaryKey(String uumid);

    int updateByExampleSelective(@Param("record") ApUserusemodular record, @Param("example") ApUserusemodularExample example);

    int updateByExample(@Param("record") ApUserusemodular record, @Param("example") ApUserusemodularExample example);

    int updateByPrimaryKeySelective(ApUserusemodular record);

    int updateByPrimaryKey(ApUserusemodular record);
}