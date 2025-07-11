package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfLogExample() {
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

        public Criteria andLogidIsNull() {
            addCriterion("LOGID is null");
            return (Criteria) this;
        }

        public Criteria andLogidIsNotNull() {
            addCriterion("LOGID is not null");
            return (Criteria) this;
        }

        public Criteria andLogidEqualTo(String value) {
            addCriterion("LOGID =", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotEqualTo(String value) {
            addCriterion("LOGID <>", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidGreaterThan(String value) {
            addCriterion("LOGID >", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidGreaterThanOrEqualTo(String value) {
            addCriterion("LOGID >=", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLessThan(String value) {
            addCriterion("LOGID <", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLessThanOrEqualTo(String value) {
            addCriterion("LOGID <=", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLike(String value) {
            addCriterion("LOGID like", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotLike(String value) {
            addCriterion("LOGID not like", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidIn(List<String> values) {
            addCriterion("LOGID in", values, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotIn(List<String> values) {
            addCriterion("LOGID not in", values, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidBetween(String value1, String value2) {
            addCriterion("LOGID between", value1, value2, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotBetween(String value1, String value2) {
            addCriterion("LOGID not between", value1, value2, "logid");
            return (Criteria) this;
        }

        public Criteria andRequestipIsNull() {
            addCriterion("REQUESTIP is null");
            return (Criteria) this;
        }

        public Criteria andRequestipIsNotNull() {
            addCriterion("REQUESTIP is not null");
            return (Criteria) this;
        }

        public Criteria andRequestipEqualTo(String value) {
            addCriterion("REQUESTIP =", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotEqualTo(String value) {
            addCriterion("REQUESTIP <>", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipGreaterThan(String value) {
            addCriterion("REQUESTIP >", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipGreaterThanOrEqualTo(String value) {
            addCriterion("REQUESTIP >=", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipLessThan(String value) {
            addCriterion("REQUESTIP <", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipLessThanOrEqualTo(String value) {
            addCriterion("REQUESTIP <=", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipLike(String value) {
            addCriterion("REQUESTIP like", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotLike(String value) {
            addCriterion("REQUESTIP not like", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipIn(List<String> values) {
            addCriterion("REQUESTIP in", values, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotIn(List<String> values) {
            addCriterion("REQUESTIP not in", values, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipBetween(String value1, String value2) {
            addCriterion("REQUESTIP between", value1, value2, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotBetween(String value1, String value2) {
            addCriterion("REQUESTIP not between", value1, value2, "requestip");
            return (Criteria) this;
        }

        public Criteria andLogtimeIsNull() {
            addCriterion("LOGTIME is null");
            return (Criteria) this;
        }

        public Criteria andLogtimeIsNotNull() {
            addCriterion("LOGTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLogtimeEqualTo(Date value) {
            addCriterion("LOGTIME =", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeNotEqualTo(Date value) {
            addCriterion("LOGTIME <>", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeGreaterThan(Date value) {
            addCriterion("LOGTIME >", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LOGTIME >=", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeLessThan(Date value) {
            addCriterion("LOGTIME <", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeLessThanOrEqualTo(Date value) {
            addCriterion("LOGTIME <=", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeIn(List<Date> values) {
            addCriterion("LOGTIME in", values, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeNotIn(List<Date> values) {
            addCriterion("LOGTIME not in", values, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeBetween(Date value1, Date value2) {
            addCriterion("LOGTIME between", value1, value2, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeNotBetween(Date value1, Date value2) {
            addCriterion("LOGTIME not between", value1, value2, "logtime");
            return (Criteria) this;
        }

        public Criteria andOpmoduleIsNull() {
            addCriterion("OPMODULE is null");
            return (Criteria) this;
        }

        public Criteria andOpmoduleIsNotNull() {
            addCriterion("OPMODULE is not null");
            return (Criteria) this;
        }

        public Criteria andOpmoduleEqualTo(String value) {
            addCriterion("OPMODULE =", value, "opmodule");
            return (Criteria) this;
        }

        public Criteria andOpmoduleNotEqualTo(String value) {
            addCriterion("OPMODULE <>", value, "opmodule");
            return (Criteria) this;
        }

        public Criteria andOpmoduleGreaterThan(String value) {
            addCriterion("OPMODULE >", value, "opmodule");
            return (Criteria) this;
        }

        public Criteria andOpmoduleGreaterThanOrEqualTo(String value) {
            addCriterion("OPMODULE >=", value, "opmodule");
            return (Criteria) this;
        }

        public Criteria andOpmoduleLessThan(String value) {
            addCriterion("OPMODULE <", value, "opmodule");
            return (Criteria) this;
        }

        public Criteria andOpmoduleLessThanOrEqualTo(String value) {
            addCriterion("OPMODULE <=", value, "opmodule");
            return (Criteria) this;
        }

        public Criteria andOpmoduleLike(String value) {
            addCriterion("OPMODULE like", value, "opmodule");
            return (Criteria) this;
        }

        public Criteria andOpmoduleNotLike(String value) {
            addCriterion("OPMODULE not like", value, "opmodule");
            return (Criteria) this;
        }

        public Criteria andOpmoduleIn(List<String> values) {
            addCriterion("OPMODULE in", values, "opmodule");
            return (Criteria) this;
        }

        public Criteria andOpmoduleNotIn(List<String> values) {
            addCriterion("OPMODULE not in", values, "opmodule");
            return (Criteria) this;
        }

        public Criteria andOpmoduleBetween(String value1, String value2) {
            addCriterion("OPMODULE between", value1, value2, "opmodule");
            return (Criteria) this;
        }

        public Criteria andOpmoduleNotBetween(String value1, String value2) {
            addCriterion("OPMODULE not between", value1, value2, "opmodule");
            return (Criteria) this;
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

        public Criteria andLogtitleIsNull() {
            addCriterion("LOGTITLE is null");
            return (Criteria) this;
        }

        public Criteria andLogtitleIsNotNull() {
            addCriterion("LOGTITLE is not null");
            return (Criteria) this;
        }

        public Criteria andLogtitleEqualTo(String value) {
            addCriterion("LOGTITLE =", value, "logtitle");
            return (Criteria) this;
        }

        public Criteria andLogtitleNotEqualTo(String value) {
            addCriterion("LOGTITLE <>", value, "logtitle");
            return (Criteria) this;
        }

        public Criteria andLogtitleGreaterThan(String value) {
            addCriterion("LOGTITLE >", value, "logtitle");
            return (Criteria) this;
        }

        public Criteria andLogtitleGreaterThanOrEqualTo(String value) {
            addCriterion("LOGTITLE >=", value, "logtitle");
            return (Criteria) this;
        }

        public Criteria andLogtitleLessThan(String value) {
            addCriterion("LOGTITLE <", value, "logtitle");
            return (Criteria) this;
        }

        public Criteria andLogtitleLessThanOrEqualTo(String value) {
            addCriterion("LOGTITLE <=", value, "logtitle");
            return (Criteria) this;
        }

        public Criteria andLogtitleLike(String value) {
            addCriterion("LOGTITLE like", value, "logtitle");
            return (Criteria) this;
        }

        public Criteria andLogtitleNotLike(String value) {
            addCriterion("LOGTITLE not like", value, "logtitle");
            return (Criteria) this;
        }

        public Criteria andLogtitleIn(List<String> values) {
            addCriterion("LOGTITLE in", values, "logtitle");
            return (Criteria) this;
        }

        public Criteria andLogtitleNotIn(List<String> values) {
            addCriterion("LOGTITLE not in", values, "logtitle");
            return (Criteria) this;
        }

        public Criteria andLogtitleBetween(String value1, String value2) {
            addCriterion("LOGTITLE between", value1, value2, "logtitle");
            return (Criteria) this;
        }

        public Criteria andLogtitleNotBetween(String value1, String value2) {
            addCriterion("LOGTITLE not between", value1, value2, "logtitle");
            return (Criteria) this;
        }

        public Criteria andClientinfoIsNull() {
            addCriterion("CLIENTINFO is null");
            return (Criteria) this;
        }

        public Criteria andClientinfoIsNotNull() {
            addCriterion("CLIENTINFO is not null");
            return (Criteria) this;
        }

        public Criteria andClientinfoEqualTo(String value) {
            addCriterion("CLIENTINFO =", value, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andClientinfoNotEqualTo(String value) {
            addCriterion("CLIENTINFO <>", value, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andClientinfoGreaterThan(String value) {
            addCriterion("CLIENTINFO >", value, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andClientinfoGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENTINFO >=", value, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andClientinfoLessThan(String value) {
            addCriterion("CLIENTINFO <", value, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andClientinfoLessThanOrEqualTo(String value) {
            addCriterion("CLIENTINFO <=", value, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andClientinfoLike(String value) {
            addCriterion("CLIENTINFO like", value, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andClientinfoNotLike(String value) {
            addCriterion("CLIENTINFO not like", value, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andClientinfoIn(List<String> values) {
            addCriterion("CLIENTINFO in", values, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andClientinfoNotIn(List<String> values) {
            addCriterion("CLIENTINFO not in", values, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andClientinfoBetween(String value1, String value2) {
            addCriterion("CLIENTINFO between", value1, value2, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andClientinfoNotBetween(String value1, String value2) {
            addCriterion("CLIENTINFO not between", value1, value2, "clientinfo");
            return (Criteria) this;
        }

        public Criteria andResponsetimeIsNull() {
            addCriterion("RESPONSETIME is null");
            return (Criteria) this;
        }

        public Criteria andResponsetimeIsNotNull() {
            addCriterion("RESPONSETIME is not null");
            return (Criteria) this;
        }

        public Criteria andResponsetimeEqualTo(Integer value) {
            addCriterion("RESPONSETIME =", value, "responsetime");
            return (Criteria) this;
        }

        public Criteria andResponsetimeNotEqualTo(Integer value) {
            addCriterion("RESPONSETIME <>", value, "responsetime");
            return (Criteria) this;
        }

        public Criteria andResponsetimeGreaterThan(Integer value) {
            addCriterion("RESPONSETIME >", value, "responsetime");
            return (Criteria) this;
        }

        public Criteria andResponsetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("RESPONSETIME >=", value, "responsetime");
            return (Criteria) this;
        }

        public Criteria andResponsetimeLessThan(Integer value) {
            addCriterion("RESPONSETIME <", value, "responsetime");
            return (Criteria) this;
        }

        public Criteria andResponsetimeLessThanOrEqualTo(Integer value) {
            addCriterion("RESPONSETIME <=", value, "responsetime");
            return (Criteria) this;
        }

        public Criteria andResponsetimeIn(List<Integer> values) {
            addCriterion("RESPONSETIME in", values, "responsetime");
            return (Criteria) this;
        }

        public Criteria andResponsetimeNotIn(List<Integer> values) {
            addCriterion("RESPONSETIME not in", values, "responsetime");
            return (Criteria) this;
        }

        public Criteria andResponsetimeBetween(Integer value1, Integer value2) {
            addCriterion("RESPONSETIME between", value1, value2, "responsetime");
            return (Criteria) this;
        }

        public Criteria andResponsetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("RESPONSETIME not between", value1, value2, "responsetime");
            return (Criteria) this;
        }

        public Criteria andIserrorIsNull() {
            addCriterion("ISERROR is null");
            return (Criteria) this;
        }

        public Criteria andIserrorIsNotNull() {
            addCriterion("ISERROR is not null");
            return (Criteria) this;
        }

        public Criteria andIserrorEqualTo(Integer value) {
            addCriterion("ISERROR =", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorNotEqualTo(Integer value) {
            addCriterion("ISERROR <>", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorGreaterThan(Integer value) {
            addCriterion("ISERROR >", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISERROR >=", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorLessThan(Integer value) {
            addCriterion("ISERROR <", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorLessThanOrEqualTo(Integer value) {
            addCriterion("ISERROR <=", value, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorIn(List<Integer> values) {
            addCriterion("ISERROR in", values, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorNotIn(List<Integer> values) {
            addCriterion("ISERROR not in", values, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorBetween(Integer value1, Integer value2) {
            addCriterion("ISERROR between", value1, value2, "iserror");
            return (Criteria) this;
        }

        public Criteria andIserrorNotBetween(Integer value1, Integer value2) {
            addCriterion("ISERROR not between", value1, value2, "iserror");
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