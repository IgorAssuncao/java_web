<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Selecionar itens</title>
    </head>
    <body>
        <div align="center">
            <h2>Selecione os itens do cardapio para adicionar ao seu pedido</h2>
            <form:form action="/mesa/${mesa.idMesa}/pedido/${pedido.idPedido}/addItens" method="post" modelAttribute="pedido">
                <table border="1" cellpadding="3">
                    <tr>
                        <th></th>
                        <th>ID</th>
                        <th>Item</th>
                        <th>Preco (R$)</th>
                    </tr>
                    <c:forEach items="${itens}" var="item">
                        <tr>
                            <td><form:checkbox path="itens" value="${item.idItem}"/></td>
                            <td>${item.idItem}</td>
                            <td>${item.nome}</td>
                            <td>${item.preco}</td>
                        </tr>
                    </c:forEach>
                </table>
                <button type="submit" name="adicionarItens">Adicionar itens</button>
            </form:form>
        </div>
    </body>
</html>