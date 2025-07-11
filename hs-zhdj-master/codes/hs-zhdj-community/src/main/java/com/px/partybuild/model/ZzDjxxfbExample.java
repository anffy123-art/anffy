package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzDjxxfbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzDjxxfbExample() {
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

        public Criteria andRybmIsNull() {
            addCriterion("RYBM is null");
            return (Criteria) this;
        }

        public Criteria andRybmIsNotNull() {
            addCriterion("RYBM is not null");
            return (Criteria) this;
        }

        public Criteria andRybmEqualTo(String value) {
            addCriterion("RYBM =", value, "rybm");
            return (Criteria) this;
        }

        public Criteria andRybmNotEqualTo(String value) {
            addCriterion("RYBM <>", value, "rybm");
            return (Criteria) this;
        }

        public Criteria andRybmGreaterThan(String value) {
            addCriterion("RYBM >", value, "rybm");
            return (Criteria) this;
        }

        public Criteria andRybmGreaterThanOrEqualTo(String value) {
            addCriterion("RYBM >=", value, "rybm");
            return (Criteria) this;
        }

        public Criteria andRybmLessThan(String value) {
            addCriterion("RYBM <", value, "rybm");
            return (Criteria) this;
        }

        public Criteria andRybmLessThanOrEqualTo(String value) {
            addCriterion("RYBM <=", value, "rybm");
            return (Criteria) this;
        }

        public Criteria andRybmLike(String value) {
            addCriterion("RYBM like", value, "rybm");
            return (Criteria) this;
        }

        public Criteria andRybmNotLike(String value) {
            addCriterion("RYBM not like", value, "rybm");
            return (Criteria) this;
        }

        public Criteria andRybmIn(List<String> values) {
            addCriterion("RYBM in", values, "rybm");
            return (Criteria) this;
        }

        public Criteria andRybmNotIn(List<String> values) {
            addCriterion("RYBM not in", values, "rybm");
            return (Criteria) this;
        }

        public Criteria andRybmBetween(String value1, String value2) {
            addCriterion("RYBM between", value1, value2, "rybm");
            return (Criteria) this;
        }

        public Criteria andRybmNotBetween(String value1, String value2) {
            addCriterion("RYBM not between", value1, value2, "rybm");
            return (Criteria) this;
        }

        public Criteria andJrzbrqIsNull() {
            addCriterion("JRZBRQ is null");
            return (Criteria) this;
        }

        public Criteria andJrzbrqIsNotNull() {
            addCriterion("JRZBRQ is not null");
            return (Criteria) this;
        }

        public Criteria andJrzbrqEqualTo(String value) {
            addCriterion("JRZBRQ =", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqNotEqualTo(String value) {
            addCriterion("JRZBRQ <>", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqGreaterThan(String value) {
            addCriterion("JRZBRQ >", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqGreaterThanOrEqualTo(String value) {
            addCriterion("JRZBRQ >=", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqLessThan(String value) {
            addCriterion("JRZBRQ <", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqLessThanOrEqualTo(String value) {
            addCriterion("JRZBRQ <=", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqLike(String value) {
            addCriterion("JRZBRQ like", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqNotLike(String value) {
            addCriterion("JRZBRQ not like", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqIn(List<String> values) {
            addCriterion("JRZBRQ in", values, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqNotIn(List<String> values) {
            addCriterion("JRZBRQ not in", values, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqBetween(String value1, String value2) {
            addCriterion("JRZBRQ between", value1, value2, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqNotBetween(String value1, String value2) {
            addCriterion("JRZBRQ not between", value1, value2, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andDjztIsNull() {
            addCriterion("DJZT is null");
            return (Criteria) this;
        }

        public Criteria andDjztIsNotNull() {
            addCriterion("DJZT is not null");
            return (Criteria) this;
        }

        public Criteria andDjztEqualTo(Integer value) {
            addCriterion("DJZT =", value, "djzt");
            return (Criteria) this;
        }

        public Criteria andDjztNotEqualTo(Integer value) {
            addCriterion("DJZT <>", value, "djzt");
            return (Criteria) this;
        }

        public Criteria andDjztGreaterThan(Integer value) {
            addCriterion("DJZT >", value, "djzt");
            return (Criteria) this;
        }

        public Criteria andDjztGreaterThanOrEqualTo(Integer value) {
            addCriterion("DJZT >=", value, "djzt");
            return (Criteria) this;
        }

        public Criteria andDjztLessThan(Integer value) {
            addCriterion("DJZT <", value, "djzt");
            return (Criteria) this;
        }

        public Criteria andDjztLessThanOrEqualTo(Integer value) {
            addCriterion("DJZT <=", value, "djzt");
            return (Criteria) this;
        }

        public Criteria andDjztIn(List<Integer> values) {
            addCriterion("DJZT in", values, "djzt");
            return (Criteria) this;
        }

        public Criteria andDjztNotIn(List<Integer> values) {
            addCriterion("DJZT not in", values, "djzt");
            return (Criteria) this;
        }

        public Criteria andDjztBetween(Integer value1, Integer value2) {
            addCriterion("DJZT between", value1, value2, "djzt");
            return (Criteria) this;
        }

        public Criteria andDjztNotBetween(Integer value1, Integer value2) {
            addCriterion("DJZT not between", value1, value2, "djzt");
            return (Criteria) this;
        }

        public Criteria andSflddyIsNull() {
            addCriterion("SFLDDY is null");
            return (Criteria) this;
        }

        public Criteria andSflddyIsNotNull() {
            addCriterion("SFLDDY is not null");
            return (Criteria) this;
        }

        public Criteria andSflddyEqualTo(Integer value) {
            addCriterion("SFLDDY =", value, "sflddy");
            return (Criteria) this;
        }

        public Criteria andSflddyNotEqualTo(Integer value) {
            addCriterion("SFLDDY <>", value, "sflddy");
            return (Criteria) this;
        }

        public Criteria andSflddyGreaterThan(Integer value) {
            addCriterion("SFLDDY >", value, "sflddy");
            return (Criteria) this;
        }

        public Criteria andSflddyGreaterThanOrEqualTo(Integer value) {
            addCriterion("SFLDDY >=", value, "sflddy");
            return (Criteria) this;
        }

        public Criteria andSflddyLessThan(Integer value) {
            addCriterion("SFLDDY <", value, "sflddy");
            return (Criteria) this;
        }

        public Criteria andSflddyLessThanOrEqualTo(Integer value) {
            addCriterion("SFLDDY <=", value, "sflddy");
            return (Criteria) this;
        }

        public Criteria andSflddyIn(List<Integer> values) {
            addCriterion("SFLDDY in", values, "sflddy");
            return (Criteria) this;
        }

        public Criteria andSflddyNotIn(List<Integer> values) {
            addCriterion("SFLDDY not in", values, "sflddy");
            return (Criteria) this;
        }

        public Criteria andSflddyBetween(Integer value1, Integer value2) {
            addCriterion("SFLDDY between", value1, value2, "sflddy");
            return (Criteria) this;
        }

        public Criteria andSflddyNotBetween(Integer value1, Integer value2) {
            addCriterion("SFLDDY not between", value1, value2, "sflddy");
            return (Criteria) this;
        }

        public Criteria andSfsldyIsNull() {
            addCriterion("SFSLDY is null");
            return (Criteria) this;
        }

        public Criteria andSfsldyIsNotNull() {
            addCriterion("SFSLDY is not null");
            return (Criteria) this;
        }

        public Criteria andSfsldyEqualTo(Integer value) {
            addCriterion("SFSLDY =", value, "sfsldy");
            return (Criteria) this;
        }

        public Criteria andSfsldyNotEqualTo(Integer value) {
            addCriterion("SFSLDY <>", value, "sfsldy");
            return (Criteria) this;
        }

        public Criteria andSfsldyGreaterThan(Integer value) {
            addCriterion("SFSLDY >", value, "sfsldy");
            return (Criteria) this;
        }

        public Criteria andSfsldyGreaterThanOrEqualTo(Integer value) {
            addCriterion("SFSLDY >=", value, "sfsldy");
            return (Criteria) this;
        }

        public Criteria andSfsldyLessThan(Integer value) {
            addCriterion("SFSLDY <", value, "sfsldy");
            return (Criteria) this;
        }

        public Criteria andSfsldyLessThanOrEqualTo(Integer value) {
            addCriterion("SFSLDY <=", value, "sfsldy");
            return (Criteria) this;
        }

        public Criteria andSfsldyIn(List<Integer> values) {
            addCriterion("SFSLDY in", values, "sfsldy");
            return (Criteria) this;
        }

        public Criteria andSfsldyNotIn(List<Integer> values) {
            addCriterion("SFSLDY not in", values, "sfsldy");
            return (Criteria) this;
        }

        public Criteria andSfsldyBetween(Integer value1, Integer value2) {
            addCriterion("SFSLDY between", value1, value2, "sfsldy");
            return (Criteria) this;
        }

        public Criteria andSfsldyNotBetween(Integer value1, Integer value2) {
            addCriterion("SFSLDY not between", value1, value2, "sfsldy");
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