package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfSnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfSnExample() {
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

        public Criteria andSnidIsNull() {
            addCriterion("SNID is null");
            return (Criteria) this;
        }

        public Criteria andSnidIsNotNull() {
            addCriterion("SNID is not null");
            return (Criteria) this;
        }

        public Criteria andSnidEqualTo(String value) {
            addCriterion("SNID =", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidNotEqualTo(String value) {
            addCriterion("SNID <>", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidGreaterThan(String value) {
            addCriterion("SNID >", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidGreaterThanOrEqualTo(String value) {
            addCriterion("SNID >=", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidLessThan(String value) {
            addCriterion("SNID <", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidLessThanOrEqualTo(String value) {
            addCriterion("SNID <=", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidLike(String value) {
            addCriterion("SNID like", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidNotLike(String value) {
            addCriterion("SNID not like", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidIn(List<String> values) {
            addCriterion("SNID in", values, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidNotIn(List<String> values) {
            addCriterion("SNID not in", values, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidBetween(String value1, String value2) {
            addCriterion("SNID between", value1, value2, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidNotBetween(String value1, String value2) {
            addCriterion("SNID not between", value1, value2, "snid");
            return (Criteria) this;
        }

        public Criteria andSnnumIsNull() {
            addCriterion("SNNUM is null");
            return (Criteria) this;
        }

        public Criteria andSnnumIsNotNull() {
            addCriterion("SNNUM is not null");
            return (Criteria) this;
        }

        public Criteria andSnnumEqualTo(Integer value) {
            addCriterion("SNNUM =", value, "snnum");
            return (Criteria) this;
        }

        public Criteria andSnnumNotEqualTo(Integer value) {
            addCriterion("SNNUM <>", value, "snnum");
            return (Criteria) this;
        }

        public Criteria andSnnumGreaterThan(Integer value) {
            addCriterion("SNNUM >", value, "snnum");
            return (Criteria) this;
        }

        public Criteria andSnnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SNNUM >=", value, "snnum");
            return (Criteria) this;
        }

        public Criteria andSnnumLessThan(Integer value) {
            addCriterion("SNNUM <", value, "snnum");
            return (Criteria) this;
        }

        public Criteria andSnnumLessThanOrEqualTo(Integer value) {
            addCriterion("SNNUM <=", value, "snnum");
            return (Criteria) this;
        }

        public Criteria andSnnumIn(List<Integer> values) {
            addCriterion("SNNUM in", values, "snnum");
            return (Criteria) this;
        }

        public Criteria andSnnumNotIn(List<Integer> values) {
            addCriterion("SNNUM not in", values, "snnum");
            return (Criteria) this;
        }

        public Criteria andSnnumBetween(Integer value1, Integer value2) {
            addCriterion("SNNUM between", value1, value2, "snnum");
            return (Criteria) this;
        }

        public Criteria andSnnumNotBetween(Integer value1, Integer value2) {
            addCriterion("SNNUM not between", value1, value2, "snnum");
            return (Criteria) this;
        }

        public Criteria andSnkeyIsNull() {
            addCriterion("SNKEY is null");
            return (Criteria) this;
        }

        public Criteria andSnkeyIsNotNull() {
            addCriterion("SNKEY is not null");
            return (Criteria) this;
        }

        public Criteria andSnkeyEqualTo(String value) {
            addCriterion("SNKEY =", value, "snkey");
            return (Criteria) this;
        }

        public Criteria andSnkeyNotEqualTo(String value) {
            addCriterion("SNKEY <>", value, "snkey");
            return (Criteria) this;
        }

        public Criteria andSnkeyGreaterThan(String value) {
            addCriterion("SNKEY >", value, "snkey");
            return (Criteria) this;
        }

        public Criteria andSnkeyGreaterThanOrEqualTo(String value) {
            addCriterion("SNKEY >=", value, "snkey");
            return (Criteria) this;
        }

        public Criteria andSnkeyLessThan(String value) {
            addCriterion("SNKEY <", value, "snkey");
            return (Criteria) this;
        }

        public Criteria andSnkeyLessThanOrEqualTo(String value) {
            addCriterion("SNKEY <=", value, "snkey");
            return (Criteria) this;
        }

        public Criteria andSnkeyLike(String value) {
            addCriterion("SNKEY like", value, "snkey");
            return (Criteria) this;
        }

        public Criteria andSnkeyNotLike(String value) {
            addCriterion("SNKEY not like", value, "snkey");
            return (Criteria) this;
        }

        public Criteria andSnkeyIn(List<String> values) {
            addCriterion("SNKEY in", values, "snkey");
            return (Criteria) this;
        }

        public Criteria andSnkeyNotIn(List<String> values) {
            addCriterion("SNKEY not in", values, "snkey");
            return (Criteria) this;
        }

        public Criteria andSnkeyBetween(String value1, String value2) {
            addCriterion("SNKEY between", value1, value2, "snkey");
            return (Criteria) this;
        }

        public Criteria andSnkeyNotBetween(String value1, String value2) {
            addCriterion("SNKEY not between", value1, value2, "snkey");
            return (Criteria) this;
        }

        public Criteria andPrefixIsNull() {
            addCriterion("PREFIX is null");
            return (Criteria) this;
        }

        public Criteria andPrefixIsNotNull() {
            addCriterion("PREFIX is not null");
            return (Criteria) this;
        }

        public Criteria andPrefixEqualTo(String value) {
            addCriterion("PREFIX =", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotEqualTo(String value) {
            addCriterion("PREFIX <>", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixGreaterThan(String value) {
            addCriterion("PREFIX >", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("PREFIX >=", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLessThan(String value) {
            addCriterion("PREFIX <", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLessThanOrEqualTo(String value) {
            addCriterion("PREFIX <=", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLike(String value) {
            addCriterion("PREFIX like", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotLike(String value) {
            addCriterion("PREFIX not like", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixIn(List<String> values) {
            addCriterion("PREFIX in", values, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotIn(List<String> values) {
            addCriterion("PREFIX not in", values, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixBetween(String value1, String value2) {
            addCriterion("PREFIX between", value1, value2, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotBetween(String value1, String value2) {
            addCriterion("PREFIX not between", value1, value2, "prefix");
            return (Criteria) this;
        }

        public Criteria andResettimeIsNull() {
            addCriterion("RESETTIME is null");
            return (Criteria) this;
        }

        public Criteria andResettimeIsNotNull() {
            addCriterion("RESETTIME is not null");
            return (Criteria) this;
        }

        public Criteria andResettimeEqualTo(Date value) {
            addCriterion("RESETTIME =", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeNotEqualTo(Date value) {
            addCriterion("RESETTIME <>", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeGreaterThan(Date value) {
            addCriterion("RESETTIME >", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RESETTIME >=", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeLessThan(Date value) {
            addCriterion("RESETTIME <", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeLessThanOrEqualTo(Date value) {
            addCriterion("RESETTIME <=", value, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeIn(List<Date> values) {
            addCriterion("RESETTIME in", values, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeNotIn(List<Date> values) {
            addCriterion("RESETTIME not in", values, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeBetween(Date value1, Date value2) {
            addCriterion("RESETTIME between", value1, value2, "resettime");
            return (Criteria) this;
        }

        public Criteria andResettimeNotBetween(Date value1, Date value2) {
            addCriterion("RESETTIME not between", value1, value2, "resettime");
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