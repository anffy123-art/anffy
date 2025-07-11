package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzBzcyxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzBzcyxxExample() {
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

        public Criteria andBzcyxxbsIsNull() {
            addCriterion("BZCYXXBS is null");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsIsNotNull() {
            addCriterion("BZCYXXBS is not null");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsEqualTo(String value) {
            addCriterion("BZCYXXBS =", value, "bzcyxxbs");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsNotEqualTo(String value) {
            addCriterion("BZCYXXBS <>", value, "bzcyxxbs");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsGreaterThan(String value) {
            addCriterion("BZCYXXBS >", value, "bzcyxxbs");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsGreaterThanOrEqualTo(String value) {
            addCriterion("BZCYXXBS >=", value, "bzcyxxbs");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsLessThan(String value) {
            addCriterion("BZCYXXBS <", value, "bzcyxxbs");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsLessThanOrEqualTo(String value) {
            addCriterion("BZCYXXBS <=", value, "bzcyxxbs");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsLike(String value) {
            addCriterion("BZCYXXBS like", value, "bzcyxxbs");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsNotLike(String value) {
            addCriterion("BZCYXXBS not like", value, "bzcyxxbs");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsIn(List<String> values) {
            addCriterion("BZCYXXBS in", values, "bzcyxxbs");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsNotIn(List<String> values) {
            addCriterion("BZCYXXBS not in", values, "bzcyxxbs");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsBetween(String value1, String value2) {
            addCriterion("BZCYXXBS between", value1, value2, "bzcyxxbs");
            return (Criteria) this;
        }

        public Criteria andBzcyxxbsNotBetween(String value1, String value2) {
            addCriterion("BZCYXXBS not between", value1, value2, "bzcyxxbs");
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

        public Criteria andJcIsNull() {
            addCriterion("JC is null");
            return (Criteria) this;
        }

        public Criteria andJcIsNotNull() {
            addCriterion("JC is not null");
            return (Criteria) this;
        }

        public Criteria andJcEqualTo(String value) {
            addCriterion("JC =", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotEqualTo(String value) {
            addCriterion("JC <>", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcGreaterThan(String value) {
            addCriterion("JC >", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcGreaterThanOrEqualTo(String value) {
            addCriterion("JC >=", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcLessThan(String value) {
            addCriterion("JC <", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcLessThanOrEqualTo(String value) {
            addCriterion("JC <=", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcLike(String value) {
            addCriterion("JC like", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotLike(String value) {
            addCriterion("JC not like", value, "jc");
            return (Criteria) this;
        }

        public Criteria andJcIn(List<String> values) {
            addCriterion("JC in", values, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotIn(List<String> values) {
            addCriterion("JC not in", values, "jc");
            return (Criteria) this;
        }

        public Criteria andJcBetween(String value1, String value2) {
            addCriterion("JC between", value1, value2, "jc");
            return (Criteria) this;
        }

        public Criteria andJcNotBetween(String value1, String value2) {
            addCriterion("JC not between", value1, value2, "jc");
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

        public Criteria andZwmcIsNull() {
            addCriterion("ZWMC is null");
            return (Criteria) this;
        }

        public Criteria andZwmcIsNotNull() {
            addCriterion("ZWMC is not null");
            return (Criteria) this;
        }

        public Criteria andZwmcEqualTo(String value) {
            addCriterion("ZWMC =", value, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZwmcNotEqualTo(String value) {
            addCriterion("ZWMC <>", value, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZwmcGreaterThan(String value) {
            addCriterion("ZWMC >", value, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZwmcGreaterThanOrEqualTo(String value) {
            addCriterion("ZWMC >=", value, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZwmcLessThan(String value) {
            addCriterion("ZWMC <", value, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZwmcLessThanOrEqualTo(String value) {
            addCriterion("ZWMC <=", value, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZwmcLike(String value) {
            addCriterion("ZWMC like", value, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZwmcNotLike(String value) {
            addCriterion("ZWMC not like", value, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZwmcIn(List<String> values) {
            addCriterion("ZWMC in", values, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZwmcNotIn(List<String> values) {
            addCriterion("ZWMC not in", values, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZwmcBetween(String value1, String value2) {
            addCriterion("ZWMC between", value1, value2, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZwmcNotBetween(String value1, String value2) {
            addCriterion("ZWMC not between", value1, value2, "zwmc");
            return (Criteria) this;
        }

        public Criteria andZzjzqkIsNull() {
            addCriterion("ZZJZQK is null");
            return (Criteria) this;
        }

        public Criteria andZzjzqkIsNotNull() {
            addCriterion("ZZJZQK is not null");
            return (Criteria) this;
        }

        public Criteria andZzjzqkEqualTo(String value) {
            addCriterion("ZZJZQK =", value, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZzjzqkNotEqualTo(String value) {
            addCriterion("ZZJZQK <>", value, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZzjzqkGreaterThan(String value) {
            addCriterion("ZZJZQK >", value, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZzjzqkGreaterThanOrEqualTo(String value) {
            addCriterion("ZZJZQK >=", value, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZzjzqkLessThan(String value) {
            addCriterion("ZZJZQK <", value, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZzjzqkLessThanOrEqualTo(String value) {
            addCriterion("ZZJZQK <=", value, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZzjzqkLike(String value) {
            addCriterion("ZZJZQK like", value, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZzjzqkNotLike(String value) {
            addCriterion("ZZJZQK not like", value, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZzjzqkIn(List<String> values) {
            addCriterion("ZZJZQK in", values, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZzjzqkNotIn(List<String> values) {
            addCriterion("ZZJZQK not in", values, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZzjzqkBetween(String value1, String value2) {
            addCriterion("ZZJZQK between", value1, value2, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZzjzqkNotBetween(String value1, String value2) {
            addCriterion("ZZJZQK not between", value1, value2, "zzjzqk");
            return (Criteria) this;
        }

        public Criteria andZwsmIsNull() {
            addCriterion("ZWSM is null");
            return (Criteria) this;
        }

        public Criteria andZwsmIsNotNull() {
            addCriterion("ZWSM is not null");
            return (Criteria) this;
        }

        public Criteria andZwsmEqualTo(String value) {
            addCriterion("ZWSM =", value, "zwsm");
            return (Criteria) this;
        }

        public Criteria andZwsmNotEqualTo(String value) {
            addCriterion("ZWSM <>", value, "zwsm");
            return (Criteria) this;
        }

        public Criteria andZwsmGreaterThan(String value) {
            addCriterion("ZWSM >", value, "zwsm");
            return (Criteria) this;
        }

        public Criteria andZwsmGreaterThanOrEqualTo(String value) {
            addCriterion("ZWSM >=", value, "zwsm");
            return (Criteria) this;
        }

        public Criteria andZwsmLessThan(String value) {
            addCriterion("ZWSM <", value, "zwsm");
            return (Criteria) this;
        }

        public Criteria andZwsmLessThanOrEqualTo(String value) {
            addCriterion("ZWSM <=", value, "zwsm");
            return (Criteria) this;
        }

        public Criteria andZwsmLike(String value) {
            addCriterion("ZWSM like", value, "zwsm");
            return (Criteria) this;
        }

        public Criteria andZwsmNotLike(String value) {
            addCriterion("ZWSM not like", value, "zwsm");
            return (Criteria) this;
        }

        public Criteria andZwsmIn(List<String> values) {
            addCriterion("ZWSM in", values, "zwsm");
            return (Criteria) this;
        }

        public Criteria andZwsmNotIn(List<String> values) {
            addCriterion("ZWSM not in", values, "zwsm");
            return (Criteria) this;
        }

        public Criteria andZwsmBetween(String value1, String value2) {
            addCriterion("ZWSM between", value1, value2, "zwsm");
            return (Criteria) this;
        }

        public Criteria andZwsmNotBetween(String value1, String value2) {
            addCriterion("ZWSM not between", value1, value2, "zwsm");
            return (Criteria) this;
        }

        public Criteria andGzwjbIsNull() {
            addCriterion("GZWJB is null");
            return (Criteria) this;
        }

        public Criteria andGzwjbIsNotNull() {
            addCriterion("GZWJB is not null");
            return (Criteria) this;
        }

        public Criteria andGzwjbEqualTo(String value) {
            addCriterion("GZWJB =", value, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andGzwjbNotEqualTo(String value) {
            addCriterion("GZWJB <>", value, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andGzwjbGreaterThan(String value) {
            addCriterion("GZWJB >", value, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andGzwjbGreaterThanOrEqualTo(String value) {
            addCriterion("GZWJB >=", value, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andGzwjbLessThan(String value) {
            addCriterion("GZWJB <", value, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andGzwjbLessThanOrEqualTo(String value) {
            addCriterion("GZWJB <=", value, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andGzwjbLike(String value) {
            addCriterion("GZWJB like", value, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andGzwjbNotLike(String value) {
            addCriterion("GZWJB not like", value, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andGzwjbIn(List<String> values) {
            addCriterion("GZWJB in", values, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andGzwjbNotIn(List<String> values) {
            addCriterion("GZWJB not in", values, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andGzwjbBetween(String value1, String value2) {
            addCriterion("GZWJB between", value1, value2, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andGzwjbNotBetween(String value1, String value2) {
            addCriterion("GZWJB not between", value1, value2, "gzwjb");
            return (Criteria) this;
        }

        public Criteria andPzrzrqIsNull() {
            addCriterion("PZRZRQ is null");
            return (Criteria) this;
        }

        public Criteria andPzrzrqIsNotNull() {
            addCriterion("PZRZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andPzrzrqEqualTo(String value) {
            addCriterion("PZRZRQ =", value, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzrzrqNotEqualTo(String value) {
            addCriterion("PZRZRQ <>", value, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzrzrqGreaterThan(String value) {
            addCriterion("PZRZRQ >", value, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzrzrqGreaterThanOrEqualTo(String value) {
            addCriterion("PZRZRQ >=", value, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzrzrqLessThan(String value) {
            addCriterion("PZRZRQ <", value, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzrzrqLessThanOrEqualTo(String value) {
            addCriterion("PZRZRQ <=", value, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzrzrqLike(String value) {
            addCriterion("PZRZRQ like", value, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzrzrqNotLike(String value) {
            addCriterion("PZRZRQ not like", value, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzrzrqIn(List<String> values) {
            addCriterion("PZRZRQ in", values, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzrzrqNotIn(List<String> values) {
            addCriterion("PZRZRQ not in", values, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzrzrqBetween(String value1, String value2) {
            addCriterion("PZRZRQ between", value1, value2, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzrzrqNotBetween(String value1, String value2) {
            addCriterion("PZRZRQ not between", value1, value2, "pzrzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqIsNull() {
            addCriterion("PZMZRQ is null");
            return (Criteria) this;
        }

        public Criteria andPzmzrqIsNotNull() {
            addCriterion("PZMZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andPzmzrqEqualTo(String value) {
            addCriterion("PZMZRQ =", value, "pzmzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqNotEqualTo(String value) {
            addCriterion("PZMZRQ <>", value, "pzmzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqGreaterThan(String value) {
            addCriterion("PZMZRQ >", value, "pzmzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqGreaterThanOrEqualTo(String value) {
            addCriterion("PZMZRQ >=", value, "pzmzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqLessThan(String value) {
            addCriterion("PZMZRQ <", value, "pzmzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqLessThanOrEqualTo(String value) {
            addCriterion("PZMZRQ <=", value, "pzmzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqLike(String value) {
            addCriterion("PZMZRQ like", value, "pzmzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqNotLike(String value) {
            addCriterion("PZMZRQ not like", value, "pzmzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqIn(List<String> values) {
            addCriterion("PZMZRQ in", values, "pzmzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqNotIn(List<String> values) {
            addCriterion("PZMZRQ not in", values, "pzmzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqBetween(String value1, String value2) {
            addCriterion("PZMZRQ between", value1, value2, "pzmzrq");
            return (Criteria) this;
        }

        public Criteria andPzmzrqNotBetween(String value1, String value2) {
            addCriterion("PZMZRQ not between", value1, value2, "pzmzrq");
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

        public Criteria andRzfsIsNull() {
            addCriterion("RZFS is null");
            return (Criteria) this;
        }

        public Criteria andRzfsIsNotNull() {
            addCriterion("RZFS is not null");
            return (Criteria) this;
        }

        public Criteria andRzfsEqualTo(String value) {
            addCriterion("RZFS =", value, "rzfs");
            return (Criteria) this;
        }

        public Criteria andRzfsNotEqualTo(String value) {
            addCriterion("RZFS <>", value, "rzfs");
            return (Criteria) this;
        }

        public Criteria andRzfsGreaterThan(String value) {
            addCriterion("RZFS >", value, "rzfs");
            return (Criteria) this;
        }

        public Criteria andRzfsGreaterThanOrEqualTo(String value) {
            addCriterion("RZFS >=", value, "rzfs");
            return (Criteria) this;
        }

        public Criteria andRzfsLessThan(String value) {
            addCriterion("RZFS <", value, "rzfs");
            return (Criteria) this;
        }

        public Criteria andRzfsLessThanOrEqualTo(String value) {
            addCriterion("RZFS <=", value, "rzfs");
            return (Criteria) this;
        }

        public Criteria andRzfsLike(String value) {
            addCriterion("RZFS like", value, "rzfs");
            return (Criteria) this;
        }

        public Criteria andRzfsNotLike(String value) {
            addCriterion("RZFS not like", value, "rzfs");
            return (Criteria) this;
        }

        public Criteria andRzfsIn(List<String> values) {
            addCriterion("RZFS in", values, "rzfs");
            return (Criteria) this;
        }

        public Criteria andRzfsNotIn(List<String> values) {
            addCriterion("RZFS not in", values, "rzfs");
            return (Criteria) this;
        }

        public Criteria andRzfsBetween(String value1, String value2) {
            addCriterion("RZFS between", value1, value2, "rzfs");
            return (Criteria) this;
        }

        public Criteria andRzfsNotBetween(String value1, String value2) {
            addCriterion("RZFS not between", value1, value2, "rzfs");
            return (Criteria) this;
        }

        public Criteria andDpWyIsNull() {
            addCriterion("DP_WY is null");
            return (Criteria) this;
        }

        public Criteria andDpWyIsNotNull() {
            addCriterion("DP_WY is not null");
            return (Criteria) this;
        }

        public Criteria andDpWyEqualTo(String value) {
            addCriterion("DP_WY =", value, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpWyNotEqualTo(String value) {
            addCriterion("DP_WY <>", value, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpWyGreaterThan(String value) {
            addCriterion("DP_WY >", value, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpWyGreaterThanOrEqualTo(String value) {
            addCriterion("DP_WY >=", value, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpWyLessThan(String value) {
            addCriterion("DP_WY <", value, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpWyLessThanOrEqualTo(String value) {
            addCriterion("DP_WY <=", value, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpWyLike(String value) {
            addCriterion("DP_WY like", value, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpWyNotLike(String value) {
            addCriterion("DP_WY not like", value, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpWyIn(List<String> values) {
            addCriterion("DP_WY in", values, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpWyNotIn(List<String> values) {
            addCriterion("DP_WY not in", values, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpWyBetween(String value1, String value2) {
            addCriterion("DP_WY between", value1, value2, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpWyNotBetween(String value1, String value2) {
            addCriterion("DP_WY not between", value1, value2, "dpWy");
            return (Criteria) this;
        }

        public Criteria andDpCwIsNull() {
            addCriterion("DP_CW is null");
            return (Criteria) this;
        }

        public Criteria andDpCwIsNotNull() {
            addCriterion("DP_CW is not null");
            return (Criteria) this;
        }

        public Criteria andDpCwEqualTo(String value) {
            addCriterion("DP_CW =", value, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpCwNotEqualTo(String value) {
            addCriterion("DP_CW <>", value, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpCwGreaterThan(String value) {
            addCriterion("DP_CW >", value, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpCwGreaterThanOrEqualTo(String value) {
            addCriterion("DP_CW >=", value, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpCwLessThan(String value) {
            addCriterion("DP_CW <", value, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpCwLessThanOrEqualTo(String value) {
            addCriterion("DP_CW <=", value, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpCwLike(String value) {
            addCriterion("DP_CW like", value, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpCwNotLike(String value) {
            addCriterion("DP_CW not like", value, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpCwIn(List<String> values) {
            addCriterion("DP_CW in", values, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpCwNotIn(List<String> values) {
            addCriterion("DP_CW not in", values, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpCwBetween(String value1, String value2) {
            addCriterion("DP_CW between", value1, value2, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpCwNotBetween(String value1, String value2) {
            addCriterion("DP_CW not between", value1, value2, "dpCw");
            return (Criteria) this;
        }

        public Criteria andDpSjIsNull() {
            addCriterion("DP_SJ is null");
            return (Criteria) this;
        }

        public Criteria andDpSjIsNotNull() {
            addCriterion("DP_SJ is not null");
            return (Criteria) this;
        }

        public Criteria andDpSjEqualTo(String value) {
            addCriterion("DP_SJ =", value, "dpSj");
            return (Criteria) this;
        }

        public Criteria andDpSjNotEqualTo(String value) {
            addCriterion("DP_SJ <>", value, "dpSj");
            return (Criteria) this;
        }

        public Criteria andDpSjGreaterThan(String value) {
            addCriterion("DP_SJ >", value, "dpSj");
            return (Criteria) this;
        }

        public Criteria andDpSjGreaterThanOrEqualTo(String value) {
            addCriterion("DP_SJ >=", value, "dpSj");
            return (Criteria) this;
        }

        public Criteria andDpSjLessThan(String value) {
            addCriterion("DP_SJ <", value, "dpSj");
            return (Criteria) this;
        }

        public Criteria andDpSjLessThanOrEqualTo(String value) {
            addCriterion("DP_SJ <=", value, "dpSj");
            return (Criteria) this;
        }

        public Criteria andDpSjLike(String value) {
            addCriterion("DP_SJ like", value, "dpSj");
            return (Criteria) this;
        }

        public Criteria andDpSjNotLike(String value) {
            addCriterion("DP_SJ not like", value, "dpSj");
            return (Criteria) this;
        }

        public Criteria andDpSjIn(List<String> values) {
            addCriterion("DP_SJ in", values, "dpSj");
            return (Criteria) this;
        }

        public Criteria andDpSjNotIn(List<String> values) {
            addCriterion("DP_SJ not in", values, "dpSj");
            return (Criteria) this;
        }

        public Criteria andDpSjBetween(String value1, String value2) {
            addCriterion("DP_SJ between", value1, value2, "dpSj");
            return (Criteria) this;
        }

        public Criteria andDpSjNotBetween(String value1, String value2) {
            addCriterion("DP_SJ not between", value1, value2, "dpSj");
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