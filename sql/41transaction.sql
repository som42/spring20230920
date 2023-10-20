USE w3schools;

-- transaction (트랜잭션)


CREATE TABLE bank(
         name VARCHAR(10) PRIMARY KEY ,
         money INT NOT NULL DEFAULT 0
);

INSERT INTO bank(name,money)
    VALUE ('son', 10000),
          ('kim', 10000);

-- 송금 업무 son -> kim 1000원 송금
UPDATE bank
SET money = money - 1000
WHERE name = 'son';
UPDATE bank
SET money = money + 1000
WHERE name = 'kim';


-- 만원주기
UPDATE bank
SET money = money

-- 여러 쿼리가 실행 될때 한방에 성공해야 한다
-- 하나의 업무 단위를 transaction (트랜잭션)
-- 트랜잭션이 완료되지 않으면 다른데서 테이블을 보면 바뀌지 값이 바뀌지않는다.
-- 오토로 되있으면 실행할때 마다 커밋이 된다/

SELECT * FROM bank;

-- 완료하는 방법
-- 되돌리기(트랜잭션하기전으로 되돌아가기 )
ROLLBACK ;
-- 반영하기 (업무가 끝까지 완료된다면,)
-- 반영해야 실제 테이블에서도 반영되는거다.
COMMIT ;
