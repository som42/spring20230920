<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-26
  Time: 오전 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main13/sub3">
<%--  div*10>label[for=input$]>lorem1^input[type][name=param$][id=input$]--%>
  <div>
    <label for="input1">Lorem.</label>
    <input type="text" name="param1" id="input1">
  </div>
  <div>
    <label for="input2">Et?</label>
    <input type="number" name="param2" id="input2">
  </div>
  <div>
    <label for="input3">Quisquam.</label>
    <input type="password" name="param3" id="input3">
  </div>
  <div>
<%--    날짜 --%>
    <label for="input4">Aliquam?</label>
    <input type="date" name="param4" id="input4">
  </div>
  <div>
<%--    날짜 시간--%>
    <label for="input5">Consequuntur.</label>
    <input type="datetime-local" name="param5" id="input5">
  </div>
  <div>
    <label for="input6">Odit?</label>
    <input type="radio" name="param6" value="radio value1" id="input6">
  </div>
  <div>
    <label for="input7">Quas.</label>
    <input type="radio" name="param6" value="radio value2" id="input7">
  </div>
  <div>
    <label for="input8">Fuga.</label>
    <input type="checkbox" name="param8" value="pizza" id="input8">
  </div>
  <div>
    <label for="input9">Atque.</label>
    <input type="checkbox" name="param8" value="melon" id="input9">
  </div>
  <div>
    <label for="input10">Voluptatum.</label>
    <input type="checkbox" name="param8" value="coffee" id="input10">
  </div>
  <button>전송</button>
</form>
</body>
</html>
