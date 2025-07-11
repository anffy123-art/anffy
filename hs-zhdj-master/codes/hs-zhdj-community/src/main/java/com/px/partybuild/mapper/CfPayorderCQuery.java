package com.px.partybuild.mapper;

import com.px.partybuild.vo.PayorderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfPayorderCQuery {
    List<PayorderVo> selectPayorderList(@Param("payState") Integer payState);
}
