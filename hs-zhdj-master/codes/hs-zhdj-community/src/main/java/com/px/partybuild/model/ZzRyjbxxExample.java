package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzRyjbxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzRyjbxxExample() {
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

        public Criteria andRyjbxxbsIsNull() {
            addCriterion("RYJBXXBS is null");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsIsNotNull() {
            addCriterion("RYJBXXBS is not null");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsEqualTo(String value) {
            addCriterion("RYJBXXBS =", value, "ryjbxxbs");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsNotEqualTo(String value) {
            addCriterion("RYJBXXBS <>", value, "ryjbxxbs");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsGreaterThan(String value) {
            addCriterion("RYJBXXBS >", value, "ryjbxxbs");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsGreaterThanOrEqualTo(String value) {
            addCriterion("RYJBXXBS >=", value, "ryjbxxbs");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsLessThan(String value) {
            addCriterion("RYJBXXBS <", value, "ryjbxxbs");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsLessThanOrEqualTo(String value) {
            addCriterion("RYJBXXBS <=", value, "ryjbxxbs");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsLike(String value) {
            addCriterion("RYJBXXBS like", value, "ryjbxxbs");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsNotLike(String value) {
            addCriterion("RYJBXXBS not like", value, "ryjbxxbs");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsIn(List<String> values) {
            addCriterion("RYJBXXBS in", values, "ryjbxxbs");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsNotIn(List<String> values) {
            addCriterion("RYJBXXBS not in", values, "ryjbxxbs");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsBetween(String value1, String value2) {
            addCriterion("RYJBXXBS between", value1, value2, "ryjbxxbs");
            return (Criteria) this;
        }

        public Criteria andRyjbxxbsNotBetween(String value1, String value2) {
            addCriterion("RYJBXXBS not between", value1, value2, "ryjbxxbs");
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

        public Criteria andRyztIsNull() {
            addCriterion("RYZT is null");
            return (Criteria) this;
        }

        public Criteria andRyztIsNotNull() {
            addCriterion("RYZT is not null");
            return (Criteria) this;
        }

        public Criteria andRyztEqualTo(String value) {
            addCriterion("RYZT =", value, "ryzt");
            return (Criteria) this;
        }

        public Criteria andRyztNotEqualTo(String value) {
            addCriterion("RYZT <>", value, "ryzt");
            return (Criteria) this;
        }

        public Criteria andRyztGreaterThan(String value) {
            addCriterion("RYZT >", value, "ryzt");
            return (Criteria) this;
        }

        public Criteria andRyztGreaterThanOrEqualTo(String value) {
            addCriterion("RYZT >=", value, "ryzt");
            return (Criteria) this;
        }

        public Criteria andRyztLessThan(String value) {
            addCriterion("RYZT <", value, "ryzt");
            return (Criteria) this;
        }

        public Criteria andRyztLessThanOrEqualTo(String value) {
            addCriterion("RYZT <=", value, "ryzt");
            return (Criteria) this;
        }

        public Criteria andRyztLike(String value) {
            addCriterion("RYZT like", value, "ryzt");
            return (Criteria) this;
        }

        public Criteria andRyztNotLike(String value) {
            addCriterion("RYZT not like", value, "ryzt");
            return (Criteria) this;
        }

        public Criteria andRyztIn(List<String> values) {
            addCriterion("RYZT in", values, "ryzt");
            return (Criteria) this;
        }

        public Criteria andRyztNotIn(List<String> values) {
            addCriterion("RYZT not in", values, "ryzt");
            return (Criteria) this;
        }

        public Criteria andRyztBetween(String value1, String value2) {
            addCriterion("RYZT between", value1, value2, "ryzt");
            return (Criteria) this;
        }

        public Criteria andRyztNotBetween(String value1, String value2) {
            addCriterion("RYZT not between", value1, value2, "ryzt");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmIsNull() {
            addCriterion("SZDZBDM is null");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmIsNotNull() {
            addCriterion("SZDZBDM is not null");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmEqualTo(String value) {
            addCriterion("SZDZBDM =", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmNotEqualTo(String value) {
            addCriterion("SZDZBDM <>", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmGreaterThan(String value) {
            addCriterion("SZDZBDM >", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmGreaterThanOrEqualTo(String value) {
            addCriterion("SZDZBDM >=", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmLessThan(String value) {
            addCriterion("SZDZBDM <", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmLessThanOrEqualTo(String value) {
            addCriterion("SZDZBDM <=", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmLike(String value) {
            addCriterion("SZDZBDM like", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmNotLike(String value) {
            addCriterion("SZDZBDM not like", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmIn(List<String> values) {
            addCriterion("SZDZBDM in", values, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmNotIn(List<String> values) {
            addCriterion("SZDZBDM not in", values, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmBetween(String value1, String value2) {
            addCriterion("SZDZBDM between", value1, value2, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmNotBetween(String value1, String value2) {
            addCriterion("SZDZBDM not between", value1, value2, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andCgcjlbIsNull() {
            addCriterion("CGCJLB is null");
            return (Criteria) this;
        }

        public Criteria andCgcjlbIsNotNull() {
            addCriterion("CGCJLB is not null");
            return (Criteria) this;
        }

        public Criteria andCgcjlbEqualTo(String value) {
            addCriterion("CGCJLB =", value, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjlbNotEqualTo(String value) {
            addCriterion("CGCJLB <>", value, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjlbGreaterThan(String value) {
            addCriterion("CGCJLB >", value, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjlbGreaterThanOrEqualTo(String value) {
            addCriterion("CGCJLB >=", value, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjlbLessThan(String value) {
            addCriterion("CGCJLB <", value, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjlbLessThanOrEqualTo(String value) {
            addCriterion("CGCJLB <=", value, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjlbLike(String value) {
            addCriterion("CGCJLB like", value, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjlbNotLike(String value) {
            addCriterion("CGCJLB not like", value, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjlbIn(List<String> values) {
            addCriterion("CGCJLB in", values, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjlbNotIn(List<String> values) {
            addCriterion("CGCJLB not in", values, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjlbBetween(String value1, String value2) {
            addCriterion("CGCJLB between", value1, value2, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjlbNotBetween(String value1, String value2) {
            addCriterion("CGCJLB not between", value1, value2, "cgcjlb");
            return (Criteria) this;
        }

        public Criteria andCgcjyyIsNull() {
            addCriterion("CGCJYY is null");
            return (Criteria) this;
        }

        public Criteria andCgcjyyIsNotNull() {
            addCriterion("CGCJYY is not null");
            return (Criteria) this;
        }

        public Criteria andCgcjyyEqualTo(String value) {
            addCriterion("CGCJYY =", value, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjyyNotEqualTo(String value) {
            addCriterion("CGCJYY <>", value, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjyyGreaterThan(String value) {
            addCriterion("CGCJYY >", value, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjyyGreaterThanOrEqualTo(String value) {
            addCriterion("CGCJYY >=", value, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjyyLessThan(String value) {
            addCriterion("CGCJYY <", value, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjyyLessThanOrEqualTo(String value) {
            addCriterion("CGCJYY <=", value, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjyyLike(String value) {
            addCriterion("CGCJYY like", value, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjyyNotLike(String value) {
            addCriterion("CGCJYY not like", value, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjyyIn(List<String> values) {
            addCriterion("CGCJYY in", values, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjyyNotIn(List<String> values) {
            addCriterion("CGCJYY not in", values, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjyyBetween(String value1, String value2) {
            addCriterion("CGCJYY between", value1, value2, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjyyNotBetween(String value1, String value2) {
            addCriterion("CGCJYY not between", value1, value2, "cgcjyy");
            return (Criteria) this;
        }

        public Criteria andCgcjrqIsNull() {
            addCriterion("CGCJRQ is null");
            return (Criteria) this;
        }

        public Criteria andCgcjrqIsNotNull() {
            addCriterion("CGCJRQ is not null");
            return (Criteria) this;
        }

        public Criteria andCgcjrqEqualTo(String value) {
            addCriterion("CGCJRQ =", value, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andCgcjrqNotEqualTo(String value) {
            addCriterion("CGCJRQ <>", value, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andCgcjrqGreaterThan(String value) {
            addCriterion("CGCJRQ >", value, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andCgcjrqGreaterThanOrEqualTo(String value) {
            addCriterion("CGCJRQ >=", value, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andCgcjrqLessThan(String value) {
            addCriterion("CGCJRQ <", value, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andCgcjrqLessThanOrEqualTo(String value) {
            addCriterion("CGCJRQ <=", value, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andCgcjrqLike(String value) {
            addCriterion("CGCJRQ like", value, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andCgcjrqNotLike(String value) {
            addCriterion("CGCJRQ not like", value, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andCgcjrqIn(List<String> values) {
            addCriterion("CGCJRQ in", values, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andCgcjrqNotIn(List<String> values) {
            addCriterion("CGCJRQ not in", values, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andCgcjrqBetween(String value1, String value2) {
            addCriterion("CGCJRQ between", value1, value2, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andCgcjrqNotBetween(String value1, String value2) {
            addCriterion("CGCJRQ not between", value1, value2, "cgcjrq");
            return (Criteria) this;
        }

        public Criteria andGzgwIsNull() {
            addCriterion("GZGW is null");
            return (Criteria) this;
        }

        public Criteria andGzgwIsNotNull() {
            addCriterion("GZGW is not null");
            return (Criteria) this;
        }

        public Criteria andGzgwEqualTo(String value) {
            addCriterion("GZGW =", value, "gzgw");
            return (Criteria) this;
        }

        public Criteria andGzgwNotEqualTo(String value) {
            addCriterion("GZGW <>", value, "gzgw");
            return (Criteria) this;
        }

        public Criteria andGzgwGreaterThan(String value) {
            addCriterion("GZGW >", value, "gzgw");
            return (Criteria) this;
        }

        public Criteria andGzgwGreaterThanOrEqualTo(String value) {
            addCriterion("GZGW >=", value, "gzgw");
            return (Criteria) this;
        }

        public Criteria andGzgwLessThan(String value) {
            addCriterion("GZGW <", value, "gzgw");
            return (Criteria) this;
        }

        public Criteria andGzgwLessThanOrEqualTo(String value) {
            addCriterion("GZGW <=", value, "gzgw");
            return (Criteria) this;
        }

        public Criteria andGzgwLike(String value) {
            addCriterion("GZGW like", value, "gzgw");
            return (Criteria) this;
        }

        public Criteria andGzgwNotLike(String value) {
            addCriterion("GZGW not like", value, "gzgw");
            return (Criteria) this;
        }

        public Criteria andGzgwIn(List<String> values) {
            addCriterion("GZGW in", values, "gzgw");
            return (Criteria) this;
        }

        public Criteria andGzgwNotIn(List<String> values) {
            addCriterion("GZGW not in", values, "gzgw");
            return (Criteria) this;
        }

        public Criteria andGzgwBetween(String value1, String value2) {
            addCriterion("GZGW between", value1, value2, "gzgw");
            return (Criteria) this;
        }

        public Criteria andGzgwNotBetween(String value1, String value2) {
            addCriterion("GZGW not between", value1, value2, "gzgw");
            return (Criteria) this;
        }

        public Criteria andPxqkIsNull() {
            addCriterion("PXQK is null");
            return (Criteria) this;
        }

        public Criteria andPxqkIsNotNull() {
            addCriterion("PXQK is not null");
            return (Criteria) this;
        }

        public Criteria andPxqkEqualTo(String value) {
            addCriterion("PXQK =", value, "pxqk");
            return (Criteria) this;
        }

        public Criteria andPxqkNotEqualTo(String value) {
            addCriterion("PXQK <>", value, "pxqk");
            return (Criteria) this;
        }

        public Criteria andPxqkGreaterThan(String value) {
            addCriterion("PXQK >", value, "pxqk");
            return (Criteria) this;
        }

        public Criteria andPxqkGreaterThanOrEqualTo(String value) {
            addCriterion("PXQK >=", value, "pxqk");
            return (Criteria) this;
        }

        public Criteria andPxqkLessThan(String value) {
            addCriterion("PXQK <", value, "pxqk");
            return (Criteria) this;
        }

        public Criteria andPxqkLessThanOrEqualTo(String value) {
            addCriterion("PXQK <=", value, "pxqk");
            return (Criteria) this;
        }

        public Criteria andPxqkLike(String value) {
            addCriterion("PXQK like", value, "pxqk");
            return (Criteria) this;
        }

        public Criteria andPxqkNotLike(String value) {
            addCriterion("PXQK not like", value, "pxqk");
            return (Criteria) this;
        }

        public Criteria andPxqkIn(List<String> values) {
            addCriterion("PXQK in", values, "pxqk");
            return (Criteria) this;
        }

        public Criteria andPxqkNotIn(List<String> values) {
            addCriterion("PXQK not in", values, "pxqk");
            return (Criteria) this;
        }

        public Criteria andPxqkBetween(String value1, String value2) {
            addCriterion("PXQK between", value1, value2, "pxqk");
            return (Criteria) this;
        }

        public Criteria andPxqkNotBetween(String value1, String value2) {
            addCriterion("PXQK not between", value1, value2, "pxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkIsNull() {
            addCriterion("YXQK is null");
            return (Criteria) this;
        }

        public Criteria andYxqkIsNotNull() {
            addCriterion("YXQK is not null");
            return (Criteria) this;
        }

        public Criteria andYxqkEqualTo(String value) {
            addCriterion("YXQK =", value, "yxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkNotEqualTo(String value) {
            addCriterion("YXQK <>", value, "yxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkGreaterThan(String value) {
            addCriterion("YXQK >", value, "yxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkGreaterThanOrEqualTo(String value) {
            addCriterion("YXQK >=", value, "yxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkLessThan(String value) {
            addCriterion("YXQK <", value, "yxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkLessThanOrEqualTo(String value) {
            addCriterion("YXQK <=", value, "yxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkLike(String value) {
            addCriterion("YXQK like", value, "yxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkNotLike(String value) {
            addCriterion("YXQK not like", value, "yxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkIn(List<String> values) {
            addCriterion("YXQK in", values, "yxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkNotIn(List<String> values) {
            addCriterion("YXQK not in", values, "yxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkBetween(String value1, String value2) {
            addCriterion("YXQK between", value1, value2, "yxqk");
            return (Criteria) this;
        }

        public Criteria andYxqkNotBetween(String value1, String value2) {
            addCriterion("YXQK not between", value1, value2, "yxqk");
            return (Criteria) this;
        }

        public Criteria andBz1IsNull() {
            addCriterion("BZ1 is null");
            return (Criteria) this;
        }

        public Criteria andBz1IsNotNull() {
            addCriterion("BZ1 is not null");
            return (Criteria) this;
        }

        public Criteria andBz1EqualTo(String value) {
            addCriterion("BZ1 =", value, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz1NotEqualTo(String value) {
            addCriterion("BZ1 <>", value, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz1GreaterThan(String value) {
            addCriterion("BZ1 >", value, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz1GreaterThanOrEqualTo(String value) {
            addCriterion("BZ1 >=", value, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz1LessThan(String value) {
            addCriterion("BZ1 <", value, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz1LessThanOrEqualTo(String value) {
            addCriterion("BZ1 <=", value, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz1Like(String value) {
            addCriterion("BZ1 like", value, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz1NotLike(String value) {
            addCriterion("BZ1 not like", value, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz1In(List<String> values) {
            addCriterion("BZ1 in", values, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz1NotIn(List<String> values) {
            addCriterion("BZ1 not in", values, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz1Between(String value1, String value2) {
            addCriterion("BZ1 between", value1, value2, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz1NotBetween(String value1, String value2) {
            addCriterion("BZ1 not between", value1, value2, "bz1");
            return (Criteria) this;
        }

        public Criteria andBz2IsNull() {
            addCriterion("BZ2 is null");
            return (Criteria) this;
        }

        public Criteria andBz2IsNotNull() {
            addCriterion("BZ2 is not null");
            return (Criteria) this;
        }

        public Criteria andBz2EqualTo(String value) {
            addCriterion("BZ2 =", value, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz2NotEqualTo(String value) {
            addCriterion("BZ2 <>", value, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz2GreaterThan(String value) {
            addCriterion("BZ2 >", value, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz2GreaterThanOrEqualTo(String value) {
            addCriterion("BZ2 >=", value, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz2LessThan(String value) {
            addCriterion("BZ2 <", value, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz2LessThanOrEqualTo(String value) {
            addCriterion("BZ2 <=", value, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz2Like(String value) {
            addCriterion("BZ2 like", value, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz2NotLike(String value) {
            addCriterion("BZ2 not like", value, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz2In(List<String> values) {
            addCriterion("BZ2 in", values, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz2NotIn(List<String> values) {
            addCriterion("BZ2 not in", values, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz2Between(String value1, String value2) {
            addCriterion("BZ2 between", value1, value2, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz2NotBetween(String value1, String value2) {
            addCriterion("BZ2 not between", value1, value2, "bz2");
            return (Criteria) this;
        }

        public Criteria andBz3IsNull() {
            addCriterion("BZ3 is null");
            return (Criteria) this;
        }

        public Criteria andBz3IsNotNull() {
            addCriterion("BZ3 is not null");
            return (Criteria) this;
        }

        public Criteria andBz3EqualTo(String value) {
            addCriterion("BZ3 =", value, "bz3");
            return (Criteria) this;
        }

        public Criteria andBz3NotEqualTo(String value) {
            addCriterion("BZ3 <>", value, "bz3");
            return (Criteria) this;
        }

        public Criteria andBz3GreaterThan(String value) {
            addCriterion("BZ3 >", value, "bz3");
            return (Criteria) this;
        }

        public Criteria andBz3GreaterThanOrEqualTo(String value) {
            addCriterion("BZ3 >=", value, "bz3");
            return (Criteria) this;
        }

        public Criteria andBz3LessThan(String value) {
            addCriterion("BZ3 <", value, "bz3");
            return (Criteria) this;
        }

        public Criteria andBz3LessThanOrEqualTo(String value) {
            addCriterion("BZ3 <=", value, "bz3");
            return (Criteria) this;
        }

        public Criteria andBz3Like(String value) {
            addCriterion("BZ3 like", value, "bz3");
            return (Criteria) this;
        }

        public Criteria andBz3NotLike(String value) {
            addCriterion("BZ3 not like", value, "bz3");
            return (Criteria) this;
        }

        public Criteria andBz3In(List<String> values) {
            addCriterion("BZ3 in", values, "bz3");
            return (Criteria) this;
        }

        public Criteria andBz3NotIn(List<String> values) {
            addCriterion("BZ3 not in", values, "bz3");
            return (Criteria) this;
        }

        public Criteria andBz3Between(String value1, String value2) {
            addCriterion("BZ3 between", value1, value2, "bz3");
            return (Criteria) this;
        }

        public Criteria andBz3NotBetween(String value1, String value2) {
            addCriterion("BZ3 not between", value1, value2, "bz3");
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

        public Criteria andYl04IsNull() {
            addCriterion("YL04 is null");
            return (Criteria) this;
        }

        public Criteria andYl04IsNotNull() {
            addCriterion("YL04 is not null");
            return (Criteria) this;
        }

        public Criteria andYl04EqualTo(String value) {
            addCriterion("YL04 =", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotEqualTo(String value) {
            addCriterion("YL04 <>", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04GreaterThan(String value) {
            addCriterion("YL04 >", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04GreaterThanOrEqualTo(String value) {
            addCriterion("YL04 >=", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04LessThan(String value) {
            addCriterion("YL04 <", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04LessThanOrEqualTo(String value) {
            addCriterion("YL04 <=", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04Like(String value) {
            addCriterion("YL04 like", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotLike(String value) {
            addCriterion("YL04 not like", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04In(List<String> values) {
            addCriterion("YL04 in", values, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotIn(List<String> values) {
            addCriterion("YL04 not in", values, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04Between(String value1, String value2) {
            addCriterion("YL04 between", value1, value2, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotBetween(String value1, String value2) {
            addCriterion("YL04 not between", value1, value2, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl05IsNull() {
            addCriterion("YL05 is null");
            return (Criteria) this;
        }

        public Criteria andYl05IsNotNull() {
            addCriterion("YL05 is not null");
            return (Criteria) this;
        }

        public Criteria andYl05EqualTo(String value) {
            addCriterion("YL05 =", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05NotEqualTo(String value) {
            addCriterion("YL05 <>", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05GreaterThan(String value) {
            addCriterion("YL05 >", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05GreaterThanOrEqualTo(String value) {
            addCriterion("YL05 >=", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05LessThan(String value) {
            addCriterion("YL05 <", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05LessThanOrEqualTo(String value) {
            addCriterion("YL05 <=", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05Like(String value) {
            addCriterion("YL05 like", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05NotLike(String value) {
            addCriterion("YL05 not like", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05In(List<String> values) {
            addCriterion("YL05 in", values, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05NotIn(List<String> values) {
            addCriterion("YL05 not in", values, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05Between(String value1, String value2) {
            addCriterion("YL05 between", value1, value2, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05NotBetween(String value1, String value2) {
            addCriterion("YL05 not between", value1, value2, "yl05");
            return (Criteria) this;
        }

        public Criteria andSqrdrqIsNull() {
            addCriterion("SQRDRQ is null");
            return (Criteria) this;
        }

        public Criteria andSqrdrqIsNotNull() {
            addCriterion("SQRDRQ is not null");
            return (Criteria) this;
        }

        public Criteria andSqrdrqEqualTo(String value) {
            addCriterion("SQRDRQ =", value, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andSqrdrqNotEqualTo(String value) {
            addCriterion("SQRDRQ <>", value, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andSqrdrqGreaterThan(String value) {
            addCriterion("SQRDRQ >", value, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andSqrdrqGreaterThanOrEqualTo(String value) {
            addCriterion("SQRDRQ >=", value, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andSqrdrqLessThan(String value) {
            addCriterion("SQRDRQ <", value, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andSqrdrqLessThanOrEqualTo(String value) {
            addCriterion("SQRDRQ <=", value, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andSqrdrqLike(String value) {
            addCriterion("SQRDRQ like", value, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andSqrdrqNotLike(String value) {
            addCriterion("SQRDRQ not like", value, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andSqrdrqIn(List<String> values) {
            addCriterion("SQRDRQ in", values, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andSqrdrqNotIn(List<String> values) {
            addCriterion("SQRDRQ not in", values, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andSqrdrqBetween(String value1, String value2) {
            addCriterion("SQRDRQ between", value1, value2, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andSqrdrqNotBetween(String value1, String value2) {
            addCriterion("SQRDRQ not between", value1, value2, "sqrdrq");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzIsNull() {
            addCriterion("ZZPYPXBZ is null");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzIsNotNull() {
            addCriterion("ZZPYPXBZ is not null");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzEqualTo(String value) {
            addCriterion("ZZPYPXBZ =", value, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzNotEqualTo(String value) {
            addCriterion("ZZPYPXBZ <>", value, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzGreaterThan(String value) {
            addCriterion("ZZPYPXBZ >", value, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzGreaterThanOrEqualTo(String value) {
            addCriterion("ZZPYPXBZ >=", value, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzLessThan(String value) {
            addCriterion("ZZPYPXBZ <", value, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzLessThanOrEqualTo(String value) {
            addCriterion("ZZPYPXBZ <=", value, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzLike(String value) {
            addCriterion("ZZPYPXBZ like", value, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzNotLike(String value) {
            addCriterion("ZZPYPXBZ not like", value, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzIn(List<String> values) {
            addCriterion("ZZPYPXBZ in", values, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzNotIn(List<String> values) {
            addCriterion("ZZPYPXBZ not in", values, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzBetween(String value1, String value2) {
            addCriterion("ZZPYPXBZ between", value1, value2, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andZzpypxbzNotBetween(String value1, String value2) {
            addCriterion("ZZPYPXBZ not between", value1, value2, "zzpypxbz");
            return (Criteria) this;
        }

        public Criteria andPyrIsNull() {
            addCriterion("PYR is null");
            return (Criteria) this;
        }

        public Criteria andPyrIsNotNull() {
            addCriterion("PYR is not null");
            return (Criteria) this;
        }

        public Criteria andPyrEqualTo(String value) {
            addCriterion("PYR =", value, "pyr");
            return (Criteria) this;
        }

        public Criteria andPyrNotEqualTo(String value) {
            addCriterion("PYR <>", value, "pyr");
            return (Criteria) this;
        }

        public Criteria andPyrGreaterThan(String value) {
            addCriterion("PYR >", value, "pyr");
            return (Criteria) this;
        }

        public Criteria andPyrGreaterThanOrEqualTo(String value) {
            addCriterion("PYR >=", value, "pyr");
            return (Criteria) this;
        }

        public Criteria andPyrLessThan(String value) {
            addCriterion("PYR <", value, "pyr");
            return (Criteria) this;
        }

        public Criteria andPyrLessThanOrEqualTo(String value) {
            addCriterion("PYR <=", value, "pyr");
            return (Criteria) this;
        }

        public Criteria andPyrLike(String value) {
            addCriterion("PYR like", value, "pyr");
            return (Criteria) this;
        }

        public Criteria andPyrNotLike(String value) {
            addCriterion("PYR not like", value, "pyr");
            return (Criteria) this;
        }

        public Criteria andPyrIn(List<String> values) {
            addCriterion("PYR in", values, "pyr");
            return (Criteria) this;
        }

        public Criteria andPyrNotIn(List<String> values) {
            addCriterion("PYR not in", values, "pyr");
            return (Criteria) this;
        }

        public Criteria andPyrBetween(String value1, String value2) {
            addCriterion("PYR between", value1, value2, "pyr");
            return (Criteria) this;
        }

        public Criteria andPyrNotBetween(String value1, String value2) {
            addCriterion("PYR not between", value1, value2, "pyr");
            return (Criteria) this;
        }

        public Criteria andZjpxrqIsNull() {
            addCriterion("ZJPXRQ is null");
            return (Criteria) this;
        }

        public Criteria andZjpxrqIsNotNull() {
            addCriterion("ZJPXRQ is not null");
            return (Criteria) this;
        }

        public Criteria andZjpxrqEqualTo(String value) {
            addCriterion("ZJPXRQ =", value, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxrqNotEqualTo(String value) {
            addCriterion("ZJPXRQ <>", value, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxrqGreaterThan(String value) {
            addCriterion("ZJPXRQ >", value, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxrqGreaterThanOrEqualTo(String value) {
            addCriterion("ZJPXRQ >=", value, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxrqLessThan(String value) {
            addCriterion("ZJPXRQ <", value, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxrqLessThanOrEqualTo(String value) {
            addCriterion("ZJPXRQ <=", value, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxrqLike(String value) {
            addCriterion("ZJPXRQ like", value, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxrqNotLike(String value) {
            addCriterion("ZJPXRQ not like", value, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxrqIn(List<String> values) {
            addCriterion("ZJPXRQ in", values, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxrqNotIn(List<String> values) {
            addCriterion("ZJPXRQ not in", values, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxrqBetween(String value1, String value2) {
            addCriterion("ZJPXRQ between", value1, value2, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxrqNotBetween(String value1, String value2) {
            addCriterion("ZJPXRQ not between", value1, value2, "zjpxrq");
            return (Criteria) this;
        }

        public Criteria andZjpxjgIsNull() {
            addCriterion("ZJPXJG is null");
            return (Criteria) this;
        }

        public Criteria andZjpxjgIsNotNull() {
            addCriterion("ZJPXJG is not null");
            return (Criteria) this;
        }

        public Criteria andZjpxjgEqualTo(String value) {
            addCriterion("ZJPXJG =", value, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andZjpxjgNotEqualTo(String value) {
            addCriterion("ZJPXJG <>", value, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andZjpxjgGreaterThan(String value) {
            addCriterion("ZJPXJG >", value, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andZjpxjgGreaterThanOrEqualTo(String value) {
            addCriterion("ZJPXJG >=", value, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andZjpxjgLessThan(String value) {
            addCriterion("ZJPXJG <", value, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andZjpxjgLessThanOrEqualTo(String value) {
            addCriterion("ZJPXJG <=", value, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andZjpxjgLike(String value) {
            addCriterion("ZJPXJG like", value, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andZjpxjgNotLike(String value) {
            addCriterion("ZJPXJG not like", value, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andZjpxjgIn(List<String> values) {
            addCriterion("ZJPXJG in", values, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andZjpxjgNotIn(List<String> values) {
            addCriterion("ZJPXJG not in", values, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andZjpxjgBetween(String value1, String value2) {
            addCriterion("ZJPXJG between", value1, value2, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andZjpxjgNotBetween(String value1, String value2) {
            addCriterion("ZJPXJG not between", value1, value2, "zjpxjg");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqIsNull() {
            addCriterion("LWJJFZRQ is null");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqIsNotNull() {
            addCriterion("LWJJFZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqEqualTo(String value) {
            addCriterion("LWJJFZRQ =", value, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqNotEqualTo(String value) {
            addCriterion("LWJJFZRQ <>", value, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqGreaterThan(String value) {
            addCriterion("LWJJFZRQ >", value, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqGreaterThanOrEqualTo(String value) {
            addCriterion("LWJJFZRQ >=", value, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqLessThan(String value) {
            addCriterion("LWJJFZRQ <", value, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqLessThanOrEqualTo(String value) {
            addCriterion("LWJJFZRQ <=", value, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqLike(String value) {
            addCriterion("LWJJFZRQ like", value, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqNotLike(String value) {
            addCriterion("LWJJFZRQ not like", value, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqIn(List<String> values) {
            addCriterion("LWJJFZRQ in", values, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqNotIn(List<String> values) {
            addCriterion("LWJJFZRQ not in", values, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqBetween(String value1, String value2) {
            addCriterion("LWJJFZRQ between", value1, value2, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwjjfzrqNotBetween(String value1, String value2) {
            addCriterion("LWJJFZRQ not between", value1, value2, "lwjjfzrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqIsNull() {
            addCriterion("LWFZDXRQ is null");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqIsNotNull() {
            addCriterion("LWFZDXRQ is not null");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqEqualTo(String value) {
            addCriterion("LWFZDXRQ =", value, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqNotEqualTo(String value) {
            addCriterion("LWFZDXRQ <>", value, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqGreaterThan(String value) {
            addCriterion("LWFZDXRQ >", value, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqGreaterThanOrEqualTo(String value) {
            addCriterion("LWFZDXRQ >=", value, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqLessThan(String value) {
            addCriterion("LWFZDXRQ <", value, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqLessThanOrEqualTo(String value) {
            addCriterion("LWFZDXRQ <=", value, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqLike(String value) {
            addCriterion("LWFZDXRQ like", value, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqNotLike(String value) {
            addCriterion("LWFZDXRQ not like", value, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqIn(List<String> values) {
            addCriterion("LWFZDXRQ in", values, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqNotIn(List<String> values) {
            addCriterion("LWFZDXRQ not in", values, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqBetween(String value1, String value2) {
            addCriterion("LWFZDXRQ between", value1, value2, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andLwfzdxrqNotBetween(String value1, String value2) {
            addCriterion("LWFZDXRQ not between", value1, value2, "lwfzdxrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqIsNull() {
            addCriterion("ZBDHTGRQ is null");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqIsNotNull() {
            addCriterion("ZBDHTGRQ is not null");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqEqualTo(String value) {
            addCriterion("ZBDHTGRQ =", value, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqNotEqualTo(String value) {
            addCriterion("ZBDHTGRQ <>", value, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqGreaterThan(String value) {
            addCriterion("ZBDHTGRQ >", value, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqGreaterThanOrEqualTo(String value) {
            addCriterion("ZBDHTGRQ >=", value, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqLessThan(String value) {
            addCriterion("ZBDHTGRQ <", value, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqLessThanOrEqualTo(String value) {
            addCriterion("ZBDHTGRQ <=", value, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqLike(String value) {
            addCriterion("ZBDHTGRQ like", value, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqNotLike(String value) {
            addCriterion("ZBDHTGRQ not like", value, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqIn(List<String> values) {
            addCriterion("ZBDHTGRQ in", values, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqNotIn(List<String> values) {
            addCriterion("ZBDHTGRQ not in", values, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqBetween(String value1, String value2) {
            addCriterion("ZBDHTGRQ between", value1, value2, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andZbdhtgrqNotBetween(String value1, String value2) {
            addCriterion("ZBDHTGRQ not between", value1, value2, "zbdhtgrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqIsNull() {
            addCriterion("SJZZPZRQ is null");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqIsNotNull() {
            addCriterion("SJZZPZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqEqualTo(String value) {
            addCriterion("SJZZPZRQ =", value, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqNotEqualTo(String value) {
            addCriterion("SJZZPZRQ <>", value, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqGreaterThan(String value) {
            addCriterion("SJZZPZRQ >", value, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqGreaterThanOrEqualTo(String value) {
            addCriterion("SJZZPZRQ >=", value, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqLessThan(String value) {
            addCriterion("SJZZPZRQ <", value, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqLessThanOrEqualTo(String value) {
            addCriterion("SJZZPZRQ <=", value, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqLike(String value) {
            addCriterion("SJZZPZRQ like", value, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqNotLike(String value) {
            addCriterion("SJZZPZRQ not like", value, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqIn(List<String> values) {
            addCriterion("SJZZPZRQ in", values, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqNotIn(List<String> values) {
            addCriterion("SJZZPZRQ not in", values, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqBetween(String value1, String value2) {
            addCriterion("SJZZPZRQ between", value1, value2, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andSjzzpzrqNotBetween(String value1, String value2) {
            addCriterion("SJZZPZRQ not between", value1, value2, "sjzzpzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqIsNull() {
            addCriterion("BLDJJZRQ is null");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqIsNotNull() {
            addCriterion("BLDJJZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqEqualTo(String value) {
            addCriterion("BLDJJZRQ =", value, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqNotEqualTo(String value) {
            addCriterion("BLDJJZRQ <>", value, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqGreaterThan(String value) {
            addCriterion("BLDJJZRQ >", value, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqGreaterThanOrEqualTo(String value) {
            addCriterion("BLDJJZRQ >=", value, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqLessThan(String value) {
            addCriterion("BLDJJZRQ <", value, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqLessThanOrEqualTo(String value) {
            addCriterion("BLDJJZRQ <=", value, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqLike(String value) {
            addCriterion("BLDJJZRQ like", value, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqNotLike(String value) {
            addCriterion("BLDJJZRQ not like", value, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqIn(List<String> values) {
            addCriterion("BLDJJZRQ in", values, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqNotIn(List<String> values) {
            addCriterion("BLDJJZRQ not in", values, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqBetween(String value1, String value2) {
            addCriterion("BLDJJZRQ between", value1, value2, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andBldjjzrqNotBetween(String value1, String value2) {
            addCriterion("BLDJJZRQ not between", value1, value2, "bldjjzrq");
            return (Criteria) this;
        }

        public Criteria andRdrqIsNull() {
            addCriterion("RDRQ is null");
            return (Criteria) this;
        }

        public Criteria andRdrqIsNotNull() {
            addCriterion("RDRQ is not null");
            return (Criteria) this;
        }

        public Criteria andRdrqEqualTo(String value) {
            addCriterion("RDRQ =", value, "rdrq");
            return (Criteria) this;
        }

        public Criteria andRdrqNotEqualTo(String value) {
            addCriterion("RDRQ <>", value, "rdrq");
            return (Criteria) this;
        }

        public Criteria andRdrqGreaterThan(String value) {
            addCriterion("RDRQ >", value, "rdrq");
            return (Criteria) this;
        }

        public Criteria andRdrqGreaterThanOrEqualTo(String value) {
            addCriterion("RDRQ >=", value, "rdrq");
            return (Criteria) this;
        }

        public Criteria andRdrqLessThan(String value) {
            addCriterion("RDRQ <", value, "rdrq");
            return (Criteria) this;
        }

        public Criteria andRdrqLessThanOrEqualTo(String value) {
            addCriterion("RDRQ <=", value, "rdrq");
            return (Criteria) this;
        }

        public Criteria andRdrqLike(String value) {
            addCriterion("RDRQ like", value, "rdrq");
            return (Criteria) this;
        }

        public Criteria andRdrqNotLike(String value) {
            addCriterion("RDRQ not like", value, "rdrq");
            return (Criteria) this;
        }

        public Criteria andRdrqIn(List<String> values) {
            addCriterion("RDRQ in", values, "rdrq");
            return (Criteria) this;
        }

        public Criteria andRdrqNotIn(List<String> values) {
            addCriterion("RDRQ not in", values, "rdrq");
            return (Criteria) this;
        }

        public Criteria andRdrqBetween(String value1, String value2) {
            addCriterion("RDRQ between", value1, value2, "rdrq");
            return (Criteria) this;
        }

        public Criteria andRdrqNotBetween(String value1, String value2) {
            addCriterion("RDRQ not between", value1, value2, "rdrq");
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