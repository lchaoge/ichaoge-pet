package com.ichaoge.pet.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhotoAlbumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PhotoAlbumExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPetIdIsNull() {
            addCriterion("pet_id is null");
            return (Criteria) this;
        }

        public Criteria andPetIdIsNotNull() {
            addCriterion("pet_id is not null");
            return (Criteria) this;
        }

        public Criteria andPetIdEqualTo(Long value) {
            addCriterion("pet_id =", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotEqualTo(Long value) {
            addCriterion("pet_id <>", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdGreaterThan(Long value) {
            addCriterion("pet_id >", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pet_id >=", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdLessThan(Long value) {
            addCriterion("pet_id <", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdLessThanOrEqualTo(Long value) {
            addCriterion("pet_id <=", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdIn(List<Long> values) {
            addCriterion("pet_id in", values, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotIn(List<Long> values) {
            addCriterion("pet_id not in", values, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdBetween(Long value1, Long value2) {
            addCriterion("pet_id between", value1, value2, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotBetween(Long value1, Long value2) {
            addCriterion("pet_id not between", value1, value2, "petId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andRecordDateIsNull() {
            addCriterion("record_date is null");
            return (Criteria) this;
        }

        public Criteria andRecordDateIsNotNull() {
            addCriterion("record_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecordDateEqualTo(Date value) {
            addCriterion("record_date =", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotEqualTo(Date value) {
            addCriterion("record_date <>", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThan(Date value) {
            addCriterion("record_date >", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateGreaterThanOrEqualTo(Date value) {
            addCriterion("record_date >=", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThan(Date value) {
            addCriterion("record_date <", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateLessThanOrEqualTo(Date value) {
            addCriterion("record_date <=", value, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateIn(List<Date> values) {
            addCriterion("record_date in", values, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotIn(List<Date> values) {
            addCriterion("record_date not in", values, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateBetween(Date value1, Date value2) {
            addCriterion("record_date between", value1, value2, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecordDateNotBetween(Date value1, Date value2) {
            addCriterion("record_date not between", value1, value2, "recordDate");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNull() {
            addCriterion("recommend is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNotNull() {
            addCriterion("recommend is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendEqualTo(Integer value) {
            addCriterion("recommend =", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotEqualTo(Integer value) {
            addCriterion("recommend <>", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThan(Integer value) {
            addCriterion("recommend >", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend >=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThan(Integer value) {
            addCriterion("recommend <", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThanOrEqualTo(Integer value) {
            addCriterion("recommend <=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendIn(List<Integer> values) {
            addCriterion("recommend in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotIn(List<Integer> values) {
            addCriterion("recommend not in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendBetween(Integer value1, Integer value2) {
            addCriterion("recommend between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend not between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNull() {
            addCriterion("modified is null");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNotNull() {
            addCriterion("modified is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedEqualTo(Date value) {
            addCriterion("modified =", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotEqualTo(Date value) {
            addCriterion("modified <>", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThan(Date value) {
            addCriterion("modified >", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("modified >=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThan(Date value) {
            addCriterion("modified <", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThanOrEqualTo(Date value) {
            addCriterion("modified <=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedIn(List<Date> values) {
            addCriterion("modified in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotIn(List<Date> values) {
            addCriterion("modified not in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedBetween(Date value1, Date value2) {
            addCriterion("modified between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotBetween(Date value1, Date value2) {
            addCriterion("modified not between", value1, value2, "modified");
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