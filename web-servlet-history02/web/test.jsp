<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="com.yykj.websimple.rule.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	Student bean = new Student();
	BeanUtils.setProperty(bean, "name", "kelvin");
	BeanUtils.setProperty(bean, "age", 30);
	
	out.print(BeanUtils.getProperty(bean, "name") + " " + bean.getAge());


// 	HttpSession sess = request.getSession();
//     sess.setAttribute("S1", "111111111111111111");
    
// 	Cookie cook1 = new Cookie("a","AAAAAAAAAAAAAAAAAAAAA");
// 	response.addCookie(cook1);
	
// 	Cookie cook2 = new Cookie("b","BBBBBBBBBBBBBBBBBBBBB");
// 	response.addCookie(cook2);
%>

</head>
<body>
<%
// 	String sessVal = (String)sess.getAttribute("S1");
// 	out.print("[Java] S1:" + sessVal + "</br>");

// 	Cookie[] cookies = request.getCookies();
// 	for(Cookie info : cookies){
// 		out.print(info.getName() + ":" +  info.getValue() + "</br>");
// 	}
%>
</body>
</html>