package cloud.gateway.core.repositories.jpa;


import cloud.gateway.core.dao.IJdbcDao;
import cloud.gateway.core.models.UserRole;
import cloud.gateway.core.repositories.BaseRepo;
import cloud.gateway.core.repositories.UserRoleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserRoleRepository implements UserRoleRepo {
	Logger logger = LoggerFactory.getLogger(UserRoleRepository.class);
	@Autowired 
	private BaseRepo<UserRole> baseService;
	
	@Autowired
	protected IJdbcDao jdbcDao;
	
	@Override
	public List<UserRole> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UserRole> findByType(String type) throws Exception {
		List<UserRole> list = this.baseService.findByWhere("UserRole", new String[]{"userId","siteId"}, new String[]{type,"4"});
		return list;
	}
	@Override
	public void doSave(UserRole userRole) throws Exception {
		this.baseService.add(userRole);	
	}
	@Override
	public void doUpdate(UserRole userRole) throws Exception {
		this.baseService.update(userRole);
		
	}
	@Override
	public void doDelete(Long id) throws Exception {
		String sql = "delete from U_USER_ROLE where u_r_id=:id ";
		Map<String, Object> paramMap = new HashMap<String, Object>();  
	    paramMap.put("id", id); 
		this.jdbcDao.delete(sql, paramMap);	
	}
	@Override
	public void doDeleteByUserid(String  userid) throws Exception {
		String sql = "delete from U_USER_ROLE where user_id=:user_id ";
		Map<String, Object> paramMap = new HashMap<String, Object>();  
	    paramMap.put("user_id", userid); 
		this.jdbcDao.delete(sql, paramMap);	
	}
	@Override
	public UserRole findById(Long id) throws Exception {
		try {
			UserRole userRole = this.baseService.getUnique("UserRole", new String[]{"id"}, new String[]{id+""});
	            return userRole;
	        } catch (Exception ex) {
	            logger.error("", ex);
	            return null;
	        }
	}
	@Override
	public List<UserRole> findByUserName(String userid) throws Exception {
		List<UserRole> list = this.baseService.findByWhere("UserRole", new String[]{"userId"}, new String[]{userid});
		return list;
	}
	@Override
	public UserRole findBySite(String userId, Integer site) {
		try {
			UserRole userRole = this.baseService.getUnique("UserRole", new String[]{"userId","siteId"}, new String[]{userId,site.toString()});
						
			return userRole;
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}
	}
	




}
