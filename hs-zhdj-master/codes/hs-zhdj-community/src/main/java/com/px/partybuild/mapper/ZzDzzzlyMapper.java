package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzDzzzly;
import com.px.partybuild.model.ZzDzzzlyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzDzzzlyMapper {
    long countByExample(ZzDzzzlyExample example);

    int deleteByExample(ZzDzzzlyExample example);

    int deleteByPrimaryKey(String dzzzlyid);

    int insert(ZzDzzzly record);

    int insertSelective(ZzDzzzly record);

    List<ZzDzzzly> selectByExample(ZzDzzzlyExample example);

    ZzDzzzly selectByPrimaryKey(String dzzzlyid);

    int updateByExampleSelective(@Param("record") ZzDzzzly record, @Param("example") ZzDzzzlyExample example);

    int updateByExample(@Param("record") ZzDzzzly record, @Param("example") ZzDzzzlyExample example);

    int updateByPrimaryKeySelective(ZzDzzzly record);

    int updateByPrimaryKey(ZzDzzzly record);
}