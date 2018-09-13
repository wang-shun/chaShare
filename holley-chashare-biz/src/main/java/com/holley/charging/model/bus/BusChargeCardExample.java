package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusChargeCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusChargeCardExample() {
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

        public Criteria andBusNoIsNull() {
            addCriterion("BUS_NO is null");
            return (Criteria) this;
        }

        public Criteria andBusNoIsNotNull() {
            addCriterion("BUS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBusNoEqualTo(String value) {
            addCriterion("BUS_NO =", value, "busNo");
            return (Criteria) this;
        }

        public Criteria andBusNoNotEqualTo(String value) {
            addCriterion("BUS_NO <>", value, "busNo");
            return (Criteria) this;
        }

        public Criteria andBusNoGreaterThan(String value) {
            addCriterion("BUS_NO >", value, "busNo");
            return (Criteria) this;
        }

        public Criteria andBusNoGreaterThanOrEqualTo(String value) {
            addCriterion("BUS_NO >=", value, "busNo");
            return (Criteria) this;
        }

        public Criteria andBusNoLessThan(String value) {
            addCriterion("BUS_NO <", value, "busNo");
            return (Criteria) this;
        }

        public Criteria andBusNoLessThanOrEqualTo(String value) {
            addCriterion("BUS_NO <=", value, "busNo");
            return (Criteria) this;
        }

        public Criteria andBusNoLike(String value) {
            addCriterion("BUS_NO like", value, "busNo");
            return (Criteria) this;
        }

        public Criteria andBusNoNotLike(String value) {
            addCriterion("BUS_NO not like", value, "busNo");
            return (Criteria) this;
        }

        public Criteria andBusNoIn(List<String> values) {
            addCriterion("BUS_NO in", values, "busNo");
            return (Criteria) this;
        }

        public Criteria andBusNoNotIn(List<String> values) {
            addCriterion("BUS_NO not in", values, "busNo");
            return (Criteria) this;
        }

        public Criteria andBusNoBetween(String value1, String value2) {
            addCriterion("BUS_NO between", value1, value2, "busNo");
            return (Criteria) this;
        }

        public Criteria andBusNoNotBetween(String value1, String value2) {
            addCriterion("BUS_NO not between", value1, value2, "busNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("CARD_NO is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("CARD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("CARD_NO =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("CARD_NO <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("CARD_NO >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_NO >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("CARD_NO <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("CARD_NO <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("CARD_NO like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("CARD_NO not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("CARD_NO in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("CARD_NO not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("CARD_NO between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("CARD_NO not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIsNull() {
            addCriterion("APPLICATION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIsNotNull() {
            addCriterion("APPLICATION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeEqualTo(Short value) {
            addCriterion("APPLICATION_TYPE =", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotEqualTo(Short value) {
            addCriterion("APPLICATION_TYPE <>", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeGreaterThan(Short value) {
            addCriterion("APPLICATION_TYPE >", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("APPLICATION_TYPE >=", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLessThan(Short value) {
            addCriterion("APPLICATION_TYPE <", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLessThanOrEqualTo(Short value) {
            addCriterion("APPLICATION_TYPE <=", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIn(List<Short> values) {
            addCriterion("APPLICATION_TYPE in", values, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotIn(List<Short> values) {
            addCriterion("APPLICATION_TYPE not in", values, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeBetween(Short value1, Short value2) {
            addCriterion("APPLICATION_TYPE between", value1, value2, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotBetween(Short value1, Short value2) {
            addCriterion("APPLICATION_TYPE not between", value1, value2, "applicationType");
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

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("CARD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("CARD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(Short value) {
            addCriterion("CARD_TYPE =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(Short value) {
            addCriterion("CARD_TYPE <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(Short value) {
            addCriterion("CARD_TYPE >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("CARD_TYPE >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(Short value) {
            addCriterion("CARD_TYPE <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(Short value) {
            addCriterion("CARD_TYPE <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<Short> values) {
            addCriterion("CARD_TYPE in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<Short> values) {
            addCriterion("CARD_TYPE not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(Short value1, Short value2) {
            addCriterion("CARD_TYPE between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(Short value1, Short value2) {
            addCriterion("CARD_TYPE not between", value1, value2, "cardType");
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

        public Criteria andBadRecordIsNull() {
            addCriterion("BAD_RECORD is null");
            return (Criteria) this;
        }

        public Criteria andBadRecordIsNotNull() {
            addCriterion("BAD_RECORD is not null");
            return (Criteria) this;
        }

        public Criteria andBadRecordEqualTo(String value) {
            addCriterion("BAD_RECORD =", value, "badRecord");
            return (Criteria) this;
        }

        public Criteria andBadRecordNotEqualTo(String value) {
            addCriterion("BAD_RECORD <>", value, "badRecord");
            return (Criteria) this;
        }

        public Criteria andBadRecordGreaterThan(String value) {
            addCriterion("BAD_RECORD >", value, "badRecord");
            return (Criteria) this;
        }

        public Criteria andBadRecordGreaterThanOrEqualTo(String value) {
            addCriterion("BAD_RECORD >=", value, "badRecord");
            return (Criteria) this;
        }

        public Criteria andBadRecordLessThan(String value) {
            addCriterion("BAD_RECORD <", value, "badRecord");
            return (Criteria) this;
        }

        public Criteria andBadRecordLessThanOrEqualTo(String value) {
            addCriterion("BAD_RECORD <=", value, "badRecord");
            return (Criteria) this;
        }

        public Criteria andBadRecordLike(String value) {
            addCriterion("BAD_RECORD like", value, "badRecord");
            return (Criteria) this;
        }

        public Criteria andBadRecordNotLike(String value) {
            addCriterion("BAD_RECORD not like", value, "badRecord");
            return (Criteria) this;
        }

        public Criteria andBadRecordIn(List<String> values) {
            addCriterion("BAD_RECORD in", values, "badRecord");
            return (Criteria) this;
        }

        public Criteria andBadRecordNotIn(List<String> values) {
            addCriterion("BAD_RECORD not in", values, "badRecord");
            return (Criteria) this;
        }

        public Criteria andBadRecordBetween(String value1, String value2) {
            addCriterion("BAD_RECORD between", value1, value2, "badRecord");
            return (Criteria) this;
        }

        public Criteria andBadRecordNotBetween(String value1, String value2) {
            addCriterion("BAD_RECORD not between", value1, value2, "badRecord");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyIsNull() {
            addCriterion("USABLE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyIsNotNull() {
            addCriterion("USABLE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyEqualTo(BigDecimal value) {
            addCriterion("USABLE_MONEY =", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyNotEqualTo(BigDecimal value) {
            addCriterion("USABLE_MONEY <>", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyGreaterThan(BigDecimal value) {
            addCriterion("USABLE_MONEY >", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USABLE_MONEY >=", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyLessThan(BigDecimal value) {
            addCriterion("USABLE_MONEY <", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USABLE_MONEY <=", value, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyIn(List<BigDecimal> values) {
            addCriterion("USABLE_MONEY in", values, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyNotIn(List<BigDecimal> values) {
            addCriterion("USABLE_MONEY not in", values, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USABLE_MONEY between", value1, value2, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andUsableMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USABLE_MONEY not between", value1, value2, "usableMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyIsNull() {
            addCriterion("FREEZE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyIsNotNull() {
            addCriterion("FREEZE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyEqualTo(BigDecimal value) {
            addCriterion("FREEZE_MONEY =", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("FREEZE_MONEY <>", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyGreaterThan(BigDecimal value) {
            addCriterion("FREEZE_MONEY >", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FREEZE_MONEY >=", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyLessThan(BigDecimal value) {
            addCriterion("FREEZE_MONEY <", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FREEZE_MONEY <=", value, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyIn(List<BigDecimal> values) {
            addCriterion("FREEZE_MONEY in", values, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("FREEZE_MONEY not in", values, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREEZE_MONEY between", value1, value2, "freezeMoney");
            return (Criteria) this;
        }

        public Criteria andFreezeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREEZE_MONEY not between", value1, value2, "freezeMoney");
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