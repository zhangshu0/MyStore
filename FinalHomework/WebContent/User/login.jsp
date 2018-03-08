<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = (String) session.getAttribute("registMessage");
		session.removeAttribute("registMessage");
		if (msg != null) {
	%>
	<script>
	alert('<%=msg%>')
	</script>
	<%
		}
	%>
	<c:set var="contextPath"
		value="${pageContext.request.contextPath}/User/userlogin.action"
		scope="application" />
	<c:set var="registPath"
		value="${pageContext.request.contextPath}/User/regist.jsp"
		scope="application" />
	<form action="${contextPath}" method="post">
		<h5>用户登录</h5>
		姓名:<input id="username" type="text" name="username" /> <br /> 密码:<input
			id="password" type="password" name="password" /><br /> <input
			type="submit" onclick="send()" value="登录" /> <a href="${registPath}">注册</a>
			<br/>
			
			
	</form>

</body>
</html>