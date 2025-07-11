package com.px.partybuild.mapper;

import com.px.partybuild.model.UsPartyMonth;
import com.px.partybuild.model.UsPartyMonthExample;
import com.px.partybuild.model.UsPartyMonthKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsPartyMonthMapper {
    long countByExample(UsPartyMonthExample example);

    int deleteByExample(UsPartyMonthExample example);

    int deleteByPrimaryKey(UsPartyMonthKey key);

    int insert(UsPartyMonth record);

    int insertSelective(UsPartyMonth record);

    List<UsPartyMonth> selectByExample(UsPartyMonthExample example);

    UsPartyMonth selectByPrimaryKey(UsPartyMonthKey key);

    int updateByExampleSelective(@Param("record") UsPartyMonth record, @Param("example") UsPartyMonthExample example);

    int updateByExample(@Param("record") UsPartyMonth record, @Param("example") UsPartyMonthExample example);

    int updateByPrimaryKeySelective(UsPartyMonth record);

    int updateByPrimaryKey(UsPartyMonth record);
}