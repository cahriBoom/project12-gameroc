<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
</head>
<%@ include file="menu.jsp" %>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<header class="card-header">
						<a href="/Gamer/login" class="float-right btn btn-outline-primary mt-1">Login</a>
						<h4 class="card-title mt-2">Sign up</h4>
					</header>
					<article class="card-body">
						<form:form id="registerform" method="post" modelAttribute="gamer"
							action="subscribe">
							<c:if test="${not empty error}">
								<div class="error">${error}</div>
							</c:if>
							<c:if test="${not empty msg}">
								<div class="msg">${msg}</div>
							</c:if>
							<div class="form-row">
								<label for="gamertag">Gamertag</label>
								<form:input path="gamertag" required="required" type="text"
									id="gamertag" class="form-control" placeholder="" />
							</div>
							<div class="form-group">
								<label for="email">Email address</label>
								<form:input type="email" id="email" path="email"
									required="required" class="form-control" placeholder="" />
								<small class="form-text text-muted">We'll never share
									your email with anyone else.</small>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="server">Server</label>
									<form:select id="inputState" required="required" path="server"
										class="form-control">
										<option selected="">Choose...</option>
										<option>Asia</option>
										<option>Europe</option>
										<option>America</option>
									</form:select>
								</div>
								<div class="form-group col-md-6">
									<label for="plateform">Plateform</label>
									<form:select id="plateform" required="required"
										path="plateform" class="form-control">
										<option selected="">Choose...</option>
										<option>Playstation</option>
										<option>PC</option>
										<option>Xbox</option>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label for="password">Create password</label>
								<form:input id="password" path="password" required="required"
									class="form-control" type="password" />
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">
									Register</button>
							</div>
							<small class="text-muted">By clicking the 'Sign Up'
								button, you confirm that you accept our <br> Terms of use
								and Privacy Policy.
							</small>
						</form:form>
					</article>
					<div class="border-top card-body text-center">
						Have an account? <a href="/Gamer/login">Log In</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
</body>
</html>