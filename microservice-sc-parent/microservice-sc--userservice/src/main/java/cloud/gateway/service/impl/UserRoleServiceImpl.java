package cloud.gateway.service.impl;

import cloud.gateway.core.models.User;
import cloud.gateway.core.models.UserRole;
import cloud.gateway.core.repositories.UserRoleRepo;
import cloud.gateway.core.repositories.user.UserRepo;
import cloud.gateway.service.UserRoleService;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service(version="1.1.0.0")
public class UserRoleServiceImpl implements UserRoleService {
	Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);
	
	@Autowired
	private UserRoleRepo userRoleRepo;
	
	@Autowired
	private UserRepo userRepo;


	@Override
	public List<UserRole> findAllGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRole> findByUserId(String userid) {
		try {
			return userRoleRepo.findByType(userid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("findByType :"+userid,e);
			return null;
		
		}
	}

	@Override
	public List<UserRole> findByUserName(String username) {
		try {
			User user = userRepo.findUserByUserName(username);
			
			return userRoleRepo.findByUserName(user.getUserid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("findByType :"+username,e);
			return null;
		
		}
	}
	
	@Override
	public void save(UserRole userRole) {
		try {
			logger.debug("save :"+userRole.getId());
			userRoleRepo.doSave(userRole);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("save :",e);			
		}
	}

	@Override
	public void update(UserRole userRole) {
		logger.debug("update :"+userRole.getId());
		// TODO Auto-generated method stub
		try {
			userRoleRepo.doUpdate(userRole);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("update :",e);
		}
	}

	@Override
	public void delete(Long id) {
		logger.debug("delete :"+id);
		try {
			userRoleRepo.doDelete(id);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("delete :"+id,e);
		}	
	}
	@Override
	public void deleteByUserid(String userid) {
		logger.debug("deleteByUserid :"+userid);
		try {
			userRoleRepo.doDeleteByUserid(userid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("deleteByUserid :"+userid,e);
		}	
	}
	@Override
	public UserRole findBySite(String userId, Integer site) {
		logger.debug("deleteBySite :"+site);
		try {
			return userRoleRepo.findBySite(userId,site);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("deleteByUserid :"+site,e);
			return null;
		}	
		
	}
	@Override
	public List<UserRole> findAllDict() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole findById(Long id) {
		try {
			UserRole findById = userRoleRepo.findById(id);
			return findById;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
}
