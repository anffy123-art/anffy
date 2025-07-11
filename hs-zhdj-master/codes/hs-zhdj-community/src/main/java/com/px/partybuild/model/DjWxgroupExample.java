package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DjWxgroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DjWxgroupExample() {
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

        public Criteria andWxgroupidIsNull() {
            addCriterion("WXGROUPID is null");
            return (Criteria) this;
        }

        public Criteria andWxgroupidIsNotNull() {
            addCriterion("WXGROUPID is not null");
            return (Criteria) this;
        }

        public Criteria andWxgroupidEqualTo(String value) {
            addCriterion("WXGROUPID =", value, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andWxgroupidNotEqualTo(String value) {
            addCriterion("WXGROUPID <>", value, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andWxgroupidGreaterThan(String value) {
            addCriterion("WXGROUPID >", value, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andWxgroupidGreaterThanOrEqualTo(String value) {
            addCriterion("WXGROUPID >=", value, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andWxgroupidLessThan(String value) {
            addCriterion("WXGROUPID <", value, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andWxgroupidLessThanOrEqualTo(String value) {
            addCriterion("WXGROUPID <=", value, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andWxgroupidLike(String value) {
            addCriterion("WXGROUPID like", value, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andWxgroupidNotLike(String value) {
            addCriterion("WXGROUPID not like", value, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andWxgroupidIn(List<String> values) {
            addCriterion("WXGROUPID in", values, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andWxgroupidNotIn(List<String> values) {
            addCriterion("WXGROUPID not in", values, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andWxgroupidBetween(String value1, String value2) {
            addCriterion("WXGROUPID between", value1, value2, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andWxgroupidNotBetween(String value1, String value2) {
            addCriterion("WXGROUPID not between", value1, value2, "wxgroupid");
            return (Criteria) this;
        }

        public Criteria andPartynameIsNull() {
            addCriterion("PARTYNAME is null");
            return (Criteria) this;
        }

        public Criteria andPartynameIsNotNull() {
            addCriterion("PARTYNAME is not null");
            return (Criteria) this;
        }

        public Criteria andPartynameEqualTo(String value) {
            addCriterion("PARTYNAME =", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotEqualTo(String value) {
            addCriterion("PARTYNAME <>", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameGreaterThan(String value) {
            addCriterion("PARTYNAME >", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameGreaterThanOrEqualTo(String value) {
            addCriterion("PARTYNAME >=", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameLessThan(String value) {
            addCriterion("PARTYNAME <", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameLessThanOrEqualTo(String value) {
            addCriterion("PARTYNAME <=", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameLike(String value) {
            addCriterion("PARTYNAME like", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotLike(String value) {
            addCriterion("PARTYNAME not like", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameIn(List<String> values) {
            addCriterion("PARTYNAME in", values, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotIn(List<String> values) {
            addCriterion("PARTYNAME not in", values, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameBetween(String value1, String value2) {
            addCriterion("PARTYNAME between", value1, value2, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotBetween(String value1, String value2) {
            addCriterion("PARTYNAME not between", value1, value2, "partyname");
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

        public Criteria andGroupnameIsNull() {
            addCriterion("GROUPNAME is null");
            return (Criteria) this;
        }

        public Criteria andGroupnameIsNotNull() {
            addCriterion("GROUPNAME is not null");
            return (Criteria) this;
        }

        public Criteria andGroupnameEqualTo(String value) {
            addCriterion("GROUPNAME =", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotEqualTo(String value) {
            addCriterion("GROUPNAME <>", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameGreaterThan(String value) {
            addCriterion("GROUPNAME >", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPNAME >=", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLessThan(String value) {
            addCriterion("GROUPNAME <", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLessThanOrEqualTo(String value) {
            addCriterion("GROUPNAME <=", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLike(String value) {
            addCriterion("GROUPNAME like", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotLike(String value) {
            addCriterion("GROUPNAME not like", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameIn(List<String> values) {
            addCriterion("GROUPNAME in", values, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotIn(List<String> values) {
            addCriterion("GROUPNAME not in", values, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameBetween(String value1, String value2) {
            addCriterion("GROUPNAME between", value1, value2, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotBetween(String value1, String value2) {
            addCriterion("GROUPNAME not between", value1, value2, "groupname");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIsNull() {
            addCriterion("BUILDTIME is null");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIsNotNull() {
            addCriterion("BUILDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andBuildtimeEqualTo(Date value) {
            addCriterion("BUILDTIME =", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotEqualTo(Date value) {
            addCriterion("BUILDTIME <>", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeGreaterThan(Date value) {
            addCriterion("BUILDTIME >", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BUILDTIME >=", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeLessThan(Date value) {
            addCriterion("BUILDTIME <", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeLessThanOrEqualTo(Date value) {
            addCriterion("BUILDTIME <=", value, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeIn(List<Date> values) {
            addCriterion("BUILDTIME in", values, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotIn(List<Date> values) {
            addCriterion("BUILDTIME not in", values, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeBetween(Date value1, Date value2) {
            addCriterion("BUILDTIME between", value1, value2, "buildtime");
            return (Criteria) this;
        }

        public Criteria andBuildtimeNotBetween(Date value1, Date value2) {
            addCriterion("BUILDTIME not between", value1, value2, "buildtime");
            return (Criteria) this;
        }

        public Criteria andImplatformIsNull() {
            addCriterion("IMPLATFORM is null");
            return (Criteria) this;
        }

        public Criteria andImplatformIsNotNull() {
            addCriterion("IMPLATFORM is not null");
            return (Criteria) this;
        }

        public Criteria andImplatformEqualTo(Integer value) {
            addCriterion("IMPLATFORM =", value, "implatform");
            return (Criteria) this;
        }

        public Criteria andImplatformNotEqualTo(Integer value) {
            addCriterion("IMPLATFORM <>", value, "implatform");
            return (Criteria) this;
        }

        public Criteria andImplatformGreaterThan(Integer value) {
            addCriterion("IMPLATFORM >", value, "implatform");
            return (Criteria) this;
        }

        public Criteria andImplatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("IMPLATFORM >=", value, "implatform");
            return (Criteria) this;
        }

        public Criteria andImplatformLessThan(Integer value) {
            addCriterion("IMPLATFORM <", value, "implatform");
            return (Criteria) this;
        }

        public Criteria andImplatformLessThanOrEqualTo(Integer value) {
            addCriterion("IMPLATFORM <=", value, "implatform");
            return (Criteria) this;
        }

        public Criteria andImplatformIn(List<Integer> values) {
            addCriterion("IMPLATFORM in", values, "implatform");
            return (Criteria) this;
        }

        public Criteria andImplatformNotIn(List<Integer> values) {
            addCriterion("IMPLATFORM not in", values, "implatform");
            return (Criteria) this;
        }

        public Criteria andImplatformBetween(Integer value1, Integer value2) {
            addCriterion("IMPLATFORM between", value1, value2, "implatform");
            return (Criteria) this;
        }

        public Criteria andImplatformNotBetween(Integer value1, Integer value2) {
            addCriterion("IMPLATFORM not between", value1, value2, "implatform");
            return (Criteria) this;
        }

        public Criteria andMirrorIsNull() {
            addCriterion("MIRROR is null");
            return (Criteria) this;
        }

        public Criteria andMirrorIsNotNull() {
            addCriterion("MIRROR is not null");
            return (Criteria) this;
        }

        public Criteria andMirrorEqualTo(String value) {
            addCriterion("MIRROR =", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorNotEqualTo(String value) {
            addCriterion("MIRROR <>", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorGreaterThan(String value) {
            addCriterion("MIRROR >", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorGreaterThanOrEqualTo(String value) {
            addCriterion("MIRROR >=", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorLessThan(String value) {
            addCriterion("MIRROR <", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorLessThanOrEqualTo(String value) {
            addCriterion("MIRROR <=", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorLike(String value) {
            addCriterion("MIRROR like", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorNotLike(String value) {
            addCriterion("MIRROR not like", value, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorIn(List<String> values) {
            addCriterion("MIRROR in", values, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorNotIn(List<String> values) {
            addCriterion("MIRROR not in", values, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorBetween(String value1, String value2) {
            addCriterion("MIRROR between", value1, value2, "mirror");
            return (Criteria) this;
        }

        public Criteria andMirrorNotBetween(String value1, String value2) {
            addCriterion("MIRROR not between", value1, value2, "mirror");
            return (Criteria) this;
        }

        public Criteria andGroupernameIsNull() {
            addCriterion("GROUPERNAME is null");
            return (Criteria) this;
        }

        public Criteria andGroupernameIsNotNull() {
            addCriterion("GROUPERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andGroupernameEqualTo(String value) {
            addCriterion("GROUPERNAME =", value, "groupername");
            return (Criteria) this;
        }

        public Criteria andGroupernameNotEqualTo(String value) {
            addCriterion("GROUPERNAME <>", value, "groupername");
            return (Criteria) this;
        }

        public Criteria andGroupernameGreaterThan(String value) {
            addCriterion("GROUPERNAME >", value, "groupername");
            return (Criteria) this;
        }

        public Criteria andGroupernameGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPERNAME >=", value, "groupername");
            return (Criteria) this;
        }

        public Criteria andGroupernameLessThan(String value) {
            addCriterion("GROUPERNAME <", value, "groupername");
            return (Criteria) this;
        }

        public Criteria andGroupernameLessThanOrEqualTo(String value) {
            addCriterion("GROUPERNAME <=", value, "groupername");
            return (Criteria) this;
        }

        public Criteria andGroupernameLike(String value) {
            addCriterion("GROUPERNAME like", value, "groupername");
            return (Criteria) this;
        }

        public Criteria andGroupernameNotLike(String value) {
            addCriterion("GROUPERNAME not like", value, "groupername");
            return (Criteria) this;
        }

        public Criteria andGroupernameIn(List<String> values) {
            addCriterion("GROUPERNAME in", values, "groupername");
            return (Criteria) this;
        }

        public Criteria andGroupernameNotIn(List<String> values) {
            addCriterion("GROUPERNAME not in", values, "groupername");
            return (Criteria) this;
        }

        public Criteria andGroupernameBetween(String value1, String value2) {
            addCriterion("GROUPERNAME between", value1, value2, "groupername");
            return (Criteria) this;
        }

        public Criteria andGroupernameNotBetween(String value1, String value2) {
            addCriterion("GROUPERNAME not between", value1, value2, "groupername");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyIsNull() {
            addCriterion("GROUPERDUTY is null");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyIsNotNull() {
            addCriterion("GROUPERDUTY is not null");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyEqualTo(String value) {
            addCriterion("GROUPERDUTY =", value, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyNotEqualTo(String value) {
            addCriterion("GROUPERDUTY <>", value, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyGreaterThan(String value) {
            addCriterion("GROUPERDUTY >", value, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPERDUTY >=", value, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyLessThan(String value) {
            addCriterion("GROUPERDUTY <", value, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyLessThanOrEqualTo(String value) {
            addCriterion("GROUPERDUTY <=", value, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyLike(String value) {
            addCriterion("GROUPERDUTY like", value, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyNotLike(String value) {
            addCriterion("GROUPERDUTY not like", value, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyIn(List<String> values) {
            addCriterion("GROUPERDUTY in", values, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyNotIn(List<String> values) {
            addCriterion("GROUPERDUTY not in", values, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyBetween(String value1, String value2) {
            addCriterion("GROUPERDUTY between", value1, value2, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGrouperdutyNotBetween(String value1, String value2) {
            addCriterion("GROUPERDUTY not between", value1, value2, "grouperduty");
            return (Criteria) this;
        }

        public Criteria andGroupertelIsNull() {
            addCriterion("GROUPERTEL is null");
            return (Criteria) this;
        }

        public Criteria andGroupertelIsNotNull() {
            addCriterion("GROUPERTEL is not null");
            return (Criteria) this;
        }

        public Criteria andGroupertelEqualTo(String value) {
            addCriterion("GROUPERTEL =", value, "groupertel");
            return (Criteria) this;
        }

        public Criteria andGroupertelNotEqualTo(String value) {
            addCriterion("GROUPERTEL <>", value, "groupertel");
            return (Criteria) this;
        }

        public Criteria andGroupertelGreaterThan(String value) {
            addCriterion("GROUPERTEL >", value, "groupertel");
            return (Criteria) this;
        }

        public Criteria andGroupertelGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPERTEL >=", value, "groupertel");
            return (Criteria) this;
        }

        public Criteria andGroupertelLessThan(String value) {
            addCriterion("GROUPERTEL <", value, "groupertel");
            return (Criteria) this;
        }

        public Criteria andGroupertelLessThanOrEqualTo(String value) {
            addCriterion("GROUPERTEL <=", value, "groupertel");
            return (Criteria) this;
        }

        public Criteria andGroupertelLike(String value) {
            addCriterion("GROUPERTEL like", value, "groupertel");
            return (Criteria) this;
        }

        public Criteria andGroupertelNotLike(String value) {
            addCriterion("GROUPERTEL not like", value, "groupertel");
            return (Criteria) this;
        }

        public Criteria andGroupertelIn(List<String> values) {
            addCriterion("GROUPERTEL in", values, "groupertel");
            return (Criteria) this;
        }

        public Criteria andGroupertelNotIn(List<String> values) {
            addCriterion("GROUPERTEL not in", values, "groupertel");
            return (Criteria) this;
        }

        public Criteria andGroupertelBetween(String value1, String value2) {
            addCriterion("GROUPERTEL between", value1, value2, "groupertel");
            return (Criteria) this;
        }

        public Criteria andGroupertelNotBetween(String value1, String value2) {
            addCriterion("GROUPERTEL not between", value1, value2, "groupertel");
            return (Criteria) this;
        }

        public Criteria andMainableIsNull() {
            addCriterion("MAINABLE is null");
            return (Criteria) this;
        }

        public Criteria andMainableIsNotNull() {
            addCriterion("MAINABLE is not null");
            return (Criteria) this;
        }

        public Criteria andMainableEqualTo(String value) {
            addCriterion("MAINABLE =", value, "mainable");
            return (Criteria) this;
        }

        public Criteria andMainableNotEqualTo(String value) {
            addCriterion("MAINABLE <>", value, "mainable");
            return (Criteria) this;
        }

        public Criteria andMainableGreaterThan(String value) {
            addCriterion("MAINABLE >", value, "mainable");
            return (Criteria) this;
        }

        public Criteria andMainableGreaterThanOrEqualTo(String value) {
            addCriterion("MAINABLE >=", value, "mainable");
            return (Criteria) this;
        }

        public Criteria andMainableLessThan(String value) {
            addCriterion("MAINABLE <", value, "mainable");
            return (Criteria) this;
        }

        public Criteria andMainableLessThanOrEqualTo(String value) {
            addCriterion("MAINABLE <=", value, "mainable");
            return (Criteria) this;
        }

        public Criteria andMainableLike(String value) {
            addCriterion("MAINABLE like", value, "mainable");
            return (Criteria) this;
        }

        public Criteria andMainableNotLike(String value) {
            addCriterion("MAINABLE not like", value, "mainable");
            return (Criteria) this;
        }

        public Criteria andMainableIn(List<String> values) {
            addCriterion("MAINABLE in", values, "mainable");
            return (Criteria) this;
        }

        public Criteria andMainableNotIn(List<String> values) {
            addCriterion("MAINABLE not in", values, "mainable");
            return (Criteria) this;
        }

        public Criteria andMainableBetween(String value1, String value2) {
            addCriterion("MAINABLE between", value1, value2, "mainable");
            return (Criteria) this;
        }

        public Criteria andMainableNotBetween(String value1, String value2) {
            addCriterion("MAINABLE not between", value1, value2, "mainable");
            return (Criteria) this;
        }

        public Criteria andMirrorwayIsNull() {
            addCriterion("MIRRORWAY is null");
            return (Criteria) this;
        }

        public Criteria andMirrorwayIsNotNull() {
            addCriterion("MIRRORWAY is not null");
            return (Criteria) this;
        }

        public Criteria andMirrorwayEqualTo(String value) {
            addCriterion("MIRRORWAY =", value, "mirrorway");
            return (Criteria) this;
        }

        public Criteria andMirrorwayNotEqualTo(String value) {
            addCriterion("MIRRORWAY <>", value, "mirrorway");
            return (Criteria) this;
        }

        public Criteria andMirrorwayGreaterThan(String value) {
            addCriterion("MIRRORWAY >", value, "mirrorway");
            return (Criteria) this;
        }

        public Criteria andMirrorwayGreaterThanOrEqualTo(String value) {
            addCriterion("MIRRORWAY >=", value, "mirrorway");
            return (Criteria) this;
        }

        public Criteria andMirrorwayLessThan(String value) {
            addCriterion("MIRRORWAY <", value, "mirrorway");
            return (Criteria) this;
        }

        public Criteria andMirrorwayLessThanOrEqualTo(String value) {
            addCriterion("MIRRORWAY <=", value, "mirrorway");
            return (Criteria) this;
        }

        public Criteria andMirrorwayLike(String value) {
            addCriterion("MIRRORWAY like", value, "mirrorway");
            return (Criteria) this;
        }

        public Criteria andMirrorwayNotLike(String value) {
            addCriterion("MIRRORWAY not like", value, "mirrorway");
            return (Criteria) this;
        }

        public Criteria andMirrorwayIn(List<String> values) {
            addCriterion("MIRRORWAY in", values, "mirrorway");
            return (Criteria) this;
        }

        public Criteria andMirrorwayNotIn(List<String> values) {
            addCriterion("MIRRORWAY not in", values, "mirrorway");
            return (Criteria) this;
        }

        public Criteria andMirrorwayBetween(String value1, String value2) {
            addCriterion("MIRRORWAY between", value1, value2, "mirrorway");
            return (Criteria) this;
        }

        public Criteria andMirrorwayNotBetween(String value1, String value2) {
            addCriterion("MIRRORWAY not between", value1, value2, "mirrorway");
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

        public Criteria andScalenumberIsNull() {
            addCriterion("SCALENUMBER is null");
            return (Criteria) this;
        }

        public Criteria andScalenumberIsNotNull() {
            addCriterion("SCALENUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andScalenumberEqualTo(Integer value) {
            addCriterion("SCALENUMBER =", value, "scalenumber");
            return (Criteria) this;
        }

        public Criteria andScalenumberNotEqualTo(Integer value) {
            addCriterion("SCALENUMBER <>", value, "scalenumber");
            return (Criteria) this;
        }

        public Criteria andScalenumberGreaterThan(Integer value) {
            addCriterion("SCALENUMBER >", value, "scalenumber");
            return (Criteria) this;
        }

        public Criteria andScalenumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCALENUMBER >=", value, "scalenumber");
            return (Criteria) this;
        }

        public Criteria andScalenumberLessThan(Integer value) {
            addCriterion("SCALENUMBER <", value, "scalenumber");
            return (Criteria) this;
        }

        public Criteria andScalenumberLessThanOrEqualTo(Integer value) {
            addCriterion("SCALENUMBER <=", value, "scalenumber");
            return (Criteria) this;
        }

        public Criteria andScalenumberIn(List<Integer> values) {
            addCriterion("SCALENUMBER in", values, "scalenumber");
            return (Criteria) this;
        }

        public Criteria andScalenumberNotIn(List<Integer> values) {
            addCriterion("SCALENUMBER not in", values, "scalenumber");
            return (Criteria) this;
        }

        public Criteria andScalenumberBetween(Integer value1, Integer value2) {
            addCriterion("SCALENUMBER between", value1, value2, "scalenumber");
            return (Criteria) this;
        }

        public Criteria andScalenumberNotBetween(Integer value1, Integer value2) {
            addCriterion("SCALENUMBER not between", value1, value2, "scalenumber");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNull() {
            addCriterion("MSGTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNotNull() {
            addCriterion("MSGTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeEqualTo(String value) {
            addCriterion("MSGTYPE =", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotEqualTo(String value) {
            addCriterion("MSGTYPE <>", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThan(String value) {
            addCriterion("MSGTYPE >", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("MSGTYPE >=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThan(String value) {
            addCriterion("MSGTYPE <", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThanOrEqualTo(String value) {
            addCriterion("MSGTYPE <=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLike(String value) {
            addCriterion("MSGTYPE like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotLike(String value) {
            addCriterion("MSGTYPE not like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIn(List<String> values) {
            addCriterion("MSGTYPE in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotIn(List<String> values) {
            addCriterion("MSGTYPE not in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeBetween(String value1, String value2) {
            addCriterion("MSGTYPE between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotBetween(String value1, String value2) {
            addCriterion("MSGTYPE not between", value1, value2, "msgtype");
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