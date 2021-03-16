package com.yykj.servlet.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 一、案例内容:
 * 1. 实现servlet service方法
 *
 * 二、程序执行步骤
 * 1. 配置Tomcat：Deployment中的war包最好只包含一个项目输出（会将选择的所有war包进行统一处理）Application Context: /
 * 2. 启动Tomcat
 * 3. 浏览器输入请求地址：http://localhost:8080/BasicServlet?method=addUser
 * 4. service方法根据参数进行逻辑处理
 */
@WebServlet("/BasicServlet")
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * service
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pMethod = request.getParameter("method");
		System.out.println("获取参数:*********************" + pMethod);
		if(pMethod.equalsIgnoreCase("addUser")){
			this.addUser(request, response);
		}
		else if(pMethod.equalsIgnoreCase("updateUser")){
			this.updateUser(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("addUser()");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("updateUser()");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("deleteUser()");
	}
	
}
