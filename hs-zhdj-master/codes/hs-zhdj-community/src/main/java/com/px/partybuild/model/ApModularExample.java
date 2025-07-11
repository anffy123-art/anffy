package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ApModularExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApModularExample() {
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

        public Criteria andMidIsNull() {
            addCriterion("MID is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("MID is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(String value) {
            addCriterion("MID =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(String value) {
            addCriterion("MID <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(String value) {
            addCriterion("MID >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(String value) {
            addCriterion("MID >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(String value) {
            addCriterion("MID <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(String value) {
            addCriterion("MID <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLike(String value) {
            addCriterion("MID like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotLike(String value) {
            addCriterion("MID not like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<String> values) {
            addCriterion("MID in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<String> values) {
            addCriterion("MID not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(String value1, String value2) {
            addCriterion("MID between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(String value1, String value2) {
            addCriterion("MID not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andModulargroupIsNull() {
            addCriterion("MODULARGROUP is null");
            return (Criteria) this;
        }

        public Criteria andModulargroupIsNotNull() {
            addCriterion("MODULARGROUP is not null");
            return (Criteria) this;
        }

        public Criteria andModulargroupEqualTo(String value) {
            addCriterion("MODULARGROUP =", value, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModulargroupNotEqualTo(String value) {
            addCriterion("MODULARGROUP <>", value, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModulargroupGreaterThan(String value) {
            addCriterion("MODULARGROUP >", value, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModulargroupGreaterThanOrEqualTo(String value) {
            addCriterion("MODULARGROUP >=", value, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModulargroupLessThan(String value) {
            addCriterion("MODULARGROUP <", value, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModulargroupLessThanOrEqualTo(String value) {
            addCriterion("MODULARGROUP <=", value, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModulargroupLike(String value) {
            addCriterion("MODULARGROUP like", value, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModulargroupNotLike(String value) {
            addCriterion("MODULARGROUP not like", value, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModulargroupIn(List<String> values) {
            addCriterion("MODULARGROUP in", values, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModulargroupNotIn(List<String> values) {
            addCriterion("MODULARGROUP not in", values, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModulargroupBetween(String value1, String value2) {
            addCriterion("MODULARGROUP between", value1, value2, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModulargroupNotBetween(String value1, String value2) {
            addCriterion("MODULARGROUP not between", value1, value2, "modulargroup");
            return (Criteria) this;
        }

        public Criteria andModularnameIsNull() {
            addCriterion("MODULARNAME is null");
            return (Criteria) this;
        }

        public Criteria andModularnameIsNotNull() {
            addCriterion("MODULARNAME is not null");
            return (Criteria) this;
        }

        public Criteria andModularnameEqualTo(String value) {
            addCriterion("MODULARNAME =", value, "modularname");
            return (Criteria) this;
        }

        public Criteria andModularnameNotEqualTo(String value) {
            addCriterion("MODULARNAME <>", value, "modularname");
            return (Criteria) this;
        }

        public Criteria andModularnameGreaterThan(String value) {
            addCriterion("MODULARNAME >", value, "modularname");
            return (Criteria) this;
        }

        public Criteria andModularnameGreaterThanOrEqualTo(String value) {
            addCriterion("MODULARNAME >=", value, "modularname");
            return (Criteria) this;
        }

        public Criteria andModularnameLessThan(String value) {
            addCriterion("MODULARNAME <", value, "modularname");
            return (Criteria) this;
        }

        public Criteria andModularnameLessThanOrEqualTo(String value) {
            addCriterion("MODULARNAME <=", value, "modularname");
            return (Criteria) this;
        }

        public Criteria andModularnameLike(String value) {
            addCriterion("MODULARNAME like", value, "modularname");
            return (Criteria) this;
        }

        public Criteria andModularnameNotLike(String value) {
            addCriterion("MODULARNAME not like", value, "modularname");
            return (Criteria) this;
        }

        public Criteria andModularnameIn(List<String> values) {
            addCriterion("MODULARNAME in", values, "modularname");
            return (Criteria) this;
        }

        public Criteria andModularnameNotIn(List<String> values) {
            addCriterion("MODULARNAME not in", values, "modularname");
            return (Criteria) this;
        }

        public Criteria andModularnameBetween(String value1, String value2) {
            addCriterion("MODULARNAME between", value1, value2, "modularname");
            return (Criteria) this;
        }

        public Criteria andModularnameNotBetween(String value1, String value2) {
            addCriterion("MODULARNAME not between", value1, value2, "modularname");
            return (Criteria) this;
        }

        public Criteria andOrderbyIsNull() {
            addCriterion("ORDERBY is null");
            return (Criteria) this;
        }

        public Criteria andOrderbyIsNotNull() {
            addCriterion("ORDERBY is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbyEqualTo(Integer value) {
            addCriterion("ORDERBY =", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotEqualTo(Integer value) {
            addCriterion("ORDERBY <>", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThan(Integer value) {
            addCriterion("ORDERBY >", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDERBY >=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThan(Integer value) {
            addCriterion("ORDERBY <", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThanOrEqualTo(Integer value) {
            addCriterion("ORDERBY <=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyIn(List<Integer> values) {
            addCriterion("ORDERBY in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotIn(List<Integer> values) {
            addCriterion("ORDERBY not in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyBetween(Integer value1, Integer value2) {
            addCriterion("ORDERBY between", value1, value2, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDERBY not between", value1, value2, "orderby");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("PARENTID is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("PARENTID is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(String value) {
            addCriterion("PARENTID =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(String value) {
            addCriterion("PARENTID <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(String value) {
            addCriterion("PARENTID >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(String value) {
            addCriterion("PARENTID >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(String value) {
            addCriterion("PARENTID <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(String value) {
            addCriterion("PARENTID <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLike(String value) {
            addCriterion("PARENTID like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotLike(String value) {
            addCriterion("PARENTID not like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<String> values) {
            addCriterion("PARENTID in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<String> values) {
            addCriterion("PARENTID not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(String value1, String value2) {
            addCriterion("PARENTID between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(String value1, String value2) {
            addCriterion("PARENTID not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("ICON is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("ICON is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("ICON =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("ICON <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("ICON >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("ICON >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("ICON <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("ICON <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("ICON like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("ICON not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("ICON in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("ICON not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("ICON between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("ICON not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andModularnoIsNull() {
            addCriterion("MODULARNO is null");
            return (Criteria) this;
        }

        public Criteria andModularnoIsNotNull() {
            addCriterion("MODULARNO is not null");
            return (Criteria) this;
        }

        public Criteria andModularnoEqualTo(String value) {
            addCriterion("MODULARNO =", value, "modularno");
            return (Criteria) this;
        }

        public Criteria andModularnoNotEqualTo(String value) {
            addCriterion("MODULARNO <>", value, "modularno");
            return (Criteria) this;
        }

        public Criteria andModularnoGreaterThan(String value) {
            addCriterion("MODULARNO >", value, "modularno");
            return (Criteria) this;
        }

        public Criteria andModularnoGreaterThanOrEqualTo(String value) {
            addCriterion("MODULARNO >=", value, "modularno");
            return (Criteria) this;
        }

        public Criteria andModularnoLessThan(String value) {
            addCriterion("MODULARNO <", value, "modularno");
            return (Criteria) this;
        }

        public Criteria andModularnoLessThanOrEqualTo(String value) {
            addCriterion("MODULARNO <=", value, "modularno");
            return (Criteria) this;
        }

        public Criteria andModularnoLike(String value) {
            addCriterion("MODULARNO like", value, "modularno");
            return (Criteria) this;
        }

        public Criteria andModularnoNotLike(String value) {
            addCriterion("MODULARNO not like", value, "modularno");
            return (Criteria) this;
        }

        public Criteria andModularnoIn(List<String> values) {
            addCriterion("MODULARNO in", values, "modularno");
            return (Criteria) this;
        }

        public Criteria andModularnoNotIn(List<String> values) {
            addCriterion("MODULARNO not in", values, "modularno");
            return (Criteria) this;
        }

        public Criteria andModularnoBetween(String value1, String value2) {
            addCriterion("MODULARNO between", value1, value2, "modularno");
            return (Criteria) this;
        }

        public Criteria andModularnoNotBetween(String value1, String value2) {
            addCriterion("MODULARNO not between", value1, value2, "modularno");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeIsNull() {
            addCriterion("MODULARGROUPTYPE is null");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeIsNotNull() {
            addCriterion("MODULARGROUPTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeEqualTo(Integer value) {
            addCriterion("MODULARGROUPTYPE =", value, "modulargrouptype");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeNotEqualTo(Integer value) {
            addCriterion("MODULARGROUPTYPE <>", value, "modulargrouptype");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeGreaterThan(Integer value) {
            addCriterion("MODULARGROUPTYPE >", value, "modulargrouptype");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MODULARGROUPTYPE >=", value, "modulargrouptype");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeLessThan(Integer value) {
            addCriterion("MODULARGROUPTYPE <", value, "modulargrouptype");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeLessThanOrEqualTo(Integer value) {
            addCriterion("MODULARGROUPTYPE <=", value, "modulargrouptype");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeIn(List<Integer> values) {
            addCriterion("MODULARGROUPTYPE in", values, "modulargrouptype");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeNotIn(List<Integer> values) {
            addCriterion("MODULARGROUPTYPE not in", values, "modulargrouptype");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeBetween(Integer value1, Integer value2) {
            addCriterion("MODULARGROUPTYPE between", value1, value2, "modulargrouptype");
            return (Criteria) this;
        }

        public Criteria andModulargrouptypeNotBetween(Integer value1, Integer value2) {
            addCriterion("MODULARGROUPTYPE not between", value1, value2, "modulargrouptype");
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