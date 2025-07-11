package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class DsjDyfzqkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsjDyfzqkExample() {
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

        public Criteria andDyfzqkidIsNull() {
            addCriterion("DYFZQKID is null");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidIsNotNull() {
            addCriterion("DYFZQKID is not null");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidEqualTo(String value) {
            addCriterion("DYFZQKID =", value, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidNotEqualTo(String value) {
            addCriterion("DYFZQKID <>", value, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidGreaterThan(String value) {
            addCriterion("DYFZQKID >", value, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidGreaterThanOrEqualTo(String value) {
            addCriterion("DYFZQKID >=", value, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidLessThan(String value) {
            addCriterion("DYFZQKID <", value, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidLessThanOrEqualTo(String value) {
            addCriterion("DYFZQKID <=", value, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidLike(String value) {
            addCriterion("DYFZQKID like", value, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidNotLike(String value) {
            addCriterion("DYFZQKID not like", value, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidIn(List<String> values) {
            addCriterion("DYFZQKID in", values, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidNotIn(List<String> values) {
            addCriterion("DYFZQKID not in", values, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidBetween(String value1, String value2) {
            addCriterion("DYFZQKID between", value1, value2, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andDyfzqkidNotBetween(String value1, String value2) {
            addCriterion("DYFZQKID not between", value1, value2, "dyfzqkid");
            return (Criteria) this;
        }

        public Criteria andNdIsNull() {
            addCriterion("ND is null");
            return (Criteria) this;
        }

        public Criteria andNdIsNotNull() {
            addCriterion("ND is not null");
            return (Criteria) this;
        }

        public Criteria andNdEqualTo(Integer value) {
            addCriterion("ND =", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotEqualTo(Integer value) {
            addCriterion("ND <>", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThan(Integer value) {
            addCriterion("ND >", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ND >=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThan(Integer value) {
            addCriterion("ND <", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThanOrEqualTo(Integer value) {
            addCriterion("ND <=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdIn(List<Integer> values) {
            addCriterion("ND in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotIn(List<Integer> values) {
            addCriterion("ND not in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdBetween(Integer value1, Integer value2) {
            addCriterion("ND between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotBetween(Integer value1, Integer value2) {
            addCriterion("ND not between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslIsNull() {
            addCriterion("JHFZDYSL is null");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslIsNotNull() {
            addCriterion("JHFZDYSL is not null");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslEqualTo(Integer value) {
            addCriterion("JHFZDYSL =", value, "jhfzdysl");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslNotEqualTo(Integer value) {
            addCriterion("JHFZDYSL <>", value, "jhfzdysl");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslGreaterThan(Integer value) {
            addCriterion("JHFZDYSL >", value, "jhfzdysl");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslGreaterThanOrEqualTo(Integer value) {
            addCriterion("JHFZDYSL >=", value, "jhfzdysl");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslLessThan(Integer value) {
            addCriterion("JHFZDYSL <", value, "jhfzdysl");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslLessThanOrEqualTo(Integer value) {
            addCriterion("JHFZDYSL <=", value, "jhfzdysl");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslIn(List<Integer> values) {
            addCriterion("JHFZDYSL in", values, "jhfzdysl");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslNotIn(List<Integer> values) {
            addCriterion("JHFZDYSL not in", values, "jhfzdysl");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslBetween(Integer value1, Integer value2) {
            addCriterion("JHFZDYSL between", value1, value2, "jhfzdysl");
            return (Criteria) this;
        }

        public Criteria andJhfzdyslNotBetween(Integer value1, Integer value2) {
            addCriterion("JHFZDYSL not between", value1, value2, "jhfzdysl");
            return (Criteria) this;
        }

        public Criteria andNvIsNull() {
            addCriterion("NV is null");
            return (Criteria) this;
        }

        public Criteria andNvIsNotNull() {
            addCriterion("NV is not null");
            return (Criteria) this;
        }

        public Criteria andNvEqualTo(Integer value) {
            addCriterion("NV =", value, "nv");
            return (Criteria) this;
        }

        public Criteria andNvNotEqualTo(Integer value) {
            addCriterion("NV <>", value, "nv");
            return (Criteria) this;
        }

        public Criteria andNvGreaterThan(Integer value) {
            addCriterion("NV >", value, "nv");
            return (Criteria) this;
        }

        public Criteria andNvGreaterThanOrEqualTo(Integer value) {
            addCriterion("NV >=", value, "nv");
            return (Criteria) this;
        }

        public Criteria andNvLessThan(Integer value) {
            addCriterion("NV <", value, "nv");
            return (Criteria) this;
        }

        public Criteria andNvLessThanOrEqualTo(Integer value) {
            addCriterion("NV <=", value, "nv");
            return (Criteria) this;
        }

        public Criteria andNvIn(List<Integer> values) {
            addCriterion("NV in", values, "nv");
            return (Criteria) this;
        }

        public Criteria andNvNotIn(List<Integer> values) {
            addCriterion("NV not in", values, "nv");
            return (Criteria) this;
        }

        public Criteria andNvBetween(Integer value1, Integer value2) {
            addCriterion("NV between", value1, value2, "nv");
            return (Criteria) this;
        }

        public Criteria andNvNotBetween(Integer value1, Integer value2) {
            addCriterion("NV not between", value1, value2, "nv");
            return (Criteria) this;
        }

        public Criteria andSsmzIsNull() {
            addCriterion("SSMZ is null");
            return (Criteria) this;
        }

        public Criteria andSsmzIsNotNull() {
            addCriterion("SSMZ is not null");
            return (Criteria) this;
        }

        public Criteria andSsmzEqualTo(Integer value) {
            addCriterion("SSMZ =", value, "ssmz");
            return (Criteria) this;
        }

        public Criteria andSsmzNotEqualTo(Integer value) {
            addCriterion("SSMZ <>", value, "ssmz");
            return (Criteria) this;
        }

        public Criteria andSsmzGreaterThan(Integer value) {
            addCriterion("SSMZ >", value, "ssmz");
            return (Criteria) this;
        }

        public Criteria andSsmzGreaterThanOrEqualTo(Integer value) {
            addCriterion("SSMZ >=", value, "ssmz");
            return (Criteria) this;
        }

        public Criteria andSsmzLessThan(Integer value) {
            addCriterion("SSMZ <", value, "ssmz");
            return (Criteria) this;
        }

        public Criteria andSsmzLessThanOrEqualTo(Integer value) {
            addCriterion("SSMZ <=", value, "ssmz");
            return (Criteria) this;
        }

        public Criteria andSsmzIn(List<Integer> values) {
            addCriterion("SSMZ in", values, "ssmz");
            return (Criteria) this;
        }

        public Criteria andSsmzNotIn(List<Integer> values) {
            addCriterion("SSMZ not in", values, "ssmz");
            return (Criteria) this;
        }

        public Criteria andSsmzBetween(Integer value1, Integer value2) {
            addCriterion("SSMZ between", value1, value2, "ssmz");
            return (Criteria) this;
        }

        public Criteria andSsmzNotBetween(Integer value1, Integer value2) {
            addCriterion("SSMZ not between", value1, value2, "ssmz");
            return (Criteria) this;
        }

        public Criteria andSwjyxIsNull() {
            addCriterion("SWJYX is null");
            return (Criteria) this;
        }

        public Criteria andSwjyxIsNotNull() {
            addCriterion("SWJYX is not null");
            return (Criteria) this;
        }

        public Criteria andSwjyxEqualTo(Integer value) {
            addCriterion("SWJYX =", value, "swjyx");
            return (Criteria) this;
        }

        public Criteria andSwjyxNotEqualTo(Integer value) {
            addCriterion("SWJYX <>", value, "swjyx");
            return (Criteria) this;
        }

        public Criteria andSwjyxGreaterThan(Integer value) {
            addCriterion("SWJYX >", value, "swjyx");
            return (Criteria) this;
        }

        public Criteria andSwjyxGreaterThanOrEqualTo(Integer value) {
            addCriterion("SWJYX >=", value, "swjyx");
            return (Criteria) this;
        }

        public Criteria andSwjyxLessThan(Integer value) {
            addCriterion("SWJYX <", value, "swjyx");
            return (Criteria) this;
        }

        public Criteria andSwjyxLessThanOrEqualTo(Integer value) {
            addCriterion("SWJYX <=", value, "swjyx");
            return (Criteria) this;
        }

        public Criteria andSwjyxIn(List<Integer> values) {
            addCriterion("SWJYX in", values, "swjyx");
            return (Criteria) this;
        }

        public Criteria andSwjyxNotIn(List<Integer> values) {
            addCriterion("SWJYX not in", values, "swjyx");
            return (Criteria) this;
        }

        public Criteria andSwjyxBetween(Integer value1, Integer value2) {
            addCriterion("SWJYX between", value1, value2, "swjyx");
            return (Criteria) this;
        }

        public Criteria andSwjyxNotBetween(Integer value1, Integer value2) {
            addCriterion("SWJYX not between", value1, value2, "swjyx");
            return (Criteria) this;
        }

        public Criteria andDzjysxlIsNull() {
            addCriterion("DZJYSXL is null");
            return (Criteria) this;
        }

        public Criteria andDzjysxlIsNotNull() {
            addCriterion("DZJYSXL is not null");
            return (Criteria) this;
        }

        public Criteria andDzjysxlEqualTo(Integer value) {
            addCriterion("DZJYSXL =", value, "dzjysxl");
            return (Criteria) this;
        }

        public Criteria andDzjysxlNotEqualTo(Integer value) {
            addCriterion("DZJYSXL <>", value, "dzjysxl");
            return (Criteria) this;
        }

        public Criteria andDzjysxlGreaterThan(Integer value) {
            addCriterion("DZJYSXL >", value, "dzjysxl");
            return (Criteria) this;
        }

        public Criteria andDzjysxlGreaterThanOrEqualTo(Integer value) {
            addCriterion("DZJYSXL >=", value, "dzjysxl");
            return (Criteria) this;
        }

        public Criteria andDzjysxlLessThan(Integer value) {
            addCriterion("DZJYSXL <", value, "dzjysxl");
            return (Criteria) this;
        }

        public Criteria andDzjysxlLessThanOrEqualTo(Integer value) {
            addCriterion("DZJYSXL <=", value, "dzjysxl");
            return (Criteria) this;
        }

        public Criteria andDzjysxlIn(List<Integer> values) {
            addCriterion("DZJYSXL in", values, "dzjysxl");
            return (Criteria) this;
        }

        public Criteria andDzjysxlNotIn(List<Integer> values) {
            addCriterion("DZJYSXL not in", values, "dzjysxl");
            return (Criteria) this;
        }

        public Criteria andDzjysxlBetween(Integer value1, Integer value2) {
            addCriterion("DZJYSXL between", value1, value2, "dzjysxl");
            return (Criteria) this;
        }

        public Criteria andDzjysxlNotBetween(Integer value1, Integer value2) {
            addCriterion("DZJYSXL not between", value1, value2, "dzjysxl");
            return (Criteria) this;
        }

        public Criteria andGrIsNull() {
            addCriterion("GR is null");
            return (Criteria) this;
        }

        public Criteria andGrIsNotNull() {
            addCriterion("GR is not null");
            return (Criteria) this;
        }

        public Criteria andGrEqualTo(Integer value) {
            addCriterion("GR =", value, "gr");
            return (Criteria) this;
        }

        public Criteria andGrNotEqualTo(Integer value) {
            addCriterion("GR <>", value, "gr");
            return (Criteria) this;
        }

        public Criteria andGrGreaterThan(Integer value) {
            addCriterion("GR >", value, "gr");
            return (Criteria) this;
        }

        public Criteria andGrGreaterThanOrEqualTo(Integer value) {
            addCriterion("GR >=", value, "gr");
            return (Criteria) this;
        }

        public Criteria andGrLessThan(Integer value) {
            addCriterion("GR <", value, "gr");
            return (Criteria) this;
        }

        public Criteria andGrLessThanOrEqualTo(Integer value) {
            addCriterion("GR <=", value, "gr");
            return (Criteria) this;
        }

        public Criteria andGrIn(List<Integer> values) {
            addCriterion("GR in", values, "gr");
            return (Criteria) this;
        }

        public Criteria andGrNotIn(List<Integer> values) {
            addCriterion("GR not in", values, "gr");
            return (Criteria) this;
        }

        public Criteria andGrBetween(Integer value1, Integer value2) {
            addCriterion("GR between", value1, value2, "gr");
            return (Criteria) this;
        }

        public Criteria andGrNotBetween(Integer value1, Integer value2) {
            addCriterion("GR not between", value1, value2, "gr");
            return (Criteria) this;
        }

        public Criteria andScgzdyxIsNull() {
            addCriterion("SCGZDYX is null");
            return (Criteria) this;
        }

        public Criteria andScgzdyxIsNotNull() {
            addCriterion("SCGZDYX is not null");
            return (Criteria) this;
        }

        public Criteria andScgzdyxEqualTo(Integer value) {
            addCriterion("SCGZDYX =", value, "scgzdyx");
            return (Criteria) this;
        }

        public Criteria andScgzdyxNotEqualTo(Integer value) {
            addCriterion("SCGZDYX <>", value, "scgzdyx");
            return (Criteria) this;
        }

        public Criteria andScgzdyxGreaterThan(Integer value) {
            addCriterion("SCGZDYX >", value, "scgzdyx");
            return (Criteria) this;
        }

        public Criteria andScgzdyxGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCGZDYX >=", value, "scgzdyx");
            return (Criteria) this;
        }

        public Criteria andScgzdyxLessThan(Integer value) {
            addCriterion("SCGZDYX <", value, "scgzdyx");
            return (Criteria) this;
        }

        public Criteria andScgzdyxLessThanOrEqualTo(Integer value) {
            addCriterion("SCGZDYX <=", value, "scgzdyx");
            return (Criteria) this;
        }

        public Criteria andScgzdyxIn(List<Integer> values) {
            addCriterion("SCGZDYX in", values, "scgzdyx");
            return (Criteria) this;
        }

        public Criteria andScgzdyxNotIn(List<Integer> values) {
            addCriterion("SCGZDYX not in", values, "scgzdyx");
            return (Criteria) this;
        }

        public Criteria andScgzdyxBetween(Integer value1, Integer value2) {
            addCriterion("SCGZDYX between", value1, value2, "scgzdyx");
            return (Criteria) this;
        }

        public Criteria andScgzdyxNotBetween(Integer value1, Integer value2) {
            addCriterion("SCGZDYX not between", value1, value2, "scgzdyx");
            return (Criteria) this;
        }

        public Criteria andQyscdyxIsNull() {
            addCriterion("QYSCDYX is null");
            return (Criteria) this;
        }

        public Criteria andQyscdyxIsNotNull() {
            addCriterion("QYSCDYX is not null");
            return (Criteria) this;
        }

        public Criteria andQyscdyxEqualTo(Integer value) {
            addCriterion("QYSCDYX =", value, "qyscdyx");
            return (Criteria) this;
        }

        public Criteria andQyscdyxNotEqualTo(Integer value) {
            addCriterion("QYSCDYX <>", value, "qyscdyx");
            return (Criteria) this;
        }

        public Criteria andQyscdyxGreaterThan(Integer value) {
            addCriterion("QYSCDYX >", value, "qyscdyx");
            return (Criteria) this;
        }

        public Criteria andQyscdyxGreaterThanOrEqualTo(Integer value) {
            addCriterion("QYSCDYX >=", value, "qyscdyx");
            return (Criteria) this;
        }

        public Criteria andQyscdyxLessThan(Integer value) {
            addCriterion("QYSCDYX <", value, "qyscdyx");
            return (Criteria) this;
        }

        public Criteria andQyscdyxLessThanOrEqualTo(Integer value) {
            addCriterion("QYSCDYX <=", value, "qyscdyx");
            return (Criteria) this;
        }

        public Criteria andQyscdyxIn(List<Integer> values) {
            addCriterion("QYSCDYX in", values, "qyscdyx");
            return (Criteria) this;
        }

        public Criteria andQyscdyxNotIn(List<Integer> values) {
            addCriterion("QYSCDYX not in", values, "qyscdyx");
            return (Criteria) this;
        }

        public Criteria andQyscdyxBetween(Integer value1, Integer value2) {
            addCriterion("QYSCDYX between", value1, value2, "qyscdyx");
            return (Criteria) this;
        }

        public Criteria andQyscdyxNotBetween(Integer value1, Integer value2) {
            addCriterion("QYSCDYX not between", value1, value2, "qyscdyx");
            return (Criteria) this;
        }

        public Criteria andYsdyxIsNull() {
            addCriterion("YSDYX is null");
            return (Criteria) this;
        }

        public Criteria andYsdyxIsNotNull() {
            addCriterion("YSDYX is not null");
            return (Criteria) this;
        }

        public Criteria andYsdyxEqualTo(Integer value) {
            addCriterion("YSDYX =", value, "ysdyx");
            return (Criteria) this;
        }

        public Criteria andYsdyxNotEqualTo(Integer value) {
            addCriterion("YSDYX <>", value, "ysdyx");
            return (Criteria) this;
        }

        public Criteria andYsdyxGreaterThan(Integer value) {
            addCriterion("YSDYX >", value, "ysdyx");
            return (Criteria) this;
        }

        public Criteria andYsdyxGreaterThanOrEqualTo(Integer value) {
            addCriterion("YSDYX >=", value, "ysdyx");
            return (Criteria) this;
        }

        public Criteria andYsdyxLessThan(Integer value) {
            addCriterion("YSDYX <", value, "ysdyx");
            return (Criteria) this;
        }

        public Criteria andYsdyxLessThanOrEqualTo(Integer value) {
            addCriterion("YSDYX <=", value, "ysdyx");
            return (Criteria) this;
        }

        public Criteria andYsdyxIn(List<Integer> values) {
            addCriterion("YSDYX in", values, "ysdyx");
            return (Criteria) this;
        }

        public Criteria andYsdyxNotIn(List<Integer> values) {
            addCriterion("YSDYX not in", values, "ysdyx");
            return (Criteria) this;
        }

        public Criteria andYsdyxBetween(Integer value1, Integer value2) {
            addCriterion("YSDYX between", value1, value2, "ysdyx");
            return (Criteria) this;
        }

        public Criteria andYsdyxNotBetween(Integer value1, Integer value2) {
            addCriterion("YSDYX not between", value1, value2, "ysdyx");
            return (Criteria) this;
        }

        public Criteria andBzzIsNull() {
            addCriterion("BZZ is null");
            return (Criteria) this;
        }

        public Criteria andBzzIsNotNull() {
            addCriterion("BZZ is not null");
            return (Criteria) this;
        }

        public Criteria andBzzEqualTo(Integer value) {
            addCriterion("BZZ =", value, "bzz");
            return (Criteria) this;
        }

        public Criteria andBzzNotEqualTo(Integer value) {
            addCriterion("BZZ <>", value, "bzz");
            return (Criteria) this;
        }

        public Criteria andBzzGreaterThan(Integer value) {
            addCriterion("BZZ >", value, "bzz");
            return (Criteria) this;
        }

        public Criteria andBzzGreaterThanOrEqualTo(Integer value) {
            addCriterion("BZZ >=", value, "bzz");
            return (Criteria) this;
        }

        public Criteria andBzzLessThan(Integer value) {
            addCriterion("BZZ <", value, "bzz");
            return (Criteria) this;
        }

        public Criteria andBzzLessThanOrEqualTo(Integer value) {
            addCriterion("BZZ <=", value, "bzz");
            return (Criteria) this;
        }

        public Criteria andBzzIn(List<Integer> values) {
            addCriterion("BZZ in", values, "bzz");
            return (Criteria) this;
        }

        public Criteria andBzzNotIn(List<Integer> values) {
            addCriterion("BZZ not in", values, "bzz");
            return (Criteria) this;
        }

        public Criteria andBzzBetween(Integer value1, Integer value2) {
            addCriterion("BZZ between", value1, value2, "bzz");
            return (Criteria) this;
        }

        public Criteria andBzzNotBetween(Integer value1, Integer value2) {
            addCriterion("BZZ not between", value1, value2, "bzz");
            return (Criteria) this;
        }

        public Criteria andGtlyIsNull() {
            addCriterion("GTLY is null");
            return (Criteria) this;
        }

        public Criteria andGtlyIsNotNull() {
            addCriterion("GTLY is not null");
            return (Criteria) this;
        }

        public Criteria andGtlyEqualTo(Integer value) {
            addCriterion("GTLY =", value, "gtly");
            return (Criteria) this;
        }

        public Criteria andGtlyNotEqualTo(Integer value) {
            addCriterion("GTLY <>", value, "gtly");
            return (Criteria) this;
        }

        public Criteria andGtlyGreaterThan(Integer value) {
            addCriterion("GTLY >", value, "gtly");
            return (Criteria) this;
        }

        public Criteria andGtlyGreaterThanOrEqualTo(Integer value) {
            addCriterion("GTLY >=", value, "gtly");
            return (Criteria) this;
        }

        public Criteria andGtlyLessThan(Integer value) {
            addCriterion("GTLY <", value, "gtly");
            return (Criteria) this;
        }

        public Criteria andGtlyLessThanOrEqualTo(Integer value) {
            addCriterion("GTLY <=", value, "gtly");
            return (Criteria) this;
        }

        public Criteria andGtlyIn(List<Integer> values) {
            addCriterion("GTLY in", values, "gtly");
            return (Criteria) this;
        }

        public Criteria andGtlyNotIn(List<Integer> values) {
            addCriterion("GTLY not in", values, "gtly");
            return (Criteria) this;
        }

        public Criteria andGtlyBetween(Integer value1, Integer value2) {
            addCriterion("GTLY between", value1, value2, "gtly");
            return (Criteria) this;
        }

        public Criteria andGtlyNotBetween(Integer value1, Integer value2) {
            addCriterion("GTLY not between", value1, value2, "gtly");
            return (Criteria) this;
        }

        public Criteria andGtcwlyIsNull() {
            addCriterion("GTCWLY is null");
            return (Criteria) this;
        }

        public Criteria andGtcwlyIsNotNull() {
            addCriterion("GTCWLY is not null");
            return (Criteria) this;
        }

        public Criteria andGtcwlyEqualTo(Integer value) {
            addCriterion("GTCWLY =", value, "gtcwly");
            return (Criteria) this;
        }

        public Criteria andGtcwlyNotEqualTo(Integer value) {
            addCriterion("GTCWLY <>", value, "gtcwly");
            return (Criteria) this;
        }

        public Criteria andGtcwlyGreaterThan(Integer value) {
            addCriterion("GTCWLY >", value, "gtcwly");
            return (Criteria) this;
        }

        public Criteria andGtcwlyGreaterThanOrEqualTo(Integer value) {
            addCriterion("GTCWLY >=", value, "gtcwly");
            return (Criteria) this;
        }

        public Criteria andGtcwlyLessThan(Integer value) {
            addCriterion("GTCWLY <", value, "gtcwly");
            return (Criteria) this;
        }

        public Criteria andGtcwlyLessThanOrEqualTo(Integer value) {
            addCriterion("GTCWLY <=", value, "gtcwly");
            return (Criteria) this;
        }

        public Criteria andGtcwlyIn(List<Integer> values) {
            addCriterion("GTCWLY in", values, "gtcwly");
            return (Criteria) this;
        }

        public Criteria andGtcwlyNotIn(List<Integer> values) {
            addCriterion("GTCWLY not in", values, "gtcwly");
            return (Criteria) this;
        }

        public Criteria andGtcwlyBetween(Integer value1, Integer value2) {
            addCriterion("GTCWLY between", value1, value2, "gtcwly");
            return (Criteria) this;
        }

        public Criteria andGtcwlyNotBetween(Integer value1, Integer value2) {
            addCriterion("GTCWLY not between", value1, value2, "gtcwly");
            return (Criteria) this;
        }

        public Criteria andLwpqgIsNull() {
            addCriterion("LWPQG is null");
            return (Criteria) this;
        }

        public Criteria andLwpqgIsNotNull() {
            addCriterion("LWPQG is not null");
            return (Criteria) this;
        }

        public Criteria andLwpqgEqualTo(Integer value) {
            addCriterion("LWPQG =", value, "lwpqg");
            return (Criteria) this;
        }

        public Criteria andLwpqgNotEqualTo(Integer value) {
            addCriterion("LWPQG <>", value, "lwpqg");
            return (Criteria) this;
        }

        public Criteria andLwpqgGreaterThan(Integer value) {
            addCriterion("LWPQG >", value, "lwpqg");
            return (Criteria) this;
        }

        public Criteria andLwpqgGreaterThanOrEqualTo(Integer value) {
            addCriterion("LWPQG >=", value, "lwpqg");
            return (Criteria) this;
        }

        public Criteria andLwpqgLessThan(Integer value) {
            addCriterion("LWPQG <", value, "lwpqg");
            return (Criteria) this;
        }

        public Criteria andLwpqgLessThanOrEqualTo(Integer value) {
            addCriterion("LWPQG <=", value, "lwpqg");
            return (Criteria) this;
        }

        public Criteria andLwpqgIn(List<Integer> values) {
            addCriterion("LWPQG in", values, "lwpqg");
            return (Criteria) this;
        }

        public Criteria andLwpqgNotIn(List<Integer> values) {
            addCriterion("LWPQG not in", values, "lwpqg");
            return (Criteria) this;
        }

        public Criteria andLwpqgBetween(Integer value1, Integer value2) {
            addCriterion("LWPQG between", value1, value2, "lwpqg");
            return (Criteria) this;
        }

        public Criteria andLwpqgNotBetween(Integer value1, Integer value2) {
            addCriterion("LWPQG not between", value1, value2, "lwpqg");
            return (Criteria) this;
        }

        public Criteria andXjmfrwIsNull() {
            addCriterion("XJMFRW is null");
            return (Criteria) this;
        }

        public Criteria andXjmfrwIsNotNull() {
            addCriterion("XJMFRW is not null");
            return (Criteria) this;
        }

        public Criteria andXjmfrwEqualTo(Integer value) {
            addCriterion("XJMFRW =", value, "xjmfrw");
            return (Criteria) this;
        }

        public Criteria andXjmfrwNotEqualTo(Integer value) {
            addCriterion("XJMFRW <>", value, "xjmfrw");
            return (Criteria) this;
        }

        public Criteria andXjmfrwGreaterThan(Integer value) {
            addCriterion("XJMFRW >", value, "xjmfrw");
            return (Criteria) this;
        }

        public Criteria andXjmfrwGreaterThanOrEqualTo(Integer value) {
            addCriterion("XJMFRW >=", value, "xjmfrw");
            return (Criteria) this;
        }

        public Criteria andXjmfrwLessThan(Integer value) {
            addCriterion("XJMFRW <", value, "xjmfrw");
            return (Criteria) this;
        }

        public Criteria andXjmfrwLessThanOrEqualTo(Integer value) {
            addCriterion("XJMFRW <=", value, "xjmfrw");
            return (Criteria) this;
        }

        public Criteria andXjmfrwIn(List<Integer> values) {
            addCriterion("XJMFRW in", values, "xjmfrw");
            return (Criteria) this;
        }

        public Criteria andXjmfrwNotIn(List<Integer> values) {
            addCriterion("XJMFRW not in", values, "xjmfrw");
            return (Criteria) this;
        }

        public Criteria andXjmfrwBetween(Integer value1, Integer value2) {
            addCriterion("XJMFRW between", value1, value2, "xjmfrw");
            return (Criteria) this;
        }

        public Criteria andXjmfrwNotBetween(Integer value1, Integer value2) {
            addCriterion("XJMFRW not between", value1, value2, "xjmfrw");
            return (Criteria) this;
        }

        public Criteria andGzsqtIsNull() {
            addCriterion("GZSQT is null");
            return (Criteria) this;
        }

        public Criteria andGzsqtIsNotNull() {
            addCriterion("GZSQT is not null");
            return (Criteria) this;
        }

        public Criteria andGzsqtEqualTo(Integer value) {
            addCriterion("GZSQT =", value, "gzsqt");
            return (Criteria) this;
        }

        public Criteria andGzsqtNotEqualTo(Integer value) {
            addCriterion("GZSQT <>", value, "gzsqt");
            return (Criteria) this;
        }

        public Criteria andGzsqtGreaterThan(Integer value) {
            addCriterion("GZSQT >", value, "gzsqt");
            return (Criteria) this;
        }

        public Criteria andGzsqtGreaterThanOrEqualTo(Integer value) {
            addCriterion("GZSQT >=", value, "gzsqt");
            return (Criteria) this;
        }

        public Criteria andGzsqtLessThan(Integer value) {
            addCriterion("GZSQT <", value, "gzsqt");
            return (Criteria) this;
        }

        public Criteria andGzsqtLessThanOrEqualTo(Integer value) {
            addCriterion("GZSQT <=", value, "gzsqt");
            return (Criteria) this;
        }

        public Criteria andGzsqtIn(List<Integer> values) {
            addCriterion("GZSQT in", values, "gzsqt");
            return (Criteria) this;
        }

        public Criteria andGzsqtNotIn(List<Integer> values) {
            addCriterion("GZSQT not in", values, "gzsqt");
            return (Criteria) this;
        }

        public Criteria andGzsqtBetween(Integer value1, Integer value2) {
            addCriterion("GZSQT between", value1, value2, "gzsqt");
            return (Criteria) this;
        }

        public Criteria andGzsqtNotBetween(Integer value1, Integer value2) {
            addCriterion("GZSQT not between", value1, value2, "gzsqt");
            return (Criteria) this;
        }

        public Criteria andGqtyIsNull() {
            addCriterion("GQTY is null");
            return (Criteria) this;
        }

        public Criteria andGqtyIsNotNull() {
            addCriterion("GQTY is not null");
            return (Criteria) this;
        }

        public Criteria andGqtyEqualTo(Integer value) {
            addCriterion("GQTY =", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyNotEqualTo(Integer value) {
            addCriterion("GQTY <>", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyGreaterThan(Integer value) {
            addCriterion("GQTY >", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("GQTY >=", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyLessThan(Integer value) {
            addCriterion("GQTY <", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyLessThanOrEqualTo(Integer value) {
            addCriterion("GQTY <=", value, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyIn(List<Integer> values) {
            addCriterion("GQTY in", values, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyNotIn(List<Integer> values) {
            addCriterion("GQTY not in", values, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyBetween(Integer value1, Integer value2) {
            addCriterion("GQTY between", value1, value2, "gqty");
            return (Criteria) this;
        }

        public Criteria andGqtyNotBetween(Integer value1, Integer value2) {
            addCriterion("GQTY not between", value1, value2, "gqty");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsIsNull() {
            addCriterion("MQWDYBZS is null");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsIsNotNull() {
            addCriterion("MQWDYBZS is not null");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsEqualTo(Integer value) {
            addCriterion("MQWDYBZS =", value, "mqwdybzs");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsNotEqualTo(Integer value) {
            addCriterion("MQWDYBZS <>", value, "mqwdybzs");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsGreaterThan(Integer value) {
            addCriterion("MQWDYBZS >", value, "mqwdybzs");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsGreaterThanOrEqualTo(Integer value) {
            addCriterion("MQWDYBZS >=", value, "mqwdybzs");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsLessThan(Integer value) {
            addCriterion("MQWDYBZS <", value, "mqwdybzs");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsLessThanOrEqualTo(Integer value) {
            addCriterion("MQWDYBZS <=", value, "mqwdybzs");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsIn(List<Integer> values) {
            addCriterion("MQWDYBZS in", values, "mqwdybzs");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsNotIn(List<Integer> values) {
            addCriterion("MQWDYBZS not in", values, "mqwdybzs");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsBetween(Integer value1, Integer value2) {
            addCriterion("MQWDYBZS between", value1, value2, "mqwdybzs");
            return (Criteria) this;
        }

        public Criteria andMqwdybzsNotBetween(Integer value1, Integer value2) {
            addCriterion("MQWDYBZS not between", value1, value2, "mqwdybzs");
            return (Criteria) this;
        }

        public Criteria andJhfzsIsNull() {
            addCriterion("JHFZS is null");
            return (Criteria) this;
        }

        public Criteria andJhfzsIsNotNull() {
            addCriterion("JHFZS is not null");
            return (Criteria) this;
        }

        public Criteria andJhfzsEqualTo(Integer value) {
            addCriterion("JHFZS =", value, "jhfzs");
            return (Criteria) this;
        }

        public Criteria andJhfzsNotEqualTo(Integer value) {
            addCriterion("JHFZS <>", value, "jhfzs");
            return (Criteria) this;
        }

        public Criteria andJhfzsGreaterThan(Integer value) {
            addCriterion("JHFZS >", value, "jhfzs");
            return (Criteria) this;
        }

        public Criteria andJhfzsGreaterThanOrEqualTo(Integer value) {
            addCriterion("JHFZS >=", value, "jhfzs");
            return (Criteria) this;
        }

        public Criteria andJhfzsLessThan(Integer value) {
            addCriterion("JHFZS <", value, "jhfzs");
            return (Criteria) this;
        }

        public Criteria andJhfzsLessThanOrEqualTo(Integer value) {
            addCriterion("JHFZS <=", value, "jhfzs");
            return (Criteria) this;
        }

        public Criteria andJhfzsIn(List<Integer> values) {
            addCriterion("JHFZS in", values, "jhfzs");
            return (Criteria) this;
        }

        public Criteria andJhfzsNotIn(List<Integer> values) {
            addCriterion("JHFZS not in", values, "jhfzs");
            return (Criteria) this;
        }

        public Criteria andJhfzsBetween(Integer value1, Integer value2) {
            addCriterion("JHFZS between", value1, value2, "jhfzs");
            return (Criteria) this;
        }

        public Criteria andJhfzsNotBetween(Integer value1, Integer value2) {
            addCriterion("JHFZS not between", value1, value2, "jhfzs");
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