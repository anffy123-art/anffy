package com.px.partybuild.mapper;

import com.px.partybuild.model.YsHdbz;
import com.px.partybuild.model.YsHdbzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsHdbzMapper {
    long countByExample(YsHdbzExample example);

    int deleteByExample(YsHdbzExample example);

    int deleteByPrimaryKey(String hdbzid);

    int insert(YsHdbz record);

    int insertSelective(YsHdbz record);

    List<YsHdbz> selectByExample(YsHdbzExample example);

    YsHdbz selectByPrimaryKey(String hdbzid);

    int updateByExampleSelective(@Param("record") YsHdbz record, @Param("example") YsHdbzExample example);

    int updateByExample(@Param("record") YsHdbz record, @Param("example") YsHdbzExample example);

    int updateByPrimaryKeySelective(YsHdbz record);

    int updateByPrimaryKey(YsHdbz record);
}