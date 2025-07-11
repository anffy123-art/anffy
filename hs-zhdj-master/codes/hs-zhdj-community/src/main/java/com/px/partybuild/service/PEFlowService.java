package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.*;

import java.util.HashMap;
import java.util.List;

public interface PEFlowService {

    int savegSuperiorapp(PeSuperiorapp model, String flowId, String userId, String userName);

    PeSuperiorapp getSuperiorappByUserId(String userId);

    PeSuperiorapp getSuperiorappById(String putrecordId);

    int delsuperiorTalk(String joinUserId, String flowId);

    int saveZzbmba(PeZzbmba model, String flowId, String userId, String userName);

    PeZzbmba getZzbmbaByUserId(String userId);

    PeZzbmba getZzbmbaById(String putrecordId);

    int delZzbmba(String joinUserId, String flowId);

    int saveBrdzb(PeBrdzb model, String flowId, String userId, String userName);

    PeBrdzb getBrdzbByUserId(String userId);

    PeBrdzb getBrdzbById(String putrecordId);

    int delBrdzb(String joinUserId, String flowId);

    int saveRdxs(PeRdxs model, String flowId, String userId, String userName);

    PeRdxs getRdxsByUserId(String userId);

    PeRdxs getRdxsById(String putrecordId);

    int delRdxs(String joinUserId, String flowId);

    PeJxjykc getJxjykcByUserId(String userId);

    int saveJxjykc(PeJxjykc model, List<PeJxjykcqkWithBLOBs> recordList, String flowId, String userId, String userName);

    PageInfo<HashMap<String, Object>> getJxjykcqkList(int page, int rows, String trainInspectId);

    int delJxjykc(String joinUserId, String flowId);

    int saveTczzsq(PeTczzsq model, String flowId, String userId, String userName);

    PeTczzsq getTczzsqByUserId(String userId);

    PeTczzsq getTczzsqById(String putrecordId);

    int delTczzsq(String joinUserId, String flowId);

    int saveZbdhtl(PeZbdhtl model, String flowId, String userId, String userName);

    PeZbdhtl getZbdhtlByUserId(String userId);

    PeZbdhtl getZbdhtlById(String putrecordId);

    int delZbdhtl(String joinUserId, String flowId);

    int saveSjdwsp(PeSjdwsp model, String flowId, String userId, String userName);

    PeSjdwsp getSjdwspByUserId(String userId);

    PeSjdwsp getSjdwspById(String putrecordId);

    int delSjdwsp(String joinUserId, String flowId);

    PeZlgd getZlgdByUserId(String userId);

    PeZlgd getZlgdById(String putrecordId);

    int delZlgd(String joinUserId, String flowId);

    int saveZlgd(PeZlgd model, String flowId, String userId, String userName);

    PeSjprth getSjprthByUserId(String userId);

    PeSjprth getSjprthById(String putrecordId);

    int delSjprth(String joinUserId, String flowId);

    PageInfo<HashMap<String, Object>> getSjprthmxList(int page, int rows, String sjprthId);

    int saveSjprth(PeSjprth model,List<PeSjprthmx> userlist, String flowId, String userId, String userName);
}
