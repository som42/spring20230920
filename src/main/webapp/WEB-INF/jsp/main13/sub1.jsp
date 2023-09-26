<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-09-26
  Time: 오전 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>input 요소들</h3>
<form action="/main13/sub2">
<%--    div*10>input[name=param$] --%>
    <div>
        <input type="text" name="param1">
    </div>
    <div>
        <input type="password" name="param2">
    </div>
    <div>
        <input type="date" name="param3">
    </div>
    <div>
        <input type="button" name="param4" value="어떤 버튼">
    </div>
    <div>
        <input type="number" name="param5">
    </div>
    <div>
<%--        버튼과 같은 역활을 한다.--%>
        <input type="submit" name="param6" value="회원가입">
    </div>
    <div>
<%--        라디오는 같은 이름에 radio면 둘중에 하나선택가능--%>
        <input type="radio" name="param7">
    </div>
    <div>
        <input type="radio" name="param7">
    </div>
    <div>
        <input type="checkbox" name="param9">
    </div>
    <div>
        <input type="checkbox" name="param9">
    </div>
    <div>
<%-- 사용자한테는 입력받기 싫고 전송하고 싶을때 쓰면된다.--%>
        <input type="hidden" name="param10" value="some value">
    </div>
    <button>전송</button>
</form>

<hr>

<form action="/main13/sub2">
    <div>
<%--        벨류는 기본값--%>
        <input type="text" name="param1" value="son">
    </div>
    <div>
<%--        입력해야하는 값의 힌트--%>
        <input type="text" name="param2" placeholder="이름을 입력해주세요">
    </div>
    <div>
<%--        입력할 값의 길이 제한--%>
        <input type="text" maxlength="5">
    </div>
    <div>
<%--        필수로 입력해야한다--%>
        <input type="text" required>
    </div>
    <div>
<%--        읽기만 가능--%>
        <input type="text" name="param3" readonly value="son">
    </div>
    <div>
<%--        값을 전송할수도 없고 읽을수뿐없다--%>
        <input type="text" name="param4" value="son" disabled>
    </div>
    <div>
<%--        정규 표현식 넣어서 패턴에맞는지조건을 줄수있따--%>
        <input type="text" pattern="\d{3}" name="param5">
    </div>
<%--    div*2>input:c--%>
    <div>
<%--        로딩하자마자 체크된 상태면 좋겠다--%>
        <input type="checkbox" name="param6" checked id="">
    </div>
    <div>
        <input type="checkbox" name="param6" id="">
    </div>
    <div>
        <input type="radio" name="param7" id="">
    </div>
    <div>
        <input type="radio" name="param7" id="">
    </div>
    <div>
        <input type="file" multiple>
    </div>
    <button>전송</button>
</form>

<hr>

<form action="/main13/sub2">
    <label for="input1">
        주소
    </label>
    <input id="input1" type="text">
    <br>
<%--    div>div*3>label[for=check$]>lorem1^input:c#check$--%>
    <div>
        <div>
            <label for="check1">Lorem.</label>
            <input type="checkbox" name="" id="check1">
        </div>
        <div>
            <label for="check2">Sit?</label>
            <input type="checkbox" name="" id="check2">
        </div>
        <div>
            <label for="check3">Vitae?</label>
            <input type="checkbox" name="" id="check3">
        </div>
    </div>
<%--    전송버튼 종료 태그가 없다--%>
    <input type="submit">
</form>
</body>
</html>
