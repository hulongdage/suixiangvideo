package com.suixiang.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andFcommentidIsNull() {
            addCriterion("fCommentId is null");
            return (Criteria) this;
        }

        public Criteria andFcommentidIsNotNull() {
            addCriterion("fCommentId is not null");
            return (Criteria) this;
        }

        public Criteria andFcommentidEqualTo(String value) {
            addCriterion("fCommentId =", value, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andFcommentidNotEqualTo(String value) {
            addCriterion("fCommentId <>", value, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andFcommentidGreaterThan(String value) {
            addCriterion("fCommentId >", value, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andFcommentidGreaterThanOrEqualTo(String value) {
            addCriterion("fCommentId >=", value, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andFcommentidLessThan(String value) {
            addCriterion("fCommentId <", value, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andFcommentidLessThanOrEqualTo(String value) {
            addCriterion("fCommentId <=", value, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andFcommentidLike(String value) {
            addCriterion("fCommentId like", value, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andFcommentidNotLike(String value) {
            addCriterion("fCommentId not like", value, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andFcommentidIn(List<String> values) {
            addCriterion("fCommentId in", values, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andFcommentidNotIn(List<String> values) {
            addCriterion("fCommentId not in", values, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andFcommentidBetween(String value1, String value2) {
            addCriterion("fCommentId between", value1, value2, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andFcommentidNotBetween(String value1, String value2) {
            addCriterion("fCommentId not between", value1, value2, "fcommentid");
            return (Criteria) this;
        }

        public Criteria andTouseridIsNull() {
            addCriterion("toUserId is null");
            return (Criteria) this;
        }

        public Criteria andTouseridIsNotNull() {
            addCriterion("toUserId is not null");
            return (Criteria) this;
        }

        public Criteria andTouseridEqualTo(String value) {
            addCriterion("toUserId =", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridNotEqualTo(String value) {
            addCriterion("toUserId <>", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridGreaterThan(String value) {
            addCriterion("toUserId >", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridGreaterThanOrEqualTo(String value) {
            addCriterion("toUserId >=", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridLessThan(String value) {
            addCriterion("toUserId <", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridLessThanOrEqualTo(String value) {
            addCriterion("toUserId <=", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridLike(String value) {
            addCriterion("toUserId like", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridNotLike(String value) {
            addCriterion("toUserId not like", value, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridIn(List<String> values) {
            addCriterion("toUserId in", values, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridNotIn(List<String> values) {
            addCriterion("toUserId not in", values, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridBetween(String value1, String value2) {
            addCriterion("toUserId between", value1, value2, "touserid");
            return (Criteria) this;
        }

        public Criteria andTouseridNotBetween(String value1, String value2) {
            addCriterion("toUserId not between", value1, value2, "touserid");
            return (Criteria) this;
        }

        public Criteria andVisionidIsNull() {
            addCriterion("visionId is null");
            return (Criteria) this;
        }

        public Criteria andVisionidIsNotNull() {
            addCriterion("visionId is not null");
            return (Criteria) this;
        }

        public Criteria andVisionidEqualTo(String value) {
            addCriterion("visionId =", value, "visionid");
            return (Criteria) this;
        }

        public Criteria andVisionidNotEqualTo(String value) {
            addCriterion("visionId <>", value, "visionid");
            return (Criteria) this;
        }

        public Criteria andVisionidGreaterThan(String value) {
            addCriterion("visionId >", value, "visionid");
            return (Criteria) this;
        }

        public Criteria andVisionidGreaterThanOrEqualTo(String value) {
            addCriterion("visionId >=", value, "visionid");
            return (Criteria) this;
        }

        public Criteria andVisionidLessThan(String value) {
            addCriterion("visionId <", value, "visionid");
            return (Criteria) this;
        }

        public Criteria andVisionidLessThanOrEqualTo(String value) {
            addCriterion("visionId <=", value, "visionid");
            return (Criteria) this;
        }

        public Criteria andVisionidLike(String value) {
            addCriterion("visionId like", value, "visionid");
            return (Criteria) this;
        }

        public Criteria andVisionidNotLike(String value) {
            addCriterion("visionId not like", value, "visionid");
            return (Criteria) this;
        }

        public Criteria andVisionidIn(List<String> values) {
            addCriterion("visionId in", values, "visionid");
            return (Criteria) this;
        }

        public Criteria andVisionidNotIn(List<String> values) {
            addCriterion("visionId not in", values, "visionid");
            return (Criteria) this;
        }

        public Criteria andVisionidBetween(String value1, String value2) {
            addCriterion("visionId between", value1, value2, "visionid");
            return (Criteria) this;
        }

        public Criteria andVisionidNotBetween(String value1, String value2) {
            addCriterion("visionId not between", value1, value2, "visionid");
            return (Criteria) this;
        }

        public Criteria andFromuseridIsNull() {
            addCriterion("fromUserId is null");
            return (Criteria) this;
        }

        public Criteria andFromuseridIsNotNull() {
            addCriterion("fromUserId is not null");
            return (Criteria) this;
        }

        public Criteria andFromuseridEqualTo(String value) {
            addCriterion("fromUserId =", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridNotEqualTo(String value) {
            addCriterion("fromUserId <>", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridGreaterThan(String value) {
            addCriterion("fromUserId >", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridGreaterThanOrEqualTo(String value) {
            addCriterion("fromUserId >=", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridLessThan(String value) {
            addCriterion("fromUserId <", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridLessThanOrEqualTo(String value) {
            addCriterion("fromUserId <=", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridLike(String value) {
            addCriterion("fromUserId like", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridNotLike(String value) {
            addCriterion("fromUserId not like", value, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridIn(List<String> values) {
            addCriterion("fromUserId in", values, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridNotIn(List<String> values) {
            addCriterion("fromUserId not in", values, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridBetween(String value1, String value2) {
            addCriterion("fromUserId between", value1, value2, "fromuserid");
            return (Criteria) this;
        }

        public Criteria andFromuseridNotBetween(String value1, String value2) {
            addCriterion("fromUserId not between", value1, value2, "fromuserid");
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