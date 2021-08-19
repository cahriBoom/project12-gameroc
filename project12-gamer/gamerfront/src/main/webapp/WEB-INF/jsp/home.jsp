<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<%@ include file="header.jsp"%>
</head>
<%@ include file="menu.jsp" %>
<body>
	<main role="main">
		<c:set var="current" value="${current}" scope="session" />
		<c:set var="gamer" value="${gamer}" scope="session" />
		<section class="jumbotron text-center">
			<div class="container">
				<h1 class="jumbotron-heading">Gamer OC</h1>
				<p class="lead text-muted">Welcome to Gamer OC. A social
					plateform where you can find people to play with. For a better
					experience. Have fun and enjoy.</p>
				<p>
					<a href="/Gamer/search_event" class="btn btn-primary my-2">Search Teammates</a>
					<a href="/Gamer/post_event" class="btn btn-secondary my-2">Post an Event</a>
				</p>
			</div>
		</section>

		<div class="album py-5 bg-light">
			<div class="container">

				
			</div>
		</div>

	</main>

	<%@ include file="footer.jsp"%>
</body>
</html>
