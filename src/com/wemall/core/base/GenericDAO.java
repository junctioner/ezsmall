package com.wemall.core.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wemall.core.dao.IGenericDAO;

public class GenericDAO<T> implements IGenericDAO<T> {
    protected Class<T> entityClass;

    @Autowired
    @Qualifier("genericEntityDao")
    private GenericEntityDao geDao;

    public Class<T> getEntityClass() {
        return this.entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public GenericEntityDao getGeDao() {
        return this.geDao;
    }

    public void setGeDao(GenericEntityDao geDao) {
        this.geDao = geDao;
    }

    public GenericDAO() {
        this.entityClass = ((Class) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]);
    }

    public GenericDAO(Class<T> type) {
        this.entityClass = type;
    }

    public int batchUpdate(String jpql, Object[] params) {
        return getGeDao().batchUpdate(jpql, params);
    }

    public List<T> executeNamedQuery(String queryName, Object[] params, int begin, int max) {
        return getGeDao().executeNamedQuery(queryName, params, begin, max);
    }

    public List<T> executeNativeNamedQuery(String nnq) {
        return getGeDao().executeNativeNamedQuery(nnq);
    }

    public List<T> executeNativeQuery(String nnq, Object[] params, int begin, int max) {
        return getGeDao().executeNativeQuery(nnq, params, begin, max);
    }

    public int executeNativeSQL(String nnq) {
        return getGeDao().executeNativeSQL(nnq);
    }

    public List find(String query, Map params, int begin, int max) {
        return getGeDao().find(this.entityClass, query, params, begin, max);
    }

    public void flush() {
        getGeDao().flush();
    }

    public T get(Serializable id) {
        return (T) getGeDao().get(this.entityClass, id);// .get(this.entityClass,
                                                        // id);
    }

    public T getBy(String propertyName, Object value) {
        return (T) getGeDao().getBy(this.entityClass, propertyName, value);
    }

    public List<T> query(String query, Map params, int begin, int max) {
        return getGeDao().query(query, params, begin, max);
    }

    public void remove(Serializable id) {
        getGeDao().remove(this.entityClass, id);
    }

    public void save(Object newInstance) {
        getGeDao().save(newInstance);
    }

    public void update(Object transientObject) {
        getGeDao().update(transientObject);
    }
}