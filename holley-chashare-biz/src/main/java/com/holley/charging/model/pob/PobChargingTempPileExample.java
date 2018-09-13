package com.holley.charging.model.pob;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PobChargingTempPileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PobChargingTempPileExample() {
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

        public Criteria andPileCodeIsNull() {
            addCriterion("PILE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPileCodeIsNotNull() {
            addCriterion("PILE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPileCodeEqualTo(String value) {
            addCriterion("PILE_CODE =", value, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileCodeNotEqualTo(String value) {
            addCriterion("PILE_CODE <>", value, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileCodeGreaterThan(String value) {
            addCriterion("PILE_CODE >", value, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PILE_CODE >=", value, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileCodeLessThan(String value) {
            addCriterion("PILE_CODE <", value, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileCodeLessThanOrEqualTo(String value) {
            addCriterion("PILE_CODE <=", value, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileCodeLike(String value) {
            addCriterion("PILE_CODE like", value, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileCodeNotLike(String value) {
            addCriterion("PILE_CODE not like", value, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileCodeIn(List<String> values) {
            addCriterion("PILE_CODE in", values, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileCodeNotIn(List<String> values) {
            addCriterion("PILE_CODE not in", values, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileCodeBetween(String value1, String value2) {
            addCriterion("PILE_CODE between", value1, value2, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileCodeNotBetween(String value1, String value2) {
            addCriterion("PILE_CODE not between", value1, value2, "pileCode");
            return (Criteria) this;
        }

        public Criteria andPileNameIsNull() {
            addCriterion("PILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPileNameIsNotNull() {
            addCriterion("PILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPileNameEqualTo(String value) {
            addCriterion("PILE_NAME =", value, "pileName");
            return (Criteria) this;
        }

        public Criteria andPileNameNotEqualTo(String value) {
            addCriterion("PILE_NAME <>", value, "pileName");
            return (Criteria) this;
        }

        public Criteria andPileNameGreaterThan(String value) {
            addCriterion("PILE_NAME >", value, "pileName");
            return (Criteria) this;
        }

        public Criteria andPileNameGreaterThanOrEqualTo(String value) {
            addCriterion("PILE_NAME >=", value, "pileName");
            return (Criteria) this;
        }

        public Criteria andPileNameLessThan(String value) {
            addCriterion("PILE_NAME <", value, "pileName");
            return (Criteria) this;
        }

        public Criteria andPileNameLessThanOrEqualTo(String value) {
            addCriterion("PILE_NAME <=", value, "pileName");
            return (Criteria) this;
        }

        public Criteria andPileNameLike(String value) {
            addCriterion("PILE_NAME like", value, "pileName");
            return (Criteria) this;
        }

        public Criteria andPileNameNotLike(String value) {
            addCriterion("PILE_NAME not like", value, "pileName");
            return (Criteria) this;
        }

        public Criteria andPileNameIn(List<String> values) {
            addCriterion("PILE_NAME in", values, "pileName");
            return (Criteria) this;
        }

        public Criteria andPileNameNotIn(List<String> values) {
            addCriterion("PILE_NAME not in", values, "pileName");
            return (Criteria) this;
        }

        public Criteria andPileNameBetween(String value1, String value2) {
            addCriterion("PILE_NAME between", value1, value2, "pileName");
            return (Criteria) this;
        }

        public Criteria andPileNameNotBetween(String value1, String value2) {
            addCriterion("PILE_NAME not between", value1, value2, "pileName");
            return (Criteria) this;
        }

        public Criteria andTempStationIdIsNull() {
            addCriterion("TEMP_STATION_ID is null");
            return (Criteria) this;
        }

        public Criteria andTempStationIdIsNotNull() {
            addCriterion("TEMP_STATION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTempStationIdEqualTo(Integer value) {
            addCriterion("TEMP_STATION_ID =", value, "tempStationId");
            return (Criteria) this;
        }

        public Criteria andTempStationIdNotEqualTo(Integer value) {
            addCriterion("TEMP_STATION_ID <>", value, "tempStationId");
            return (Criteria) this;
        }

        public Criteria andTempStationIdGreaterThan(Integer value) {
            addCriterion("TEMP_STATION_ID >", value, "tempStationId");
            return (Criteria) this;
        }

        public Criteria andTempStationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TEMP_STATION_ID >=", value, "tempStationId");
            return (Criteria) this;
        }

        public Criteria andTempStationIdLessThan(Integer value) {
            addCriterion("TEMP_STATION_ID <", value, "tempStationId");
            return (Criteria) this;
        }

        public Criteria andTempStationIdLessThanOrEqualTo(Integer value) {
            addCriterion("TEMP_STATION_ID <=", value, "tempStationId");
            return (Criteria) this;
        }

        public Criteria andTempStationIdIn(List<Integer> values) {
            addCriterion("TEMP_STATION_ID in", values, "tempStationId");
            return (Criteria) this;
        }

        public Criteria andTempStationIdNotIn(List<Integer> values) {
            addCriterion("TEMP_STATION_ID not in", values, "tempStationId");
            return (Criteria) this;
        }

        public Criteria andTempStationIdBetween(Integer value1, Integer value2) {
            addCriterion("TEMP_STATION_ID between", value1, value2, "tempStationId");
            return (Criteria) this;
        }

        public Criteria andTempStationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TEMP_STATION_ID not between", value1, value2, "tempStationId");
            return (Criteria) this;
        }

        public Criteria andRealStationIdIsNull() {
            addCriterion("REAL_STATION_ID is null");
            return (Criteria) this;
        }

        public Criteria andRealStationIdIsNotNull() {
            addCriterion("REAL_STATION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRealStationIdEqualTo(Integer value) {
            addCriterion("REAL_STATION_ID =", value, "realStationId");
            return (Criteria) this;
        }

        public Criteria andRealStationIdNotEqualTo(Integer value) {
            addCriterion("REAL_STATION_ID <>", value, "realStationId");
            return (Criteria) this;
        }

        public Criteria andRealStationIdGreaterThan(Integer value) {
            addCriterion("REAL_STATION_ID >", value, "realStationId");
            return (Criteria) this;
        }

        public Criteria andRealStationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("REAL_STATION_ID >=", value, "realStationId");
            return (Criteria) this;
        }

        public Criteria andRealStationIdLessThan(Integer value) {
            addCriterion("REAL_STATION_ID <", value, "realStationId");
            return (Criteria) this;
        }

        public Criteria andRealStationIdLessThanOrEqualTo(Integer value) {
            addCriterion("REAL_STATION_ID <=", value, "realStationId");
            return (Criteria) this;
        }

        public Criteria andRealStationIdIn(List<Integer> values) {
            addCriterion("REAL_STATION_ID in", values, "realStationId");
            return (Criteria) this;
        }

        public Criteria andRealStationIdNotIn(List<Integer> values) {
            addCriterion("REAL_STATION_ID not in", values, "realStationId");
            return (Criteria) this;
        }

        public Criteria andRealStationIdBetween(Integer value1, Integer value2) {
            addCriterion("REAL_STATION_ID between", value1, value2, "realStationId");
            return (Criteria) this;
        }

        public Criteria andRealStationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("REAL_STATION_ID not between", value1, value2, "realStationId");
            return (Criteria) this;
        }

        public Criteria andRealPileIdIsNull() {
            addCriterion("REAL_PILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRealPileIdIsNotNull() {
            addCriterion("REAL_PILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRealPileIdEqualTo(Integer value) {
            addCriterion("REAL_PILE_ID =", value, "realPileId");
            return (Criteria) this;
        }

        public Criteria andRealPileIdNotEqualTo(Integer value) {
            addCriterion("REAL_PILE_ID <>", value, "realPileId");
            return (Criteria) this;
        }

        public Criteria andRealPileIdGreaterThan(Integer value) {
            addCriterion("REAL_PILE_ID >", value, "realPileId");
            return (Criteria) this;
        }

        public Criteria andRealPileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("REAL_PILE_ID >=", value, "realPileId");
            return (Criteria) this;
        }

        public Criteria andRealPileIdLessThan(Integer value) {
            addCriterion("REAL_PILE_ID <", value, "realPileId");
            return (Criteria) this;
        }

        public Criteria andRealPileIdLessThanOrEqualTo(Integer value) {
            addCriterion("REAL_PILE_ID <=", value, "realPileId");
            return (Criteria) this;
        }

        public Criteria andRealPileIdIn(List<Integer> values) {
            addCriterion("REAL_PILE_ID in", values, "realPileId");
            return (Criteria) this;
        }

        public Criteria andRealPileIdNotIn(List<Integer> values) {
            addCriterion("REAL_PILE_ID not in", values, "realPileId");
            return (Criteria) this;
        }

        public Criteria andRealPileIdBetween(Integer value1, Integer value2) {
            addCriterion("REAL_PILE_ID between", value1, value2, "realPileId");
            return (Criteria) this;
        }

        public Criteria andRealPileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("REAL_PILE_ID not between", value1, value2, "realPileId");
            return (Criteria) this;
        }

        public Criteria andBusMecIsNull() {
            addCriterion("BUS_MEC is null");
            return (Criteria) this;
        }

        public Criteria andBusMecIsNotNull() {
            addCriterion("BUS_MEC is not null");
            return (Criteria) this;
        }

        public Criteria andBusMecEqualTo(Integer value) {
            addCriterion("BUS_MEC =", value, "busMec");
            return (Criteria) this;
        }

        public Criteria andBusMecNotEqualTo(Integer value) {
            addCriterion("BUS_MEC <>", value, "busMec");
            return (Criteria) this;
        }

        public Criteria andBusMecGreaterThan(Integer value) {
            addCriterion("BUS_MEC >", value, "busMec");
            return (Criteria) this;
        }

        public Criteria andBusMecGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUS_MEC >=", value, "busMec");
            return (Criteria) this;
        }

        public Criteria andBusMecLessThan(Integer value) {
            addCriterion("BUS_MEC <", value, "busMec");
            return (Criteria) this;
        }

        public Criteria andBusMecLessThanOrEqualTo(Integer value) {
            addCriterion("BUS_MEC <=", value, "busMec");
            return (Criteria) this;
        }

        public Criteria andBusMecIn(List<Integer> values) {
            addCriterion("BUS_MEC in", values, "busMec");
            return (Criteria) this;
        }

        public Criteria andBusMecNotIn(List<Integer> values) {
            addCriterion("BUS_MEC not in", values, "busMec");
            return (Criteria) this;
        }

        public Criteria andBusMecBetween(Integer value1, Integer value2) {
            addCriterion("BUS_MEC between", value1, value2, "busMec");
            return (Criteria) this;
        }

        public Criteria andBusMecNotBetween(Integer value1, Integer value2) {
            addCriterion("BUS_MEC not between", value1, value2, "busMec");
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

        public Criteria andPileTypeIsNull() {
            addCriterion("PILE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPileTypeIsNotNull() {
            addCriterion("PILE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPileTypeEqualTo(Short value) {
            addCriterion("PILE_TYPE =", value, "pileType");
            return (Criteria) this;
        }

        public Criteria andPileTypeNotEqualTo(Short value) {
            addCriterion("PILE_TYPE <>", value, "pileType");
            return (Criteria) this;
        }

        public Criteria andPileTypeGreaterThan(Short value) {
            addCriterion("PILE_TYPE >", value, "pileType");
            return (Criteria) this;
        }

        public Criteria andPileTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("PILE_TYPE >=", value, "pileType");
            return (Criteria) this;
        }

        public Criteria andPileTypeLessThan(Short value) {
            addCriterion("PILE_TYPE <", value, "pileType");
            return (Criteria) this;
        }

        public Criteria andPileTypeLessThanOrEqualTo(Short value) {
            addCriterion("PILE_TYPE <=", value, "pileType");
            return (Criteria) this;
        }

        public Criteria andPileTypeIn(List<Short> values) {
            addCriterion("PILE_TYPE in", values, "pileType");
            return (Criteria) this;
        }

        public Criteria andPileTypeNotIn(List<Short> values) {
            addCriterion("PILE_TYPE not in", values, "pileType");
            return (Criteria) this;
        }

        public Criteria andPileTypeBetween(Short value1, Short value2) {
            addCriterion("PILE_TYPE between", value1, value2, "pileType");
            return (Criteria) this;
        }

        public Criteria andPileTypeNotBetween(Short value1, Short value2) {
            addCriterion("PILE_TYPE not between", value1, value2, "pileType");
            return (Criteria) this;
        }

        public Criteria andPileModelIsNull() {
            addCriterion("PILE_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andPileModelIsNotNull() {
            addCriterion("PILE_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andPileModelEqualTo(Integer value) {
            addCriterion("PILE_MODEL =", value, "pileModel");
            return (Criteria) this;
        }

        public Criteria andPileModelNotEqualTo(Integer value) {
            addCriterion("PILE_MODEL <>", value, "pileModel");
            return (Criteria) this;
        }

        public Criteria andPileModelGreaterThan(Integer value) {
            addCriterion("PILE_MODEL >", value, "pileModel");
            return (Criteria) this;
        }

        public Criteria andPileModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("PILE_MODEL >=", value, "pileModel");
            return (Criteria) this;
        }

        public Criteria andPileModelLessThan(Integer value) {
            addCriterion("PILE_MODEL <", value, "pileModel");
            return (Criteria) this;
        }

        public Criteria andPileModelLessThanOrEqualTo(Integer value) {
            addCriterion("PILE_MODEL <=", value, "pileModel");
            return (Criteria) this;
        }

        public Criteria andPileModelIn(List<Integer> values) {
            addCriterion("PILE_MODEL in", values, "pileModel");
            return (Criteria) this;
        }

        public Criteria andPileModelNotIn(List<Integer> values) {
            addCriterion("PILE_MODEL not in", values, "pileModel");
            return (Criteria) this;
        }

        public Criteria andPileModelBetween(Integer value1, Integer value2) {
            addCriterion("PILE_MODEL between", value1, value2, "pileModel");
            return (Criteria) this;
        }

        public Criteria andPileModelNotBetween(Integer value1, Integer value2) {
            addCriterion("PILE_MODEL not between", value1, value2, "pileModel");
            return (Criteria) this;
        }

        public Criteria andIntfTypeIsNull() {
            addCriterion("INTF_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andIntfTypeIsNotNull() {
            addCriterion("INTF_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIntfTypeEqualTo(Short value) {
            addCriterion("INTF_TYPE =", value, "intfType");
            return (Criteria) this;
        }

        public Criteria andIntfTypeNotEqualTo(Short value) {
            addCriterion("INTF_TYPE <>", value, "intfType");
            return (Criteria) this;
        }

        public Criteria andIntfTypeGreaterThan(Short value) {
            addCriterion("INTF_TYPE >", value, "intfType");
            return (Criteria) this;
        }

        public Criteria andIntfTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("INTF_TYPE >=", value, "intfType");
            return (Criteria) this;
        }

        public Criteria andIntfTypeLessThan(Short value) {
            addCriterion("INTF_TYPE <", value, "intfType");
            return (Criteria) this;
        }

        public Criteria andIntfTypeLessThanOrEqualTo(Short value) {
            addCriterion("INTF_TYPE <=", value, "intfType");
            return (Criteria) this;
        }

        public Criteria andIntfTypeIn(List<Short> values) {
            addCriterion("INTF_TYPE in", values, "intfType");
            return (Criteria) this;
        }

        public Criteria andIntfTypeNotIn(List<Short> values) {
            addCriterion("INTF_TYPE not in", values, "intfType");
            return (Criteria) this;
        }

        public Criteria andIntfTypeBetween(Short value1, Short value2) {
            addCriterion("INTF_TYPE between", value1, value2, "intfType");
            return (Criteria) this;
        }

        public Criteria andIntfTypeNotBetween(Short value1, Short value2) {
            addCriterion("INTF_TYPE not between", value1, value2, "intfType");
            return (Criteria) this;
        }

        public Criteria andChaWayIsNull() {
            addCriterion("CHA_WAY is null");
            return (Criteria) this;
        }

        public Criteria andChaWayIsNotNull() {
            addCriterion("CHA_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andChaWayEqualTo(Short value) {
            addCriterion("CHA_WAY =", value, "chaWay");
            return (Criteria) this;
        }

        public Criteria andChaWayNotEqualTo(Short value) {
            addCriterion("CHA_WAY <>", value, "chaWay");
            return (Criteria) this;
        }

        public Criteria andChaWayGreaterThan(Short value) {
            addCriterion("CHA_WAY >", value, "chaWay");
            return (Criteria) this;
        }

        public Criteria andChaWayGreaterThanOrEqualTo(Short value) {
            addCriterion("CHA_WAY >=", value, "chaWay");
            return (Criteria) this;
        }

        public Criteria andChaWayLessThan(Short value) {
            addCriterion("CHA_WAY <", value, "chaWay");
            return (Criteria) this;
        }

        public Criteria andChaWayLessThanOrEqualTo(Short value) {
            addCriterion("CHA_WAY <=", value, "chaWay");
            return (Criteria) this;
        }

        public Criteria andChaWayIn(List<Short> values) {
            addCriterion("CHA_WAY in", values, "chaWay");
            return (Criteria) this;
        }

        public Criteria andChaWayNotIn(List<Short> values) {
            addCriterion("CHA_WAY not in", values, "chaWay");
            return (Criteria) this;
        }

        public Criteria andChaWayBetween(Short value1, Short value2) {
            addCriterion("CHA_WAY between", value1, value2, "chaWay");
            return (Criteria) this;
        }

        public Criteria andChaWayNotBetween(Short value1, Short value2) {
            addCriterion("CHA_WAY not between", value1, value2, "chaWay");
            return (Criteria) this;
        }

        public Criteria andComTypeIsNull() {
            addCriterion("COM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andComTypeIsNotNull() {
            addCriterion("COM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andComTypeEqualTo(Short value) {
            addCriterion("COM_TYPE =", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotEqualTo(Short value) {
            addCriterion("COM_TYPE <>", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeGreaterThan(Short value) {
            addCriterion("COM_TYPE >", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("COM_TYPE >=", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLessThan(Short value) {
            addCriterion("COM_TYPE <", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLessThanOrEqualTo(Short value) {
            addCriterion("COM_TYPE <=", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeIn(List<Short> values) {
            addCriterion("COM_TYPE in", values, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotIn(List<Short> values) {
            addCriterion("COM_TYPE not in", values, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeBetween(Short value1, Short value2) {
            addCriterion("COM_TYPE between", value1, value2, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotBetween(Short value1, Short value2) {
            addCriterion("COM_TYPE not between", value1, value2, "comType");
            return (Criteria) this;
        }

        public Criteria andComAddrIsNull() {
            addCriterion("COM_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andComAddrIsNotNull() {
            addCriterion("COM_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andComAddrEqualTo(String value) {
            addCriterion("COM_ADDR =", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrNotEqualTo(String value) {
            addCriterion("COM_ADDR <>", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrGreaterThan(String value) {
            addCriterion("COM_ADDR >", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrGreaterThanOrEqualTo(String value) {
            addCriterion("COM_ADDR >=", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrLessThan(String value) {
            addCriterion("COM_ADDR <", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrLessThanOrEqualTo(String value) {
            addCriterion("COM_ADDR <=", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrLike(String value) {
            addCriterion("COM_ADDR like", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrNotLike(String value) {
            addCriterion("COM_ADDR not like", value, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrIn(List<String> values) {
            addCriterion("COM_ADDR in", values, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrNotIn(List<String> values) {
            addCriterion("COM_ADDR not in", values, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrBetween(String value1, String value2) {
            addCriterion("COM_ADDR between", value1, value2, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComAddrNotBetween(String value1, String value2) {
            addCriterion("COM_ADDR not between", value1, value2, "comAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrIsNull() {
            addCriterion("COM_SUB_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andComSubAddrIsNotNull() {
            addCriterion("COM_SUB_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andComSubAddrEqualTo(String value) {
            addCriterion("COM_SUB_ADDR =", value, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrNotEqualTo(String value) {
            addCriterion("COM_SUB_ADDR <>", value, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrGreaterThan(String value) {
            addCriterion("COM_SUB_ADDR >", value, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrGreaterThanOrEqualTo(String value) {
            addCriterion("COM_SUB_ADDR >=", value, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrLessThan(String value) {
            addCriterion("COM_SUB_ADDR <", value, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrLessThanOrEqualTo(String value) {
            addCriterion("COM_SUB_ADDR <=", value, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrLike(String value) {
            addCriterion("COM_SUB_ADDR like", value, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrNotLike(String value) {
            addCriterion("COM_SUB_ADDR not like", value, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrIn(List<String> values) {
            addCriterion("COM_SUB_ADDR in", values, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrNotIn(List<String> values) {
            addCriterion("COM_SUB_ADDR not in", values, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrBetween(String value1, String value2) {
            addCriterion("COM_SUB_ADDR between", value1, value2, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andComSubAddrNotBetween(String value1, String value2) {
            addCriterion("COM_SUB_ADDR not between", value1, value2, "comSubAddr");
            return (Criteria) this;
        }

        public Criteria andIsAppIsNull() {
            addCriterion("IS_APP is null");
            return (Criteria) this;
        }

        public Criteria andIsAppIsNotNull() {
            addCriterion("IS_APP is not null");
            return (Criteria) this;
        }

        public Criteria andIsAppEqualTo(Short value) {
            addCriterion("IS_APP =", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppNotEqualTo(Short value) {
            addCriterion("IS_APP <>", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppGreaterThan(Short value) {
            addCriterion("IS_APP >", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_APP >=", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppLessThan(Short value) {
            addCriterion("IS_APP <", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppLessThanOrEqualTo(Short value) {
            addCriterion("IS_APP <=", value, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppIn(List<Short> values) {
            addCriterion("IS_APP in", values, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppNotIn(List<Short> values) {
            addCriterion("IS_APP not in", values, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppBetween(Short value1, Short value2) {
            addCriterion("IS_APP between", value1, value2, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsAppNotBetween(Short value1, Short value2) {
            addCriterion("IS_APP not between", value1, value2, "isApp");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaIsNull() {
            addCriterion("IS_TIME_CHA is null");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaIsNotNull() {
            addCriterion("IS_TIME_CHA is not null");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaEqualTo(Short value) {
            addCriterion("IS_TIME_CHA =", value, "isTimeCha");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaNotEqualTo(Short value) {
            addCriterion("IS_TIME_CHA <>", value, "isTimeCha");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaGreaterThan(Short value) {
            addCriterion("IS_TIME_CHA >", value, "isTimeCha");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_TIME_CHA >=", value, "isTimeCha");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaLessThan(Short value) {
            addCriterion("IS_TIME_CHA <", value, "isTimeCha");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaLessThanOrEqualTo(Short value) {
            addCriterion("IS_TIME_CHA <=", value, "isTimeCha");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaIn(List<Short> values) {
            addCriterion("IS_TIME_CHA in", values, "isTimeCha");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaNotIn(List<Short> values) {
            addCriterion("IS_TIME_CHA not in", values, "isTimeCha");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaBetween(Short value1, Short value2) {
            addCriterion("IS_TIME_CHA between", value1, value2, "isTimeCha");
            return (Criteria) this;
        }

        public Criteria andIsTimeChaNotBetween(Short value1, Short value2) {
            addCriterion("IS_TIME_CHA not between", value1, value2, "isTimeCha");
            return (Criteria) this;
        }

        public Criteria andIsRationChaIsNull() {
            addCriterion("IS_RATION_CHA is null");
            return (Criteria) this;
        }

        public Criteria andIsRationChaIsNotNull() {
            addCriterion("IS_RATION_CHA is not null");
            return (Criteria) this;
        }

        public Criteria andIsRationChaEqualTo(Short value) {
            addCriterion("IS_RATION_CHA =", value, "isRationCha");
            return (Criteria) this;
        }

        public Criteria andIsRationChaNotEqualTo(Short value) {
            addCriterion("IS_RATION_CHA <>", value, "isRationCha");
            return (Criteria) this;
        }

        public Criteria andIsRationChaGreaterThan(Short value) {
            addCriterion("IS_RATION_CHA >", value, "isRationCha");
            return (Criteria) this;
        }

        public Criteria andIsRationChaGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_RATION_CHA >=", value, "isRationCha");
            return (Criteria) this;
        }

        public Criteria andIsRationChaLessThan(Short value) {
            addCriterion("IS_RATION_CHA <", value, "isRationCha");
            return (Criteria) this;
        }

        public Criteria andIsRationChaLessThanOrEqualTo(Short value) {
            addCriterion("IS_RATION_CHA <=", value, "isRationCha");
            return (Criteria) this;
        }

        public Criteria andIsRationChaIn(List<Short> values) {
            addCriterion("IS_RATION_CHA in", values, "isRationCha");
            return (Criteria) this;
        }

        public Criteria andIsRationChaNotIn(List<Short> values) {
            addCriterion("IS_RATION_CHA not in", values, "isRationCha");
            return (Criteria) this;
        }

        public Criteria andIsRationChaBetween(Short value1, Short value2) {
            addCriterion("IS_RATION_CHA between", value1, value2, "isRationCha");
            return (Criteria) this;
        }

        public Criteria andIsRationChaNotBetween(Short value1, Short value2) {
            addCriterion("IS_RATION_CHA not between", value1, value2, "isRationCha");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaIsNull() {
            addCriterion("IS_MONEY_CHA is null");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaIsNotNull() {
            addCriterion("IS_MONEY_CHA is not null");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaEqualTo(Short value) {
            addCriterion("IS_MONEY_CHA =", value, "isMoneyCha");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaNotEqualTo(Short value) {
            addCriterion("IS_MONEY_CHA <>", value, "isMoneyCha");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaGreaterThan(Short value) {
            addCriterion("IS_MONEY_CHA >", value, "isMoneyCha");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_MONEY_CHA >=", value, "isMoneyCha");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaLessThan(Short value) {
            addCriterion("IS_MONEY_CHA <", value, "isMoneyCha");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaLessThanOrEqualTo(Short value) {
            addCriterion("IS_MONEY_CHA <=", value, "isMoneyCha");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaIn(List<Short> values) {
            addCriterion("IS_MONEY_CHA in", values, "isMoneyCha");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaNotIn(List<Short> values) {
            addCriterion("IS_MONEY_CHA not in", values, "isMoneyCha");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaBetween(Short value1, Short value2) {
            addCriterion("IS_MONEY_CHA between", value1, value2, "isMoneyCha");
            return (Criteria) this;
        }

        public Criteria andIsMoneyChaNotBetween(Short value1, Short value2) {
            addCriterion("IS_MONEY_CHA not between", value1, value2, "isMoneyCha");
            return (Criteria) this;
        }

        public Criteria andIsControlIsNull() {
            addCriterion("IS_CONTROL is null");
            return (Criteria) this;
        }

        public Criteria andIsControlIsNotNull() {
            addCriterion("IS_CONTROL is not null");
            return (Criteria) this;
        }

        public Criteria andIsControlEqualTo(Short value) {
            addCriterion("IS_CONTROL =", value, "isControl");
            return (Criteria) this;
        }

        public Criteria andIsControlNotEqualTo(Short value) {
            addCriterion("IS_CONTROL <>", value, "isControl");
            return (Criteria) this;
        }

        public Criteria andIsControlGreaterThan(Short value) {
            addCriterion("IS_CONTROL >", value, "isControl");
            return (Criteria) this;
        }

        public Criteria andIsControlGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_CONTROL >=", value, "isControl");
            return (Criteria) this;
        }

        public Criteria andIsControlLessThan(Short value) {
            addCriterion("IS_CONTROL <", value, "isControl");
            return (Criteria) this;
        }

        public Criteria andIsControlLessThanOrEqualTo(Short value) {
            addCriterion("IS_CONTROL <=", value, "isControl");
            return (Criteria) this;
        }

        public Criteria andIsControlIn(List<Short> values) {
            addCriterion("IS_CONTROL in", values, "isControl");
            return (Criteria) this;
        }

        public Criteria andIsControlNotIn(List<Short> values) {
            addCriterion("IS_CONTROL not in", values, "isControl");
            return (Criteria) this;
        }

        public Criteria andIsControlBetween(Short value1, Short value2) {
            addCriterion("IS_CONTROL between", value1, value2, "isControl");
            return (Criteria) this;
        }

        public Criteria andIsControlNotBetween(Short value1, Short value2) {
            addCriterion("IS_CONTROL not between", value1, value2, "isControl");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadIsNull() {
            addCriterion("IS_CHA_LOAD is null");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadIsNotNull() {
            addCriterion("IS_CHA_LOAD is not null");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadEqualTo(Short value) {
            addCriterion("IS_CHA_LOAD =", value, "isChaLoad");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadNotEqualTo(Short value) {
            addCriterion("IS_CHA_LOAD <>", value, "isChaLoad");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadGreaterThan(Short value) {
            addCriterion("IS_CHA_LOAD >", value, "isChaLoad");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_CHA_LOAD >=", value, "isChaLoad");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadLessThan(Short value) {
            addCriterion("IS_CHA_LOAD <", value, "isChaLoad");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadLessThanOrEqualTo(Short value) {
            addCriterion("IS_CHA_LOAD <=", value, "isChaLoad");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadIn(List<Short> values) {
            addCriterion("IS_CHA_LOAD in", values, "isChaLoad");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadNotIn(List<Short> values) {
            addCriterion("IS_CHA_LOAD not in", values, "isChaLoad");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadBetween(Short value1, Short value2) {
            addCriterion("IS_CHA_LOAD between", value1, value2, "isChaLoad");
            return (Criteria) this;
        }

        public Criteria andIsChaLoadNotBetween(Short value1, Short value2) {
            addCriterion("IS_CHA_LOAD not between", value1, value2, "isChaLoad");
            return (Criteria) this;
        }

        public Criteria andBuildTimeIsNull() {
            addCriterion("BUILD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBuildTimeIsNotNull() {
            addCriterion("BUILD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBuildTimeEqualTo(Date value) {
            addCriterion("BUILD_TIME =", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotEqualTo(Date value) {
            addCriterion("BUILD_TIME <>", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeGreaterThan(Date value) {
            addCriterion("BUILD_TIME >", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BUILD_TIME >=", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeLessThan(Date value) {
            addCriterion("BUILD_TIME <", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeLessThanOrEqualTo(Date value) {
            addCriterion("BUILD_TIME <=", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeIn(List<Date> values) {
            addCriterion("BUILD_TIME in", values, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotIn(List<Date> values) {
            addCriterion("BUILD_TIME not in", values, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeBetween(Date value1, Date value2) {
            addCriterion("BUILD_TIME between", value1, value2, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotBetween(Date value1, Date value2) {
            addCriterion("BUILD_TIME not between", value1, value2, "buildTime");
            return (Criteria) this;
        }

        public Criteria andDocIsNull() {
            addCriterion("DOC is null");
            return (Criteria) this;
        }

        public Criteria andDocIsNotNull() {
            addCriterion("DOC is not null");
            return (Criteria) this;
        }

        public Criteria andDocEqualTo(String value) {
            addCriterion("DOC =", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotEqualTo(String value) {
            addCriterion("DOC <>", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocGreaterThan(String value) {
            addCriterion("DOC >", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocGreaterThanOrEqualTo(String value) {
            addCriterion("DOC >=", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocLessThan(String value) {
            addCriterion("DOC <", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocLessThanOrEqualTo(String value) {
            addCriterion("DOC <=", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocLike(String value) {
            addCriterion("DOC like", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotLike(String value) {
            addCriterion("DOC not like", value, "doc");
            return (Criteria) this;
        }

        public Criteria andDocIn(List<String> values) {
            addCriterion("DOC in", values, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotIn(List<String> values) {
            addCriterion("DOC not in", values, "doc");
            return (Criteria) this;
        }

        public Criteria andDocBetween(String value1, String value2) {
            addCriterion("DOC between", value1, value2, "doc");
            return (Criteria) this;
        }

        public Criteria andDocNotBetween(String value1, String value2) {
            addCriterion("DOC not between", value1, value2, "doc");
            return (Criteria) this;
        }

        public Criteria andIsFeeIsNull() {
            addCriterion("IS_FEE is null");
            return (Criteria) this;
        }

        public Criteria andIsFeeIsNotNull() {
            addCriterion("IS_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andIsFeeEqualTo(Short value) {
            addCriterion("IS_FEE =", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeNotEqualTo(Short value) {
            addCriterion("IS_FEE <>", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeGreaterThan(Short value) {
            addCriterion("IS_FEE >", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_FEE >=", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeLessThan(Short value) {
            addCriterion("IS_FEE <", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeLessThanOrEqualTo(Short value) {
            addCriterion("IS_FEE <=", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeIn(List<Short> values) {
            addCriterion("IS_FEE in", values, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeNotIn(List<Short> values) {
            addCriterion("IS_FEE not in", values, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeBetween(Short value1, Short value2) {
            addCriterion("IS_FEE between", value1, value2, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeNotBetween(Short value1, Short value2) {
            addCriterion("IS_FEE not between", value1, value2, "isFee");
            return (Criteria) this;
        }

        public Criteria andFeeRuleIsNull() {
            addCriterion("FEE_RULE is null");
            return (Criteria) this;
        }

        public Criteria andFeeRuleIsNotNull() {
            addCriterion("FEE_RULE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeRuleEqualTo(Integer value) {
            addCriterion("FEE_RULE =", value, "feeRule");
            return (Criteria) this;
        }

        public Criteria andFeeRuleNotEqualTo(Integer value) {
            addCriterion("FEE_RULE <>", value, "feeRule");
            return (Criteria) this;
        }

        public Criteria andFeeRuleGreaterThan(Integer value) {
            addCriterion("FEE_RULE >", value, "feeRule");
            return (Criteria) this;
        }

        public Criteria andFeeRuleGreaterThanOrEqualTo(Integer value) {
            addCriterion("FEE_RULE >=", value, "feeRule");
            return (Criteria) this;
        }

        public Criteria andFeeRuleLessThan(Integer value) {
            addCriterion("FEE_RULE <", value, "feeRule");
            return (Criteria) this;
        }

        public Criteria andFeeRuleLessThanOrEqualTo(Integer value) {
            addCriterion("FEE_RULE <=", value, "feeRule");
            return (Criteria) this;
        }

        public Criteria andFeeRuleIn(List<Integer> values) {
            addCriterion("FEE_RULE in", values, "feeRule");
            return (Criteria) this;
        }

        public Criteria andFeeRuleNotIn(List<Integer> values) {
            addCriterion("FEE_RULE not in", values, "feeRule");
            return (Criteria) this;
        }

        public Criteria andFeeRuleBetween(Integer value1, Integer value2) {
            addCriterion("FEE_RULE between", value1, value2, "feeRule");
            return (Criteria) this;
        }

        public Criteria andFeeRuleNotBetween(Integer value1, Integer value2) {
            addCriterion("FEE_RULE not between", value1, value2, "feeRule");
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

        public Criteria andPayWayIsNull() {
            addCriterion("PAY_WAY is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNotNull() {
            addCriterion("PAY_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayEqualTo(String value) {
            addCriterion("PAY_WAY =", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotEqualTo(String value) {
            addCriterion("PAY_WAY <>", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThan(String value) {
            addCriterion("PAY_WAY >", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_WAY >=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThan(String value) {
            addCriterion("PAY_WAY <", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThanOrEqualTo(String value) {
            addCriterion("PAY_WAY <=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLike(String value) {
            addCriterion("PAY_WAY like", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotLike(String value) {
            addCriterion("PAY_WAY not like", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayIn(List<String> values) {
            addCriterion("PAY_WAY in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotIn(List<String> values) {
            addCriterion("PAY_WAY not in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayBetween(String value1, String value2) {
            addCriterion("PAY_WAY between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotBetween(String value1, String value2) {
            addCriterion("PAY_WAY not between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andIsLockIsNull() {
            addCriterion("IS_LOCK is null");
            return (Criteria) this;
        }

        public Criteria andIsLockIsNotNull() {
            addCriterion("IS_LOCK is not null");
            return (Criteria) this;
        }

        public Criteria andIsLockEqualTo(Short value) {
            addCriterion("IS_LOCK =", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotEqualTo(Short value) {
            addCriterion("IS_LOCK <>", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThan(Short value) {
            addCriterion("IS_LOCK >", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_LOCK >=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThan(Short value) {
            addCriterion("IS_LOCK <", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThanOrEqualTo(Short value) {
            addCriterion("IS_LOCK <=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockIn(List<Short> values) {
            addCriterion("IS_LOCK in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotIn(List<Short> values) {
            addCriterion("IS_LOCK not in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockBetween(Short value1, Short value2) {
            addCriterion("IS_LOCK between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotBetween(Short value1, Short value2) {
            addCriterion("IS_LOCK not between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andLockCodeIsNull() {
            addCriterion("LOCK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andLockCodeIsNotNull() {
            addCriterion("LOCK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andLockCodeEqualTo(String value) {
            addCriterion("LOCK_CODE =", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeNotEqualTo(String value) {
            addCriterion("LOCK_CODE <>", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeGreaterThan(String value) {
            addCriterion("LOCK_CODE >", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_CODE >=", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeLessThan(String value) {
            addCriterion("LOCK_CODE <", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeLessThanOrEqualTo(String value) {
            addCriterion("LOCK_CODE <=", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeLike(String value) {
            addCriterion("LOCK_CODE like", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeNotLike(String value) {
            addCriterion("LOCK_CODE not like", value, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeIn(List<String> values) {
            addCriterion("LOCK_CODE in", values, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeNotIn(List<String> values) {
            addCriterion("LOCK_CODE not in", values, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeBetween(String value1, String value2) {
            addCriterion("LOCK_CODE between", value1, value2, "lockCode");
            return (Criteria) this;
        }

        public Criteria andLockCodeNotBetween(String value1, String value2) {
            addCriterion("LOCK_CODE not between", value1, value2, "lockCode");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIsNull() {
            addCriterion("SOFT_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIsNotNull() {
            addCriterion("SOFT_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andSoftVersionEqualTo(String value) {
            addCriterion("SOFT_VERSION =", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotEqualTo(String value) {
            addCriterion("SOFT_VERSION <>", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionGreaterThan(String value) {
            addCriterion("SOFT_VERSION >", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionGreaterThanOrEqualTo(String value) {
            addCriterion("SOFT_VERSION >=", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLessThan(String value) {
            addCriterion("SOFT_VERSION <", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLessThanOrEqualTo(String value) {
            addCriterion("SOFT_VERSION <=", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionLike(String value) {
            addCriterion("SOFT_VERSION like", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotLike(String value) {
            addCriterion("SOFT_VERSION not like", value, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionIn(List<String> values) {
            addCriterion("SOFT_VERSION in", values, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotIn(List<String> values) {
            addCriterion("SOFT_VERSION not in", values, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionBetween(String value1, String value2) {
            addCriterion("SOFT_VERSION between", value1, value2, "softVersion");
            return (Criteria) this;
        }

        public Criteria andSoftVersionNotBetween(String value1, String value2) {
            addCriterion("SOFT_VERSION not between", value1, value2, "softVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionIsNull() {
            addCriterion("HARD_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andHardVersionIsNotNull() {
            addCriterion("HARD_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andHardVersionEqualTo(String value) {
            addCriterion("HARD_VERSION =", value, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionNotEqualTo(String value) {
            addCriterion("HARD_VERSION <>", value, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionGreaterThan(String value) {
            addCriterion("HARD_VERSION >", value, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionGreaterThanOrEqualTo(String value) {
            addCriterion("HARD_VERSION >=", value, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionLessThan(String value) {
            addCriterion("HARD_VERSION <", value, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionLessThanOrEqualTo(String value) {
            addCriterion("HARD_VERSION <=", value, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionLike(String value) {
            addCriterion("HARD_VERSION like", value, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionNotLike(String value) {
            addCriterion("HARD_VERSION not like", value, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionIn(List<String> values) {
            addCriterion("HARD_VERSION in", values, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionNotIn(List<String> values) {
            addCriterion("HARD_VERSION not in", values, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionBetween(String value1, String value2) {
            addCriterion("HARD_VERSION between", value1, value2, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andHardVersionNotBetween(String value1, String value2) {
            addCriterion("HARD_VERSION not between", value1, value2, "hardVersion");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNull() {
            addCriterion("REQUEST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNotNull() {
            addCriterion("REQUEST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeEqualTo(Short value) {
            addCriterion("REQUEST_TYPE =", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotEqualTo(Short value) {
            addCriterion("REQUEST_TYPE <>", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThan(Short value) {
            addCriterion("REQUEST_TYPE >", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("REQUEST_TYPE >=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThan(Short value) {
            addCriterion("REQUEST_TYPE <", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThanOrEqualTo(Short value) {
            addCriterion("REQUEST_TYPE <=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIn(List<Short> values) {
            addCriterion("REQUEST_TYPE in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotIn(List<Short> values) {
            addCriterion("REQUEST_TYPE not in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeBetween(Short value1, Short value2) {
            addCriterion("REQUEST_TYPE between", value1, value2, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotBetween(Short value1, Short value2) {
            addCriterion("REQUEST_TYPE not between", value1, value2, "requestType");
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