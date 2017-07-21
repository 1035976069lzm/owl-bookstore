package cn.net.bysoft.owl.bookstore.common.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import cn.net.bysoft.owl.bookstore.common.entity.BaseEntity;
import cn.net.bysoft.owl.bookstore.common.entity.PageBean;
import cn.net.bysoft.owl.bookstore.common.entity.PageParam;

public abstract class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T> {

    private static final String SQL_INSERT = "insert";
    private static final String SQL_UPDATE = "update";
    private static final String SQL_DELETE_BY_ID = "deleteById";
    private static final String SQL_DELETE_BY_IDS = "deleteByIds";
    private static final String SQL_FIND_BY_ID = "findById";
    private static final String SQL_FIND_BY_PARAM = "findByParam";
    private static final String SQL_LIST_BY_PARAM = "listByParam";
    private static final String SQL_LIST_BY_PAGE = "listByPageAndParam";
    private static final String SQL_COUNT_BY_PARAM = "countByParam";

    // SqlSessionTemplate实例(要求Spring中进行SqlSessionTemplate的配置)
    // 可以调用sessionTemplate完成数据库操作
    private SqlSessionTemplate sessionTemplate;

    // SqlSessionFactory实例(要求Spring中进行SqlSessionFactory的配置)
    // 可以调用sessionFactory打开一个SqlSession
    private SqlSessionFactory sessionFactory;

    public SqlSessionTemplate getSessionTemplate() {
        return this.sessionTemplate;
    }

    @Autowired
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        super.setSqlSessionTemplate(sessionTemplate);
        this.sessionTemplate = sessionTemplate;
    }

    public SqlSessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sessionFactory) {
        super.setSqlSessionFactory(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long insert(T entity) {
        // 对数据库进行insert操作。
        // 执行Mapper配置文件中的insert方法。
        int result = sessionTemplate.insert(getStatement(SQL_INSERT), entity);
        // 判断如果要新建的实体对象不为null，并且成功保存到数据库了，则返回其主键。
        if (entity != null && entity.getId() != null && result > 0) {
            return entity.getId();
        }
        return result;
    }

    @Override
    public int update(T entity) {
        // 对数据库进行update操作，并返回影响行数。
        // 执行Mapper配置文件中的update方法。
        return sessionTemplate.update(getStatement(SQL_UPDATE), entity);
    }

    @Override
    public int deleteById(long id) {
        // 对数据库进行删除操作。
        // 执行Mapper配置文件中的deleteById方法。
        return sessionTemplate.delete(getStatement(SQL_DELETE_BY_ID), id);
    }

    @Override
    public int deleteByIds(long... ids) {
        return sessionTemplate.delete(getStatement(SQL_DELETE_BY_IDS), ids);
    }

    @Override
    public T findById(long id) {
        // 对数据库进行查询操作。
        // 执行Mapper配置文件中的findById方法。
        return sessionTemplate.selectOne(getStatement(SQL_FIND_BY_ID), id);
    }

    @Override
    public T findByParam(Map<String, Object> param) {
        // 对数据库进行查询操作。
        // 执行Mapper配置文件中的findByParam方法。
        if (param == null || param.isEmpty()) {
            return null;
        }
        return sessionTemplate.selectOne(getStatement(SQL_FIND_BY_PARAM), param);
    }

    @Override
    public List<T> listByParam(Map<String, Object> param) {
        // 对数据库进行查询操作。
        // 执行Mapper配置文件中的findListByParam方法。
        return sessionTemplate.selectList(getStatement(SQL_LIST_BY_PARAM), param);
    }

    @Override
    public PageBean<T> listByPageAndParam(PageParam pageParam, Map<String, Object> param) {
        // 对数据库进行查询操作。
        // 执行Mapper配置文件中的findListByPageAndParam方法。
        HashMap<String, Object> params;
        if (param == null) {
            params = new HashMap<>();
        } else {
            params = (HashMap<String, Object>) param;
        }

        // 获取分页数据集 , 注切勿换成 sessionTemplate 对象。
        // 使用RowBounds进行分页。
        List<T> list = getSqlSession().selectList(getStatement(SQL_LIST_BY_PAGE), params,
                new RowBounds((pageParam.getPageNum() - 1) * pageParam.getNumPerPage(), pageParam.getNumPerPage()));

        // 统计总记录数
        Object countObject = (Object) getSqlSession().selectOne(getStatement(SQL_LIST_BY_PAGE),
                new ExecutorInterceptor.CountParameter(params));
        Long count = Long.valueOf(countObject.toString());

        return new PageBean<>(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
    }

    @Override
    public PageBean<T> listByPageAndParam(PageParam pageParam, Map<String, Object> param, String sqlId) {
        // 对数据库进行查询操作。
        // 执行Mapper配置文件中的自定义的方法。
        HashMap<String, Object> params;
        if (param == null) {
            params = new HashMap<>();
        } else {
            params = (HashMap<String, Object>) param;
        }

        // 获取分页数据集 , 注切勿换成 sessionTemplate 对象
        List<T> list = getSqlSession().selectList(getStatement(sqlId), params,
                new RowBounds((pageParam.getPageNum() - 1) * pageParam.getNumPerPage(), pageParam.getNumPerPage()));

        // 统计总记录数
        Object countObject = (Object) getSqlSession().selectOne(getStatement(sqlId),
                new ExecutorInterceptor.CountParameter(params));
        Long count = Long.valueOf(countObject.toString());

        return new PageBean<>(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
    }

    @Override
    public long countByParam(Map<String, Object> param) {
        // 对数据库进行查询操作。
        // 执行Mapper配置文件中的findCountByParam方法。
        return sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PARAM), param);
    }

    protected String getStatement(String sqlId) {
        String name = this.getClass().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(".").append(sqlId);
        return sb.toString();
    }

}
