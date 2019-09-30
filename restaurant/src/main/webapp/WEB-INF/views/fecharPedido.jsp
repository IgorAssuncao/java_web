<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Novo Pedido</title>
    </head>
    <body>
        <div align="center">
            <h2>Dirija-se ao caixa para efetuar o pagamento do seu pedido</h2>
            <h3>Resumo do seu pedido.</h3>
            <h4>Sua mesa: ${mesa.idMesa}</h4>
            <h4>Numero do seu pedido: ${pedido.idPedido}</h4>
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
        </div>
    </body>
</html>