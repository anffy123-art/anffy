package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class YsJfysmxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YsJfysmxExample() {
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

        public Criteria andYsmxidIsNull() {
            addCriterion("YSMXID is null");
            return (Criteria) this;
        }

        public Criteria andYsmxidIsNotNull() {
            addCriterion("YSMXID is not null");
            return (Criteria) this;
        }

        public Criteria andYsmxidEqualTo(String value) {
            addCriterion("YSMXID =", value, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andYsmxidNotEqualTo(String value) {
            addCriterion("YSMXID <>", value, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andYsmxidGreaterThan(String value) {
            addCriterion("YSMXID >", value, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andYsmxidGreaterThanOrEqualTo(String value) {
            addCriterion("YSMXID >=", value, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andYsmxidLessThan(String value) {
            addCriterion("YSMXID <", value, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andYsmxidLessThanOrEqualTo(String value) {
            addCriterion("YSMXID <=", value, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andYsmxidLike(String value) {
            addCriterion("YSMXID like", value, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andYsmxidNotLike(String value) {
            addCriterion("YSMXID not like", value, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andYsmxidIn(List<String> values) {
            addCriterion("YSMXID in", values, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andYsmxidNotIn(List<String> values) {
            addCriterion("YSMXID not in", values, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andYsmxidBetween(String value1, String value2) {
            addCriterion("YSMXID between", value1, value2, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andYsmxidNotBetween(String value1, String value2) {
            addCriterion("YSMXID not between", value1, value2, "ysmxid");
            return (Criteria) this;
        }

        public Criteria andJfysidIsNull() {
            addCriterion("JFYSID is null");
            return (Criteria) this;
        }

        public Criteria andJfysidIsNotNull() {
            addCriterion("JFYSID is not null");
            return (Criteria) this;
        }

        public Criteria andJfysidEqualTo(String value) {
            addCriterion("JFYSID =", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidNotEqualTo(String value) {
            addCriterion("JFYSID <>", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidGreaterThan(String value) {
            addCriterion("JFYSID >", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidGreaterThanOrEqualTo(String value) {
            addCriterion("JFYSID >=", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidLessThan(String value) {
            addCriterion("JFYSID <", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidLessThanOrEqualTo(String value) {
            addCriterion("JFYSID <=", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidLike(String value) {
            addCriterion("JFYSID like", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidNotLike(String value) {
            addCriterion("JFYSID not like", value, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidIn(List<String> values) {
            addCriterion("JFYSID in", values, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidNotIn(List<String> values) {
            addCriterion("JFYSID not in", values, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidBetween(String value1, String value2) {
            addCriterion("JFYSID between", value1, value2, "jfysid");
            return (Criteria) this;
        }

        public Criteria andJfysidNotBetween(String value1, String value2) {
            addCriterion("JFYSID not between", value1, value2, "jfysid");
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

        public Criteria andV1slIsNull() {
            addCriterion("V1SL is null");
            return (Criteria) this;
        }

        public Criteria andV1slIsNotNull() {
            addCriterion("V1SL is not null");
            return (Criteria) this;
        }

        public Criteria andV1slEqualTo(Integer value) {
            addCriterion("V1SL =", value, "v1sl");
            return (Criteria) this;
        }

        public Criteria andV1slNotEqualTo(Integer value) {
            addCriterion("V1SL <>", value, "v1sl");
            return (Criteria) this;
        }

        public Criteria andV1slGreaterThan(Integer value) {
            addCriterion("V1SL >", value, "v1sl");
            return (Criteria) this;
        }

        public Criteria andV1slGreaterThanOrEqualTo(Integer value) {
            addCriterion("V1SL >=", value, "v1sl");
            return (Criteria) this;
        }

        public Criteria andV1slLessThan(Integer value) {
            addCriterion("V1SL <", value, "v1sl");
            return (Criteria) this;
        }

        public Criteria andV1slLessThanOrEqualTo(Integer value) {
            addCriterion("V1SL <=", value, "v1sl");
            return (Criteria) this;
        }

        public Criteria andV1slIn(List<Integer> values) {
            addCriterion("V1SL in", values, "v1sl");
            return (Criteria) this;
        }

        public Criteria andV1slNotIn(List<Integer> values) {
            addCriterion("V1SL not in", values, "v1sl");
            return (Criteria) this;
        }

        public Criteria andV1slBetween(Integer value1, Integer value2) {
            addCriterion("V1SL between", value1, value2, "v1sl");
            return (Criteria) this;
        }

        public Criteria andV1slNotBetween(Integer value1, Integer value2) {
            addCriterion("V1SL not between", value1, value2, "v1sl");
            return (Criteria) this;
        }

        public Criteria andV2slIsNull() {
            addCriterion("V2SL is null");
            return (Criteria) this;
        }

        public Criteria andV2slIsNotNull() {
            addCriterion("V2SL is not null");
            return (Criteria) this;
        }

        public Criteria andV2slEqualTo(Integer value) {
            addCriterion("V2SL =", value, "v2sl");
            return (Criteria) this;
        }

        public Criteria andV2slNotEqualTo(Integer value) {
            addCriterion("V2SL <>", value, "v2sl");
            return (Criteria) this;
        }

        public Criteria andV2slGreaterThan(Integer value) {
            addCriterion("V2SL >", value, "v2sl");
            return (Criteria) this;
        }

        public Criteria andV2slGreaterThanOrEqualTo(Integer value) {
            addCriterion("V2SL >=", value, "v2sl");
            return (Criteria) this;
        }

        public Criteria andV2slLessThan(Integer value) {
            addCriterion("V2SL <", value, "v2sl");
            return (Criteria) this;
        }

        public Criteria andV2slLessThanOrEqualTo(Integer value) {
            addCriterion("V2SL <=", value, "v2sl");
            return (Criteria) this;
        }

        public Criteria andV2slIn(List<Integer> values) {
            addCriterion("V2SL in", values, "v2sl");
            return (Criteria) this;
        }

        public Criteria andV2slNotIn(List<Integer> values) {
            addCriterion("V2SL not in", values, "v2sl");
            return (Criteria) this;
        }

        public Criteria andV2slBetween(Integer value1, Integer value2) {
            addCriterion("V2SL between", value1, value2, "v2sl");
            return (Criteria) this;
        }

        public Criteria andV2slNotBetween(Integer value1, Integer value2) {
            addCriterion("V2SL not between", value1, value2, "v2sl");
            return (Criteria) this;
        }

        public Criteria andV3slIsNull() {
            addCriterion("V3SL is null");
            return (Criteria) this;
        }

        public Criteria andV3slIsNotNull() {
            addCriterion("V3SL is not null");
            return (Criteria) this;
        }

        public Criteria andV3slEqualTo(Integer value) {
            addCriterion("V3SL =", value, "v3sl");
            return (Criteria) this;
        }

        public Criteria andV3slNotEqualTo(Integer value) {
            addCriterion("V3SL <>", value, "v3sl");
            return (Criteria) this;
        }

        public Criteria andV3slGreaterThan(Integer value) {
            addCriterion("V3SL >", value, "v3sl");
            return (Criteria) this;
        }

        public Criteria andV3slGreaterThanOrEqualTo(Integer value) {
            addCriterion("V3SL >=", value, "v3sl");
            return (Criteria) this;
        }

        public Criteria andV3slLessThan(Integer value) {
            addCriterion("V3SL <", value, "v3sl");
            return (Criteria) this;
        }

        public Criteria andV3slLessThanOrEqualTo(Integer value) {
            addCriterion("V3SL <=", value, "v3sl");
            return (Criteria) this;
        }

        public Criteria andV3slIn(List<Integer> values) {
            addCriterion("V3SL in", values, "v3sl");
            return (Criteria) this;
        }

        public Criteria andV3slNotIn(List<Integer> values) {
            addCriterion("V3SL not in", values, "v3sl");
            return (Criteria) this;
        }

        public Criteria andV3slBetween(Integer value1, Integer value2) {
            addCriterion("V3SL between", value1, value2, "v3sl");
            return (Criteria) this;
        }

        public Criteria andV3slNotBetween(Integer value1, Integer value2) {
            addCriterion("V3SL not between", value1, value2, "v3sl");
            return (Criteria) this;
        }

        public Criteria andV4slIsNull() {
            addCriterion("V4SL is null");
            return (Criteria) this;
        }

        public Criteria andV4slIsNotNull() {
            addCriterion("V4SL is not null");
            return (Criteria) this;
        }

        public Criteria andV4slEqualTo(Integer value) {
            addCriterion("V4SL =", value, "v4sl");
            return (Criteria) this;
        }

        public Criteria andV4slNotEqualTo(Integer value) {
            addCriterion("V4SL <>", value, "v4sl");
            return (Criteria) this;
        }

        public Criteria andV4slGreaterThan(Integer value) {
            addCriterion("V4SL >", value, "v4sl");
            return (Criteria) this;
        }

        public Criteria andV4slGreaterThanOrEqualTo(Integer value) {
            addCriterion("V4SL >=", value, "v4sl");
            return (Criteria) this;
        }

        public Criteria andV4slLessThan(Integer value) {
            addCriterion("V4SL <", value, "v4sl");
            return (Criteria) this;
        }

        public Criteria andV4slLessThanOrEqualTo(Integer value) {
            addCriterion("V4SL <=", value, "v4sl");
            return (Criteria) this;
        }

        public Criteria andV4slIn(List<Integer> values) {
            addCriterion("V4SL in", values, "v4sl");
            return (Criteria) this;
        }

        public Criteria andV4slNotIn(List<Integer> values) {
            addCriterion("V4SL not in", values, "v4sl");
            return (Criteria) this;
        }

        public Criteria andV4slBetween(Integer value1, Integer value2) {
            addCriterion("V4SL between", value1, value2, "v4sl");
            return (Criteria) this;
        }

        public Criteria andV4slNotBetween(Integer value1, Integer value2) {
            addCriterion("V4SL not between", value1, value2, "v4sl");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjIsNull() {
            addCriterion("DZBJFXJ is null");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjIsNotNull() {
            addCriterion("DZBJFXJ is not null");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjEqualTo(Integer value) {
            addCriterion("DZBJFXJ =", value, "dzbjfxj");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjNotEqualTo(Integer value) {
            addCriterion("DZBJFXJ <>", value, "dzbjfxj");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjGreaterThan(Integer value) {
            addCriterion("DZBJFXJ >", value, "dzbjfxj");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjGreaterThanOrEqualTo(Integer value) {
            addCriterion("DZBJFXJ >=", value, "dzbjfxj");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjLessThan(Integer value) {
            addCriterion("DZBJFXJ <", value, "dzbjfxj");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjLessThanOrEqualTo(Integer value) {
            addCriterion("DZBJFXJ <=", value, "dzbjfxj");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjIn(List<Integer> values) {
            addCriterion("DZBJFXJ in", values, "dzbjfxj");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjNotIn(List<Integer> values) {
            addCriterion("DZBJFXJ not in", values, "dzbjfxj");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjBetween(Integer value1, Integer value2) {
            addCriterion("DZBJFXJ between", value1, value2, "dzbjfxj");
            return (Criteria) this;
        }

        public Criteria andDzbjfxjNotBetween(Integer value1, Integer value2) {
            addCriterion("DZBJFXJ not between", value1, value2, "dzbjfxj");
            return (Criteria) this;
        }

        public Criteria andV1hdbzIsNull() {
            addCriterion("V1HDBZ is null");
            return (Criteria) this;
        }

        public Criteria andV1hdbzIsNotNull() {
            addCriterion("V1HDBZ is not null");
            return (Criteria) this;
        }

        public Criteria andV1hdbzEqualTo(Integer value) {
            addCriterion("V1HDBZ =", value, "v1hdbz");
            return (Criteria) this;
        }

        public Criteria andV1hdbzNotEqualTo(Integer value) {
            addCriterion("V1HDBZ <>", value, "v1hdbz");
            return (Criteria) this;
        }

        public Criteria andV1hdbzGreaterThan(Integer value) {
            addCriterion("V1HDBZ >", value, "v1hdbz");
            return (Criteria) this;
        }

        public Criteria andV1hdbzGreaterThanOrEqualTo(Integer value) {
            addCriterion("V1HDBZ >=", value, "v1hdbz");
            return (Criteria) this;
        }

        public Criteria andV1hdbzLessThan(Integer value) {
            addCriterion("V1HDBZ <", value, "v1hdbz");
            return (Criteria) this;
        }

        public Criteria andV1hdbzLessThanOrEqualTo(Integer value) {
            addCriterion("V1HDBZ <=", value, "v1hdbz");
            return (Criteria) this;
        }

        public Criteria andV1hdbzIn(List<Integer> values) {
            addCriterion("V1HDBZ in", values, "v1hdbz");
            return (Criteria) this;
        }

        public Criteria andV1hdbzNotIn(List<Integer> values) {
            addCriterion("V1HDBZ not in", values, "v1hdbz");
            return (Criteria) this;
        }

        public Criteria andV1hdbzBetween(Integer value1, Integer value2) {
            addCriterion("V1HDBZ between", value1, value2, "v1hdbz");
            return (Criteria) this;
        }

        public Criteria andV1hdbzNotBetween(Integer value1, Integer value2) {
            addCriterion("V1HDBZ not between", value1, value2, "v1hdbz");
            return (Criteria) this;
        }

        public Criteria andV2hdbzIsNull() {
            addCriterion("V2HDBZ is null");
            return (Criteria) this;
        }

        public Criteria andV2hdbzIsNotNull() {
            addCriterion("V2HDBZ is not null");
            return (Criteria) this;
        }

        public Criteria andV2hdbzEqualTo(Integer value) {
            addCriterion("V2HDBZ =", value, "v2hdbz");
            return (Criteria) this;
        }

        public Criteria andV2hdbzNotEqualTo(Integer value) {
            addCriterion("V2HDBZ <>", value, "v2hdbz");
            return (Criteria) this;
        }

        public Criteria andV2hdbzGreaterThan(Integer value) {
            addCriterion("V2HDBZ >", value, "v2hdbz");
            return (Criteria) this;
        }

        public Criteria andV2hdbzGreaterThanOrEqualTo(Integer value) {
            addCriterion("V2HDBZ >=", value, "v2hdbz");
            return (Criteria) this;
        }

        public Criteria andV2hdbzLessThan(Integer value) {
            addCriterion("V2HDBZ <", value, "v2hdbz");
            return (Criteria) this;
        }

        public Criteria andV2hdbzLessThanOrEqualTo(Integer value) {
            addCriterion("V2HDBZ <=", value, "v2hdbz");
            return (Criteria) this;
        }

        public Criteria andV2hdbzIn(List<Integer> values) {
            addCriterion("V2HDBZ in", values, "v2hdbz");
            return (Criteria) this;
        }

        public Criteria andV2hdbzNotIn(List<Integer> values) {
            addCriterion("V2HDBZ not in", values, "v2hdbz");
            return (Criteria) this;
        }

        public Criteria andV2hdbzBetween(Integer value1, Integer value2) {
            addCriterion("V2HDBZ between", value1, value2, "v2hdbz");
            return (Criteria) this;
        }

        public Criteria andV2hdbzNotBetween(Integer value1, Integer value2) {
            addCriterion("V2HDBZ not between", value1, value2, "v2hdbz");
            return (Criteria) this;
        }

        public Criteria andV3hdbzIsNull() {
            addCriterion("V3HDBZ is null");
            return (Criteria) this;
        }

        public Criteria andV3hdbzIsNotNull() {
            addCriterion("V3HDBZ is not null");
            return (Criteria) this;
        }

        public Criteria andV3hdbzEqualTo(Integer value) {
            addCriterion("V3HDBZ =", value, "v3hdbz");
            return (Criteria) this;
        }

        public Criteria andV3hdbzNotEqualTo(Integer value) {
            addCriterion("V3HDBZ <>", value, "v3hdbz");
            return (Criteria) this;
        }

        public Criteria andV3hdbzGreaterThan(Integer value) {
            addCriterion("V3HDBZ >", value, "v3hdbz");
            return (Criteria) this;
        }

        public Criteria andV3hdbzGreaterThanOrEqualTo(Integer value) {
            addCriterion("V3HDBZ >=", value, "v3hdbz");
            return (Criteria) this;
        }

        public Criteria andV3hdbzLessThan(Integer value) {
            addCriterion("V3HDBZ <", value, "v3hdbz");
            return (Criteria) this;
        }

        public Criteria andV3hdbzLessThanOrEqualTo(Integer value) {
            addCriterion("V3HDBZ <=", value, "v3hdbz");
            return (Criteria) this;
        }

        public Criteria andV3hdbzIn(List<Integer> values) {
            addCriterion("V3HDBZ in", values, "v3hdbz");
            return (Criteria) this;
        }

        public Criteria andV3hdbzNotIn(List<Integer> values) {
            addCriterion("V3HDBZ not in", values, "v3hdbz");
            return (Criteria) this;
        }

        public Criteria andV3hdbzBetween(Integer value1, Integer value2) {
            addCriterion("V3HDBZ between", value1, value2, "v3hdbz");
            return (Criteria) this;
        }

        public Criteria andV3hdbzNotBetween(Integer value1, Integer value2) {
            addCriterion("V3HDBZ not between", value1, value2, "v3hdbz");
            return (Criteria) this;
        }

        public Criteria andV4hdbzIsNull() {
            addCriterion("V4HDBZ is null");
            return (Criteria) this;
        }

        public Criteria andV4hdbzIsNotNull() {
            addCriterion("V4HDBZ is not null");
            return (Criteria) this;
        }

        public Criteria andV4hdbzEqualTo(Integer value) {
            addCriterion("V4HDBZ =", value, "v4hdbz");
            return (Criteria) this;
        }

        public Criteria andV4hdbzNotEqualTo(Integer value) {
            addCriterion("V4HDBZ <>", value, "v4hdbz");
            return (Criteria) this;
        }

        public Criteria andV4hdbzGreaterThan(Integer value) {
            addCriterion("V4HDBZ >", value, "v4hdbz");
            return (Criteria) this;
        }

        public Criteria andV4hdbzGreaterThanOrEqualTo(Integer value) {
            addCriterion("V4HDBZ >=", value, "v4hdbz");
            return (Criteria) this;
        }

        public Criteria andV4hdbzLessThan(Integer value) {
            addCriterion("V4HDBZ <", value, "v4hdbz");
            return (Criteria) this;
        }

        public Criteria andV4hdbzLessThanOrEqualTo(Integer value) {
            addCriterion("V4HDBZ <=", value, "v4hdbz");
            return (Criteria) this;
        }

        public Criteria andV4hdbzIn(List<Integer> values) {
            addCriterion("V4HDBZ in", values, "v4hdbz");
            return (Criteria) this;
        }

        public Criteria andV4hdbzNotIn(List<Integer> values) {
            addCriterion("V4HDBZ not in", values, "v4hdbz");
            return (Criteria) this;
        }

        public Criteria andV4hdbzBetween(Integer value1, Integer value2) {
            addCriterion("V4HDBZ between", value1, value2, "v4hdbz");
            return (Criteria) this;
        }

        public Criteria andV4hdbzNotBetween(Integer value1, Integer value2) {
            addCriterion("V4HDBZ not between", value1, value2, "v4hdbz");
            return (Criteria) this;
        }

        public Criteria andZgdyrsIsNull() {
            addCriterion("ZGDYRS is null");
            return (Criteria) this;
        }

        public Criteria andZgdyrsIsNotNull() {
            addCriterion("ZGDYRS is not null");
            return (Criteria) this;
        }

        public Criteria andZgdyrsEqualTo(Integer value) {
            addCriterion("ZGDYRS =", value, "zgdyrs");
            return (Criteria) this;
        }

        public Criteria andZgdyrsNotEqualTo(Integer value) {
            addCriterion("ZGDYRS <>", value, "zgdyrs");
            return (Criteria) this;
        }

        public Criteria andZgdyrsGreaterThan(Integer value) {
            addCriterion("ZGDYRS >", value, "zgdyrs");
            return (Criteria) this;
        }

        public Criteria andZgdyrsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZGDYRS >=", value, "zgdyrs");
            return (Criteria) this;
        }

        public Criteria andZgdyrsLessThan(Integer value) {
            addCriterion("ZGDYRS <", value, "zgdyrs");
            return (Criteria) this;
        }

        public Criteria andZgdyrsLessThanOrEqualTo(Integer value) {
            addCriterion("ZGDYRS <=", value, "zgdyrs");
            return (Criteria) this;
        }

        public Criteria andZgdyrsIn(List<Integer> values) {
            addCriterion("ZGDYRS in", values, "zgdyrs");
            return (Criteria) this;
        }

        public Criteria andZgdyrsNotIn(List<Integer> values) {
            addCriterion("ZGDYRS not in", values, "zgdyrs");
            return (Criteria) this;
        }

        public Criteria andZgdyrsBetween(Integer value1, Integer value2) {
            addCriterion("ZGDYRS between", value1, value2, "zgdyrs");
            return (Criteria) this;
        }

        public Criteria andZgdyrsNotBetween(Integer value1, Integer value2) {
            addCriterion("ZGDYRS not between", value1, value2, "zgdyrs");
            return (Criteria) this;
        }

        public Criteria andHdbzIsNull() {
            addCriterion("HDBZ is null");
            return (Criteria) this;
        }

        public Criteria andHdbzIsNotNull() {
            addCriterion("HDBZ is not null");
            return (Criteria) this;
        }

        public Criteria andHdbzEqualTo(Integer value) {
            addCriterion("HDBZ =", value, "hdbz");
            return (Criteria) this;
        }

        public Criteria andHdbzNotEqualTo(Integer value) {
            addCriterion("HDBZ <>", value, "hdbz");
            return (Criteria) this;
        }

        public Criteria andHdbzGreaterThan(Integer value) {
            addCriterion("HDBZ >", value, "hdbz");
            return (Criteria) this;
        }

        public Criteria andHdbzGreaterThanOrEqualTo(Integer value) {
            addCriterion("HDBZ >=", value, "hdbz");
            return (Criteria) this;
        }

        public Criteria andHdbzLessThan(Integer value) {
            addCriterion("HDBZ <", value, "hdbz");
            return (Criteria) this;
        }

        public Criteria andHdbzLessThanOrEqualTo(Integer value) {
            addCriterion("HDBZ <=", value, "hdbz");
            return (Criteria) this;
        }

        public Criteria andHdbzIn(List<Integer> values) {
            addCriterion("HDBZ in", values, "hdbz");
            return (Criteria) this;
        }

        public Criteria andHdbzNotIn(List<Integer> values) {
            addCriterion("HDBZ not in", values, "hdbz");
            return (Criteria) this;
        }

        public Criteria andHdbzBetween(Integer value1, Integer value2) {
            addCriterion("HDBZ between", value1, value2, "hdbz");
            return (Criteria) this;
        }

        public Criteria andHdbzNotBetween(Integer value1, Integer value2) {
            addCriterion("HDBZ not between", value1, value2, "hdbz");
            return (Criteria) this;
        }

        public Criteria andXtyszeIsNull() {
            addCriterion("XTYSZE is null");
            return (Criteria) this;
        }

        public Criteria andXtyszeIsNotNull() {
            addCriterion("XTYSZE is not null");
            return (Criteria) this;
        }

        public Criteria andXtyszeEqualTo(Integer value) {
            addCriterion("XTYSZE =", value, "xtysze");
            return (Criteria) this;
        }

        public Criteria andXtyszeNotEqualTo(Integer value) {
            addCriterion("XTYSZE <>", value, "xtysze");
            return (Criteria) this;
        }

        public Criteria andXtyszeGreaterThan(Integer value) {
            addCriterion("XTYSZE >", value, "xtysze");
            return (Criteria) this;
        }

        public Criteria andXtyszeGreaterThanOrEqualTo(Integer value) {
            addCriterion("XTYSZE >=", value, "xtysze");
            return (Criteria) this;
        }

        public Criteria andXtyszeLessThan(Integer value) {
            addCriterion("XTYSZE <", value, "xtysze");
            return (Criteria) this;
        }

        public Criteria andXtyszeLessThanOrEqualTo(Integer value) {
            addCriterion("XTYSZE <=", value, "xtysze");
            return (Criteria) this;
        }

        public Criteria andXtyszeIn(List<Integer> values) {
            addCriterion("XTYSZE in", values, "xtysze");
            return (Criteria) this;
        }

        public Criteria andXtyszeNotIn(List<Integer> values) {
            addCriterion("XTYSZE not in", values, "xtysze");
            return (Criteria) this;
        }

        public Criteria andXtyszeBetween(Integer value1, Integer value2) {
            addCriterion("XTYSZE between", value1, value2, "xtysze");
            return (Criteria) this;
        }

        public Criteria andXtyszeNotBetween(Integer value1, Integer value2) {
            addCriterion("XTYSZE not between", value1, value2, "xtysze");
            return (Criteria) this;
        }

        public Criteria andSjyszeIsNull() {
            addCriterion("SJYSZE is null");
            return (Criteria) this;
        }

        public Criteria andSjyszeIsNotNull() {
            addCriterion("SJYSZE is not null");
            return (Criteria) this;
        }

        public Criteria andSjyszeEqualTo(Integer value) {
            addCriterion("SJYSZE =", value, "sjysze");
            return (Criteria) this;
        }

        public Criteria andSjyszeNotEqualTo(Integer value) {
            addCriterion("SJYSZE <>", value, "sjysze");
            return (Criteria) this;
        }

        public Criteria andSjyszeGreaterThan(Integer value) {
            addCriterion("SJYSZE >", value, "sjysze");
            return (Criteria) this;
        }

        public Criteria andSjyszeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SJYSZE >=", value, "sjysze");
            return (Criteria) this;
        }

        public Criteria andSjyszeLessThan(Integer value) {
            addCriterion("SJYSZE <", value, "sjysze");
            return (Criteria) this;
        }

        public Criteria andSjyszeLessThanOrEqualTo(Integer value) {
            addCriterion("SJYSZE <=", value, "sjysze");
            return (Criteria) this;
        }

        public Criteria andSjyszeIn(List<Integer> values) {
            addCriterion("SJYSZE in", values, "sjysze");
            return (Criteria) this;
        }

        public Criteria andSjyszeNotIn(List<Integer> values) {
            addCriterion("SJYSZE not in", values, "sjysze");
            return (Criteria) this;
        }

        public Criteria andSjyszeBetween(Integer value1, Integer value2) {
            addCriterion("SJYSZE between", value1, value2, "sjysze");
            return (Criteria) this;
        }

        public Criteria andSjyszeNotBetween(Integer value1, Integer value2) {
            addCriterion("SJYSZE not between", value1, value2, "sjysze");
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