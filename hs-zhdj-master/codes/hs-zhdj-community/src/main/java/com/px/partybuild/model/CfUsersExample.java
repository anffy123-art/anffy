package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfUsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfUsersExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("USERID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("USERID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andApplicationidIsNull() {
            addCriterion("APPLICATIONID is null");
            return (Criteria) this;
        }

        public Criteria andApplicationidIsNotNull() {
            addCriterion("APPLICATIONID is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationidEqualTo(String value) {
            addCriterion("APPLICATIONID =", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotEqualTo(String value) {
            addCriterion("APPLICATIONID <>", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidGreaterThan(String value) {
            addCriterion("APPLICATIONID >", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidGreaterThanOrEqualTo(String value) {
            addCriterion("APPLICATIONID >=", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidLessThan(String value) {
            addCriterion("APPLICATIONID <", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidLessThanOrEqualTo(String value) {
            addCriterion("APPLICATIONID <=", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidLike(String value) {
            addCriterion("APPLICATIONID like", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotLike(String value) {
            addCriterion("APPLICATIONID not like", value, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidIn(List<String> values) {
            addCriterion("APPLICATIONID in", values, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotIn(List<String> values) {
            addCriterion("APPLICATIONID not in", values, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidBetween(String value1, String value2) {
            addCriterion("APPLICATIONID between", value1, value2, "applicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationidNotBetween(String value1, String value2) {
            addCriterion("APPLICATIONID not between", value1, value2, "applicationid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andIsanonymousIsNull() {
            addCriterion("ISANONYMOUS is null");
            return (Criteria) this;
        }

        public Criteria andIsanonymousIsNotNull() {
            addCriterion("ISANONYMOUS is not null");
            return (Criteria) this;
        }

        public Criteria andIsanonymousEqualTo(Integer value) {
            addCriterion("ISANONYMOUS =", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousNotEqualTo(Integer value) {
            addCriterion("ISANONYMOUS <>", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousGreaterThan(Integer value) {
            addCriterion("ISANONYMOUS >", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISANONYMOUS >=", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousLessThan(Integer value) {
            addCriterion("ISANONYMOUS <", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousLessThanOrEqualTo(Integer value) {
            addCriterion("ISANONYMOUS <=", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousIn(List<Integer> values) {
            addCriterion("ISANONYMOUS in", values, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousNotIn(List<Integer> values) {
            addCriterion("ISANONYMOUS not in", values, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousBetween(Integer value1, Integer value2) {
            addCriterion("ISANONYMOUS between", value1, value2, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousNotBetween(Integer value1, Integer value2) {
            addCriterion("ISANONYMOUS not between", value1, value2, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateIsNull() {
            addCriterion("LASTACTIVITYDATE is null");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateIsNotNull() {
            addCriterion("LASTACTIVITYDATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateEqualTo(Date value) {
            addCriterion("LASTACTIVITYDATE =", value, "lastactivitydate");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateNotEqualTo(Date value) {
            addCriterion("LASTACTIVITYDATE <>", value, "lastactivitydate");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateGreaterThan(Date value) {
            addCriterion("LASTACTIVITYDATE >", value, "lastactivitydate");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateGreaterThanOrEqualTo(Date value) {
            addCriterion("LASTACTIVITYDATE >=", value, "lastactivitydate");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateLessThan(Date value) {
            addCriterion("LASTACTIVITYDATE <", value, "lastactivitydate");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateLessThanOrEqualTo(Date value) {
            addCriterion("LASTACTIVITYDATE <=", value, "lastactivitydate");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateIn(List<Date> values) {
            addCriterion("LASTACTIVITYDATE in", values, "lastactivitydate");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateNotIn(List<Date> values) {
            addCriterion("LASTACTIVITYDATE not in", values, "lastactivitydate");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateBetween(Date value1, Date value2) {
            addCriterion("LASTACTIVITYDATE between", value1, value2, "lastactivitydate");
            return (Criteria) this;
        }

        public Criteria andLastactivitydateNotBetween(Date value1, Date value2) {
            addCriterion("LASTACTIVITYDATE not between", value1, value2, "lastactivitydate");
            return (Criteria) this;
        }

        public Criteria andUserpwdIsNull() {
            addCriterion("USERPWD is null");
            return (Criteria) this;
        }

        public Criteria andUserpwdIsNotNull() {
            addCriterion("USERPWD is not null");
            return (Criteria) this;
        }

        public Criteria andUserpwdEqualTo(String value) {
            addCriterion("USERPWD =", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotEqualTo(String value) {
            addCriterion("USERPWD <>", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdGreaterThan(String value) {
            addCriterion("USERPWD >", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdGreaterThanOrEqualTo(String value) {
            addCriterion("USERPWD >=", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdLessThan(String value) {
            addCriterion("USERPWD <", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdLessThanOrEqualTo(String value) {
            addCriterion("USERPWD <=", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdLike(String value) {
            addCriterion("USERPWD like", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotLike(String value) {
            addCriterion("USERPWD not like", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdIn(List<String> values) {
            addCriterion("USERPWD in", values, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotIn(List<String> values) {
            addCriterion("USERPWD not in", values, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdBetween(String value1, String value2) {
            addCriterion("USERPWD between", value1, value2, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotBetween(String value1, String value2) {
            addCriterion("USERPWD not between", value1, value2, "userpwd");
            return (Criteria) this;
        }

        public Criteria andForceloginoutIsNull() {
            addCriterion("FORCELOGINOUT is null");
            return (Criteria) this;
        }

        public Criteria andForceloginoutIsNotNull() {
            addCriterion("FORCELOGINOUT is not null");
            return (Criteria) this;
        }

        public Criteria andForceloginoutEqualTo(Integer value) {
            addCriterion("FORCELOGINOUT =", value, "forceloginout");
            return (Criteria) this;
        }

        public Criteria andForceloginoutNotEqualTo(Integer value) {
            addCriterion("FORCELOGINOUT <>", value, "forceloginout");
            return (Criteria) this;
        }

        public Criteria andForceloginoutGreaterThan(Integer value) {
            addCriterion("FORCELOGINOUT >", value, "forceloginout");
            return (Criteria) this;
        }

        public Criteria andForceloginoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("FORCELOGINOUT >=", value, "forceloginout");
            return (Criteria) this;
        }

        public Criteria andForceloginoutLessThan(Integer value) {
            addCriterion("FORCELOGINOUT <", value, "forceloginout");
            return (Criteria) this;
        }

        public Criteria andForceloginoutLessThanOrEqualTo(Integer value) {
            addCriterion("FORCELOGINOUT <=", value, "forceloginout");
            return (Criteria) this;
        }

        public Criteria andForceloginoutIn(List<Integer> values) {
            addCriterion("FORCELOGINOUT in", values, "forceloginout");
            return (Criteria) this;
        }

        public Criteria andForceloginoutNotIn(List<Integer> values) {
            addCriterion("FORCELOGINOUT not in", values, "forceloginout");
            return (Criteria) this;
        }

        public Criteria andForceloginoutBetween(Integer value1, Integer value2) {
            addCriterion("FORCELOGINOUT between", value1, value2, "forceloginout");
            return (Criteria) this;
        }

        public Criteria andForceloginoutNotBetween(Integer value1, Integer value2) {
            addCriterion("FORCELOGINOUT not between", value1, value2, "forceloginout");
            return (Criteria) this;
        }

        public Criteria andOauseridIsNull() {
            addCriterion("OAUSERID is null");
            return (Criteria) this;
        }

        public Criteria andOauseridIsNotNull() {
            addCriterion("OAUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andOauseridEqualTo(String value) {
            addCriterion("OAUSERID =", value, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOauseridNotEqualTo(String value) {
            addCriterion("OAUSERID <>", value, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOauseridGreaterThan(String value) {
            addCriterion("OAUSERID >", value, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOauseridGreaterThanOrEqualTo(String value) {
            addCriterion("OAUSERID >=", value, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOauseridLessThan(String value) {
            addCriterion("OAUSERID <", value, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOauseridLessThanOrEqualTo(String value) {
            addCriterion("OAUSERID <=", value, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOauseridLike(String value) {
            addCriterion("OAUSERID like", value, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOauseridNotLike(String value) {
            addCriterion("OAUSERID not like", value, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOauseridIn(List<String> values) {
            addCriterion("OAUSERID in", values, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOauseridNotIn(List<String> values) {
            addCriterion("OAUSERID not in", values, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOauseridBetween(String value1, String value2) {
            addCriterion("OAUSERID between", value1, value2, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOauseridNotBetween(String value1, String value2) {
            addCriterion("OAUSERID not between", value1, value2, "oauserid");
            return (Criteria) this;
        }

        public Criteria andOausersfzIsNull() {
            addCriterion("OAUSERSFZ is null");
            return (Criteria) this;
        }

        public Criteria andOausersfzIsNotNull() {
            addCriterion("OAUSERSFZ is not null");
            return (Criteria) this;
        }

        public Criteria andOausersfzEqualTo(String value) {
            addCriterion("OAUSERSFZ =", value, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andOausersfzNotEqualTo(String value) {
            addCriterion("OAUSERSFZ <>", value, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andOausersfzGreaterThan(String value) {
            addCriterion("OAUSERSFZ >", value, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andOausersfzGreaterThanOrEqualTo(String value) {
            addCriterion("OAUSERSFZ >=", value, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andOausersfzLessThan(String value) {
            addCriterion("OAUSERSFZ <", value, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andOausersfzLessThanOrEqualTo(String value) {
            addCriterion("OAUSERSFZ <=", value, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andOausersfzLike(String value) {
            addCriterion("OAUSERSFZ like", value, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andOausersfzNotLike(String value) {
            addCriterion("OAUSERSFZ not like", value, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andOausersfzIn(List<String> values) {
            addCriterion("OAUSERSFZ in", values, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andOausersfzNotIn(List<String> values) {
            addCriterion("OAUSERSFZ not in", values, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andOausersfzBetween(String value1, String value2) {
            addCriterion("OAUSERSFZ between", value1, value2, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andOausersfzNotBetween(String value1, String value2) {
            addCriterion("OAUSERSFZ not between", value1, value2, "oausersfz");
            return (Criteria) this;
        }

        public Criteria andWxuseridIsNull() {
            addCriterion("wxUserId is null");
            return (Criteria) this;
        }

        public Criteria andWxuseridIsNotNull() {
            addCriterion("wxUserId is not null");
            return (Criteria) this;
        }

        public Criteria andWxuseridEqualTo(String value) {
            addCriterion("wxUserId =", value, "wxuserid");
            return (Criteria) this;
        }

        public Criteria andWxuseridNotEqualTo(String value) {
            addCriterion("wxUserId <>", value, "wxuserid");
            return (Criteria) this;
        }

        public Criteria andWxuseridGreaterThan(String value) {
            addCriterion("wxUserId >", value, "wxuserid");
            return (Criteria) this;
        }

        public Criteria andWxuseridGreaterThanOrEqualTo(String value) {
            addCriterion("wxUserId >=", value, "wxuserid");
            return (Criteria) this;
        }

        public Criteria andWxuseridLessThan(String value) {
            addCriterion("wxUserId <", value, "wxuserid");
            return (Criteria) this;
        }

        public Criteria andWxuseridLessThanOrEqualTo(String value) {
            addCriterion("wxUserId <=", value, "wxuserid");
            return (Criteria) this;
        }

        public Criteria andWxuseridLike(String value) {
            addCriterion("wxUserId like", value, "wxuserid");
            return (Criteria) this;
        }

        public Criteria andWxuseridNotLike(String value) {
            addCriterion("wxUserId not like", value, "wxuserid");
            return (Criteria) this;
        }

        public Criteria andWxuseridIn(List<String> values) {
            addCriterion("wxUserId in", values, "wxuserid");
            return (Criteria) this;
        }

        public Criteria andWxuseridNotIn(List<String> values) {
            addCriterion("wxUserId not in", values, "wxuserid");
            return (Criteria) this;
        }

        public Criteria andWxuseridBetween(String value1, String value2) {
            addCriterion("wxUserId between", value1, value2, "wxuserid");
            return (Criteria) this;
        }

        public Criteria andWxuseridNotBetween(String value1, String value2) {
            addCriterion("wxUserId not between", value1, value2, "wxuserid");
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