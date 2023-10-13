-- union 합집합(중복된 원소가 없음)
USE  w3schools;
SELECT Country FROM customers;
SELECT Country FROM suppliers;
-- 두개의 결과를 한번에 보고싶은데 중복 제거 하고
SELECT Country FROM customers
UNION
SELECT Country FROM suppliers;

-- 중복 제거 없이 나옴
SELECT Country FROM customers
UNION ALL
SELECT Country FROM suppliers;

-- 여러개 써도 갯수만 컬럼 갯수만 맞으면 상관없다.
SELECT CustomerName, Country, City, CustomerID FROM customers
UNION
SELECT SupplierName, Country, City, Address FROM suppliers;

-- 예) 직원은 lastName과 firstName을 name이라는 하나의 컬럼으로 조회
SELECT LastName AS name FROM employees
UNION ALL
SELECT FirstName FROM employees;

-- FULL OUTER JOIN
USE mydb1;
SELECT *
FROM my_table44_a a LEFT JOIN my_table45_b b
ON a.col1 = b.col1
UNION ALL
SELECT *
FROM my_table44_a a RIGHT JOIN my_table45_b b
ON a.col1 = b.col1;

-- LFET OUTER JOIN
SELECT *
FROM my_table44_a a LEFT JOIN my_table45_b b
ON a.col1 = b.col1;

-- RIGHT OUTER JOIN
SELECT *
FROM my_table44_a a RIGHT JOIN my_table45_b b
ON a.col1 = b.col1;

