<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오후 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${personMap.person1.lastName}</h3>
<h3>${personMap.person2.lastName}</h3>

<hr>

<%--키가 앞에 숫자로 시작할때일때는 [""}해주고 뒤에 . 은 상관없다--%>
<h3>${people["1st"].lastName}</h3>
<h3>${people["2nd"].lastName}</h3>

</body>
</html>
