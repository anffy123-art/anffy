package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YsJfysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YsJfysExample() {
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

        public Criteria andJfysidIsNull() {
            addCriterion("JFYSID is null");
            return (Criteria) this;
        }

        public Criteria andJfysidIsNotNull() {
            addCriterion("JFYSID is not null");
            return (Criteria) this;
        }

        public Criteria andJfysidEqualTo(String value) {
            addCriterion("JFYSID =", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidNotEqualTo(String value) {
            addCriterion("JFYSID <>", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidGreaterThan(String value) {
            addCriterion("JFYSID >", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidGreaterThanOrEqualTo(String value) {
            addCriterion("JFYSID >=", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidLessThan(String value) {
            addCriterion("JFYSID <", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidLessThanOrEqualTo(String value) {
            addCriterion("JFYSID <=", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidLike(String value) {
            addCriterion("JFYSID like", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidNotLike(String value) {
            addCriterion("JFYSID not like", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidIn(List<String> values) {
            addCriterion("JFYSID in", values, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidNotIn(List<String> values) {
            addCriterion("JFYSID not in", values, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidBetween(String value1, String value2) {
            addCriterion("JFYSID between", value1, value2, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidNotBetween(String value1, String value2) {
            addCriterion("JFYSID not between", value1, value2, "jfysid");
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

        public Criteria andYsbmcIsNull() {
            addCriterion("YSBMC is null");
            return (Criteria) this;
        }

        public Criteria andYsbmcIsNotNull() {
            addCriterion("YSBMC is not null");
            return (Criteria) this;
        }

        public Criteria andYsbmcEqualTo(String value) {
            addCriterion("YSBMC =", value, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andYsbmcNotEqualTo(String value) {
            addCriterion("YSBMC <>", value, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andYsbmcGreaterThan(String value) {
            addCriterion("YSBMC >", value, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andYsbmcGreaterThanOrEqualTo(String value) {
            addCriterion("YSBMC >=", value, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andYsbmcLessThan(String value) {
            addCriterion("YSBMC <", value, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andYsbmcLessThanOrEqualTo(String value) {
            addCriterion("YSBMC <=", value, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andYsbmcLike(String value) {
            addCriterion("YSBMC like", value, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andYsbmcNotLike(String value) {
            addCriterion("YSBMC not like", value, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andYsbmcIn(List<String> values) {
            addCriterion("YSBMC in", values, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andYsbmcNotIn(List<String> values) {
            addCriterion("YSBMC not in", values, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andYsbmcBetween(String value1, String value2) {
            addCriterion("YSBMC between", value1, value2, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andYsbmcNotBetween(String value1, String value2) {
            addCriterion("YSBMC not between", value1, value2, "ysbmc");
            return (Criteria) this;
        }

        public Criteria andCjsjIsNull() {
            addCriterion("CJSJ is null");
            return (Criteria) this;
        }

        public Criteria andCjsjIsNotNull() {
            addCriterion("CJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andCjsjEqualTo(Date value) {
            addCriterion("CJSJ =", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotEqualTo(Date value) {
            addCriterion("CJSJ <>", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjGreaterThan(Date value) {
            addCriterion("CJSJ >", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjGreaterThanOrEqualTo(Date value) {
            addCriterion("CJSJ >=", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjLessThan(Date value) {
            addCriterion("CJSJ <", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjLessThanOrEqualTo(Date value) {
            addCriterion("CJSJ <=", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjIn(List<Date> values) {
            addCriterion("CJSJ in", values, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotIn(List<Date> values) {
            addCriterion("CJSJ not in", values, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjBetween(Date value1, Date value2) {
            addCriterion("CJSJ between", value1, value2, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotBetween(Date value1, Date value2) {
            addCriterion("CJSJ not between", value1, value2, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjrIsNull() {
            addCriterion("CJR is null");
            return (Criteria) this;
        }

        public Criteria andCjrIsNotNull() {
            addCriterion("CJR is not null");
            return (Criteria) this;
        }

        public Criteria andCjrEqualTo(String value) {
            addCriterion("CJR =", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotEqualTo(String value) {
            addCriterion("CJR <>", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrGreaterThan(String value) {
            addCriterion("CJR >", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrGreaterThanOrEqualTo(String value) {
            addCriterion("CJR >=", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrLessThan(String value) {
            addCriterion("CJR <", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrLessThanOrEqualTo(String value) {
            addCriterion("CJR <=", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrLike(String value) {
            addCriterion("CJR like", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotLike(String value) {
            addCriterion("CJR not like", value, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrIn(List<String> values) {
            addCriterion("CJR in", values, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotIn(List<String> values) {
            addCriterion("CJR not in", values, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrBetween(String value1, String value2) {
            addCriterion("CJR between", value1, value2, "cjr");
            return (Criteria) this;
        }

        public Criteria andCjrNotBetween(String value1, String value2) {
            addCriterion("CJR not between", value1, value2, "cjr");
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