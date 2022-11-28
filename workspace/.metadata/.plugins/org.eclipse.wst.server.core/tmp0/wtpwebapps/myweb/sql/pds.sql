-- pds.sql
-- 포토갤러리 게시판

-- 테이블 생성

CREATE TABLE tb_pds (
   pdsno      NUMBER         NOT NULL
  ,wname      VARCHAR2(100)  NOT NULL
  ,subject    VARCHAR2(250)  NOT NULL
  ,regdate    DATE           NOT NULL
  ,passwd     VARCHAR2(15)   NOT NULL
  ,readcnt    NUMBER         DEFAULT 0
  ,filename   VARCHAR2(250)  NOT NULL   --파일명
  ,filesize   NUMBER         DEFAULT 0  --파일크기
  ,PRIMARY KEY(pdsno)
);

-- 시퀀스 생성
create sequence pds_seq;

-- 행추가
pdsno				   : 시퀀스
wname, subject, passwd : 사용자 입력 <form></form>
regdate				   : 오늘날짜 (sysdate)
filename, filesize 	   : 첨부파일 관련 정보

insert into tb_pds(pdsno, wname, subject, passwd, filename, filesize, regdate)
values (pds_seq.nextval, ?, ?, ?, ?, ?, sysdate)

-- 전체목록
select pdsno, wname, subject, filename, filesize, readcnt, regdate
from tb_pds
order by regdate desc;

-- 상세보기
select * 
from tp_pds 
where pdsno=?

-- 행삭제
글번호와 비밀번호가 일치하면 테이블 행삭제 + /storage폴더 관련된 파일도 삭제
delete from tb_pds 
where pbsno=? and passwd=?

-- 행수정
update tb_pds 
set wname=?, subject=?, filename=?, filesize=?
where pbsno=? and passwd=?
