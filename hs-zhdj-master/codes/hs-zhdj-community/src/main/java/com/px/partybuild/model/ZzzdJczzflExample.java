package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzzdJczzflExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzzdJczzflExample() {
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

        public Criteria andBmIsNull() {
            addCriterion("BM is null");
            return (Criteria) this;
        }

        public Criteria andBmIsNotNull() {
            addCriterion("BM is not null");
            return (Criteria) this;
        }

        public Criteria andBmEqualTo(String value) {
            addCriterion("BM =", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotEqualTo(String value) {
            addCriterion("BM <>", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmGreaterThan(String value) {
            addCriterion("BM >", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmGreaterThanOrEqualTo(String value) {
            addCriterion("BM >=", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLessThan(String value) {
            addCriterion("BM <", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLessThanOrEqualTo(String value) {
            addCriterion("BM <=", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLike(String value) {
            addCriterion("BM like", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotLike(String value) {
            addCriterion("BM not like", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmIn(List<String> values) {
            addCriterion("BM in", values, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotIn(List<String> values) {
            addCriterion("BM not in", values, "bm");
            return (Criteria) this;
        }

        public Criteria andBmBetween(String value1, String value2) {
            addCriterion("BM between", value1, value2, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotBetween(String value1, String value2) {
            addCriterion("BM not between", value1, value2, "bm");
            return (Criteria) this;
        }

        public Criteria andHzmcIsNull() {
            addCriterion("HZMC is null");
            return (Criteria) this;
        }

        public Criteria andHzmcIsNotNull() {
            addCriterion("HZMC is not null");
            return (Criteria) this;
        }

        public Criteria andHzmcEqualTo(String value) {
            addCriterion("HZMC =", value, "hzmc");
            return (Criteria) this;
        }

        public Criteria andHzmcNotEqualTo(String value) {
            addCriterion("HZMC <>", value, "hzmc");
            return (Criteria) this;
        }

        public Criteria andHzmcGreaterThan(String value) {
            addCriterion("HZMC >", value, "hzmc");
            return (Criteria) this;
        }

        public Criteria andHzmcGreaterThanOrEqualTo(String value) {
            addCriterion("HZMC >=", value, "hzmc");
            return (Criteria) this;
        }

        public Criteria andHzmcLessThan(String value) {
            addCriterion("HZMC <", value, "hzmc");
            return (Criteria) this;
        }

        public Criteria andHzmcLessThanOrEqualTo(String value) {
            addCriterion("HZMC <=", value, "hzmc");
            return (Criteria) this;
        }

        public Criteria andHzmcLike(String value) {
            addCriterion("HZMC like", value, "hzmc");
            return (Criteria) this;
        }

        public Criteria andHzmcNotLike(String value) {
            addCriterion("HZMC not like", value, "hzmc");
            return (Criteria) this;
        }

        public Criteria andHzmcIn(List<String> values) {
            addCriterion("HZMC in", values, "hzmc");
            return (Criteria) this;
        }

        public Criteria andHzmcNotIn(List<String> values) {
            addCriterion("HZMC not in", values, "hzmc");
            return (Criteria) this;
        }

        public Criteria andHzmcBetween(String value1, String value2) {
            addCriterion("HZMC between", value1, value2, "hzmc");
            return (Criteria) this;
        }

        public Criteria andHzmcNotBetween(String value1, String value2) {
            addCriterion("HZMC not between", value1, value2, "hzmc");
            return (Criteria) this;
        }

        public Criteria andXhIsNull() {
            addCriterion("XH is null");
            return (Criteria) this;
        }

        public Criteria andXhIsNotNull() {
            addCriterion("XH is not null");
            return (Criteria) this;
        }

        public Criteria andXhEqualTo(Integer value) {
            addCriterion("XH =", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotEqualTo(Integer value) {
            addCriterion("XH <>", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThan(Integer value) {
            addCriterion("XH >", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThanOrEqualTo(Integer value) {
            addCriterion("XH >=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThan(Integer value) {
            addCriterion("XH <", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThanOrEqualTo(Integer value) {
            addCriterion("XH <=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhIn(List<Integer> values) {
            addCriterion("XH in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotIn(List<Integer> values) {
            addCriterion("XH not in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhBetween(Integer value1, Integer value2) {
            addCriterion("XH between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotBetween(Integer value1, Integer value2) {
            addCriterion("XH not between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andYl01IsNull() {
            addCriterion("YL01 is null");
            return (Criteria) this;
        }

        public Criteria andYl01IsNotNull() {
            addCriterion("YL01 is not null");
            return (Criteria) this;
        }

        public Criteria andYl01EqualTo(String value) {
            addCriterion("YL01 =", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01NotEqualTo(String value) {
            addCriterion("YL01 <>", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01GreaterThan(String value) {
            addCriterion("YL01 >", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01GreaterThanOrEqualTo(String value) {
            addCriterion("YL01 >=", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01LessThan(String value) {
            addCriterion("YL01 <", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01LessThanOrEqualTo(String value) {
            addCriterion("YL01 <=", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01Like(String value) {
            addCriterion("YL01 like", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01NotLike(String value) {
            addCriterion("YL01 not like", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01In(List<String> values) {
            addCriterion("YL01 in", values, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01NotIn(List<String> values) {
            addCriterion("YL01 not in", values, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01Between(String value1, String value2) {
            addCriterion("YL01 between", value1, value2, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01NotBetween(String value1, String value2) {
            addCriterion("YL01 not between", value1, value2, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl02IsNull() {
            addCriterion("YL02 is null");
            return (Criteria) this;
        }

        public Criteria andYl02IsNotNull() {
            addCriterion("YL02 is not null");
            return (Criteria) this;
        }

        public Criteria andYl02EqualTo(String value) {
            addCriterion("YL02 =", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02NotEqualTo(String value) {
            addCriterion("YL02 <>", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02GreaterThan(String value) {
            addCriterion("YL02 >", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02GreaterThanOrEqualTo(String value) {
            addCriterion("YL02 >=", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02LessThan(String value) {
            addCriterion("YL02 <", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02LessThanOrEqualTo(String value) {
            addCriterion("YL02 <=", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02Like(String value) {
            addCriterion("YL02 like", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02NotLike(String value) {
            addCriterion("YL02 not like", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02In(List<String> values) {
            addCriterion("YL02 in", values, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02NotIn(List<String> values) {
            addCriterion("YL02 not in", values, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02Between(String value1, String value2) {
            addCriterion("YL02 between", value1, value2, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02NotBetween(String value1, String value2) {
            addCriterion("YL02 not between", value1, value2, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl03IsNull() {
            addCriterion("YL03 is null");
            return (Criteria) this;
        }

        public Criteria andYl03IsNotNull() {
            addCriterion("YL03 is not null");
            return (Criteria) this;
        }

        public Criteria andYl03EqualTo(String value) {
            addCriterion("YL03 =", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03NotEqualTo(String value) {
            addCriterion("YL03 <>", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03GreaterThan(String value) {
            addCriterion("YL03 >", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03GreaterThanOrEqualTo(String value) {
            addCriterion("YL03 >=", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03LessThan(String value) {
            addCriterion("YL03 <", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03LessThanOrEqualTo(String value) {
            addCriterion("YL03 <=", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03Like(String value) {
            addCriterion("YL03 like", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03NotLike(String value) {
            addCriterion("YL03 not like", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03In(List<String> values) {
            addCriterion("YL03 in", values, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03NotIn(List<String> values) {
            addCriterion("YL03 not in", values, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03Between(String value1, String value2) {
            addCriterion("YL03 between", value1, value2, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03NotBetween(String value1, String value2) {
            addCriterion("YL03 not between", value1, value2, "yl03");
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