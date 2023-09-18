<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <jsp:include page="./Footer.jsp"></jsp:include>
	
	<% String msg=(String)request.getParameter("msg");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#submit {
	background-color: #333;
	color: white;
	width: 80px;
	margin-top: 10px;
}
h2{
color: #333;
margin-top: 50px;}
</style>
</head>
<body>

	<div align="center">
		<h2>Create Admin Account<h2>
			
			<form action="./createAccount" method="post">
				<table>
					<tr>
						<td>userName</td>
						<td>
						<input type="text" name="username">
						</td>
					</tr>
					<tr>
						<td>password</td>
						<td> <input type="text" name="password"> </td>
					</tr>
				</table>
				<input type="submit" value="CREATE"/>
			</form>
		
	</div>


</body>
</html>