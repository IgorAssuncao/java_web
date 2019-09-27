<%-- 
    Document   : error_search_usuario
    Created on : Sep 25, 2019, 12:44:25 PM
    Author     : igorassuncao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Error Delete Usuario</title>
        </head>
        <body>
            <div align="center">
                <h1><h:outputText value="Usuario nao deletado"/></h1>
                <a href="/usuarios"/>Voltar</a>
            </div>
        </body>
    </html>
</f:view>
