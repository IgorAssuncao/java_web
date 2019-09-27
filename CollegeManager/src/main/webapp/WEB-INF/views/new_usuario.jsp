<%--
  Created by IntelliJ IDEA.
  User: igorassuncao
  Date: 2019-09-23
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>New Customer</title>
</head>
<body>
    <div align="center">
        <h2>New Customer</h2>
        <form:form action="/usuarios/newUsuarioPost" method="post" modelAttribute="usuarioModel">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Matricula </td>
                    <td><form:input type="text" path="matricula" /></td>
                </tr>
                <tr>
                    <td>Nome: </td>
                    <td><form:input path="nome" /></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><form:input type="email" path="email" /></td>
                </tr>
                <tr>
                    <td>Senha: </td>
                    <td><form:input type="password" path="senha" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
