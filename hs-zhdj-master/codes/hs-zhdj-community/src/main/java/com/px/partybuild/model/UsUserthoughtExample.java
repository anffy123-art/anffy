package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsUserthoughtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsUserthoughtExample() {
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

        public Criteria andUserthoughtidIsNull() {
            addCriterion("USERTHOUGHTID is null");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidIsNotNull() {
            addCriterion("USERTHOUGHTID is not null");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidEqualTo(String value) {
            addCriterion("USERTHOUGHTID =", value, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidNotEqualTo(String value) {
            addCriterion("USERTHOUGHTID <>", value, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidGreaterThan(String value) {
            addCriterion("USERTHOUGHTID >", value, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidGreaterThanOrEqualTo(String value) {
            addCriterion("USERTHOUGHTID >=", value, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidLessThan(String value) {
            addCriterion("USERTHOUGHTID <", value, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidLessThanOrEqualTo(String value) {
            addCriterion("USERTHOUGHTID <=", value, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidLike(String value) {
            addCriterion("USERTHOUGHTID like", value, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidNotLike(String value) {
            addCriterion("USERTHOUGHTID not like", value, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidIn(List<String> values) {
            addCriterion("USERTHOUGHTID in", values, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidNotIn(List<String> values) {
            addCriterion("USERTHOUGHTID not in", values, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidBetween(String value1, String value2) {
            addCriterion("USERTHOUGHTID between", value1, value2, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUserthoughtidNotBetween(String value1, String value2) {
            addCriterion("USERTHOUGHTID not between", value1, value2, "userthoughtid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
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

        public Criteria andThoughttypeIsNull() {
            addCriterion("THOUGHTTYPE is null");
            return (Criteria) this;
        }

        public Criteria andThoughttypeIsNotNull() {
            addCriterion("THOUGHTTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andThoughttypeEqualTo(Integer value) {
            addCriterion("THOUGHTTYPE =", value, "thoughttype");
            return (Criteria) this;
        }

        public Criteria andThoughttypeNotEqualTo(Integer value) {
            addCriterion("THOUGHTTYPE <>", value, "thoughttype");
            return (Criteria) this;
        }

        public Criteria andThoughttypeGreaterThan(Integer value) {
            addCriterion("THOUGHTTYPE >", value, "thoughttype");
            return (Criteria) this;
        }

        public Criteria andThoughttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("THOUGHTTYPE >=", value, "thoughttype");
            return (Criteria) this;
        }

        public Criteria andThoughttypeLessThan(Integer value) {
            addCriterion("THOUGHTTYPE <", value, "thoughttype");
            return (Criteria) this;
        }

        public Criteria andThoughttypeLessThanOrEqualTo(Integer value) {
            addCriterion("THOUGHTTYPE <=", value, "thoughttype");
            return (Criteria) this;
        }

        public Criteria andThoughttypeIn(List<Integer> values) {
            addCriterion("THOUGHTTYPE in", values, "thoughttype");
            return (Criteria) this;
        }

        public Criteria andThoughttypeNotIn(List<Integer> values) {
            addCriterion("THOUGHTTYPE not in", values, "thoughttype");
            return (Criteria) this;
        }

        public Criteria andThoughttypeBetween(Integer value1, Integer value2) {
            addCriterion("THOUGHTTYPE between", value1, value2, "thoughttype");
            return (Criteria) this;
        }

        public Criteria andThoughttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("THOUGHTTYPE not between", value1, value2, "thoughttype");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeIsNull() {
            addCriterion("QUESTIONTYPE is null");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeIsNotNull() {
            addCriterion("QUESTIONTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeEqualTo(Integer value) {
            addCriterion("QUESTIONTYPE =", value, "questiontype");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeNotEqualTo(Integer value) {
            addCriterion("QUESTIONTYPE <>", value, "questiontype");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeGreaterThan(Integer value) {
            addCriterion("QUESTIONTYPE >", value, "questiontype");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("QUESTIONTYPE >=", value, "questiontype");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeLessThan(Integer value) {
            addCriterion("QUESTIONTYPE <", value, "questiontype");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeLessThanOrEqualTo(Integer value) {
            addCriterion("QUESTIONTYPE <=", value, "questiontype");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeIn(List<Integer> values) {
            addCriterion("QUESTIONTYPE in", values, "questiontype");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeNotIn(List<Integer> values) {
            addCriterion("QUESTIONTYPE not in", values, "questiontype");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeBetween(Integer value1, Integer value2) {
            addCriterion("QUESTIONTYPE between", value1, value2, "questiontype");
            return (Criteria) this;
        }

        public Criteria andQuestiontypeNotBetween(Integer value1, Integer value2) {
            addCriterion("QUESTIONTYPE not between", value1, value2, "questiontype");
            return (Criteria) this;
        }

        public Criteria andFindtimeIsNull() {
            addCriterion("FINDTIME is null");
            return (Criteria) this;
        }

        public Criteria andFindtimeIsNotNull() {
            addCriterion("FINDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andFindtimeEqualTo(Date value) {
            addCriterion("FINDTIME =", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeNotEqualTo(Date value) {
            addCriterion("FINDTIME <>", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeGreaterThan(Date value) {
            addCriterion("FINDTIME >", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FINDTIME >=", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeLessThan(Date value) {
            addCriterion("FINDTIME <", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeLessThanOrEqualTo(Date value) {
            addCriterion("FINDTIME <=", value, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeIn(List<Date> values) {
            addCriterion("FINDTIME in", values, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeNotIn(List<Date> values) {
            addCriterion("FINDTIME not in", values, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeBetween(Date value1, Date value2) {
            addCriterion("FINDTIME between", value1, value2, "findtime");
            return (Criteria) this;
        }

        public Criteria andFindtimeNotBetween(Date value1, Date value2) {
            addCriterion("FINDTIME not between", value1, value2, "findtime");
            return (Criteria) this;
        }

        public Criteria andAcceptuserIsNull() {
            addCriterion("ACCEPTUSER is null");
            return (Criteria) this;
        }

        public Criteria andAcceptuserIsNotNull() {
            addCriterion("ACCEPTUSER is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptuserEqualTo(String value) {
            addCriterion("ACCEPTUSER =", value, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andAcceptuserNotEqualTo(String value) {
            addCriterion("ACCEPTUSER <>", value, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andAcceptuserGreaterThan(String value) {
            addCriterion("ACCEPTUSER >", value, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andAcceptuserGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPTUSER >=", value, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andAcceptuserLessThan(String value) {
            addCriterion("ACCEPTUSER <", value, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andAcceptuserLessThanOrEqualTo(String value) {
            addCriterion("ACCEPTUSER <=", value, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andAcceptuserLike(String value) {
            addCriterion("ACCEPTUSER like", value, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andAcceptuserNotLike(String value) {
            addCriterion("ACCEPTUSER not like", value, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andAcceptuserIn(List<String> values) {
            addCriterion("ACCEPTUSER in", values, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andAcceptuserNotIn(List<String> values) {
            addCriterion("ACCEPTUSER not in", values, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andAcceptuserBetween(String value1, String value2) {
            addCriterion("ACCEPTUSER between", value1, value2, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andAcceptuserNotBetween(String value1, String value2) {
            addCriterion("ACCEPTUSER not between", value1, value2, "acceptuser");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNull() {
            addCriterion("QUESTION is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNotNull() {
            addCriterion("QUESTION is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionEqualTo(String value) {
            addCriterion("QUESTION =", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotEqualTo(String value) {
            addCriterion("QUESTION <>", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThan(String value) {
            addCriterion("QUESTION >", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION >=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThan(String value) {
            addCriterion("QUESTION <", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThanOrEqualTo(String value) {
            addCriterion("QUESTION <=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLike(String value) {
            addCriterion("QUESTION like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotLike(String value) {
            addCriterion("QUESTION not like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionIn(List<String> values) {
            addCriterion("QUESTION in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotIn(List<String> values) {
            addCriterion("QUESTION not in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionBetween(String value1, String value2) {
            addCriterion("QUESTION between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotBetween(String value1, String value2) {
            addCriterion("QUESTION not between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andHandletypeIsNull() {
            addCriterion("HANDLETYPE is null");
            return (Criteria) this;
        }

        public Criteria andHandletypeIsNotNull() {
            addCriterion("HANDLETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andHandletypeEqualTo(Integer value) {
            addCriterion("HANDLETYPE =", value, "handletype");
            return (Criteria) this;
        }

        public Criteria andHandletypeNotEqualTo(Integer value) {
            addCriterion("HANDLETYPE <>", value, "handletype");
            return (Criteria) this;
        }

        public Criteria andHandletypeGreaterThan(Integer value) {
            addCriterion("HANDLETYPE >", value, "handletype");
            return (Criteria) this;
        }

        public Criteria andHandletypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("HANDLETYPE >=", value, "handletype");
            return (Criteria) this;
        }

        public Criteria andHandletypeLessThan(Integer value) {
            addCriterion("HANDLETYPE <", value, "handletype");
            return (Criteria) this;
        }

        public Criteria andHandletypeLessThanOrEqualTo(Integer value) {
            addCriterion("HANDLETYPE <=", value, "handletype");
            return (Criteria) this;
        }

        public Criteria andHandletypeIn(List<Integer> values) {
            addCriterion("HANDLETYPE in", values, "handletype");
            return (Criteria) this;
        }

        public Criteria andHandletypeNotIn(List<Integer> values) {
            addCriterion("HANDLETYPE not in", values, "handletype");
            return (Criteria) this;
        }

        public Criteria andHandletypeBetween(Integer value1, Integer value2) {
            addCriterion("HANDLETYPE between", value1, value2, "handletype");
            return (Criteria) this;
        }

        public Criteria andHandletypeNotBetween(Integer value1, Integer value2) {
            addCriterion("HANDLETYPE not between", value1, value2, "handletype");
            return (Criteria) this;
        }

        public Criteria andDestroytypeIsNull() {
            addCriterion("DESTROYTYPE is null");
            return (Criteria) this;
        }

        public Criteria andDestroytypeIsNotNull() {
            addCriterion("DESTROYTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDestroytypeEqualTo(Integer value) {
            addCriterion("DESTROYTYPE =", value, "destroytype");
            return (Criteria) this;
        }

        public Criteria andDestroytypeNotEqualTo(Integer value) {
            addCriterion("DESTROYTYPE <>", value, "destroytype");
            return (Criteria) this;
        }

        public Criteria andDestroytypeGreaterThan(Integer value) {
            addCriterion("DESTROYTYPE >", value, "destroytype");
            return (Criteria) this;
        }

        public Criteria andDestroytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DESTROYTYPE >=", value, "destroytype");
            return (Criteria) this;
        }

        public Criteria andDestroytypeLessThan(Integer value) {
            addCriterion("DESTROYTYPE <", value, "destroytype");
            return (Criteria) this;
        }

        public Criteria andDestroytypeLessThanOrEqualTo(Integer value) {
            addCriterion("DESTROYTYPE <=", value, "destroytype");
            return (Criteria) this;
        }

        public Criteria andDestroytypeIn(List<Integer> values) {
            addCriterion("DESTROYTYPE in", values, "destroytype");
            return (Criteria) this;
        }

        public Criteria andDestroytypeNotIn(List<Integer> values) {
            addCriterion("DESTROYTYPE not in", values, "destroytype");
            return (Criteria) this;
        }

        public Criteria andDestroytypeBetween(Integer value1, Integer value2) {
            addCriterion("DESTROYTYPE between", value1, value2, "destroytype");
            return (Criteria) this;
        }

        public Criteria andDestroytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("DESTROYTYPE not between", value1, value2, "destroytype");
            return (Criteria) this;
        }

        public Criteria andDestroytimeIsNull() {
            addCriterion("DESTROYTIME is null");
            return (Criteria) this;
        }

        public Criteria andDestroytimeIsNotNull() {
            addCriterion("DESTROYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andDestroytimeEqualTo(Date value) {
            addCriterion("DESTROYTIME =", value, "destroytime");
            return (Criteria) this;
        }

        public Criteria andDestroytimeNotEqualTo(Date value) {
            addCriterion("DESTROYTIME <>", value, "destroytime");
            return (Criteria) this;
        }

        public Criteria andDestroytimeGreaterThan(Date value) {
            addCriterion("DESTROYTIME >", value, "destroytime");
            return (Criteria) this;
        }

        public Criteria andDestroytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DESTROYTIME >=", value, "destroytime");
            return (Criteria) this;
        }

        public Criteria andDestroytimeLessThan(Date value) {
            addCriterion("DESTROYTIME <", value, "destroytime");
            return (Criteria) this;
        }

        public Criteria andDestroytimeLessThanOrEqualTo(Date value) {
            addCriterion("DESTROYTIME <=", value, "destroytime");
            return (Criteria) this;
        }

        public Criteria andDestroytimeIn(List<Date> values) {
            addCriterion("DESTROYTIME in", values, "destroytime");
            return (Criteria) this;
        }

        public Criteria andDestroytimeNotIn(List<Date> values) {
            addCriterion("DESTROYTIME not in", values, "destroytime");
            return (Criteria) this;
        }

        public Criteria andDestroytimeBetween(Date value1, Date value2) {
            addCriterion("DESTROYTIME between", value1, value2, "destroytime");
            return (Criteria) this;
        }

        public Criteria andDestroytimeNotBetween(Date value1, Date value2) {
            addCriterion("DESTROYTIME not between", value1, value2, "destroytime");
            return (Criteria) this;
        }

        public Criteria andHandlestateIsNull() {
            addCriterion("HANDLESTATE is null");
            return (Criteria) this;
        }

        public Criteria andHandlestateIsNotNull() {
            addCriterion("HANDLESTATE is not null");
            return (Criteria) this;
        }

        public Criteria andHandlestateEqualTo(Integer value) {
            addCriterion("HANDLESTATE =", value, "handlestate");
            return (Criteria) this;
        }

        public Criteria andHandlestateNotEqualTo(Integer value) {
            addCriterion("HANDLESTATE <>", value, "handlestate");
            return (Criteria) this;
        }

        public Criteria andHandlestateGreaterThan(Integer value) {
            addCriterion("HANDLESTATE >", value, "handlestate");
            return (Criteria) this;
        }

        public Criteria andHandlestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("HANDLESTATE >=", value, "handlestate");
            return (Criteria) this;
        }

        public Criteria andHandlestateLessThan(Integer value) {
            addCriterion("HANDLESTATE <", value, "handlestate");
            return (Criteria) this;
        }

        public Criteria andHandlestateLessThanOrEqualTo(Integer value) {
            addCriterion("HANDLESTATE <=", value, "handlestate");
            return (Criteria) this;
        }

        public Criteria andHandlestateIn(List<Integer> values) {
            addCriterion("HANDLESTATE in", values, "handlestate");
            return (Criteria) this;
        }

        public Criteria andHandlestateNotIn(List<Integer> values) {
            addCriterion("HANDLESTATE not in", values, "handlestate");
            return (Criteria) this;
        }

        public Criteria andHandlestateBetween(Integer value1, Integer value2) {
            addCriterion("HANDLESTATE between", value1, value2, "handlestate");
            return (Criteria) this;
        }

        public Criteria andHandlestateNotBetween(Integer value1, Integer value2) {
            addCriterion("HANDLESTATE not between", value1, value2, "handlestate");
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

        public Criteria andHandlecontentIsNull() {
            addCriterion("HANDLECONTENT is null");
            return (Criteria) this;
        }

        public Criteria andHandlecontentIsNotNull() {
            addCriterion("HANDLECONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andHandlecontentEqualTo(String value) {
            addCriterion("HANDLECONTENT =", value, "handlecontent");
            return (Criteria) this;
        }

        public Criteria andHandlecontentNotEqualTo(String value) {
            addCriterion("HANDLECONTENT <>", value, "handlecontent");
            return (Criteria) this;
        }

        public Criteria andHandlecontentGreaterThan(String value) {
            addCriterion("HANDLECONTENT >", value, "handlecontent");
            return (Criteria) this;
        }

        public Criteria andHandlecontentGreaterThanOrEqualTo(String value) {
            addCriterion("HANDLECONTENT >=", value, "handlecontent");
            return (Criteria) this;
        }

        public Criteria andHandlecontentLessThan(String value) {
            addCriterion("HANDLECONTENT <", value, "handlecontent");
            return (Criteria) this;
        }

        public Criteria andHandlecontentLessThanOrEqualTo(String value) {
            addCriterion("HANDLECONTENT <=", value, "handlecontent");
            return (Criteria) this;
        }

        public Criteria andHandlecontentLike(String value) {
            addCriterion("HANDLECONTENT like", value, "handlecontent");
            return (Criteria) this;
        }

        public Criteria andHandlecontentNotLike(String value) {
            addCriterion("HANDLECONTENT not like", value, "handlecontent");
            return (Criteria) this;
        }

        public Criteria andHandlecontentIn(List<String> values) {
            addCriterion("HANDLECONTENT in", values, "handlecontent");
            return (Criteria) this;
        }

        public Criteria andHandlecontentNotIn(List<String> values) {
            addCriterion("HANDLECONTENT not in", values, "handlecontent");
            return (Criteria) this;
        }

        public Criteria andHandlecontentBetween(String value1, String value2) {
            addCriterion("HANDLECONTENT between", value1, value2, "handlecontent");
            return (Criteria) this;
        }

        public Criteria andHandlecontentNotBetween(String value1, String value2) {
            addCriterion("HANDLECONTENT not between", value1, value2, "handlecontent");
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