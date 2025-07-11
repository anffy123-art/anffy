package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DjDnghbfmxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DjDnghbfmxExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDnghbfidIsNull() {
            addCriterion("DNGHBFID is null");
            return (Criteria) this;
        }

        public Criteria andDnghbfidIsNotNull() {
            addCriterion("DNGHBFID is not null");
            return (Criteria) this;
        }

        public Criteria andDnghbfidEqualTo(String value) {
            addCriterion("DNGHBFID =", value, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andDnghbfidNotEqualTo(String value) {
            addCriterion("DNGHBFID <>", value, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andDnghbfidGreaterThan(String value) {
            addCriterion("DNGHBFID >", value, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andDnghbfidGreaterThanOrEqualTo(String value) {
            addCriterion("DNGHBFID >=", value, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andDnghbfidLessThan(String value) {
            addCriterion("DNGHBFID <", value, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andDnghbfidLessThanOrEqualTo(String value) {
            addCriterion("DNGHBFID <=", value, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andDnghbfidLike(String value) {
            addCriterion("DNGHBFID like", value, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andDnghbfidNotLike(String value) {
            addCriterion("DNGHBFID not like", value, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andDnghbfidIn(List<String> values) {
            addCriterion("DNGHBFID in", values, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andDnghbfidNotIn(List<String> values) {
            addCriterion("DNGHBFID not in", values, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andDnghbfidBetween(String value1, String value2) {
            addCriterion("DNGHBFID between", value1, value2, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andDnghbfidNotBetween(String value1, String value2) {
            addCriterion("DNGHBFID not between", value1, value2, "dnghbfid");
            return (Criteria) this;
        }

        public Criteria andCaredateIsNull() {
            addCriterion("CAREDATE is null");
            return (Criteria) this;
        }

        public Criteria andCaredateIsNotNull() {
            addCriterion("CAREDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCaredateEqualTo(Date value) {
            addCriterion("CAREDATE =", value, "caredate");
            return (Criteria) this;
        }

        public Criteria andCaredateNotEqualTo(Date value) {
            addCriterion("CAREDATE <>", value, "caredate");
            return (Criteria) this;
        }

        public Criteria andCaredateGreaterThan(Date value) {
            addCriterion("CAREDATE >", value, "caredate");
            return (Criteria) this;
        }

        public Criteria andCaredateGreaterThanOrEqualTo(Date value) {
            addCriterion("CAREDATE >=", value, "caredate");
            return (Criteria) this;
        }

        public Criteria andCaredateLessThan(Date value) {
            addCriterion("CAREDATE <", value, "caredate");
            return (Criteria) this;
        }

        public Criteria andCaredateLessThanOrEqualTo(Date value) {
            addCriterion("CAREDATE <=", value, "caredate");
            return (Criteria) this;
        }

        public Criteria andCaredateIn(List<Date> values) {
            addCriterion("CAREDATE in", values, "caredate");
            return (Criteria) this;
        }

        public Criteria andCaredateNotIn(List<Date> values) {
            addCriterion("CAREDATE not in", values, "caredate");
            return (Criteria) this;
        }

        public Criteria andCaredateBetween(Date value1, Date value2) {
            addCriterion("CAREDATE between", value1, value2, "caredate");
            return (Criteria) this;
        }

        public Criteria andCaredateNotBetween(Date value1, Date value2) {
            addCriterion("CAREDATE not between", value1, value2, "caredate");
            return (Criteria) this;
        }

        public Criteria andCarecontentIsNull() {
            addCriterion("CARECONTENT is null");
            return (Criteria) this;
        }

        public Criteria andCarecontentIsNotNull() {
            addCriterion("CARECONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andCarecontentEqualTo(String value) {
            addCriterion("CARECONTENT =", value, "carecontent");
            return (Criteria) this;
        }

        public Criteria andCarecontentNotEqualTo(String value) {
            addCriterion("CARECONTENT <>", value, "carecontent");
            return (Criteria) this;
        }

        public Criteria andCarecontentGreaterThan(String value) {
            addCriterion("CARECONTENT >", value, "carecontent");
            return (Criteria) this;
        }

        public Criteria andCarecontentGreaterThanOrEqualTo(String value) {
            addCriterion("CARECONTENT >=", value, "carecontent");
            return (Criteria) this;
        }

        public Criteria andCarecontentLessThan(String value) {
            addCriterion("CARECONTENT <", value, "carecontent");
            return (Criteria) this;
        }

        public Criteria andCarecontentLessThanOrEqualTo(String value) {
            addCriterion("CARECONTENT <=", value, "carecontent");
            return (Criteria) this;
        }

        public Criteria andCarecontentLike(String value) {
            addCriterion("CARECONTENT like", value, "carecontent");
            return (Criteria) this;
        }

        public Criteria andCarecontentNotLike(String value) {
            addCriterion("CARECONTENT not like", value, "carecontent");
            return (Criteria) this;
        }

        public Criteria andCarecontentIn(List<String> values) {
            addCriterion("CARECONTENT in", values, "carecontent");
            return (Criteria) this;
        }

        public Criteria andCarecontentNotIn(List<String> values) {
            addCriterion("CARECONTENT not in", values, "carecontent");
            return (Criteria) this;
        }

        public Criteria andCarecontentBetween(String value1, String value2) {
            addCriterion("CARECONTENT between", value1, value2, "carecontent");
            return (Criteria) this;
        }

        public Criteria andCarecontentNotBetween(String value1, String value2) {
            addCriterion("CARECONTENT not between", value1, value2, "carecontent");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeIsNull() {
            addCriterion("HELPFORMTYPE is null");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeIsNotNull() {
            addCriterion("HELPFORMTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeEqualTo(Integer value) {
            addCriterion("HELPFORMTYPE =", value, "helpformtype");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeNotEqualTo(Integer value) {
            addCriterion("HELPFORMTYPE <>", value, "helpformtype");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeGreaterThan(Integer value) {
            addCriterion("HELPFORMTYPE >", value, "helpformtype");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("HELPFORMTYPE >=", value, "helpformtype");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeLessThan(Integer value) {
            addCriterion("HELPFORMTYPE <", value, "helpformtype");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeLessThanOrEqualTo(Integer value) {
            addCriterion("HELPFORMTYPE <=", value, "helpformtype");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeIn(List<Integer> values) {
            addCriterion("HELPFORMTYPE in", values, "helpformtype");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeNotIn(List<Integer> values) {
            addCriterion("HELPFORMTYPE not in", values, "helpformtype");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeBetween(Integer value1, Integer value2) {
            addCriterion("HELPFORMTYPE between", value1, value2, "helpformtype");
            return (Criteria) this;
        }

        public Criteria andHelpformtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("HELPFORMTYPE not between", value1, value2, "helpformtype");
            return (Criteria) this;
        }

        public Criteria andHelpformIsNull() {
            addCriterion("HELPFORM is null");
            return (Criteria) this;
        }

        public Criteria andHelpformIsNotNull() {
            addCriterion("HELPFORM is not null");
            return (Criteria) this;
        }

        public Criteria andHelpformEqualTo(String value) {
            addCriterion("HELPFORM =", value, "helpform");
            return (Criteria) this;
        }

        public Criteria andHelpformNotEqualTo(String value) {
            addCriterion("HELPFORM <>", value, "helpform");
            return (Criteria) this;
        }

        public Criteria andHelpformGreaterThan(String value) {
            addCriterion("HELPFORM >", value, "helpform");
            return (Criteria) this;
        }

        public Criteria andHelpformGreaterThanOrEqualTo(String value) {
            addCriterion("HELPFORM >=", value, "helpform");
            return (Criteria) this;
        }

        public Criteria andHelpformLessThan(String value) {
            addCriterion("HELPFORM <", value, "helpform");
            return (Criteria) this;
        }

        public Criteria andHelpformLessThanOrEqualTo(String value) {
            addCriterion("HELPFORM <=", value, "helpform");
            return (Criteria) this;
        }

        public Criteria andHelpformLike(String value) {
            addCriterion("HELPFORM like", value, "helpform");
            return (Criteria) this;
        }

        public Criteria andHelpformNotLike(String value) {
            addCriterion("HELPFORM not like", value, "helpform");
            return (Criteria) this;
        }

        public Criteria andHelpformIn(List<String> values) {
            addCriterion("HELPFORM in", values, "helpform");
            return (Criteria) this;
        }

        public Criteria andHelpformNotIn(List<String> values) {
            addCriterion("HELPFORM not in", values, "helpform");
            return (Criteria) this;
        }

        public Criteria andHelpformBetween(String value1, String value2) {
            addCriterion("HELPFORM between", value1, value2, "helpform");
            return (Criteria) this;
        }

        public Criteria andHelpformNotBetween(String value1, String value2) {
            addCriterion("HELPFORM not between", value1, value2, "helpform");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
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