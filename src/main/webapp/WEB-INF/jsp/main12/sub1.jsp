<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-25
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> form 요소 </h1>
<form>
    <input type="text" name="param1">
    <br>
    <input type="text" name="param2">
    <%--    select(option) , textarea - --%>
    <button>검색</button>
</form>

<hr>

<%--
전송 버튼 클릭시
?name=lee&age=44&address=seoul&email=abc@naver.com
--%>
<form>
<%--    (input[name]+br)*4--%>
    <input type="text" name="name">
    <br>
    <input trye="text" name="age">
    <br>
    <input trye="text" name="address">
    <br>
    <input trye="text" name="email">
    <button>검색버튼</button>
</form>
<hr>
<h3>action 속성 : request 파라미터들을 어디로 보낼 지 결정</h3>
<p>action 속성이 없거나 빈문자열일 경우 현재경로 </p>
<form action="http://www.naver.com">
    <input type="text" name="query">
    <br>
    <button>전송!</button>
</form>

<form action="https://search.daum.net/search">
    <input type="text" name="q">
    <br>
    <button>전승</button>
</form>
<form action="https://search.daum.net/search?">
    <input type="text" name="q">
    <button>다음</button>
</form>

<hr>
<h1>action 속성값 : /로 시작할 경우 path가 결정됨</h1>
<form action="/"></form>
    <input type="text" name="email">
    <button>쓔웅~</button>

<%--전송버튼 클릭시 request parameter가 /main12/sub2 로 전송되도록--%>
<form action="/main1/sub2">
    <input type="text" name="zzzoo42">
    <button>전송!</button>
</form>

<hr>
<h1>action 속성 값 : /도 아니고 protocol(scheme)이 아니면 현재페이지 상대경로</h1>
<h1>경로(path)에서  마지막 / 기준(현재경로 기준)</h1>
<form action="/main1/sub2">
    <input type="text" name="email">
    <button>❤️❤️❤️</button>
</form>

<form action="sub3">
    <input type="text" name="address">
    <button>전송</button>
</form>

<%-- .. : 한경로 위 --%>
<form action="..">
    <input type="text" name="age">
    <button>전송!</button>
</form>
</body>
</html>
