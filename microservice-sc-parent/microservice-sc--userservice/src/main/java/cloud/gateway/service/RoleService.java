package cloud.gateway.service;

import cloud.gateway.core.models.Role;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.service.base.BaseService;
import java.util.List;

public interface RoleService extends BaseService<Role> {
	/**
	 * 添加角色
	 * @param bean
	 * @return
     */
	public boolean save(Role bean);

	/**
	 * 根据角色名称查询角色
	 * @param roleName 角色名称
	 * @return
	 * @throws Exception
     */
	Role findRoleByRoleName(String roleName)throws Exception;
	/**
	 * 根据条件查询
	 * @param columns 查询的字段
	 * @param values 查询的条件
	 * @return
	 */
	public List<Object> findPage(String[] columns, String[] values, Integer page, Integer rows)throws Exception;

	/**
	 * 传统分页查询
	 * @param page 当前页
	 * @param rows 每页记录数
     * @return
     */
	List<Object> getRoleList(Integer page, Integer rows);
	/**
	 * 更新数据
	 * @param bean
	 * @return
     */
	public boolean update2(Role bean);
	/**
	 * 根据sql分页条件返回查询结果
	 * @param obj
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Page<Role> getListByPage(Role obj, Page<Role> page, String orderBySql)throws Exception;

	/**
	 * 根据主键查询
	 * @param id
	 * @return
     */
	public Role findById(String id);

	/**
	 * 根据主键删除
	 * @param id
	 * @return
     */
	public boolean delete(String id);

	/**
	 * 查询所有角色
	 * @return
     */
	public List<Role> findAll();

	public List<Role> getRolesByUserNameAndSiteId(String username, String siteId);
	/*public List<Role> findAll();


	public boolean save(Role bean);
	
	public boolean delete(Integer id);
	
	//List<Resource> getResourceByRoleid(Integer roleid);
	
	//boolean save(RoleResource bean);
	
	boolean deleteRoleResourceByRoleid(Integer roleid);
	
	public List<Map<String, Object>> getResource(Integer id);

	List<Role> findBySiteid(String siteid);
	*/
}
