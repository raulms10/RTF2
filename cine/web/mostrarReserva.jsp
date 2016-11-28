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
                <li class="active"><a href="/cine/pelicula">Películas</a></li>
                <li><a href="/cine/registrar">Registro</a></li>
                <li><a href="/cine/login">Login</a></li>
                <li><a href="/cine/cerrar">Cerrar</a></li>
                <li><a hfre="">${email}</h3>
                
            </ul>
        </div>
    </nav>
</head>
<body>
    <div class="container well">
        <h1>INFORMACIÓN DE RESERVAS</h1>

        <form action="/reserva" method="POST" enctype="multipart/form-data">

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

                        <c:forEach items="${reservas}" var="r">
                            <td>${r.codigo}</td>
                            <td>${r.esatdo}</td>
                            <td>${r.fecha}</td>
                            <td>${r.hora}</td>


                        </tr>
                    </thead>
                </c:forEach>

                </div>
                </body>
                </html>