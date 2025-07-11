package com.px.partybuild.mapper;

import com.px.partybuild.model.PeWordtemplate;
import com.px.partybuild.model.PeWordtemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeWordtemplateMapper {
    long countByExample(PeWordtemplateExample example);

    int deleteByExample(PeWordtemplateExample example);

    int deleteByPrimaryKey(String wordtemplateid);

    int insert(PeWordtemplate record);

    int insertSelective(PeWordtemplate record);

    List<PeWordtemplate> selectByExampleWithBLOBs(PeWordtemplateExample example);

    List<PeWordtemplate> selectByExample(PeWordtemplateExample example);

    PeWordtemplate selectByPrimaryKey(String wordtemplateid);

    int updateByExampleSelective(@Param("record") PeWordtemplate record, @Param("example") PeWordtemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") PeWordtemplate record, @Param("example") PeWordtemplateExample example);

    int updateByExample(@Param("record") PeWordtemplate record, @Param("example") PeWordtemplateExample example);

    int updateByPrimaryKeySelective(PeWordtemplate record);

    int updateByPrimaryKeyWithBLOBs(PeWordtemplate record);

    int updateByPrimaryKey(PeWordtemplate record);
}