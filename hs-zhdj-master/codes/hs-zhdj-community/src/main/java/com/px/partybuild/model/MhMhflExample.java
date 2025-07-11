package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MhMhflExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MhMhflExample() {
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

        public Criteria andMhflbsIsNull() {
            addCriterion("MHFLBS is null");
            return (Criteria) this;
        }

        public Criteria andMhflbsIsNotNull() {
            addCriterion("MHFLBS is not null");
            return (Criteria) this;
        }

        public Criteria andMhflbsEqualTo(String value) {
            addCriterion("MHFLBS =", value, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andMhflbsNotEqualTo(String value) {
            addCriterion("MHFLBS <>", value, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andMhflbsGreaterThan(String value) {
            addCriterion("MHFLBS >", value, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andMhflbsGreaterThanOrEqualTo(String value) {
            addCriterion("MHFLBS >=", value, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andMhflbsLessThan(String value) {
            addCriterion("MHFLBS <", value, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andMhflbsLessThanOrEqualTo(String value) {
            addCriterion("MHFLBS <=", value, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andMhflbsLike(String value) {
            addCriterion("MHFLBS like", value, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andMhflbsNotLike(String value) {
            addCriterion("MHFLBS not like", value, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andMhflbsIn(List<String> values) {
            addCriterion("MHFLBS in", values, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andMhflbsNotIn(List<String> values) {
            addCriterion("MHFLBS not in", values, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andMhflbsBetween(String value1, String value2) {
            addCriterion("MHFLBS between", value1, value2, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andMhflbsNotBetween(String value1, String value2) {
            addCriterion("MHFLBS not between", value1, value2, "mhflbs");
            return (Criteria) this;
        }

        public Criteria andSjflIsNull() {
            addCriterion("SJFL is null");
            return (Criteria) this;
        }

        public Criteria andSjflIsNotNull() {
            addCriterion("SJFL is not null");
            return (Criteria) this;
        }

        public Criteria andSjflEqualTo(String value) {
            addCriterion("SJFL =", value, "sjfl");
            return (Criteria) this;
        }

        public Criteria andSjflNotEqualTo(String value) {
            addCriterion("SJFL <>", value, "sjfl");
            return (Criteria) this;
        }

        public Criteria andSjflGreaterThan(String value) {
            addCriterion("SJFL >", value, "sjfl");
            return (Criteria) this;
        }

        public Criteria andSjflGreaterThanOrEqualTo(String value) {
            addCriterion("SJFL >=", value, "sjfl");
            return (Criteria) this;
        }

        public Criteria andSjflLessThan(String value) {
            addCriterion("SJFL <", value, "sjfl");
            return (Criteria) this;
        }

        public Criteria andSjflLessThanOrEqualTo(String value) {
            addCriterion("SJFL <=", value, "sjfl");
            return (Criteria) this;
        }

        public Criteria andSjflLike(String value) {
            addCriterion("SJFL like", value, "sjfl");
            return (Criteria) this;
        }

        public Criteria andSjflNotLike(String value) {
            addCriterion("SJFL not like", value, "sjfl");
            return (Criteria) this;
        }

        public Criteria andSjflIn(List<String> values) {
            addCriterion("SJFL in", values, "sjfl");
            return (Criteria) this;
        }

        public Criteria andSjflNotIn(List<String> values) {
            addCriterion("SJFL not in", values, "sjfl");
            return (Criteria) this;
        }

        public Criteria andSjflBetween(String value1, String value2) {
            addCriterion("SJFL between", value1, value2, "sjfl");
            return (Criteria) this;
        }

        public Criteria andSjflNotBetween(String value1, String value2) {
            addCriterion("SJFL not between", value1, value2, "sjfl");
            return (Criteria) this;
        }

        public Criteria andFlmcIsNull() {
            addCriterion("FLMC is null");
            return (Criteria) this;
        }

        public Criteria andFlmcIsNotNull() {
            addCriterion("FLMC is not null");
            return (Criteria) this;
        }

        public Criteria andFlmcEqualTo(String value) {
            addCriterion("FLMC =", value, "flmc");
            return (Criteria) this;
        }

        public Criteria andFlmcNotEqualTo(String value) {
            addCriterion("FLMC <>", value, "flmc");
            return (Criteria) this;
        }

        public Criteria andFlmcGreaterThan(String value) {
            addCriterion("FLMC >", value, "flmc");
            return (Criteria) this;
        }

        public Criteria andFlmcGreaterThanOrEqualTo(String value) {
            addCriterion("FLMC >=", value, "flmc");
            return (Criteria) this;
        }

        public Criteria andFlmcLessThan(String value) {
            addCriterion("FLMC <", value, "flmc");
            return (Criteria) this;
        }

        public Criteria andFlmcLessThanOrEqualTo(String value) {
            addCriterion("FLMC <=", value, "flmc");
            return (Criteria) this;
        }

        public Criteria andFlmcLike(String value) {
            addCriterion("FLMC like", value, "flmc");
            return (Criteria) this;
        }

        public Criteria andFlmcNotLike(String value) {
            addCriterion("FLMC not like", value, "flmc");
            return (Criteria) this;
        }

        public Criteria andFlmcIn(List<String> values) {
            addCriterion("FLMC in", values, "flmc");
            return (Criteria) this;
        }

        public Criteria andFlmcNotIn(List<String> values) {
            addCriterion("FLMC not in", values, "flmc");
            return (Criteria) this;
        }

        public Criteria andFlmcBetween(String value1, String value2) {
            addCriterion("FLMC between", value1, value2, "flmc");
            return (Criteria) this;
        }

        public Criteria andFlmcNotBetween(String value1, String value2) {
            addCriterion("FLMC not between", value1, value2, "flmc");
            return (Criteria) this;
        }

        public Criteria andLmurlIsNull() {
            addCriterion("LMURL is null");
            return (Criteria) this;
        }

        public Criteria andLmurlIsNotNull() {
            addCriterion("LMURL is not null");
            return (Criteria) this;
        }

        public Criteria andLmurlEqualTo(String value) {
            addCriterion("LMURL =", value, "lmurl");
            return (Criteria) this;
        }

        public Criteria andLmurlNotEqualTo(String value) {
            addCriterion("LMURL <>", value, "lmurl");
            return (Criteria) this;
        }

        public Criteria andLmurlGreaterThan(String value) {
            addCriterion("LMURL >", value, "lmurl");
            return (Criteria) this;
        }

        public Criteria andLmurlGreaterThanOrEqualTo(String value) {
            addCriterion("LMURL >=", value, "lmurl");
            return (Criteria) this;
        }

        public Criteria andLmurlLessThan(String value) {
            addCriterion("LMURL <", value, "lmurl");
            return (Criteria) this;
        }

        public Criteria andLmurlLessThanOrEqualTo(String value) {
            addCriterion("LMURL <=", value, "lmurl");
            return (Criteria) this;
        }

        public Criteria andLmurlLike(String value) {
            addCriterion("LMURL like", value, "lmurl");
            return (Criteria) this;
        }

        public Criteria andLmurlNotLike(String value) {
            addCriterion("LMURL not like", value, "lmurl");
            return (Criteria) this;
        }

        public Criteria andLmurlIn(List<String> values) {
            addCriterion("LMURL in", values, "lmurl");
            return (Criteria) this;
        }

        public Criteria andLmurlNotIn(List<String> values) {
            addCriterion("LMURL not in", values, "lmurl");
            return (Criteria) this;
        }

        public Criteria andLmurlBetween(String value1, String value2) {
            addCriterion("LMURL between", value1, value2, "lmurl");
            return (Criteria) this;
        }

        public Criteria andLmurlNotBetween(String value1, String value2) {
            addCriterion("LMURL not between", value1, value2, "lmurl");
            return (Criteria) this;
        }

        public Criteria andSfxsIsNull() {
            addCriterion("SFXS is null");
            return (Criteria) this;
        }

        public Criteria andSfxsIsNotNull() {
            addCriterion("SFXS is not null");
            return (Criteria) this;
        }

        public Criteria andSfxsEqualTo(Integer value) {
            addCriterion("SFXS =", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsNotEqualTo(Integer value) {
            addCriterion("SFXS <>", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsGreaterThan(Integer value) {
            addCriterion("SFXS >", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("SFXS >=", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsLessThan(Integer value) {
            addCriterion("SFXS <", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsLessThanOrEqualTo(Integer value) {
            addCriterion("SFXS <=", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsIn(List<Integer> values) {
            addCriterion("SFXS in", values, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsNotIn(List<Integer> values) {
            addCriterion("SFXS not in", values, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsBetween(Integer value1, Integer value2) {
            addCriterion("SFXS between", value1, value2, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsNotBetween(Integer value1, Integer value2) {
            addCriterion("SFXS not between", value1, value2, "sfxs");
            return (Criteria) this;
        }

        public Criteria andPxIsNull() {
            addCriterion("PX is null");
            return (Criteria) this;
        }

        public Criteria andPxIsNotNull() {
            addCriterion("PX is not null");
            return (Criteria) this;
        }

        public Criteria andPxEqualTo(Integer value) {
            addCriterion("PX =", value, "px");
            return (Criteria) this;
        }

        public Criteria andPxNotEqualTo(Integer value) {
            addCriterion("PX <>", value, "px");
            return (Criteria) this;
        }

        public Criteria andPxGreaterThan(Integer value) {
            addCriterion("PX >", value, "px");
            return (Criteria) this;
        }

        public Criteria andPxGreaterThanOrEqualTo(Integer value) {
            addCriterion("PX >=", value, "px");
            return (Criteria) this;
        }

        public Criteria andPxLessThan(Integer value) {
            addCriterion("PX <", value, "px");
            return (Criteria) this;
        }

        public Criteria andPxLessThanOrEqualTo(Integer value) {
            addCriterion("PX <=", value, "px");
            return (Criteria) this;
        }

        public Criteria andPxIn(List<Integer> values) {
            addCriterion("PX in", values, "px");
            return (Criteria) this;
        }

        public Criteria andPxNotIn(List<Integer> values) {
            addCriterion("PX not in", values, "px");
            return (Criteria) this;
        }

        public Criteria andPxBetween(Integer value1, Integer value2) {
            addCriterion("PX between", value1, value2, "px");
            return (Criteria) this;
        }

        public Criteria andPxNotBetween(Integer value1, Integer value2) {
            addCriterion("PX not between", value1, value2, "px");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("BZ is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("BZ is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("BZ =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("BZ <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("BZ >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("BZ >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("BZ <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("BZ <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("BZ like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("BZ not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("BZ in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("BZ not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("BZ between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("BZ not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andCjsjIsNull() {
            addCriterion("CJSJ is null");
            return (Criteria) this;
        }

        public Criteria andCjsjIsNotNull() {
            addCriterion("CJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andCjsjEqualTo(Date value) {
            addCriterion("CJSJ =", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotEqualTo(Date value) {
            addCriterion("CJSJ <>", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjGreaterThan(Date value) {
            addCriterion("CJSJ >", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjGreaterThanOrEqualTo(Date value) {
            addCriterion("CJSJ >=", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjLessThan(Date value) {
            addCriterion("CJSJ <", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjLessThanOrEqualTo(Date value) {
            addCriterion("CJSJ <=", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjIn(List<Date> values) {
            addCriterion("CJSJ in", values, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotIn(List<Date> values) {
            addCriterion("CJSJ not in", values, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjBetween(Date value1, Date value2) {
            addCriterion("CJSJ between", value1, value2, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotBetween(Date value1, Date value2) {
            addCriterion("CJSJ not between", value1, value2, "cjsj");
            return (Criteria) this;
        }

        public Criteria andJbIsNull() {
            addCriterion("JB is null");
            return (Criteria) this;
        }

        public Criteria andJbIsNotNull() {
            addCriterion("JB is not null");
            return (Criteria) this;
        }

        public Criteria andJbEqualTo(Integer value) {
            addCriterion("JB =", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotEqualTo(Integer value) {
            addCriterion("JB <>", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbGreaterThan(Integer value) {
            addCriterion("JB >", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbGreaterThanOrEqualTo(Integer value) {
            addCriterion("JB >=", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbLessThan(Integer value) {
            addCriterion("JB <", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbLessThanOrEqualTo(Integer value) {
            addCriterion("JB <=", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbIn(List<Integer> values) {
            addCriterion("JB in", values, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotIn(List<Integer> values) {
            addCriterion("JB not in", values, "jb");
            return (Criteria) this;
        }

        public Criteria andJbBetween(Integer value1, Integer value2) {
            addCriterion("JB between", value1, value2, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotBetween(Integer value1, Integer value2) {
            addCriterion("JB not between", value1, value2, "jb");
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