package com.holley.platform.model.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysNoticeExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSentUserIsNull() {
            addCriterion("SENT_USER is null");
            return (Criteria) this;
        }

        public Criteria andSentUserIsNotNull() {
            addCriterion("SENT_USER is not null");
            return (Criteria) this;
        }

        public Criteria andSentUserEqualTo(Integer value) {
            addCriterion("SENT_USER =", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserNotEqualTo(Integer value) {
            addCriterion("SENT_USER <>", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserGreaterThan(Integer value) {
            addCriterion("SENT_USER >", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("SENT_USER >=", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserLessThan(Integer value) {
            addCriterion("SENT_USER <", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserLessThanOrEqualTo(Integer value) {
            addCriterion("SENT_USER <=", value, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserIn(List<Integer> values) {
            addCriterion("SENT_USER in", values, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserNotIn(List<Integer> values) {
            addCriterion("SENT_USER not in", values, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserBetween(Integer value1, Integer value2) {
            addCriterion("SENT_USER between", value1, value2, "sentUser");
            return (Criteria) this;
        }

        public Criteria andSentUserNotBetween(Integer value1, Integer value2) {
            addCriterion("SENT_USER not between", value1, value2, "sentUser");
            return (Criteria) this;
        }

        public Criteria andReciveUserIsNull() {
            addCriterion("RECIVE_USER is null");
            return (Criteria) this;
        }

        public Criteria andReciveUserIsNotNull() {
            addCriterion("RECIVE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andReciveUserEqualTo(Integer value) {
            addCriterion("RECIVE_USER =", value, "reciveUser");
            return (Criteria) this;
        }

        public Criteria andReciveUserNotEqualTo(Integer value) {
            addCriterion("RECIVE_USER <>", value, "reciveUser");
            return (Criteria) this;
        }

        public Criteria andReciveUserGreaterThan(Integer value) {
            addCriterion("RECIVE_USER >", value, "reciveUser");
            return (Criteria) this;
        }

        public Criteria andReciveUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECIVE_USER >=", value, "reciveUser");
            return (Criteria) this;
        }

        public Criteria andReciveUserLessThan(Integer value) {
            addCriterion("RECIVE_USER <", value, "reciveUser");
            return (Criteria) this;
        }

        public Criteria andReciveUserLessThanOrEqualTo(Integer value) {
            addCriterion("RECIVE_USER <=", value, "reciveUser");
            return (Criteria) this;
        }

        public Criteria andReciveUserIn(List<Integer> values) {
            addCriterion("RECIVE_USER in", values, "reciveUser");
            return (Criteria) this;
        }

        public Criteria andReciveUserNotIn(List<Integer> values) {
            addCriterion("RECIVE_USER not in", values, "reciveUser");
            return (Criteria) this;
        }

        public Criteria andReciveUserBetween(Integer value1, Integer value2) {
            addCriterion("RECIVE_USER between", value1, value2, "reciveUser");
            return (Criteria) this;
        }

        public Criteria andReciveUserNotBetween(Integer value1, Integer value2) {
            addCriterion("RECIVE_USER not between", value1, value2, "reciveUser");
            return (Criteria) this;
        }

        public Criteria andMessageidIsNull() {
            addCriterion("MESSAGEID is null");
            return (Criteria) this;
        }

        public Criteria andMessageidIsNotNull() {
            addCriterion("MESSAGEID is not null");
            return (Criteria) this;
        }

        public Criteria andMessageidEqualTo(Integer value) {
            addCriterion("MESSAGEID =", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotEqualTo(Integer value) {
            addCriterion("MESSAGEID <>", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThan(Integer value) {
            addCriterion("MESSAGEID >", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MESSAGEID >=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThan(Integer value) {
            addCriterion("MESSAGEID <", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThanOrEqualTo(Integer value) {
            addCriterion("MESSAGEID <=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidIn(List<Integer> values) {
            addCriterion("MESSAGEID in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotIn(List<Integer> values) {
            addCriterion("MESSAGEID not in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidBetween(Integer value1, Integer value2) {
            addCriterion("MESSAGEID between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotBetween(Integer value1, Integer value2) {
            addCriterion("MESSAGEID not between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNull() {
            addCriterion("IS_READ is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("IS_READ is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(Short value) {
            addCriterion("IS_READ =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(Short value) {
            addCriterion("IS_READ <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(Short value) {
            addCriterion("IS_READ >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_READ >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(Short value) {
            addCriterion("IS_READ <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(Short value) {
            addCriterion("IS_READ <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(List<Short> values) {
            addCriterion("IS_READ in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(List<Short> values) {
            addCriterion("IS_READ not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(Short value1, Short value2) {
            addCriterion("IS_READ between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(Short value1, Short value2) {
            addCriterion("IS_READ not between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("SEND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("SEND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("SEND_TIME =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("SEND_TIME <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("SEND_TIME >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("SEND_TIME <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("SEND_TIME in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("SEND_TIME not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME not between", value1, value2, "sendTime");
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