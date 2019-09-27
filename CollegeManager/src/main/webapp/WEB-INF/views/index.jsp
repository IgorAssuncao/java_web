<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <div align="center">
            <h2>Home</h2>
            <c:if test="${true}" var="errorLogin">
                <span>Email ou senha incorretos</span>
            </c:if>
            <form:form action="/login" method="post" modelAttribute="usuario">
                Email: <input type="text" name="email" /> &nbsp; <br>
                Senha: <input type="password" name="senha" /> &nbsp; <br>
                <input type="submit" value="Login" />
            </form:form>
            <h3><a href="/usuarios/newUsuario">Cadastre-se</a></h3>
        </div>
    </body>
</html>
