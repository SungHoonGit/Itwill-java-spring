-- Maria DB 기반

-- pds.sql

-- 첨부형 게시판 테이블 생성

    CREATE TABLE tb_pds (
      pdsno       INT            NOT NULL AUTO_INCREMENT PRIMARY KEY
      ,wname      VARCHAR(100)   NOT NULL
      ,subject    VARCHAR(250)   NOT NULL
      ,regdate    DATETIME       NOT NULL
      ,passwd     VARCHAR(15)    NOT NULL
      ,readcnt    INT            DEFAULT 0
      ,filename   VARCHAR(250)   NOT NULL
      ,filesize   INT            DEFAULT 0
    );
    
  - 테스트
    INSERT INTO tb_pds (wname,subject,passwd,filename,filesize,regdate)
    values('무궁화', '오필승코리아','1234', 'buddy.png', 1000, now())   ; 