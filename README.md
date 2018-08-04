##### 1、项目结构介绍
&emsp;&emsp;如下图所示，我们是`springboot+dubbo+zookeeper` 的项目：
![image](https://img-blog.csdn.net/20180804160903308?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dvaGFxaXlp/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
&emsp;&emsp;关于上边的项目，`master` 项目即是我们的主项目，含有登录页，`suiteone` 、`suitetwo` 即是我们的从项目。`facade` 项目是我们分布式项目中相当于`公共引用项目` 一样，而`userservice` 项目作为我们的服务接口发布者。我们项目的实际架构我也贴了一张简单的图，方便大家理解：
![这里写图片描述](https://img-blog.csdn.net/20180804132038200?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dvaGFxaXlp/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
&emsp;&emsp;实际上就是我们把我们常见的`serviceImp` 以及`dao和数据库连接等等` 这一部分抽到了`zookeeper`中右边`service` 项目里了，这里我是测试项目，就没有写`suiteoneservice` 、`suitetwoservice` ，仅仅写了`userservice` 项目。
关于`springboot+dubbo+zookeeper` 项目的实现可以参考我的另一篇文章
[spring boot配置dubbo(XML)](https://blog.csdn.net/wohaqiyi/article/details/73159261)
&emsp;&emsp;按照上面的图，大概了解到，`redis` 是与`master` 、`suiteone` 、`suitetwo` 连接的。
### 项目配置介绍
###### （1）主从都添加了`shiro` 和`redis` 依赖。

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
######（2）主从项目里配置`application.properties` 文件
&emsp;&emsp;`master` 项目配置如下：

```
shiro.loginUrl=/login
shiro.jessionid=sessionId
spring.redis.host=192.168.1.160
spring.redis.port=6379
spring.redis.password=znxd
```
&emsp;&emsp;`suite` 项目配置如下：

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
![这里写图片描述](https://img-blog.csdn.net/20180804141953208?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dvaGFxaXlp/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
&emsp;&emsp;`suite` 项目的配置：
![这里写图片描述](https://img-blog.csdn.net/20180804142036409?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dvaGFxaXlp/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
