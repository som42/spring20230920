<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>empty</h2>
<p>null, 빈 문자열, 사이즈 가0인 콜렉션 이면 true 값이 없는걸 판단하고 싶을때! </p>
<p>\${empty a} : ${empty a}</p>
<p>\${empty b} : ${empty b}</p>
<p>\${empty c} : ${empty c}</p>
<p>\${empty d} : ${empty d}</p>
<p>\${empty e} : ${empty e}</p>
<p>\${empty f} : ${empty f}</p>
<p>\${empty g} : ${empty g}</p>
<p>\${empty h} : ${empty h}</p>

<br>

<h2>not empty ( ! empty)</h2>
<p>null 아닌 속성, 길이가 1 이상인 콜렉션/문자열 true</p>
<p>\${! empty a} : ${ ! empty a}</p>
<p>\${! empty b} : ${ ! empty b}</p>
<p>\${! empty c} : ${ ! empty c}</p>
<p>\${! empty d} : ${ ! empty d}</p>
<p>\${not empty e} : ${not empty e}</p>
<p>\${not empty f} : ${not empty f}</p>
<p>\${not empty g} : ${not empty g}</p>
<p>\${not empty h} : ${not empty h}</p>

</body>
</html>
