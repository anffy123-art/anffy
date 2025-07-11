package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzMzpyxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzMzpyxxExample() {
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

        public Criteria andMzpyxxbsIsNull() {
            addCriterion("MZPYXXBS is null");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsIsNotNull() {
            addCriterion("MZPYXXBS is not null");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsEqualTo(String value) {
            addCriterion("MZPYXXBS =", value, "mzpyxxbs");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsNotEqualTo(String value) {
            addCriterion("MZPYXXBS <>", value, "mzpyxxbs");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsGreaterThan(String value) {
            addCriterion("MZPYXXBS >", value, "mzpyxxbs");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsGreaterThanOrEqualTo(String value) {
            addCriterion("MZPYXXBS >=", value, "mzpyxxbs");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsLessThan(String value) {
            addCriterion("MZPYXXBS <", value, "mzpyxxbs");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsLessThanOrEqualTo(String value) {
            addCriterion("MZPYXXBS <=", value, "mzpyxxbs");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsLike(String value) {
            addCriterion("MZPYXXBS like", value, "mzpyxxbs");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsNotLike(String value) {
            addCriterion("MZPYXXBS not like", value, "mzpyxxbs");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsIn(List<String> values) {
            addCriterion("MZPYXXBS in", values, "mzpyxxbs");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsNotIn(List<String> values) {
            addCriterion("MZPYXXBS not in", values, "mzpyxxbs");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsBetween(String value1, String value2) {
            addCriterion("MZPYXXBS between", value1, value2, "mzpyxxbs");
            return (Criteria) this;
        }

        public Criteria andMzpyxxbsNotBetween(String value1, String value2) {
            addCriterion("MZPYXXBS not between", value1, value2, "mzpyxxbs");
            return (Criteria) this;
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

        public Criteria andSzdzbdmIsNull() {
            addCriterion("SZDZBDM is null");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmIsNotNull() {
            addCriterion("SZDZBDM is not null");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmEqualTo(String value) {
            addCriterion("SZDZBDM =", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmNotEqualTo(String value) {
            addCriterion("SZDZBDM <>", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmGreaterThan(String value) {
            addCriterion("SZDZBDM >", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmGreaterThanOrEqualTo(String value) {
            addCriterion("SZDZBDM >=", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmLessThan(String value) {
            addCriterion("SZDZBDM <", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmLessThanOrEqualTo(String value) {
            addCriterion("SZDZBDM <=", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmLike(String value) {
            addCriterion("SZDZBDM like", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmNotLike(String value) {
            addCriterion("SZDZBDM not like", value, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmIn(List<String> values) {
            addCriterion("SZDZBDM in", values, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmNotIn(List<String> values) {
            addCriterion("SZDZBDM not in", values, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmBetween(String value1, String value2) {
            addCriterion("SZDZBDM between", value1, value2, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andSzdzbdmNotBetween(String value1, String value2) {
            addCriterion("SZDZBDM not between", value1, value2, "szdzbdm");
            return (Criteria) this;
        }

        public Criteria andKzpyrqIsNull() {
            addCriterion("KZPYRQ is null");
            return (Criteria) this;
        }

        public Criteria andKzpyrqIsNotNull() {
            addCriterion("KZPYRQ is not null");
            return (Criteria) this;
        }

        public Criteria andKzpyrqEqualTo(String value) {
            addCriterion("KZPYRQ =", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqNotEqualTo(String value) {
            addCriterion("KZPYRQ <>", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqGreaterThan(String value) {
            addCriterion("KZPYRQ >", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqGreaterThanOrEqualTo(String value) {
            addCriterion("KZPYRQ >=", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqLessThan(String value) {
            addCriterion("KZPYRQ <", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqLessThanOrEqualTo(String value) {
            addCriterion("KZPYRQ <=", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqLike(String value) {
            addCriterion("KZPYRQ like", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqNotLike(String value) {
            addCriterion("KZPYRQ not like", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqIn(List<String> values) {
            addCriterion("KZPYRQ in", values, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqNotIn(List<String> values) {
            addCriterion("KZPYRQ not in", values, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqBetween(String value1, String value2) {
            addCriterion("KZPYRQ between", value1, value2, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqNotBetween(String value1, String value2) {
            addCriterion("KZPYRQ not between", value1, value2, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqIsNull() {
            addCriterion("JSPYRQ is null");
            return (Criteria) this;
        }

        public Criteria andJspyrqIsNotNull() {
            addCriterion("JSPYRQ is not null");
            return (Criteria) this;
        }

        public Criteria andJspyrqEqualTo(String value) {
            addCriterion("JSPYRQ =", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqNotEqualTo(String value) {
            addCriterion("JSPYRQ <>", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqGreaterThan(String value) {
            addCriterion("JSPYRQ >", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqGreaterThanOrEqualTo(String value) {
            addCriterion("JSPYRQ >=", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqLessThan(String value) {
            addCriterion("JSPYRQ <", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqLessThanOrEqualTo(String value) {
            addCriterion("JSPYRQ <=", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqLike(String value) {
            addCriterion("JSPYRQ like", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqNotLike(String value) {
            addCriterion("JSPYRQ not like", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqIn(List<String> values) {
            addCriterion("JSPYRQ in", values, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqNotIn(List<String> values) {
            addCriterion("JSPYRQ not in", values, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqBetween(String value1, String value2) {
            addCriterion("JSPYRQ between", value1, value2, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqNotBetween(String value1, String value2) {
            addCriterion("JSPYRQ not between", value1, value2, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andPyjgIsNull() {
            addCriterion("PYJG is null");
            return (Criteria) this;
        }

        public Criteria andPyjgIsNotNull() {
            addCriterion("PYJG is not null");
            return (Criteria) this;
        }

        public Criteria andPyjgEqualTo(String value) {
            addCriterion("PYJG =", value, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjgNotEqualTo(String value) {
            addCriterion("PYJG <>", value, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjgGreaterThan(String value) {
            addCriterion("PYJG >", value, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjgGreaterThanOrEqualTo(String value) {
            addCriterion("PYJG >=", value, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjgLessThan(String value) {
            addCriterion("PYJG <", value, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjgLessThanOrEqualTo(String value) {
            addCriterion("PYJG <=", value, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjgLike(String value) {
            addCriterion("PYJG like", value, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjgNotLike(String value) {
            addCriterion("PYJG not like", value, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjgIn(List<String> values) {
            addCriterion("PYJG in", values, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjgNotIn(List<String> values) {
            addCriterion("PYJG not in", values, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjgBetween(String value1, String value2) {
            addCriterion("PYJG between", value1, value2, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjgNotBetween(String value1, String value2) {
            addCriterion("PYJG not between", value1, value2, "pyjg");
            return (Criteria) this;
        }

        public Criteria andPyjcqkIsNull() {
            addCriterion("PYJCQK is null");
            return (Criteria) this;
        }

        public Criteria andPyjcqkIsNotNull() {
            addCriterion("PYJCQK is not null");
            return (Criteria) this;
        }

        public Criteria andPyjcqkEqualTo(String value) {
            addCriterion("PYJCQK =", value, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcqkNotEqualTo(String value) {
            addCriterion("PYJCQK <>", value, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcqkGreaterThan(String value) {
            addCriterion("PYJCQK >", value, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcqkGreaterThanOrEqualTo(String value) {
            addCriterion("PYJCQK >=", value, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcqkLessThan(String value) {
            addCriterion("PYJCQK <", value, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcqkLessThanOrEqualTo(String value) {
            addCriterion("PYJCQK <=", value, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcqkLike(String value) {
            addCriterion("PYJCQK like", value, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcqkNotLike(String value) {
            addCriterion("PYJCQK not like", value, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcqkIn(List<String> values) {
            addCriterion("PYJCQK in", values, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcqkNotIn(List<String> values) {
            addCriterion("PYJCQK not in", values, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcqkBetween(String value1, String value2) {
            addCriterion("PYJCQK between", value1, value2, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcqkNotBetween(String value1, String value2) {
            addCriterion("PYJCQK not between", value1, value2, "pyjcqk");
            return (Criteria) this;
        }

        public Criteria andPyjcyyIsNull() {
            addCriterion("PYJCYY is null");
            return (Criteria) this;
        }

        public Criteria andPyjcyyIsNotNull() {
            addCriterion("PYJCYY is not null");
            return (Criteria) this;
        }

        public Criteria andPyjcyyEqualTo(String value) {
            addCriterion("PYJCYY =", value, "pyjcyy");
            return (Criteria) this;
        }

        public Criteria andPyjcyyNotEqualTo(String value) {
            addCriterion("PYJCYY <>", value, "pyjcyy");
            return (Criteria) this;
        }

        public Criteria andPyjcyyGreaterThan(String value) {
            addCriterion("PYJCYY >", value, "pyjcyy");
            return (Criteria) this;
        }

        public Criteria andPyjcyyGreaterThanOrEqualTo(String value) {
            addCriterion("PYJCYY >=", value, "pyjcyy");
            return (Criteria) this;
        }

        public Criteria andPyjcyyLessThan(String value) {
            addCriterion("PYJCYY <", value, "pyjcyy");
            return (Criteria) this;
        }

        public Criteria andPyjcyyLessThanOrEqualTo(String value) {
            addCriterion("PYJCYY <=", value, "pyjcyy");
            return (Criteria) this;
        }

        public Criteria andPyjcyyLike(String value) {
            addCriterion("PYJCYY like", value, "pyjcyy");
            return (Criteria) this;
        }

        public Criteria andPyjcyyNotLike(String value) {
            addCriterion("PYJCYY not like", value, "pyjcyy");
            return (Criteria) this;
        }

        public Criteria andPyjcyyIn(List<String> values) {
            addCriterion("PYJCYY in", values, "pyjcyy");
            return (Criteria) this;
        }

        public Criteria andPyjcyyNotIn(List<String> values) {
            addCriterion("PYJCYY not in", values, "pyjcyy");
            return (Criteria) this;
        }

        public Criteria andPyjcyyBetween(String value1, String value2) {
            addCriterion("PYJCYY between", value1, value2, "pyjcyy");
            return (Criteria) this;
        }

        public Criteria andPyjcyyNotBetween(String value1, String value2) {
            addCriterion("PYJCYY not between", value1, value2, "pyjcyy");
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