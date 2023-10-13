USE mydb1;

CREATE TABLE my_table42_a (
    col1 VARBINARY(1)
);
CREATE TABLE my_table43_b(
    col1 VARBINARY(1)
);

-- A에도 있고 B에도 있는 교집합
-- INNER JOIN 두 테이블에 컬럼에 공통으로 있는것
INSERT INTO my_table42_a(col1)
VALUE ('a'),('b'),('c');

INSERT INTO my_table43_b(col1)
VALUE ('b'),('c'),('d'),('e');

SELECT *
FROM my_table42_a a INNER JOIN my_table43_b b
    ON a.col1 = b.col1;

-- 왼쪽 테이블인 A 에만 있는것, 포함 교집합도 남는다
-- A에만 있는 레코드니깐 B 는 null 남아있는다
-- LEFT JOIN
-- 풀 네임이 LEFT OUTER JOIN ( OUTER는 생략가능)
SELECT *
FROM my_table42_a a LEFT OUTER JOIN my_table43_b b
    ON a.col1 = b.col1;

-- 오른쪽 테이블 인 B에만 있는것, 포함 교집합 인것도 남는다
-- RIGHT OUTER JOIN 풀 네임
-- B에만 있는 레코드니깐 A는 없는것으 null
SELECT *
FROM my_table42_a a RIGHT OUTER JOIN my_table43_b b
     ON a.col1 = b.col1;

-- 여기서 컬럼이 하나만 아니라면?
-- 컬럼이 여러개라도 공통적인 컬럼만 생각하면된다
CREATE TABLE my_table44_a(
    col1 VARBINARY(1),
    name VARBINARY(10),
    address VARBINARY(10)
);
CREATE TABLE my_table45_b(
    col1 VARBINARY(1),
    product VARBINARY(10),
    country VARBINARY(10)
);

INSERT INTO my_table44_a(col1, name, address)
VALUE
        ('a','흥민','런던'),
        ('b','강인','파리'),
        ('c','민재','도쿄');
INSERT INTO my_table45_b(col1, product, country)
VALUE
        ('b','축구공','한국'),
        ('c','컴퓨터','미국'),
        ('d','전화기','호주'),
        ('e','햄버거','영국');

SELECT *
FROM my_table44_a a JOIN my_table45_b b
    ON a.col1 = b.col1;
SELECT *
FROM my_table44_a a LEFT JOIN my_table45_b b
    ON a.col1 = b.col1;
SELECT *
FROM my_table44_a a RIGHT JOIN my_table45_b b
    ON a.col1 = b.col1;


