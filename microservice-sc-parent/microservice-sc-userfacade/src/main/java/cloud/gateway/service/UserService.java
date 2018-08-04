package cloud.gateway.service;


import cloud.gateway.core.models.User;
import cloud.gateway.core.pagination.Page;

import java.util.List;


public interface UserService  {

	public User save(User user);
	public boolean updateUser(User user);

	/**
	 * 逻辑删除
	 * @param userid
	 * @return
     */
	public boolean delete(String userid);
	/**
	 * 物理删除
	 * @param id
	 * @return
	 */
	public boolean deleted(String id);
	
	boolean loginVerify(String username, String password);

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

	List<Object> getUserListByRoleid(Integer page, Integer rows, String roleid);

	public boolean registerUser(User user); //注册用户

	boolean passwordVerify(String password, String encodePassword, String salt);

	/**
	 * 分页查询
	 * @param page
	 * @param rows
     * @return
     */
	List<Object> getPageUserList(Integer page, Integer rows);

	/**
	 * 不包含删除数据
	 * @return
	 * @throws Exception
	 */
	public List<User> findAll()throws Exception;

	/**
	 * 根据sql分页条件返回查询结果
	 * @param obj
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Page<User> getListByPage(User obj, Page<User> page, String orderBySql)throws Exception;

	/**
	 * 根据sql分页条件返回查询结果
	 * @param obj
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Page<User> getPageBySql(User obj, Page<User> page, String orderBySql)throws Exception;

}
