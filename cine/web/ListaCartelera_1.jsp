<%-- 
    Document   : ListaCiudades
    Created on : 10-abr-2014, 10:33:10
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cartelera</title>
    </head>
    <body>
        <h1>Cartelera</h1>
        <ul type="circle">
            <li><a href="index">Inicio</a></li>
            
        </ul>
        <c:if test="${!empty carteleras}">
          <table frame="border" width="50%" border="1" >
            <tbody>
              <tr>
                <th>Codigo</th>
                <th>Fecha Estreno</th>
                <th>Fecha Salida</th>
                <th>Pelicula</th>
                <th>Sucursal</th>
              </tr>
                <c:set var="contador" value="1" scope="page"/>
                <c:forEach var="item" items="${carteleras}">
                    <c:if test="${contador%2 == 0}"><tr bgcolor="silver"></c:if>
                    <c:if test="${contador%2 != 0}"><tr bgcolor="white"></c:if>
                        <td> ${item.titulo} </td>
                        <td> ${item.titulo} </td>
                        <td> ${item.titulo} </td>
                        <td> ${item.titulo} </td>
                        <td> ${item.titulo} </td>
                    </tr>
                    <c:set var="contador" value="${contador+1}" />
                </c:forEach>

            </tbody>
          </table>
          
        </c:if>

    </body>
</html>
