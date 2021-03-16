package com.yykj.servlet.servlet;

import com.yykj.servlet.dao.StudentDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 一、创建学生信息案例 未实现
 * 1.1 案例内容:
 * 1.1.1 提交学生信息 保存至数据库 显示成功页面
 * 1.2 程序执行步骤
 * 1.2.1 配置Tomcat：Deployment中的war包最好只包含一个项目输出（会将选择的所有war包进行统一处理）Application Context /
 * 1.2.2 启动Tomcat
 * 1.2.3 浏览器输入请求地址：http://localhost:8080/index.jsp
 * 1.2.4 提交
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StudentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("doGet()");
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		response.getWriter().print("doPost()");
		// TODO Auto-generated method stub
		String name = request.getParameter("inputName");
		int age = Integer.parseInt(request.getParameter("inputAge"));
		System.out.println("*************:" + name + "  " + age);
		
		StudentDao manager = new StudentDao();
		boolean result = manager.createStudent(name, age);
		System.out.println(result);
		request.setAttribute("result", result?true:false);
		if(result){
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
		else{
			response.encodeRedirectURL("/createstudent.jsp");
		}	
	}

}
