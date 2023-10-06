-- < 작다, > 크다, >= 크거나 같다, <= 작거나 같다

SELECT * FROM products
WHERE Price < 10.00;

SELECT * FROM products
WHERE Price > 10.00;

SELECT * FROM products
WHERE Price >= 10.00;

SELECT * FROM products
WHERE Price <= 10.00;

SELECT * FROM products
WHERE Price = 10.00;

SELECT * FROM products
WHERE NOT Price >= 10.00;

-- ! 버전 마다 되는지 안 되는지 확인 해야 한다
SELECT * FROM products
WHERE Price != 10.00;

-- ! NOT <> 셋다 같지 않다 라는 똑같은 의미 이다
SELECT * FROM products
WHERE Price <> 10.00;

SELECT * FROM customers
WHERE CustomerID < 3;
--  문자형식도 된다.
SELECT * FROM customers
WHERE CustomerID <'5';

SELECT * FROM customers
WHERE CustomerName = 'Ana';

SELECT * FROM customers
WHERE CustomerName < 'D';
SELECT * FROM customers
WHERE CustomerName >= 'R';
SELECT * FROM customers
WHERE CustomerName >= 'r';

--  날짜
SELECT * FROM employees;
SELECT * FROM employees
WHERE BirthDate >= '1960-01-01';
SELECT * FROM employees
WHERE BirthDate < '1960-01-01';
