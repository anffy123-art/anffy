package com.px.partybuild.mapper;

import com.px.partybuild.model.PeJoinbook;
import com.px.partybuild.model.PeJoinbookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeJoinbookMapper {
    long countByExample(PeJoinbookExample example);

    int deleteByExample(PeJoinbookExample example);

    int deleteByPrimaryKey(String joinbookid);

    int insert(PeJoinbook record);

    int insertSelective(PeJoinbook record);

    List<PeJoinbook> selectByExample(PeJoinbookExample example);

    PeJoinbook selectByPrimaryKey(String joinbookid);

    int updateByExampleSelective(@Param("record") PeJoinbook record, @Param("example") PeJoinbookExample example);

    int updateByExample(@Param("record") PeJoinbook record, @Param("example") PeJoinbookExample example);

    int updateByPrimaryKeySelective(PeJoinbook record);

    int updateByPrimaryKey(PeJoinbook record);
}