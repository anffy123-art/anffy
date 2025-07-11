package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzzdZwmc;
import com.px.partybuild.model.ZzzdZwmcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzzdZwmcMapper {
    long countByExample(ZzzdZwmcExample example);

    int deleteByExample(ZzzdZwmcExample example);

    int insert(ZzzdZwmc record);

    int insertSelective(ZzzdZwmc record);

    List<ZzzdZwmc> selectByExample(ZzzdZwmcExample example);

    int updateByExampleSelective(@Param("record") ZzzdZwmc record, @Param("example") ZzzdZwmcExample example);

    int updateByExample(@Param("record") ZzzdZwmc record, @Param("example") ZzzdZwmcExample example);
}