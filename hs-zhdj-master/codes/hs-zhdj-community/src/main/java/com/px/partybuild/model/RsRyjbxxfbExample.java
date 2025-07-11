package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RsRyjbxxfbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RsRyjbxxfbExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSfzgIsNull() {
            addCriterion("SFZG is null");
            return (Criteria) this;
        }

        public Criteria andSfzgIsNotNull() {
            addCriterion("SFZG is not null");
            return (Criteria) this;
        }

        public Criteria andSfzgEqualTo(Integer value) {
            addCriterion("SFZG =", value, "sfzg");
            return (Criteria) this;
        }

        public Criteria andSfzgNotEqualTo(Integer value) {
            addCriterion("SFZG <>", value, "sfzg");
            return (Criteria) this;
        }

        public Criteria andSfzgGreaterThan(Integer value) {
            addCriterion("SFZG >", value, "sfzg");
            return (Criteria) this;
        }

        public Criteria andSfzgGreaterThanOrEqualTo(Integer value) {
            addCriterion("SFZG >=", value, "sfzg");
            return (Criteria) this;
        }

        public Criteria andSfzgLessThan(Integer value) {
            addCriterion("SFZG <", value, "sfzg");
            return (Criteria) this;
        }

        public Criteria andSfzgLessThanOrEqualTo(Integer value) {
            addCriterion("SFZG <=", value, "sfzg");
            return (Criteria) this;
        }

        public Criteria andSfzgIn(List<Integer> values) {
            addCriterion("SFZG in", values, "sfzg");
            return (Criteria) this;
        }

        public Criteria andSfzgNotIn(List<Integer> values) {
            addCriterion("SFZG not in", values, "sfzg");
            return (Criteria) this;
        }

        public Criteria andSfzgBetween(Integer value1, Integer value2) {
            addCriterion("SFZG between", value1, value2, "sfzg");
            return (Criteria) this;
        }

        public Criteria andSfzgNotBetween(Integer value1, Integer value2) {
            addCriterion("SFZG not between", value1, value2, "sfzg");
            return (Criteria) this;
        }

        public Criteria andBzgyyIsNull() {
            addCriterion("BZGYY is null");
            return (Criteria) this;
        }

        public Criteria andBzgyyIsNotNull() {
            addCriterion("BZGYY is not null");
            return (Criteria) this;
        }

        public Criteria andBzgyyEqualTo(String value) {
            addCriterion("BZGYY =", value, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andBzgyyNotEqualTo(String value) {
            addCriterion("BZGYY <>", value, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andBzgyyGreaterThan(String value) {
            addCriterion("BZGYY >", value, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andBzgyyGreaterThanOrEqualTo(String value) {
            addCriterion("BZGYY >=", value, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andBzgyyLessThan(String value) {
            addCriterion("BZGYY <", value, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andBzgyyLessThanOrEqualTo(String value) {
            addCriterion("BZGYY <=", value, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andBzgyyLike(String value) {
            addCriterion("BZGYY like", value, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andBzgyyNotLike(String value) {
            addCriterion("BZGYY not like", value, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andBzgyyIn(List<String> values) {
            addCriterion("BZGYY in", values, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andBzgyyNotIn(List<String> values) {
            addCriterion("BZGYY not in", values, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andBzgyyBetween(String value1, String value2) {
            addCriterion("BZGYY between", value1, value2, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andBzgyyNotBetween(String value1, String value2) {
            addCriterion("BZGYY not between", value1, value2, "bzgyy");
            return (Criteria) this;
        }

        public Criteria andSfsldryIsNull() {
            addCriterion("SFSLDRY is null");
            return (Criteria) this;
        }

        public Criteria andSfsldryIsNotNull() {
            addCriterion("SFSLDRY is not null");
            return (Criteria) this;
        }

        public Criteria andSfsldryEqualTo(Integer value) {
            addCriterion("SFSLDRY =", value, "sfsldry");
            return (Criteria) this;
        }

        public Criteria andSfsldryNotEqualTo(Integer value) {
            addCriterion("SFSLDRY <>", value, "sfsldry");
            return (Criteria) this;
        }

        public Criteria andSfsldryGreaterThan(Integer value) {
            addCriterion("SFSLDRY >", value, "sfsldry");
            return (Criteria) this;
        }

        public Criteria andSfsldryGreaterThanOrEqualTo(Integer value) {
            addCriterion("SFSLDRY >=", value, "sfsldry");
            return (Criteria) this;
        }

        public Criteria andSfsldryLessThan(Integer value) {
            addCriterion("SFSLDRY <", value, "sfsldry");
            return (Criteria) this;
        }

        public Criteria andSfsldryLessThanOrEqualTo(Integer value) {
            addCriterion("SFSLDRY <=", value, "sfsldry");
            return (Criteria) this;
        }

        public Criteria andSfsldryIn(List<Integer> values) {
            addCriterion("SFSLDRY in", values, "sfsldry");
            return (Criteria) this;
        }

        public Criteria andSfsldryNotIn(List<Integer> values) {
            addCriterion("SFSLDRY not in", values, "sfsldry");
            return (Criteria) this;
        }

        public Criteria andSfsldryBetween(Integer value1, Integer value2) {
            addCriterion("SFSLDRY between", value1, value2, "sfsldry");
            return (Criteria) this;
        }

        public Criteria andSfsldryNotBetween(Integer value1, Integer value2) {
            addCriterion("SFSLDRY not between", value1, value2, "sfsldry");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmIsNull() {
            addCriterion("LDRYLXDBM is null");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmIsNotNull() {
            addCriterion("LDRYLXDBM is not null");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmEqualTo(String value) {
            addCriterion("LDRYLXDBM =", value, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmNotEqualTo(String value) {
            addCriterion("LDRYLXDBM <>", value, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmGreaterThan(String value) {
            addCriterion("LDRYLXDBM >", value, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmGreaterThanOrEqualTo(String value) {
            addCriterion("LDRYLXDBM >=", value, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmLessThan(String value) {
            addCriterion("LDRYLXDBM <", value, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmLessThanOrEqualTo(String value) {
            addCriterion("LDRYLXDBM <=", value, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmLike(String value) {
            addCriterion("LDRYLXDBM like", value, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmNotLike(String value) {
            addCriterion("LDRYLXDBM not like", value, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmIn(List<String> values) {
            addCriterion("LDRYLXDBM in", values, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmNotIn(List<String> values) {
            addCriterion("LDRYLXDBM not in", values, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmBetween(String value1, String value2) {
            addCriterion("LDRYLXDBM between", value1, value2, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdbmNotBetween(String value1, String value2) {
            addCriterion("LDRYLXDBM not between", value1, value2, "ldrylxdbm");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcIsNull() {
            addCriterion("LDRYLXDMC is null");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcIsNotNull() {
            addCriterion("LDRYLXDMC is not null");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcEqualTo(String value) {
            addCriterion("LDRYLXDMC =", value, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcNotEqualTo(String value) {
            addCriterion("LDRYLXDMC <>", value, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcGreaterThan(String value) {
            addCriterion("LDRYLXDMC >", value, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcGreaterThanOrEqualTo(String value) {
            addCriterion("LDRYLXDMC >=", value, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcLessThan(String value) {
            addCriterion("LDRYLXDMC <", value, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcLessThanOrEqualTo(String value) {
            addCriterion("LDRYLXDMC <=", value, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcLike(String value) {
            addCriterion("LDRYLXDMC like", value, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcNotLike(String value) {
            addCriterion("LDRYLXDMC not like", value, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcIn(List<String> values) {
            addCriterion("LDRYLXDMC in", values, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcNotIn(List<String> values) {
            addCriterion("LDRYLXDMC not in", values, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcBetween(String value1, String value2) {
            addCriterion("LDRYLXDMC between", value1, value2, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andLdrylxdmcNotBetween(String value1, String value2) {
            addCriterion("LDRYLXDMC not between", value1, value2, "ldrylxdmc");
            return (Criteria) this;
        }

        public Criteria andNlIsNull() {
            addCriterion("NL is null");
            return (Criteria) this;
        }

        public Criteria andNlIsNotNull() {
            addCriterion("NL is not null");
            return (Criteria) this;
        }

        public Criteria andNlEqualTo(Integer value) {
            addCriterion("NL =", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlNotEqualTo(Integer value) {
            addCriterion("NL <>", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlGreaterThan(Integer value) {
            addCriterion("NL >", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlGreaterThanOrEqualTo(Integer value) {
            addCriterion("NL >=", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlLessThan(Integer value) {
            addCriterion("NL <", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlLessThanOrEqualTo(Integer value) {
            addCriterion("NL <=", value, "nl");
            return (Criteria) this;
        }

        public Criteria andNlIn(List<Integer> values) {
            addCriterion("NL in", values, "nl");
            return (Criteria) this;
        }

        public Criteria andNlNotIn(List<Integer> values) {
            addCriterion("NL not in", values, "nl");
            return (Criteria) this;
        }

        public Criteria andNlBetween(Integer value1, Integer value2) {
            addCriterion("NL between", value1, value2, "nl");
            return (Criteria) this;
        }

        public Criteria andNlNotBetween(Integer value1, Integer value2) {
            addCriterion("NL not between", value1, value2, "nl");
            return (Criteria) this;
        }

        public Criteria andLeadtypeIsNull() {
            addCriterion("LEADTYPE is null");
            return (Criteria) this;
        }

        public Criteria andLeadtypeIsNotNull() {
            addCriterion("LEADTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLeadtypeEqualTo(Integer value) {
            addCriterion("LEADTYPE =", value, "leadtype");
            return (Criteria) this;
        }

        public Criteria andLeadtypeNotEqualTo(Integer value) {
            addCriterion("LEADTYPE <>", value, "leadtype");
            return (Criteria) this;
        }

        public Criteria andLeadtypeGreaterThan(Integer value) {
            addCriterion("LEADTYPE >", value, "leadtype");
            return (Criteria) this;
        }

        public Criteria andLeadtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LEADTYPE >=", value, "leadtype");
            return (Criteria) this;
        }

        public Criteria andLeadtypeLessThan(Integer value) {
            addCriterion("LEADTYPE <", value, "leadtype");
            return (Criteria) this;
        }

        public Criteria andLeadtypeLessThanOrEqualTo(Integer value) {
            addCriterion("LEADTYPE <=", value, "leadtype");
            return (Criteria) this;
        }

        public Criteria andLeadtypeIn(List<Integer> values) {
            addCriterion("LEADTYPE in", values, "leadtype");
            return (Criteria) this;
        }

        public Criteria andLeadtypeNotIn(List<Integer> values) {
            addCriterion("LEADTYPE not in", values, "leadtype");
            return (Criteria) this;
        }

        public Criteria andLeadtypeBetween(Integer value1, Integer value2) {
            addCriterion("LEADTYPE between", value1, value2, "leadtype");
            return (Criteria) this;
        }

        public Criteria andLeadtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LEADTYPE not between", value1, value2, "leadtype");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNull() {
            addCriterion("APPLYDATE is null");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNotNull() {
            addCriterion("APPLYDATE is not null");
            return (Criteria) this;
        }

        public Criteria andApplydateEqualTo(Date value) {
            addCriterionForJDBCDate("APPLYDATE =", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotEqualTo(Date value) {
            addCriterionForJDBCDate("APPLYDATE <>", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThan(Date value) {
            addCriterionForJDBCDate("APPLYDATE >", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("APPLYDATE >=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThan(Date value) {
            addCriterionForJDBCDate("APPLYDATE <", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("APPLYDATE <=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateIn(List<Date> values) {
            addCriterionForJDBCDate("APPLYDATE in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotIn(List<Date> values) {
            addCriterionForJDBCDate("APPLYDATE not in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("APPLYDATE between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("APPLYDATE not between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andActivedateIsNull() {
            addCriterion("ACTIVEDATE is null");
            return (Criteria) this;
        }

        public Criteria andActivedateIsNotNull() {
            addCriterion("ACTIVEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andActivedateEqualTo(Date value) {
            addCriterionForJDBCDate("ACTIVEDATE =", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ACTIVEDATE <>", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateGreaterThan(Date value) {
            addCriterionForJDBCDate("ACTIVEDATE >", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ACTIVEDATE >=", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateLessThan(Date value) {
            addCriterionForJDBCDate("ACTIVEDATE <", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ACTIVEDATE <=", value, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateIn(List<Date> values) {
            addCriterionForJDBCDate("ACTIVEDATE in", values, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ACTIVEDATE not in", values, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ACTIVEDATE between", value1, value2, "activedate");
            return (Criteria) this;
        }

        public Criteria andActivedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ACTIVEDATE not between", value1, value2, "activedate");
            return (Criteria) this;
        }

        public Criteria andPassdateIsNull() {
            addCriterion("PASSDATE is null");
            return (Criteria) this;
        }

        public Criteria andPassdateIsNotNull() {
            addCriterion("PASSDATE is not null");
            return (Criteria) this;
        }

        public Criteria andPassdateEqualTo(Date value) {
            addCriterionForJDBCDate("PASSDATE =", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PASSDATE <>", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateGreaterThan(Date value) {
            addCriterionForJDBCDate("PASSDATE >", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PASSDATE >=", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateLessThan(Date value) {
            addCriterionForJDBCDate("PASSDATE <", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PASSDATE <=", value, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateIn(List<Date> values) {
            addCriterionForJDBCDate("PASSDATE in", values, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PASSDATE not in", values, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PASSDATE between", value1, value2, "passdate");
            return (Criteria) this;
        }

        public Criteria andPassdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PASSDATE not between", value1, value2, "passdate");
            return (Criteria) this;
        }

        public Criteria andIsarchiveIsNull() {
            addCriterion("ISARCHIVE is null");
            return (Criteria) this;
        }

        public Criteria andIsarchiveIsNotNull() {
            addCriterion("ISARCHIVE is not null");
            return (Criteria) this;
        }

        public Criteria andIsarchiveEqualTo(Integer value) {
            addCriterion("ISARCHIVE =", value, "isarchive");
            return (Criteria) this;
        }

        public Criteria andIsarchiveNotEqualTo(Integer value) {
            addCriterion("ISARCHIVE <>", value, "isarchive");
            return (Criteria) this;
        }

        public Criteria andIsarchiveGreaterThan(Integer value) {
            addCriterion("ISARCHIVE >", value, "isarchive");
            return (Criteria) this;
        }

        public Criteria andIsarchiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISARCHIVE >=", value, "isarchive");
            return (Criteria) this;
        }

        public Criteria andIsarchiveLessThan(Integer value) {
            addCriterion("ISARCHIVE <", value, "isarchive");
            return (Criteria) this;
        }

        public Criteria andIsarchiveLessThanOrEqualTo(Integer value) {
            addCriterion("ISARCHIVE <=", value, "isarchive");
            return (Criteria) this;
        }

        public Criteria andIsarchiveIn(List<Integer> values) {
            addCriterion("ISARCHIVE in", values, "isarchive");
            return (Criteria) this;
        }

        public Criteria andIsarchiveNotIn(List<Integer> values) {
            addCriterion("ISARCHIVE not in", values, "isarchive");
            return (Criteria) this;
        }

        public Criteria andIsarchiveBetween(Integer value1, Integer value2) {
            addCriterion("ISARCHIVE between", value1, value2, "isarchive");
            return (Criteria) this;
        }

        public Criteria andIsarchiveNotBetween(Integer value1, Integer value2) {
            addCriterion("ISARCHIVE not between", value1, value2, "isarchive");
            return (Criteria) this;
        }

        public Criteria andGradenameIsNull() {
            addCriterion("gradeName is null");
            return (Criteria) this;
        }

        public Criteria andGradenameIsNotNull() {
            addCriterion("gradeName is not null");
            return (Criteria) this;
        }

        public Criteria andGradenameEqualTo(String value) {
            addCriterion("gradeName =", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameNotEqualTo(String value) {
            addCriterion("gradeName <>", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameGreaterThan(String value) {
            addCriterion("gradeName >", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameGreaterThanOrEqualTo(String value) {
            addCriterion("gradeName >=", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameLessThan(String value) {
            addCriterion("gradeName <", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameLessThanOrEqualTo(String value) {
            addCriterion("gradeName <=", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameLike(String value) {
            addCriterion("gradeName like", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameNotLike(String value) {
            addCriterion("gradeName not like", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameIn(List<String> values) {
            addCriterion("gradeName in", values, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameNotIn(List<String> values) {
            addCriterion("gradeName not in", values, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameBetween(String value1, String value2) {
            addCriterion("gradeName between", value1, value2, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameNotBetween(String value1, String value2) {
            addCriterion("gradeName not between", value1, value2, "gradename");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNull() {
            addCriterion("className is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("className is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("className =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("className <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("className >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("className >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("className <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("className <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("className like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("className not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("className in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("className not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("className between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("className not between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateIsNull() {
            addCriterion("enrollmentDate is null");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateIsNotNull() {
            addCriterion("enrollmentDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateEqualTo(Date value) {
            addCriterionForJDBCDate("enrollmentDate =", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("enrollmentDate <>", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateGreaterThan(Date value) {
            addCriterionForJDBCDate("enrollmentDate >", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enrollmentDate >=", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateLessThan(Date value) {
            addCriterionForJDBCDate("enrollmentDate <", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enrollmentDate <=", value, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateIn(List<Date> values) {
            addCriterionForJDBCDate("enrollmentDate in", values, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("enrollmentDate not in", values, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enrollmentDate between", value1, value2, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andEnrollmentdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enrollmentDate not between", value1, value2, "enrollmentdate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateIsNull() {
            addCriterion("graduateDate is null");
            return (Criteria) this;
        }

        public Criteria andGraduatedateIsNotNull() {
            addCriterion("graduateDate is not null");
            return (Criteria) this;
        }

        public Criteria andGraduatedateEqualTo(Date value) {
            addCriterionForJDBCDate("graduateDate =", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("graduateDate <>", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("graduateDate >", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("graduateDate >=", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateLessThan(Date value) {
            addCriterionForJDBCDate("graduateDate <", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("graduateDate <=", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateIn(List<Date> values) {
            addCriterionForJDBCDate("graduateDate in", values, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("graduateDate not in", values, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("graduateDate between", value1, value2, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("graduateDate not between", value1, value2, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andWorkdateIsNull() {
            addCriterion("workDate is null");
            return (Criteria) this;
        }

        public Criteria andWorkdateIsNotNull() {
            addCriterion("workDate is not null");
            return (Criteria) this;
        }

        public Criteria andWorkdateEqualTo(Date value) {
            addCriterionForJDBCDate("workDate =", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("workDate <>", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateGreaterThan(Date value) {
            addCriterionForJDBCDate("workDate >", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("workDate >=", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateLessThan(Date value) {
            addCriterionForJDBCDate("workDate <", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("workDate <=", value, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateIn(List<Date> values) {
            addCriterionForJDBCDate("workDate in", values, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("workDate not in", values, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("workDate between", value1, value2, "workdate");
            return (Criteria) this;
        }

        public Criteria andWorkdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("workDate not between", value1, value2, "workdate");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionIsNull() {
            addCriterion("technologyPosition is null");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionIsNotNull() {
            addCriterion("technologyPosition is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionEqualTo(String value) {
            addCriterion("technologyPosition =", value, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionNotEqualTo(String value) {
            addCriterion("technologyPosition <>", value, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionGreaterThan(String value) {
            addCriterion("technologyPosition >", value, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionGreaterThanOrEqualTo(String value) {
            addCriterion("technologyPosition >=", value, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionLessThan(String value) {
            addCriterion("technologyPosition <", value, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionLessThanOrEqualTo(String value) {
            addCriterion("technologyPosition <=", value, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionLike(String value) {
            addCriterion("technologyPosition like", value, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionNotLike(String value) {
            addCriterion("technologyPosition not like", value, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionIn(List<String> values) {
            addCriterion("technologyPosition in", values, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionNotIn(List<String> values) {
            addCriterion("technologyPosition not in", values, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionBetween(String value1, String value2) {
            addCriterion("technologyPosition between", value1, value2, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTechnologypositionNotBetween(String value1, String value2) {
            addCriterion("technologyPosition not between", value1, value2, "technologyposition");
            return (Criteria) this;
        }

        public Criteria andTrainuser1IsNull() {
            addCriterion("trainUser1 is null");
            return (Criteria) this;
        }

        public Criteria andTrainuser1IsNotNull() {
            addCriterion("trainUser1 is not null");
            return (Criteria) this;
        }

        public Criteria andTrainuser1EqualTo(String value) {
            addCriterion("trainUser1 =", value, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser1NotEqualTo(String value) {
            addCriterion("trainUser1 <>", value, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser1GreaterThan(String value) {
            addCriterion("trainUser1 >", value, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser1GreaterThanOrEqualTo(String value) {
            addCriterion("trainUser1 >=", value, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser1LessThan(String value) {
            addCriterion("trainUser1 <", value, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser1LessThanOrEqualTo(String value) {
            addCriterion("trainUser1 <=", value, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser1Like(String value) {
            addCriterion("trainUser1 like", value, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser1NotLike(String value) {
            addCriterion("trainUser1 not like", value, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser1In(List<String> values) {
            addCriterion("trainUser1 in", values, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser1NotIn(List<String> values) {
            addCriterion("trainUser1 not in", values, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser1Between(String value1, String value2) {
            addCriterion("trainUser1 between", value1, value2, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser1NotBetween(String value1, String value2) {
            addCriterion("trainUser1 not between", value1, value2, "trainuser1");
            return (Criteria) this;
        }

        public Criteria andTrainuser2IsNull() {
            addCriterion("trainUser2 is null");
            return (Criteria) this;
        }

        public Criteria andTrainuser2IsNotNull() {
            addCriterion("trainUser2 is not null");
            return (Criteria) this;
        }

        public Criteria andTrainuser2EqualTo(String value) {
            addCriterion("trainUser2 =", value, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andTrainuser2NotEqualTo(String value) {
            addCriterion("trainUser2 <>", value, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andTrainuser2GreaterThan(String value) {
            addCriterion("trainUser2 >", value, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andTrainuser2GreaterThanOrEqualTo(String value) {
            addCriterion("trainUser2 >=", value, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andTrainuser2LessThan(String value) {
            addCriterion("trainUser2 <", value, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andTrainuser2LessThanOrEqualTo(String value) {
            addCriterion("trainUser2 <=", value, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andTrainuser2Like(String value) {
            addCriterion("trainUser2 like", value, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andTrainuser2NotLike(String value) {
            addCriterion("trainUser2 not like", value, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andTrainuser2In(List<String> values) {
            addCriterion("trainUser2 in", values, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andTrainuser2NotIn(List<String> values) {
            addCriterion("trainUser2 not in", values, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andTrainuser2Between(String value1, String value2) {
            addCriterion("trainUser2 between", value1, value2, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andTrainuser2NotBetween(String value1, String value2) {
            addCriterion("trainUser2 not between", value1, value2, "trainuser2");
            return (Criteria) this;
        }

        public Criteria andIsstudentIsNull() {
            addCriterion("isStudent is null");
            return (Criteria) this;
        }

        public Criteria andIsstudentIsNotNull() {
            addCriterion("isStudent is not null");
            return (Criteria) this;
        }

        public Criteria andIsstudentEqualTo(Boolean value) {
            addCriterion("isStudent =", value, "isstudent");
            return (Criteria) this;
        }

        public Criteria andIsstudentNotEqualTo(Boolean value) {
            addCriterion("isStudent <>", value, "isstudent");
            return (Criteria) this;
        }

        public Criteria andIsstudentGreaterThan(Boolean value) {
            addCriterion("isStudent >", value, "isstudent");
            return (Criteria) this;
        }

        public Criteria andIsstudentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isStudent >=", value, "isstudent");
            return (Criteria) this;
        }

        public Criteria andIsstudentLessThan(Boolean value) {
            addCriterion("isStudent <", value, "isstudent");
            return (Criteria) this;
        }

        public Criteria andIsstudentLessThanOrEqualTo(Boolean value) {
            addCriterion("isStudent <=", value, "isstudent");
            return (Criteria) this;
        }

        public Criteria andIsstudentIn(List<Boolean> values) {
            addCriterion("isStudent in", values, "isstudent");
            return (Criteria) this;
        }

        public Criteria andIsstudentNotIn(List<Boolean> values) {
            addCriterion("isStudent not in", values, "isstudent");
            return (Criteria) this;
        }

        public Criteria andIsstudentBetween(Boolean value1, Boolean value2) {
            addCriterion("isStudent between", value1, value2, "isstudent");
            return (Criteria) this;
        }

        public Criteria andIsstudentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isStudent not between", value1, value2, "isstudent");
            return (Criteria) this;
        }

        public Criteria andExportdateIsNull() {
            addCriterion("exportDate is null");
            return (Criteria) this;
        }

        public Criteria andExportdateIsNotNull() {
            addCriterion("exportDate is not null");
            return (Criteria) this;
        }

        public Criteria andExportdateEqualTo(Date value) {
            addCriterionForJDBCDate("exportDate =", value, "exportdate");
            return (Criteria) this;
        }

        public Criteria andExportdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("exportDate <>", value, "exportdate");
            return (Criteria) this;
        }

        public Criteria andExportdateGreaterThan(Date value) {
            addCriterionForJDBCDate("exportDate >", value, "exportdate");
            return (Criteria) this;
        }

        public Criteria andExportdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("exportDate >=", value, "exportdate");
            return (Criteria) this;
        }

        public Criteria andExportdateLessThan(Date value) {
            addCriterionForJDBCDate("exportDate <", value, "exportdate");
            return (Criteria) this;
        }

        public Criteria andExportdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("exportDate <=", value, "exportdate");
            return (Criteria) this;
        }

        public Criteria andExportdateIn(List<Date> values) {
            addCriterionForJDBCDate("exportDate in", values, "exportdate");
            return (Criteria) this;
        }

        public Criteria andExportdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("exportDate not in", values, "exportdate");
            return (Criteria) this;
        }

        public Criteria andExportdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("exportDate between", value1, value2, "exportdate");
            return (Criteria) this;
        }

        public Criteria andExportdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("exportDate not between", value1, value2, "exportdate");
            return (Criteria) this;
        }

        public Criteria andExportpartynameIsNull() {
            addCriterion("exportPartyName is null");
            return (Criteria) this;
        }

        public Criteria andExportpartynameIsNotNull() {
            addCriterion("exportPartyName is not null");
            return (Criteria) this;
        }

        public Criteria andExportpartynameEqualTo(String value) {
            addCriterion("exportPartyName =", value, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andExportpartynameNotEqualTo(String value) {
            addCriterion("exportPartyName <>", value, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andExportpartynameGreaterThan(String value) {
            addCriterion("exportPartyName >", value, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andExportpartynameGreaterThanOrEqualTo(String value) {
            addCriterion("exportPartyName >=", value, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andExportpartynameLessThan(String value) {
            addCriterion("exportPartyName <", value, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andExportpartynameLessThanOrEqualTo(String value) {
            addCriterion("exportPartyName <=", value, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andExportpartynameLike(String value) {
            addCriterion("exportPartyName like", value, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andExportpartynameNotLike(String value) {
            addCriterion("exportPartyName not like", value, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andExportpartynameIn(List<String> values) {
            addCriterion("exportPartyName in", values, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andExportpartynameNotIn(List<String> values) {
            addCriterion("exportPartyName not in", values, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andExportpartynameBetween(String value1, String value2) {
            addCriterion("exportPartyName between", value1, value2, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andExportpartynameNotBetween(String value1, String value2) {
            addCriterion("exportPartyName not between", value1, value2, "exportpartyname");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusIsNull() {
            addCriterion("applyApproveStatus is null");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusIsNotNull() {
            addCriterion("applyApproveStatus is not null");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusEqualTo(Integer value) {
            addCriterion("applyApproveStatus =", value, "applyapprovestatus");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusNotEqualTo(Integer value) {
            addCriterion("applyApproveStatus <>", value, "applyapprovestatus");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusGreaterThan(Integer value) {
            addCriterion("applyApproveStatus >", value, "applyapprovestatus");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("applyApproveStatus >=", value, "applyapprovestatus");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusLessThan(Integer value) {
            addCriterion("applyApproveStatus <", value, "applyapprovestatus");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusLessThanOrEqualTo(Integer value) {
            addCriterion("applyApproveStatus <=", value, "applyapprovestatus");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusIn(List<Integer> values) {
            addCriterion("applyApproveStatus in", values, "applyapprovestatus");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusNotIn(List<Integer> values) {
            addCriterion("applyApproveStatus not in", values, "applyapprovestatus");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusBetween(Integer value1, Integer value2) {
            addCriterion("applyApproveStatus between", value1, value2, "applyapprovestatus");
            return (Criteria) this;
        }

        public Criteria andApplyapprovestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("applyApproveStatus not between", value1, value2, "applyapprovestatus");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidIsNull() {
            addCriterion("applyFileReId is null");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidIsNotNull() {
            addCriterion("applyFileReId is not null");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidEqualTo(String value) {
            addCriterion("applyFileReId =", value, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidNotEqualTo(String value) {
            addCriterion("applyFileReId <>", value, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidGreaterThan(String value) {
            addCriterion("applyFileReId >", value, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidGreaterThanOrEqualTo(String value) {
            addCriterion("applyFileReId >=", value, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidLessThan(String value) {
            addCriterion("applyFileReId <", value, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidLessThanOrEqualTo(String value) {
            addCriterion("applyFileReId <=", value, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidLike(String value) {
            addCriterion("applyFileReId like", value, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidNotLike(String value) {
            addCriterion("applyFileReId not like", value, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidIn(List<String> values) {
            addCriterion("applyFileReId in", values, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidNotIn(List<String> values) {
            addCriterion("applyFileReId not in", values, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidBetween(String value1, String value2) {
            addCriterion("applyFileReId between", value1, value2, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andApplyfilereidNotBetween(String value1, String value2) {
            addCriterion("applyFileReId not between", value1, value2, "applyfilereid");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthIsNull() {
            addCriterion("partyDuesStartMonth is null");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthIsNotNull() {
            addCriterion("partyDuesStartMonth is not null");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthEqualTo(Integer value) {
            addCriterion("partyDuesStartMonth =", value, "partyduesstartmonth");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthNotEqualTo(Integer value) {
            addCriterion("partyDuesStartMonth <>", value, "partyduesstartmonth");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthGreaterThan(Integer value) {
            addCriterion("partyDuesStartMonth >", value, "partyduesstartmonth");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("partyDuesStartMonth >=", value, "partyduesstartmonth");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthLessThan(Integer value) {
            addCriterion("partyDuesStartMonth <", value, "partyduesstartmonth");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthLessThanOrEqualTo(Integer value) {
            addCriterion("partyDuesStartMonth <=", value, "partyduesstartmonth");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthIn(List<Integer> values) {
            addCriterion("partyDuesStartMonth in", values, "partyduesstartmonth");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthNotIn(List<Integer> values) {
            addCriterion("partyDuesStartMonth not in", values, "partyduesstartmonth");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthBetween(Integer value1, Integer value2) {
            addCriterion("partyDuesStartMonth between", value1, value2, "partyduesstartmonth");
            return (Criteria) this;
        }

        public Criteria andPartyduesstartmonthNotBetween(Integer value1, Integer value2) {
            addCriterion("partyDuesStartMonth not between", value1, value2, "partyduesstartmonth");
            return (Criteria) this;
        }

        public Criteria andArchivedateIsNull() {
            addCriterion("archiveDate is null");
            return (Criteria) this;
        }

        public Criteria andArchivedateIsNotNull() {
            addCriterion("archiveDate is not null");
            return (Criteria) this;
        }

        public Criteria andArchivedateEqualTo(Date value) {
            addCriterionForJDBCDate("archiveDate =", value, "archivedate");
            return (Criteria) this;
        }

        public Criteria andArchivedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("archiveDate <>", value, "archivedate");
            return (Criteria) this;
        }

        public Criteria andArchivedateGreaterThan(Date value) {
            addCriterionForJDBCDate("archiveDate >", value, "archivedate");
            return (Criteria) this;
        }

        public Criteria andArchivedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("archiveDate >=", value, "archivedate");
            return (Criteria) this;
        }

        public Criteria andArchivedateLessThan(Date value) {
            addCriterionForJDBCDate("archiveDate <", value, "archivedate");
            return (Criteria) this;
        }

        public Criteria andArchivedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("archiveDate <=", value, "archivedate");
            return (Criteria) this;
        }

        public Criteria andArchivedateIn(List<Date> values) {
            addCriterionForJDBCDate("archiveDate in", values, "archivedate");
            return (Criteria) this;
        }

        public Criteria andArchivedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("archiveDate not in", values, "archivedate");
            return (Criteria) this;
        }

        public Criteria andArchivedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("archiveDate between", value1, value2, "archivedate");
            return (Criteria) this;
        }

        public Criteria andArchivedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("archiveDate not between", value1, value2, "archivedate");
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