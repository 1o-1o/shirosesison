package cloud.gateway.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * equivalence :
 * database-config.xml
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"cloud.gateway.core.repositories"})
public class DataSourceConfig {

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

    @Value("${db.driver}")
    private String dbDriver;
    @Value("${db.url}")
    private String dbUrl;
    @Value("${db.username}")
    private String dbUsername;
    @Value("${db.password}")
    private String dbPassword;
    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;
    @Value("${entitymanager.packages.to.scan}")
    private String entityPackages;

//    @Resource
//    private Environment env;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        
        dataSource.setInitialSize(50);
        dataSource.setMinIdle(50);
        dataSource.setMaxIdle(200);
        //dataSource.set.set.setsetMaxActive(500);
        dataSource.setTimeBetweenEvictionRunsMillis(3000000);
//        dataSource.setValidationQuery("select 1 from dual");
        dataSource.setValidationQuery("SELECT getdate()"); //sqlserver不支持dual
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setPackagesToScan(entityPackages);

        entityManagerFactoryBean.setJpaProperties(hibProperties());

        return entityManagerFactoryBean;
    }

    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect);
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);
        properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, hibernateHbm2ddlAuto);
        
        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
    

    /*@Bean
    public LocalSessionFactoryBean entityManagerFactory() {
    	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    	sessionFactory.setDataSource(dataSource());
        //JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    	sessionFactory.setPackagesToScan(entityPackages);
    	sessionFactory.setHibernateProperties(hibProperties());

        return sessionFactory;
    }

    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect);
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);
        properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, hibernateHbm2ddlAuto);
        return properties;
    }
*/
}

/*
equivalence :
    <context:component-scan base-package="net.htn.springjwt.core.repositories"/>

    <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
        <property name="username" value="sa"/>
        <property name="password" value="sa"/>
        <property name="url" value="jdbc:h2:mem:test"/>
        <property name="driverClassName" value="org.h2.Driver"/>
    </bean>

    <bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="jpaVendorAdapter">
            <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter"/>
        </property>
        <property name="jpaProperties">
            <map>
                <entry key="hibernate.hbm2ddl.auto" value="create-drop"/>
                <entry key="hibernate.show_sql" value="true"/>
            </map>
        </property>
        <property name="packagesToScan" value="net.htn.springjwt.core.models.entities"/>
    </bean>

    <tx:annotation-driven/>
    <bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager"/>
*/