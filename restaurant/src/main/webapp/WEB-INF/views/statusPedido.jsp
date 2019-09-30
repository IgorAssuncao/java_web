<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Novo Pedido</title>
    </head>
    <body>
        <div align="center">
            <h2>Estes itens estao no seu pedido</h2>
            <table border="1" cellpadding="3">
                <tr>
                    <th>ID</th>
                    <th>Item</th>
                    <th>Preco (R$)</th>
                </tr>
                <c:forEach items="${pedido.itens}" var="item">
                    <tr>
                        <td>${item.idItem}</td>
                        <td>${item.nome}</td>
                        <td>${item.preco}</td>
                    </tr>
                </c:forEach>
            </table>
            <h4>Preco total: R$ ${pedido.precoTotal}</h4>
            <form:form action="/mesa/${mesa.idMesa}/pedido/${pedido.idPedido}/selecionarItens" method="get" modelAttribute="pedido">
                <button type="submit" name="novoPedido">Adicionar itens</button>
            </form:form>
            <form:form action="/mesa/${mesa.idMesa}/pedido/${pedido.idPedido}/fecharPedido" method="post" modelAttribute="pedido">
                <button type="submit" name="fecharPedido">Fechar pedido</button>
            </form:form>
        </div>
    </body>
</html>