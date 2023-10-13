USE w3schools;

SELECT *
FROM products p JOIN shippers s
    ON p.SupplierID = s.ShipperID;
-- 위와 같은 쿼리를 줄일때 USING  위와 같은 일을 한다.
SELECT *
FROM products p JOIN suppliers s
    USING (SupplierID);

-- NATURAL
-- 두 테이블에 같은 이름에 컬럼을 찾아서 join을 해준다
SELECT *
FROM products p NATURAL JOIN suppliers s;

