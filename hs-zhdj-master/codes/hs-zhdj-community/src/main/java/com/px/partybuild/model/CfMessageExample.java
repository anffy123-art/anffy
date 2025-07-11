package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfMessageExample() {
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

        public Criteria andMessageidIsNull() {
            addCriterion("MESSAGEID is null");
            return (Criteria) this;
        }

        public Criteria andMessageidIsNotNull() {
            addCriterion("MESSAGEID is not null");
            return (Criteria) this;
        }

        public Criteria andMessageidEqualTo(String value) {
            addCriterion("MESSAGEID =", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotEqualTo(String value) {
            addCriterion("MESSAGEID <>", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThan(String value) {
            addCriterion("MESSAGEID >", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGEID >=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThan(String value) {
            addCriterion("MESSAGEID <", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThanOrEqualTo(String value) {
            addCriterion("MESSAGEID <=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLike(String value) {
            addCriterion("MESSAGEID like", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotLike(String value) {
            addCriterion("MESSAGEID not like", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidIn(List<String> values) {
            addCriterion("MESSAGEID in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotIn(List<String> values) {
            addCriterion("MESSAGEID not in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidBetween(String value1, String value2) {
            addCriterion("MESSAGEID between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotBetween(String value1, String value2) {
            addCriterion("MESSAGEID not between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andMsgtitleIsNull() {
            addCriterion("MSGTITLE is null");
            return (Criteria) this;
        }

        public Criteria andMsgtitleIsNotNull() {
            addCriterion("MSGTITLE is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtitleEqualTo(String value) {
            addCriterion("MSGTITLE =", value, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andMsgtitleNotEqualTo(String value) {
            addCriterion("MSGTITLE <>", value, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andMsgtitleGreaterThan(String value) {
            addCriterion("MSGTITLE >", value, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andMsgtitleGreaterThanOrEqualTo(String value) {
            addCriterion("MSGTITLE >=", value, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andMsgtitleLessThan(String value) {
            addCriterion("MSGTITLE <", value, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andMsgtitleLessThanOrEqualTo(String value) {
            addCriterion("MSGTITLE <=", value, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andMsgtitleLike(String value) {
            addCriterion("MSGTITLE like", value, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andMsgtitleNotLike(String value) {
            addCriterion("MSGTITLE not like", value, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andMsgtitleIn(List<String> values) {
            addCriterion("MSGTITLE in", values, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andMsgtitleNotIn(List<String> values) {
            addCriterion("MSGTITLE not in", values, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andMsgtitleBetween(String value1, String value2) {
            addCriterion("MSGTITLE between", value1, value2, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andMsgtitleNotBetween(String value1, String value2) {
            addCriterion("MSGTITLE not between", value1, value2, "msgtitle");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andFromuserIsNull() {
            addCriterion("FROMUSER is null");
            return (Criteria) this;
        }

        public Criteria andFromuserIsNotNull() {
            addCriterion("FROMUSER is not null");
            return (Criteria) this;
        }

        public Criteria andFromuserEqualTo(String value) {
            addCriterion("FROMUSER =", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserNotEqualTo(String value) {
            addCriterion("FROMUSER <>", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserGreaterThan(String value) {
            addCriterion("FROMUSER >", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserGreaterThanOrEqualTo(String value) {
            addCriterion("FROMUSER >=", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserLessThan(String value) {
            addCriterion("FROMUSER <", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserLessThanOrEqualTo(String value) {
            addCriterion("FROMUSER <=", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserLike(String value) {
            addCriterion("FROMUSER like", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserNotLike(String value) {
            addCriterion("FROMUSER not like", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserIn(List<String> values) {
            addCriterion("FROMUSER in", values, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserNotIn(List<String> values) {
            addCriterion("FROMUSER not in", values, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserBetween(String value1, String value2) {
            addCriterion("FROMUSER between", value1, value2, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserNotBetween(String value1, String value2) {
            addCriterion("FROMUSER not between", value1, value2, "fromuser");
            return (Criteria) this;
        }

        public Criteria andTouserIsNull() {
            addCriterion("TOUSER is null");
            return (Criteria) this;
        }

        public Criteria andTouserIsNotNull() {
            addCriterion("TOUSER is not null");
            return (Criteria) this;
        }

        public Criteria andTouserEqualTo(String value) {
            addCriterion("TOUSER =", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotEqualTo(String value) {
            addCriterion("TOUSER <>", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserGreaterThan(String value) {
            addCriterion("TOUSER >", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserGreaterThanOrEqualTo(String value) {
            addCriterion("TOUSER >=", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserLessThan(String value) {
            addCriterion("TOUSER <", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserLessThanOrEqualTo(String value) {
            addCriterion("TOUSER <=", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserLike(String value) {
            addCriterion("TOUSER like", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotLike(String value) {
            addCriterion("TOUSER not like", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserIn(List<String> values) {
            addCriterion("TOUSER in", values, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotIn(List<String> values) {
            addCriterion("TOUSER not in", values, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserBetween(String value1, String value2) {
            addCriterion("TOUSER between", value1, value2, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotBetween(String value1, String value2) {
            addCriterion("TOUSER not between", value1, value2, "touser");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("SENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("SENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("SENDTIME =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("SENDTIME <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("SENDTIME >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SENDTIME >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("SENDTIME <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("SENDTIME <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("SENDTIME in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("SENDTIME not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("SENDTIME between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("SENDTIME not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("STATE not between", value1, value2, "state");
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

        public Criteria andBusinessidIsNull() {
            addCriterion("BUSINESSID is null");
            return (Criteria) this;
        }

        public Criteria andBusinessidIsNotNull() {
            addCriterion("BUSINESSID is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessidEqualTo(String value) {
            addCriterion("BUSINESSID =", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidNotEqualTo(String value) {
            addCriterion("BUSINESSID <>", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidGreaterThan(String value) {
            addCriterion("BUSINESSID >", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESSID >=", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidLessThan(String value) {
            addCriterion("BUSINESSID <", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidLessThanOrEqualTo(String value) {
            addCriterion("BUSINESSID <=", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidLike(String value) {
            addCriterion("BUSINESSID like", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidNotLike(String value) {
            addCriterion("BUSINESSID not like", value, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidIn(List<String> values) {
            addCriterion("BUSINESSID in", values, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidNotIn(List<String> values) {
            addCriterion("BUSINESSID not in", values, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidBetween(String value1, String value2) {
            addCriterion("BUSINESSID between", value1, value2, "businessid");
            return (Criteria) this;
        }

        public Criteria andBusinessidNotBetween(String value1, String value2) {
            addCriterion("BUSINESSID not between", value1, value2, "businessid");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNull() {
            addCriterion("MESSAGETYPE is null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIsNotNull() {
            addCriterion("MESSAGETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMessagetypeEqualTo(Integer value) {
            addCriterion("MESSAGETYPE =", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotEqualTo(Integer value) {
            addCriterion("MESSAGETYPE <>", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThan(Integer value) {
            addCriterion("MESSAGETYPE >", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MESSAGETYPE >=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThan(Integer value) {
            addCriterion("MESSAGETYPE <", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeLessThanOrEqualTo(Integer value) {
            addCriterion("MESSAGETYPE <=", value, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeIn(List<Integer> values) {
            addCriterion("MESSAGETYPE in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotIn(List<Integer> values) {
            addCriterion("MESSAGETYPE not in", values, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeBetween(Integer value1, Integer value2) {
            addCriterion("MESSAGETYPE between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andMessagetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("MESSAGETYPE not between", value1, value2, "messagetype");
            return (Criteria) this;
        }

        public Criteria andServiceidIsNull() {
            addCriterion("SERVICEID is null");
            return (Criteria) this;
        }

        public Criteria andServiceidIsNotNull() {
            addCriterion("SERVICEID is not null");
            return (Criteria) this;
        }

        public Criteria andServiceidEqualTo(String value) {
            addCriterion("SERVICEID =", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotEqualTo(String value) {
            addCriterion("SERVICEID <>", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidGreaterThan(String value) {
            addCriterion("SERVICEID >", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICEID >=", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLessThan(String value) {
            addCriterion("SERVICEID <", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLessThanOrEqualTo(String value) {
            addCriterion("SERVICEID <=", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLike(String value) {
            addCriterion("SERVICEID like", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotLike(String value) {
            addCriterion("SERVICEID not like", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidIn(List<String> values) {
            addCriterion("SERVICEID in", values, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotIn(List<String> values) {
            addCriterion("SERVICEID not in", values, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidBetween(String value1, String value2) {
            addCriterion("SERVICEID between", value1, value2, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotBetween(String value1, String value2) {
            addCriterion("SERVICEID not between", value1, value2, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServicestateIsNull() {
            addCriterion("SERVICESTATE is null");
            return (Criteria) this;
        }

        public Criteria andServicestateIsNotNull() {
            addCriterion("SERVICESTATE is not null");
            return (Criteria) this;
        }

        public Criteria andServicestateEqualTo(Integer value) {
            addCriterion("SERVICESTATE =", value, "servicestate");
            return (Criteria) this;
        }

        public Criteria andServicestateNotEqualTo(Integer value) {
            addCriterion("SERVICESTATE <>", value, "servicestate");
            return (Criteria) this;
        }

        public Criteria andServicestateGreaterThan(Integer value) {
            addCriterion("SERVICESTATE >", value, "servicestate");
            return (Criteria) this;
        }

        public Criteria andServicestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICESTATE >=", value, "servicestate");
            return (Criteria) this;
        }

        public Criteria andServicestateLessThan(Integer value) {
            addCriterion("SERVICESTATE <", value, "servicestate");
            return (Criteria) this;
        }

        public Criteria andServicestateLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICESTATE <=", value, "servicestate");
            return (Criteria) this;
        }

        public Criteria andServicestateIn(List<Integer> values) {
            addCriterion("SERVICESTATE in", values, "servicestate");
            return (Criteria) this;
        }

        public Criteria andServicestateNotIn(List<Integer> values) {
            addCriterion("SERVICESTATE not in", values, "servicestate");
            return (Criteria) this;
        }

        public Criteria andServicestateBetween(Integer value1, Integer value2) {
            addCriterion("SERVICESTATE between", value1, value2, "servicestate");
            return (Criteria) this;
        }

        public Criteria andServicestateNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICESTATE not between", value1, value2, "servicestate");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeIsNull() {
            addCriterion("SERVICEUPDATATIME is null");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeIsNotNull() {
            addCriterion("SERVICEUPDATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeEqualTo(Date value) {
            addCriterion("SERVICEUPDATATIME =", value, "serviceupdatatime");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeNotEqualTo(Date value) {
            addCriterion("SERVICEUPDATATIME <>", value, "serviceupdatatime");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeGreaterThan(Date value) {
            addCriterion("SERVICEUPDATATIME >", value, "serviceupdatatime");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SERVICEUPDATATIME >=", value, "serviceupdatatime");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeLessThan(Date value) {
            addCriterion("SERVICEUPDATATIME <", value, "serviceupdatatime");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeLessThanOrEqualTo(Date value) {
            addCriterion("SERVICEUPDATATIME <=", value, "serviceupdatatime");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeIn(List<Date> values) {
            addCriterion("SERVICEUPDATATIME in", values, "serviceupdatatime");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeNotIn(List<Date> values) {
            addCriterion("SERVICEUPDATATIME not in", values, "serviceupdatatime");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeBetween(Date value1, Date value2) {
            addCriterion("SERVICEUPDATATIME between", value1, value2, "serviceupdatatime");
            return (Criteria) this;
        }

        public Criteria andServiceupdatatimeNotBetween(Date value1, Date value2) {
            addCriterion("SERVICEUPDATATIME not between", value1, value2, "serviceupdatatime");
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