-- IN : 하나라도 같으면

SELECT * FROM customers
WHERE Country = 'UK' OR Country = 'spain' OR Country ='italy';
SELECT * FROM customers
WHERE Country IN ('UK', 'spain', 'italy');

-- 카테고리 3, 4dp 속한 상품들 조회
SELECT * FROM products
WHERE CategoryID IN (3,4);
-- 1996년 7월 4,5일에 주문한 주문들
SELECT * FROM orders
WHERE OrderDate IN ('1996-07-04','1996-07-05');
-- london 이나 madrid, sevilla에 있는 고객들
SELECT * FROM customers
WHERE City IN ('London','Madrid','sevilla');