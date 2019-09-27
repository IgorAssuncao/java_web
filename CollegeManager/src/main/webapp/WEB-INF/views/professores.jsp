<%-- 
    Document   : professores
    Created on : Sep 25, 2019, 10:06:17 PM
    Author     : igorassuncao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <div align="center">
                <h3><a href="/professores/newProfessor">New Professor</a></h3>
                <table border="1" cellpadding="5">
                    <tr>
                        <th>ID</th>
                        <th>Titulacao</th>
                        <th>ID_usuario</th>
                    </tr>
                    <c:forEach items="${listaProfessores}" var="professor">
                    <tr>
                        <td>${professor.id}</td>
                        <td>${professor.titulacao}</td>
                        <td>${professor.id_usuario}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </body>
    </html>
</f:view>
