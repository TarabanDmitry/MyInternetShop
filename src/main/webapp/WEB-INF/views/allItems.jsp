<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="items" scope="request" type="java.util.List<mate.academy.internetshop.model.Item>"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Items</title>
</head>
<body>
Welcome to All Items page!<br>
All Items :
<table border="1">
    <tr>
        <th>ID</th>
        <th>Item Name</th>
        <th>Price</th>
        <th>Add to Bucket</th>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>
                <c:out value="${item.id}"/>
            </td>
            <td>
                <c:out value="${item.name}"/>
            </td>
            <td>
                <c:out value="${item.price}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/servlet/addItemToBucket?item_id=${item.id}">Add in
                    bucket</a>
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
