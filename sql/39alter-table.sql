USE w3schools;

-- ALTER TABLE : 테이블 수정

-- 컬럼 추가, 변경, 삭제(잘 일어나지 않는다)

-- 제약 사항 변경
-- NOT NULL, UNIQUE, PRIMARY KEY, DEFAULT KEY

-- 컬럼 추가 ( 컬럼명, 타입, 제약사항)
ALTER TABLE products
ADD COLUMN col1 INT;
ALTER TABLE products
ADD COLUMN col2 VARBINARY(10);

-- 컬럼을 중간에 추가 하고 싶다
ALTER TABLE products
ADD COLUMN col3 VARBINARY(10) AFTER ProductName;

-- 첫 번째 넣고 싶다
ALTER TABLE products
ADD COLUMN col4 VARBINARY(10) FIRST;

ALTER TABLE products
ADD COLUMN col5 INT(10)
    NOT NULL DEFAULT 1 REFERENCES employees(EmployeeID);

DESC products;

-- 예) 직원테이블 salay 컬럼 마지막에 추가
-- data type 은 dec(10, 2), null 허용 안하고, 기본값음 0.00
-- 더블이 없어서 DEC

ALTER TABLE employees
ADD COLUMN salary DEC(10,2)
    NOT NULL DEFAULT 0.00 ;
DESC employees;

-- 컬럼 삭제
ALTER TABLE products
DROP COLUMN col1;

-- 예) products 테이블에서 col2 컬럼삭제
-- 주의사항 없이 실행되니깐 항상 주의 해야한다.
ALTER TABLE products
DROP COLUMN col2;
DESC employees;

-- 컬럼 변경(type)
-- col3 타입을 INT로 바꿔라
ALTER TABLE products
MODIFY COLUMN col3 INT;
DESC products;

-- 컬럼을 변경할때 이미 값이 있다면 안된다.
INSERT INTO products(col4)
VALUE ('pizza');
SELECT * FROM products
ORDER BY ProductID DESC;

ALTER TABLE products
MODIFY COLUMN col4 INT; -- x

-- 글자 수 늘리는건 가능, 하지만 글자 수 줄이는거는 주의해야한다.
ALTER TABLE products
MODIFY COLUMN col4 VARCHAR(20);
