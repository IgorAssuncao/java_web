<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Novo Pedido</title>
    </head>
    <body>
        <div align="center">
            <h2>Cardapio</h2>
            <form:form action="/mesa/${mesa.idMesa}/pedido/novoPedido" method="post" modelAttribute="pedido">
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
                <button type="submit" name="novoPedido">Novo Pedido</button>
            </form:form>
        </div>
    </body>
</html>