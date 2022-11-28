-- notice.sql

--테이블 생성
create table tb_nbs(
  nbsno    number(5)       not null -- 일련번호 -99999~99999
 ,subject  varchar2(100)   not null -- 글제목
 ,content  varchar2(2000)  not null -- 글내용
 ,readcnt  number(5)       default 0 not null -- 글조회수
 ,regdt    date            default  sysdate   -- 글작성일
 ,primary key(nbsno)                 --bbsno 기본키
);


-- 시퀀스 생성
create sequence nbs_seq;

-- 행추가
pdsno				   : 시퀀스
wname, subject, passwd : 사용자 입력 <form></form>
regdate				   : 오늘날짜 (sysdate)
filename, filesize 	   : 첨부파일 관련 정보

insert into tb_pds(nbsno, subject, content, readcnt ,regdt)
values (pds_seq.nextval, ?, ?, ?, sysdate)


--Maria
create table tb_nbs(
  nbsno    int     		  not null AUTO_INCREMENT PRIMARY KEY   
 ,subject  varchar(100)   not null  
 ,content text			  not null
 ,readcnt  INT    		  default 0 not null
 ,regdt    datetime     NOT NULL
);