<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오후 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>jstl choose, when, otherwise tag</h1>
<c:choose>
<%-- 처음만나는 true만 실행되고 나머지는 실행안됨--%>
    <c:when test="${false}">
        <p>when 1번</p>
    </c:when>
    <c:when test="${false}">
        <p>when 2번</p>
    </c:when>
    <c:when test="${false}">
        <p>when 3번</p>
    </c:when>
<%-- 모든게 false면 otherwise로 내용을 넣을수있다.--%>
    <c:otherwise>
        <p>otherwise 태그 내용</p>
    </c:otherwise>

</c:choose>

</body>
</html>
