package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusPileChargeruleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusPileChargeruleExample() {
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

        public Criteria andChargeruleIdIsNull() {
            addCriterion("CHARGERULE_ID is null");
            return (Criteria) this;
        }

        public Criteria andChargeruleIdIsNotNull() {
            addCriterion("CHARGERULE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChargeruleIdEqualTo(Integer value) {
            addCriterion("CHARGERULE_ID =", value, "chargeruleId");
            return (Criteria) this;
        }

        public Criteria andChargeruleIdNotEqualTo(Integer value) {
            addCriterion("CHARGERULE_ID <>", value, "chargeruleId");
            return (Criteria) this;
        }

        public Criteria andChargeruleIdGreaterThan(Integer value) {
            addCriterion("CHARGERULE_ID >", value, "chargeruleId");
            return (Criteria) this;
        }

        public Criteria andChargeruleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHARGERULE_ID >=", value, "chargeruleId");
            return (Criteria) this;
        }

        public Criteria andChargeruleIdLessThan(Integer value) {
            addCriterion("CHARGERULE_ID <", value, "chargeruleId");
            return (Criteria) this;
        }

        public Criteria andChargeruleIdLessThanOrEqualTo(Integer value) {
            addCriterion("CHARGERULE_ID <=", value, "chargeruleId");
            return (Criteria) this;
        }

        public Criteria andChargeruleIdIn(List<Integer> values) {
            addCriterion("CHARGERULE_ID in", values, "chargeruleId");
            return (Criteria) this;
        }

        public Criteria andChargeruleIdNotIn(List<Integer> values) {
            addCriterion("CHARGERULE_ID not in", values, "chargeruleId");
            return (Criteria) this;
        }

        public Criteria andChargeruleIdBetween(Integer value1, Integer value2) {
            addCriterion("CHARGERULE_ID between", value1, value2, "chargeruleId");
            return (Criteria) this;
        }

        public Criteria andChargeruleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CHARGERULE_ID not between", value1, value2, "chargeruleId");
            return (Criteria) this;
        }

        public Criteria andChargeFeeIsNull() {
            addCriterion("CHARGE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andChargeFeeIsNotNull() {
            addCriterion("CHARGE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andChargeFeeEqualTo(BigDecimal value) {
            addCriterion("CHARGE_FEE =", value, "chargeFee");
            return (Criteria) this;
        }

        public Criteria andChargeFeeNotEqualTo(BigDecimal value) {
            addCriterion("CHARGE_FEE <>", value, "chargeFee");
            return (Criteria) this;
        }

        public Criteria andChargeFeeGreaterThan(BigDecimal value) {
            addCriterion("CHARGE_FEE >", value, "chargeFee");
            return (Criteria) this;
        }

        public Criteria andChargeFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHARGE_FEE >=", value, "chargeFee");
            return (Criteria) this;
        }

        public Criteria andChargeFeeLessThan(BigDecimal value) {
            addCriterion("CHARGE_FEE <", value, "chargeFee");
            return (Criteria) this;
        }

        public Criteria andChargeFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHARGE_FEE <=", value, "chargeFee");
            return (Criteria) this;
        }

        public Criteria andChargeFeeIn(List<BigDecimal> values) {
            addCriterion("CHARGE_FEE in", values, "chargeFee");
            return (Criteria) this;
        }

        public Criteria andChargeFeeNotIn(List<BigDecimal> values) {
            addCriterion("CHARGE_FEE not in", values, "chargeFee");
            return (Criteria) this;
        }

        public Criteria andChargeFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHARGE_FEE between", value1, value2, "chargeFee");
            return (Criteria) this;
        }

        public Criteria andChargeFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHARGE_FEE not between", value1, value2, "chargeFee");
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

        public Criteria andActiveTimeIsNull() {
            addCriterion("ACTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNotNull() {
            addCriterion("ACTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeEqualTo(Date value) {
            addCriterion("ACTIVE_TIME =", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotEqualTo(Date value) {
            addCriterion("ACTIVE_TIME <>", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThan(Date value) {
            addCriterion("ACTIVE_TIME >", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ACTIVE_TIME >=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThan(Date value) {
            addCriterion("ACTIVE_TIME <", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("ACTIVE_TIME <=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIn(List<Date> values) {
            addCriterion("ACTIVE_TIME in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotIn(List<Date> values) {
            addCriterion("ACTIVE_TIME not in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeBetween(Date value1, Date value2) {
            addCriterion("ACTIVE_TIME between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("ACTIVE_TIME not between", value1, value2, "activeTime");
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