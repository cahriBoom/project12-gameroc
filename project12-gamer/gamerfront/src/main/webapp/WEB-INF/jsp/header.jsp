<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="bootstrap.css" />
<title>Gamer OC</title>
<meta charset="utf-8" />
</head>
<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/Gamer/home">GOC</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/Gamer/home">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/Gamer/search_event">Seach Teamates</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/Gamer/post_event">Post an Event</a></li>
			</ul>
			<c:if test="${current == 'anonymousUser'}">
				<ul class="navbar-nav mr-auto float-right">
					<li><a href="/Gamer/login"
						class="btn btn-outline-primary my-2 my-sm-0">Login</a></li>
					<li><a href="/Gamer/subscribe"
						class="btn btn-outline-primary my-2 my-sm-0">Create an account</a>></li>
				</ul>
			</c:if>
			<c:if test="${current != 'anonymousUser'}">
				<ul class="navbar-nav mr-auto float-right">
					<li><a href=""
						class="btn btn-outline-primary my-2 my-sm-0"> ${ gamer.gamertag }</a></li>
					<li><a href="/Gamer/logout"
						class="btn btn-outline-primary my-2 my-sm-0"> Logout </a>></li>
				</ul>
			</c:if>
		</div>
	</nav>
</header>
