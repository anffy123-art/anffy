package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DjFundsuseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DjFundsuseExample() {
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

        public Criteria andFundsuseidIsNull() {
            addCriterion("FUNDSUSEID is null");
            return (Criteria) this;
        }

        public Criteria andFundsuseidIsNotNull() {
            addCriterion("FUNDSUSEID is not null");
            return (Criteria) this;
        }

        public Criteria andFundsuseidEqualTo(String value) {
            addCriterion("FUNDSUSEID =", value, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andFundsuseidNotEqualTo(String value) {
            addCriterion("FUNDSUSEID <>", value, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andFundsuseidGreaterThan(String value) {
            addCriterion("FUNDSUSEID >", value, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andFundsuseidGreaterThanOrEqualTo(String value) {
            addCriterion("FUNDSUSEID >=", value, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andFundsuseidLessThan(String value) {
            addCriterion("FUNDSUSEID <", value, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andFundsuseidLessThanOrEqualTo(String value) {
            addCriterion("FUNDSUSEID <=", value, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andFundsuseidLike(String value) {
            addCriterion("FUNDSUSEID like", value, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andFundsuseidNotLike(String value) {
            addCriterion("FUNDSUSEID not like", value, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andFundsuseidIn(List<String> values) {
            addCriterion("FUNDSUSEID in", values, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andFundsuseidNotIn(List<String> values) {
            addCriterion("FUNDSUSEID not in", values, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andFundsuseidBetween(String value1, String value2) {
            addCriterion("FUNDSUSEID between", value1, value2, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andFundsuseidNotBetween(String value1, String value2) {
            addCriterion("FUNDSUSEID not between", value1, value2, "fundsuseid");
            return (Criteria) this;
        }

        public Criteria andPartycodeIsNull() {
            addCriterion("PARTYCODE is null");
            return (Criteria) this;
        }

        public Criteria andPartycodeIsNotNull() {
            addCriterion("PARTYCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPartycodeEqualTo(String value) {
            addCriterion("PARTYCODE =", value, "partycode");
            return (Criteria) this;
        }

        public Criteria andPartycodeNotEqualTo(String value) {
            addCriterion("PARTYCODE <>", value, "partycode");
            return (Criteria) this;
        }

        public Criteria andPartycodeGreaterThan(String value) {
            addCriterion("PARTYCODE >", value, "partycode");
            return (Criteria) this;
        }

        public Criteria andPartycodeGreaterThanOrEqualTo(String value) {
            addCriterion("PARTYCODE >=", value, "partycode");
            return (Criteria) this;
        }

        public Criteria andPartycodeLessThan(String value) {
            addCriterion("PARTYCODE <", value, "partycode");
            return (Criteria) this;
        }

        public Criteria andPartycodeLessThanOrEqualTo(String value) {
            addCriterion("PARTYCODE <=", value, "partycode");
            return (Criteria) this;
        }

        public Criteria andPartycodeLike(String value) {
            addCriterion("PARTYCODE like", value, "partycode");
            return (Criteria) this;
        }

        public Criteria andPartycodeNotLike(String value) {
            addCriterion("PARTYCODE not like", value, "partycode");
            return (Criteria) this;
        }

        public Criteria andPartycodeIn(List<String> values) {
            addCriterion("PARTYCODE in", values, "partycode");
            return (Criteria) this;
        }

        public Criteria andPartycodeNotIn(List<String> values) {
            addCriterion("PARTYCODE not in", values, "partycode");
            return (Criteria) this;
        }

        public Criteria andPartycodeBetween(String value1, String value2) {
            addCriterion("PARTYCODE between", value1, value2, "partycode");
            return (Criteria) this;
        }

        public Criteria andPartycodeNotBetween(String value1, String value2) {
            addCriterion("PARTYCODE not between", value1, value2, "partycode");
            return (Criteria) this;
        }

        public Criteria andHandleuseridIsNull() {
            addCriterion("HANDLEUSERID is null");
            return (Criteria) this;
        }

        public Criteria andHandleuseridIsNotNull() {
            addCriterion("HANDLEUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andHandleuseridEqualTo(String value) {
            addCriterion("HANDLEUSERID =", value, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleuseridNotEqualTo(String value) {
            addCriterion("HANDLEUSERID <>", value, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleuseridGreaterThan(String value) {
            addCriterion("HANDLEUSERID >", value, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleuseridGreaterThanOrEqualTo(String value) {
            addCriterion("HANDLEUSERID >=", value, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleuseridLessThan(String value) {
            addCriterion("HANDLEUSERID <", value, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleuseridLessThanOrEqualTo(String value) {
            addCriterion("HANDLEUSERID <=", value, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleuseridLike(String value) {
            addCriterion("HANDLEUSERID like", value, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleuseridNotLike(String value) {
            addCriterion("HANDLEUSERID not like", value, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleuseridIn(List<String> values) {
            addCriterion("HANDLEUSERID in", values, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleuseridNotIn(List<String> values) {
            addCriterion("HANDLEUSERID not in", values, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleuseridBetween(String value1, String value2) {
            addCriterion("HANDLEUSERID between", value1, value2, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleuseridNotBetween(String value1, String value2) {
            addCriterion("HANDLEUSERID not between", value1, value2, "handleuserid");
            return (Criteria) this;
        }

        public Criteria andHandleusernameIsNull() {
            addCriterion("HANDLEUSERNAME is null");
            return (Criteria) this;
        }

        public Criteria andHandleusernameIsNotNull() {
            addCriterion("HANDLEUSERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andHandleusernameEqualTo(String value) {
            addCriterion("HANDLEUSERNAME =", value, "handleusername");
            return (Criteria) this;
        }

        public Criteria andHandleusernameNotEqualTo(String value) {
            addCriterion("HANDLEUSERNAME <>", value, "handleusername");
            return (Criteria) this;
        }

        public Criteria andHandleusernameGreaterThan(String value) {
            addCriterion("HANDLEUSERNAME >", value, "handleusername");
            return (Criteria) this;
        }

        public Criteria andHandleusernameGreaterThanOrEqualTo(String value) {
            addCriterion("HANDLEUSERNAME >=", value, "handleusername");
            return (Criteria) this;
        }

        public Criteria andHandleusernameLessThan(String value) {
            addCriterion("HANDLEUSERNAME <", value, "handleusername");
            return (Criteria) this;
        }

        public Criteria andHandleusernameLessThanOrEqualTo(String value) {
            addCriterion("HANDLEUSERNAME <=", value, "handleusername");
            return (Criteria) this;
        }

        public Criteria andHandleusernameLike(String value) {
            addCriterion("HANDLEUSERNAME like", value, "handleusername");
            return (Criteria) this;
        }

        public Criteria andHandleusernameNotLike(String value) {
            addCriterion("HANDLEUSERNAME not like", value, "handleusername");
            return (Criteria) this;
        }

        public Criteria andHandleusernameIn(List<String> values) {
            addCriterion("HANDLEUSERNAME in", values, "handleusername");
            return (Criteria) this;
        }

        public Criteria andHandleusernameNotIn(List<String> values) {
            addCriterion("HANDLEUSERNAME not in", values, "handleusername");
            return (Criteria) this;
        }

        public Criteria andHandleusernameBetween(String value1, String value2) {
            addCriterion("HANDLEUSERNAME between", value1, value2, "handleusername");
            return (Criteria) this;
        }

        public Criteria andHandleusernameNotBetween(String value1, String value2) {
            addCriterion("HANDLEUSERNAME not between", value1, value2, "handleusername");
            return (Criteria) this;
        }

        public Criteria andExpendtimeIsNull() {
            addCriterion("EXPENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andExpendtimeIsNotNull() {
            addCriterion("EXPENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andExpendtimeEqualTo(Date value) {
            addCriterion("EXPENDTIME =", value, "expendtime");
            return (Criteria) this;
        }

        public Criteria andExpendtimeNotEqualTo(Date value) {
            addCriterion("EXPENDTIME <>", value, "expendtime");
            return (Criteria) this;
        }

        public Criteria andExpendtimeGreaterThan(Date value) {
            addCriterion("EXPENDTIME >", value, "expendtime");
            return (Criteria) this;
        }

        public Criteria andExpendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EXPENDTIME >=", value, "expendtime");
            return (Criteria) this;
        }

        public Criteria andExpendtimeLessThan(Date value) {
            addCriterion("EXPENDTIME <", value, "expendtime");
            return (Criteria) this;
        }

        public Criteria andExpendtimeLessThanOrEqualTo(Date value) {
            addCriterion("EXPENDTIME <=", value, "expendtime");
            return (Criteria) this;
        }

        public Criteria andExpendtimeIn(List<Date> values) {
            addCriterion("EXPENDTIME in", values, "expendtime");
            return (Criteria) this;
        }

        public Criteria andExpendtimeNotIn(List<Date> values) {
            addCriterion("EXPENDTIME not in", values, "expendtime");
            return (Criteria) this;
        }

        public Criteria andExpendtimeBetween(Date value1, Date value2) {
            addCriterion("EXPENDTIME between", value1, value2, "expendtime");
            return (Criteria) this;
        }

        public Criteria andExpendtimeNotBetween(Date value1, Date value2) {
            addCriterion("EXPENDTIME not between", value1, value2, "expendtime");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyIsNull() {
            addCriterion("EXPENDMONEY is null");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyIsNotNull() {
            addCriterion("EXPENDMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyEqualTo(Integer value) {
            addCriterion("EXPENDMONEY =", value, "expendmoney");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyNotEqualTo(Integer value) {
            addCriterion("EXPENDMONEY <>", value, "expendmoney");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyGreaterThan(Integer value) {
            addCriterion("EXPENDMONEY >", value, "expendmoney");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXPENDMONEY >=", value, "expendmoney");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyLessThan(Integer value) {
            addCriterion("EXPENDMONEY <", value, "expendmoney");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyLessThanOrEqualTo(Integer value) {
            addCriterion("EXPENDMONEY <=", value, "expendmoney");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyIn(List<Integer> values) {
            addCriterion("EXPENDMONEY in", values, "expendmoney");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyNotIn(List<Integer> values) {
            addCriterion("EXPENDMONEY not in", values, "expendmoney");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyBetween(Integer value1, Integer value2) {
            addCriterion("EXPENDMONEY between", value1, value2, "expendmoney");
            return (Criteria) this;
        }

        public Criteria andExpendmoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("EXPENDMONEY not between", value1, value2, "expendmoney");
            return (Criteria) this;
        }

        public Criteria andExpendscopeIsNull() {
            addCriterion("EXPENDSCOPE is null");
            return (Criteria) this;
        }

        public Criteria andExpendscopeIsNotNull() {
            addCriterion("EXPENDSCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andExpendscopeEqualTo(Integer value) {
            addCriterion("EXPENDSCOPE =", value, "expendscope");
            return (Criteria) this;
        }

        public Criteria andExpendscopeNotEqualTo(Integer value) {
            addCriterion("EXPENDSCOPE <>", value, "expendscope");
            return (Criteria) this;
        }

        public Criteria andExpendscopeGreaterThan(Integer value) {
            addCriterion("EXPENDSCOPE >", value, "expendscope");
            return (Criteria) this;
        }

        public Criteria andExpendscopeGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXPENDSCOPE >=", value, "expendscope");
            return (Criteria) this;
        }

        public Criteria andExpendscopeLessThan(Integer value) {
            addCriterion("EXPENDSCOPE <", value, "expendscope");
            return (Criteria) this;
        }

        public Criteria andExpendscopeLessThanOrEqualTo(Integer value) {
            addCriterion("EXPENDSCOPE <=", value, "expendscope");
            return (Criteria) this;
        }

        public Criteria andExpendscopeIn(List<Integer> values) {
            addCriterion("EXPENDSCOPE in", values, "expendscope");
            return (Criteria) this;
        }

        public Criteria andExpendscopeNotIn(List<Integer> values) {
            addCriterion("EXPENDSCOPE not in", values, "expendscope");
            return (Criteria) this;
        }

        public Criteria andExpendscopeBetween(Integer value1, Integer value2) {
            addCriterion("EXPENDSCOPE between", value1, value2, "expendscope");
            return (Criteria) this;
        }

        public Criteria andExpendscopeNotBetween(Integer value1, Integer value2) {
            addCriterion("EXPENDSCOPE not between", value1, value2, "expendscope");
            return (Criteria) this;
        }

        public Criteria andExpendtypeIsNull() {
            addCriterion("EXPENDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andExpendtypeIsNotNull() {
            addCriterion("EXPENDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andExpendtypeEqualTo(Integer value) {
            addCriterion("EXPENDTYPE =", value, "expendtype");
            return (Criteria) this;
        }

        public Criteria andExpendtypeNotEqualTo(Integer value) {
            addCriterion("EXPENDTYPE <>", value, "expendtype");
            return (Criteria) this;
        }

        public Criteria andExpendtypeGreaterThan(Integer value) {
            addCriterion("EXPENDTYPE >", value, "expendtype");
            return (Criteria) this;
        }

        public Criteria andExpendtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXPENDTYPE >=", value, "expendtype");
            return (Criteria) this;
        }

        public Criteria andExpendtypeLessThan(Integer value) {
            addCriterion("EXPENDTYPE <", value, "expendtype");
            return (Criteria) this;
        }

        public Criteria andExpendtypeLessThanOrEqualTo(Integer value) {
            addCriterion("EXPENDTYPE <=", value, "expendtype");
            return (Criteria) this;
        }

        public Criteria andExpendtypeIn(List<Integer> values) {
            addCriterion("EXPENDTYPE in", values, "expendtype");
            return (Criteria) this;
        }

        public Criteria andExpendtypeNotIn(List<Integer> values) {
            addCriterion("EXPENDTYPE not in", values, "expendtype");
            return (Criteria) this;
        }

        public Criteria andExpendtypeBetween(Integer value1, Integer value2) {
            addCriterion("EXPENDTYPE between", value1, value2, "expendtype");
            return (Criteria) this;
        }

        public Criteria andExpendtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("EXPENDTYPE not between", value1, value2, "expendtype");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIsNull() {
            addCriterion("CREATEUSERID is null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIsNotNull() {
            addCriterion("CREATEUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridEqualTo(String value) {
            addCriterion("CREATEUSERID =", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotEqualTo(String value) {
            addCriterion("CREATEUSERID <>", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThan(String value) {
            addCriterion("CREATEUSERID >", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEUSERID >=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThan(String value) {
            addCriterion("CREATEUSERID <", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThanOrEqualTo(String value) {
            addCriterion("CREATEUSERID <=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLike(String value) {
            addCriterion("CREATEUSERID like", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotLike(String value) {
            addCriterion("CREATEUSERID not like", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIn(List<String> values) {
            addCriterion("CREATEUSERID in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotIn(List<String> values) {
            addCriterion("CREATEUSERID not in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridBetween(String value1, String value2) {
            addCriterion("CREATEUSERID between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotBetween(String value1, String value2) {
            addCriterion("CREATEUSERID not between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIsNull() {
            addCriterion("CREATEUSERNAME is null");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIsNotNull() {
            addCriterion("CREATEUSERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateusernameEqualTo(String value) {
            addCriterion("CREATEUSERNAME =", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotEqualTo(String value) {
            addCriterion("CREATEUSERNAME <>", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameGreaterThan(String value) {
            addCriterion("CREATEUSERNAME >", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEUSERNAME >=", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLessThan(String value) {
            addCriterion("CREATEUSERNAME <", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLessThanOrEqualTo(String value) {
            addCriterion("CREATEUSERNAME <=", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLike(String value) {
            addCriterion("CREATEUSERNAME like", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotLike(String value) {
            addCriterion("CREATEUSERNAME not like", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIn(List<String> values) {
            addCriterion("CREATEUSERNAME in", values, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotIn(List<String> values) {
            addCriterion("CREATEUSERNAME not in", values, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameBetween(String value1, String value2) {
            addCriterion("CREATEUSERNAME between", value1, value2, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotBetween(String value1, String value2) {
            addCriterion("CREATEUSERNAME not between", value1, value2, "createusername");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridIsNull() {
            addCriterion("UPDATEUSERID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridIsNotNull() {
            addCriterion("UPDATEUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridEqualTo(String value) {
            addCriterion("UPDATEUSERID =", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridNotEqualTo(String value) {
            addCriterion("UPDATEUSERID <>", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridGreaterThan(String value) {
            addCriterion("UPDATEUSERID >", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATEUSERID >=", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridLessThan(String value) {
            addCriterion("UPDATEUSERID <", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridLessThanOrEqualTo(String value) {
            addCriterion("UPDATEUSERID <=", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridLike(String value) {
            addCriterion("UPDATEUSERID like", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridNotLike(String value) {
            addCriterion("UPDATEUSERID not like", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridIn(List<String> values) {
            addCriterion("UPDATEUSERID in", values, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridNotIn(List<String> values) {
            addCriterion("UPDATEUSERID not in", values, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridBetween(String value1, String value2) {
            addCriterion("UPDATEUSERID between", value1, value2, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridNotBetween(String value1, String value2) {
            addCriterion("UPDATEUSERID not between", value1, value2, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIsNull() {
            addCriterion("UPDATEUSERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIsNotNull() {
            addCriterion("UPDATEUSERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameEqualTo(String value) {
            addCriterion("UPDATEUSERNAME =", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotEqualTo(String value) {
            addCriterion("UPDATEUSERNAME <>", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameGreaterThan(String value) {
            addCriterion("UPDATEUSERNAME >", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATEUSERNAME >=", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLessThan(String value) {
            addCriterion("UPDATEUSERNAME <", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLessThanOrEqualTo(String value) {
            addCriterion("UPDATEUSERNAME <=", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLike(String value) {
            addCriterion("UPDATEUSERNAME like", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotLike(String value) {
            addCriterion("UPDATEUSERNAME not like", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIn(List<String> values) {
            addCriterion("UPDATEUSERNAME in", values, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotIn(List<String> values) {
            addCriterion("UPDATEUSERNAME not in", values, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameBetween(String value1, String value2) {
            addCriterion("UPDATEUSERNAME between", value1, value2, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotBetween(String value1, String value2) {
            addCriterion("UPDATEUSERNAME not between", value1, value2, "updateusername");
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