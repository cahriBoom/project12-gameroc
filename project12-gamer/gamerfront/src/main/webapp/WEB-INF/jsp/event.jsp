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
    <body>
        <!-- Header-->
        <header class="py-5">
            <div class="container px-lg-5">
                <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
                    <div class="m-4 m-lg-5">
                        <h1 class="display-5 fw-bold">${ event.title }</h1>
                        <p class="fs-4">${ event.description }</p>
                        <a class="btn btn-primary btn-lg" href="#!">Join Group</a>
                    </div>
                </div>
            </div>
        </header>
        <!-- Page Content-->
        <section class="pt-4">
            <div class="container px-lg-5">
                <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
                    <div class="m-4 m-lg-5">
                    	<ul class="list-group">
	                    	<c:forEach var="gamers" items="${ gamers }">
	                    		<c:if test="${gamers.plateform == 'Playstation'}">
	                    			<li class="list-group-item list-group-item-primary"><h2>${gamers.gamertag} -- ${gamers.server }</h2></li>
	                    		</c:if>
	                    		<c:if test="${gamers.plateform == 'PC'}">
	                    			<li class="list-group-item list-group-item-dark"><h2>${gamers.gamertag} -- ${gamers.server }</h2></li>
	                    		</c:if>
	                    		<c:if test="${gamers.plateform == 'Xbox'}">
	                    			<li class="list-group-item list-group-item-success"><h2>${gamers.gamertag} -- ${gamers.server }</h2></li>
	                    		</c:if>
	                    	</c:forEach>  
                    	</ul>
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
