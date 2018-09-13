package com.holley.charging.model.dcs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.holley.charging.common.model.BaseExample;

public class DcsAlarmEventsExample extends BaseExample {

    protected String         orderByClause;

    protected boolean        distinct;

    protected List<Criteria> oredCriteria;

    public DcsAlarmEventsExample() {
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

        public Criteria andEventIdIsNull() {
            addCriterion("EVENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andEventIdIsNotNull() {
            addCriterion("EVENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEventIdEqualTo(String value) {
            addCriterion("EVENT_ID =", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotEqualTo(String value) {
            addCriterion("EVENT_ID <>", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThan(String value) {
            addCriterion("EVENT_ID >", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThanOrEqualTo(String value) {
            addCriterion("EVENT_ID >=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThan(String value) {
            addCriterion("EVENT_ID <", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThanOrEqualTo(String value) {
            addCriterion("EVENT_ID <=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLike(String value) {
            addCriterion("EVENT_ID like", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotLike(String value) {
            addCriterion("EVENT_ID not like", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdIn(List<String> values) {
            addCriterion("EVENT_ID in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotIn(List<String> values) {
            addCriterion("EVENT_ID not in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdBetween(String value1, String value2) {
            addCriterion("EVENT_ID between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotBetween(String value1, String value2) {
            addCriterion("EVENT_ID not between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andDescribedIsNull() {
            addCriterion("DESCRIBED is null");
            return (Criteria) this;
        }

        public Criteria andDescribedIsNotNull() {
            addCriterion("DESCRIBED is not null");
            return (Criteria) this;
        }

        public Criteria andDescribedEqualTo(String value) {
            addCriterion("DESCRIBED =", value, "described");
            return (Criteria) this;
        }

        public Criteria andDescribedNotEqualTo(String value) {
            addCriterion("DESCRIBED <>", value, "described");
            return (Criteria) this;
        }

        public Criteria andDescribedGreaterThan(String value) {
            addCriterion("DESCRIBED >", value, "described");
            return (Criteria) this;
        }

        public Criteria andDescribedGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIBED >=", value, "described");
            return (Criteria) this;
        }

        public Criteria andDescribedLessThan(String value) {
            addCriterion("DESCRIBED <", value, "described");
            return (Criteria) this;
        }

        public Criteria andDescribedLessThanOrEqualTo(String value) {
            addCriterion("DESCRIBED <=", value, "described");
            return (Criteria) this;
        }

        public Criteria andDescribedLike(String value) {
            addCriterion("DESCRIBED like", value, "described");
            return (Criteria) this;
        }

        public Criteria andDescribedNotLike(String value) {
            addCriterion("DESCRIBED not like", value, "described");
            return (Criteria) this;
        }

        public Criteria andDescribedIn(List<String> values) {
            addCriterion("DESCRIBED in", values, "described");
            return (Criteria) this;
        }

        public Criteria andDescribedNotIn(List<String> values) {
            addCriterion("DESCRIBED not in", values, "described");
            return (Criteria) this;
        }

        public Criteria andDescribedBetween(String value1, String value2) {
            addCriterion("DESCRIBED between", value1, value2, "described");
            return (Criteria) this;
        }

        public Criteria andDescribedNotBetween(String value1, String value2) {
            addCriterion("DESCRIBED not between", value1, value2, "described");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Short value) {
            addCriterion("LEVEL =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Short value) {
            addCriterion("LEVEL <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Short value) {
            addCriterion("LEVEL >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("LEVEL >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Short value) {
            addCriterion("LEVEL <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Short value) {
            addCriterion("LEVEL <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Short> values) {
            addCriterion("LEVEL in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Short> values) {
            addCriterion("LEVEL not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Short value1, Short value2) {
            addCriterion("LEVEL between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Short value1, Short value2) {
            addCriterion("LEVEL not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andEventTimeIsNull() {
            addCriterion("EVENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEventTimeIsNotNull() {
            addCriterion("EVENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEventTimeEqualTo(Date value) {
            addCriterion("EVENT_TIME =", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeNotEqualTo(Date value) {
            addCriterion("EVENT_TIME <>", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeGreaterThan(Date value) {
            addCriterion("EVENT_TIME >", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EVENT_TIME >=", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeLessThan(Date value) {
            addCriterion("EVENT_TIME <", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeLessThanOrEqualTo(Date value) {
            addCriterion("EVENT_TIME <=", value, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeIn(List<Date> values) {
            addCriterion("EVENT_TIME in", values, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeNotIn(List<Date> values) {
            addCriterion("EVENT_TIME not in", values, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeBetween(Date value1, Date value2) {
            addCriterion("EVENT_TIME between", value1, value2, "eventTime");
            return (Criteria) this;
        }

        public Criteria andEventTimeNotBetween(Date value1, Date value2) {
            addCriterion("EVENT_TIME not between", value1, value2, "eventTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {

        private String  condition;

        private Object  value;

        private Object  secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String  typeHandler;

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
