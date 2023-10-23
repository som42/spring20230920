<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-23
  Time: 오후 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
<%--Axios를 쓸려면 이 src가 필요하다 --%>
  <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<div>
<%--    onclick ajax함수 실행시키는 코드--%>
    <button onclick="ajax()">button1</button>
</div>
<script>
  function ajax(){
      https://axios-http.com/docs/req_config
    axios.request({ // 함수를 사용하여 요청을 보낸다.
        url: "/main35/sub2" // url 속성에 요청보낼 엔드포인트 경로 설정
    });
  }
</script>

<div>
    <button onclick="ajax2()">button2</button>
    <script>
        function ajax2(){
            axios.request({
                url:"/main35/sub3?address=seoul"
            })
        }
    </script>
</div>
<div>
    <button onclick="ajax3()">button3</button>
    <script>
        function ajax3(){
            axios.request({
                url:"/main35/sub4",
                // 쿼리에 붙는 값들은 params 로 붙여주면된다.
                params:{
                    address: "seoul",
                    name: "son",
                    age: 33,
                    email: "abc@naver.com"
                }
            });
        }
    </script>
</div>
<div>
    <button onclick="ajax4()">button4</button>
    <script>
        function ajax4(){
            axios.request({ //이 메소드 사용하여 get요청을 보낸다
                url:"/main35/sub5",
                params:{ // 객체가 포함되어 있으면 키와 해당값들이 포함되어있다.
                    city: "마산",
                    id: "1",
                    score: "100.0",
                    country: "대한민국"
                }
            });

        }
    </script>
</div>
<div>
    <div>
        <input type="text" id="input1" value="서울">
    </div>
    <div>
        <input type="text" id="input2" value="33">
    </div>
    <div>
        <input type="text" id="input3" value="88.7">
    </div>
    <div>
        <input type="text" id="input4" value="한국">
    </div>
    <div>
        <button onclick="ajax5()">button5</button>
        <script>
            function ajax5() {
                // const 통해 변수 선언
                const city = document.querySelector("#input1").value;
                const id = document.querySelector("#input2").value;
                const score = document.querySelector("#input3").value;
                const country = document.querySelector("#input4").value;
                axios.request({
                    url: "/main35/sub5",
                    params: {
                        city: city,
                        id: id,
                        score: score,
                        country: country
                    }
                });
            }
        </script>
    </div>
</div>
<div>
    <%--div*4>input#input$@5--%>
    <div>
        <input type="text" id="input5">
    </div>
    <div>
        <input type="text" id="input6">
    </div>
    <div>
        <input type="text" id="input7">
    </div>
    <div>
        <input type="text" id="input8">
    </div>
    <div>
        <button onclick="ajax6()">button6</button>
        <script>
            function ajax6() {
                const address = document.querySelector("#input5").value;
                const name = document.querySelector("#input6").value;
                const age = document.querySelector("#input7").value;
                const email = document.querySelector("#input8").value;
                axios.request({
                    url: "/main35/sub4",
                    params: {
                        address,
                        name,
                        age,
                        email
                    }
                })
            }
        </script>
    </div>
</div>
<%-- 자바빈 으로 해보기 --%>
<div>
    <button onclick="ajax7()">button7</button>
    <script>
        function ajax7() {
            axios.request({
                url: "/main35/sub6",
                params: {
                    eid: 9,
                    lastName: "손",
                    firstName: "흥민"
                }
            })
        }
    </script>
</div>
<div>
    <button onclick="ajax8()">button8</button>
    <script>
        function ajax8() {
            axios.request({
                url: "/main35/sub7",
                method: "post"
            })
        }
    </script>
</div>
<%--post 방식은 요롷게 요청하면된다 --%>
<div>
    <button onclick="ajax9()">button9</button>
    <script>
        function ajax9() {
            axios.post("/main35/sub7")
        }
    </script>
</div>
<div>
    <button onclick="ajax10()">button10</button>
    <script>
        // city=서울&country=한국
        // headers: { 'content-type': 'application/x-www-form-urlencoded' },
        function ajax10(){
            axios.post("/main35/sub8",{
                city: "seoul",
                country: "korea"
            }, {
                headers: {
                    "content-type": "application/x-www-form-urlencoded"
                }
            });
        }
    </script>
</div>
<%-- --%>
<div>
    <div>
        <input type="text" id="input9">
    </div>
    <div>
        <input type="text" id="input10">
    </div>
    <div>
        <input type="text" id="input11">
    </div>
    <div>
        <button onclick="ajax11()">button11</button>
        <script>
            function ajax11() {
                const eid = document.getElementById("input9").value;
                const lastName = document.getElementById("input10").value;
                const firstName = document.getElementById("input11").value;
                axios.post("/main35/sub9", {
                    eid, lastName, firstName
                }, {
                    headers: {
                        "content-type": "application/x-www-form-urlencoded"
                    }
                })
            }
        </script>
    </div>
</div>

<%-- 파일 넘기기 --%>
<div>
    <div>
        <input type="text" id="input12" value="한여름">
    </div>
    <div>
        <input type="file" multiple id="input13" accept="image/*">
    </div>
    <div>
        <button onclick="ajax12()">button12</button>
        <script>
            function ajax12(){
                axios.postForm("/main35/sub10",{
                    name: document.querySelector("#input12").value,
                    files: document.querySelector("#input13").files
                });
            }
        </script>
    </div>

</div>
</body>
</html>
