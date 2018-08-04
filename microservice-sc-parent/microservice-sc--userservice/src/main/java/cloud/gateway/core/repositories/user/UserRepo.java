package cloud.gateway.core.repositories.user;


import cloud.gateway.core.models.User;
import cloud.gateway.core.pagination.Page;

import java.util.List;


public interface UserRepo {
	public User saveUser(User user);
	public boolean updateUser(User user);
    public User findUser(String userId);

	/**
	 * 逻辑查询
	 * @param username
	 * @return
     */
    public User findUserByUserName(String username);

	/**
	 * 物理查询
	 * @param username
	 * @return
     */
	public User findUserByName(String username);
    
    public List<User> getUserList(Page<User> page) throws Exception;

	/**
	 * 逻辑删除
	 * @param userid
	 * @throws Exception
     */
    public void delete(String userid) throws Exception;

	/**
	 * 物理删除
	 * @param id
	 * @throws Exception
     */
	public boolean deleted(String id)throws Exception;
    public List<User> getUserByRoleId(String roleId, Page<User> page) throws Exception;
    public User findUseByuuid(String uuid);
	void deleteByuuid(String uuid) throws Exception;
	public List<User> getUserListByName(Page<User> page, String name) throws Exception ;
	List<User> getUserListByPow(Page<User> page, String name) throws Exception;
	List<User> getUserListByPowName(Page<User> page, String name, String xzdw)throws Exception;

	/**
	 * 根据条件查询支持模糊和等值
	 * @param hql 拼写的hql
	 * @param counthql 计算的总数
	 * @param page 分页
	 * @return
     * @throws Exception
     */
	public Page<User> getListPageByHql(String hql, String counthql, Page<User> page) throws Exception;
	/**
	 * 查询所有数据
	 */
	public List<User> getUserList() throws Exception ;

	/**
	 * 根据条件查询
	 * @param columns 查询字段
	 * @param values 查询值
	 * @return
	 * @throws Exception
     */
	public List<Object> findPage(String[] columns, String[] values, Page<User> page)throws Exception;

	/**
	 * 根据hql查询符合条件的结果
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public List<User> getListPageByHql(String hql) throws Exception;
}
