package cloud.gateway.core.repositories;


import cloud.gateway.core.models.UserRole;

import java.util.List;


public interface UserRoleRepo {

    public List<UserRole> findAll() throws Exception;
    public List<UserRole> findByType(String type) throws Exception;
    public void doSave(UserRole userRole) throws Exception;
    public void doUpdate(UserRole userRole) throws Exception;
    public void doDelete(Long id) throws Exception;
    UserRole findById(Long id) throws Exception;
	public List<UserRole> findByUserName(String userName)throws Exception;
	void doDeleteByUserid(String userid) throws Exception;
	public UserRole findBySite(String userId, Integer site);
 }
