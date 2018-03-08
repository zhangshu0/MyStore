<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--在error.jsp页面中必须加入<%@page isErrorPage=“true”%>才能进行错误处理 --%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册界面</title>
</head>
<c:set var="Path"
		value="${pageContext.request.contextPath}/User/userlist.action"
scope="application" />
<c:set var="contextPath"
		value="${pageContext.request.contextPath}/User/fileupload.action"
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
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					if (xmlHttp.responseText == "true") {
						document.getElementById("error").innerHTML = "用户名已被注册!".fontcolor("red");
					} else {
						document.getElementById("error").innerHTML = "用户名可用".fontcolor("green");
					}
				}
			};
			xmlHttp.open("post", "${Path}", true);
			xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			var username = document.getElementById("username").value;
			xmlHttp.send("username=" + username);
		}
		function checkRspassword() {
			var flag;
			//获取确认密码框里内容
			var rspassword = document.getElementsByName("repassword")[0].value;
			//获取密码框里内容
			var password = document.getElementsByName("password")[0].value;
			var oRepasswordSpan = document.getElementById("repasswordspan");
			if(rspassword == ""){
				oRepasswordSpan.innerHTML = "密码不能为空".fontcolor("red");
				flag = false;
			}else if (rspassword == password) {
				oRepasswordSpan.innerHTML = "正确".fontcolor("green");
				flag = true;
			} else {
				oRepasswordSpan.innerHTML = "错误".fontcolor("red");
				flag = false;
			}
			return flag;
		}

		//校验邮箱
		   function checkMail() {
	        var temp = document.getElementsByName("mail")[0].value;
	        var myreg = /(\S)+[@]{1}(\S)+[.]{1}(\w)+/;
	        if(temp!="")
	        {
	            if(!myreg.test(temp))
	            {
	                document.getElementById("mailspan").innerHTML="请输入有效的email!";
	                document.getElementById("mailspan").style.color="red";
	                temp="";
	                temp.focus();
	                return false;
	            }
	            else{
	                document.getElementById("mailspan").innerHTML="email可以使用";
	                document.getElementById("mailspan").style.color="green";
	            }
	        }
        }
		   function remove1() {
				document.getElementById("error").innerHTML = ""
			}
		   function remove2() {	
				document.getElementById("repasswordspan").innerHTML = ""
			}
		   function remove3() {
				document.getElementById("mailspan").innerHTML = ""
			}
	</script>
<body>
		<form action="${contextPath}" method="post" enctype="multipart/form-data">
			<h5>用户注册界面</h5>
			用户姓名:<input id="username" type="text" name="username" onblur="send()" onfocus="remove1()" />
			<span id="error"></span><br/> 
				
			用户密码:<input type="password" name="password" /> <span id="passwordspan"></span><br />
	
			确认密码:<input type="password" name="repassword" onblur="checkRspassword()" onfocus="remove2()" />
			<span id="repasswordspan" ></span><br /> 
			
			邮箱地址:<input type="text"	name="mail" onblur="checkMail()" onfocus="remove3()" /> <span id="mailspan"></span><br />

			收货地址:<input type="text" name="address" value="*可选填" onfocus="javascript:if(this.value=='*可选填')this.value='';"/><br /> 
			
			添加头像:<input type="file" name="imagefile" value="点此添加文件"/><br /> 
			<input type="submit" value="注册" />
			
		</form>
</body>
</html>