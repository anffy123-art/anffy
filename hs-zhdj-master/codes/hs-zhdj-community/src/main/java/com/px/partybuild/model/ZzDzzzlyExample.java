package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzDzzzlyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzDzzzlyExample() {
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

        public Criteria andDzzzlyidIsNull() {
            addCriterion("DZZZLYID is null");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidIsNotNull() {
            addCriterion("DZZZLYID is not null");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidEqualTo(String value) {
            addCriterion("DZZZLYID =", value, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidNotEqualTo(String value) {
            addCriterion("DZZZLYID <>", value, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidGreaterThan(String value) {
            addCriterion("DZZZLYID >", value, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidGreaterThanOrEqualTo(String value) {
            addCriterion("DZZZLYID >=", value, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidLessThan(String value) {
            addCriterion("DZZZLYID <", value, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidLessThanOrEqualTo(String value) {
            addCriterion("DZZZLYID <=", value, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidLike(String value) {
            addCriterion("DZZZLYID like", value, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidNotLike(String value) {
            addCriterion("DZZZLYID not like", value, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidIn(List<String> values) {
            addCriterion("DZZZLYID in", values, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidNotIn(List<String> values) {
            addCriterion("DZZZLYID not in", values, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidBetween(String value1, String value2) {
            addCriterion("DZZZLYID between", value1, value2, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzzlyidNotBetween(String value1, String value2) {
            addCriterion("DZZZLYID not between", value1, value2, "dzzzlyid");
            return (Criteria) this;
        }

        public Criteria andDzzdmIsNull() {
            addCriterion("DZZDM is null");
            return (Criteria) this;
        }

        public Criteria andDzzdmIsNotNull() {
            addCriterion("DZZDM is not null");
            return (Criteria) this;
        }

        public Criteria andDzzdmEqualTo(String value) {
            addCriterion("DZZDM =", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotEqualTo(String value) {
            addCriterion("DZZDM <>", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmGreaterThan(String value) {
            addCriterion("DZZDM >", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmGreaterThanOrEqualTo(String value) {
            addCriterion("DZZDM >=", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmLessThan(String value) {
            addCriterion("DZZDM <", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmLessThanOrEqualTo(String value) {
            addCriterion("DZZDM <=", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmLike(String value) {
            addCriterion("DZZDM like", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotLike(String value) {
            addCriterion("DZZDM not like", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmIn(List<String> values) {
            addCriterion("DZZDM in", values, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotIn(List<String> values) {
            addCriterion("DZZDM not in", values, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmBetween(String value1, String value2) {
            addCriterion("DZZDM between", value1, value2, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotBetween(String value1, String value2) {
            addCriterion("DZZDM not between", value1, value2, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzmcIsNull() {
            addCriterion("DZZMC is null");
            return (Criteria) this;
        }

        public Criteria andDzzmcIsNotNull() {
            addCriterion("DZZMC is not null");
            return (Criteria) this;
        }

        public Criteria andDzzmcEqualTo(String value) {
            addCriterion("DZZMC =", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotEqualTo(String value) {
            addCriterion("DZZMC <>", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcGreaterThan(String value) {
            addCriterion("DZZMC >", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcGreaterThanOrEqualTo(String value) {
            addCriterion("DZZMC >=", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLessThan(String value) {
            addCriterion("DZZMC <", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLessThanOrEqualTo(String value) {
            addCriterion("DZZMC <=", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLike(String value) {
            addCriterion("DZZMC like", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotLike(String value) {
            addCriterion("DZZMC not like", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcIn(List<String> values) {
            addCriterion("DZZMC in", values, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotIn(List<String> values) {
            addCriterion("DZZMC not in", values, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcBetween(String value1, String value2) {
            addCriterion("DZZMC between", value1, value2, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotBetween(String value1, String value2) {
            addCriterion("DZZMC not between", value1, value2, "dzzmc");
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

        public Criteria andXmIsNull() {
            addCriterion("XM is null");
            return (Criteria) this;
        }

        public Criteria andXmIsNotNull() {
            addCriterion("XM is not null");
            return (Criteria) this;
        }

        public Criteria andXmEqualTo(String value) {
            addCriterion("XM =", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotEqualTo(String value) {
            addCriterion("XM <>", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThan(String value) {
            addCriterion("XM >", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThanOrEqualTo(String value) {
            addCriterion("XM >=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThan(String value) {
            addCriterion("XM <", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThanOrEqualTo(String value) {
            addCriterion("XM <=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLike(String value) {
            addCriterion("XM like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotLike(String value) {
            addCriterion("XM not like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmIn(List<String> values) {
            addCriterion("XM in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotIn(List<String> values) {
            addCriterion("XM not in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmBetween(String value1, String value2) {
            addCriterion("XM between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotBetween(String value1, String value2) {
            addCriterion("XM not between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andZlytypeIsNull() {
            addCriterion("ZLYTYPE is null");
            return (Criteria) this;
        }

        public Criteria andZlytypeIsNotNull() {
            addCriterion("ZLYTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andZlytypeEqualTo(Integer value) {
            addCriterion("ZLYTYPE =", value, "zlytype");
            return (Criteria) this;
        }

        public Criteria andZlytypeNotEqualTo(Integer value) {
            addCriterion("ZLYTYPE <>", value, "zlytype");
            return (Criteria) this;
        }

        public Criteria andZlytypeGreaterThan(Integer value) {
            addCriterion("ZLYTYPE >", value, "zlytype");
            return (Criteria) this;
        }

        public Criteria andZlytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZLYTYPE >=", value, "zlytype");
            return (Criteria) this;
        }

        public Criteria andZlytypeLessThan(Integer value) {
            addCriterion("ZLYTYPE <", value, "zlytype");
            return (Criteria) this;
        }

        public Criteria andZlytypeLessThanOrEqualTo(Integer value) {
            addCriterion("ZLYTYPE <=", value, "zlytype");
            return (Criteria) this;
        }

        public Criteria andZlytypeIn(List<Integer> values) {
            addCriterion("ZLYTYPE in", values, "zlytype");
            return (Criteria) this;
        }

        public Criteria andZlytypeNotIn(List<Integer> values) {
            addCriterion("ZLYTYPE not in", values, "zlytype");
            return (Criteria) this;
        }

        public Criteria andZlytypeBetween(Integer value1, Integer value2) {
            addCriterion("ZLYTYPE between", value1, value2, "zlytype");
            return (Criteria) this;
        }

        public Criteria andZlytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ZLYTYPE not between", value1, value2, "zlytype");
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