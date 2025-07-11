package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MhSylmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MhSylmExample() {
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

        public Criteria andSylmbsIsNull() {
            addCriterion("SYLMBS is null");
            return (Criteria) this;
        }

        public Criteria andSylmbsIsNotNull() {
            addCriterion("SYLMBS is not null");
            return (Criteria) this;
        }

        public Criteria andSylmbsEqualTo(String value) {
            addCriterion("SYLMBS =", value, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andSylmbsNotEqualTo(String value) {
            addCriterion("SYLMBS <>", value, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andSylmbsGreaterThan(String value) {
            addCriterion("SYLMBS >", value, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andSylmbsGreaterThanOrEqualTo(String value) {
            addCriterion("SYLMBS >=", value, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andSylmbsLessThan(String value) {
            addCriterion("SYLMBS <", value, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andSylmbsLessThanOrEqualTo(String value) {
            addCriterion("SYLMBS <=", value, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andSylmbsLike(String value) {
            addCriterion("SYLMBS like", value, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andSylmbsNotLike(String value) {
            addCriterion("SYLMBS not like", value, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andSylmbsIn(List<String> values) {
            addCriterion("SYLMBS in", values, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andSylmbsNotIn(List<String> values) {
            addCriterion("SYLMBS not in", values, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andSylmbsBetween(String value1, String value2) {
            addCriterion("SYLMBS between", value1, value2, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andSylmbsNotBetween(String value1, String value2) {
            addCriterion("SYLMBS not between", value1, value2, "sylmbs");
            return (Criteria) this;
        }

        public Criteria andLmlxIsNull() {
            addCriterion("LMLX is null");
            return (Criteria) this;
        }

        public Criteria andLmlxIsNotNull() {
            addCriterion("LMLX is not null");
            return (Criteria) this;
        }

        public Criteria andLmlxEqualTo(Integer value) {
            addCriterion("LMLX =", value, "lmlx");
            return (Criteria) this;
        }

        public Criteria andLmlxNotEqualTo(Integer value) {
            addCriterion("LMLX <>", value, "lmlx");
            return (Criteria) this;
        }

        public Criteria andLmlxGreaterThan(Integer value) {
            addCriterion("LMLX >", value, "lmlx");
            return (Criteria) this;
        }

        public Criteria andLmlxGreaterThanOrEqualTo(Integer value) {
            addCriterion("LMLX >=", value, "lmlx");
            return (Criteria) this;
        }

        public Criteria andLmlxLessThan(Integer value) {
            addCriterion("LMLX <", value, "lmlx");
            return (Criteria) this;
        }

        public Criteria andLmlxLessThanOrEqualTo(Integer value) {
            addCriterion("LMLX <=", value, "lmlx");
            return (Criteria) this;
        }

        public Criteria andLmlxIn(List<Integer> values) {
            addCriterion("LMLX in", values, "lmlx");
            return (Criteria) this;
        }

        public Criteria andLmlxNotIn(List<Integer> values) {
            addCriterion("LMLX not in", values, "lmlx");
            return (Criteria) this;
        }

        public Criteria andLmlxBetween(Integer value1, Integer value2) {
            addCriterion("LMLX between", value1, value2, "lmlx");
            return (Criteria) this;
        }

        public Criteria andLmlxNotBetween(Integer value1, Integer value2) {
            addCriterion("LMLX not between", value1, value2, "lmlx");
            return (Criteria) this;
        }

        public Criteria andLmbtIsNull() {
            addCriterion("LMBT is null");
            return (Criteria) this;
        }

        public Criteria andLmbtIsNotNull() {
            addCriterion("LMBT is not null");
            return (Criteria) this;
        }

        public Criteria andLmbtEqualTo(String value) {
            addCriterion("LMBT =", value, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmbtNotEqualTo(String value) {
            addCriterion("LMBT <>", value, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmbtGreaterThan(String value) {
            addCriterion("LMBT >", value, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmbtGreaterThanOrEqualTo(String value) {
            addCriterion("LMBT >=", value, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmbtLessThan(String value) {
            addCriterion("LMBT <", value, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmbtLessThanOrEqualTo(String value) {
            addCriterion("LMBT <=", value, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmbtLike(String value) {
            addCriterion("LMBT like", value, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmbtNotLike(String value) {
            addCriterion("LMBT not like", value, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmbtIn(List<String> values) {
            addCriterion("LMBT in", values, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmbtNotIn(List<String> values) {
            addCriterion("LMBT not in", values, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmbtBetween(String value1, String value2) {
            addCriterion("LMBT between", value1, value2, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmbtNotBetween(String value1, String value2) {
            addCriterion("LMBT not between", value1, value2, "lmbt");
            return (Criteria) this;
        }

        public Criteria andLmtpdzIsNull() {
            addCriterion("LMTPDZ is null");
            return (Criteria) this;
        }

        public Criteria andLmtpdzIsNotNull() {
            addCriterion("LMTPDZ is not null");
            return (Criteria) this;
        }

        public Criteria andLmtpdzEqualTo(String value) {
            addCriterion("LMTPDZ =", value, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andLmtpdzNotEqualTo(String value) {
            addCriterion("LMTPDZ <>", value, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andLmtpdzGreaterThan(String value) {
            addCriterion("LMTPDZ >", value, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andLmtpdzGreaterThanOrEqualTo(String value) {
            addCriterion("LMTPDZ >=", value, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andLmtpdzLessThan(String value) {
            addCriterion("LMTPDZ <", value, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andLmtpdzLessThanOrEqualTo(String value) {
            addCriterion("LMTPDZ <=", value, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andLmtpdzLike(String value) {
            addCriterion("LMTPDZ like", value, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andLmtpdzNotLike(String value) {
            addCriterion("LMTPDZ not like", value, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andLmtpdzIn(List<String> values) {
            addCriterion("LMTPDZ in", values, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andLmtpdzNotIn(List<String> values) {
            addCriterion("LMTPDZ not in", values, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andLmtpdzBetween(String value1, String value2) {
            addCriterion("LMTPDZ between", value1, value2, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andLmtpdzNotBetween(String value1, String value2) {
            addCriterion("LMTPDZ not between", value1, value2, "lmtpdz");
            return (Criteria) this;
        }

        public Criteria andXqdzIsNull() {
            addCriterion("XQDZ is null");
            return (Criteria) this;
        }

        public Criteria andXqdzIsNotNull() {
            addCriterion("XQDZ is not null");
            return (Criteria) this;
        }

        public Criteria andXqdzEqualTo(String value) {
            addCriterion("XQDZ =", value, "xqdz");
            return (Criteria) this;
        }

        public Criteria andXqdzNotEqualTo(String value) {
            addCriterion("XQDZ <>", value, "xqdz");
            return (Criteria) this;
        }

        public Criteria andXqdzGreaterThan(String value) {
            addCriterion("XQDZ >", value, "xqdz");
            return (Criteria) this;
        }

        public Criteria andXqdzGreaterThanOrEqualTo(String value) {
            addCriterion("XQDZ >=", value, "xqdz");
            return (Criteria) this;
        }

        public Criteria andXqdzLessThan(String value) {
            addCriterion("XQDZ <", value, "xqdz");
            return (Criteria) this;
        }

        public Criteria andXqdzLessThanOrEqualTo(String value) {
            addCriterion("XQDZ <=", value, "xqdz");
            return (Criteria) this;
        }

        public Criteria andXqdzLike(String value) {
            addCriterion("XQDZ like", value, "xqdz");
            return (Criteria) this;
        }

        public Criteria andXqdzNotLike(String value) {
            addCriterion("XQDZ not like", value, "xqdz");
            return (Criteria) this;
        }

        public Criteria andXqdzIn(List<String> values) {
            addCriterion("XQDZ in", values, "xqdz");
            return (Criteria) this;
        }

        public Criteria andXqdzNotIn(List<String> values) {
            addCriterion("XQDZ not in", values, "xqdz");
            return (Criteria) this;
        }

        public Criteria andXqdzBetween(String value1, String value2) {
            addCriterion("XQDZ between", value1, value2, "xqdz");
            return (Criteria) this;
        }

        public Criteria andXqdzNotBetween(String value1, String value2) {
            addCriterion("XQDZ not between", value1, value2, "xqdz");
            return (Criteria) this;
        }

        public Criteria andZtIsNull() {
            addCriterion("ZT is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("ZT is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(Integer value) {
            addCriterion("ZT =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(Integer value) {
            addCriterion("ZT <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(Integer value) {
            addCriterion("ZT >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZT >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(Integer value) {
            addCriterion("ZT <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(Integer value) {
            addCriterion("ZT <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<Integer> values) {
            addCriterion("ZT in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<Integer> values) {
            addCriterion("ZT not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(Integer value1, Integer value2) {
            addCriterion("ZT between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(Integer value1, Integer value2) {
            addCriterion("ZT not between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andSxIsNull() {
            addCriterion("SX is null");
            return (Criteria) this;
        }

        public Criteria andSxIsNotNull() {
            addCriterion("SX is not null");
            return (Criteria) this;
        }

        public Criteria andSxEqualTo(Integer value) {
            addCriterion("SX =", value, "sx");
            return (Criteria) this;
        }

        public Criteria andSxNotEqualTo(Integer value) {
            addCriterion("SX <>", value, "sx");
            return (Criteria) this;
        }

        public Criteria andSxGreaterThan(Integer value) {
            addCriterion("SX >", value, "sx");
            return (Criteria) this;
        }

        public Criteria andSxGreaterThanOrEqualTo(Integer value) {
            addCriterion("SX >=", value, "sx");
            return (Criteria) this;
        }

        public Criteria andSxLessThan(Integer value) {
            addCriterion("SX <", value, "sx");
            return (Criteria) this;
        }

        public Criteria andSxLessThanOrEqualTo(Integer value) {
            addCriterion("SX <=", value, "sx");
            return (Criteria) this;
        }

        public Criteria andSxIn(List<Integer> values) {
            addCriterion("SX in", values, "sx");
            return (Criteria) this;
        }

        public Criteria andSxNotIn(List<Integer> values) {
            addCriterion("SX not in", values, "sx");
            return (Criteria) this;
        }

        public Criteria andSxBetween(Integer value1, Integer value2) {
            addCriterion("SX between", value1, value2, "sx");
            return (Criteria) this;
        }

        public Criteria andSxNotBetween(Integer value1, Integer value2) {
            addCriterion("SX not between", value1, value2, "sx");
            return (Criteria) this;
        }

        public Criteria andYl1IsNull() {
            addCriterion("YL1 is null");
            return (Criteria) this;
        }

        public Criteria andYl1IsNotNull() {
            addCriterion("YL1 is not null");
            return (Criteria) this;
        }

        public Criteria andYl1EqualTo(String value) {
            addCriterion("YL1 =", value, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl1NotEqualTo(String value) {
            addCriterion("YL1 <>", value, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl1GreaterThan(String value) {
            addCriterion("YL1 >", value, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl1GreaterThanOrEqualTo(String value) {
            addCriterion("YL1 >=", value, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl1LessThan(String value) {
            addCriterion("YL1 <", value, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl1LessThanOrEqualTo(String value) {
            addCriterion("YL1 <=", value, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl1Like(String value) {
            addCriterion("YL1 like", value, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl1NotLike(String value) {
            addCriterion("YL1 not like", value, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl1In(List<String> values) {
            addCriterion("YL1 in", values, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl1NotIn(List<String> values) {
            addCriterion("YL1 not in", values, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl1Between(String value1, String value2) {
            addCriterion("YL1 between", value1, value2, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl1NotBetween(String value1, String value2) {
            addCriterion("YL1 not between", value1, value2, "yl1");
            return (Criteria) this;
        }

        public Criteria andYl2IsNull() {
            addCriterion("YL2 is null");
            return (Criteria) this;
        }

        public Criteria andYl2IsNotNull() {
            addCriterion("YL2 is not null");
            return (Criteria) this;
        }

        public Criteria andYl2EqualTo(String value) {
            addCriterion("YL2 =", value, "yl2");
            return (Criteria) this;
        }

        public Criteria andYl2NotEqualTo(String value) {
            addCriterion("YL2 <>", value, "yl2");
            return (Criteria) this;
        }

        public Criteria andYl2GreaterThan(String value) {
            addCriterion("YL2 >", value, "yl2");
            return (Criteria) this;
        }

        public Criteria andYl2GreaterThanOrEqualTo(String value) {
            addCriterion("YL2 >=", value, "yl2");
            return (Criteria) this;
        }

        public Criteria andYl2LessThan(String value) {
            addCriterion("YL2 <", value, "yl2");
            return (Criteria) this;
        }

        public Criteria andYl2LessThanOrEqualTo(String value) {
            addCriterion("YL2 <=", value, "yl2");
            return (Criteria) this;
        }

        public Criteria andYl2Like(String value) {
            addCriterion("YL2 like", value, "yl2");
            return (Criteria) this;
        }

        public Criteria andYl2NotLike(String value) {
            addCriterion("YL2 not like", value, "yl2");
            return (Criteria) this;
        }

        public Criteria andYl2In(List<String> values) {
            addCriterion("YL2 in", values, "yl2");
            return (Criteria) this;
        }

        public Criteria andYl2NotIn(List<String> values) {
            addCriterion("YL2 not in", values, "yl2");
            return (Criteria) this;
        }

        public Criteria andYl2Between(String value1, String value2) {
            addCriterion("YL2 between", value1, value2, "yl2");
            return (Criteria) this;
        }

        public Criteria andYl2NotBetween(String value1, String value2) {
            addCriterion("YL2 not between", value1, value2, "yl2");
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