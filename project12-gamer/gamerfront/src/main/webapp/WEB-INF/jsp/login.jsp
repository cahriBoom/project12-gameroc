<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<header class="card-header">
						<a href="/Gamer/subscribe"
							class="float-right btn btn-outline-primary mt-1">Create an
							account</a>
						<h4 class="card-title mt-2">Sign in</h4>
					</header>
					<article class="card-body">
						<form:form method="post" modelAttribute="gamer" action="login">
							<div class="form-group">
								<label for="email">Email address</label>
								<form:input id="email" path="username" type="email"
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<form:input id="password" path="password" autocomplete=""
									class="form-control" type="password" />
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">
									Log in</button>
							</div>
						</form:form>
					</article>
					<div class="border-top card-body text-center">
						Don't have an account? <a href="/Gamer/subscribe">Create an
							account</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
</body>
</html>