package com.holley.charging.model.pob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PobChargingTempStationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PobChargingTempStationExample() {
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

        public Criteria andStationNameIsNull() {
            addCriterion("STATION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNotNull() {
            addCriterion("STATION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStationNameEqualTo(String value) {
            addCriterion("STATION_NAME =", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotEqualTo(String value) {
            addCriterion("STATION_NAME <>", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThan(String value) {
            addCriterion("STATION_NAME >", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThanOrEqualTo(String value) {
            addCriterion("STATION_NAME >=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThan(String value) {
            addCriterion("STATION_NAME <", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThanOrEqualTo(String value) {
            addCriterion("STATION_NAME <=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLike(String value) {
            addCriterion("STATION_NAME like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotLike(String value) {
            addCriterion("STATION_NAME not like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameIn(List<String> values) {
            addCriterion("STATION_NAME in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotIn(List<String> values) {
            addCriterion("STATION_NAME not in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameBetween(String value1, String value2) {
            addCriterion("STATION_NAME between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotBetween(String value1, String value2) {
            addCriterion("STATION_NAME not between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(Integer value) {
            addCriterion("PROVINCE =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(Integer value) {
            addCriterion("PROVINCE <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(Integer value) {
            addCriterion("PROVINCE >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(Integer value) {
            addCriterion("PROVINCE <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<Integer> values) {
            addCriterion("PROVINCE in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<Integer> values) {
            addCriterion("PROVINCE not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("CITY is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(Integer value) {
            addCriterion("CITY =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(Integer value) {
            addCriterion("CITY <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(Integer value) {
            addCriterion("CITY >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("CITY >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(Integer value) {
            addCriterion("CITY <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(Integer value) {
            addCriterion("CITY <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<Integer> values) {
            addCriterion("CITY in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<Integer> values) {
            addCriterion("CITY not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(Integer value1, Integer value2) {
            addCriterion("CITY between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(Integer value1, Integer value2) {
            addCriterion("CITY not between", value1, value2, "city");
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

        public Criteria andLngIsNull() {
            addCriterion("LNG is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("LNG is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(String value) {
            addCriterion("LNG =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(String value) {
            addCriterion("LNG <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(String value) {
            addCriterion("LNG >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(String value) {
            addCriterion("LNG >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(String value) {
            addCriterion("LNG <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(String value) {
            addCriterion("LNG <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLike(String value) {
            addCriterion("LNG like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotLike(String value) {
            addCriterion("LNG not like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<String> values) {
            addCriterion("LNG in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<String> values) {
            addCriterion("LNG not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(String value1, String value2) {
            addCriterion("LNG between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(String value1, String value2) {
            addCriterion("LNG not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("LAT is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("LAT is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("LAT =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("LAT <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("LAT >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("LAT >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("LAT <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("LAT <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("LAT like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("LAT not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("LAT in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("LAT not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("LAT between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("LAT not between", value1, value2, "lat");
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

        public Criteria andOpenDayIsNull() {
            addCriterion("OPEN_DAY is null");
            return (Criteria) this;
        }

        public Criteria andOpenDayIsNotNull() {
            addCriterion("OPEN_DAY is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDayEqualTo(Short value) {
            addCriterion("OPEN_DAY =", value, "openDay");
            return (Criteria) this;
        }

        public Criteria andOpenDayNotEqualTo(Short value) {
            addCriterion("OPEN_DAY <>", value, "openDay");
            return (Criteria) this;
        }

        public Criteria andOpenDayGreaterThan(Short value) {
            addCriterion("OPEN_DAY >", value, "openDay");
            return (Criteria) this;
        }

        public Criteria andOpenDayGreaterThanOrEqualTo(Short value) {
            addCriterion("OPEN_DAY >=", value, "openDay");
            return (Criteria) this;
        }

        public Criteria andOpenDayLessThan(Short value) {
            addCriterion("OPEN_DAY <", value, "openDay");
            return (Criteria) this;
        }

        public Criteria andOpenDayLessThanOrEqualTo(Short value) {
            addCriterion("OPEN_DAY <=", value, "openDay");
            return (Criteria) this;
        }

        public Criteria andOpenDayIn(List<Short> values) {
            addCriterion("OPEN_DAY in", values, "openDay");
            return (Criteria) this;
        }

        public Criteria andOpenDayNotIn(List<Short> values) {
            addCriterion("OPEN_DAY not in", values, "openDay");
            return (Criteria) this;
        }

        public Criteria andOpenDayBetween(Short value1, Short value2) {
            addCriterion("OPEN_DAY between", value1, value2, "openDay");
            return (Criteria) this;
        }

        public Criteria andOpenDayNotBetween(Short value1, Short value2) {
            addCriterion("OPEN_DAY not between", value1, value2, "openDay");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("OPEN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("OPEN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(Short value) {
            addCriterion("OPEN_TIME =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(Short value) {
            addCriterion("OPEN_TIME <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(Short value) {
            addCriterion("OPEN_TIME >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(Short value) {
            addCriterion("OPEN_TIME >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(Short value) {
            addCriterion("OPEN_TIME <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(Short value) {
            addCriterion("OPEN_TIME <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<Short> values) {
            addCriterion("OPEN_TIME in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<Short> values) {
            addCriterion("OPEN_TIME not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(Short value1, Short value2) {
            addCriterion("OPEN_TIME between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(Short value1, Short value2) {
            addCriterion("OPEN_TIME not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andParkTypeIsNull() {
            addCriterion("PARK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andParkTypeIsNotNull() {
            addCriterion("PARK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andParkTypeEqualTo(Short value) {
            addCriterion("PARK_TYPE =", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeNotEqualTo(Short value) {
            addCriterion("PARK_TYPE <>", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeGreaterThan(Short value) {
            addCriterion("PARK_TYPE >", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("PARK_TYPE >=", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeLessThan(Short value) {
            addCriterion("PARK_TYPE <", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeLessThanOrEqualTo(Short value) {
            addCriterion("PARK_TYPE <=", value, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeIn(List<Short> values) {
            addCriterion("PARK_TYPE in", values, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeNotIn(List<Short> values) {
            addCriterion("PARK_TYPE not in", values, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeBetween(Short value1, Short value2) {
            addCriterion("PARK_TYPE between", value1, value2, "parkType");
            return (Criteria) this;
        }

        public Criteria andParkTypeNotBetween(Short value1, Short value2) {
            addCriterion("PARK_TYPE not between", value1, value2, "parkType");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeIsNull() {
            addCriterion("IS_PARK_FEE is null");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeIsNotNull() {
            addCriterion("IS_PARK_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeEqualTo(Short value) {
            addCriterion("IS_PARK_FEE =", value, "isParkFee");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeNotEqualTo(Short value) {
            addCriterion("IS_PARK_FEE <>", value, "isParkFee");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeGreaterThan(Short value) {
            addCriterion("IS_PARK_FEE >", value, "isParkFee");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_PARK_FEE >=", value, "isParkFee");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeLessThan(Short value) {
            addCriterion("IS_PARK_FEE <", value, "isParkFee");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeLessThanOrEqualTo(Short value) {
            addCriterion("IS_PARK_FEE <=", value, "isParkFee");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeIn(List<Short> values) {
            addCriterion("IS_PARK_FEE in", values, "isParkFee");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeNotIn(List<Short> values) {
            addCriterion("IS_PARK_FEE not in", values, "isParkFee");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeBetween(Short value1, Short value2) {
            addCriterion("IS_PARK_FEE between", value1, value2, "isParkFee");
            return (Criteria) this;
        }

        public Criteria andIsParkFeeNotBetween(Short value1, Short value2) {
            addCriterion("IS_PARK_FEE not between", value1, value2, "isParkFee");
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

        public Criteria andImgIsNull() {
            addCriterion("IMG is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("IMG is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("IMG =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("IMG <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("IMG >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("IMG >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("IMG <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("IMG <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("IMG like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("IMG not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("IMG in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("IMG not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("IMG between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("IMG not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("SCORE is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Short value) {
            addCriterion("SCORE =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Short value) {
            addCriterion("SCORE <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Short value) {
            addCriterion("SCORE >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Short value) {
            addCriterion("SCORE >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Short value) {
            addCriterion("SCORE <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Short value) {
            addCriterion("SCORE <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Short> values) {
            addCriterion("SCORE in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Short> values) {
            addCriterion("SCORE not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Short value1, Short value2) {
            addCriterion("SCORE between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Short value1, Short value2) {
            addCriterion("SCORE not between", value1, value2, "score");
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

        public Criteria andOperatTimeIsNull() {
            addCriterion("OPERAT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOperatTimeIsNotNull() {
            addCriterion("OPERAT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperatTimeEqualTo(Date value) {
            addCriterion("OPERAT_TIME =", value, "operatTime");
            return (Criteria) this;
        }

        public Criteria andOperatTimeNotEqualTo(Date value) {
            addCriterion("OPERAT_TIME <>", value, "operatTime");
            return (Criteria) this;
        }

        public Criteria andOperatTimeGreaterThan(Date value) {
            addCriterion("OPERAT_TIME >", value, "operatTime");
            return (Criteria) this;
        }

        public Criteria andOperatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPERAT_TIME >=", value, "operatTime");
            return (Criteria) this;
        }

        public Criteria andOperatTimeLessThan(Date value) {
            addCriterion("OPERAT_TIME <", value, "operatTime");
            return (Criteria) this;
        }

        public Criteria andOperatTimeLessThanOrEqualTo(Date value) {
            addCriterion("OPERAT_TIME <=", value, "operatTime");
            return (Criteria) this;
        }

        public Criteria andOperatTimeIn(List<Date> values) {
            addCriterion("OPERAT_TIME in", values, "operatTime");
            return (Criteria) this;
        }

        public Criteria andOperatTimeNotIn(List<Date> values) {
            addCriterion("OPERAT_TIME not in", values, "operatTime");
            return (Criteria) this;
        }

        public Criteria andOperatTimeBetween(Date value1, Date value2) {
            addCriterion("OPERAT_TIME between", value1, value2, "operatTime");
            return (Criteria) this;
        }

        public Criteria andOperatTimeNotBetween(Date value1, Date value2) {
            addCriterion("OPERAT_TIME not between", value1, value2, "operatTime");
            return (Criteria) this;
        }

        public Criteria andLinkManIsNull() {
            addCriterion("LINK_MAN is null");
            return (Criteria) this;
        }

        public Criteria andLinkManIsNotNull() {
            addCriterion("LINK_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andLinkManEqualTo(String value) {
            addCriterion("LINK_MAN =", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotEqualTo(String value) {
            addCriterion("LINK_MAN <>", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManGreaterThan(String value) {
            addCriterion("LINK_MAN >", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_MAN >=", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManLessThan(String value) {
            addCriterion("LINK_MAN <", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManLessThanOrEqualTo(String value) {
            addCriterion("LINK_MAN <=", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManLike(String value) {
            addCriterion("LINK_MAN like", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotLike(String value) {
            addCriterion("LINK_MAN not like", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManIn(List<String> values) {
            addCriterion("LINK_MAN in", values, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotIn(List<String> values) {
            addCriterion("LINK_MAN not in", values, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManBetween(String value1, String value2) {
            addCriterion("LINK_MAN between", value1, value2, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotBetween(String value1, String value2) {
            addCriterion("LINK_MAN not between", value1, value2, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNull() {
            addCriterion("LINK_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNotNull() {
            addCriterion("LINK_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneEqualTo(String value) {
            addCriterion("LINK_PHONE =", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotEqualTo(String value) {
            addCriterion("LINK_PHONE <>", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThan(String value) {
            addCriterion("LINK_PHONE >", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_PHONE >=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThan(String value) {
            addCriterion("LINK_PHONE <", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThanOrEqualTo(String value) {
            addCriterion("LINK_PHONE <=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLike(String value) {
            addCriterion("LINK_PHONE like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotLike(String value) {
            addCriterion("LINK_PHONE not like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIn(List<String> values) {
            addCriterion("LINK_PHONE in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotIn(List<String> values) {
            addCriterion("LINK_PHONE not in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneBetween(String value1, String value2) {
            addCriterion("LINK_PHONE between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotBetween(String value1, String value2) {
            addCriterion("LINK_PHONE not between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andFastNumIsNull() {
            addCriterion("FAST_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFastNumIsNotNull() {
            addCriterion("FAST_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFastNumEqualTo(Integer value) {
            addCriterion("FAST_NUM =", value, "fastNum");
            return (Criteria) this;
        }

        public Criteria andFastNumNotEqualTo(Integer value) {
            addCriterion("FAST_NUM <>", value, "fastNum");
            return (Criteria) this;
        }

        public Criteria andFastNumGreaterThan(Integer value) {
            addCriterion("FAST_NUM >", value, "fastNum");
            return (Criteria) this;
        }

        public Criteria andFastNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAST_NUM >=", value, "fastNum");
            return (Criteria) this;
        }

        public Criteria andFastNumLessThan(Integer value) {
            addCriterion("FAST_NUM <", value, "fastNum");
            return (Criteria) this;
        }

        public Criteria andFastNumLessThanOrEqualTo(Integer value) {
            addCriterion("FAST_NUM <=", value, "fastNum");
            return (Criteria) this;
        }

        public Criteria andFastNumIn(List<Integer> values) {
            addCriterion("FAST_NUM in", values, "fastNum");
            return (Criteria) this;
        }

        public Criteria andFastNumNotIn(List<Integer> values) {
            addCriterion("FAST_NUM not in", values, "fastNum");
            return (Criteria) this;
        }

        public Criteria andFastNumBetween(Integer value1, Integer value2) {
            addCriterion("FAST_NUM between", value1, value2, "fastNum");
            return (Criteria) this;
        }

        public Criteria andFastNumNotBetween(Integer value1, Integer value2) {
            addCriterion("FAST_NUM not between", value1, value2, "fastNum");
            return (Criteria) this;
        }

        public Criteria andSlowNumIsNull() {
            addCriterion("SLOW_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSlowNumIsNotNull() {
            addCriterion("SLOW_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSlowNumEqualTo(Integer value) {
            addCriterion("SLOW_NUM =", value, "slowNum");
            return (Criteria) this;
        }

        public Criteria andSlowNumNotEqualTo(Integer value) {
            addCriterion("SLOW_NUM <>", value, "slowNum");
            return (Criteria) this;
        }

        public Criteria andSlowNumGreaterThan(Integer value) {
            addCriterion("SLOW_NUM >", value, "slowNum");
            return (Criteria) this;
        }

        public Criteria andSlowNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SLOW_NUM >=", value, "slowNum");
            return (Criteria) this;
        }

        public Criteria andSlowNumLessThan(Integer value) {
            addCriterion("SLOW_NUM <", value, "slowNum");
            return (Criteria) this;
        }

        public Criteria andSlowNumLessThanOrEqualTo(Integer value) {
            addCriterion("SLOW_NUM <=", value, "slowNum");
            return (Criteria) this;
        }

        public Criteria andSlowNumIn(List<Integer> values) {
            addCriterion("SLOW_NUM in", values, "slowNum");
            return (Criteria) this;
        }

        public Criteria andSlowNumNotIn(List<Integer> values) {
            addCriterion("SLOW_NUM not in", values, "slowNum");
            return (Criteria) this;
        }

        public Criteria andSlowNumBetween(Integer value1, Integer value2) {
            addCriterion("SLOW_NUM between", value1, value2, "slowNum");
            return (Criteria) this;
        }

        public Criteria andSlowNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SLOW_NUM not between", value1, value2, "slowNum");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNull() {
            addCriterion("DATA_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNotNull() {
            addCriterion("DATA_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceEqualTo(String value) {
            addCriterion("DATA_SOURCE =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(String value) {
            addCriterion("DATA_SOURCE <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(String value) {
            addCriterion("DATA_SOURCE >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_SOURCE >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(String value) {
            addCriterion("DATA_SOURCE <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(String value) {
            addCriterion("DATA_SOURCE <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLike(String value) {
            addCriterion("DATA_SOURCE like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotLike(String value) {
            addCriterion("DATA_SOURCE not like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<String> values) {
            addCriterion("DATA_SOURCE in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<String> values) {
            addCriterion("DATA_SOURCE not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(String value1, String value2) {
            addCriterion("DATA_SOURCE between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(String value1, String value2) {
            addCriterion("DATA_SOURCE not between", value1, value2, "dataSource");
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