package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusChargeRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusChargeRuleExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andJianFeeIsNull() {
            addCriterion("JIAN_FEE is null");
            return (Criteria) this;
        }

        public Criteria andJianFeeIsNotNull() {
            addCriterion("JIAN_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andJianFeeEqualTo(BigDecimal value) {
            addCriterion("JIAN_FEE =", value, "jianFee");
            return (Criteria) this;
        }

        public Criteria andJianFeeNotEqualTo(BigDecimal value) {
            addCriterion("JIAN_FEE <>", value, "jianFee");
            return (Criteria) this;
        }

        public Criteria andJianFeeGreaterThan(BigDecimal value) {
            addCriterion("JIAN_FEE >", value, "jianFee");
            return (Criteria) this;
        }

        public Criteria andJianFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("JIAN_FEE >=", value, "jianFee");
            return (Criteria) this;
        }

        public Criteria andJianFeeLessThan(BigDecimal value) {
            addCriterion("JIAN_FEE <", value, "jianFee");
            return (Criteria) this;
        }

        public Criteria andJianFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("JIAN_FEE <=", value, "jianFee");
            return (Criteria) this;
        }

        public Criteria andJianFeeIn(List<BigDecimal> values) {
            addCriterion("JIAN_FEE in", values, "jianFee");
            return (Criteria) this;
        }

        public Criteria andJianFeeNotIn(List<BigDecimal> values) {
            addCriterion("JIAN_FEE not in", values, "jianFee");
            return (Criteria) this;
        }

        public Criteria andJianFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JIAN_FEE between", value1, value2, "jianFee");
            return (Criteria) this;
        }

        public Criteria andJianFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JIAN_FEE not between", value1, value2, "jianFee");
            return (Criteria) this;
        }

        public Criteria andFengFeeIsNull() {
            addCriterion("FENG_FEE is null");
            return (Criteria) this;
        }

        public Criteria andFengFeeIsNotNull() {
            addCriterion("FENG_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFengFeeEqualTo(BigDecimal value) {
            addCriterion("FENG_FEE =", value, "fengFee");
            return (Criteria) this;
        }

        public Criteria andFengFeeNotEqualTo(BigDecimal value) {
            addCriterion("FENG_FEE <>", value, "fengFee");
            return (Criteria) this;
        }

        public Criteria andFengFeeGreaterThan(BigDecimal value) {
            addCriterion("FENG_FEE >", value, "fengFee");
            return (Criteria) this;
        }

        public Criteria andFengFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FENG_FEE >=", value, "fengFee");
            return (Criteria) this;
        }

        public Criteria andFengFeeLessThan(BigDecimal value) {
            addCriterion("FENG_FEE <", value, "fengFee");
            return (Criteria) this;
        }

        public Criteria andFengFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FENG_FEE <=", value, "fengFee");
            return (Criteria) this;
        }

        public Criteria andFengFeeIn(List<BigDecimal> values) {
            addCriterion("FENG_FEE in", values, "fengFee");
            return (Criteria) this;
        }

        public Criteria andFengFeeNotIn(List<BigDecimal> values) {
            addCriterion("FENG_FEE not in", values, "fengFee");
            return (Criteria) this;
        }

        public Criteria andFengFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FENG_FEE between", value1, value2, "fengFee");
            return (Criteria) this;
        }

        public Criteria andFengFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FENG_FEE not between", value1, value2, "fengFee");
            return (Criteria) this;
        }

        public Criteria andPingFeeIsNull() {
            addCriterion("PING_FEE is null");
            return (Criteria) this;
        }

        public Criteria andPingFeeIsNotNull() {
            addCriterion("PING_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andPingFeeEqualTo(BigDecimal value) {
            addCriterion("PING_FEE =", value, "pingFee");
            return (Criteria) this;
        }

        public Criteria andPingFeeNotEqualTo(BigDecimal value) {
            addCriterion("PING_FEE <>", value, "pingFee");
            return (Criteria) this;
        }

        public Criteria andPingFeeGreaterThan(BigDecimal value) {
            addCriterion("PING_FEE >", value, "pingFee");
            return (Criteria) this;
        }

        public Criteria andPingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PING_FEE >=", value, "pingFee");
            return (Criteria) this;
        }

        public Criteria andPingFeeLessThan(BigDecimal value) {
            addCriterion("PING_FEE <", value, "pingFee");
            return (Criteria) this;
        }

        public Criteria andPingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PING_FEE <=", value, "pingFee");
            return (Criteria) this;
        }

        public Criteria andPingFeeIn(List<BigDecimal> values) {
            addCriterion("PING_FEE in", values, "pingFee");
            return (Criteria) this;
        }

        public Criteria andPingFeeNotIn(List<BigDecimal> values) {
            addCriterion("PING_FEE not in", values, "pingFee");
            return (Criteria) this;
        }

        public Criteria andPingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PING_FEE between", value1, value2, "pingFee");
            return (Criteria) this;
        }

        public Criteria andPingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PING_FEE not between", value1, value2, "pingFee");
            return (Criteria) this;
        }

        public Criteria andGuFeeIsNull() {
            addCriterion("GU_FEE is null");
            return (Criteria) this;
        }

        public Criteria andGuFeeIsNotNull() {
            addCriterion("GU_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andGuFeeEqualTo(BigDecimal value) {
            addCriterion("GU_FEE =", value, "guFee");
            return (Criteria) this;
        }

        public Criteria andGuFeeNotEqualTo(BigDecimal value) {
            addCriterion("GU_FEE <>", value, "guFee");
            return (Criteria) this;
        }

        public Criteria andGuFeeGreaterThan(BigDecimal value) {
            addCriterion("GU_FEE >", value, "guFee");
            return (Criteria) this;
        }

        public Criteria andGuFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GU_FEE >=", value, "guFee");
            return (Criteria) this;
        }

        public Criteria andGuFeeLessThan(BigDecimal value) {
            addCriterion("GU_FEE <", value, "guFee");
            return (Criteria) this;
        }

        public Criteria andGuFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GU_FEE <=", value, "guFee");
            return (Criteria) this;
        }

        public Criteria andGuFeeIn(List<BigDecimal> values) {
            addCriterion("GU_FEE in", values, "guFee");
            return (Criteria) this;
        }

        public Criteria andGuFeeNotIn(List<BigDecimal> values) {
            addCriterion("GU_FEE not in", values, "guFee");
            return (Criteria) this;
        }

        public Criteria andGuFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GU_FEE between", value1, value2, "guFee");
            return (Criteria) this;
        }

        public Criteria andGuFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GU_FEE not between", value1, value2, "guFee");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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