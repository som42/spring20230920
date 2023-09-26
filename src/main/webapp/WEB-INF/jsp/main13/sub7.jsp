<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-26
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main13/sub8">
    <div>
        <lable for="input1">아이디</lable>
        <input type="text" id="input1" name="id">
    </div>
    <div>
        <lable for="input2">이름</lable>
        <input type="text" id="input2" name="name">
    </div>
    <div>
        <lable for="input3">주소</lable>
        <input type="text" id="input3" name="address">
    </div>
    <div>
        <lable for="input4">일정</lable>
        <input type="datetime-local" id="input4" name="schedule">
    </div>
    <div>
        <lable for=" input5">한국</lable>
        <input type="checkbox" id=" input5" name="todos" value="한국">
    </div>
    <div>
        <lable for=" input6">미국</lable>
        <input type="checkbox" id=" input6" name="todos" value="미국">
    </div>
    <div>
        <lable for=" input7">영국</lable>
        <input type="checkbox" id=" input7" name="todos" value="영국">
    </div>
    <button>❤️😊❤️</button>
</form>
</body>
</html>
