package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ApRolemodularExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApRolemodularExample() {
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

        public Criteria andRmidIsNull() {
            addCriterion("RMID is null");
            return (Criteria) this;
        }

        public Criteria andRmidIsNotNull() {
            addCriterion("RMID is not null");
            return (Criteria) this;
        }

        public Criteria andRmidEqualTo(String value) {
            addCriterion("RMID =", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotEqualTo(String value) {
            addCriterion("RMID <>", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidGreaterThan(String value) {
            addCriterion("RMID >", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidGreaterThanOrEqualTo(String value) {
            addCriterion("RMID >=", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLessThan(String value) {
            addCriterion("RMID <", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLessThanOrEqualTo(String value) {
            addCriterion("RMID <=", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidLike(String value) {
            addCriterion("RMID like", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotLike(String value) {
            addCriterion("RMID not like", value, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidIn(List<String> values) {
            addCriterion("RMID in", values, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotIn(List<String> values) {
            addCriterion("RMID not in", values, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidBetween(String value1, String value2) {
            addCriterion("RMID between", value1, value2, "rmid");
            return (Criteria) this;
        }

        public Criteria andRmidNotBetween(String value1, String value2) {
            addCriterion("RMID not between", value1, value2, "rmid");
            return (Criteria) this;
        }

        public Criteria andModularidIsNull() {
            addCriterion("MODULARID is null");
            return (Criteria) this;
        }

        public Criteria andModularidIsNotNull() {
            addCriterion("MODULARID is not null");
            return (Criteria) this;
        }

        public Criteria andModularidEqualTo(String value) {
            addCriterion("MODULARID =", value, "modularid");
            return (Criteria) this;
        }

        public Criteria andModularidNotEqualTo(String value) {
            addCriterion("MODULARID <>", value, "modularid");
            return (Criteria) this;
        }

        public Criteria andModularidGreaterThan(String value) {
            addCriterion("MODULARID >", value, "modularid");
            return (Criteria) this;
        }

        public Criteria andModularidGreaterThanOrEqualTo(String value) {
            addCriterion("MODULARID >=", value, "modularid");
            return (Criteria) this;
        }

        public Criteria andModularidLessThan(String value) {
            addCriterion("MODULARID <", value, "modularid");
            return (Criteria) this;
        }

        public Criteria andModularidLessThanOrEqualTo(String value) {
            addCriterion("MODULARID <=", value, "modularid");
            return (Criteria) this;
        }

        public Criteria andModularidLike(String value) {
            addCriterion("MODULARID like", value, "modularid");
            return (Criteria) this;
        }

        public Criteria andModularidNotLike(String value) {
            addCriterion("MODULARID not like", value, "modularid");
            return (Criteria) this;
        }

        public Criteria andModularidIn(List<String> values) {
            addCriterion("MODULARID in", values, "modularid");
            return (Criteria) this;
        }

        public Criteria andModularidNotIn(List<String> values) {
            addCriterion("MODULARID not in", values, "modularid");
            return (Criteria) this;
        }

        public Criteria andModularidBetween(String value1, String value2) {
            addCriterion("MODULARID between", value1, value2, "modularid");
            return (Criteria) this;
        }

        public Criteria andModularidNotBetween(String value1, String value2) {
            addCriterion("MODULARID not between", value1, value2, "modularid");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("ROLEID is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("ROLEID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(String value) {
            addCriterion("ROLEID =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(String value) {
            addCriterion("ROLEID <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(String value) {
            addCriterion("ROLEID >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(String value) {
            addCriterion("ROLEID >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(String value) {
            addCriterion("ROLEID <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(String value) {
            addCriterion("ROLEID <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLike(String value) {
            addCriterion("ROLEID like", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotLike(String value) {
            addCriterion("ROLEID not like", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<String> values) {
            addCriterion("ROLEID in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<String> values) {
            addCriterion("ROLEID not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(String value1, String value2) {
            addCriterion("ROLEID between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(String value1, String value2) {
            addCriterion("ROLEID not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andIscommonuseIsNull() {
            addCriterion("ISCOMMONUSE is null");
            return (Criteria) this;
        }

        public Criteria andIscommonuseIsNotNull() {
            addCriterion("ISCOMMONUSE is not null");
            return (Criteria) this;
        }

        public Criteria andIscommonuseEqualTo(Integer value) {
            addCriterion("ISCOMMONUSE =", value, "iscommonuse");
            return (Criteria) this;
        }

        public Criteria andIscommonuseNotEqualTo(Integer value) {
            addCriterion("ISCOMMONUSE <>", value, "iscommonuse");
            return (Criteria) this;
        }

        public Criteria andIscommonuseGreaterThan(Integer value) {
            addCriterion("ISCOMMONUSE >", value, "iscommonuse");
            return (Criteria) this;
        }

        public Criteria andIscommonuseGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISCOMMONUSE >=", value, "iscommonuse");
            return (Criteria) this;
        }

        public Criteria andIscommonuseLessThan(Integer value) {
            addCriterion("ISCOMMONUSE <", value, "iscommonuse");
            return (Criteria) this;
        }

        public Criteria andIscommonuseLessThanOrEqualTo(Integer value) {
            addCriterion("ISCOMMONUSE <=", value, "iscommonuse");
            return (Criteria) this;
        }

        public Criteria andIscommonuseIn(List<Integer> values) {
            addCriterion("ISCOMMONUSE in", values, "iscommonuse");
            return (Criteria) this;
        }

        public Criteria andIscommonuseNotIn(List<Integer> values) {
            addCriterion("ISCOMMONUSE not in", values, "iscommonuse");
            return (Criteria) this;
        }

        public Criteria andIscommonuseBetween(Integer value1, Integer value2) {
            addCriterion("ISCOMMONUSE between", value1, value2, "iscommonuse");
            return (Criteria) this;
        }

        public Criteria andIscommonuseNotBetween(Integer value1, Integer value2) {
            addCriterion("ISCOMMONUSE not between", value1, value2, "iscommonuse");
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