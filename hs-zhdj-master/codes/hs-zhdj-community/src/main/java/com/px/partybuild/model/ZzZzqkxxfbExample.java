package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzZzqkxxfbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzZzqkxxfbExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDzzdmIsNull() {
            addCriterion("DZZDM is null");
            return (Criteria) this;
        }

        public Criteria andDzzdmIsNotNull() {
            addCriterion("DZZDM is not null");
            return (Criteria) this;
        }

        public Criteria andDzzdmEqualTo(String value) {
            addCriterion("DZZDM =", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotEqualTo(String value) {
            addCriterion("DZZDM <>", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmGreaterThan(String value) {
            addCriterion("DZZDM >", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmGreaterThanOrEqualTo(String value) {
            addCriterion("DZZDM >=", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmLessThan(String value) {
            addCriterion("DZZDM <", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmLessThanOrEqualTo(String value) {
            addCriterion("DZZDM <=", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmLike(String value) {
            addCriterion("DZZDM like", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotLike(String value) {
            addCriterion("DZZDM not like", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmIn(List<String> values) {
            addCriterion("DZZDM in", values, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotIn(List<String> values) {
            addCriterion("DZZDM not in", values, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmBetween(String value1, String value2) {
            addCriterion("DZZDM between", value1, value2, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotBetween(String value1, String value2) {
            addCriterion("DZZDM not between", value1, value2, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andZzlbIsNull() {
            addCriterion("ZZLB is null");
            return (Criteria) this;
        }

        public Criteria andZzlbIsNotNull() {
            addCriterion("ZZLB is not null");
            return (Criteria) this;
        }

        public Criteria andZzlbEqualTo(String value) {
            addCriterion("ZZLB =", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbNotEqualTo(String value) {
            addCriterion("ZZLB <>", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbGreaterThan(String value) {
            addCriterion("ZZLB >", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbGreaterThanOrEqualTo(String value) {
            addCriterion("ZZLB >=", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbLessThan(String value) {
            addCriterion("ZZLB <", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbLessThanOrEqualTo(String value) {
            addCriterion("ZZLB <=", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbLike(String value) {
            addCriterion("ZZLB like", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbNotLike(String value) {
            addCriterion("ZZLB not like", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbIn(List<String> values) {
            addCriterion("ZZLB in", values, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbNotIn(List<String> values) {
            addCriterion("ZZLB not in", values, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbBetween(String value1, String value2) {
            addCriterion("ZZLB between", value1, value2, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbNotBetween(String value1, String value2) {
            addCriterion("ZZLB not between", value1, value2, "zzlb");
            return (Criteria) this;
        }

        public Criteria andJczzflIsNull() {
            addCriterion("JCZZFL is null");
            return (Criteria) this;
        }

        public Criteria andJczzflIsNotNull() {
            addCriterion("JCZZFL is not null");
            return (Criteria) this;
        }

        public Criteria andJczzflEqualTo(String value) {
            addCriterion("JCZZFL =", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflNotEqualTo(String value) {
            addCriterion("JCZZFL <>", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflGreaterThan(String value) {
            addCriterion("JCZZFL >", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflGreaterThanOrEqualTo(String value) {
            addCriterion("JCZZFL >=", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflLessThan(String value) {
            addCriterion("JCZZFL <", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflLessThanOrEqualTo(String value) {
            addCriterion("JCZZFL <=", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflLike(String value) {
            addCriterion("JCZZFL like", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflNotLike(String value) {
            addCriterion("JCZZFL not like", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflIn(List<String> values) {
            addCriterion("JCZZFL in", values, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflNotIn(List<String> values) {
            addCriterion("JCZZFL not in", values, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflBetween(String value1, String value2) {
            addCriterion("JCZZFL between", value1, value2, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflNotBetween(String value1, String value2) {
            addCriterion("JCZZFL not between", value1, value2, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andZgrsIsNull() {
            addCriterion("ZGRS is null");
            return (Criteria) this;
        }

        public Criteria andZgrsIsNotNull() {
            addCriterion("ZGRS is not null");
            return (Criteria) this;
        }

        public Criteria andZgrsEqualTo(Integer value) {
            addCriterion("ZGRS =", value, "zgrs");
            return (Criteria) this;
        }

        public Criteria andZgrsNotEqualTo(Integer value) {
            addCriterion("ZGRS <>", value, "zgrs");
            return (Criteria) this;
        }

        public Criteria andZgrsGreaterThan(Integer value) {
            addCriterion("ZGRS >", value, "zgrs");
            return (Criteria) this;
        }

        public Criteria andZgrsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZGRS >=", value, "zgrs");
            return (Criteria) this;
        }

        public Criteria andZgrsLessThan(Integer value) {
            addCriterion("ZGRS <", value, "zgrs");
            return (Criteria) this;
        }

        public Criteria andZgrsLessThanOrEqualTo(Integer value) {
            addCriterion("ZGRS <=", value, "zgrs");
            return (Criteria) this;
        }

        public Criteria andZgrsIn(List<Integer> values) {
            addCriterion("ZGRS in", values, "zgrs");
            return (Criteria) this;
        }

        public Criteria andZgrsNotIn(List<Integer> values) {
            addCriterion("ZGRS not in", values, "zgrs");
            return (Criteria) this;
        }

        public Criteria andZgrsBetween(Integer value1, Integer value2) {
            addCriterion("ZGRS between", value1, value2, "zgrs");
            return (Criteria) this;
        }

        public Criteria andZgrsNotBetween(Integer value1, Integer value2) {
            addCriterion("ZGRS not between", value1, value2, "zgrs");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmIsNull() {
            addCriterion("DXZZZBM is null");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmIsNotNull() {
            addCriterion("DXZZZBM is not null");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmEqualTo(String value) {
            addCriterion("DXZZZBM =", value, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmNotEqualTo(String value) {
            addCriterion("DXZZZBM <>", value, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmGreaterThan(String value) {
            addCriterion("DXZZZBM >", value, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmGreaterThanOrEqualTo(String value) {
            addCriterion("DXZZZBM >=", value, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmLessThan(String value) {
            addCriterion("DXZZZBM <", value, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmLessThanOrEqualTo(String value) {
            addCriterion("DXZZZBM <=", value, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmLike(String value) {
            addCriterion("DXZZZBM like", value, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmNotLike(String value) {
            addCriterion("DXZZZBM not like", value, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmIn(List<String> values) {
            addCriterion("DXZZZBM in", values, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmNotIn(List<String> values) {
            addCriterion("DXZZZBM not in", values, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmBetween(String value1, String value2) {
            addCriterion("DXZZZBM between", value1, value2, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzbmNotBetween(String value1, String value2) {
            addCriterion("DXZZZBM not between", value1, value2, "dxzzzbm");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcIsNull() {
            addCriterion("DXZZZMC is null");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcIsNotNull() {
            addCriterion("DXZZZMC is not null");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcEqualTo(String value) {
            addCriterion("DXZZZMC =", value, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcNotEqualTo(String value) {
            addCriterion("DXZZZMC <>", value, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcGreaterThan(String value) {
            addCriterion("DXZZZMC >", value, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcGreaterThanOrEqualTo(String value) {
            addCriterion("DXZZZMC >=", value, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcLessThan(String value) {
            addCriterion("DXZZZMC <", value, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcLessThanOrEqualTo(String value) {
            addCriterion("DXZZZMC <=", value, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcLike(String value) {
            addCriterion("DXZZZMC like", value, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcNotLike(String value) {
            addCriterion("DXZZZMC not like", value, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcIn(List<String> values) {
            addCriterion("DXZZZMC in", values, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcNotIn(List<String> values) {
            addCriterion("DXZZZMC not in", values, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcBetween(String value1, String value2) {
            addCriterion("DXZZZMC between", value1, value2, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andDxzzzmcNotBetween(String value1, String value2) {
            addCriterion("DXZZZMC not between", value1, value2, "dxzzzmc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcIsNull() {
            addCriterion("LDJTJC is null");
            return (Criteria) this;
        }

        public Criteria andLdjtjcIsNotNull() {
            addCriterion("LDJTJC is not null");
            return (Criteria) this;
        }

        public Criteria andLdjtjcEqualTo(String value) {
            addCriterion("LDJTJC =", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcNotEqualTo(String value) {
            addCriterion("LDJTJC <>", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcGreaterThan(String value) {
            addCriterion("LDJTJC >", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcGreaterThanOrEqualTo(String value) {
            addCriterion("LDJTJC >=", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcLessThan(String value) {
            addCriterion("LDJTJC <", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcLessThanOrEqualTo(String value) {
            addCriterion("LDJTJC <=", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcLike(String value) {
            addCriterion("LDJTJC like", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcNotLike(String value) {
            addCriterion("LDJTJC not like", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcIn(List<String> values) {
            addCriterion("LDJTJC in", values, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcNotIn(List<String> values) {
            addCriterion("LDJTJC not in", values, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcBetween(String value1, String value2) {
            addCriterion("LDJTJC between", value1, value2, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcNotBetween(String value1, String value2) {
            addCriterion("LDJTJC not between", value1, value2, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andDyzsIsNull() {
            addCriterion("DYZS is null");
            return (Criteria) this;
        }

        public Criteria andDyzsIsNotNull() {
            addCriterion("DYZS is not null");
            return (Criteria) this;
        }

        public Criteria andDyzsEqualTo(Integer value) {
            addCriterion("DYZS =", value, "dyzs");
            return (Criteria) this;
        }

        public Criteria andDyzsNotEqualTo(Integer value) {
            addCriterion("DYZS <>", value, "dyzs");
            return (Criteria) this;
        }

        public Criteria andDyzsGreaterThan(Integer value) {
            addCriterion("DYZS >", value, "dyzs");
            return (Criteria) this;
        }

        public Criteria andDyzsGreaterThanOrEqualTo(Integer value) {
            addCriterion("DYZS >=", value, "dyzs");
            return (Criteria) this;
        }

        public Criteria andDyzsLessThan(Integer value) {
            addCriterion("DYZS <", value, "dyzs");
            return (Criteria) this;
        }

        public Criteria andDyzsLessThanOrEqualTo(Integer value) {
            addCriterion("DYZS <=", value, "dyzs");
            return (Criteria) this;
        }

        public Criteria andDyzsIn(List<Integer> values) {
            addCriterion("DYZS in", values, "dyzs");
            return (Criteria) this;
        }

        public Criteria andDyzsNotIn(List<Integer> values) {
            addCriterion("DYZS not in", values, "dyzs");
            return (Criteria) this;
        }

        public Criteria andDyzsBetween(Integer value1, Integer value2) {
            addCriterion("DYZS between", value1, value2, "dyzs");
            return (Criteria) this;
        }

        public Criteria andDyzsNotBetween(Integer value1, Integer value2) {
            addCriterion("DYZS not between", value1, value2, "dyzs");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}