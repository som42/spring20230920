<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-05
  Time: 오후 4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Country</th>
        <th>name</th>
    </tr>
    <c:forEach items="${country}" var="con">
        <tr>
            <td>${con.country}</td>
            <td>${con.name}</td>
        </tr>
    </c:forEach>
</table>



</body>
</html>
