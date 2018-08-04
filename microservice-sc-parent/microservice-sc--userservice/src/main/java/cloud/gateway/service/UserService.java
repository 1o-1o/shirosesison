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
	public boolean deleted(String id) throws Exception;

	boolean loginVerify(String username, String password);

    public User findUser(String userId);
    public User findUseByuuid(String uuid);

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
	List<Object> getPageUserList(Integer page, Integer rows);
	List<Object> getUserListByRoleid(Integer page, Integer rows, String roleid);
	boolean passwordVerify(String password, String encodePassword, String salt);
	String getSaltPasswd(String pwd, String salt);
	public boolean registerUser(User user); //注册用户
	boolean deleteByuuid(String uuid);
	List<Object> getUserListByName(Integer page, Integer rows, String name);
	List<Object> getUserListByPow(Integer page, Integer rows, String name);
	List<Object> getUserListByPowName(Integer page, Integer rows, String name, String xzdw);
	public Page<User> getListByPage(User obj, Page<User> page, String orderBySql) throws Exception;
	/**
	 * 包含所有数据
	 * @return
	 * @throws Exception
     */
	 public List<User> getUserList()throws Exception;

	/**
	 * 不包含删除数据
	 * @return
	 * @throws Exception
     */
	public List<User> findAll()throws Exception;

	public Page<User> getPageBySql(User obj, Page<User> page, String orderBySql) throws Exception;
}
