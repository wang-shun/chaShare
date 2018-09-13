package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.holley.charging.common.model.BaseExample;

public class BusAccountLogExample extends BaseExample {

    protected String         orderByClause;

    protected boolean        distinct;

    protected List<Criteria> oredCriteria;

    public BusAccountLogExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("DIRECTION is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("DIRECTION is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(Short value) {
            addCriterion("DIRECTION =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(Short value) {
            addCriterion("DIRECTION <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(Short value) {
            addCriterion("DIRECTION >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(Short value) {
            addCriterion("DIRECTION >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(Short value) {
            addCriterion("DIRECTION <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(Short value) {
            addCriterion("DIRECTION <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<Short> values) {
            addCriterion("DIRECTION in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<Short> values) {
            addCriterion("DIRECTION not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(Short value1, Short value2) {
            addCriterion("DIRECTION between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(Short value1, Short value2) {
            addCriterion("DIRECTION not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("TOTAL_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("TOTAL_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MONEY =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MONEY <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_MONEY >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MONEY >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(BigDecimal value) {
            addCriterion("TOTAL_MONEY <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MONEY <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("TOTAL_MONEY in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_MONEY not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_MONEY between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_MONEY not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyIsNull() {
            addCriterion("OPERATE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyIsNotNull() {
            addCriterion("OPERATE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyEqualTo(BigDecimal value) {
            addCriterion("OPERATE_MONEY =", value, "operateMoney");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyNotEqualTo(BigDecimal value) {
            addCriterion("OPERATE_MONEY <>", value, "operateMoney");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyGreaterThan(BigDecimal value) {
            addCriterion("OPERATE_MONEY >", value, "operateMoney");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OPERATE_MONEY >=", value, "operateMoney");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyLessThan(BigDecimal value) {
            addCriterion("OPERATE_MONEY <", value, "operateMoney");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OPERATE_MONEY <=", value, "operateMoney");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyIn(List<BigDecimal> values) {
            addCriterion("OPERATE_MONEY in", values, "operateMoney");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyNotIn(List<BigDecimal> values) {
            addCriterion("OPERATE_MONEY not in", values, "operateMoney");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPERATE_MONEY between", value1, value2, "operateMoney");
            return (Criteria) this;
        }

        public Criteria andOperateMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPERATE_MONEY not between", value1, value2, "operateMoney");
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

        public Criteria andAddIpIsNull() {
            addCriterion("ADD_IP is null");
            return (Criteria) this;
        }

        public Criteria andAddIpIsNotNull() {
            addCriterion("ADD_IP is not null");
            return (Criteria) this;
        }

        public Criteria andAddIpEqualTo(String value) {
            addCriterion("ADD_IP =", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotEqualTo(String value) {
            addCriterion("ADD_IP <>", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpGreaterThan(String value) {
            addCriterion("ADD_IP >", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpGreaterThanOrEqualTo(String value) {
            addCriterion("ADD_IP >=", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpLessThan(String value) {
            addCriterion("ADD_IP <", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpLessThanOrEqualTo(String value) {
            addCriterion("ADD_IP <=", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpLike(String value) {
            addCriterion("ADD_IP like", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotLike(String value) {
            addCriterion("ADD_IP not like", value, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpIn(List<String> values) {
            addCriterion("ADD_IP in", values, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotIn(List<String> values) {
            addCriterion("ADD_IP not in", values, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpBetween(String value1, String value2) {
            addCriterion("ADD_IP between", value1, value2, "addIp");
            return (Criteria) this;
        }

        public Criteria andAddIpNotBetween(String value1, String value2) {
            addCriterion("ADD_IP not between", value1, value2, "addIp");
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
