package cloud.gateway.core.repositories.base;

import cloud.gateway.core.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/6.
 */
public interface BaseDaoRepo<T> {
    public void add(T bean) throws Exception ;

    public void saveOrUpdate(T bean) throws Exception;

    public void delete(T bean) throws Exception;

    public void update(T bean) throws Exception;

    public List<Map<String,Object>> findAllBySql(String sql, Map<String, Object> paramMap) throws Exception;

    public boolean deleteSql(String sql) throws Exception;

    public void updateSql(String sql, Map<String, Object> paramMap) throws Exception;
    /**
     *
     * @param tableEntityName  表对应的实体类名称
     * @param fieldsName 查询的字段对应实体类中的属性名称数组
     * @param values  对应属性的值数组
     * @return
     */
    public T getByArgs(String tableEntityName, String[] fieldsName, String[] values);

    /**
     * 分页查询，传入的page对象以new Page<T>(page,rows)形式传入
     * @param hql
     * @param counthql
     * @param page
     * @return
     * @throws Exception
     */
    public Page<T> getListPageByHql(String hql, String counthql, Page<T> page) throws Exception;

    public List<T> getListByHql(String hql) throws Exception;

}
