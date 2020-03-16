package com.mcyy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReturnsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReturnsExample() {
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

        public Criteria andRIdIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andRIdIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andRIdEqualTo(Integer value) {
            addCriterion("r_id =", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotEqualTo(Integer value) {
            addCriterion("r_id <>", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThan(Integer value) {
            addCriterion("r_id >", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_id >=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThan(Integer value) {
            addCriterion("r_id <", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThanOrEqualTo(Integer value) {
            addCriterion("r_id <=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdIn(List<Integer> values) {
            addCriterion("r_id in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotIn(List<Integer> values) {
            addCriterion("r_id not in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdBetween(Integer value1, Integer value2) {
            addCriterion("r_id between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotBetween(Integer value1, Integer value2) {
            addCriterion("r_id not between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRMedicineidIsNull() {
            addCriterion("r_medicineid is null");
            return (Criteria) this;
        }

        public Criteria andRMedicineidIsNotNull() {
            addCriterion("r_medicineid is not null");
            return (Criteria) this;
        }

        public Criteria andRMedicineidEqualTo(Integer value) {
            addCriterion("r_medicineid =", value, "rMedicineid");
            return (Criteria) this;
        }

        public Criteria andRMedicineidNotEqualTo(Integer value) {
            addCriterion("r_medicineid <>", value, "rMedicineid");
            return (Criteria) this;
        }

        public Criteria andRMedicineidGreaterThan(Integer value) {
            addCriterion("r_medicineid >", value, "rMedicineid");
            return (Criteria) this;
        }

        public Criteria andRMedicineidGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_medicineid >=", value, "rMedicineid");
            return (Criteria) this;
        }

        public Criteria andRMedicineidLessThan(Integer value) {
            addCriterion("r_medicineid <", value, "rMedicineid");
            return (Criteria) this;
        }

        public Criteria andRMedicineidLessThanOrEqualTo(Integer value) {
            addCriterion("r_medicineid <=", value, "rMedicineid");
            return (Criteria) this;
        }

        public Criteria andRMedicineidIn(List<Integer> values) {
            addCriterion("r_medicineid in", values, "rMedicineid");
            return (Criteria) this;
        }

        public Criteria andRMedicineidNotIn(List<Integer> values) {
            addCriterion("r_medicineid not in", values, "rMedicineid");
            return (Criteria) this;
        }

        public Criteria andRMedicineidBetween(Integer value1, Integer value2) {
            addCriterion("r_medicineid between", value1, value2, "rMedicineid");
            return (Criteria) this;
        }

        public Criteria andRMedicineidNotBetween(Integer value1, Integer value2) {
            addCriterion("r_medicineid not between", value1, value2, "rMedicineid");
            return (Criteria) this;
        }

        public Criteria andRCountIsNull() {
            addCriterion("r_count is null");
            return (Criteria) this;
        }

        public Criteria andRCountIsNotNull() {
            addCriterion("r_count is not null");
            return (Criteria) this;
        }

        public Criteria andRCountEqualTo(Integer value) {
            addCriterion("r_count =", value, "rCount");
            return (Criteria) this;
        }

        public Criteria andRCountNotEqualTo(Integer value) {
            addCriterion("r_count <>", value, "rCount");
            return (Criteria) this;
        }

        public Criteria andRCountGreaterThan(Integer value) {
            addCriterion("r_count >", value, "rCount");
            return (Criteria) this;
        }

        public Criteria andRCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_count >=", value, "rCount");
            return (Criteria) this;
        }

        public Criteria andRCountLessThan(Integer value) {
            addCriterion("r_count <", value, "rCount");
            return (Criteria) this;
        }

        public Criteria andRCountLessThanOrEqualTo(Integer value) {
            addCriterion("r_count <=", value, "rCount");
            return (Criteria) this;
        }

        public Criteria andRCountIn(List<Integer> values) {
            addCriterion("r_count in", values, "rCount");
            return (Criteria) this;
        }

        public Criteria andRCountNotIn(List<Integer> values) {
            addCriterion("r_count not in", values, "rCount");
            return (Criteria) this;
        }

        public Criteria andRCountBetween(Integer value1, Integer value2) {
            addCriterion("r_count between", value1, value2, "rCount");
            return (Criteria) this;
        }

        public Criteria andRCountNotBetween(Integer value1, Integer value2) {
            addCriterion("r_count not between", value1, value2, "rCount");
            return (Criteria) this;
        }

        public Criteria andRDateIsNull() {
            addCriterion("r_date is null");
            return (Criteria) this;
        }

        public Criteria andRDateIsNotNull() {
            addCriterion("r_date is not null");
            return (Criteria) this;
        }

        public Criteria andRDateEqualTo(Date value) {
            addCriterionForJDBCDate("r_date =", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("r_date <>", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateGreaterThan(Date value) {
            addCriterionForJDBCDate("r_date >", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("r_date >=", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateLessThan(Date value) {
            addCriterionForJDBCDate("r_date <", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("r_date <=", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateIn(List<Date> values) {
            addCriterionForJDBCDate("r_date in", values, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("r_date not in", values, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("r_date between", value1, value2, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("r_date not between", value1, value2, "rDate");
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