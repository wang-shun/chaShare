package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusPaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusPaymentExample() {
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

        public Criteria andPileIdIsNull() {
            addCriterion("PILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPileIdIsNotNull() {
            addCriterion("PILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPileIdEqualTo(Integer value) {
            addCriterion("PILE_ID =", value, "pileId");
            return (Criteria) this;
        }

        public Criteria andPileIdNotEqualTo(Integer value) {
            addCriterion("PILE_ID <>", value, "pileId");
            return (Criteria) this;
        }

        public Criteria andPileIdGreaterThan(Integer value) {
            addCriterion("PILE_ID >", value, "pileId");
            return (Criteria) this;
        }

        public Criteria andPileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PILE_ID >=", value, "pileId");
            return (Criteria) this;
        }

        public Criteria andPileIdLessThan(Integer value) {
            addCriterion("PILE_ID <", value, "pileId");
            return (Criteria) this;
        }

        public Criteria andPileIdLessThanOrEqualTo(Integer value) {
            addCriterion("PILE_ID <=", value, "pileId");
            return (Criteria) this;
        }

        public Criteria andPileIdIn(List<Integer> values) {
            addCriterion("PILE_ID in", values, "pileId");
            return (Criteria) this;
        }

        public Criteria andPileIdNotIn(List<Integer> values) {
            addCriterion("PILE_ID not in", values, "pileId");
            return (Criteria) this;
        }

        public Criteria andPileIdBetween(Integer value1, Integer value2) {
            addCriterion("PILE_ID between", value1, value2, "pileId");
            return (Criteria) this;
        }

        public Criteria andPileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PILE_ID not between", value1, value2, "pileId");
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

        public Criteria andChaModeIsNull() {
            addCriterion("CHA_MODE is null");
            return (Criteria) this;
        }

        public Criteria andChaModeIsNotNull() {
            addCriterion("CHA_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andChaModeEqualTo(Short value) {
            addCriterion("CHA_MODE =", value, "chaMode");
            return (Criteria) this;
        }

        public Criteria andChaModeNotEqualTo(Short value) {
            addCriterion("CHA_MODE <>", value, "chaMode");
            return (Criteria) this;
        }

        public Criteria andChaModeGreaterThan(Short value) {
            addCriterion("CHA_MODE >", value, "chaMode");
            return (Criteria) this;
        }

        public Criteria andChaModeGreaterThanOrEqualTo(Short value) {
            addCriterion("CHA_MODE >=", value, "chaMode");
            return (Criteria) this;
        }

        public Criteria andChaModeLessThan(Short value) {
            addCriterion("CHA_MODE <", value, "chaMode");
            return (Criteria) this;
        }

        public Criteria andChaModeLessThanOrEqualTo(Short value) {
            addCriterion("CHA_MODE <=", value, "chaMode");
            return (Criteria) this;
        }

        public Criteria andChaModeIn(List<Short> values) {
            addCriterion("CHA_MODE in", values, "chaMode");
            return (Criteria) this;
        }

        public Criteria andChaModeNotIn(List<Short> values) {
            addCriterion("CHA_MODE not in", values, "chaMode");
            return (Criteria) this;
        }

        public Criteria andChaModeBetween(Short value1, Short value2) {
            addCriterion("CHA_MODE between", value1, value2, "chaMode");
            return (Criteria) this;
        }

        public Criteria andChaModeNotBetween(Short value1, Short value2) {
            addCriterion("CHA_MODE not between", value1, value2, "chaMode");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNull() {
            addCriterion("DEAL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNotNull() {
            addCriterion("DEAL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDealStatusEqualTo(Short value) {
            addCriterion("DEAL_STATUS =", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotEqualTo(Short value) {
            addCriterion("DEAL_STATUS <>", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThan(Short value) {
            addCriterion("DEAL_STATUS >", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("DEAL_STATUS >=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThan(Short value) {
            addCriterion("DEAL_STATUS <", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThanOrEqualTo(Short value) {
            addCriterion("DEAL_STATUS <=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusIn(List<Short> values) {
            addCriterion("DEAL_STATUS in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotIn(List<Short> values) {
            addCriterion("DEAL_STATUS not in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusBetween(Short value1, Short value2) {
            addCriterion("DEAL_STATUS between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotBetween(Short value1, Short value2) {
            addCriterion("DEAL_STATUS not between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andParkFeeIsNull() {
            addCriterion("PARK_FEE is null");
            return (Criteria) this;
        }

        public Criteria andParkFeeIsNotNull() {
            addCriterion("PARK_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andParkFeeEqualTo(BigDecimal value) {
            addCriterion("PARK_FEE =", value, "parkFee");
            return (Criteria) this;
        }

        public Criteria andParkFeeNotEqualTo(BigDecimal value) {
            addCriterion("PARK_FEE <>", value, "parkFee");
            return (Criteria) this;
        }

        public Criteria andParkFeeGreaterThan(BigDecimal value) {
            addCriterion("PARK_FEE >", value, "parkFee");
            return (Criteria) this;
        }

        public Criteria andParkFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PARK_FEE >=", value, "parkFee");
            return (Criteria) this;
        }

        public Criteria andParkFeeLessThan(BigDecimal value) {
            addCriterion("PARK_FEE <", value, "parkFee");
            return (Criteria) this;
        }

        public Criteria andParkFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PARK_FEE <=", value, "parkFee");
            return (Criteria) this;
        }

        public Criteria andParkFeeIn(List<BigDecimal> values) {
            addCriterion("PARK_FEE in", values, "parkFee");
            return (Criteria) this;
        }

        public Criteria andParkFeeNotIn(List<BigDecimal> values) {
            addCriterion("PARK_FEE not in", values, "parkFee");
            return (Criteria) this;
        }

        public Criteria andParkFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PARK_FEE between", value1, value2, "parkFee");
            return (Criteria) this;
        }

        public Criteria andParkFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PARK_FEE not between", value1, value2, "parkFee");
            return (Criteria) this;
        }

        public Criteria andChaFeeIsNull() {
            addCriterion("CHA_FEE is null");
            return (Criteria) this;
        }

        public Criteria andChaFeeIsNotNull() {
            addCriterion("CHA_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andChaFeeEqualTo(BigDecimal value) {
            addCriterion("CHA_FEE =", value, "chaFee");
            return (Criteria) this;
        }

        public Criteria andChaFeeNotEqualTo(BigDecimal value) {
            addCriterion("CHA_FEE <>", value, "chaFee");
            return (Criteria) this;
        }

        public Criteria andChaFeeGreaterThan(BigDecimal value) {
            addCriterion("CHA_FEE >", value, "chaFee");
            return (Criteria) this;
        }

        public Criteria andChaFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHA_FEE >=", value, "chaFee");
            return (Criteria) this;
        }

        public Criteria andChaFeeLessThan(BigDecimal value) {
            addCriterion("CHA_FEE <", value, "chaFee");
            return (Criteria) this;
        }

        public Criteria andChaFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHA_FEE <=", value, "chaFee");
            return (Criteria) this;
        }

        public Criteria andChaFeeIn(List<BigDecimal> values) {
            addCriterion("CHA_FEE in", values, "chaFee");
            return (Criteria) this;
        }

        public Criteria andChaFeeNotIn(List<BigDecimal> values) {
            addCriterion("CHA_FEE not in", values, "chaFee");
            return (Criteria) this;
        }

        public Criteria andChaFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHA_FEE between", value1, value2, "chaFee");
            return (Criteria) this;
        }

        public Criteria andChaFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHA_FEE not between", value1, value2, "chaFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNull() {
            addCriterion("SERVICE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNotNull() {
            addCriterion("SERVICE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE =", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE <>", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThan(BigDecimal value) {
            addCriterion("SERVICE_FEE >", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE >=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThan(BigDecimal value) {
            addCriterion("SERVICE_FEE <", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE <=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIn(List<BigDecimal> values) {
            addCriterion("SERVICE_FEE in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotIn(List<BigDecimal> values) {
            addCriterion("SERVICE_FEE not in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SERVICE_FEE between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SERVICE_FEE not between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andChaLenIsNull() {
            addCriterion("CHA_LEN is null");
            return (Criteria) this;
        }

        public Criteria andChaLenIsNotNull() {
            addCriterion("CHA_LEN is not null");
            return (Criteria) this;
        }

        public Criteria andChaLenEqualTo(Integer value) {
            addCriterion("CHA_LEN =", value, "chaLen");
            return (Criteria) this;
        }

        public Criteria andChaLenNotEqualTo(Integer value) {
            addCriterion("CHA_LEN <>", value, "chaLen");
            return (Criteria) this;
        }

        public Criteria andChaLenGreaterThan(Integer value) {
            addCriterion("CHA_LEN >", value, "chaLen");
            return (Criteria) this;
        }

        public Criteria andChaLenGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHA_LEN >=", value, "chaLen");
            return (Criteria) this;
        }

        public Criteria andChaLenLessThan(Integer value) {
            addCriterion("CHA_LEN <", value, "chaLen");
            return (Criteria) this;
        }

        public Criteria andChaLenLessThanOrEqualTo(Integer value) {
            addCriterion("CHA_LEN <=", value, "chaLen");
            return (Criteria) this;
        }

        public Criteria andChaLenIn(List<Integer> values) {
            addCriterion("CHA_LEN in", values, "chaLen");
            return (Criteria) this;
        }

        public Criteria andChaLenNotIn(List<Integer> values) {
            addCriterion("CHA_LEN not in", values, "chaLen");
            return (Criteria) this;
        }

        public Criteria andChaLenBetween(Integer value1, Integer value2) {
            addCriterion("CHA_LEN between", value1, value2, "chaLen");
            return (Criteria) this;
        }

        public Criteria andChaLenNotBetween(Integer value1, Integer value2) {
            addCriterion("CHA_LEN not between", value1, value2, "chaLen");
            return (Criteria) this;
        }

        public Criteria andChaPowerIsNull() {
            addCriterion("CHA_POWER is null");
            return (Criteria) this;
        }

        public Criteria andChaPowerIsNotNull() {
            addCriterion("CHA_POWER is not null");
            return (Criteria) this;
        }

        public Criteria andChaPowerEqualTo(Double value) {
            addCriterion("CHA_POWER =", value, "chaPower");
            return (Criteria) this;
        }

        public Criteria andChaPowerNotEqualTo(Double value) {
            addCriterion("CHA_POWER <>", value, "chaPower");
            return (Criteria) this;
        }

        public Criteria andChaPowerGreaterThan(Double value) {
            addCriterion("CHA_POWER >", value, "chaPower");
            return (Criteria) this;
        }

        public Criteria andChaPowerGreaterThanOrEqualTo(Double value) {
            addCriterion("CHA_POWER >=", value, "chaPower");
            return (Criteria) this;
        }

        public Criteria andChaPowerLessThan(Double value) {
            addCriterion("CHA_POWER <", value, "chaPower");
            return (Criteria) this;
        }

        public Criteria andChaPowerLessThanOrEqualTo(Double value) {
            addCriterion("CHA_POWER <=", value, "chaPower");
            return (Criteria) this;
        }

        public Criteria andChaPowerIn(List<Double> values) {
            addCriterion("CHA_POWER in", values, "chaPower");
            return (Criteria) this;
        }

        public Criteria andChaPowerNotIn(List<Double> values) {
            addCriterion("CHA_POWER not in", values, "chaPower");
            return (Criteria) this;
        }

        public Criteria andChaPowerBetween(Double value1, Double value2) {
            addCriterion("CHA_POWER between", value1, value2, "chaPower");
            return (Criteria) this;
        }

        public Criteria andChaPowerNotBetween(Double value1, Double value2) {
            addCriterion("CHA_POWER not between", value1, value2, "chaPower");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyIsNull() {
            addCriterion("SHOULD_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyIsNotNull() {
            addCriterion("SHOULD_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyEqualTo(BigDecimal value) {
            addCriterion("SHOULD_MONEY =", value, "shouldMoney");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyNotEqualTo(BigDecimal value) {
            addCriterion("SHOULD_MONEY <>", value, "shouldMoney");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyGreaterThan(BigDecimal value) {
            addCriterion("SHOULD_MONEY >", value, "shouldMoney");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SHOULD_MONEY >=", value, "shouldMoney");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyLessThan(BigDecimal value) {
            addCriterion("SHOULD_MONEY <", value, "shouldMoney");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SHOULD_MONEY <=", value, "shouldMoney");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyIn(List<BigDecimal> values) {
            addCriterion("SHOULD_MONEY in", values, "shouldMoney");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyNotIn(List<BigDecimal> values) {
            addCriterion("SHOULD_MONEY not in", values, "shouldMoney");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHOULD_MONEY between", value1, value2, "shouldMoney");
            return (Criteria) this;
        }

        public Criteria andShouldMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHOULD_MONEY not between", value1, value2, "shouldMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIsNull() {
            addCriterion("ACTUAL_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIsNotNull() {
            addCriterion("ACTUAL_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andActualMoneyEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_MONEY =", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_MONEY <>", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_MONEY >", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_MONEY >=", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyLessThan(BigDecimal value) {
            addCriterion("ACTUAL_MONEY <", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_MONEY <=", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_MONEY in", values, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_MONEY not in", values, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_MONEY between", value1, value2, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_MONEY not between", value1, value2, "actualMoney");
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

        public Criteria andPayStatusIsNull() {
            addCriterion("PAY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("PAY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Short value) {
            addCriterion("PAY_STATUS =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Short value) {
            addCriterion("PAY_STATUS <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Short value) {
            addCriterion("PAY_STATUS >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("PAY_STATUS >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Short value) {
            addCriterion("PAY_STATUS <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Short value) {
            addCriterion("PAY_STATUS <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Short> values) {
            addCriterion("PAY_STATUS in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Short> values) {
            addCriterion("PAY_STATUS not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Short value1, Short value2) {
            addCriterion("PAY_STATUS between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Short value1, Short value2) {
            addCriterion("PAY_STATUS not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andIsBillIsNull() {
            addCriterion("IS_BILL is null");
            return (Criteria) this;
        }

        public Criteria andIsBillIsNotNull() {
            addCriterion("IS_BILL is not null");
            return (Criteria) this;
        }

        public Criteria andIsBillEqualTo(Short value) {
            addCriterion("IS_BILL =", value, "isBill");
            return (Criteria) this;
        }

        public Criteria andIsBillNotEqualTo(Short value) {
            addCriterion("IS_BILL <>", value, "isBill");
            return (Criteria) this;
        }

        public Criteria andIsBillGreaterThan(Short value) {
            addCriterion("IS_BILL >", value, "isBill");
            return (Criteria) this;
        }

        public Criteria andIsBillGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_BILL >=", value, "isBill");
            return (Criteria) this;
        }

        public Criteria andIsBillLessThan(Short value) {
            addCriterion("IS_BILL <", value, "isBill");
            return (Criteria) this;
        }

        public Criteria andIsBillLessThanOrEqualTo(Short value) {
            addCriterion("IS_BILL <=", value, "isBill");
            return (Criteria) this;
        }

        public Criteria andIsBillIn(List<Short> values) {
            addCriterion("IS_BILL in", values, "isBill");
            return (Criteria) this;
        }

        public Criteria andIsBillNotIn(List<Short> values) {
            addCriterion("IS_BILL not in", values, "isBill");
            return (Criteria) this;
        }

        public Criteria andIsBillBetween(Short value1, Short value2) {
            addCriterion("IS_BILL between", value1, value2, "isBill");
            return (Criteria) this;
        }

        public Criteria andIsBillNotBetween(Short value1, Short value2) {
            addCriterion("IS_BILL not between", value1, value2, "isBill");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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