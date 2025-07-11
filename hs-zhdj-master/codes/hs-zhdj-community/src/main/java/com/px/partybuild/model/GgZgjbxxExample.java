package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GgZgjbxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GgZgjbxxExample() {
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

        public Criteria andXbIsNull() {
            addCriterion("XB is null");
            return (Criteria) this;
        }

        public Criteria andXbIsNotNull() {
            addCriterion("XB is not null");
            return (Criteria) this;
        }

        public Criteria andXbEqualTo(String value) {
            addCriterion("XB =", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotEqualTo(String value) {
            addCriterion("XB <>", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThan(String value) {
            addCriterion("XB >", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThanOrEqualTo(String value) {
            addCriterion("XB >=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThan(String value) {
            addCriterion("XB <", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThanOrEqualTo(String value) {
            addCriterion("XB <=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLike(String value) {
            addCriterion("XB like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotLike(String value) {
            addCriterion("XB not like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbIn(List<String> values) {
            addCriterion("XB in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotIn(List<String> values) {
            addCriterion("XB not in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbBetween(String value1, String value2) {
            addCriterion("XB between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotBetween(String value1, String value2) {
            addCriterion("XB not between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andDwbsmIsNull() {
            addCriterion("DWBSM is null");
            return (Criteria) this;
        }

        public Criteria andDwbsmIsNotNull() {
            addCriterion("DWBSM is not null");
            return (Criteria) this;
        }

        public Criteria andDwbsmEqualTo(String value) {
            addCriterion("DWBSM =", value, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbsmNotEqualTo(String value) {
            addCriterion("DWBSM <>", value, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbsmGreaterThan(String value) {
            addCriterion("DWBSM >", value, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbsmGreaterThanOrEqualTo(String value) {
            addCriterion("DWBSM >=", value, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbsmLessThan(String value) {
            addCriterion("DWBSM <", value, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbsmLessThanOrEqualTo(String value) {
            addCriterion("DWBSM <=", value, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbsmLike(String value) {
            addCriterion("DWBSM like", value, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbsmNotLike(String value) {
            addCriterion("DWBSM not like", value, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbsmIn(List<String> values) {
            addCriterion("DWBSM in", values, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbsmNotIn(List<String> values) {
            addCriterion("DWBSM not in", values, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbsmBetween(String value1, String value2) {
            addCriterion("DWBSM between", value1, value2, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbsmNotBetween(String value1, String value2) {
            addCriterion("DWBSM not between", value1, value2, "dwbsm");
            return (Criteria) this;
        }

        public Criteria andDwbmIsNull() {
            addCriterion("DWBM is null");
            return (Criteria) this;
        }

        public Criteria andDwbmIsNotNull() {
            addCriterion("DWBM is not null");
            return (Criteria) this;
        }

        public Criteria andDwbmEqualTo(String value) {
            addCriterion("DWBM =", value, "dwbm");
            return (Criteria) this;
        }

        public Criteria andDwbmNotEqualTo(String value) {
            addCriterion("DWBM <>", value, "dwbm");
            return (Criteria) this;
        }

        public Criteria andDwbmGreaterThan(String value) {
            addCriterion("DWBM >", value, "dwbm");
            return (Criteria) this;
        }

        public Criteria andDwbmGreaterThanOrEqualTo(String value) {
            addCriterion("DWBM >=", value, "dwbm");
            return (Criteria) this;
        }

        public Criteria andDwbmLessThan(String value) {
            addCriterion("DWBM <", value, "dwbm");
            return (Criteria) this;
        }

        public Criteria andDwbmLessThanOrEqualTo(String value) {
            addCriterion("DWBM <=", value, "dwbm");
            return (Criteria) this;
        }

        public Criteria andDwbmLike(String value) {
            addCriterion("DWBM like", value, "dwbm");
            return (Criteria) this;
        }

        public Criteria andDwbmNotLike(String value) {
            addCriterion("DWBM not like", value, "dwbm");
            return (Criteria) this;
        }

        public Criteria andDwbmIn(List<String> values) {
            addCriterion("DWBM in", values, "dwbm");
            return (Criteria) this;
        }

        public Criteria andDwbmNotIn(List<String> values) {
            addCriterion("DWBM not in", values, "dwbm");
            return (Criteria) this;
        }

        public Criteria andDwbmBetween(String value1, String value2) {
            addCriterion("DWBM between", value1, value2, "dwbm");
            return (Criteria) this;
        }

        public Criteria andDwbmNotBetween(String value1, String value2) {
            addCriterion("DWBM not between", value1, value2, "dwbm");
            return (Criteria) this;
        }

        public Criteria andBmbmIsNull() {
            addCriterion("BMBM is null");
            return (Criteria) this;
        }

        public Criteria andBmbmIsNotNull() {
            addCriterion("BMBM is not null");
            return (Criteria) this;
        }

        public Criteria andBmbmEqualTo(String value) {
            addCriterion("BMBM =", value, "bmbm");
            return (Criteria) this;
        }

        public Criteria andBmbmNotEqualTo(String value) {
            addCriterion("BMBM <>", value, "bmbm");
            return (Criteria) this;
        }

        public Criteria andBmbmGreaterThan(String value) {
            addCriterion("BMBM >", value, "bmbm");
            return (Criteria) this;
        }

        public Criteria andBmbmGreaterThanOrEqualTo(String value) {
            addCriterion("BMBM >=", value, "bmbm");
            return (Criteria) this;
        }

        public Criteria andBmbmLessThan(String value) {
            addCriterion("BMBM <", value, "bmbm");
            return (Criteria) this;
        }

        public Criteria andBmbmLessThanOrEqualTo(String value) {
            addCriterion("BMBM <=", value, "bmbm");
            return (Criteria) this;
        }

        public Criteria andBmbmLike(String value) {
            addCriterion("BMBM like", value, "bmbm");
            return (Criteria) this;
        }

        public Criteria andBmbmNotLike(String value) {
            addCriterion("BMBM not like", value, "bmbm");
            return (Criteria) this;
        }

        public Criteria andBmbmIn(List<String> values) {
            addCriterion("BMBM in", values, "bmbm");
            return (Criteria) this;
        }

        public Criteria andBmbmNotIn(List<String> values) {
            addCriterion("BMBM not in", values, "bmbm");
            return (Criteria) this;
        }

        public Criteria andBmbmBetween(String value1, String value2) {
            addCriterion("BMBM between", value1, value2, "bmbm");
            return (Criteria) this;
        }

        public Criteria andBmbmNotBetween(String value1, String value2) {
            addCriterion("BMBM not between", value1, value2, "bmbm");
            return (Criteria) this;
        }

        public Criteria andGzzhIsNull() {
            addCriterion("GZZH is null");
            return (Criteria) this;
        }

        public Criteria andGzzhIsNotNull() {
            addCriterion("GZZH is not null");
            return (Criteria) this;
        }

        public Criteria andGzzhEqualTo(String value) {
            addCriterion("GZZH =", value, "gzzh");
            return (Criteria) this;
        }

        public Criteria andGzzhNotEqualTo(String value) {
            addCriterion("GZZH <>", value, "gzzh");
            return (Criteria) this;
        }

        public Criteria andGzzhGreaterThan(String value) {
            addCriterion("GZZH >", value, "gzzh");
            return (Criteria) this;
        }

        public Criteria andGzzhGreaterThanOrEqualTo(String value) {
            addCriterion("GZZH >=", value, "gzzh");
            return (Criteria) this;
        }

        public Criteria andGzzhLessThan(String value) {
            addCriterion("GZZH <", value, "gzzh");
            return (Criteria) this;
        }

        public Criteria andGzzhLessThanOrEqualTo(String value) {
            addCriterion("GZZH <=", value, "gzzh");
            return (Criteria) this;
        }

        public Criteria andGzzhLike(String value) {
            addCriterion("GZZH like", value, "gzzh");
            return (Criteria) this;
        }

        public Criteria andGzzhNotLike(String value) {
            addCriterion("GZZH not like", value, "gzzh");
            return (Criteria) this;
        }

        public Criteria andGzzhIn(List<String> values) {
            addCriterion("GZZH in", values, "gzzh");
            return (Criteria) this;
        }

        public Criteria andGzzhNotIn(List<String> values) {
            addCriterion("GZZH not in", values, "gzzh");
            return (Criteria) this;
        }

        public Criteria andGzzhBetween(String value1, String value2) {
            addCriterion("GZZH between", value1, value2, "gzzh");
            return (Criteria) this;
        }

        public Criteria andGzzhNotBetween(String value1, String value2) {
            addCriterion("GZZH not between", value1, value2, "gzzh");
            return (Criteria) this;
        }

        public Criteria andSfzhIsNull() {
            addCriterion("SFZH is null");
            return (Criteria) this;
        }

        public Criteria andSfzhIsNotNull() {
            addCriterion("SFZH is not null");
            return (Criteria) this;
        }

        public Criteria andSfzhEqualTo(String value) {
            addCriterion("SFZH =", value, "sfzh");
            return (Criteria) this;
        }

        public Criteria andSfzhNotEqualTo(String value) {
            addCriterion("SFZH <>", value, "sfzh");
            return (Criteria) this;
        }

        public Criteria andSfzhGreaterThan(String value) {
            addCriterion("SFZH >", value, "sfzh");
            return (Criteria) this;
        }

        public Criteria andSfzhGreaterThanOrEqualTo(String value) {
            addCriterion("SFZH >=", value, "sfzh");
            return (Criteria) this;
        }

        public Criteria andSfzhLessThan(String value) {
            addCriterion("SFZH <", value, "sfzh");
            return (Criteria) this;
        }

        public Criteria andSfzhLessThanOrEqualTo(String value) {
            addCriterion("SFZH <=", value, "sfzh");
            return (Criteria) this;
        }

        public Criteria andSfzhLike(String value) {
            addCriterion("SFZH like", value, "sfzh");
            return (Criteria) this;
        }

        public Criteria andSfzhNotLike(String value) {
            addCriterion("SFZH not like", value, "sfzh");
            return (Criteria) this;
        }

        public Criteria andSfzhIn(List<String> values) {
            addCriterion("SFZH in", values, "sfzh");
            return (Criteria) this;
        }

        public Criteria andSfzhNotIn(List<String> values) {
            addCriterion("SFZH not in", values, "sfzh");
            return (Criteria) this;
        }

        public Criteria andSfzhBetween(String value1, String value2) {
            addCriterion("SFZH between", value1, value2, "sfzh");
            return (Criteria) this;
        }

        public Criteria andSfzhNotBetween(String value1, String value2) {
            addCriterion("SFZH not between", value1, value2, "sfzh");
            return (Criteria) this;
        }

        public Criteria andJgIsNull() {
            addCriterion("JG is null");
            return (Criteria) this;
        }

        public Criteria andJgIsNotNull() {
            addCriterion("JG is not null");
            return (Criteria) this;
        }

        public Criteria andJgEqualTo(String value) {
            addCriterion("JG =", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotEqualTo(String value) {
            addCriterion("JG <>", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgGreaterThan(String value) {
            addCriterion("JG >", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgGreaterThanOrEqualTo(String value) {
            addCriterion("JG >=", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgLessThan(String value) {
            addCriterion("JG <", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgLessThanOrEqualTo(String value) {
            addCriterion("JG <=", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgLike(String value) {
            addCriterion("JG like", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotLike(String value) {
            addCriterion("JG not like", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgIn(List<String> values) {
            addCriterion("JG in", values, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotIn(List<String> values) {
            addCriterion("JG not in", values, "jg");
            return (Criteria) this;
        }

        public Criteria andJgBetween(String value1, String value2) {
            addCriterion("JG between", value1, value2, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotBetween(String value1, String value2) {
            addCriterion("JG not between", value1, value2, "jg");
            return (Criteria) this;
        }

        public Criteria andCsdIsNull() {
            addCriterion("CSD is null");
            return (Criteria) this;
        }

        public Criteria andCsdIsNotNull() {
            addCriterion("CSD is not null");
            return (Criteria) this;
        }

        public Criteria andCsdEqualTo(String value) {
            addCriterion("CSD =", value, "csd");
            return (Criteria) this;
        }

        public Criteria andCsdNotEqualTo(String value) {
            addCriterion("CSD <>", value, "csd");
            return (Criteria) this;
        }

        public Criteria andCsdGreaterThan(String value) {
            addCriterion("CSD >", value, "csd");
            return (Criteria) this;
        }

        public Criteria andCsdGreaterThanOrEqualTo(String value) {
            addCriterion("CSD >=", value, "csd");
            return (Criteria) this;
        }

        public Criteria andCsdLessThan(String value) {
            addCriterion("CSD <", value, "csd");
            return (Criteria) this;
        }

        public Criteria andCsdLessThanOrEqualTo(String value) {
            addCriterion("CSD <=", value, "csd");
            return (Criteria) this;
        }

        public Criteria andCsdLike(String value) {
            addCriterion("CSD like", value, "csd");
            return (Criteria) this;
        }

        public Criteria andCsdNotLike(String value) {
            addCriterion("CSD not like", value, "csd");
            return (Criteria) this;
        }

        public Criteria andCsdIn(List<String> values) {
            addCriterion("CSD in", values, "csd");
            return (Criteria) this;
        }

        public Criteria andCsdNotIn(List<String> values) {
            addCriterion("CSD not in", values, "csd");
            return (Criteria) this;
        }

        public Criteria andCsdBetween(String value1, String value2) {
            addCriterion("CSD between", value1, value2, "csd");
            return (Criteria) this;
        }

        public Criteria andCsdNotBetween(String value1, String value2) {
            addCriterion("CSD not between", value1, value2, "csd");
            return (Criteria) this;
        }

        public Criteria andMzIsNull() {
            addCriterion("MZ is null");
            return (Criteria) this;
        }

        public Criteria andMzIsNotNull() {
            addCriterion("MZ is not null");
            return (Criteria) this;
        }

        public Criteria andMzEqualTo(String value) {
            addCriterion("MZ =", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotEqualTo(String value) {
            addCriterion("MZ <>", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzGreaterThan(String value) {
            addCriterion("MZ >", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzGreaterThanOrEqualTo(String value) {
            addCriterion("MZ >=", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLessThan(String value) {
            addCriterion("MZ <", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLessThanOrEqualTo(String value) {
            addCriterion("MZ <=", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLike(String value) {
            addCriterion("MZ like", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotLike(String value) {
            addCriterion("MZ not like", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzIn(List<String> values) {
            addCriterion("MZ in", values, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotIn(List<String> values) {
            addCriterion("MZ not in", values, "mz");
            return (Criteria) this;
        }

        public Criteria andMzBetween(String value1, String value2) {
            addCriterion("MZ between", value1, value2, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotBetween(String value1, String value2) {
            addCriterion("MZ not between", value1, value2, "mz");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNull() {
            addCriterion("CSRQ is null");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNotNull() {
            addCriterion("CSRQ is not null");
            return (Criteria) this;
        }

        public Criteria andCsrqEqualTo(Date value) {
            addCriterion("CSRQ =", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotEqualTo(Date value) {
            addCriterion("CSRQ <>", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThan(Date value) {
            addCriterion("CSRQ >", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThanOrEqualTo(Date value) {
            addCriterion("CSRQ >=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThan(Date value) {
            addCriterion("CSRQ <", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThanOrEqualTo(Date value) {
            addCriterion("CSRQ <=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqIn(List<Date> values) {
            addCriterion("CSRQ in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotIn(List<Date> values) {
            addCriterion("CSRQ not in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqBetween(Date value1, Date value2) {
            addCriterion("CSRQ between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotBetween(Date value1, Date value2) {
            addCriterion("CSRQ not between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andHkszdIsNull() {
            addCriterion("HKSZD is null");
            return (Criteria) this;
        }

        public Criteria andHkszdIsNotNull() {
            addCriterion("HKSZD is not null");
            return (Criteria) this;
        }

        public Criteria andHkszdEqualTo(String value) {
            addCriterion("HKSZD =", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdNotEqualTo(String value) {
            addCriterion("HKSZD <>", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdGreaterThan(String value) {
            addCriterion("HKSZD >", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdGreaterThanOrEqualTo(String value) {
            addCriterion("HKSZD >=", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdLessThan(String value) {
            addCriterion("HKSZD <", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdLessThanOrEqualTo(String value) {
            addCriterion("HKSZD <=", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdLike(String value) {
            addCriterion("HKSZD like", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdNotLike(String value) {
            addCriterion("HKSZD not like", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdIn(List<String> values) {
            addCriterion("HKSZD in", values, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdNotIn(List<String> values) {
            addCriterion("HKSZD not in", values, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdBetween(String value1, String value2) {
            addCriterion("HKSZD between", value1, value2, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdNotBetween(String value1, String value2) {
            addCriterion("HKSZD not between", value1, value2, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkxzIsNull() {
            addCriterion("HKXZ is null");
            return (Criteria) this;
        }

        public Criteria andHkxzIsNotNull() {
            addCriterion("HKXZ is not null");
            return (Criteria) this;
        }

        public Criteria andHkxzEqualTo(String value) {
            addCriterion("HKXZ =", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzNotEqualTo(String value) {
            addCriterion("HKXZ <>", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzGreaterThan(String value) {
            addCriterion("HKXZ >", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzGreaterThanOrEqualTo(String value) {
            addCriterion("HKXZ >=", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzLessThan(String value) {
            addCriterion("HKXZ <", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzLessThanOrEqualTo(String value) {
            addCriterion("HKXZ <=", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzLike(String value) {
            addCriterion("HKXZ like", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzNotLike(String value) {
            addCriterion("HKXZ not like", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzIn(List<String> values) {
            addCriterion("HKXZ in", values, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzNotIn(List<String> values) {
            addCriterion("HKXZ not in", values, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzBetween(String value1, String value2) {
            addCriterion("HKXZ between", value1, value2, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzNotBetween(String value1, String value2) {
            addCriterion("HKXZ not between", value1, value2, "hkxz");
            return (Criteria) this;
        }

        public Criteria andZzmmIsNull() {
            addCriterion("ZZMM is null");
            return (Criteria) this;
        }

        public Criteria andZzmmIsNotNull() {
            addCriterion("ZZMM is not null");
            return (Criteria) this;
        }

        public Criteria andZzmmEqualTo(String value) {
            addCriterion("ZZMM =", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotEqualTo(String value) {
            addCriterion("ZZMM <>", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmGreaterThan(String value) {
            addCriterion("ZZMM >", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmGreaterThanOrEqualTo(String value) {
            addCriterion("ZZMM >=", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLessThan(String value) {
            addCriterion("ZZMM <", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLessThanOrEqualTo(String value) {
            addCriterion("ZZMM <=", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLike(String value) {
            addCriterion("ZZMM like", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotLike(String value) {
            addCriterion("ZZMM not like", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmIn(List<String> values) {
            addCriterion("ZZMM in", values, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotIn(List<String> values) {
            addCriterion("ZZMM not in", values, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmBetween(String value1, String value2) {
            addCriterion("ZZMM between", value1, value2, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotBetween(String value1, String value2) {
            addCriterion("ZZMM not between", value1, value2, "zzmm");
            return (Criteria) this;
        }

        public Criteria andJrdprqIsNull() {
            addCriterion("JRDPRQ is null");
            return (Criteria) this;
        }

        public Criteria andJrdprqIsNotNull() {
            addCriterion("JRDPRQ is not null");
            return (Criteria) this;
        }

        public Criteria andJrdprqEqualTo(Date value) {
            addCriterion("JRDPRQ =", value, "jrdprq");
            return (Criteria) this;
        }

        public Criteria andJrdprqNotEqualTo(Date value) {
            addCriterion("JRDPRQ <>", value, "jrdprq");
            return (Criteria) this;
        }

        public Criteria andJrdprqGreaterThan(Date value) {
            addCriterion("JRDPRQ >", value, "jrdprq");
            return (Criteria) this;
        }

        public Criteria andJrdprqGreaterThanOrEqualTo(Date value) {
            addCriterion("JRDPRQ >=", value, "jrdprq");
            return (Criteria) this;
        }

        public Criteria andJrdprqLessThan(Date value) {
            addCriterion("JRDPRQ <", value, "jrdprq");
            return (Criteria) this;
        }

        public Criteria andJrdprqLessThanOrEqualTo(Date value) {
            addCriterion("JRDPRQ <=", value, "jrdprq");
            return (Criteria) this;
        }

        public Criteria andJrdprqIn(List<Date> values) {
            addCriterion("JRDPRQ in", values, "jrdprq");
            return (Criteria) this;
        }

        public Criteria andJrdprqNotIn(List<Date> values) {
            addCriterion("JRDPRQ not in", values, "jrdprq");
            return (Criteria) this;
        }

        public Criteria andJrdprqBetween(Date value1, Date value2) {
            addCriterion("JRDPRQ between", value1, value2, "jrdprq");
            return (Criteria) this;
        }

        public Criteria andJrdprqNotBetween(Date value1, Date value2) {
            addCriterion("JRDPRQ not between", value1, value2, "jrdprq");
            return (Criteria) this;
        }

        public Criteria andJkqkIsNull() {
            addCriterion("JKQK is null");
            return (Criteria) this;
        }

        public Criteria andJkqkIsNotNull() {
            addCriterion("JKQK is not null");
            return (Criteria) this;
        }

        public Criteria andJkqkEqualTo(String value) {
            addCriterion("JKQK =", value, "jkqk");
            return (Criteria) this;
        }

        public Criteria andJkqkNotEqualTo(String value) {
            addCriterion("JKQK <>", value, "jkqk");
            return (Criteria) this;
        }

        public Criteria andJkqkGreaterThan(String value) {
            addCriterion("JKQK >", value, "jkqk");
            return (Criteria) this;
        }

        public Criteria andJkqkGreaterThanOrEqualTo(String value) {
            addCriterion("JKQK >=", value, "jkqk");
            return (Criteria) this;
        }

        public Criteria andJkqkLessThan(String value) {
            addCriterion("JKQK <", value, "jkqk");
            return (Criteria) this;
        }

        public Criteria andJkqkLessThanOrEqualTo(String value) {
            addCriterion("JKQK <=", value, "jkqk");
            return (Criteria) this;
        }

        public Criteria andJkqkLike(String value) {
            addCriterion("JKQK like", value, "jkqk");
            return (Criteria) this;
        }

        public Criteria andJkqkNotLike(String value) {
            addCriterion("JKQK not like", value, "jkqk");
            return (Criteria) this;
        }

        public Criteria andJkqkIn(List<String> values) {
            addCriterion("JKQK in", values, "jkqk");
            return (Criteria) this;
        }

        public Criteria andJkqkNotIn(List<String> values) {
            addCriterion("JKQK not in", values, "jkqk");
            return (Criteria) this;
        }

        public Criteria andJkqkBetween(String value1, String value2) {
            addCriterion("JKQK between", value1, value2, "jkqk");
            return (Criteria) this;
        }

        public Criteria andJkqkNotBetween(String value1, String value2) {
            addCriterion("JKQK not between", value1, value2, "jkqk");
            return (Criteria) this;
        }

        public Criteria andHyzkIsNull() {
            addCriterion("HYZK is null");
            return (Criteria) this;
        }

        public Criteria andHyzkIsNotNull() {
            addCriterion("HYZK is not null");
            return (Criteria) this;
        }

        public Criteria andHyzkEqualTo(String value) {
            addCriterion("HYZK =", value, "hyzk");
            return (Criteria) this;
        }

        public Criteria andHyzkNotEqualTo(String value) {
            addCriterion("HYZK <>", value, "hyzk");
            return (Criteria) this;
        }

        public Criteria andHyzkGreaterThan(String value) {
            addCriterion("HYZK >", value, "hyzk");
            return (Criteria) this;
        }

        public Criteria andHyzkGreaterThanOrEqualTo(String value) {
            addCriterion("HYZK >=", value, "hyzk");
            return (Criteria) this;
        }

        public Criteria andHyzkLessThan(String value) {
            addCriterion("HYZK <", value, "hyzk");
            return (Criteria) this;
        }

        public Criteria andHyzkLessThanOrEqualTo(String value) {
            addCriterion("HYZK <=", value, "hyzk");
            return (Criteria) this;
        }

        public Criteria andHyzkLike(String value) {
            addCriterion("HYZK like", value, "hyzk");
            return (Criteria) this;
        }

        public Criteria andHyzkNotLike(String value) {
            addCriterion("HYZK not like", value, "hyzk");
            return (Criteria) this;
        }

        public Criteria andHyzkIn(List<String> values) {
            addCriterion("HYZK in", values, "hyzk");
            return (Criteria) this;
        }

        public Criteria andHyzkNotIn(List<String> values) {
            addCriterion("HYZK not in", values, "hyzk");
            return (Criteria) this;
        }

        public Criteria andHyzkBetween(String value1, String value2) {
            addCriterion("HYZK between", value1, value2, "hyzk");
            return (Criteria) this;
        }

        public Criteria andHyzkNotBetween(String value1, String value2) {
            addCriterion("HYZK not between", value1, value2, "hyzk");
            return (Criteria) this;
        }

        public Criteria andCjgzrqIsNull() {
            addCriterion("CJGZRQ is null");
            return (Criteria) this;
        }

        public Criteria andCjgzrqIsNotNull() {
            addCriterion("CJGZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andCjgzrqEqualTo(Date value) {
            addCriterion("CJGZRQ =", value, "cjgzrq");
            return (Criteria) this;
        }

        public Criteria andCjgzrqNotEqualTo(Date value) {
            addCriterion("CJGZRQ <>", value, "cjgzrq");
            return (Criteria) this;
        }

        public Criteria andCjgzrqGreaterThan(Date value) {
            addCriterion("CJGZRQ >", value, "cjgzrq");
            return (Criteria) this;
        }

        public Criteria andCjgzrqGreaterThanOrEqualTo(Date value) {
            addCriterion("CJGZRQ >=", value, "cjgzrq");
            return (Criteria) this;
        }

        public Criteria andCjgzrqLessThan(Date value) {
            addCriterion("CJGZRQ <", value, "cjgzrq");
            return (Criteria) this;
        }

        public Criteria andCjgzrqLessThanOrEqualTo(Date value) {
            addCriterion("CJGZRQ <=", value, "cjgzrq");
            return (Criteria) this;
        }

        public Criteria andCjgzrqIn(List<Date> values) {
            addCriterion("CJGZRQ in", values, "cjgzrq");
            return (Criteria) this;
        }

        public Criteria andCjgzrqNotIn(List<Date> values) {
            addCriterion("CJGZRQ not in", values, "cjgzrq");
            return (Criteria) this;
        }

        public Criteria andCjgzrqBetween(Date value1, Date value2) {
            addCriterion("CJGZRQ between", value1, value2, "cjgzrq");
            return (Criteria) this;
        }

        public Criteria andCjgzrqNotBetween(Date value1, Date value2) {
            addCriterion("CJGZRQ not between", value1, value2, "cjgzrq");
            return (Criteria) this;
        }

        public Criteria andRlgzrqIsNull() {
            addCriterion("RLGZRQ is null");
            return (Criteria) this;
        }

        public Criteria andRlgzrqIsNotNull() {
            addCriterion("RLGZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andRlgzrqEqualTo(Date value) {
            addCriterion("RLGZRQ =", value, "rlgzrq");
            return (Criteria) this;
        }

        public Criteria andRlgzrqNotEqualTo(Date value) {
            addCriterion("RLGZRQ <>", value, "rlgzrq");
            return (Criteria) this;
        }

        public Criteria andRlgzrqGreaterThan(Date value) {
            addCriterion("RLGZRQ >", value, "rlgzrq");
            return (Criteria) this;
        }

        public Criteria andRlgzrqGreaterThanOrEqualTo(Date value) {
            addCriterion("RLGZRQ >=", value, "rlgzrq");
            return (Criteria) this;
        }

        public Criteria andRlgzrqLessThan(Date value) {
            addCriterion("RLGZRQ <", value, "rlgzrq");
            return (Criteria) this;
        }

        public Criteria andRlgzrqLessThanOrEqualTo(Date value) {
            addCriterion("RLGZRQ <=", value, "rlgzrq");
            return (Criteria) this;
        }

        public Criteria andRlgzrqIn(List<Date> values) {
            addCriterion("RLGZRQ in", values, "rlgzrq");
            return (Criteria) this;
        }

        public Criteria andRlgzrqNotIn(List<Date> values) {
            addCriterion("RLGZRQ not in", values, "rlgzrq");
            return (Criteria) this;
        }

        public Criteria andRlgzrqBetween(Date value1, Date value2) {
            addCriterion("RLGZRQ between", value1, value2, "rlgzrq");
            return (Criteria) this;
        }

        public Criteria andRlgzrqNotBetween(Date value1, Date value2) {
            addCriterion("RLGZRQ not between", value1, value2, "rlgzrq");
            return (Criteria) this;
        }

        public Criteria andGljzzIsNull() {
            addCriterion("GLJZZ is null");
            return (Criteria) this;
        }

        public Criteria andGljzzIsNotNull() {
            addCriterion("GLJZZ is not null");
            return (Criteria) this;
        }

        public Criteria andGljzzEqualTo(Integer value) {
            addCriterion("GLJZZ =", value, "gljzz");
            return (Criteria) this;
        }

        public Criteria andGljzzNotEqualTo(Integer value) {
            addCriterion("GLJZZ <>", value, "gljzz");
            return (Criteria) this;
        }

        public Criteria andGljzzGreaterThan(Integer value) {
            addCriterion("GLJZZ >", value, "gljzz");
            return (Criteria) this;
        }

        public Criteria andGljzzGreaterThanOrEqualTo(Integer value) {
            addCriterion("GLJZZ >=", value, "gljzz");
            return (Criteria) this;
        }

        public Criteria andGljzzLessThan(Integer value) {
            addCriterion("GLJZZ <", value, "gljzz");
            return (Criteria) this;
        }

        public Criteria andGljzzLessThanOrEqualTo(Integer value) {
            addCriterion("GLJZZ <=", value, "gljzz");
            return (Criteria) this;
        }

        public Criteria andGljzzIn(List<Integer> values) {
            addCriterion("GLJZZ in", values, "gljzz");
            return (Criteria) this;
        }

        public Criteria andGljzzNotIn(List<Integer> values) {
            addCriterion("GLJZZ not in", values, "gljzz");
            return (Criteria) this;
        }

        public Criteria andGljzzBetween(Integer value1, Integer value2) {
            addCriterion("GLJZZ between", value1, value2, "gljzz");
            return (Criteria) this;
        }

        public Criteria andGljzzNotBetween(Integer value1, Integer value2) {
            addCriterion("GLJZZ not between", value1, value2, "gljzz");
            return (Criteria) this;
        }

        public Criteria andQrzxlIsNull() {
            addCriterion("QRZXL is null");
            return (Criteria) this;
        }

        public Criteria andQrzxlIsNotNull() {
            addCriterion("QRZXL is not null");
            return (Criteria) this;
        }

        public Criteria andQrzxlEqualTo(String value) {
            addCriterion("QRZXL =", value, "qrzxl");
            return (Criteria) this;
        }

        public Criteria andQrzxlNotEqualTo(String value) {
            addCriterion("QRZXL <>", value, "qrzxl");
            return (Criteria) this;
        }

        public Criteria andQrzxlGreaterThan(String value) {
            addCriterion("QRZXL >", value, "qrzxl");
            return (Criteria) this;
        }

        public Criteria andQrzxlGreaterThanOrEqualTo(String value) {
            addCriterion("QRZXL >=", value, "qrzxl");
            return (Criteria) this;
        }

        public Criteria andQrzxlLessThan(String value) {
            addCriterion("QRZXL <", value, "qrzxl");
            return (Criteria) this;
        }

        public Criteria andQrzxlLessThanOrEqualTo(String value) {
            addCriterion("QRZXL <=", value, "qrzxl");
            return (Criteria) this;
        }

        public Criteria andQrzxlLike(String value) {
            addCriterion("QRZXL like", value, "qrzxl");
            return (Criteria) this;
        }

        public Criteria andQrzxlNotLike(String value) {
            addCriterion("QRZXL not like", value, "qrzxl");
            return (Criteria) this;
        }

        public Criteria andQrzxlIn(List<String> values) {
            addCriterion("QRZXL in", values, "qrzxl");
            return (Criteria) this;
        }

        public Criteria andQrzxlNotIn(List<String> values) {
            addCriterion("QRZXL not in", values, "qrzxl");
            return (Criteria) this;
        }

        public Criteria andQrzxlBetween(String value1, String value2) {
            addCriterion("QRZXL between", value1, value2, "qrzxl");
            return (Criteria) this;
        }

        public Criteria andQrzxlNotBetween(String value1, String value2) {
            addCriterion("QRZXL not between", value1, value2, "qrzxl");
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

        public Criteria andZwjbIsNull() {
            addCriterion("ZWJB is null");
            return (Criteria) this;
        }

        public Criteria andZwjbIsNotNull() {
            addCriterion("ZWJB is not null");
            return (Criteria) this;
        }

        public Criteria andZwjbEqualTo(String value) {
            addCriterion("ZWJB =", value, "zwjb");
            return (Criteria) this;
        }

        public Criteria andZwjbNotEqualTo(String value) {
            addCriterion("ZWJB <>", value, "zwjb");
            return (Criteria) this;
        }

        public Criteria andZwjbGreaterThan(String value) {
            addCriterion("ZWJB >", value, "zwjb");
            return (Criteria) this;
        }

        public Criteria andZwjbGreaterThanOrEqualTo(String value) {
            addCriterion("ZWJB >=", value, "zwjb");
            return (Criteria) this;
        }

        public Criteria andZwjbLessThan(String value) {
            addCriterion("ZWJB <", value, "zwjb");
            return (Criteria) this;
        }

        public Criteria andZwjbLessThanOrEqualTo(String value) {
            addCriterion("ZWJB <=", value, "zwjb");
            return (Criteria) this;
        }

        public Criteria andZwjbLike(String value) {
            addCriterion("ZWJB like", value, "zwjb");
            return (Criteria) this;
        }

        public Criteria andZwjbNotLike(String value) {
            addCriterion("ZWJB not like", value, "zwjb");
            return (Criteria) this;
        }

        public Criteria andZwjbIn(List<String> values) {
            addCriterion("ZWJB in", values, "zwjb");
            return (Criteria) this;
        }

        public Criteria andZwjbNotIn(List<String> values) {
            addCriterion("ZWJB not in", values, "zwjb");
            return (Criteria) this;
        }

        public Criteria andZwjbBetween(String value1, String value2) {
            addCriterion("ZWJB between", value1, value2, "zwjb");
            return (Criteria) this;
        }

        public Criteria andZwjbNotBetween(String value1, String value2) {
            addCriterion("ZWJB not between", value1, value2, "zwjb");
            return (Criteria) this;
        }

        public Criteria andXjszwmcIsNull() {
            addCriterion("XJSZWMC is null");
            return (Criteria) this;
        }

        public Criteria andXjszwmcIsNotNull() {
            addCriterion("XJSZWMC is not null");
            return (Criteria) this;
        }

        public Criteria andXjszwmcEqualTo(String value) {
            addCriterion("XJSZWMC =", value, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andXjszwmcNotEqualTo(String value) {
            addCriterion("XJSZWMC <>", value, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andXjszwmcGreaterThan(String value) {
            addCriterion("XJSZWMC >", value, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andXjszwmcGreaterThanOrEqualTo(String value) {
            addCriterion("XJSZWMC >=", value, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andXjszwmcLessThan(String value) {
            addCriterion("XJSZWMC <", value, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andXjszwmcLessThanOrEqualTo(String value) {
            addCriterion("XJSZWMC <=", value, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andXjszwmcLike(String value) {
            addCriterion("XJSZWMC like", value, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andXjszwmcNotLike(String value) {
            addCriterion("XJSZWMC not like", value, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andXjszwmcIn(List<String> values) {
            addCriterion("XJSZWMC in", values, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andXjszwmcNotIn(List<String> values) {
            addCriterion("XJSZWMC not in", values, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andXjszwmcBetween(String value1, String value2) {
            addCriterion("XJSZWMC between", value1, value2, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andXjszwmcNotBetween(String value1, String value2) {
            addCriterion("XJSZWMC not between", value1, value2, "xjszwmc");
            return (Criteria) this;
        }

        public Criteria andRylbIsNull() {
            addCriterion("RYLB is null");
            return (Criteria) this;
        }

        public Criteria andRylbIsNotNull() {
            addCriterion("RYLB is not null");
            return (Criteria) this;
        }

        public Criteria andRylbEqualTo(String value) {
            addCriterion("RYLB =", value, "rylb");
            return (Criteria) this;
        }

        public Criteria andRylbNotEqualTo(String value) {
            addCriterion("RYLB <>", value, "rylb");
            return (Criteria) this;
        }

        public Criteria andRylbGreaterThan(String value) {
            addCriterion("RYLB >", value, "rylb");
            return (Criteria) this;
        }

        public Criteria andRylbGreaterThanOrEqualTo(String value) {
            addCriterion("RYLB >=", value, "rylb");
            return (Criteria) this;
        }

        public Criteria andRylbLessThan(String value) {
            addCriterion("RYLB <", value, "rylb");
            return (Criteria) this;
        }

        public Criteria andRylbLessThanOrEqualTo(String value) {
            addCriterion("RYLB <=", value, "rylb");
            return (Criteria) this;
        }

        public Criteria andRylbLike(String value) {
            addCriterion("RYLB like", value, "rylb");
            return (Criteria) this;
        }

        public Criteria andRylbNotLike(String value) {
            addCriterion("RYLB not like", value, "rylb");
            return (Criteria) this;
        }

        public Criteria andRylbIn(List<String> values) {
            addCriterion("RYLB in", values, "rylb");
            return (Criteria) this;
        }

        public Criteria andRylbNotIn(List<String> values) {
            addCriterion("RYLB not in", values, "rylb");
            return (Criteria) this;
        }

        public Criteria andRylbBetween(String value1, String value2) {
            addCriterion("RYLB between", value1, value2, "rylb");
            return (Criteria) this;
        }

        public Criteria andRylbNotBetween(String value1, String value2) {
            addCriterion("RYLB not between", value1, value2, "rylb");
            return (Criteria) this;
        }

        public Criteria andGwsxIsNull() {
            addCriterion("GWSX is null");
            return (Criteria) this;
        }

        public Criteria andGwsxIsNotNull() {
            addCriterion("GWSX is not null");
            return (Criteria) this;
        }

        public Criteria andGwsxEqualTo(String value) {
            addCriterion("GWSX =", value, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGwsxNotEqualTo(String value) {
            addCriterion("GWSX <>", value, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGwsxGreaterThan(String value) {
            addCriterion("GWSX >", value, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGwsxGreaterThanOrEqualTo(String value) {
            addCriterion("GWSX >=", value, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGwsxLessThan(String value) {
            addCriterion("GWSX <", value, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGwsxLessThanOrEqualTo(String value) {
            addCriterion("GWSX <=", value, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGwsxLike(String value) {
            addCriterion("GWSX like", value, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGwsxNotLike(String value) {
            addCriterion("GWSX not like", value, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGwsxIn(List<String> values) {
            addCriterion("GWSX in", values, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGwsxNotIn(List<String> values) {
            addCriterion("GWSX not in", values, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGwsxBetween(String value1, String value2) {
            addCriterion("GWSX between", value1, value2, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGwsxNotBetween(String value1, String value2) {
            addCriterion("GWSX not between", value1, value2, "gwsx");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflIsNull() {
            addCriterion("GMJJHYFL is null");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflIsNotNull() {
            addCriterion("GMJJHYFL is not null");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflEqualTo(String value) {
            addCriterion("GMJJHYFL =", value, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflNotEqualTo(String value) {
            addCriterion("GMJJHYFL <>", value, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflGreaterThan(String value) {
            addCriterion("GMJJHYFL >", value, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflGreaterThanOrEqualTo(String value) {
            addCriterion("GMJJHYFL >=", value, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflLessThan(String value) {
            addCriterion("GMJJHYFL <", value, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflLessThanOrEqualTo(String value) {
            addCriterion("GMJJHYFL <=", value, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflLike(String value) {
            addCriterion("GMJJHYFL like", value, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflNotLike(String value) {
            addCriterion("GMJJHYFL not like", value, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflIn(List<String> values) {
            addCriterion("GMJJHYFL in", values, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflNotIn(List<String> values) {
            addCriterion("GMJJHYFL not in", values, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflBetween(String value1, String value2) {
            addCriterion("GMJJHYFL between", value1, value2, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andGmjjhyflNotBetween(String value1, String value2) {
            addCriterion("GMJJHYFL not between", value1, value2, "gmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflIsNull() {
            addCriterion("ZZGMJJHYFL is null");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflIsNotNull() {
            addCriterion("ZZGMJJHYFL is not null");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflEqualTo(String value) {
            addCriterion("ZZGMJJHYFL =", value, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflNotEqualTo(String value) {
            addCriterion("ZZGMJJHYFL <>", value, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflGreaterThan(String value) {
            addCriterion("ZZGMJJHYFL >", value, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflGreaterThanOrEqualTo(String value) {
            addCriterion("ZZGMJJHYFL >=", value, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflLessThan(String value) {
            addCriterion("ZZGMJJHYFL <", value, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflLessThanOrEqualTo(String value) {
            addCriterion("ZZGMJJHYFL <=", value, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflLike(String value) {
            addCriterion("ZZGMJJHYFL like", value, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflNotLike(String value) {
            addCriterion("ZZGMJJHYFL not like", value, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflIn(List<String> values) {
            addCriterion("ZZGMJJHYFL in", values, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflNotIn(List<String> values) {
            addCriterion("ZZGMJJHYFL not in", values, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflBetween(String value1, String value2) {
            addCriterion("ZZGMJJHYFL between", value1, value2, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZzgmjjhyflNotBetween(String value1, String value2) {
            addCriterion("ZZGMJJHYFL not between", value1, value2, "zzgmjjhyfl");
            return (Criteria) this;
        }

        public Criteria andZjgblxIsNull() {
            addCriterion("ZJGBLX is null");
            return (Criteria) this;
        }

        public Criteria andZjgblxIsNotNull() {
            addCriterion("ZJGBLX is not null");
            return (Criteria) this;
        }

        public Criteria andZjgblxEqualTo(String value) {
            addCriterion("ZJGBLX =", value, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andZjgblxNotEqualTo(String value) {
            addCriterion("ZJGBLX <>", value, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andZjgblxGreaterThan(String value) {
            addCriterion("ZJGBLX >", value, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andZjgblxGreaterThanOrEqualTo(String value) {
            addCriterion("ZJGBLX >=", value, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andZjgblxLessThan(String value) {
            addCriterion("ZJGBLX <", value, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andZjgblxLessThanOrEqualTo(String value) {
            addCriterion("ZJGBLX <=", value, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andZjgblxLike(String value) {
            addCriterion("ZJGBLX like", value, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andZjgblxNotLike(String value) {
            addCriterion("ZJGBLX not like", value, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andZjgblxIn(List<String> values) {
            addCriterion("ZJGBLX in", values, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andZjgblxNotIn(List<String> values) {
            addCriterion("ZJGBLX not in", values, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andZjgblxBetween(String value1, String value2) {
            addCriterion("ZJGBLX between", value1, value2, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andZjgblxNotBetween(String value1, String value2) {
            addCriterion("ZJGBLX not between", value1, value2, "zjgblx");
            return (Criteria) this;
        }

        public Criteria andJbfhbsIsNull() {
            addCriterion("JBFHBS is null");
            return (Criteria) this;
        }

        public Criteria andJbfhbsIsNotNull() {
            addCriterion("JBFHBS is not null");
            return (Criteria) this;
        }

        public Criteria andJbfhbsEqualTo(String value) {
            addCriterion("JBFHBS =", value, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andJbfhbsNotEqualTo(String value) {
            addCriterion("JBFHBS <>", value, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andJbfhbsGreaterThan(String value) {
            addCriterion("JBFHBS >", value, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andJbfhbsGreaterThanOrEqualTo(String value) {
            addCriterion("JBFHBS >=", value, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andJbfhbsLessThan(String value) {
            addCriterion("JBFHBS <", value, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andJbfhbsLessThanOrEqualTo(String value) {
            addCriterion("JBFHBS <=", value, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andJbfhbsLike(String value) {
            addCriterion("JBFHBS like", value, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andJbfhbsNotLike(String value) {
            addCriterion("JBFHBS not like", value, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andJbfhbsIn(List<String> values) {
            addCriterion("JBFHBS in", values, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andJbfhbsNotIn(List<String> values) {
            addCriterion("JBFHBS not in", values, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andJbfhbsBetween(String value1, String value2) {
            addCriterion("JBFHBS between", value1, value2, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andJbfhbsNotBetween(String value1, String value2) {
            addCriterion("JBFHBS not between", value1, value2, "jbfhbs");
            return (Criteria) this;
        }

        public Criteria andFyrybsIsNull() {
            addCriterion("FYRYBS is null");
            return (Criteria) this;
        }

        public Criteria andFyrybsIsNotNull() {
            addCriterion("FYRYBS is not null");
            return (Criteria) this;
        }

        public Criteria andFyrybsEqualTo(String value) {
            addCriterion("FYRYBS =", value, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andFyrybsNotEqualTo(String value) {
            addCriterion("FYRYBS <>", value, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andFyrybsGreaterThan(String value) {
            addCriterion("FYRYBS >", value, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andFyrybsGreaterThanOrEqualTo(String value) {
            addCriterion("FYRYBS >=", value, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andFyrybsLessThan(String value) {
            addCriterion("FYRYBS <", value, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andFyrybsLessThanOrEqualTo(String value) {
            addCriterion("FYRYBS <=", value, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andFyrybsLike(String value) {
            addCriterion("FYRYBS like", value, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andFyrybsNotLike(String value) {
            addCriterion("FYRYBS not like", value, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andFyrybsIn(List<String> values) {
            addCriterion("FYRYBS in", values, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andFyrybsNotIn(List<String> values) {
            addCriterion("FYRYBS not in", values, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andFyrybsBetween(String value1, String value2) {
            addCriterion("FYRYBS between", value1, value2, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andFyrybsNotBetween(String value1, String value2) {
            addCriterion("FYRYBS not between", value1, value2, "fyrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsIsNull() {
            addCriterion("EXRYBS is null");
            return (Criteria) this;
        }

        public Criteria andExrybsIsNotNull() {
            addCriterion("EXRYBS is not null");
            return (Criteria) this;
        }

        public Criteria andExrybsEqualTo(String value) {
            addCriterion("EXRYBS =", value, "exrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsNotEqualTo(String value) {
            addCriterion("EXRYBS <>", value, "exrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsGreaterThan(String value) {
            addCriterion("EXRYBS >", value, "exrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsGreaterThanOrEqualTo(String value) {
            addCriterion("EXRYBS >=", value, "exrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsLessThan(String value) {
            addCriterion("EXRYBS <", value, "exrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsLessThanOrEqualTo(String value) {
            addCriterion("EXRYBS <=", value, "exrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsLike(String value) {
            addCriterion("EXRYBS like", value, "exrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsNotLike(String value) {
            addCriterion("EXRYBS not like", value, "exrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsIn(List<String> values) {
            addCriterion("EXRYBS in", values, "exrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsNotIn(List<String> values) {
            addCriterion("EXRYBS not in", values, "exrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsBetween(String value1, String value2) {
            addCriterion("EXRYBS between", value1, value2, "exrybs");
            return (Criteria) this;
        }

        public Criteria andExrybsNotBetween(String value1, String value2) {
            addCriterion("EXRYBS not between", value1, value2, "exrybs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsIsNull() {
            addCriterion("GBGRBS is null");
            return (Criteria) this;
        }

        public Criteria andGbgrbsIsNotNull() {
            addCriterion("GBGRBS is not null");
            return (Criteria) this;
        }

        public Criteria andGbgrbsEqualTo(String value) {
            addCriterion("GBGRBS =", value, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsNotEqualTo(String value) {
            addCriterion("GBGRBS <>", value, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsGreaterThan(String value) {
            addCriterion("GBGRBS >", value, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsGreaterThanOrEqualTo(String value) {
            addCriterion("GBGRBS >=", value, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsLessThan(String value) {
            addCriterion("GBGRBS <", value, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsLessThanOrEqualTo(String value) {
            addCriterion("GBGRBS <=", value, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsLike(String value) {
            addCriterion("GBGRBS like", value, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsNotLike(String value) {
            addCriterion("GBGRBS not like", value, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsIn(List<String> values) {
            addCriterion("GBGRBS in", values, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsNotIn(List<String> values) {
            addCriterion("GBGRBS not in", values, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsBetween(String value1, String value2) {
            addCriterion("GBGRBS between", value1, value2, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andGbgrbsNotBetween(String value1, String value2) {
            addCriterion("GBGRBS not between", value1, value2, "gbgrbs");
            return (Criteria) this;
        }

        public Criteria andDgbhIsNull() {
            addCriterion("DGBH is null");
            return (Criteria) this;
        }

        public Criteria andDgbhIsNotNull() {
            addCriterion("DGBH is not null");
            return (Criteria) this;
        }

        public Criteria andDgbhEqualTo(String value) {
            addCriterion("DGBH =", value, "dgbh");
            return (Criteria) this;
        }

        public Criteria andDgbhNotEqualTo(String value) {
            addCriterion("DGBH <>", value, "dgbh");
            return (Criteria) this;
        }

        public Criteria andDgbhGreaterThan(String value) {
            addCriterion("DGBH >", value, "dgbh");
            return (Criteria) this;
        }

        public Criteria andDgbhGreaterThanOrEqualTo(String value) {
            addCriterion("DGBH >=", value, "dgbh");
            return (Criteria) this;
        }

        public Criteria andDgbhLessThan(String value) {
            addCriterion("DGBH <", value, "dgbh");
            return (Criteria) this;
        }

        public Criteria andDgbhLessThanOrEqualTo(String value) {
            addCriterion("DGBH <=", value, "dgbh");
            return (Criteria) this;
        }

        public Criteria andDgbhLike(String value) {
            addCriterion("DGBH like", value, "dgbh");
            return (Criteria) this;
        }

        public Criteria andDgbhNotLike(String value) {
            addCriterion("DGBH not like", value, "dgbh");
            return (Criteria) this;
        }

        public Criteria andDgbhIn(List<String> values) {
            addCriterion("DGBH in", values, "dgbh");
            return (Criteria) this;
        }

        public Criteria andDgbhNotIn(List<String> values) {
            addCriterion("DGBH not in", values, "dgbh");
            return (Criteria) this;
        }

        public Criteria andDgbhBetween(String value1, String value2) {
            addCriterion("DGBH between", value1, value2, "dgbh");
            return (Criteria) this;
        }

        public Criteria andDgbhNotBetween(String value1, String value2) {
            addCriterion("DGBH not between", value1, value2, "dgbh");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("BZ is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("BZ is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("BZ =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("BZ <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("BZ >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("BZ >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("BZ <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("BZ <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("BZ like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("BZ not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("BZ in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("BZ not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("BZ between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("BZ not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andTbflagIsNull() {
            addCriterion("TBFLAG is null");
            return (Criteria) this;
        }

        public Criteria andTbflagIsNotNull() {
            addCriterion("TBFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andTbflagEqualTo(String value) {
            addCriterion("TBFLAG =", value, "tbflag");
            return (Criteria) this;
        }

        public Criteria andTbflagNotEqualTo(String value) {
            addCriterion("TBFLAG <>", value, "tbflag");
            return (Criteria) this;
        }

        public Criteria andTbflagGreaterThan(String value) {
            addCriterion("TBFLAG >", value, "tbflag");
            return (Criteria) this;
        }

        public Criteria andTbflagGreaterThanOrEqualTo(String value) {
            addCriterion("TBFLAG >=", value, "tbflag");
            return (Criteria) this;
        }

        public Criteria andTbflagLessThan(String value) {
            addCriterion("TBFLAG <", value, "tbflag");
            return (Criteria) this;
        }

        public Criteria andTbflagLessThanOrEqualTo(String value) {
            addCriterion("TBFLAG <=", value, "tbflag");
            return (Criteria) this;
        }

        public Criteria andTbflagLike(String value) {
            addCriterion("TBFLAG like", value, "tbflag");
            return (Criteria) this;
        }

        public Criteria andTbflagNotLike(String value) {
            addCriterion("TBFLAG not like", value, "tbflag");
            return (Criteria) this;
        }

        public Criteria andTbflagIn(List<String> values) {
            addCriterion("TBFLAG in", values, "tbflag");
            return (Criteria) this;
        }

        public Criteria andTbflagNotIn(List<String> values) {
            addCriterion("TBFLAG not in", values, "tbflag");
            return (Criteria) this;
        }

        public Criteria andTbflagBetween(String value1, String value2) {
            addCriterion("TBFLAG between", value1, value2, "tbflag");
            return (Criteria) this;
        }

        public Criteria andTbflagNotBetween(String value1, String value2) {
            addCriterion("TBFLAG not between", value1, value2, "tbflag");
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

        public Criteria andYl06IsNull() {
            addCriterion("YL06 is null");
            return (Criteria) this;
        }

        public Criteria andYl06IsNotNull() {
            addCriterion("YL06 is not null");
            return (Criteria) this;
        }

        public Criteria andYl06EqualTo(String value) {
            addCriterion("YL06 =", value, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl06NotEqualTo(String value) {
            addCriterion("YL06 <>", value, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl06GreaterThan(String value) {
            addCriterion("YL06 >", value, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl06GreaterThanOrEqualTo(String value) {
            addCriterion("YL06 >=", value, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl06LessThan(String value) {
            addCriterion("YL06 <", value, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl06LessThanOrEqualTo(String value) {
            addCriterion("YL06 <=", value, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl06Like(String value) {
            addCriterion("YL06 like", value, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl06NotLike(String value) {
            addCriterion("YL06 not like", value, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl06In(List<String> values) {
            addCriterion("YL06 in", values, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl06NotIn(List<String> values) {
            addCriterion("YL06 not in", values, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl06Between(String value1, String value2) {
            addCriterion("YL06 between", value1, value2, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl06NotBetween(String value1, String value2) {
            addCriterion("YL06 not between", value1, value2, "yl06");
            return (Criteria) this;
        }

        public Criteria andYl07IsNull() {
            addCriterion("YL07 is null");
            return (Criteria) this;
        }

        public Criteria andYl07IsNotNull() {
            addCriterion("YL07 is not null");
            return (Criteria) this;
        }

        public Criteria andYl07EqualTo(String value) {
            addCriterion("YL07 =", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07NotEqualTo(String value) {
            addCriterion("YL07 <>", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07GreaterThan(String value) {
            addCriterion("YL07 >", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07GreaterThanOrEqualTo(String value) {
            addCriterion("YL07 >=", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07LessThan(String value) {
            addCriterion("YL07 <", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07LessThanOrEqualTo(String value) {
            addCriterion("YL07 <=", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07Like(String value) {
            addCriterion("YL07 like", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07NotLike(String value) {
            addCriterion("YL07 not like", value, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07In(List<String> values) {
            addCriterion("YL07 in", values, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07NotIn(List<String> values) {
            addCriterion("YL07 not in", values, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07Between(String value1, String value2) {
            addCriterion("YL07 between", value1, value2, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl07NotBetween(String value1, String value2) {
            addCriterion("YL07 not between", value1, value2, "yl07");
            return (Criteria) this;
        }

        public Criteria andYl08IsNull() {
            addCriterion("YL08 is null");
            return (Criteria) this;
        }

        public Criteria andYl08IsNotNull() {
            addCriterion("YL08 is not null");
            return (Criteria) this;
        }

        public Criteria andYl08EqualTo(String value) {
            addCriterion("YL08 =", value, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl08NotEqualTo(String value) {
            addCriterion("YL08 <>", value, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl08GreaterThan(String value) {
            addCriterion("YL08 >", value, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl08GreaterThanOrEqualTo(String value) {
            addCriterion("YL08 >=", value, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl08LessThan(String value) {
            addCriterion("YL08 <", value, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl08LessThanOrEqualTo(String value) {
            addCriterion("YL08 <=", value, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl08Like(String value) {
            addCriterion("YL08 like", value, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl08NotLike(String value) {
            addCriterion("YL08 not like", value, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl08In(List<String> values) {
            addCriterion("YL08 in", values, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl08NotIn(List<String> values) {
            addCriterion("YL08 not in", values, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl08Between(String value1, String value2) {
            addCriterion("YL08 between", value1, value2, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl08NotBetween(String value1, String value2) {
            addCriterion("YL08 not between", value1, value2, "yl08");
            return (Criteria) this;
        }

        public Criteria andYl09IsNull() {
            addCriterion("YL09 is null");
            return (Criteria) this;
        }

        public Criteria andYl09IsNotNull() {
            addCriterion("YL09 is not null");
            return (Criteria) this;
        }

        public Criteria andYl09EqualTo(Date value) {
            addCriterion("YL09 =", value, "yl09");
            return (Criteria) this;
        }

        public Criteria andYl09NotEqualTo(Date value) {
            addCriterion("YL09 <>", value, "yl09");
            return (Criteria) this;
        }

        public Criteria andYl09GreaterThan(Date value) {
            addCriterion("YL09 >", value, "yl09");
            return (Criteria) this;
        }

        public Criteria andYl09GreaterThanOrEqualTo(Date value) {
            addCriterion("YL09 >=", value, "yl09");
            return (Criteria) this;
        }

        public Criteria andYl09LessThan(Date value) {
            addCriterion("YL09 <", value, "yl09");
            return (Criteria) this;
        }

        public Criteria andYl09LessThanOrEqualTo(Date value) {
            addCriterion("YL09 <=", value, "yl09");
            return (Criteria) this;
        }

        public Criteria andYl09In(List<Date> values) {
            addCriterion("YL09 in", values, "yl09");
            return (Criteria) this;
        }

        public Criteria andYl09NotIn(List<Date> values) {
            addCriterion("YL09 not in", values, "yl09");
            return (Criteria) this;
        }

        public Criteria andYl09Between(Date value1, Date value2) {
            addCriterion("YL09 between", value1, value2, "yl09");
            return (Criteria) this;
        }

        public Criteria andYl09NotBetween(Date value1, Date value2) {
            addCriterion("YL09 not between", value1, value2, "yl09");
            return (Criteria) this;
        }

        public Criteria andYl10IsNull() {
            addCriterion("YL10 is null");
            return (Criteria) this;
        }

        public Criteria andYl10IsNotNull() {
            addCriterion("YL10 is not null");
            return (Criteria) this;
        }

        public Criteria andYl10EqualTo(Date value) {
            addCriterion("YL10 =", value, "yl10");
            return (Criteria) this;
        }

        public Criteria andYl10NotEqualTo(Date value) {
            addCriterion("YL10 <>", value, "yl10");
            return (Criteria) this;
        }

        public Criteria andYl10GreaterThan(Date value) {
            addCriterion("YL10 >", value, "yl10");
            return (Criteria) this;
        }

        public Criteria andYl10GreaterThanOrEqualTo(Date value) {
            addCriterion("YL10 >=", value, "yl10");
            return (Criteria) this;
        }

        public Criteria andYl10LessThan(Date value) {
            addCriterion("YL10 <", value, "yl10");
            return (Criteria) this;
        }

        public Criteria andYl10LessThanOrEqualTo(Date value) {
            addCriterion("YL10 <=", value, "yl10");
            return (Criteria) this;
        }

        public Criteria andYl10In(List<Date> values) {
            addCriterion("YL10 in", values, "yl10");
            return (Criteria) this;
        }

        public Criteria andYl10NotIn(List<Date> values) {
            addCriterion("YL10 not in", values, "yl10");
            return (Criteria) this;
        }

        public Criteria andYl10Between(Date value1, Date value2) {
            addCriterion("YL10 between", value1, value2, "yl10");
            return (Criteria) this;
        }

        public Criteria andYl10NotBetween(Date value1, Date value2) {
            addCriterion("YL10 not between", value1, value2, "yl10");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("PROVINCE =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("PROVINCE <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("PROVINCE >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("PROVINCE <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("PROVINCE like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("PROVINCE not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("PROVINCE in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("PROVINCE not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("PROVINCE between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("PROVINCE not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andXmpyIsNull() {
            addCriterion("XMPY is null");
            return (Criteria) this;
        }

        public Criteria andXmpyIsNotNull() {
            addCriterion("XMPY is not null");
            return (Criteria) this;
        }

        public Criteria andXmpyEqualTo(String value) {
            addCriterion("XMPY =", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyNotEqualTo(String value) {
            addCriterion("XMPY <>", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyGreaterThan(String value) {
            addCriterion("XMPY >", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyGreaterThanOrEqualTo(String value) {
            addCriterion("XMPY >=", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyLessThan(String value) {
            addCriterion("XMPY <", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyLessThanOrEqualTo(String value) {
            addCriterion("XMPY <=", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyLike(String value) {
            addCriterion("XMPY like", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyNotLike(String value) {
            addCriterion("XMPY not like", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyIn(List<String> values) {
            addCriterion("XMPY in", values, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyNotIn(List<String> values) {
            addCriterion("XMPY not in", values, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyBetween(String value1, String value2) {
            addCriterion("XMPY between", value1, value2, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyNotBetween(String value1, String value2) {
            addCriterion("XMPY not between", value1, value2, "xmpy");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andXrzwhzIsNull() {
            addCriterion("XRZWHZ is null");
            return (Criteria) this;
        }

        public Criteria andXrzwhzIsNotNull() {
            addCriterion("XRZWHZ is not null");
            return (Criteria) this;
        }

        public Criteria andXrzwhzEqualTo(String value) {
            addCriterion("XRZWHZ =", value, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andXrzwhzNotEqualTo(String value) {
            addCriterion("XRZWHZ <>", value, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andXrzwhzGreaterThan(String value) {
            addCriterion("XRZWHZ >", value, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andXrzwhzGreaterThanOrEqualTo(String value) {
            addCriterion("XRZWHZ >=", value, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andXrzwhzLessThan(String value) {
            addCriterion("XRZWHZ <", value, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andXrzwhzLessThanOrEqualTo(String value) {
            addCriterion("XRZWHZ <=", value, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andXrzwhzLike(String value) {
            addCriterion("XRZWHZ like", value, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andXrzwhzNotLike(String value) {
            addCriterion("XRZWHZ not like", value, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andXrzwhzIn(List<String> values) {
            addCriterion("XRZWHZ in", values, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andXrzwhzNotIn(List<String> values) {
            addCriterion("XRZWHZ not in", values, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andXrzwhzBetween(String value1, String value2) {
            addCriterion("XRZWHZ between", value1, value2, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andXrzwhzNotBetween(String value1, String value2) {
            addCriterion("XRZWHZ not between", value1, value2, "xrzwhz");
            return (Criteria) this;
        }

        public Criteria andGwmcIsNull() {
            addCriterion("GWMC is null");
            return (Criteria) this;
        }

        public Criteria andGwmcIsNotNull() {
            addCriterion("GWMC is not null");
            return (Criteria) this;
        }

        public Criteria andGwmcEqualTo(String value) {
            addCriterion("GWMC =", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcNotEqualTo(String value) {
            addCriterion("GWMC <>", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcGreaterThan(String value) {
            addCriterion("GWMC >", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcGreaterThanOrEqualTo(String value) {
            addCriterion("GWMC >=", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcLessThan(String value) {
            addCriterion("GWMC <", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcLessThanOrEqualTo(String value) {
            addCriterion("GWMC <=", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcLike(String value) {
            addCriterion("GWMC like", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcNotLike(String value) {
            addCriterion("GWMC not like", value, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcIn(List<String> values) {
            addCriterion("GWMC in", values, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcNotIn(List<String> values) {
            addCriterion("GWMC not in", values, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcBetween(String value1, String value2) {
            addCriterion("GWMC between", value1, value2, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwmcNotBetween(String value1, String value2) {
            addCriterion("GWMC not between", value1, value2, "gwmc");
            return (Criteria) this;
        }

        public Criteria andGwparaIsNull() {
            addCriterion("GWPARA is null");
            return (Criteria) this;
        }

        public Criteria andGwparaIsNotNull() {
            addCriterion("GWPARA is not null");
            return (Criteria) this;
        }

        public Criteria andGwparaEqualTo(String value) {
            addCriterion("GWPARA =", value, "gwpara");
            return (Criteria) this;
        }

        public Criteria andGwparaNotEqualTo(String value) {
            addCriterion("GWPARA <>", value, "gwpara");
            return (Criteria) this;
        }

        public Criteria andGwparaGreaterThan(String value) {
            addCriterion("GWPARA >", value, "gwpara");
            return (Criteria) this;
        }

        public Criteria andGwparaGreaterThanOrEqualTo(String value) {
            addCriterion("GWPARA >=", value, "gwpara");
            return (Criteria) this;
        }

        public Criteria andGwparaLessThan(String value) {
            addCriterion("GWPARA <", value, "gwpara");
            return (Criteria) this;
        }

        public Criteria andGwparaLessThanOrEqualTo(String value) {
            addCriterion("GWPARA <=", value, "gwpara");
            return (Criteria) this;
        }

        public Criteria andGwparaLike(String value) {
            addCriterion("GWPARA like", value, "gwpara");
            return (Criteria) this;
        }

        public Criteria andGwparaNotLike(String value) {
            addCriterion("GWPARA not like", value, "gwpara");
            return (Criteria) this;
        }

        public Criteria andGwparaIn(List<String> values) {
            addCriterion("GWPARA in", values, "gwpara");
            return (Criteria) this;
        }

        public Criteria andGwparaNotIn(List<String> values) {
            addCriterion("GWPARA not in", values, "gwpara");
            return (Criteria) this;
        }

        public Criteria andGwparaBetween(String value1, String value2) {
            addCriterion("GWPARA between", value1, value2, "gwpara");
            return (Criteria) this;
        }

        public Criteria andGwparaNotBetween(String value1, String value2) {
            addCriterion("GWPARA not between", value1, value2, "gwpara");
            return (Criteria) this;
        }

        public Criteria andBczwhzIsNull() {
            addCriterion("BCZWHZ is null");
            return (Criteria) this;
        }

        public Criteria andBczwhzIsNotNull() {
            addCriterion("BCZWHZ is not null");
            return (Criteria) this;
        }

        public Criteria andBczwhzEqualTo(String value) {
            addCriterion("BCZWHZ =", value, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andBczwhzNotEqualTo(String value) {
            addCriterion("BCZWHZ <>", value, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andBczwhzGreaterThan(String value) {
            addCriterion("BCZWHZ >", value, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andBczwhzGreaterThanOrEqualTo(String value) {
            addCriterion("BCZWHZ >=", value, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andBczwhzLessThan(String value) {
            addCriterion("BCZWHZ <", value, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andBczwhzLessThanOrEqualTo(String value) {
            addCriterion("BCZWHZ <=", value, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andBczwhzLike(String value) {
            addCriterion("BCZWHZ like", value, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andBczwhzNotLike(String value) {
            addCriterion("BCZWHZ not like", value, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andBczwhzIn(List<String> values) {
            addCriterion("BCZWHZ in", values, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andBczwhzNotIn(List<String> values) {
            addCriterion("BCZWHZ not in", values, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andBczwhzBetween(String value1, String value2) {
            addCriterion("BCZWHZ between", value1, value2, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andBczwhzNotBetween(String value1, String value2) {
            addCriterion("BCZWHZ not between", value1, value2, "bczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzIsNull() {
            addCriterion("MCZWHZ is null");
            return (Criteria) this;
        }

        public Criteria andMczwhzIsNotNull() {
            addCriterion("MCZWHZ is not null");
            return (Criteria) this;
        }

        public Criteria andMczwhzEqualTo(String value) {
            addCriterion("MCZWHZ =", value, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzNotEqualTo(String value) {
            addCriterion("MCZWHZ <>", value, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzGreaterThan(String value) {
            addCriterion("MCZWHZ >", value, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzGreaterThanOrEqualTo(String value) {
            addCriterion("MCZWHZ >=", value, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzLessThan(String value) {
            addCriterion("MCZWHZ <", value, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzLessThanOrEqualTo(String value) {
            addCriterion("MCZWHZ <=", value, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzLike(String value) {
            addCriterion("MCZWHZ like", value, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzNotLike(String value) {
            addCriterion("MCZWHZ not like", value, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzIn(List<String> values) {
            addCriterion("MCZWHZ in", values, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzNotIn(List<String> values) {
            addCriterion("MCZWHZ not in", values, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzBetween(String value1, String value2) {
            addCriterion("MCZWHZ between", value1, value2, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andMczwhzNotBetween(String value1, String value2) {
            addCriterion("MCZWHZ not between", value1, value2, "mczwhz");
            return (Criteria) this;
        }

        public Criteria andRysdIsNull() {
            addCriterion("RYSD is null");
            return (Criteria) this;
        }

        public Criteria andRysdIsNotNull() {
            addCriterion("RYSD is not null");
            return (Criteria) this;
        }

        public Criteria andRysdEqualTo(String value) {
            addCriterion("RYSD =", value, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysdNotEqualTo(String value) {
            addCriterion("RYSD <>", value, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysdGreaterThan(String value) {
            addCriterion("RYSD >", value, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysdGreaterThanOrEqualTo(String value) {
            addCriterion("RYSD >=", value, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysdLessThan(String value) {
            addCriterion("RYSD <", value, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysdLessThanOrEqualTo(String value) {
            addCriterion("RYSD <=", value, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysdLike(String value) {
            addCriterion("RYSD like", value, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysdNotLike(String value) {
            addCriterion("RYSD not like", value, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysdIn(List<String> values) {
            addCriterion("RYSD in", values, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysdNotIn(List<String> values) {
            addCriterion("RYSD not in", values, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysdBetween(String value1, String value2) {
            addCriterion("RYSD between", value1, value2, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysdNotBetween(String value1, String value2) {
            addCriterion("RYSD not between", value1, value2, "rysd");
            return (Criteria) this;
        }

        public Criteria andRysduserIsNull() {
            addCriterion("RYSDUSER is null");
            return (Criteria) this;
        }

        public Criteria andRysduserIsNotNull() {
            addCriterion("RYSDUSER is not null");
            return (Criteria) this;
        }

        public Criteria andRysduserEqualTo(String value) {
            addCriterion("RYSDUSER =", value, "rysduser");
            return (Criteria) this;
        }

        public Criteria andRysduserNotEqualTo(String value) {
            addCriterion("RYSDUSER <>", value, "rysduser");
            return (Criteria) this;
        }

        public Criteria andRysduserGreaterThan(String value) {
            addCriterion("RYSDUSER >", value, "rysduser");
            return (Criteria) this;
        }

        public Criteria andRysduserGreaterThanOrEqualTo(String value) {
            addCriterion("RYSDUSER >=", value, "rysduser");
            return (Criteria) this;
        }

        public Criteria andRysduserLessThan(String value) {
            addCriterion("RYSDUSER <", value, "rysduser");
            return (Criteria) this;
        }

        public Criteria andRysduserLessThanOrEqualTo(String value) {
            addCriterion("RYSDUSER <=", value, "rysduser");
            return (Criteria) this;
        }

        public Criteria andRysduserLike(String value) {
            addCriterion("RYSDUSER like", value, "rysduser");
            return (Criteria) this;
        }

        public Criteria andRysduserNotLike(String value) {
            addCriterion("RYSDUSER not like", value, "rysduser");
            return (Criteria) this;
        }

        public Criteria andRysduserIn(List<String> values) {
            addCriterion("RYSDUSER in", values, "rysduser");
            return (Criteria) this;
        }

        public Criteria andRysduserNotIn(List<String> values) {
            addCriterion("RYSDUSER not in", values, "rysduser");
            return (Criteria) this;
        }

        public Criteria andRysduserBetween(String value1, String value2) {
            addCriterion("RYSDUSER between", value1, value2, "rysduser");
            return (Criteria) this;
        }

        public Criteria andRysduserNotBetween(String value1, String value2) {
            addCriterion("RYSDUSER not between", value1, value2, "rysduser");
            return (Criteria) this;
        }

        public Criteria andShztIsNull() {
            addCriterion("SHZT is null");
            return (Criteria) this;
        }

        public Criteria andShztIsNotNull() {
            addCriterion("SHZT is not null");
            return (Criteria) this;
        }

        public Criteria andShztEqualTo(String value) {
            addCriterion("SHZT =", value, "shzt");
            return (Criteria) this;
        }

        public Criteria andShztNotEqualTo(String value) {
            addCriterion("SHZT <>", value, "shzt");
            return (Criteria) this;
        }

        public Criteria andShztGreaterThan(String value) {
            addCriterion("SHZT >", value, "shzt");
            return (Criteria) this;
        }

        public Criteria andShztGreaterThanOrEqualTo(String value) {
            addCriterion("SHZT >=", value, "shzt");
            return (Criteria) this;
        }

        public Criteria andShztLessThan(String value) {
            addCriterion("SHZT <", value, "shzt");
            return (Criteria) this;
        }

        public Criteria andShztLessThanOrEqualTo(String value) {
            addCriterion("SHZT <=", value, "shzt");
            return (Criteria) this;
        }

        public Criteria andShztLike(String value) {
            addCriterion("SHZT like", value, "shzt");
            return (Criteria) this;
        }

        public Criteria andShztNotLike(String value) {
            addCriterion("SHZT not like", value, "shzt");
            return (Criteria) this;
        }

        public Criteria andShztIn(List<String> values) {
            addCriterion("SHZT in", values, "shzt");
            return (Criteria) this;
        }

        public Criteria andShztNotIn(List<String> values) {
            addCriterion("SHZT not in", values, "shzt");
            return (Criteria) this;
        }

        public Criteria andShztBetween(String value1, String value2) {
            addCriterion("SHZT between", value1, value2, "shzt");
            return (Criteria) this;
        }

        public Criteria andShztNotBetween(String value1, String value2) {
            addCriterion("SHZT not between", value1, value2, "shzt");
            return (Criteria) this;
        }

        public Criteria andShrIsNull() {
            addCriterion("SHR is null");
            return (Criteria) this;
        }

        public Criteria andShrIsNotNull() {
            addCriterion("SHR is not null");
            return (Criteria) this;
        }

        public Criteria andShrEqualTo(String value) {
            addCriterion("SHR =", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotEqualTo(String value) {
            addCriterion("SHR <>", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrGreaterThan(String value) {
            addCriterion("SHR >", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrGreaterThanOrEqualTo(String value) {
            addCriterion("SHR >=", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrLessThan(String value) {
            addCriterion("SHR <", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrLessThanOrEqualTo(String value) {
            addCriterion("SHR <=", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrLike(String value) {
            addCriterion("SHR like", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotLike(String value) {
            addCriterion("SHR not like", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrIn(List<String> values) {
            addCriterion("SHR in", values, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotIn(List<String> values) {
            addCriterion("SHR not in", values, "shr");
            return (Criteria) this;
        }

        public Criteria andShrBetween(String value1, String value2) {
            addCriterion("SHR between", value1, value2, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotBetween(String value1, String value2) {
            addCriterion("SHR not between", value1, value2, "shr");
            return (Criteria) this;
        }

        public Criteria andShrqIsNull() {
            addCriterion("SHRQ is null");
            return (Criteria) this;
        }

        public Criteria andShrqIsNotNull() {
            addCriterion("SHRQ is not null");
            return (Criteria) this;
        }

        public Criteria andShrqEqualTo(String value) {
            addCriterion("SHRQ =", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqNotEqualTo(String value) {
            addCriterion("SHRQ <>", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqGreaterThan(String value) {
            addCriterion("SHRQ >", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqGreaterThanOrEqualTo(String value) {
            addCriterion("SHRQ >=", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqLessThan(String value) {
            addCriterion("SHRQ <", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqLessThanOrEqualTo(String value) {
            addCriterion("SHRQ <=", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqLike(String value) {
            addCriterion("SHRQ like", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqNotLike(String value) {
            addCriterion("SHRQ not like", value, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqIn(List<String> values) {
            addCriterion("SHRQ in", values, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqNotIn(List<String> values) {
            addCriterion("SHRQ not in", values, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqBetween(String value1, String value2) {
            addCriterion("SHRQ between", value1, value2, "shrq");
            return (Criteria) this;
        }

        public Criteria andShrqNotBetween(String value1, String value2) {
            addCriterion("SHRQ not between", value1, value2, "shrq");
            return (Criteria) this;
        }

        public Criteria andRysdbmIsNull() {
            addCriterion("RYSDBM is null");
            return (Criteria) this;
        }

        public Criteria andRysdbmIsNotNull() {
            addCriterion("RYSDBM is not null");
            return (Criteria) this;
        }

        public Criteria andRysdbmEqualTo(String value) {
            addCriterion("RYSDBM =", value, "rysdbm");
            return (Criteria) this;
        }

        public Criteria andRysdbmNotEqualTo(String value) {
            addCriterion("RYSDBM <>", value, "rysdbm");
            return (Criteria) this;
        }

        public Criteria andRysdbmGreaterThan(String value) {
            addCriterion("RYSDBM >", value, "rysdbm");
            return (Criteria) this;
        }

        public Criteria andRysdbmGreaterThanOrEqualTo(String value) {
            addCriterion("RYSDBM >=", value, "rysdbm");
            return (Criteria) this;
        }

        public Criteria andRysdbmLessThan(String value) {
            addCriterion("RYSDBM <", value, "rysdbm");
            return (Criteria) this;
        }

        public Criteria andRysdbmLessThanOrEqualTo(String value) {
            addCriterion("RYSDBM <=", value, "rysdbm");
            return (Criteria) this;
        }

        public Criteria andRysdbmLike(String value) {
            addCriterion("RYSDBM like", value, "rysdbm");
            return (Criteria) this;
        }

        public Criteria andRysdbmNotLike(String value) {
            addCriterion("RYSDBM not like", value, "rysdbm");
            return (Criteria) this;
        }

        public Criteria andRysdbmIn(List<String> values) {
            addCriterion("RYSDBM in", values, "rysdbm");
            return (Criteria) this;
        }

        public Criteria andRysdbmNotIn(List<String> values) {
            addCriterion("RYSDBM not in", values, "rysdbm");
            return (Criteria) this;
        }

        public Criteria andRysdbmBetween(String value1, String value2) {
            addCriterion("RYSDBM between", value1, value2, "rysdbm");
            return (Criteria) this;
        }

        public Criteria andRysdbmNotBetween(String value1, String value2) {
            addCriterion("RYSDBM not between", value1, value2, "rysdbm");
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