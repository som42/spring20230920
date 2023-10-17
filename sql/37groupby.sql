-- 소계 : 그룹 별로 집계 함수를 쓰고 싶을때
-- 예를 들면 1공장에 매출액 2공장에 매출액 전체 총액
-- GROUP BY : 그룹 함수 사용 시 그룹 함수의 범위(그룹) 지정
USE w3schools;
SELECT * FROM products;
SELECT MAX(Price)FROM products;
-- 같은 카테고리 id를 가진 애들 끼리 중에 가장 높은것
-- 그룹 함수를 썼을때는 카테고리 아이디 쓰는게 의미가 있다.
SELECT CategoryID, MAX(Price)
FROM products
GROUP BY CategoryID;
-- 카테고리 아이디로 가장 싼거! 가장비싼거
SELECT CategoryID,MAX(Price), MIN(Price)
FROM products
GROUP BY CategoryID;
SELECT CategoryID, MAX(Price) m, MIN(Price) mi
FROM products
GROUP BY CategoryID
-- 비싼거 순서대로 정렬하겠다.
ORDER BY m DESC ;

-- 일별 매출액을 구해보겠다
SELECT o.OrderDate, SUM(p.Price * od.Quantity) AS 매출액
FROM products p
    JOIN orderdetails od
    ON p.ProductID = od.ProductID
    JOIN orders o
    ON o.OrderID = od.OrderID
GROUP BY o.OrderDate
ORDER BY o.OrderDate ;

-- 예) 직원별 주문 처리액 조회
-- 직원명, 직원별 주문 처리액
SELECT e.FirstName, SUM(p.Price * od.Quantity) `총 처리 금액`
FROM products p
    JOIN orderdetails od
    ON p.ProductID = od.ProductID
    JOIN orders o
    ON o.OrderID = od.OrderID
    JOIN employees e
    ON e.EmployeeID = o.EmployeeID
WHERE o.OrderDate >= '1996-08-01' AND o.OrderDate < '1996-09-01'
GROUP BY e.EmployeeID
ORDER BY `총 처리 금액` DESC ;

-- 예) 고객별 총 주문 금액 조회
-- 고객명, 고객별 주문 금액
SELECT c.CustomerName, SUM(p.Price * od.Quantity) `총 주문 금액`
FROM customers c
    JOIN orders o
    ON c.CustomerID = o.CustomerID
    JOIN orderdetails od
    ON o.OrderID = od.OrderID
    JOIN products p
    ON p.ProductID = od.ProductID
GROUP BY c.CustomerID
ORDER BY 2 DESC ; -- 가장 높은애부터 조회하겠땅

-- 10만 달러 이상 쓴 고객 조회
-- 서브 쿼리로 잘써서 해도 된당.
SELECT * FROM
(SELECT c.CustomerName, SUM(p.Price * od.Quantity) `총 주문 금액`
FROM customers c
         JOIN orders o
              ON c.CustomerID = o.CustomerID
         JOIN orderdetails od
              ON o.OrderID = od.OrderID
         JOIN products p
              ON p.ProductID = od.ProductID
GROUP BY c.CustomerID) t1
WHERE t1.`총 주문 금액` >= 100000;




