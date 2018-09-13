package com.holley.charging.model.dcs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DcsMonitorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DcsMonitorExample() {
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

        public Criteria andOutVIsNull() {
            addCriterion("OUT_V is null");
            return (Criteria) this;
        }

        public Criteria andOutVIsNotNull() {
            addCriterion("OUT_V is not null");
            return (Criteria) this;
        }

        public Criteria andOutVEqualTo(String value) {
            addCriterion("OUT_V =", value, "outV");
            return (Criteria) this;
        }

        public Criteria andOutVNotEqualTo(String value) {
            addCriterion("OUT_V <>", value, "outV");
            return (Criteria) this;
        }

        public Criteria andOutVGreaterThan(String value) {
            addCriterion("OUT_V >", value, "outV");
            return (Criteria) this;
        }

        public Criteria andOutVGreaterThanOrEqualTo(String value) {
            addCriterion("OUT_V >=", value, "outV");
            return (Criteria) this;
        }

        public Criteria andOutVLessThan(String value) {
            addCriterion("OUT_V <", value, "outV");
            return (Criteria) this;
        }

        public Criteria andOutVLessThanOrEqualTo(String value) {
            addCriterion("OUT_V <=", value, "outV");
            return (Criteria) this;
        }

        public Criteria andOutVLike(String value) {
            addCriterion("OUT_V like", value, "outV");
            return (Criteria) this;
        }

        public Criteria andOutVNotLike(String value) {
            addCriterion("OUT_V not like", value, "outV");
            return (Criteria) this;
        }

        public Criteria andOutVIn(List<String> values) {
            addCriterion("OUT_V in", values, "outV");
            return (Criteria) this;
        }

        public Criteria andOutVNotIn(List<String> values) {
            addCriterion("OUT_V not in", values, "outV");
            return (Criteria) this;
        }

        public Criteria andOutVBetween(String value1, String value2) {
            addCriterion("OUT_V between", value1, value2, "outV");
            return (Criteria) this;
        }

        public Criteria andOutVNotBetween(String value1, String value2) {
            addCriterion("OUT_V not between", value1, value2, "outV");
            return (Criteria) this;
        }

        public Criteria andOutIIsNull() {
            addCriterion("OUT_I is null");
            return (Criteria) this;
        }

        public Criteria andOutIIsNotNull() {
            addCriterion("OUT_I is not null");
            return (Criteria) this;
        }

        public Criteria andOutIEqualTo(String value) {
            addCriterion("OUT_I =", value, "outI");
            return (Criteria) this;
        }

        public Criteria andOutINotEqualTo(String value) {
            addCriterion("OUT_I <>", value, "outI");
            return (Criteria) this;
        }

        public Criteria andOutIGreaterThan(String value) {
            addCriterion("OUT_I >", value, "outI");
            return (Criteria) this;
        }

        public Criteria andOutIGreaterThanOrEqualTo(String value) {
            addCriterion("OUT_I >=", value, "outI");
            return (Criteria) this;
        }

        public Criteria andOutILessThan(String value) {
            addCriterion("OUT_I <", value, "outI");
            return (Criteria) this;
        }

        public Criteria andOutILessThanOrEqualTo(String value) {
            addCriterion("OUT_I <=", value, "outI");
            return (Criteria) this;
        }

        public Criteria andOutILike(String value) {
            addCriterion("OUT_I like", value, "outI");
            return (Criteria) this;
        }

        public Criteria andOutINotLike(String value) {
            addCriterion("OUT_I not like", value, "outI");
            return (Criteria) this;
        }

        public Criteria andOutIIn(List<String> values) {
            addCriterion("OUT_I in", values, "outI");
            return (Criteria) this;
        }

        public Criteria andOutINotIn(List<String> values) {
            addCriterion("OUT_I not in", values, "outI");
            return (Criteria) this;
        }

        public Criteria andOutIBetween(String value1, String value2) {
            addCriterion("OUT_I between", value1, value2, "outI");
            return (Criteria) this;
        }

        public Criteria andOutINotBetween(String value1, String value2) {
            addCriterion("OUT_I not between", value1, value2, "outI");
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

        public Criteria andIsOnlineIsNull() {
            addCriterion("IS_ONLINE is null");
            return (Criteria) this;
        }

        public Criteria andIsOnlineIsNotNull() {
            addCriterion("IS_ONLINE is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnlineEqualTo(Short value) {
            addCriterion("IS_ONLINE =", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineNotEqualTo(Short value) {
            addCriterion("IS_ONLINE <>", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineGreaterThan(Short value) {
            addCriterion("IS_ONLINE >", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_ONLINE >=", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLessThan(Short value) {
            addCriterion("IS_ONLINE <", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLessThanOrEqualTo(Short value) {
            addCriterion("IS_ONLINE <=", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineIn(List<Short> values) {
            addCriterion("IS_ONLINE in", values, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineNotIn(List<Short> values) {
            addCriterion("IS_ONLINE not in", values, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineBetween(Short value1, Short value2) {
            addCriterion("IS_ONLINE between", value1, value2, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineNotBetween(Short value1, Short value2) {
            addCriterion("IS_ONLINE not between", value1, value2, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsChargingIsNull() {
            addCriterion("IS_CHARGING is null");
            return (Criteria) this;
        }

        public Criteria andIsChargingIsNotNull() {
            addCriterion("IS_CHARGING is not null");
            return (Criteria) this;
        }

        public Criteria andIsChargingEqualTo(Short value) {
            addCriterion("IS_CHARGING =", value, "isCharging");
            return (Criteria) this;
        }

        public Criteria andIsChargingNotEqualTo(Short value) {
            addCriterion("IS_CHARGING <>", value, "isCharging");
            return (Criteria) this;
        }

        public Criteria andIsChargingGreaterThan(Short value) {
            addCriterion("IS_CHARGING >", value, "isCharging");
            return (Criteria) this;
        }

        public Criteria andIsChargingGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_CHARGING >=", value, "isCharging");
            return (Criteria) this;
        }

        public Criteria andIsChargingLessThan(Short value) {
            addCriterion("IS_CHARGING <", value, "isCharging");
            return (Criteria) this;
        }

        public Criteria andIsChargingLessThanOrEqualTo(Short value) {
            addCriterion("IS_CHARGING <=", value, "isCharging");
            return (Criteria) this;
        }

        public Criteria andIsChargingIn(List<Short> values) {
            addCriterion("IS_CHARGING in", values, "isCharging");
            return (Criteria) this;
        }

        public Criteria andIsChargingNotIn(List<Short> values) {
            addCriterion("IS_CHARGING not in", values, "isCharging");
            return (Criteria) this;
        }

        public Criteria andIsChargingBetween(Short value1, Short value2) {
            addCriterion("IS_CHARGING between", value1, value2, "isCharging");
            return (Criteria) this;
        }

        public Criteria andIsChargingNotBetween(Short value1, Short value2) {
            addCriterion("IS_CHARGING not between", value1, value2, "isCharging");
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