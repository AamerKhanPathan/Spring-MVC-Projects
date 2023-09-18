<%@page import="com.hospital.pojo.PatientPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./Navbar.jsp"></jsp:include>
<jsp:include page="./Footer.jsp"></jsp:include>
<%
String msg=(String)request.getAttribute("msg");
List<PatientPOJO> patients = (List<PatientPOJO>) request.getAttribute("patients");
PatientPOJO pojo=(PatientPOJO)request.getAttribute("pojo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<style type="text/css">
h2 {
	margin: auto;
	margin-top: 30px;
	color: #333;
	margin-bottom: 30px;
}

.over-flow {
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
	<%if (pojo==null) {%>
	<div align="center">
		<h2>Update Patients Data</h2>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Patients id:</td>
					<td><input type="number" name="id" required></td>
				</tr>
			</table>
			<input id="submit" type="submit" value="SELECT">
		</form>
	
		
		<%} %>
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
				for (PatientPOJO pojo1 : patients) {
				%>
				<tr>
					<td><%=pojo1.getId()%></td>
					<td><%=pojo1.getName()%></td>
					<td><%=pojo1.getContact()%></td>
					<td><%=pojo1.getEmail()%></td>
					<td><%=pojo1.getDisease()%></td>
					<td><%=pojo1.getAddress()%></td>
					<td><%=pojo1.getNextVisitDate()%></td>
				</tr>
				</div>
				<%
				}
		}
			%>
<%if(pojo!=null){	%>
					<div>
	<fieldset>
			<legend>Update Patient</legend>
			<form action="./updatePatient" method="post">
				<table>
					<tr>
						<td>ID</td>
						<td> <input type="number" name="id" value="<%= pojo.getId()%>" readonly="readonly"> </td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"
							value="<%=pojo.getName()%>" autofocus="autofocus"></td>
					</tr>
					<tr>
						<td>Contact</td>
						<td><input type="text" name="contact"
							value="<%=pojo.getContact()%>"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"
							value="<%=pojo.getEmail()%>"></td>
					</tr>
					<tr>
						<td>Disease</td>
						<td><input type="text" name="deisease"
							value="<%=pojo.getDisease()%>"></td>
					</tr>
					<tr>
						<td>Date</td>
						<td><input type="text" name="date"
							value="<%=pojo.getNextVisitDate()%>"></td>
					</tr>
					
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"
							value="<%=pojo.getAddress()%>"></td>
					</tr>
				</table>
				<input type="submit" value="UPDATE">
			</form>
		</fieldset>
	</div>
				<%}
				
				if (msg != null) {
				%>
				<h2><%=msg%></h2>
				<%
				}
				%>
</body>
</html>