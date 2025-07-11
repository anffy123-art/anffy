package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class CfLeaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfLeaderExample() {
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

        public Criteria andLeaderguidIsNull() {
            addCriterion("LEADERGUID is null");
            return (Criteria) this;
        }

        public Criteria andLeaderguidIsNotNull() {
            addCriterion("LEADERGUID is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderguidEqualTo(String value) {
            addCriterion("LEADERGUID =", value, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andLeaderguidNotEqualTo(String value) {
            addCriterion("LEADERGUID <>", value, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andLeaderguidGreaterThan(String value) {
            addCriterion("LEADERGUID >", value, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andLeaderguidGreaterThanOrEqualTo(String value) {
            addCriterion("LEADERGUID >=", value, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andLeaderguidLessThan(String value) {
            addCriterion("LEADERGUID <", value, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andLeaderguidLessThanOrEqualTo(String value) {
            addCriterion("LEADERGUID <=", value, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andLeaderguidLike(String value) {
            addCriterion("LEADERGUID like", value, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andLeaderguidNotLike(String value) {
            addCriterion("LEADERGUID not like", value, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andLeaderguidIn(List<String> values) {
            addCriterion("LEADERGUID in", values, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andLeaderguidNotIn(List<String> values) {
            addCriterion("LEADERGUID not in", values, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andLeaderguidBetween(String value1, String value2) {
            addCriterion("LEADERGUID between", value1, value2, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andLeaderguidNotBetween(String value1, String value2) {
            addCriterion("LEADERGUID not between", value1, value2, "leaderguid");
            return (Criteria) this;
        }

        public Criteria andDpidIsNull() {
            addCriterion("DPID is null");
            return (Criteria) this;
        }

        public Criteria andDpidIsNotNull() {
            addCriterion("DPID is not null");
            return (Criteria) this;
        }

        public Criteria andDpidEqualTo(String value) {
            addCriterion("DPID =", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidNotEqualTo(String value) {
            addCriterion("DPID <>", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidGreaterThan(String value) {
            addCriterion("DPID >", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidGreaterThanOrEqualTo(String value) {
            addCriterion("DPID >=", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidLessThan(String value) {
            addCriterion("DPID <", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidLessThanOrEqualTo(String value) {
            addCriterion("DPID <=", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidLike(String value) {
            addCriterion("DPID like", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidNotLike(String value) {
            addCriterion("DPID not like", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidIn(List<String> values) {
            addCriterion("DPID in", values, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidNotIn(List<String> values) {
            addCriterion("DPID not in", values, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidBetween(String value1, String value2) {
            addCriterion("DPID between", value1, value2, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidNotBetween(String value1, String value2) {
            addCriterion("DPID not between", value1, value2, "dpid");
            return (Criteria) this;
        }

        public Criteria andPosIsNull() {
            addCriterion("POS is null");
            return (Criteria) this;
        }

        public Criteria andPosIsNotNull() {
            addCriterion("POS is not null");
            return (Criteria) this;
        }

        public Criteria andPosEqualTo(String value) {
            addCriterion("POS =", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotEqualTo(String value) {
            addCriterion("POS <>", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosGreaterThan(String value) {
            addCriterion("POS >", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosGreaterThanOrEqualTo(String value) {
            addCriterion("POS >=", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLessThan(String value) {
            addCriterion("POS <", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLessThanOrEqualTo(String value) {
            addCriterion("POS <=", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLike(String value) {
            addCriterion("POS like", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotLike(String value) {
            addCriterion("POS not like", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosIn(List<String> values) {
            addCriterion("POS in", values, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotIn(List<String> values) {
            addCriterion("POS not in", values, "pos");
            return (Criteria) this;
        }

        public Criteria andPosBetween(String value1, String value2) {
            addCriterion("POS between", value1, value2, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotBetween(String value1, String value2) {
            addCriterion("POS not between", value1, value2, "pos");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("USERID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("USERID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNull() {
            addCriterion("SEQUENCE is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("SEQUENCE is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(String value) {
            addCriterion("SEQUENCE =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(String value) {
            addCriterion("SEQUENCE <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(String value) {
            addCriterion("SEQUENCE >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(String value) {
            addCriterion("SEQUENCE >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(String value) {
            addCriterion("SEQUENCE <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(String value) {
            addCriterion("SEQUENCE <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLike(String value) {
            addCriterion("SEQUENCE like", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotLike(String value) {
            addCriterion("SEQUENCE not like", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<String> values) {
            addCriterion("SEQUENCE in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<String> values) {
            addCriterion("SEQUENCE not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(String value1, String value2) {
            addCriterion("SEQUENCE between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(String value1, String value2) {
            addCriterion("SEQUENCE not between", value1, value2, "sequence");
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