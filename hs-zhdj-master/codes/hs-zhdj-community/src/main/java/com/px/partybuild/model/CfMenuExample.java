package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class CfMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfMenuExample() {
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

        public Criteria andMenuidIsNull() {
            addCriterion("MENUID is null");
            return (Criteria) this;
        }

        public Criteria andMenuidIsNotNull() {
            addCriterion("MENUID is not null");
            return (Criteria) this;
        }

        public Criteria andMenuidEqualTo(String value) {
            addCriterion("MENUID =", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotEqualTo(String value) {
            addCriterion("MENUID <>", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidGreaterThan(String value) {
            addCriterion("MENUID >", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidGreaterThanOrEqualTo(String value) {
            addCriterion("MENUID >=", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidLessThan(String value) {
            addCriterion("MENUID <", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidLessThanOrEqualTo(String value) {
            addCriterion("MENUID <=", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidLike(String value) {
            addCriterion("MENUID like", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotLike(String value) {
            addCriterion("MENUID not like", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidIn(List<String> values) {
            addCriterion("MENUID in", values, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotIn(List<String> values) {
            addCriterion("MENUID not in", values, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidBetween(String value1, String value2) {
            addCriterion("MENUID between", value1, value2, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotBetween(String value1, String value2) {
            addCriterion("MENUID not between", value1, value2, "menuid");
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

        public Criteria andParentmenuidIsNull() {
            addCriterion("PARENTMENUID is null");
            return (Criteria) this;
        }

        public Criteria andParentmenuidIsNotNull() {
            addCriterion("PARENTMENUID is not null");
            return (Criteria) this;
        }

        public Criteria andParentmenuidEqualTo(String value) {
            addCriterion("PARENTMENUID =", value, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andParentmenuidNotEqualTo(String value) {
            addCriterion("PARENTMENUID <>", value, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andParentmenuidGreaterThan(String value) {
            addCriterion("PARENTMENUID >", value, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andParentmenuidGreaterThanOrEqualTo(String value) {
            addCriterion("PARENTMENUID >=", value, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andParentmenuidLessThan(String value) {
            addCriterion("PARENTMENUID <", value, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andParentmenuidLessThanOrEqualTo(String value) {
            addCriterion("PARENTMENUID <=", value, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andParentmenuidLike(String value) {
            addCriterion("PARENTMENUID like", value, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andParentmenuidNotLike(String value) {
            addCriterion("PARENTMENUID not like", value, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andParentmenuidIn(List<String> values) {
            addCriterion("PARENTMENUID in", values, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andParentmenuidNotIn(List<String> values) {
            addCriterion("PARENTMENUID not in", values, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andParentmenuidBetween(String value1, String value2) {
            addCriterion("PARENTMENUID between", value1, value2, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andParentmenuidNotBetween(String value1, String value2) {
            addCriterion("PARENTMENUID not between", value1, value2, "parentmenuid");
            return (Criteria) this;
        }

        public Criteria andMnusystemIsNull() {
            addCriterion("MNUSYSTEM is null");
            return (Criteria) this;
        }

        public Criteria andMnusystemIsNotNull() {
            addCriterion("MNUSYSTEM is not null");
            return (Criteria) this;
        }

        public Criteria andMnusystemEqualTo(String value) {
            addCriterion("MNUSYSTEM =", value, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMnusystemNotEqualTo(String value) {
            addCriterion("MNUSYSTEM <>", value, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMnusystemGreaterThan(String value) {
            addCriterion("MNUSYSTEM >", value, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMnusystemGreaterThanOrEqualTo(String value) {
            addCriterion("MNUSYSTEM >=", value, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMnusystemLessThan(String value) {
            addCriterion("MNUSYSTEM <", value, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMnusystemLessThanOrEqualTo(String value) {
            addCriterion("MNUSYSTEM <=", value, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMnusystemLike(String value) {
            addCriterion("MNUSYSTEM like", value, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMnusystemNotLike(String value) {
            addCriterion("MNUSYSTEM not like", value, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMnusystemIn(List<String> values) {
            addCriterion("MNUSYSTEM in", values, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMnusystemNotIn(List<String> values) {
            addCriterion("MNUSYSTEM not in", values, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMnusystemBetween(String value1, String value2) {
            addCriterion("MNUSYSTEM between", value1, value2, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMnusystemNotBetween(String value1, String value2) {
            addCriterion("MNUSYSTEM not between", value1, value2, "mnusystem");
            return (Criteria) this;
        }

        public Criteria andMenuorderIsNull() {
            addCriterion("MENUORDER is null");
            return (Criteria) this;
        }

        public Criteria andMenuorderIsNotNull() {
            addCriterion("MENUORDER is not null");
            return (Criteria) this;
        }

        public Criteria andMenuorderEqualTo(Integer value) {
            addCriterion("MENUORDER =", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderNotEqualTo(Integer value) {
            addCriterion("MENUORDER <>", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderGreaterThan(Integer value) {
            addCriterion("MENUORDER >", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("MENUORDER >=", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderLessThan(Integer value) {
            addCriterion("MENUORDER <", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderLessThanOrEqualTo(Integer value) {
            addCriterion("MENUORDER <=", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderIn(List<Integer> values) {
            addCriterion("MENUORDER in", values, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderNotIn(List<Integer> values) {
            addCriterion("MENUORDER not in", values, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderBetween(Integer value1, Integer value2) {
            addCriterion("MENUORDER between", value1, value2, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderNotBetween(Integer value1, Integer value2) {
            addCriterion("MENUORDER not between", value1, value2, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenunoIsNull() {
            addCriterion("MENUNO is null");
            return (Criteria) this;
        }

        public Criteria andMenunoIsNotNull() {
            addCriterion("MENUNO is not null");
            return (Criteria) this;
        }

        public Criteria andMenunoEqualTo(String value) {
            addCriterion("MENUNO =", value, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunoNotEqualTo(String value) {
            addCriterion("MENUNO <>", value, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunoGreaterThan(String value) {
            addCriterion("MENUNO >", value, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunoGreaterThanOrEqualTo(String value) {
            addCriterion("MENUNO >=", value, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunoLessThan(String value) {
            addCriterion("MENUNO <", value, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunoLessThanOrEqualTo(String value) {
            addCriterion("MENUNO <=", value, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunoLike(String value) {
            addCriterion("MENUNO like", value, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunoNotLike(String value) {
            addCriterion("MENUNO not like", value, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunoIn(List<String> values) {
            addCriterion("MENUNO in", values, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunoNotIn(List<String> values) {
            addCriterion("MENUNO not in", values, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunoBetween(String value1, String value2) {
            addCriterion("MENUNO between", value1, value2, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunoNotBetween(String value1, String value2) {
            addCriterion("MENUNO not between", value1, value2, "menuno");
            return (Criteria) this;
        }

        public Criteria andMenunameIsNull() {
            addCriterion("MENUNAME is null");
            return (Criteria) this;
        }

        public Criteria andMenunameIsNotNull() {
            addCriterion("MENUNAME is not null");
            return (Criteria) this;
        }

        public Criteria andMenunameEqualTo(String value) {
            addCriterion("MENUNAME =", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotEqualTo(String value) {
            addCriterion("MENUNAME <>", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameGreaterThan(String value) {
            addCriterion("MENUNAME >", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameGreaterThanOrEqualTo(String value) {
            addCriterion("MENUNAME >=", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLessThan(String value) {
            addCriterion("MENUNAME <", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLessThanOrEqualTo(String value) {
            addCriterion("MENUNAME <=", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameLike(String value) {
            addCriterion("MENUNAME like", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotLike(String value) {
            addCriterion("MENUNAME not like", value, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameIn(List<String> values) {
            addCriterion("MENUNAME in", values, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotIn(List<String> values) {
            addCriterion("MENUNAME not in", values, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameBetween(String value1, String value2) {
            addCriterion("MENUNAME between", value1, value2, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenunameNotBetween(String value1, String value2) {
            addCriterion("MENUNAME not between", value1, value2, "menuname");
            return (Criteria) this;
        }

        public Criteria andMenuprogramIsNull() {
            addCriterion("MENUPROGRAM is null");
            return (Criteria) this;
        }

        public Criteria andMenuprogramIsNotNull() {
            addCriterion("MENUPROGRAM is not null");
            return (Criteria) this;
        }

        public Criteria andMenuprogramEqualTo(String value) {
            addCriterion("MENUPROGRAM =", value, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenuprogramNotEqualTo(String value) {
            addCriterion("MENUPROGRAM <>", value, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenuprogramGreaterThan(String value) {
            addCriterion("MENUPROGRAM >", value, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenuprogramGreaterThanOrEqualTo(String value) {
            addCriterion("MENUPROGRAM >=", value, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenuprogramLessThan(String value) {
            addCriterion("MENUPROGRAM <", value, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenuprogramLessThanOrEqualTo(String value) {
            addCriterion("MENUPROGRAM <=", value, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenuprogramLike(String value) {
            addCriterion("MENUPROGRAM like", value, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenuprogramNotLike(String value) {
            addCriterion("MENUPROGRAM not like", value, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenuprogramIn(List<String> values) {
            addCriterion("MENUPROGRAM in", values, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenuprogramNotIn(List<String> values) {
            addCriterion("MENUPROGRAM not in", values, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenuprogramBetween(String value1, String value2) {
            addCriterion("MENUPROGRAM between", value1, value2, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenuprogramNotBetween(String value1, String value2) {
            addCriterion("MENUPROGRAM not between", value1, value2, "menuprogram");
            return (Criteria) this;
        }

        public Criteria andMenupicIsNull() {
            addCriterion("MENUPIC is null");
            return (Criteria) this;
        }

        public Criteria andMenupicIsNotNull() {
            addCriterion("MENUPIC is not null");
            return (Criteria) this;
        }

        public Criteria andMenupicEqualTo(String value) {
            addCriterion("MENUPIC =", value, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenupicNotEqualTo(String value) {
            addCriterion("MENUPIC <>", value, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenupicGreaterThan(String value) {
            addCriterion("MENUPIC >", value, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenupicGreaterThanOrEqualTo(String value) {
            addCriterion("MENUPIC >=", value, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenupicLessThan(String value) {
            addCriterion("MENUPIC <", value, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenupicLessThanOrEqualTo(String value) {
            addCriterion("MENUPIC <=", value, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenupicLike(String value) {
            addCriterion("MENUPIC like", value, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenupicNotLike(String value) {
            addCriterion("MENUPIC not like", value, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenupicIn(List<String> values) {
            addCriterion("MENUPIC in", values, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenupicNotIn(List<String> values) {
            addCriterion("MENUPIC not in", values, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenupicBetween(String value1, String value2) {
            addCriterion("MENUPIC between", value1, value2, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenupicNotBetween(String value1, String value2) {
            addCriterion("MENUPIC not between", value1, value2, "menupic");
            return (Criteria) this;
        }

        public Criteria andMenudescIsNull() {
            addCriterion("MENUDESC is null");
            return (Criteria) this;
        }

        public Criteria andMenudescIsNotNull() {
            addCriterion("MENUDESC is not null");
            return (Criteria) this;
        }

        public Criteria andMenudescEqualTo(String value) {
            addCriterion("MENUDESC =", value, "menudesc");
            return (Criteria) this;
        }

        public Criteria andMenudescNotEqualTo(String value) {
            addCriterion("MENUDESC <>", value, "menudesc");
            return (Criteria) this;
        }

        public Criteria andMenudescGreaterThan(String value) {
            addCriterion("MENUDESC >", value, "menudesc");
            return (Criteria) this;
        }

        public Criteria andMenudescGreaterThanOrEqualTo(String value) {
            addCriterion("MENUDESC >=", value, "menudesc");
            return (Criteria) this;
        }

        public Criteria andMenudescLessThan(String value) {
            addCriterion("MENUDESC <", value, "menudesc");
            return (Criteria) this;
        }

        public Criteria andMenudescLessThanOrEqualTo(String value) {
            addCriterion("MENUDESC <=", value, "menudesc");
            return (Criteria) this;
        }

        public Criteria andMenudescLike(String value) {
            addCriterion("MENUDESC like", value, "menudesc");
            return (Criteria) this;
        }

        public Criteria andMenudescNotLike(String value) {
            addCriterion("MENUDESC not like", value, "menudesc");
            return (Criteria) this;
        }

        public Criteria andMenudescIn(List<String> values) {
            addCriterion("MENUDESC in", values, "menudesc");
            return (Criteria) this;
        }

        public Criteria andMenudescNotIn(List<String> values) {
            addCriterion("MENUDESC not in", values, "menudesc");
            return (Criteria) this;
        }

        public Criteria andMenudescBetween(String value1, String value2) {
            addCriterion("MENUDESC between", value1, value2, "menudesc");
            return (Criteria) this;
        }

        public Criteria andMenudescNotBetween(String value1, String value2) {
            addCriterion("MENUDESC not between", value1, value2, "menudesc");
            return (Criteria) this;
        }

        public Criteria andIsvisibleIsNull() {
            addCriterion("ISVISIBLE is null");
            return (Criteria) this;
        }

        public Criteria andIsvisibleIsNotNull() {
            addCriterion("ISVISIBLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsvisibleEqualTo(Integer value) {
            addCriterion("ISVISIBLE =", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleNotEqualTo(Integer value) {
            addCriterion("ISVISIBLE <>", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleGreaterThan(Integer value) {
            addCriterion("ISVISIBLE >", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISVISIBLE >=", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleLessThan(Integer value) {
            addCriterion("ISVISIBLE <", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleLessThanOrEqualTo(Integer value) {
            addCriterion("ISVISIBLE <=", value, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleIn(List<Integer> values) {
            addCriterion("ISVISIBLE in", values, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleNotIn(List<Integer> values) {
            addCriterion("ISVISIBLE not in", values, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleBetween(Integer value1, Integer value2) {
            addCriterion("ISVISIBLE between", value1, value2, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsvisibleNotBetween(Integer value1, Integer value2) {
            addCriterion("ISVISIBLE not between", value1, value2, "isvisible");
            return (Criteria) this;
        }

        public Criteria andIsleafIsNull() {
            addCriterion("ISLEAF is null");
            return (Criteria) this;
        }

        public Criteria andIsleafIsNotNull() {
            addCriterion("ISLEAF is not null");
            return (Criteria) this;
        }

        public Criteria andIsleafEqualTo(Integer value) {
            addCriterion("ISLEAF =", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotEqualTo(Integer value) {
            addCriterion("ISLEAF <>", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafGreaterThan(Integer value) {
            addCriterion("ISLEAF >", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISLEAF >=", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafLessThan(Integer value) {
            addCriterion("ISLEAF <", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafLessThanOrEqualTo(Integer value) {
            addCriterion("ISLEAF <=", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafIn(List<Integer> values) {
            addCriterion("ISLEAF in", values, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotIn(List<Integer> values) {
            addCriterion("ISLEAF not in", values, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafBetween(Integer value1, Integer value2) {
            addCriterion("ISLEAF between", value1, value2, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotBetween(Integer value1, Integer value2) {
            addCriterion("ISLEAF not between", value1, value2, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsblankIsNull() {
            addCriterion("ISBLANK is null");
            return (Criteria) this;
        }

        public Criteria andIsblankIsNotNull() {
            addCriterion("ISBLANK is not null");
            return (Criteria) this;
        }

        public Criteria andIsblankEqualTo(Integer value) {
            addCriterion("ISBLANK =", value, "isblank");
            return (Criteria) this;
        }

        public Criteria andIsblankNotEqualTo(Integer value) {
            addCriterion("ISBLANK <>", value, "isblank");
            return (Criteria) this;
        }

        public Criteria andIsblankGreaterThan(Integer value) {
            addCriterion("ISBLANK >", value, "isblank");
            return (Criteria) this;
        }

        public Criteria andIsblankGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISBLANK >=", value, "isblank");
            return (Criteria) this;
        }

        public Criteria andIsblankLessThan(Integer value) {
            addCriterion("ISBLANK <", value, "isblank");
            return (Criteria) this;
        }

        public Criteria andIsblankLessThanOrEqualTo(Integer value) {
            addCriterion("ISBLANK <=", value, "isblank");
            return (Criteria) this;
        }

        public Criteria andIsblankIn(List<Integer> values) {
            addCriterion("ISBLANK in", values, "isblank");
            return (Criteria) this;
        }

        public Criteria andIsblankNotIn(List<Integer> values) {
            addCriterion("ISBLANK not in", values, "isblank");
            return (Criteria) this;
        }

        public Criteria andIsblankBetween(Integer value1, Integer value2) {
            addCriterion("ISBLANK between", value1, value2, "isblank");
            return (Criteria) this;
        }

        public Criteria andIsblankNotBetween(Integer value1, Integer value2) {
            addCriterion("ISBLANK not between", value1, value2, "isblank");
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