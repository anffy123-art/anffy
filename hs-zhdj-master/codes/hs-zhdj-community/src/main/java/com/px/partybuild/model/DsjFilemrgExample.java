package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DsjFilemrgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DsjFilemrgExample() {
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

        public Criteria andExtendednameIsNull() {
            addCriterion("EXTENDEDNAME is null");
            return (Criteria) this;
        }

        public Criteria andExtendednameIsNotNull() {
            addCriterion("EXTENDEDNAME is not null");
            return (Criteria) this;
        }

        public Criteria andExtendednameEqualTo(String value) {
            addCriterion("EXTENDEDNAME =", value, "extendedname");
            return (Criteria) this;
        }

        public Criteria andExtendednameNotEqualTo(String value) {
            addCriterion("EXTENDEDNAME <>", value, "extendedname");
            return (Criteria) this;
        }

        public Criteria andExtendednameGreaterThan(String value) {
            addCriterion("EXTENDEDNAME >", value, "extendedname");
            return (Criteria) this;
        }

        public Criteria andExtendednameGreaterThanOrEqualTo(String value) {
            addCriterion("EXTENDEDNAME >=", value, "extendedname");
            return (Criteria) this;
        }

        public Criteria andExtendednameLessThan(String value) {
            addCriterion("EXTENDEDNAME <", value, "extendedname");
            return (Criteria) this;
        }

        public Criteria andExtendednameLessThanOrEqualTo(String value) {
            addCriterion("EXTENDEDNAME <=", value, "extendedname");
            return (Criteria) this;
        }

        public Criteria andExtendednameLike(String value) {
            addCriterion("EXTENDEDNAME like", value, "extendedname");
            return (Criteria) this;
        }

        public Criteria andExtendednameNotLike(String value) {
            addCriterion("EXTENDEDNAME not like", value, "extendedname");
            return (Criteria) this;
        }

        public Criteria andExtendednameIn(List<String> values) {
            addCriterion("EXTENDEDNAME in", values, "extendedname");
            return (Criteria) this;
        }

        public Criteria andExtendednameNotIn(List<String> values) {
            addCriterion("EXTENDEDNAME not in", values, "extendedname");
            return (Criteria) this;
        }

        public Criteria andExtendednameBetween(String value1, String value2) {
            addCriterion("EXTENDEDNAME between", value1, value2, "extendedname");
            return (Criteria) this;
        }

        public Criteria andExtendednameNotBetween(String value1, String value2) {
            addCriterion("EXTENDEDNAME not between", value1, value2, "extendedname");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeIsNull() {
            addCriterion("CREATEDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeIsNotNull() {
            addCriterion("CREATEDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeEqualTo(Date value) {
            addCriterion("CREATEDATETIME =", value, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeNotEqualTo(Date value) {
            addCriterion("CREATEDATETIME <>", value, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeGreaterThan(Date value) {
            addCriterion("CREATEDATETIME >", value, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATEDATETIME >=", value, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeLessThan(Date value) {
            addCriterion("CREATEDATETIME <", value, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATEDATETIME <=", value, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeIn(List<Date> values) {
            addCriterion("CREATEDATETIME in", values, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeNotIn(List<Date> values) {
            addCriterion("CREATEDATETIME not in", values, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATEDATETIME between", value1, value2, "createdatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATEDATETIME not between", value1, value2, "createdatetime");
            return (Criteria) this;
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

        public Criteria andFilecodeIsNull() {
            addCriterion("FILECODE is null");
            return (Criteria) this;
        }

        public Criteria andFilecodeIsNotNull() {
            addCriterion("FILECODE is not null");
            return (Criteria) this;
        }

        public Criteria andFilecodeEqualTo(String value) {
            addCriterion("FILECODE =", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotEqualTo(String value) {
            addCriterion("FILECODE <>", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeGreaterThan(String value) {
            addCriterion("FILECODE >", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeGreaterThanOrEqualTo(String value) {
            addCriterion("FILECODE >=", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeLessThan(String value) {
            addCriterion("FILECODE <", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeLessThanOrEqualTo(String value) {
            addCriterion("FILECODE <=", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeLike(String value) {
            addCriterion("FILECODE like", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotLike(String value) {
            addCriterion("FILECODE not like", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeIn(List<String> values) {
            addCriterion("FILECODE in", values, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotIn(List<String> values) {
            addCriterion("FILECODE not in", values, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeBetween(String value1, String value2) {
            addCriterion("FILECODE between", value1, value2, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotBetween(String value1, String value2) {
            addCriterion("FILECODE not between", value1, value2, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecode2IsNull() {
            addCriterion("FILECODE2 is null");
            return (Criteria) this;
        }

        public Criteria andFilecode2IsNotNull() {
            addCriterion("FILECODE2 is not null");
            return (Criteria) this;
        }

        public Criteria andFilecode2EqualTo(Integer value) {
            addCriterion("FILECODE2 =", value, "filecode2");
            return (Criteria) this;
        }

        public Criteria andFilecode2NotEqualTo(Integer value) {
            addCriterion("FILECODE2 <>", value, "filecode2");
            return (Criteria) this;
        }

        public Criteria andFilecode2GreaterThan(Integer value) {
            addCriterion("FILECODE2 >", value, "filecode2");
            return (Criteria) this;
        }

        public Criteria andFilecode2GreaterThanOrEqualTo(Integer value) {
            addCriterion("FILECODE2 >=", value, "filecode2");
            return (Criteria) this;
        }

        public Criteria andFilecode2LessThan(Integer value) {
            addCriterion("FILECODE2 <", value, "filecode2");
            return (Criteria) this;
        }

        public Criteria andFilecode2LessThanOrEqualTo(Integer value) {
            addCriterion("FILECODE2 <=", value, "filecode2");
            return (Criteria) this;
        }

        public Criteria andFilecode2In(List<Integer> values) {
            addCriterion("FILECODE2 in", values, "filecode2");
            return (Criteria) this;
        }

        public Criteria andFilecode2NotIn(List<Integer> values) {
            addCriterion("FILECODE2 not in", values, "filecode2");
            return (Criteria) this;
        }

        public Criteria andFilecode2Between(Integer value1, Integer value2) {
            addCriterion("FILECODE2 between", value1, value2, "filecode2");
            return (Criteria) this;
        }

        public Criteria andFilecode2NotBetween(Integer value1, Integer value2) {
            addCriterion("FILECODE2 not between", value1, value2, "filecode2");
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