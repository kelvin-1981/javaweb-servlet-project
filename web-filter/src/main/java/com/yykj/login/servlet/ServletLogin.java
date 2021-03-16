package com.yykj.login.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 一、需求: 通过Filter进行登录验证，登录过进入主页，否则不能进入
 * 二、程序执行步骤
 * 1 配置Tomcat：Deployment中的war包最好只包含一个项目输出（会将选择的所有war包进行统一处理）Application Context /
 * 2 启动Tomcat
 * 3 浏览器输入请求地址：http://localhost:8080/login/login.jsp
 */
@WebServlet("/login.do")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if(username.equals("admin")){
            req.getSession().setAttribute("USER_SESSION",req.getSession().getId());
            resp.sendRedirect("/login/success.jsp");
        }
        else{
            resp.sendRedirect("/login/fail.jsp");
        }
    }
}
