package com.px.partybuild.mapper;

import com.px.partybuild.model.CfLeaderadmin;
import com.px.partybuild.model.CfLeaderadminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfLeaderadminMapper {
    long countByExample(CfLeaderadminExample example);

    int deleteByExample(CfLeaderadminExample example);

    int deleteByPrimaryKey(String userid);

    int insert(CfLeaderadmin record);

    int insertSelective(CfLeaderadmin record);

    List<CfLeaderadmin> selectByExample(CfLeaderadminExample example);

    CfLeaderadmin selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") CfLeaderadmin record, @Param("example") CfLeaderadminExample example);

    int updateByExample(@Param("record") CfLeaderadmin record, @Param("example") CfLeaderadminExample example);

    int updateByPrimaryKeySelective(CfLeaderadmin record);

    int updateByPrimaryKey(CfLeaderadmin record);
}