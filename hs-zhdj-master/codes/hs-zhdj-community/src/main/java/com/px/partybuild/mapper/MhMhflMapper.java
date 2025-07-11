package com.px.partybuild.mapper;

import com.px.partybuild.model.MhMhfl;
import com.px.partybuild.model.MhMhflExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MhMhflMapper {
    long countByExample(MhMhflExample example);

    int deleteByExample(MhMhflExample example);

    int deleteByPrimaryKey(String mhflbs);

    int insert(MhMhfl record);

    int insertSelective(MhMhfl record);

    List<MhMhfl> selectByExample(MhMhflExample example);

    MhMhfl selectByPrimaryKey(String mhflbs);

    int updateByExampleSelective(@Param("record") MhMhfl record, @Param("example") MhMhflExample example);

    int updateByExample(@Param("record") MhMhfl record, @Param("example") MhMhflExample example);

    int updateByPrimaryKeySelective(MhMhfl record);

    int updateByPrimaryKey(MhMhfl record);
}