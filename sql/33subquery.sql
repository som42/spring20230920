USE w3schools;

SELECT Price FROM products WHERE ProductName = 'ipoh coffee';

SELECT ProductName, Price FROM products
WHERE Price > 46.00;

-- 어떤 쿼리가 다른 쿼리안에 포함 되어 있다면 서브 쿼리(내부 쿼리)
SELECT ProductName, Price FROM products
WHERE Price > (SELECT Price FROM products WHERE ProductName = 'ipoh coffee');

-- 밑에 두개는 같은 결과를 가져와 준다.
SELECT BirthDate FROM employees
WHERE LastName = 'leverling';

SELECT LastName,FirstName,BirthDate FROM employees
WHERE BirthDate < (SELECT BirthDate FROM employees
                   WHERE LastName = 'leverling');

-- subquery
-- 행1 컬럼이 1개 ( 부 등호와 같이 쓸수 있다 > < = )
SELECT BirthDate FROM employees
WHERE LastName = 'leverling';

-- 행 여러개 컬럼이 1개
SELECT ShipperID FROM orders
WHERE OrderDate = '1996-07-08';
SELECT CustomerName FROM customers WHERE Country = 'mexico';

-- 행도 여러개 컬럼도 여러개인것
SELECT CustomerID, CustomerName FROM customers
WHERE Country = 'mexico';

-- 행1개 열1개 예제
-- 'Tofu' 상품을 공급하는 공급자 명
SELECT SupplierID FROM products WHERE ProductName = 'tofu';
SELECT SupplierID, SupplierName FROM suppliers
WHERE SupplierID = (SELECT SupplierID FROM products WHERE ProductName = 'tofu');
-- join
SELECT  p.SupplierID, s.SupplierName
FROM suppliers s JOIN products p
ON s.SupplierID = p.SupplierID
WHERE p.ProductName = 'tofu';

-- 여러행 한개 컬럼일때
-- 멕시코 고객이 주문한 일자들 조회
SELECT CustomerID FROM customers WHERE Country = 'mexico';
SELECT * FROM orders WHERE CustomerID IN (2,3,13,58,80);

SELECT OrderDate FROM orders WHERE CustomerID IN (SELECT CustomerID FROM customers WHERE Country = 'mexico');



-- 예) 1번 카테고리에 있는 상품이 주문된 주문번호
SELECT ProductID FROM products WHERE CategoryID = 1;
SELECT OrderID FROM orderdetails
               WHERE orderdetails.ProductID IN (SELECT ProductID FROM products WHERE CategoryID = 1);
-- 예) 1번 카테고리에 있는 상품이 주문된 날짜 알고싶다
SELECT OrderDate FROM orders
WHERE OrderID IN (SELECT OrderID FROM orderdetails
                  WHERE orderdetails.ProductID IN (SELECT ProductID FROM products WHERE CategoryID = 1));


SELECT *
FROM orders o
    JOIN orderdetails od
    ON o.OrderID = od.OrderID
    JOIN products p
    ON od.ProductID = p.ProductID
WHERE p.CategoryID = 1;

-- 예) 주문한 적 없는 고객들 ( 여러행 한개 컬럼)
SELECT CustomerID FROM orders;

SELECT * FROM customers WHERE CustomerID NOT IN (SELECT CustomerID FROM orders);

-- 주문 한 적이 없는 직원
SELECT EmployeeID FROM orders;
SELECT *
FROM employees WHERE EmployeeID NOT IN (SELECT EmployeeID FROM orders);

-- 행 여러개 열 여러개
SELECT * FROM customers;
SELECT SupplierName, Address,Country FROM suppliers;
INSERT INTO customers(CustomerName,Address,Country)
(SELECT SupplierName, Address,Country FROM suppliers);

INSERT INTO customers(CustomerName,Address,Country)
(SELECT CustomerName, City, Phone FROM suppliers);

SELECT * FROM customers
WHERE (City, Country)
          IN (SELECT City, Country FROM suppliers);
-- 기존에 있는 테이블로 새로운 테이블 만들겟다
CREATE TABLE table_c
SELECT CustomerName, City, Country FROM customers;
SELECT * FROM table_c;
DESC table_c;

-- 예) 1번 카테고리에 있는 상품들로 새 테이블을 만드는데
-- 새로운 테이블(table_d)은 productName, categoryName, price


CREATE TABLE table_d
SELECT p.ProductName, c.CategoryName, p.Price
FROM products p
    JOIN categories c
    ON p.CategoryID = c.CategoryID
WHERE c.CategoryID =1;
SELECT * FROM table_d;
DESC table_d;