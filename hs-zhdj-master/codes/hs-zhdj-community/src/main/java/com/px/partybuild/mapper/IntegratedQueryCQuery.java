package com.px.partybuild.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface IntegratedQueryCQuery {
    /**
     * @return java.util.List<java.util.HashMap                                                                                                                                                                                                                                                               <                                                                                                                                                                                                                                                               java.lang.String                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                               java.lang.Object>>
     * @Description //TODO 党组织信息高级查询
     * @date 2024-08
     * @Param []
     **/
    List<HashMap<String, Object>> departmentAdvanceList(@Param("dzzmc") String dzzmc,
                                                        @Param("zzlb") String[] zzlb,
                                                        @Param("jczzfl") String[] jczzfl,
                                                        @Param("jldzzrqStart") String jldzzrqStart,
                                                        @Param("jldzzrqEnd") String jldzzrqEnd,
                                                        @Param("gjjmrqStart") String gjjmrqStart,
                                                        @Param("gjjmrqEnd") String gjjmrqEnd,
                                                        @Param("memberCountStart") Integer memberCountStart,
                                                        @Param("memberCountEnd") Integer memberCountEnd,
                                                        @Param("djkpxxYear") Integer djkpxxYear,
                                                        @Param("judgeLevel") Integer[] judgeLevel,
                                                        @Param("honourYear") Integer honourYear,
                                                        @Param("honourlevel") Integer honourlevel,
                                                        @Param("honourType") Integer[] honourType
            , @Param("djkpxxYear_dzb") Integer djkpxxYear_dzb, @Param("judgeLevel_dzb") Integer[] judgeLevel_dzb,@Param("dzzdm") String dzzdm);
}
