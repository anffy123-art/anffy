package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class DsjPxpyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsjPxpyExample() {
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

        public Criteria andPxpybsIsNull() {
            addCriterion("PXPYBS is null");
            return (Criteria) this;
        }

        public Criteria andPxpybsIsNotNull() {
            addCriterion("PXPYBS is not null");
            return (Criteria) this;
        }

        public Criteria andPxpybsEqualTo(String value) {
            addCriterion("PXPYBS =", value, "pxpybs");
            return (Criteria) this;
        }

        public Criteria andPxpybsNotEqualTo(String value) {
            addCriterion("PXPYBS <>", value, "pxpybs");
            return (Criteria) this;
        }

        public Criteria andPxpybsGreaterThan(String value) {
            addCriterion("PXPYBS >", value, "pxpybs");
            return (Criteria) this;
        }

        public Criteria andPxpybsGreaterThanOrEqualTo(String value) {
            addCriterion("PXPYBS >=", value, "pxpybs");
            return (Criteria) this;
        }

        public Criteria andPxpybsLessThan(String value) {
            addCriterion("PXPYBS <", value, "pxpybs");
            return (Criteria) this;
        }

        public Criteria andPxpybsLessThanOrEqualTo(String value) {
            addCriterion("PXPYBS <=", value, "pxpybs");
            return (Criteria) this;
        }

        public Criteria andPxpybsLike(String value) {
            addCriterion("PXPYBS like", value, "pxpybs");
            return (Criteria) this;
        }

        public Criteria andPxpybsNotLike(String value) {
            addCriterion("PXPYBS not like", value, "pxpybs");
            return (Criteria) this;
        }

        public Criteria andPxpybsIn(List<String> values) {
            addCriterion("PXPYBS in", values, "pxpybs");
            return (Criteria) this;
        }

        public Criteria andPxpybsNotIn(List<String> values) {
            addCriterion("PXPYBS not in", values, "pxpybs");
            return (Criteria) this;
        }

        public Criteria andPxpybsBetween(String value1, String value2) {
            addCriterion("PXPYBS between", value1, value2, "pxpybs");
            return (Criteria) this;
        }

        public Criteria andPxpybsNotBetween(String value1, String value2) {
            addCriterion("PXPYBS not between", value1, value2, "pxpybs");
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

        public Criteria andXjjcdzzIsNull() {
            addCriterion("XJJCDZZ is null");
            return (Criteria) this;
        }

        public Criteria andXjjcdzzIsNotNull() {
            addCriterion("XJJCDZZ is not null");
            return (Criteria) this;
        }

        public Criteria andXjjcdzzEqualTo(Integer value) {
            addCriterion("XJJCDZZ =", value, "xjjcdzz");
            return (Criteria) this;
        }

        public Criteria andXjjcdzzNotEqualTo(Integer value) {
            addCriterion("XJJCDZZ <>", value, "xjjcdzz");
            return (Criteria) this;
        }

        public Criteria andXjjcdzzGreaterThan(Integer value) {
            addCriterion("XJJCDZZ >", value, "xjjcdzz");
            return (Criteria) this;
        }

        public Criteria andXjjcdzzGreaterThanOrEqualTo(Integer value) {
            addCriterion("XJJCDZZ >=", value, "xjjcdzz");
            return (Criteria) this;
        }

        public Criteria andXjjcdzzLessThan(Integer value) {
            addCriterion("XJJCDZZ <", value, "xjjcdzz");
            return (Criteria) this;
        }

        public Criteria andXjjcdzzLessThanOrEqualTo(Integer value) {
            addCriterion("XJJCDZZ <=", value, "xjjcdzz");
            return (Criteria) this;
        }

        public Criteria andXjjcdzzIn(List<Integer> values) {
            addCriterion("XJJCDZZ in", values, "xjjcdzz");
            return (Criteria) this;
        }

        public Criteria andXjjcdzzNotIn(List<Integer> values) {
            addCriterion("XJJCDZZ not in", values, "xjjcdzz");
            return (Criteria) this;
        }

        public Criteria andXjjcdzzBetween(Integer value1, Integer value2) {
            addCriterion("XJJCDZZ between", value1, value2, "xjjcdzz");
            return (Criteria) this;
        }

        public Criteria andXjjcdzzNotBetween(Integer value1, Integer value2) {
            addCriterion("XJJCDZZ not between", value1, value2, "xjjcdzz");
            return (Criteria) this;
        }

        public Criteria andYxgcdyIsNull() {
            addCriterion("YXGCDY is null");
            return (Criteria) this;
        }

        public Criteria andYxgcdyIsNotNull() {
            addCriterion("YXGCDY is not null");
            return (Criteria) this;
        }

        public Criteria andYxgcdyEqualTo(Integer value) {
            addCriterion("YXGCDY =", value, "yxgcdy");
            return (Criteria) this;
        }

        public Criteria andYxgcdyNotEqualTo(Integer value) {
            addCriterion("YXGCDY <>", value, "yxgcdy");
            return (Criteria) this;
        }

        public Criteria andYxgcdyGreaterThan(Integer value) {
            addCriterion("YXGCDY >", value, "yxgcdy");
            return (Criteria) this;
        }

        public Criteria andYxgcdyGreaterThanOrEqualTo(Integer value) {
            addCriterion("YXGCDY >=", value, "yxgcdy");
            return (Criteria) this;
        }

        public Criteria andYxgcdyLessThan(Integer value) {
            addCriterion("YXGCDY <", value, "yxgcdy");
            return (Criteria) this;
        }

        public Criteria andYxgcdyLessThanOrEqualTo(Integer value) {
            addCriterion("YXGCDY <=", value, "yxgcdy");
            return (Criteria) this;
        }

        public Criteria andYxgcdyIn(List<Integer> values) {
            addCriterion("YXGCDY in", values, "yxgcdy");
            return (Criteria) this;
        }

        public Criteria andYxgcdyNotIn(List<Integer> values) {
            addCriterion("YXGCDY not in", values, "yxgcdy");
            return (Criteria) this;
        }

        public Criteria andYxgcdyBetween(Integer value1, Integer value2) {
            addCriterion("YXGCDY between", value1, value2, "yxgcdy");
            return (Criteria) this;
        }

        public Criteria andYxgcdyNotBetween(Integer value1, Integer value2) {
            addCriterion("YXGCDY not between", value1, value2, "yxgcdy");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzIsNull() {
            addCriterion("YXDWGZZ is null");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzIsNotNull() {
            addCriterion("YXDWGZZ is not null");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzEqualTo(Integer value) {
            addCriterion("YXDWGZZ =", value, "yxdwgzz");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzNotEqualTo(Integer value) {
            addCriterion("YXDWGZZ <>", value, "yxdwgzz");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzGreaterThan(Integer value) {
            addCriterion("YXDWGZZ >", value, "yxdwgzz");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzGreaterThanOrEqualTo(Integer value) {
            addCriterion("YXDWGZZ >=", value, "yxdwgzz");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzLessThan(Integer value) {
            addCriterion("YXDWGZZ <", value, "yxdwgzz");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzLessThanOrEqualTo(Integer value) {
            addCriterion("YXDWGZZ <=", value, "yxdwgzz");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzIn(List<Integer> values) {
            addCriterion("YXDWGZZ in", values, "yxdwgzz");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzNotIn(List<Integer> values) {
            addCriterion("YXDWGZZ not in", values, "yxdwgzz");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzBetween(Integer value1, Integer value2) {
            addCriterion("YXDWGZZ between", value1, value2, "yxdwgzz");
            return (Criteria) this;
        }

        public Criteria andYxdwgzzNotBetween(Integer value1, Integer value2) {
            addCriterion("YXDWGZZ not between", value1, value2, "yxdwgzz");
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