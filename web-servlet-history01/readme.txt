一、AServlet案例
1. 启动tomcat（完成tomcat前期配置）
2. 浏览器：http://localhost:8080/AServlet
3. 控制台打印Servlet & Filter 的生命周期过程信息

二、BServlet案例
2.1 案例内容:
2.2.1 @WebServlet("/BServlet")注解使用（不用再web.xml映射）
2.2.2 实现数字计算
2.2 程序执行步骤
2.2.1 配置Tomcat：Deployment中的war包最好只包含一个项目输出（会将选择的所有war包进行统一处理）Application Context /
2.2.2 启动Tomcat
2.2.3 浏览器输入请求地址：http://localhost:8080/index.jsp
2.2.4 提交

三、BasicServlet案例
3.1 案例内容:
3.2.1 实现servlet service方法
3.2 程序执行步骤
3.2.1 配置Tomcat：Deployment中的war包最好只包含一个项目输出（会将选择的所有war包进行统一处理）Application Context /
3.2.2 启动Tomcat
3.2.3 浏览器输入请求地址：http://localhost:8080/BasicServlet?method=addUser
3.2.4 service方法根据参数进行逻辑处理