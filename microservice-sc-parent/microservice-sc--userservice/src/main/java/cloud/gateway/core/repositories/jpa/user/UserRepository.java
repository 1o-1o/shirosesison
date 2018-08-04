package cloud.gateway.core.repositories.jpa.user;


import cloud.gateway.core.dao.IBaseDao;
import cloud.gateway.core.dao.IJdbcDao;
import cloud.gateway.core.models.User;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.repositories.BaseRepo;
import cloud.gateway.core.repositories.user.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserRepository implements UserRepo {
	Logger logger = LoggerFactory.getLogger(UserRepository.class);
	
	@Autowired 
	private BaseRepo<User> baseService;

	@Autowired
	private IBaseDao<User> baseDao;
	
	@Autowired
	protected IJdbcDao jdbcDao;

	@Override
	public User findUser(String userId) {
		
		try {
			User user = this.baseService.getUnique("User", new String[]{"userid","deleted"}, new String[]{userId,"0"});
						
			return user;
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}
		
		/*try {
			User user = em.find(User.class, userId);
			user.setDeparts(getDepartByUserid(userId));
			return user;
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}*/
	}
	@Override
	public User findUseByuuid(String uuid) {
		
		try {
			User user = this.baseService.getUnique("User", new String[]{"uuid"}, new String[]{uuid});
						
			return user;
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}
		
		/*try {
			User user = em.find(User.class, userId);
			user.setDeparts(getDepartByUserid(userId));
			return user;
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}*/
	}
	@Override

	public User findUserByUserName(String userDlmc) {
		
		try {
			//User user = this.baseService.getUnique("User", new String[]{"username","deleted","locked"}, new String[]{username,"0","0"});
			User user = this.baseService.getUnique("User", new String[]{"username","deleted"}, new String[]{userDlmc,"0"});
			return user;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			logger.error("", ex);
			return null;
		}
	}

	@Override
	public User findUserByName(String username) {
		try {
			//User user = this.baseService.getUnique("User", new String[]{"username","deleted","locked"}, new String[]{username,"0","0"});
			User user = this.baseService.getUnique("User", new String[]{"username"}, new String[]{username});
			return user;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			logger.error("", ex);
			return null;
		}
	}


	@Override
	public User saveUser(User user) {
		try {
			baseService.add(user);
			return user;
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			this.baseService.update(user);			
			return true;
		} catch (Exception ex) {
			logger.error("", ex);
			return false;
		}
	}
	@Override
	public List<User> getUserList(Page<User> page) throws Exception {
		List<User> list = this.baseService.getListPage("User", new String[]{}, new String[]{}, " order by createDate desc ", page);
		return list;
	}
	@Override
	public List<User> getUserByRoleId(String roleId, Page<User> page) throws Exception {
//		List<User> list = findByPage("User", new String[]{"group"}, new String[]{groupId});
		List<User> list = this.baseService.getListPage("User", new String[]{"role"}, new String[]{roleId}, page);
		return list;
	}
	
	@Override
	public void delete(String userid) throws Exception {
		
		String sql = "update sys_user set deleted=1 where user_id=:user_id ";
		Map<String, Object> paramMap = new HashMap<String, Object>();  
	    paramMap.put("user_id", userid);  
		this.jdbcDao.saveOrUpdate(sql, paramMap);
		
	}

	@Override
	public boolean deleted(String id) throws Exception {
		String sql = "delete from sys_user where  user_id=:user_id ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_id",id);
		int i = this.jdbcDao.delete(sql, paramMap);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public void deleteByuuid(String uuid) throws Exception {
		
		String sql = "update u_user set deleted=1 where uuid=:uuid ";
		Map<String, Object> paramMap = new HashMap<String, Object>();  
	    paramMap.put("uuid", uuid);  
		this.jdbcDao.saveOrUpdate(sql, paramMap);
		
	}
	@Override
	public List<User> getUserListByName(Page<User> page, String name) throws Exception {
		
		StringBuffer hql = new StringBuffer(); 
		hql.append("select a from User  a where a.nickname like '%").append(name).append("%' or a.username like '%").append(name).append("%' order by createDate desc");
		StringBuffer countsql = new StringBuffer(); 
		countsql.append("select count(*) from User  a where a.nickname like '%").append(name).append("%' or a.username like '%").append(name).append("%' order by createDate desc");
		
		//List<User> list = this.baseService.getListPageOrLike("User", new String[]{"nickname","username"}, new String[]{name,name}," order by createDate desc ", page);
		List<User> list = this.baseService.getListPageHql(hql.toString(), countsql.toString(), page);
		return list;
	}
	
	@Override
	public List<User> getUserListByPow(Page<User> page, String name) throws Exception {
		StringBuffer hql = new StringBuffer(); 
		hql.append("select a from User  a where a.usertype = '2' and a.xzdw_id like '").append(name).append("%' order by createDate desc");
		StringBuffer countsql = new StringBuffer(); 
		countsql.append("select count(*) from User  a where a.usertype = '2' and a.xzdw_id like '").append(name).append("%' order by createDate desc");
		//List<User> list = this.baseService.getListPageAndMore("User", new String[]{"xzdw_id","usertype"}, new String[]{name,"2"}," order by createDate desc ", page);
		List<User> list = this.baseService.getListPageHql(hql.toString(), countsql.toString(), page);
		return list;
	}
	
	@Override
	public List<User> getUserListByPowName(Page<User> page, String name, String xzdw) throws Exception {
		StringBuffer hql = new StringBuffer(); 
		hql.append("select a from User  a where  a.usertype = '2' and a.xzdw_id like '").append(xzdw).append("%'  and (a.nickname like '%").append(name).append("%' or a.username like '%").append(name).append("%') order by createDate desc");
		StringBuffer countsql = new StringBuffer(); 
		countsql.append("select count(*) from User  a where a.usertype = '2' and a.xzdw_id like '").append(xzdw).append("%' and  ( a.nickname like '%").append(name).append("%' or a.username like '%").append(name).append("%') order by createDate desc");
		//List<User> list = this.baseService.getListPageAndOr("User", new String[]{"xzdw_id","usertype","username","nickname"}, new String[]{xzdw,"2",name,name}," order by createDate desc ", page);
		List<User> list = this.baseService.getListPageHql(hql.toString(), countsql.toString(), page);
		return list;
	}
	@Override
	public List<User> getUserList() throws Exception {
		List<User> list = baseService.findByWhere("User", new String[]{"deleted"},new String[]{"0"});
		if(list.size()==0 || list.isEmpty()){
			logger.error("getListBeanAll"+"获取数据失败");
			return null;
		}
		logger.debug("getListBeanAll"+list);
		return list;
	}


	@Override
	public List<Object> findPage(String[] columns, String[] values,Page<User> page)throws Exception{

		List<User> list = baseService.getListPage("User", columns, values, page);
		if(list.size() == 0 || list.isEmpty()){
			return null;
		}

		List<Object> o = new ArrayList<Object>();
		o.add(list);
		return o;
	}

	@Override
	public Page<User> getListPageByHql(String hql, String counthql, Page<User> page) throws Exception {
		return baseService.getListPageByHql(hql,counthql,page);
	}

	@Override
	public List<User> getListPageByHql(String hql) throws Exception {
		return baseService.findByWhereHql(hql);
	}
}
