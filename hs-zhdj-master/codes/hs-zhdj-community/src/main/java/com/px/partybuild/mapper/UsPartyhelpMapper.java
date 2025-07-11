package com.px.partybuild.mapper;

import com.px.partybuild.model.UsPartyhelp;
import com.px.partybuild.model.UsPartyhelpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsPartyhelpMapper {
    long countByExample(UsPartyhelpExample example);

    int deleteByExample(UsPartyhelpExample example);

    int deleteByPrimaryKey(String partyHelpID);

    int insert(UsPartyhelp record);

    int insertSelective(UsPartyhelp record);

    List<UsPartyhelp> selectByExampleWithBLOBs(UsPartyhelpExample example);

    List<UsPartyhelp> selectByExample(UsPartyhelpExample example);

    UsPartyhelp selectByPrimaryKey(String partyHelpID);

    int updateByExampleSelective(@Param("record") UsPartyhelp record, @Param("example") UsPartyhelpExample example);

    int updateByExampleWithBLOBs(@Param("record") UsPartyhelp record, @Param("example") UsPartyhelpExample example);

    int updateByExample(@Param("record") UsPartyhelp record, @Param("example") UsPartyhelpExample example);

    int updateByPrimaryKeySelective(UsPartyhelp record);

    int updateByPrimaryKeyWithBLOBs(UsPartyhelp record);

    int updateByPrimaryKey(UsPartyhelp record);
}