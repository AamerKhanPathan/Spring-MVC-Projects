<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String msg = (String) request.getAttribute("msg");
%>
<jsp:include page="./Header.jsp"></jsp:include>
<jsp:include page="./Footer.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
input {
	border: none;
	border-bottom: 0.5px solid #333;
	outline: none;
}

tr {
	margin-top: 20px;
}

a {
	text-decoration: none;
	color: white;
}

button {
	margin-top: 70px;
	background-color: #333;
	padding: 4px;
}

#submit {
	background-color: #333;
	color: white;
	width: 80px;
	margin-top: 10px;
}

#main {
	margin-top: 140px;
	height: auto;
	width: auto;
	align: center;
}
</style>
</head>
<body>
	<div id="main" align="center">


		<form action="./login" method="post">
			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" autofocus="autofocus">
					</td>

				</tr>

				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<input id="submit" type="submit" value="login">
		</form>

		<button>
			<a href="./createAccount">Create Account</a>
		</button>
		<br> <br>
		<%
		if (msg != null) {
		%>
		<h1><%=msg%></h1>
		<%
		}
		%>
	</div>






</body>
</html>