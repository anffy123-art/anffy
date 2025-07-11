package com.px.partybuild.mapper;

import com.px.partybuild.model.DjBrand;
import com.px.partybuild.model.DjBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjBrandMapper {
    long countByExample(DjBrandExample example);

    int deleteByExample(DjBrandExample example);

    int deleteByPrimaryKey(String brandid);

    int insert(DjBrand record);

    int insertSelective(DjBrand record);

    List<DjBrand> selectByExampleWithBLOBs(DjBrandExample example);

    List<DjBrand> selectByExample(DjBrandExample example);

    DjBrand selectByPrimaryKey(String brandid);

    int updateByExampleSelective(@Param("record") DjBrand record, @Param("example") DjBrandExample example);

    int updateByExampleWithBLOBs(@Param("record") DjBrand record, @Param("example") DjBrandExample example);

    int updateByExample(@Param("record") DjBrand record, @Param("example") DjBrandExample example);

    int updateByPrimaryKeySelective(DjBrand record);

    int updateByPrimaryKeyWithBLOBs(DjBrand record);

    int updateByPrimaryKey(DjBrand record);
}