package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzzdZzlbdmnew;
import com.px.partybuild.model.ZzzdZzlbdmnewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzzdZzlbdmnewMapper {
    long countByExample(ZzzdZzlbdmnewExample example);

    int deleteByExample(ZzzdZzlbdmnewExample example);

    int deleteByPrimaryKey(String bm);

    int insert(ZzzdZzlbdmnew record);

    int insertSelective(ZzzdZzlbdmnew record);

    List<ZzzdZzlbdmnew> selectByExample(ZzzdZzlbdmnewExample example);

    ZzzdZzlbdmnew selectByPrimaryKey(String bm);

    int updateByExampleSelective(@Param("record") ZzzdZzlbdmnew record, @Param("example") ZzzdZzlbdmnewExample example);

    int updateByExample(@Param("record") ZzzdZzlbdmnew record, @Param("example") ZzzdZzlbdmnewExample example);

    int updateByPrimaryKeySelective(ZzzdZzlbdmnew record);

    int updateByPrimaryKey(ZzzdZzlbdmnew record);
}