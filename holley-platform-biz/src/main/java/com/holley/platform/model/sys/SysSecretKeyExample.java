package com.holley.platform.model.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysSecretKeyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysSecretKeyExample() {
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

        public Criteria andOperatoridIsNull() {
            addCriterion("operatorID is null");
            return (Criteria) this;
        }

        public Criteria andOperatoridIsNotNull() {
            addCriterion("operatorID is not null");
            return (Criteria) this;
        }

        public Criteria andOperatoridEqualTo(String value) {
            addCriterion("operatorID =", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridNotEqualTo(String value) {
            addCriterion("operatorID <>", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridGreaterThan(String value) {
            addCriterion("operatorID >", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridGreaterThanOrEqualTo(String value) {
            addCriterion("operatorID >=", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridLessThan(String value) {
            addCriterion("operatorID <", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridLessThanOrEqualTo(String value) {
            addCriterion("operatorID <=", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridLike(String value) {
            addCriterion("operatorID like", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridNotLike(String value) {
            addCriterion("operatorID not like", value, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridIn(List<String> values) {
            addCriterion("operatorID in", values, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridNotIn(List<String> values) {
            addCriterion("operatorID not in", values, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridBetween(String value1, String value2) {
            addCriterion("operatorID between", value1, value2, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatoridNotBetween(String value1, String value2) {
            addCriterion("operatorID not between", value1, value2, "operatorid");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretIsNull() {
            addCriterion("operatorSecret is null");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretIsNotNull() {
            addCriterion("operatorSecret is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretEqualTo(String value) {
            addCriterion("operatorSecret =", value, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretNotEqualTo(String value) {
            addCriterion("operatorSecret <>", value, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretGreaterThan(String value) {
            addCriterion("operatorSecret >", value, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretGreaterThanOrEqualTo(String value) {
            addCriterion("operatorSecret >=", value, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretLessThan(String value) {
            addCriterion("operatorSecret <", value, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretLessThanOrEqualTo(String value) {
            addCriterion("operatorSecret <=", value, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretLike(String value) {
            addCriterion("operatorSecret like", value, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretNotLike(String value) {
            addCriterion("operatorSecret not like", value, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretIn(List<String> values) {
            addCriterion("operatorSecret in", values, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretNotIn(List<String> values) {
            addCriterion("operatorSecret not in", values, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretBetween(String value1, String value2) {
            addCriterion("operatorSecret between", value1, value2, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andOperatorsecretNotBetween(String value1, String value2) {
            addCriterion("operatorSecret not between", value1, value2, "operatorsecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretIsNull() {
            addCriterion("dataSecret is null");
            return (Criteria) this;
        }

        public Criteria andDatasecretIsNotNull() {
            addCriterion("dataSecret is not null");
            return (Criteria) this;
        }

        public Criteria andDatasecretEqualTo(String value) {
            addCriterion("dataSecret =", value, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretNotEqualTo(String value) {
            addCriterion("dataSecret <>", value, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretGreaterThan(String value) {
            addCriterion("dataSecret >", value, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretGreaterThanOrEqualTo(String value) {
            addCriterion("dataSecret >=", value, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretLessThan(String value) {
            addCriterion("dataSecret <", value, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretLessThanOrEqualTo(String value) {
            addCriterion("dataSecret <=", value, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretLike(String value) {
            addCriterion("dataSecret like", value, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretNotLike(String value) {
            addCriterion("dataSecret not like", value, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretIn(List<String> values) {
            addCriterion("dataSecret in", values, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretNotIn(List<String> values) {
            addCriterion("dataSecret not in", values, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretBetween(String value1, String value2) {
            addCriterion("dataSecret between", value1, value2, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretNotBetween(String value1, String value2) {
            addCriterion("dataSecret not between", value1, value2, "datasecret");
            return (Criteria) this;
        }

        public Criteria andDatasecretivIsNull() {
            addCriterion("dataSecretIV is null");
            return (Criteria) this;
        }

        public Criteria andDatasecretivIsNotNull() {
            addCriterion("dataSecretIV is not null");
            return (Criteria) this;
        }

        public Criteria andDatasecretivEqualTo(String value) {
            addCriterion("dataSecretIV =", value, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andDatasecretivNotEqualTo(String value) {
            addCriterion("dataSecretIV <>", value, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andDatasecretivGreaterThan(String value) {
            addCriterion("dataSecretIV >", value, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andDatasecretivGreaterThanOrEqualTo(String value) {
            addCriterion("dataSecretIV >=", value, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andDatasecretivLessThan(String value) {
            addCriterion("dataSecretIV <", value, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andDatasecretivLessThanOrEqualTo(String value) {
            addCriterion("dataSecretIV <=", value, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andDatasecretivLike(String value) {
            addCriterion("dataSecretIV like", value, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andDatasecretivNotLike(String value) {
            addCriterion("dataSecretIV not like", value, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andDatasecretivIn(List<String> values) {
            addCriterion("dataSecretIV in", values, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andDatasecretivNotIn(List<String> values) {
            addCriterion("dataSecretIV not in", values, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andDatasecretivBetween(String value1, String value2) {
            addCriterion("dataSecretIV between", value1, value2, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andDatasecretivNotBetween(String value1, String value2) {
            addCriterion("dataSecretIV not between", value1, value2, "datasecretiv");
            return (Criteria) this;
        }

        public Criteria andSigsecretIsNull() {
            addCriterion("sigSecret is null");
            return (Criteria) this;
        }

        public Criteria andSigsecretIsNotNull() {
            addCriterion("sigSecret is not null");
            return (Criteria) this;
        }

        public Criteria andSigsecretEqualTo(String value) {
            addCriterion("sigSecret =", value, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andSigsecretNotEqualTo(String value) {
            addCriterion("sigSecret <>", value, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andSigsecretGreaterThan(String value) {
            addCriterion("sigSecret >", value, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andSigsecretGreaterThanOrEqualTo(String value) {
            addCriterion("sigSecret >=", value, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andSigsecretLessThan(String value) {
            addCriterion("sigSecret <", value, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andSigsecretLessThanOrEqualTo(String value) {
            addCriterion("sigSecret <=", value, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andSigsecretLike(String value) {
            addCriterion("sigSecret like", value, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andSigsecretNotLike(String value) {
            addCriterion("sigSecret not like", value, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andSigsecretIn(List<String> values) {
            addCriterion("sigSecret in", values, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andSigsecretNotIn(List<String> values) {
            addCriterion("sigSecret not in", values, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andSigsecretBetween(String value1, String value2) {
            addCriterion("sigSecret between", value1, value2, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andSigsecretNotBetween(String value1, String value2) {
            addCriterion("sigSecret not between", value1, value2, "sigsecret");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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