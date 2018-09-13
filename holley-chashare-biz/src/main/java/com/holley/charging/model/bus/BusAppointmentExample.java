package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.holley.charging.common.model.BaseExample;

public class BusAppointmentExample extends BaseExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusAppointmentExample() {
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

        public Criteria andAppNoIsNull() {
            addCriterion("APP_NO is null");
            return (Criteria) this;
        }

        public Criteria andAppNoIsNotNull() {
            addCriterion("APP_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAppNoEqualTo(String value) {
            addCriterion("APP_NO =", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotEqualTo(String value) {
            addCriterion("APP_NO <>", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoGreaterThan(String value) {
            addCriterion("APP_NO >", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoGreaterThanOrEqualTo(String value) {
            addCriterion("APP_NO >=", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoLessThan(String value) {
            addCriterion("APP_NO <", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoLessThanOrEqualTo(String value) {
            addCriterion("APP_NO <=", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoLike(String value) {
            addCriterion("APP_NO like", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotLike(String value) {
            addCriterion("APP_NO not like", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoIn(List<String> values) {
            addCriterion("APP_NO in", values, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotIn(List<String> values) {
            addCriterion("APP_NO not in", values, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoBetween(String value1, String value2) {
            addCriterion("APP_NO between", value1, value2, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotBetween(String value1, String value2) {
            addCriterion("APP_NO not between", value1, value2, "appNo");
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

        public Criteria andAppLenIsNull() {
            addCriterion("APP_LEN is null");
            return (Criteria) this;
        }

        public Criteria andAppLenIsNotNull() {
            addCriterion("APP_LEN is not null");
            return (Criteria) this;
        }

        public Criteria andAppLenEqualTo(Integer value) {
            addCriterion("APP_LEN =", value, "appLen");
            return (Criteria) this;
        }

        public Criteria andAppLenNotEqualTo(Integer value) {
            addCriterion("APP_LEN <>", value, "appLen");
            return (Criteria) this;
        }

        public Criteria andAppLenGreaterThan(Integer value) {
            addCriterion("APP_LEN >", value, "appLen");
            return (Criteria) this;
        }

        public Criteria andAppLenGreaterThanOrEqualTo(Integer value) {
            addCriterion("APP_LEN >=", value, "appLen");
            return (Criteria) this;
        }

        public Criteria andAppLenLessThan(Integer value) {
            addCriterion("APP_LEN <", value, "appLen");
            return (Criteria) this;
        }

        public Criteria andAppLenLessThanOrEqualTo(Integer value) {
            addCriterion("APP_LEN <=", value, "appLen");
            return (Criteria) this;
        }

        public Criteria andAppLenIn(List<Integer> values) {
            addCriterion("APP_LEN in", values, "appLen");
            return (Criteria) this;
        }

        public Criteria andAppLenNotIn(List<Integer> values) {
            addCriterion("APP_LEN not in", values, "appLen");
            return (Criteria) this;
        }

        public Criteria andAppLenBetween(Integer value1, Integer value2) {
            addCriterion("APP_LEN between", value1, value2, "appLen");
            return (Criteria) this;
        }

        public Criteria andAppLenNotBetween(Integer value1, Integer value2) {
            addCriterion("APP_LEN not between", value1, value2, "appLen");
            return (Criteria) this;
        }

        public Criteria andAppFeeIsNull() {
            addCriterion("APP_FEE is null");
            return (Criteria) this;
        }

        public Criteria andAppFeeIsNotNull() {
            addCriterion("APP_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andAppFeeEqualTo(BigDecimal value) {
            addCriterion("APP_FEE =", value, "appFee");
            return (Criteria) this;
        }

        public Criteria andAppFeeNotEqualTo(BigDecimal value) {
            addCriterion("APP_FEE <>", value, "appFee");
            return (Criteria) this;
        }

        public Criteria andAppFeeGreaterThan(BigDecimal value) {
            addCriterion("APP_FEE >", value, "appFee");
            return (Criteria) this;
        }

        public Criteria andAppFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("APP_FEE >=", value, "appFee");
            return (Criteria) this;
        }

        public Criteria andAppFeeLessThan(BigDecimal value) {
            addCriterion("APP_FEE <", value, "appFee");
            return (Criteria) this;
        }

        public Criteria andAppFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("APP_FEE <=", value, "appFee");
            return (Criteria) this;
        }

        public Criteria andAppFeeIn(List<BigDecimal> values) {
            addCriterion("APP_FEE in", values, "appFee");
            return (Criteria) this;
        }

        public Criteria andAppFeeNotIn(List<BigDecimal> values) {
            addCriterion("APP_FEE not in", values, "appFee");
            return (Criteria) this;
        }

        public Criteria andAppFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("APP_FEE between", value1, value2, "appFee");
            return (Criteria) this;
        }

        public Criteria andAppFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("APP_FEE not between", value1, value2, "appFee");
            return (Criteria) this;
        }

        public Criteria andAppStatusIsNull() {
            addCriterion("APP_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAppStatusIsNotNull() {
            addCriterion("APP_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAppStatusEqualTo(Short value) {
            addCriterion("APP_STATUS =", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusNotEqualTo(Short value) {
            addCriterion("APP_STATUS <>", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusGreaterThan(Short value) {
            addCriterion("APP_STATUS >", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("APP_STATUS >=", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusLessThan(Short value) {
            addCriterion("APP_STATUS <", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusLessThanOrEqualTo(Short value) {
            addCriterion("APP_STATUS <=", value, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusIn(List<Short> values) {
            addCriterion("APP_STATUS in", values, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusNotIn(List<Short> values) {
            addCriterion("APP_STATUS not in", values, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusBetween(Short value1, Short value2) {
            addCriterion("APP_STATUS between", value1, value2, "appStatus");
            return (Criteria) this;
        }

        public Criteria andAppStatusNotBetween(Short value1, Short value2) {
            addCriterion("APP_STATUS not between", value1, value2, "appStatus");
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