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
<%
double d = Math.random();
String flag = Double.toString(d);
		String msg = (String)request.getAttribute("msg");
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
			<th>图书种类</th>
		</tr>
		<c:forEach items="${Type_sublist}" var="type">
			<tr>
				<td>${type.types_id }</td>
				<td>${type.types_name }</td>
				<td>
					<form action="ToupdateProduct_Type.action" method="post">
						<input type="hidden" name="types_id" value="${type.types_id }"/>
						<input type="hidden" name="types_name" value="${type.types_name }"/>
						<input type="submit" value="更新"/>
					</form>
					<form action="deleteProduct_Type.action" method="post"> 
						<input type="hidden" name="types_id" value="${type.types_id }"/>
							<input type="hidden" name="flag" value="<%=flag%>">
						<input type="submit" value="删除"/>
					</form>
				</td>
			</tr>
		</c:forEach>
		</table>
	<a href="op_Product/addProduct_Type.jsp">添加种类</a>
	<br />
	<a href="success.jsp">返回主页</a>
</body>
</html>