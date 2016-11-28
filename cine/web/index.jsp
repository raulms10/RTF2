<%-- 
    Document   : index
    Created on : 10-abr-2014, 11:02:20
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página principal</title>
    </head>
    <body>
        <%=(String)request.getAttribute("ey")%>
        <c:if test="${not empty ey}">
            <h1>${ey}</h1>
        </c:if>
        
        <h1>${ey}</h1>
        <ul type="square">
            <li><a href="/cine/cartelera">Lista de Cartelera</a></li>
            <li><a href="/cine/login">Iniciar Sesión</a></li>
            <li><a href="/cine/pelicula">Lista Pelicula</a></li>
        </ul>
    </body>
</html>