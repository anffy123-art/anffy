package com.px.partybuild.mapper;

import com.px.partybuild.model.DjTaskusers;
import com.px.partybuild.model.DjTaskusersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjTaskusersMapper {
    long countByExample(DjTaskusersExample example);

    int deleteByExample(DjTaskusersExample example);

    int deleteByPrimaryKey(String id);

    int insert(DjTaskusers record);

    int insertSelective(DjTaskusers record);

    List<DjTaskusers> selectByExample(DjTaskusersExample example);

    DjTaskusers selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DjTaskusers record, @Param("example") DjTaskusersExample example);

    int updateByExample(@Param("record") DjTaskusers record, @Param("example") DjTaskusersExample example);

    int updateByPrimaryKeySelective(DjTaskusers record);

    int updateByPrimaryKey(DjTaskusers record);
}