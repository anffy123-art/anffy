package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzzdGzgwExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzzdGzgwExample() {
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

        public Criteria andY101IsNull() {
            addCriterion("Y101 is null");
            return (Criteria) this;
        }

        public Criteria andY101IsNotNull() {
            addCriterion("Y101 is not null");
            return (Criteria) this;
        }

        public Criteria andY101EqualTo(String value) {
            addCriterion("Y101 =", value, "y101");
            return (Criteria) this;
        }

        public Criteria andY101NotEqualTo(String value) {
            addCriterion("Y101 <>", value, "y101");
            return (Criteria) this;
        }

        public Criteria andY101GreaterThan(String value) {
            addCriterion("Y101 >", value, "y101");
            return (Criteria) this;
        }

        public Criteria andY101GreaterThanOrEqualTo(String value) {
            addCriterion("Y101 >=", value, "y101");
            return (Criteria) this;
        }

        public Criteria andY101LessThan(String value) {
            addCriterion("Y101 <", value, "y101");
            return (Criteria) this;
        }

        public Criteria andY101LessThanOrEqualTo(String value) {
            addCriterion("Y101 <=", value, "y101");
            return (Criteria) this;
        }

        public Criteria andY101Like(String value) {
            addCriterion("Y101 like", value, "y101");
            return (Criteria) this;
        }

        public Criteria andY101NotLike(String value) {
            addCriterion("Y101 not like", value, "y101");
            return (Criteria) this;
        }

        public Criteria andY101In(List<String> values) {
            addCriterion("Y101 in", values, "y101");
            return (Criteria) this;
        }

        public Criteria andY101NotIn(List<String> values) {
            addCriterion("Y101 not in", values, "y101");
            return (Criteria) this;
        }

        public Criteria andY101Between(String value1, String value2) {
            addCriterion("Y101 between", value1, value2, "y101");
            return (Criteria) this;
        }

        public Criteria andY101NotBetween(String value1, String value2) {
            addCriterion("Y101 not between", value1, value2, "y101");
            return (Criteria) this;
        }

        public Criteria andY102IsNull() {
            addCriterion("Y102 is null");
            return (Criteria) this;
        }

        public Criteria andY102IsNotNull() {
            addCriterion("Y102 is not null");
            return (Criteria) this;
        }

        public Criteria andY102EqualTo(String value) {
            addCriterion("Y102 =", value, "y102");
            return (Criteria) this;
        }

        public Criteria andY102NotEqualTo(String value) {
            addCriterion("Y102 <>", value, "y102");
            return (Criteria) this;
        }

        public Criteria andY102GreaterThan(String value) {
            addCriterion("Y102 >", value, "y102");
            return (Criteria) this;
        }

        public Criteria andY102GreaterThanOrEqualTo(String value) {
            addCriterion("Y102 >=", value, "y102");
            return (Criteria) this;
        }

        public Criteria andY102LessThan(String value) {
            addCriterion("Y102 <", value, "y102");
            return (Criteria) this;
        }

        public Criteria andY102LessThanOrEqualTo(String value) {
            addCriterion("Y102 <=", value, "y102");
            return (Criteria) this;
        }

        public Criteria andY102Like(String value) {
            addCriterion("Y102 like", value, "y102");
            return (Criteria) this;
        }

        public Criteria andY102NotLike(String value) {
            addCriterion("Y102 not like", value, "y102");
            return (Criteria) this;
        }

        public Criteria andY102In(List<String> values) {
            addCriterion("Y102 in", values, "y102");
            return (Criteria) this;
        }

        public Criteria andY102NotIn(List<String> values) {
            addCriterion("Y102 not in", values, "y102");
            return (Criteria) this;
        }

        public Criteria andY102Between(String value1, String value2) {
            addCriterion("Y102 between", value1, value2, "y102");
            return (Criteria) this;
        }

        public Criteria andY102NotBetween(String value1, String value2) {
            addCriterion("Y102 not between", value1, value2, "y102");
            return (Criteria) this;
        }

        public Criteria andY103IsNull() {
            addCriterion("Y103 is null");
            return (Criteria) this;
        }

        public Criteria andY103IsNotNull() {
            addCriterion("Y103 is not null");
            return (Criteria) this;
        }

        public Criteria andY103EqualTo(String value) {
            addCriterion("Y103 =", value, "y103");
            return (Criteria) this;
        }

        public Criteria andY103NotEqualTo(String value) {
            addCriterion("Y103 <>", value, "y103");
            return (Criteria) this;
        }

        public Criteria andY103GreaterThan(String value) {
            addCriterion("Y103 >", value, "y103");
            return (Criteria) this;
        }

        public Criteria andY103GreaterThanOrEqualTo(String value) {
            addCriterion("Y103 >=", value, "y103");
            return (Criteria) this;
        }

        public Criteria andY103LessThan(String value) {
            addCriterion("Y103 <", value, "y103");
            return (Criteria) this;
        }

        public Criteria andY103LessThanOrEqualTo(String value) {
            addCriterion("Y103 <=", value, "y103");
            return (Criteria) this;
        }

        public Criteria andY103Like(String value) {
            addCriterion("Y103 like", value, "y103");
            return (Criteria) this;
        }

        public Criteria andY103NotLike(String value) {
            addCriterion("Y103 not like", value, "y103");
            return (Criteria) this;
        }

        public Criteria andY103In(List<String> values) {
            addCriterion("Y103 in", values, "y103");
            return (Criteria) this;
        }

        public Criteria andY103NotIn(List<String> values) {
            addCriterion("Y103 not in", values, "y103");
            return (Criteria) this;
        }

        public Criteria andY103Between(String value1, String value2) {
            addCriterion("Y103 between", value1, value2, "y103");
            return (Criteria) this;
        }

        public Criteria andY103NotBetween(String value1, String value2) {
            addCriterion("Y103 not between", value1, value2, "y103");
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