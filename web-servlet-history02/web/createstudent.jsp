<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="/StudentServlet" method="post">
    姓名：<input type="text" name="inputName" value="oscar"></br>
    年龄：<input type="text" name="inputAge" value="20"></br>
    <input type="submit" value="提交">

    <c:choose>
        <c:when test="${result == true }">保存成功！</c:when>
        <c:when test="${result == false }">保存失败！</c:when>
    </c:choose>

</form>
</body>
</html>