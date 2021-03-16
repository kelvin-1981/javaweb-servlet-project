package com.yykj.encoding.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 一、需求: 通过Filter进行编码转换
 * 二、程序执行步骤
 * 1 配置Tomcat：Deployment中的war包最好只包含一个项目输出（会将选择的所有war包进行统一处理）Application Context /
 * 2 启动Tomcat
 * 3 浏览器输入请求地址：http://localhost:8080/encoding.do
 */
@WebFilter(urlPatterns = {"/*"})
public class FilterCharacterEncoding implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter: init() ...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletRequest.setCharacterEncoding("utf-8");

        System.out.println("Filter:doFilter()...");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter: destroy() ...");
    }
}
