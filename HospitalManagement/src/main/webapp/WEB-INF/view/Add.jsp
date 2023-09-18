<%@page import="com.hospital.pojo.PatientPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
List<PatientPOJO> patients = (List<PatientPOJO>) request.getAttribute("patients");
%>
<jsp:include page="./Navbar.jsp"></jsp:include>
<jsp:include page="./Footer.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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

		<h2>Add Patient Details</h2>


		<form action="./add" method="post">

			<table>

				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"></td>
				</tr>

				<tr>
					<td>Email:</td>
					<td><input type="email" name="email"></td>
				</tr>

				<tr>
					<td>Mobile:</td>
					<td><input type="number" name="contact" minlength="10"
						maxlength="10"></td>
				</tr>

				<tr>
					<td>Address:</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>Disease:</td>
					<td><input type="text" name="disease"></td>
				</tr>
				<tr>
					<td>Next visit date:</td>
					<td><input type="text" name="date"></td>
				</tr>
			</table>

			<input id="submit" type="submit" value="Enter">
		</form>

	<%
		if (patients != null) {
		%>
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
				<%
				for (PatientPOJO pojo : patients) {
				%>
				<tr>
					<td><%=pojo.getId()%></td>
					<td><%=pojo.getName()%></td>
					<td><%=pojo.getContact()%></td>
					<td><%=pojo.getEmail()%></td>
					<td><%=pojo.getDisease()%></td>
					<td><%=pojo.getAddress()%></td>
					<td><%=pojo.getNextVisitDate()%></td>
				</tr>
				<%
				}
				}
				if (msg != null) {
				%>
				<h2><%=msg%></h2>
				<%
				}
				%>

				
			</table>
			</div>
</body>
</html>