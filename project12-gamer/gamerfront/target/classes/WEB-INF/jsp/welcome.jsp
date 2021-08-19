<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<%@ include file="header.jsp"%>
	</head>
<%@ include file="menu.jsp"%>
<body>
	<div class="container">
		<div class="main-body">
			<div class="row gutters-sm">
				<div class="col-md-4 mb-3">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
									alt="Admin" class="rounded-circle" width="150">
								<div class="mt-3">
									<h4>${ gamer.gamertag }</h4>
									<p class="text-secondary mb-1">Rank : ${ gamer.note }</p>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-8">
					<div class="card mb-3">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<h4 class="mb-0">Gamertag</h4>
								</div>
								<div class="col-sm-9 text-secondary">${ gamer.gamertag }</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h4 class="mb-0">Plateform</h4>
								</div>
								<div class="col-sm-9 text-secondary">${ gamer.plateform }</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h4 class="mb-0">Server</h4>
								</div>
								<div class="col-sm-9 text-secondary">${ gamer.server }</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-12">
									<a class="btn btn-info" href="/Gamer/edit_profile">Edit</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<h2>Recents players met</h2>
					<form:form method="post" modelAttribute="voted" action="">
						<table class="table">
	                    	<thead class="thead-dark">
		                    	<tr>
		                    		<th scope="col"><h4>Gamertag</h4></th>
		                    		<th scope="col"><h4>Server</h4></th>
		                    		<th scope="col"><h4>Rating</h4></th>
		                    	</tr>
	                    	</thead>
	                    	<tbody>
	                    		<c:forEach var="recent_gamers" items="${ recent_gamers }">
		                    		<tr>
		                    			<td><h4>${recent_gamers.gamertag}</h4></td>
		                    			<td><h4>${recent_gamers.server }</h4></td>
		                    			<td>
			                    			<h4>  		
			                    				<form:input value="${recent_gamers.email}" type="submit" name="good_rating" path="good_rating" class="btn btn-success" />
												<form:input value="${recent_gamers.email}" type="submit" name="bad_rating" path="bad_rating" class="btn btn-danger" />
			                    			</h4>
		                    			</td>
		                    		</tr>
	                    		</c:forEach> 
	                    	</tbody>
	                    </table>
                   </form:form> 
				</div>
			</div>
		</div>
	</div>
</body>
</html>