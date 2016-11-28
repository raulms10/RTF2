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
        <title>Registrar Usuario</title>
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
            <h1>Registrar Usuario: </h1>

            <form action="Aquí va lo del metodo registrar usuario" method="POST">
                <table>
                    <tr>
                        <th>Código: </th>
                        <th><br><input type="text" name="codigo" class="form-control" required="true" placeholder="1245" value=""/> </th>
                    </tr>
                    <tr>
                        <th> Nombre: </th>
                        <th><br><input type="text" name="nombre" class="form-control" required="true" placeholder="Pedro" value=""/></th>
                    </tr>
                    <tr>
                        <th>Apellidos: </th>
                        <th><br><input type="text" name="apellidos" class="form-control" required="true" placeholder="Pérez" value=""/> </th>
                    </tr>
                    <tr>
                        <th>Tipo de Documento: </th>
                        <th><br> <select class="form-control">
                                <option>C.C</option>
                                <option>T.I</option>
                            </select>                         
                    </tr>
                    <tr>
                        <th>Número de Documento: </th>
                        <th><br><input type="text" name="numerodocumento" class="form-control" required="true" placeholder="115467890" value=""/></th>
                    </tr>                                       
                    <tr>
                        <th>Fecha de Nacimiento: </th>
                        <th><br><input type="date" name="fechanacimiento" class="form-control" required="true" value=""/></th>
                    </tr> 
                     <tr>
                        <th>Sexo: </th>
                        <th><br> <select class="form-control">
                                <option>F</option>
                                <option>M</option>
                            </select>
                    </tr> 
                      <tr>
                        <th>Email: </th>
                        <th><br><input type="email" name="email" class="form-control" required="true" value=""/></th>
                    </tr>  
                     <tr>
                        <th>Contraseña: </th>
                        <th><br><input type="password" name="contrasenia" class="form-control" required="true" value=""/></th>
                    </tr> 
                    <tr>
                        <td  colspan="2"><br>
                            <input class="btn btn-primary" type="submit" name="action" value="Registrar"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>