package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class DjWorkresourcelibrarytypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DjWorkresourcelibrarytypeExample() {
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

        public Criteria andFiletypeidIsNull() {
            addCriterion("FILETYPEID is null");
            return (Criteria) this;
        }

        public Criteria andFiletypeidIsNotNull() {
            addCriterion("FILETYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andFiletypeidEqualTo(String value) {
            addCriterion("FILETYPEID =", value, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypeidNotEqualTo(String value) {
            addCriterion("FILETYPEID <>", value, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypeidGreaterThan(String value) {
            addCriterion("FILETYPEID >", value, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypeidGreaterThanOrEqualTo(String value) {
            addCriterion("FILETYPEID >=", value, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypeidLessThan(String value) {
            addCriterion("FILETYPEID <", value, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypeidLessThanOrEqualTo(String value) {
            addCriterion("FILETYPEID <=", value, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypeidLike(String value) {
            addCriterion("FILETYPEID like", value, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypeidNotLike(String value) {
            addCriterion("FILETYPEID not like", value, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypeidIn(List<String> values) {
            addCriterion("FILETYPEID in", values, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypeidNotIn(List<String> values) {
            addCriterion("FILETYPEID not in", values, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypeidBetween(String value1, String value2) {
            addCriterion("FILETYPEID between", value1, value2, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypeidNotBetween(String value1, String value2) {
            addCriterion("FILETYPEID not between", value1, value2, "filetypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidIsNull() {
            addCriterion("PARENTTYPEID is null");
            return (Criteria) this;
        }

        public Criteria andParenttypeidIsNotNull() {
            addCriterion("PARENTTYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andParenttypeidEqualTo(String value) {
            addCriterion("PARENTTYPEID =", value, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidNotEqualTo(String value) {
            addCriterion("PARENTTYPEID <>", value, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidGreaterThan(String value) {
            addCriterion("PARENTTYPEID >", value, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidGreaterThanOrEqualTo(String value) {
            addCriterion("PARENTTYPEID >=", value, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidLessThan(String value) {
            addCriterion("PARENTTYPEID <", value, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidLessThanOrEqualTo(String value) {
            addCriterion("PARENTTYPEID <=", value, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidLike(String value) {
            addCriterion("PARENTTYPEID like", value, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidNotLike(String value) {
            addCriterion("PARENTTYPEID not like", value, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidIn(List<String> values) {
            addCriterion("PARENTTYPEID in", values, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidNotIn(List<String> values) {
            addCriterion("PARENTTYPEID not in", values, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidBetween(String value1, String value2) {
            addCriterion("PARENTTYPEID between", value1, value2, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andParenttypeidNotBetween(String value1, String value2) {
            addCriterion("PARENTTYPEID not between", value1, value2, "parenttypeid");
            return (Criteria) this;
        }

        public Criteria andFiletypenameIsNull() {
            addCriterion("FILETYPENAME is null");
            return (Criteria) this;
        }

        public Criteria andFiletypenameIsNotNull() {
            addCriterion("FILETYPENAME is not null");
            return (Criteria) this;
        }

        public Criteria andFiletypenameEqualTo(String value) {
            addCriterion("FILETYPENAME =", value, "filetypename");
            return (Criteria) this;
        }

        public Criteria andFiletypenameNotEqualTo(String value) {
            addCriterion("FILETYPENAME <>", value, "filetypename");
            return (Criteria) this;
        }

        public Criteria andFiletypenameGreaterThan(String value) {
            addCriterion("FILETYPENAME >", value, "filetypename");
            return (Criteria) this;
        }

        public Criteria andFiletypenameGreaterThanOrEqualTo(String value) {
            addCriterion("FILETYPENAME >=", value, "filetypename");
            return (Criteria) this;
        }

        public Criteria andFiletypenameLessThan(String value) {
            addCriterion("FILETYPENAME <", value, "filetypename");
            return (Criteria) this;
        }

        public Criteria andFiletypenameLessThanOrEqualTo(String value) {
            addCriterion("FILETYPENAME <=", value, "filetypename");
            return (Criteria) this;
        }

        public Criteria andFiletypenameLike(String value) {
            addCriterion("FILETYPENAME like", value, "filetypename");
            return (Criteria) this;
        }

        public Criteria andFiletypenameNotLike(String value) {
            addCriterion("FILETYPENAME not like", value, "filetypename");
            return (Criteria) this;
        }

        public Criteria andFiletypenameIn(List<String> values) {
            addCriterion("FILETYPENAME in", values, "filetypename");
            return (Criteria) this;
        }

        public Criteria andFiletypenameNotIn(List<String> values) {
            addCriterion("FILETYPENAME not in", values, "filetypename");
            return (Criteria) this;
        }

        public Criteria andFiletypenameBetween(String value1, String value2) {
            addCriterion("FILETYPENAME between", value1, value2, "filetypename");
            return (Criteria) this;
        }

        public Criteria andFiletypenameNotBetween(String value1, String value2) {
            addCriterion("FILETYPENAME not between", value1, value2, "filetypename");
            return (Criteria) this;
        }

        public Criteria andTreelevelIsNull() {
            addCriterion("TREELEVEL is null");
            return (Criteria) this;
        }

        public Criteria andTreelevelIsNotNull() {
            addCriterion("TREELEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andTreelevelEqualTo(Integer value) {
            addCriterion("TREELEVEL =", value, "treelevel");
            return (Criteria) this;
        }

        public Criteria andTreelevelNotEqualTo(Integer value) {
            addCriterion("TREELEVEL <>", value, "treelevel");
            return (Criteria) this;
        }

        public Criteria andTreelevelGreaterThan(Integer value) {
            addCriterion("TREELEVEL >", value, "treelevel");
            return (Criteria) this;
        }

        public Criteria andTreelevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("TREELEVEL >=", value, "treelevel");
            return (Criteria) this;
        }

        public Criteria andTreelevelLessThan(Integer value) {
            addCriterion("TREELEVEL <", value, "treelevel");
            return (Criteria) this;
        }

        public Criteria andTreelevelLessThanOrEqualTo(Integer value) {
            addCriterion("TREELEVEL <=", value, "treelevel");
            return (Criteria) this;
        }

        public Criteria andTreelevelIn(List<Integer> values) {
            addCriterion("TREELEVEL in", values, "treelevel");
            return (Criteria) this;
        }

        public Criteria andTreelevelNotIn(List<Integer> values) {
            addCriterion("TREELEVEL not in", values, "treelevel");
            return (Criteria) this;
        }

        public Criteria andTreelevelBetween(Integer value1, Integer value2) {
            addCriterion("TREELEVEL between", value1, value2, "treelevel");
            return (Criteria) this;
        }

        public Criteria andTreelevelNotBetween(Integer value1, Integer value2) {
            addCriterion("TREELEVEL not between", value1, value2, "treelevel");
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