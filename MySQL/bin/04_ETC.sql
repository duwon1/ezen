--04_ETC.sql

-- command 창에서 운영되는 mysql 프로그램 접속

--  mysql -h localhost -u root -p
-- -h는 호스트, -u는 사용자 -p는 비밀번호를 의미

-- mysql 종료는 quit 또는 exit

-- Schema 생성
create schema scott defalut character ser utf8mb4;

-- 사용하려는 스키마로 이동
use scott;

-- 현재 스키마의 테이블들 보기
show talbles;

-- 테이블의 구조 보기
desc 테이블이름;



-- LIMIT
-- select로 데이터 조회할 떄 조회할 레코드의 개수를 조절 제한 할 수 있음
select * from memberlist order by membernum desc limit 5;
-- 회원 정보를 조회하여 5개의 레코드만 리턴

-- OFFSET
-- select로 데이터를 조회할때, 맨위에서부터 offset에 지정한 번 째까지는 뛰어 넘고 그 다음부터 리턴함
select * from memberlist order by membernum desc limit 10 offset 5;
-- 6번 째 데이터부터 10개의 레코드 리턴 - 개수가 모자라면 있는곳까지 리턴

-- limit 와 offset의 동시사용
select * from memberlist order by membernum desc limit 5 offset 5;
-- 6번 째 데이터부터 15개의 레코드 리턴 

-- offset과 limit는 게시판이나, 상품 진열시에 페이지를 표시하기 위한 용도로 가장 많이 사용됨


