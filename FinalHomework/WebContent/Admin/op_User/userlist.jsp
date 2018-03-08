<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	double d = Math.random();
	String flag = Double.toString(d);
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
%>
<script>
	alert('<%=msg%>')
</script>
<%
	}
%>
<body>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>用户名</th>
			<th>email</th>
			<th>收货地址</th>
			<th>头像</th>
		</tr>
		<c:forEach items="${userlist}" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td>${user.email }</td>
				<td>${user.address }</td>
				<td><img src="${user.head_portrait }" width="50px" height="50px"/></td>
				<td>
					<form action="ToupdateUser.action" method="post">
						<input type="hidden" name="user_id" value="${user.id}" /> <input
							type="hidden" name="username" value="${user.username }" /> <input
							type="hidden" name="email" value="${user.email }" /> <input
							type="hidden" name="address" value="${user.address}" /> <input
							type="hidden" name="head_portrait" value="${user.head_portrait}" /><input
							type="hidden" name="password" value="${user.password}" /> <input
							type="submit" value="更新" />
					</form>
					<form action="deleteUser.action" method="post">
						<input type="hidden" name="user_id" value="${user.id}" /> <input
							type="hidden" name="flag" value="<%=flag%>"> <input
							type="submit" value="删除" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="success.jsp">返回主页</a>
</body>
</html>