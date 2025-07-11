package com.px.partybuild.mapper;

import com.px.partybuild.model.DjFundsuse;
import com.px.partybuild.model.DjFundsuseExample;
import com.px.partybuild.model.DjFundsuseWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjFundsuseMapper {
    long countByExample(DjFundsuseExample example);

    int deleteByExample(DjFundsuseExample example);

    int deleteByPrimaryKey(String fundsuseid);

    int insert(DjFundsuseWithBLOBs record);

    int insertSelective(DjFundsuseWithBLOBs record);

    List<DjFundsuseWithBLOBs> selectByExampleWithBLOBs(DjFundsuseExample example);

    List<DjFundsuse> selectByExample(DjFundsuseExample example);

    DjFundsuseWithBLOBs selectByPrimaryKey(String fundsuseid);

    int updateByExampleSelective(@Param("record") DjFundsuseWithBLOBs record, @Param("example") DjFundsuseExample example);

    int updateByExampleWithBLOBs(@Param("record") DjFundsuseWithBLOBs record, @Param("example") DjFundsuseExample example);

    int updateByExample(@Param("record") DjFundsuse record, @Param("example") DjFundsuseExample example);

    int updateByPrimaryKeySelective(DjFundsuseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DjFundsuseWithBLOBs record);

    int updateByPrimaryKey(DjFundsuse record);
}