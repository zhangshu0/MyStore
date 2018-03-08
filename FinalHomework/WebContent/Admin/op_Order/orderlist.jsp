<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.ZhangShuo.Entity.Cart_details"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<c:if test="${not empty orderlist}">
			<c:forEach items="${orderlist}" var="orderlist">
				<tr>
					<th>商品名称</th>
					<th>商品单价</th>
					<th>购买数量</th>
					<th>单件商品总价</th>
				</tr>
				<c:set var="sum" value="0.0" />
				<c:forEach items="${orderlist.map_details}" var="details">
					<tr>
						<td>${details.key.book_name }</td>
						<td>${details.key.book_price }￥</td>
						<td>${details.value}</td>
						<td>${details.key.book_price*details.value}￥</td>

						<c:set var="temp" value="${details.key.book_price*details.value}" />
						<c:set var="sum" value="${sum+temp}" />
					</tr>
				</c:forEach>
				<tr>
					<td>收货地址:</td>
					<td>${orderlist.address}</td>
				</tr>
				<tr>
					<td>下单时间:</td>
					<td>${orderlist.create_time}</td>
					<td>
						<form action="ToupdateOrder.action" method="post">
							<input type="hidden" name="order_id" value="${orderlist.proxy_id}" /> 
							<input type="submit" value="修改" />
						</form>
						<form action="deleteOrder.action" method="post">
							<input type="hidden" name="order_id" value="${orderlist.proxy_id}" /> 
							<input type="hidden" name="address" value="${orderlist.address}" /> 
							<input type="submit" value="删除" />
						</form>
					</td>
				</tr>
				<tr>
					<td>总价</td>
					<td>${sum}￥</td>
				</tr>

			</c:forEach>
		</c:if>
		<c:if test="${empty orderlist}">
			<h5>该用户当前还未创建订单~</h5>
		</c:if>
	</table>
	<a href="op_OrdershowUser.action">返回继续操作</a>
</body>
</html>