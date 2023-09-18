<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style type="text/css">
ul {
	
	box-shadow: 5px 5px 5px rgb(77, 73, 73);
	margin-bottom: 50px;
	list-style-type: none;
	background-color: green;
	overflow: hidden;
	height: 80px;
	color: white;
}

li {
	border-color: #333;
	border-radius: 50px;
	float: right;
}

li a {
	text-decoration: none;
	display: block;
	margin: 0px;
	padding: 15px;
}

li a:hover {
	border: 0.5px white;
	border-radius: 50px;
	background-color: #1B4D3E;
}

#parent_button {
	margin-top: 20px;
}
</style>
</head>
<body>
	<ul> 
	
		<div id="parent_button">
			<li><a style="color: white;" href="./logout">Logout</a></li>
			<li><a style="color: white;" href="./search">Search patient</a></li>
			<li><a style="color: white;" href="./add">Add patient</a></li>
			<li><a style="color: white;" href="./update">Update patient</a></li>
			<li><a style="color: white;" href="./remove">Remove patient</a></li>
			<li><a style="color: white;" href="./home">Home</a></li>
		</div>
	</ul>


</body>
</html>