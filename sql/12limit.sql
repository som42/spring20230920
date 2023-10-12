-- LIMIT 조회 레코드(행, row) 제한 오라클에는 없는거같당

SELECT * FROM customers;
-- 많은 고객들 중 에 3개만 뽑고 싶다
SELECT * FROM customers
LIMIT 3;
SELECT * FROM employees
LIMIT 2;

-- 나이가 가장 많은 직원 두사람을 뽑고 싶다
SELECT * FROM employees
ORDER BY BirthDate
LIMIT 2;
-- 가장 비싼 상품 10개 만 뽑고 싶다 .
SELECT * FROM products
ORDER BY Price DESC
LIMIT 10;

-- 예제 가장 어린 3명의 직원 조회
SELECT * FROM employees
ORDER BY BirthDate DESC
LIMIT 3;
-- 2번 카테고리 에서 가장 저렴한 상품 조회
SELECT * FROM products
WHERE CategoryID = 2
ORDER BY Price
LIMIT 1;

-- LIMIT n : n 개
-- LIMIT n , m : n부터 m 개 ( n은 0 부터)
SELECT ProductName, Price
FROM products
ORDER BY Price
LIMIT 0, 3; -- 0 ~부터 3까지

-- 페이지 나누기
SELECT CustomerID, CustomerName
FROM customers
ORDER BY CustomerID; -- 91개 row
-- 10개씩 끊어서 보여주고 싶다
SELECT CustomerID, CustomerName
FROM customers
ORDER BY CustomerID
LIMIT 0, 10; -- 1페이지
SELECT CustomerID, CustomerName
FROM customers
ORDER BY CustomerID
LIMIT 20, 10; -- 2페이지
SELECT CustomerID, CustomerName
FROM customers
ORDER BY CustomerID
LIMIT 30, 10; -- 3페이지

-- 예제 공급자를 한 페이지에 5개씩 공급자 번호 순으로 보여줄 때
-- 3번째 페이지 조회 코드 작성
SELECT * FROM suppliers
ORDER BY SupplierID
LIMIT 10, 5;

-- 한페이지가 n개의 레코드를 보여주면
-- m 번째 페이지 조회
-- LIMIT (m-1)*n, n
