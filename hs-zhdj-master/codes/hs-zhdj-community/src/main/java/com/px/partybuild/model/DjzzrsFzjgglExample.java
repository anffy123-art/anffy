package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DjzzrsFzjgglExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DjzzrsFzjgglExample() {
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

        public Criteria andGlidIsNull() {
            addCriterion("GLID is null");
            return (Criteria) this;
        }

        public Criteria andGlidIsNotNull() {
            addCriterion("GLID is not null");
            return (Criteria) this;
        }

        public Criteria andGlidEqualTo(String value) {
            addCriterion("GLID =", value, "glid");
            return (Criteria) this;
        }

        public Criteria andGlidNotEqualTo(String value) {
            addCriterion("GLID <>", value, "glid");
            return (Criteria) this;
        }

        public Criteria andGlidGreaterThan(String value) {
            addCriterion("GLID >", value, "glid");
            return (Criteria) this;
        }

        public Criteria andGlidGreaterThanOrEqualTo(String value) {
            addCriterion("GLID >=", value, "glid");
            return (Criteria) this;
        }

        public Criteria andGlidLessThan(String value) {
            addCriterion("GLID <", value, "glid");
            return (Criteria) this;
        }

        public Criteria andGlidLessThanOrEqualTo(String value) {
            addCriterion("GLID <=", value, "glid");
            return (Criteria) this;
        }

        public Criteria andGlidLike(String value) {
            addCriterion("GLID like", value, "glid");
            return (Criteria) this;
        }

        public Criteria andGlidNotLike(String value) {
            addCriterion("GLID not like", value, "glid");
            return (Criteria) this;
        }

        public Criteria andGlidIn(List<String> values) {
            addCriterion("GLID in", values, "glid");
            return (Criteria) this;
        }

        public Criteria andGlidNotIn(List<String> values) {
            addCriterion("GLID not in", values, "glid");
            return (Criteria) this;
        }

        public Criteria andGlidBetween(String value1, String value2) {
            addCriterion("GLID between", value1, value2, "glid");
            return (Criteria) this;
        }

        public Criteria andGlidNotBetween(String value1, String value2) {
            addCriterion("GLID not between", value1, value2, "glid");
            return (Criteria) this;
        }

        public Criteria andDzzbmIsNull() {
            addCriterion("DZZBM is null");
            return (Criteria) this;
        }

        public Criteria andDzzbmIsNotNull() {
            addCriterion("DZZBM is not null");
            return (Criteria) this;
        }

        public Criteria andDzzbmEqualTo(String value) {
            addCriterion("DZZBM =", value, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andDzzbmNotEqualTo(String value) {
            addCriterion("DZZBM <>", value, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andDzzbmGreaterThan(String value) {
            addCriterion("DZZBM >", value, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andDzzbmGreaterThanOrEqualTo(String value) {
            addCriterion("DZZBM >=", value, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andDzzbmLessThan(String value) {
            addCriterion("DZZBM <", value, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andDzzbmLessThanOrEqualTo(String value) {
            addCriterion("DZZBM <=", value, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andDzzbmLike(String value) {
            addCriterion("DZZBM like", value, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andDzzbmNotLike(String value) {
            addCriterion("DZZBM not like", value, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andDzzbmIn(List<String> values) {
            addCriterion("DZZBM in", values, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andDzzbmNotIn(List<String> values) {
            addCriterion("DZZBM not in", values, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andDzzbmBetween(String value1, String value2) {
            addCriterion("DZZBM between", value1, value2, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andDzzbmNotBetween(String value1, String value2) {
            addCriterion("DZZBM not between", value1, value2, "dzzbm");
            return (Criteria) this;
        }

        public Criteria andJgfzidIsNull() {
            addCriterion("JGFZID is null");
            return (Criteria) this;
        }

        public Criteria andJgfzidIsNotNull() {
            addCriterion("JGFZID is not null");
            return (Criteria) this;
        }

        public Criteria andJgfzidEqualTo(String value) {
            addCriterion("JGFZID =", value, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andJgfzidNotEqualTo(String value) {
            addCriterion("JGFZID <>", value, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andJgfzidGreaterThan(String value) {
            addCriterion("JGFZID >", value, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andJgfzidGreaterThanOrEqualTo(String value) {
            addCriterion("JGFZID >=", value, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andJgfzidLessThan(String value) {
            addCriterion("JGFZID <", value, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andJgfzidLessThanOrEqualTo(String value) {
            addCriterion("JGFZID <=", value, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andJgfzidLike(String value) {
            addCriterion("JGFZID like", value, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andJgfzidNotLike(String value) {
            addCriterion("JGFZID not like", value, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andJgfzidIn(List<String> values) {
            addCriterion("JGFZID in", values, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andJgfzidNotIn(List<String> values) {
            addCriterion("JGFZID not in", values, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andJgfzidBetween(String value1, String value2) {
            addCriterion("JGFZID between", value1, value2, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andJgfzidNotBetween(String value1, String value2) {
            addCriterion("JGFZID not between", value1, value2, "jgfzid");
            return (Criteria) this;
        }

        public Criteria andFzztIsNull() {
            addCriterion("FZZT is null");
            return (Criteria) this;
        }

        public Criteria andFzztIsNotNull() {
            addCriterion("FZZT is not null");
            return (Criteria) this;
        }

        public Criteria andFzztEqualTo(String value) {
            addCriterion("FZZT =", value, "fzzt");
            return (Criteria) this;
        }

        public Criteria andFzztNotEqualTo(String value) {
            addCriterion("FZZT <>", value, "fzzt");
            return (Criteria) this;
        }

        public Criteria andFzztGreaterThan(String value) {
            addCriterion("FZZT >", value, "fzzt");
            return (Criteria) this;
        }

        public Criteria andFzztGreaterThanOrEqualTo(String value) {
            addCriterion("FZZT >=", value, "fzzt");
            return (Criteria) this;
        }

        public Criteria andFzztLessThan(String value) {
            addCriterion("FZZT <", value, "fzzt");
            return (Criteria) this;
        }

        public Criteria andFzztLessThanOrEqualTo(String value) {
            addCriterion("FZZT <=", value, "fzzt");
            return (Criteria) this;
        }

        public Criteria andFzztLike(String value) {
            addCriterion("FZZT like", value, "fzzt");
            return (Criteria) this;
        }

        public Criteria andFzztNotLike(String value) {
            addCriterion("FZZT not like", value, "fzzt");
            return (Criteria) this;
        }

        public Criteria andFzztIn(List<String> values) {
            addCriterion("FZZT in", values, "fzzt");
            return (Criteria) this;
        }

        public Criteria andFzztNotIn(List<String> values) {
            addCriterion("FZZT not in", values, "fzzt");
            return (Criteria) this;
        }

        public Criteria andFzztBetween(String value1, String value2) {
            addCriterion("FZZT between", value1, value2, "fzzt");
            return (Criteria) this;
        }

        public Criteria andFzztNotBetween(String value1, String value2) {
            addCriterion("FZZT not between", value1, value2, "fzzt");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIsNull() {
            addCriterion("CREATE_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIsNotNull() {
            addCriterion("CREATE_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonEqualTo(String value) {
            addCriterion("CREATE_PERSON =", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotEqualTo(String value) {
            addCriterion("CREATE_PERSON <>", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThan(String value) {
            addCriterion("CREATE_PERSON >", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_PERSON >=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThan(String value) {
            addCriterion("CREATE_PERSON <", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThanOrEqualTo(String value) {
            addCriterion("CREATE_PERSON <=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLike(String value) {
            addCriterion("CREATE_PERSON like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotLike(String value) {
            addCriterion("CREATE_PERSON not like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIn(List<String> values) {
            addCriterion("CREATE_PERSON in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotIn(List<String> values) {
            addCriterion("CREATE_PERSON not in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonBetween(String value1, String value2) {
            addCriterion("CREATE_PERSON between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotBetween(String value1, String value2) {
            addCriterion("CREATE_PERSON not between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIsNull() {
            addCriterion("UPDATE_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIsNotNull() {
            addCriterion("UPDATE_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonEqualTo(String value) {
            addCriterion("UPDATE_PERSON =", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotEqualTo(String value) {
            addCriterion("UPDATE_PERSON <>", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonGreaterThan(String value) {
            addCriterion("UPDATE_PERSON >", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_PERSON >=", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLessThan(String value) {
            addCriterion("UPDATE_PERSON <", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_PERSON <=", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLike(String value) {
            addCriterion("UPDATE_PERSON like", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotLike(String value) {
            addCriterion("UPDATE_PERSON not like", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIn(List<String> values) {
            addCriterion("UPDATE_PERSON in", values, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotIn(List<String> values) {
            addCriterion("UPDATE_PERSON not in", values, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonBetween(String value1, String value2) {
            addCriterion("UPDATE_PERSON between", value1, value2, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotBetween(String value1, String value2) {
            addCriterion("UPDATE_PERSON not between", value1, value2, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andComeFromIsNull() {
            addCriterion("COME_FROM is null");
            return (Criteria) this;
        }

        public Criteria andComeFromIsNotNull() {
            addCriterion("COME_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andComeFromEqualTo(String value) {
            addCriterion("COME_FROM =", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromNotEqualTo(String value) {
            addCriterion("COME_FROM <>", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromGreaterThan(String value) {
            addCriterion("COME_FROM >", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromGreaterThanOrEqualTo(String value) {
            addCriterion("COME_FROM >=", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromLessThan(String value) {
            addCriterion("COME_FROM <", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromLessThanOrEqualTo(String value) {
            addCriterion("COME_FROM <=", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromLike(String value) {
            addCriterion("COME_FROM like", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromNotLike(String value) {
            addCriterion("COME_FROM not like", value, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromIn(List<String> values) {
            addCriterion("COME_FROM in", values, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromNotIn(List<String> values) {
            addCriterion("COME_FROM not in", values, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromBetween(String value1, String value2) {
            addCriterion("COME_FROM between", value1, value2, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andComeFromNotBetween(String value1, String value2) {
            addCriterion("COME_FROM not between", value1, value2, "comeFrom");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("ORG_ID like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("ORG_ID not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
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