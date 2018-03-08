<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎管理员:${sessionScope.admin.username}!
<br/>
<a href="showProduct.action">管理商品</a>
<br/>
<a href="op_OrdershowUser.action">管理订单</a>
<br/>
<a href="showUser.action">管理用户</a>
</body>
</html>