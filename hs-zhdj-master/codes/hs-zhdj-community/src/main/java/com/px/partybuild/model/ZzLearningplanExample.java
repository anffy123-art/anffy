package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ZzLearningplanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzLearningplanExample() {
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

        public Criteria andLearningPlanIDIsNull() {
            addCriterion("learningPlanID is null");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDIsNotNull() {
            addCriterion("learningPlanID is not null");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDEqualTo(String value) {
            addCriterion("learningPlanID =", value, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDNotEqualTo(String value) {
            addCriterion("learningPlanID <>", value, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDGreaterThan(String value) {
            addCriterion("learningPlanID >", value, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDGreaterThanOrEqualTo(String value) {
            addCriterion("learningPlanID >=", value, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDLessThan(String value) {
            addCriterion("learningPlanID <", value, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDLessThanOrEqualTo(String value) {
            addCriterion("learningPlanID <=", value, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDLike(String value) {
            addCriterion("learningPlanID like", value, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDNotLike(String value) {
            addCriterion("learningPlanID not like", value, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDIn(List<String> values) {
            addCriterion("learningPlanID in", values, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDNotIn(List<String> values) {
            addCriterion("learningPlanID not in", values, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDBetween(String value1, String value2) {
            addCriterion("learningPlanID between", value1, value2, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andLearningPlanIDNotBetween(String value1, String value2) {
            addCriterion("learningPlanID not between", value1, value2, "learningPlanID");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPartyCodeIsNull() {
            addCriterion("partyCode is null");
            return (Criteria) this;
        }

        public Criteria andPartyCodeIsNotNull() {
            addCriterion("partyCode is not null");
            return (Criteria) this;
        }

        public Criteria andPartyCodeEqualTo(String value) {
            addCriterion("partyCode =", value, "partyCode");
            return (Criteria) this;
        }

        public Criteria andPartyCodeNotEqualTo(String value) {
            addCriterion("partyCode <>", value, "partyCode");
            return (Criteria) this;
        }

        public Criteria andPartyCodeGreaterThan(String value) {
            addCriterion("partyCode >", value, "partyCode");
            return (Criteria) this;
        }

        public Criteria andPartyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("partyCode >=", value, "partyCode");
            return (Criteria) this;
        }

        public Criteria andPartyCodeLessThan(String value) {
            addCriterion("partyCode <", value, "partyCode");
            return (Criteria) this;
        }

        public Criteria andPartyCodeLessThanOrEqualTo(String value) {
            addCriterion("partyCode <=", value, "partyCode");
            return (Criteria) this;
        }

        public Criteria andPartyCodeLike(String value) {
            addCriterion("partyCode like", value, "partyCode");
            return (Criteria) this;
        }

        public Criteria andPartyCodeNotLike(String value) {
            addCriterion("partyCode not like", value, "partyCode");
            return (Criteria) this;
        }

        public Criteria andPartyCodeIn(List<String> values) {
            addCriterion("partyCode in", values, "partyCode");
            return (Criteria) this;
        }

        public Criteria andPartyCodeNotIn(List<String> values) {
            addCriterion("partyCode not in", values, "partyCode");
            return (Criteria) this;
        }

        public Criteria andPartyCodeBetween(String value1, String value2) {
            addCriterion("partyCode between", value1, value2, "partyCode");
            return (Criteria) this;
        }

        public Criteria andPartyCodeNotBetween(String value1, String value2) {
            addCriterion("partyCode not between", value1, value2, "partyCode");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeIsNull() {
            addCriterion("learningPlanType is null");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeIsNotNull() {
            addCriterion("learningPlanType is not null");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeEqualTo(Integer value) {
            addCriterion("learningPlanType =", value, "learningPlanType");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeNotEqualTo(Integer value) {
            addCriterion("learningPlanType <>", value, "learningPlanType");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeGreaterThan(Integer value) {
            addCriterion("learningPlanType >", value, "learningPlanType");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("learningPlanType >=", value, "learningPlanType");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeLessThan(Integer value) {
            addCriterion("learningPlanType <", value, "learningPlanType");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeLessThanOrEqualTo(Integer value) {
            addCriterion("learningPlanType <=", value, "learningPlanType");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeIn(List<Integer> values) {
            addCriterion("learningPlanType in", values, "learningPlanType");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeNotIn(List<Integer> values) {
            addCriterion("learningPlanType not in", values, "learningPlanType");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeBetween(Integer value1, Integer value2) {
            addCriterion("learningPlanType between", value1, value2, "learningPlanType");
            return (Criteria) this;
        }

        public Criteria andLearningPlanTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("learningPlanType not between", value1, value2, "learningPlanType");
            return (Criteria) this;
        }

        public Criteria andPublicDateIsNull() {
            addCriterion("publicDate is null");
            return (Criteria) this;
        }

        public Criteria andPublicDateIsNotNull() {
            addCriterion("publicDate is not null");
            return (Criteria) this;
        }

        public Criteria andPublicDateEqualTo(Date value) {
            addCriterionForJDBCDate("publicDate =", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("publicDate <>", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateGreaterThan(Date value) {
            addCriterionForJDBCDate("publicDate >", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publicDate >=", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateLessThan(Date value) {
            addCriterionForJDBCDate("publicDate <", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publicDate <=", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateIn(List<Date> values) {
            addCriterionForJDBCDate("publicDate in", values, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("publicDate not in", values, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publicDate between", value1, value2, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publicDate not between", value1, value2, "publicDate");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("recordStatus is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("recordStatus is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Integer value) {
            addCriterion("recordStatus =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Integer value) {
            addCriterion("recordStatus <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Integer value) {
            addCriterion("recordStatus >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("recordStatus >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Integer value) {
            addCriterion("recordStatus <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Integer value) {
            addCriterion("recordStatus <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Integer> values) {
            addCriterion("recordStatus in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Integer> values) {
            addCriterion("recordStatus not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Integer value1, Integer value2) {
            addCriterion("recordStatus between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("recordStatus not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("createUserId is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("createUserId is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("createUserId =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("createUserId <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("createUserId >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("createUserId >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("createUserId <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("createUserId <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("createUserId like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("createUserId not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("createUserId in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("createUserId not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("createUserId between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("createUserId not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNull() {
            addCriterion("createUserName is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("createUserName is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("createUserName =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("createUserName <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("createUserName >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("createUserName >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("createUserName <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("createUserName <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("createUserName like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("createUserName not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("createUserName in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("createUserName not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("createUserName between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("createUserName not between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("updateUserId is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("updateUserId is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(String value) {
            addCriterion("updateUserId =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(String value) {
            addCriterion("updateUserId <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(String value) {
            addCriterion("updateUserId >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("updateUserId >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(String value) {
            addCriterion("updateUserId <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
            addCriterion("updateUserId <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(String value) {
            addCriterion("updateUserId like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(String value) {
            addCriterion("updateUserId not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<String> values) {
            addCriterion("updateUserId in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<String> values) {
            addCriterion("updateUserId not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(String value1, String value2) {
            addCriterion("updateUserId between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
            addCriterion("updateUserId not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("updateUserName is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("updateUserName is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("updateUserName =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("updateUserName <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("updateUserName >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("updateUserName >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("updateUserName <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("updateUserName <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("updateUserName like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("updateUserName not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(List<String> values) {
            addCriterion("updateUserName in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(List<String> values) {
            addCriterion("updateUserName not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("updateUserName between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("updateUserName not between", value1, value2, "updateUserName");
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