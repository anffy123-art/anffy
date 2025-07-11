package com.px.partybuild.mapper;

import com.px.partybuild.model.PePartyreview;
import com.px.partybuild.model.PePartyreviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PePartyreviewMapper {
    long countByExample(PePartyreviewExample example);

    int deleteByExample(PePartyreviewExample example);

    int deleteByPrimaryKey(String partyreviewid);

    int insert(PePartyreview record);

    int insertSelective(PePartyreview record);

    List<PePartyreview> selectByExampleWithBLOBs(PePartyreviewExample example);

    List<PePartyreview> selectByExample(PePartyreviewExample example);

    PePartyreview selectByPrimaryKey(String partyreviewid);

    int updateByExampleSelective(@Param("record") PePartyreview record, @Param("example") PePartyreviewExample example);

    int updateByExampleWithBLOBs(@Param("record") PePartyreview record, @Param("example") PePartyreviewExample example);

    int updateByExample(@Param("record") PePartyreview record, @Param("example") PePartyreviewExample example);

    int updateByPrimaryKeySelective(PePartyreview record);

    int updateByPrimaryKeyWithBLOBs(PePartyreview record);

    int updateByPrimaryKey(PePartyreview record);
}