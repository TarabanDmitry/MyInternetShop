<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="orders" scope="request" type="java.util.List<mate.academy.internetshop.model.Order>"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ORDER!</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Items</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>
                <c:out value="${order.id}"/>
            </td>
            <td>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Items</th>
                    </tr>
                    <c:forEach var="item" items="${order.items}">
                        <tr>
                            <td>
                                <c:out value="${item.id}"/>
                            </td>
                            <td>
                                <c:out value="${item.name}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </c:forEach>
</table>
<p>
    <button onclick="location.href='/MyInternetShop_war_exploded/servlet/main_menu'"
            type="button">Back to menu
    </button>
</p>

</body>
</html>
