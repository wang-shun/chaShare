package com.holley.charging.model.bus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusFavoritesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusFavoritesExample() {
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

        public Criteria andStationIdIsNull() {
            addCriterion("STATION_ID is null");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNotNull() {
            addCriterion("STATION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStationIdEqualTo(Integer value) {
            addCriterion("STATION_ID =", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotEqualTo(Integer value) {
            addCriterion("STATION_ID <>", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThan(Integer value) {
            addCriterion("STATION_ID >", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATION_ID >=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThan(Integer value) {
            addCriterion("STATION_ID <", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThanOrEqualTo(Integer value) {
            addCriterion("STATION_ID <=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdIn(List<Integer> values) {
            addCriterion("STATION_ID in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotIn(List<Integer> values) {
            addCriterion("STATION_ID not in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdBetween(Integer value1, Integer value2) {
            addCriterion("STATION_ID between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("STATION_ID not between", value1, value2, "stationId");
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

        public Criteria andIsShowIsNull() {
            addCriterion("IS_SHOW is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("IS_SHOW is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Short value) {
            addCriterion("IS_SHOW =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Short value) {
            addCriterion("IS_SHOW <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Short value) {
            addCriterion("IS_SHOW >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_SHOW >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Short value) {
            addCriterion("IS_SHOW <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Short value) {
            addCriterion("IS_SHOW <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Short> values) {
            addCriterion("IS_SHOW in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Short> values) {
            addCriterion("IS_SHOW not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Short value1, Short value2) {
            addCriterion("IS_SHOW between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Short value1, Short value2) {
            addCriterion("IS_SHOW not between", value1, value2, "isShow");
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