package cloud.gateway.core.dao.impl;


import cloud.gateway.core.dao.IBaseDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Repository
public class BaseDaoImpl<T> implements IBaseDao<T> {
	
	@PersistenceContext
	private EntityManager em;
	
	//Session session = em.unwrap(org.hibernate.Session.class);
	
	public Session getSession() {
	    //事务必须是开启的(Required)，否则获取不到
	    return em.unwrap(Session.class);
	}
	
	@Override 
	public void add(T bean) throws Exception{
		this.getSession().save(bean) ;
	}
	
	@Override
	public void saveOrUpdate(T bean) throws Exception{
		this.getSession().saveOrUpdate(bean);
	}
	
	@Override
	public void delete(T bean) throws Exception{
		this.getSession().delete(bean);
	}
	
	@Override
	public void update(T bean) throws Exception{
		this.getSession().update(bean);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> createQuery(String queryString) throws Exception{
		//List<Object> o =  this.getSession().createQuery(queryString).list();
		List<T> list = this.getSession().createQuery(queryString).list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T getBean(Class<T> obj, Serializable id) throws Exception{
		return (T) getSession().get(obj.getClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByPage(String hql, int firstResult, int maxResult) throws Exception{
		Session session=getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T unique(String hql) throws Exception{
		Query query = getSession().createQuery(hql);
	    return (T) query.uniqueResult();
	}

	@Override
	public Long count(String hql) {
		return (Long) this.getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public Integer countBySql(String sql) {
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sql).addScalar("count(*)", StandardBasicTypes.INTEGER);
		Integer i =(Integer) sqlQuery.uniqueResult();
		return i;
	}

	@Override
	public List<T> findStartWith(String sql)  {
		List<T> list = null;
		return list;
	}
	@Override
	public Integer findCountBySql(String sql) {
		SQLQuery query =  getSession().createSQLQuery(sql);
		BigDecimal id= (BigDecimal) query.uniqueResult();
		int value = id.intValue();
		return value;
	}

	@Override
	public List findBySql(String sql) {
		List<T> list = null;
		return list;
	}
	@Override
	public List find(String sql) {
		List<T> list = null;
		return list;
	}

	@Override
	public Integer updateByWhere(String hql) {
		Query query = getSession().createQuery(hql);

		return query.executeUpdate();
	}
}
