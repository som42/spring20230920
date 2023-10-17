USE mydb1;

CREATE TABLE my_table46(
    col1 INT,
    col2 INT,
    col3 INT,
    col4 INT,
    col5 INT
);
ALTER TABLE my_table46
ADD COLUMN col3 INT;

-- NOT NULL 제약 사항 추가
ALTER TABLE my_table46
MODIFY col1 INT NOT NULL;

DESC my_table46;

-- NOT NULL 제약 사항 삭제
ALTER TABLE my_table46
MODIFY col1 INT NULL;

-- 예) col2에 not null 제약사항 추가
ALTER TABLE my_table46
MODIFY col2 INT NOT NULL;
-- 예) col2에 not null 제약사항 삭제
ALTER TABLE my_table46
MODIFY col2 INT NULL;

-- DEFAULT 제약사항 추가
ALTER TABLE my_table46
ALTER col3 SET DEFAULT 100;

-- DEFAULT 제양 사항 삭제
ALTER TABLE my_table46
ALTER col3 DROP DEFAULT ;

-- 예) col4 에 기본값 0 제약사항 추가
ALTER TABLE my_table46
ALTER col4 SEt DEFAULT 0;
-- 예) col4에 default 제약사항 삭제
ALTER TABLE my_table46
ALTER col4 DROP DEFAULT;
DESC my_table46;

-- UNIQUE 제약 사항 추가
ALTER TABLE my_table46
    ADD UNIQUE (col5);
DESC my_table46;

-- UNIQUE 제약 사항 삭제 가로 안에 없는걸로 지워야 한다
SHOW CREATE TABLE my_table46;
CREATE TABLE `my_table46` (
                              `col1` int(11) DEFAULT NULL,
                              `col4` int(11),
                              `col5` int(11) DEFAULT NULL,
                              UNIQUE KEY `col5` (`col5`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE my_table46
DROP INDEX col5;

-- PRIMARY KEY 제약 사항 추가
ALTER TABLE my_table46
ADD PRIMARY KEY (col1);
DESC my_table46;
-- PRIMARY KEY 제약 사항 삭제
ALTER TABLE my_table46
DROP PRIMARY KEY;
ALTER TABLE my_table46
MODIFY col1 INT NULL;


CREATE TABLE my_table47(
    id INT AUTO_INCREMENT primary key,
    name VARBINARY(10)
);

-- FOREIGN KEY(외래키) 제약사항 추가
ALTER TABLE my_table46
ADD FOREIGN KEY (col5) REFERENCES my_table47(id);
-- FOREIGN KEY(외래키) 제약사항 삭제
SHOW CREATE TABLE my_table46;
CREATE TABLE `my_table46` (
                              `col1` int(11) DEFAULT NULL,
                              `col4` int(11),
                              `col5` int(11) DEFAULT NULL,
                              `col2` int(11) DEFAULT NULL,
                              `col3` int(11) DEFAULT NULL,
                              KEY `col5` (`col5`),
                              CONSTRAINT `my_table46_ibfk_1` FOREIGN KEY (`col5`) REFERENCES `my_table47` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
ALTER TABLE my_table46
DROP FOREIGN KEY my_table46_ibfk_1;
-- 위에 아래 둘다 해야 삭제된다.
ALTER TABLE my_table46
DROP INDEX col5;

DESC my_table46;