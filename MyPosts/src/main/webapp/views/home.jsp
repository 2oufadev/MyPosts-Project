<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPosts</title>
<link rel="stylesheet" href="views/homestyle.css" type="text/css" />

</head>
<body>

	<header class="topheader">
		<h1>MyPosts</h1>
	</header>


	<div class="formdiv">
		<form action="${pageContext.request.contextPath}/login" method="post" class="loginform">

			<p id="logintext">MyPosts</p>
			<p id="logintext2">Hear what people are talking about</p>
			<div id="outerdiv">

				<div id="innerdiv">


					<input id="iusername" type="text" name="username"
						placeholder="Username"> <br> <input id="ipassword"
						type="password" name="password" placeholder="Password"> <br>


					<input id="loginbtn" type="submit" value="Login"> <br>

					<p id="securityexception">${SPRING_SECURITY_LAST_EXCEPTION.message}</p>


				</div>


			</div>




		</form>

	</div>

</body>
</html>