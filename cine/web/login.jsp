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
        <title>Iniciar Sesión</title>
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
            <h1>Iniciar Sesión</h1>

            <form action="/cine/login" method="POST">
                <table>
                    <tr>
                        <th>Email: </th>
                        <th><br><input type="email" name="email" class="form-control" required="true" value=""/></th>
                    </tr>  
                     <tr>
                        <th>Contraseña: </th>
                        <th><br><input type="password" name="contrasenia" class="form-control" required="true" value=""/></th>
                    </tr> 
                    <tr>
                        <td><br>
                            <input class="btn btn-primary" type="submit" name="action" value="Iniciar"/>
                        </td>
                        <td>
                            <a href="registrarUsuario.jsp">No estoy registrado</a>
                        </td>
                            
                    </tr>
                </table>
                <h1>${error}</h1>
            </form>
    </body>
</html>
