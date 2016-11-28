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
        <title>Buscar Película</title>
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
            <h1>Buscar Película por: </h1>

            <form action="/cine/peliculas" method="POST">
                <table>
                    <tr>
                    <br> <th>Título:  <td> <br> <input type="text" name="tit" class="form-control" placeholder="rápido y furioso" /></th></td>
                    
                    </tr>
                    <tr>
                    <br> <th>Género:   <td> <br> <input type="text" name="generoPk" class="form-control" placeholder="ej: Acción"/></th></td>
                    
                    </tr>
                   <tr>
                    <br> <th>Clasificación +: <td> <br> <input type="text" name="clasificacionPk" class="form-control" placeholder="ej: 12"/></th></td>
                    
                    </tr>
                    <tr><td><br> <input class="btn btn-primary" type="submit" name="action" value="Buscar"/>
                            <span class="glyphicon btn-glyphicon glyphicon-search img-circle text-primary"/></td></tr>
                </table>
            </form>
           </div>
    </body>
</html>