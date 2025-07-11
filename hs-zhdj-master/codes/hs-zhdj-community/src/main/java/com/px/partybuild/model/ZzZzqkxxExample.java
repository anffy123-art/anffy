package com.px.partybuild.model;

import java.util.ArrayList;
import java.util.List;

public class ZzZzqkxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzZzqkxxExample() {
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

        public Criteria andZzqkxxbsIsNull() {
            addCriterion("ZZQKXXBS is null");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsIsNotNull() {
            addCriterion("ZZQKXXBS is not null");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsEqualTo(String value) {
            addCriterion("ZZQKXXBS =", value, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsNotEqualTo(String value) {
            addCriterion("ZZQKXXBS <>", value, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsGreaterThan(String value) {
            addCriterion("ZZQKXXBS >", value, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsGreaterThanOrEqualTo(String value) {
            addCriterion("ZZQKXXBS >=", value, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsLessThan(String value) {
            addCriterion("ZZQKXXBS <", value, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsLessThanOrEqualTo(String value) {
            addCriterion("ZZQKXXBS <=", value, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsLike(String value) {
            addCriterion("ZZQKXXBS like", value, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsNotLike(String value) {
            addCriterion("ZZQKXXBS not like", value, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsIn(List<String> values) {
            addCriterion("ZZQKXXBS in", values, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsNotIn(List<String> values) {
            addCriterion("ZZQKXXBS not in", values, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsBetween(String value1, String value2) {
            addCriterion("ZZQKXXBS between", value1, value2, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andZzqkxxbsNotBetween(String value1, String value2) {
            addCriterion("ZZQKXXBS not between", value1, value2, "zzqkxxbs");
            return (Criteria) this;
        }

        public Criteria andDzzdmIsNull() {
            addCriterion("DZZDM is null");
            return (Criteria) this;
        }

        public Criteria andDzzdmIsNotNull() {
            addCriterion("DZZDM is not null");
            return (Criteria) this;
        }

        public Criteria andDzzdmEqualTo(String value) {
            addCriterion("DZZDM =", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotEqualTo(String value) {
            addCriterion("DZZDM <>", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmGreaterThan(String value) {
            addCriterion("DZZDM >", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmGreaterThanOrEqualTo(String value) {
            addCriterion("DZZDM >=", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmLessThan(String value) {
            addCriterion("DZZDM <", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmLessThanOrEqualTo(String value) {
            addCriterion("DZZDM <=", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmLike(String value) {
            addCriterion("DZZDM like", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotLike(String value) {
            addCriterion("DZZDM not like", value, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmIn(List<String> values) {
            addCriterion("DZZDM in", values, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotIn(List<String> values) {
            addCriterion("DZZDM not in", values, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmBetween(String value1, String value2) {
            addCriterion("DZZDM between", value1, value2, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzdmNotBetween(String value1, String value2) {
            addCriterion("DZZDM not between", value1, value2, "dzzdm");
            return (Criteria) this;
        }

        public Criteria andDzzmcIsNull() {
            addCriterion("DZZMC is null");
            return (Criteria) this;
        }

        public Criteria andDzzmcIsNotNull() {
            addCriterion("DZZMC is not null");
            return (Criteria) this;
        }

        public Criteria andDzzmcEqualTo(String value) {
            addCriterion("DZZMC =", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotEqualTo(String value) {
            addCriterion("DZZMC <>", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcGreaterThan(String value) {
            addCriterion("DZZMC >", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcGreaterThanOrEqualTo(String value) {
            addCriterion("DZZMC >=", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLessThan(String value) {
            addCriterion("DZZMC <", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLessThanOrEqualTo(String value) {
            addCriterion("DZZMC <=", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcLike(String value) {
            addCriterion("DZZMC like", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotLike(String value) {
            addCriterion("DZZMC not like", value, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcIn(List<String> values) {
            addCriterion("DZZMC in", values, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotIn(List<String> values) {
            addCriterion("DZZMC not in", values, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcBetween(String value1, String value2) {
            addCriterion("DZZMC between", value1, value2, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andDzzmcNotBetween(String value1, String value2) {
            addCriterion("DZZMC not between", value1, value2, "dzzmc");
            return (Criteria) this;
        }

        public Criteria andZzlbIsNull() {
            addCriterion("ZZLB is null");
            return (Criteria) this;
        }

        public Criteria andZzlbIsNotNull() {
            addCriterion("ZZLB is not null");
            return (Criteria) this;
        }

        public Criteria andZzlbEqualTo(String value) {
            addCriterion("ZZLB =", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbNotEqualTo(String value) {
            addCriterion("ZZLB <>", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbGreaterThan(String value) {
            addCriterion("ZZLB >", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbGreaterThanOrEqualTo(String value) {
            addCriterion("ZZLB >=", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbLessThan(String value) {
            addCriterion("ZZLB <", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbLessThanOrEqualTo(String value) {
            addCriterion("ZZLB <=", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbLike(String value) {
            addCriterion("ZZLB like", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbNotLike(String value) {
            addCriterion("ZZLB not like", value, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbIn(List<String> values) {
            addCriterion("ZZLB in", values, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbNotIn(List<String> values) {
            addCriterion("ZZLB not in", values, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbBetween(String value1, String value2) {
            addCriterion("ZZLB between", value1, value2, "zzlb");
            return (Criteria) this;
        }

        public Criteria andZzlbNotBetween(String value1, String value2) {
            addCriterion("ZZLB not between", value1, value2, "zzlb");
            return (Criteria) this;
        }

        public Criteria andJczzflIsNull() {
            addCriterion("JCZZFL is null");
            return (Criteria) this;
        }

        public Criteria andJczzflIsNotNull() {
            addCriterion("JCZZFL is not null");
            return (Criteria) this;
        }

        public Criteria andJczzflEqualTo(String value) {
            addCriterion("JCZZFL =", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflNotEqualTo(String value) {
            addCriterion("JCZZFL <>", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflGreaterThan(String value) {
            addCriterion("JCZZFL >", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflGreaterThanOrEqualTo(String value) {
            addCriterion("JCZZFL >=", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflLessThan(String value) {
            addCriterion("JCZZFL <", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflLessThanOrEqualTo(String value) {
            addCriterion("JCZZFL <=", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflLike(String value) {
            addCriterion("JCZZFL like", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflNotLike(String value) {
            addCriterion("JCZZFL not like", value, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflIn(List<String> values) {
            addCriterion("JCZZFL in", values, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflNotIn(List<String> values) {
            addCriterion("JCZZFL not in", values, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflBetween(String value1, String value2) {
            addCriterion("JCZZFL between", value1, value2, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJczzflNotBetween(String value1, String value2) {
            addCriterion("JCZZFL not between", value1, value2, "jczzfl");
            return (Criteria) this;
        }

        public Criteria andJldzzrqIsNull() {
            addCriterion("JLDZZRQ is null");
            return (Criteria) this;
        }

        public Criteria andJldzzrqIsNotNull() {
            addCriterion("JLDZZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andJldzzrqEqualTo(String value) {
            addCriterion("JLDZZRQ =", value, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andJldzzrqNotEqualTo(String value) {
            addCriterion("JLDZZRQ <>", value, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andJldzzrqGreaterThan(String value) {
            addCriterion("JLDZZRQ >", value, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andJldzzrqGreaterThanOrEqualTo(String value) {
            addCriterion("JLDZZRQ >=", value, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andJldzzrqLessThan(String value) {
            addCriterion("JLDZZRQ <", value, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andJldzzrqLessThanOrEqualTo(String value) {
            addCriterion("JLDZZRQ <=", value, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andJldzzrqLike(String value) {
            addCriterion("JLDZZRQ like", value, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andJldzzrqNotLike(String value) {
            addCriterion("JLDZZRQ not like", value, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andJldzzrqIn(List<String> values) {
            addCriterion("JLDZZRQ in", values, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andJldzzrqNotIn(List<String> values) {
            addCriterion("JLDZZRQ not in", values, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andJldzzrqBetween(String value1, String value2) {
            addCriterion("JLDZZRQ between", value1, value2, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andJldzzrqNotBetween(String value1, String value2) {
            addCriterion("JLDZZRQ not between", value1, value2, "jldzzrq");
            return (Criteria) this;
        }

        public Criteria andScytdzbIsNull() {
            addCriterion("SCYTDZB is null");
            return (Criteria) this;
        }

        public Criteria andScytdzbIsNotNull() {
            addCriterion("SCYTDZB is not null");
            return (Criteria) this;
        }

        public Criteria andScytdzbEqualTo(String value) {
            addCriterion("SCYTDZB =", value, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andScytdzbNotEqualTo(String value) {
            addCriterion("SCYTDZB <>", value, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andScytdzbGreaterThan(String value) {
            addCriterion("SCYTDZB >", value, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andScytdzbGreaterThanOrEqualTo(String value) {
            addCriterion("SCYTDZB >=", value, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andScytdzbLessThan(String value) {
            addCriterion("SCYTDZB <", value, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andScytdzbLessThanOrEqualTo(String value) {
            addCriterion("SCYTDZB <=", value, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andScytdzbLike(String value) {
            addCriterion("SCYTDZB like", value, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andScytdzbNotLike(String value) {
            addCriterion("SCYTDZB not like", value, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andScytdzbIn(List<String> values) {
            addCriterion("SCYTDZB in", values, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andScytdzbNotIn(List<String> values) {
            addCriterion("SCYTDZB not in", values, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andScytdzbBetween(String value1, String value2) {
            addCriterion("SCYTDZB between", value1, value2, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andScytdzbNotBetween(String value1, String value2) {
            addCriterion("SCYTDZB not between", value1, value2, "scytdzb");
            return (Criteria) this;
        }

        public Criteria andKzpyrqIsNull() {
            addCriterion("KZPYRQ is null");
            return (Criteria) this;
        }

        public Criteria andKzpyrqIsNotNull() {
            addCriterion("KZPYRQ is not null");
            return (Criteria) this;
        }

        public Criteria andKzpyrqEqualTo(String value) {
            addCriterion("KZPYRQ =", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqNotEqualTo(String value) {
            addCriterion("KZPYRQ <>", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqGreaterThan(String value) {
            addCriterion("KZPYRQ >", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqGreaterThanOrEqualTo(String value) {
            addCriterion("KZPYRQ >=", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqLessThan(String value) {
            addCriterion("KZPYRQ <", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqLessThanOrEqualTo(String value) {
            addCriterion("KZPYRQ <=", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqLike(String value) {
            addCriterion("KZPYRQ like", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqNotLike(String value) {
            addCriterion("KZPYRQ not like", value, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqIn(List<String> values) {
            addCriterion("KZPYRQ in", values, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqNotIn(List<String> values) {
            addCriterion("KZPYRQ not in", values, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqBetween(String value1, String value2) {
            addCriterion("KZPYRQ between", value1, value2, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andKzpyrqNotBetween(String value1, String value2) {
            addCriterion("KZPYRQ not between", value1, value2, "kzpyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqIsNull() {
            addCriterion("JSPYRQ is null");
            return (Criteria) this;
        }

        public Criteria andJspyrqIsNotNull() {
            addCriterion("JSPYRQ is not null");
            return (Criteria) this;
        }

        public Criteria andJspyrqEqualTo(String value) {
            addCriterion("JSPYRQ =", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqNotEqualTo(String value) {
            addCriterion("JSPYRQ <>", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqGreaterThan(String value) {
            addCriterion("JSPYRQ >", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqGreaterThanOrEqualTo(String value) {
            addCriterion("JSPYRQ >=", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqLessThan(String value) {
            addCriterion("JSPYRQ <", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqLessThanOrEqualTo(String value) {
            addCriterion("JSPYRQ <=", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqLike(String value) {
            addCriterion("JSPYRQ like", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqNotLike(String value) {
            addCriterion("JSPYRQ not like", value, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqIn(List<String> values) {
            addCriterion("JSPYRQ in", values, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqNotIn(List<String> values) {
            addCriterion("JSPYRQ not in", values, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqBetween(String value1, String value2) {
            addCriterion("JSPYRQ between", value1, value2, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andJspyrqNotBetween(String value1, String value2) {
            addCriterion("JSPYRQ not between", value1, value2, "jspyrq");
            return (Criteria) this;
        }

        public Criteria andYl01IsNull() {
            addCriterion("YL01 is null");
            return (Criteria) this;
        }

        public Criteria andYl01IsNotNull() {
            addCriterion("YL01 is not null");
            return (Criteria) this;
        }

        public Criteria andYl01EqualTo(String value) {
            addCriterion("YL01 =", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01NotEqualTo(String value) {
            addCriterion("YL01 <>", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01GreaterThan(String value) {
            addCriterion("YL01 >", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01GreaterThanOrEqualTo(String value) {
            addCriterion("YL01 >=", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01LessThan(String value) {
            addCriterion("YL01 <", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01LessThanOrEqualTo(String value) {
            addCriterion("YL01 <=", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01Like(String value) {
            addCriterion("YL01 like", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01NotLike(String value) {
            addCriterion("YL01 not like", value, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01In(List<String> values) {
            addCriterion("YL01 in", values, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01NotIn(List<String> values) {
            addCriterion("YL01 not in", values, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01Between(String value1, String value2) {
            addCriterion("YL01 between", value1, value2, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl01NotBetween(String value1, String value2) {
            addCriterion("YL01 not between", value1, value2, "yl01");
            return (Criteria) this;
        }

        public Criteria andYl02IsNull() {
            addCriterion("YL02 is null");
            return (Criteria) this;
        }

        public Criteria andYl02IsNotNull() {
            addCriterion("YL02 is not null");
            return (Criteria) this;
        }

        public Criteria andYl02EqualTo(String value) {
            addCriterion("YL02 =", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02NotEqualTo(String value) {
            addCriterion("YL02 <>", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02GreaterThan(String value) {
            addCriterion("YL02 >", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02GreaterThanOrEqualTo(String value) {
            addCriterion("YL02 >=", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02LessThan(String value) {
            addCriterion("YL02 <", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02LessThanOrEqualTo(String value) {
            addCriterion("YL02 <=", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02Like(String value) {
            addCriterion("YL02 like", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02NotLike(String value) {
            addCriterion("YL02 not like", value, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02In(List<String> values) {
            addCriterion("YL02 in", values, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02NotIn(List<String> values) {
            addCriterion("YL02 not in", values, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02Between(String value1, String value2) {
            addCriterion("YL02 between", value1, value2, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl02NotBetween(String value1, String value2) {
            addCriterion("YL02 not between", value1, value2, "yl02");
            return (Criteria) this;
        }

        public Criteria andYl03IsNull() {
            addCriterion("YL03 is null");
            return (Criteria) this;
        }

        public Criteria andYl03IsNotNull() {
            addCriterion("YL03 is not null");
            return (Criteria) this;
        }

        public Criteria andYl03EqualTo(String value) {
            addCriterion("YL03 =", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03NotEqualTo(String value) {
            addCriterion("YL03 <>", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03GreaterThan(String value) {
            addCriterion("YL03 >", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03GreaterThanOrEqualTo(String value) {
            addCriterion("YL03 >=", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03LessThan(String value) {
            addCriterion("YL03 <", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03LessThanOrEqualTo(String value) {
            addCriterion("YL03 <=", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03Like(String value) {
            addCriterion("YL03 like", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03NotLike(String value) {
            addCriterion("YL03 not like", value, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03In(List<String> values) {
            addCriterion("YL03 in", values, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03NotIn(List<String> values) {
            addCriterion("YL03 not in", values, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03Between(String value1, String value2) {
            addCriterion("YL03 between", value1, value2, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl03NotBetween(String value1, String value2) {
            addCriterion("YL03 not between", value1, value2, "yl03");
            return (Criteria) this;
        }

        public Criteria andYl04IsNull() {
            addCriterion("YL04 is null");
            return (Criteria) this;
        }

        public Criteria andYl04IsNotNull() {
            addCriterion("YL04 is not null");
            return (Criteria) this;
        }

        public Criteria andYl04EqualTo(String value) {
            addCriterion("YL04 =", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotEqualTo(String value) {
            addCriterion("YL04 <>", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04GreaterThan(String value) {
            addCriterion("YL04 >", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04GreaterThanOrEqualTo(String value) {
            addCriterion("YL04 >=", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04LessThan(String value) {
            addCriterion("YL04 <", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04LessThanOrEqualTo(String value) {
            addCriterion("YL04 <=", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04Like(String value) {
            addCriterion("YL04 like", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotLike(String value) {
            addCriterion("YL04 not like", value, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04In(List<String> values) {
            addCriterion("YL04 in", values, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotIn(List<String> values) {
            addCriterion("YL04 not in", values, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04Between(String value1, String value2) {
            addCriterion("YL04 between", value1, value2, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl04NotBetween(String value1, String value2) {
            addCriterion("YL04 not between", value1, value2, "yl04");
            return (Criteria) this;
        }

        public Criteria andYl05IsNull() {
            addCriterion("YL05 is null");
            return (Criteria) this;
        }

        public Criteria andYl05IsNotNull() {
            addCriterion("YL05 is not null");
            return (Criteria) this;
        }

        public Criteria andYl05EqualTo(String value) {
            addCriterion("YL05 =", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05NotEqualTo(String value) {
            addCriterion("YL05 <>", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05GreaterThan(String value) {
            addCriterion("YL05 >", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05GreaterThanOrEqualTo(String value) {
            addCriterion("YL05 >=", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05LessThan(String value) {
            addCriterion("YL05 <", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05LessThanOrEqualTo(String value) {
            addCriterion("YL05 <=", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05Like(String value) {
            addCriterion("YL05 like", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05NotLike(String value) {
            addCriterion("YL05 not like", value, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05In(List<String> values) {
            addCriterion("YL05 in", values, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05NotIn(List<String> values) {
            addCriterion("YL05 not in", values, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05Between(String value1, String value2) {
            addCriterion("YL05 between", value1, value2, "yl05");
            return (Criteria) this;
        }

        public Criteria andYl05NotBetween(String value1, String value2) {
            addCriterion("YL05 not between", value1, value2, "yl05");
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