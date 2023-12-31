--프로시져
--함수와 비슷한 구조
--함수는 결과 리턴이 있지만 프로시져는 결과리턴이 없는 것이 특징(리턴을 위한 별도의 코드(변수)가 있음)
--return 키워드 대신, 리턴역할을 하는 변수를 필요개수만큼 만들어서 사용함

--프로시져의 생성
--create or replace procedure 프로시져이름(
--  매개변수명1 [in|out|in out] 데이터타입[:=디폴트 값],
--  매개변수명2 [in|out|in out] 데이터타입[:=디폴트 값],
--  ...
-- )
--is(as)
--  변수, 상수 선언
--begin
--  실행부
--[exception
--  예외처리부]
--end [프로시져이름];

-- create or replace procedure : 프로시져를 생성하는 구문
--매개변수명1 [in|out|in out] :매개변수를 만들되 전달되는 전달인수를 받는 in변수와 리턴역할을 할수 있는 out변수를 만들 때 사용.
--  입력변수와 출력변수의 역할이 동시에 부여되려면 in out을 같이 기술함
--  프로시져는 기본적으로 리턴값이 없지만(실제 return명령을 사용하지 않음) 변수의 속성에 out속성하나를 부여함으로써
--      리턴의 역할을 흉내낼 수 있게는 사용이 가능함
--  변수 속성이 in인경우 생략 가능


--rentlist 테이블에 레코드를 추가하는 프로시져
set serveroutput on;
create or replace procedure newRentList(
    p_bnum in rentlist.bnum%type,
    p_mnum in rentlist.mnum%type,
    p_discount in rentlist.discount%type)
is
begin
    insert into rentlist(rentdate, numseq, bnum, mnum, discount)
    values (sysdate, rent_seq.nextVal, p_bnum, p_mnum, p_discount);
    commit;
end;

exec newRentList(6,3,300);

select * from rentlist order by numseq desc;


--in,out, in out 매개변수 사용 #1
--newRentlist 프로시져에서 입력된 오늘 날짜를 호출한 곳에서 되돌려 받아서 출력함
create or replace procedure newRentList2(
    p_bnum in rentlist.bnum%type,
    p_mnum in rentlist.mnum%type,
    p_discount in rentlist.discount%type,
    p_outdate out rentlist.rentdate%type)
is
    v_sysdate rentlist.rentdate%type := sysdate;  --변수 선언과 동시에 오늘날짜를 저장
begin
    insert into rentlist(rentdate, numseq, bnum, mnum, discount)
    values (v_sysdate, rent_seq.nextVal, p_bnum, p_mnum, p_discount);
    commit;
    p_outdate := v_sysdate; --out변수에 오늘날짜를 담고 있는 변수값에 대입함
    --out변수에 값을 넣는 것은 호출할 때 out변수에 전달해준 변수로 그 값을 전달하는 것과 같음
end;
declare
    v_date rentlist.rentdate%type;
begin
    newRentList2(4,2,200,v_date);
    --익명블럭에서 프로시져를 호출할 때는 exec를 사용하지 않음
    --프로시져가 아니고 함수였다면 v_curdate=newrentlist2(7,2,200); 와 같이 사용하겠지만
    --프로시져이기 때문에 매개변수중에서도 out변수에 값 대신 변수를 전달해줌(자바의 call by reference와 같은 의미)
    --프로시져 내부에서 out변수에 뭔가 값을 넣는 동작이 있으면 호출한 곳에서 넣어준 변수에 그 값을 공유받아서 사용한 것과 같음.
    
    --프로시져에서 넣어준 값이 현재 변수를 통해 출력됨
    dbms_output.put_line(v_date);
end;


--in,out, in out 매개변수 사용 #2
--in변수와 out변수와 in out 변수
create or replace procedure parameter_test(
    p_var1 in varchar2,
    p_var2 out varchar2,
    p_var3 in out varchar2)
is
begin
    --in변수와 out변수에 전달된 내용을 모두 출력해 봄
    dbms_output.put_line('p_var1 value = '||p_var1);
    --out변수는 전달인수를 값으로 전달받지 못하는 변수임. 값을 전달해줘도 적용되지 않음
    --in 변수로서의 기능을 부여하려면 변수 선언당시 in과 out을 같이 사용함.
    dbms_output.put_line('p_var2 value = '||p_var2);
    dbms_output.put_line('p_var3 value = '||p_var3);
    --in 변수와 out변수에 모두 값을 대입해봄
    p_var1 := 'A2';  --in변수는 전달인수에 의해 값이 정해질 뿐 임의로 값을 변경하지 못함.
    p_var2 := 'B2';
    p_var3 := 'C2';
end;

DECLARE
    v_var1 varchar2(10) :='A';
    v_var2 varchar2(10) :='B';
    v_var3 varchar2(10) :='C';
begin
    parameter_test(v_var1,v_var2,v_var3);
    dbms_output.put_line('v_var1 value = '||v_var1);
    dbms_output.put_line('v_var2 value = '||v_var2);
    dbms_output.put_line('v_var3 value = '||v_var3);
    --프로시져에 out변수로 전달된 변수는 프로시져 실행 후 프로시져 내에서 넣어준 값이 저장되어 있게 됨
end;

--in out 변수의 사용규칙
--1. in 변수는 전달인수로 전달되어 저장된 값을 참조만 할 수 있고, 값을 할당할 수 없음
--2. out 변수에는 전달인수로 값을 전달할 수는 있지만, 참조할 수 없으므로 의미가 없는 전달
--3. out 변수와 in out 변수는 디폴트값을 지정할 수 없음
--4. in변수에는 변수, 상수, 각 데이터형에 따른 값을 전달인수로 전달 할 수 있지만, out변수와 in out변수는 반드시 변수형태로 전달인수를 넣어줘야함


--Default value
create or replace procedure newRentList(
    p_bnum in rentlist.bnum%type,
    p_mnum in rentlist.bnum%type,
    p_discount in rentlist.discount%type := 100 --디폴트 밸류:매개변수에 값을 미리 저장함
)
is
begin
    insert into rentlist(rentdate, numseq, bnum, mnum, discount)
    values (sysdate, rent_seq.nextVal, p_bnum, p_mnum, p_discount);
    commit;
end;
exec newRentList(5,5);

--매개변수 인수 전달시, 순서 변경
exec newRentList(p_mnum=>5, p_bnum=>6);
select * from rentlist order by numseq desc;


--return문:프로시져에서 return은 값을 리턴하겠다는 명령이 아니고, 현시점에서 프로시져를 끝내겠다는 뜻
--rentlist에 레코드를 추가하기 전에 전달된 도서번호와 회원번호가 없다면 '해당 도서번호가 없습니다' 또는 '해당 회원번호가 없습니다.' 라고 출력하고
--중간에 프로시져가 끝나도록 아래 프로시져를 수정하기
--default value 2
create or replace procedure newRentList(
    p_bnum in rentlist.bnum%type,
    p_mnum in rentlist.bnum%type,
    p_discount in rentlist.discount%type := 100 --디폴트 밸류:매개변수에 값을 미리 저장함
)
is
    bcnt Number; mcnt Number;
begin
    select count(*) into bcnt from booklist where booknum=p_bnum;
    if bcnt=0 then
        dbms_output.put_line('해당 도서번호가 없습니다');  return; --프로시져 종료
    end if;
    select count(*) into mcnt from memberlist where membernum=p_mnum;
    if mcnt=0 then
        dbms_output.put_line('해당 회원번호가 없습니다');  return; --프로시져 종료
    end if;
    insert into rentlist(rentdate, numseq, bnum, mnum, discount)
    values (sysdate, rent_seq.nextVal, p_bnum, p_mnum, p_discount);
    commit;
end;
exec newRentList(20,60,100);

--매개변수 인수 전달시, 순서 변경
exec newRentList(p_mnum=>5, p_bnum=>6);
select * from rentlist order by numseq desc;



