package com.holley.charging.model.bus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusPileModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusPileModelExample() {
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

        public Criteria andBrandIsNull() {
            addCriterion("BRAND is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("BRAND is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("BRAND =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("BRAND <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("BRAND >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("BRAND >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("BRAND <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("BRAND <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("BRAND like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("BRAND not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("BRAND in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("BRAND not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("BRAND between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("BRAND not between", value1, value2, "brand");
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

        public Criteria andChaTypeIsNull() {
            addCriterion("CHA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andChaTypeIsNotNull() {
            addCriterion("CHA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChaTypeEqualTo(Short value) {
            addCriterion("CHA_TYPE =", value, "chaType");
            return (Criteria) this;
        }

        public Criteria andChaTypeNotEqualTo(Short value) {
            addCriterion("CHA_TYPE <>", value, "chaType");
            return (Criteria) this;
        }

        public Criteria andChaTypeGreaterThan(Short value) {
            addCriterion("CHA_TYPE >", value, "chaType");
            return (Criteria) this;
        }

        public Criteria andChaTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("CHA_TYPE >=", value, "chaType");
            return (Criteria) this;
        }

        public Criteria andChaTypeLessThan(Short value) {
            addCriterion("CHA_TYPE <", value, "chaType");
            return (Criteria) this;
        }

        public Criteria andChaTypeLessThanOrEqualTo(Short value) {
            addCriterion("CHA_TYPE <=", value, "chaType");
            return (Criteria) this;
        }

        public Criteria andChaTypeIn(List<Short> values) {
            addCriterion("CHA_TYPE in", values, "chaType");
            return (Criteria) this;
        }

        public Criteria andChaTypeNotIn(List<Short> values) {
            addCriterion("CHA_TYPE not in", values, "chaType");
            return (Criteria) this;
        }

        public Criteria andChaTypeBetween(Short value1, Short value2) {
            addCriterion("CHA_TYPE between", value1, value2, "chaType");
            return (Criteria) this;
        }

        public Criteria andChaTypeNotBetween(Short value1, Short value2) {
            addCriterion("CHA_TYPE not between", value1, value2, "chaType");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("NUM is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("NUM is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(String value) {
            addCriterion("NUM =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(String value) {
            addCriterion("NUM <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(String value) {
            addCriterion("NUM >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(String value) {
            addCriterion("NUM >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(String value) {
            addCriterion("NUM <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(String value) {
            addCriterion("NUM <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLike(String value) {
            addCriterion("NUM like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotLike(String value) {
            addCriterion("NUM not like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<String> values) {
            addCriterion("NUM in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<String> values) {
            addCriterion("NUM not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(String value1, String value2) {
            addCriterion("NUM between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(String value1, String value2) {
            addCriterion("NUM not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentIsNull() {
            addCriterion("IS_INTELLIGENT is null");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentIsNotNull() {
            addCriterion("IS_INTELLIGENT is not null");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentEqualTo(Short value) {
            addCriterion("IS_INTELLIGENT =", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentNotEqualTo(Short value) {
            addCriterion("IS_INTELLIGENT <>", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentGreaterThan(Short value) {
            addCriterion("IS_INTELLIGENT >", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_INTELLIGENT >=", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentLessThan(Short value) {
            addCriterion("IS_INTELLIGENT <", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentLessThanOrEqualTo(Short value) {
            addCriterion("IS_INTELLIGENT <=", value, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentIn(List<Short> values) {
            addCriterion("IS_INTELLIGENT in", values, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentNotIn(List<Short> values) {
            addCriterion("IS_INTELLIGENT not in", values, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentBetween(Short value1, Short value2) {
            addCriterion("IS_INTELLIGENT between", value1, value2, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andIsIntelligentNotBetween(Short value1, Short value2) {
            addCriterion("IS_INTELLIGENT not between", value1, value2, "isIntelligent");
            return (Criteria) this;
        }

        public Criteria andStandardIsNull() {
            addCriterion("STANDARD is null");
            return (Criteria) this;
        }

        public Criteria andStandardIsNotNull() {
            addCriterion("STANDARD is not null");
            return (Criteria) this;
        }

        public Criteria andStandardEqualTo(Short value) {
            addCriterion("STANDARD =", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotEqualTo(Short value) {
            addCriterion("STANDARD <>", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThan(Short value) {
            addCriterion("STANDARD >", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThanOrEqualTo(Short value) {
            addCriterion("STANDARD >=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThan(Short value) {
            addCriterion("STANDARD <", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThanOrEqualTo(Short value) {
            addCriterion("STANDARD <=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardIn(List<Short> values) {
            addCriterion("STANDARD in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotIn(List<Short> values) {
            addCriterion("STANDARD not in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardBetween(Short value1, Short value2) {
            addCriterion("STANDARD between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotBetween(Short value1, Short value2) {
            addCriterion("STANDARD not between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andInVIsNull() {
            addCriterion("IN_V is null");
            return (Criteria) this;
        }

        public Criteria andInVIsNotNull() {
            addCriterion("IN_V is not null");
            return (Criteria) this;
        }

        public Criteria andInVEqualTo(String value) {
            addCriterion("IN_V =", value, "inV");
            return (Criteria) this;
        }

        public Criteria andInVNotEqualTo(String value) {
            addCriterion("IN_V <>", value, "inV");
            return (Criteria) this;
        }

        public Criteria andInVGreaterThan(String value) {
            addCriterion("IN_V >", value, "inV");
            return (Criteria) this;
        }

        public Criteria andInVGreaterThanOrEqualTo(String value) {
            addCriterion("IN_V >=", value, "inV");
            return (Criteria) this;
        }

        public Criteria andInVLessThan(String value) {
            addCriterion("IN_V <", value, "inV");
            return (Criteria) this;
        }

        public Criteria andInVLessThanOrEqualTo(String value) {
            addCriterion("IN_V <=", value, "inV");
            return (Criteria) this;
        }

        public Criteria andInVLike(String value) {
            addCriterion("IN_V like", value, "inV");
            return (Criteria) this;
        }

        public Criteria andInVNotLike(String value) {
            addCriterion("IN_V not like", value, "inV");
            return (Criteria) this;
        }

        public Criteria andInVIn(List<String> values) {
            addCriterion("IN_V in", values, "inV");
            return (Criteria) this;
        }

        public Criteria andInVNotIn(List<String> values) {
            addCriterion("IN_V not in", values, "inV");
            return (Criteria) this;
        }

        public Criteria andInVBetween(String value1, String value2) {
            addCriterion("IN_V between", value1, value2, "inV");
            return (Criteria) this;
        }

        public Criteria andInVNotBetween(String value1, String value2) {
            addCriterion("IN_V not between", value1, value2, "inV");
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

        public Criteria andMaxPIsNull() {
            addCriterion("MAX_P is null");
            return (Criteria) this;
        }

        public Criteria andMaxPIsNotNull() {
            addCriterion("MAX_P is not null");
            return (Criteria) this;
        }

        public Criteria andMaxPEqualTo(String value) {
            addCriterion("MAX_P =", value, "maxP");
            return (Criteria) this;
        }

        public Criteria andMaxPNotEqualTo(String value) {
            addCriterion("MAX_P <>", value, "maxP");
            return (Criteria) this;
        }

        public Criteria andMaxPGreaterThan(String value) {
            addCriterion("MAX_P >", value, "maxP");
            return (Criteria) this;
        }

        public Criteria andMaxPGreaterThanOrEqualTo(String value) {
            addCriterion("MAX_P >=", value, "maxP");
            return (Criteria) this;
        }

        public Criteria andMaxPLessThan(String value) {
            addCriterion("MAX_P <", value, "maxP");
            return (Criteria) this;
        }

        public Criteria andMaxPLessThanOrEqualTo(String value) {
            addCriterion("MAX_P <=", value, "maxP");
            return (Criteria) this;
        }

        public Criteria andMaxPLike(String value) {
            addCriterion("MAX_P like", value, "maxP");
            return (Criteria) this;
        }

        public Criteria andMaxPNotLike(String value) {
            addCriterion("MAX_P not like", value, "maxP");
            return (Criteria) this;
        }

        public Criteria andMaxPIn(List<String> values) {
            addCriterion("MAX_P in", values, "maxP");
            return (Criteria) this;
        }

        public Criteria andMaxPNotIn(List<String> values) {
            addCriterion("MAX_P not in", values, "maxP");
            return (Criteria) this;
        }

        public Criteria andMaxPBetween(String value1, String value2) {
            addCriterion("MAX_P between", value1, value2, "maxP");
            return (Criteria) this;
        }

        public Criteria andMaxPNotBetween(String value1, String value2) {
            addCriterion("MAX_P not between", value1, value2, "maxP");
            return (Criteria) this;
        }

        public Criteria andRatPIsNull() {
            addCriterion("RAT_P is null");
            return (Criteria) this;
        }

        public Criteria andRatPIsNotNull() {
            addCriterion("RAT_P is not null");
            return (Criteria) this;
        }

        public Criteria andRatPEqualTo(String value) {
            addCriterion("RAT_P =", value, "ratP");
            return (Criteria) this;
        }

        public Criteria andRatPNotEqualTo(String value) {
            addCriterion("RAT_P <>", value, "ratP");
            return (Criteria) this;
        }

        public Criteria andRatPGreaterThan(String value) {
            addCriterion("RAT_P >", value, "ratP");
            return (Criteria) this;
        }

        public Criteria andRatPGreaterThanOrEqualTo(String value) {
            addCriterion("RAT_P >=", value, "ratP");
            return (Criteria) this;
        }

        public Criteria andRatPLessThan(String value) {
            addCriterion("RAT_P <", value, "ratP");
            return (Criteria) this;
        }

        public Criteria andRatPLessThanOrEqualTo(String value) {
            addCriterion("RAT_P <=", value, "ratP");
            return (Criteria) this;
        }

        public Criteria andRatPLike(String value) {
            addCriterion("RAT_P like", value, "ratP");
            return (Criteria) this;
        }

        public Criteria andRatPNotLike(String value) {
            addCriterion("RAT_P not like", value, "ratP");
            return (Criteria) this;
        }

        public Criteria andRatPIn(List<String> values) {
            addCriterion("RAT_P in", values, "ratP");
            return (Criteria) this;
        }

        public Criteria andRatPNotIn(List<String> values) {
            addCriterion("RAT_P not in", values, "ratP");
            return (Criteria) this;
        }

        public Criteria andRatPBetween(String value1, String value2) {
            addCriterion("RAT_P between", value1, value2, "ratP");
            return (Criteria) this;
        }

        public Criteria andRatPNotBetween(String value1, String value2) {
            addCriterion("RAT_P not between", value1, value2, "ratP");
            return (Criteria) this;
        }

        public Criteria andHullIsNull() {
            addCriterion("HULL is null");
            return (Criteria) this;
        }

        public Criteria andHullIsNotNull() {
            addCriterion("HULL is not null");
            return (Criteria) this;
        }

        public Criteria andHullEqualTo(String value) {
            addCriterion("HULL =", value, "hull");
            return (Criteria) this;
        }

        public Criteria andHullNotEqualTo(String value) {
            addCriterion("HULL <>", value, "hull");
            return (Criteria) this;
        }

        public Criteria andHullGreaterThan(String value) {
            addCriterion("HULL >", value, "hull");
            return (Criteria) this;
        }

        public Criteria andHullGreaterThanOrEqualTo(String value) {
            addCriterion("HULL >=", value, "hull");
            return (Criteria) this;
        }

        public Criteria andHullLessThan(String value) {
            addCriterion("HULL <", value, "hull");
            return (Criteria) this;
        }

        public Criteria andHullLessThanOrEqualTo(String value) {
            addCriterion("HULL <=", value, "hull");
            return (Criteria) this;
        }

        public Criteria andHullLike(String value) {
            addCriterion("HULL like", value, "hull");
            return (Criteria) this;
        }

        public Criteria andHullNotLike(String value) {
            addCriterion("HULL not like", value, "hull");
            return (Criteria) this;
        }

        public Criteria andHullIn(List<String> values) {
            addCriterion("HULL in", values, "hull");
            return (Criteria) this;
        }

        public Criteria andHullNotIn(List<String> values) {
            addCriterion("HULL not in", values, "hull");
            return (Criteria) this;
        }

        public Criteria andHullBetween(String value1, String value2) {
            addCriterion("HULL between", value1, value2, "hull");
            return (Criteria) this;
        }

        public Criteria andHullNotBetween(String value1, String value2) {
            addCriterion("HULL not between", value1, value2, "hull");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("SIZE is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("SIZE =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("SIZE <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("SIZE >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("SIZE >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("SIZE <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("SIZE <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("SIZE like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("SIZE not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("SIZE in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("SIZE not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("SIZE between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("SIZE not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andProLevelIsNull() {
            addCriterion("PRO_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andProLevelIsNotNull() {
            addCriterion("PRO_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andProLevelEqualTo(String value) {
            addCriterion("PRO_LEVEL =", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotEqualTo(String value) {
            addCriterion("PRO_LEVEL <>", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelGreaterThan(String value) {
            addCriterion("PRO_LEVEL >", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelGreaterThanOrEqualTo(String value) {
            addCriterion("PRO_LEVEL >=", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelLessThan(String value) {
            addCriterion("PRO_LEVEL <", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelLessThanOrEqualTo(String value) {
            addCriterion("PRO_LEVEL <=", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelLike(String value) {
            addCriterion("PRO_LEVEL like", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotLike(String value) {
            addCriterion("PRO_LEVEL not like", value, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelIn(List<String> values) {
            addCriterion("PRO_LEVEL in", values, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotIn(List<String> values) {
            addCriterion("PRO_LEVEL not in", values, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelBetween(String value1, String value2) {
            addCriterion("PRO_LEVEL between", value1, value2, "proLevel");
            return (Criteria) this;
        }

        public Criteria andProLevelNotBetween(String value1, String value2) {
            addCriterion("PRO_LEVEL not between", value1, value2, "proLevel");
            return (Criteria) this;
        }

        public Criteria andLineLenIsNull() {
            addCriterion("LINE_LEN is null");
            return (Criteria) this;
        }

        public Criteria andLineLenIsNotNull() {
            addCriterion("LINE_LEN is not null");
            return (Criteria) this;
        }

        public Criteria andLineLenEqualTo(String value) {
            addCriterion("LINE_LEN =", value, "lineLen");
            return (Criteria) this;
        }

        public Criteria andLineLenNotEqualTo(String value) {
            addCriterion("LINE_LEN <>", value, "lineLen");
            return (Criteria) this;
        }

        public Criteria andLineLenGreaterThan(String value) {
            addCriterion("LINE_LEN >", value, "lineLen");
            return (Criteria) this;
        }

        public Criteria andLineLenGreaterThanOrEqualTo(String value) {
            addCriterion("LINE_LEN >=", value, "lineLen");
            return (Criteria) this;
        }

        public Criteria andLineLenLessThan(String value) {
            addCriterion("LINE_LEN <", value, "lineLen");
            return (Criteria) this;
        }

        public Criteria andLineLenLessThanOrEqualTo(String value) {
            addCriterion("LINE_LEN <=", value, "lineLen");
            return (Criteria) this;
        }

        public Criteria andLineLenLike(String value) {
            addCriterion("LINE_LEN like", value, "lineLen");
            return (Criteria) this;
        }

        public Criteria andLineLenNotLike(String value) {
            addCriterion("LINE_LEN not like", value, "lineLen");
            return (Criteria) this;
        }

        public Criteria andLineLenIn(List<String> values) {
            addCriterion("LINE_LEN in", values, "lineLen");
            return (Criteria) this;
        }

        public Criteria andLineLenNotIn(List<String> values) {
            addCriterion("LINE_LEN not in", values, "lineLen");
            return (Criteria) this;
        }

        public Criteria andLineLenBetween(String value1, String value2) {
            addCriterion("LINE_LEN between", value1, value2, "lineLen");
            return (Criteria) this;
        }

        public Criteria andLineLenNotBetween(String value1, String value2) {
            addCriterion("LINE_LEN not between", value1, value2, "lineLen");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("RATE is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("RATE is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(String value) {
            addCriterion("RATE =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(String value) {
            addCriterion("RATE <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(String value) {
            addCriterion("RATE >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(String value) {
            addCriterion("RATE >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(String value) {
            addCriterion("RATE <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(String value) {
            addCriterion("RATE <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLike(String value) {
            addCriterion("RATE like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotLike(String value) {
            addCriterion("RATE not like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<String> values) {
            addCriterion("RATE in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<String> values) {
            addCriterion("RATE not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(String value1, String value2) {
            addCriterion("RATE between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(String value1, String value2) {
            addCriterion("RATE not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andMeaAccIsNull() {
            addCriterion("MEA_ACC is null");
            return (Criteria) this;
        }

        public Criteria andMeaAccIsNotNull() {
            addCriterion("MEA_ACC is not null");
            return (Criteria) this;
        }

        public Criteria andMeaAccEqualTo(String value) {
            addCriterion("MEA_ACC =", value, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andMeaAccNotEqualTo(String value) {
            addCriterion("MEA_ACC <>", value, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andMeaAccGreaterThan(String value) {
            addCriterion("MEA_ACC >", value, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andMeaAccGreaterThanOrEqualTo(String value) {
            addCriterion("MEA_ACC >=", value, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andMeaAccLessThan(String value) {
            addCriterion("MEA_ACC <", value, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andMeaAccLessThanOrEqualTo(String value) {
            addCriterion("MEA_ACC <=", value, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andMeaAccLike(String value) {
            addCriterion("MEA_ACC like", value, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andMeaAccNotLike(String value) {
            addCriterion("MEA_ACC not like", value, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andMeaAccIn(List<String> values) {
            addCriterion("MEA_ACC in", values, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andMeaAccNotIn(List<String> values) {
            addCriterion("MEA_ACC not in", values, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andMeaAccBetween(String value1, String value2) {
            addCriterion("MEA_ACC between", value1, value2, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andMeaAccNotBetween(String value1, String value2) {
            addCriterion("MEA_ACC not between", value1, value2, "meaAcc");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(String value) {
            addCriterion("WEIGHT =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(String value) {
            addCriterion("WEIGHT <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(String value) {
            addCriterion("WEIGHT >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(String value) {
            addCriterion("WEIGHT >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(String value) {
            addCriterion("WEIGHT <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(String value) {
            addCriterion("WEIGHT <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLike(String value) {
            addCriterion("WEIGHT like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotLike(String value) {
            addCriterion("WEIGHT not like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<String> values) {
            addCriterion("WEIGHT in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<String> values) {
            addCriterion("WEIGHT not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(String value1, String value2) {
            addCriterion("WEIGHT between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(String value1, String value2) {
            addCriterion("WEIGHT not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWindowIsNull() {
            addCriterion("WINDOW is null");
            return (Criteria) this;
        }

        public Criteria andWindowIsNotNull() {
            addCriterion("WINDOW is not null");
            return (Criteria) this;
        }

        public Criteria andWindowEqualTo(String value) {
            addCriterion("WINDOW =", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotEqualTo(String value) {
            addCriterion("WINDOW <>", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowGreaterThan(String value) {
            addCriterion("WINDOW >", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowGreaterThanOrEqualTo(String value) {
            addCriterion("WINDOW >=", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowLessThan(String value) {
            addCriterion("WINDOW <", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowLessThanOrEqualTo(String value) {
            addCriterion("WINDOW <=", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowLike(String value) {
            addCriterion("WINDOW like", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotLike(String value) {
            addCriterion("WINDOW not like", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowIn(List<String> values) {
            addCriterion("WINDOW in", values, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotIn(List<String> values) {
            addCriterion("WINDOW not in", values, "window");
            return (Criteria) this;
        }

        public Criteria andWindowBetween(String value1, String value2) {
            addCriterion("WINDOW between", value1, value2, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotBetween(String value1, String value2) {
            addCriterion("WINDOW not between", value1, value2, "window");
            return (Criteria) this;
        }

        public Criteria andWorkTemIsNull() {
            addCriterion("WORK_TEM is null");
            return (Criteria) this;
        }

        public Criteria andWorkTemIsNotNull() {
            addCriterion("WORK_TEM is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTemEqualTo(String value) {
            addCriterion("WORK_TEM =", value, "workTem");
            return (Criteria) this;
        }

        public Criteria andWorkTemNotEqualTo(String value) {
            addCriterion("WORK_TEM <>", value, "workTem");
            return (Criteria) this;
        }

        public Criteria andWorkTemGreaterThan(String value) {
            addCriterion("WORK_TEM >", value, "workTem");
            return (Criteria) this;
        }

        public Criteria andWorkTemGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_TEM >=", value, "workTem");
            return (Criteria) this;
        }

        public Criteria andWorkTemLessThan(String value) {
            addCriterion("WORK_TEM <", value, "workTem");
            return (Criteria) this;
        }

        public Criteria andWorkTemLessThanOrEqualTo(String value) {
            addCriterion("WORK_TEM <=", value, "workTem");
            return (Criteria) this;
        }

        public Criteria andWorkTemLike(String value) {
            addCriterion("WORK_TEM like", value, "workTem");
            return (Criteria) this;
        }

        public Criteria andWorkTemNotLike(String value) {
            addCriterion("WORK_TEM not like", value, "workTem");
            return (Criteria) this;
        }

        public Criteria andWorkTemIn(List<String> values) {
            addCriterion("WORK_TEM in", values, "workTem");
            return (Criteria) this;
        }

        public Criteria andWorkTemNotIn(List<String> values) {
            addCriterion("WORK_TEM not in", values, "workTem");
            return (Criteria) this;
        }

        public Criteria andWorkTemBetween(String value1, String value2) {
            addCriterion("WORK_TEM between", value1, value2, "workTem");
            return (Criteria) this;
        }

        public Criteria andWorkTemNotBetween(String value1, String value2) {
            addCriterion("WORK_TEM not between", value1, value2, "workTem");
            return (Criteria) this;
        }

        public Criteria andRelaHumIsNull() {
            addCriterion("RELA_HUM is null");
            return (Criteria) this;
        }

        public Criteria andRelaHumIsNotNull() {
            addCriterion("RELA_HUM is not null");
            return (Criteria) this;
        }

        public Criteria andRelaHumEqualTo(String value) {
            addCriterion("RELA_HUM =", value, "relaHum");
            return (Criteria) this;
        }

        public Criteria andRelaHumNotEqualTo(String value) {
            addCriterion("RELA_HUM <>", value, "relaHum");
            return (Criteria) this;
        }

        public Criteria andRelaHumGreaterThan(String value) {
            addCriterion("RELA_HUM >", value, "relaHum");
            return (Criteria) this;
        }

        public Criteria andRelaHumGreaterThanOrEqualTo(String value) {
            addCriterion("RELA_HUM >=", value, "relaHum");
            return (Criteria) this;
        }

        public Criteria andRelaHumLessThan(String value) {
            addCriterion("RELA_HUM <", value, "relaHum");
            return (Criteria) this;
        }

        public Criteria andRelaHumLessThanOrEqualTo(String value) {
            addCriterion("RELA_HUM <=", value, "relaHum");
            return (Criteria) this;
        }

        public Criteria andRelaHumLike(String value) {
            addCriterion("RELA_HUM like", value, "relaHum");
            return (Criteria) this;
        }

        public Criteria andRelaHumNotLike(String value) {
            addCriterion("RELA_HUM not like", value, "relaHum");
            return (Criteria) this;
        }

        public Criteria andRelaHumIn(List<String> values) {
            addCriterion("RELA_HUM in", values, "relaHum");
            return (Criteria) this;
        }

        public Criteria andRelaHumNotIn(List<String> values) {
            addCriterion("RELA_HUM not in", values, "relaHum");
            return (Criteria) this;
        }

        public Criteria andRelaHumBetween(String value1, String value2) {
            addCriterion("RELA_HUM between", value1, value2, "relaHum");
            return (Criteria) this;
        }

        public Criteria andRelaHumNotBetween(String value1, String value2) {
            addCriterion("RELA_HUM not between", value1, value2, "relaHum");
            return (Criteria) this;
        }

        public Criteria andAltitudeIsNull() {
            addCriterion("ALTITUDE is null");
            return (Criteria) this;
        }

        public Criteria andAltitudeIsNotNull() {
            addCriterion("ALTITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andAltitudeEqualTo(String value) {
            addCriterion("ALTITUDE =", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotEqualTo(String value) {
            addCriterion("ALTITUDE <>", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeGreaterThan(String value) {
            addCriterion("ALTITUDE >", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeGreaterThanOrEqualTo(String value) {
            addCriterion("ALTITUDE >=", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeLessThan(String value) {
            addCriterion("ALTITUDE <", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeLessThanOrEqualTo(String value) {
            addCriterion("ALTITUDE <=", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeLike(String value) {
            addCriterion("ALTITUDE like", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotLike(String value) {
            addCriterion("ALTITUDE not like", value, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeIn(List<String> values) {
            addCriterion("ALTITUDE in", values, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotIn(List<String> values) {
            addCriterion("ALTITUDE not in", values, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeBetween(String value1, String value2) {
            addCriterion("ALTITUDE between", value1, value2, "altitude");
            return (Criteria) this;
        }

        public Criteria andAltitudeNotBetween(String value1, String value2) {
            addCriterion("ALTITUDE not between", value1, value2, "altitude");
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

        public Criteria andInsMethodIsNull() {
            addCriterion("INS_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andInsMethodIsNotNull() {
            addCriterion("INS_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andInsMethodEqualTo(String value) {
            addCriterion("INS_METHOD =", value, "insMethod");
            return (Criteria) this;
        }

        public Criteria andInsMethodNotEqualTo(String value) {
            addCriterion("INS_METHOD <>", value, "insMethod");
            return (Criteria) this;
        }

        public Criteria andInsMethodGreaterThan(String value) {
            addCriterion("INS_METHOD >", value, "insMethod");
            return (Criteria) this;
        }

        public Criteria andInsMethodGreaterThanOrEqualTo(String value) {
            addCriterion("INS_METHOD >=", value, "insMethod");
            return (Criteria) this;
        }

        public Criteria andInsMethodLessThan(String value) {
            addCriterion("INS_METHOD <", value, "insMethod");
            return (Criteria) this;
        }

        public Criteria andInsMethodLessThanOrEqualTo(String value) {
            addCriterion("INS_METHOD <=", value, "insMethod");
            return (Criteria) this;
        }

        public Criteria andInsMethodLike(String value) {
            addCriterion("INS_METHOD like", value, "insMethod");
            return (Criteria) this;
        }

        public Criteria andInsMethodNotLike(String value) {
            addCriterion("INS_METHOD not like", value, "insMethod");
            return (Criteria) this;
        }

        public Criteria andInsMethodIn(List<String> values) {
            addCriterion("INS_METHOD in", values, "insMethod");
            return (Criteria) this;
        }

        public Criteria andInsMethodNotIn(List<String> values) {
            addCriterion("INS_METHOD not in", values, "insMethod");
            return (Criteria) this;
        }

        public Criteria andInsMethodBetween(String value1, String value2) {
            addCriterion("INS_METHOD between", value1, value2, "insMethod");
            return (Criteria) this;
        }

        public Criteria andInsMethodNotBetween(String value1, String value2) {
            addCriterion("INS_METHOD not between", value1, value2, "insMethod");
            return (Criteria) this;
        }

        public Criteria andWorkStaIsNull() {
            addCriterion("WORK_STA is null");
            return (Criteria) this;
        }

        public Criteria andWorkStaIsNotNull() {
            addCriterion("WORK_STA is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStaEqualTo(String value) {
            addCriterion("WORK_STA =", value, "workSta");
            return (Criteria) this;
        }

        public Criteria andWorkStaNotEqualTo(String value) {
            addCriterion("WORK_STA <>", value, "workSta");
            return (Criteria) this;
        }

        public Criteria andWorkStaGreaterThan(String value) {
            addCriterion("WORK_STA >", value, "workSta");
            return (Criteria) this;
        }

        public Criteria andWorkStaGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_STA >=", value, "workSta");
            return (Criteria) this;
        }

        public Criteria andWorkStaLessThan(String value) {
            addCriterion("WORK_STA <", value, "workSta");
            return (Criteria) this;
        }

        public Criteria andWorkStaLessThanOrEqualTo(String value) {
            addCriterion("WORK_STA <=", value, "workSta");
            return (Criteria) this;
        }

        public Criteria andWorkStaLike(String value) {
            addCriterion("WORK_STA like", value, "workSta");
            return (Criteria) this;
        }

        public Criteria andWorkStaNotLike(String value) {
            addCriterion("WORK_STA not like", value, "workSta");
            return (Criteria) this;
        }

        public Criteria andWorkStaIn(List<String> values) {
            addCriterion("WORK_STA in", values, "workSta");
            return (Criteria) this;
        }

        public Criteria andWorkStaNotIn(List<String> values) {
            addCriterion("WORK_STA not in", values, "workSta");
            return (Criteria) this;
        }

        public Criteria andWorkStaBetween(String value1, String value2) {
            addCriterion("WORK_STA between", value1, value2, "workSta");
            return (Criteria) this;
        }

        public Criteria andWorkStaNotBetween(String value1, String value2) {
            addCriterion("WORK_STA not between", value1, value2, "workSta");
            return (Criteria) this;
        }

        public Criteria andIdentifyIsNull() {
            addCriterion("IDENTIFY is null");
            return (Criteria) this;
        }

        public Criteria andIdentifyIsNotNull() {
            addCriterion("IDENTIFY is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifyEqualTo(String value) {
            addCriterion("IDENTIFY =", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotEqualTo(String value) {
            addCriterion("IDENTIFY <>", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyGreaterThan(String value) {
            addCriterion("IDENTIFY >", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyGreaterThanOrEqualTo(String value) {
            addCriterion("IDENTIFY >=", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLessThan(String value) {
            addCriterion("IDENTIFY <", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLessThanOrEqualTo(String value) {
            addCriterion("IDENTIFY <=", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyLike(String value) {
            addCriterion("IDENTIFY like", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotLike(String value) {
            addCriterion("IDENTIFY not like", value, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyIn(List<String> values) {
            addCriterion("IDENTIFY in", values, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotIn(List<String> values) {
            addCriterion("IDENTIFY not in", values, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyBetween(String value1, String value2) {
            addCriterion("IDENTIFY between", value1, value2, "identify");
            return (Criteria) this;
        }

        public Criteria andIdentifyNotBetween(String value1, String value2) {
            addCriterion("IDENTIFY not between", value1, value2, "identify");
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