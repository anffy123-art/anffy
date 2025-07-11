package com.px.partybuild.mapper;

import com.px.partybuild.model.DjzzrsFzjggl;
import com.px.partybuild.model.DjzzrsFzjgglExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjzzrsFzjgglMapper {
    long countByExample(DjzzrsFzjgglExample example);

    int deleteByExample(DjzzrsFzjgglExample example);

    int deleteByPrimaryKey(String glid);

    int insert(DjzzrsFzjggl record);

    int insertSelective(DjzzrsFzjggl record);

    List<DjzzrsFzjggl> selectByExample(DjzzrsFzjgglExample example);

    DjzzrsFzjggl selectByPrimaryKey(String glid);

    int updateByExampleSelective(@Param("record") DjzzrsFzjggl record, @Param("example") DjzzrsFzjgglExample example);

    int updateByExample(@Param("record") DjzzrsFzjggl record, @Param("example") DjzzrsFzjgglExample example);

    int updateByPrimaryKeySelective(DjzzrsFzjggl record);

    int updateByPrimaryKey(DjzzrsFzjggl record);
}