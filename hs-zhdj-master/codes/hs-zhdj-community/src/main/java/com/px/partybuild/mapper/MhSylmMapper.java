package com.px.partybuild.mapper;

import com.px.partybuild.model.MhSylm;
import com.px.partybuild.model.MhSylmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MhSylmMapper {
    long countByExample(MhSylmExample example);

    int deleteByExample(MhSylmExample example);

    int deleteByPrimaryKey(String sylmbs);

    int insert(MhSylm record);

    int insertSelective(MhSylm record);

    List<MhSylm> selectByExample(MhSylmExample example);

    MhSylm selectByPrimaryKey(String sylmbs);

    int updateByExampleSelective(@Param("record") MhSylm record, @Param("example") MhSylmExample example);

    int updateByExample(@Param("record") MhSylm record, @Param("example") MhSylmExample example);

    int updateByPrimaryKeySelective(MhSylm record);

    int updateByPrimaryKey(MhSylm record);
}