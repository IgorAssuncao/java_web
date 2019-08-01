<%--
  Created by IntelliJ IDEA.
  User: igorassuncao
  Date: 2019-08-01
  Time: 07:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <div>
      <form action="/Form_war_exploded/FormViewServlet" method="GET">
        <table>
          <tr>
            <td>Name: </td>
            <td><input type="text" name="name"></td>
          </tr>
          <tr>
            <td>E-mail: </td>
            <td><input type="text" name="email"></td>
          </tr>
          <tr>
            <td>Address: </td>
            <td><input type="text" name="address"></td>
          </tr>
          <tr>
            <td>UF:</td>
            <td>
              <select name="uf">
                <option value="rj">RJ</option>
                <option value="sp">SP</option>
                <option value="mg">MG</option>
                <option value="es">ES</option>
              </select>
            </td>
          </tr>
          <tr>
            <td><input type="submit" name="submit" value="Submit"></td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>
