<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" href="views/searchstyle.css" type="text/css">

</head>
<body>

	<form class="topform" method="post" action="${pageContext.request.contextPath}/search">

		<div id="topformdiv">
			<h1>MyPosts</h1>
			<input type="text" name="searchtext" placeholder="Search"
				id="searchinput"> <input type="image" id="searchbutton"
				src="views/search.png">
		</div>

	</form>


	<section id="sec">


		<form action="${pageContext.request.contextPath}/writepost" method="post" class="postform">

			<div class="insidepostform">



				<c:forEach items="${matchedposts}" var="post">

					<div id="eachpost">

						<div>
							<div class="avatardiv">
								<img id="avatarimg" alt="avatar" src="views/profile.png">

							</div>

							<div class="avatardiv">
								<p id="username">${post.username}</p>
								<p id="date">${post.date_created}</p>
							</div>
						</div>

						<p id="content">${post.content}</p>

					</div>

				</c:forEach>
			</div>


		</form>




	</section>
</body>
</html>