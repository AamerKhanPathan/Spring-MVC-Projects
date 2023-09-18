<%@page import="java.util.List"%>
<%@page import="com.hospital.pojo.PatientPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./Navbar.jsp"></jsp:include>
<jsp:include page="./Footer.jsp"></jsp:include>
<%
String msg = (String) request.getAttribute("msg");

List<PatientPOJO> patients = (List<PatientPOJO>)request.getAttribute("patients");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Page</title>
<style type="text/css">
#submit {
	background-color: #1B4D3E;
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

h2 {
	margin: auto;
	margin-top: 30px;
	color: #333;
	margin-bottom: 30px;
}
</style>
</head>
<body>
	<div align="center">
		<h2>Insert id for remove record</h2>

		<form action="./remove" method="post">
			<table>
				<tr>
					<td>Patient id:</td>
					<td><input type="number" name="id" required="required"></td>
				</tr>
			</table>
			<input id="submit" type="submit" value="REMOVE">
		</form>

	</div>

	<%
	if (msg != null) {
	%>
	<div align="center">
		<h2><%=msg%>
		</h2>
	</div>
	<%
	}
	%>

	<%
	if (patients!=null) {
	%>
	<div align="center" class="over-flow">
		<table border="1px">
			<tr>
				<th>Patient id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Contact</th>
				<th>Address</th>
				<th>Disease</th>
				<th>Next_Visit_date</th>
			</tr>
			<%
			for (PatientPOJO patient : patients) {
			%>
			<tr>
				<td><%=patient.getId()%></td>
				<td><%=patient.getName()%></td>
				<td><%=patient.getEmail()%></td>
				<td><%=patient.getContact() %></td>
				<td><%=patient.getAddress()%></td>
				<td><%=patient.getDisease() %></td>
				<td><%=patient.getNextVisitDate() %></td>
	     	</tr>
			<%
			}
			%>
		</table>
	</div>
	<%
	}
	%>

</body>
</html>