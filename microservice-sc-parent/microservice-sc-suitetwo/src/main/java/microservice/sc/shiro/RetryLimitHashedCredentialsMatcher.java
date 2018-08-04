package microservice.sc.shiro;



import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
/**
 * 输错5次密码锁定2分钟，ehcache.xml配置
 * @author ZML
 *
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

//	@Autowired
//	private UserService userService;

	/**
	 * 从项目这里没用
	 */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

		//boolean matches = super.doCredentialsMatch(token, info);
//		if(token instanceof UsernamePasswordToken){
//			//根据用户的登陆信息创建一个token
//			UsernamePasswordToken userToken = (UsernamePasswordToken) token;
//			//String accountCredentials = (String) info.getCredentials();
//			User user = userService.findUserByUserName(userToken.getUsername());
//
//			char[] passwordchars =userToken.getPassword();
//
//			String password = new String(passwordchars);
//			//验证令牌
//			if(password.equals("")){
//				return false;
//			}else{
//				boolean res = userService.passwordVerify(password,user.getPasswd(),user.getUserid()+user.getUsername());
//				return res;
//			}
//		}
		return false;
    }
}
