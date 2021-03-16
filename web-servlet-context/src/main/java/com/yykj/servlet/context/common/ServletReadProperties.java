package com.yykj.servlet.context.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * ServletContext: web容器在启动的时候，它会为每个web程序都创建一个对应的ServletContext对象，它代表了当前的web应用
 * ServletContext 读取配置文件
 */
public class ServletReadProperties extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        InputStream ins = context.getResourceAsStream("/WEB-INF/dbconfig.properties");

        Properties prop = new Properties();
        prop.load(ins);

        String userName = prop.getProperty("username");
        String password = prop.getProperty("password");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("userName: " + userName);
        writer.println("password: " + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
