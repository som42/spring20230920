SELECT * FROM employees;

-- 생일 순으로 정렬 하고 싶다
SELECT *
FROM employees
ORDER BY BirthDate;

-- order by 나오는 순서에 번호로 적어줄수도 있다..
SELECT *
FROM employees
ORDER BY 4;

SELECT EmployeeID, LastName, BirthDate
FROM employees
ORDER BY 3;

SELECT * FROM products;
-- 카테 고리로 정렬 했다.  하지만 이 안에서 더 정렬 하고 싶다
SELECT * FROM products
ORDER BY CategoryID, Price;

-- 기본적 으로 오름차순이지만 내림차순으로 하고 싶을때는 끝에 DESC 붙이면된다
SELECT * FROM products
ORDER BY CategoryID ASC ; -- 생략가능 오름차순
SELECT * FROM products
ORDER BY CategoryID DESC; -- 내림차순

SELECT * FROM products
ORDER BY CategoryID DESC , Price DESC;

-- 예제) 고객을 국가명 오름차 순으로 조회
SELECT * FROM customers
ORDER BY Country;
-- 예제) 가격이 비싼 상품이 먼저 조회되도록 코드 작성
SELECT * FROM products
ORDER BY Price DESC;
-- 예제) 가장 어린 직원이 먼저 조회도돍 코드 작성
SELECT * FROM employees
ORDER BY BirthDate DESC;

-- 제품이 카테고리 ID가 1번인 제품들을 가격을 높은 순 으로 보겠다
SELECT * FROM products
WHERE CategoryID = 1
ORDER BY Price DESC ;
