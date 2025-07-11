package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class DsjDydtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsjDydtExample() {
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

        public Criteria andDydtbsIsNull() {
            addCriterion("DYDTBS is null");
            return (Criteria) this;
        }

        public Criteria andDydtbsIsNotNull() {
            addCriterion("DYDTBS is not null");
            return (Criteria) this;
        }

        public Criteria andDydtbsEqualTo(String value) {
            addCriterion("DYDTBS =", value, "dydtbs");
            return (Criteria) this;
        }

        public Criteria andDydtbsNotEqualTo(String value) {
            addCriterion("DYDTBS <>", value, "dydtbs");
            return (Criteria) this;
        }

        public Criteria andDydtbsGreaterThan(String value) {
            addCriterion("DYDTBS >", value, "dydtbs");
            return (Criteria) this;
        }

        public Criteria andDydtbsGreaterThanOrEqualTo(String value) {
            addCriterion("DYDTBS >=", value, "dydtbs");
            return (Criteria) this;
        }

        public Criteria andDydtbsLessThan(String value) {
            addCriterion("DYDTBS <", value, "dydtbs");
            return (Criteria) this;
        }

        public Criteria andDydtbsLessThanOrEqualTo(String value) {
            addCriterion("DYDTBS <=", value, "dydtbs");
            return (Criteria) this;
        }

        public Criteria andDydtbsLike(String value) {
            addCriterion("DYDTBS like", value, "dydtbs");
            return (Criteria) this;
        }

        public Criteria andDydtbsNotLike(String value) {
            addCriterion("DYDTBS not like", value, "dydtbs");
            return (Criteria) this;
        }

        public Criteria andDydtbsIn(List<String> values) {
            addCriterion("DYDTBS in", values, "dydtbs");
            return (Criteria) this;
        }

        public Criteria andDydtbsNotIn(List<String> values) {
            addCriterion("DYDTBS not in", values, "dydtbs");
            return (Criteria) this;
        }

        public Criteria andDydtbsBetween(String value1, String value2) {
            addCriterion("DYDTBS between", value1, value2, "dydtbs");
            return (Criteria) this;
        }

        public Criteria andDydtbsNotBetween(String value1, String value2) {
            addCriterion("DYDTBS not between", value1, value2, "dydtbs");
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

        public Criteria andZrIsNull() {
            addCriterion("ZR is null");
            return (Criteria) this;
        }

        public Criteria andZrIsNotNull() {
            addCriterion("ZR is not null");
            return (Criteria) this;
        }

        public Criteria andZrEqualTo(Integer value) {
            addCriterion("ZR =", value, "zr");
            return (Criteria) this;
        }

        public Criteria andZrNotEqualTo(Integer value) {
            addCriterion("ZR <>", value, "zr");
            return (Criteria) this;
        }

        public Criteria andZrGreaterThan(Integer value) {
            addCriterion("ZR >", value, "zr");
            return (Criteria) this;
        }

        public Criteria andZrGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZR >=", value, "zr");
            return (Criteria) this;
        }

        public Criteria andZrLessThan(Integer value) {
            addCriterion("ZR <", value, "zr");
            return (Criteria) this;
        }

        public Criteria andZrLessThanOrEqualTo(Integer value) {
            addCriterion("ZR <=", value, "zr");
            return (Criteria) this;
        }

        public Criteria andZrIn(List<Integer> values) {
            addCriterion("ZR in", values, "zr");
            return (Criteria) this;
        }

        public Criteria andZrNotIn(List<Integer> values) {
            addCriterion("ZR not in", values, "zr");
            return (Criteria) this;
        }

        public Criteria andZrBetween(Integer value1, Integer value2) {
            addCriterion("ZR between", value1, value2, "zr");
            return (Criteria) this;
        }

        public Criteria andZrNotBetween(Integer value1, Integer value2) {
            addCriterion("ZR not between", value1, value2, "zr");
            return (Criteria) this;
        }

        public Criteria andZcIsNull() {
            addCriterion("ZC is null");
            return (Criteria) this;
        }

        public Criteria andZcIsNotNull() {
            addCriterion("ZC is not null");
            return (Criteria) this;
        }

        public Criteria andZcEqualTo(Integer value) {
            addCriterion("ZC =", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcNotEqualTo(Integer value) {
            addCriterion("ZC <>", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcGreaterThan(Integer value) {
            addCriterion("ZC >", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZC >=", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcLessThan(Integer value) {
            addCriterion("ZC <", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcLessThanOrEqualTo(Integer value) {
            addCriterion("ZC <=", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcIn(List<Integer> values) {
            addCriterion("ZC in", values, "zc");
            return (Criteria) this;
        }

        public Criteria andZcNotIn(List<Integer> values) {
            addCriterion("ZC not in", values, "zc");
            return (Criteria) this;
        }

        public Criteria andZcBetween(Integer value1, Integer value2) {
            addCriterion("ZC between", value1, value2, "zc");
            return (Criteria) this;
        }

        public Criteria andZcNotBetween(Integer value1, Integer value2) {
            addCriterion("ZC not between", value1, value2, "zc");
            return (Criteria) this;
        }

        public Criteria andNbjzIsNull() {
            addCriterion("NBJZ is null");
            return (Criteria) this;
        }

        public Criteria andNbjzIsNotNull() {
            addCriterion("NBJZ is not null");
            return (Criteria) this;
        }

        public Criteria andNbjzEqualTo(Integer value) {
            addCriterion("NBJZ =", value, "nbjz");
            return (Criteria) this;
        }

        public Criteria andNbjzNotEqualTo(Integer value) {
            addCriterion("NBJZ <>", value, "nbjz");
            return (Criteria) this;
        }

        public Criteria andNbjzGreaterThan(Integer value) {
            addCriterion("NBJZ >", value, "nbjz");
            return (Criteria) this;
        }

        public Criteria andNbjzGreaterThanOrEqualTo(Integer value) {
            addCriterion("NBJZ >=", value, "nbjz");
            return (Criteria) this;
        }

        public Criteria andNbjzLessThan(Integer value) {
            addCriterion("NBJZ <", value, "nbjz");
            return (Criteria) this;
        }

        public Criteria andNbjzLessThanOrEqualTo(Integer value) {
            addCriterion("NBJZ <=", value, "nbjz");
            return (Criteria) this;
        }

        public Criteria andNbjzIn(List<Integer> values) {
            addCriterion("NBJZ in", values, "nbjz");
            return (Criteria) this;
        }

        public Criteria andNbjzNotIn(List<Integer> values) {
            addCriterion("NBJZ not in", values, "nbjz");
            return (Criteria) this;
        }

        public Criteria andNbjzBetween(Integer value1, Integer value2) {
            addCriterion("NBJZ between", value1, value2, "nbjz");
            return (Criteria) this;
        }

        public Criteria andNbjzNotBetween(Integer value1, Integer value2) {
            addCriterion("NBJZ not between", value1, value2, "nbjz");
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