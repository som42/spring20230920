-- normalization : 정규화 ( 보통에 테이블이 되는가)
USE mydb1;

-- atomic data(원자적 데이터) 책 209쪽
-- 예) 이름, 최종학력, 특기,

-- 규칙1
-- 원자적 데이터로 구성된 열은 그열에 같은 타입의 데이터를 여러 개 가질 수 없다.
CREATE TABLE my_table21_person (
    name VARCHAR(100) NOT NULL ,
    schools VARCHAR(100),
    skill VARCHAR(1000)
);
INSERT  INTO my_table21_person(name, schools, skill)
VALUE ('한봄','대학교','노래,피아노');
INSERT  INTO my_table21_person(name, schools, skill)
    VALUE ('한여름','대학','농구,골프');
INSERT  INTO my_table21_person(name, schools, skill)
    VALUE ('한겨울','고졸','그림,요리');
SELECT * FROM my_table21_person;

-- 책209쪽 규칙2
-- 원자적 데이터로 구성된 테이블은 같은 타입의 데이터를 여러개 가질수 없다.
CREATE TABLE my_table22_person(
    name VARCHAR(100) NOT NULL ,
    schools VARCHAR(100) ,
    skill1 VARCHAR(100),
    skill2 VARCHAR(100),
    skill3 VARCHAR(100)
    );
INSERT INTO my_table22_person(name, schools, skill1, skill2, skill3)
VALUE ('한봄','대학교','노래','피아노',null);
INSERT INTO my_table22_person(name, schools, skill1, skill2, skill3)
    VALUE ('한여름','대학교','요리','그림',null);
INSERT INTO my_table22_person(name, schools, skill1, skill2, skill3)
    VALUE ('한겨울','대학교','노래',null,null);
SELECT * FROM my_table22_person;

CREATE TABLE my_table23_person(
    name    VARCHAR(100) NOT NULL,
    schools VARCHAR(100),
    skill   VARCHAR(1000)
);
INSERT INTO my_table23_person(name, schools, skill)
VALUE ('여름','대학','그림');
INSERT INTO my_table23_person(name, schools, skill)
    VALUE ('가을','대학교','그림');
INSERT INTO my_table23_person(name, schools, skill)
    VALUE ('겨울','대학원','요리');
SELECT * FROM my_table23_person;

-- key : 각 행을 구분하는 컬럼(들)
-- 책 215 정규화
-- 각 행의 데이터들은 원자적 값을 가져야한다.
-- 각 행은 유일무이한 식별자인 기본키(primary key)를 가지고 있어야한다.

CREATE TABLE my_table24_person(
    ssn VARCHAR(10) NOT NULL UNIQUE ,
    name VARCHAR(10) NOT NULL ,
    school VARCHAR(10),
    skill VARCHAR(10)
);

-- 기본키(primary key) 조건
-- 기본키는 null이 될수 없고 유니크 여야 한다
-- 기본키는 레코드가 삽입 될 때 값이 있어야 한다.
-- 기본키는 간결 해야 한다, 기본키의 값은 변경 불가다
-- AUTO_INCREMENT : 1부터 자동으로 증가된 값 삽입 해준다.

CREATE TABLE my_table25_person(
    id INT NOT NULL UNIQUE AUTO_INCREMENT,
    ssn VARCHAR(10) NOT NULL ,
    name VARCHAR(10) NOT NULL ,
    school VARCHAR(10),
    skill VARCHAR(10)
);
DROP TABLE my_table25_person;
INSERT INTO my_table25_person(ssn, name, school, skill)
VALUE ('080101','여름','대학','그림');
INSERT INTO my_table25_person(ssn, name, school, skill)
    VALUE ('080101','여름','대학','그림');
INSERT INTO my_table25_person(ssn, name, school, skill)
    VALUE ('090101','겨울','대학','요리');
INSERT INTO my_table25_person(ssn, name, school, skill)
    VALUE ('090101','겨울','대학','노래');
SELECT * FROM my_table25_person;

-- PRIMARY KEY : NOT NULL UNIQUE
CREATE TABLE my_table26_person(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    ssn    VARCHAR(10) NOT NULL,
    name   VARCHAR(10) NOT NULL,
    school VARCHAR(10),
    skill  VARCHAR(10)
);
DESC my_table25_person;
DESC my_table26_person;
