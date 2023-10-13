USE w3schools;

-- 같은 테이블 끼리도 JOIN 된다
SELECT *
FROM employees e1 JOIN employees e2;

-- Leverling 나이더 많은 사람
-- 셀프 JOIN
SELECT e1.LastName, e1.BirthDate
FROM employees e1 JOIN employees e2
WHERE e1.BirthDate < e2.BirthDate
    AND e2.LastName = 'Leverling';

-- 예) 'Ipoh Coffee'보다 비싼 상품명 조회
SELECT p1.ProductName,p1.Price
FROM products p1 JOIN products p2
WHERE p1.Price > p2.Price
    AND p2.ProductName = 'Ipoh Coffee'
    ORDER BY 1;

-- Ipoh Coffee 커피 조회
SELECT * FROM products
WHERE ProductName = 'Ipoh Coffee';
