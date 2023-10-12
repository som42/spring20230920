-- 1 : n

-- 1 : 1 : 많이 보이지는 않는다.
CREATE TABLE my_table37_employee(
    id INT PRIMARY KEY  AUTO_INCREMENT,
    name VARCHAR(20),
    birth DATE
);
CREATE TABLE my_table37_employee_info(
    id INT REFERENCES my_table37_employee(id),
    salary INT,
    address VARCHAR(20)
);

-- 책 350쪽
-- n : m (다대다)
-- 다대다 를 할려면 두 개의 일대다 관계로 이루어지고 사이에 연결테이블이 있어야한다
-- 1 : n , 1 : m 인 중간 테이블이 생성 되어야 한다.
CREATE TABLE my_table39_person(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    skill VARCHAR(20)
);
CREATE TABLE my_table40_skill(
    id INT PRIMARY KEY AUTO_INCREMENT,
    skill_name VARCHAR(20)
);
CREATE TABLE my_table41_person_skill(
    person_id INT REFERENCES my_table39_person(id) ,
    skill_id INT REFERENCES my_table40_skill(id),
    PRIMARY KEY (person_id, skill_id)
);

