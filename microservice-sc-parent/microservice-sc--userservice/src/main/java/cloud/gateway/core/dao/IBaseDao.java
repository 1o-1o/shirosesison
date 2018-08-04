package cloud.gateway.core.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
	/**
	 * 
	 * @Title: save
	 * @Description: 保存实体
	 * @param: @param bean
	 * @param: @return   
	 * @return: Serializable   
	 * @throws
	 */
	public void add(T bean) throws Exception;

	/**
	 * 
	 * @Title: saveOrUpdate
	 * @Description: 保存或者更新实体
	 * @param: @param bean   
	 * @return: void   
	 * @throws
	 */
	public void saveOrUpdate(T bean) throws Exception;


	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param: @param clazz
	 * @param: @param id   
	 * @return: void   
	 * @throws
	 */
	public void delete(T bean) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description: 更新实体
	 * @param: @param bean   
	 * @return: void   
	 * @throws
	 */
	public void update(T bean) throws Exception;
	
	/**
	 * 
	 * @Title: update
	 * @Description: 执行HQL
	 * @param: @param queryString   
	 * @return: List<T>   
	 * @throws
	 */
	public List<T> createQuery(final String hql) throws Exception;
	
	/**
	 * 
	 * @Title: getBean
	 * @Description: 根据ID获取实体
	 * @param: @param obj
	 * @param: @param id
	 * @param: @return   
	 * @return: T   
	 * @throws
	 */
	public T getBean(final Class<T> obj, final Serializable id) throws Exception;

	/**
	 * 
	 * @Title: findByPage
	 * @Description: 分页-无条件
	 * @param: @param hql
	 * @param: @param values
	 * @param: @return   
	 * @return: List<T>   
	 * @throws
	 */
	public List<T> findByPage(final String hql, int firstResult, int maxResult) throws Exception;
	
	/**
	 * 
	 * @Title: unique
	 * @Description: 返回唯一一条数据
	 * @param: @return   
	 * @return: T   
	 * @throws
	 */
	public T unique(final String hql) throws Exception;
	
	/**
	 * 
	 * @param hql
	 * @return
	 */
	public Long count(String hql);

	/**
	 * sql查询记录数
	 * @param sql
	 * @return
	 * @throws Exception
     */
	public Integer countBySql(String sql);
	/**
	 * sql查询start with
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<T> findStartWith(String sql);

	/**
	 * 通用sql计算
	 * @param sql
	 * @return
     */
	Integer findCountBySql(String sql);
	/**
	 * 通用sql查询数据
	 * @param sql
	 * @return
	 */
	List findBySql(String sql);
	public List find(String sql);


	Integer updateByWhere(String hql);

}
