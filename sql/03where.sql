SELECT CustomerName, Address, City, Country FROM customers;

-- WHERE : 레코드 선택(솎아내기)
SELECT * FROM customers WHERE CustomerID = 1;
SELECT * FROM customers WHERE CustomerID = 2;

SELECT * FROM customers WHERE Country = 'USA';
SELECT * FROM customers WHERE Country = 'Mexico';
SELECT * FROM customers WHERE Country ='mexico'; -- 위에꺼랑 두개 똑같다
SELECT * FROM customers WHERE Country = 'France'; -- 문자열은 ' '

SELECT * FROM customers WHERE CustomerID = 3; -- 수형식은  따옴표 없어
SELECT * FROM customers WHERE CustomerID= '3';

-- 예) 영구(UK) 에 사는 고객들 조회
SELECT * FROM customers WHERE Country ='UK';
-- 예) 1번 카테고리에 속한 상품(Products) 로 조회
SELECT * FROM products WHERE CategoryID = 1;
-- 예) Osaka에 있는 공급자들 조회
SELECT * FROM suppliers WHERE City = 'Osaka';


-- 미국에 사는 고객의 이름을 조회
SELECT CustomerName FROM customers WHERE Country = 'USA';
-- 영구에 사는 고객의 이름과, 고객번호 조회
SELECT CustomerID, CustomerName FROM customers WHERE Country = 'UK';

-- 예) 2번 카테고리에 있는 상품명과 가격 조회
SELECT ProductName, Price
 FROM  products WHERE CategoryID =2;
-- 예) 일본에 있는 공급자의 이름 (SupplierName)과 전화번호조회
SELECT Phone,SupplierName FROM suppliers WHERE Country= 'JAPAN';
-- 예) 2번 카테고리의 이름 (categoryNAme) 조회
SELECT CategoryName FROM categories WHERE CategoryID = 2;