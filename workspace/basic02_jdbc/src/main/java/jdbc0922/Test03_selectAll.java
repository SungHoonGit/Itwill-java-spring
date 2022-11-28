package jdbc0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test03_selectAll {

	public static void main(String[] args) {
		// sungjuk 테이블에서 한 행 조회하기
			
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			
			String url		= "jdbc:oracle:thin:@localhost:1521:xe"; // 위치
			String user		= "system";	 // 아이디
			String password	= "1234";
			String driver	= "oracle.jdbc.driver.OracleDriver";	// ojdbc8.jar
			Class.forName(driver);	// 데이터가 다닐수 있는 길
			con =  DriverManager.getConnection(url, user, password);
			System.out.println("오라클DB 서버 연결 성공!!");


			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT sno, uname, kor, eng, mat, tot, aver, addr, wdate ");
			sql.append(" FROM sungjuk ");
			sql.append(" ORDER BY sno DESC ");
				
			
			pstmt=con.prepareStatement(sql.toString());			
			rs = pstmt.executeQuery();			
			
			if (rs.next()) { // cursor 가 있는지?
				System.out.println("자료있음~~");
				do {
					System.out.print(rs.getInt("sno")+ " ");		//1번칼럼. sno칼럼
					System.out.print(rs.getString("uname")+ " ");	//2번칼럼. uname칼럼
					System.out.print(rs.getInt("kor")+ " ");
					System.out.print(rs.getInt("eng")+ " ");
					System.out.print(rs.getInt("mat")+ " ");
					System.out.print(rs.getInt("tot")+ " ");
					System.out.print(rs.getInt("aver")+ " ");
					System.out.print(rs.getString("addr")+ " ");
					System.out.print(rs.getString("wdate")+ " ");					
					System.out.println();
				}while(rs.next()); // 다음 cursor 가 있는지?
				
			} else {
				System.out.println("자료없음!!");
			}// if end
			
		} catch (Exception e) {
			System.out.println("실패 :" + e);
		} finally { //자원 반납( 순서주의)
			try {
				if(rs!=null) {rs.close();}
			} catch (Exception e2) {} 
			try {
				if(pstmt!=null) {pstmt.close();}
			} catch (Exception e2) {} 
			try {
				if(con!=null) {con.close();}
			} catch (Exception e2) {} 
			
		}// end

		
		
		
	}// main() end
}// class end