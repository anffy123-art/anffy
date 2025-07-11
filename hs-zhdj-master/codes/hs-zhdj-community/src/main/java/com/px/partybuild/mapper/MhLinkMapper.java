package com.px.partybuild.mapper;

import com.px.partybuild.model.MhLink;
import com.px.partybuild.model.MhLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MhLinkMapper {
    long countByExample(MhLinkExample example);

    int deleteByExample(MhLinkExample example);

    int deleteByPrimaryKey(String linkid);

    int insert(MhLink record);

    int insertSelective(MhLink record);

    List<MhLink> selectByExample(MhLinkExample example);

    MhLink selectByPrimaryKey(String linkid);

    int updateByExampleSelective(@Param("record") MhLink record, @Param("example") MhLinkExample example);

    int updateByExample(@Param("record") MhLink record, @Param("example") MhLinkExample example);

    int updateByPrimaryKeySelective(MhLink record);

    int updateByPrimaryKey(MhLink record);
}