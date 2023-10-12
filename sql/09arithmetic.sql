SELECT Price FROM products WHERE ProductID = 1;
SELECT Price + 1 FROM products WHERE ProductID = 1;
SELECT Price - 10.5 FROM products WHERE ProductID = 1;
SELECT Price * 3 FROM products WHERE ProductID = 1;
SELECT Price / 5 FROM products WHERE ProductID = 1;


SELECT ProductName, Price FROM products;
SELECT ProductName, Price * 2 FROM products;

-- String 에는 문자열 연결 연산은 안됨
-- 문자열 연결은 CONCAT를 사용 하면 된다.
-- 다른 데이터 베이스를 쓰면 제공 되는 연산자를 찾아야 한다.
SELECT CONCAT(ProductName, 1), Price FROM  products;

-- 1968-12-08
SELECT LastName, BirthDate FROM employees WHERE EmployeeID = 1;
-- 19681209 생일을 수로 변환 할려고 노력 한 것
SELECT LastName, BirthDate + 1 FROM employees WHERE EmployeeID = 1;

-- 날짜를 더하고 빼는 내장 함수는 따로 있다.
-- 날짜 변경 함수 사용 ADDDATE
SELECT LastName, ADDDATE(BirthDate, INTERVAL 1 DAY )
FROM employees
WHERE EmployeeID = 1;


SELECT * FROM employees;
SELECT EmployeeID, LastName, FirstName FROM employees;
SELECT EmployeeID, CONCAT(LastName, FirstName) FROM employees;
SELECT EmployeeID, CONCAT(LastName,' ', FirstName) FROM employees;
SELECT EmployeeID,
       CONCAT(LastName, ' ', FirstName),
       ADDDATE(BirthDate, INTERVAL 1 YEAR)
FROM employees;

-- 주문수량 * 2 결과 조회
SELECT Quantity * 2 FROM orderdetails;
-- city, country 고객 테이블 조회
SELECT CONCAT(City,' , ', Country) FROM customers;


