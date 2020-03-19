package com.mcyy.entity;

import java.util.ArrayList;
import java.util.List;

public class ClientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClientExample() {
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

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCClientnameIsNull() {
            addCriterion("c_clientname is null");
            return (Criteria) this;
        }

        public Criteria andCClientnameIsNotNull() {
            addCriterion("c_clientname is not null");
            return (Criteria) this;
        }

        public Criteria andCClientnameEqualTo(String value) {
            addCriterion("c_clientname =", value, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCClientnameNotEqualTo(String value) {
            addCriterion("c_clientname <>", value, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCClientnameGreaterThan(String value) {
            addCriterion("c_clientname >", value, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCClientnameGreaterThanOrEqualTo(String value) {
            addCriterion("c_clientname >=", value, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCClientnameLessThan(String value) {
            addCriterion("c_clientname <", value, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCClientnameLessThanOrEqualTo(String value) {
            addCriterion("c_clientname <=", value, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCClientnameLike(String value) {
            addCriterion("c_clientname like", value, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCClientnameNotLike(String value) {
            addCriterion("c_clientname not like", value, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCClientnameIn(List<String> values) {
            addCriterion("c_clientname in", values, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCClientnameNotIn(List<String> values) {
            addCriterion("c_clientname not in", values, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCClientnameBetween(String value1, String value2) {
            addCriterion("c_clientname between", value1, value2, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCClientnameNotBetween(String value1, String value2) {
            addCriterion("c_clientname not between", value1, value2, "cClientname");
            return (Criteria) this;
        }

        public Criteria andCPasswordIsNull() {
            addCriterion("c_password is null");
            return (Criteria) this;
        }

        public Criteria andCPasswordIsNotNull() {
            addCriterion("c_password is not null");
            return (Criteria) this;
        }

        public Criteria andCPasswordEqualTo(String value) {
            addCriterion("c_password =", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordNotEqualTo(String value) {
            addCriterion("c_password <>", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordGreaterThan(String value) {
            addCriterion("c_password >", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("c_password >=", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordLessThan(String value) {
            addCriterion("c_password <", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordLessThanOrEqualTo(String value) {
            addCriterion("c_password <=", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordLike(String value) {
            addCriterion("c_password like", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordNotLike(String value) {
            addCriterion("c_password not like", value, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordIn(List<String> values) {
            addCriterion("c_password in", values, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordNotIn(List<String> values) {
            addCriterion("c_password not in", values, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordBetween(String value1, String value2) {
            addCriterion("c_password between", value1, value2, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPasswordNotBetween(String value1, String value2) {
            addCriterion("c_password not between", value1, value2, "cPassword");
            return (Criteria) this;
        }

        public Criteria andCPhonenumIsNull() {
            addCriterion("c_phonenum is null");
            return (Criteria) this;
        }

        public Criteria andCPhonenumIsNotNull() {
            addCriterion("c_phonenum is not null");
            return (Criteria) this;
        }

        public Criteria andCPhonenumEqualTo(String value) {
            addCriterion("c_phonenum =", value, "cPhonenum");
            return (Criteria) this;
        }

        public Criteria andCPhonenumNotEqualTo(String value) {
            addCriterion("c_phonenum <>", value, "cPhonenum");
            return (Criteria) this;
        }

        public Criteria andCPhonenumGreaterThan(String value) {
            addCriterion("c_phonenum >", value, "cPhonenum");
            return (Criteria) this;
        }

        public Criteria andCPhonenumGreaterThanOrEqualTo(String value) {
            addCriterion("c_phonenum >=", value, "cPhonenum");
            return (Criteria) this;
        }

        public Criteria andCPhonenumLessThan(String value) {
            addCriterion("c_phonenum <", value, "cPhonenum");
            return (Criteria) this;
        }

        public Criteria andCPhonenumLessThanOrEqualTo(String value) {
            addCriterion("c_phonenum <=", value, "cPhonenum");
            return (Criteria) this;
        }

        public Criteria andCPhonenumLike(String value) {
            addCriterion("c_phonenum like", value, "cPhonenum");
            return (Criteria) this;
        }

        public Criteria andCPhonenumNotLike(String value) {
            addCriterion("c_phonenum not like", value, "cPhonenum");
            return (Criteria) this;
        }

        public Criteria andCPhonenumIn(List<String> values) {
            addCriterion("c_phonenum in", values, "cPhonenum");
            return (Criteria) this;
        }

        public Criteria andCPhonenumNotIn(List<String> values) {
            addCriterion("c_phonenum not in", values, "cPhonenum");
            return (Criteria) this;
        }

        public Criteria andCPhonenumBetween(String value1, String value2) {
            addCriterion("c_phonenum between", value1, value2, "cPhonenum");
            return (Criteria) this;
        }

        public Criteria andCPhonenumNotBetween(String value1, String value2) {
            addCriterion("c_phonenum not between", value1, value2, "cPhonenum");
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