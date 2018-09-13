package com.holley.charging.model.dcs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.holley.charging.common.model.BaseExample;

public class DcsChargerecordExample extends BaseExample {

    protected String         orderByClause;

    protected boolean        distinct;

    protected List<Criteria> oredCriteria;

    public DcsChargerecordExample() {
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

        public Criteria andChargeidIsNull() {
            addCriterion("CHARGEID is null");
            return (Criteria) this;
        }

        public Criteria andChargeidIsNotNull() {
            addCriterion("CHARGEID is not null");
            return (Criteria) this;
        }

        public Criteria andChargeidEqualTo(Integer value) {
            addCriterion("CHARGEID =", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidNotEqualTo(Integer value) {
            addCriterion("CHARGEID <>", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidGreaterThan(Integer value) {
            addCriterion("CHARGEID >", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHARGEID >=", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidLessThan(Integer value) {
            addCriterion("CHARGEID <", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidLessThanOrEqualTo(Integer value) {
            addCriterion("CHARGEID <=", value, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidIn(List<Integer> values) {
            addCriterion("CHARGEID in", values, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidNotIn(List<Integer> values) {
            addCriterion("CHARGEID not in", values, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidBetween(Integer value1, Integer value2) {
            addCriterion("CHARGEID between", value1, value2, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeidNotBetween(Integer value1, Integer value2) {
            addCriterion("CHARGEID not between", value1, value2, "chargeid");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNull() {
            addCriterion("CHARGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNotNull() {
            addCriterion("CHARGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeEqualTo(Short value) {
            addCriterion("CHARGE_TYPE =", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotEqualTo(Short value) {
            addCriterion("CHARGE_TYPE <>", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThan(Short value) {
            addCriterion("CHARGE_TYPE >", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("CHARGE_TYPE >=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThan(Short value) {
            addCriterion("CHARGE_TYPE <", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThanOrEqualTo(Short value) {
            addCriterion("CHARGE_TYPE <=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIn(List<Short> values) {
            addCriterion("CHARGE_TYPE in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotIn(List<Short> values) {
            addCriterion("CHARGE_TYPE not in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeBetween(Short value1, Short value2) {
            addCriterion("CHARGE_TYPE between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotBetween(Short value1, Short value2) {
            addCriterion("CHARGE_TYPE not between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andPileNumIsNull() {
            addCriterion("PILE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPileNumIsNotNull() {
            addCriterion("PILE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPileNumEqualTo(Short value) {
            addCriterion("PILE_NUM =", value, "pileNum");
            return (Criteria) this;
        }

        public Criteria andPileNumNotEqualTo(Short value) {
            addCriterion("PILE_NUM <>", value, "pileNum");
            return (Criteria) this;
        }

        public Criteria andPileNumGreaterThan(Short value) {
            addCriterion("PILE_NUM >", value, "pileNum");
            return (Criteria) this;
        }

        public Criteria andPileNumGreaterThanOrEqualTo(Short value) {
            addCriterion("PILE_NUM >=", value, "pileNum");
            return (Criteria) this;
        }

        public Criteria andPileNumLessThan(Short value) {
            addCriterion("PILE_NUM <", value, "pileNum");
            return (Criteria) this;
        }

        public Criteria andPileNumLessThanOrEqualTo(Short value) {
            addCriterion("PILE_NUM <=", value, "pileNum");
            return (Criteria) this;
        }

        public Criteria andPileNumIn(List<Short> values) {
            addCriterion("PILE_NUM in", values, "pileNum");
            return (Criteria) this;
        }

        public Criteria andPileNumNotIn(List<Short> values) {
            addCriterion("PILE_NUM not in", values, "pileNum");
            return (Criteria) this;
        }

        public Criteria andPileNumBetween(Short value1, Short value2) {
            addCriterion("PILE_NUM between", value1, value2, "pileNum");
            return (Criteria) this;
        }

        public Criteria andPileNumNotBetween(Short value1, Short value2) {
            addCriterion("PILE_NUM not between", value1, value2, "pileNum");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("TRADE_NO is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("TRADE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("TRADE_NO =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("TRADE_NO <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("TRADE_NO >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE_NO >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("TRADE_NO <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("TRADE_NO <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("TRADE_NO like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("TRADE_NO not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("TRADE_NO in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("TRADE_NO not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("TRADE_NO between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("TRADE_NO not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNull() {
            addCriterion("PAY_NO is null");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNotNull() {
            addCriterion("PAY_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPayNoEqualTo(String value) {
            addCriterion("PAY_NO =", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotEqualTo(String value) {
            addCriterion("PAY_NO <>", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThan(String value) {
            addCriterion("PAY_NO >", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_NO >=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThan(String value) {
            addCriterion("PAY_NO <", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThanOrEqualTo(String value) {
            addCriterion("PAY_NO <=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLike(String value) {
            addCriterion("PAY_NO like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotLike(String value) {
            addCriterion("PAY_NO not like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoIn(List<String> values) {
            addCriterion("PAY_NO in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotIn(List<String> values) {
            addCriterion("PAY_NO not in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoBetween(String value1, String value2) {
            addCriterion("PAY_NO between", value1, value2, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotBetween(String value1, String value2) {
            addCriterion("PAY_NO not between", value1, value2, "payNo");
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

        public Criteria andIsTimesIsNull() {
            addCriterion("IS_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andIsTimesIsNotNull() {
            addCriterion("IS_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andIsTimesEqualTo(Short value) {
            addCriterion("IS_TIMES =", value, "isTimes");
            return (Criteria) this;
        }

        public Criteria andIsTimesNotEqualTo(Short value) {
            addCriterion("IS_TIMES <>", value, "isTimes");
            return (Criteria) this;
        }

        public Criteria andIsTimesGreaterThan(Short value) {
            addCriterion("IS_TIMES >", value, "isTimes");
            return (Criteria) this;
        }

        public Criteria andIsTimesGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_TIMES >=", value, "isTimes");
            return (Criteria) this;
        }

        public Criteria andIsTimesLessThan(Short value) {
            addCriterion("IS_TIMES <", value, "isTimes");
            return (Criteria) this;
        }

        public Criteria andIsTimesLessThanOrEqualTo(Short value) {
            addCriterion("IS_TIMES <=", value, "isTimes");
            return (Criteria) this;
        }

        public Criteria andIsTimesIn(List<Short> values) {
            addCriterion("IS_TIMES in", values, "isTimes");
            return (Criteria) this;
        }

        public Criteria andIsTimesNotIn(List<Short> values) {
            addCriterion("IS_TIMES not in", values, "isTimes");
            return (Criteria) this;
        }

        public Criteria andIsTimesBetween(Short value1, Short value2) {
            addCriterion("IS_TIMES between", value1, value2, "isTimes");
            return (Criteria) this;
        }

        public Criteria andIsTimesNotBetween(Short value1, Short value2) {
            addCriterion("IS_TIMES not between", value1, value2, "isTimes");
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

        public Criteria andBmj1IsNull() {
            addCriterion("BMJ1 is null");
            return (Criteria) this;
        }

        public Criteria andBmj1IsNotNull() {
            addCriterion("BMJ1 is not null");
            return (Criteria) this;
        }

        public Criteria andBmj1EqualTo(Double value) {
            addCriterion("BMJ1 =", value, "bmj1");
            return (Criteria) this;
        }

        public Criteria andBmj1NotEqualTo(Double value) {
            addCriterion("BMJ1 <>", value, "bmj1");
            return (Criteria) this;
        }

        public Criteria andBmj1GreaterThan(Double value) {
            addCriterion("BMJ1 >", value, "bmj1");
            return (Criteria) this;
        }

        public Criteria andBmj1GreaterThanOrEqualTo(Double value) {
            addCriterion("BMJ1 >=", value, "bmj1");
            return (Criteria) this;
        }

        public Criteria andBmj1LessThan(Double value) {
            addCriterion("BMJ1 <", value, "bmj1");
            return (Criteria) this;
        }

        public Criteria andBmj1LessThanOrEqualTo(Double value) {
            addCriterion("BMJ1 <=", value, "bmj1");
            return (Criteria) this;
        }

        public Criteria andBmj1In(List<Double> values) {
            addCriterion("BMJ1 in", values, "bmj1");
            return (Criteria) this;
        }

        public Criteria andBmj1NotIn(List<Double> values) {
            addCriterion("BMJ1 not in", values, "bmj1");
            return (Criteria) this;
        }

        public Criteria andBmj1Between(Double value1, Double value2) {
            addCriterion("BMJ1 between", value1, value2, "bmj1");
            return (Criteria) this;
        }

        public Criteria andBmj1NotBetween(Double value1, Double value2) {
            addCriterion("BMJ1 not between", value1, value2, "bmj1");
            return (Criteria) this;
        }

        public Criteria andBmj2IsNull() {
            addCriterion("BMJ2 is null");
            return (Criteria) this;
        }

        public Criteria andBmj2IsNotNull() {
            addCriterion("BMJ2 is not null");
            return (Criteria) this;
        }

        public Criteria andBmj2EqualTo(Double value) {
            addCriterion("BMJ2 =", value, "bmj2");
            return (Criteria) this;
        }

        public Criteria andBmj2NotEqualTo(Double value) {
            addCriterion("BMJ2 <>", value, "bmj2");
            return (Criteria) this;
        }

        public Criteria andBmj2GreaterThan(Double value) {
            addCriterion("BMJ2 >", value, "bmj2");
            return (Criteria) this;
        }

        public Criteria andBmj2GreaterThanOrEqualTo(Double value) {
            addCriterion("BMJ2 >=", value, "bmj2");
            return (Criteria) this;
        }

        public Criteria andBmj2LessThan(Double value) {
            addCriterion("BMJ2 <", value, "bmj2");
            return (Criteria) this;
        }

        public Criteria andBmj2LessThanOrEqualTo(Double value) {
            addCriterion("BMJ2 <=", value, "bmj2");
            return (Criteria) this;
        }

        public Criteria andBmj2In(List<Double> values) {
            addCriterion("BMJ2 in", values, "bmj2");
            return (Criteria) this;
        }

        public Criteria andBmj2NotIn(List<Double> values) {
            addCriterion("BMJ2 not in", values, "bmj2");
            return (Criteria) this;
        }

        public Criteria andBmj2Between(Double value1, Double value2) {
            addCriterion("BMJ2 between", value1, value2, "bmj2");
            return (Criteria) this;
        }

        public Criteria andBmj2NotBetween(Double value1, Double value2) {
            addCriterion("BMJ2 not between", value1, value2, "bmj2");
            return (Criteria) this;
        }

        public Criteria andBmf1IsNull() {
            addCriterion("BMF1 is null");
            return (Criteria) this;
        }

        public Criteria andBmf1IsNotNull() {
            addCriterion("BMF1 is not null");
            return (Criteria) this;
        }

        public Criteria andBmf1EqualTo(Double value) {
            addCriterion("BMF1 =", value, "bmf1");
            return (Criteria) this;
        }

        public Criteria andBmf1NotEqualTo(Double value) {
            addCriterion("BMF1 <>", value, "bmf1");
            return (Criteria) this;
        }

        public Criteria andBmf1GreaterThan(Double value) {
            addCriterion("BMF1 >", value, "bmf1");
            return (Criteria) this;
        }

        public Criteria andBmf1GreaterThanOrEqualTo(Double value) {
            addCriterion("BMF1 >=", value, "bmf1");
            return (Criteria) this;
        }

        public Criteria andBmf1LessThan(Double value) {
            addCriterion("BMF1 <", value, "bmf1");
            return (Criteria) this;
        }

        public Criteria andBmf1LessThanOrEqualTo(Double value) {
            addCriterion("BMF1 <=", value, "bmf1");
            return (Criteria) this;
        }

        public Criteria andBmf1In(List<Double> values) {
            addCriterion("BMF1 in", values, "bmf1");
            return (Criteria) this;
        }

        public Criteria andBmf1NotIn(List<Double> values) {
            addCriterion("BMF1 not in", values, "bmf1");
            return (Criteria) this;
        }

        public Criteria andBmf1Between(Double value1, Double value2) {
            addCriterion("BMF1 between", value1, value2, "bmf1");
            return (Criteria) this;
        }

        public Criteria andBmf1NotBetween(Double value1, Double value2) {
            addCriterion("BMF1 not between", value1, value2, "bmf1");
            return (Criteria) this;
        }

        public Criteria andBmf2IsNull() {
            addCriterion("BMF2 is null");
            return (Criteria) this;
        }

        public Criteria andBmf2IsNotNull() {
            addCriterion("BMF2 is not null");
            return (Criteria) this;
        }

        public Criteria andBmf2EqualTo(Double value) {
            addCriterion("BMF2 =", value, "bmf2");
            return (Criteria) this;
        }

        public Criteria andBmf2NotEqualTo(Double value) {
            addCriterion("BMF2 <>", value, "bmf2");
            return (Criteria) this;
        }

        public Criteria andBmf2GreaterThan(Double value) {
            addCriterion("BMF2 >", value, "bmf2");
            return (Criteria) this;
        }

        public Criteria andBmf2GreaterThanOrEqualTo(Double value) {
            addCriterion("BMF2 >=", value, "bmf2");
            return (Criteria) this;
        }

        public Criteria andBmf2LessThan(Double value) {
            addCriterion("BMF2 <", value, "bmf2");
            return (Criteria) this;
        }

        public Criteria andBmf2LessThanOrEqualTo(Double value) {
            addCriterion("BMF2 <=", value, "bmf2");
            return (Criteria) this;
        }

        public Criteria andBmf2In(List<Double> values) {
            addCriterion("BMF2 in", values, "bmf2");
            return (Criteria) this;
        }

        public Criteria andBmf2NotIn(List<Double> values) {
            addCriterion("BMF2 not in", values, "bmf2");
            return (Criteria) this;
        }

        public Criteria andBmf2Between(Double value1, Double value2) {
            addCriterion("BMF2 between", value1, value2, "bmf2");
            return (Criteria) this;
        }

        public Criteria andBmf2NotBetween(Double value1, Double value2) {
            addCriterion("BMF2 not between", value1, value2, "bmf2");
            return (Criteria) this;
        }

        public Criteria andBmp1IsNull() {
            addCriterion("BMP1 is null");
            return (Criteria) this;
        }

        public Criteria andBmp1IsNotNull() {
            addCriterion("BMP1 is not null");
            return (Criteria) this;
        }

        public Criteria andBmp1EqualTo(Double value) {
            addCriterion("BMP1 =", value, "bmp1");
            return (Criteria) this;
        }

        public Criteria andBmp1NotEqualTo(Double value) {
            addCriterion("BMP1 <>", value, "bmp1");
            return (Criteria) this;
        }

        public Criteria andBmp1GreaterThan(Double value) {
            addCriterion("BMP1 >", value, "bmp1");
            return (Criteria) this;
        }

        public Criteria andBmp1GreaterThanOrEqualTo(Double value) {
            addCriterion("BMP1 >=", value, "bmp1");
            return (Criteria) this;
        }

        public Criteria andBmp1LessThan(Double value) {
            addCriterion("BMP1 <", value, "bmp1");
            return (Criteria) this;
        }

        public Criteria andBmp1LessThanOrEqualTo(Double value) {
            addCriterion("BMP1 <=", value, "bmp1");
            return (Criteria) this;
        }

        public Criteria andBmp1In(List<Double> values) {
            addCriterion("BMP1 in", values, "bmp1");
            return (Criteria) this;
        }

        public Criteria andBmp1NotIn(List<Double> values) {
            addCriterion("BMP1 not in", values, "bmp1");
            return (Criteria) this;
        }

        public Criteria andBmp1Between(Double value1, Double value2) {
            addCriterion("BMP1 between", value1, value2, "bmp1");
            return (Criteria) this;
        }

        public Criteria andBmp1NotBetween(Double value1, Double value2) {
            addCriterion("BMP1 not between", value1, value2, "bmp1");
            return (Criteria) this;
        }

        public Criteria andBmp2IsNull() {
            addCriterion("BMP2 is null");
            return (Criteria) this;
        }

        public Criteria andBmp2IsNotNull() {
            addCriterion("BMP2 is not null");
            return (Criteria) this;
        }

        public Criteria andBmp2EqualTo(Double value) {
            addCriterion("BMP2 =", value, "bmp2");
            return (Criteria) this;
        }

        public Criteria andBmp2NotEqualTo(Double value) {
            addCriterion("BMP2 <>", value, "bmp2");
            return (Criteria) this;
        }

        public Criteria andBmp2GreaterThan(Double value) {
            addCriterion("BMP2 >", value, "bmp2");
            return (Criteria) this;
        }

        public Criteria andBmp2GreaterThanOrEqualTo(Double value) {
            addCriterion("BMP2 >=", value, "bmp2");
            return (Criteria) this;
        }

        public Criteria andBmp2LessThan(Double value) {
            addCriterion("BMP2 <", value, "bmp2");
            return (Criteria) this;
        }

        public Criteria andBmp2LessThanOrEqualTo(Double value) {
            addCriterion("BMP2 <=", value, "bmp2");
            return (Criteria) this;
        }

        public Criteria andBmp2In(List<Double> values) {
            addCriterion("BMP2 in", values, "bmp2");
            return (Criteria) this;
        }

        public Criteria andBmp2NotIn(List<Double> values) {
            addCriterion("BMP2 not in", values, "bmp2");
            return (Criteria) this;
        }

        public Criteria andBmp2Between(Double value1, Double value2) {
            addCriterion("BMP2 between", value1, value2, "bmp2");
            return (Criteria) this;
        }

        public Criteria andBmp2NotBetween(Double value1, Double value2) {
            addCriterion("BMP2 not between", value1, value2, "bmp2");
            return (Criteria) this;
        }

        public Criteria andBmg1IsNull() {
            addCriterion("BMG1 is null");
            return (Criteria) this;
        }

        public Criteria andBmg1IsNotNull() {
            addCriterion("BMG1 is not null");
            return (Criteria) this;
        }

        public Criteria andBmg1EqualTo(Double value) {
            addCriterion("BMG1 =", value, "bmg1");
            return (Criteria) this;
        }

        public Criteria andBmg1NotEqualTo(Double value) {
            addCriterion("BMG1 <>", value, "bmg1");
            return (Criteria) this;
        }

        public Criteria andBmg1GreaterThan(Double value) {
            addCriterion("BMG1 >", value, "bmg1");
            return (Criteria) this;
        }

        public Criteria andBmg1GreaterThanOrEqualTo(Double value) {
            addCriterion("BMG1 >=", value, "bmg1");
            return (Criteria) this;
        }

        public Criteria andBmg1LessThan(Double value) {
            addCriterion("BMG1 <", value, "bmg1");
            return (Criteria) this;
        }

        public Criteria andBmg1LessThanOrEqualTo(Double value) {
            addCriterion("BMG1 <=", value, "bmg1");
            return (Criteria) this;
        }

        public Criteria andBmg1In(List<Double> values) {
            addCriterion("BMG1 in", values, "bmg1");
            return (Criteria) this;
        }

        public Criteria andBmg1NotIn(List<Double> values) {
            addCriterion("BMG1 not in", values, "bmg1");
            return (Criteria) this;
        }

        public Criteria andBmg1Between(Double value1, Double value2) {
            addCriterion("BMG1 between", value1, value2, "bmg1");
            return (Criteria) this;
        }

        public Criteria andBmg1NotBetween(Double value1, Double value2) {
            addCriterion("BMG1 not between", value1, value2, "bmg1");
            return (Criteria) this;
        }

        public Criteria andBmg2IsNull() {
            addCriterion("BMG2 is null");
            return (Criteria) this;
        }

        public Criteria andBmg2IsNotNull() {
            addCriterion("BMG2 is not null");
            return (Criteria) this;
        }

        public Criteria andBmg2EqualTo(Double value) {
            addCriterion("BMG2 =", value, "bmg2");
            return (Criteria) this;
        }

        public Criteria andBmg2NotEqualTo(Double value) {
            addCriterion("BMG2 <>", value, "bmg2");
            return (Criteria) this;
        }

        public Criteria andBmg2GreaterThan(Double value) {
            addCriterion("BMG2 >", value, "bmg2");
            return (Criteria) this;
        }

        public Criteria andBmg2GreaterThanOrEqualTo(Double value) {
            addCriterion("BMG2 >=", value, "bmg2");
            return (Criteria) this;
        }

        public Criteria andBmg2LessThan(Double value) {
            addCriterion("BMG2 <", value, "bmg2");
            return (Criteria) this;
        }

        public Criteria andBmg2LessThanOrEqualTo(Double value) {
            addCriterion("BMG2 <=", value, "bmg2");
            return (Criteria) this;
        }

        public Criteria andBmg2In(List<Double> values) {
            addCriterion("BMG2 in", values, "bmg2");
            return (Criteria) this;
        }

        public Criteria andBmg2NotIn(List<Double> values) {
            addCriterion("BMG2 not in", values, "bmg2");
            return (Criteria) this;
        }

        public Criteria andBmg2Between(Double value1, Double value2) {
            addCriterion("BMG2 between", value1, value2, "bmg2");
            return (Criteria) this;
        }

        public Criteria andBmg2NotBetween(Double value1, Double value2) {
            addCriterion("BMG2 not between", value1, value2, "bmg2");
            return (Criteria) this;
        }

        public Criteria andMetTypeIsNull() {
            addCriterion("MET_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMetTypeIsNotNull() {
            addCriterion("MET_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMetTypeEqualTo(Double value) {
            addCriterion("MET_TYPE =", value, "metType");
            return (Criteria) this;
        }

        public Criteria andMetTypeNotEqualTo(Double value) {
            addCriterion("MET_TYPE <>", value, "metType");
            return (Criteria) this;
        }

        public Criteria andMetTypeGreaterThan(Double value) {
            addCriterion("MET_TYPE >", value, "metType");
            return (Criteria) this;
        }

        public Criteria andMetTypeGreaterThanOrEqualTo(Double value) {
            addCriterion("MET_TYPE >=", value, "metType");
            return (Criteria) this;
        }

        public Criteria andMetTypeLessThan(Double value) {
            addCriterion("MET_TYPE <", value, "metType");
            return (Criteria) this;
        }

        public Criteria andMetTypeLessThanOrEqualTo(Double value) {
            addCriterion("MET_TYPE <=", value, "metType");
            return (Criteria) this;
        }

        public Criteria andMetTypeIn(List<Double> values) {
            addCriterion("MET_TYPE in", values, "metType");
            return (Criteria) this;
        }

        public Criteria andMetTypeNotIn(List<Double> values) {
            addCriterion("MET_TYPE not in", values, "metType");
            return (Criteria) this;
        }

        public Criteria andMetTypeBetween(Double value1, Double value2) {
            addCriterion("MET_TYPE between", value1, value2, "metType");
            return (Criteria) this;
        }

        public Criteria andMetTypeNotBetween(Double value1, Double value2) {
            addCriterion("MET_TYPE not between", value1, value2, "metType");
            return (Criteria) this;
        }

        public Criteria andBmz1IsNull() {
            addCriterion("BMZ1 is null");
            return (Criteria) this;
        }

        public Criteria andBmz1IsNotNull() {
            addCriterion("BMZ1 is not null");
            return (Criteria) this;
        }

        public Criteria andBmz1EqualTo(Double value) {
            addCriterion("BMZ1 =", value, "bmz1");
            return (Criteria) this;
        }

        public Criteria andBmz1NotEqualTo(Double value) {
            addCriterion("BMZ1 <>", value, "bmz1");
            return (Criteria) this;
        }

        public Criteria andBmz1GreaterThan(Double value) {
            addCriterion("BMZ1 >", value, "bmz1");
            return (Criteria) this;
        }

        public Criteria andBmz1GreaterThanOrEqualTo(Double value) {
            addCriterion("BMZ1 >=", value, "bmz1");
            return (Criteria) this;
        }

        public Criteria andBmz1LessThan(Double value) {
            addCriterion("BMZ1 <", value, "bmz1");
            return (Criteria) this;
        }

        public Criteria andBmz1LessThanOrEqualTo(Double value) {
            addCriterion("BMZ1 <=", value, "bmz1");
            return (Criteria) this;
        }

        public Criteria andBmz1In(List<Double> values) {
            addCriterion("BMZ1 in", values, "bmz1");
            return (Criteria) this;
        }

        public Criteria andBmz1NotIn(List<Double> values) {
            addCriterion("BMZ1 not in", values, "bmz1");
            return (Criteria) this;
        }

        public Criteria andBmz1Between(Double value1, Double value2) {
            addCriterion("BMZ1 between", value1, value2, "bmz1");
            return (Criteria) this;
        }

        public Criteria andBmz1NotBetween(Double value1, Double value2) {
            addCriterion("BMZ1 not between", value1, value2, "bmz1");
            return (Criteria) this;
        }

        public Criteria andBmz2IsNull() {
            addCriterion("BMZ2 is null");
            return (Criteria) this;
        }

        public Criteria andBmz2IsNotNull() {
            addCriterion("BMZ2 is not null");
            return (Criteria) this;
        }

        public Criteria andBmz2EqualTo(Double value) {
            addCriterion("BMZ2 =", value, "bmz2");
            return (Criteria) this;
        }

        public Criteria andBmz2NotEqualTo(Double value) {
            addCriterion("BMZ2 <>", value, "bmz2");
            return (Criteria) this;
        }

        public Criteria andBmz2GreaterThan(Double value) {
            addCriterion("BMZ2 >", value, "bmz2");
            return (Criteria) this;
        }

        public Criteria andBmz2GreaterThanOrEqualTo(Double value) {
            addCriterion("BMZ2 >=", value, "bmz2");
            return (Criteria) this;
        }

        public Criteria andBmz2LessThan(Double value) {
            addCriterion("BMZ2 <", value, "bmz2");
            return (Criteria) this;
        }

        public Criteria andBmz2LessThanOrEqualTo(Double value) {
            addCriterion("BMZ2 <=", value, "bmz2");
            return (Criteria) this;
        }

        public Criteria andBmz2In(List<Double> values) {
            addCriterion("BMZ2 in", values, "bmz2");
            return (Criteria) this;
        }

        public Criteria andBmz2NotIn(List<Double> values) {
            addCriterion("BMZ2 not in", values, "bmz2");
            return (Criteria) this;
        }

        public Criteria andBmz2Between(Double value1, Double value2) {
            addCriterion("BMZ2 between", value1, value2, "bmz2");
            return (Criteria) this;
        }

        public Criteria andBmz2NotBetween(Double value1, Double value2) {
            addCriterion("BMZ2 not between", value1, value2, "bmz2");
            return (Criteria) this;
        }

        public Criteria andDjjIsNull() {
            addCriterion("DJJ is null");
            return (Criteria) this;
        }

        public Criteria andDjjIsNotNull() {
            addCriterion("DJJ is not null");
            return (Criteria) this;
        }

        public Criteria andDjjEqualTo(BigDecimal value) {
            addCriterion("DJJ =", value, "djj");
            return (Criteria) this;
        }

        public Criteria andDjjNotEqualTo(BigDecimal value) {
            addCriterion("DJJ <>", value, "djj");
            return (Criteria) this;
        }

        public Criteria andDjjGreaterThan(BigDecimal value) {
            addCriterion("DJJ >", value, "djj");
            return (Criteria) this;
        }

        public Criteria andDjjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DJJ >=", value, "djj");
            return (Criteria) this;
        }

        public Criteria andDjjLessThan(BigDecimal value) {
            addCriterion("DJJ <", value, "djj");
            return (Criteria) this;
        }

        public Criteria andDjjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DJJ <=", value, "djj");
            return (Criteria) this;
        }

        public Criteria andDjjIn(List<BigDecimal> values) {
            addCriterion("DJJ in", values, "djj");
            return (Criteria) this;
        }

        public Criteria andDjjNotIn(List<BigDecimal> values) {
            addCriterion("DJJ not in", values, "djj");
            return (Criteria) this;
        }

        public Criteria andDjjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DJJ between", value1, value2, "djj");
            return (Criteria) this;
        }

        public Criteria andDjjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DJJ not between", value1, value2, "djj");
            return (Criteria) this;
        }

        public Criteria andDljIsNull() {
            addCriterion("DLJ is null");
            return (Criteria) this;
        }

        public Criteria andDljIsNotNull() {
            addCriterion("DLJ is not null");
            return (Criteria) this;
        }

        public Criteria andDljEqualTo(Double value) {
            addCriterion("DLJ =", value, "dlj");
            return (Criteria) this;
        }

        public Criteria andDljNotEqualTo(Double value) {
            addCriterion("DLJ <>", value, "dlj");
            return (Criteria) this;
        }

        public Criteria andDljGreaterThan(Double value) {
            addCriterion("DLJ >", value, "dlj");
            return (Criteria) this;
        }

        public Criteria andDljGreaterThanOrEqualTo(Double value) {
            addCriterion("DLJ >=", value, "dlj");
            return (Criteria) this;
        }

        public Criteria andDljLessThan(Double value) {
            addCriterion("DLJ <", value, "dlj");
            return (Criteria) this;
        }

        public Criteria andDljLessThanOrEqualTo(Double value) {
            addCriterion("DLJ <=", value, "dlj");
            return (Criteria) this;
        }

        public Criteria andDljIn(List<Double> values) {
            addCriterion("DLJ in", values, "dlj");
            return (Criteria) this;
        }

        public Criteria andDljNotIn(List<Double> values) {
            addCriterion("DLJ not in", values, "dlj");
            return (Criteria) this;
        }

        public Criteria andDljBetween(Double value1, Double value2) {
            addCriterion("DLJ between", value1, value2, "dlj");
            return (Criteria) this;
        }

        public Criteria andDljNotBetween(Double value1, Double value2) {
            addCriterion("DLJ not between", value1, value2, "dlj");
            return (Criteria) this;
        }

        public Criteria andJejIsNull() {
            addCriterion("JEJ is null");
            return (Criteria) this;
        }

        public Criteria andJejIsNotNull() {
            addCriterion("JEJ is not null");
            return (Criteria) this;
        }

        public Criteria andJejEqualTo(BigDecimal value) {
            addCriterion("JEJ =", value, "jej");
            return (Criteria) this;
        }

        public Criteria andJejNotEqualTo(BigDecimal value) {
            addCriterion("JEJ <>", value, "jej");
            return (Criteria) this;
        }

        public Criteria andJejGreaterThan(BigDecimal value) {
            addCriterion("JEJ >", value, "jej");
            return (Criteria) this;
        }

        public Criteria andJejGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("JEJ >=", value, "jej");
            return (Criteria) this;
        }

        public Criteria andJejLessThan(BigDecimal value) {
            addCriterion("JEJ <", value, "jej");
            return (Criteria) this;
        }

        public Criteria andJejLessThanOrEqualTo(BigDecimal value) {
            addCriterion("JEJ <=", value, "jej");
            return (Criteria) this;
        }

        public Criteria andJejIn(List<BigDecimal> values) {
            addCriterion("JEJ in", values, "jej");
            return (Criteria) this;
        }

        public Criteria andJejNotIn(List<BigDecimal> values) {
            addCriterion("JEJ not in", values, "jej");
            return (Criteria) this;
        }

        public Criteria andJejBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JEJ between", value1, value2, "jej");
            return (Criteria) this;
        }

        public Criteria andJejNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JEJ not between", value1, value2, "jej");
            return (Criteria) this;
        }

        public Criteria andDjfIsNull() {
            addCriterion("DJF is null");
            return (Criteria) this;
        }

        public Criteria andDjfIsNotNull() {
            addCriterion("DJF is not null");
            return (Criteria) this;
        }

        public Criteria andDjfEqualTo(BigDecimal value) {
            addCriterion("DJF =", value, "djf");
            return (Criteria) this;
        }

        public Criteria andDjfNotEqualTo(BigDecimal value) {
            addCriterion("DJF <>", value, "djf");
            return (Criteria) this;
        }

        public Criteria andDjfGreaterThan(BigDecimal value) {
            addCriterion("DJF >", value, "djf");
            return (Criteria) this;
        }

        public Criteria andDjfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DJF >=", value, "djf");
            return (Criteria) this;
        }

        public Criteria andDjfLessThan(BigDecimal value) {
            addCriterion("DJF <", value, "djf");
            return (Criteria) this;
        }

        public Criteria andDjfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DJF <=", value, "djf");
            return (Criteria) this;
        }

        public Criteria andDjfIn(List<BigDecimal> values) {
            addCriterion("DJF in", values, "djf");
            return (Criteria) this;
        }

        public Criteria andDjfNotIn(List<BigDecimal> values) {
            addCriterion("DJF not in", values, "djf");
            return (Criteria) this;
        }

        public Criteria andDjfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DJF between", value1, value2, "djf");
            return (Criteria) this;
        }

        public Criteria andDjfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DJF not between", value1, value2, "djf");
            return (Criteria) this;
        }

        public Criteria andDlfIsNull() {
            addCriterion("DLF is null");
            return (Criteria) this;
        }

        public Criteria andDlfIsNotNull() {
            addCriterion("DLF is not null");
            return (Criteria) this;
        }

        public Criteria andDlfEqualTo(Double value) {
            addCriterion("DLF =", value, "dlf");
            return (Criteria) this;
        }

        public Criteria andDlfNotEqualTo(Double value) {
            addCriterion("DLF <>", value, "dlf");
            return (Criteria) this;
        }

        public Criteria andDlfGreaterThan(Double value) {
            addCriterion("DLF >", value, "dlf");
            return (Criteria) this;
        }

        public Criteria andDlfGreaterThanOrEqualTo(Double value) {
            addCriterion("DLF >=", value, "dlf");
            return (Criteria) this;
        }

        public Criteria andDlfLessThan(Double value) {
            addCriterion("DLF <", value, "dlf");
            return (Criteria) this;
        }

        public Criteria andDlfLessThanOrEqualTo(Double value) {
            addCriterion("DLF <=", value, "dlf");
            return (Criteria) this;
        }

        public Criteria andDlfIn(List<Double> values) {
            addCriterion("DLF in", values, "dlf");
            return (Criteria) this;
        }

        public Criteria andDlfNotIn(List<Double> values) {
            addCriterion("DLF not in", values, "dlf");
            return (Criteria) this;
        }

        public Criteria andDlfBetween(Double value1, Double value2) {
            addCriterion("DLF between", value1, value2, "dlf");
            return (Criteria) this;
        }

        public Criteria andDlfNotBetween(Double value1, Double value2) {
            addCriterion("DLF not between", value1, value2, "dlf");
            return (Criteria) this;
        }

        public Criteria andJefIsNull() {
            addCriterion("JEF is null");
            return (Criteria) this;
        }

        public Criteria andJefIsNotNull() {
            addCriterion("JEF is not null");
            return (Criteria) this;
        }

        public Criteria andJefEqualTo(BigDecimal value) {
            addCriterion("JEF =", value, "jef");
            return (Criteria) this;
        }

        public Criteria andJefNotEqualTo(BigDecimal value) {
            addCriterion("JEF <>", value, "jef");
            return (Criteria) this;
        }

        public Criteria andJefGreaterThan(BigDecimal value) {
            addCriterion("JEF >", value, "jef");
            return (Criteria) this;
        }

        public Criteria andJefGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("JEF >=", value, "jef");
            return (Criteria) this;
        }

        public Criteria andJefLessThan(BigDecimal value) {
            addCriterion("JEF <", value, "jef");
            return (Criteria) this;
        }

        public Criteria andJefLessThanOrEqualTo(BigDecimal value) {
            addCriterion("JEF <=", value, "jef");
            return (Criteria) this;
        }

        public Criteria andJefIn(List<BigDecimal> values) {
            addCriterion("JEF in", values, "jef");
            return (Criteria) this;
        }

        public Criteria andJefNotIn(List<BigDecimal> values) {
            addCriterion("JEF not in", values, "jef");
            return (Criteria) this;
        }

        public Criteria andJefBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JEF between", value1, value2, "jef");
            return (Criteria) this;
        }

        public Criteria andJefNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JEF not between", value1, value2, "jef");
            return (Criteria) this;
        }

        public Criteria andDjpIsNull() {
            addCriterion("DJP is null");
            return (Criteria) this;
        }

        public Criteria andDjpIsNotNull() {
            addCriterion("DJP is not null");
            return (Criteria) this;
        }

        public Criteria andDjpEqualTo(BigDecimal value) {
            addCriterion("DJP =", value, "djp");
            return (Criteria) this;
        }

        public Criteria andDjpNotEqualTo(BigDecimal value) {
            addCriterion("DJP <>", value, "djp");
            return (Criteria) this;
        }

        public Criteria andDjpGreaterThan(BigDecimal value) {
            addCriterion("DJP >", value, "djp");
            return (Criteria) this;
        }

        public Criteria andDjpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DJP >=", value, "djp");
            return (Criteria) this;
        }

        public Criteria andDjpLessThan(BigDecimal value) {
            addCriterion("DJP <", value, "djp");
            return (Criteria) this;
        }

        public Criteria andDjpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DJP <=", value, "djp");
            return (Criteria) this;
        }

        public Criteria andDjpIn(List<BigDecimal> values) {
            addCriterion("DJP in", values, "djp");
            return (Criteria) this;
        }

        public Criteria andDjpNotIn(List<BigDecimal> values) {
            addCriterion("DJP not in", values, "djp");
            return (Criteria) this;
        }

        public Criteria andDjpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DJP between", value1, value2, "djp");
            return (Criteria) this;
        }

        public Criteria andDjpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DJP not between", value1, value2, "djp");
            return (Criteria) this;
        }

        public Criteria andDlpIsNull() {
            addCriterion("DLP is null");
            return (Criteria) this;
        }

        public Criteria andDlpIsNotNull() {
            addCriterion("DLP is not null");
            return (Criteria) this;
        }

        public Criteria andDlpEqualTo(Double value) {
            addCriterion("DLP =", value, "dlp");
            return (Criteria) this;
        }

        public Criteria andDlpNotEqualTo(Double value) {
            addCriterion("DLP <>", value, "dlp");
            return (Criteria) this;
        }

        public Criteria andDlpGreaterThan(Double value) {
            addCriterion("DLP >", value, "dlp");
            return (Criteria) this;
        }

        public Criteria andDlpGreaterThanOrEqualTo(Double value) {
            addCriterion("DLP >=", value, "dlp");
            return (Criteria) this;
        }

        public Criteria andDlpLessThan(Double value) {
            addCriterion("DLP <", value, "dlp");
            return (Criteria) this;
        }

        public Criteria andDlpLessThanOrEqualTo(Double value) {
            addCriterion("DLP <=", value, "dlp");
            return (Criteria) this;
        }

        public Criteria andDlpIn(List<Double> values) {
            addCriterion("DLP in", values, "dlp");
            return (Criteria) this;
        }

        public Criteria andDlpNotIn(List<Double> values) {
            addCriterion("DLP not in", values, "dlp");
            return (Criteria) this;
        }

        public Criteria andDlpBetween(Double value1, Double value2) {
            addCriterion("DLP between", value1, value2, "dlp");
            return (Criteria) this;
        }

        public Criteria andDlpNotBetween(Double value1, Double value2) {
            addCriterion("DLP not between", value1, value2, "dlp");
            return (Criteria) this;
        }

        public Criteria andJepIsNull() {
            addCriterion("JEP is null");
            return (Criteria) this;
        }

        public Criteria andJepIsNotNull() {
            addCriterion("JEP is not null");
            return (Criteria) this;
        }

        public Criteria andJepEqualTo(BigDecimal value) {
            addCriterion("JEP =", value, "jep");
            return (Criteria) this;
        }

        public Criteria andJepNotEqualTo(BigDecimal value) {
            addCriterion("JEP <>", value, "jep");
            return (Criteria) this;
        }

        public Criteria andJepGreaterThan(BigDecimal value) {
            addCriterion("JEP >", value, "jep");
            return (Criteria) this;
        }

        public Criteria andJepGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("JEP >=", value, "jep");
            return (Criteria) this;
        }

        public Criteria andJepLessThan(BigDecimal value) {
            addCriterion("JEP <", value, "jep");
            return (Criteria) this;
        }

        public Criteria andJepLessThanOrEqualTo(BigDecimal value) {
            addCriterion("JEP <=", value, "jep");
            return (Criteria) this;
        }

        public Criteria andJepIn(List<BigDecimal> values) {
            addCriterion("JEP in", values, "jep");
            return (Criteria) this;
        }

        public Criteria andJepNotIn(List<BigDecimal> values) {
            addCriterion("JEP not in", values, "jep");
            return (Criteria) this;
        }

        public Criteria andJepBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JEP between", value1, value2, "jep");
            return (Criteria) this;
        }

        public Criteria andJepNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JEP not between", value1, value2, "jep");
            return (Criteria) this;
        }

        public Criteria andDjgIsNull() {
            addCriterion("DJG is null");
            return (Criteria) this;
        }

        public Criteria andDjgIsNotNull() {
            addCriterion("DJG is not null");
            return (Criteria) this;
        }

        public Criteria andDjgEqualTo(BigDecimal value) {
            addCriterion("DJG =", value, "djg");
            return (Criteria) this;
        }

        public Criteria andDjgNotEqualTo(BigDecimal value) {
            addCriterion("DJG <>", value, "djg");
            return (Criteria) this;
        }

        public Criteria andDjgGreaterThan(BigDecimal value) {
            addCriterion("DJG >", value, "djg");
            return (Criteria) this;
        }

        public Criteria andDjgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DJG >=", value, "djg");
            return (Criteria) this;
        }

        public Criteria andDjgLessThan(BigDecimal value) {
            addCriterion("DJG <", value, "djg");
            return (Criteria) this;
        }

        public Criteria andDjgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DJG <=", value, "djg");
            return (Criteria) this;
        }

        public Criteria andDjgIn(List<BigDecimal> values) {
            addCriterion("DJG in", values, "djg");
            return (Criteria) this;
        }

        public Criteria andDjgNotIn(List<BigDecimal> values) {
            addCriterion("DJG not in", values, "djg");
            return (Criteria) this;
        }

        public Criteria andDjgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DJG between", value1, value2, "djg");
            return (Criteria) this;
        }

        public Criteria andDjgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DJG not between", value1, value2, "djg");
            return (Criteria) this;
        }

        public Criteria andDlgIsNull() {
            addCriterion("DLG is null");
            return (Criteria) this;
        }

        public Criteria andDlgIsNotNull() {
            addCriterion("DLG is not null");
            return (Criteria) this;
        }

        public Criteria andDlgEqualTo(Double value) {
            addCriterion("DLG =", value, "dlg");
            return (Criteria) this;
        }

        public Criteria andDlgNotEqualTo(Double value) {
            addCriterion("DLG <>", value, "dlg");
            return (Criteria) this;
        }

        public Criteria andDlgGreaterThan(Double value) {
            addCriterion("DLG >", value, "dlg");
            return (Criteria) this;
        }

        public Criteria andDlgGreaterThanOrEqualTo(Double value) {
            addCriterion("DLG >=", value, "dlg");
            return (Criteria) this;
        }

        public Criteria andDlgLessThan(Double value) {
            addCriterion("DLG <", value, "dlg");
            return (Criteria) this;
        }

        public Criteria andDlgLessThanOrEqualTo(Double value) {
            addCriterion("DLG <=", value, "dlg");
            return (Criteria) this;
        }

        public Criteria andDlgIn(List<Double> values) {
            addCriterion("DLG in", values, "dlg");
            return (Criteria) this;
        }

        public Criteria andDlgNotIn(List<Double> values) {
            addCriterion("DLG not in", values, "dlg");
            return (Criteria) this;
        }

        public Criteria andDlgBetween(Double value1, Double value2) {
            addCriterion("DLG between", value1, value2, "dlg");
            return (Criteria) this;
        }

        public Criteria andDlgNotBetween(Double value1, Double value2) {
            addCriterion("DLG not between", value1, value2, "dlg");
            return (Criteria) this;
        }

        public Criteria andJegIsNull() {
            addCriterion("JEG is null");
            return (Criteria) this;
        }

        public Criteria andJegIsNotNull() {
            addCriterion("JEG is not null");
            return (Criteria) this;
        }

        public Criteria andJegEqualTo(BigDecimal value) {
            addCriterion("JEG =", value, "jeg");
            return (Criteria) this;
        }

        public Criteria andJegNotEqualTo(BigDecimal value) {
            addCriterion("JEG <>", value, "jeg");
            return (Criteria) this;
        }

        public Criteria andJegGreaterThan(BigDecimal value) {
            addCriterion("JEG >", value, "jeg");
            return (Criteria) this;
        }

        public Criteria andJegGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("JEG >=", value, "jeg");
            return (Criteria) this;
        }

        public Criteria andJegLessThan(BigDecimal value) {
            addCriterion("JEG <", value, "jeg");
            return (Criteria) this;
        }

        public Criteria andJegLessThanOrEqualTo(BigDecimal value) {
            addCriterion("JEG <=", value, "jeg");
            return (Criteria) this;
        }

        public Criteria andJegIn(List<BigDecimal> values) {
            addCriterion("JEG in", values, "jeg");
            return (Criteria) this;
        }

        public Criteria andJegNotIn(List<BigDecimal> values) {
            addCriterion("JEG not in", values, "jeg");
            return (Criteria) this;
        }

        public Criteria andJegBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JEG between", value1, value2, "jeg");
            return (Criteria) this;
        }

        public Criteria andJegNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JEG not between", value1, value2, "jeg");
            return (Criteria) this;
        }

        public Criteria andDlzIsNull() {
            addCriterion("DLZ is null");
            return (Criteria) this;
        }

        public Criteria andDlzIsNotNull() {
            addCriterion("DLZ is not null");
            return (Criteria) this;
        }

        public Criteria andDlzEqualTo(Double value) {
            addCriterion("DLZ =", value, "dlz");
            return (Criteria) this;
        }

        public Criteria andDlzNotEqualTo(Double value) {
            addCriterion("DLZ <>", value, "dlz");
            return (Criteria) this;
        }

        public Criteria andDlzGreaterThan(Double value) {
            addCriterion("DLZ >", value, "dlz");
            return (Criteria) this;
        }

        public Criteria andDlzGreaterThanOrEqualTo(Double value) {
            addCriterion("DLZ >=", value, "dlz");
            return (Criteria) this;
        }

        public Criteria andDlzLessThan(Double value) {
            addCriterion("DLZ <", value, "dlz");
            return (Criteria) this;
        }

        public Criteria andDlzLessThanOrEqualTo(Double value) {
            addCriterion("DLZ <=", value, "dlz");
            return (Criteria) this;
        }

        public Criteria andDlzIn(List<Double> values) {
            addCriterion("DLZ in", values, "dlz");
            return (Criteria) this;
        }

        public Criteria andDlzNotIn(List<Double> values) {
            addCriterion("DLZ not in", values, "dlz");
            return (Criteria) this;
        }

        public Criteria andDlzBetween(Double value1, Double value2) {
            addCriterion("DLZ between", value1, value2, "dlz");
            return (Criteria) this;
        }

        public Criteria andDlzNotBetween(Double value1, Double value2) {
            addCriterion("DLZ not between", value1, value2, "dlz");
            return (Criteria) this;
        }

        public Criteria andBusTypeIsNull() {
            addCriterion("BUS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusTypeIsNotNull() {
            addCriterion("BUS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusTypeEqualTo(Short value) {
            addCriterion("BUS_TYPE =", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotEqualTo(Short value) {
            addCriterion("BUS_TYPE <>", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeGreaterThan(Short value) {
            addCriterion("BUS_TYPE >", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("BUS_TYPE >=", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeLessThan(Short value) {
            addCriterion("BUS_TYPE <", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeLessThanOrEqualTo(Short value) {
            addCriterion("BUS_TYPE <=", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeIn(List<Short> values) {
            addCriterion("BUS_TYPE in", values, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotIn(List<Short> values) {
            addCriterion("BUS_TYPE not in", values, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeBetween(Short value1, Short value2) {
            addCriterion("BUS_TYPE between", value1, value2, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotBetween(Short value1, Short value2) {
            addCriterion("BUS_TYPE not between", value1, value2, "busType");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyIsNull() {
            addCriterion("AFTER_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyIsNotNull() {
            addCriterion("AFTER_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyEqualTo(BigDecimal value) {
            addCriterion("AFTER_MONEY =", value, "afterMoney");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyNotEqualTo(BigDecimal value) {
            addCriterion("AFTER_MONEY <>", value, "afterMoney");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyGreaterThan(BigDecimal value) {
            addCriterion("AFTER_MONEY >", value, "afterMoney");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AFTER_MONEY >=", value, "afterMoney");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyLessThan(BigDecimal value) {
            addCriterion("AFTER_MONEY <", value, "afterMoney");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AFTER_MONEY <=", value, "afterMoney");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyIn(List<BigDecimal> values) {
            addCriterion("AFTER_MONEY in", values, "afterMoney");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyNotIn(List<BigDecimal> values) {
            addCriterion("AFTER_MONEY not in", values, "afterMoney");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AFTER_MONEY between", value1, value2, "afterMoney");
            return (Criteria) this;
        }

        public Criteria andAfterMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AFTER_MONEY not between", value1, value2, "afterMoney");
            return (Criteria) this;
        }

        public Criteria andXfdjIsNull() {
            addCriterion("XFDJ is null");
            return (Criteria) this;
        }

        public Criteria andXfdjIsNotNull() {
            addCriterion("XFDJ is not null");
            return (Criteria) this;
        }

        public Criteria andXfdjEqualTo(BigDecimal value) {
            addCriterion("XFDJ =", value, "xfdj");
            return (Criteria) this;
        }

        public Criteria andXfdjNotEqualTo(BigDecimal value) {
            addCriterion("XFDJ <>", value, "xfdj");
            return (Criteria) this;
        }

        public Criteria andXfdjGreaterThan(BigDecimal value) {
            addCriterion("XFDJ >", value, "xfdj");
            return (Criteria) this;
        }

        public Criteria andXfdjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XFDJ >=", value, "xfdj");
            return (Criteria) this;
        }

        public Criteria andXfdjLessThan(BigDecimal value) {
            addCriterion("XFDJ <", value, "xfdj");
            return (Criteria) this;
        }

        public Criteria andXfdjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("XFDJ <=", value, "xfdj");
            return (Criteria) this;
        }

        public Criteria andXfdjIn(List<BigDecimal> values) {
            addCriterion("XFDJ in", values, "xfdj");
            return (Criteria) this;
        }

        public Criteria andXfdjNotIn(List<BigDecimal> values) {
            addCriterion("XFDJ not in", values, "xfdj");
            return (Criteria) this;
        }

        public Criteria andXfdjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XFDJ between", value1, value2, "xfdj");
            return (Criteria) this;
        }

        public Criteria andXfdjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XFDJ not between", value1, value2, "xfdj");
            return (Criteria) this;
        }

        public Criteria andXfjeIsNull() {
            addCriterion("XFJE is null");
            return (Criteria) this;
        }

        public Criteria andXfjeIsNotNull() {
            addCriterion("XFJE is not null");
            return (Criteria) this;
        }

        public Criteria andXfjeEqualTo(BigDecimal value) {
            addCriterion("XFJE =", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeNotEqualTo(BigDecimal value) {
            addCriterion("XFJE <>", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeGreaterThan(BigDecimal value) {
            addCriterion("XFJE >", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XFJE >=", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeLessThan(BigDecimal value) {
            addCriterion("XFJE <", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("XFJE <=", value, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeIn(List<BigDecimal> values) {
            addCriterion("XFJE in", values, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeNotIn(List<BigDecimal> values) {
            addCriterion("XFJE not in", values, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XFJE between", value1, value2, "xfje");
            return (Criteria) this;
        }

        public Criteria andXfjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XFJE not between", value1, value2, "xfje");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("MARK is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("MARK is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("MARK =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("MARK <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("MARK >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("MARK >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("MARK <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("MARK <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("MARK like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("MARK not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("MARK in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("MARK not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("MARK between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("MARK not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("PAY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("PAY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Short value) {
            addCriterion("PAY_STATUS =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Short value) {
            addCriterion("PAY_STATUS <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Short value) {
            addCriterion("PAY_STATUS >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("PAY_STATUS >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Short value) {
            addCriterion("PAY_STATUS <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Short value) {
            addCriterion("PAY_STATUS <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Short> values) {
            addCriterion("PAY_STATUS in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Short> values) {
            addCriterion("PAY_STATUS not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Short value1, Short value2) {
            addCriterion("PAY_STATUS between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Short value1, Short value2) {
            addCriterion("PAY_STATUS not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andClientNoIsNull() {
            addCriterion("CLIENT_NO is null");
            return (Criteria) this;
        }

        public Criteria andClientNoIsNotNull() {
            addCriterion("CLIENT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andClientNoEqualTo(String value) {
            addCriterion("CLIENT_NO =", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNoNotEqualTo(String value) {
            addCriterion("CLIENT_NO <>", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNoGreaterThan(String value) {
            addCriterion("CLIENT_NO >", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNoGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_NO >=", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNoLessThan(String value) {
            addCriterion("CLIENT_NO <", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNoLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_NO <=", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNoLike(String value) {
            addCriterion("CLIENT_NO like", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNoNotLike(String value) {
            addCriterion("CLIENT_NO not like", value, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNoIn(List<String> values) {
            addCriterion("CLIENT_NO in", values, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNoNotIn(List<String> values) {
            addCriterion("CLIENT_NO not in", values, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNoBetween(String value1, String value2) {
            addCriterion("CLIENT_NO between", value1, value2, "clientNo");
            return (Criteria) this;
        }

        public Criteria andClientNoNotBetween(String value1, String value2) {
            addCriterion("CLIENT_NO not between", value1, value2, "clientNo");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyIsNull() {
            addCriterion("BEFORE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyIsNotNull() {
            addCriterion("BEFORE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyEqualTo(BigDecimal value) {
            addCriterion("BEFORE_MONEY =", value, "beforeMoney");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("BEFORE_MONEY <>", value, "beforeMoney");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyGreaterThan(BigDecimal value) {
            addCriterion("BEFORE_MONEY >", value, "beforeMoney");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_MONEY >=", value, "beforeMoney");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyLessThan(BigDecimal value) {
            addCriterion("BEFORE_MONEY <", value, "beforeMoney");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BEFORE_MONEY <=", value, "beforeMoney");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyIn(List<BigDecimal> values) {
            addCriterion("BEFORE_MONEY in", values, "beforeMoney");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("BEFORE_MONEY not in", values, "beforeMoney");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_MONEY between", value1, value2, "beforeMoney");
            return (Criteria) this;
        }

        public Criteria andBeforeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BEFORE_MONEY not between", value1, value2, "beforeMoney");
            return (Criteria) this;
        }

        public Criteria andBagNoIsNull() {
            addCriterion("BAG_NO is null");
            return (Criteria) this;
        }

        public Criteria andBagNoIsNotNull() {
            addCriterion("BAG_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBagNoEqualTo(String value) {
            addCriterion("BAG_NO =", value, "bagNo");
            return (Criteria) this;
        }

        public Criteria andBagNoNotEqualTo(String value) {
            addCriterion("BAG_NO <>", value, "bagNo");
            return (Criteria) this;
        }

        public Criteria andBagNoGreaterThan(String value) {
            addCriterion("BAG_NO >", value, "bagNo");
            return (Criteria) this;
        }

        public Criteria andBagNoGreaterThanOrEqualTo(String value) {
            addCriterion("BAG_NO >=", value, "bagNo");
            return (Criteria) this;
        }

        public Criteria andBagNoLessThan(String value) {
            addCriterion("BAG_NO <", value, "bagNo");
            return (Criteria) this;
        }

        public Criteria andBagNoLessThanOrEqualTo(String value) {
            addCriterion("BAG_NO <=", value, "bagNo");
            return (Criteria) this;
        }

        public Criteria andBagNoLike(String value) {
            addCriterion("BAG_NO like", value, "bagNo");
            return (Criteria) this;
        }

        public Criteria andBagNoNotLike(String value) {
            addCriterion("BAG_NO not like", value, "bagNo");
            return (Criteria) this;
        }

        public Criteria andBagNoIn(List<String> values) {
            addCriterion("BAG_NO in", values, "bagNo");
            return (Criteria) this;
        }

        public Criteria andBagNoNotIn(List<String> values) {
            addCriterion("BAG_NO not in", values, "bagNo");
            return (Criteria) this;
        }

        public Criteria andBagNoBetween(String value1, String value2) {
            addCriterion("BAG_NO between", value1, value2, "bagNo");
            return (Criteria) this;
        }

        public Criteria andBagNoNotBetween(String value1, String value2) {
            addCriterion("BAG_NO not between", value1, value2, "bagNo");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNull() {
            addCriterion("PAY_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNotNull() {
            addCriterion("PAY_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyEqualTo(BigDecimal value) {
            addCriterion("PAY_MONEY =", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotEqualTo(BigDecimal value) {
            addCriterion("PAY_MONEY <>", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThan(BigDecimal value) {
            addCriterion("PAY_MONEY >", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAY_MONEY >=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThan(BigDecimal value) {
            addCriterion("PAY_MONEY <", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAY_MONEY <=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIn(List<BigDecimal> values) {
            addCriterion("PAY_MONEY in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotIn(List<BigDecimal> values) {
            addCriterion("PAY_MONEY not in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAY_MONEY between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAY_MONEY not between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNull() {
            addCriterion("DATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNotNull() {
            addCriterion("DATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDateTimeEqualTo(String value) {
            addCriterion("DATE_TIME =", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotEqualTo(String value) {
            addCriterion("DATE_TIME <>", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThan(String value) {
            addCriterion("DATE_TIME >", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("DATE_TIME >=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThan(String value) {
            addCriterion("DATE_TIME <", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThanOrEqualTo(String value) {
            addCriterion("DATE_TIME <=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLike(String value) {
            addCriterion("DATE_TIME like", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotLike(String value) {
            addCriterion("DATE_TIME not like", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeIn(List<String> values) {
            addCriterion("DATE_TIME in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotIn(List<String> values) {
            addCriterion("DATE_TIME not in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeBetween(String value1, String value2) {
            addCriterion("DATE_TIME between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotBetween(String value1, String value2) {
            addCriterion("DATE_TIME not between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andRadomNoIsNull() {
            addCriterion("RADOM_NO is null");
            return (Criteria) this;
        }

        public Criteria andRadomNoIsNotNull() {
            addCriterion("RADOM_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRadomNoEqualTo(String value) {
            addCriterion("RADOM_NO =", value, "radomNo");
            return (Criteria) this;
        }

        public Criteria andRadomNoNotEqualTo(String value) {
            addCriterion("RADOM_NO <>", value, "radomNo");
            return (Criteria) this;
        }

        public Criteria andRadomNoGreaterThan(String value) {
            addCriterion("RADOM_NO >", value, "radomNo");
            return (Criteria) this;
        }

        public Criteria andRadomNoGreaterThanOrEqualTo(String value) {
            addCriterion("RADOM_NO >=", value, "radomNo");
            return (Criteria) this;
        }

        public Criteria andRadomNoLessThan(String value) {
            addCriterion("RADOM_NO <", value, "radomNo");
            return (Criteria) this;
        }

        public Criteria andRadomNoLessThanOrEqualTo(String value) {
            addCriterion("RADOM_NO <=", value, "radomNo");
            return (Criteria) this;
        }

        public Criteria andRadomNoLike(String value) {
            addCriterion("RADOM_NO like", value, "radomNo");
            return (Criteria) this;
        }

        public Criteria andRadomNoNotLike(String value) {
            addCriterion("RADOM_NO not like", value, "radomNo");
            return (Criteria) this;
        }

        public Criteria andRadomNoIn(List<String> values) {
            addCriterion("RADOM_NO in", values, "radomNo");
            return (Criteria) this;
        }

        public Criteria andRadomNoNotIn(List<String> values) {
            addCriterion("RADOM_NO not in", values, "radomNo");
            return (Criteria) this;
        }

        public Criteria andRadomNoBetween(String value1, String value2) {
            addCriterion("RADOM_NO between", value1, value2, "radomNo");
            return (Criteria) this;
        }

        public Criteria andRadomNoNotBetween(String value1, String value2) {
            addCriterion("RADOM_NO not between", value1, value2, "radomNo");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Short value) {
            addCriterion("PAY_TYPE =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Short value) {
            addCriterion("PAY_TYPE <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Short value) {
            addCriterion("PAY_TYPE >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("PAY_TYPE >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Short value) {
            addCriterion("PAY_TYPE <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Short value) {
            addCriterion("PAY_TYPE <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Short> values) {
            addCriterion("PAY_TYPE in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Short> values) {
            addCriterion("PAY_TYPE not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Short value1, Short value2) {
            addCriterion("PAY_TYPE between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Short value1, Short value2) {
            addCriterion("PAY_TYPE not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andTacIsNull() {
            addCriterion("TAC is null");
            return (Criteria) this;
        }

        public Criteria andTacIsNotNull() {
            addCriterion("TAC is not null");
            return (Criteria) this;
        }

        public Criteria andTacEqualTo(String value) {
            addCriterion("TAC =", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacNotEqualTo(String value) {
            addCriterion("TAC <>", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacGreaterThan(String value) {
            addCriterion("TAC >", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacGreaterThanOrEqualTo(String value) {
            addCriterion("TAC >=", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacLessThan(String value) {
            addCriterion("TAC <", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacLessThanOrEqualTo(String value) {
            addCriterion("TAC <=", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacLike(String value) {
            addCriterion("TAC like", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacNotLike(String value) {
            addCriterion("TAC not like", value, "tac");
            return (Criteria) this;
        }

        public Criteria andTacIn(List<String> values) {
            addCriterion("TAC in", values, "tac");
            return (Criteria) this;
        }

        public Criteria andTacNotIn(List<String> values) {
            addCriterion("TAC not in", values, "tac");
            return (Criteria) this;
        }

        public Criteria andTacBetween(String value1, String value2) {
            addCriterion("TAC between", value1, value2, "tac");
            return (Criteria) this;
        }

        public Criteria andTacNotBetween(String value1, String value2) {
            addCriterion("TAC not between", value1, value2, "tac");
            return (Criteria) this;
        }

        public Criteria andKeyVersionIsNull() {
            addCriterion("KEY_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andKeyVersionIsNotNull() {
            addCriterion("KEY_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andKeyVersionEqualTo(String value) {
            addCriterion("KEY_VERSION =", value, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andKeyVersionNotEqualTo(String value) {
            addCriterion("KEY_VERSION <>", value, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andKeyVersionGreaterThan(String value) {
            addCriterion("KEY_VERSION >", value, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andKeyVersionGreaterThanOrEqualTo(String value) {
            addCriterion("KEY_VERSION >=", value, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andKeyVersionLessThan(String value) {
            addCriterion("KEY_VERSION <", value, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andKeyVersionLessThanOrEqualTo(String value) {
            addCriterion("KEY_VERSION <=", value, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andKeyVersionLike(String value) {
            addCriterion("KEY_VERSION like", value, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andKeyVersionNotLike(String value) {
            addCriterion("KEY_VERSION not like", value, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andKeyVersionIn(List<String> values) {
            addCriterion("KEY_VERSION in", values, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andKeyVersionNotIn(List<String> values) {
            addCriterion("KEY_VERSION not in", values, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andKeyVersionBetween(String value1, String value2) {
            addCriterion("KEY_VERSION between", value1, value2, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andKeyVersionNotBetween(String value1, String value2) {
            addCriterion("KEY_VERSION not between", value1, value2, "keyVersion");
            return (Criteria) this;
        }

        public Criteria andTerminalNoIsNull() {
            addCriterion("TERMINAL_NO is null");
            return (Criteria) this;
        }

        public Criteria andTerminalNoIsNotNull() {
            addCriterion("TERMINAL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalNoEqualTo(String value) {
            addCriterion("TERMINAL_NO =", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotEqualTo(String value) {
            addCriterion("TERMINAL_NO <>", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoGreaterThan(String value) {
            addCriterion("TERMINAL_NO >", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoGreaterThanOrEqualTo(String value) {
            addCriterion("TERMINAL_NO >=", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoLessThan(String value) {
            addCriterion("TERMINAL_NO <", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoLessThanOrEqualTo(String value) {
            addCriterion("TERMINAL_NO <=", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoLike(String value) {
            addCriterion("TERMINAL_NO like", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotLike(String value) {
            addCriterion("TERMINAL_NO not like", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoIn(List<String> values) {
            addCriterion("TERMINAL_NO in", values, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotIn(List<String> values) {
            addCriterion("TERMINAL_NO not in", values, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoBetween(String value1, String value2) {
            addCriterion("TERMINAL_NO between", value1, value2, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotBetween(String value1, String value2) {
            addCriterion("TERMINAL_NO not between", value1, value2, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andChaPriceIsNull() {
            addCriterion("CHA_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andChaPriceIsNotNull() {
            addCriterion("CHA_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andChaPriceEqualTo(BigDecimal value) {
            addCriterion("CHA_PRICE =", value, "chaPrice");
            return (Criteria) this;
        }

        public Criteria andChaPriceNotEqualTo(BigDecimal value) {
            addCriterion("CHA_PRICE <>", value, "chaPrice");
            return (Criteria) this;
        }

        public Criteria andChaPriceGreaterThan(BigDecimal value) {
            addCriterion("CHA_PRICE >", value, "chaPrice");
            return (Criteria) this;
        }

        public Criteria andChaPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHA_PRICE >=", value, "chaPrice");
            return (Criteria) this;
        }

        public Criteria andChaPriceLessThan(BigDecimal value) {
            addCriterion("CHA_PRICE <", value, "chaPrice");
            return (Criteria) this;
        }

        public Criteria andChaPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHA_PRICE <=", value, "chaPrice");
            return (Criteria) this;
        }

        public Criteria andChaPriceIn(List<BigDecimal> values) {
            addCriterion("CHA_PRICE in", values, "chaPrice");
            return (Criteria) this;
        }

        public Criteria andChaPriceNotIn(List<BigDecimal> values) {
            addCriterion("CHA_PRICE not in", values, "chaPrice");
            return (Criteria) this;
        }

        public Criteria andChaPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHA_PRICE between", value1, value2, "chaPrice");
            return (Criteria) this;
        }

        public Criteria andChaPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHA_PRICE not between", value1, value2, "chaPrice");
            return (Criteria) this;
        }

        public Criteria andChaMoneyIsNull() {
            addCriterion("CHA_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andChaMoneyIsNotNull() {
            addCriterion("CHA_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andChaMoneyEqualTo(BigDecimal value) {
            addCriterion("CHA_MONEY =", value, "chaMoney");
            return (Criteria) this;
        }

        public Criteria andChaMoneyNotEqualTo(BigDecimal value) {
            addCriterion("CHA_MONEY <>", value, "chaMoney");
            return (Criteria) this;
        }

        public Criteria andChaMoneyGreaterThan(BigDecimal value) {
            addCriterion("CHA_MONEY >", value, "chaMoney");
            return (Criteria) this;
        }

        public Criteria andChaMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHA_MONEY >=", value, "chaMoney");
            return (Criteria) this;
        }

        public Criteria andChaMoneyLessThan(BigDecimal value) {
            addCriterion("CHA_MONEY <", value, "chaMoney");
            return (Criteria) this;
        }

        public Criteria andChaMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHA_MONEY <=", value, "chaMoney");
            return (Criteria) this;
        }

        public Criteria andChaMoneyIn(List<BigDecimal> values) {
            addCriterion("CHA_MONEY in", values, "chaMoney");
            return (Criteria) this;
        }

        public Criteria andChaMoneyNotIn(List<BigDecimal> values) {
            addCriterion("CHA_MONEY not in", values, "chaMoney");
            return (Criteria) this;
        }

        public Criteria andChaMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHA_MONEY between", value1, value2, "chaMoney");
            return (Criteria) this;
        }

        public Criteria andChaMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHA_MONEY not between", value1, value2, "chaMoney");
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
