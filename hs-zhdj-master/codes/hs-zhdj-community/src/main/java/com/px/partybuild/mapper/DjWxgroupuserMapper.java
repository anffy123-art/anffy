package com.px.partybuild.mapper;

import com.px.partybuild.model.DjWxgroupuser;
import com.px.partybuild.model.DjWxgroupuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjWxgroupuserMapper {
    long countByExample(DjWxgroupuserExample example);

    int deleteByExample(DjWxgroupuserExample example);

    int deleteByPrimaryKey(String wxgroupuserid);

    int insert(DjWxgroupuser record);

    int insertSelective(DjWxgroupuser record);

    List<DjWxgroupuser> selectByExample(DjWxgroupuserExample example);

    DjWxgroupuser selectByPrimaryKey(String wxgroupuserid);

    int updateByExampleSelective(@Param("record") DjWxgroupuser record, @Param("example") DjWxgroupuserExample example);

    int updateByExample(@Param("record") DjWxgroupuser record, @Param("example") DjWxgroupuserExample example);

    int updateByPrimaryKeySelective(DjWxgroupuser record);

    int updateByPrimaryKey(DjWxgroupuser record);
}