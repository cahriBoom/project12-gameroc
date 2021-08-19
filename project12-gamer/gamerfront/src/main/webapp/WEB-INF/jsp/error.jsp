<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="header.jsp"%>
<style>
.error-template {padding: 40px 15px;text-align: center;}
.error-actions {margin-top:15px;margin-bottom:15px;}
.error-actions .btn { margin-right:10px; }
</style>
</head>

<%@ include file="menu.jsp"%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="error-template">
					<h1>Oops!</h1>
					<div class="error-actions">
						<h2>${errorMsg}</h2>
						<a href="/Gamer/home" class="btn btn-primary btn-lg"> Take Me Home</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>