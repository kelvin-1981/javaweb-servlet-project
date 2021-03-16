package com.yykj.cookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 一、需求: 通过Cookie进行登录时间的记录及获取
 * 二、程序执行步骤
 * 1 配置Tomcat：Deployment中的war包最好只包含一个项目输出（会将选择的所有war包进行统一处理）Application Context /
 * 2 启动Tomcat
 * 3 浏览器输入请求地址：http://localhost:8080/cookie
 */
@WebServlet("/cookie")
public class ServletCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: 1.解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();
        writer.print("Last visit time is : ");

        // TODO: 2.处理Cookie信息
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie info: cookies){
                if(info.getName().equals("lastTime")){
                    long longTime = Long.parseLong(info.getValue());
                    writer.println(new Date(longTime).toLocaleString());
                    break;
                }
            }
        }
        else{
            writer.println("First visit web ...");
        }

        Cookie cookie = new Cookie("lastTime", System.currentTimeMillis() + "");
        cookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
