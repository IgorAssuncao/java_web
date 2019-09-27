<%-- 
    Document   : new_professor
    Created on : Sep 25, 2019, 9:39:20 PM
    Author     : igorassuncao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>New Professor</title>
        </head>
        <body>
            <div align="center">
                <h2>Selecione um usuario</h2>
                <form:form action="/professores/salvar" method="post" modelAttribute="professorModel">
                    <table>
                        <tr>
                            <td>Selecione o ID do usuario que sera cadastrado como professor: <br></td>
                            <td>
                                <form:select path="id_usuario">
                                    <c:forEach items="${listaUsuarios}" var="usuario">
                                        <form:option value="${usuario.id}" label="${usuario.id} - ${usuario.nome}"/>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Titulacao: </td>
                            <td>
                                <div align="center"><form:input path="titulacao" /></div>
                            </td>
                        </tr>
                    <tr><td><input type="submit" value="Save"></td></tr>
                    </table>
                </form:form>
                <table border="1" cellpadding="5">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Email</th>
                    </tr>
                    <c:forEach items="${listaUsuarios}" var="usuario">
                    <tr>
                        <td>${usuario.id}</td>
                        <td>${usuario.nome}</td>
                        <td>${usuario.email}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>
    </html>
</f:view>
