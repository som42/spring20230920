USE mydb1
-- PRIMARY KEY (주키, 기본키, pk)
CREATE TABLE my_table27(
    id INT PRIMARY KEY ,
    name VARCHAR(20)
);
CREATE TABLE my_table28(
    id INT,
    name VARCHAR(10),
    PRIMARY KEY (id)
);
-- 여러가지를 묶어서도 키를 줄수 있다.
-- 별일 없으면 하나의 컬럼으로 주는게 좋다
CREATE TABLE my_table29(
    name VARCHAR(10),
    birth DATE,
    PRIMARY KEY (name,birth)
);

-- 주로 이렇게 쓴다
CREATE TABLE my_table30(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10)
);
INSERT INTO my_table30(name)
VALUE ('som');
INSERT INTO my_table30(name)
    VALUE ('kim');
INSERT INTO my_table30(name)
    VALUE ('son');
INSERT INTO my_table30(name)
    VALUE ('lee');
INSERT INTO my_table30(name)
    VALUE ('son');
INSERT INTO my_table30(name)
    VALUE ('lee');
SELECT * FROM my_table30;
-- 4번을 지우면 다시 다른걸 생성할때 4번 건너띄고 5번부터 생성된다.
DELETE FROM my_table30
WHERE id = 4;
