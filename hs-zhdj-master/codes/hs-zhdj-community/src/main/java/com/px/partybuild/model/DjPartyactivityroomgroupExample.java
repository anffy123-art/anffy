package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class DjPartyactivityroomgroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DjPartyactivityroomgroupExample() {
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

        public Criteria andGroupidIsNull() {
            addCriterion("GROUPID is null");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNotNull() {
            addCriterion("GROUPID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupidEqualTo(String value) {
            addCriterion("GROUPID =", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotEqualTo(String value) {
            addCriterion("GROUPID <>", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThan(String value) {
            addCriterion("GROUPID >", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPID >=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThan(String value) {
            addCriterion("GROUPID <", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThanOrEqualTo(String value) {
            addCriterion("GROUPID <=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLike(String value) {
            addCriterion("GROUPID like", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotLike(String value) {
            addCriterion("GROUPID not like", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidIn(List<String> values) {
            addCriterion("GROUPID in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotIn(List<String> values) {
            addCriterion("GROUPID not in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidBetween(String value1, String value2) {
            addCriterion("GROUPID between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotBetween(String value1, String value2) {
            addCriterion("GROUPID not between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidIsNull() {
            addCriterion("PARTYACTIVITYROOMID is null");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidIsNotNull() {
            addCriterion("PARTYACTIVITYROOMID is not null");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidEqualTo(String value) {
            addCriterion("PARTYACTIVITYROOMID =", value, "partyactivityroomid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidNotEqualTo(String value) {
            addCriterion("PARTYACTIVITYROOMID <>", value, "partyactivityroomid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidGreaterThan(String value) {
            addCriterion("PARTYACTIVITYROOMID >", value, "partyactivityroomid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidGreaterThanOrEqualTo(String value) {
            addCriterion("PARTYACTIVITYROOMID >=", value, "partyactivityroomid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidLessThan(String value) {
            addCriterion("PARTYACTIVITYROOMID <", value, "partyactivityroomid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidLessThanOrEqualTo(String value) {
            addCriterion("PARTYACTIVITYROOMID <=", value, "partyactivityroomid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidLike(String value) {
            addCriterion("PARTYACTIVITYROOMID like", value, "partyactivityroomid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidNotLike(String value) {
            addCriterion("PARTYACTIVITYROOMID not like", value, "partyactivityroomid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidIn(List<String> values) {
            addCriterion("PARTYACTIVITYROOMID in", values, "partyactivityroomid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidNotIn(List<String> values) {
            addCriterion("PARTYACTIVITYROOMID not in", values, "partyactivityroomid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidBetween(String value1, String value2) {
            addCriterion("PARTYACTIVITYROOMID between", value1, value2, "partyactivityroomid");
            return (Criteria) this;
        }

        public Criteria andPartyactivityroomidNotBetween(String value1, String value2) {
            addCriterion("PARTYACTIVITYROOMID not between", value1, value2, "partyactivityroomid");
            return (Criteria) this;
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

        public Criteria andDzzmcIsNull() {
            addCriterion("DZZMC is null");
            return (Criteria) this;
        }

        public Criteria andDzzmcIsNotNull() {
            addCriterion("DZZMC is not null");
            return (Criteria) this;
        }

        public Criteria andDzzmcEqualTo(String value) {
            addCriterion("DZZMC =", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotEqualTo(String value) {
            addCriterion("DZZMC <>", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcGreaterThan(String value) {
            addCriterion("DZZMC >", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcGreaterThanOrEqualTo(String value) {
            addCriterion("DZZMC >=", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLessThan(String value) {
            addCriterion("DZZMC <", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLessThanOrEqualTo(String value) {
            addCriterion("DZZMC <=", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLike(String value) {
            addCriterion("DZZMC like", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotLike(String value) {
            addCriterion("DZZMC not like", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcIn(List<String> values) {
            addCriterion("DZZMC in", values, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotIn(List<String> values) {
            addCriterion("DZZMC not in", values, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcBetween(String value1, String value2) {
            addCriterion("DZZMC between", value1, value2, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotBetween(String value1, String value2) {
            addCriterion("DZZMC not between", value1, value2, "dzzmc");
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