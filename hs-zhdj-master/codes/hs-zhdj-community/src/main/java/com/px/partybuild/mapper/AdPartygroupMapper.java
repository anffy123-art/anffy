package com.px.partybuild.mapper;

import com.px.partybuild.model.AdPartygroup;
import com.px.partybuild.model.AdPartygroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdPartygroupMapper {
    long countByExample(AdPartygroupExample example);

    int deleteByExample(AdPartygroupExample example);

    int deleteByPrimaryKey(String id);

    int insert(AdPartygroup record);

    int insertSelective(AdPartygroup record);

    List<AdPartygroup> selectByExample(AdPartygroupExample example);

    AdPartygroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AdPartygroup record, @Param("example") AdPartygroupExample example);

    int updateByExample(@Param("record") AdPartygroup record, @Param("example") AdPartygroupExample example);

    int updateByPrimaryKeySelective(AdPartygroup record);

    int updateByPrimaryKey(AdPartygroup record);
}