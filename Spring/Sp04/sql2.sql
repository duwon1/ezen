CREATE TABLE student(
   sNum varchar2(20),
   sId varchar2(20),
   sPw varchar2(20),
   sName varchar2(20),
   sAge number(3),
   sGender varchar2(20),
   sMajor varchar2(80)
);
select * from student;
delete from student;
drop table student;