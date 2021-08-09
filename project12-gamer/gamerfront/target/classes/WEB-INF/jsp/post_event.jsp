<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
</head>
<%@ include file="menu.jsp"%>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<header class="card-header">
						<h4 class="card-title mt-2">Create a new Event</h4>
					</header>
					<article class="card-body">
						<form:form method="post" modelAttribute="event" action="">

							<div class="form-row">
								<label for="title">Title</label>
								<form:input path="title" required="required" type="text"
									id="title" class="form-control" placeholder="" />
							</div>
							<div class="form-group">
								<label for="description">Description</label>
								<form:textarea path="description" id="description"
									class="form-control" required="required" type="text"
									placeholder="" />
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="game">Game</label>
									<form:select id="inputState" required="required"
										path="videogame" class="form-control">
										<option selected="">Choose...</option>
										<c:forEach var="videogames" items="${ videogames }">
											<option>${ videogames.nom }-${ videogames.plateform }</option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label for="pneeded">Player needed</label>
								<form:select id="pneeded" required="required"
									path="player_needed" class="form-control">
									<option selected="">Choose...</option>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</form:select>
							</div>
							
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">
									Post Event</button>
							</div>
						</form:form>
					</article>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
</body>
</html>