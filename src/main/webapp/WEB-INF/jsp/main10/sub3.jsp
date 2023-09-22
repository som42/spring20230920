<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오후 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%--코어태그--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>${person1.id}</h2>
<h2>${person1.name}</h2>
<h2>${person1.foods[0]}</h2>
<h2>${person1.foods[1]}</h2>
<h2>${person1.foods[2]}</h2>
<%--foods는 배열이라서 이렇게한다--%>

<hr>

<h3>${person1.cars[0]}</h3>
<h3>${person1.cars[1]}</h3>
<h3>${person1.cars[2]}</h3>

<hr>
<c:forEach items="${person1.cars}" var="car">
    <h3>${car}</h3>
</c:forEach>

<hr>
<%-- 배열을 반복하고 싶을때 forEach를 쓰면된다.--%>
<c:forEach items="${person1.foods}" var="food">
    <h3>${food}</h3>
</c:forEach>



</body>
</html>
