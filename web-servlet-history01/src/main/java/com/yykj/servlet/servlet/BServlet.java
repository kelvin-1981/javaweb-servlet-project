package com.yykj.servlet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 一、案例内容:
 * 1. @WebServlet("/BServlet")注解使用（不用再web.xml映射）
 * 2. 实现数字计算
 *
 * 二、程序执行步骤
 * 1. 配置Tomcat：Deployment中的war包最好只包含一个项目输出（会将选择的所有war包进行统一处理）Application Context: /
 * 2. 启动Tomcat
 * 3. 浏览器输入请求地址：http://localhost:8080/index.jsp
 * 4. 提交
 */
@WebServlet("/BServlet")
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num1 = Integer.parseInt(request.getParameter("inputNum1"));
		int num2 = Integer.parseInt(request.getParameter("inputNum2"));
		
		request.setAttribute("result", num1 + num2);
		request.getRequestDispatcher("/result.jsp").forward(request,response);
	}
}
