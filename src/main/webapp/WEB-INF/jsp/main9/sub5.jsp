<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-22
  Time: 오전 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--네모가로 쓸때 "" 까먹지 마라--%>
<h3>${caps.korea}</h3>
<h3>${caps["korea"]}</h3>

<hr>
<%--${모델이름. 키이름}--%>
<h3>${phones["phone1"]}</h3>
<h3>${caps.us}</h3>
<h3>${foods["2nd"]}</h3>

</body>
</html>
