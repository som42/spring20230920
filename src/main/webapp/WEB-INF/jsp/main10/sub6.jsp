<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<style>
    table{
        margin: 5%;
        border-collapse: collapse;
        border: 1px solid pink;
        width: 50%;
        text-align: center;
        color: deeppink;

    }
    th{
        background: pink;
    }
    th ,td{
        padding: 5px;
        border: 2px solid pink;
    }
</style>
<head>
    <table>
        <tr>
            <td>나이</td>
            <td>성함</td>
            <td>이름</td>
            <td>지역</td>
            <td>번호</td>
        </tr>
        <c:forEach items="${moving}" var="f">

        <tr>
            <td>${f.id}</td>
            <td>${f.firstName}</td>
            <td>${f.lastName}</td>
            <td>${f.className}</td>
            <td>${f.phoneNumber}</td>
        </tr>
        </c:forEach>
    </table>

</head>
</html>
