-- 전체 게시물 구하는 방법
-- page
SELECT * FROM suppliers;
SELECT COUNT(*) FROM suppliers; -- 29rows

-- 1 페이지에 10개 rows
-- suppliers 목록은 3 페이지 마지막 페이지

-- COUNT(*) : records 수 n : 마지막 페이지
-- 1 ~ 10                 : 1
-- 11 ~ 20                : 2
-- 21 ~ 30                : 3
-- 31 ~ 40                : 4

-- 레코드가 n개이고 페이지당 10개씩 보여줄 때 마지막 페이지번호는?
-- 마지막 페이지 번호는 (n/10)을 올림한 값입니다.
-- ((n-1) / 10) + 1
