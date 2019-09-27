<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Usuarios</title>
    </head>
    <body>
        <div align="center">
            <h2>Usuarios</h2>
            <h3><a href="/alunos">View alunos</a></h3>
            <h3><a href="/professores">View professores</a></h3>
            <table border="1" cellpadding="5">
                <tr>
                    <th>ID</th>
                    <th>Matricula</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${listaUsuarios}" var="usuario">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.matricula}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.email}</td>
                        <td>
                            <a href="/usuarios/editUsuario/${usuario.id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="/usuarios/deleteUsuario/${usuario.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            </div>
    </body>
</html>
