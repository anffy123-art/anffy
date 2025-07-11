package com.px.partybuild.mapper;

import com.px.partybuild.model.DsjFilemrg;
import com.px.partybuild.model.DsjFilemrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsjFilemrgMapper {
    long countByExample(DsjFilemrgExample example);

    int deleteByExample(DsjFilemrgExample example);

    int deleteByPrimaryKey(String fileid);

    int insert(DsjFilemrg record);

    int insertSelective(DsjFilemrg record);

    List<DsjFilemrg> selectByExample(DsjFilemrgExample example);

    DsjFilemrg selectByPrimaryKey(String fileid);

    int updateByExampleSelective(@Param("record") DsjFilemrg record, @Param("example") DsjFilemrgExample example);

    int updateByExample(@Param("record") DsjFilemrg record, @Param("example") DsjFilemrgExample example);

    int updateByPrimaryKeySelective(DsjFilemrg record);

    int updateByPrimaryKey(DsjFilemrg record);
}