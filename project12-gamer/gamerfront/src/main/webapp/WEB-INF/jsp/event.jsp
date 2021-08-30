<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
		<%@ include file="header.jsp"%>	
    </head>
    <%@ include file="menu.jsp" %>
    <style>
    table,
	thead,
	tr,
	tbody,
	th,
	td {
	  text-align: center;
	}

	.table td {
	  text-align: center;
	}
    </style>
    <body>
        <!-- Header-->
        <header class="py-5">
            <div class="container px-lg-5">
                <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
                    <div class="m-4 m-lg-5">
                        <h1 class="display-5 fw-bold">${ event.title }</h1>
                        <p class="fs-4">${ event.description }</p>
						<form:form method="post" modelAttribute="gamer" action="">
                    		<c:if test="${isEligible}">
                        		<button type="submit" class="btn btn-primary btn-lg">Join Group</button>
	                        </c:if>
	                        <c:if test="${!isEligible}">
	                        	<button type="submit" class="disabled btn btn-primary btn-lg">Join Group</button>
	                        </c:if>
	                        <c:if test="${isAlreadyIn}">
	                        	<button type="submit" class="btn btn-primary btn-lg">Quit Group</button>
	                        </c:if>
                    	</form:form>   
                    </div>
                </div>
            </div>
        </header>
        <!-- Page Content-->
        <section class="pt-4">
            <div class="container px-lg-5">
                <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
                    <div class="m-4 m-lg-5">
                    	<table class="table">
                    		<thead class="thead-dark">
	                    		<tr>
	                    			<th scope="col"><h2>Gamertag</h2></th>
	                    			<th scope="col"><h2>Server</h2></th>
	                    			<th scope="col"><h2>Grade</h2></th>
	                    		</tr>
                    		</thead>
                    		<tbody>
                    			<c:forEach var="gamers" items="${ gamers }">
	                    			<tr>
	                    				<td><h3>${gamers.gamertag}</h3></td>
	                    				<td><h3>${gamers.server }</h3></td>
	                    				<td><h3>${gamers.note }</h3></td>
	                    			</tr>
                    			</c:forEach> 
                    		</tbody>
                    		
                    	</table>
                    	
                    	
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2021</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
