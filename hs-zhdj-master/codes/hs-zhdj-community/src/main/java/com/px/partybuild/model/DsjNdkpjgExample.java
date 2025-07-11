package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class DsjNdkpjgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsjNdkpjgExample() {
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

        public Criteria andNdkpjgbsIsNull() {
            addCriterion("NDKPJGBS is null");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsIsNotNull() {
            addCriterion("NDKPJGBS is not null");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsEqualTo(String value) {
            addCriterion("NDKPJGBS =", value, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsNotEqualTo(String value) {
            addCriterion("NDKPJGBS <>", value, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsGreaterThan(String value) {
            addCriterion("NDKPJGBS >", value, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsGreaterThanOrEqualTo(String value) {
            addCriterion("NDKPJGBS >=", value, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsLessThan(String value) {
            addCriterion("NDKPJGBS <", value, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsLessThanOrEqualTo(String value) {
            addCriterion("NDKPJGBS <=", value, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsLike(String value) {
            addCriterion("NDKPJGBS like", value, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsNotLike(String value) {
            addCriterion("NDKPJGBS not like", value, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsIn(List<String> values) {
            addCriterion("NDKPJGBS in", values, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsNotIn(List<String> values) {
            addCriterion("NDKPJGBS not in", values, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsBetween(String value1, String value2) {
            addCriterion("NDKPJGBS between", value1, value2, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdkpjgbsNotBetween(String value1, String value2) {
            addCriterion("NDKPJGBS not between", value1, value2, "ndkpjgbs");
            return (Criteria) this;
        }

        public Criteria andNdIsNull() {
            addCriterion("ND is null");
            return (Criteria) this;
        }

        public Criteria andNdIsNotNull() {
            addCriterion("ND is not null");
            return (Criteria) this;
        }

        public Criteria andNdEqualTo(Integer value) {
            addCriterion("ND =", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotEqualTo(Integer value) {
            addCriterion("ND <>", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThan(Integer value) {
            addCriterion("ND >", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ND >=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThan(Integer value) {
            addCriterion("ND <", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThanOrEqualTo(Integer value) {
            addCriterion("ND <=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdIn(List<Integer> values) {
            addCriterion("ND in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotIn(List<Integer> values) {
            addCriterion("ND not in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdBetween(Integer value1, Integer value2) {
            addCriterion("ND between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotBetween(Integer value1, Integer value2) {
            addCriterion("ND not between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andYxIsNull() {
            addCriterion("YX is null");
            return (Criteria) this;
        }

        public Criteria andYxIsNotNull() {
            addCriterion("YX is not null");
            return (Criteria) this;
        }

        public Criteria andYxEqualTo(Integer value) {
            addCriterion("YX =", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotEqualTo(Integer value) {
            addCriterion("YX <>", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxGreaterThan(Integer value) {
            addCriterion("YX >", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxGreaterThanOrEqualTo(Integer value) {
            addCriterion("YX >=", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLessThan(Integer value) {
            addCriterion("YX <", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLessThanOrEqualTo(Integer value) {
            addCriterion("YX <=", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxIn(List<Integer> values) {
            addCriterion("YX in", values, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotIn(List<Integer> values) {
            addCriterion("YX not in", values, "yx");
            return (Criteria) this;
        }

        public Criteria andYxBetween(Integer value1, Integer value2) {
            addCriterion("YX between", value1, value2, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotBetween(Integer value1, Integer value2) {
            addCriterion("YX not between", value1, value2, "yx");
            return (Criteria) this;
        }

        public Criteria andLhIsNull() {
            addCriterion("LH is null");
            return (Criteria) this;
        }

        public Criteria andLhIsNotNull() {
            addCriterion("LH is not null");
            return (Criteria) this;
        }

        public Criteria andLhEqualTo(Integer value) {
            addCriterion("LH =", value, "lh");
            return (Criteria) this;
        }

        public Criteria andLhNotEqualTo(Integer value) {
            addCriterion("LH <>", value, "lh");
            return (Criteria) this;
        }

        public Criteria andLhGreaterThan(Integer value) {
            addCriterion("LH >", value, "lh");
            return (Criteria) this;
        }

        public Criteria andLhGreaterThanOrEqualTo(Integer value) {
            addCriterion("LH >=", value, "lh");
            return (Criteria) this;
        }

        public Criteria andLhLessThan(Integer value) {
            addCriterion("LH <", value, "lh");
            return (Criteria) this;
        }

        public Criteria andLhLessThanOrEqualTo(Integer value) {
            addCriterion("LH <=", value, "lh");
            return (Criteria) this;
        }

        public Criteria andLhIn(List<Integer> values) {
            addCriterion("LH in", values, "lh");
            return (Criteria) this;
        }

        public Criteria andLhNotIn(List<Integer> values) {
            addCriterion("LH not in", values, "lh");
            return (Criteria) this;
        }

        public Criteria andLhBetween(Integer value1, Integer value2) {
            addCriterion("LH between", value1, value2, "lh");
            return (Criteria) this;
        }

        public Criteria andLhNotBetween(Integer value1, Integer value2) {
            addCriterion("LH not between", value1, value2, "lh");
            return (Criteria) this;
        }

        public Criteria andHgIsNull() {
            addCriterion("HG is null");
            return (Criteria) this;
        }

        public Criteria andHgIsNotNull() {
            addCriterion("HG is not null");
            return (Criteria) this;
        }

        public Criteria andHgEqualTo(Integer value) {
            addCriterion("HG =", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgNotEqualTo(Integer value) {
            addCriterion("HG <>", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgGreaterThan(Integer value) {
            addCriterion("HG >", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgGreaterThanOrEqualTo(Integer value) {
            addCriterion("HG >=", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgLessThan(Integer value) {
            addCriterion("HG <", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgLessThanOrEqualTo(Integer value) {
            addCriterion("HG <=", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgIn(List<Integer> values) {
            addCriterion("HG in", values, "hg");
            return (Criteria) this;
        }

        public Criteria andHgNotIn(List<Integer> values) {
            addCriterion("HG not in", values, "hg");
            return (Criteria) this;
        }

        public Criteria andHgBetween(Integer value1, Integer value2) {
            addCriterion("HG between", value1, value2, "hg");
            return (Criteria) this;
        }

        public Criteria andHgNotBetween(Integer value1, Integer value2) {
            addCriterion("HG not between", value1, value2, "hg");
            return (Criteria) this;
        }

        public Criteria andBhgIsNull() {
            addCriterion("BHG is null");
            return (Criteria) this;
        }

        public Criteria andBhgIsNotNull() {
            addCriterion("BHG is not null");
            return (Criteria) this;
        }

        public Criteria andBhgEqualTo(Integer value) {
            addCriterion("BHG =", value, "bhg");
            return (Criteria) this;
        }

        public Criteria andBhgNotEqualTo(Integer value) {
            addCriterion("BHG <>", value, "bhg");
            return (Criteria) this;
        }

        public Criteria andBhgGreaterThan(Integer value) {
            addCriterion("BHG >", value, "bhg");
            return (Criteria) this;
        }

        public Criteria andBhgGreaterThanOrEqualTo(Integer value) {
            addCriterion("BHG >=", value, "bhg");
            return (Criteria) this;
        }

        public Criteria andBhgLessThan(Integer value) {
            addCriterion("BHG <", value, "bhg");
            return (Criteria) this;
        }

        public Criteria andBhgLessThanOrEqualTo(Integer value) {
            addCriterion("BHG <=", value, "bhg");
            return (Criteria) this;
        }

        public Criteria andBhgIn(List<Integer> values) {
            addCriterion("BHG in", values, "bhg");
            return (Criteria) this;
        }

        public Criteria andBhgNotIn(List<Integer> values) {
            addCriterion("BHG not in", values, "bhg");
            return (Criteria) this;
        }

        public Criteria andBhgBetween(Integer value1, Integer value2) {
            addCriterion("BHG between", value1, value2, "bhg");
            return (Criteria) this;
        }

        public Criteria andBhgNotBetween(Integer value1, Integer value2) {
            addCriterion("BHG not between", value1, value2, "bhg");
            return (Criteria) this;
        }

        public Criteria andWclIsNull() {
            addCriterion("WCL is null");
            return (Criteria) this;
        }

        public Criteria andWclIsNotNull() {
            addCriterion("WCL is not null");
            return (Criteria) this;
        }

        public Criteria andWclEqualTo(Integer value) {
            addCriterion("WCL =", value, "wcl");
            return (Criteria) this;
        }

        public Criteria andWclNotEqualTo(Integer value) {
            addCriterion("WCL <>", value, "wcl");
            return (Criteria) this;
        }

        public Criteria andWclGreaterThan(Integer value) {
            addCriterion("WCL >", value, "wcl");
            return (Criteria) this;
        }

        public Criteria andWclGreaterThanOrEqualTo(Integer value) {
            addCriterion("WCL >=", value, "wcl");
            return (Criteria) this;
        }

        public Criteria andWclLessThan(Integer value) {
            addCriterion("WCL <", value, "wcl");
            return (Criteria) this;
        }

        public Criteria andWclLessThanOrEqualTo(Integer value) {
            addCriterion("WCL <=", value, "wcl");
            return (Criteria) this;
        }

        public Criteria andWclIn(List<Integer> values) {
            addCriterion("WCL in", values, "wcl");
            return (Criteria) this;
        }

        public Criteria andWclNotIn(List<Integer> values) {
            addCriterion("WCL not in", values, "wcl");
            return (Criteria) this;
        }

        public Criteria andWclBetween(Integer value1, Integer value2) {
            addCriterion("WCL between", value1, value2, "wcl");
            return (Criteria) this;
        }

        public Criteria andWclNotBetween(Integer value1, Integer value2) {
            addCriterion("WCL not between", value1, value2, "wcl");
            return (Criteria) this;
        }

        public Criteria andJzpIsNull() {
            addCriterion("JZP is null");
            return (Criteria) this;
        }

        public Criteria andJzpIsNotNull() {
            addCriterion("JZP is not null");
            return (Criteria) this;
        }

        public Criteria andJzpEqualTo(Integer value) {
            addCriterion("JZP =", value, "jzp");
            return (Criteria) this;
        }

        public Criteria andJzpNotEqualTo(Integer value) {
            addCriterion("JZP <>", value, "jzp");
            return (Criteria) this;
        }

        public Criteria andJzpGreaterThan(Integer value) {
            addCriterion("JZP >", value, "jzp");
            return (Criteria) this;
        }

        public Criteria andJzpGreaterThanOrEqualTo(Integer value) {
            addCriterion("JZP >=", value, "jzp");
            return (Criteria) this;
        }

        public Criteria andJzpLessThan(Integer value) {
            addCriterion("JZP <", value, "jzp");
            return (Criteria) this;
        }

        public Criteria andJzpLessThanOrEqualTo(Integer value) {
            addCriterion("JZP <=", value, "jzp");
            return (Criteria) this;
        }

        public Criteria andJzpIn(List<Integer> values) {
            addCriterion("JZP in", values, "jzp");
            return (Criteria) this;
        }

        public Criteria andJzpNotIn(List<Integer> values) {
            addCriterion("JZP not in", values, "jzp");
            return (Criteria) this;
        }

        public Criteria andJzpBetween(Integer value1, Integer value2) {
            addCriterion("JZP between", value1, value2, "jzp");
            return (Criteria) this;
        }

        public Criteria andJzpNotBetween(Integer value1, Integer value2) {
            addCriterion("JZP not between", value1, value2, "jzp");
            return (Criteria) this;
        }

        public Criteria andDwcxIsNull() {
            addCriterion("DWCX is null");
            return (Criteria) this;
        }

        public Criteria andDwcxIsNotNull() {
            addCriterion("DWCX is not null");
            return (Criteria) this;
        }

        public Criteria andDwcxEqualTo(Integer value) {
            addCriterion("DWCX =", value, "dwcx");
            return (Criteria) this;
        }

        public Criteria andDwcxNotEqualTo(Integer value) {
            addCriterion("DWCX <>", value, "dwcx");
            return (Criteria) this;
        }

        public Criteria andDwcxGreaterThan(Integer value) {
            addCriterion("DWCX >", value, "dwcx");
            return (Criteria) this;
        }

        public Criteria andDwcxGreaterThanOrEqualTo(Integer value) {
            addCriterion("DWCX >=", value, "dwcx");
            return (Criteria) this;
        }

        public Criteria andDwcxLessThan(Integer value) {
            addCriterion("DWCX <", value, "dwcx");
            return (Criteria) this;
        }

        public Criteria andDwcxLessThanOrEqualTo(Integer value) {
            addCriterion("DWCX <=", value, "dwcx");
            return (Criteria) this;
        }

        public Criteria andDwcxIn(List<Integer> values) {
            addCriterion("DWCX in", values, "dwcx");
            return (Criteria) this;
        }

        public Criteria andDwcxNotIn(List<Integer> values) {
            addCriterion("DWCX not in", values, "dwcx");
            return (Criteria) this;
        }

        public Criteria andDwcxBetween(Integer value1, Integer value2) {
            addCriterion("DWCX between", value1, value2, "dwcx");
            return (Criteria) this;
        }

        public Criteria andDwcxNotBetween(Integer value1, Integer value2) {
            addCriterion("DWCX not between", value1, value2, "dwcx");
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