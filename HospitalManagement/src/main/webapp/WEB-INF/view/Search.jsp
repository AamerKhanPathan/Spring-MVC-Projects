<%@page import="com.hospital.pojo.PatientPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <jsp:include page="./Navbar.jsp"></jsp:include>
     <jsp:include page="./Footer.jsp"></jsp:include>
     <%
     String msg=(String)request.getAttribute("msg");
     PatientPOJO pojo=(PatientPOJO)request.getAttribute("pojo");
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
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
	background-color: #1B4D3E;
	color: white;
	width: 80px;
	margin-top: 10px;
}
</style>
</head>
<body>
	<div align="center">
	<h2>Search Patients record</h2>
		
			<form action="./search" method="post">
				<table>
					<tr>
						<td>Patient id:</td>
						<td><input type="number" name="id" required></td>
					</tr>
				</table>
				<input id="submit" type="submit" value="SEARCH">
			</form>
			
		<%if(pojo!=null){ %>
		<div align="center" class="over-flow">
		<table border="1px">
			<tr>
				<th>Patient id</th>
				<th>Name</th>
				<th>Contact</th>
				<th>Email</th>
				<th>Disease</th>
				<th>Address</th>
				<th>Next Visit Date</th>
				
			</tr>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getContact()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getDisease()%></td>
				<td><%=pojo.getAddress()%></td>
				<td><%=pojo.getNextVisitDate()%></td>
			</tr>
		</table>
	</div>
		<%} %>
		
		<%if(msg!=null){ %>
		<h2><%=msg %></h2>
		<%} %>
	</div>

</body>
</html>