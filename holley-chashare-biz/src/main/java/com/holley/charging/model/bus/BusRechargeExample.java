package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusRechargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusRechargeExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
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

        public Criteria andPayWayIsNull() {
            addCriterion("PAY_WAY is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNotNull() {
            addCriterion("PAY_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayEqualTo(Short value) {
            addCriterion("PAY_WAY =", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotEqualTo(Short value) {
            addCriterion("PAY_WAY <>", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThan(Short value) {
            addCriterion("PAY_WAY >", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThanOrEqualTo(Short value) {
            addCriterion("PAY_WAY >=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThan(Short value) {
            addCriterion("PAY_WAY <", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThanOrEqualTo(Short value) {
            addCriterion("PAY_WAY <=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayIn(List<Short> values) {
            addCriterion("PAY_WAY in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotIn(List<Short> values) {
            addCriterion("PAY_WAY not in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayBetween(Short value1, Short value2) {
            addCriterion("PAY_WAY between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotBetween(Short value1, Short value2) {
            addCriterion("PAY_WAY not between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andAccountInfoIsNull() {
            addCriterion("ACCOUNT_INFO is null");
            return (Criteria) this;
        }

        public Criteria andAccountInfoIsNotNull() {
            addCriterion("ACCOUNT_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andAccountInfoEqualTo(String value) {
            addCriterion("ACCOUNT_INFO =", value, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andAccountInfoNotEqualTo(String value) {
            addCriterion("ACCOUNT_INFO <>", value, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andAccountInfoGreaterThan(String value) {
            addCriterion("ACCOUNT_INFO >", value, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andAccountInfoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_INFO >=", value, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andAccountInfoLessThan(String value) {
            addCriterion("ACCOUNT_INFO <", value, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andAccountInfoLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_INFO <=", value, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andAccountInfoLike(String value) {
            addCriterion("ACCOUNT_INFO like", value, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andAccountInfoNotLike(String value) {
            addCriterion("ACCOUNT_INFO not like", value, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andAccountInfoIn(List<String> values) {
            addCriterion("ACCOUNT_INFO in", values, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andAccountInfoNotIn(List<String> values) {
            addCriterion("ACCOUNT_INFO not in", values, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andAccountInfoBetween(String value1, String value2) {
            addCriterion("ACCOUNT_INFO between", value1, value2, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andAccountInfoNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_INFO not between", value1, value2, "accountInfo");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("FEE is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(BigDecimal value) {
            addCriterion("FEE =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(BigDecimal value) {
            addCriterion("FEE <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(BigDecimal value) {
            addCriterion("FEE >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(BigDecimal value) {
            addCriterion("FEE <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<BigDecimal> values) {
            addCriterion("FEE in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<BigDecimal> values) {
            addCriterion("FEE not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE not between", value1, value2, "fee");
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