<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
<%@ include file="header.jsp"%>
</head>
<%@ include file="menu.jsp" %>
<body>
	<main role="main">

		<section class="jumbotron text-center">
			<div class="container">
				<h1 class="jumbotron-heading">Gamer OC</h1>
				<p class="lead text-muted">Welcome to Gamer OC. A social
					platform where you can find poeple to play with. For a better
					experience. Have fun and enjoy.</p>
				<p>
					<a href="/Gamer/search_event" class="btn btn-primary my-2">Search Teammates</a>
					<a href="/Gamer/post_event" class="btn btn-secondary my-2">Post an Event</a>
				</p>
			</div>
		</section>
		<form:form method="post" modelAttribute="videogame" action="">
			<div class="row">
		        <div class="col-lg-4 col-lg-offset-4">
		            <form:input type="search" id="search" path="nom" class="form-control" placeholder="Search..." />
		        </div>
	    	</div>
		</form:form>
		<div class="album py-5 bg-light">
			<div class="container">
				<div class="row">
				  <c:forEach var="events" items="${ events }">
				  	<c:if test="${events.videogame.plateform == 'Playstation'}">
						<div class="result col-md-4">
							<div class="card mb-4 box-shadow bg-primary">
								<img class="card-img-top" src="./${ events.videogame.nom }.jpg" alt="${ events.videogame.nom }">
								<div class="card-body">
									<p class="card-text">
										<c:out value="${ events.videogame.nom } - ${events.title } - ${events.description }"></c:out>
									</p>
									<div class="d-flex justify-content-between align-items-center">
										<div class="btn-group">
											<a type="button" href="/Gamer/event/${ events.id }" class="btn btn-sm">View</a>
										</div>
										<small>${ events.spots } spots</small>
										<small>${ events.plateform }</small>
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${events.videogame.plateform == 'Xbox'}">
						<div class="result col-md-4">
							<div class="card mb-4 box-shadow bg-success">
								<img class="card-img-top" src="./${ events.videogame.nom }.jpg" alt="${ events.videogame.nom }">
								<div class="card-body">
									<p class="card-text">
										<c:out value="${ events.videogame.nom } - ${events.title } - ${events.description }"></c:out>
									</p>
									<div class="d-flex justify-content-between align-items-center">
										<div class="btn-group">
											<a type="button" href="/Gamer/event/${ events.id }" class="btn btn-sm">View</a>
										</div>
										<small>${ events.spots } spots</small>
										<small>${ events.plateform }</small>
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${events.videogame.plateform == 'PC'}">
						<div class="result col-md-4">
							<div class="card mb-4 box-shadow bg-secondary">
								<img class="card-img-top" src="./${ events.videogame.nom }.jpg" alt="${ events.videogame.nom }">
								<div class="card-body">
									<p class="card-text">
										<c:out value="${ events.videogame.nom } - ${events.title } - ${events.description }"></c:out>
									</p>
									<div class="d-flex justify-content-between align-items-center">
										<div class="btn-group">
											<a type="button" href="/Gamer/event/${ events.id }" class="btn btn-sm">View</a>
										</div>
										<small>${ events.spots } spots</small>
										<small>${ events.plateform }</small>
									</div>
								</div>
							</div>
						</div>
					</c:if>	
				  </c:forEach>
				</div>
			</div>
		</div>

	</main>
	<%@ include file="footer.jsp"%>
</body>
</html>
