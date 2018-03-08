<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="updateProduct_Type.action" method="post">
	类型名:<input type="text" name="types_name" value="${types_name}" onfocus="if(this.value==${types_name}){this.value=''}"/><br/>
	<input type="hidden" name="types_id" value="${types_id}"/>
	<input type="hidden" name="flag" value="<%=flag%>">
		<input type="submit" value="提交">
</form>
</body>
</html>