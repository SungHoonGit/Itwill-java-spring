package jdbc0921;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test05_insert {

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

			
			String name = "박지성";
			int kor = 99, eng = 98, mat = 100;
			String addr = "Seoul";
			
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO sungjuk(sno, uname, kor, eng, mat, addr, wdate) ");
			sql.append(" VALUES (sungjuk_seq.nextval, ?, ?, ?, ?, ?, sysdate)");
					// -> ? 특정값으로 대입할 수 있는 표식중 하나    '?' = 문자열
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			//-> ? 의 갯수, 순서, 자료형이 일치해야 한다
			pstmt.setString(1, name);	// 1 번째 물음표 name 칼럼
			pstmt.setInt(2, kor);		// 2 번째 물음표 kor 칼럼
			pstmt.setInt(3, eng);		// 3 번째 물음표 eng 칼럼
			pstmt.setInt(4, mat);		// 4 번째 물음표 mat 칼럼
			pstmt.setString(5, addr);	// 5 번째 물음표 addr 칼럼
			
			int cnt=pstmt.executeUpdate();
			if(cnt==0) {
				System.out.println("행 추가 실패!!");
			}else {
				System.out.println("행 추가 성공~~");
			}// if end
			
			pstmt.close();
			con.close();
			
			
		} catch (Exception e) {
			System.out.println("실패 :" + e);
		} // end
			
		System.out.println("END");

	} // main() end
} // class end