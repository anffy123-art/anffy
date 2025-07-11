package com.px.partybuild.mapper;

import com.px.partybuild.model.DjzzrsJgfz;
import com.px.partybuild.model.DjzzrsJgfzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DjzzrsJgfzMapper {
    long countByExample(DjzzrsJgfzExample example);

    int deleteByExample(DjzzrsJgfzExample example);

    int deleteByPrimaryKey(String jgfzid);

    int insert(DjzzrsJgfz record);

    int insertSelective(DjzzrsJgfz record);

    List<DjzzrsJgfz> selectByExample(DjzzrsJgfzExample example);

    DjzzrsJgfz selectByPrimaryKey(String jgfzid);

    int updateByExampleSelective(@Param("record") DjzzrsJgfz record, @Param("example") DjzzrsJgfzExample example);

    int updateByExample(@Param("record") DjzzrsJgfz record, @Param("example") DjzzrsJgfzExample example);

    int updateByPrimaryKeySelective(DjzzrsJgfz record);

    int updateByPrimaryKey(DjzzrsJgfz record);
}