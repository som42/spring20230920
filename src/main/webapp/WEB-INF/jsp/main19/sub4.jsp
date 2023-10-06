<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-04
  Time: 오후 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="border-collapse: collapse; border: 1px solid black; width: 100%">
    <tr>
        <th style="background-color: #eeeeee">ID</th>
        <th style="background-color: #eeeeee">NAME</th>
        <th style="background-color: #eeeeee">CITY</th>
        <th style="background-color: #eeeeee">COUNTRY</th>
    </tr>
<c:forEach items="${customers}" var="customers">
    <tr>
        <td>${customers.id}</td>
        <td>${customers.name}</td>
        <td>${customers.city}</td>
        <td>${customers.country}</td>
    </tr>
</c:forEach>
</body>
</html>
