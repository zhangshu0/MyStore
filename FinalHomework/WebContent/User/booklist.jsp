<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*"%>
<%@ page import="com.ZhangShuo.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String registMessage = (String) request.getAttribute("registMessage");
		double d = Math.random();
		String flag = Double.toString(d);
		request.removeAttribute("registMessage");
		if (registMessage != null) {
	%>
	<script>
		alert('<%=registMessage%>')
	</script>
	<%
		}
	%>
	<c:set var="contextPath"
		value="${pageContext.request.contextPath}/User/login.jsp"
		scope="application" />
		<c:set var="contextPath1"
		value="${pageContext.request.contextPath}/User/changePassword.jsp"
		scope="application" />
		<c:set var="contextPath2"
		value="${pageContext.request.contextPath}/User/booklist.action"
		scope="application" />
		<c:set var="contextPath3"
		value="${pageContext.request.contextPath}/User/Cart.action"
		scope="application" />
	<c:choose>
		<c:when test="${empty sessionScope.user}">

		<a href="${contextPath}">登录</a>
		</c:when>
		<c:otherwise>
		欢迎您：${sessionScope.user.username} 
		<img alt="头像" src="${sessionScope.user.head_portrait}" height="50px"
				width="50px" />
			<a href="${contextPath1}">修改密码</a>
			<a href="quitlogin.action">退出登录</a>
		</c:otherwise>
	</c:choose>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>图书名称</th>
			<th>图书作者</th>
			<th>图书价格</th>
			<th>图书出版社</th>
		</tr>
		<c:forEach items="${sublist}" var="book">
			<tr>
				<td>${book.book_id }</td>
				<td>${book.book_name }</td>
				<td>${book.book_auth }</td>
				<td>${book.book_price }</td>
				<td>${book.book_publisher }</td>
				<td>
					<form action="${contextPath3}" method="post">
						<input type="hidden" name="page" value="${page.current_page}"></input>
						<input type="hidden" name="book_id" value="${book.book_id}"></input>
						<input type="hidden" name="action" value="add"></input> 
						<input type="hidden" name="flag" value="<%=flag%>"></input>
						<input type="hidden" name="number" value=1></input> 
						<input type="submit" value="添加至购物车"></input>
					</form>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><c:if
					test="${page != null && page.page_count > 1 }">
					<a href="${contextPath2}?current_page=1">首页</a>&nbsp;&nbsp;
				<c:if test="${page.current_page > 1 }">
						<a href="${contextPath2}?current_page=${page.current_page - 1 }">上一页</a>&nbsp;&nbsp;
				</c:if>
					<c:if test="${page.current_page != page.page_count }">
						<a href="${contextPath2}?current_page=${page.current_page + 1 }">下一页</a>&nbsp;&nbsp;
				</c:if>
					<a href="${contextPath2}?current_page=${page.page_count }">尾页</a>
				</c:if></td>
		</tr>



	</table>
	<a href="${contextPath3}?action=show">跳转至购物车</a>
</body>
</html>