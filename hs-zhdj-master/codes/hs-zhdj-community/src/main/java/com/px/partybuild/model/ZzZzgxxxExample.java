package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZzZzgxxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzZzgxxxExample() {
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

        public Criteria andZzgxxxbsIsNull() {
            addCriterion("ZZGXXXBS is null");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsIsNotNull() {
            addCriterion("ZZGXXXBS is not null");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsEqualTo(String value) {
            addCriterion("ZZGXXXBS =", value, "zzgxxxbs");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsNotEqualTo(String value) {
            addCriterion("ZZGXXXBS <>", value, "zzgxxxbs");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsGreaterThan(String value) {
            addCriterion("ZZGXXXBS >", value, "zzgxxxbs");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsGreaterThanOrEqualTo(String value) {
            addCriterion("ZZGXXXBS >=", value, "zzgxxxbs");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsLessThan(String value) {
            addCriterion("ZZGXXXBS <", value, "zzgxxxbs");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsLessThanOrEqualTo(String value) {
            addCriterion("ZZGXXXBS <=", value, "zzgxxxbs");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsLike(String value) {
            addCriterion("ZZGXXXBS like", value, "zzgxxxbs");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsNotLike(String value) {
            addCriterion("ZZGXXXBS not like", value, "zzgxxxbs");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsIn(List<String> values) {
            addCriterion("ZZGXXXBS in", values, "zzgxxxbs");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsNotIn(List<String> values) {
            addCriterion("ZZGXXXBS not in", values, "zzgxxxbs");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsBetween(String value1, String value2) {
            addCriterion("ZZGXXXBS between", value1, value2, "zzgxxxbs");
            return (Criteria) this;
        }

        public Criteria andZzgxxxbsNotBetween(String value1, String value2) {
            addCriterion("ZZGXXXBS not between", value1, value2, "zzgxxxbs");
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

        public Criteria andJrzbrqIsNull() {
            addCriterion("JRZBRQ is null");
            return (Criteria) this;
        }

        public Criteria andJrzbrqIsNotNull() {
            addCriterion("JRZBRQ is not null");
            return (Criteria) this;
        }

        public Criteria andJrzbrqEqualTo(String value) {
            addCriterion("JRZBRQ =", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqNotEqualTo(String value) {
            addCriterion("JRZBRQ <>", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqGreaterThan(String value) {
            addCriterion("JRZBRQ >", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqGreaterThanOrEqualTo(String value) {
            addCriterion("JRZBRQ >=", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqLessThan(String value) {
            addCriterion("JRZBRQ <", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqLessThanOrEqualTo(String value) {
            addCriterion("JRZBRQ <=", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqLike(String value) {
            addCriterion("JRZBRQ like", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqNotLike(String value) {
            addCriterion("JRZBRQ not like", value, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqIn(List<String> values) {
            addCriterion("JRZBRQ in", values, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqNotIn(List<String> values) {
            addCriterion("JRZBRQ not in", values, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqBetween(String value1, String value2) {
            addCriterion("JRZBRQ between", value1, value2, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzbrqNotBetween(String value1, String value2) {
            addCriterion("JRZBRQ not between", value1, value2, "jrzbrq");
            return (Criteria) this;
        }

        public Criteria andJrzblxIsNull() {
            addCriterion("JRZBLX is null");
            return (Criteria) this;
        }

        public Criteria andJrzblxIsNotNull() {
            addCriterion("JRZBLX is not null");
            return (Criteria) this;
        }

        public Criteria andJrzblxEqualTo(String value) {
            addCriterion("JRZBLX =", value, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andJrzblxNotEqualTo(String value) {
            addCriterion("JRZBLX <>", value, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andJrzblxGreaterThan(String value) {
            addCriterion("JRZBLX >", value, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andJrzblxGreaterThanOrEqualTo(String value) {
            addCriterion("JRZBLX >=", value, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andJrzblxLessThan(String value) {
            addCriterion("JRZBLX <", value, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andJrzblxLessThanOrEqualTo(String value) {
            addCriterion("JRZBLX <=", value, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andJrzblxLike(String value) {
            addCriterion("JRZBLX like", value, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andJrzblxNotLike(String value) {
            addCriterion("JRZBLX not like", value, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andJrzblxIn(List<String> values) {
            addCriterion("JRZBLX in", values, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andJrzblxNotIn(List<String> values) {
            addCriterion("JRZBLX not in", values, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andJrzblxBetween(String value1, String value2) {
            addCriterion("JRZBLX between", value1, value2, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andJrzblxNotBetween(String value1, String value2) {
            addCriterion("JRZBLX not between", value1, value2, "jrzblx");
            return (Criteria) this;
        }

        public Criteria andZlzbrqIsNull() {
            addCriterion("ZLZBRQ is null");
            return (Criteria) this;
        }

        public Criteria andZlzbrqIsNotNull() {
            addCriterion("ZLZBRQ is not null");
            return (Criteria) this;
        }

        public Criteria andZlzbrqEqualTo(String value) {
            addCriterion("ZLZBRQ =", value, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzbrqNotEqualTo(String value) {
            addCriterion("ZLZBRQ <>", value, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzbrqGreaterThan(String value) {
            addCriterion("ZLZBRQ >", value, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzbrqGreaterThanOrEqualTo(String value) {
            addCriterion("ZLZBRQ >=", value, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzbrqLessThan(String value) {
            addCriterion("ZLZBRQ <", value, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzbrqLessThanOrEqualTo(String value) {
            addCriterion("ZLZBRQ <=", value, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzbrqLike(String value) {
            addCriterion("ZLZBRQ like", value, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzbrqNotLike(String value) {
            addCriterion("ZLZBRQ not like", value, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzbrqIn(List<String> values) {
            addCriterion("ZLZBRQ in", values, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzbrqNotIn(List<String> values) {
            addCriterion("ZLZBRQ not in", values, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzbrqBetween(String value1, String value2) {
            addCriterion("ZLZBRQ between", value1, value2, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzbrqNotBetween(String value1, String value2) {
            addCriterion("ZLZBRQ not between", value1, value2, "zlzbrq");
            return (Criteria) this;
        }

        public Criteria andZlzblxIsNull() {
            addCriterion("ZLZBLX is null");
            return (Criteria) this;
        }

        public Criteria andZlzblxIsNotNull() {
            addCriterion("ZLZBLX is not null");
            return (Criteria) this;
        }

        public Criteria andZlzblxEqualTo(String value) {
            addCriterion("ZLZBLX =", value, "zlzblx");
            return (Criteria) this;
        }

        public Criteria andZlzblxNotEqualTo(String value) {
            addCriterion("ZLZBLX <>", value, "zlzblx");
            return (Criteria) this;
        }

        public Criteria andZlzblxGreaterThan(String value) {
            addCriterion("ZLZBLX >", value, "zlzblx");
            return (Criteria) this;
        }

        public Criteria andZlzblxGreaterThanOrEqualTo(String value) {
            addCriterion("ZLZBLX >=", value, "zlzblx");
            return (Criteria) this;
        }

        public Criteria andZlzblxLessThan(String value) {
            addCriterion("ZLZBLX <", value, "zlzblx");
            return (Criteria) this;
        }

        public Criteria andZlzblxLessThanOrEqualTo(String value) {
            addCriterion("ZLZBLX <=", value, "zlzblx");
            return (Criteria) this;
        }

        public Criteria andZlzblxLike(String value) {
            addCriterion("ZLZBLX like", value, "zlzblx");
            return (Criteria) this;
        }

        public Criteria andZlzblxNotLike(String value) {
            addCriterion("ZLZBLX not like", value, "zlzblx");
            return (Criteria) this;
        }

        public Criteria andZlzblxIn(List<String> values) {
            addCriterion("ZLZBLX in", values, "zlzblx");
            return (Criteria) this;
        }

        public Criteria andZlzblxNotIn(List<String> values) {
            addCriterion("ZLZBLX not in", values, "zlzblx");
            return (Criteria) this;
        }

        public Criteria andZlzblxBetween(String value1, String value2) {
            addCriterion("ZLZBLX between", value1, value2, "zlzblx");
            return (Criteria) this;
        }

        public Criteria andZlzblxNotBetween(String value1, String value2) {
            addCriterion("ZLZBLX not between", value1, value2, "zlzblx");
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

        public Criteria andNewdzzdmIsNull() {
            addCriterion("newDzzdm is null");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmIsNotNull() {
            addCriterion("newDzzdm is not null");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmEqualTo(String value) {
            addCriterion("newDzzdm =", value, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmNotEqualTo(String value) {
            addCriterion("newDzzdm <>", value, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmGreaterThan(String value) {
            addCriterion("newDzzdm >", value, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmGreaterThanOrEqualTo(String value) {
            addCriterion("newDzzdm >=", value, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmLessThan(String value) {
            addCriterion("newDzzdm <", value, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmLessThanOrEqualTo(String value) {
            addCriterion("newDzzdm <=", value, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmLike(String value) {
            addCriterion("newDzzdm like", value, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmNotLike(String value) {
            addCriterion("newDzzdm not like", value, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmIn(List<String> values) {
            addCriterion("newDzzdm in", values, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmNotIn(List<String> values) {
            addCriterion("newDzzdm not in", values, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmBetween(String value1, String value2) {
            addCriterion("newDzzdm between", value1, value2, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andNewdzzdmNotBetween(String value1, String value2) {
            addCriterion("newDzzdm not between", value1, value2, "newdzzdm");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusIsNull() {
            addCriterion("userPartyChangeStatus is null");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusIsNotNull() {
            addCriterion("userPartyChangeStatus is not null");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusEqualTo(Integer value) {
            addCriterion("userPartyChangeStatus =", value, "userpartychangestatus");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusNotEqualTo(Integer value) {
            addCriterion("userPartyChangeStatus <>", value, "userpartychangestatus");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusGreaterThan(Integer value) {
            addCriterion("userPartyChangeStatus >", value, "userpartychangestatus");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("userPartyChangeStatus >=", value, "userpartychangestatus");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusLessThan(Integer value) {
            addCriterion("userPartyChangeStatus <", value, "userpartychangestatus");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusLessThanOrEqualTo(Integer value) {
            addCriterion("userPartyChangeStatus <=", value, "userpartychangestatus");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusIn(List<Integer> values) {
            addCriterion("userPartyChangeStatus in", values, "userpartychangestatus");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusNotIn(List<Integer> values) {
            addCriterion("userPartyChangeStatus not in", values, "userpartychangestatus");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusBetween(Integer value1, Integer value2) {
            addCriterion("userPartyChangeStatus between", value1, value2, "userpartychangestatus");
            return (Criteria) this;
        }

        public Criteria andUserpartychangestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("userPartyChangeStatus not between", value1, value2, "userpartychangestatus");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkIsNull() {
            addCriterion("auditRemark is null");
            return (Criteria) this;
        }

        public Criteria andAuditremarkIsNotNull() {
            addCriterion("auditRemark is not null");
            return (Criteria) this;
        }

        public Criteria andAuditremarkEqualTo(String value) {
            addCriterion("auditRemark =", value, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkNotEqualTo(String value) {
            addCriterion("auditRemark <>", value, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkGreaterThan(String value) {
            addCriterion("auditRemark >", value, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkGreaterThanOrEqualTo(String value) {
            addCriterion("auditRemark >=", value, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkLessThan(String value) {
            addCriterion("auditRemark <", value, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkLessThanOrEqualTo(String value) {
            addCriterion("auditRemark <=", value, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkLike(String value) {
            addCriterion("auditRemark like", value, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkNotLike(String value) {
            addCriterion("auditRemark not like", value, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkIn(List<String> values) {
            addCriterion("auditRemark in", values, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkNotIn(List<String> values) {
            addCriterion("auditRemark not in", values, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkBetween(String value1, String value2) {
            addCriterion("auditRemark between", value1, value2, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAuditremarkNotBetween(String value1, String value2) {
            addCriterion("auditRemark not between", value1, value2, "auditremark");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNull() {
            addCriterion("auditTime is null");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNotNull() {
            addCriterion("auditTime is not null");
            return (Criteria) this;
        }

        public Criteria andAudittimeEqualTo(Date value) {
            addCriterion("auditTime =", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotEqualTo(Date value) {
            addCriterion("auditTime <>", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThan(Date value) {
            addCriterion("auditTime >", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("auditTime >=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThan(Date value) {
            addCriterion("auditTime <", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThanOrEqualTo(Date value) {
            addCriterion("auditTime <=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeIn(List<Date> values) {
            addCriterion("auditTime in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotIn(List<Date> values) {
            addCriterion("auditTime not in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeBetween(Date value1, Date value2) {
            addCriterion("auditTime between", value1, value2, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotBetween(Date value1, Date value2) {
            addCriterion("auditTime not between", value1, value2, "audittime");
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