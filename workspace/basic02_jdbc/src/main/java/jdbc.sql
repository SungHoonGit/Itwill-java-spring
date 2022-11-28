-- sungjuk테이블 행추가
insert into sungjuk(sno, uname, kor, eng, mat, addr, wdate)
values (sungjuk_seq.nextval, '손흥민', 99, 98, 97, 'Seoul', sysdate)


-- 오라클 콘솔창 예쁘게 출력
set linesize 1000;
col uname for a10;	-- col 칼럼 for 20자
col addr for a10;	-- col 칼럼 for 20자
select * from sungjuk order by sno desc;


select *
from sungjuk
order by sno desc;


-- 문제) 주소가 서울인 행들의 국영수 평균값을 구하시오
-- 		(단, 소수점은 반올림해서 둘째자리값까지 표현)
select addr ,round(avg(aver),2)as avg
from (
	select addr, round((kor+eng+mat)/3,2)as aver
	from sungjuk
	group by addr, round((kor+eng+mat)/3,2)
	having addr='Seoul'
	order by addr  desc
)
group by addr;



------------ 강사님

1) 주소가 서울인 행 조회하기
select addr, uname, kor, eng, mat
from sungjuk
where addr='Seoul';

2) 주소가 서울인 행을 대상으로 국영수 평균 구하기
select avg(kor), avg(eng), avg(eng)
from sungjuk
where addr='Seoul';

3) 주소가 서울인 행을 대상으로 국영수 평균 구하고 반올림해서 소수점 둘째 자리까지 표현
select round(avg(kor),2), round(avg(eng),2), round(avg(mat),2)
from sungjuk
where addr='Seoul';

4) 주소가 서울인 행을 대상으로 국영수 평균구하고 반올림해서 소수점 둘째 자리까지 표현하고, 컬럼명 변경하기
select round(avg(kor),2) as avg_kor
	 , round(avg(eng),2) as avg_eng
	 , round(avg(mat),2) as avg_mat
from sungjuk
where addr='Seoul';



-- 문제) 이름에 '나' 문자 있는 행을 조회하시오  					package jdbc0922  / Test05_selectLike

select *
from sungjuk
where uname like '%나%';




-- 문제) 학번 g1001이 수강신청한 과목을 과목코드별로 조회하시오		package jdbc0922  / Test06_quiz
		/*	 
				g1001	p001	OOP
				g1001	p003	JSP
				g1001	d001	웹표준
		*/
select hakno, sg.gcode, gname 
from tb_sugang sg join tb_gwamok gm on sg.gcode=gm.gcode
where hakno = 'g1001'
order by SG.gcode;


-- 문제) sungjuk테이블에서 이름순으로 정렬후 행번호 4~6만 조회하시오	package jdbc0922  /  Test07_selectPaging

create sequence seq start with 1 increment by 1;
drop sequence seq;

ALTER TABLE sungjuk ADD num varchar(10) default 1 not null;
alter table sungjuk drop column num


SELECT * FROM sungjuk WHERE ROWNUM BETWEEN 1 AND 6; -- 1부터만 사용가능

SELECT * 
FROM (SELECT ROWNUM rm, sg.* FROM sungjuk sg)
WHERE rm BETWEEN 4 AND 6;



---------  강사님
1) 
select uname, aver, addr
from sungjuk
order by uname;

2) rownum도 같이 정렬된다
select uname, aver, addr, rownum
from sungjuk
order by uname;

3) 1)의 결과를 한번 더 셀프조인하고, rownum 추가하기

select uname, aver ,addr ,rownum
from (
	select uname, aver, addr
	from sungjuk
	order by uname
	);
	
4) 행번호 4~6 조회하기 ( 결과: 조회되지 않음 )

select uname, aver ,addr ,rownum
from (
	select uname, aver, addr
	from sungjuk
	order by uname
	)
where rownum>=4 and rownum<=6;

5) 3)의 내용을 한번 더 셀프조인한 행번호 4~6 조회하기
select *
from (
	select uname, aver ,addr ,rownum as rnum
	from (
		select uname, aver, addr
		from sungjuk
		order by uname
		)
	)
where rnum >= 4 and rnum <= 6;


