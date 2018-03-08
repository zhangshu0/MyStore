<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%double d = Math.random();
String flag = Double.toString(d);
%>
<form action="updateUser.action" method="post">
	地址:<input type="text" name="address" value="${address}" onfocus="if(this.value==${address}){this.value=''}"/>
		<input type="hidden" name="user_id" value="${user_id}"/>
		<input type="hidden" name="username" value="${username}"/>
		<input type="hidden" name="email" value="${email}"/>
		<input type="hidden" name="head_portrait" value="${head_portrait}"/>
		<input type="hidden" name="password" value="${password}"/>
		<input type="hidden" name="flag" value="<%=flag%>">
		<input type="submit" value="提交">
</form>
</body>
</html>