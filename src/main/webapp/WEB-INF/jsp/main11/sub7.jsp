<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%-- main11/sub7 --%>
<%--데이터가 없습니다.--%>
    <c:if test="${empty moving}">
        <p>데이터가 없습니다</p>
    </c:if>
<%-- /main11/sub7?show=true --%>
<%-- table 형식의 데이터 출력 --%>
<c:if test="${not empty moving}">

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
</c:if>


<hr>
<h1>choose 태그 사용</h1>
<c:choose>
    <c:when test="${not empty moving}">
        <table>
            <tr>
                <th>ID</th>
                <th>FIRST NAME</th>
                <th>LAST NAME</th>
                <th>CLASS</th>
                <th>PHONE</th>
            </tr>
            <c:forEach items="${moving}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.firstName}</td>
                    <td>${item.lastName}</td>
                    <td>${item.className}</td>
                    <td>${item.phoneNumber}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h1>데이터가 없습니다.</h1>
    </c:otherwise>
</c:choose>




</body>
</html>
