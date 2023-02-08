<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>listado de personas</title>
    </head>
    <body>
        <h1>listado de personas</h1>
        <table border="1">
            <caption>listado de personas</caption>
            <tr>
                <th>Id persona</th>
                <th>nombre </th>
                <th>apellido </th>
                <th>email </th>
                <th>telefono </th>
            </tr>
            <c:forEach var="persona" items="${personas}">
                <tr>
                    <td>${persona.idPersona}</td>
                    <td>${persona.nombre}</td>
                    <td>${persona.apellido}</td>
                    <td>${persona.email}</td>
                    <td>${persona.telefono}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
