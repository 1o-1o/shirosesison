//package microservice.sc.shiro.controller;
//
//import cloud.gateway.core.models.User;
//import cloud.gateway.service.UserService;
//import com.alibaba.dubbo.common.utils.StringUtils;
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import microservice.sc.service.controller.base.BaseController;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.Map;
//
//@Controller //如果用RestController，比如login.html就会只显示值，必须用controller注解才可以显示页面
//public class LoginCheckController extends BaseController {
//	/*存入session里的用户名称*/
//	public static final String SESSION_USER = "sessionUser";
//
//	@Autowired
//	private UserService userService;
//
//    /**
//     * 跳转本地登录页面
//     */
//    @RequestMapping(value="/login",method=RequestMethod.GET)
//    public String login(HttpServletRequest request){
//		return "login";
//    }
//
//    /**
//     * 本地登录页面账户密码提交验证ajax请求方式
//     * @param req
//     * @return
//     * @throws Exception
//     * @throws IOException
//     * @throws JsonMappingException
//     * @throws JsonParseException
//     */
//    @RequestMapping(value="/loginForm",method=RequestMethod.POST)
//	@ResponseBody
//    public Object loginForm(@RequestBody String req) throws Exception{
//    	Map map=null;
//    	String username = "";
//    	String password ="";
//		try {
//			map=jsonTranster.readValue(req,Map.class);
//			username = map.get("username").toString();
//			password = map.get("password").toString();
//		} catch (IOException e) {
//			e.printStackTrace();
//			return addResultMapMsg(false,"username和password必须以json字符串形式传入");
//		}
//		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
//			return addResultMapMsg(false,"username和password必须以json字符串形式传入");
//		}
//    	UsernamePasswordToken upt = new UsernamePasswordToken(username,password);
//    	Subject subject = SecurityUtils.getSubject();
//		try {
//			subject.login(upt);
//		} catch (Exception e) {
//			e.printStackTrace();
//			if("no_user".equals(e.getMessage())){
//				return addResultMapMsg(false,"用户不存在");
//			}else if("no_permission".equals(e.getMessage())){
//				return addResultMapMsg(false,"用户无权限访问");
//			}else if("no_status".equals(e.getMessage())){
//				return addResultMapMsg(false,"用户已停用");
//			}
//			return addResultMapMsg(false,"密码错误");
//		}
//		Session session = subject.getSession();
//		User user = userService.findUserByUserName(username);
//		user.setPasswd("");
//		session.setAttribute(SESSION_USER, user);
//		return addResultMapMsg(true,"登录成功");
//    }
//    /**
//     * 登录首页
//     * @return
//     */
//    @RequestMapping(value={"/home","/"},method=RequestMethod.GET)
//	public String home(){
//		return "SZMap";
//	}
//
//    /**
//     * 本地登出页面
//     * @param redirectAttributes
//     * @return
//     */
//    @RequestMapping(value="/logout",method=RequestMethod.GET)
//    public String logout(RedirectAttributes redirectAttributes ){
//        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
//    	Subject subject = SecurityUtils.getSubject();
//        if (subject.isAuthenticated()) {
//        	subject.logout();
//        }
//		return "redirect:/login";
//    }
//}
