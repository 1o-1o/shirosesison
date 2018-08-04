package microservice.sc.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * 验证用户登录
 * 
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private SysFuncService sysFuncService;

	public UserRealm() {
		setName("UserRealm");
		// 采用MD5加密
		setCredentialsMatcher(new HashedCredentialsMatcher("md5"));
	}

	/**
	 * 从项目下边的也没用
	 */

	//权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		User user = (User)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		Map<String,Object> argsMap = new HashMap<String,Object>();
//		argsMap.put("username",user.getUsername());
//		argsMap.put("funcType","3");
//		argsMap.put("siteId","1"); //门户
//		List<SysFunc> sysFuncList = sysFuncService.selectSysFuncByUserName(argsMap); //获取所有按钮的功能记录
//		if(sysFuncList != null){
//			Set<String> permissonSet = new HashSet<String>();
//			for(SysFunc func:sysFuncList){
//				if(!StringUtils.isEmpty(func.getFunc_Url())){
//					permissonSet.add(func.getFunc_Url());
//				};
//			}
//			info.setStringPermissions(permissonSet);
//		}
		
		//add Roles String[Set<String> roles]
		//info.setRoles(roles);
		return info;
	}
	
	//登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//		UsernamePasswordToken upt = (UsernamePasswordToken) token;
//		char[] passwords = upt.getPassword();
//		String pwd = new String(passwords);
//		if(!StringUtils.isEmpty(pwd)){ //如果密码不是空,表示是本地登录
//			User user = this.userService.findUserByUserName(upt.getUsername());
//			if(user == null){
//				throw new AuthenticationException("no_user");
//			}
//			if(!"1".equals(user.getStatus())){ //停用
//				throw new AuthenticationException("no_status");
//			}
//			Map map = new HashMap();
//			map.put("username",user.getUsername());
//			map.put("siteId","1");
//			List<String> siteIdList = sysFuncService.selectSiteIdByUserName(map);
//			if(siteIdList == null || siteIdList.isEmpty()){
//				throw new AuthenticationException("no_permission");
//			}
//
//			if(user!=null && user.getDeleted()==0){
//				SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
//		                user, //用户名
//		                user.getPasswd(), //密码
//		                ByteSource.Util.bytes(user.getUserid()+user.getUsername()),//salt=username+salt
//		                getName());  //realm name
//				return info;
//			}
//			return null;//getAuthenticationInfoMethod(upt.getUsername());
//		}else{ //如果密码是空，表示是远程登录，从username位置获得token
//			return null;
//		}
		return null;
	}
}