package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzDjxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzDjxxExample() {
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

        public Criteria andDjxxbsIsNull() {
            addCriterion("DJXXBS is null");
            return (Criteria) this;
        }

        public Criteria andDjxxbsIsNotNull() {
            addCriterion("DJXXBS is not null");
            return (Criteria) this;
        }

        public Criteria andDjxxbsEqualTo(String value) {
            addCriterion("DJXXBS =", value, "djxxbs");
            return (Criteria) this;
        }

        public Criteria andDjxxbsNotEqualTo(String value) {
            addCriterion("DJXXBS <>", value, "djxxbs");
            return (Criteria) this;
        }

        public Criteria andDjxxbsGreaterThan(String value) {
            addCriterion("DJXXBS >", value, "djxxbs");
            return (Criteria) this;
        }

        public Criteria andDjxxbsGreaterThanOrEqualTo(String value) {
            addCriterion("DJXXBS >=", value, "djxxbs");
            return (Criteria) this;
        }

        public Criteria andDjxxbsLessThan(String value) {
            addCriterion("DJXXBS <", value, "djxxbs");
            return (Criteria) this;
        }

        public Criteria andDjxxbsLessThanOrEqualTo(String value) {
            addCriterion("DJXXBS <=", value, "djxxbs");
            return (Criteria) this;
        }

        public Criteria andDjxxbsLike(String value) {
            addCriterion("DJXXBS like", value, "djxxbs");
            return (Criteria) this;
        }

        public Criteria andDjxxbsNotLike(String value) {
            addCriterion("DJXXBS not like", value, "djxxbs");
            return (Criteria) this;
        }

        public Criteria andDjxxbsIn(List<String> values) {
            addCriterion("DJXXBS in", values, "djxxbs");
            return (Criteria) this;
        }

        public Criteria andDjxxbsNotIn(List<String> values) {
            addCriterion("DJXXBS not in", values, "djxxbs");
            return (Criteria) this;
        }

        public Criteria andDjxxbsBetween(String value1, String value2) {
            addCriterion("DJXXBS between", value1, value2, "djxxbs");
            return (Criteria) this;
        }

        public Criteria andDjxxbsNotBetween(String value1, String value2) {
            addCriterion("DJXXBS not between", value1, value2, "djxxbs");
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

        public Criteria andJrzgzzrqIsNull() {
            addCriterion("JRZGZZRQ is null");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqIsNotNull() {
            addCriterion("JRZGZZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqEqualTo(String value) {
            addCriterion("JRZGZZRQ =", value, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqNotEqualTo(String value) {
            addCriterion("JRZGZZRQ <>", value, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqGreaterThan(String value) {
            addCriterion("JRZGZZRQ >", value, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqGreaterThanOrEqualTo(String value) {
            addCriterion("JRZGZZRQ >=", value, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqLessThan(String value) {
            addCriterion("JRZGZZRQ <", value, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqLessThanOrEqualTo(String value) {
            addCriterion("JRZGZZRQ <=", value, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqLike(String value) {
            addCriterion("JRZGZZRQ like", value, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqNotLike(String value) {
            addCriterion("JRZGZZRQ not like", value, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqIn(List<String> values) {
            addCriterion("JRZGZZRQ in", values, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqNotIn(List<String> values) {
            addCriterion("JRZGZZRQ not in", values, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqBetween(String value1, String value2) {
            addCriterion("JRZGZZRQ between", value1, value2, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzrqNotBetween(String value1, String value2) {
            addCriterion("JRZGZZRQ not between", value1, value2, "jrzgzzrq");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxIsNull() {
            addCriterion("JRZGZZLX is null");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxIsNotNull() {
            addCriterion("JRZGZZLX is not null");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxEqualTo(String value) {
            addCriterion("JRZGZZLX =", value, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxNotEqualTo(String value) {
            addCriterion("JRZGZZLX <>", value, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxGreaterThan(String value) {
            addCriterion("JRZGZZLX >", value, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxGreaterThanOrEqualTo(String value) {
            addCriterion("JRZGZZLX >=", value, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxLessThan(String value) {
            addCriterion("JRZGZZLX <", value, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxLessThanOrEqualTo(String value) {
            addCriterion("JRZGZZLX <=", value, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxLike(String value) {
            addCriterion("JRZGZZLX like", value, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxNotLike(String value) {
            addCriterion("JRZGZZLX not like", value, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxIn(List<String> values) {
            addCriterion("JRZGZZLX in", values, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxNotIn(List<String> values) {
            addCriterion("JRZGZZLX not in", values, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxBetween(String value1, String value2) {
            addCriterion("JRZGZZLX between", value1, value2, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andJrzgzzlxNotBetween(String value1, String value2) {
            addCriterion("JRZGZZLX not between", value1, value2, "jrzgzzlx");
            return (Criteria) this;
        }

        public Criteria andZzrqIsNull() {
            addCriterion("ZZRQ is null");
            return (Criteria) this;
        }

        public Criteria andZzrqIsNotNull() {
            addCriterion("ZZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andZzrqEqualTo(String value) {
            addCriterion("ZZRQ =", value, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzrqNotEqualTo(String value) {
            addCriterion("ZZRQ <>", value, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzrqGreaterThan(String value) {
            addCriterion("ZZRQ >", value, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzrqGreaterThanOrEqualTo(String value) {
            addCriterion("ZZRQ >=", value, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzrqLessThan(String value) {
            addCriterion("ZZRQ <", value, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzrqLessThanOrEqualTo(String value) {
            addCriterion("ZZRQ <=", value, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzrqLike(String value) {
            addCriterion("ZZRQ like", value, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzrqNotLike(String value) {
            addCriterion("ZZRQ not like", value, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzrqIn(List<String> values) {
            addCriterion("ZZRQ in", values, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzrqNotIn(List<String> values) {
            addCriterion("ZZRQ not in", values, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzrqBetween(String value1, String value2) {
            addCriterion("ZZRQ between", value1, value2, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzrqNotBetween(String value1, String value2) {
            addCriterion("ZZRQ not between", value1, value2, "zzrq");
            return (Criteria) this;
        }

        public Criteria andZzqkIsNull() {
            addCriterion("ZZQK is null");
            return (Criteria) this;
        }

        public Criteria andZzqkIsNotNull() {
            addCriterion("ZZQK is not null");
            return (Criteria) this;
        }

        public Criteria andZzqkEqualTo(String value) {
            addCriterion("ZZQK =", value, "zzqk");
            return (Criteria) this;
        }

        public Criteria andZzqkNotEqualTo(String value) {
            addCriterion("ZZQK <>", value, "zzqk");
            return (Criteria) this;
        }

        public Criteria andZzqkGreaterThan(String value) {
            addCriterion("ZZQK >", value, "zzqk");
            return (Criteria) this;
        }

        public Criteria andZzqkGreaterThanOrEqualTo(String value) {
            addCriterion("ZZQK >=", value, "zzqk");
            return (Criteria) this;
        }

        public Criteria andZzqkLessThan(String value) {
            addCriterion("ZZQK <", value, "zzqk");
            return (Criteria) this;
        }

        public Criteria andZzqkLessThanOrEqualTo(String value) {
            addCriterion("ZZQK <=", value, "zzqk");
            return (Criteria) this;
        }

        public Criteria andZzqkLike(String value) {
            addCriterion("ZZQK like", value, "zzqk");
            return (Criteria) this;
        }

        public Criteria andZzqkNotLike(String value) {
            addCriterion("ZZQK not like", value, "zzqk");
            return (Criteria) this;
        }

        public Criteria andZzqkIn(List<String> values) {
            addCriterion("ZZQK in", values, "zzqk");
            return (Criteria) this;
        }

        public Criteria andZzqkNotIn(List<String> values) {
            addCriterion("ZZQK not in", values, "zzqk");
            return (Criteria) this;
        }

        public Criteria andZzqkBetween(String value1, String value2) {
            addCriterion("ZZQK between", value1, value2, "zzqk");
            return (Criteria) this;
        }

        public Criteria andZzqkNotBetween(String value1, String value2) {
            addCriterion("ZZQK not between", value1, value2, "zzqk");
            return (Criteria) this;
        }

        public Criteria andSzdzbIsNull() {
            addCriterion("SZDZB is null");
            return (Criteria) this;
        }

        public Criteria andSzdzbIsNotNull() {
            addCriterion("SZDZB is not null");
            return (Criteria) this;
        }

        public Criteria andSzdzbEqualTo(String value) {
            addCriterion("SZDZB =", value, "szdzb");
            return (Criteria) this;
        }

        public Criteria andSzdzbNotEqualTo(String value) {
            addCriterion("SZDZB <>", value, "szdzb");
            return (Criteria) this;
        }

        public Criteria andSzdzbGreaterThan(String value) {
            addCriterion("SZDZB >", value, "szdzb");
            return (Criteria) this;
        }

        public Criteria andSzdzbGreaterThanOrEqualTo(String value) {
            addCriterion("SZDZB >=", value, "szdzb");
            return (Criteria) this;
        }

        public Criteria andSzdzbLessThan(String value) {
            addCriterion("SZDZB <", value, "szdzb");
            return (Criteria) this;
        }

        public Criteria andSzdzbLessThanOrEqualTo(String value) {
            addCriterion("SZDZB <=", value, "szdzb");
            return (Criteria) this;
        }

        public Criteria andSzdzbLike(String value) {
            addCriterion("SZDZB like", value, "szdzb");
            return (Criteria) this;
        }

        public Criteria andSzdzbNotLike(String value) {
            addCriterion("SZDZB not like", value, "szdzb");
            return (Criteria) this;
        }

        public Criteria andSzdzbIn(List<String> values) {
            addCriterion("SZDZB in", values, "szdzb");
            return (Criteria) this;
        }

        public Criteria andSzdzbNotIn(List<String> values) {
            addCriterion("SZDZB not in", values, "szdzb");
            return (Criteria) this;
        }

        public Criteria andSzdzbBetween(String value1, String value2) {
            addCriterion("SZDZB between", value1, value2, "szdzb");
            return (Criteria) this;
        }

        public Criteria andSzdzbNotBetween(String value1, String value2) {
            addCriterion("SZDZB not between", value1, value2, "szdzb");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqIsNull() {
            addCriterion("LKZGZZRQ is null");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqIsNotNull() {
            addCriterion("LKZGZZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqEqualTo(String value) {
            addCriterion("LKZGZZRQ =", value, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqNotEqualTo(String value) {
            addCriterion("LKZGZZRQ <>", value, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqGreaterThan(String value) {
            addCriterion("LKZGZZRQ >", value, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqGreaterThanOrEqualTo(String value) {
            addCriterion("LKZGZZRQ >=", value, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqLessThan(String value) {
            addCriterion("LKZGZZRQ <", value, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqLessThanOrEqualTo(String value) {
            addCriterion("LKZGZZRQ <=", value, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqLike(String value) {
            addCriterion("LKZGZZRQ like", value, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqNotLike(String value) {
            addCriterion("LKZGZZRQ not like", value, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqIn(List<String> values) {
            addCriterion("LKZGZZRQ in", values, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqNotIn(List<String> values) {
            addCriterion("LKZGZZRQ not in", values, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqBetween(String value1, String value2) {
            addCriterion("LKZGZZRQ between", value1, value2, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andLkzgzzrqNotBetween(String value1, String value2) {
            addCriterion("LKZGZZRQ not between", value1, value2, "lkzgzzrq");
            return (Criteria) this;
        }

        public Criteria andCdyyIsNull() {
            addCriterion("CDYY is null");
            return (Criteria) this;
        }

        public Criteria andCdyyIsNotNull() {
            addCriterion("CDYY is not null");
            return (Criteria) this;
        }

        public Criteria andCdyyEqualTo(String value) {
            addCriterion("CDYY =", value, "cdyy");
            return (Criteria) this;
        }

        public Criteria andCdyyNotEqualTo(String value) {
            addCriterion("CDYY <>", value, "cdyy");
            return (Criteria) this;
        }

        public Criteria andCdyyGreaterThan(String value) {
            addCriterion("CDYY >", value, "cdyy");
            return (Criteria) this;
        }

        public Criteria andCdyyGreaterThanOrEqualTo(String value) {
            addCriterion("CDYY >=", value, "cdyy");
            return (Criteria) this;
        }

        public Criteria andCdyyLessThan(String value) {
            addCriterion("CDYY <", value, "cdyy");
            return (Criteria) this;
        }

        public Criteria andCdyyLessThanOrEqualTo(String value) {
            addCriterion("CDYY <=", value, "cdyy");
            return (Criteria) this;
        }

        public Criteria andCdyyLike(String value) {
            addCriterion("CDYY like", value, "cdyy");
            return (Criteria) this;
        }

        public Criteria andCdyyNotLike(String value) {
            addCriterion("CDYY not like", value, "cdyy");
            return (Criteria) this;
        }

        public Criteria andCdyyIn(List<String> values) {
            addCriterion("CDYY in", values, "cdyy");
            return (Criteria) this;
        }

        public Criteria andCdyyNotIn(List<String> values) {
            addCriterion("CDYY not in", values, "cdyy");
            return (Criteria) this;
        }

        public Criteria andCdyyBetween(String value1, String value2) {
            addCriterion("CDYY between", value1, value2, "cdyy");
            return (Criteria) this;
        }

        public Criteria andCdyyNotBetween(String value1, String value2) {
            addCriterion("CDYY not between", value1, value2, "cdyy");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxIsNull() {
            addCriterion("LKZGZZLX is null");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxIsNotNull() {
            addCriterion("LKZGZZLX is not null");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxEqualTo(String value) {
            addCriterion("LKZGZZLX =", value, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxNotEqualTo(String value) {
            addCriterion("LKZGZZLX <>", value, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxGreaterThan(String value) {
            addCriterion("LKZGZZLX >", value, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxGreaterThanOrEqualTo(String value) {
            addCriterion("LKZGZZLX >=", value, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxLessThan(String value) {
            addCriterion("LKZGZZLX <", value, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxLessThanOrEqualTo(String value) {
            addCriterion("LKZGZZLX <=", value, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxLike(String value) {
            addCriterion("LKZGZZLX like", value, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxNotLike(String value) {
            addCriterion("LKZGZZLX not like", value, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxIn(List<String> values) {
            addCriterion("LKZGZZLX in", values, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxNotIn(List<String> values) {
            addCriterion("LKZGZZLX not in", values, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxBetween(String value1, String value2) {
            addCriterion("LKZGZZLX between", value1, value2, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andLkzgzzlxNotBetween(String value1, String value2) {
            addCriterion("LKZGZZLX not between", value1, value2, "lkzgzzlx");
            return (Criteria) this;
        }

        public Criteria andCjzzshIsNull() {
            addCriterion("CJZZSH is null");
            return (Criteria) this;
        }

        public Criteria andCjzzshIsNotNull() {
            addCriterion("CJZZSH is not null");
            return (Criteria) this;
        }

        public Criteria andCjzzshEqualTo(String value) {
            addCriterion("CJZZSH =", value, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andCjzzshNotEqualTo(String value) {
            addCriterion("CJZZSH <>", value, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andCjzzshGreaterThan(String value) {
            addCriterion("CJZZSH >", value, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andCjzzshGreaterThanOrEqualTo(String value) {
            addCriterion("CJZZSH >=", value, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andCjzzshLessThan(String value) {
            addCriterion("CJZZSH <", value, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andCjzzshLessThanOrEqualTo(String value) {
            addCriterion("CJZZSH <=", value, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andCjzzshLike(String value) {
            addCriterion("CJZZSH like", value, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andCjzzshNotLike(String value) {
            addCriterion("CJZZSH not like", value, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andCjzzshIn(List<String> values) {
            addCriterion("CJZZSH in", values, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andCjzzshNotIn(List<String> values) {
            addCriterion("CJZZSH not in", values, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andCjzzshBetween(String value1, String value2) {
            addCriterion("CJZZSH between", value1, value2, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andCjzzshNotBetween(String value1, String value2) {
            addCriterion("CJZZSH not between", value1, value2, "cjzzsh");
            return (Criteria) this;
        }

        public Criteria andHfdjrqIsNull() {
            addCriterion("HFDJRQ is null");
            return (Criteria) this;
        }

        public Criteria andHfdjrqIsNotNull() {
            addCriterion("HFDJRQ is not null");
            return (Criteria) this;
        }

        public Criteria andHfdjrqEqualTo(String value) {
            addCriterion("HFDJRQ =", value, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andHfdjrqNotEqualTo(String value) {
            addCriterion("HFDJRQ <>", value, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andHfdjrqGreaterThan(String value) {
            addCriterion("HFDJRQ >", value, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andHfdjrqGreaterThanOrEqualTo(String value) {
            addCriterion("HFDJRQ >=", value, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andHfdjrqLessThan(String value) {
            addCriterion("HFDJRQ <", value, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andHfdjrqLessThanOrEqualTo(String value) {
            addCriterion("HFDJRQ <=", value, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andHfdjrqLike(String value) {
            addCriterion("HFDJRQ like", value, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andHfdjrqNotLike(String value) {
            addCriterion("HFDJRQ not like", value, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andHfdjrqIn(List<String> values) {
            addCriterion("HFDJRQ in", values, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andHfdjrqNotIn(List<String> values) {
            addCriterion("HFDJRQ not in", values, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andHfdjrqBetween(String value1, String value2) {
            addCriterion("HFDJRQ between", value1, value2, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andHfdjrqNotBetween(String value1, String value2) {
            addCriterion("HFDJRQ not between", value1, value2, "hfdjrq");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcIsNull() {
            addCriterion("SZDZBMC is null");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcIsNotNull() {
            addCriterion("SZDZBMC is not null");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcEqualTo(String value) {
            addCriterion("SZDZBMC =", value, "szdzbmc");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcNotEqualTo(String value) {
            addCriterion("SZDZBMC <>", value, "szdzbmc");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcGreaterThan(String value) {
            addCriterion("SZDZBMC >", value, "szdzbmc");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcGreaterThanOrEqualTo(String value) {
            addCriterion("SZDZBMC >=", value, "szdzbmc");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcLessThan(String value) {
            addCriterion("SZDZBMC <", value, "szdzbmc");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcLessThanOrEqualTo(String value) {
            addCriterion("SZDZBMC <=", value, "szdzbmc");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcLike(String value) {
            addCriterion("SZDZBMC like", value, "szdzbmc");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcNotLike(String value) {
            addCriterion("SZDZBMC not like", value, "szdzbmc");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcIn(List<String> values) {
            addCriterion("SZDZBMC in", values, "szdzbmc");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcNotIn(List<String> values) {
            addCriterion("SZDZBMC not in", values, "szdzbmc");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcBetween(String value1, String value2) {
            addCriterion("SZDZBMC between", value1, value2, "szdzbmc");
            return (Criteria) this;
        }

        public Criteria andSzdzbmcNotBetween(String value1, String value2) {
            addCriterion("SZDZBMC not between", value1, value2, "szdzbmc");
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