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
		<div class="row gutters">
			<div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
				<div class="card h-100">
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
			<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
				<div class="card h-100">
					<form:form method="post" modelAttribute="gamer" action="">
						<div class="card-body">
							<div class="row gutters">
								<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
									<h6 class="mb-2 text-primary">Personal Details</h6>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="gamertag">Gamertag</label>
										<form:input type="text" path="gamertag" class="form-control"
											id="gamertag" placeholder="${ gamer.gamertag }" />
									</div>

									<div class="form-group">
										<label for="password">Email</label>
										<form:input type="email" path="email"
											class="form-control" id="email"
											placeholder="${ gamer.email }" />
									</div>

									<div class="form-group">
										<label for="password">password</label>
										<form:input type="password" path="password"
											class="form-control" id="password"
											placeholder="${ gamer.password }" />
									</div>

									<div class="form-group">
										<label for="plateform">Platform</label>
										<form:select id="plateform" required="required"
											path="plateform" class="form-control">
											<option selected="">Choose...</option>
											<option>Playstation</option>
											<option>PC</option>
											<option>Xbox</option>
										</form:select>
									</div>

									<div class="form-group">
										<label for="server">Server</label>
										<form:select id="inputState" required="required" path="server"
											class="form-control">
											<option selected="">Choose...</option>
											<option>Asia</option>
											<option>Europe</option>
											<option>America</option>
										</form:select>
									</div>
								</div>
							</div>
							<div class="row gutters">
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="text-right">
										<button type="submit" id="submit" name="submit"
											class="btn btn-primary">Update</button>
									</div>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>