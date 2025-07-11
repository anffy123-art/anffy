package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DjGdwydqkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DjGdwydqkExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDzzmcIsNull() {
            addCriterion("DZZMC is null");
            return (Criteria) this;
        }

        public Criteria andDzzmcIsNotNull() {
            addCriterion("DZZMC is not null");
            return (Criteria) this;
        }

        public Criteria andDzzmcEqualTo(String value) {
            addCriterion("DZZMC =", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotEqualTo(String value) {
            addCriterion("DZZMC <>", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcGreaterThan(String value) {
            addCriterion("DZZMC >", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcGreaterThanOrEqualTo(String value) {
            addCriterion("DZZMC >=", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLessThan(String value) {
            addCriterion("DZZMC <", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLessThanOrEqualTo(String value) {
            addCriterion("DZZMC <=", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLike(String value) {
            addCriterion("DZZMC like", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotLike(String value) {
            addCriterion("DZZMC not like", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcIn(List<String> values) {
            addCriterion("DZZMC in", values, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotIn(List<String> values) {
            addCriterion("DZZMC not in", values, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcBetween(String value1, String value2) {
            addCriterion("DZZMC between", value1, value2, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotBetween(String value1, String value2) {
            addCriterion("DZZMC not between", value1, value2, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andNyIsNull() {
            addCriterion("NY is null");
            return (Criteria) this;
        }

        public Criteria andNyIsNotNull() {
            addCriterion("NY is not null");
            return (Criteria) this;
        }

        public Criteria andNyEqualTo(Date value) {
            addCriterion("NY =", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyNotEqualTo(Date value) {
            addCriterion("NY <>", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyGreaterThan(Date value) {
            addCriterion("NY >", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyGreaterThanOrEqualTo(Date value) {
            addCriterion("NY >=", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyLessThan(Date value) {
            addCriterion("NY <", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyLessThanOrEqualTo(Date value) {
            addCriterion("NY <=", value, "ny");
            return (Criteria) this;
        }

        public Criteria andNyIn(List<Date> values) {
            addCriterion("NY in", values, "ny");
            return (Criteria) this;
        }

        public Criteria andNyNotIn(List<Date> values) {
            addCriterion("NY not in", values, "ny");
            return (Criteria) this;
        }

        public Criteria andNyBetween(Date value1, Date value2) {
            addCriterion("NY between", value1, value2, "ny");
            return (Criteria) this;
        }

        public Criteria andNyNotBetween(Date value1, Date value2) {
            addCriterion("NY not between", value1, value2, "ny");
            return (Criteria) this;
        }

        public Criteria andDwzrsIsNull() {
            addCriterion("DWZRS is null");
            return (Criteria) this;
        }

        public Criteria andDwzrsIsNotNull() {
            addCriterion("DWZRS is not null");
            return (Criteria) this;
        }

        public Criteria andDwzrsEqualTo(Integer value) {
            addCriterion("DWZRS =", value, "dwzrs");
            return (Criteria) this;
        }

        public Criteria andDwzrsNotEqualTo(Integer value) {
            addCriterion("DWZRS <>", value, "dwzrs");
            return (Criteria) this;
        }

        public Criteria andDwzrsGreaterThan(Integer value) {
            addCriterion("DWZRS >", value, "dwzrs");
            return (Criteria) this;
        }

        public Criteria andDwzrsGreaterThanOrEqualTo(Integer value) {
            addCriterion("DWZRS >=", value, "dwzrs");
            return (Criteria) this;
        }

        public Criteria andDwzrsLessThan(Integer value) {
            addCriterion("DWZRS <", value, "dwzrs");
            return (Criteria) this;
        }

        public Criteria andDwzrsLessThanOrEqualTo(Integer value) {
            addCriterion("DWZRS <=", value, "dwzrs");
            return (Criteria) this;
        }

        public Criteria andDwzrsIn(List<Integer> values) {
            addCriterion("DWZRS in", values, "dwzrs");
            return (Criteria) this;
        }

        public Criteria andDwzrsNotIn(List<Integer> values) {
            addCriterion("DWZRS not in", values, "dwzrs");
            return (Criteria) this;
        }

        public Criteria andDwzrsBetween(Integer value1, Integer value2) {
            addCriterion("DWZRS between", value1, value2, "dwzrs");
            return (Criteria) this;
        }

        public Criteria andDwzrsNotBetween(Integer value1, Integer value2) {
            addCriterion("DWZRS not between", value1, value2, "dwzrs");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsIsNull() {
            addCriterion("DWGZZRS is null");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsIsNotNull() {
            addCriterion("DWGZZRS is not null");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsEqualTo(Integer value) {
            addCriterion("DWGZZRS =", value, "dwgzzrs");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsNotEqualTo(Integer value) {
            addCriterion("DWGZZRS <>", value, "dwgzzrs");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsGreaterThan(Integer value) {
            addCriterion("DWGZZRS >", value, "dwgzzrs");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsGreaterThanOrEqualTo(Integer value) {
            addCriterion("DWGZZRS >=", value, "dwgzzrs");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsLessThan(Integer value) {
            addCriterion("DWGZZRS <", value, "dwgzzrs");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsLessThanOrEqualTo(Integer value) {
            addCriterion("DWGZZRS <=", value, "dwgzzrs");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsIn(List<Integer> values) {
            addCriterion("DWGZZRS in", values, "dwgzzrs");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsNotIn(List<Integer> values) {
            addCriterion("DWGZZRS not in", values, "dwgzzrs");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsBetween(Integer value1, Integer value2) {
            addCriterion("DWGZZRS between", value1, value2, "dwgzzrs");
            return (Criteria) this;
        }

        public Criteria andDwgzzrsNotBetween(Integer value1, Integer value2) {
            addCriterion("DWGZZRS not between", value1, value2, "dwgzzrs");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlIsNull() {
            addCriterion("DZBSJYDL is null");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlIsNotNull() {
            addCriterion("DZBSJYDL is not null");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlEqualTo(Integer value) {
            addCriterion("DZBSJYDL =", value, "dzbsjydl");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlNotEqualTo(Integer value) {
            addCriterion("DZBSJYDL <>", value, "dzbsjydl");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlGreaterThan(Integer value) {
            addCriterion("DZBSJYDL >", value, "dzbsjydl");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlGreaterThanOrEqualTo(Integer value) {
            addCriterion("DZBSJYDL >=", value, "dzbsjydl");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlLessThan(Integer value) {
            addCriterion("DZBSJYDL <", value, "dzbsjydl");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlLessThanOrEqualTo(Integer value) {
            addCriterion("DZBSJYDL <=", value, "dzbsjydl");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlIn(List<Integer> values) {
            addCriterion("DZBSJYDL in", values, "dzbsjydl");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlNotIn(List<Integer> values) {
            addCriterion("DZBSJYDL not in", values, "dzbsjydl");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlBetween(Integer value1, Integer value2) {
            addCriterion("DZBSJYDL between", value1, value2, "dzbsjydl");
            return (Criteria) this;
        }

        public Criteria andDzbsjydlNotBetween(Integer value1, Integer value2) {
            addCriterion("DZBSJYDL not between", value1, value2, "dzbsjydl");
            return (Criteria) this;
        }

        public Criteria andDyydlIsNull() {
            addCriterion("DYYDL is null");
            return (Criteria) this;
        }

        public Criteria andDyydlIsNotNull() {
            addCriterion("DYYDL is not null");
            return (Criteria) this;
        }

        public Criteria andDyydlEqualTo(Integer value) {
            addCriterion("DYYDL =", value, "dyydl");
            return (Criteria) this;
        }

        public Criteria andDyydlNotEqualTo(Integer value) {
            addCriterion("DYYDL <>", value, "dyydl");
            return (Criteria) this;
        }

        public Criteria andDyydlGreaterThan(Integer value) {
            addCriterion("DYYDL >", value, "dyydl");
            return (Criteria) this;
        }

        public Criteria andDyydlGreaterThanOrEqualTo(Integer value) {
            addCriterion("DYYDL >=", value, "dyydl");
            return (Criteria) this;
        }

        public Criteria andDyydlLessThan(Integer value) {
            addCriterion("DYYDL <", value, "dyydl");
            return (Criteria) this;
        }

        public Criteria andDyydlLessThanOrEqualTo(Integer value) {
            addCriterion("DYYDL <=", value, "dyydl");
            return (Criteria) this;
        }

        public Criteria andDyydlIn(List<Integer> values) {
            addCriterion("DYYDL in", values, "dyydl");
            return (Criteria) this;
        }

        public Criteria andDyydlNotIn(List<Integer> values) {
            addCriterion("DYYDL not in", values, "dyydl");
            return (Criteria) this;
        }

        public Criteria andDyydlBetween(Integer value1, Integer value2) {
            addCriterion("DYYDL between", value1, value2, "dyydl");
            return (Criteria) this;
        }

        public Criteria andDyydlNotBetween(Integer value1, Integer value2) {
            addCriterion("DYYDL not between", value1, value2, "dyydl");
            return (Criteria) this;
        }

        public Criteria andDzlvIsNull() {
            addCriterion("DZLV is null");
            return (Criteria) this;
        }

        public Criteria andDzlvIsNotNull() {
            addCriterion("DZLV is not null");
            return (Criteria) this;
        }

        public Criteria andDzlvEqualTo(Integer value) {
            addCriterion("DZLV =", value, "dzlv");
            return (Criteria) this;
        }

        public Criteria andDzlvNotEqualTo(Integer value) {
            addCriterion("DZLV <>", value, "dzlv");
            return (Criteria) this;
        }

        public Criteria andDzlvGreaterThan(Integer value) {
            addCriterion("DZLV >", value, "dzlv");
            return (Criteria) this;
        }

        public Criteria andDzlvGreaterThanOrEqualTo(Integer value) {
            addCriterion("DZLV >=", value, "dzlv");
            return (Criteria) this;
        }

        public Criteria andDzlvLessThan(Integer value) {
            addCriterion("DZLV <", value, "dzlv");
            return (Criteria) this;
        }

        public Criteria andDzlvLessThanOrEqualTo(Integer value) {
            addCriterion("DZLV <=", value, "dzlv");
            return (Criteria) this;
        }

        public Criteria andDzlvIn(List<Integer> values) {
            addCriterion("DZLV in", values, "dzlv");
            return (Criteria) this;
        }

        public Criteria andDzlvNotIn(List<Integer> values) {
            addCriterion("DZLV not in", values, "dzlv");
            return (Criteria) this;
        }

        public Criteria andDzlvBetween(Integer value1, Integer value2) {
            addCriterion("DZLV between", value1, value2, "dzlv");
            return (Criteria) this;
        }

        public Criteria andDzlvNotBetween(Integer value1, Integer value2) {
            addCriterion("DZLV not between", value1, value2, "dzlv");
            return (Criteria) this;
        }

        public Criteria andDdldfIsNull() {
            addCriterion("DDLDF is null");
            return (Criteria) this;
        }

        public Criteria andDdldfIsNotNull() {
            addCriterion("DDLDF is not null");
            return (Criteria) this;
        }

        public Criteria andDdldfEqualTo(Integer value) {
            addCriterion("DDLDF =", value, "ddldf");
            return (Criteria) this;
        }

        public Criteria andDdldfNotEqualTo(Integer value) {
            addCriterion("DDLDF <>", value, "ddldf");
            return (Criteria) this;
        }

        public Criteria andDdldfGreaterThan(Integer value) {
            addCriterion("DDLDF >", value, "ddldf");
            return (Criteria) this;
        }

        public Criteria andDdldfGreaterThanOrEqualTo(Integer value) {
            addCriterion("DDLDF >=", value, "ddldf");
            return (Criteria) this;
        }

        public Criteria andDdldfLessThan(Integer value) {
            addCriterion("DDLDF <", value, "ddldf");
            return (Criteria) this;
        }

        public Criteria andDdldfLessThanOrEqualTo(Integer value) {
            addCriterion("DDLDF <=", value, "ddldf");
            return (Criteria) this;
        }

        public Criteria andDdldfIn(List<Integer> values) {
            addCriterion("DDLDF in", values, "ddldf");
            return (Criteria) this;
        }

        public Criteria andDdldfNotIn(List<Integer> values) {
            addCriterion("DDLDF not in", values, "ddldf");
            return (Criteria) this;
        }

        public Criteria andDdldfBetween(Integer value1, Integer value2) {
            addCriterion("DDLDF between", value1, value2, "ddldf");
            return (Criteria) this;
        }

        public Criteria andDdldfNotBetween(Integer value1, Integer value2) {
            addCriterion("DDLDF not between", value1, value2, "ddldf");
            return (Criteria) this;
        }

        public Criteria andLdbzydlIsNull() {
            addCriterion("LDBZYDL is null");
            return (Criteria) this;
        }

        public Criteria andLdbzydlIsNotNull() {
            addCriterion("LDBZYDL is not null");
            return (Criteria) this;
        }

        public Criteria andLdbzydlEqualTo(Integer value) {
            addCriterion("LDBZYDL =", value, "ldbzydl");
            return (Criteria) this;
        }

        public Criteria andLdbzydlNotEqualTo(Integer value) {
            addCriterion("LDBZYDL <>", value, "ldbzydl");
            return (Criteria) this;
        }

        public Criteria andLdbzydlGreaterThan(Integer value) {
            addCriterion("LDBZYDL >", value, "ldbzydl");
            return (Criteria) this;
        }

        public Criteria andLdbzydlGreaterThanOrEqualTo(Integer value) {
            addCriterion("LDBZYDL >=", value, "ldbzydl");
            return (Criteria) this;
        }

        public Criteria andLdbzydlLessThan(Integer value) {
            addCriterion("LDBZYDL <", value, "ldbzydl");
            return (Criteria) this;
        }

        public Criteria andLdbzydlLessThanOrEqualTo(Integer value) {
            addCriterion("LDBZYDL <=", value, "ldbzydl");
            return (Criteria) this;
        }

        public Criteria andLdbzydlIn(List<Integer> values) {
            addCriterion("LDBZYDL in", values, "ldbzydl");
            return (Criteria) this;
        }

        public Criteria andLdbzydlNotIn(List<Integer> values) {
            addCriterion("LDBZYDL not in", values, "ldbzydl");
            return (Criteria) this;
        }

        public Criteria andLdbzydlBetween(Integer value1, Integer value2) {
            addCriterion("LDBZYDL between", value1, value2, "ldbzydl");
            return (Criteria) this;
        }

        public Criteria andLdbzydlNotBetween(Integer value1, Integer value2) {
            addCriterion("LDBZYDL not between", value1, value2, "ldbzydl");
            return (Criteria) this;
        }

        public Criteria andPjdzlIsNull() {
            addCriterion("PJDZL is null");
            return (Criteria) this;
        }

        public Criteria andPjdzlIsNotNull() {
            addCriterion("PJDZL is not null");
            return (Criteria) this;
        }

        public Criteria andPjdzlEqualTo(Integer value) {
            addCriterion("PJDZL =", value, "pjdzl");
            return (Criteria) this;
        }

        public Criteria andPjdzlNotEqualTo(Integer value) {
            addCriterion("PJDZL <>", value, "pjdzl");
            return (Criteria) this;
        }

        public Criteria andPjdzlGreaterThan(Integer value) {
            addCriterion("PJDZL >", value, "pjdzl");
            return (Criteria) this;
        }

        public Criteria andPjdzlGreaterThanOrEqualTo(Integer value) {
            addCriterion("PJDZL >=", value, "pjdzl");
            return (Criteria) this;
        }

        public Criteria andPjdzlLessThan(Integer value) {
            addCriterion("PJDZL <", value, "pjdzl");
            return (Criteria) this;
        }

        public Criteria andPjdzlLessThanOrEqualTo(Integer value) {
            addCriterion("PJDZL <=", value, "pjdzl");
            return (Criteria) this;
        }

        public Criteria andPjdzlIn(List<Integer> values) {
            addCriterion("PJDZL in", values, "pjdzl");
            return (Criteria) this;
        }

        public Criteria andPjdzlNotIn(List<Integer> values) {
            addCriterion("PJDZL not in", values, "pjdzl");
            return (Criteria) this;
        }

        public Criteria andPjdzlBetween(Integer value1, Integer value2) {
            addCriterion("PJDZL between", value1, value2, "pjdzl");
            return (Criteria) this;
        }

        public Criteria andPjdzlNotBetween(Integer value1, Integer value2) {
            addCriterion("PJDZL not between", value1, value2, "pjdzl");
            return (Criteria) this;
        }

        public Criteria andDdlIsNull() {
            addCriterion("DDL is null");
            return (Criteria) this;
        }

        public Criteria andDdlIsNotNull() {
            addCriterion("DDL is not null");
            return (Criteria) this;
        }

        public Criteria andDdlEqualTo(Integer value) {
            addCriterion("DDL =", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotEqualTo(Integer value) {
            addCriterion("DDL <>", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlGreaterThan(Integer value) {
            addCriterion("DDL >", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlGreaterThanOrEqualTo(Integer value) {
            addCriterion("DDL >=", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlLessThan(Integer value) {
            addCriterion("DDL <", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlLessThanOrEqualTo(Integer value) {
            addCriterion("DDL <=", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlIn(List<Integer> values) {
            addCriterion("DDL in", values, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotIn(List<Integer> values) {
            addCriterion("DDL not in", values, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlBetween(Integer value1, Integer value2) {
            addCriterion("DDL between", value1, value2, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotBetween(Integer value1, Integer value2) {
            addCriterion("DDL not between", value1, value2, "ddl");
            return (Criteria) this;
        }

        public Criteria andYdlvIsNull() {
            addCriterion("YDLV is null");
            return (Criteria) this;
        }

        public Criteria andYdlvIsNotNull() {
            addCriterion("YDLV is not null");
            return (Criteria) this;
        }

        public Criteria andYdlvEqualTo(Integer value) {
            addCriterion("YDLV =", value, "ydlv");
            return (Criteria) this;
        }

        public Criteria andYdlvNotEqualTo(Integer value) {
            addCriterion("YDLV <>", value, "ydlv");
            return (Criteria) this;
        }

        public Criteria andYdlvGreaterThan(Integer value) {
            addCriterion("YDLV >", value, "ydlv");
            return (Criteria) this;
        }

        public Criteria andYdlvGreaterThanOrEqualTo(Integer value) {
            addCriterion("YDLV >=", value, "ydlv");
            return (Criteria) this;
        }

        public Criteria andYdlvLessThan(Integer value) {
            addCriterion("YDLV <", value, "ydlv");
            return (Criteria) this;
        }

        public Criteria andYdlvLessThanOrEqualTo(Integer value) {
            addCriterion("YDLV <=", value, "ydlv");
            return (Criteria) this;
        }

        public Criteria andYdlvIn(List<Integer> values) {
            addCriterion("YDLV in", values, "ydlv");
            return (Criteria) this;
        }

        public Criteria andYdlvNotIn(List<Integer> values) {
            addCriterion("YDLV not in", values, "ydlv");
            return (Criteria) this;
        }

        public Criteria andYdlvBetween(Integer value1, Integer value2) {
            addCriterion("YDLV between", value1, value2, "ydlv");
            return (Criteria) this;
        }

        public Criteria andYdlvNotBetween(Integer value1, Integer value2) {
            addCriterion("YDLV not between", value1, value2, "ydlv");
            return (Criteria) this;
        }

        public Criteria andYdlIsNull() {
            addCriterion("YDL is null");
            return (Criteria) this;
        }

        public Criteria andYdlIsNotNull() {
            addCriterion("YDL is not null");
            return (Criteria) this;
        }

        public Criteria andYdlEqualTo(Integer value) {
            addCriterion("YDL =", value, "ydl");
            return (Criteria) this;
        }

        public Criteria andYdlNotEqualTo(Integer value) {
            addCriterion("YDL <>", value, "ydl");
            return (Criteria) this;
        }

        public Criteria andYdlGreaterThan(Integer value) {
            addCriterion("YDL >", value, "ydl");
            return (Criteria) this;
        }

        public Criteria andYdlGreaterThanOrEqualTo(Integer value) {
            addCriterion("YDL >=", value, "ydl");
            return (Criteria) this;
        }

        public Criteria andYdlLessThan(Integer value) {
            addCriterion("YDL <", value, "ydl");
            return (Criteria) this;
        }

        public Criteria andYdlLessThanOrEqualTo(Integer value) {
            addCriterion("YDL <=", value, "ydl");
            return (Criteria) this;
        }

        public Criteria andYdlIn(List<Integer> values) {
            addCriterion("YDL in", values, "ydl");
            return (Criteria) this;
        }

        public Criteria andYdlNotIn(List<Integer> values) {
            addCriterion("YDL not in", values, "ydl");
            return (Criteria) this;
        }

        public Criteria andYdlBetween(Integer value1, Integer value2) {
            addCriterion("YDL between", value1, value2, "ydl");
            return (Criteria) this;
        }

        public Criteria andYdlNotBetween(Integer value1, Integer value2) {
            addCriterion("YDL not between", value1, value2, "ydl");
            return (Criteria) this;
        }

        public Criteria andDzlIsNull() {
            addCriterion("DZL is null");
            return (Criteria) this;
        }

        public Criteria andDzlIsNotNull() {
            addCriterion("DZL is not null");
            return (Criteria) this;
        }

        public Criteria andDzlEqualTo(Integer value) {
            addCriterion("DZL =", value, "dzl");
            return (Criteria) this;
        }

        public Criteria andDzlNotEqualTo(Integer value) {
            addCriterion("DZL <>", value, "dzl");
            return (Criteria) this;
        }

        public Criteria andDzlGreaterThan(Integer value) {
            addCriterion("DZL >", value, "dzl");
            return (Criteria) this;
        }

        public Criteria andDzlGreaterThanOrEqualTo(Integer value) {
            addCriterion("DZL >=", value, "dzl");
            return (Criteria) this;
        }

        public Criteria andDzlLessThan(Integer value) {
            addCriterion("DZL <", value, "dzl");
            return (Criteria) this;
        }

        public Criteria andDzlLessThanOrEqualTo(Integer value) {
            addCriterion("DZL <=", value, "dzl");
            return (Criteria) this;
        }

        public Criteria andDzlIn(List<Integer> values) {
            addCriterion("DZL in", values, "dzl");
            return (Criteria) this;
        }

        public Criteria andDzlNotIn(List<Integer> values) {
            addCriterion("DZL not in", values, "dzl");
            return (Criteria) this;
        }

        public Criteria andDzlBetween(Integer value1, Integer value2) {
            addCriterion("DZL between", value1, value2, "dzl");
            return (Criteria) this;
        }

        public Criteria andDzlNotBetween(Integer value1, Integer value2) {
            addCriterion("DZL not between", value1, value2, "dzl");
            return (Criteria) this;
        }

        public Criteria andPjydlIsNull() {
            addCriterion("PJYDL is null");
            return (Criteria) this;
        }

        public Criteria andPjydlIsNotNull() {
            addCriterion("PJYDL is not null");
            return (Criteria) this;
        }

        public Criteria andPjydlEqualTo(Integer value) {
            addCriterion("PJYDL =", value, "pjydl");
            return (Criteria) this;
        }

        public Criteria andPjydlNotEqualTo(Integer value) {
            addCriterion("PJYDL <>", value, "pjydl");
            return (Criteria) this;
        }

        public Criteria andPjydlGreaterThan(Integer value) {
            addCriterion("PJYDL >", value, "pjydl");
            return (Criteria) this;
        }

        public Criteria andPjydlGreaterThanOrEqualTo(Integer value) {
            addCriterion("PJYDL >=", value, "pjydl");
            return (Criteria) this;
        }

        public Criteria andPjydlLessThan(Integer value) {
            addCriterion("PJYDL <", value, "pjydl");
            return (Criteria) this;
        }

        public Criteria andPjydlLessThanOrEqualTo(Integer value) {
            addCriterion("PJYDL <=", value, "pjydl");
            return (Criteria) this;
        }

        public Criteria andPjydlIn(List<Integer> values) {
            addCriterion("PJYDL in", values, "pjydl");
            return (Criteria) this;
        }

        public Criteria andPjydlNotIn(List<Integer> values) {
            addCriterion("PJYDL not in", values, "pjydl");
            return (Criteria) this;
        }

        public Criteria andPjydlBetween(Integer value1, Integer value2) {
            addCriterion("PJYDL between", value1, value2, "pjydl");
            return (Criteria) this;
        }

        public Criteria andPjydlNotBetween(Integer value1, Integer value2) {
            addCriterion("PJYDL not between", value1, value2, "pjydl");
            return (Criteria) this;
        }

        public Criteria andOrderbyIsNull() {
            addCriterion("ORDERBY is null");
            return (Criteria) this;
        }

        public Criteria andOrderbyIsNotNull() {
            addCriterion("ORDERBY is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbyEqualTo(Integer value) {
            addCriterion("ORDERBY =", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotEqualTo(Integer value) {
            addCriterion("ORDERBY <>", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThan(Integer value) {
            addCriterion("ORDERBY >", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDERBY >=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThan(Integer value) {
            addCriterion("ORDERBY <", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThanOrEqualTo(Integer value) {
            addCriterion("ORDERBY <=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyIn(List<Integer> values) {
            addCriterion("ORDERBY in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotIn(List<Integer> values) {
            addCriterion("ORDERBY not in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyBetween(Integer value1, Integer value2) {
            addCriterion("ORDERBY between", value1, value2, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDERBY not between", value1, value2, "orderby");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIsNull() {
            addCriterion("CREATEUSERID is null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIsNotNull() {
            addCriterion("CREATEUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridEqualTo(String value) {
            addCriterion("CREATEUSERID =", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotEqualTo(String value) {
            addCriterion("CREATEUSERID <>", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThan(String value) {
            addCriterion("CREATEUSERID >", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEUSERID >=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThan(String value) {
            addCriterion("CREATEUSERID <", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThanOrEqualTo(String value) {
            addCriterion("CREATEUSERID <=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLike(String value) {
            addCriterion("CREATEUSERID like", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotLike(String value) {
            addCriterion("CREATEUSERID not like", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIn(List<String> values) {
            addCriterion("CREATEUSERID in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotIn(List<String> values) {
            addCriterion("CREATEUSERID not in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridBetween(String value1, String value2) {
            addCriterion("CREATEUSERID between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotBetween(String value1, String value2) {
            addCriterion("CREATEUSERID not between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIsNull() {
            addCriterion("CREATEUSERNAME is null");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIsNotNull() {
            addCriterion("CREATEUSERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateusernameEqualTo(String value) {
            addCriterion("CREATEUSERNAME =", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotEqualTo(String value) {
            addCriterion("CREATEUSERNAME <>", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameGreaterThan(String value) {
            addCriterion("CREATEUSERNAME >", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEUSERNAME >=", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLessThan(String value) {
            addCriterion("CREATEUSERNAME <", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLessThanOrEqualTo(String value) {
            addCriterion("CREATEUSERNAME <=", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLike(String value) {
            addCriterion("CREATEUSERNAME like", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotLike(String value) {
            addCriterion("CREATEUSERNAME not like", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIn(List<String> values) {
            addCriterion("CREATEUSERNAME in", values, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotIn(List<String> values) {
            addCriterion("CREATEUSERNAME not in", values, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameBetween(String value1, String value2) {
            addCriterion("CREATEUSERNAME between", value1, value2, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotBetween(String value1, String value2) {
            addCriterion("CREATEUSERNAME not between", value1, value2, "createusername");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridIsNull() {
            addCriterion("UPDATEUSERID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridIsNotNull() {
            addCriterion("UPDATEUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridEqualTo(String value) {
            addCriterion("UPDATEUSERID =", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridNotEqualTo(String value) {
            addCriterion("UPDATEUSERID <>", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridGreaterThan(String value) {
            addCriterion("UPDATEUSERID >", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATEUSERID >=", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridLessThan(String value) {
            addCriterion("UPDATEUSERID <", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridLessThanOrEqualTo(String value) {
            addCriterion("UPDATEUSERID <=", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridLike(String value) {
            addCriterion("UPDATEUSERID like", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridNotLike(String value) {
            addCriterion("UPDATEUSERID not like", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridIn(List<String> values) {
            addCriterion("UPDATEUSERID in", values, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridNotIn(List<String> values) {
            addCriterion("UPDATEUSERID not in", values, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridBetween(String value1, String value2) {
            addCriterion("UPDATEUSERID between", value1, value2, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridNotBetween(String value1, String value2) {
            addCriterion("UPDATEUSERID not between", value1, value2, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIsNull() {
            addCriterion("UPDATEUSERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIsNotNull() {
            addCriterion("UPDATEUSERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameEqualTo(String value) {
            addCriterion("UPDATEUSERNAME =", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotEqualTo(String value) {
            addCriterion("UPDATEUSERNAME <>", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameGreaterThan(String value) {
            addCriterion("UPDATEUSERNAME >", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATEUSERNAME >=", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLessThan(String value) {
            addCriterion("UPDATEUSERNAME <", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLessThanOrEqualTo(String value) {
            addCriterion("UPDATEUSERNAME <=", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLike(String value) {
            addCriterion("UPDATEUSERNAME like", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotLike(String value) {
            addCriterion("UPDATEUSERNAME not like", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIn(List<String> values) {
            addCriterion("UPDATEUSERNAME in", values, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotIn(List<String> values) {
            addCriterion("UPDATEUSERNAME not in", values, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameBetween(String value1, String value2) {
            addCriterion("UPDATEUSERNAME between", value1, value2, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotBetween(String value1, String value2) {
            addCriterion("UPDATEUSERNAME not between", value1, value2, "updateusername");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIsNull() {
            addCriterion("OPERATETIME is null");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIsNotNull() {
            addCriterion("OPERATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperatetimeEqualTo(Date value) {
            addCriterion("OPERATETIME =", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotEqualTo(Date value) {
            addCriterion("OPERATETIME <>", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeGreaterThan(Date value) {
            addCriterion("OPERATETIME >", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPERATETIME >=", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeLessThan(Date value) {
            addCriterion("OPERATETIME <", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeLessThanOrEqualTo(Date value) {
            addCriterion("OPERATETIME <=", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIn(List<Date> values) {
            addCriterion("OPERATETIME in", values, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotIn(List<Date> values) {
            addCriterion("OPERATETIME not in", values, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeBetween(Date value1, Date value2) {
            addCriterion("OPERATETIME between", value1, value2, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotBetween(Date value1, Date value2) {
            addCriterion("OPERATETIME not between", value1, value2, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatestateIsNull() {
            addCriterion("OPERATESTATE is null");
            return (Criteria) this;
        }

        public Criteria andOperatestateIsNotNull() {
            addCriterion("OPERATESTATE is not null");
            return (Criteria) this;
        }

        public Criteria andOperatestateEqualTo(String value) {
            addCriterion("OPERATESTATE =", value, "operatestate");
            return (Criteria) this;
        }

        public Criteria andOperatestateNotEqualTo(String value) {
            addCriterion("OPERATESTATE <>", value, "operatestate");
            return (Criteria) this;
        }

        public Criteria andOperatestateGreaterThan(String value) {
            addCriterion("OPERATESTATE >", value, "operatestate");
            return (Criteria) this;
        }

        public Criteria andOperatestateGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATESTATE >=", value, "operatestate");
            return (Criteria) this;
        }

        public Criteria andOperatestateLessThan(String value) {
            addCriterion("OPERATESTATE <", value, "operatestate");
            return (Criteria) this;
        }

        public Criteria andOperatestateLessThanOrEqualTo(String value) {
            addCriterion("OPERATESTATE <=", value, "operatestate");
            return (Criteria) this;
        }

        public Criteria andOperatestateLike(String value) {
            addCriterion("OPERATESTATE like", value, "operatestate");
            return (Criteria) this;
        }

        public Criteria andOperatestateNotLike(String value) {
            addCriterion("OPERATESTATE not like", value, "operatestate");
            return (Criteria) this;
        }

        public Criteria andOperatestateIn(List<String> values) {
            addCriterion("OPERATESTATE in", values, "operatestate");
            return (Criteria) this;
        }

        public Criteria andOperatestateNotIn(List<String> values) {
            addCriterion("OPERATESTATE not in", values, "operatestate");
            return (Criteria) this;
        }

        public Criteria andOperatestateBetween(String value1, String value2) {
            addCriterion("OPERATESTATE between", value1, value2, "operatestate");
            return (Criteria) this;
        }

        public Criteria andOperatestateNotBetween(String value1, String value2) {
            addCriterion("OPERATESTATE not between", value1, value2, "operatestate");
            return (Criteria) this;
        }

        public Criteria andSyncstateIsNull() {
            addCriterion("SYNCSTATE is null");
            return (Criteria) this;
        }

        public Criteria andSyncstateIsNotNull() {
            addCriterion("SYNCSTATE is not null");
            return (Criteria) this;
        }

        public Criteria andSyncstateEqualTo(String value) {
            addCriterion("SYNCSTATE =", value, "syncstate");
            return (Criteria) this;
        }

        public Criteria andSyncstateNotEqualTo(String value) {
            addCriterion("SYNCSTATE <>", value, "syncstate");
            return (Criteria) this;
        }

        public Criteria andSyncstateGreaterThan(String value) {
            addCriterion("SYNCSTATE >", value, "syncstate");
            return (Criteria) this;
        }

        public Criteria andSyncstateGreaterThanOrEqualTo(String value) {
            addCriterion("SYNCSTATE >=", value, "syncstate");
            return (Criteria) this;
        }

        public Criteria andSyncstateLessThan(String value) {
            addCriterion("SYNCSTATE <", value, "syncstate");
            return (Criteria) this;
        }

        public Criteria andSyncstateLessThanOrEqualTo(String value) {
            addCriterion("SYNCSTATE <=", value, "syncstate");
            return (Criteria) this;
        }

        public Criteria andSyncstateLike(String value) {
            addCriterion("SYNCSTATE like", value, "syncstate");
            return (Criteria) this;
        }

        public Criteria andSyncstateNotLike(String value) {
            addCriterion("SYNCSTATE not like", value, "syncstate");
            return (Criteria) this;
        }

        public Criteria andSyncstateIn(List<String> values) {
            addCriterion("SYNCSTATE in", values, "syncstate");
            return (Criteria) this;
        }

        public Criteria andSyncstateNotIn(List<String> values) {
            addCriterion("SYNCSTATE not in", values, "syncstate");
            return (Criteria) this;
        }

        public Criteria andSyncstateBetween(String value1, String value2) {
            addCriterion("SYNCSTATE between", value1, value2, "syncstate");
            return (Criteria) this;
        }

        public Criteria andSyncstateNotBetween(String value1, String value2) {
            addCriterion("SYNCSTATE not between", value1, value2, "syncstate");
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