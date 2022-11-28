-- notice.sql

--테이블 생성

create table tb_nbs(
  nbsno    INT       	NOT NULL AUTO_INCREMENT PRIMARY KEY
 ,subject  VARCHAR(20)	NOT NULL
 ,content  TEXT			NOT NULL
 ,readcnt  INT			DEFAULT 0	NOT NULL			
 ,regdt    DATETIME		NOT NULL
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

