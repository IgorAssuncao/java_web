<%-- 
    Document   : alunos
    Created on : Sep 25, 2019, 10:06:09 PM
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
            <title>New Aluno</title>
        </head>
        <body>
            <div align="center">
                <h3><a href="/alunos/newAluno">New Aluno</a></h3>
                <table border="1" cellpadding="5">
                    <tr>
                        <th>ID</th>
                        <th>Id_usuario</th>
                        <th>Id_curso</th>
                    </tr>
                    <c:forEach items="${listaAlunos}" var="aluno">
                    <tr>
                        <td>${aluno.id}</td>
                        <td>${aluno.id_usuario}</td>
                        <td>${aluno.id_curso}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>
    </html>
</f:view>
