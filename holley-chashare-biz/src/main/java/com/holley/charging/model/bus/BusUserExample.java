package com.holley.charging.model.bus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusUserExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIsNull() {
            addCriterion("PAY_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIsNotNull() {
            addCriterion("PAY_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordEqualTo(String value) {
            addCriterion("PAY_PASSWORD =", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotEqualTo(String value) {
            addCriterion("PAY_PASSWORD <>", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThan(String value) {
            addCriterion("PAY_PASSWORD >", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_PASSWORD >=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThan(String value) {
            addCriterion("PAY_PASSWORD <", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThanOrEqualTo(String value) {
            addCriterion("PAY_PASSWORD <=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLike(String value) {
            addCriterion("PAY_PASSWORD like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotLike(String value) {
            addCriterion("PAY_PASSWORD not like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIn(List<String> values) {
            addCriterion("PAY_PASSWORD in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotIn(List<String> values) {
            addCriterion("PAY_PASSWORD not in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordBetween(String value1, String value2) {
            addCriterion("PAY_PASSWORD between", value1, value2, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotBetween(String value1, String value2) {
            addCriterion("PAY_PASSWORD not between", value1, value2, "payPassword");
            return (Criteria) this;
        }

        public Criteria andHeadImgIsNull() {
            addCriterion("HEAD_IMG is null");
            return (Criteria) this;
        }

        public Criteria andHeadImgIsNotNull() {
            addCriterion("HEAD_IMG is not null");
            return (Criteria) this;
        }

        public Criteria andHeadImgEqualTo(String value) {
            addCriterion("HEAD_IMG =", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgNotEqualTo(String value) {
            addCriterion("HEAD_IMG <>", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgGreaterThan(String value) {
            addCriterion("HEAD_IMG >", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgGreaterThanOrEqualTo(String value) {
            addCriterion("HEAD_IMG >=", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgLessThan(String value) {
            addCriterion("HEAD_IMG <", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgLessThanOrEqualTo(String value) {
            addCriterion("HEAD_IMG <=", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgLike(String value) {
            addCriterion("HEAD_IMG like", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgNotLike(String value) {
            addCriterion("HEAD_IMG not like", value, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgIn(List<String> values) {
            addCriterion("HEAD_IMG in", values, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgNotIn(List<String> values) {
            addCriterion("HEAD_IMG not in", values, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgBetween(String value1, String value2) {
            addCriterion("HEAD_IMG between", value1, value2, "headImg");
            return (Criteria) this;
        }

        public Criteria andHeadImgNotBetween(String value1, String value2) {
            addCriterion("HEAD_IMG not between", value1, value2, "headImg");
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

        public Criteria andRealStatusIsNull() {
            addCriterion("REAL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andRealStatusIsNotNull() {
            addCriterion("REAL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andRealStatusEqualTo(Short value) {
            addCriterion("REAL_STATUS =", value, "realStatus");
            return (Criteria) this;
        }

        public Criteria andRealStatusNotEqualTo(Short value) {
            addCriterion("REAL_STATUS <>", value, "realStatus");
            return (Criteria) this;
        }

        public Criteria andRealStatusGreaterThan(Short value) {
            addCriterion("REAL_STATUS >", value, "realStatus");
            return (Criteria) this;
        }

        public Criteria andRealStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("REAL_STATUS >=", value, "realStatus");
            return (Criteria) this;
        }

        public Criteria andRealStatusLessThan(Short value) {
            addCriterion("REAL_STATUS <", value, "realStatus");
            return (Criteria) this;
        }

        public Criteria andRealStatusLessThanOrEqualTo(Short value) {
            addCriterion("REAL_STATUS <=", value, "realStatus");
            return (Criteria) this;
        }

        public Criteria andRealStatusIn(List<Short> values) {
            addCriterion("REAL_STATUS in", values, "realStatus");
            return (Criteria) this;
        }

        public Criteria andRealStatusNotIn(List<Short> values) {
            addCriterion("REAL_STATUS not in", values, "realStatus");
            return (Criteria) this;
        }

        public Criteria andRealStatusBetween(Short value1, Short value2) {
            addCriterion("REAL_STATUS between", value1, value2, "realStatus");
            return (Criteria) this;
        }

        public Criteria andRealStatusNotBetween(Short value1, Short value2) {
            addCriterion("REAL_STATUS not between", value1, value2, "realStatus");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIsNull() {
            addCriterion("EMAIL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIsNotNull() {
            addCriterion("EMAIL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andEmailStatusEqualTo(Short value) {
            addCriterion("EMAIL_STATUS =", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotEqualTo(Short value) {
            addCriterion("EMAIL_STATUS <>", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusGreaterThan(Short value) {
            addCriterion("EMAIL_STATUS >", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("EMAIL_STATUS >=", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusLessThan(Short value) {
            addCriterion("EMAIL_STATUS <", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusLessThanOrEqualTo(Short value) {
            addCriterion("EMAIL_STATUS <=", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIn(List<Short> values) {
            addCriterion("EMAIL_STATUS in", values, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotIn(List<Short> values) {
            addCriterion("EMAIL_STATUS not in", values, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusBetween(Short value1, Short value2) {
            addCriterion("EMAIL_STATUS between", value1, value2, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotBetween(Short value1, Short value2) {
            addCriterion("EMAIL_STATUS not between", value1, value2, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusIsNull() {
            addCriterion("PHONE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusIsNotNull() {
            addCriterion("PHONE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusEqualTo(Short value) {
            addCriterion("PHONE_STATUS =", value, "phoneStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusNotEqualTo(Short value) {
            addCriterion("PHONE_STATUS <>", value, "phoneStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusGreaterThan(Short value) {
            addCriterion("PHONE_STATUS >", value, "phoneStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("PHONE_STATUS >=", value, "phoneStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusLessThan(Short value) {
            addCriterion("PHONE_STATUS <", value, "phoneStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusLessThanOrEqualTo(Short value) {
            addCriterion("PHONE_STATUS <=", value, "phoneStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusIn(List<Short> values) {
            addCriterion("PHONE_STATUS in", values, "phoneStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusNotIn(List<Short> values) {
            addCriterion("PHONE_STATUS not in", values, "phoneStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusBetween(Short value1, Short value2) {
            addCriterion("PHONE_STATUS between", value1, value2, "phoneStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneStatusNotBetween(Short value1, Short value2) {
            addCriterion("PHONE_STATUS not between", value1, value2, "phoneStatus");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("USER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("USER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Short value) {
            addCriterion("USER_TYPE =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Short value) {
            addCriterion("USER_TYPE <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Short value) {
            addCriterion("USER_TYPE >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("USER_TYPE >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Short value) {
            addCriterion("USER_TYPE <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Short value) {
            addCriterion("USER_TYPE <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Short> values) {
            addCriterion("USER_TYPE in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Short> values) {
            addCriterion("USER_TYPE not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Short value1, Short value2) {
            addCriterion("USER_TYPE between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Short value1, Short value2) {
            addCriterion("USER_TYPE not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNull() {
            addCriterion("INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(Integer value) {
            addCriterion("INFO_ID =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(Integer value) {
            addCriterion("INFO_ID <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(Integer value) {
            addCriterion("INFO_ID >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("INFO_ID >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(Integer value) {
            addCriterion("INFO_ID <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("INFO_ID <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<Integer> values) {
            addCriterion("INFO_ID in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<Integer> values) {
            addCriterion("INFO_ID not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("INFO_ID between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("INFO_ID not between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("GROUP_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("GROUP_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("GROUP_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GROUP_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("GROUP_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("GROUP_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("GROUP_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("GROUP_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_ID not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andRegistTimeIsNull() {
            addCriterion("REGIST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRegistTimeIsNotNull() {
            addCriterion("REGIST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRegistTimeEqualTo(Date value) {
            addCriterion("REGIST_TIME =", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeNotEqualTo(Date value) {
            addCriterion("REGIST_TIME <>", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeGreaterThan(Date value) {
            addCriterion("REGIST_TIME >", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REGIST_TIME >=", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeLessThan(Date value) {
            addCriterion("REGIST_TIME <", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeLessThanOrEqualTo(Date value) {
            addCriterion("REGIST_TIME <=", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeIn(List<Date> values) {
            addCriterion("REGIST_TIME in", values, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeNotIn(List<Date> values) {
            addCriterion("REGIST_TIME not in", values, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeBetween(Date value1, Date value2) {
            addCriterion("REGIST_TIME between", value1, value2, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeNotBetween(Date value1, Date value2) {
            addCriterion("REGIST_TIME not between", value1, value2, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistIpIsNull() {
            addCriterion("REGIST_IP is null");
            return (Criteria) this;
        }

        public Criteria andRegistIpIsNotNull() {
            addCriterion("REGIST_IP is not null");
            return (Criteria) this;
        }

        public Criteria andRegistIpEqualTo(String value) {
            addCriterion("REGIST_IP =", value, "registIp");
            return (Criteria) this;
        }

        public Criteria andRegistIpNotEqualTo(String value) {
            addCriterion("REGIST_IP <>", value, "registIp");
            return (Criteria) this;
        }

        public Criteria andRegistIpGreaterThan(String value) {
            addCriterion("REGIST_IP >", value, "registIp");
            return (Criteria) this;
        }

        public Criteria andRegistIpGreaterThanOrEqualTo(String value) {
            addCriterion("REGIST_IP >=", value, "registIp");
            return (Criteria) this;
        }

        public Criteria andRegistIpLessThan(String value) {
            addCriterion("REGIST_IP <", value, "registIp");
            return (Criteria) this;
        }

        public Criteria andRegistIpLessThanOrEqualTo(String value) {
            addCriterion("REGIST_IP <=", value, "registIp");
            return (Criteria) this;
        }

        public Criteria andRegistIpLike(String value) {
            addCriterion("REGIST_IP like", value, "registIp");
            return (Criteria) this;
        }

        public Criteria andRegistIpNotLike(String value) {
            addCriterion("REGIST_IP not like", value, "registIp");
            return (Criteria) this;
        }

        public Criteria andRegistIpIn(List<String> values) {
            addCriterion("REGIST_IP in", values, "registIp");
            return (Criteria) this;
        }

        public Criteria andRegistIpNotIn(List<String> values) {
            addCriterion("REGIST_IP not in", values, "registIp");
            return (Criteria) this;
        }

        public Criteria andRegistIpBetween(String value1, String value2) {
            addCriterion("REGIST_IP between", value1, value2, "registIp");
            return (Criteria) this;
        }

        public Criteria andRegistIpNotBetween(String value1, String value2) {
            addCriterion("REGIST_IP not between", value1, value2, "registIp");
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