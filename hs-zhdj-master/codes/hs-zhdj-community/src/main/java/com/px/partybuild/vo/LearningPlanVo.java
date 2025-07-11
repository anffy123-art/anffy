package com.px.partybuild.vo;

import com.px.partybuild.model.ZzLearningplanWithBLOBs;
import lombok.Data;

@Data
public class LearningPlanVo extends ZzLearningplanWithBLOBs {
    public String learningPlanTypeName;
    public String recordStatusName;
    public String partyName;
}
