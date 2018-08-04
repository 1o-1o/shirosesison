package cloud.gateway.core.repositories.jpa;


import cloud.gateway.core.dao.IBaseDao;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.pagination.PaginationThreadUtils;
import cloud.gateway.core.repositories.BaseRepo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @ClassName: BaseServiceImpl
 * @Description: BaseServiceImpl
 * @author: zml
 * @date: 2014-11-9 下午5:42:11
 *
 */
@Service
public class BaseRepository<T> implements BaseRepo<T> {
	private static final Logger logger = Logger.getLogger(BaseRepository.class);
	
    @Autowired  
    private IBaseDao<T> baseDao;
    
    
	public IBaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<T> getAllList(String tableSimpleName) throws Exception{
		StringBuffer sff = new StringBuffer();  
        sff.append("select a from ").append(tableSimpleName).append(" a ");  
        List<T> list = this.baseDao.createQuery(sff.toString());  
        if( list.size()>0 ){
      	   return list;
         }else{
      	   return Collections.emptyList();
         }
	}

	@Override
	public T getUnique(String tableSimpleName, String[] columns, String[] values) throws Exception{
		StringBuffer sb = new StringBuffer();  
        sb.append("select a from ").append(tableSimpleName).append( " a where ");  
        if(columns.length==values.length){  
            for(int i = 0; i < columns.length; i++){  
                sb.append("a.").append(columns[i]).append("='").append(values[i]).append("'");  
                if(i < columns.length-1){  
                    sb.append(" and ");  
                }  
           }  
           T entity = this.baseDao.unique(sb.toString());  
           return entity; 
        }else{  
           logger.error("columns.length != values.length");
           return null;  
        } 
	}

	@Override
	public T getUniqueBean(String hql) throws Exception {
		return this.baseDao.unique(hql);
	}

	@Override
	public List<T> findByWhere(String tableSimpleName, String[] columns,
			String[] values) throws Exception{
		StringBuffer sb = new StringBuffer();  
        sb.append("select a from ").append(tableSimpleName).append( " a where ");  
        if(columns.length==values.length){  
            for(int i = 0; i < columns.length; i++){  
                sb.append("a.").append(columns[i]).append("='").append(values[i]).append("'");  
                if(i < columns.length-1){  
                    sb.append(" and ");  
                }  
           }  
           List<T> list = this.baseDao.createQuery(sb.toString());  
//         最好用JDK提供的Collections.emptyList()来返回一个空的集合对象 而不是 null
//         Collections.EMPTY_LIST 是返回一个空集合对象，emptyList()是对EMPTY_LIST做了一个泛型支持，具体看源码
//         Collections.EMPTY_LIST的返回值是一个不可变的空List，不能进行例如add的各种操作！
           if( list.size()>0 ){
        	   return list;
           }else{
        	   return Collections.emptyList();
           }
        }else{  
        	return Collections.emptyList();  
        } 
	}
	@Override
	public List<T> findByWhereHql(String hql) throws Exception{
		 List<T> list = this.baseDao.createQuery(hql);  
         if( list.size()>0 ){
      	   return list;
         }else{
      	   return Collections.emptyList();
         }
	}
	@Override
	public List<T> getCount(String tableSimpleName) throws Exception{
    	String hql = "select count(*) from " + tableSimpleName;
    	List<T> list = this.baseDao.createQuery(hql);
    	return list;
	}
	@Override
	public Integer getCountAll(String tableSimpleName) throws Exception{
		String hql = "select count(*) from " + tableSimpleName;
    	Integer c = Integer.valueOf(this.baseDao.unique(hql).toString());
    	return c;
	}
	@Override
	public Integer getCountWhere(String sql) throws Exception{
    	String hql = "select count(*) from ( " + sql +" ) ";
    	Integer c = Integer.valueOf(this.baseDao.unique(hql).toString());
    	return c;
	}
	@Override
	public Integer getCountWhere(String tableSimpleName, String[] columns,
			String[] values) throws Exception{
		StringBuffer sb = new StringBuffer();  
        sb.append("select a from ").append(tableSimpleName).append( " a where ");  
        if(columns.length==values.length){  
            for(int i = 0; i < columns.length; i++){  
                sb.append(" a.").append(columns[i]).append("  ='").append(values[i]).append("'");
                if(i < columns.length-1){  
                    sb.append(" and ");  
                }  
           }
           Integer count = getCountWhere(sb.toString());
           return count;
        }else{  
        	return 0; 
        } 
	}
	
	public Integer getCountWhereOrLike(String tableSimpleName, String[] columns,
			String[] values) throws Exception{
		StringBuffer sb = new StringBuffer();  
        sb.append("select count(*) from ").append(tableSimpleName).append( " a where ");  
        if(columns.length==values.length){  
            for(int i = 0; i < columns.length; i++){  
                sb.append("a.").append(columns[i]).append(" like '%").append(values[i]).append("%'");  
                if(i < columns.length-1){  
                    sb.append(" or ");  
                }  
           }  
           Integer count = Integer.valueOf(this.baseDao.unique(sb.toString()).toString());
           return count;
        }else{  
        	return 0; 
        } 
	}
	
	public Integer getCountWhereAndMore(String tableSimpleName, String[] columns,
			String[] values) throws Exception{
		StringBuffer sb = new StringBuffer();  
		sb.append("select count(*) from  ").append(tableSimpleName).append( " a where ");  
        if(columns.length==values.length){  
        	 for(int i = 0; i < columns.length; i++){  
                 sb.append("a.").append(columns[i]).append(" = '").append(values[i]).append("'");  
                 if(i < columns.length-1){  
                     sb.append(" and ");  
                 }  
             } 
     
           Integer count = Integer.valueOf(this.baseDao.unique(sb.toString()).toString());
           return count;
        }else{  
        	return 0; 
        } 
	}
	public Integer getCountWhereAndOr(String tableSimpleName, String[] columns,
			String[] values) throws Exception{
		StringBuffer sb = new StringBuffer();  
		sb.append("select count(*) from  ").append(tableSimpleName).append( " a where ")
		  .append(columns[0]).append(" = '").append(values[0]).append("' and ")
	      .append(columns[1]).append(" = '").append(values[1]).append("' ")
	      .append(" AND ("); 
        if(columns.length==values.length){  
        	  for(int i = 2; i < columns.length; i++){  
                  sb.append("a.").append(columns[i]).append(" like '%").append(values[i]).append("%'");  
                  if(i < columns.length-1){  
                      sb.append(" or ");  
                  }  
              } 
              sb.append(" )");
           Integer count = Integer.valueOf(this.baseDao.unique(sb.toString()).toString());
           return count;
        }else{  
        	return 0; 
        } 
	}
	@Override
	public void add(T bean) throws Exception{
		this.baseDao.add(bean);
	}

	@Override
	public void saveOrUpdate(T bean) throws Exception{
		this.baseDao.saveOrUpdate(bean);
	}

	@Override
	public void delete(T bean) throws Exception{
		this.baseDao.delete(bean);
	}

	@Override
	public void update(T bean) throws Exception{
		this.baseDao.update(bean);
	}

	@Override
	public T getBean(Class<T> obj, Serializable id) throws Exception{
		return this.baseDao.getBean(obj, id);
	}

	@Override
	public List<T> findByPage(String tableSimpleName, String[] columns, String[] values) throws Exception{
		Integer totalSum = 0;
		List<T> list = new ArrayList<T>();
		Integer count=0;
		if(columns.length <= 0 && values.length <= 0){
			count = this.getCountAll(tableSimpleName);
		}else{
			count = this.getCountWhere(tableSimpleName, columns, values);
		}		
		totalSum = count;
		int[] pageParams = PaginationThreadUtils.setPage(totalSum);
		
		StringBuffer sb = new StringBuffer();  
        sb.append("select a from ").append(tableSimpleName).append( " a where ");  
        if(columns.length==values.length){  
            for(int i = 0; i < columns.length; i++){  
                sb.append("a.").append(columns[i]).append("='").append(values[i]).append("'");  
                if(i < columns.length-1){  
                    sb.append(" and ");  
                }  
           } 
	       String hql = sb.toString();
	       if(hql.endsWith("where ")){
	    	   hql = hql.substring(0, hql.length()-6);
	       }
	       logger.info("findByPage: HQL: "+hql);
	       list = this.baseDao.findByPage(hql, pageParams[0], pageParams[1]); 
	       if( list.size()>0 ){
        	   return list;
           }else{
        	   return Collections.emptyList();
           }
        }else{
        	logger.info("findByPage: columns.length != values.length");
        	return Collections.emptyList();
        }
	}

	@Override
	public List<T> getListPage(String tableSimpleName, String[] columns,
			String[] values, Page<T> page) throws Exception {
		Integer totalSum = 0;
		List<T> list = new ArrayList<T>();
		Integer count=0;
		if(columns.length <= 0 && values.length <= 0){
			count = this.getCountAll(tableSimpleName);
		}else{
			count = this.getCountWhere(tableSimpleName, columns, values);
		}		
		totalSum = count;
		int[] pageParams = page.getPageParams(totalSum);
		
		StringBuffer sb = new StringBuffer();  
        sb.append("select a from ").append(tableSimpleName).append( " a where ");  
        if(columns.length==values.length){  
            for(int i = 0; i < columns.length; i++){  
                sb.append("a.").append(columns[i]).append("='").append(values[i]).append("'");  
                if(i < columns.length-1){  
                    sb.append(" and ");  
                }  
            } 
	        String hql = sb.toString();
	        if(hql.endsWith("where ")){
	    	    hql = hql.substring(0, hql.length()-6);
	        }
	        logger.info("findByPage: HQL: "+hql);
	        list = this.baseDao.findByPage(hql, pageParams[0], pageParams[1]); 
	        if( list.size()>0 ){
	        	page.setResult(list);
        	    return list;
            }else{
        	    return Collections.emptyList();
            }
        }else{
        	logger.info("findByPage: columns.length != values.length");
        	return Collections.emptyList();
        }
	}
	@Override
	public List<T> getListPageOrLike(String tableSimpleName, String[] columns,
			String[] values, String orderby,Page<T> page) throws Exception {
		Integer totalSum = 0;
		List<T> list = new ArrayList<T>();
		Integer count=0;
		if(columns.length <= 0 && values.length <= 0){
			count = this.getCountAll(tableSimpleName);
		}else{
			count = this.getCountWhereOrLike(tableSimpleName, columns, values);
		}		
		totalSum = count;
		int[] pageParams = page.getPageParams(totalSum);
		
		StringBuffer sb = new StringBuffer();  
        sb.append("select a from ").append(tableSimpleName).append( " a where ");  
        if(columns.length==values.length){  
            for(int i = 0; i < columns.length; i++){  
                sb.append("a.").append(columns[i]).append(" like '%").append(values[i]).append("%'");  
                if(i < columns.length-1){  
                    sb.append(" or ");  
                }  
            } 
	        String hql = sb.toString();
	        if(hql.endsWith("where ")){
	    	    hql = hql.substring(0, hql.length()-6);
	        }
	        logger.info("findByPage: HQL: "+hql);
	        list = this.baseDao.findByPage(hql, pageParams[0], pageParams[1]); 
	        if( list.size()>0 ){
	        	page.setResult(list);
        	    return list;
            }else{
        	    return Collections.emptyList();
            }
        }else{
        	logger.info("findByPage: columns.length != values.length");
        	return Collections.emptyList();
        }
	}
	@Override
	public List<T> getListPageAndMore(String tableSimpleName, String[] columns, 
			String[] values, String orderby,Page<T> page)throws Exception {
		Integer totalSum = 0;
		List<T> list = new ArrayList<T>();
		Integer count=0;
		if(columns.length <= 0 && values.length <= 0){
			count = this.getCountAll(tableSimpleName);
		}else{
			count = this.getCountWhereAndMore(tableSimpleName, columns, values);
		}		
		totalSum = count;
		int[] pageParams = page.getPageParams(totalSum);
		
		StringBuffer sb = new StringBuffer();  
        sb.append("select a from ").append(tableSimpleName).append( " a where ");  
        if(columns.length==values.length){  
            for(int i = 0; i < columns.length; i++){  
                sb.append("a.").append(columns[i]).append(" = '").append(values[i]).append("'");  
                if(i < columns.length-1){  
                    sb.append(" and ");  
                }  
            } 
	        String hql = sb.toString();
	        if(hql.endsWith("where ")){
	    	    hql = hql.substring(0, hql.length()-6);
	        }
	        logger.info("findByPage: HQL: "+hql);
	        list = this.baseDao.findByPage(hql, pageParams[0], pageParams[1]); 
	        if( list.size()>0 ){
	        	page.setResult(list);
        	    return list;
            }else{
        	    return Collections.emptyList();
            }
        }else{
        	logger.info("findByPage: columns.length != values.length");
        	return Collections.emptyList();
        }
	}
	@Override
	public List<T> getListPageHql(String hql,String countsql ,Page<T> page)throws Exception {
		
		Integer totalSum =  Integer.valueOf(this.baseDao.unique(countsql).toString());

		List<T> list = new ArrayList<T>();
		
		int[] pageParams = page.getPageParams(totalSum);
		
		list = this.baseDao.findByPage(hql, pageParams[0], pageParams[1]); 
        if( list.size()>0 ){
        	page.setResult(list);
    	    return list;
        }else{
    	    return Collections.emptyList();
        }
       
	}
	@Override
	public List<T> getListPageAndOr(String tableSimpleName, String[] columns, 
			String[] values, String orderby,Page<T> page)throws Exception {
		Integer totalSum = 0;
		List<T> list = new ArrayList<T>();
		Integer count=0;
		if(columns.length <= 0 && values.length <= 0){
			count = this.getCountAll(tableSimpleName);
		}else{
			count = this.getCountWhereAndOr(tableSimpleName, columns, values);
		}		
		totalSum = count;
		int[] pageParams = page.getPageParams(totalSum);
		
		StringBuffer sb = new StringBuffer();  
		 sb.append("select a from  ").append(tableSimpleName)
	        .append( " a where ").append(columns[0]).append(" = '").append(values[0]).append("' and ")
	        .append(columns[1]).append(" = '").append(values[1]).append("' ")
	        .append(" AND (");  
        if(columns.length==values.length){  
            for(int i = 2; i < columns.length; i++){  
                sb.append("a.").append(columns[i]).append(" like '%").append(values[i]).append("%'");  
                if(i < columns.length-1){  
                    sb.append(" or ");  
                }  
            } 
            sb.append(" )");
	        String hql = sb.toString();
	        if(hql.endsWith("where ")){
	    	    hql = hql.substring(0, hql.length()-6);
	        }
	        logger.info("findByPage: HQL: "+hql);
	        list = this.baseDao.findByPage(hql, pageParams[0], pageParams[1]); 
	        if( list.size()>0 ){
	        	page.setResult(list);
        	    return list;
            }else{
        	    return Collections.emptyList();
            }
        }else{
        	logger.info("findByPage: columns.length != values.length");
        	return Collections.emptyList();
        }
	}
	@Override
	public List<T> getListPage(String tableSimpleName, String[] columns,
			String[] values, String orderby, Page<T> page) throws Exception {
		Integer totalSum = 0;
		List<T> list = new ArrayList<T>();
		Integer count=0;
		if(columns.length <= 0 && values.length <= 0){
			count = this.getCountAll(tableSimpleName);
		}else{
			count = this.getCountWhere(tableSimpleName, columns, values);
		}		
		totalSum = count;
		//if(!BeanUtils.isBlank(list)){
		//}
		int[] pageParams = page.getPageParams(totalSum);
		
		StringBuffer sb = new StringBuffer();  
        sb.append("select a from ").append(tableSimpleName).append( " a where a.deleted!=1");
        if(columns.length==values.length){  
            for(int i = 0; i < columns.length; i++){  
                sb.append("and a.").append(columns[i]).append("='").append(values[i]).append("'");
                if(i < columns.length-1){  
                    sb.append(" and ");  
                }  
            } 
	        String hql = sb.toString();
	        if(hql.endsWith("where ")){
	    	    hql = hql.substring(0, hql.length()-6);
	        }
	        logger.info("findByPage: HQL: "+hql);
	        hql = hql + " "+ orderby;
	        list = this.baseDao.findByPage(hql, pageParams[0], pageParams[1]); 
	        if( list.size()>0 ){
	        	page.setResult(list);
        	    return list;
            }else{
        	    return Collections.emptyList();
            }
        }else{
        	logger.info("findByPage: columns.length != values.length");
        	return Collections.emptyList();
        }
	}
	
	@Override
	public List<T> findBy(String tableSimpleName, Integer site_id) throws Exception {
		StringBuffer sff = new StringBuffer();  
        sff.append("select a from ").append(tableSimpleName).append(" a where site_id =").append(site_id.toString());  
        List<T> list = this.baseDao.createQuery(sff.toString());  
        if( list.size()>0 ){
      	   return list;
         }else{
      	   return Collections.emptyList();
         }
	}

	@Override
	public Integer getCountByWhere(String tableSimpleName,Integer num) throws Exception {
		String hql = "select count(*) from " + tableSimpleName+" where deleted="+num;
    	Integer c = Integer.valueOf(this.baseDao.unique(hql).toString());
    	return c;
	}

	/*@Override
	public List<T> findLinkageById(String tableSimpleName,Integer id) throws Exception {
		String hql="select * from "+tableSimpleName+" start with id="+id+" connect by prior id=parent_Id";
        List<T> list = this.baseDao.createSqlQuery(hql);
        if(list.size()==0 || list.isEmpty()){
        	return null;
        }
		return list;
	}*/

	/**
	 * 新查询，将sql的拼写逻辑放到上一层，通用，与本类中的getListPageHql方法，
	 * 不同的地方就是统计数量的方法不同，这个统一都是hql
	 * @param hql
	 * @param countHql
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<T> getListPageByHql(String hql, String countHql, Page<T> page) throws Exception {

		Integer totalSum =  Integer.valueOf(this.baseDao.count(countHql).toString());

		List<T> list = new ArrayList<T>();

		int[] pageParams = page.getPageParams(totalSum);

		list = this.baseDao.findByPage(hql, pageParams[0], pageParams[1]);
		if( list.size()>0 ){
			page.setResult(list);

		}
		return page;
	}

	@Override
	public List<T> getPage(String tableSimpleName, String[] columns,
							   String[] values, String orderby, Page<T> page) throws Exception {
		Integer totalSum = 0;
		List<T> list = new ArrayList<T>();
		Integer count=0;
		if(columns.length <= 0 && values.length <= 0){
			count = this.getCountAll(tableSimpleName);
		}else{
			count = this.getCountWhere(tableSimpleName, columns, values);
		}
		totalSum = count;
		//if(!BeanUtils.isBlank(list)){
		//}
		int[] pageParams = page.getPageParams(totalSum);

		StringBuffer sb = new StringBuffer();
		sb.append("select a from ").append(tableSimpleName).append( " a where ");
		if(columns.length==values.length){
			for(int i = 0; i < columns.length; i++){
				sb.append("  a.").append(columns[i]).append("='").append(values[i]).append("'");
				if(i < columns.length-1){
					sb.append(" and ");
				}
			}
			String hql = sb.toString();
			if(hql.endsWith("where ")){
				hql = hql.substring(0, hql.length()-6);
			}
			logger.info("findByPage: HQL: "+hql);
			hql = hql + " "+ orderby;
			list = this.baseDao.findByPage(hql, pageParams[0], pageParams[1]);
			if( list.size()>0 ){
				page.setResult(list);
				return list;
			}else{
				return Collections.emptyList();
			}
		}else{
			logger.info("findByPage: columns.length != values.length");
			return Collections.emptyList();
		}
	}

	@Override
	public Integer updateByWhere(String hql) throws Exception {
		return baseDao.updateByWhere(hql);
	}

	@Override
	public Integer countHql (String countHql) throws Exception{
		Integer totalSum =  Integer.valueOf(this.baseDao.count(countHql).toString());
		return totalSum;
	}

}
