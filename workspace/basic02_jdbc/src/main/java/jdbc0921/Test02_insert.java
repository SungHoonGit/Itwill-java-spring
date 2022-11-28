package jdbc0921;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02_insert {

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
						
			//4) SQL 작성
			// -> 주의사항)SQL 종결문자 ; 를 쓰면 오류남
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO sungj)uk(sno, uname, kor, eng, mat, addr, wdate)");
			sql.append("VALUES (sungjuk_seq.nextval, '손흥민', 99, 98, 97, 'Seoul', sysdate)");
			// System.out.println(sql.toString());
			
			//5) SQL형식으로 변환
			PreparedStatement pstmt= con.prepareStatement(sql.toString());
			
			//6# SQL 문 
			int cnt=pstmt.executeUpdate();	// INSERT, UPDATE, DELETE문 실행
			
			
			
		} catch (Exception e) {
			System.out.println("실패 :" + e);
		} // end
			
		System.out.println("END");

	} // main() end
} // class end