<%@page import="java.util.List"%>
<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./NavBar.jsp"></jsp:include>
 <jsp:include page="./Footer.jsp"></jsp:include>
<%
String msg = (String) request.getAttribute("msg");

StudentPOJO student=(StudentPOJO)request.getAttribute("student");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

h2{
  margin: auto;
  margin-top: 30px;
  color: #333;
  margin-bottom: 30px;   
}
.over-flow{
margin-top: 50px;
}

#submit {
	background-color: #333;
	color: white;
	width: 80px;
	margin-top: 10px;
}
</style>
</head>
<body>


	<div align="center">
	<h2>Search Strudents record</h2>
		
			<form action="./search" method="post">
				<table>
					<tr>
						<td>Student id:</td>
						<td><input type="number" name="id" required></td>
					</tr>
				</table>
				<input id="submit"type="submit" value="SEARCH">
			</form>
		
	</div>

	<%
	if (student != null) {
	%>
	<div align="center" class="over-flow">
		<table border="1px">
			<tr>
				<th>Student id</th>
				<th>Name</th>
				<th>Contact</th>
				<th>Email</th>
				<th>Address</th>
			</tr>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getContact()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getAddress()%></td>
			</tr>
		</table>
	</div>

	<%
	} if(msg!=null){
	%>
	<div align="center">
		<h2><%=msg %></h2>
	</div>
	<%
	}
	%>

</body>
</html>