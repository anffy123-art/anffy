package com.px.partybuild.mapper;

import com.px.partybuild.model.DsjNdkpjg;
import com.px.partybuild.model.DsjNdkpjgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsjNdkpjgMapper {
    long countByExample(DsjNdkpjgExample example);

    int deleteByExample(DsjNdkpjgExample example);

    int deleteByPrimaryKey(String ndkpjgbs);

    int insert(DsjNdkpjg record);

    int insertSelective(DsjNdkpjg record);

    List<DsjNdkpjg> selectByExample(DsjNdkpjgExample example);

    DsjNdkpjg selectByPrimaryKey(String ndkpjgbs);

    int updateByExampleSelective(@Param("record") DsjNdkpjg record, @Param("example") DsjNdkpjgExample example);

    int updateByExample(@Param("record") DsjNdkpjg record, @Param("example") DsjNdkpjgExample example);

    int updateByPrimaryKeySelective(DsjNdkpjg record);

    int updateByPrimaryKey(DsjNdkpjg record);
}