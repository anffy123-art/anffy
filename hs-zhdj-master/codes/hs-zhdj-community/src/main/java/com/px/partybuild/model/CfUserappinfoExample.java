package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class CfUserappinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfUserappinfoExample() {
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

        public Criteria andUserappinfoidIsNull() {
            addCriterion("USERAPPINFOID is null");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidIsNotNull() {
            addCriterion("USERAPPINFOID is not null");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidEqualTo(String value) {
            addCriterion("USERAPPINFOID =", value, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidNotEqualTo(String value) {
            addCriterion("USERAPPINFOID <>", value, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidGreaterThan(String value) {
            addCriterion("USERAPPINFOID >", value, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidGreaterThanOrEqualTo(String value) {
            addCriterion("USERAPPINFOID >=", value, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidLessThan(String value) {
            addCriterion("USERAPPINFOID <", value, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidLessThanOrEqualTo(String value) {
            addCriterion("USERAPPINFOID <=", value, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidLike(String value) {
            addCriterion("USERAPPINFOID like", value, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidNotLike(String value) {
            addCriterion("USERAPPINFOID not like", value, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidIn(List<String> values) {
            addCriterion("USERAPPINFOID in", values, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidNotIn(List<String> values) {
            addCriterion("USERAPPINFOID not in", values, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidBetween(String value1, String value2) {
            addCriterion("USERAPPINFOID between", value1, value2, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUserappinfoidNotBetween(String value1, String value2) {
            addCriterion("USERAPPINFOID not between", value1, value2, "userappinfoid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andRefuseridIsNull() {
            addCriterion("REFUSERID is null");
            return (Criteria) this;
        }

        public Criteria andRefuseridIsNotNull() {
            addCriterion("REFUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andRefuseridEqualTo(String value) {
            addCriterion("REFUSERID =", value, "refuserid");
            return (Criteria) this;
        }

        public Criteria andRefuseridNotEqualTo(String value) {
            addCriterion("REFUSERID <>", value, "refuserid");
            return (Criteria) this;
        }

        public Criteria andRefuseridGreaterThan(String value) {
            addCriterion("REFUSERID >", value, "refuserid");
            return (Criteria) this;
        }

        public Criteria andRefuseridGreaterThanOrEqualTo(String value) {
            addCriterion("REFUSERID >=", value, "refuserid");
            return (Criteria) this;
        }

        public Criteria andRefuseridLessThan(String value) {
            addCriterion("REFUSERID <", value, "refuserid");
            return (Criteria) this;
        }

        public Criteria andRefuseridLessThanOrEqualTo(String value) {
            addCriterion("REFUSERID <=", value, "refuserid");
            return (Criteria) this;
        }

        public Criteria andRefuseridLike(String value) {
            addCriterion("REFUSERID like", value, "refuserid");
            return (Criteria) this;
        }

        public Criteria andRefuseridNotLike(String value) {
            addCriterion("REFUSERID not like", value, "refuserid");
            return (Criteria) this;
        }

        public Criteria andRefuseridIn(List<String> values) {
            addCriterion("REFUSERID in", values, "refuserid");
            return (Criteria) this;
        }

        public Criteria andRefuseridNotIn(List<String> values) {
            addCriterion("REFUSERID not in", values, "refuserid");
            return (Criteria) this;
        }

        public Criteria andRefuseridBetween(String value1, String value2) {
            addCriterion("REFUSERID between", value1, value2, "refuserid");
            return (Criteria) this;
        }

        public Criteria andRefuseridNotBetween(String value1, String value2) {
            addCriterion("REFUSERID not between", value1, value2, "refuserid");
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