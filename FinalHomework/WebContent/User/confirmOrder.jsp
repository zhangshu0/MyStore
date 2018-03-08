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
		String msg = (String) session.getAttribute("message");
		session.removeAttribute("message");
		if (msg != null) {
	%>
	<script>
	alert('<%=msg%>')
	</script>
	<%
		}
	%>
<script type="text/javascript">
	function check() {
		var temp = document.getElementsByName("address")[0].value;
		if (temp == "") {
			document.getElementById("msg").innerHTML = "请输入有效的收货地址!";
			document.getElementById("msg").style.color = "red";
			temp = "";
			temp.focus();
			return false;
		} else {
			document.getElementById("msg").innerHTML = "收货地址可使用!";
			document.getElementById("msg").style.color = "green";
			return true;
		}
	}
	function remove() {
		document.getElementById("msg").innerHTML = ""
	}
</script>
<body>
	<table border=1>
		<tr>
			<th>商品名称</th>
			<th>商品单价</th>
			<th>购买数量</th>
			<th>单件商品总价</th>
		</tr>
		<c:set var="sum" value="0.0" />
		<c:forEach items="${details}" var="details">
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
			<td>总价</td>
			<td>${sum}￥</td>
		</tr>
	</table>
	<form action="saveOrder.action" method="post">
		收货地址:<input type="text" name="address" value="${requestScope.address}"
			onblur="check()" onclick="remove()"> <span id="msg"></span> <input
			type="hidden" name="totalPrice" value="${sum}" /> <br/>
			<input type="submit" value="确认订单"></input>
	</form>
</body>
</html>