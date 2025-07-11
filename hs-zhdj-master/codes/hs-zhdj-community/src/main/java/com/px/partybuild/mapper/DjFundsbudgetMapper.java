package com.px.partybuild.mapper;

import com.px.partybuild.model.DjFundsbudget;
import com.px.partybuild.model.DjFundsbudgetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjFundsbudgetMapper {
    long countByExample(DjFundsbudgetExample example);

    int deleteByExample(DjFundsbudgetExample example);

    int deleteByPrimaryKey(String fundsbudgetid);

    int insert(DjFundsbudget record);

    int insertSelective(DjFundsbudget record);

    List<DjFundsbudget> selectByExample(DjFundsbudgetExample example);

    DjFundsbudget selectByPrimaryKey(String fundsbudgetid);

    int updateByExampleSelective(@Param("record") DjFundsbudget record, @Param("example") DjFundsbudgetExample example);

    int updateByExample(@Param("record") DjFundsbudget record, @Param("example") DjFundsbudgetExample example);

    int updateByPrimaryKeySelective(DjFundsbudget record);

    int updateByPrimaryKey(DjFundsbudget record);
}