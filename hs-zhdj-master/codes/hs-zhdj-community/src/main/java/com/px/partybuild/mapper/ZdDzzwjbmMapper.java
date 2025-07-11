package com.px.partybuild.mapper;

import com.px.partybuild.model.ZdDzzwjbm;
import com.px.partybuild.model.ZdDzzwjbmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZdDzzwjbmMapper {
    long countByExample(ZdDzzwjbmExample example);

    int deleteByExample(ZdDzzwjbmExample example);

    int insert(ZdDzzwjbm record);

    int insertSelective(ZdDzzwjbm record);

    List<ZdDzzwjbm> selectByExample(ZdDzzwjbmExample example);

    int updateByExampleSelective(@Param("record") ZdDzzwjbm record, @Param("example") ZdDzzwjbmExample example);

    int updateByExample(@Param("record") ZdDzzwjbm record, @Param("example") ZdDzzwjbmExample example);
}