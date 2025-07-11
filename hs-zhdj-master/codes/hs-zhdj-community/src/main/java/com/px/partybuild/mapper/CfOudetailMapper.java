package com.px.partybuild.mapper;

import com.px.partybuild.model.CfOudetail;
import com.px.partybuild.model.CfOudetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfOudetailMapper {
    long countByExample(CfOudetailExample example);

    int deleteByExample(CfOudetailExample example);

    int deleteByPrimaryKey(String dpkey);

    int insert(CfOudetail record);

    int insertSelective(CfOudetail record);

    List<CfOudetail> selectByExample(CfOudetailExample example);

    CfOudetail selectByPrimaryKey(String dpkey);

    int updateByExampleSelective(@Param("record") CfOudetail record, @Param("example") CfOudetailExample example);

    int updateByExample(@Param("record") CfOudetail record, @Param("example") CfOudetailExample example);

    int updateByPrimaryKeySelective(CfOudetail record);

    int updateByPrimaryKey(CfOudetail record);
}