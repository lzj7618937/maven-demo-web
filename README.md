Spring MVC Showcase
-------------------
Demonstrates the capabilities of the Spring MVC web framework through small, simple examples.
After reviewing this showcase, you should have a good understanding of what Spring MVC can do and get a feel for how easy it is to use.
Includes project code along with a supporting slideshow and screen cast.

In this showcase you'll see the following in action:

* The simplest possible @Controller
* Mapping Requests
* Obtaining Request Data
* Generating Responses
* Message Converters
* Rendering Views
* Type Conversion
* Validation
* Forms
* File Upload
* Exception Handling

To get the code:
-------------------
Clone the repository:

    $ git clone git://github.com/SpringSource/spring-mvc-showcase.git

If this is your first time using Github, review http://help.github.com to learn the basics.

To run the application:
-------------------	
From the command line with Maven:

    $ cd spring-mvc-showcase
    $ mvn tomcat7:run [-Dmaven.tomcat.port=<port no.>] (In case 8080 is busy] 

or

In your preferred IDE such as SpringSource Tool Suite (STS) or IDEA:

* Import spring-mvc-showcase as a Maven Project
* Drag-n-drop the project onto the "SpringSource tc Server Developer Edition" or another Servlet 2.5 or > Server to run, such as Tomcat.

Access the deployed web application at: http://localhost:8080/spring-mvc-showcase/

Note:
-------------------

This showcase originated from a [blog post](http://blog.springsource.com/2010/07/22/spring-mvc-3-showcase/) and was adapted into a SpringOne presentation called [Mastering MVC 3](http://www.infoq.com/presentations/Mastering-Spring-MVC-3).

A screen cast showing the showcase in action is [available in QuickTime format](http://s3.springsource.org/MVC/mvc-showcase-screencast.mov).

编译运行:
-------------------
-----------------------------maven使用--------------------------------------
编译：
直接在目录下运行mvn compile
打包：
直接在目录下运行mvn package


服务器维护:
-------------------
https://my.bluehost.com/web-hosting/
demon-studio.com/Demon$1234

--后台登录
ssh demonstu@demon-studio.com
用户名/密码：demonstu/Demon$1234

--查找文件 
find . -name 'httpd.conf'

FTP
ftp.demon-studio.com
demonstu/Demon$1234

---------------------------查看进程-----------------------------------
sudo netstat -anp | grep 8080 8009 8005
ps -aux | grep httpd
sudo kill -9 2352

 ps -ef | grep httpd

-------------------------查看服务--------------------------------------
http://gm100861.blog.51cto.com/1930562/950066
安装服务启动查看器：sudo apt-get install sysv-rc-conf
运行：
安装完成后，直接运行sudo sysv-rc-conf命令即可打开该管理软件，如下图
操作界面十分简洁，你可以用鼠标点击，也可以用键盘方向键定位，用空格键选择， “X”表示开启该服务。 用Ctrl+N翻下一页，用Ctrl+P翻上一页，用Q退出。 

--------------------------修改环境变更-------------------------------
sudo vi mvn compile
sudo source /etc/profile

版本管理:
-------------------
github代码管理：
http://www.cnblogs.com/yc-755909659/p/3753626.html

目录结构：
|-src.main.java.com.demo
|----main
|--------java
|------------web(mvc中的V层)
|----------------controller（控制层代码）
|----------------filter（过滤器）
|----------------interceptor（拦截器）
|------------entity（数据实体层）
|------------dao（数据库操作层）
|------------service（业务处理层）
|------------constant（常量定义）
|------------domain（域定义）
|------------util（常用方法）
|--------resources
|--------webapp
|----test


框架说明:
-------------------
-------------------------框架说明-----------------------------------
所有配置从web.xml开始

报错：
1.出现tomcat启动时报错，如：Failed to initialize component [org.apache.catalina.webresources.JarResourceSet
原因分析：spring-context和spring-context-support有冲突造成，去除spring-context-support的依赖后解决。

Spring一些思想：
1.注解式Spring MVC响应流程：http://www.cnblogs.com/liukemng/p/3724379.html
2.

项目搭建步骤：
1.新建一个maven项目，添加maven依赖包关系pom.xml。
2.修改web.xml，添加spring上下文配置。
有关web.xml结点信息可以参考http://blog.csdn.net/jubincn/article/details/9115205
可知容器对于web.xml的加载过程是context-param >> listener  >> fileter  >> servlet
3.修改web.xml，添加ContextLoaderListener：
ContextLoaderListener作用详解可参考：http://blog.csdn.net/ysughw/article/details/8992322
4.修改root-context.xml，配置了相关springmvc关于安全防御的bean，可参考：http://www.cnblogs.com/Mainz/archive/2012/11/01/2749874.html
5.配置Spring MVC过滤器-委派过滤器代理（DelegatingFilterProxy）
可参考：http://blog.csdn.net/geloin/article/details/7441937
6.配置请求处理器DispatcherServlet，可参考：http://blog.csdn.net/generalyy0/article/details/8243439
7.配置thymeleaf,可参考：http://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html
8.配置hibernate,可参考：http://www.cnblogs.com/leiOOlei/p/3727859.html
9.配置用户自定义过滤器和拦截器，可参考：http://wenku.baidu.com/view/0883d535b90d6c85ec3ac692.html
10.加入hibernate-ehcache配置：可参考：http://xingqinstar.iteye.com/blog/1578578


开发说明:
-------------------
http://sishuok.com/forum/blogPost/list/2625.html


常见问题:
-------------------
spring管理hibernate4 transaction getCurrentSession为什么报错？
http://www.zuidaima.com/question/2017266650483712.htm

前台乱码问题：
修改spring-thymeleaf.xml,增加：<property name="characterEncoding" value="UTF-8"/>  
http://blog.csdn.net/xwin1989/article/details/17553839

SpringMVC为什么在修改一个静态页面必须重新启动服务器才可以？ 
1.参考http://bbs.csdn.net/topics/390301021?page=1，由于论坛上的问题是针对freemaker，但本应用没有使用，而用的thymeleaf，在网站上查了一下没有相关解决方案。
2.试了下使用springmvc原有的视图转发类无些问题。
3.所以直接看了thymeleaf官方文档，看到ServletContextTemplateResolver有个属性为templateResolver.setCacheTTLMs(3600000L);所以加上了相关参数，加上如下配置属性：
 <property name="cacheTTLMs" value="10"/>  问题解决。

