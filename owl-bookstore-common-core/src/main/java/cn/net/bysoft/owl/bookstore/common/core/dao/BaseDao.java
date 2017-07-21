package cn.net.bysoft.owl.bookstore.common.core.dao;

import java.util.List;
import java.util.Map;

import cn.net.bysoft.owl.bookstore.common.entity.BaseEntity;
import cn.net.bysoft.owl.bookstore.common.entity.PageBean;
import cn.net.bysoft.owl.bookstore.common.entity.PageParam;

public interface BaseDao<T extends BaseEntity> {

    long insert(T entity);

    int update(T entity);

    int deleteById(long id);

    int deleteByIds(long... id);

    T findById(long id);

    T findByParam(Map<String, Object> paramMap);

    List<T> listByParam(Map<String, Object> paramMap);

    PageBean<T> listByPageAndParam(PageParam pageParam, Map<String, Object> paramMap);

    PageBean<T> listByPageAndParam(PageParam pageParam, Map<String, Object> paramMap, String sqlId);

    long countByParam(Map<String, Object> paramMap);

}
