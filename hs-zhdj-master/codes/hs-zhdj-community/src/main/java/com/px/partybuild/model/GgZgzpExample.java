package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class GgZgzpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GgZgzpExample() {
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

        public Criteria andZgzpbsIsNull() {
            addCriterion("ZGZPBS is null");
            return (Criteria) this;
        }

        public Criteria andZgzpbsIsNotNull() {
            addCriterion("ZGZPBS is not null");
            return (Criteria) this;
        }

        public Criteria andZgzpbsEqualTo(String value) {
            addCriterion("ZGZPBS =", value, "zgzpbs");
            return (Criteria) this;
        }

        public Criteria andZgzpbsNotEqualTo(String value) {
            addCriterion("ZGZPBS <>", value, "zgzpbs");
            return (Criteria) this;
        }

        public Criteria andZgzpbsGreaterThan(String value) {
            addCriterion("ZGZPBS >", value, "zgzpbs");
            return (Criteria) this;
        }

        public Criteria andZgzpbsGreaterThanOrEqualTo(String value) {
            addCriterion("ZGZPBS >=", value, "zgzpbs");
            return (Criteria) this;
        }

        public Criteria andZgzpbsLessThan(String value) {
            addCriterion("ZGZPBS <", value, "zgzpbs");
            return (Criteria) this;
        }

        public Criteria andZgzpbsLessThanOrEqualTo(String value) {
            addCriterion("ZGZPBS <=", value, "zgzpbs");
            return (Criteria) this;
        }

        public Criteria andZgzpbsLike(String value) {
            addCriterion("ZGZPBS like", value, "zgzpbs");
            return (Criteria) this;
        }

        public Criteria andZgzpbsNotLike(String value) {
            addCriterion("ZGZPBS not like", value, "zgzpbs");
            return (Criteria) this;
        }

        public Criteria andZgzpbsIn(List<String> values) {
            addCriterion("ZGZPBS in", values, "zgzpbs");
            return (Criteria) this;
        }

        public Criteria andZgzpbsNotIn(List<String> values) {
            addCriterion("ZGZPBS not in", values, "zgzpbs");
            return (Criteria) this;
        }

        public Criteria andZgzpbsBetween(String value1, String value2) {
            addCriterion("ZGZPBS between", value1, value2, "zgzpbs");
            return (Criteria) this;
        }

        public Criteria andZgzpbsNotBetween(String value1, String value2) {
            addCriterion("ZGZPBS not between", value1, value2, "zgzpbs");
            return (Criteria) this;
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

        public Criteria andYl04IsNull() {
            addCriterion("YL04 is null");
            return (Criteria) this;
        }

        public Criteria andYl04IsNotNull() {
            addCriterion("YL04 is not null");
            return (Criteria) this;
        }

        public Criteria andYl04EqualTo(String value) {
            addCriterion("YL04 =", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotEqualTo(String value) {
            addCriterion("YL04 <>", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04GreaterThan(String value) {
            addCriterion("YL04 >", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04GreaterThanOrEqualTo(String value) {
            addCriterion("YL04 >=", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04LessThan(String value) {
            addCriterion("YL04 <", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04LessThanOrEqualTo(String value) {
            addCriterion("YL04 <=", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04Like(String value) {
            addCriterion("YL04 like", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotLike(String value) {
            addCriterion("YL04 not like", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04In(List<String> values) {
            addCriterion("YL04 in", values, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotIn(List<String> values) {
            addCriterion("YL04 not in", values, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04Between(String value1, String value2) {
            addCriterion("YL04 between", value1, value2, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotBetween(String value1, String value2) {
            addCriterion("YL04 not between", value1, value2, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl07IsNull() {
            addCriterion("YL07 is null");
            return (Criteria) this;
        }

        public Criteria andYl07IsNotNull() {
            addCriterion("YL07 is not null");
            return (Criteria) this;
        }

        public Criteria andYl07EqualTo(String value) {
            addCriterion("YL07 =", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07NotEqualTo(String value) {
            addCriterion("YL07 <>", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07GreaterThan(String value) {
            addCriterion("YL07 >", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07GreaterThanOrEqualTo(String value) {
            addCriterion("YL07 >=", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07LessThan(String value) {
            addCriterion("YL07 <", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07LessThanOrEqualTo(String value) {
            addCriterion("YL07 <=", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07Like(String value) {
            addCriterion("YL07 like", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07NotLike(String value) {
            addCriterion("YL07 not like", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07In(List<String> values) {
            addCriterion("YL07 in", values, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07NotIn(List<String> values) {
            addCriterion("YL07 not in", values, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07Between(String value1, String value2) {
            addCriterion("YL07 between", value1, value2, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07NotBetween(String value1, String value2) {
            addCriterion("YL07 not between", value1, value2, "yl07");
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