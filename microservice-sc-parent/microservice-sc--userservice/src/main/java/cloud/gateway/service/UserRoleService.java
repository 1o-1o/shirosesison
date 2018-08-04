package cloud.gateway.service;


import cloud.gateway.core.models.UserRole;

import java.util.List;


public interface UserRoleService {
	
		
    public List<UserRole> findAllGroup();
    
    public List<UserRole> findByUserId(String userid);
    
    public void save(UserRole userRole);
    public void update(UserRole userRole);
    public void delete(Long id);

    public List<UserRole> findAllDict();

    UserRole findById(Long id);

	List<UserRole> findByUserName(String userName);

	void deleteByUserid(String userid);

	UserRole findBySite(String userId, Integer site);
    
    
	
}
