-- 정규화 NORMALIZATION
-- 첫번째 정규화 (FIRST NORMAL FORM) 1NF
-- 원자적 데이터를 가진 테이블, PK(프라임 키가) 컬럼이 있어야 함

-- 책 369
-- 두번째 정규화(SECOND NORMAL FORM) 2NF
-- 1NF(만족하고) 이고, 부분적 함수 의존이 없어야 한다.

-- 부분적 함수 의존(partial functional dependency)
-- 키가 아닌 컬럼의 값이 키 컬럼 일부에 종속되지 않아야 한다.
-- 키의 일부가 변경되면 키가 아닌 컬럼이 변경되어야 하면 부분적 함수 의존
-- 내가 인위적 키(자동 키)를  따로 만들면 2NF 까지는 만든거다.

-- 책 374
-- 세번째 정규화 (THIRD NORMAL FORM) 3NF
-- 2NF 이고, 이행적 종속이 없어야 함

-- 이행적 종속(transitive dependency) :
-- 키가 아닌 컬럼이 키가 아닌 다른 컬럼에 의존
-- 키가 아닌 컬럼이 변경되면 다른 키가 아닌 컬럼이 변경 되어야 할때
USE mydb1;
-- 입사지원자 테이블 만들기
-- id, 이름, 학교, 학교 주소
-- 밑에 테이블은 2NF는 만족했지만 3NK는 만족하지못함
CREATE TABLE my_table30_person(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    school VARCHAR(10),
    school_address VARCHAR(10)
);
INSERT INTO my_table30_person(name, school, school_address)
VALUES ('아리','서울대','관악'),
       ('소유','고려대','안암'),
       ('민수','연서대','신촌'),
       ('혜지','카이스트대','지방'),
       ('영지','경희대','건대');

SELECT * FROM my_table30_person;

CREATE TABLE my_table31_person(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    school VARCHAR(10)
);
CREATE TABLE my_table32_school(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    address VARCHAR(10)
);

INSERT INTO my_table31_person(name, school)
VALUES ('아리','서울대'),
       ('소유','고려대'),
       ('민수','연서대'),
       ('혜지','카이스트대'),
       ('영지','경희대');

INSERT INTO my_table32_school(name, address)
VALUES ('서울대','관악'),
       ('고려대','안암'),
       ('연서대','신촌'),
       ('카이스트대','지방'),
       ('경희대','건대');

-- 한테이블의 컬럼이 다른 테이블을 참조하면 pk를 사용해야함
-- 서로 타입을 맞춰져야 한다.
CREATE TABLE my_table33_person(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(10),
    school_id INT
);
CREATE TABLE my_table34_school(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(10),
    address VARCHAR(10)
);

INSERT INTO my_table33_person(name, school_id)
VALUES ('아리',  ,);
INSERT INTO my_table34_school(name, address)
VALUES ('서울대','관악'),
       ('연선대','신촌'),
       ('고려대','안암');
SELECT * FROM my_table34_school;

INSERT INTO my_table33_person(name, school_id)
VALUES ('지성', 4);

-- REFERENCES (다른테이블 참조 하도록 만듬)제약 상항을 걸면 없을때 만들어지지 않음
CREATE TABLE my_table35_person(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(10),
    school_id INT REFERENCES my_table36_school(id) -- (안에는 pk)
    -- 왜래키(foreign key) 제약사항
);
CREATE TABLE my_table36_school(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(10),
    address VARCHAR(10)
);
INSERT INTO my_table35_person(name, school_id)
VALUES ('아리', 1),
       ('혜지', 2),
       ('민경', 1);
INSERT INTO my_table36_school(name, address)
VALUES ('서울대','관악'),
       ('연선대','신촌'),
       ('고려대','안암');
INSERT INTO my_table35_person(name, school_id)
VALUES ('지성', 4); -- 바로 에러걸리쥬 제약 사항 걸어 놓기 때문에

-- 1번 학교를 지울려고해도 레코드가 걸려있어서 지울수 없다.
DELETE FROM my_table36_school WHERE id = 1;

-- MUL 보면 다른 테이블 참조하고 있구나
DESC my_table35_person;
SHOW CREATE TABLE my_table35_person;
CREATE TABLE `my_table35_person` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT,
                                     `name` varchar(10) DEFAULT NULL,
                                     `school_id` int(11) DEFAULT NULL,
                                     PRIMARY KEY (`id`),
                                     KEY `school_id` (`school_id`),
                                     CONSTRAINT `my_table35_person_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `my_table36_school` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 외래키, 참조키, FK(foreign key)
-- 프라이머리키가 1 참조하고있는 쪽이 n  1: n 관계

-- 정규화 하지 못한것 은 역 정규화
