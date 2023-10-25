<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-10-24
  Time: 오후 4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<%-- 파싱 한거 출력중~--%>
<div>
<button onclick="ajax1()">button1</button>
<script>
  function ajax1(){
    axios.get("/main38/sub1");
  }
</script>
</div>
<div>
  <button onclick="ajax2()">button2</button>
  <script>
    function ajax2(){
      axios.get("/main38/sub2")
              // then 파라미터 하나 받을수 있다. 이름은 어떤걸로 하든 상관없다.

              .then(function (response){
                console.log("응답 받은 후 해야하는 일");
                console.log(response.data); // 서버로 부터 응답 받은거
                console.log(response.status);
                console.log(response.statusText);
                console.log(response.headers);
                console.log(response.config);
              });
    }
  </script>
</div>
<div>
  <button onclick="ajax3()">button3</button>
  <script>
    function ajax3(){
      axios.get("/main38/sub3")
              .then(function (res){
                console.log(res.data); // 응답받은 json 파싱 되서 들어간다.
                console.log(res.data.age);
                console.log(res.data.name);
              });
    }
  </script>
</div>
<div>
  <button onclick="ajax4()">button4</button>
  <script>
    function ajax4(){
      axios.get("/main38/sub4")
              .then(function (re){
                const data = re.data;
                // 응답된 json 데이터를 js object로 파싱 해서
                console.log(data);
                console.log(data.city);
                console.log(data.price);
                console.log(data.list[0]);
                console.log(data.birth);
              });
    }
  </script>
</div>
<div>
  <input type="text" id="input1" value="7">
  <button onclick="ajax5()">button5</button>
  <script>
    function ajax5(){
      const pid = document.querySelector("#input1").value;
      axios.get("/main38/sub5?id=" + pid)
              .then(function (response){
                const product = response.data;
                console.log(product.ProductID);
                console.log(product.ProductName);
                console.log(product.Unit);
                console.log(product.Price);
              })
    }
  </script>
</div>
<div>
  <button onclick="ajax6()">button6</button>
  <script>
    // then 메소드는 연속으로 쓸수 있게 차례대로 실행된다.
    // 들어간 함수에 아귀먼트를 정해줄수 있다. (직전 함수가 리턴한 값)
    function ajax6(){
      axios.get("/main38/sub2")
              .then(function (p){
                console.log("응답 완료 후 실행")
              })
              .then(function (p){
                console.log("그 다음 실행")
              })
              .then(function (p){
                console.log("또 그 다음 실행")
              })
    }
  </script>
</div>
<div>
  <button onclick="ajax7()">button7</button>
  <script>
      function ajax7(){
        axios.get("/main38/sub2")
                .then(function (){
                  console.log('첫 함수')
                  return "abcd"
                //   직전 함수의 리턴하는 값이 param에 들어간다.
                })
                .then(function (param){
                  console.log('두번째 함수')
                  console.log(param)
                  return 345;
                })
                .then(function (param){
                  console.log(param)
                })
      }
  </script>
</div>
<div>
  <button onclick="ajax8()">button8</button>
  <script>
    function ajax8(){
    axios.get("/main38/sub2")
            .then(function (param){
              console.log("첫 함수 일함")
              return param.data;
            })
            .then(function (param){
              console.log("두번째 함수 일함")
              console.log(param)
            })
    }
  </script>
</div>
<%-- => 함수로 해보기 --%>
<div>
  <button onclick="ajax9()">button9</button>
  <script>
    function ajax9() {
      axios.get("/main38/sub2")
              // 명령문이 한 줄이면 중괄호 생략, return도 생략가능
              // 파라미터 한개면 소 괄호도 생략 가능
              .then(response => response.data)
              .then(data => console.log(data));
    }
  </script>
</div>
<%--연습 항상 주소적을때 앞에 / 잘봐라 제발--%>
<div>
  <button onclick="ajax10()">button10</button>
  <script>
    function ajax10(){
      axios.get("/main38/sub4")
              .then(response => response.data)
              .then(data => console.log(data.list[1]))
    }
  </script>
</div>
<div>
  <button onclick="ajax11()">button11</button>
  <script>
    // 구조 분해 할때 파라미터가 하나라도 () 괄호 해줘야 한다.
    function ajax11(){
      axios.get("/main38/sub4")
              .then(response => response.data)
              .then(({price, birth, list, city}) => console.log(price)); //3000
    }
  </script>
</div>
<div>
  <button onclick="ajax12()">button12</button>
<script>
  function ajax12(){
    axios.get("/main38/sub4")
            // 첫번째 할당 받은게 있으면 두번째는 이렇게 쓰면된다.
            .then(({data}) => console.log(data.price));
  }
</script>
</div>
<div>
  <button onclick="ajax13()">button13</button>
  <script>
    function ajax13() {
      axios.get("/main38/sub4")
              .then(response => response.data)
              .then(({price, city, country = "korea"}) => {
                console.log(price); // 3000
                console.log(city); // seoul
                console.log(country); // korea
              })
    }
  </script>
</div>

<script>
<%--구조 분해 할당--%>
<%--Destructuring assignment--%>
  let a = {
    name: "son",
    age: 30
  };
  console.log(a.name); //어디선가 사용 할 때 이렇게
  console.log(a.age);

  // 다른곳에 할당하려고 하면
  let myName = a.name;
  let myAge = a.age;

  console.log(myName);
  console.log(myAge);

  // 분해 해서 한번에 할당 하자
  // a가 가지고 있는 2개의 프로퍼티지를 분해해서 중괄호 안에 넣자
  let {name, age} = a;  //destructuring assignment
  console.log(name);
  console.log(age);

  let b = {
    city: "seoul",
    country: "korea"
  };
  let {city, country} = b; // 구조 분해 할당 일어남
  console.log(city);
  console.log(country);

  let c = {
    email: "abc@gmail.com",
    price: 300
  };
  // let {email, price} = c; 꼭 구지 모든 프로퍼티를 분해안해두된다
 let {email} = c; // 부분만 할당해도 된다

  let d ={
    name2: "lee",
    address: "paris",
    age: 77
  }
  let{name2, address} = d;

  // category는 undefined 로 남아있다
  let e = {
    city2: "seoul",
    country2: "korea"
  }
  let {city2, country2, category} = e;
  console.log(city2);
  console.log(country2);
  console.log(category); // undefined

  // 없으면 기본 값을 주고 싶다 할때
  let f = {
    name3: "kim",
    city3: "busan"
  };

  let{name3, city3, address3 = "신촌"} = f; // 없을때 기본 값 할당
  console.log(name3);
  console.log(city3);
  console.log(address3);

  //배열 할당 해보기  배열은 괄호 [] 신경써서 하기
  let g = [30, 40, 50];

  let [h, i , j] = g; // destructuring assignment
  console.log(h);
  console.log(i);
  console.log(j);

  let [k, l] = g;
  console.log(k);
  console.log(l);
  //  나머지 모두다 활당하겠다 ...
  let [m, ...n] = g;
  console.log(m);  // [30]
  console.log(n); // [40, 50]

// g라는 배열을 복사해서 쓰겠다
  let [ ...o] =  g;
  console.log(o); // [30, 40, 50]

</script>
</body>
</html>
