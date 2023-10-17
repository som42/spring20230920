-- HAVING : 그룹 함수 연산 결과를 조건으로 줄 수 있는 키워드
USE w3schools;
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


-- HAVING
-- 집계 함수 뒤에 연산 함수를 적을수 있다.
SELECT c.CustomerName, SUM(p.Price * od.Quantity) `총 주문 금액`
FROM customers c
         JOIN orders o
              ON c.CustomerID = o.CustomerID
         JOIN orderdetails od
              ON o.OrderID = od.OrderID
         JOIN products p
              ON p.ProductID = od.ProductID
GROUP BY c.CustomerID
HAVING `총 주문 금액` >= 100000
ORDER BY `총 주문 금액` DESC ;

-- 예) 총 처리 금액 10만 달러 미만인 직원 조회
-- orders, orderDetails, products, employees
SELECT e.FirstName, SUM(p.Price * od.Quantity) `총 처리 금액`
FROM orders o
    JOIN orderdetails od
    ON o.OrderID = od.OrderID
    JOIN products p
    ON p.ProductID = od.ProductID
    JOIN employees e
    ON e.EmployeeID = o.EmployeeID
GROUP BY e.EmployeeID
HAVING `총 처리 금액` < 100000
ORDER BY `총 처리 금액` DESC ;
