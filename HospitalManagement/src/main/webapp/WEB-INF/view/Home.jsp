<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="./Navbar.jsp"></jsp:include>
    <jsp:include page="./Footer.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<style>
/* Reset some default browser styles */
body, h2, p {
	margin: 0;
	padding: 0;
}

.about-container {
	font-family: Arial, sans-serif;
	height: 250px;
	width: 500px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	padding: 25px;
	margin-top: 100px;
	margin-left: 450px;
}

#aboutus {
	color: #333;
	margin-bottom: 20px;
	text-align: center;
}

p {
	color: #555;
}
</style>

</head>
<body>
<div class="about-container">
		<h2 id="aboutus">About Us</h2>
		<p>
			Hopital  management system is a web application designed to help
			Hospital record  to manage their Patients information . This
			appliaction provide features of maintaining patients data,
			manipulation of patients data. <br> Technologies used in this
			application is: <br> <b>'Java, SQL (Hibernate),JSP,HTML,CSS'<br>
				<br></b> Developed by <b> Aamer Khan <br> Contact: +91 9284142323
			</b><br> email: <a href="mailto:aamerkhanpvt@gmail.com">aamerkhanpvt@gmail.com</a>
			</b>
		</p>
	</div>
</body>
</html>
