package cloud.gateway.core.repositories;


import cloud.gateway.core.models.Role;
import cloud.gateway.core.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IGroupService
 * @Description:Group接口
 * @author: zml
 * @date: 2014-11-27 下午15:05:07
 *
 */
public interface ServiceRoleRepo {

	public List<Role> getRoleListPage(Page<Role> page) throws Exception;
	
	public List<Role> getRoleList() throws Exception;
	
	public Role getRoleById(String id) throws Exception;
	
	public List<Role> getRoleListPage() throws Exception;
	
	public void doAdd(Role role) throws Exception;

	public void doUpdate(Role role) throws Exception;
	
	public void doDelete(Role role) throws Exception;
	
	public void doDelete(Integer roleid) throws Exception;
	
	public List<Map<String, Object>> getMenuByRoleid(String id) throws Exception;

	List<Role> getRoleListBySiteid(String site_id) throws Exception;
}
