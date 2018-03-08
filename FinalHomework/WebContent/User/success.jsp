<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎您：${sessionScope.user.username} 
<img alt="头像" src="${sessionScope.user.head_portrait}" height="50px" width="50px"/> 
<br/>
<a href="booklist.action">点此购物</a>
<br/>
<a href="showOrder.action">查看订单</a>
</body>
</html>