package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class DsjCzqkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsjCzqkExample() {
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

        public Criteria andCzqkbsIsNull() {
            addCriterion("CZQKBS is null");
            return (Criteria) this;
        }

        public Criteria andCzqkbsIsNotNull() {
            addCriterion("CZQKBS is not null");
            return (Criteria) this;
        }

        public Criteria andCzqkbsEqualTo(String value) {
            addCriterion("CZQKBS =", value, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andCzqkbsNotEqualTo(String value) {
            addCriterion("CZQKBS <>", value, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andCzqkbsGreaterThan(String value) {
            addCriterion("CZQKBS >", value, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andCzqkbsGreaterThanOrEqualTo(String value) {
            addCriterion("CZQKBS >=", value, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andCzqkbsLessThan(String value) {
            addCriterion("CZQKBS <", value, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andCzqkbsLessThanOrEqualTo(String value) {
            addCriterion("CZQKBS <=", value, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andCzqkbsLike(String value) {
            addCriterion("CZQKBS like", value, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andCzqkbsNotLike(String value) {
            addCriterion("CZQKBS not like", value, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andCzqkbsIn(List<String> values) {
            addCriterion("CZQKBS in", values, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andCzqkbsNotIn(List<String> values) {
            addCriterion("CZQKBS not in", values, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andCzqkbsBetween(String value1, String value2) {
            addCriterion("CZQKBS between", value1, value2, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andCzqkbsNotBetween(String value1, String value2) {
            addCriterion("CZQKBS not between", value1, value2, "czqkbs");
            return (Criteria) this;
        }

        public Criteria andNdIsNull() {
            addCriterion("ND is null");
            return (Criteria) this;
        }

        public Criteria andNdIsNotNull() {
            addCriterion("ND is not null");
            return (Criteria) this;
        }

        public Criteria andNdEqualTo(Integer value) {
            addCriterion("ND =", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotEqualTo(Integer value) {
            addCriterion("ND <>", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThan(Integer value) {
            addCriterion("ND >", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ND >=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThan(Integer value) {
            addCriterion("ND <", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThanOrEqualTo(Integer value) {
            addCriterion("ND <=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdIn(List<Integer> values) {
            addCriterion("ND in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotIn(List<Integer> values) {
            addCriterion("ND not in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdBetween(Integer value1, Integer value2) {
            addCriterion("ND between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotBetween(Integer value1, Integer value2) {
            addCriterion("ND not between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andCpdyIsNull() {
            addCriterion("CPDY is null");
            return (Criteria) this;
        }

        public Criteria andCpdyIsNotNull() {
            addCriterion("CPDY is not null");
            return (Criteria) this;
        }

        public Criteria andCpdyEqualTo(Integer value) {
            addCriterion("CPDY =", value, "cpdy");
            return (Criteria) this;
        }

        public Criteria andCpdyNotEqualTo(Integer value) {
            addCriterion("CPDY <>", value, "cpdy");
            return (Criteria) this;
        }

        public Criteria andCpdyGreaterThan(Integer value) {
            addCriterion("CPDY >", value, "cpdy");
            return (Criteria) this;
        }

        public Criteria andCpdyGreaterThanOrEqualTo(Integer value) {
            addCriterion("CPDY >=", value, "cpdy");
            return (Criteria) this;
        }

        public Criteria andCpdyLessThan(Integer value) {
            addCriterion("CPDY <", value, "cpdy");
            return (Criteria) this;
        }

        public Criteria andCpdyLessThanOrEqualTo(Integer value) {
            addCriterion("CPDY <=", value, "cpdy");
            return (Criteria) this;
        }

        public Criteria andCpdyIn(List<Integer> values) {
            addCriterion("CPDY in", values, "cpdy");
            return (Criteria) this;
        }

        public Criteria andCpdyNotIn(List<Integer> values) {
            addCriterion("CPDY not in", values, "cpdy");
            return (Criteria) this;
        }

        public Criteria andCpdyBetween(Integer value1, Integer value2) {
            addCriterion("CPDY between", value1, value2, "cpdy");
            return (Criteria) this;
        }

        public Criteria andCpdyNotBetween(Integer value1, Integer value2) {
            addCriterion("CPDY not between", value1, value2, "cpdy");
            return (Criteria) this;
        }

        public Criteria andBhgdyIsNull() {
            addCriterion("BHGDY is null");
            return (Criteria) this;
        }

        public Criteria andBhgdyIsNotNull() {
            addCriterion("BHGDY is not null");
            return (Criteria) this;
        }

        public Criteria andBhgdyEqualTo(Integer value) {
            addCriterion("BHGDY =", value, "bhgdy");
            return (Criteria) this;
        }

        public Criteria andBhgdyNotEqualTo(Integer value) {
            addCriterion("BHGDY <>", value, "bhgdy");
            return (Criteria) this;
        }

        public Criteria andBhgdyGreaterThan(Integer value) {
            addCriterion("BHGDY >", value, "bhgdy");
            return (Criteria) this;
        }

        public Criteria andBhgdyGreaterThanOrEqualTo(Integer value) {
            addCriterion("BHGDY >=", value, "bhgdy");
            return (Criteria) this;
        }

        public Criteria andBhgdyLessThan(Integer value) {
            addCriterion("BHGDY <", value, "bhgdy");
            return (Criteria) this;
        }

        public Criteria andBhgdyLessThanOrEqualTo(Integer value) {
            addCriterion("BHGDY <=", value, "bhgdy");
            return (Criteria) this;
        }

        public Criteria andBhgdyIn(List<Integer> values) {
            addCriterion("BHGDY in", values, "bhgdy");
            return (Criteria) this;
        }

        public Criteria andBhgdyNotIn(List<Integer> values) {
            addCriterion("BHGDY not in", values, "bhgdy");
            return (Criteria) this;
        }

        public Criteria andBhgdyBetween(Integer value1, Integer value2) {
            addCriterion("BHGDY between", value1, value2, "bhgdy");
            return (Criteria) this;
        }

        public Criteria andBhgdyNotBetween(Integer value1, Integer value2) {
            addCriterion("BHGDY not between", value1, value2, "bhgdy");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyIsNull() {
            addCriterion("CLDBHGDY is null");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyIsNotNull() {
            addCriterion("CLDBHGDY is not null");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyEqualTo(Integer value) {
            addCriterion("CLDBHGDY =", value, "cldbhgdy");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyNotEqualTo(Integer value) {
            addCriterion("CLDBHGDY <>", value, "cldbhgdy");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyGreaterThan(Integer value) {
            addCriterion("CLDBHGDY >", value, "cldbhgdy");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyGreaterThanOrEqualTo(Integer value) {
            addCriterion("CLDBHGDY >=", value, "cldbhgdy");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyLessThan(Integer value) {
            addCriterion("CLDBHGDY <", value, "cldbhgdy");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyLessThanOrEqualTo(Integer value) {
            addCriterion("CLDBHGDY <=", value, "cldbhgdy");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyIn(List<Integer> values) {
            addCriterion("CLDBHGDY in", values, "cldbhgdy");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyNotIn(List<Integer> values) {
            addCriterion("CLDBHGDY not in", values, "cldbhgdy");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyBetween(Integer value1, Integer value2) {
            addCriterion("CLDBHGDY between", value1, value2, "cldbhgdy");
            return (Criteria) this;
        }

        public Criteria andCldbhgdyNotBetween(Integer value1, Integer value2) {
            addCriterion("CLDBHGDY not between", value1, value2, "cldbhgdy");
            return (Criteria) this;
        }

        public Criteria andCdzrsIsNull() {
            addCriterion("CDZRS is null");
            return (Criteria) this;
        }

        public Criteria andCdzrsIsNotNull() {
            addCriterion("CDZRS is not null");
            return (Criteria) this;
        }

        public Criteria andCdzrsEqualTo(Integer value) {
            addCriterion("CDZRS =", value, "cdzrs");
            return (Criteria) this;
        }

        public Criteria andCdzrsNotEqualTo(Integer value) {
            addCriterion("CDZRS <>", value, "cdzrs");
            return (Criteria) this;
        }

        public Criteria andCdzrsGreaterThan(Integer value) {
            addCriterion("CDZRS >", value, "cdzrs");
            return (Criteria) this;
        }

        public Criteria andCdzrsGreaterThanOrEqualTo(Integer value) {
            addCriterion("CDZRS >=", value, "cdzrs");
            return (Criteria) this;
        }

        public Criteria andCdzrsLessThan(Integer value) {
            addCriterion("CDZRS <", value, "cdzrs");
            return (Criteria) this;
        }

        public Criteria andCdzrsLessThanOrEqualTo(Integer value) {
            addCriterion("CDZRS <=", value, "cdzrs");
            return (Criteria) this;
        }

        public Criteria andCdzrsIn(List<Integer> values) {
            addCriterion("CDZRS in", values, "cdzrs");
            return (Criteria) this;
        }

        public Criteria andCdzrsNotIn(List<Integer> values) {
            addCriterion("CDZRS not in", values, "cdzrs");
            return (Criteria) this;
        }

        public Criteria andCdzrsBetween(Integer value1, Integer value2) {
            addCriterion("CDZRS between", value1, value2, "cdzrs");
            return (Criteria) this;
        }

        public Criteria andCdzrsNotBetween(Integer value1, Integer value2) {
            addCriterion("CDZRS not between", value1, value2, "cdzrs");
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