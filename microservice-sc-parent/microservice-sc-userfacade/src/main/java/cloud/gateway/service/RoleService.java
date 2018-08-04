package cloud.gateway.service;


import cloud.gateway.core.models.Resource;
import cloud.gateway.core.models.Role;
import cloud.gateway.core.models.RoleResource;
import cloud.gateway.core.pagination.Page;

import java.util.List;
import java.util.Map;


public interface RoleService {

	public List<Role> findAll();
	
	public Role findById(String id);
	
	public boolean save(Role bean);
	
	public boolean update2(Role bean);
	
	public boolean delete(String id);

	List<Object> getRoleList(Integer page, Integer rows);

	List<Resource> getResourceByRoleid(Integer roleid);

	boolean save(RoleResource bean);

	public List<Map<String, Object>> getResource(Integer id);

	boolean deleteRoleResourceByRoleid(Integer roleid);
	
	List<Role> findBySiteid(String siteid);
	/**
	 * 根据角色名称查询角色
	 * @param roleName 角色名称
	 * @return
	 * @throws Exception
	 */
	Role findRoleByRoleName(String roleName)throws Exception;
	/**
	 * 根据sql分页条件返回查询结果
	 * @param obj
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Page<Role> getListByPage(Role obj, Page<Role> page, String orderBySql)throws Exception;

	public List<Role> getRolesByUserNameAndSiteId(String username, String siteId);

}
