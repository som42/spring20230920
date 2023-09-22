<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach begin="0" end="3" var="i">
  <p>${foodList[i]}</p>
</c:forEach>

<hr>
<%-- name 두자리 이름이 같아야 한다--%>
<C:forEach items="${names}" var="name">
    <li>name : ${name}</li>
</C:forEach>

<hr>
<style>
    .box{
        border: 1px solid black;
        margin: 5px;
        padding: 10px;
        display: flex;
        /*justify-content: space-between;*/
        gap: 10px;
    }
    .box > div{
        border: 2px solid orange;
    }
</style>

<%-- varStatus : 반복문의 상태 --%>
<c:forEach begin="0" end="3" var="n" varStatus="status">
<%--    div.box>div.content1+div.content2 --%>
    <div class="box">
        <div class="content1"></div>
         n : ${n}
        <div class="content2"></div>
        <div>count : ${status.count}</div>
        <div>index : ${status.index}</div>
        <div>current : ${status.current}</div>
        <div>first : ${status.first}</div>
        <div>last : ${status.last}</div>
<%-- status 관한 객체다       --%>
    </div>
</c:forEach>

<hr>

<c:forEach items="${names}" var="name" varStatus="status">
    <div class="box">
        <div>name : ${name}</div>
        <div>
            <div>count : ${status.count}</div>
            <div>index : ${status.index}</div>
            <div>current : ${status.current}</div>
            <div>first : ${status.first}</div>
            <div>last : ${status.last}</div>
        </div>
    </div>
</c:forEach>

</body>
</html>
