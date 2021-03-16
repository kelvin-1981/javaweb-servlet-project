# 1. Tomcat

## 1.1 Tomcat安装及使用

### 1.1.1 环境准备-JDK安装

> windows安装

1. 官网下载 JDK：windows：jdk-8u212-windows-x64.exe  

2. 安装至目录：C:\Program Files\Java\jdk1.8.0_212

3. 设置环境变量  添加系统变量

   JAVA_HOME： C:\Progra~1\Java\jdk1.8.0_212

   path： %JAVA_HOME%\bin 与  %JAVA_HOME%\jre\bin

> linux安装

1. 官网下载JDK :jdk-8u251-linux-x64.tar.gz

2. 下载文件传输至虚拟机/opt/software

3. 进入虚拟机software 解压安装文件：tar -zxvf jdk-8u251-linux-x64.tar.gz -C /opt/module/

4. 编辑配置文件：

```shell
# 编辑配置文件
sudo vim /etc/profile
##JAVA_HOME
export JAVA_HOME=/opt/module/jdk1.8.0_251
export PATH=$PATH:$JAVA_HOME/bin
```

### 1.1.2 Tomcat下载

> 官网地址：https://tomcat.apache.org

1. windows： apache-tomcat-9.0.44-windows-x64.zip （此范例使用windows）

2. linux：apache-tomcat-9.0.35.tar.gz

<img src="C:\Users\YYKJ\AppData\Roaming\Typora\typora-user-images\image-20210315134004902.png" alt="image-20210315134004902" style="zoom:50%;" />

### 1.1.3 Tomcat 启动&访问&关闭

1. 解压至目录 D:\apache-tomcat-9.0.35

2. 启动 tomcat：D:\apache-tomcat-9.0.35\bin\startup.bat

3. 访问测试 浏览器：http://localhost:8080/ 

4. 关闭 tomcat：D:\apache-tomcat-9.0.35\bin\shutdown.bat

### 1.1.4 Tomcat配置

1. 核心配置文件：D:\apache-tomcat-9.0.35\conf\server.xml

2. 访问：http://localhost:8080/  指向访问D:\apache-tomcat-9.0.35\webapps\ROOT\index.jsp
3. 可配置项

> port：访问端口  默认：8080

```xml
<Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
```

> host：访问主机名称 默认：localhost

```xml
<!--除此外需要更改system32 下的host映射文件-->
<Host name="localhost"  appBase="webapps" 
      		   unpackWARs="true" autoDeploy="true"/>
```

> appBase：访问路径

## 1.2 访问流程

1. 输入域名 确定
2. 查找IP：C:\Windows\System32\drivers\etc\hosts
   - 发现对应IP：直接返回
   - 未发现对应IP：远程DNS服务器上找IP(找不到返回异常) 

3. 访问页面资源

## 1.3 网站结构

<img src="C:\Users\YYKJ\AppData\Roaming\Typora\typora-user-images\image-20210315144911601.png" alt="image-20210315144911601" style="zoom:67%;" />

## 1.4 发布应用

1. 复制D:\apache-tomcat-9.0.35\webapps\ROOT 更改名称 tomcat-demo
2. 清空web.xml文件内容
3. 编写index.jsp

```html
<html>
	<header>
  		<title>tomcat</title>
	</header>
	<body>
 		<h1>Tomcat Demo !!!</h1>
	</body>
</html>
```

4. 启动tomcat：D:\apache-tomcat-9.0.35\bin\startup.bat
5. 访问站点：http://localhost:8080/tomcat-demo/



# 2. HTTP

## 2.1 HTTP定义

​	1. HTTP（超文本传输协议）是一个简单的请求-响应协议，它通常运行在TCP之上。

- 文本：html，字符串
- 超文本：图片，音乐，视频定位，地图。。。。
- 80

​    2. HTTPS：安全的

- 443

## 2.2 HTTP版本

- HTTP/1.0:客户端可以与web服务器连接后，只能获得一个web资源，断开连接

- HTTP/1.1：客户端可以与web服务器连接后，可以获得多个web资源。

## 2.3 HTTP请求

1. 请求流程

   客户端 -> 请求 -> 服务器

2. 请求行

- 请求方式：Get，Post ，HEAD，DELETE，PUT，TRACT...

  get：请求能够携带的参数比较少，大小有限制，会在浏览器的URL地址栏显示数据内容，不安全，但高效

  post：请求能够携带的参数没有限制，大小没有限制，不会在浏览器的URL地址栏显示数据内容，安全，但不高效。

```shell
# 请求地址
Request URL:https://www.baidu.com/   
# get方法/post方法
Request Method:GET   
# 状态码：200
Status Code:200 OK   
# 请求远程地址
Remote Address:182.61.200.7:443
```

3.  Request Headers

```shell
# Accept： 告诉浏览器，它所支持的数据类型
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
# Accept-Encoding: 告诉浏览器，它所支持的编码格式    GBK UTF-8 GB2312
Accept-Encoding: gzip, deflate, br
# Accept-Language：告诉浏览器，它的语言环境
Accept-Language: en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7
# cache-Control：缓冲控制
Cache-Control: max-age=0
# connection：告诉浏览器，请求完成是断开还是保持连接
Connection: keep-alive
# cookie信息
Cookie: BIDUPSID=58382D7E4D10E8C6A2B35C83A456AC39; PSTM=1603427760; BAIDUID=58382D7E4D10E8C6D5F71F52EA3805FB:FG=1; BD_UPN=12314753; COOKIE_SESSION=2_2_6_7_11_10_0_1_6_3_57_5_527823_527810_59_42_1612699866_1612699849_1612699807%7C9%23527771_13_1612699807%7C4; BD_HOME=1; H_PS_PSSID=33512_33242_33272_31253_33594_33570_33676_33392_26350; BA_HECTOR=818g24alak8g8la4rg1g4u5g80r
# Host：主机..../.
Host: www.baidu.com
Sec-Fetch-Dest: document
Sec-Fetch-Mode: navigate
Sec-Fetch-Site: none
Sec-Fetch-User: ?1
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36
```

## 2.4 HTTP响应

1. 响应流程

   服务器 -> 响应 -> 客户端

2. Response Headers

```shell
# Cache-Control:private 缓冲控制
Cache-Control: private
# Connection:keep-alive   连接
Connection: keep-alive
# Content-Encoding:gzip   编码
Content-Encoding: gzip
# Content-Type:text/html;charset=utf-8  编码类型
Content-Type: text/html;charset=utf-8
# 响应时间
Date: Mon, 15 Mar 2021 08:08:49 GMT
Expires: Mon, 15 Mar 2021 08:08:28 GMT
# 浏览器服务信息
Server: BWS/1.1
# cookie
Set-Cookie: BDSVRTM=0; path=/
Set-Cookie: BD_HOME=1; path=/
Set-Cookie: H_PS_PSSID=33512_33242_33272_31253_33594_33570_33676_33392_26350; path=/; domain=.baidu.com
Strict-Transport-Security: max-age=172800
Traceid: 1615795729356208871411616365730710296391
Transfer-Encoding: chunked
# 兼容性
X-Ua-Compatible: IE=Edge,chrome=1
```

3. 响应状态码

- 200：请求响应成功 200

- 3**：请求重定向 重新指定位置

- 4xx：找不到资源；404

- 5xx：服务器代码错误 500 502网关错误

# 3. Maven

## 3.1 Maven作用

1. 在JavaWeb中，需要使用大量的jar包，我们手动去导入；
2. 如何个够让一个东西自动帮我导入和配置这个jar包。
3. 由此，Maven诞生了！

## 3.2 Maven安装配置

1. Maven官网：https://maven.apache.org/
2. 下载Maven

<img src="C:\Users\YYKJ\AppData\Roaming\Typora\typora-user-images\image-20210315164112110.png" alt="image-20210315164112110" style="zoom:67%;" />

3. 解压完成  D:\apache-maven-3.6.3

4. Maven配置：设置环境变量  添加系统变量

   - M2_HOME： D:\apache-maven-3.6.3\bin  注释：此地址spring、springboot会使用

   - MAVEN_HOME： D:\apache-maven-3.6.3

   - path: %MAVEN_HOME%\bin

5. 验证安装： mvn -version 

6. 案例云镜像：D:\apache-maven-3.6.3\conf\settings.xml

```xml
<mirror>
	<id>nexus-aliyun</id>
	<mirrorOf>central</mirrorOf>
	<name>Nexus aliyun</name>
	<url>http://maven.aliyun.com/nexus/content/groups/public</url>
</mirror>
```

7. 本地仓库：D:\apache-maven-3.6.3\conf\settings.xml

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
	<localRepository>e:/MavenRepository</localRepository>
</settings>
```

## 3.3 IDEA-Maven

1. 启动idea
2. 创建一个maven项目 （可不使用模板）create from archetype 可以使用maven模板 可以选择webapp模板

<img src="C:\Users\YYKJ\AppData\Roaming\Typora\typora-user-images\image-20210315170029964.png" alt="image-20210315170029964" style="zoom: 50%;" />



3. 选择maven配置

<img src="C:\Users\YYKJ\AppData\Roaming\Typora\typora-user-images\image-20210315170202395.png" alt="image-20210315170202395" style="zoom:50%;" />



4. 完成创建

## 3.4 Maven-Tomcat

1. 创建项目不再是Java Enterprise了,而是先New 一个普通Java项目

2. 创建项目后,选择Run->Edit Configuration->左上角加号->Tomcat Server(注意不是TomEE)->Local

<img src="C:\Users\YYKJ\AppData\Roaming\Typora\typora-user-images\image-20210315172246050.png" alt="image-20210315172246050" style="zoom: 50%;" />

3. 点击Application server 右边的Configure,找到你放置的Tomcat的目录,点击OK

<img src="C:\Users\YYKJ\AppData\Roaming\Typora\typora-user-images\image-20210315174702945.png" alt="image-20210315174702945" style="zoom:50%;" />

4. 回到项目界面,右键项目名称->add framwork support->选中Web Application->默认勾选创建web.xml

<img src="https://img-blog.csdnimg.cn/20200810143446948.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNDQxMDc4,size_16,color_FFFFFF,t_70" alt="step5" style="zoom: 33%;" />

<img src="https://img-blog.csdnimg.cn/20200810143511221.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNDQxMDc4,size_16,color_FFFFFF,t_70" alt="step5.2" style="zoom: 33%;" />

5. 回到刚刚配置Tomcat的页面,选择第二个选项卡Deployment->右边的加号->选择Artifact…

<img src="https://img-blog.csdnimg.cn/20200810143757262.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNDQxMDc4,size_16,color_FFFFFF,t_70" alt="step6" style="zoom:33%;" />

<img src="C:\Users\YYKJ\AppData\Roaming\Typora\typora-user-images\image-20210315222945941.png" alt="image-20210315222945941" style="zoom: 33%;" />

6. 项目默认创建了一个index.jsp,你可以尝试启动看一下,右键run,启动需要时间

<img src="https://img-blog.csdnimg.cn/20200810144225812.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNDQxMDc4,size_16,color_FFFFFF,t_70" alt="step8" style="zoom:33%;" />



## 3.5 Maven命令行操作

1. clean（清理）
2. validate（验证）
3. compile（编译）
4. test（测试）
5. package（打包）
6. verify（核实）
7. install（安装）
8. site（设置）
9. deploy（部署）

## 3.6 Maven依赖 

> POM.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!-- 1.基本设置 The Basics -->
    <groupId>com.yykj</groupId>
    <artifactId>maven-project</artifactId>
    <version>1.0-SNAPSHOT</version>
    <!-- 打包方式 jar:java应用 war:java web引用 -->
    <packaging>...</packaging>
    <!-- 项目依赖 -->
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.20</version>
        </dependency>
    </dependencies>
    <!-- 父工程 -->
    <parent>...</parent>
    <!-- 模块信息 -->
    <modules>...</modules>
    <!-- 配置 -->
    <properties>
        <!-- 项目默认构建编码 -->
        <file.encoding>UTF-8</file.encoding>
        <!-- 编译版本 -->
        <java.source.version>1.8</java.source.version>
        <java.target.version>1.8</java.target.version>
    </properties>

    <!-- 2.构建过程的设置 Build Settings -->
    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.properties</include>
                </includes>
            </resource>

            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.properties</include>
                </includes>
            </resource>
        </resources>
    </build>

    <!-- 3.项目信息设置 More Project Information -->
    <!-- 名称 -->
    <name>...</name>
    <!-- 描述 -->
    <description>...</description>

    <!-- 环境设置 Environment Settings -->
    <issueManagement>...</issueManagement>
    <ciManagement>...</ciManagement>
    <mailingLists>...</mailingLists>
    <scm>...</scm>
    <prerequisites>...</prerequisites>
    <repositories>...</repositories>
    <pluginRepositories>...</pluginRepositories>
    <distributionManagement>...</distributionManagement>
    <profiles>...</profiles>
</project>
```

# 4. Servlet

## 4.1 Servlet简介

- Servlet就是sun公司开发动态web的一门技术
- sun公司在这些API中提供一个接口叫作：Servlet，如果你想开发一个Servlet程序，只需要完成两个小步骤：
  - 编写一个类，实现Servlet接口
  - 把开发好的java类部署道web服务器中。

- 把实现了Servlet接口的java程序叫做Servlet

## 4.2 HelloServlet

> 

1. 构建一个普通的maven项目，删掉里面的src目录。以后我们的学习就在这个项目里面建立Moudel；

2. 关于Maven父子工程的理解 

   父项目中会有一个

```xml
	<modules>
       <module>servlet-01</module>
	</modules>
```

​		子项目中会有一个

```xml
 	<parent>
        <artifactId>javaweb-02-servlet</artifactId>
        <groupId>com.dong</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
```

​	父项目中的java子项目可以直接使用

```
	son extends parents
```

3. Maven环境优化

- 修改web.xml为最新的

- 将maven的结构搭建完整

4. 编写一个Servlet程序

- 编写一个普通类 HelloServlet

- 实现Servlet接口，这里我们直接继承HTTPServlet

> Servlet接口Sun公司有两个默认的实现类：HttpServlet，GenericServlet

```java
public class HelloServlet extends HttpServlet {
    //由于get或者post只是请求实现的不同的方式，可以互相调用，业务逻辑都一样
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();//响应流
        writer.print("Hello,Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
```

5. 编写Servlet的映射

> 映射原因：我们写的是java程序，但是要通过浏览器访问，而浏览器需要连接web服务器，所以我们要在web服务中注册我们写的Servlet，还需给他一个浏
>
> 览器能够访问的路径；

```xml
<!-- 注册Servlet-->
<servlet>
    <servlet-name>hello</servlet-name>
    <servlet-class>com.dong.servlet.HelloServlet</servlet-class>
</servlet>
<!-- servlet的请求路径-->
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

6. 配置Tomcat

   注意：配置项目发布的路径就可以了

7. 启动测试

- 启动 tomcat 
- 浏览器：http://localhost:8080/hello

## 4.3 Servlet原理

> Servlet是由Web服务器调用，web服务器在收到浏览器请求之后，
>

<img src="C:\Users\YYKJ\AppData\Roaming\Typora\typora-user-images\image-20210316091128271.png" alt="image-20210316091128271" style="zoom:67%;" />

## 4.4 Mapping

1.  一个Servlet可以指定一个映射路径

```xml
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

2. 一个Servlet可以指定多个映射路径

```xml
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>

<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello1</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello2</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello3</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello4</url-pattern>
</servlet-mapping>
```

3.  一个Servlet可以指定通用映射路径

```xml
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello/*</url-pattern>
</servlet-mapping>
```

4. 默认请求路径

```xml
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/*</url-pattern>
</servlet-mapping>
```

5. 指定一些后缀或者前缀等待.....

```xml
 <!-- 可以自定义后缀实现请求映射注意点：*前面不能加项目映射的路径-->
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>
```

6.优先级问题

​	指定了固有的映射路径优先级最高，如果找不到就会走默认的处理请求；

## 4.5 ServletContext

1. 概述

   web容器在启动的时候，它会为每个web程序都创建一个对应的ServletContext对象，它代表了当前的web应用

2. 共享数据:在这个Servlet保存的数据，可以在另一个Servlet拿到

> 代码：javaweb-servlet-project： web.servlet.context

```java
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   //this.getInitParameter() 初始化参数
   //this.getServletConfig() Servlet配置
   //this.getServletContext() Servlet 上下文
    ServletContext context = this.getServletContext();
    String username="赵东";
    context.setAttribute("username",username);//将一个数据保存在了ServletContext中，名字为：username，值username

}
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext context = this.getServletContext();
    String username = (String) context.getAttribute("username");
    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf-8");
    resp.getWriter().print("名字"+username);
}
```

```xml
<servlet>
    <servlet-name>hello</servlet-name>
    <servlet-class>com.dong.servlet.HelloServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
<servlet>
    <servlet-name>getc</servlet-name>
    <servlet-class>com.dong.servlet.GetServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>getc</servlet-name>
    <url-pattern>/getc</url-pattern>
</servlet-mapping>
```

3. 获取初始化参数

```java
<!-- 配置一些web应用初始化参数-->
<context-param>
    <param-name>url</param-name>
    <param-value>jdbc:mysql://localhost:3306/mybatis</param-value>
</context-param>
        
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext context = this.getServletContext();
    String url=context.getInitParameter("url");
    resp.getWriter().print(url);
}
```

4. 请求转发

```java
ServletContext context = this.getServletContext();
System.out.println("进入了ServletDemo04");
//RequestDispatcher requestDispatcher = context.getRequestDispatcher("/demo");//转发的请求
//requestDispatcher.forward(req,resp);//调用forward实现请求转发
context.getRequestDispatcher("/demo").forward(req,resp);
```

5. 读取资源文件

Properties

- 在java目录下新建properties
- 在resources目录下新建properties

发现：都被打包到了同一个路径下：classes，我们俗称这个路径为类路径

思路：需要一个文件流

```
username=root
password=123456
```

```
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    InputStream in = this.getServletContext().getResourceAsStream("/target/classes/db.properties");
    Properties properties = new Properties();
    properties.load(in);
    String user = properties.getProperty("username");
    String pwd = properties.getProperty("password");
    resp.getWriter().print(user+":"+pwd);
}
```

## 4.5 HttpServletResponse

1. 概述	

   web服务器接收到客户端的http请求，针对这个请求，分别创建一个代表请求的HTTPServletRequest对象，代表响应的一个HTTPServletResponse；

   - 如果要获取客户端请求过来的参数：找HttpServletRequest
   - 如果要给客户端响应一些信息：赵HTTPServletResponse

2. 简单分类

- 负责向浏览器发送数据的方法

```java
ServletOutputStream getOutputStream() throws IOException;
PrintWriter getWriter() throws IOException;
```

- 负责向浏览器发送响应头的方法

```java
void setCharacterEncoding(String var1);
void setContentLength(int var1);
void setContentLengthLong(long var1);
void setContentType(String var1);响应的状态码
```

```java
int SC_CONTINUE = 100;
int SC_SWITCHING_PROTOCOLS = 101;
int SC_OK = 200;
int SC_CREATED = 201;
int SC_ACCEPTED = 202;
int SC_NON_AUTHORITATIVE_INRMATION = 203;
int SC_NO_CONTENT = 204;
int SC_RESET_CONTENT = 205;
int SC_PARTIAL_CONTENT = 206;
```

3. 下载文件

- 向浏览器输出消息

- 下载文件

```
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1. 要获取下载文件的路径
    String realPath="D:\\IDEA\\javaweb-02-servlet\\response\\src\\main\\resources\\1.jpg";
    System.out.println("下载文件的路径："+realPath);
    // 2. 下载的文件名是啥？
    String fileName=realPath.substring(realPath.lastIndexOf("\\")+1);
    // 3. 设置想办法让浏览器能够支持(Content-Disposition)下载我们需要的东西,中文文件名URLEncoder.encode编码，否则可能乱麻
    resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
    // 4. 获取下载文件的输入流
    FileInputStream in = new FileInputStream(realPath);
    // 5. 创建缓冲区
    int len=0;
    byte[] buffer= new byte[1024];
    // 6. 获取OutputStream对象
    ServletOutputStream out = resp.getOutputStream();
    // 7. 将FileOutputStream流写入到buffer缓冲区,使用OutputStream将缓冲区中的数据输出到客户端！
    while ((len=in.read(buffer))>0){
        out.write(buffer,0,len);
    }
    in.close();
    out.close();
}
```

4. 验证码功能

```
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //如何让浏览器3秒自动刷新一次
    resp.setHeader("refresh", "3");
    //在内存中创建一个图片
    BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
    //得到图片
    Graphics2D g = (Graphics2D) image.getGraphics();//笔
    //设置图片的背景颜色
    g.setColor(Color.white);
    g.fillRect(0, 0, 80, 20);
    //给图片写数据
    g.setColor(Color.BLUE);
    g.setFont(new Font(null, Font.BOLD, 20));
    g.drawString(makeNum(), 0, 20);
    //告诉浏览器，这个请求用图片的方式打开
    resp.setContentType("image/jpg");
    //网站存在缓冲，不让浏览器缓冲
    resp.setDateHeader("expires",-1);
    resp.setHeader("Cache-Control","no-cache");
    resp.setHeader("Pragma","no1-cache");
    //把图片写给浏览器
    ImageIO.write(image,"jpg",resp.getOutputStream());
}

    //生成随机数
    private String makeNum () {
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++) {
            sb.append("0");

        }
        num = sb.toString() + num;
        return num;
    }
```

5. 实现重定向

![image-20200614125256628]()

```
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       resp.setHeader("Location","/down");
//       resp.setStatus(302);
        resp.sendRedirect("/down");//重定向
    }
```

面试题：请你聊聊重定向和转发的区别？

相同点：

- 页面都会实现跳转

不同点

- 请求转发的时候，url不会产生变化
- 重定向的时候，url地址栏会产生变化

用户登陆：

```
void sendRedirect(String var1) throws IOException;
```

## 4.6 HttPServletRequest

​	HttPServletRequest代表客户端的请求，用户通过Http协议访问服务器，HTTP请求中的所有信息会被封装到HttPServletRequest，通过HttPServletRequest的方法，

获得客户端的所有信息。

1. 获取前端传递的参数

```
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String[] hobbys = req.getParameterValues("hobbys");
    System.out.println("===========================");
    System.out.println(username);
    System.out.println(password);
    System.out.println(Arrays.toString(hobbys));
    System.out.println("============================");
    //通过请求转发
    req.getRequestDispatcher("/success.jsp").forward(req,resp);
    resp.setCharacterEncoding("utf-8");
}
```

# 5. Cookie、Session

## 5.1 会话

1. 会话：用户打开一个浏览器，点击了很多超链接，访问多个web资源，关闭浏览器，这个过程可以称之为会话；
2. 有状态会话：Cookie 会话痕迹

## 5.2 保存会话的两种技术

1. cookie

   客户端技术 （响应，请求）

2. session

   服务器技术，利用这个技术，可以保存用户的会话信息？ 我们可以把信息或者数据放在Session中！

   常见常见：网站登录之后，你下次不用再登录了，第二次访问直接就上去了！

## 5.3 Cookie

1. 从请求中拿到cookie信息 服务器响应给客户端cookie

```java
Cookie[] cookies = req.getCookies(); //获得Cookie
cookie.getName(); //获得cookie中的key
cookie.getValue(); //获得cookie中的vlaue
new Cookie("lastLoginTime", System.currentTimeMillis()+""); //新建一个cookie
cookie.setMaxAge(24*60*60); //设置cookie的有效期
resp.addCookie(cookie); //响应给客户端一个cookie
```

2. cookie 特性

- 一般会保存在本地的 用户目录下 appdata
- 一个网站cookie是否存在上限！聊聊细节问题
- 一个Cookie只能保存一个信息；
- 一个web站点可以给浏览器发送多个cookie，最多存放20个cookie；
- Cookie大小有限制4kb；
- 300个cookie浏览器上限

3. 删除Cookie

- 不设置有效期，关闭浏览器，自动失效；
- 设置有效期时间为 0 ；

4. 编码解码

```java
URLEncoder.encode("秦疆","utf-8")
URLDecoder.decode(cookie.getValue(),"UTF-8")
```

# 6. Session

1. 什么是Session

- 服务器会给每一个用户（浏览器）创建一个Seesion对象；

- 一个Seesion独占一个浏览器，只要浏览器没有关闭，这个Session就存在；

- 用户登录之后，整个网站它都可以访问！–> 保存用户的信息；保存购物车的信息……

2. Session和cookie的区别

- Cookie是把用户的数据写给用户的浏览器，浏览器保存 （可以保存多个）
- Session把用户的数据写到用户独占Session中，服务器端保存 （保存重要的信息，减少服务器资源的浪费）
- Session对象由服务创建；

3. 使用场景：

- 保存一个登录用户的信息；
- 购物车信息；
- 在整个网站中经常会使用的数据，我们将它保存在Session中；

4. Session案例

```java
package com.kuang.servlet;

import com.kuang.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //解决乱码问题
    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=utf-8");
    
    //得到Session
    HttpSession session = req.getSession();
    //给Session中存东西
    session.setAttribute("name",new Person("秦疆",1));
    //获取Session的ID
    String sessionId = session.getId();

    //判断Session是不是新创建
    if (session.isNew()){
        resp.getWriter().write("session创建成功,ID:"+sessionId);
    }else {
        resp.getWriter().write("session以及在服务器中存在了,ID:"+sessionId);
    }

    //Session创建的时候做了什么事情；
    // Cookie cookie = new Cookie("JSESSIONID",sessionId);
    // resp.addCookie(cookie);
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req, resp);
	}    
}
```

5. 会话自动过期：web.xml配置

```xml
<!--设置Session默认的失效时间-->
<session-config>
    <!--15分钟后Session自动失效，以分钟为单位-->
    <session-timeout>15</session-timeout>
</session-config>
```

# 7. JSP

## 7.1 什么是JSP

​	1. Java Server Pages ： Java服务器端页面，也和Servlet一样，用于动态Web技术！

2. 特点与区别：

- 写JSP就像在写HTML
- HTML只给用户提供静态的数据
- JSP页面中可以嵌入JAVA代码，为用户提供动态数据；

## 7.2 JSP原理

> 思路：JSP到底怎么执行的！
>

1. 代码层面没有任何问题

2. 服务器内部工作

- tomcat中有一个work目录；

- IDEA中使用Tomcat的会在IDEA的tomcat中生产一个work目录

​         C:\Users\Administrator.IntelliJIdea2018.1\system\tomcat\Unnamed_javaweb-session-cookie\work\Catalina\localhost\ROOT\org\apache\jsp

- 发现页面转变成了Java程序！

- 浏览器向服务器发送请求，不管访问什么资源，其实都是在访问Servlet！

- JSP最终也会被转换成为一个Java类！

- JSP 本质上就是一个Servlet

```java
  //初始化
  public void _jspInit() {
 
  }

  //销毁
  public void _jspDestroy() {
  
  }

  //JSPService
  public void _jspService(.HttpServletRequest request,HttpServletResponse response){
      
  }
```

3. 内置一些对象

```java
final javax.servlet.jsp.PageContext pageContext;  //页面上下文
javax.servlet.http.HttpSession session = null;    //session
final javax.servlet.ServletContext application;   //applicationContext
final javax.servlet.ServletConfig config;         //config
javax.servlet.jsp.JspWriter out = null;           //out
final java.lang.Object page = this;               //page：当前
HttpServletRequest request                        //请求
HttpServletResponse response                      //响应
```

## 7.3 基础语法

	 1. JSP 作为java技术的一种应用，它拥有一些自己扩充的语法（了解，知道即可！），Java所有语法都支持！
  	 2. 基础语法汇总

```jsp
 <%%>        脚本片段
 <%=%>       变量或表达式
 <%!%>       声明
 <%----%>    注释
```

3. JSP表达式

```jsp
  <%--JSP表达式 作用：用来将程序的输出，输出到客户端
  	<%= 变量或者表达式%>
  --%>

  <%= new java.util.Date()%>
```

4. jsp脚本片段

```jsp
  <%--jsp脚本片段--%>
  <%
    int sum = 0;
    for (int i = 1; i <=100 ; i++) {
      sum+=i;
    }
    out.println("<h1>Sum="+sum+"</h1>");
  %>
```

5. 脚本片段的再实现

```jsp
 <%
    int x = 10;
    out.println(x);
  %>

  <p>这是一个JSP文档</p>

  <%
    int y = 2;
    out.println(y);
  %>
```

6. 在代码嵌入HTML元素

```jsp
  <%--在代码嵌入HTML元素--%>
  <%
    for (int i = 0; i < 5; i++) {
  %>

  <h1>Hello,World  <%=i%> </h1>

  <%
    }
  %>
```

7. JSP声明：会被编译到JSP生成Java的类中！其他的，就会被生成到_jspService方法中！

```jsp
<%!
    static {
      System.out.println("Loading Servlet!");
    }

    private int globalVar = 0;
    
    public void kuang(){
      System.out.println("进入了方法Kuang！");
    }
%>
```

## 7.4 JSP指令

```jsp
<%@page args.... %>

<%@include file="common/footer.jsp"%>

<%@include file="common/header.jsp"%>
```

## 7.5 内置对象

1. PageContext 存东西
2. Request 存东西
3. Response
4. Session 存东西
5. Application 【SerlvetContext】 存东西
6. config 【SerlvetConfig】
7. out
8. page ，不用了解
9. exception

```java
pageContext.setAttribute("name1","秦疆1号"); //保存的数据只在一个页面中有效
request.setAttribute("name2","秦疆2号"); //保存的数据只在一次请求中有效，请求转发会携带这个数据
session.setAttribute("name3","秦疆3号"); //保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
application.setAttribute("name4","秦疆4号");  //保存的数据只在服务器中有效，从打开服务器到关闭服务器
```

## 8.6 JSP标签、JSTL标签、EL表达式

1. 标签引用

```
<!-- JSTL表达式的依赖 -->
<dependency>
    <groupId>javax.servlet.jsp.jstl</groupId>
    <artifactId>jstl-api</artifactId>
    <version>1.2</version>
</dependency>
<!-- standard标签库 -->
<dependency>
    <groupId>taglibs</groupId>
    <artifactId>standard</artifactId>
    <version>1.1.2</version>
</dependency>
```

2. EL表达式： ${ }

- 获取数据
- 执行运算
- 获取web开发的常用对象

3. JSP标签

```
<jsp:include page="index.jsp"></jsp:include>

<jsp:forward page="index02.jsp"></jsp:forward>

...
```

4. JSTL表达式

​     JSTL标签库的使用就是为了弥补HTML标签的不足；它自定义许多标签，可以供我们使用，标签的功能和Java代码一样！

- 格式化标签

- SQL标签

- XML 标签

- 核心标签 （掌握部分）

# 8. JavaBean

> 实体类
>

1. JavaBean有特定的写法：

- 必须要有一个无参构造
- 属性必须私有化
- 必须有对应的get/set方法；
- 一般用来和数据库的字段做映射 ORM；

2. ORM ：对象关系映射

- 表—>类
- 字段–>属性
- 行记录---->对象

```
people表

id	name	age	address
1	秦疆1号	3	西安
2	秦疆2号	18	西安
3	秦疆3号	100	西安
class People{
    private int id;
    private String name;
    private int id;
    private String address;
}

class A{
    new People(1,"秦疆1号",3，"西安");
    new People(2,"秦疆2号",3，"西安");
    new People(3,"秦疆3号",3，"西安");
}
```

# 9. 过滤器

文件上传
邮件发送
JDBC 复习 ： 如何使用JDBC , JDBC crud， jdbc 事务

# 10. MVC三层架构

## 10.1 什么是MVC

​	Model view Controller 模型、视图、控制器

## 10.2 MVC三层架构

<img src="C:\Users\YYKJ\AppData\Roaming\Typora\typora-user-images\image-20210316212010962.png" alt="image-20210316212010962" style="zoom:67%;" />

1. Model

- 业务处理 ：业务逻辑（Service）
- 数据持久层：CRUD （Dao - 数据持久化对象）

2. View

- 展示数据
- 提供链接发起Servlet请求 （a，form，img…）

3. Controller （Servlet）

- 接收用户的请求 ：（req：请求参数、Session信息….）

- 交给业务层处理对应的代码

- 控制视图的跳转

## 10.3 执行流程

	1. 登录
 	2. 接收用户的登录请求
 	3. 处理用户的请求（获取用户登录的参数，username，password）
 	4. 交给业务层处理登录业务（判断用户名密码是否正确：事务）
 	5. Dao层查询用户名和密码是否正确
 	6. 数据库

# 11. Filter （重点）

> 比如 Shiro安全框架技术就是用Filter来实现的

<img src="C:\Users\YYKJ\AppData\Roaming\Typora\typora-user-images\image-20210316213903682.png" alt="image-20210316213903682" style="zoom: 67%;" />

## 11.1 Filter定义及作用

​	Filter：过滤器 ，用来过滤网站的**数据**；

- 处理中文乱码
- 登录验证….

## 11.2 Filter开发步骤

1. 导包

2. 编写过滤器 导包不要错 （注意）

3. 实现Filter接口，重写对应的方法即可

  ```java
  public class CharacterEncodingFilter implements Filter {
  
      //初始化：web服务器启动，就以及初始化了，随时等待过滤对象出现！
      public void init(FilterConfig filterConfig) throws ServletException {
          System.out.println("CharacterEncodingFilter初始化");
      }
  
      //Chain : 链
      /*
      1. 过滤中的所有代码，在过滤特定请求的时候都会执行
      2. 必须要让过滤器继续同行
          chain.doFilter(request,response);
       */
      public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
          request.setCharacterEncoding("utf-8");
          response.setCharacterEncoding("utf-8");
          response.setContentType("text/html;charset=UTF-8");
  
          System.out.println("CharacterEncodingFilter执行前....");
          chain.doFilter(request,response); //让我们的请求继续走，如果不写，程序到这里就被拦截停止！
          System.out.println("CharacterEncodingFilter执行后....");
      }
  
      //销毁：web服务器关闭的时候，过滤器会销毁
      public void destroy() {
          System.out.println("CharacterEncodingFilter销毁");
      }
  }
  
  ```
4. 在web.xml中配置 Filter 或者Filter配置注解：@WebFilter(urlPatterns = {"/*"})

```xml
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>com.kuang.filter.CharacterEncodingFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <!--只要是 /servlet的任何请求，会经过这个过滤器-->
    <url-pattern>/servlet/*</url-pattern>
    <!--<url-pattern>/*</url-pattern>-->
    <!-- 别偷懒写个 /* -->
</filter-mapping>
```

# 12. 监听器

> 被监听的对象（三个域对象 request，session，servletContext）

1. 实现一个监听器的接口；（有n种监听器）

2. 编写一个监听器

3. 依赖的jar包

> 统计网站在线人数 ： 统计session

1. 编写监听器

```java
@WebListener
public class ListenerOnline implements HttpSessionListener {

    /**
     * 一旦创建Session创建触发一次这个事件！
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {

        ServletContext context = se.getSession().getServletContext();

        int cnt = 0;
        Object online = context.getAttribute("online");
        if(online != null){
            cnt = Integer.parseInt(online.toString())  + 1;
        }
        else{
            cnt = 1;
        }

        context.setAttribute("online",cnt);
    }

    /**
     * 一旦创建Session销毁触发一次这个事件！
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        ServletContext context = se.getSession().getServletContext();

        int cnt = 0;
        Object online = context.getAttribute("online");
        if(online != null){
            cnt = Integer.parseInt(online.toString()) - 1;
            context.setAttribute("online",cnt);
        }
    }
}
```

2. web.xml中注册监听器 OR @WebListener

```xml
<!--注册监听器-->
<listener>
    <listener-class>com.kuang.listener.OnlineCountListener</listener-class>
</listener>
```



# 13. JDBC

1. 什么是JDBC ： Java连接数据库！

2. 需要jar包的支持：

- java.sql
- javax.sql
- mysql-conneter-java… 连接驱动（必须要导入）

3. 实验环境搭建

```sql
CREATE TABLE users(
    id INT PRIMARY KEY,
    `name` VARCHAR(40),
    `password` VARCHAR(40),
    email VARCHAR(60),
    birthday DATE
);

INSERT INTO users(id,`name`,`password`,email,birthday)
VALUES(1,'张三','123456','zs@qq.com','2000-01-01');
INSERT INTO users(id,`name`,`password`,email,birthday)
VALUES(2,'李四','123456','ls@qq.com','2000-01-01');
INSERT INTO users(id,`name`,`password`,email,birthday)
VALUES(3,'王五','123456','ww@qq.com','2000-01-01');

SELECT	* FROM users;
```

4. 导入数据库依赖

```xml
<!--mysql的驱动-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.47</version>
</dependency>
```

5. IDEA中连接数据库

> JDBC 固定步骤：

- 加载驱动

- 连接数据库,代表数据库

- 向数据库发送SQL的对象Statement : CRUD

- 编写SQL （根据业务，不同的SQL）

- 执行SQL

- 关闭连接（先开的后关）

> 示例1

```java
public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
 //1.加载驱动
    Class.forName("com.mysql.jdbc.Driver");
    //2.连接数据库,代表数据库
    Connection connection = DriverManager.getConnection(url, username, password);

    //3.向数据库发送SQL的对象Statement,PreparedStatement : CRUD
    Statement statement = connection.createStatement();

    //4.编写SQL
    String sql = "select * from users";

    //5.执行查询SQL，返回一个 ResultSet  ： 结果集
    ResultSet rs = statement.executeQuery(sql);

    while (rs.next()){
        System.out.println("id="+rs.getObject("id"));
        System.out.println("name="+rs.getObject("name"));
        System.out.println("password="+rs.getObject("password"));
        System.out.println("email="+rs.getObject("email"));
        System.out.println("birthday="+rs.getObject("birthday"));
    }

    //6.关闭连接，释放资源（一定要做） 先开后关
    rs.close();
    statement.close();
    connection.close();
}
```

> 示例2： 预编译SQL

```java
public class TestJDBC2 {
    public static void main(String[] args) throws Exception {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        //1.加载驱动
    Class.forName("com.mysql.jdbc.Driver");
    //2.连接数据库,代表数据库
    Connection connection = DriverManager.getConnection(url, username, password);

    //3.编写SQL
    String sql = "insert into  users(id, name, password, email, birthday) values (?,?,?,?,?);";

    //4.预编译
    PreparedStatement preparedStatement = connection.prepareStatement(sql);

    preparedStatement.setInt(1,2);//给第一个占位符？ 的值赋值为1；
    preparedStatement.setString(2,"狂神说Java");//给第二个占位符？ 的值赋值为狂神说Java；
    preparedStatement.setString(3,"123456");//给第三个占位符？ 的值赋值为123456；
    preparedStatement.setString(4,"24736743@qq.com");//给第四个占位符？ 的值赋值为1；
    preparedStatement.setDate(5,new Date(new java.util.Date().getTime()));//给第五个占位符？ 的值赋值为new Date(new java.util.Date().getTime())；

    //5.执行SQL
    int i = preparedStatement.executeUpdate();

    if (i>0){
        System.out.println("插入成功@");
    }

    //6.关闭连接，释放资源（一定要做） 先开后关
    preparedStatement.close();
    connection.close();
}
```