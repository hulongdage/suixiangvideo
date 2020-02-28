package com.suixiang.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportNodesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportNodesExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReportuseridIsNull() {
            addCriterion("reportUserId is null");
            return (Criteria) this;
        }

        public Criteria andReportuseridIsNotNull() {
            addCriterion("reportUserId is not null");
            return (Criteria) this;
        }

        public Criteria andReportuseridEqualTo(String value) {
            addCriterion("reportUserId =", value, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportuseridNotEqualTo(String value) {
            addCriterion("reportUserId <>", value, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportuseridGreaterThan(String value) {
            addCriterion("reportUserId >", value, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportuseridGreaterThanOrEqualTo(String value) {
            addCriterion("reportUserId >=", value, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportuseridLessThan(String value) {
            addCriterion("reportUserId <", value, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportuseridLessThanOrEqualTo(String value) {
            addCriterion("reportUserId <=", value, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportuseridLike(String value) {
            addCriterion("reportUserId like", value, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportuseridNotLike(String value) {
            addCriterion("reportUserId not like", value, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportuseridIn(List<String> values) {
            addCriterion("reportUserId in", values, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportuseridNotIn(List<String> values) {
            addCriterion("reportUserId not in", values, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportuseridBetween(String value1, String value2) {
            addCriterion("reportUserId between", value1, value2, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportuseridNotBetween(String value1, String value2) {
            addCriterion("reportUserId not between", value1, value2, "reportuserid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidIsNull() {
            addCriterion("reportVisionId is null");
            return (Criteria) this;
        }

        public Criteria andReportvisionidIsNotNull() {
            addCriterion("reportVisionId is not null");
            return (Criteria) this;
        }

        public Criteria andReportvisionidEqualTo(String value) {
            addCriterion("reportVisionId =", value, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidNotEqualTo(String value) {
            addCriterion("reportVisionId <>", value, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidGreaterThan(String value) {
            addCriterion("reportVisionId >", value, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidGreaterThanOrEqualTo(String value) {
            addCriterion("reportVisionId >=", value, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidLessThan(String value) {
            addCriterion("reportVisionId <", value, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidLessThanOrEqualTo(String value) {
            addCriterion("reportVisionId <=", value, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidLike(String value) {
            addCriterion("reportVisionId like", value, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidNotLike(String value) {
            addCriterion("reportVisionId not like", value, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidIn(List<String> values) {
            addCriterion("reportVisionId in", values, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidNotIn(List<String> values) {
            addCriterion("reportVisionId not in", values, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidBetween(String value1, String value2) {
            addCriterion("reportVisionId between", value1, value2, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReportvisionidNotBetween(String value1, String value2) {
            addCriterion("reportVisionId not between", value1, value2, "reportvisionid");
            return (Criteria) this;
        }

        public Criteria andReporttitleIsNull() {
            addCriterion("reportTitle is null");
            return (Criteria) this;
        }

        public Criteria andReporttitleIsNotNull() {
            addCriterion("reportTitle is not null");
            return (Criteria) this;
        }

        public Criteria andReporttitleEqualTo(String value) {
            addCriterion("reportTitle =", value, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReporttitleNotEqualTo(String value) {
            addCriterion("reportTitle <>", value, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReporttitleGreaterThan(String value) {
            addCriterion("reportTitle >", value, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReporttitleGreaterThanOrEqualTo(String value) {
            addCriterion("reportTitle >=", value, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReporttitleLessThan(String value) {
            addCriterion("reportTitle <", value, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReporttitleLessThanOrEqualTo(String value) {
            addCriterion("reportTitle <=", value, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReporttitleLike(String value) {
            addCriterion("reportTitle like", value, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReporttitleNotLike(String value) {
            addCriterion("reportTitle not like", value, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReporttitleIn(List<String> values) {
            addCriterion("reportTitle in", values, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReporttitleNotIn(List<String> values) {
            addCriterion("reportTitle not in", values, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReporttitleBetween(String value1, String value2) {
            addCriterion("reportTitle between", value1, value2, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReporttitleNotBetween(String value1, String value2) {
            addCriterion("reportTitle not between", value1, value2, "reporttitle");
            return (Criteria) this;
        }

        public Criteria andReportcontentIsNull() {
            addCriterion("reportContent is null");
            return (Criteria) this;
        }

        public Criteria andReportcontentIsNotNull() {
            addCriterion("reportContent is not null");
            return (Criteria) this;
        }

        public Criteria andReportcontentEqualTo(String value) {
            addCriterion("reportContent =", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentNotEqualTo(String value) {
            addCriterion("reportContent <>", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentGreaterThan(String value) {
            addCriterion("reportContent >", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentGreaterThanOrEqualTo(String value) {
            addCriterion("reportContent >=", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentLessThan(String value) {
            addCriterion("reportContent <", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentLessThanOrEqualTo(String value) {
            addCriterion("reportContent <=", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentLike(String value) {
            addCriterion("reportContent like", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentNotLike(String value) {
            addCriterion("reportContent not like", value, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentIn(List<String> values) {
            addCriterion("reportContent in", values, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentNotIn(List<String> values) {
            addCriterion("reportContent not in", values, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentBetween(String value1, String value2) {
            addCriterion("reportContent between", value1, value2, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andReportcontentNotBetween(String value1, String value2) {
            addCriterion("reportContent not between", value1, value2, "reportcontent");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNull() {
            addCriterion("creatTime is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("creatTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(Date value) {
            addCriterion("creatTime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterion("creatTime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterion("creatTime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creatTime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterion("creatTime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("creatTime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterion("creatTime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterion("creatTime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterion("creatTime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("creatTime not between", value1, value2, "creattime");
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