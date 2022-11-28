package net.nbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBClose;
import net.utility.DBOpen;

public class NbsDAO {

    private DBOpen dbopen=null;
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private StringBuilder sql=null;
    
    public NbsDAO() {
        dbopen=new DBOpen();
    }// end
    
    public int create(NbsDTO dto) {
        int cnt=0;
        try {
            con=dbopen.getConnection(); // DB 연결
            
            sql=new StringBuilder();
            sql.append(" INSERT INTO tb_nbs(nbsno, subject, content) ");
            sql.append(" VALUES(nbs_seq.nextval, ?, ?) ");
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getSubject());
            pstmt.setString(2, dto.getContent());
            
            cnt=pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("추가실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }// end 
        return cnt;    
    }// create() end
    
    public ArrayList<NbsDTO> list() {
        ArrayList<NbsDTO> list=null;
        try {
            con=dbopen.getConnection();
            
           sql=new StringBuilder();
           sql.append(" SELECT nbsno, subject, readcnt, regdt, indent");
           sql.append(" FROM tb_nbs ");
           sql.append(" ORDER BY nrpno DESC, ansnum ASC ");
           
           pstmt=con.prepareStatement(sql.toString());
           rs=pstmt.executeQuery();
           if(rs.next()) {
               list=new ArrayList<>();
               do {
                   NbsDTO dto=new NbsDTO(); // 한줄담기
                   dto.setNbsno(rs.getInt("nbsno"));
                   dto.setSubject(rs.getString("subject"));
                   dto.setReadcnt(rs.getInt("readcnt"));
                   dto.setRegdt(rs.getString("regdt"));
                   list.add(dto);   // list 에 모으기
               }while(rs.next());
           }//if end
            
        } catch (Exception e) {
            System.out.println("전체목록실패:"+e);
        } finally {
            DBClose.close(con, pstmt, rs);;
        }//end
        return list;
    }//list() end
    
    
    public NbsDTO read(int nbsno) {
        NbsDTO dto=null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT nbsno, subject, content, readcnt, regdt");
            sql.append(" from tb_nbs ");
            sql.append(" where nbsno=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, nbsno);
            
            rs=pstmt.executeQuery();
            if(rs.next()) {
                dto=new NbsDTO();
                dto.setNbsno(rs.getInt("nbsno"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setReadcnt(rs.getInt("readcnt"));
                dto.setRegdt(rs.getString("regdt"));                
            }// end            
        } catch (Exception e) {
            System.out.println("글 갯수 실패:" + e);
        } finally {
            DBClose.close(con, pstmt, rs);
        } 
        return dto;             
    }// read() end    
    
    
    public void incrementCnt(int nbsno) {
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" UPDATE tb_nbs ");
            sql.append(" SET readcnt=readcnt+1 ");
            sql.append(" WHERE nbsno=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, nbsno);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("조회수 추가 실패:" + e);
        } finally {
            DBClose.close(con, pstmt);
        }//end    
    }// incrementCnt() end  
    
    
    public int delete(NbsDTO dto) {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" DELETE FROM tb_nbs ");
            sql.append(" WHERE nbsno=?");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, dto.getNbsno());
            cnt=pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("삭제 실패:"+e);
        } finally {
            DBClose.close(con, pstmt);
        }// end
        return cnt;
    }// delete() end
    
    
    public int updateproc(NbsDTO dto) {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" UPDATE tb_nbs ");
            sql.append(" SET subject=?, content=? ");
            sql.append(" WHERE nbsno=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getSubject());
            pstmt.setString(2, dto.getContent());
            pstmt.setInt(3, dto.getNbsno());
            
            cnt=pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("수정 실패 : " + e );
        } finally {
            DBClose.close(con, pstmt);
        }// end
        return cnt;
    }// end update
    
    
    public int count2(String col, String word) {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT COUNT(*) as cnt ");
            sql.append(" FROM tb_nbs ");
            
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
    

    public ArrayList<NbsDTO> list3(String col, String word, int nowPage, int recordPerPage){
        ArrayList<NbsDTO> list=null;
        
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
                sql.append("         SELECT nbsno,subject,readcnt,regdt, rownum as r ");
                sql.append("         FROM ( ");
                sql.append("                 SELECT nbsno,subject,readcnt,regdt ");
                sql.append("                 FROM tb_nbs ");
                sql.append("                 ORDER BY nbsno DESC ");
                sql.append("              ) ");
                sql.append("      ) ");
                sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
                
            }else { //검색 하는 경우  -> 7)
                sql.append(" SELECT * ");
                sql.append(" FROM ( ");
                sql.append("         SELECT nbsno,subject,readcnt,regdt, rownum as r ");
                sql.append("         FROM ( ");
                sql.append("                 SELECT nbsno,subject,readcnt,regdt ");
                sql.append("                 FROM tb_nbs ");
                
                String search="";
                if(col.equals("subject_content")) {
                    search += " WHERE subject LIKE '%" + word + "%' ";
                    search += " OR    content LIKE '%" + word + "%' ";
                }else if(col.equals("subject")) {
                    search += " WHERE subject LIKE '%" + word + "%' ";
                }else if(col.equals("content")) {
                    search += " WHERE content LIKE '%" + word + "%' ";
                }else if(col.equals("wname")) {
                    search += " WHERE wname LIKE '%" + word + "%' ";
                }//if end 
                sql.append(search);                
                
                sql.append("                 ORDER BY nbsno DESC ");
                sql.append("              ) ");
                sql.append("      ) ");
                sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
            }//if end   
            
            
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<>();
                do {
                    NbsDTO dto=new NbsDTO();//한줄담기
                    dto.setNbsno(rs.getInt("nbsno"));
                    dto.setSubject(rs.getString("subject"));
                    dto.setReadcnt(rs.getInt("readcnt"));
                    dto.setRegdt(rs.getString("regdt"));
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
    
    
}// class end
