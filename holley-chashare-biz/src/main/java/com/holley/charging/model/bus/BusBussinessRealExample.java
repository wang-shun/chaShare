package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusBussinessRealExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusBussinessRealExample() {
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

        public Criteria andBusInfoIdIsNull() {
            addCriterion("BUS_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andBusInfoIdIsNotNull() {
            addCriterion("BUS_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBusInfoIdEqualTo(Integer value) {
            addCriterion("BUS_INFO_ID =", value, "busInfoId");
            return (Criteria) this;
        }

        public Criteria andBusInfoIdNotEqualTo(Integer value) {
            addCriterion("BUS_INFO_ID <>", value, "busInfoId");
            return (Criteria) this;
        }

        public Criteria andBusInfoIdGreaterThan(Integer value) {
            addCriterion("BUS_INFO_ID >", value, "busInfoId");
            return (Criteria) this;
        }

        public Criteria andBusInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUS_INFO_ID >=", value, "busInfoId");
            return (Criteria) this;
        }

        public Criteria andBusInfoIdLessThan(Integer value) {
            addCriterion("BUS_INFO_ID <", value, "busInfoId");
            return (Criteria) this;
        }

        public Criteria andBusInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("BUS_INFO_ID <=", value, "busInfoId");
            return (Criteria) this;
        }

        public Criteria andBusInfoIdIn(List<Integer> values) {
            addCriterion("BUS_INFO_ID in", values, "busInfoId");
            return (Criteria) this;
        }

        public Criteria andBusInfoIdNotIn(List<Integer> values) {
            addCriterion("BUS_INFO_ID not in", values, "busInfoId");
            return (Criteria) this;
        }

        public Criteria andBusInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("BUS_INFO_ID between", value1, value2, "busInfoId");
            return (Criteria) this;
        }

        public Criteria andBusInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BUS_INFO_ID not between", value1, value2, "busInfoId");
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

        public Criteria andValidMoneyIsNull() {
            addCriterion("VALID_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andValidMoneyIsNotNull() {
            addCriterion("VALID_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andValidMoneyEqualTo(BigDecimal value) {
            addCriterion("VALID_MONEY =", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyNotEqualTo(BigDecimal value) {
            addCriterion("VALID_MONEY <>", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyGreaterThan(BigDecimal value) {
            addCriterion("VALID_MONEY >", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VALID_MONEY >=", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyLessThan(BigDecimal value) {
            addCriterion("VALID_MONEY <", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("VALID_MONEY <=", value, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyIn(List<BigDecimal> values) {
            addCriterion("VALID_MONEY in", values, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyNotIn(List<BigDecimal> values) {
            addCriterion("VALID_MONEY not in", values, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALID_MONEY between", value1, value2, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALID_MONEY not between", value1, value2, "validMoney");
            return (Criteria) this;
        }

        public Criteria andValidCodeIsNull() {
            addCriterion("VALID_CODE is null");
            return (Criteria) this;
        }

        public Criteria andValidCodeIsNotNull() {
            addCriterion("VALID_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andValidCodeEqualTo(String value) {
            addCriterion("VALID_CODE =", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotEqualTo(String value) {
            addCriterion("VALID_CODE <>", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeGreaterThan(String value) {
            addCriterion("VALID_CODE >", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeGreaterThanOrEqualTo(String value) {
            addCriterion("VALID_CODE >=", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeLessThan(String value) {
            addCriterion("VALID_CODE <", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeLessThanOrEqualTo(String value) {
            addCriterion("VALID_CODE <=", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeLike(String value) {
            addCriterion("VALID_CODE like", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotLike(String value) {
            addCriterion("VALID_CODE not like", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeIn(List<String> values) {
            addCriterion("VALID_CODE in", values, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotIn(List<String> values) {
            addCriterion("VALID_CODE not in", values, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeBetween(String value1, String value2) {
            addCriterion("VALID_CODE between", value1, value2, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotBetween(String value1, String value2) {
            addCriterion("VALID_CODE not between", value1, value2, "validCode");
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