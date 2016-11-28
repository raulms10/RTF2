<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet"
              href="https://bootswatch.com/darkly/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>RESERVAS</title>
        <nav role="navigation" class="navbar navbar-default">
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="consultaPelicula.jsp">Películas</a></li>
                <li><a href="registrarUsuario.jsp">Registro</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </div>
        </nav>
    </head>
    <body>
        <div class="container well">
            <h1>INFORMACIÓN DE RESERVAS</h1>

            <form action="aqui va la vaina de reserva" method="POST" enctype="multipart/form-data">
             
             <table class="table table-inverse">
                <thead>
                 <tr class="info">               
                    <th>Código de la reserva</th>
                    <th>Estado</th>
                    <th>Fecha</th>   
                    <th>Hora</th> 
                </tr>
                </thead>
                <thead>
                <tr>
                     <!-- MODIFICAR ESTO ACORDE AL CONTROLADOR DE RAUL-->
                    <c:choose>
                        <c:when test="${buscarTodo}">
                            <c:forEach items="${allVehiculos}" var="veh">
                                <td>${veh.matricula}</td>
                                <td>${veh.marca}</td>
                                <td>${veh.modelo}</td>
                                <td>${veh.color}</td>
                                <td>${veh.precio}</td>
                                <td> <img src="/concesionario/vehiculoServlet?code=1&matricula=${veh.matricula}"height="150" width="250"/></td> 
                            </tr>
                </thead>
                        </c:forEach>
                    </c:when>
                    </c:choose>
           </div>
    </body>
</html>