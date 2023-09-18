<%@page import="com.jspiders.springmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./NavBar.jsp"></jsp:include>
 <jsp:include page="./Footer.jsp"></jsp:include>
<%String msg=(String)request.getAttribute("msg");
List<StudentPOJO> students=(List<StudentPOJO>)request.getAttribute("students");

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
.over-flow {
	height: 150px;
	width: 557px;
	overflow: auto;
	margin: auto;
	margin-top: 50px;
}
h2{
  margin: auto;
  margin-top: 30px;
  color: #333;
  margin-bottom: 30px;   
}</style>
</head>
<body>
	<div align="center">
		<h2>Insert id for remove  record</h2>
		
			<form action="./remove" method="post">
				<table>
					<tr>
						<td>Student id:</td>
						<td><input type="number" name="id" required="required"></td>
					</tr>
				</table>
				<input id="submit" type="submit" value="REMOVE">
			</form>
		
	</div>
	
	<%if(msg!=null) {%>
	<div align="center">
	<h1><%=msg %> </h1>
	</div>
	<% }%>
	
	<%if(students!=null){ %>
	
	<div align="center" class="over-flow">
		<table border="1px">
			<tr>
				<th>Student id</th>
				<th>Name</th>
				<th>Contact</th>
				<th>Email</th>
				<th>Address</th>
			</tr>
			<%for(StudentPOJO student:students) {%>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getContact()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getAddress()%></td>
			</tr>
			<%} %>
		</table>
	</div>
	<%} %>
	
</body>
</html>