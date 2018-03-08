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
					<form action="ToupdateProduct.action" method="post">
						<input type="hidden" name="book_id" value="${book.book_id}" /> 
						<input type="hidden" name="book_name" value="${book.book_name }" />
						<input type="hidden" name="book_auth" value="${book.book_auth}" /> 
						<input type="hidden" name="book_price" value="${book.book_price}" />
						 <input type="hidden" name="book_publisher" value="${book.book_publisher}" /> 
						 <input type="submit" value="更新" />
					</form>
					<form action="deleteProduct.action" method="post">
						<input type="hidden" name="book_id" value="${book.book_id}" /> <input
							type="hidden" name="flag" value="<%=flag%>"> <input
							type="submit" value="删除" />
					</form>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><c:if
					test="${page != null && page.page_count > 1 }">
					<a href="showProduct.action?current_page=1">首页</a>&nbsp;&nbsp;
				<c:if test="${page.current_page > 1 }">
						<a
							href="showProduct.action?current_page=${page.current_page - 1 }">上一页</a>&nbsp;&nbsp;
				</c:if>
					<c:if test="${page.current_page != page.page_count }">
						<a
							href="showProduct.action?current_page=${page.current_page + 1 }">下一页</a>&nbsp;&nbsp;
				</c:if>
					<a href="showProduct.action?current_page=${page.page_count }">尾页</a>
				</c:if></td>
		</tr>
	</table>
	<a href="op_Product/addProduct.jsp">添加商品</a>
	<br />
	<a href="showProduct_Type.action">管理商品种类</a>
	<br />
	<a href="success.jsp">返回主页</a>
</body>
</html>