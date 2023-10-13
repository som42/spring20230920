USE w3schools;

-- 주문한적 없는 고객을 뽑아 와라

-- 근데 내가 조인을 몰랏다면
SELECT CustomerID FROM orders
ORDER BY 1;

SELECT CustomerName
FROM customers
WHERE CustomerID NOT IN (SELECT CustomerID FROM orders
                         ORDER BY 1);

-- 근데 우리는 조인을 아니깐
SELECT c.CustomerName
FROM customers c LEFT JOIN orders o
    ON c.CustomerID = o.CustomerID -- 주문한적 있는 고객들
    WHERE o.CustomerID IS NULL ;

-- 주문을 처리한적 없는 직원
SELECT e.LastName,e.FirstName
FROM employees e LEFT JOIN orders o
    ON e.EmployeeID = o.EmployeeID
    WHERE o.EmployeeID IS NULL;

-- 실제로 없는지 확인해보자
SELECT DISTINCT EmployeeID FROM orders ORDER BY 1;
SELECT COUNT(*) FROM employees;

INSERT INTO employees( LastName, FirstName, BirthDate, Photo, Notes)
VALUE ('손','흥민','2000-01-01','사진1','축구선수');


