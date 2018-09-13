package com.holley.charging.model.bus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusBussinessInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusBussinessInfoExample() {
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

        public Criteria andBusNameIsNull() {
            addCriterion("BUS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBusNameIsNotNull() {
            addCriterion("BUS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBusNameEqualTo(String value) {
            addCriterion("BUS_NAME =", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameNotEqualTo(String value) {
            addCriterion("BUS_NAME <>", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameGreaterThan(String value) {
            addCriterion("BUS_NAME >", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUS_NAME >=", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameLessThan(String value) {
            addCriterion("BUS_NAME <", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameLessThanOrEqualTo(String value) {
            addCriterion("BUS_NAME <=", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameLike(String value) {
            addCriterion("BUS_NAME like", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameNotLike(String value) {
            addCriterion("BUS_NAME not like", value, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameIn(List<String> values) {
            addCriterion("BUS_NAME in", values, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameNotIn(List<String> values) {
            addCriterion("BUS_NAME not in", values, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameBetween(String value1, String value2) {
            addCriterion("BUS_NAME between", value1, value2, "busName");
            return (Criteria) this;
        }

        public Criteria andBusNameNotBetween(String value1, String value2) {
            addCriterion("BUS_NAME not between", value1, value2, "busName");
            return (Criteria) this;
        }

        public Criteria andLicenceIsNull() {
            addCriterion("LICENCE is null");
            return (Criteria) this;
        }

        public Criteria andLicenceIsNotNull() {
            addCriterion("LICENCE is not null");
            return (Criteria) this;
        }

        public Criteria andLicenceEqualTo(String value) {
            addCriterion("LICENCE =", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotEqualTo(String value) {
            addCriterion("LICENCE <>", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceGreaterThan(String value) {
            addCriterion("LICENCE >", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceGreaterThanOrEqualTo(String value) {
            addCriterion("LICENCE >=", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceLessThan(String value) {
            addCriterion("LICENCE <", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceLessThanOrEqualTo(String value) {
            addCriterion("LICENCE <=", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceLike(String value) {
            addCriterion("LICENCE like", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotLike(String value) {
            addCriterion("LICENCE not like", value, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceIn(List<String> values) {
            addCriterion("LICENCE in", values, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotIn(List<String> values) {
            addCriterion("LICENCE not in", values, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceBetween(String value1, String value2) {
            addCriterion("LICENCE between", value1, value2, "licence");
            return (Criteria) this;
        }

        public Criteria andLicenceNotBetween(String value1, String value2) {
            addCriterion("LICENCE not between", value1, value2, "licence");
            return (Criteria) this;
        }

        public Criteria andAccRealNameIsNull() {
            addCriterion("ACC_REAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAccRealNameIsNotNull() {
            addCriterion("ACC_REAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAccRealNameEqualTo(String value) {
            addCriterion("ACC_REAL_NAME =", value, "accRealName");
            return (Criteria) this;
        }

        public Criteria andAccRealNameNotEqualTo(String value) {
            addCriterion("ACC_REAL_NAME <>", value, "accRealName");
            return (Criteria) this;
        }

        public Criteria andAccRealNameGreaterThan(String value) {
            addCriterion("ACC_REAL_NAME >", value, "accRealName");
            return (Criteria) this;
        }

        public Criteria andAccRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("ACC_REAL_NAME >=", value, "accRealName");
            return (Criteria) this;
        }

        public Criteria andAccRealNameLessThan(String value) {
            addCriterion("ACC_REAL_NAME <", value, "accRealName");
            return (Criteria) this;
        }

        public Criteria andAccRealNameLessThanOrEqualTo(String value) {
            addCriterion("ACC_REAL_NAME <=", value, "accRealName");
            return (Criteria) this;
        }

        public Criteria andAccRealNameLike(String value) {
            addCriterion("ACC_REAL_NAME like", value, "accRealName");
            return (Criteria) this;
        }

        public Criteria andAccRealNameNotLike(String value) {
            addCriterion("ACC_REAL_NAME not like", value, "accRealName");
            return (Criteria) this;
        }

        public Criteria andAccRealNameIn(List<String> values) {
            addCriterion("ACC_REAL_NAME in", values, "accRealName");
            return (Criteria) this;
        }

        public Criteria andAccRealNameNotIn(List<String> values) {
            addCriterion("ACC_REAL_NAME not in", values, "accRealName");
            return (Criteria) this;
        }

        public Criteria andAccRealNameBetween(String value1, String value2) {
            addCriterion("ACC_REAL_NAME between", value1, value2, "accRealName");
            return (Criteria) this;
        }

        public Criteria andAccRealNameNotBetween(String value1, String value2) {
            addCriterion("ACC_REAL_NAME not between", value1, value2, "accRealName");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("BANK_NAME =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("BANK_NAME <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("BANK_NAME >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NAME >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("BANK_NAME <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("BANK_NAME <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("BANK_NAME like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("BANK_NAME not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("BANK_NAME in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("BANK_NAME not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("BANK_NAME between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("BANK_NAME not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("BANK_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("BANK_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("BANK_ACCOUNT =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("BANK_ACCOUNT <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("BANK_ACCOUNT >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("BANK_ACCOUNT <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("BANK_ACCOUNT like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("BANK_ACCOUNT not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("BANK_ACCOUNT in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("BANK_ACCOUNT not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andLimitYearIsNull() {
            addCriterion("LIMIT_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andLimitYearIsNotNull() {
            addCriterion("LIMIT_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andLimitYearEqualTo(String value) {
            addCriterion("LIMIT_YEAR =", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearNotEqualTo(String value) {
            addCriterion("LIMIT_YEAR <>", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearGreaterThan(String value) {
            addCriterion("LIMIT_YEAR >", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearGreaterThanOrEqualTo(String value) {
            addCriterion("LIMIT_YEAR >=", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearLessThan(String value) {
            addCriterion("LIMIT_YEAR <", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearLessThanOrEqualTo(String value) {
            addCriterion("LIMIT_YEAR <=", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearLike(String value) {
            addCriterion("LIMIT_YEAR like", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearNotLike(String value) {
            addCriterion("LIMIT_YEAR not like", value, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearIn(List<String> values) {
            addCriterion("LIMIT_YEAR in", values, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearNotIn(List<String> values) {
            addCriterion("LIMIT_YEAR not in", values, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearBetween(String value1, String value2) {
            addCriterion("LIMIT_YEAR between", value1, value2, "limitYear");
            return (Criteria) this;
        }

        public Criteria andLimitYearNotBetween(String value1, String value2) {
            addCriterion("LIMIT_YEAR not between", value1, value2, "limitYear");
            return (Criteria) this;
        }

        public Criteria andScaleIsNull() {
            addCriterion("SCALE is null");
            return (Criteria) this;
        }

        public Criteria andScaleIsNotNull() {
            addCriterion("SCALE is not null");
            return (Criteria) this;
        }

        public Criteria andScaleEqualTo(String value) {
            addCriterion("SCALE =", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotEqualTo(String value) {
            addCriterion("SCALE <>", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThan(String value) {
            addCriterion("SCALE >", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThanOrEqualTo(String value) {
            addCriterion("SCALE >=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThan(String value) {
            addCriterion("SCALE <", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThanOrEqualTo(String value) {
            addCriterion("SCALE <=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLike(String value) {
            addCriterion("SCALE like", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotLike(String value) {
            addCriterion("SCALE not like", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleIn(List<String> values) {
            addCriterion("SCALE in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotIn(List<String> values) {
            addCriterion("SCALE not in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleBetween(String value1, String value2) {
            addCriterion("SCALE between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotBetween(String value1, String value2) {
            addCriterion("SCALE not between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andBusDomainIsNull() {
            addCriterion("BUS_DOMAIN is null");
            return (Criteria) this;
        }

        public Criteria andBusDomainIsNotNull() {
            addCriterion("BUS_DOMAIN is not null");
            return (Criteria) this;
        }

        public Criteria andBusDomainEqualTo(String value) {
            addCriterion("BUS_DOMAIN =", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainNotEqualTo(String value) {
            addCriterion("BUS_DOMAIN <>", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainGreaterThan(String value) {
            addCriterion("BUS_DOMAIN >", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainGreaterThanOrEqualTo(String value) {
            addCriterion("BUS_DOMAIN >=", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainLessThan(String value) {
            addCriterion("BUS_DOMAIN <", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainLessThanOrEqualTo(String value) {
            addCriterion("BUS_DOMAIN <=", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainLike(String value) {
            addCriterion("BUS_DOMAIN like", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainNotLike(String value) {
            addCriterion("BUS_DOMAIN not like", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainIn(List<String> values) {
            addCriterion("BUS_DOMAIN in", values, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainNotIn(List<String> values) {
            addCriterion("BUS_DOMAIN not in", values, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainBetween(String value1, String value2) {
            addCriterion("BUS_DOMAIN between", value1, value2, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainNotBetween(String value1, String value2) {
            addCriterion("BUS_DOMAIN not between", value1, value2, "busDomain");
            return (Criteria) this;
        }

        public Criteria andDomainIsNull() {
            addCriterion("DOMAIN is null");
            return (Criteria) this;
        }

        public Criteria andDomainIsNotNull() {
            addCriterion("DOMAIN is not null");
            return (Criteria) this;
        }

        public Criteria andDomainEqualTo(String value) {
            addCriterion("DOMAIN =", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotEqualTo(String value) {
            addCriterion("DOMAIN <>", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThan(String value) {
            addCriterion("DOMAIN >", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(String value) {
            addCriterion("DOMAIN >=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThan(String value) {
            addCriterion("DOMAIN <", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThanOrEqualTo(String value) {
            addCriterion("DOMAIN <=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLike(String value) {
            addCriterion("DOMAIN like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotLike(String value) {
            addCriterion("DOMAIN not like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainIn(List<String> values) {
            addCriterion("DOMAIN in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotIn(List<String> values) {
            addCriterion("DOMAIN not in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainBetween(String value1, String value2) {
            addCriterion("DOMAIN between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotBetween(String value1, String value2) {
            addCriterion("DOMAIN not between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("COUNTRY is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("COUNTRY is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("COUNTRY =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("COUNTRY <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("COUNTRY >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTRY >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("COUNTRY <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("COUNTRY <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("COUNTRY like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("COUNTRY not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("COUNTRY in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("COUNTRY not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("COUNTRY between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("COUNTRY not between", value1, value2, "country");
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

        public Criteria andTelIsNull() {
            addCriterion("TEL is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("TEL is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("TEL =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("TEL <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("TEL >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("TEL >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("TEL <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("TEL <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("TEL like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("TEL not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("TEL in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("TEL not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("TEL between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("TEL not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andLicenceImgIsNull() {
            addCriterion("LICENCE_IMG is null");
            return (Criteria) this;
        }

        public Criteria andLicenceImgIsNotNull() {
            addCriterion("LICENCE_IMG is not null");
            return (Criteria) this;
        }

        public Criteria andLicenceImgEqualTo(String value) {
            addCriterion("LICENCE_IMG =", value, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andLicenceImgNotEqualTo(String value) {
            addCriterion("LICENCE_IMG <>", value, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andLicenceImgGreaterThan(String value) {
            addCriterion("LICENCE_IMG >", value, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andLicenceImgGreaterThanOrEqualTo(String value) {
            addCriterion("LICENCE_IMG >=", value, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andLicenceImgLessThan(String value) {
            addCriterion("LICENCE_IMG <", value, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andLicenceImgLessThanOrEqualTo(String value) {
            addCriterion("LICENCE_IMG <=", value, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andLicenceImgLike(String value) {
            addCriterion("LICENCE_IMG like", value, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andLicenceImgNotLike(String value) {
            addCriterion("LICENCE_IMG not like", value, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andLicenceImgIn(List<String> values) {
            addCriterion("LICENCE_IMG in", values, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andLicenceImgNotIn(List<String> values) {
            addCriterion("LICENCE_IMG not in", values, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andLicenceImgBetween(String value1, String value2) {
            addCriterion("LICENCE_IMG between", value1, value2, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andLicenceImgNotBetween(String value1, String value2) {
            addCriterion("LICENCE_IMG not between", value1, value2, "licenceImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgIsNull() {
            addCriterion("CORPORATE_IMG is null");
            return (Criteria) this;
        }

        public Criteria andCorporateImgIsNotNull() {
            addCriterion("CORPORATE_IMG is not null");
            return (Criteria) this;
        }

        public Criteria andCorporateImgEqualTo(String value) {
            addCriterion("CORPORATE_IMG =", value, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgNotEqualTo(String value) {
            addCriterion("CORPORATE_IMG <>", value, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgGreaterThan(String value) {
            addCriterion("CORPORATE_IMG >", value, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgGreaterThanOrEqualTo(String value) {
            addCriterion("CORPORATE_IMG >=", value, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgLessThan(String value) {
            addCriterion("CORPORATE_IMG <", value, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgLessThanOrEqualTo(String value) {
            addCriterion("CORPORATE_IMG <=", value, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgLike(String value) {
            addCriterion("CORPORATE_IMG like", value, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgNotLike(String value) {
            addCriterion("CORPORATE_IMG not like", value, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgIn(List<String> values) {
            addCriterion("CORPORATE_IMG in", values, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgNotIn(List<String> values) {
            addCriterion("CORPORATE_IMG not in", values, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgBetween(String value1, String value2) {
            addCriterion("CORPORATE_IMG between", value1, value2, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andCorporateImgNotBetween(String value1, String value2) {
            addCriterion("CORPORATE_IMG not between", value1, value2, "corporateImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgIsNull() {
            addCriterion("TRANSATOR_IMG is null");
            return (Criteria) this;
        }

        public Criteria andTransatorImgIsNotNull() {
            addCriterion("TRANSATOR_IMG is not null");
            return (Criteria) this;
        }

        public Criteria andTransatorImgEqualTo(String value) {
            addCriterion("TRANSATOR_IMG =", value, "transatorImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgNotEqualTo(String value) {
            addCriterion("TRANSATOR_IMG <>", value, "transatorImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgGreaterThan(String value) {
            addCriterion("TRANSATOR_IMG >", value, "transatorImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSATOR_IMG >=", value, "transatorImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgLessThan(String value) {
            addCriterion("TRANSATOR_IMG <", value, "transatorImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgLessThanOrEqualTo(String value) {
            addCriterion("TRANSATOR_IMG <=", value, "transatorImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgLike(String value) {
            addCriterion("TRANSATOR_IMG like", value, "transatorImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgNotLike(String value) {
            addCriterion("TRANSATOR_IMG not like", value, "transatorImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgIn(List<String> values) {
            addCriterion("TRANSATOR_IMG in", values, "transatorImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgNotIn(List<String> values) {
            addCriterion("TRANSATOR_IMG not in", values, "transatorImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgBetween(String value1, String value2) {
            addCriterion("TRANSATOR_IMG between", value1, value2, "transatorImg");
            return (Criteria) this;
        }

        public Criteria andTransatorImgNotBetween(String value1, String value2) {
            addCriterion("TRANSATOR_IMG not between", value1, value2, "transatorImg");
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