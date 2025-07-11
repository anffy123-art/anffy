package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DjDnpxxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DjDnpxxxExample() {
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

        public Criteria andHonourtimeIsNull() {
            addCriterion("HONOURTIME is null");
            return (Criteria) this;
        }

        public Criteria andHonourtimeIsNotNull() {
            addCriterion("HONOURTIME is not null");
            return (Criteria) this;
        }

        public Criteria andHonourtimeEqualTo(Date value) {
            addCriterion("HONOURTIME =", value, "honourtime");
            return (Criteria) this;
        }

        public Criteria andHonourtimeNotEqualTo(Date value) {
            addCriterion("HONOURTIME <>", value, "honourtime");
            return (Criteria) this;
        }

        public Criteria andHonourtimeGreaterThan(Date value) {
            addCriterion("HONOURTIME >", value, "honourtime");
            return (Criteria) this;
        }

        public Criteria andHonourtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("HONOURTIME >=", value, "honourtime");
            return (Criteria) this;
        }

        public Criteria andHonourtimeLessThan(Date value) {
            addCriterion("HONOURTIME <", value, "honourtime");
            return (Criteria) this;
        }

        public Criteria andHonourtimeLessThanOrEqualTo(Date value) {
            addCriterion("HONOURTIME <=", value, "honourtime");
            return (Criteria) this;
        }

        public Criteria andHonourtimeIn(List<Date> values) {
            addCriterion("HONOURTIME in", values, "honourtime");
            return (Criteria) this;
        }

        public Criteria andHonourtimeNotIn(List<Date> values) {
            addCriterion("HONOURTIME not in", values, "honourtime");
            return (Criteria) this;
        }

        public Criteria andHonourtimeBetween(Date value1, Date value2) {
            addCriterion("HONOURTIME between", value1, value2, "honourtime");
            return (Criteria) this;
        }

        public Criteria andHonourtimeNotBetween(Date value1, Date value2) {
            addCriterion("HONOURTIME not between", value1, value2, "honourtime");
            return (Criteria) this;
        }

        public Criteria andHonourlevelIsNull() {
            addCriterion("HONOURLEVEL is null");
            return (Criteria) this;
        }

        public Criteria andHonourlevelIsNotNull() {
            addCriterion("HONOURLEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andHonourlevelEqualTo(Integer value) {
            addCriterion("HONOURLEVEL =", value, "honourlevel");
            return (Criteria) this;
        }

        public Criteria andHonourlevelNotEqualTo(Integer value) {
            addCriterion("HONOURLEVEL <>", value, "honourlevel");
            return (Criteria) this;
        }

        public Criteria andHonourlevelGreaterThan(Integer value) {
            addCriterion("HONOURLEVEL >", value, "honourlevel");
            return (Criteria) this;
        }

        public Criteria andHonourlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("HONOURLEVEL >=", value, "honourlevel");
            return (Criteria) this;
        }

        public Criteria andHonourlevelLessThan(Integer value) {
            addCriterion("HONOURLEVEL <", value, "honourlevel");
            return (Criteria) this;
        }

        public Criteria andHonourlevelLessThanOrEqualTo(Integer value) {
            addCriterion("HONOURLEVEL <=", value, "honourlevel");
            return (Criteria) this;
        }

        public Criteria andHonourlevelIn(List<Integer> values) {
            addCriterion("HONOURLEVEL in", values, "honourlevel");
            return (Criteria) this;
        }

        public Criteria andHonourlevelNotIn(List<Integer> values) {
            addCriterion("HONOURLEVEL not in", values, "honourlevel");
            return (Criteria) this;
        }

        public Criteria andHonourlevelBetween(Integer value1, Integer value2) {
            addCriterion("HONOURLEVEL between", value1, value2, "honourlevel");
            return (Criteria) this;
        }

        public Criteria andHonourlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("HONOURLEVEL not between", value1, value2, "honourlevel");
            return (Criteria) this;
        }

        public Criteria andHonournameIsNull() {
            addCriterion("HONOURNAME is null");
            return (Criteria) this;
        }

        public Criteria andHonournameIsNotNull() {
            addCriterion("HONOURNAME is not null");
            return (Criteria) this;
        }

        public Criteria andHonournameEqualTo(String value) {
            addCriterion("HONOURNAME =", value, "honourname");
            return (Criteria) this;
        }

        public Criteria andHonournameNotEqualTo(String value) {
            addCriterion("HONOURNAME <>", value, "honourname");
            return (Criteria) this;
        }

        public Criteria andHonournameGreaterThan(String value) {
            addCriterion("HONOURNAME >", value, "honourname");
            return (Criteria) this;
        }

        public Criteria andHonournameGreaterThanOrEqualTo(String value) {
            addCriterion("HONOURNAME >=", value, "honourname");
            return (Criteria) this;
        }

        public Criteria andHonournameLessThan(String value) {
            addCriterion("HONOURNAME <", value, "honourname");
            return (Criteria) this;
        }

        public Criteria andHonournameLessThanOrEqualTo(String value) {
            addCriterion("HONOURNAME <=", value, "honourname");
            return (Criteria) this;
        }

        public Criteria andHonournameLike(String value) {
            addCriterion("HONOURNAME like", value, "honourname");
            return (Criteria) this;
        }

        public Criteria andHonournameNotLike(String value) {
            addCriterion("HONOURNAME not like", value, "honourname");
            return (Criteria) this;
        }

        public Criteria andHonournameIn(List<String> values) {
            addCriterion("HONOURNAME in", values, "honourname");
            return (Criteria) this;
        }

        public Criteria andHonournameNotIn(List<String> values) {
            addCriterion("HONOURNAME not in", values, "honourname");
            return (Criteria) this;
        }

        public Criteria andHonournameBetween(String value1, String value2) {
            addCriterion("HONOURNAME between", value1, value2, "honourname");
            return (Criteria) this;
        }

        public Criteria andHonournameNotBetween(String value1, String value2) {
            addCriterion("HONOURNAME not between", value1, value2, "honourname");
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

        public Criteria andIscommendIsNull() {
            addCriterion("ISCOMMEND is null");
            return (Criteria) this;
        }

        public Criteria andIscommendIsNotNull() {
            addCriterion("ISCOMMEND is not null");
            return (Criteria) this;
        }

        public Criteria andIscommendEqualTo(Integer value) {
            addCriterion("ISCOMMEND =", value, "iscommend");
            return (Criteria) this;
        }

        public Criteria andIscommendNotEqualTo(Integer value) {
            addCriterion("ISCOMMEND <>", value, "iscommend");
            return (Criteria) this;
        }

        public Criteria andIscommendGreaterThan(Integer value) {
            addCriterion("ISCOMMEND >", value, "iscommend");
            return (Criteria) this;
        }

        public Criteria andIscommendGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISCOMMEND >=", value, "iscommend");
            return (Criteria) this;
        }

        public Criteria andIscommendLessThan(Integer value) {
            addCriterion("ISCOMMEND <", value, "iscommend");
            return (Criteria) this;
        }

        public Criteria andIscommendLessThanOrEqualTo(Integer value) {
            addCriterion("ISCOMMEND <=", value, "iscommend");
            return (Criteria) this;
        }

        public Criteria andIscommendIn(List<Integer> values) {
            addCriterion("ISCOMMEND in", values, "iscommend");
            return (Criteria) this;
        }

        public Criteria andIscommendNotIn(List<Integer> values) {
            addCriterion("ISCOMMEND not in", values, "iscommend");
            return (Criteria) this;
        }

        public Criteria andIscommendBetween(Integer value1, Integer value2) {
            addCriterion("ISCOMMEND between", value1, value2, "iscommend");
            return (Criteria) this;
        }

        public Criteria andIscommendNotBetween(Integer value1, Integer value2) {
            addCriterion("ISCOMMEND not between", value1, value2, "iscommend");
            return (Criteria) this;
        }

        public Criteria andPxlxIsNull() {
            addCriterion("PXLX is null");
            return (Criteria) this;
        }

        public Criteria andPxlxIsNotNull() {
            addCriterion("PXLX is not null");
            return (Criteria) this;
        }

        public Criteria andPxlxEqualTo(String value) {
            addCriterion("PXLX =", value, "pxlx");
            return (Criteria) this;
        }

        public Criteria andPxlxNotEqualTo(String value) {
            addCriterion("PXLX <>", value, "pxlx");
            return (Criteria) this;
        }

        public Criteria andPxlxGreaterThan(String value) {
            addCriterion("PXLX >", value, "pxlx");
            return (Criteria) this;
        }

        public Criteria andPxlxGreaterThanOrEqualTo(String value) {
            addCriterion("PXLX >=", value, "pxlx");
            return (Criteria) this;
        }

        public Criteria andPxlxLessThan(String value) {
            addCriterion("PXLX <", value, "pxlx");
            return (Criteria) this;
        }

        public Criteria andPxlxLessThanOrEqualTo(String value) {
            addCriterion("PXLX <=", value, "pxlx");
            return (Criteria) this;
        }

        public Criteria andPxlxLike(String value) {
            addCriterion("PXLX like", value, "pxlx");
            return (Criteria) this;
        }

        public Criteria andPxlxNotLike(String value) {
            addCriterion("PXLX not like", value, "pxlx");
            return (Criteria) this;
        }

        public Criteria andPxlxIn(List<String> values) {
            addCriterion("PXLX in", values, "pxlx");
            return (Criteria) this;
        }

        public Criteria andPxlxNotIn(List<String> values) {
            addCriterion("PXLX not in", values, "pxlx");
            return (Criteria) this;
        }

        public Criteria andPxlxBetween(String value1, String value2) {
            addCriterion("PXLX between", value1, value2, "pxlx");
            return (Criteria) this;
        }

        public Criteria andPxlxNotBetween(String value1, String value2) {
            addCriterion("PXLX not between", value1, value2, "pxlx");
            return (Criteria) this;
        }

        public Criteria andHonourtypeIsNull() {
            addCriterion("HONOURTYPE is null");
            return (Criteria) this;
        }

        public Criteria andHonourtypeIsNotNull() {
            addCriterion("HONOURTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andHonourtypeEqualTo(Integer value) {
            addCriterion("HONOURTYPE =", value, "honourtype");
            return (Criteria) this;
        }

        public Criteria andHonourtypeNotEqualTo(Integer value) {
            addCriterion("HONOURTYPE <>", value, "honourtype");
            return (Criteria) this;
        }

        public Criteria andHonourtypeGreaterThan(Integer value) {
            addCriterion("HONOURTYPE >", value, "honourtype");
            return (Criteria) this;
        }

        public Criteria andHonourtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("HONOURTYPE >=", value, "honourtype");
            return (Criteria) this;
        }

        public Criteria andHonourtypeLessThan(Integer value) {
            addCriterion("HONOURTYPE <", value, "honourtype");
            return (Criteria) this;
        }

        public Criteria andHonourtypeLessThanOrEqualTo(Integer value) {
            addCriterion("HONOURTYPE <=", value, "honourtype");
            return (Criteria) this;
        }

        public Criteria andHonourtypeIn(List<Integer> values) {
            addCriterion("HONOURTYPE in", values, "honourtype");
            return (Criteria) this;
        }

        public Criteria andHonourtypeNotIn(List<Integer> values) {
            addCriterion("HONOURTYPE not in", values, "honourtype");
            return (Criteria) this;
        }

        public Criteria andHonourtypeBetween(Integer value1, Integer value2) {
            addCriterion("HONOURTYPE between", value1, value2, "honourtype");
            return (Criteria) this;
        }

        public Criteria andHonourtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("HONOURTYPE not between", value1, value2, "honourtype");
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