package com.yykj.servlet.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 一、程序执行步骤
 * 1. 配置Tomcat：Deployment中的war包最好只包含一个项目输出（会将选择的所有war包进行统一处理）Application Context: /
 * 2. 启动Tomcat
 * 3. 浏览器输入请求地址：http://localhost:8080/AServlet
 */
public class AServlet implements Servlet {
	
	ServletConfig config = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("AServlet:destroy()");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("AServlet:getServletConfig()");
		
		return this.config;
	}

	

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig sConfig) throws ServletException {
		
		
		this.config = sConfig;
		
		// TODO Auto-generated method stub
		System.out.println("AServlet:init()");
		
		Enumeration<String> emnum = sConfig.getInitParameterNames();
		while(emnum.hasMoreElements()){
			String pName = emnum.nextElement();
			String pValue = sConfig.getInitParameter(pName);
			System.out.println(pName + ":" + pValue);
		}
		
		ServletContext sContext = sConfig.getServletContext();
		System.out.println("sContext" + sContext);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AServlet:service()");
		
	}

}
