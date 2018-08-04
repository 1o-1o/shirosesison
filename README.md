## shiro多项目共享session的`springboot+shiro+redis` 实现项目  
#### 项目结构介绍
&emsp;&emsp;如下图所示，我们是`springboot+dubbo+zookeeper` 的项目：

![images](https://github.com/lingshufeng/images/blob/master/images/%E9%A1%B9%E7%9B%AE%E7%BB%93%E6%9E%84.png)  
&emsp;&emsp;关于上边的项目，`master` 项目即是我们的主项目，含有登录页，`suiteone` 、`suitetwo` 即是我们的从项目。`facade` 项目是我们分布式项目中相当于`公共引用项目` 一样，而`userservice` 项目作为我们的服务接口发布者。我们项目的实际架构我也贴了一张简单的图，方便大家理解：
![images](https://github.com/lingshufeng/images/blob/master/images/%E9%A1%B9%E7%9B%AE%E5%85%B3%E7%B3%BB.png)
&emsp;&emsp;实际上就是我们把我们常见的`serviceImp` 以及`dao和数据库连接等等` 这一部分抽到了`zookeeper`中右边`service` 项目里了，这里我是测试项目，就没有写`suiteoneservice` 、`suitetwoservice` ，仅仅写了`userservice` 项目。 
&emsp;&emsp;关于`springboot+dubbo+zookeeper` 项目的实现可以参考我的另一篇文章
[spring boot配置dubbo(XML)](https://blog.csdn.net/wohaqiyi/article/details/73159261)
&emsp;&emsp;按照上面的图，大概了解到，`redis` 是与`master` 、`suiteone` 、`suitetwo` 连接的。 
### 项目配置介绍  
#### （1）主从都添加了`shiro` 和`redis` 依赖。  

```
<dependency>
    <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-redis</artifactId>
     <version>1.3.6.RELEASE</version>
 </dependency>
  <dependency>
     <groupId>org.apache.shiro</groupId>
     <artifactId>shiro-all</artifactId>
     <version>1.3.2</version>
 </dependency>
```  
#### （2）主从项目里配置`application.properties` 文件      

&emsp;&emsp;`master` 项目配置如下： 

```
shiro.loginUrl=/login
shiro.jessionid=sessionId
spring.redis.host=192.168.1.160
spring.redis.port=6379
spring.redis.password=znxd
```
  
&emsp;&emsp; `suite` 项目配置如下： 

```
#从项目在未登录的情况下访问的登录页，默认为主项目master的登录页
shiro.loginUrl=http://localhost:30000/login
#从项目的sessionId，名字必须与主项目的名字一致
shiro.jessionid=sessionId
#以下为redis的配置
spring.redis.host=192.168.1.160
spring.redis.port=6379
spring.redis.password=znxd
```
(3) 主从项目都放上相同的`shiro` 相关类，如下：
&emsp;&emsp;`master` 项目的配置：
![images](https://github.com/lingshufeng/images/blob/master/images/%E4%B8%BB%E9%A1%B9%E7%9B%AE%E9%85%8D%E7%BD%AE.png)
&emsp;&emsp;`suite` 项目的配置：
![images](https://github.com/lingshufeng/images/blob/master/images/%E4%BB%8E%E9%A1%B9%E7%9B%AE%E9%85%8D%E7%BD%AE.png)

&emsp;&emsp;其实关于从项目的配置不需要跟主项目的相同，在本项目中我已经能去掉的都去掉了。  
&emsp;&emsp;因为我的数据库是用的`sqlserver` 你需要下载下来`sql` 文件，把它们改成合适的`sql` 导入到数据库中。  
&emsp;&emsp;然后修改`userservice` 中的数据库连接配置。  
&emsp;&emsp;启动顺序，先启动`userservice项目` ,再启动`master项目`,最后启动`suite项目`。  
&emsp;&emsp;注意，如果你已经有相关的用户那些类，你完全没必要去用我的，你只需要修改`master` 项目中的`userRealm` 和`RetryLimitHashedCredentialsMatcher` 类中关于`UserService` 和`SysFuncService` 接口的调用。  
&emsp;&emsp; 如果你想添加额外的从项目，你只需要仿照`suiteone` 或者`suitetwo` 写的关于`shiro` 配置即可。  
&emsp;&emsp; 我们是需要`zookeeper` ，如果你没有使用这些，你还可以把我的项目，`master` 项目与`userservice` 项目合并，并且在从项目中引用下`User`类，因为共享的`Session` 在反序列化时，需要`User` 类 。  

