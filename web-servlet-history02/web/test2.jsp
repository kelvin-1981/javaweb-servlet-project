<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mfn" uri="/WEB-INF/tlds/myfunction.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<% request.setAttribute("A", "2222222222222"); %>
${requestScope.A}

</br>
${fn:toUpperCase("kelvin")}

</br>
${mfn:getMessage()} }

<c:out value="aaa" default=""></c:out>

<c:url value="/test.jsp">
	<c:param name="NM" value="kelvin"></c:param>
</c:url>

</br>
<c:set var="v" value="Hello"/>
<c:if test="${not empty v}">
	<c:out value="${v}"/>
</c:if>

</br>
<c:set var="score" value="10"/>
<c:choose>
	<c:when test="${score > 80}">优秀！</c:when>
	<c:when test="${score < 80 && score > 60}">良好！</c:when>
	<c:when test="${score < 60}">及格？</c:when>
</c:choose>

</br>
<c:forEach var="i" begin="1" end="5">
	<c:out value="${i}"/></br>
</c:forEach>

</br>
<%
	ArrayList list = new ArrayList();
	list.add("A");
	list.add("B");
	list.add("C");
	
	request.setAttribute("list", list);
%>
<c:forEach items="${list}" var="info">
	${info}<br>
</c:forEach>
</form>
</body>
</html>