package jdbc0921;

import java.sql.*;

public class Test01_DBOpen {

	public static void main(String[] args) {
		// Oracle DB 18c XE 연결

		try {
			
			//1) 오라클DB 서버 연결 관련 정보 
			String url		= "jdbc:oracle:thin:@localhost:1521:xe"; // 위치
			String user		= "system";	 // 아이디
			String password	= "1234";
			String driver	= "oracle.jdbc.driver.OracleDriver";	// ojdbc8.jar
			          //  이것이 있어야지만 오라클에 연동가능
			
			//2) 드라이버 로딩
			Class.forName(driver);	// 데이터가 다닐수 있는 길
			
			//3) 오라클 DB 서버 연결   빨리쓸수 있고 continue 된다.
			DriverManager.getConnection(url, user, password);
			
			System.out.println("오라클DB 서버 연결 성공!!");
			
			
		}catch (Exception e) {
			System.out.println("오라클  DB 연결 실패 : " + e);
		}//end		// 이미 내부적으로 있지만 기계적 코딩
				
		
	}// main() end
}// class end
