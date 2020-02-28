package com.suixiang.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisionExample() {
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

        public Criteria andAudioidIsNull() {
            addCriterion("audioId is null");
            return (Criteria) this;
        }

        public Criteria andAudioidIsNotNull() {
            addCriterion("audioId is not null");
            return (Criteria) this;
        }

        public Criteria andAudioidEqualTo(String value) {
            addCriterion("audioId =", value, "audioid");
            return (Criteria) this;
        }

        public Criteria andAudioidNotEqualTo(String value) {
            addCriterion("audioId <>", value, "audioid");
            return (Criteria) this;
        }

        public Criteria andAudioidGreaterThan(String value) {
            addCriterion("audioId >", value, "audioid");
            return (Criteria) this;
        }

        public Criteria andAudioidGreaterThanOrEqualTo(String value) {
            addCriterion("audioId >=", value, "audioid");
            return (Criteria) this;
        }

        public Criteria andAudioidLessThan(String value) {
            addCriterion("audioId <", value, "audioid");
            return (Criteria) this;
        }

        public Criteria andAudioidLessThanOrEqualTo(String value) {
            addCriterion("audioId <=", value, "audioid");
            return (Criteria) this;
        }

        public Criteria andAudioidLike(String value) {
            addCriterion("audioId like", value, "audioid");
            return (Criteria) this;
        }

        public Criteria andAudioidNotLike(String value) {
            addCriterion("audioId not like", value, "audioid");
            return (Criteria) this;
        }

        public Criteria andAudioidIn(List<String> values) {
            addCriterion("audioId in", values, "audioid");
            return (Criteria) this;
        }

        public Criteria andAudioidNotIn(List<String> values) {
            addCriterion("audioId not in", values, "audioid");
            return (Criteria) this;
        }

        public Criteria andAudioidBetween(String value1, String value2) {
            addCriterion("audioId between", value1, value2, "audioid");
            return (Criteria) this;
        }

        public Criteria andAudioidNotBetween(String value1, String value2) {
            addCriterion("audioId not between", value1, value2, "audioid");
            return (Criteria) this;
        }

        public Criteria andVisiondescIsNull() {
            addCriterion("visionDesc is null");
            return (Criteria) this;
        }

        public Criteria andVisiondescIsNotNull() {
            addCriterion("visionDesc is not null");
            return (Criteria) this;
        }

        public Criteria andVisiondescEqualTo(String value) {
            addCriterion("visionDesc =", value, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisiondescNotEqualTo(String value) {
            addCriterion("visionDesc <>", value, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisiondescGreaterThan(String value) {
            addCriterion("visionDesc >", value, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisiondescGreaterThanOrEqualTo(String value) {
            addCriterion("visionDesc >=", value, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisiondescLessThan(String value) {
            addCriterion("visionDesc <", value, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisiondescLessThanOrEqualTo(String value) {
            addCriterion("visionDesc <=", value, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisiondescLike(String value) {
            addCriterion("visionDesc like", value, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisiondescNotLike(String value) {
            addCriterion("visionDesc not like", value, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisiondescIn(List<String> values) {
            addCriterion("visionDesc in", values, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisiondescNotIn(List<String> values) {
            addCriterion("visionDesc not in", values, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisiondescBetween(String value1, String value2) {
            addCriterion("visionDesc between", value1, value2, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisiondescNotBetween(String value1, String value2) {
            addCriterion("visionDesc not between", value1, value2, "visiondesc");
            return (Criteria) this;
        }

        public Criteria andVisionpathIsNull() {
            addCriterion("visionPath is null");
            return (Criteria) this;
        }

        public Criteria andVisionpathIsNotNull() {
            addCriterion("visionPath is not null");
            return (Criteria) this;
        }

        public Criteria andVisionpathEqualTo(String value) {
            addCriterion("visionPath =", value, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionpathNotEqualTo(String value) {
            addCriterion("visionPath <>", value, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionpathGreaterThan(String value) {
            addCriterion("visionPath >", value, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionpathGreaterThanOrEqualTo(String value) {
            addCriterion("visionPath >=", value, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionpathLessThan(String value) {
            addCriterion("visionPath <", value, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionpathLessThanOrEqualTo(String value) {
            addCriterion("visionPath <=", value, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionpathLike(String value) {
            addCriterion("visionPath like", value, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionpathNotLike(String value) {
            addCriterion("visionPath not like", value, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionpathIn(List<String> values) {
            addCriterion("visionPath in", values, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionpathNotIn(List<String> values) {
            addCriterion("visionPath not in", values, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionpathBetween(String value1, String value2) {
            addCriterion("visionPath between", value1, value2, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionpathNotBetween(String value1, String value2) {
            addCriterion("visionPath not between", value1, value2, "visionpath");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsIsNull() {
            addCriterion("visionSeconds is null");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsIsNotNull() {
            addCriterion("visionSeconds is not null");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsEqualTo(Float value) {
            addCriterion("visionSeconds =", value, "visionseconds");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsNotEqualTo(Float value) {
            addCriterion("visionSeconds <>", value, "visionseconds");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsGreaterThan(Float value) {
            addCriterion("visionSeconds >", value, "visionseconds");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsGreaterThanOrEqualTo(Float value) {
            addCriterion("visionSeconds >=", value, "visionseconds");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsLessThan(Float value) {
            addCriterion("visionSeconds <", value, "visionseconds");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsLessThanOrEqualTo(Float value) {
            addCriterion("visionSeconds <=", value, "visionseconds");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsIn(List<Float> values) {
            addCriterion("visionSeconds in", values, "visionseconds");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsNotIn(List<Float> values) {
            addCriterion("visionSeconds not in", values, "visionseconds");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsBetween(Float value1, Float value2) {
            addCriterion("visionSeconds between", value1, value2, "visionseconds");
            return (Criteria) this;
        }

        public Criteria andVisionsecondsNotBetween(Float value1, Float value2) {
            addCriterion("visionSeconds not between", value1, value2, "visionseconds");
            return (Criteria) this;
        }

        public Criteria andVisionwidthIsNull() {
            addCriterion("visionWidth is null");
            return (Criteria) this;
        }

        public Criteria andVisionwidthIsNotNull() {
            addCriterion("visionWidth is not null");
            return (Criteria) this;
        }

        public Criteria andVisionwidthEqualTo(Integer value) {
            addCriterion("visionWidth =", value, "visionwidth");
            return (Criteria) this;
        }

        public Criteria andVisionwidthNotEqualTo(Integer value) {
            addCriterion("visionWidth <>", value, "visionwidth");
            return (Criteria) this;
        }

        public Criteria andVisionwidthGreaterThan(Integer value) {
            addCriterion("visionWidth >", value, "visionwidth");
            return (Criteria) this;
        }

        public Criteria andVisionwidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("visionWidth >=", value, "visionwidth");
            return (Criteria) this;
        }

        public Criteria andVisionwidthLessThan(Integer value) {
            addCriterion("visionWidth <", value, "visionwidth");
            return (Criteria) this;
        }

        public Criteria andVisionwidthLessThanOrEqualTo(Integer value) {
            addCriterion("visionWidth <=", value, "visionwidth");
            return (Criteria) this;
        }

        public Criteria andVisionwidthIn(List<Integer> values) {
            addCriterion("visionWidth in", values, "visionwidth");
            return (Criteria) this;
        }

        public Criteria andVisionwidthNotIn(List<Integer> values) {
            addCriterion("visionWidth not in", values, "visionwidth");
            return (Criteria) this;
        }

        public Criteria andVisionwidthBetween(Integer value1, Integer value2) {
            addCriterion("visionWidth between", value1, value2, "visionwidth");
            return (Criteria) this;
        }

        public Criteria andVisionwidthNotBetween(Integer value1, Integer value2) {
            addCriterion("visionWidth not between", value1, value2, "visionwidth");
            return (Criteria) this;
        }

        public Criteria andVisionheightIsNull() {
            addCriterion("visionHeight is null");
            return (Criteria) this;
        }

        public Criteria andVisionheightIsNotNull() {
            addCriterion("visionHeight is not null");
            return (Criteria) this;
        }

        public Criteria andVisionheightEqualTo(Integer value) {
            addCriterion("visionHeight =", value, "visionheight");
            return (Criteria) this;
        }

        public Criteria andVisionheightNotEqualTo(Integer value) {
            addCriterion("visionHeight <>", value, "visionheight");
            return (Criteria) this;
        }

        public Criteria andVisionheightGreaterThan(Integer value) {
            addCriterion("visionHeight >", value, "visionheight");
            return (Criteria) this;
        }

        public Criteria andVisionheightGreaterThanOrEqualTo(Integer value) {
            addCriterion("visionHeight >=", value, "visionheight");
            return (Criteria) this;
        }

        public Criteria andVisionheightLessThan(Integer value) {
            addCriterion("visionHeight <", value, "visionheight");
            return (Criteria) this;
        }

        public Criteria andVisionheightLessThanOrEqualTo(Integer value) {
            addCriterion("visionHeight <=", value, "visionheight");
            return (Criteria) this;
        }

        public Criteria andVisionheightIn(List<Integer> values) {
            addCriterion("visionHeight in", values, "visionheight");
            return (Criteria) this;
        }

        public Criteria andVisionheightNotIn(List<Integer> values) {
            addCriterion("visionHeight not in", values, "visionheight");
            return (Criteria) this;
        }

        public Criteria andVisionheightBetween(Integer value1, Integer value2) {
            addCriterion("visionHeight between", value1, value2, "visionheight");
            return (Criteria) this;
        }

        public Criteria andVisionheightNotBetween(Integer value1, Integer value2) {
            addCriterion("visionHeight not between", value1, value2, "visionheight");
            return (Criteria) this;
        }

        public Criteria andCoverpathIsNull() {
            addCriterion("coverPath is null");
            return (Criteria) this;
        }

        public Criteria andCoverpathIsNotNull() {
            addCriterion("coverPath is not null");
            return (Criteria) this;
        }

        public Criteria andCoverpathEqualTo(String value) {
            addCriterion("coverPath =", value, "coverpath");
            return (Criteria) this;
        }

        public Criteria andCoverpathNotEqualTo(String value) {
            addCriterion("coverPath <>", value, "coverpath");
            return (Criteria) this;
        }

        public Criteria andCoverpathGreaterThan(String value) {
            addCriterion("coverPath >", value, "coverpath");
            return (Criteria) this;
        }

        public Criteria andCoverpathGreaterThanOrEqualTo(String value) {
            addCriterion("coverPath >=", value, "coverpath");
            return (Criteria) this;
        }

        public Criteria andCoverpathLessThan(String value) {
            addCriterion("coverPath <", value, "coverpath");
            return (Criteria) this;
        }

        public Criteria andCoverpathLessThanOrEqualTo(String value) {
            addCriterion("coverPath <=", value, "coverpath");
            return (Criteria) this;
        }

        public Criteria andCoverpathLike(String value) {
            addCriterion("coverPath like", value, "coverpath");
            return (Criteria) this;
        }

        public Criteria andCoverpathNotLike(String value) {
            addCriterion("coverPath not like", value, "coverpath");
            return (Criteria) this;
        }

        public Criteria andCoverpathIn(List<String> values) {
            addCriterion("coverPath in", values, "coverpath");
            return (Criteria) this;
        }

        public Criteria andCoverpathNotIn(List<String> values) {
            addCriterion("coverPath not in", values, "coverpath");
            return (Criteria) this;
        }

        public Criteria andCoverpathBetween(String value1, String value2) {
            addCriterion("coverPath between", value1, value2, "coverpath");
            return (Criteria) this;
        }

        public Criteria andCoverpathNotBetween(String value1, String value2) {
            addCriterion("coverPath not between", value1, value2, "coverpath");
            return (Criteria) this;
        }

        public Criteria andLovecountIsNull() {
            addCriterion("loveCount is null");
            return (Criteria) this;
        }

        public Criteria andLovecountIsNotNull() {
            addCriterion("loveCount is not null");
            return (Criteria) this;
        }

        public Criteria andLovecountEqualTo(Long value) {
            addCriterion("loveCount =", value, "lovecount");
            return (Criteria) this;
        }

        public Criteria andLovecountNotEqualTo(Long value) {
            addCriterion("loveCount <>", value, "lovecount");
            return (Criteria) this;
        }

        public Criteria andLovecountGreaterThan(Long value) {
            addCriterion("loveCount >", value, "lovecount");
            return (Criteria) this;
        }

        public Criteria andLovecountGreaterThanOrEqualTo(Long value) {
            addCriterion("loveCount >=", value, "lovecount");
            return (Criteria) this;
        }

        public Criteria andLovecountLessThan(Long value) {
            addCriterion("loveCount <", value, "lovecount");
            return (Criteria) this;
        }

        public Criteria andLovecountLessThanOrEqualTo(Long value) {
            addCriterion("loveCount <=", value, "lovecount");
            return (Criteria) this;
        }

        public Criteria andLovecountIn(List<Long> values) {
            addCriterion("loveCount in", values, "lovecount");
            return (Criteria) this;
        }

        public Criteria andLovecountNotIn(List<Long> values) {
            addCriterion("loveCount not in", values, "lovecount");
            return (Criteria) this;
        }

        public Criteria andLovecountBetween(Long value1, Long value2) {
            addCriterion("loveCount between", value1, value2, "lovecount");
            return (Criteria) this;
        }

        public Criteria andLovecountNotBetween(Long value1, Long value2) {
            addCriterion("loveCount not between", value1, value2, "lovecount");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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