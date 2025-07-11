package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzzdZzlbdm;
import com.px.partybuild.model.ZzzdZzlbdmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzzdZzlbdmMapper {
    long countByExample(ZzzdZzlbdmExample example);

    int deleteByExample(ZzzdZzlbdmExample example);

    int insert(ZzzdZzlbdm record);

    int insertSelective(ZzzdZzlbdm record);

    List<ZzzdZzlbdm> selectByExample(ZzzdZzlbdmExample example);

    int updateByExampleSelective(@Param("record") ZzzdZzlbdm record, @Param("example") ZzzdZzlbdmExample example);

    int updateByExample(@Param("record") ZzzdZzlbdm record, @Param("example") ZzzdZzlbdmExample example);
}