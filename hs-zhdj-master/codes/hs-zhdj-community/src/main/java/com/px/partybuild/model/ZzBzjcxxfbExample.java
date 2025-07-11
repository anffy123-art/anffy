package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzBzjcxxfbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzBzjcxxfbExample() {
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

        public Criteria andBzjcxxbsIsNull() {
            addCriterion("BZJCXXBS is null");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsIsNotNull() {
            addCriterion("BZJCXXBS is not null");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsEqualTo(String value) {
            addCriterion("BZJCXXBS =", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsNotEqualTo(String value) {
            addCriterion("BZJCXXBS <>", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsGreaterThan(String value) {
            addCriterion("BZJCXXBS >", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsGreaterThanOrEqualTo(String value) {
            addCriterion("BZJCXXBS >=", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsLessThan(String value) {
            addCriterion("BZJCXXBS <", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsLessThanOrEqualTo(String value) {
            addCriterion("BZJCXXBS <=", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsLike(String value) {
            addCriterion("BZJCXXBS like", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsNotLike(String value) {
            addCriterion("BZJCXXBS not like", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsIn(List<String> values) {
            addCriterion("BZJCXXBS in", values, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsNotIn(List<String> values) {
            addCriterion("BZJCXXBS not in", values, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsBetween(String value1, String value2) {
            addCriterion("BZJCXXBS between", value1, value2, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsNotBetween(String value1, String value2) {
            addCriterion("BZJCXXBS not between", value1, value2, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andWyhdyIsNull() {
            addCriterion("WYHDY is null");
            return (Criteria) this;
        }

        public Criteria andWyhdyIsNotNull() {
            addCriterion("WYHDY is not null");
            return (Criteria) this;
        }

        public Criteria andWyhdyEqualTo(Integer value) {
            addCriterion("WYHDY =", value, "wyhdy");
            return (Criteria) this;
        }

        public Criteria andWyhdyNotEqualTo(Integer value) {
            addCriterion("WYHDY <>", value, "wyhdy");
            return (Criteria) this;
        }

        public Criteria andWyhdyGreaterThan(Integer value) {
            addCriterion("WYHDY >", value, "wyhdy");
            return (Criteria) this;
        }

        public Criteria andWyhdyGreaterThanOrEqualTo(Integer value) {
            addCriterion("WYHDY >=", value, "wyhdy");
            return (Criteria) this;
        }

        public Criteria andWyhdyLessThan(Integer value) {
            addCriterion("WYHDY <", value, "wyhdy");
            return (Criteria) this;
        }

        public Criteria andWyhdyLessThanOrEqualTo(Integer value) {
            addCriterion("WYHDY <=", value, "wyhdy");
            return (Criteria) this;
        }

        public Criteria andWyhdyIn(List<Integer> values) {
            addCriterion("WYHDY in", values, "wyhdy");
            return (Criteria) this;
        }

        public Criteria andWyhdyNotIn(List<Integer> values) {
            addCriterion("WYHDY not in", values, "wyhdy");
            return (Criteria) this;
        }

        public Criteria andWyhdyBetween(Integer value1, Integer value2) {
            addCriterion("WYHDY between", value1, value2, "wyhdy");
            return (Criteria) this;
        }

        public Criteria andWyhdyNotBetween(Integer value1, Integer value2) {
            addCriterion("WYHDY not between", value1, value2, "wyhdy");
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