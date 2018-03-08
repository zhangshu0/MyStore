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
<form action="updateProduct.action" method="post">
	书名:<input type="text" name="book_name" value="${book_name}" onfocus="if(this.value==${book_name}){this.value=''}"/><br/>
	作者:<input type="text" name="book_auth" value="${book_auth}" onfocus="if(this.value==${book_auth}){this.value=''}"/><br/>
	价格:<input type="text" name="book_price" value="${book_price}" onfocus="if(this.value==${book_price}){this.value=''}"/><br/>
	出版社:<input type="text" name="book_publisher" value="${book_publisher}" onfocus="if(this.value==${book_publisher}){this.value=''}"/><br/>
	<input type="hidden" name="book_id" value="${book_id}"/>
	<label>类型</label> 
		<select name="types_id"> 
			<c:forEach items="${bookTypelist}" var="book_type">
			<option value="${book_type.types_id }">${book_type.types_name }</option>
			</c:forEach>
		</select> 
		<input type="hidden" name="flag" value="<%=flag%>">
		<input type="submit" value="提交">
</form>
</body>
</html>