package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class CfOudetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfOudetailExample() {
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

        public Criteria andDpkeyIsNull() {
            addCriterion("DPKEY is null");
            return (Criteria) this;
        }

        public Criteria andDpkeyIsNotNull() {
            addCriterion("DPKEY is not null");
            return (Criteria) this;
        }

        public Criteria andDpkeyEqualTo(String value) {
            addCriterion("DPKEY =", value, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpkeyNotEqualTo(String value) {
            addCriterion("DPKEY <>", value, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpkeyGreaterThan(String value) {
            addCriterion("DPKEY >", value, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpkeyGreaterThanOrEqualTo(String value) {
            addCriterion("DPKEY >=", value, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpkeyLessThan(String value) {
            addCriterion("DPKEY <", value, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpkeyLessThanOrEqualTo(String value) {
            addCriterion("DPKEY <=", value, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpkeyLike(String value) {
            addCriterion("DPKEY like", value, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpkeyNotLike(String value) {
            addCriterion("DPKEY not like", value, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpkeyIn(List<String> values) {
            addCriterion("DPKEY in", values, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpkeyNotIn(List<String> values) {
            addCriterion("DPKEY not in", values, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpkeyBetween(String value1, String value2) {
            addCriterion("DPKEY between", value1, value2, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpkeyNotBetween(String value1, String value2) {
            addCriterion("DPKEY not between", value1, value2, "dpkey");
            return (Criteria) this;
        }

        public Criteria andDpidIsNull() {
            addCriterion("DPID is null");
            return (Criteria) this;
        }

        public Criteria andDpidIsNotNull() {
            addCriterion("DPID is not null");
            return (Criteria) this;
        }

        public Criteria andDpidEqualTo(String value) {
            addCriterion("DPID =", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidNotEqualTo(String value) {
            addCriterion("DPID <>", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidGreaterThan(String value) {
            addCriterion("DPID >", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidGreaterThanOrEqualTo(String value) {
            addCriterion("DPID >=", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidLessThan(String value) {
            addCriterion("DPID <", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidLessThanOrEqualTo(String value) {
            addCriterion("DPID <=", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidLike(String value) {
            addCriterion("DPID like", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidNotLike(String value) {
            addCriterion("DPID not like", value, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidIn(List<String> values) {
            addCriterion("DPID in", values, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidNotIn(List<String> values) {
            addCriterion("DPID not in", values, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidBetween(String value1, String value2) {
            addCriterion("DPID between", value1, value2, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpidNotBetween(String value1, String value2) {
            addCriterion("DPID not between", value1, value2, "dpid");
            return (Criteria) this;
        }

        public Criteria andDpnameIsNull() {
            addCriterion("DPNAME is null");
            return (Criteria) this;
        }

        public Criteria andDpnameIsNotNull() {
            addCriterion("DPNAME is not null");
            return (Criteria) this;
        }

        public Criteria andDpnameEqualTo(String value) {
            addCriterion("DPNAME =", value, "dpname");
            return (Criteria) this;
        }

        public Criteria andDpnameNotEqualTo(String value) {
            addCriterion("DPNAME <>", value, "dpname");
            return (Criteria) this;
        }

        public Criteria andDpnameGreaterThan(String value) {
            addCriterion("DPNAME >", value, "dpname");
            return (Criteria) this;
        }

        public Criteria andDpnameGreaterThanOrEqualTo(String value) {
            addCriterion("DPNAME >=", value, "dpname");
            return (Criteria) this;
        }

        public Criteria andDpnameLessThan(String value) {
            addCriterion("DPNAME <", value, "dpname");
            return (Criteria) this;
        }

        public Criteria andDpnameLessThanOrEqualTo(String value) {
            addCriterion("DPNAME <=", value, "dpname");
            return (Criteria) this;
        }

        public Criteria andDpnameLike(String value) {
            addCriterion("DPNAME like", value, "dpname");
            return (Criteria) this;
        }

        public Criteria andDpnameNotLike(String value) {
            addCriterion("DPNAME not like", value, "dpname");
            return (Criteria) this;
        }

        public Criteria andDpnameIn(List<String> values) {
            addCriterion("DPNAME in", values, "dpname");
            return (Criteria) this;
        }

        public Criteria andDpnameNotIn(List<String> values) {
            addCriterion("DPNAME not in", values, "dpname");
            return (Criteria) this;
        }

        public Criteria andDpnameBetween(String value1, String value2) {
            addCriterion("DPNAME between", value1, value2, "dpname");
            return (Criteria) this;
        }

        public Criteria andDpnameNotBetween(String value1, String value2) {
            addCriterion("DPNAME not between", value1, value2, "dpname");
            return (Criteria) this;
        }

        public Criteria andParentdpidIsNull() {
            addCriterion("PARENTDPID is null");
            return (Criteria) this;
        }

        public Criteria andParentdpidIsNotNull() {
            addCriterion("PARENTDPID is not null");
            return (Criteria) this;
        }

        public Criteria andParentdpidEqualTo(String value) {
            addCriterion("PARENTDPID =", value, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andParentdpidNotEqualTo(String value) {
            addCriterion("PARENTDPID <>", value, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andParentdpidGreaterThan(String value) {
            addCriterion("PARENTDPID >", value, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andParentdpidGreaterThanOrEqualTo(String value) {
            addCriterion("PARENTDPID >=", value, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andParentdpidLessThan(String value) {
            addCriterion("PARENTDPID <", value, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andParentdpidLessThanOrEqualTo(String value) {
            addCriterion("PARENTDPID <=", value, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andParentdpidLike(String value) {
            addCriterion("PARENTDPID like", value, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andParentdpidNotLike(String value) {
            addCriterion("PARENTDPID not like", value, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andParentdpidIn(List<String> values) {
            addCriterion("PARENTDPID in", values, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andParentdpidNotIn(List<String> values) {
            addCriterion("PARENTDPID not in", values, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andParentdpidBetween(String value1, String value2) {
            addCriterion("PARENTDPID between", value1, value2, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andParentdpidNotBetween(String value1, String value2) {
            addCriterion("PARENTDPID not between", value1, value2, "parentdpid");
            return (Criteria) this;
        }

        public Criteria andDpfullnameIsNull() {
            addCriterion("DPFULLNAME is null");
            return (Criteria) this;
        }

        public Criteria andDpfullnameIsNotNull() {
            addCriterion("DPFULLNAME is not null");
            return (Criteria) this;
        }

        public Criteria andDpfullnameEqualTo(String value) {
            addCriterion("DPFULLNAME =", value, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpfullnameNotEqualTo(String value) {
            addCriterion("DPFULLNAME <>", value, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpfullnameGreaterThan(String value) {
            addCriterion("DPFULLNAME >", value, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpfullnameGreaterThanOrEqualTo(String value) {
            addCriterion("DPFULLNAME >=", value, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpfullnameLessThan(String value) {
            addCriterion("DPFULLNAME <", value, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpfullnameLessThanOrEqualTo(String value) {
            addCriterion("DPFULLNAME <=", value, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpfullnameLike(String value) {
            addCriterion("DPFULLNAME like", value, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpfullnameNotLike(String value) {
            addCriterion("DPFULLNAME not like", value, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpfullnameIn(List<String> values) {
            addCriterion("DPFULLNAME in", values, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpfullnameNotIn(List<String> values) {
            addCriterion("DPFULLNAME not in", values, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpfullnameBetween(String value1, String value2) {
            addCriterion("DPFULLNAME between", value1, value2, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpfullnameNotBetween(String value1, String value2) {
            addCriterion("DPFULLNAME not between", value1, value2, "dpfullname");
            return (Criteria) this;
        }

        public Criteria andDpcodeIsNull() {
            addCriterion("DPCODE is null");
            return (Criteria) this;
        }

        public Criteria andDpcodeIsNotNull() {
            addCriterion("DPCODE is not null");
            return (Criteria) this;
        }

        public Criteria andDpcodeEqualTo(String value) {
            addCriterion("DPCODE =", value, "dpcode");
            return (Criteria) this;
        }

        public Criteria andDpcodeNotEqualTo(String value) {
            addCriterion("DPCODE <>", value, "dpcode");
            return (Criteria) this;
        }

        public Criteria andDpcodeGreaterThan(String value) {
            addCriterion("DPCODE >", value, "dpcode");
            return (Criteria) this;
        }

        public Criteria andDpcodeGreaterThanOrEqualTo(String value) {
            addCriterion("DPCODE >=", value, "dpcode");
            return (Criteria) this;
        }

        public Criteria andDpcodeLessThan(String value) {
            addCriterion("DPCODE <", value, "dpcode");
            return (Criteria) this;
        }

        public Criteria andDpcodeLessThanOrEqualTo(String value) {
            addCriterion("DPCODE <=", value, "dpcode");
            return (Criteria) this;
        }

        public Criteria andDpcodeLike(String value) {
            addCriterion("DPCODE like", value, "dpcode");
            return (Criteria) this;
        }

        public Criteria andDpcodeNotLike(String value) {
            addCriterion("DPCODE not like", value, "dpcode");
            return (Criteria) this;
        }

        public Criteria andDpcodeIn(List<String> values) {
            addCriterion("DPCODE in", values, "dpcode");
            return (Criteria) this;
        }

        public Criteria andDpcodeNotIn(List<String> values) {
            addCriterion("DPCODE not in", values, "dpcode");
            return (Criteria) this;
        }

        public Criteria andDpcodeBetween(String value1, String value2) {
            addCriterion("DPCODE between", value1, value2, "dpcode");
            return (Criteria) this;
        }

        public Criteria andDpcodeNotBetween(String value1, String value2) {
            addCriterion("DPCODE not between", value1, value2, "dpcode");
            return (Criteria) this;
        }

        public Criteria andIstmpdpIsNull() {
            addCriterion("ISTMPDP is null");
            return (Criteria) this;
        }

        public Criteria andIstmpdpIsNotNull() {
            addCriterion("ISTMPDP is not null");
            return (Criteria) this;
        }

        public Criteria andIstmpdpEqualTo(String value) {
            addCriterion("ISTMPDP =", value, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andIstmpdpNotEqualTo(String value) {
            addCriterion("ISTMPDP <>", value, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andIstmpdpGreaterThan(String value) {
            addCriterion("ISTMPDP >", value, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andIstmpdpGreaterThanOrEqualTo(String value) {
            addCriterion("ISTMPDP >=", value, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andIstmpdpLessThan(String value) {
            addCriterion("ISTMPDP <", value, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andIstmpdpLessThanOrEqualTo(String value) {
            addCriterion("ISTMPDP <=", value, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andIstmpdpLike(String value) {
            addCriterion("ISTMPDP like", value, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andIstmpdpNotLike(String value) {
            addCriterion("ISTMPDP not like", value, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andIstmpdpIn(List<String> values) {
            addCriterion("ISTMPDP in", values, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andIstmpdpNotIn(List<String> values) {
            addCriterion("ISTMPDP not in", values, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andIstmpdpBetween(String value1, String value2) {
            addCriterion("ISTMPDP between", value1, value2, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andIstmpdpNotBetween(String value1, String value2) {
            addCriterion("ISTMPDP not between", value1, value2, "istmpdp");
            return (Criteria) this;
        }

        public Criteria andDeptordernoIsNull() {
            addCriterion("DEPTORDERNO is null");
            return (Criteria) this;
        }

        public Criteria andDeptordernoIsNotNull() {
            addCriterion("DEPTORDERNO is not null");
            return (Criteria) this;
        }

        public Criteria andDeptordernoEqualTo(String value) {
            addCriterion("DEPTORDERNO =", value, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andDeptordernoNotEqualTo(String value) {
            addCriterion("DEPTORDERNO <>", value, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andDeptordernoGreaterThan(String value) {
            addCriterion("DEPTORDERNO >", value, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andDeptordernoGreaterThanOrEqualTo(String value) {
            addCriterion("DEPTORDERNO >=", value, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andDeptordernoLessThan(String value) {
            addCriterion("DEPTORDERNO <", value, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andDeptordernoLessThanOrEqualTo(String value) {
            addCriterion("DEPTORDERNO <=", value, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andDeptordernoLike(String value) {
            addCriterion("DEPTORDERNO like", value, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andDeptordernoNotLike(String value) {
            addCriterion("DEPTORDERNO not like", value, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andDeptordernoIn(List<String> values) {
            addCriterion("DEPTORDERNO in", values, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andDeptordernoNotIn(List<String> values) {
            addCriterion("DEPTORDERNO not in", values, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andDeptordernoBetween(String value1, String value2) {
            addCriterion("DEPTORDERNO between", value1, value2, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andDeptordernoNotBetween(String value1, String value2) {
            addCriterion("DEPTORDERNO not between", value1, value2, "deptorderno");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNull() {
            addCriterion("ISDEL is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("ISDEL is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(Integer value) {
            addCriterion("ISDEL =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(Integer value) {
            addCriterion("ISDEL <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(Integer value) {
            addCriterion("ISDEL >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISDEL >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(Integer value) {
            addCriterion("ISDEL <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(Integer value) {
            addCriterion("ISDEL <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<Integer> values) {
            addCriterion("ISDEL in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<Integer> values) {
            addCriterion("ISDEL not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(Integer value1, Integer value2) {
            addCriterion("ISDEL between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(Integer value1, Integer value2) {
            addCriterion("ISDEL not between", value1, value2, "isdel");
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