package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzBzjcxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzBzjcxxExample() {
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

        public Criteria andBzjcxxbsIsNull() {
            addCriterion("BZJCXXBS is null");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsIsNotNull() {
            addCriterion("BZJCXXBS is not null");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsEqualTo(String value) {
            addCriterion("BZJCXXBS =", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsNotEqualTo(String value) {
            addCriterion("BZJCXXBS <>", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsGreaterThan(String value) {
            addCriterion("BZJCXXBS >", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsGreaterThanOrEqualTo(String value) {
            addCriterion("BZJCXXBS >=", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsLessThan(String value) {
            addCriterion("BZJCXXBS <", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsLessThanOrEqualTo(String value) {
            addCriterion("BZJCXXBS <=", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsLike(String value) {
            addCriterion("BZJCXXBS like", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsNotLike(String value) {
            addCriterion("BZJCXXBS not like", value, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsIn(List<String> values) {
            addCriterion("BZJCXXBS in", values, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsNotIn(List<String> values) {
            addCriterion("BZJCXXBS not in", values, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsBetween(String value1, String value2) {
            addCriterion("BZJCXXBS between", value1, value2, "bzjcxxbs");
            return (Criteria) this;
        }

        public Criteria andBzjcxxbsNotBetween(String value1, String value2) {
            addCriterion("BZJCXXBS not between", value1, value2, "bzjcxxbs");
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

        public Criteria andLdjtjcIsNull() {
            addCriterion("LDJTJC is null");
            return (Criteria) this;
        }

        public Criteria andLdjtjcIsNotNull() {
            addCriterion("LDJTJC is not null");
            return (Criteria) this;
        }

        public Criteria andLdjtjcEqualTo(String value) {
            addCriterion("LDJTJC =", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcNotEqualTo(String value) {
            addCriterion("LDJTJC <>", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcGreaterThan(String value) {
            addCriterion("LDJTJC >", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcGreaterThanOrEqualTo(String value) {
            addCriterion("LDJTJC >=", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcLessThan(String value) {
            addCriterion("LDJTJC <", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcLessThanOrEqualTo(String value) {
            addCriterion("LDJTJC <=", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcLike(String value) {
            addCriterion("LDJTJC like", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcNotLike(String value) {
            addCriterion("LDJTJC not like", value, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcIn(List<String> values) {
            addCriterion("LDJTJC in", values, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcNotIn(List<String> values) {
            addCriterion("LDJTJC not in", values, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcBetween(String value1, String value2) {
            addCriterion("LDJTJC between", value1, value2, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtjcNotBetween(String value1, String value2) {
            addCriterion("LDJTJC not between", value1, value2, "ldjtjc");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqIsNull() {
            addCriterion("LDJTDXRQ is null");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqIsNotNull() {
            addCriterion("LDJTDXRQ is not null");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqEqualTo(String value) {
            addCriterion("LDJTDXRQ =", value, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqNotEqualTo(String value) {
            addCriterion("LDJTDXRQ <>", value, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqGreaterThan(String value) {
            addCriterion("LDJTDXRQ >", value, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqGreaterThanOrEqualTo(String value) {
            addCriterion("LDJTDXRQ >=", value, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqLessThan(String value) {
            addCriterion("LDJTDXRQ <", value, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqLessThanOrEqualTo(String value) {
            addCriterion("LDJTDXRQ <=", value, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqLike(String value) {
            addCriterion("LDJTDXRQ like", value, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqNotLike(String value) {
            addCriterion("LDJTDXRQ not like", value, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqIn(List<String> values) {
            addCriterion("LDJTDXRQ in", values, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqNotIn(List<String> values) {
            addCriterion("LDJTDXRQ not in", values, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqBetween(String value1, String value2) {
            addCriterion("LDJTDXRQ between", value1, value2, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andLdjtdxrqNotBetween(String value1, String value2) {
            addCriterion("LDJTDXRQ not between", value1, value2, "ldjtdxrq");
            return (Criteria) this;
        }

        public Criteria andXjfsIsNull() {
            addCriterion("XJFS is null");
            return (Criteria) this;
        }

        public Criteria andXjfsIsNotNull() {
            addCriterion("XJFS is not null");
            return (Criteria) this;
        }

        public Criteria andXjfsEqualTo(String value) {
            addCriterion("XJFS =", value, "xjfs");
            return (Criteria) this;
        }

        public Criteria andXjfsNotEqualTo(String value) {
            addCriterion("XJFS <>", value, "xjfs");
            return (Criteria) this;
        }

        public Criteria andXjfsGreaterThan(String value) {
            addCriterion("XJFS >", value, "xjfs");
            return (Criteria) this;
        }

        public Criteria andXjfsGreaterThanOrEqualTo(String value) {
            addCriterion("XJFS >=", value, "xjfs");
            return (Criteria) this;
        }

        public Criteria andXjfsLessThan(String value) {
            addCriterion("XJFS <", value, "xjfs");
            return (Criteria) this;
        }

        public Criteria andXjfsLessThanOrEqualTo(String value) {
            addCriterion("XJFS <=", value, "xjfs");
            return (Criteria) this;
        }

        public Criteria andXjfsLike(String value) {
            addCriterion("XJFS like", value, "xjfs");
            return (Criteria) this;
        }

        public Criteria andXjfsNotLike(String value) {
            addCriterion("XJFS not like", value, "xjfs");
            return (Criteria) this;
        }

        public Criteria andXjfsIn(List<String> values) {
            addCriterion("XJFS in", values, "xjfs");
            return (Criteria) this;
        }

        public Criteria andXjfsNotIn(List<String> values) {
            addCriterion("XJFS not in", values, "xjfs");
            return (Criteria) this;
        }

        public Criteria andXjfsBetween(String value1, String value2) {
            addCriterion("XJFS between", value1, value2, "xjfs");
            return (Criteria) this;
        }

        public Criteria andXjfsNotBetween(String value1, String value2) {
            addCriterion("XJFS not between", value1, value2, "xjfs");
            return (Criteria) this;
        }

        public Criteria andGjjmrqIsNull() {
            addCriterion("GJJMRQ is null");
            return (Criteria) this;
        }

        public Criteria andGjjmrqIsNotNull() {
            addCriterion("GJJMRQ is not null");
            return (Criteria) this;
        }

        public Criteria andGjjmrqEqualTo(String value) {
            addCriterion("GJJMRQ =", value, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andGjjmrqNotEqualTo(String value) {
            addCriterion("GJJMRQ <>", value, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andGjjmrqGreaterThan(String value) {
            addCriterion("GJJMRQ >", value, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andGjjmrqGreaterThanOrEqualTo(String value) {
            addCriterion("GJJMRQ >=", value, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andGjjmrqLessThan(String value) {
            addCriterion("GJJMRQ <", value, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andGjjmrqLessThanOrEqualTo(String value) {
            addCriterion("GJJMRQ <=", value, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andGjjmrqLike(String value) {
            addCriterion("GJJMRQ like", value, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andGjjmrqNotLike(String value) {
            addCriterion("GJJMRQ not like", value, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andGjjmrqIn(List<String> values) {
            addCriterion("GJJMRQ in", values, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andGjjmrqNotIn(List<String> values) {
            addCriterion("GJJMRQ not in", values, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andGjjmrqBetween(String value1, String value2) {
            addCriterion("GJJMRQ between", value1, value2, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andGjjmrqNotBetween(String value1, String value2) {
            addCriterion("GJJMRQ not between", value1, value2, "gjjmrq");
            return (Criteria) this;
        }

        public Criteria andYdhrsIsNull() {
            addCriterion("YDHRS is null");
            return (Criteria) this;
        }

        public Criteria andYdhrsIsNotNull() {
            addCriterion("YDHRS is not null");
            return (Criteria) this;
        }

        public Criteria andYdhrsEqualTo(String value) {
            addCriterion("YDHRS =", value, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andYdhrsNotEqualTo(String value) {
            addCriterion("YDHRS <>", value, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andYdhrsGreaterThan(String value) {
            addCriterion("YDHRS >", value, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andYdhrsGreaterThanOrEqualTo(String value) {
            addCriterion("YDHRS >=", value, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andYdhrsLessThan(String value) {
            addCriterion("YDHRS <", value, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andYdhrsLessThanOrEqualTo(String value) {
            addCriterion("YDHRS <=", value, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andYdhrsLike(String value) {
            addCriterion("YDHRS like", value, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andYdhrsNotLike(String value) {
            addCriterion("YDHRS not like", value, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andYdhrsIn(List<String> values) {
            addCriterion("YDHRS in", values, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andYdhrsNotIn(List<String> values) {
            addCriterion("YDHRS not in", values, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andYdhrsBetween(String value1, String value2) {
            addCriterion("YDHRS between", value1, value2, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andYdhrsNotBetween(String value1, String value2) {
            addCriterion("YDHRS not between", value1, value2, "ydhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsIsNull() {
            addCriterion("SDHRS is null");
            return (Criteria) this;
        }

        public Criteria andSdhrsIsNotNull() {
            addCriterion("SDHRS is not null");
            return (Criteria) this;
        }

        public Criteria andSdhrsEqualTo(String value) {
            addCriterion("SDHRS =", value, "sdhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsNotEqualTo(String value) {
            addCriterion("SDHRS <>", value, "sdhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsGreaterThan(String value) {
            addCriterion("SDHRS >", value, "sdhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsGreaterThanOrEqualTo(String value) {
            addCriterion("SDHRS >=", value, "sdhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsLessThan(String value) {
            addCriterion("SDHRS <", value, "sdhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsLessThanOrEqualTo(String value) {
            addCriterion("SDHRS <=", value, "sdhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsLike(String value) {
            addCriterion("SDHRS like", value, "sdhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsNotLike(String value) {
            addCriterion("SDHRS not like", value, "sdhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsIn(List<String> values) {
            addCriterion("SDHRS in", values, "sdhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsNotIn(List<String> values) {
            addCriterion("SDHRS not in", values, "sdhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsBetween(String value1, String value2) {
            addCriterion("SDHRS between", value1, value2, "sdhrs");
            return (Criteria) this;
        }

        public Criteria andSdhrsNotBetween(String value1, String value2) {
            addCriterion("SDHRS not between", value1, value2, "sdhrs");
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

        public Criteria andQwrsIsNull() {
            addCriterion("QWRS is null");
            return (Criteria) this;
        }

        public Criteria andQwrsIsNotNull() {
            addCriterion("QWRS is not null");
            return (Criteria) this;
        }

        public Criteria andQwrsEqualTo(String value) {
            addCriterion("QWRS =", value, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwrsNotEqualTo(String value) {
            addCriterion("QWRS <>", value, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwrsGreaterThan(String value) {
            addCriterion("QWRS >", value, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwrsGreaterThanOrEqualTo(String value) {
            addCriterion("QWRS >=", value, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwrsLessThan(String value) {
            addCriterion("QWRS <", value, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwrsLessThanOrEqualTo(String value) {
            addCriterion("QWRS <=", value, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwrsLike(String value) {
            addCriterion("QWRS like", value, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwrsNotLike(String value) {
            addCriterion("QWRS not like", value, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwrsIn(List<String> values) {
            addCriterion("QWRS in", values, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwrsNotIn(List<String> values) {
            addCriterion("QWRS not in", values, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwrsBetween(String value1, String value2) {
            addCriterion("QWRS between", value1, value2, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwrsNotBetween(String value1, String value2) {
            addCriterion("QWRS not between", value1, value2, "qwrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsIsNull() {
            addCriterion("QWSDRS is null");
            return (Criteria) this;
        }

        public Criteria andQwsdrsIsNotNull() {
            addCriterion("QWSDRS is not null");
            return (Criteria) this;
        }

        public Criteria andQwsdrsEqualTo(String value) {
            addCriterion("QWSDRS =", value, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsNotEqualTo(String value) {
            addCriterion("QWSDRS <>", value, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsGreaterThan(String value) {
            addCriterion("QWSDRS >", value, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsGreaterThanOrEqualTo(String value) {
            addCriterion("QWSDRS >=", value, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsLessThan(String value) {
            addCriterion("QWSDRS <", value, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsLessThanOrEqualTo(String value) {
            addCriterion("QWSDRS <=", value, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsLike(String value) {
            addCriterion("QWSDRS like", value, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsNotLike(String value) {
            addCriterion("QWSDRS not like", value, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsIn(List<String> values) {
            addCriterion("QWSDRS in", values, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsNotIn(List<String> values) {
            addCriterion("QWSDRS not in", values, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsBetween(String value1, String value2) {
            addCriterion("QWSDRS between", value1, value2, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andQwsdrsNotBetween(String value1, String value2) {
            addCriterion("QWSDRS not between", value1, value2, "qwsdrs");
            return (Criteria) this;
        }

        public Criteria andPzwymeIsNull() {
            addCriterion("PZWYME is null");
            return (Criteria) this;
        }

        public Criteria andPzwymeIsNotNull() {
            addCriterion("PZWYME is not null");
            return (Criteria) this;
        }

        public Criteria andPzwymeEqualTo(String value) {
            addCriterion("PZWYME =", value, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzwymeNotEqualTo(String value) {
            addCriterion("PZWYME <>", value, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzwymeGreaterThan(String value) {
            addCriterion("PZWYME >", value, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzwymeGreaterThanOrEqualTo(String value) {
            addCriterion("PZWYME >=", value, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzwymeLessThan(String value) {
            addCriterion("PZWYME <", value, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzwymeLessThanOrEqualTo(String value) {
            addCriterion("PZWYME <=", value, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzwymeLike(String value) {
            addCriterion("PZWYME like", value, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzwymeNotLike(String value) {
            addCriterion("PZWYME not like", value, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzwymeIn(List<String> values) {
            addCriterion("PZWYME in", values, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzwymeNotIn(List<String> values) {
            addCriterion("PZWYME not in", values, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzwymeBetween(String value1, String value2) {
            addCriterion("PZWYME between", value1, value2, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzwymeNotBetween(String value1, String value2) {
            addCriterion("PZWYME not between", value1, value2, "pzwyme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeIsNull() {
            addCriterion("PZCWME is null");
            return (Criteria) this;
        }

        public Criteria andPzcwmeIsNotNull() {
            addCriterion("PZCWME is not null");
            return (Criteria) this;
        }

        public Criteria andPzcwmeEqualTo(String value) {
            addCriterion("PZCWME =", value, "pzcwme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeNotEqualTo(String value) {
            addCriterion("PZCWME <>", value, "pzcwme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeGreaterThan(String value) {
            addCriterion("PZCWME >", value, "pzcwme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeGreaterThanOrEqualTo(String value) {
            addCriterion("PZCWME >=", value, "pzcwme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeLessThan(String value) {
            addCriterion("PZCWME <", value, "pzcwme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeLessThanOrEqualTo(String value) {
            addCriterion("PZCWME <=", value, "pzcwme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeLike(String value) {
            addCriterion("PZCWME like", value, "pzcwme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeNotLike(String value) {
            addCriterion("PZCWME not like", value, "pzcwme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeIn(List<String> values) {
            addCriterion("PZCWME in", values, "pzcwme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeNotIn(List<String> values) {
            addCriterion("PZCWME not in", values, "pzcwme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeBetween(String value1, String value2) {
            addCriterion("PZCWME between", value1, value2, "pzcwme");
            return (Criteria) this;
        }

        public Criteria andPzcwmeNotBetween(String value1, String value2) {
            addCriterion("PZCWME not between", value1, value2, "pzcwme");
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