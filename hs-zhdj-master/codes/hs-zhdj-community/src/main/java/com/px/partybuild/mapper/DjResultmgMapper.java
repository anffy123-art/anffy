package com.px.partybuild.mapper;

import com.px.partybuild.model.DjResultmg;
import com.px.partybuild.model.DjResultmgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjResultmgMapper {
    long countByExample(DjResultmgExample example);

    int deleteByExample(DjResultmgExample example);

    int deleteByPrimaryKey(String djResultmgid);

    int insert(DjResultmg record);

    int insertSelective(DjResultmg record);

    List<DjResultmg> selectByExample(DjResultmgExample example);

    DjResultmg selectByPrimaryKey(String djResultmgid);

    int updateByExampleSelective(@Param("record") DjResultmg record, @Param("example") DjResultmgExample example);

    int updateByExample(@Param("record") DjResultmg record, @Param("example") DjResultmgExample example);

    int updateByPrimaryKeySelective(DjResultmg record);

    int updateByPrimaryKey(DjResultmg record);
}