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
<title>购物车页面</title>
<c:set var="contextPath"
	value="${pageContext.request.contextPath}/User/Cart.action"
	scope="application" />
<script type="text/javascript">
function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();
	} catch (e) {
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
}
function send() {
		$(".details").each(function(){ 
		    var tmp=$(this).children().eq(6); 
		    var btn=tmp.children(); 
		    btn.bind("onblur",function(){ 
		        var number=btn.parent().parent().children("td").get(3).val(); 
		        var book_id=btn.parent().parent().children("td").get(6).val();
		        alert("number="+number+" book_id="+book_id); 
		        }); 
		    }); 
	var xmlHttp = createXMLHttpRequest();
	xmlHttp.open("post", "${Path}", true);
	xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xmlHttp.send("number="+number+"&book_id="+book_id+"&action=add");
}
</script>
</head>


<body>
	<h1>我的购物车</h1>
	<a href="booklist.action">首页</a> >>
	<a href="cart.jsp">购物车列表</a>
	<hr>
	<c:if test="${not empty details}">
		<table>
			<c:set var="sum" value="0.0" />
			<tr>
				<th>商品名称</th>
				<th>商品单价</th>		
				<th>购买数量</th>
				<th>商品总价</th>
				<th>操作</th>
			</tr>
			<c:set var="sum" value="0.0" />
			<c:forEach items="${details}" var="details">
				<tr class="details">
					<td>${details.key.book_name }</td>
					<td>${details.key.book_price }￥</td>
					<td><input type="text" name="number" value="${details.value}" style="width:20px;" onchange="this.value=parseInt(this.value);if (isNaN(this.value) || this.value<=0){alert('输入错误');this.focus();};"/></td>
					<td>${details.key.book_price*details.value}￥</td>
					<c:set var="temp" value="${details.key.book_price*details.value}" />
					<c:set var="sum" value="${sum+temp}" />
					<td>
						<form action="Cart.action" method="post">
							<input type="hidden" name="book_id"
								value="${details.key.book_id}"></input> <input type="hidden"
								name="action" value="delete"></input> <input type="submit"
								value="删除"></input>
						</form>
					</td>
					<td><input type="hidden" name="book_id" value="${details.key.book_id }"/></td>
				</tr>
			</c:forEach>
			<tr>
				<td>总价</td>
				<td>${sum}￥</td>
			</tr>
		</table>
		<a href="Cart.action?action=deleteAll">清空购物车</a>
		<form action="saveCart.action">
			<input type="submit" value="保存购物车" />
		</form>
		<hr>
		<form action="CreateOrder.action">
			<input type="submit" value="生成订单" />
		</form>
	</c:if>
	<c:if test="${empty details}">
			购物车空空如也~
			<a href="booklist.action">继续购物</a>
	</c:if>
</body>
</html>