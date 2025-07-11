package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfFileExample() {
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

        public Criteria andFileidIsNull() {
            addCriterion("FILEID is null");
            return (Criteria) this;
        }

        public Criteria andFileidIsNotNull() {
            addCriterion("FILEID is not null");
            return (Criteria) this;
        }

        public Criteria andFileidEqualTo(String value) {
            addCriterion("FILEID =", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotEqualTo(String value) {
            addCriterion("FILEID <>", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThan(String value) {
            addCriterion("FILEID >", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThanOrEqualTo(String value) {
            addCriterion("FILEID >=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThan(String value) {
            addCriterion("FILEID <", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThanOrEqualTo(String value) {
            addCriterion("FILEID <=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLike(String value) {
            addCriterion("FILEID like", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotLike(String value) {
            addCriterion("FILEID not like", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidIn(List<String> values) {
            addCriterion("FILEID in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotIn(List<String> values) {
            addCriterion("FILEID not in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidBetween(String value1, String value2) {
            addCriterion("FILEID between", value1, value2, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotBetween(String value1, String value2) {
            addCriterion("FILEID not between", value1, value2, "fileid");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("FILENAME is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("FILENAME is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("FILENAME =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("FILENAME <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("FILENAME >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("FILENAME >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("FILENAME <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("FILENAME <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("FILENAME like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("FILENAME not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("FILENAME in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("FILENAME not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("FILENAME between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("FILENAME not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilesuffixIsNull() {
            addCriterion("FILESUFFIX is null");
            return (Criteria) this;
        }

        public Criteria andFilesuffixIsNotNull() {
            addCriterion("FILESUFFIX is not null");
            return (Criteria) this;
        }

        public Criteria andFilesuffixEqualTo(String value) {
            addCriterion("FILESUFFIX =", value, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFilesuffixNotEqualTo(String value) {
            addCriterion("FILESUFFIX <>", value, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFilesuffixGreaterThan(String value) {
            addCriterion("FILESUFFIX >", value, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFilesuffixGreaterThanOrEqualTo(String value) {
            addCriterion("FILESUFFIX >=", value, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFilesuffixLessThan(String value) {
            addCriterion("FILESUFFIX <", value, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFilesuffixLessThanOrEqualTo(String value) {
            addCriterion("FILESUFFIX <=", value, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFilesuffixLike(String value) {
            addCriterion("FILESUFFIX like", value, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFilesuffixNotLike(String value) {
            addCriterion("FILESUFFIX not like", value, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFilesuffixIn(List<String> values) {
            addCriterion("FILESUFFIX in", values, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFilesuffixNotIn(List<String> values) {
            addCriterion("FILESUFFIX not in", values, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFilesuffixBetween(String value1, String value2) {
            addCriterion("FILESUFFIX between", value1, value2, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFilesuffixNotBetween(String value1, String value2) {
            addCriterion("FILESUFFIX not between", value1, value2, "filesuffix");
            return (Criteria) this;
        }

        public Criteria andFileurlIsNull() {
            addCriterion("FILEURL is null");
            return (Criteria) this;
        }

        public Criteria andFileurlIsNotNull() {
            addCriterion("FILEURL is not null");
            return (Criteria) this;
        }

        public Criteria andFileurlEqualTo(String value) {
            addCriterion("FILEURL =", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotEqualTo(String value) {
            addCriterion("FILEURL <>", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlGreaterThan(String value) {
            addCriterion("FILEURL >", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlGreaterThanOrEqualTo(String value) {
            addCriterion("FILEURL >=", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlLessThan(String value) {
            addCriterion("FILEURL <", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlLessThanOrEqualTo(String value) {
            addCriterion("FILEURL <=", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlLike(String value) {
            addCriterion("FILEURL like", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotLike(String value) {
            addCriterion("FILEURL not like", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlIn(List<String> values) {
            addCriterion("FILEURL in", values, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotIn(List<String> values) {
            addCriterion("FILEURL not in", values, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlBetween(String value1, String value2) {
            addCriterion("FILEURL between", value1, value2, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotBetween(String value1, String value2) {
            addCriterion("FILEURL not between", value1, value2, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNull() {
            addCriterion("FILETYPE is null");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNotNull() {
            addCriterion("FILETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFiletypeEqualTo(Integer value) {
            addCriterion("FILETYPE =", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotEqualTo(Integer value) {
            addCriterion("FILETYPE <>", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThan(Integer value) {
            addCriterion("FILETYPE >", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FILETYPE >=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThan(Integer value) {
            addCriterion("FILETYPE <", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThanOrEqualTo(Integer value) {
            addCriterion("FILETYPE <=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeIn(List<Integer> values) {
            addCriterion("FILETYPE in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotIn(List<Integer> values) {
            addCriterion("FILETYPE not in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeBetween(Integer value1, Integer value2) {
            addCriterion("FILETYPE between", value1, value2, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotBetween(Integer value1, Integer value2) {
            addCriterion("FILETYPE not between", value1, value2, "filetype");
            return (Criteria) this;
        }

        public Criteria andSfileidIsNull() {
            addCriterion("SFILEID is null");
            return (Criteria) this;
        }

        public Criteria andSfileidIsNotNull() {
            addCriterion("SFILEID is not null");
            return (Criteria) this;
        }

        public Criteria andSfileidEqualTo(String value) {
            addCriterion("SFILEID =", value, "sfileid");
            return (Criteria) this;
        }

        public Criteria andSfileidNotEqualTo(String value) {
            addCriterion("SFILEID <>", value, "sfileid");
            return (Criteria) this;
        }

        public Criteria andSfileidGreaterThan(String value) {
            addCriterion("SFILEID >", value, "sfileid");
            return (Criteria) this;
        }

        public Criteria andSfileidGreaterThanOrEqualTo(String value) {
            addCriterion("SFILEID >=", value, "sfileid");
            return (Criteria) this;
        }

        public Criteria andSfileidLessThan(String value) {
            addCriterion("SFILEID <", value, "sfileid");
            return (Criteria) this;
        }

        public Criteria andSfileidLessThanOrEqualTo(String value) {
            addCriterion("SFILEID <=", value, "sfileid");
            return (Criteria) this;
        }

        public Criteria andSfileidLike(String value) {
            addCriterion("SFILEID like", value, "sfileid");
            return (Criteria) this;
        }

        public Criteria andSfileidNotLike(String value) {
            addCriterion("SFILEID not like", value, "sfileid");
            return (Criteria) this;
        }

        public Criteria andSfileidIn(List<String> values) {
            addCriterion("SFILEID in", values, "sfileid");
            return (Criteria) this;
        }

        public Criteria andSfileidNotIn(List<String> values) {
            addCriterion("SFILEID not in", values, "sfileid");
            return (Criteria) this;
        }

        public Criteria andSfileidBetween(String value1, String value2) {
            addCriterion("SFILEID between", value1, value2, "sfileid");
            return (Criteria) this;
        }

        public Criteria andSfileidNotBetween(String value1, String value2) {
            addCriterion("SFILEID not between", value1, value2, "sfileid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("USERID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("USERID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andFilerefidIsNull() {
            addCriterion("FILEREFID is null");
            return (Criteria) this;
        }

        public Criteria andFilerefidIsNotNull() {
            addCriterion("FILEREFID is not null");
            return (Criteria) this;
        }

        public Criteria andFilerefidEqualTo(String value) {
            addCriterion("FILEREFID =", value, "filerefid");
            return (Criteria) this;
        }

        public Criteria andFilerefidNotEqualTo(String value) {
            addCriterion("FILEREFID <>", value, "filerefid");
            return (Criteria) this;
        }

        public Criteria andFilerefidGreaterThan(String value) {
            addCriterion("FILEREFID >", value, "filerefid");
            return (Criteria) this;
        }

        public Criteria andFilerefidGreaterThanOrEqualTo(String value) {
            addCriterion("FILEREFID >=", value, "filerefid");
            return (Criteria) this;
        }

        public Criteria andFilerefidLessThan(String value) {
            addCriterion("FILEREFID <", value, "filerefid");
            return (Criteria) this;
        }

        public Criteria andFilerefidLessThanOrEqualTo(String value) {
            addCriterion("FILEREFID <=", value, "filerefid");
            return (Criteria) this;
        }

        public Criteria andFilerefidLike(String value) {
            addCriterion("FILEREFID like", value, "filerefid");
            return (Criteria) this;
        }

        public Criteria andFilerefidNotLike(String value) {
            addCriterion("FILEREFID not like", value, "filerefid");
            return (Criteria) this;
        }

        public Criteria andFilerefidIn(List<String> values) {
            addCriterion("FILEREFID in", values, "filerefid");
            return (Criteria) this;
        }

        public Criteria andFilerefidNotIn(List<String> values) {
            addCriterion("FILEREFID not in", values, "filerefid");
            return (Criteria) this;
        }

        public Criteria andFilerefidBetween(String value1, String value2) {
            addCriterion("FILEREFID between", value1, value2, "filerefid");
            return (Criteria) this;
        }

        public Criteria andFilerefidNotBetween(String value1, String value2) {
            addCriterion("FILEREFID not between", value1, value2, "filerefid");
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