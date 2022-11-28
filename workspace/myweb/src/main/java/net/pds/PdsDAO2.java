package net.pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBClose;
import net.utility.DBOpen;

public class PdsDAO2 {

    private DBOpen dbopen=null;
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private StringBuilder sql=null;
    
    public PdsDAO2() {
        dbopen=new DBOpen();
    }// end 
    
    public int create(PdsDTO dto) {
        int cnt=0;
        try {
            con=dbopen.getConnection();//DB 연결
            
            sql=new StringBuilder();
            sql.append(" insert into tb_pds(pdsno, wname, subject, passwd, filename, filesize, regdate) ");
            sql.append(" values (pds_seq.nextval, ?, ?, ?, ?, ?, sysdate) ");
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getWname());
            pstmt.setString(2, dto.getSubject());
            pstmt.setString(3, dto.getPasswd());
            pstmt.setString(4, dto.getFilename());
            pstmt.setLong(5, dto.getFilesize());
            
            cnt=pstmt.executeUpdate();
            
        }catch (Exception e) {
            System.out.println("추가실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }// end
        return cnt;
    }// create() end
    
    
    public ArrayList<PdsDTO> list() {
        ArrayList<PdsDTO> list=null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT pdsno, wname, subject, filename, readcnt, regdate ");
            sql.append(" FROM tb_pds ");
            sql.append(" ORDER BY regdate DESC ");
            
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<PdsDTO>();
                do {
                    PdsDTO dto=new PdsDTO();
                    dto.setPdsno(rs.getInt("pdsno"));
                    dto.setWname(rs.getString("wname"));
                    dto.setSubject(rs.getString("subject"));
                    dto.setFilename(rs.getString("filename"));
                    dto.setReadcnt(rs.getInt("readcnt"));
                    dto.setRegdate(rs.getString("regdate"));
                    list.add(dto);
                }while(rs.next());
            }//if end
            
        }catch (Exception e) {
            System.out.println("목록실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return list;
    }//list () end
    
    // 내가 한 그읏
    public ArrayList<PdsDTO> list3(String col, String word, int nowPage, int recordPerPage){
        ArrayList<PdsDTO> list=null;
        
        //페이지당 출력할 행의 갯수(10개를 기준)
        //1 페이지 : WHERE r>=1  AND r<=10;
        //2 페이지 : WHERE r>=11 AND r<=20;
        //3 페이지 : WHERE r>=21 AND r<=30;
        int startRow = ((nowPage-1) * recordPerPage) + 1 ;
        int endRow   = nowPage * recordPerPage;
        
        try {
            con=dbopen.getConnection();            
            sql=new StringBuilder();
            
            word=word.trim(); //검색어 좌우 공백 제거
            
            if(word.length()==0) { //검색하지 않는 경우    -> 6)
                sql.append(" SELECT * ");
                sql.append(" FROM ( ");
                sql.append("         SELECT pdsno,subject,wname,readcnt,regdate, rownum as r " );
                sql.append("         FROM ( ");
                sql.append("                 SELECT bbsno,subject,wname,readcnt,regdate " );
                sql.append("                 FROM tb_pds ");
                sql.append("                 ORDER BY grpno DESC, ansnum ASC " );
                sql.append("              ) " );
                sql.append("      ) " );
                sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
                
            }else { //검색 하는 경우  -> 7)
                sql.append(" SELECT * ");
                sql.append(" FROM ( ");
                sql.append("         SELECT pdsno,subject,wname,readcnt,regdate, rownum as r " );
                sql.append("         FROM ( " );
                sql.append("                 SELECT pdsno,subject,wname,readcnt,regdate" );
                sql.append("                 FROM tb_pds " );
                
                String search="";
                if(col.equals("subject_content")) {
                    search += " WHERE subject LIKE '%" + word + "%' ";
                    search += " OR    content LIKE '%" + word + "%' ";
                }else if(col.equals("subject")) {
                    search += " WHERE subject LIKE '%" + word + "%' ";

                }else if(col.equals("wname")) {
                    search += " WHERE wname LIKE '%" + word + "%' ";
                }//if end 
                sql.append(search);                
                
                sql.append("                 ORDER BY grpno DESC, ansnum ASC ");
                sql.append("              ) ");
                sql.append("      ) ");
                sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
            }//if end   
            
            
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<>();
                do {
                    PdsDTO dto=new PdsDTO();//한줄담기
                    dto.setPdsno(rs.getInt("pdsno"));
                    dto.setWname(rs.getString("wname"));
                    dto.setSubject(rs.getString("subject"));
                    dto.setReadcnt(rs.getInt("readcnt"));
                    dto.setRegdate(rs.getString("regdate"));
                    list.add(dto); //list에 모으기
                }while(rs.next());
            }//if end
            
        }catch (Exception e) {
            System.out.println("목록 페이징 실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return list;
    }//list3() end
    
    public int count2(String col, String word) {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT COUNT(*) as cnt ");
            sql.append(" FROM tb_pds ");
            
            if(word.length()>=1) { // 검색어가 존재한다면
                String search="";
                if(col.equals("subject_content")) {
                    search += " WHERE subject LIKE '%" + word + "%' ";
                    search += " OR    content LIKE '%" + word + "%' ";
                }else if (col.equals("subject")) {
                    search += " WHERE subject LIKE '%" + word + "%' ";
                }else if (col.equals("content")) {
                    search += " WHERE content LIKE '%" + word + "%' ";
                }else if (col.equals("wname")) {
                    search += " WHERE wname LIKE '%" + word + "%' ";
                }// if end
                sql.append(search);
            }// if end
            
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                cnt=rs.getInt("cnt");
            }// if end
            
        } catch (Exception e) {
            System.out.println("검색 글갯수 실패:"+e);
        } finally {
            DBClose.close(con, pstmt, rs);
        }// end
        return cnt;
    }// count2() end
        
    public void incrementCnt(int pdsno) {
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" UPDATE tb_pds ");
            sql.append(" SET readcnt=readcnt+1 ");
            sql.append(" WHERE bbsno=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, pdsno);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("조회수 추가 실패:" + e);
        } finally {
            DBClose.close(con, pstmt);
        }//end    
    }// incrementCnt() end
    
}// class end
