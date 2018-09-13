package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusCashExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusCashExample() {
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

        public Criteria andValidTimeIsNull() {
            addCriterion("VALID_TIME is null");
            return (Criteria) this;
        }

        public Criteria andValidTimeIsNotNull() {
            addCriterion("VALID_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andValidTimeEqualTo(Date value) {
            addCriterion("VALID_TIME =", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotEqualTo(Date value) {
            addCriterion("VALID_TIME <>", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThan(Date value) {
            addCriterion("VALID_TIME >", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("VALID_TIME >=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThan(Date value) {
            addCriterion("VALID_TIME <", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThanOrEqualTo(Date value) {
            addCriterion("VALID_TIME <=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeIn(List<Date> values) {
            addCriterion("VALID_TIME in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotIn(List<Date> values) {
            addCriterion("VALID_TIME not in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeBetween(Date value1, Date value2) {
            addCriterion("VALID_TIME between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotBetween(Date value1, Date value2) {
            addCriterion("VALID_TIME not between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidRemarkIsNull() {
            addCriterion("VALID_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andValidRemarkIsNotNull() {
            addCriterion("VALID_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andValidRemarkEqualTo(String value) {
            addCriterion("VALID_REMARK =", value, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidRemarkNotEqualTo(String value) {
            addCriterion("VALID_REMARK <>", value, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidRemarkGreaterThan(String value) {
            addCriterion("VALID_REMARK >", value, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("VALID_REMARK >=", value, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidRemarkLessThan(String value) {
            addCriterion("VALID_REMARK <", value, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidRemarkLessThanOrEqualTo(String value) {
            addCriterion("VALID_REMARK <=", value, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidRemarkLike(String value) {
            addCriterion("VALID_REMARK like", value, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidRemarkNotLike(String value) {
            addCriterion("VALID_REMARK not like", value, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidRemarkIn(List<String> values) {
            addCriterion("VALID_REMARK in", values, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidRemarkNotIn(List<String> values) {
            addCriterion("VALID_REMARK not in", values, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidRemarkBetween(String value1, String value2) {
            addCriterion("VALID_REMARK between", value1, value2, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidRemarkNotBetween(String value1, String value2) {
            addCriterion("VALID_REMARK not between", value1, value2, "validRemark");
            return (Criteria) this;
        }

        public Criteria andValidStatusIsNull() {
            addCriterion("VALID_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andValidStatusIsNotNull() {
            addCriterion("VALID_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andValidStatusEqualTo(Short value) {
            addCriterion("VALID_STATUS =", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusNotEqualTo(Short value) {
            addCriterion("VALID_STATUS <>", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusGreaterThan(Short value) {
            addCriterion("VALID_STATUS >", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("VALID_STATUS >=", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusLessThan(Short value) {
            addCriterion("VALID_STATUS <", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusLessThanOrEqualTo(Short value) {
            addCriterion("VALID_STATUS <=", value, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusIn(List<Short> values) {
            addCriterion("VALID_STATUS in", values, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusNotIn(List<Short> values) {
            addCriterion("VALID_STATUS not in", values, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusBetween(Short value1, Short value2) {
            addCriterion("VALID_STATUS between", value1, value2, "validStatus");
            return (Criteria) this;
        }

        public Criteria andValidStatusNotBetween(Short value1, Short value2) {
            addCriterion("VALID_STATUS not between", value1, value2, "validStatus");
            return (Criteria) this;
        }

        public Criteria andCashWayIsNull() {
            addCriterion("CASH_WAY is null");
            return (Criteria) this;
        }

        public Criteria andCashWayIsNotNull() {
            addCriterion("CASH_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andCashWayEqualTo(Short value) {
            addCriterion("CASH_WAY =", value, "cashWay");
            return (Criteria) this;
        }

        public Criteria andCashWayNotEqualTo(Short value) {
            addCriterion("CASH_WAY <>", value, "cashWay");
            return (Criteria) this;
        }

        public Criteria andCashWayGreaterThan(Short value) {
            addCriterion("CASH_WAY >", value, "cashWay");
            return (Criteria) this;
        }

        public Criteria andCashWayGreaterThanOrEqualTo(Short value) {
            addCriterion("CASH_WAY >=", value, "cashWay");
            return (Criteria) this;
        }

        public Criteria andCashWayLessThan(Short value) {
            addCriterion("CASH_WAY <", value, "cashWay");
            return (Criteria) this;
        }

        public Criteria andCashWayLessThanOrEqualTo(Short value) {
            addCriterion("CASH_WAY <=", value, "cashWay");
            return (Criteria) this;
        }

        public Criteria andCashWayIn(List<Short> values) {
            addCriterion("CASH_WAY in", values, "cashWay");
            return (Criteria) this;
        }

        public Criteria andCashWayNotIn(List<Short> values) {
            addCriterion("CASH_WAY not in", values, "cashWay");
            return (Criteria) this;
        }

        public Criteria andCashWayBetween(Short value1, Short value2) {
            addCriterion("CASH_WAY between", value1, value2, "cashWay");
            return (Criteria) this;
        }

        public Criteria andCashWayNotBetween(Short value1, Short value2) {
            addCriterion("CASH_WAY not between", value1, value2, "cashWay");
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

        public Criteria andCashStatusIsNull() {
            addCriterion("CASH_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCashStatusIsNotNull() {
            addCriterion("CASH_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCashStatusEqualTo(Short value) {
            addCriterion("CASH_STATUS =", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusNotEqualTo(Short value) {
            addCriterion("CASH_STATUS <>", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusGreaterThan(Short value) {
            addCriterion("CASH_STATUS >", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("CASH_STATUS >=", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusLessThan(Short value) {
            addCriterion("CASH_STATUS <", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusLessThanOrEqualTo(Short value) {
            addCriterion("CASH_STATUS <=", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusIn(List<Short> values) {
            addCriterion("CASH_STATUS in", values, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusNotIn(List<Short> values) {
            addCriterion("CASH_STATUS not in", values, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusBetween(Short value1, Short value2) {
            addCriterion("CASH_STATUS between", value1, value2, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusNotBetween(Short value1, Short value2) {
            addCriterion("CASH_STATUS not between", value1, value2, "cashStatus");
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