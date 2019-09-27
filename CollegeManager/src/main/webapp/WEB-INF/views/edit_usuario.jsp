<%--
  Created by IntelliJ IDEA.
  User: igorassuncao
  Date: 2019-09-24
  Time: 07:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Customer</title>
</head>
<body>
<div align="center">
    <h2>Edit Customer</h2>
    <form:form action="/usuarios/salvar" method="post" modelAttribute="usuarioModel">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${customer.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>Nome: </td>
                <td><form:input path="nome" /></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
