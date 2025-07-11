package com.px.partybuild.mapper;

import com.px.partybuild.model.GgZgjbxx;
import com.px.partybuild.model.GgZgjbxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GgZgjbxxMapper {
    long countByExample(GgZgjbxxExample example);

    int deleteByExample(GgZgjbxxExample example);

    int insert(GgZgjbxx record);

    int insertSelective(GgZgjbxx record);

    List<GgZgjbxx> selectByExample(GgZgjbxxExample example);

    int updateByExampleSelective(@Param("record") GgZgjbxx record, @Param("example") GgZgjbxxExample example);

    int updateByExample(@Param("record") GgZgjbxx record, @Param("example") GgZgjbxxExample example);
}