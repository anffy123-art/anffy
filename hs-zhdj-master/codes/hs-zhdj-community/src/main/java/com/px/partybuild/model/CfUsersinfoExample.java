package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class CfUsersinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfUsersinfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDguseridIsNull() {
            addCriterion("DGUSERID is null");
            return (Criteria) this;
        }

        public Criteria andDguseridIsNotNull() {
            addCriterion("DGUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andDguseridEqualTo(String value) {
            addCriterion("DGUSERID =", value, "dguserid");
            return (Criteria) this;
        }

        public Criteria andDguseridNotEqualTo(String value) {
            addCriterion("DGUSERID <>", value, "dguserid");
            return (Criteria) this;
        }

        public Criteria andDguseridGreaterThan(String value) {
            addCriterion("DGUSERID >", value, "dguserid");
            return (Criteria) this;
        }

        public Criteria andDguseridGreaterThanOrEqualTo(String value) {
            addCriterion("DGUSERID >=", value, "dguserid");
            return (Criteria) this;
        }

        public Criteria andDguseridLessThan(String value) {
            addCriterion("DGUSERID <", value, "dguserid");
            return (Criteria) this;
        }

        public Criteria andDguseridLessThanOrEqualTo(String value) {
            addCriterion("DGUSERID <=", value, "dguserid");
            return (Criteria) this;
        }

        public Criteria andDguseridLike(String value) {
            addCriterion("DGUSERID like", value, "dguserid");
            return (Criteria) this;
        }

        public Criteria andDguseridNotLike(String value) {
            addCriterion("DGUSERID not like", value, "dguserid");
            return (Criteria) this;
        }

        public Criteria andDguseridIn(List<String> values) {
            addCriterion("DGUSERID in", values, "dguserid");
            return (Criteria) this;
        }

        public Criteria andDguseridNotIn(List<String> values) {
            addCriterion("DGUSERID not in", values, "dguserid");
            return (Criteria) this;
        }

        public Criteria andDguseridBetween(String value1, String value2) {
            addCriterion("DGUSERID between", value1, value2, "dguserid");
            return (Criteria) this;
        }

        public Criteria andDguseridNotBetween(String value1, String value2) {
            addCriterion("DGUSERID not between", value1, value2, "dguserid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberIsNull() {
            addCriterion("TELEPHONENUMBER is null");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberIsNotNull() {
            addCriterion("TELEPHONENUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberEqualTo(String value) {
            addCriterion("TELEPHONENUMBER =", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberNotEqualTo(String value) {
            addCriterion("TELEPHONENUMBER <>", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberGreaterThan(String value) {
            addCriterion("TELEPHONENUMBER >", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("TELEPHONENUMBER >=", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberLessThan(String value) {
            addCriterion("TELEPHONENUMBER <", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberLessThanOrEqualTo(String value) {
            addCriterion("TELEPHONENUMBER <=", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberLike(String value) {
            addCriterion("TELEPHONENUMBER like", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberNotLike(String value) {
            addCriterion("TELEPHONENUMBER not like", value, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberIn(List<String> values) {
            addCriterion("TELEPHONENUMBER in", values, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberNotIn(List<String> values) {
            addCriterion("TELEPHONENUMBER not in", values, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberBetween(String value1, String value2) {
            addCriterion("TELEPHONENUMBER between", value1, value2, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andTelephonenumberNotBetween(String value1, String value2) {
            addCriterion("TELEPHONENUMBER not between", value1, value2, "telephonenumber");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("BIRTHDAY =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("BIRTHDAY <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("BIRTHDAY >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("BIRTHDAY >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("BIRTHDAY <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("BIRTHDAY <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("BIRTHDAY like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("BIRTHDAY not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("BIRTHDAY in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("BIRTHDAY not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("BIRTHDAY between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("BIRTHDAY not between", value1, value2, "birthday");
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

        public Criteria andJobtypeidIsNull() {
            addCriterion("JOBTYPEID is null");
            return (Criteria) this;
        }

        public Criteria andJobtypeidIsNotNull() {
            addCriterion("JOBTYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andJobtypeidEqualTo(String value) {
            addCriterion("JOBTYPEID =", value, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andJobtypeidNotEqualTo(String value) {
            addCriterion("JOBTYPEID <>", value, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andJobtypeidGreaterThan(String value) {
            addCriterion("JOBTYPEID >", value, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andJobtypeidGreaterThanOrEqualTo(String value) {
            addCriterion("JOBTYPEID >=", value, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andJobtypeidLessThan(String value) {
            addCriterion("JOBTYPEID <", value, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andJobtypeidLessThanOrEqualTo(String value) {
            addCriterion("JOBTYPEID <=", value, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andJobtypeidLike(String value) {
            addCriterion("JOBTYPEID like", value, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andJobtypeidNotLike(String value) {
            addCriterion("JOBTYPEID not like", value, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andJobtypeidIn(List<String> values) {
            addCriterion("JOBTYPEID in", values, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andJobtypeidNotIn(List<String> values) {
            addCriterion("JOBTYPEID not in", values, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andJobtypeidBetween(String value1, String value2) {
            addCriterion("JOBTYPEID between", value1, value2, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andJobtypeidNotBetween(String value1, String value2) {
            addCriterion("JOBTYPEID not between", value1, value2, "jobtypeid");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeIsNull() {
            addCriterion("DESJOBTYPE is null");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeIsNotNull() {
            addCriterion("DESJOBTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeEqualTo(String value) {
            addCriterion("DESJOBTYPE =", value, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeNotEqualTo(String value) {
            addCriterion("DESJOBTYPE <>", value, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeGreaterThan(String value) {
            addCriterion("DESJOBTYPE >", value, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeGreaterThanOrEqualTo(String value) {
            addCriterion("DESJOBTYPE >=", value, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeLessThan(String value) {
            addCriterion("DESJOBTYPE <", value, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeLessThanOrEqualTo(String value) {
            addCriterion("DESJOBTYPE <=", value, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeLike(String value) {
            addCriterion("DESJOBTYPE like", value, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeNotLike(String value) {
            addCriterion("DESJOBTYPE not like", value, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeIn(List<String> values) {
            addCriterion("DESJOBTYPE in", values, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeNotIn(List<String> values) {
            addCriterion("DESJOBTYPE not in", values, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeBetween(String value1, String value2) {
            addCriterion("DESJOBTYPE between", value1, value2, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andDesjobtypeNotBetween(String value1, String value2) {
            addCriterion("DESJOBTYPE not between", value1, value2, "desjobtype");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidIsNull() {
            addCriterion("EMPLOYEECLASSID is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidIsNotNull() {
            addCriterion("EMPLOYEECLASSID is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidEqualTo(String value) {
            addCriterion("EMPLOYEECLASSID =", value, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidNotEqualTo(String value) {
            addCriterion("EMPLOYEECLASSID <>", value, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidGreaterThan(String value) {
            addCriterion("EMPLOYEECLASSID >", value, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOYEECLASSID >=", value, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidLessThan(String value) {
            addCriterion("EMPLOYEECLASSID <", value, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidLessThanOrEqualTo(String value) {
            addCriterion("EMPLOYEECLASSID <=", value, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidLike(String value) {
            addCriterion("EMPLOYEECLASSID like", value, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidNotLike(String value) {
            addCriterion("EMPLOYEECLASSID not like", value, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidIn(List<String> values) {
            addCriterion("EMPLOYEECLASSID in", values, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidNotIn(List<String> values) {
            addCriterion("EMPLOYEECLASSID not in", values, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidBetween(String value1, String value2) {
            addCriterion("EMPLOYEECLASSID between", value1, value2, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andEmployeeclassidNotBetween(String value1, String value2) {
            addCriterion("EMPLOYEECLASSID not between", value1, value2, "employeeclassid");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassIsNull() {
            addCriterion("DESEMPLOYEECLASS is null");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassIsNotNull() {
            addCriterion("DESEMPLOYEECLASS is not null");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassEqualTo(String value) {
            addCriterion("DESEMPLOYEECLASS =", value, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassNotEqualTo(String value) {
            addCriterion("DESEMPLOYEECLASS <>", value, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassGreaterThan(String value) {
            addCriterion("DESEMPLOYEECLASS >", value, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassGreaterThanOrEqualTo(String value) {
            addCriterion("DESEMPLOYEECLASS >=", value, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassLessThan(String value) {
            addCriterion("DESEMPLOYEECLASS <", value, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassLessThanOrEqualTo(String value) {
            addCriterion("DESEMPLOYEECLASS <=", value, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassLike(String value) {
            addCriterion("DESEMPLOYEECLASS like", value, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassNotLike(String value) {
            addCriterion("DESEMPLOYEECLASS not like", value, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassIn(List<String> values) {
            addCriterion("DESEMPLOYEECLASS in", values, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassNotIn(List<String> values) {
            addCriterion("DESEMPLOYEECLASS not in", values, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassBetween(String value1, String value2) {
            addCriterion("DESEMPLOYEECLASS between", value1, value2, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andDesemployeeclassNotBetween(String value1, String value2) {
            addCriterion("DESEMPLOYEECLASS not between", value1, value2, "desemployeeclass");
            return (Criteria) this;
        }

        public Criteria andSexidIsNull() {
            addCriterion("SEXID is null");
            return (Criteria) this;
        }

        public Criteria andSexidIsNotNull() {
            addCriterion("SEXID is not null");
            return (Criteria) this;
        }

        public Criteria andSexidEqualTo(Integer value) {
            addCriterion("SEXID =", value, "sexid");
            return (Criteria) this;
        }

        public Criteria andSexidNotEqualTo(Integer value) {
            addCriterion("SEXID <>", value, "sexid");
            return (Criteria) this;
        }

        public Criteria andSexidGreaterThan(Integer value) {
            addCriterion("SEXID >", value, "sexid");
            return (Criteria) this;
        }

        public Criteria andSexidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEXID >=", value, "sexid");
            return (Criteria) this;
        }

        public Criteria andSexidLessThan(Integer value) {
            addCriterion("SEXID <", value, "sexid");
            return (Criteria) this;
        }

        public Criteria andSexidLessThanOrEqualTo(Integer value) {
            addCriterion("SEXID <=", value, "sexid");
            return (Criteria) this;
        }

        public Criteria andSexidIn(List<Integer> values) {
            addCriterion("SEXID in", values, "sexid");
            return (Criteria) this;
        }

        public Criteria andSexidNotIn(List<Integer> values) {
            addCriterion("SEXID not in", values, "sexid");
            return (Criteria) this;
        }

        public Criteria andSexidBetween(Integer value1, Integer value2) {
            addCriterion("SEXID between", value1, value2, "sexid");
            return (Criteria) this;
        }

        public Criteria andSexidNotBetween(Integer value1, Integer value2) {
            addCriterion("SEXID not between", value1, value2, "sexid");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNull() {
            addCriterion("ORDERNO is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("ORDERNO is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(String value) {
            addCriterion("ORDERNO =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(String value) {
            addCriterion("ORDERNO <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(String value) {
            addCriterion("ORDERNO >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERNO >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(String value) {
            addCriterion("ORDERNO <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(String value) {
            addCriterion("ORDERNO <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLike(String value) {
            addCriterion("ORDERNO like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotLike(String value) {
            addCriterion("ORDERNO not like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<String> values) {
            addCriterion("ORDERNO in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<String> values) {
            addCriterion("ORDERNO not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(String value1, String value2) {
            addCriterion("ORDERNO between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(String value1, String value2) {
            addCriterion("ORDERNO not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andUserroleIsNull() {
            addCriterion("USERROLE is null");
            return (Criteria) this;
        }

        public Criteria andUserroleIsNotNull() {
            addCriterion("USERROLE is not null");
            return (Criteria) this;
        }

        public Criteria andUserroleEqualTo(String value) {
            addCriterion("USERROLE =", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleNotEqualTo(String value) {
            addCriterion("USERROLE <>", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleGreaterThan(String value) {
            addCriterion("USERROLE >", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleGreaterThanOrEqualTo(String value) {
            addCriterion("USERROLE >=", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleLessThan(String value) {
            addCriterion("USERROLE <", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleLessThanOrEqualTo(String value) {
            addCriterion("USERROLE <=", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleLike(String value) {
            addCriterion("USERROLE like", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleNotLike(String value) {
            addCriterion("USERROLE not like", value, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleIn(List<String> values) {
            addCriterion("USERROLE in", values, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleNotIn(List<String> values) {
            addCriterion("USERROLE not in", values, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleBetween(String value1, String value2) {
            addCriterion("USERROLE between", value1, value2, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserroleNotBetween(String value1, String value2) {
            addCriterion("USERROLE not between", value1, value2, "userrole");
            return (Criteria) this;
        }

        public Criteria andUserligionIsNull() {
            addCriterion("USERLIGION is null");
            return (Criteria) this;
        }

        public Criteria andUserligionIsNotNull() {
            addCriterion("USERLIGION is not null");
            return (Criteria) this;
        }

        public Criteria andUserligionEqualTo(String value) {
            addCriterion("USERLIGION =", value, "userligion");
            return (Criteria) this;
        }

        public Criteria andUserligionNotEqualTo(String value) {
            addCriterion("USERLIGION <>", value, "userligion");
            return (Criteria) this;
        }

        public Criteria andUserligionGreaterThan(String value) {
            addCriterion("USERLIGION >", value, "userligion");
            return (Criteria) this;
        }

        public Criteria andUserligionGreaterThanOrEqualTo(String value) {
            addCriterion("USERLIGION >=", value, "userligion");
            return (Criteria) this;
        }

        public Criteria andUserligionLessThan(String value) {
            addCriterion("USERLIGION <", value, "userligion");
            return (Criteria) this;
        }

        public Criteria andUserligionLessThanOrEqualTo(String value) {
            addCriterion("USERLIGION <=", value, "userligion");
            return (Criteria) this;
        }

        public Criteria andUserligionLike(String value) {
            addCriterion("USERLIGION like", value, "userligion");
            return (Criteria) this;
        }

        public Criteria andUserligionNotLike(String value) {
            addCriterion("USERLIGION not like", value, "userligion");
            return (Criteria) this;
        }

        public Criteria andUserligionIn(List<String> values) {
            addCriterion("USERLIGION in", values, "userligion");
            return (Criteria) this;
        }

        public Criteria andUserligionNotIn(List<String> values) {
            addCriterion("USERLIGION not in", values, "userligion");
            return (Criteria) this;
        }

        public Criteria andUserligionBetween(String value1, String value2) {
            addCriterion("USERLIGION between", value1, value2, "userligion");
            return (Criteria) this;
        }

        public Criteria andUserligionNotBetween(String value1, String value2) {
            addCriterion("USERLIGION not between", value1, value2, "userligion");
            return (Criteria) this;
        }

        public Criteria andIstmpuserIsNull() {
            addCriterion("ISTMPUSER is null");
            return (Criteria) this;
        }

        public Criteria andIstmpuserIsNotNull() {
            addCriterion("ISTMPUSER is not null");
            return (Criteria) this;
        }

        public Criteria andIstmpuserEqualTo(String value) {
            addCriterion("ISTMPUSER =", value, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andIstmpuserNotEqualTo(String value) {
            addCriterion("ISTMPUSER <>", value, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andIstmpuserGreaterThan(String value) {
            addCriterion("ISTMPUSER >", value, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andIstmpuserGreaterThanOrEqualTo(String value) {
            addCriterion("ISTMPUSER >=", value, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andIstmpuserLessThan(String value) {
            addCriterion("ISTMPUSER <", value, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andIstmpuserLessThanOrEqualTo(String value) {
            addCriterion("ISTMPUSER <=", value, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andIstmpuserLike(String value) {
            addCriterion("ISTMPUSER like", value, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andIstmpuserNotLike(String value) {
            addCriterion("ISTMPUSER not like", value, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andIstmpuserIn(List<String> values) {
            addCriterion("ISTMPUSER in", values, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andIstmpuserNotIn(List<String> values) {
            addCriterion("ISTMPUSER not in", values, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andIstmpuserBetween(String value1, String value2) {
            addCriterion("ISTMPUSER between", value1, value2, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andIstmpuserNotBetween(String value1, String value2) {
            addCriterion("ISTMPUSER not between", value1, value2, "istmpuser");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("USERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("USERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Integer value) {
            addCriterion("USERTYPE =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Integer value) {
            addCriterion("USERTYPE <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Integer value) {
            addCriterion("USERTYPE >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("USERTYPE >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Integer value) {
            addCriterion("USERTYPE <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Integer value) {
            addCriterion("USERTYPE <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Integer> values) {
            addCriterion("USERTYPE in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Integer> values) {
            addCriterion("USERTYPE not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Integer value1, Integer value2) {
            addCriterion("USERTYPE between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("USERTYPE not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("POSITION is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("POSITION =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("POSITION <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("POSITION >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("POSITION >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("POSITION <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("POSITION <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("POSITION like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("POSITION not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("POSITION in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("POSITION not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("POSITION between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("POSITION not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andWechatIsNull() {
            addCriterion("WECHAT is null");
            return (Criteria) this;
        }

        public Criteria andWechatIsNotNull() {
            addCriterion("WECHAT is not null");
            return (Criteria) this;
        }

        public Criteria andWechatEqualTo(String value) {
            addCriterion("WECHAT =", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotEqualTo(String value) {
            addCriterion("WECHAT <>", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThan(String value) {
            addCriterion("WECHAT >", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThanOrEqualTo(String value) {
            addCriterion("WECHAT >=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThan(String value) {
            addCriterion("WECHAT <", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThanOrEqualTo(String value) {
            addCriterion("WECHAT <=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLike(String value) {
            addCriterion("WECHAT like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotLike(String value) {
            addCriterion("WECHAT not like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatIn(List<String> values) {
            addCriterion("WECHAT in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotIn(List<String> values) {
            addCriterion("WECHAT not in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatBetween(String value1, String value2) {
            addCriterion("WECHAT between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotBetween(String value1, String value2) {
            addCriterion("WECHAT not between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andIsenableIsNull() {
            addCriterion("ISENABLE is null");
            return (Criteria) this;
        }

        public Criteria andIsenableIsNotNull() {
            addCriterion("ISENABLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsenableEqualTo(Integer value) {
            addCriterion("ISENABLE =", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableNotEqualTo(Integer value) {
            addCriterion("ISENABLE <>", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableGreaterThan(Integer value) {
            addCriterion("ISENABLE >", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISENABLE >=", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableLessThan(Integer value) {
            addCriterion("ISENABLE <", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableLessThanOrEqualTo(Integer value) {
            addCriterion("ISENABLE <=", value, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableIn(List<Integer> values) {
            addCriterion("ISENABLE in", values, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableNotIn(List<Integer> values) {
            addCriterion("ISENABLE not in", values, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableBetween(Integer value1, Integer value2) {
            addCriterion("ISENABLE between", value1, value2, "isenable");
            return (Criteria) this;
        }

        public Criteria andIsenableNotBetween(Integer value1, Integer value2) {
            addCriterion("ISENABLE not between", value1, value2, "isenable");
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