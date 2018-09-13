package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusCardRechargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusCardRechargeExample() {
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

        public Criteria andTradeNoIsNull() {
            addCriterion("TRADE_NO is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("TRADE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("TRADE_NO =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("TRADE_NO <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("TRADE_NO >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE_NO >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("TRADE_NO <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("TRADE_NO <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("TRADE_NO like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("TRADE_NO not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("TRADE_NO in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("TRADE_NO not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("TRADE_NO between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("TRADE_NO not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdIsNull() {
            addCriterion("CARD_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdIsNotNull() {
            addCriterion("CARD_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdEqualTo(Integer value) {
            addCriterion("CARD_INFO_ID =", value, "cardInfoId");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdNotEqualTo(Integer value) {
            addCriterion("CARD_INFO_ID <>", value, "cardInfoId");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdGreaterThan(Integer value) {
            addCriterion("CARD_INFO_ID >", value, "cardInfoId");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CARD_INFO_ID >=", value, "cardInfoId");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdLessThan(Integer value) {
            addCriterion("CARD_INFO_ID <", value, "cardInfoId");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("CARD_INFO_ID <=", value, "cardInfoId");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdIn(List<Integer> values) {
            addCriterion("CARD_INFO_ID in", values, "cardInfoId");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdNotIn(List<Integer> values) {
            addCriterion("CARD_INFO_ID not in", values, "cardInfoId");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("CARD_INFO_ID between", value1, value2, "cardInfoId");
            return (Criteria) this;
        }

        public Criteria andCardInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CARD_INFO_ID not between", value1, value2, "cardInfoId");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("MONEY is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("MONEY =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("MONEY <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("MONEY >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("MONEY <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andWorkerIsNull() {
            addCriterion("WORKER is null");
            return (Criteria) this;
        }

        public Criteria andWorkerIsNotNull() {
            addCriterion("WORKER is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerEqualTo(Integer value) {
            addCriterion("WORKER =", value, "worker");
            return (Criteria) this;
        }

        public Criteria andWorkerNotEqualTo(Integer value) {
            addCriterion("WORKER <>", value, "worker");
            return (Criteria) this;
        }

        public Criteria andWorkerGreaterThan(Integer value) {
            addCriterion("WORKER >", value, "worker");
            return (Criteria) this;
        }

        public Criteria andWorkerGreaterThanOrEqualTo(Integer value) {
            addCriterion("WORKER >=", value, "worker");
            return (Criteria) this;
        }

        public Criteria andWorkerLessThan(Integer value) {
            addCriterion("WORKER <", value, "worker");
            return (Criteria) this;
        }

        public Criteria andWorkerLessThanOrEqualTo(Integer value) {
            addCriterion("WORKER <=", value, "worker");
            return (Criteria) this;
        }

        public Criteria andWorkerIn(List<Integer> values) {
            addCriterion("WORKER in", values, "worker");
            return (Criteria) this;
        }

        public Criteria andWorkerNotIn(List<Integer> values) {
            addCriterion("WORKER not in", values, "worker");
            return (Criteria) this;
        }

        public Criteria andWorkerBetween(Integer value1, Integer value2) {
            addCriterion("WORKER between", value1, value2, "worker");
            return (Criteria) this;
        }

        public Criteria andWorkerNotBetween(Integer value1, Integer value2) {
            addCriterion("WORKER not between", value1, value2, "worker");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("ADD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("ADD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("ADD_TIME =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("ADD_TIME <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("ADD_TIME >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ADD_TIME >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("ADD_TIME <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("ADD_TIME <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("ADD_TIME in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("ADD_TIME not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("ADD_TIME between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("ADD_TIME not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddIpIsNull() {
            addCriterion("ADD_IP is null");
            return (Criteria) this;
        }

        public Criteria andAddIpIsNotNull() {
            addCriterion("ADD_IP is not null");
            return (Criteria) this;
        }

        public Criteria andAddIpEqualTo(String value) {
            addCriterion("ADD_IP =", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotEqualTo(String value) {
            addCriterion("ADD_IP <>", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpGreaterThan(String value) {
            addCriterion("ADD_IP >", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpGreaterThanOrEqualTo(String value) {
            addCriterion("ADD_IP >=", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpLessThan(String value) {
            addCriterion("ADD_IP <", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpLessThanOrEqualTo(String value) {
            addCriterion("ADD_IP <=", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpLike(String value) {
            addCriterion("ADD_IP like", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotLike(String value) {
            addCriterion("ADD_IP not like", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpIn(List<String> values) {
            addCriterion("ADD_IP in", values, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotIn(List<String> values) {
            addCriterion("ADD_IP not in", values, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpBetween(String value1, String value2) {
            addCriterion("ADD_IP between", value1, value2, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotBetween(String value1, String value2) {
            addCriterion("ADD_IP not between", value1, value2, "addIp");
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