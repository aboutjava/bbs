package com.fun.bbs.dao.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 帖子回复表条件 */
public class ReplyExample {
    /** 排序语句 */
    protected String orderByClause;

    /** 过滤相同行 */
    protected boolean distinct;

    /** oredCriteria */
    protected List<Criteria> oredCriteria;

    /** 跳过指定行数 */
    private Integer skipRowCount;

    /** 取得指定行数 */
    private Integer takeRowCount = 20;

    /** 创建 帖子回复表条件 */
    public ReplyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /** 设置“排序语句” */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** 取得“排序语句” */
    public String getOrderByClause() {
        return orderByClause;
    }

    /** 设置“过滤相同行” */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /** isDistinct */
    public boolean isDistinct() {
        return distinct;
    }

    /** getOredCriteria */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /** or */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /** or */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /** createCriteria */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /** createCriteriaInternal */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /** clear */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /** 取得“跳过指定行数” */
    public Integer getSkipRowCount() {
        return this.skipRowCount;
    }

    /** 设置“跳过指定行数” */
    public void setSkipRowCount(Integer skipRowCount) {
        this.skipRowCount = skipRowCount;
    }

    /** 取得“取得指定行数” */
    public Integer getTakeRowCount() {
        return this.takeRowCount;
    }

    /** 设置“取得指定行数” */
    public void setTakeRowCount(Integer takeRowCount) {
        if (this.skipRowCount == null) this.skipRowCount = 0;
        this.takeRowCount = takeRowCount;
    }

    /** GeneratedCriteria */
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNull() {
            addCriterion("post_id is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("post_id is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(Integer value) {
            addCriterion("post_id =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(Integer value) {
            addCriterion("post_id <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(Integer value) {
            addCriterion("post_id >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_id >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(Integer value) {
            addCriterion("post_id <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(Integer value) {
            addCriterion("post_id <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<Integer> values) {
            addCriterion("post_id in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<Integer> values) {
            addCriterion("post_id not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(Integer value1, Integer value2) {
            addCriterion("post_id between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(Integer value1, Integer value2) {
            addCriterion("post_id not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andReplierIdIsNull() {
            addCriterion("replier_id is null");
            return (Criteria) this;
        }

        public Criteria andReplierIdIsNotNull() {
            addCriterion("replier_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplierIdEqualTo(Integer value) {
            addCriterion("replier_id =", value, "replierId");
            return (Criteria) this;
        }

        public Criteria andReplierIdNotEqualTo(Integer value) {
            addCriterion("replier_id <>", value, "replierId");
            return (Criteria) this;
        }

        public Criteria andReplierIdGreaterThan(Integer value) {
            addCriterion("replier_id >", value, "replierId");
            return (Criteria) this;
        }

        public Criteria andReplierIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("replier_id >=", value, "replierId");
            return (Criteria) this;
        }

        public Criteria andReplierIdLessThan(Integer value) {
            addCriterion("replier_id <", value, "replierId");
            return (Criteria) this;
        }

        public Criteria andReplierIdLessThanOrEqualTo(Integer value) {
            addCriterion("replier_id <=", value, "replierId");
            return (Criteria) this;
        }

        public Criteria andReplierIdIn(List<Integer> values) {
            addCriterion("replier_id in", values, "replierId");
            return (Criteria) this;
        }

        public Criteria andReplierIdNotIn(List<Integer> values) {
            addCriterion("replier_id not in", values, "replierId");
            return (Criteria) this;
        }

        public Criteria andReplierIdBetween(Integer value1, Integer value2) {
            addCriterion("replier_id between", value1, value2, "replierId");
            return (Criteria) this;
        }

        public Criteria andReplierIdNotBetween(Integer value1, Integer value2) {
            addCriterion("replier_id not between", value1, value2, "replierId");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNull() {
            addCriterion("reply_time is null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNotNull() {
            addCriterion("reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeEqualTo(Date value) {
            addCriterion("reply_time =", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotEqualTo(Date value) {
            addCriterion("reply_time <>", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThan(Date value) {
            addCriterion("reply_time >", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_time >=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThan(Date value) {
            addCriterion("reply_time <", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_time <=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIn(List<Date> values) {
            addCriterion("reply_time in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotIn(List<Date> values) {
            addCriterion("reply_time not in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeBetween(Date value1, Date value2) {
            addCriterion("reply_time between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_time not between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeIsNull() {
            addCriterion("reply_update_time is null");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeIsNotNull() {
            addCriterion("reply_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeEqualTo(Date value) {
            addCriterion("reply_update_time =", value, "replyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeNotEqualTo(Date value) {
            addCriterion("reply_update_time <>", value, "replyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeGreaterThan(Date value) {
            addCriterion("reply_update_time >", value, "replyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_update_time >=", value, "replyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeLessThan(Date value) {
            addCriterion("reply_update_time <", value, "replyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_update_time <=", value, "replyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeIn(List<Date> values) {
            addCriterion("reply_update_time in", values, "replyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeNotIn(List<Date> values) {
            addCriterion("reply_update_time not in", values, "replyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("reply_update_time between", value1, value2, "replyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andReplyUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_update_time not between", value1, value2, "replyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }
    }

    /** Criteria */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /** Criterion */
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