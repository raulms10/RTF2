
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peliculas</title>
    </head>
    <body>
        <h1>Peliculas</h1>
        <ul type="circle">
            
        </ul>
          <c:if test="${!empty peliculas}">
          <table frame="border" width="50%" border="1" >
            <tbody>
              <tr>
                <th>Titulo</th>
                <th>Fecha Estreno</th>
                <th>Sinopsis</th>
                <th>Estado</th>
            </tr>+
                <c:set var="contador" value="1" scope="page"/>
                <c:forEach var="item" items="${peliculas}">
                    
                    <c:if test="${contador%2 == 0}"><tr bgcolor="silver"></c:if>
                    <c:if test="${contador%2 != 0}"><tr bgcolor="white"></c:if>
                        <td> ${item.titulo} </td>
                        <td> ${item.fechaestreno} </td>
                        <td> ${item.sinopsis} </td>
                        <td> ${item.estado} </td>>
                    </tr>
                   
                    <c:set var="contador" value="${contador+1}" />
                </c:forEach>

            </tbody>
          </table>
          
        </c:if>
    </div>
</body>
</html>
