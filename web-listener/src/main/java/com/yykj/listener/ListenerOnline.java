package com.yykj.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 一、需求: 通过SessionListener进行在线人数统计
 * 二、程序执行步骤
 * 1 配置Tomcat：Deployment中的war包最好只包含一个项目输出（会将选择的所有war包进行统一处理）Application Context /
 * 2 启动Tomcat
 * 3 浏览器输入请求地址：http://localhost:8080/index.jsp
 */
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
