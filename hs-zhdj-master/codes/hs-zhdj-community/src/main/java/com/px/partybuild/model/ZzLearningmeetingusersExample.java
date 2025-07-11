package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzLearningmeetingusersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzLearningmeetingusersExample() {
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

        public Criteria andMeetinguseridIsNull() {
            addCriterion("meetingUserId is null");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridIsNotNull() {
            addCriterion("meetingUserId is not null");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridEqualTo(String value) {
            addCriterion("meetingUserId =", value, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridNotEqualTo(String value) {
            addCriterion("meetingUserId <>", value, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridGreaterThan(String value) {
            addCriterion("meetingUserId >", value, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridGreaterThanOrEqualTo(String value) {
            addCriterion("meetingUserId >=", value, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridLessThan(String value) {
            addCriterion("meetingUserId <", value, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridLessThanOrEqualTo(String value) {
            addCriterion("meetingUserId <=", value, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridLike(String value) {
            addCriterion("meetingUserId like", value, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridNotLike(String value) {
            addCriterion("meetingUserId not like", value, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridIn(List<String> values) {
            addCriterion("meetingUserId in", values, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridNotIn(List<String> values) {
            addCriterion("meetingUserId not in", values, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridBetween(String value1, String value2) {
            addCriterion("meetingUserId between", value1, value2, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetinguseridNotBetween(String value1, String value2) {
            addCriterion("meetingUserId not between", value1, value2, "meetinguserid");
            return (Criteria) this;
        }

        public Criteria andMeetingidIsNull() {
            addCriterion("meetingId is null");
            return (Criteria) this;
        }

        public Criteria andMeetingidIsNotNull() {
            addCriterion("meetingId is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingidEqualTo(String value) {
            addCriterion("meetingId =", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidNotEqualTo(String value) {
            addCriterion("meetingId <>", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidGreaterThan(String value) {
            addCriterion("meetingId >", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidGreaterThanOrEqualTo(String value) {
            addCriterion("meetingId >=", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidLessThan(String value) {
            addCriterion("meetingId <", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidLessThanOrEqualTo(String value) {
            addCriterion("meetingId <=", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidLike(String value) {
            addCriterion("meetingId like", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidNotLike(String value) {
            addCriterion("meetingId not like", value, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidIn(List<String> values) {
            addCriterion("meetingId in", values, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidNotIn(List<String> values) {
            addCriterion("meetingId not in", values, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidBetween(String value1, String value2) {
            addCriterion("meetingId between", value1, value2, "meetingid");
            return (Criteria) this;
        }

        public Criteria andMeetingidNotBetween(String value1, String value2) {
            addCriterion("meetingId not between", value1, value2, "meetingid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("usertype is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("usertype is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Integer value) {
            addCriterion("usertype =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Integer value) {
            addCriterion("usertype <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Integer value) {
            addCriterion("usertype >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("usertype >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Integer value) {
            addCriterion("usertype <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Integer value) {
            addCriterion("usertype <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Integer> values) {
            addCriterion("usertype in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Integer> values) {
            addCriterion("usertype not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Integer value1, Integer value2) {
            addCriterion("usertype between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("usertype not between", value1, value2, "usertype");
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