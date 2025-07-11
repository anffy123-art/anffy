package com.px.partybuild.mapper;

import com.px.partybuild.model.DjFundsincome;
import com.px.partybuild.model.DjFundsincomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjFundsincomeMapper {
    long countByExample(DjFundsincomeExample example);

    int deleteByExample(DjFundsincomeExample example);

    int deleteByPrimaryKey(String fundsbudgetid);

    int insert(DjFundsincome record);

    int insertSelective(DjFundsincome record);

    List<DjFundsincome> selectByExample(DjFundsincomeExample example);

    DjFundsincome selectByPrimaryKey(String fundsbudgetid);

    int updateByExampleSelective(@Param("record") DjFundsincome record, @Param("example") DjFundsincomeExample example);

    int updateByExample(@Param("record") DjFundsincome record, @Param("example") DjFundsincomeExample example);

    int updateByPrimaryKeySelective(DjFundsincome record);

    int updateByPrimaryKey(DjFundsincome record);
}