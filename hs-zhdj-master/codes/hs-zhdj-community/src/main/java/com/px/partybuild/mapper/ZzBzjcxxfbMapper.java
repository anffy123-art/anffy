package com.px.partybuild.mapper;

import com.px.partybuild.model.ZzBzjcxxfb;
import com.px.partybuild.model.ZzBzjcxxfbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZzBzjcxxfbMapper {
    long countByExample(ZzBzjcxxfbExample example);

    int deleteByExample(ZzBzjcxxfbExample example);

    int deleteByPrimaryKey(String bzjcxxbs);

    int insert(ZzBzjcxxfb record);

    int insertSelective(ZzBzjcxxfb record);

    List<ZzBzjcxxfb> selectByExample(ZzBzjcxxfbExample example);

    ZzBzjcxxfb selectByPrimaryKey(String bzjcxxbs);

    int updateByExampleSelective(@Param("record") ZzBzjcxxfb record, @Param("example") ZzBzjcxxfbExample example);

    int updateByExample(@Param("record") ZzBzjcxxfb record, @Param("example") ZzBzjcxxfbExample example);

    int updateByPrimaryKeySelective(ZzBzjcxxfb record);

    int updateByPrimaryKey(ZzBzjcxxfb record);
}