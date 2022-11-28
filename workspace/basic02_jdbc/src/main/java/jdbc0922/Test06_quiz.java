package jdbc0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test06_quiz {

	public static void main(String[] args) {
		// 문제) 학번 g1001이 수강신청한 과목을 과목코드별로 조회하시오
		/*
		 
				g1001	p001	OOP
				g1001	p003	JSP
				g1001	d001	웹표준
					
		*/
		
		String hakno = "g1001";	// 검색칼럼 keyfield

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
			sql.append("select hakno, sg.gcode, gname ");
			sql.append("from tb_sugang sg join tb_gwamok gm on sg.gcode=gm.gcode ");
			
			// 검색어 존재하는지?
//			if(hakno.length()>=0) {
//				// where hakno like '%g1001%'
//				String where=" WHERE hakno = '" + hakno + "' ";
//				sql.append(where);
//			}// if end
			
			sql.append(" WHERE Sg.hakno= ? ");
			
            sql.append(" ORDER BY sg.gcode ");
			
			
			
			
			 System.out.println(sql.toString());
			
			
			pstmt=con.prepareStatement(sql.toString());		
			
			pstmt.setString(1, hakno );
			rs = pstmt.executeQuery();			
			
			if (rs.next()) { // cursor 가 있는지?
				System.out.println("자료있음~~");
				do {
					System.out.print(rs.getString("hakno")+ " ");	
					System.out.print(rs.getString("gcode")+ " ");
					System.out.print(rs.getString("gname")+ " ");					
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
