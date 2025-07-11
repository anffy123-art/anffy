package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class DsjFzdyqkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsjFzdyqkExample() {
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

        public Criteria andFzdyqkbsIsNull() {
            addCriterion("FZDYQKBS is null");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsIsNotNull() {
            addCriterion("FZDYQKBS is not null");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsEqualTo(String value) {
            addCriterion("FZDYQKBS =", value, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsNotEqualTo(String value) {
            addCriterion("FZDYQKBS <>", value, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsGreaterThan(String value) {
            addCriterion("FZDYQKBS >", value, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsGreaterThanOrEqualTo(String value) {
            addCriterion("FZDYQKBS >=", value, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsLessThan(String value) {
            addCriterion("FZDYQKBS <", value, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsLessThanOrEqualTo(String value) {
            addCriterion("FZDYQKBS <=", value, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsLike(String value) {
            addCriterion("FZDYQKBS like", value, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsNotLike(String value) {
            addCriterion("FZDYQKBS not like", value, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsIn(List<String> values) {
            addCriterion("FZDYQKBS in", values, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsNotIn(List<String> values) {
            addCriterion("FZDYQKBS not in", values, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsBetween(String value1, String value2) {
            addCriterion("FZDYQKBS between", value1, value2, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andFzdyqkbsNotBetween(String value1, String value2) {
            addCriterion("FZDYQKBS not between", value1, value2, "fzdyqkbs");
            return (Criteria) this;
        }

        public Criteria andLbmcIsNull() {
            addCriterion("LBMC is null");
            return (Criteria) this;
        }

        public Criteria andLbmcIsNotNull() {
            addCriterion("LBMC is not null");
            return (Criteria) this;
        }

        public Criteria andLbmcEqualTo(String value) {
            addCriterion("LBMC =", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcNotEqualTo(String value) {
            addCriterion("LBMC <>", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcGreaterThan(String value) {
            addCriterion("LBMC >", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcGreaterThanOrEqualTo(String value) {
            addCriterion("LBMC >=", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcLessThan(String value) {
            addCriterion("LBMC <", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcLessThanOrEqualTo(String value) {
            addCriterion("LBMC <=", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcLike(String value) {
            addCriterion("LBMC like", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcNotLike(String value) {
            addCriterion("LBMC not like", value, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcIn(List<String> values) {
            addCriterion("LBMC in", values, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcNotIn(List<String> values) {
            addCriterion("LBMC not in", values, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcBetween(String value1, String value2) {
            addCriterion("LBMC between", value1, value2, "lbmc");
            return (Criteria) this;
        }

        public Criteria andLbmcNotBetween(String value1, String value2) {
            addCriterion("LBMC not between", value1, value2, "lbmc");
            return (Criteria) this;
        }

        public Criteria andSlIsNull() {
            addCriterion("SL is null");
            return (Criteria) this;
        }

        public Criteria andSlIsNotNull() {
            addCriterion("SL is not null");
            return (Criteria) this;
        }

        public Criteria andSlEqualTo(Integer value) {
            addCriterion("SL =", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotEqualTo(Integer value) {
            addCriterion("SL <>", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlGreaterThan(Integer value) {
            addCriterion("SL >", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlGreaterThanOrEqualTo(Integer value) {
            addCriterion("SL >=", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlLessThan(Integer value) {
            addCriterion("SL <", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlLessThanOrEqualTo(Integer value) {
            addCriterion("SL <=", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlIn(List<Integer> values) {
            addCriterion("SL in", values, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotIn(List<Integer> values) {
            addCriterion("SL not in", values, "sl");
            return (Criteria) this;
        }

        public Criteria andSlBetween(Integer value1, Integer value2) {
            addCriterion("SL between", value1, value2, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotBetween(Integer value1, Integer value2) {
            addCriterion("SL not between", value1, value2, "sl");
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