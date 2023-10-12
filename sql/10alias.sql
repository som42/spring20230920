SELECT * FROM employees;
SELECT EmployeeID, LastName FROM employees;

-- AS : 컬럼명(테이블명) 변경
SELECT EmployeeID AS id,
       LastName   AS name
FROM  employees;

-- As 생략 가능
SELECT EmployeeID,
       CONCAT(FirstName, ' ', LastName) AS fullName
FROM employees;

-- backtick ``으로 키워드나 특수문자 사용가능
SELECT EmployeeID,
       CONCAT(FirstName,' ',LastName)`full name`
FROM employees;

-- 공급자의 이름(supplierName), 주소 (address, city, country)
-- 전화번호(Phone number)
SELECT SupplierName,
       CONCAT(Address,' ', City,' ', Country) address,
       Phone `phone number`
FROM suppliers;

-- 테이블도 별칭을 줘서 이름바꿀수 있다
SELECT * FROM products;
SELECT * FROM customers;

SELECT products.ProductName,
       categories.CategoryName
FROM products Join categories
    ON products.CategoryID = categories.CategoryID

SELECT p.ProductName,
       c.CategoryName
FROM products p
         Join categories c
              ON p.CategoryID = c.CategoryID
