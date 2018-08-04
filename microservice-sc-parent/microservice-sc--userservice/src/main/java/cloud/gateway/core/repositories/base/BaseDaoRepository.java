package cloud.gateway.core.repositories.base;

import cloud.gateway.core.dao.IJdbcDao;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.repositories.BaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/7.
 */
@Transactional //这里的事务注解不能去掉，去掉之后在调接口的时候会报No Transactional EntityManager available
public abstract class BaseDaoRepository<T> implements BaseDaoRepo<T> {

    @Autowired
    public BaseRepo<T> baseService;

    @Autowired
    public IJdbcDao jdbcDao;

    @Override
    public void add(T bean) throws Exception {
        baseService.add(bean);
    }
    @Override
    public void saveOrUpdate(T bean) throws Exception {
        baseService.saveOrUpdate(bean);
    }
    @Override
    public void delete(T bean) throws Exception {
        baseService.update(bean); //删除前首先更新一下
        baseService.delete(bean);
    }
    @Override
    public void update(T bean) throws Exception {
        baseService.update(bean);
    }

    /**
     *
     * @param tableEntityName  表对应的实体类名称
     * @param fieldsName 查询的字段对应实体类中的属性名称数组
     * @param values  对应属性的值数组
     * @return
     */
    @Override
    public T getByArgs(String tableEntityName,String[] fieldsName,String[] values){
        try {
            T zation = this.baseService.getUnique(tableEntityName, fieldsName, values);
            return zation;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 分页查询，传入的page对象以new Page<T>(page,rows)形式传入
     * @param hql
     * @param counthql
     * @param page
     * @return
     * @throws Exception
     */
    @Override
    public Page<T> getListPageByHql(String hql, String counthql, Page<T> page) throws Exception {
        return baseService.getListPageByHql(hql,counthql,page);
    }

    @Override
    public List<T> getListByHql(String hql) throws Exception{
        return baseService.findByWhereHql(hql);
    }

    @Override
    public List<Map<String,Object>> findAllBySql(String sql,Map<String,Object> paramMap) throws Exception{
        return jdbcDao.findAll(sql,paramMap);
    }
    @Override
    public boolean deleteSql(String sql) throws Exception{
        try{
            int execute = jdbcDao.delete(sql,new HashMap<>());
            System.out.println(execute);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }
    @Override
    public void updateSql(String sql,Map<String, Object> paramMap) throws Exception{
        this.jdbcDao.saveOrUpdate(sql, paramMap);
    }
}
