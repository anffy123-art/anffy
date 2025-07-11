package com.px.partybuild.mapper;

import com.px.partybuild.model.CfDictionary;
import com.px.partybuild.model.CfDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfDictionaryMapper {
    long countByExample(CfDictionaryExample example);

    int deleteByExample(CfDictionaryExample example);

    int deleteByPrimaryKey(String dictionaryid);

    int insert(CfDictionary record);

    int insertSelective(CfDictionary record);

    List<CfDictionary> selectByExampleWithBLOBs(CfDictionaryExample example);

    List<CfDictionary> selectByExample(CfDictionaryExample example);

    CfDictionary selectByPrimaryKey(String dictionaryid);

    int updateByExampleSelective(@Param("record") CfDictionary record, @Param("example") CfDictionaryExample example);

    int updateByExampleWithBLOBs(@Param("record") CfDictionary record, @Param("example") CfDictionaryExample example);

    int updateByExample(@Param("record") CfDictionary record, @Param("example") CfDictionaryExample example);

    int updateByPrimaryKeySelective(CfDictionary record);

    int updateByPrimaryKeyWithBLOBs(CfDictionary record);

    int updateByPrimaryKey(CfDictionary record);
}