package com.yykj.servlet.response.common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Response: Web服务器接收到客户端的http请求，针对这个请求，分别创建一个代表请求的HTTPServletRequest对象，代表响应的一个HTTPServletResponse
 * Response 重定向
 */
public class ServletRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: 重定向
        resp.sendRedirect("/val");

        // TODO: 替换实现方法
        //resp.setHeader("Location","/down");
        //resp.setStatus(203);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
