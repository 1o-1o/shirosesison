package cloud.gateway.core.repositories;


import cloud.gateway.core.models.Role;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.repositories.base.BaseDaoRepo;
import java.util.List;
import java.util.Map;
/**
 * @ClassName: IGroupService
 * @Description:Group接口
 * @author: zml
 * @date: 2014-11-27 下午15:05:07
 *
 */
public interface RoleRepo extends BaseDaoRepo<Role> {

	public List<Role> getRoleListPage(Page<Role> page) throws Exception;
	
	public List<Role> getRoleList() throws Exception;
	
	public Role getRoleById(String id) throws Exception;
	
	public List<Role> getRoleListPage() throws Exception;
	
	public void doAdd(Role role) throws Exception;

	public void doUpdate(Role role) throws Exception;
	
	public void doDelete(Role role) throws Exception;
	
	public void doDelete(String roleid) throws Exception;
	
	public List<Map<String, Object>> getMenuByRoleid(String id) throws Exception;

	List<Role> getRoleListBySiteid(String site_id) throws Exception;

	Role findRoleByRoleName(String roleName)throws Exception;
	/**
	 * 根据条件查询
	 * @param columns 查询字段
	 * @param values 查询值
	 * @return
	 * @throws Exception
	 */
	public List<Object> findPage(String[] columns, String[] values, Page<Role> page)throws Exception;
	public Page<Role> getListPageByHql(String hql, String counthql, Page<Role> page) throws Exception;
}
