package microservice.sc.shiro;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

	@Value("${shiro.loginUrl}")
	private String suiteLoginUrl;

	@Value("${shiro.jessionid}")
	private String jessionId;
	/**
	 * FilterRegistrationBean
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter")); 
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*"); 
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
	}
	
	/**
	 * @see ShiroFilterFactoryBean
	 * @return
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(){
		ShiroFilterFactoryBean bean = new MShiroFilterFactoryBean(); //指向自定义过滤器，自定义过滤器对js/css等忽略
		bean.setSecurityManager(securityManager());
		bean.setLoginUrl(suiteLoginUrl);
//		bean.setUnauthorizedUrl("/unauthor");
		Map<String, Filter>filters = new LinkedHashMap<>();
//		filters.put("perms", urlPermissionsFilter());
		filters.put("anon", new AnonymousFilter());
		bean.setFilters(filters);
		//shiro配置过滤规则少量的话可以用hashMap,数量多了要用LinkedHashMap,保证有序，原因未知
		Map<String, String> chains =  new LinkedHashMap<>();
//		chains.put("/login","anon");
//		chains.put("/loginForm","anon");
//		chains.put("/login/check","anon");
		chains.put("/**", "authc");
		bean.setFilterChainDefinitionMap(chains);
		return bean;
	}
	
	/**
	 * @see org.apache.shiro.mgt.SecurityManager
	 * @return
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(userRealm());
		//manager.setCacheManager(cacheManager());
		manager.setSessionManager(defaultWebSessionManager());
		return manager;
	}

	@Bean
	public RedisSessionDao getRedisSessionDao(){
		return new RedisSessionDao();
	}
	/**
	 * @see DefaultWebSessionManager
	 * @return
	 */
	@Bean(name="sessionManager")
	public DefaultWebSessionManager defaultWebSessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		//sessionManager.setCacheManager(cacheManager());
		sessionManager.setGlobalSessionTimeout(43200000); //12小时
		sessionManager.setDeleteInvalidSessions(true);
		sessionManager.setSessionDAO(getRedisSessionDao());
		sessionManager.setSessionValidationSchedulerEnabled(true);
		sessionManager.setDeleteInvalidSessions(true);
		sessionManager.setSessionIdCookie(getSessionIdCookie());
		return sessionManager;
	}
	/**
	 * 给shiro的sessionId默认的JSSESSIONID名字改掉,
	 * 下边的名字不能变，必须要与主项目的相同
	 * @return
	 */
	@Bean(name="sessionIdCookie")
	public SimpleCookie getSessionIdCookie(){
		SimpleCookie simpleCookie = new SimpleCookie(jessionId);
		return simpleCookie;
	}
	
	/**
	 * @see UserRealm--->AuthorizingRealm
	 * @return
	 */
	@Bean
	@DependsOn(value="lifecycleBeanPostProcessor")
	public UserRealm userRealm() {
		UserRealm userRealm = new UserRealm();
		//userRealm.setJwtService(jwtService);
		userRealm.setCredentialsMatcher(credentialsMatcher());
		//userRealm.setCacheManager(cacheManager());
		return userRealm;
	}
	@Bean(name="credentialsMatcher")
    public CredentialsMatcher credentialsMatcher() {
        return new RetryLimitHashedCredentialsMatcher();
    }

	
	/*@Bean
	public EhCacheManager cacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
		return cacheManager;
	}*/

	/**
	 * 该类如果不设置为static，@Value注解就无效，原因未知
	 * @return
	 */
	@Bean
	public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
}