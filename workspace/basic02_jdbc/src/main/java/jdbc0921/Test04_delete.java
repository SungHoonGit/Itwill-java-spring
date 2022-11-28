package jdbc0921;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test04_delete {

	public static void main(String[] args) {
		// sungjuk 테이블 행 추가 연습
		
		try {
			
			String url		= "jdbc:oracle:thin:@localhost:1521:xe"; // 위치
			String user		= "system";	 // 아이디
			String password	= "1234";
			String driver	= "oracle.jdbc.driver.OracleDriver";	// ojdbc8.jar
			Class.forName(driver);	// 데이터가 다닐수 있는 길
			Connection con =  DriverManager.getConnection(url, user, password);
			System.out.println("오라클DB 서버 연결 성공!!");

			
			
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM sungjuk WHERE sno=22 ");

			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			
			int cnt = pstmt.executeUpdate();	// 실행 했을때 행의 갯수가 반환
			if (cnt==0) {
				System.out.println("행 삭제 실패!!");
			} else {
				System.out.println("행 삭제 성공~~");
			}// if end
			
			// 자원반납(순서주의)
			pstmt.close();
			con.close();
			
			
		} catch (Exception e) {
			System.out.println("실패 :" + e);
		} // end
			
		System.out.println("END");

	} // main() end
} // class end