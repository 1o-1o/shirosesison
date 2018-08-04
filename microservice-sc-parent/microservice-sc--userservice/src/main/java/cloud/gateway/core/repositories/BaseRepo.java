package cloud.gateway.core.repositories;


import cloud.gateway.core.pagination.Page;

import java.io.Serializable;
import java.util.List;


/**
 * @ClassName: IBaseService
 * @Description:IBaseService
 * @author: zml
 * @date: 2014-11-9 下午5:37:16
 *
 */
public interface BaseRepo<T> {

	 public List<T> getAllList(String tableSimpleName) throws Exception;
	 
	 public T getUnique(String tableSimpleName, String[] columns, String[] values) throws Exception;
	 T getUniqueBean(String hql) throws Exception;
	 public List<T> findByWhere(String tableSimpleName, String[] columns, String[] values) throws Exception;

	 public List<T> getCount(String tableSimpleName) throws Exception;

	 public void add(T bean) throws Exception;

	 public void saveOrUpdate(T bean) throws Exception;

	 public void delete(T bean) throws Exception;

	 public void update(T bean) throws Exception;

	 public T getBean(final Class<T> obj, final Serializable id) throws Exception;

	 public List<T> findByPage(String tableSimpleName, String[] columns, String[] values) throws Exception;

	 public List<T> getListPage(String tableSimpleName, String[] columns, String[] values, Page<T> page) throws Exception;

	 public List<T> getListPage(String tableSimpleName, String[] columns, String[] values, String orderby, Page<T> page) throws Exception;

	Integer getCountWhere(String sql) throws Exception;

	Integer getCountWhere(String tableSimpleName, String[] columns, String[] values) throws Exception;

	Integer getCountAll(String tableSimpleName) throws Exception;
	
	Integer getCountByWhere(String tableSimpleName, Integer num)throws Exception;

	public List<T> findBy(String tableSimpleName, Integer site_id)throws Exception;

	List<T> getListPageOrLike(String tableSimpleName, String[] columns, String[] values, String orderby, Page<T> page) throws Exception;

	List<T> getListPageAndMore(String tableSimpleName, String[] columns, String[] values, String orderby, Page<T> page)throws Exception;

	List<T> getListPageAndOr(String tableSimpleName, String[] columns, String[] values, String orderby, Page<T> page)throws Exception;

	List<T> getListPageHql(String hql, String countsql, Page<T> page)throws Exception;

	List<T> findByWhereHql(String hql) throws Exception;

	public Page<T> getListPageByHql(String hql, String countHql, Page<T> page)throws Exception;

	public List<T> getPage(String tableSimpleName, String[] columns, String[] values, String orderby, Page<T> page) throws Exception;



	Integer updateByWhere(String hql) throws Exception;

	Integer countHql (String countHql) throws Exception;
}
