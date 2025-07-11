package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzBzjcxx;
import com.px.partybuild.model.ZzBzjcxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzBzjcxxMapper {
    long countByExample(ZzBzjcxxExample example);

    int deleteByExample(ZzBzjcxxExample example);

    int insert(ZzBzjcxx record);

    int insertSelective(ZzBzjcxx record);

    List<ZzBzjcxx> selectByExample(ZzBzjcxxExample example);

    int updateByExampleSelective(@Param("record") ZzBzjcxx record, @Param("example") ZzBzjcxxExample example);

    int updateByExample(@Param("record") ZzBzjcxx record, @Param("example") ZzBzjcxxExample example);
}