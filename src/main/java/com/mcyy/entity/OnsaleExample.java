package com.mcyy.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OnsaleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OnsaleExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andOIdIsNull() {
            addCriterion("o_id is null");
            return (Criteria) this;
        }

        public Criteria andOIdIsNotNull() {
            addCriterion("o_id is not null");
            return (Criteria) this;
        }

        public Criteria andOIdEqualTo(Integer value) {
            addCriterion("o_id =", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotEqualTo(Integer value) {
            addCriterion("o_id <>", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThan(Integer value) {
            addCriterion("o_id >", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_id >=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThan(Integer value) {
            addCriterion("o_id <", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThanOrEqualTo(Integer value) {
            addCriterion("o_id <=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdIn(List<Integer> values) {
            addCriterion("o_id in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotIn(List<Integer> values) {
            addCriterion("o_id not in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdBetween(Integer value1, Integer value2) {
            addCriterion("o_id between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotBetween(Integer value1, Integer value2) {
            addCriterion("o_id not between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andONameIsNull() {
            addCriterion("o_name is null");
            return (Criteria) this;
        }

        public Criteria andONameIsNotNull() {
            addCriterion("o_name is not null");
            return (Criteria) this;
        }

        public Criteria andONameEqualTo(String value) {
            addCriterion("o_name =", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameNotEqualTo(String value) {
            addCriterion("o_name <>", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameGreaterThan(String value) {
            addCriterion("o_name >", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameGreaterThanOrEqualTo(String value) {
            addCriterion("o_name >=", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameLessThan(String value) {
            addCriterion("o_name <", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameLessThanOrEqualTo(String value) {
            addCriterion("o_name <=", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameLike(String value) {
            addCriterion("o_name like", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameNotLike(String value) {
            addCriterion("o_name not like", value, "oName");
            return (Criteria) this;
        }

        public Criteria andONameIn(List<String> values) {
            addCriterion("o_name in", values, "oName");
            return (Criteria) this;
        }

        public Criteria andONameNotIn(List<String> values) {
            addCriterion("o_name not in", values, "oName");
            return (Criteria) this;
        }

        public Criteria andONameBetween(String value1, String value2) {
            addCriterion("o_name between", value1, value2, "oName");
            return (Criteria) this;
        }

        public Criteria andONameNotBetween(String value1, String value2) {
            addCriterion("o_name not between", value1, value2, "oName");
            return (Criteria) this;
        }

        public Criteria andOPriceIsNull() {
            addCriterion("o_price is null");
            return (Criteria) this;
        }

        public Criteria andOPriceIsNotNull() {
            addCriterion("o_price is not null");
            return (Criteria) this;
        }

        public Criteria andOPriceEqualTo(BigDecimal value) {
            addCriterion("o_price =", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceNotEqualTo(BigDecimal value) {
            addCriterion("o_price <>", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceGreaterThan(BigDecimal value) {
            addCriterion("o_price >", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("o_price >=", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceLessThan(BigDecimal value) {
            addCriterion("o_price <", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("o_price <=", value, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceIn(List<BigDecimal> values) {
            addCriterion("o_price in", values, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceNotIn(List<BigDecimal> values) {
            addCriterion("o_price not in", values, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("o_price between", value1, value2, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("o_price not between", value1, value2, "oPrice");
            return (Criteria) this;
        }

        public Criteria andOCountIsNull() {
            addCriterion("o_count is null");
            return (Criteria) this;
        }

        public Criteria andOCountIsNotNull() {
            addCriterion("o_count is not null");
            return (Criteria) this;
        }

        public Criteria andOCountEqualTo(Integer value) {
            addCriterion("o_count =", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountNotEqualTo(Integer value) {
            addCriterion("o_count <>", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountGreaterThan(Integer value) {
            addCriterion("o_count >", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_count >=", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountLessThan(Integer value) {
            addCriterion("o_count <", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountLessThanOrEqualTo(Integer value) {
            addCriterion("o_count <=", value, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountIn(List<Integer> values) {
            addCriterion("o_count in", values, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountNotIn(List<Integer> values) {
            addCriterion("o_count not in", values, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountBetween(Integer value1, Integer value2) {
            addCriterion("o_count between", value1, value2, "oCount");
            return (Criteria) this;
        }

        public Criteria andOCountNotBetween(Integer value1, Integer value2) {
            addCriterion("o_count not between", value1, value2, "oCount");
            return (Criteria) this;
        }

        public Criteria andOStateIsNull() {
            addCriterion("o_state is null");
            return (Criteria) this;
        }

        public Criteria andOStateIsNotNull() {
            addCriterion("o_state is not null");
            return (Criteria) this;
        }

        public Criteria andOStateEqualTo(String value) {
            addCriterion("o_state =", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateNotEqualTo(String value) {
            addCriterion("o_state <>", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateGreaterThan(String value) {
            addCriterion("o_state >", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateGreaterThanOrEqualTo(String value) {
            addCriterion("o_state >=", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateLessThan(String value) {
            addCriterion("o_state <", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateLessThanOrEqualTo(String value) {
            addCriterion("o_state <=", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateLike(String value) {
            addCriterion("o_state like", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateNotLike(String value) {
            addCriterion("o_state not like", value, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateIn(List<String> values) {
            addCriterion("o_state in", values, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateNotIn(List<String> values) {
            addCriterion("o_state not in", values, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateBetween(String value1, String value2) {
            addCriterion("o_state between", value1, value2, "oState");
            return (Criteria) this;
        }

        public Criteria andOStateNotBetween(String value1, String value2) {
            addCriterion("o_state not between", value1, value2, "oState");
            return (Criteria) this;
        }

        public Criteria andOPastdateIsNull() {
            addCriterion("o_pastdate is null");
            return (Criteria) this;
        }

        public Criteria andOPastdateIsNotNull() {
            addCriterion("o_pastdate is not null");
            return (Criteria) this;
        }

        public Criteria andOPastdateEqualTo(Date value) {
            addCriterionForJDBCDate("o_pastdate =", value, "oPastdate");
            return (Criteria) this;
        }

        public Criteria andOPastdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("o_pastdate <>", value, "oPastdate");
            return (Criteria) this;
        }

        public Criteria andOPastdateGreaterThan(Date value) {
            addCriterionForJDBCDate("o_pastdate >", value, "oPastdate");
            return (Criteria) this;
        }

        public Criteria andOPastdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("o_pastdate >=", value, "oPastdate");
            return (Criteria) this;
        }

        public Criteria andOPastdateLessThan(Date value) {
            addCriterionForJDBCDate("o_pastdate <", value, "oPastdate");
            return (Criteria) this;
        }

        public Criteria andOPastdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("o_pastdate <=", value, "oPastdate");
            return (Criteria) this;
        }

        public Criteria andOPastdateIn(List<Date> values) {
            addCriterionForJDBCDate("o_pastdate in", values, "oPastdate");
            return (Criteria) this;
        }

        public Criteria andOPastdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("o_pastdate not in", values, "oPastdate");
            return (Criteria) this;
        }

        public Criteria andOPastdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("o_pastdate between", value1, value2, "oPastdate");
            return (Criteria) this;
        }

        public Criteria andOPastdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("o_pastdate not between", value1, value2, "oPastdate");
            return (Criteria) this;
        }

        public Criteria andOClassifyIsNull() {
            addCriterion("o_classify is null");
            return (Criteria) this;
        }

        public Criteria andOClassifyIsNotNull() {
            addCriterion("o_classify is not null");
            return (Criteria) this;
        }

        public Criteria andOClassifyEqualTo(String value) {
            addCriterion("o_classify =", value, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOClassifyNotEqualTo(String value) {
            addCriterion("o_classify <>", value, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOClassifyGreaterThan(String value) {
            addCriterion("o_classify >", value, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOClassifyGreaterThanOrEqualTo(String value) {
            addCriterion("o_classify >=", value, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOClassifyLessThan(String value) {
            addCriterion("o_classify <", value, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOClassifyLessThanOrEqualTo(String value) {
            addCriterion("o_classify <=", value, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOClassifyLike(String value) {
            addCriterion("o_classify like", value, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOClassifyNotLike(String value) {
            addCriterion("o_classify not like", value, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOClassifyIn(List<String> values) {
            addCriterion("o_classify in", values, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOClassifyNotIn(List<String> values) {
            addCriterion("o_classify not in", values, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOClassifyBetween(String value1, String value2) {
            addCriterion("o_classify between", value1, value2, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOClassifyNotBetween(String value1, String value2) {
            addCriterion("o_classify not between", value1, value2, "oClassify");
            return (Criteria) this;
        }

        public Criteria andOOperatorIsNull() {
            addCriterion("o_operator is null");
            return (Criteria) this;
        }

        public Criteria andOOperatorIsNotNull() {
            addCriterion("o_operator is not null");
            return (Criteria) this;
        }

        public Criteria andOOperatorEqualTo(String value) {
            addCriterion("o_operator =", value, "oOperator");
            return (Criteria) this;
        }

        public Criteria andOOperatorNotEqualTo(String value) {
            addCriterion("o_operator <>", value, "oOperator");
            return (Criteria) this;
        }

        public Criteria andOOperatorGreaterThan(String value) {
            addCriterion("o_operator >", value, "oOperator");
            return (Criteria) this;
        }

        public Criteria andOOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("o_operator >=", value, "oOperator");
            return (Criteria) this;
        }

        public Criteria andOOperatorLessThan(String value) {
            addCriterion("o_operator <", value, "oOperator");
            return (Criteria) this;
        }

        public Criteria andOOperatorLessThanOrEqualTo(String value) {
            addCriterion("o_operator <=", value, "oOperator");
            return (Criteria) this;
        }

        public Criteria andOOperatorLike(String value) {
            addCriterion("o_operator like", value, "oOperator");
            return (Criteria) this;
        }

        public Criteria andOOperatorNotLike(String value) {
            addCriterion("o_operator not like", value, "oOperator");
            return (Criteria) this;
        }

        public Criteria andOOperatorIn(List<String> values) {
            addCriterion("o_operator in", values, "oOperator");
            return (Criteria) this;
        }

        public Criteria andOOperatorNotIn(List<String> values) {
            addCriterion("o_operator not in", values, "oOperator");
            return (Criteria) this;
        }

        public Criteria andOOperatorBetween(String value1, String value2) {
            addCriterion("o_operator between", value1, value2, "oOperator");
            return (Criteria) this;
        }

        public Criteria andOOperatorNotBetween(String value1, String value2) {
            addCriterion("o_operator not between", value1, value2, "oOperator");
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