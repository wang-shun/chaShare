package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusBillsDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusBillsDetailExample() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("RECORD_ID is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("RECORD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Integer value) {
            addCriterion("RECORD_ID =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Integer value) {
            addCriterion("RECORD_ID <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Integer value) {
            addCriterion("RECORD_ID >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECORD_ID >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Integer value) {
            addCriterion("RECORD_ID <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("RECORD_ID <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Integer> values) {
            addCriterion("RECORD_ID in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Integer> values) {
            addCriterion("RECORD_ID not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("RECORD_ID between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RECORD_ID not between", value1, value2, "recordId");
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

        public Criteria andCheckCycleIsNull() {
            addCriterion("CHECK_CYCLE is null");
            return (Criteria) this;
        }

        public Criteria andCheckCycleIsNotNull() {
            addCriterion("CHECK_CYCLE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckCycleEqualTo(String value) {
            addCriterion("CHECK_CYCLE =", value, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andCheckCycleNotEqualTo(String value) {
            addCriterion("CHECK_CYCLE <>", value, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andCheckCycleGreaterThan(String value) {
            addCriterion("CHECK_CYCLE >", value, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andCheckCycleGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_CYCLE >=", value, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andCheckCycleLessThan(String value) {
            addCriterion("CHECK_CYCLE <", value, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andCheckCycleLessThanOrEqualTo(String value) {
            addCriterion("CHECK_CYCLE <=", value, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andCheckCycleLike(String value) {
            addCriterion("CHECK_CYCLE like", value, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andCheckCycleNotLike(String value) {
            addCriterion("CHECK_CYCLE not like", value, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andCheckCycleIn(List<String> values) {
            addCriterion("CHECK_CYCLE in", values, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andCheckCycleNotIn(List<String> values) {
            addCriterion("CHECK_CYCLE not in", values, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andCheckCycleBetween(String value1, String value2) {
            addCriterion("CHECK_CYCLE between", value1, value2, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andCheckCycleNotBetween(String value1, String value2) {
            addCriterion("CHECK_CYCLE not between", value1, value2, "checkCycle");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("TOTAL_FEE is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("TOTAL_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(BigDecimal value) {
            addCriterion("TOTAL_FEE =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_FEE <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_FEE >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_FEE >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(BigDecimal value) {
            addCriterion("TOTAL_FEE <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_FEE <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<BigDecimal> values) {
            addCriterion("TOTAL_FEE in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_FEE not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_FEE between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_FEE not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andAppFeeInIsNull() {
            addCriterion("APP_FEE_IN is null");
            return (Criteria) this;
        }

        public Criteria andAppFeeInIsNotNull() {
            addCriterion("APP_FEE_IN is not null");
            return (Criteria) this;
        }

        public Criteria andAppFeeInEqualTo(BigDecimal value) {
            addCriterion("APP_FEE_IN =", value, "appFeeIn");
            return (Criteria) this;
        }

        public Criteria andAppFeeInNotEqualTo(BigDecimal value) {
            addCriterion("APP_FEE_IN <>", value, "appFeeIn");
            return (Criteria) this;
        }

        public Criteria andAppFeeInGreaterThan(BigDecimal value) {
            addCriterion("APP_FEE_IN >", value, "appFeeIn");
            return (Criteria) this;
        }

        public Criteria andAppFeeInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("APP_FEE_IN >=", value, "appFeeIn");
            return (Criteria) this;
        }

        public Criteria andAppFeeInLessThan(BigDecimal value) {
            addCriterion("APP_FEE_IN <", value, "appFeeIn");
            return (Criteria) this;
        }

        public Criteria andAppFeeInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("APP_FEE_IN <=", value, "appFeeIn");
            return (Criteria) this;
        }

        public Criteria andAppFeeInIn(List<BigDecimal> values) {
            addCriterion("APP_FEE_IN in", values, "appFeeIn");
            return (Criteria) this;
        }

        public Criteria andAppFeeInNotIn(List<BigDecimal> values) {
            addCriterion("APP_FEE_IN not in", values, "appFeeIn");
            return (Criteria) this;
        }

        public Criteria andAppFeeInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("APP_FEE_IN between", value1, value2, "appFeeIn");
            return (Criteria) this;
        }

        public Criteria andAppFeeInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("APP_FEE_IN not between", value1, value2, "appFeeIn");
            return (Criteria) this;
        }

        public Criteria andChaFeeInIsNull() {
            addCriterion("CHA_FEE_IN is null");
            return (Criteria) this;
        }

        public Criteria andChaFeeInIsNotNull() {
            addCriterion("CHA_FEE_IN is not null");
            return (Criteria) this;
        }

        public Criteria andChaFeeInEqualTo(BigDecimal value) {
            addCriterion("CHA_FEE_IN =", value, "chaFeeIn");
            return (Criteria) this;
        }

        public Criteria andChaFeeInNotEqualTo(BigDecimal value) {
            addCriterion("CHA_FEE_IN <>", value, "chaFeeIn");
            return (Criteria) this;
        }

        public Criteria andChaFeeInGreaterThan(BigDecimal value) {
            addCriterion("CHA_FEE_IN >", value, "chaFeeIn");
            return (Criteria) this;
        }

        public Criteria andChaFeeInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHA_FEE_IN >=", value, "chaFeeIn");
            return (Criteria) this;
        }

        public Criteria andChaFeeInLessThan(BigDecimal value) {
            addCriterion("CHA_FEE_IN <", value, "chaFeeIn");
            return (Criteria) this;
        }

        public Criteria andChaFeeInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHA_FEE_IN <=", value, "chaFeeIn");
            return (Criteria) this;
        }

        public Criteria andChaFeeInIn(List<BigDecimal> values) {
            addCriterion("CHA_FEE_IN in", values, "chaFeeIn");
            return (Criteria) this;
        }

        public Criteria andChaFeeInNotIn(List<BigDecimal> values) {
            addCriterion("CHA_FEE_IN not in", values, "chaFeeIn");
            return (Criteria) this;
        }

        public Criteria andChaFeeInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHA_FEE_IN between", value1, value2, "chaFeeIn");
            return (Criteria) this;
        }

        public Criteria andChaFeeInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHA_FEE_IN not between", value1, value2, "chaFeeIn");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInIsNull() {
            addCriterion("SERVICE_FEE_IN is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInIsNotNull() {
            addCriterion("SERVICE_FEE_IN is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE_IN =", value, "serviceFeeIn");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInNotEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE_IN <>", value, "serviceFeeIn");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInGreaterThan(BigDecimal value) {
            addCriterion("SERVICE_FEE_IN >", value, "serviceFeeIn");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE_IN >=", value, "serviceFeeIn");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInLessThan(BigDecimal value) {
            addCriterion("SERVICE_FEE_IN <", value, "serviceFeeIn");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE_IN <=", value, "serviceFeeIn");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInIn(List<BigDecimal> values) {
            addCriterion("SERVICE_FEE_IN in", values, "serviceFeeIn");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInNotIn(List<BigDecimal> values) {
            addCriterion("SERVICE_FEE_IN not in", values, "serviceFeeIn");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SERVICE_FEE_IN between", value1, value2, "serviceFeeIn");
            return (Criteria) this;
        }

        public Criteria andServiceFeeInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SERVICE_FEE_IN not between", value1, value2, "serviceFeeIn");
            return (Criteria) this;
        }

        public Criteria andParkFeeInIsNull() {
            addCriterion("PARK_FEE_IN is null");
            return (Criteria) this;
        }

        public Criteria andParkFeeInIsNotNull() {
            addCriterion("PARK_FEE_IN is not null");
            return (Criteria) this;
        }

        public Criteria andParkFeeInEqualTo(BigDecimal value) {
            addCriterion("PARK_FEE_IN =", value, "parkFeeIn");
            return (Criteria) this;
        }

        public Criteria andParkFeeInNotEqualTo(BigDecimal value) {
            addCriterion("PARK_FEE_IN <>", value, "parkFeeIn");
            return (Criteria) this;
        }

        public Criteria andParkFeeInGreaterThan(BigDecimal value) {
            addCriterion("PARK_FEE_IN >", value, "parkFeeIn");
            return (Criteria) this;
        }

        public Criteria andParkFeeInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PARK_FEE_IN >=", value, "parkFeeIn");
            return (Criteria) this;
        }

        public Criteria andParkFeeInLessThan(BigDecimal value) {
            addCriterion("PARK_FEE_IN <", value, "parkFeeIn");
            return (Criteria) this;
        }

        public Criteria andParkFeeInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PARK_FEE_IN <=", value, "parkFeeIn");
            return (Criteria) this;
        }

        public Criteria andParkFeeInIn(List<BigDecimal> values) {
            addCriterion("PARK_FEE_IN in", values, "parkFeeIn");
            return (Criteria) this;
        }

        public Criteria andParkFeeInNotIn(List<BigDecimal> values) {
            addCriterion("PARK_FEE_IN not in", values, "parkFeeIn");
            return (Criteria) this;
        }

        public Criteria andParkFeeInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PARK_FEE_IN between", value1, value2, "parkFeeIn");
            return (Criteria) this;
        }

        public Criteria andParkFeeInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PARK_FEE_IN not between", value1, value2, "parkFeeIn");
            return (Criteria) this;
        }

        public Criteria andCheckMarkIsNull() {
            addCriterion("CHECK_MARK is null");
            return (Criteria) this;
        }

        public Criteria andCheckMarkIsNotNull() {
            addCriterion("CHECK_MARK is not null");
            return (Criteria) this;
        }

        public Criteria andCheckMarkEqualTo(Short value) {
            addCriterion("CHECK_MARK =", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkNotEqualTo(Short value) {
            addCriterion("CHECK_MARK <>", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkGreaterThan(Short value) {
            addCriterion("CHECK_MARK >", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkGreaterThanOrEqualTo(Short value) {
            addCriterion("CHECK_MARK >=", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkLessThan(Short value) {
            addCriterion("CHECK_MARK <", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkLessThanOrEqualTo(Short value) {
            addCriterion("CHECK_MARK <=", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkIn(List<Short> values) {
            addCriterion("CHECK_MARK in", values, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkNotIn(List<Short> values) {
            addCriterion("CHECK_MARK not in", values, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkBetween(Short value1, Short value2) {
            addCriterion("CHECK_MARK between", value1, value2, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkNotBetween(Short value1, Short value2) {
            addCriterion("CHECK_MARK not between", value1, value2, "checkMark");
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