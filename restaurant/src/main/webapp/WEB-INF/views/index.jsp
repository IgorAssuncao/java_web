<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <div align="center">
            <h2>Cardapio</h2>
            <table border="1" cellpadding="3">
                <tr>
                    <th>ID</th>
                    <th>Item</th>
                    <th>Preco (R$)</th>
                </tr>
                <c:forEach items="${itens}" var="item">
                    <tr>
                        <td>${item.idItem}</td>
                        <td>${item.nome}</td>
                        <td>${item.preco}</td>
                    </tr>
                </c:forEach>
            </table>
            <h3>Selecione sua mesa</h3>
            <form:form action="/mesa" method="post" modelAttribute="mesa">
                <table border="1" cellpadding="3">
                    <tr>
                        <th></th>
                        <th>Mesa</th>
                    </tr>
                    <c:forEach items="${mesas}" var="mesa">
                        <tr>
                            <td><form:radiobutton path="idMesa" value="${mesa.idMesa}" /></td>
                            <td>${mesa.idMesa}</td>
                        </tr>
                    </c:forEach>
                </table>
                <br />
                <button type="submit">Prosseguir</button>
            </form:form>
        </div>
    </body>
</html>