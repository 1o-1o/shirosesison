package cloud.gateway.base;



import cloud.gateway.core.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/6.
 */
public interface BaseService<T> {

    public void add(T bean) throws Exception;

    public void saveOrUpdate(T bean) throws Exception;

    public void delete(T bean) throws Exception;

    /**
     * 修改对象
     * @param bean
     * @throws Exception
     */
    public void update(T bean) throws Exception;

    /**
     * 根据id返回对象
     * @param id
     * @param id
     * @return
     * @throws Exception
     */
    T getById(String id)throws Exception;

    /**
     * 根据sql分页条件返回查询结果
     * @param obj
     * @param page
     * @return
     * @throws Exception
     */
    Page<T> getListByPage(T obj, Page<T> page, String orderBySql)throws Exception;

    List<T> getListByHql(T obj, String orderBySql) throws Exception;

    public List<Map<String,Object>> findAllBySql(T obj, Map<String, Object> paramMap);
}
