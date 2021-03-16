package com.yykj.servlet.context.share;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext: web容器在启动的时候，它会为每个web程序都创建一个对应的ServletContext对象，它代表了当前的web应用
 *
 * ServletContext共享数据
 * 一.执行步骤
 * 1. 启动tomcat
 * 2. 属性赋值: http://localhost:8080/set
 * 3. 属性值输出: http://localhost:8080/get
 */
public class ServletGetAttribute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: 读取属性
        ServletContext context = this.getServletContext();
        String name = context.getAttribute("user").toString();
        // TODO: 输出
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
