package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfDictionaryExample() {
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

        public Criteria andDictionaryidIsNull() {
            addCriterion("DICTIONARYID is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryidIsNotNull() {
            addCriterion("DICTIONARYID is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryidEqualTo(String value) {
            addCriterion("DICTIONARYID =", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidNotEqualTo(String value) {
            addCriterion("DICTIONARYID <>", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidGreaterThan(String value) {
            addCriterion("DICTIONARYID >", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidGreaterThanOrEqualTo(String value) {
            addCriterion("DICTIONARYID >=", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidLessThan(String value) {
            addCriterion("DICTIONARYID <", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidLessThanOrEqualTo(String value) {
            addCriterion("DICTIONARYID <=", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidLike(String value) {
            addCriterion("DICTIONARYID like", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidNotLike(String value) {
            addCriterion("DICTIONARYID not like", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidIn(List<String> values) {
            addCriterion("DICTIONARYID in", values, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidNotIn(List<String> values) {
            addCriterion("DICTIONARYID not in", values, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidBetween(String value1, String value2) {
            addCriterion("DICTIONARYID between", value1, value2, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidNotBetween(String value1, String value2) {
            addCriterion("DICTIONARYID not between", value1, value2, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDickeyIsNull() {
            addCriterion("DICKEY is null");
            return (Criteria) this;
        }

        public Criteria andDickeyIsNotNull() {
            addCriterion("DICKEY is not null");
            return (Criteria) this;
        }

        public Criteria andDickeyEqualTo(Integer value) {
            addCriterion("DICKEY =", value, "dickey");
            return (Criteria) this;
        }

        public Criteria andDickeyNotEqualTo(Integer value) {
            addCriterion("DICKEY <>", value, "dickey");
            return (Criteria) this;
        }

        public Criteria andDickeyGreaterThan(Integer value) {
            addCriterion("DICKEY >", value, "dickey");
            return (Criteria) this;
        }

        public Criteria andDickeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("DICKEY >=", value, "dickey");
            return (Criteria) this;
        }

        public Criteria andDickeyLessThan(Integer value) {
            addCriterion("DICKEY <", value, "dickey");
            return (Criteria) this;
        }

        public Criteria andDickeyLessThanOrEqualTo(Integer value) {
            addCriterion("DICKEY <=", value, "dickey");
            return (Criteria) this;
        }

        public Criteria andDickeyIn(List<Integer> values) {
            addCriterion("DICKEY in", values, "dickey");
            return (Criteria) this;
        }

        public Criteria andDickeyNotIn(List<Integer> values) {
            addCriterion("DICKEY not in", values, "dickey");
            return (Criteria) this;
        }

        public Criteria andDickeyBetween(Integer value1, Integer value2) {
            addCriterion("DICKEY between", value1, value2, "dickey");
            return (Criteria) this;
        }

        public Criteria andDickeyNotBetween(Integer value1, Integer value2) {
            addCriterion("DICKEY not between", value1, value2, "dickey");
            return (Criteria) this;
        }

        public Criteria andDicvalueIsNull() {
            addCriterion("DICVALUE is null");
            return (Criteria) this;
        }

        public Criteria andDicvalueIsNotNull() {
            addCriterion("DICVALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDicvalueEqualTo(String value) {
            addCriterion("DICVALUE =", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotEqualTo(String value) {
            addCriterion("DICVALUE <>", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueGreaterThan(String value) {
            addCriterion("DICVALUE >", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueGreaterThanOrEqualTo(String value) {
            addCriterion("DICVALUE >=", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueLessThan(String value) {
            addCriterion("DICVALUE <", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueLessThanOrEqualTo(String value) {
            addCriterion("DICVALUE <=", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueLike(String value) {
            addCriterion("DICVALUE like", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotLike(String value) {
            addCriterion("DICVALUE not like", value, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueIn(List<String> values) {
            addCriterion("DICVALUE in", values, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotIn(List<String> values) {
            addCriterion("DICVALUE not in", values, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueBetween(String value1, String value2) {
            addCriterion("DICVALUE between", value1, value2, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDicvalueNotBetween(String value1, String value2) {
            addCriterion("DICVALUE not between", value1, value2, "dicvalue");
            return (Criteria) this;
        }

        public Criteria andDictypekeyIsNull() {
            addCriterion("DICTYPEKEY is null");
            return (Criteria) this;
        }

        public Criteria andDictypekeyIsNotNull() {
            addCriterion("DICTYPEKEY is not null");
            return (Criteria) this;
        }

        public Criteria andDictypekeyEqualTo(String value) {
            addCriterion("DICTYPEKEY =", value, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypekeyNotEqualTo(String value) {
            addCriterion("DICTYPEKEY <>", value, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypekeyGreaterThan(String value) {
            addCriterion("DICTYPEKEY >", value, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypekeyGreaterThanOrEqualTo(String value) {
            addCriterion("DICTYPEKEY >=", value, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypekeyLessThan(String value) {
            addCriterion("DICTYPEKEY <", value, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypekeyLessThanOrEqualTo(String value) {
            addCriterion("DICTYPEKEY <=", value, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypekeyLike(String value) {
            addCriterion("DICTYPEKEY like", value, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypekeyNotLike(String value) {
            addCriterion("DICTYPEKEY not like", value, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypekeyIn(List<String> values) {
            addCriterion("DICTYPEKEY in", values, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypekeyNotIn(List<String> values) {
            addCriterion("DICTYPEKEY not in", values, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypekeyBetween(String value1, String value2) {
            addCriterion("DICTYPEKEY between", value1, value2, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypekeyNotBetween(String value1, String value2) {
            addCriterion("DICTYPEKEY not between", value1, value2, "dictypekey");
            return (Criteria) this;
        }

        public Criteria andDictypeIsNull() {
            addCriterion("DICTYPE is null");
            return (Criteria) this;
        }

        public Criteria andDictypeIsNotNull() {
            addCriterion("DICTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDictypeEqualTo(Integer value) {
            addCriterion("DICTYPE =", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeNotEqualTo(Integer value) {
            addCriterion("DICTYPE <>", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeGreaterThan(Integer value) {
            addCriterion("DICTYPE >", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DICTYPE >=", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeLessThan(Integer value) {
            addCriterion("DICTYPE <", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeLessThanOrEqualTo(Integer value) {
            addCriterion("DICTYPE <=", value, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeIn(List<Integer> values) {
            addCriterion("DICTYPE in", values, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeNotIn(List<Integer> values) {
            addCriterion("DICTYPE not in", values, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeBetween(Integer value1, Integer value2) {
            addCriterion("DICTYPE between", value1, value2, "dictype");
            return (Criteria) this;
        }

        public Criteria andDictypeNotBetween(Integer value1, Integer value2) {
            addCriterion("DICTYPE not between", value1, value2, "dictype");
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