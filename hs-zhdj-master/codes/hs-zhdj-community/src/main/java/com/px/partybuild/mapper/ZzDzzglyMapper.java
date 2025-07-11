package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzDzzgly;
import com.px.partybuild.model.ZzDzzglyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzDzzglyMapper {
    long countByExample(ZzDzzglyExample example);

    int deleteByExample(ZzDzzglyExample example);

    int deleteByPrimaryKey(String dzzdm);

    int insert(ZzDzzgly record);

    int insertSelective(ZzDzzgly record);

    List<ZzDzzgly> selectByExample(ZzDzzglyExample example);

    ZzDzzgly selectByPrimaryKey(String dzzdm);

    int updateByExampleSelective(@Param("record") ZzDzzgly record, @Param("example") ZzDzzglyExample example);

    int updateByExample(@Param("record") ZzDzzgly record, @Param("example") ZzDzzglyExample example);

    int updateByPrimaryKeySelective(ZzDzzgly record);

    int updateByPrimaryKey(ZzDzzgly record);
}