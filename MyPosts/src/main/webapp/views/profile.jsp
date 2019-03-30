<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="views/profilestyle.css" type="text/css">
</head>
<body>
	<form action="${pageContext.request.contextPath}/search"
		class="topform" method="post">

		<div id="topformdiv">
			<h1>MyPosts</h1>
			<input type="text" name="searchtext" placeholder="Search" id="searchinput">
			<input type="image" id="searchbutton" src="views/search.png">
		</div>

	</form>

	<form action="${pageContext.request.contextPath}/logout" method="post" class="logoutform">
		<input id="logoutbtn" type="image" id="searchbutton" src="views/logout.png">
	</form>
	<section id="sec">


		<form action="${pageContext.request.contextPath}/writepost"
			method="post" class="postform">

			<div class="insidepostform">

				<textarea name="postcontent" placeholder="What's on your mind?"
					cols="40" rows="10 "></textarea>
				<br>

				<div class="wrapperdiv">
					<div class="statusdiv">
						<input type="radio" name="status" value="public" checked="checked">
						Public <input type="radio" name="status" value="private">
						Private

					</div>

					<div class="postingdiv">
						<input type="submit" name="submit" value="Publish">
					</div>
				</div>

				<c:forEach items="${postslist}" var="post">

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