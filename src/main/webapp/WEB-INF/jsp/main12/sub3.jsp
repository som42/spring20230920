<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오후 4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main12/sub4">
<%--    (inpuy[name]+br)*2+button{전송}--%>
    <input type="text" name="name"></input>
    <br>
    <input type="text" name="age"></input>
    <br>
    <button>전송</button>
</form>
</body>
</html>
