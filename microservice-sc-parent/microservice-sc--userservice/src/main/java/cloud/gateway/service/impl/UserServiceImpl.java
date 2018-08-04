package cloud.gateway.service.impl;

import cloud.gateway.core.models.User;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.repositories.user.UserRepo;
import cloud.gateway.core.util.PasswordUtil;
import cloud.gateway.service.UserService;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service(version="1.1.0.0")
public class UserServiceImpl implements UserService {
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepo userRepo;

	
	/*
	 * 登录，验证用户名密码
	 * @see microservice.fpzj.service.JwtService#getTokenStatus(java.lang.String)
	 */
	@Override
	public boolean loginVerify(String username, String password) {
		logger.debug("loginVerify :"+username+"--"+password);
		// String newPassword = PasswordUtil.encodePassword(password);
		boolean res = false;
		User user = userRepo.findUserByUserName(username);
		if (user != null) {
			res = new PasswordUtil().verifyPassword(password, user.getPasswd(), user.getUserid()+user.getUsername());
		}
		return res;
	}

	/*
	 * 密码验证
	 * @see microservice.fpzj.service.JwtService#getTokenStatus(java.lang.String)
	 */
	@Override
	public boolean passwordVerify(String password, String encodePassword, String salt) {
		logger.debug("passwordVerify :"+password+"--"+encodePassword+"--"+salt);
		//String newPassword1 = PasswordUtil.encodePassword(password, salt);
		boolean res = false;
		res = new PasswordUtil().verifyPassword(password, encodePassword, salt);
		//System.out.println(newPassword1);
		return res;
	}

	/*
	 * 根据userid,获取用户
	 * @see microservice.fpzj.service.JwtService#getTokenStatus(java.lang.String)
	 */
	@Override
	public User findUser(String userId) {
		logger.debug("findUser :"+userId );
		return userRepo.findUser(userId);
	}

	/*
	 * 根据uuid,获取用户
	 * @see microservice.fpzj.service.JwtService#getTokenStatus(java.lang.String)
	 */
	@Override
	public User findUseByuuid(String uuid) {
		logger.debug("findUser :"+uuid );
		return userRepo.findUseByuuid(uuid);
	}
	
	/*
	 * 根据用户名，获取用户实例(non-Javadoc)
	 * @see microservice.fpzj.service.JwtService#findUserByUserName(java.lang.String)
	 */
	@Override
	public User findUserByUserName(String name) {
		logger.debug("findUserByUserName :"+name );
		User user = userRepo.findUserByUserName(name);
		return user;
	}

	@Override
	public User findUserByName(String username) {
		logger.debug("findUserByName :"+username );
		User user = userRepo.findUserByName(username);
		return user;
	}

	/*
	 * 获取所有的用户信息
	 * 
	 */
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<Object> getPageUserList(Integer page, Integer rows){
		logger.debug("getUserList :"+page +"--"+rows);
		Page<User> p = new Page<User>(page, rows);
		List<User> list = new ArrayList<User>();
		try {
			list = this.userRepo.getUserList(p);
		} catch (Exception e) {
			logger.error("getUserList :", e);
		}
		List<Object> o = new ArrayList<Object>();
		o.add(list);
		o.add(p);
		return o;
	}
	/*
	 * 根据用户xzdw 查询 符合权限相关的用户信息
	 * 
	 */
	@Override
	public List<Object> getUserListByPow(Integer page, Integer rows,String name){
		logger.debug("getUserListByPow :"+page +"--"+rows);
		Page<User> p = new Page<User>(page, rows);
		List<User> list = new ArrayList<User>();
		try {
			list = this.userRepo.getUserListByPow(p, name);
		} catch (Exception e) {
			logger.error("getUserListByPow :", e);
		}
		List<Object> o = new ArrayList<Object>();
		o.add(list);
		o.add(p);
		return o;
	}
	/*
	 * 根据name 查询 符合相关的用户信息
	 * 
	 */
	@Override
	public List<Object> getUserListByName(Integer page, Integer rows,String name){
		logger.debug("getUserListByName :"+page +"--"+rows);
		Page<User> p = new Page<User>(page, rows);
		List<User> list = new ArrayList<User>();
		try {
			list = this.userRepo.getUserListByName(p,name);
		} catch (Exception e) {
			logger.error("getUserListByName :", e);
		}
		List<Object> o = new ArrayList<Object>();
		o.add(list);
		o.add(p);
		return o;
	}
	/*
	 * 根据name 查询 符合相关的用户信息
	 * 
	 */
	@Override
	public List<Object> getUserListByPowName(Integer page, Integer rows,String name ,String xzdw){
		logger.debug("getUserListByName :"+page +"--"+rows);
		Page<User> p = new Page<User>(page, rows);
		List<User> list = new ArrayList<User>();
		try {
			list = this.userRepo.getUserListByPowName(p,name,xzdw);
		} catch (Exception e) {
			logger.error("getUserListByName :", e);
		}
		List<Object> o = new ArrayList<Object>();
		o.add(list);
		o.add(p);
		return o;
	}

	@Override
	public List<Object> getUserListByRoleid(Integer page, Integer rows, String roleid){
		logger.debug("getUserListByRoleid :"+page +"--"+rows+"--"+roleid);
		Page<User> p = new Page<User>(page, rows);
		List<User> list = new ArrayList<User>();
		try {
			list = this.userRepo.getUserByRoleId(roleid,p);
		} catch (Exception e) {
			
			logger.error("getUserListByRoleid :"+roleid, e);
		}
		List<Object> o = new ArrayList<Object>();
		o.add(list);
		o.add(p);
		return o;
	}
	@Override
	public String getSaltPasswd(String pwd, String salt) {
		logger.debug("getSaltPasswd :"+pwd +"--"+salt);
		return new PasswordUtil().encodePassword(pwd, salt);
	}
	@Override
	public User save(User user) {
		logger.debug("save :"+user.getUsername() +"--"+user.getUserid());
		User u = userRepo.saveUser(user);
		return u;
	}
	@Override
	public boolean updateUser(User user) {
		logger.debug("update :"+user.getUsername() +"--"+user.getUserid());
		boolean b = userRepo.updateUser(user);
		if(b){
			return true;
		}
		return false;
		/*if(userRepo.updateUser(user)){
			if(user!=null){
				userRedisRepo.saveUser(user);
			}
			return true;
		}else{
			return false;
		}*/
	}
	@Override
	public boolean delete(String userid) {
		logger.debug("delete :"+userid);
		try {
			String[] split = userid.split(",");
			if(split.length == 0){
				return false;
			}
			for(int i=0;i<split.length;i++){
				userRepo.delete(split[i]);
			}
			return true;
		} catch (Exception e) {
			logger.error("userDelete"+"删除失败");
			e.printStackTrace();
		}
		/*try {
			userRepo.delete(userid);
			User user = userRepo.findUser(userid);			
			if(user != null){
				userRedisRepo.deleteUser(user);
				
			}
			return true;
		} catch (Exception e) {
			logger.error("delete :"+userid, e);
		}
		return false;*/
		return false;
	}

	@Override
	public boolean deleted(String  id) {
		String[] split = id.split(",");
		if(split.length==0){
			return false;
		}
		try {
			for(int i=0;i<split.length;i++){
				boolean b = userRepo.deleted(split[i]);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return false;
	}


	@Override
	public boolean deleteByuuid(String uuid) {
		logger.debug("delete :"+uuid);
		try {
			userRepo.deleteByuuid(uuid);
			User user = userRepo.findUseByuuid(uuid);
			return true;
		} catch (Exception e) {
			logger.error("delete :"+uuid, e);
		}
		return false;
	}
	
	@Override
	public boolean registerUser(User user) {
		logger.debug("registerUser :"+user.getUsername());
		User saveUser = userRepo.saveUser(user);
		if(saveUser == null){
			return false; //注册失败
		}
		return true ; //注册成功
		
	}
	public synchronized Map<String, Object> addResultMapMsg(boolean flag,String msg){
		logger.debug("addResultMapMsg :"+flag+"--"+msg);
		Map<String, Object> map = new HashMap<>();
		map.put("success", flag);
		map.put("msg", msg);
		return map;
	}

	@Override
	public List<User> findAll() throws Exception{
		List<User> userList = userRepo.getUserList();
		if(userList.size()==0 || userList.isEmpty()){
			return null;
		}
		return userList;
	}
//	@Override
//	public List<Object> findPage(String[] columns, String[] values,Integer page,Integer rows){
//		Page<User> pageUser = new Page<User>(page, rows);
//
//		try {
//			List<Object> list = userRepo.findPage(columns, values, pageUser);
//			if(list.isEmpty()){
//				return null;
//			}
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	/**
	 * 根据sql分页条件返回查询结果
	 * @param obj
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<User> getPageBySql(User obj, Page<User> page, String orderBySql) throws Exception {
		StringBuffer buffer = new StringBuffer();
		String selectHql = "select a from User a ";
		String countHql = "select count(*) from User a ";
		if(!StringUtils.isBlank(obj.getUsername())){ //条件的拼接
			buffer.append(" and a.username ='"+obj.getUsername()+"'");
		}
		if(!StringUtils.isBlank(obj.getNickName())){
			buffer.append(" and a.nickName like '%"+obj.getNickName()+"%'");
		}

		buffer.append(" and a.deleted!=1 ");

		String cotentHql = buffer.toString();
		if(!StringUtils.isBlank(cotentHql)){ //如果有条件则截取拼接到
			selectHql = selectHql + "where "+cotentHql.substring(cotentHql.indexOf(" a."));
			countHql = countHql + " where "+cotentHql.substring(cotentHql.indexOf(" a."));
		}
		selectHql = selectHql+orderBySql;
		//默认必须传入page，如果不想分页，那传入一个大值也行
		Page<User> pageResponse =  userRepo.getListPageByHql(selectHql,countHql,page);
		return pageResponse;
	}

	@Override
	public Page<User> getListByPage(User obj, Page<User> page, String orderBySql) throws Exception {
		StringBuffer buffer = new StringBuffer();
		String selectHql = "select a from User a where a.deleted!=1 and( ";
		String countHql = "select count(*) from User a where a.deleted!=1 and( ";



			buffer.append(" a.username like '%"+obj.getSearch()+"%' ");


			buffer.append("or a.nickName like '%"+obj.getSearch()+"%' ");


			buffer.append("or a.cardno like '%"+obj.getSearch()+"%' ");


			buffer.append("or a.daParTment like '%"+obj.getSearch()+"%' ");


			buffer.append("or a.mobiLeno like '%"+obj.getSearch()+"%' ");


			buffer.append("or a.hAddress like '%"+obj.getSearch()+"%' ) ");


		String cotentHql = buffer.toString();
		/*if(!StringUtils.isBlank(cotentHql)){ //如果有条件则截取拼接到
			selectHql = selectHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
			countHql = countHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
		}*/

		selectHql=selectHql+cotentHql+orderBySql;//查询
		countHql=countHql+cotentHql;//统计
		//默认必须传入page，如果不想分页，那传入一个大值也行
		Page<User> pageResponse =  userRepo.getListPageByHql(selectHql,countHql,page);
		return pageResponse;
	}

	@Override
	public List<User> getUserList() throws Exception {
		return null;
	}


}
