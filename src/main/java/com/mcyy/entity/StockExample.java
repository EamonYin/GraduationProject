package com.mcyy.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockExample() {
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

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSMedicineidIsNull() {
            addCriterion("s_medicineid is null");
            return (Criteria) this;
        }

        public Criteria andSMedicineidIsNotNull() {
            addCriterion("s_medicineid is not null");
            return (Criteria) this;
        }

        public Criteria andSMedicineidEqualTo(Integer value) {
            addCriterion("s_medicineid =", value, "sMedicineid");
            return (Criteria) this;
        }

        public Criteria andSMedicineidNotEqualTo(Integer value) {
            addCriterion("s_medicineid <>", value, "sMedicineid");
            return (Criteria) this;
        }

        public Criteria andSMedicineidGreaterThan(Integer value) {
            addCriterion("s_medicineid >", value, "sMedicineid");
            return (Criteria) this;
        }

        public Criteria andSMedicineidGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_medicineid >=", value, "sMedicineid");
            return (Criteria) this;
        }

        public Criteria andSMedicineidLessThan(Integer value) {
            addCriterion("s_medicineid <", value, "sMedicineid");
            return (Criteria) this;
        }

        public Criteria andSMedicineidLessThanOrEqualTo(Integer value) {
            addCriterion("s_medicineid <=", value, "sMedicineid");
            return (Criteria) this;
        }

        public Criteria andSMedicineidIn(List<Integer> values) {
            addCriterion("s_medicineid in", values, "sMedicineid");
            return (Criteria) this;
        }

        public Criteria andSMedicineidNotIn(List<Integer> values) {
            addCriterion("s_medicineid not in", values, "sMedicineid");
            return (Criteria) this;
        }

        public Criteria andSMedicineidBetween(Integer value1, Integer value2) {
            addCriterion("s_medicineid between", value1, value2, "sMedicineid");
            return (Criteria) this;
        }

        public Criteria andSMedicineidNotBetween(Integer value1, Integer value2) {
            addCriterion("s_medicineid not between", value1, value2, "sMedicineid");
            return (Criteria) this;
        }

        public Criteria andSCountIsNull() {
            addCriterion("s_count is null");
            return (Criteria) this;
        }

        public Criteria andSCountIsNotNull() {
            addCriterion("s_count is not null");
            return (Criteria) this;
        }

        public Criteria andSCountEqualTo(Integer value) {
            addCriterion("s_count =", value, "sCount");
            return (Criteria) this;
        }

        public Criteria andSCountNotEqualTo(Integer value) {
            addCriterion("s_count <>", value, "sCount");
            return (Criteria) this;
        }

        public Criteria andSCountGreaterThan(Integer value) {
            addCriterion("s_count >", value, "sCount");
            return (Criteria) this;
        }

        public Criteria andSCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_count >=", value, "sCount");
            return (Criteria) this;
        }

        public Criteria andSCountLessThan(Integer value) {
            addCriterion("s_count <", value, "sCount");
            return (Criteria) this;
        }

        public Criteria andSCountLessThanOrEqualTo(Integer value) {
            addCriterion("s_count <=", value, "sCount");
            return (Criteria) this;
        }

        public Criteria andSCountIn(List<Integer> values) {
            addCriterion("s_count in", values, "sCount");
            return (Criteria) this;
        }

        public Criteria andSCountNotIn(List<Integer> values) {
            addCriterion("s_count not in", values, "sCount");
            return (Criteria) this;
        }

        public Criteria andSCountBetween(Integer value1, Integer value2) {
            addCriterion("s_count between", value1, value2, "sCount");
            return (Criteria) this;
        }

        public Criteria andSCountNotBetween(Integer value1, Integer value2) {
            addCriterion("s_count not between", value1, value2, "sCount");
            return (Criteria) this;
        }

        public Criteria andSPastdateIsNull() {
            addCriterion("s_pastdate is null");
            return (Criteria) this;
        }

        public Criteria andSPastdateIsNotNull() {
            addCriterion("s_pastdate is not null");
            return (Criteria) this;
        }

        public Criteria andSPastdateEqualTo(Date value) {
            addCriterionForJDBCDate("s_pastdate =", value, "sPastdate");
            return (Criteria) this;
        }

        public Criteria andSPastdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("s_pastdate <>", value, "sPastdate");
            return (Criteria) this;
        }

        public Criteria andSPastdateGreaterThan(Date value) {
            addCriterionForJDBCDate("s_pastdate >", value, "sPastdate");
            return (Criteria) this;
        }

        public Criteria andSPastdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_pastdate >=", value, "sPastdate");
            return (Criteria) this;
        }

        public Criteria andSPastdateLessThan(Date value) {
            addCriterionForJDBCDate("s_pastdate <", value, "sPastdate");
            return (Criteria) this;
        }

        public Criteria andSPastdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_pastdate <=", value, "sPastdate");
            return (Criteria) this;
        }

        public Criteria andSPastdateIn(List<Date> values) {
            addCriterionForJDBCDate("s_pastdate in", values, "sPastdate");
            return (Criteria) this;
        }

        public Criteria andSPastdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("s_pastdate not in", values, "sPastdate");
            return (Criteria) this;
        }

        public Criteria andSPastdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_pastdate between", value1, value2, "sPastdate");
            return (Criteria) this;
        }

        public Criteria andSPastdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_pastdate not between", value1, value2, "sPastdate");
            return (Criteria) this;
        }

        public Criteria andSPriceIsNull() {
            addCriterion("s_price is null");
            return (Criteria) this;
        }

        public Criteria andSPriceIsNotNull() {
            addCriterion("s_price is not null");
            return (Criteria) this;
        }

        public Criteria andSPriceEqualTo(BigDecimal value) {
            addCriterion("s_price =", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceNotEqualTo(BigDecimal value) {
            addCriterion("s_price <>", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceGreaterThan(BigDecimal value) {
            addCriterion("s_price >", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("s_price >=", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceLessThan(BigDecimal value) {
            addCriterion("s_price <", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("s_price <=", value, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceIn(List<BigDecimal> values) {
            addCriterion("s_price in", values, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceNotIn(List<BigDecimal> values) {
            addCriterion("s_price not in", values, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("s_price between", value1, value2, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("s_price not between", value1, value2, "sPrice");
            return (Criteria) this;
        }

        public Criteria andSTodayIsNull() {
            addCriterion("s_today is null");
            return (Criteria) this;
        }

        public Criteria andSTodayIsNotNull() {
            addCriterion("s_today is not null");
            return (Criteria) this;
        }

        public Criteria andSTodayEqualTo(Date value) {
            addCriterionForJDBCDate("s_today =", value, "sToday");
            return (Criteria) this;
        }

        public Criteria andSTodayNotEqualTo(Date value) {
            addCriterionForJDBCDate("s_today <>", value, "sToday");
            return (Criteria) this;
        }

        public Criteria andSTodayGreaterThan(Date value) {
            addCriterionForJDBCDate("s_today >", value, "sToday");
            return (Criteria) this;
        }

        public Criteria andSTodayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_today >=", value, "sToday");
            return (Criteria) this;
        }

        public Criteria andSTodayLessThan(Date value) {
            addCriterionForJDBCDate("s_today <", value, "sToday");
            return (Criteria) this;
        }

        public Criteria andSTodayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("s_today <=", value, "sToday");
            return (Criteria) this;
        }

        public Criteria andSTodayIn(List<Date> values) {
            addCriterionForJDBCDate("s_today in", values, "sToday");
            return (Criteria) this;
        }

        public Criteria andSTodayNotIn(List<Date> values) {
            addCriterionForJDBCDate("s_today not in", values, "sToday");
            return (Criteria) this;
        }

        public Criteria andSTodayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_today between", value1, value2, "sToday");
            return (Criteria) this;
        }

        public Criteria andSTodayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("s_today not between", value1, value2, "sToday");
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