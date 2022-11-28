package kr.co.itwill.mediagroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// @Service
// @Repository 모델클래스로 지정. 스프링 컨테이너가 자동으로 객체 생성해 준다
@Repository
public class MediagroupDAO {

	 // DBOpen dbopen= new DBOpen()
	@Autowired
	private JdbcTemplate jt; // DBOpen dpopen=new DBOpen()와 동일한 형태
	
	StringBuilder sql=null;
	
	public MediagroupDAO() {
		System.out.println("------------3--MediagroupDAO() 객체 생성됨");
	}//end
	
	// 비지니스 로직 구현
	
	public int create(MediagroupDTO dto) {
		int cnt=0;
		try {
			sql=new StringBuilder();
			/* Oracle
			 * sql.append(" INSERT INTO mediagroup(mediagroupno, title) ");
			 * sql.append(" VALUES( mediagroup_seq.nextval, ? ) ");
			   Maria   */
			
		      sql.append(" INSERT INTO mediagroup(mediagroupno, title)");
		      sql.append(" VALUES((select ifnull(max(mediagroupno),0)+1 from mediagroup as TB), ?)");
		      
			cnt=jt.update(sql.toString(), dto.getTitle());
		}catch (Exception e) {
			System.out.println("미디어그룹등록실패 : " + e);
		}//end
		return cnt;
	}// create()end
	
	
	public int totalRowCount() {
		int cnt=0;
		try {
			sql=new StringBuilder();
			sql.append(" SELECT COUNT(*) FROM mediagroup ");
			cnt=jt.queryForObject(sql.toString(), Integer.class);
		}catch (Exception e) {
			System.out.println("전체 행 갯수:" + e );
		}// end
		return cnt;
	}//totalRowCount() end
	
	
	// 페이징 추가 시작
	
	public List<MediagroupDTO> list(){
		List<MediagroupDTO> list = null;
		try {
			sql=new StringBuilder();
			sql.append(" SELECT mediagroupno, title ");
			sql.append(" FROM mediagroup ");
			sql.append(" ORDER BY mediagroupno DESC ");
			
			RowMapper<MediagroupDTO> rowMapper=new RowMapper<MediagroupDTO>() {
				@Override
				public MediagroupDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MediagroupDTO dto=new MediagroupDTO();
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					dto.setTitle(rs.getString("title"));
					//System.out.println(rowNum + "" + dto.toString());
					return dto;
				}// mapRow() end
			}; // rowMapper end
			
			list = jt.query(sql.toString(), rowMapper);
			
		}catch (Exception e) {
			System.out.println("미디어그룹목록실패 : " + e);
		}// end
		return list;
	}// list() end
	
	
	public List<MediagroupDTO> list2(int start, int end) { // 페이징
		List<MediagroupDTO> list=null;
		try {
			sql=new StringBuilder();
			/* Oracle
			sql.append(" SELECT AA.* ");
			sql.append(" FROM ( ");
			sql.append(" 	SELECT  limit AS RNUM , BB.* ");
			sql.append(" 	FROM ( ");
			sql.append(" 		SELECT mediagroupno, title ");
			sql.append("		FROM mediagroup ");
			sql.append("		ORDER BY mediagroupno DESC ");
			sql.append("		) BB ");
			sql.append("	) AA ");
			sql.append(" WHERE AA.RNUM >=" + start + " AND AA.RNUM<= " + end);
			   Maria  */
	          sql.append(" SELECT AA.* ");
	          sql.append(" FROM ( ");
	          sql.append("    SELECT @RNO := @RNO + 1 AS r, CC.* ");
	          sql.append("    FROM ( ");
	          sql.append("       SELECT mediagroupno, title ");
	          sql.append("       FROM mediagroup ");
	          sql.append("    ) CC, ( SELECT @RNO := 0 ) BB ORDER BY mediagroupno DESC ");
	          sql.append(" ) AA ");
	          sql.append(" WHERE r >=" + start + " AND r <= " + end );
			
			
			
			RowMapper<MediagroupDTO> rowMapper = new RowMapper<MediagroupDTO>() {
				@Override
				public MediagroupDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MediagroupDTO dto=new MediagroupDTO();
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					dto.setTitle(rs.getString("title"));
					return dto;
				}// mapRow() end
			};// rowMapper end
			
			list=jt.query(sql.toString(), rowMapper);
			
		}catch (Exception e) {
			System.out.println("미디어그룹페이징실패 : " + e);
		}// end
		return list;
	}// list2() end
	
	
	public int delete(int mediagroupno) {
		int cnt = 0;
		try {
			sql = new StringBuilder();
			sql.append(" DELETE FROM mediagroup ");
			sql.append(" WHERE mediagroupno = ? ");
			cnt = jt.update(sql.toString(), mediagroupno);
		}catch (Exception e) {
			System.out.println("미디어그룹 삭제실패 : " + e );
		}//end
		return cnt;		
	}// delete() end
	
	
	public MediagroupDTO read(int mediagroupno) {
		MediagroupDTO dto=null;
		try {
			sql = new StringBuilder();
			sql.append(" SELECT mediagroupno, title ");
			sql.append(" FROM mediagroup ");
			sql.append(" WHERE mediagroupno = " + mediagroupno);
			
			RowMapper<MediagroupDTO> rowMapper=new RowMapper<MediagroupDTO>() {
				
				public MediagroupDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MediagroupDTO dto = new MediagroupDTO();
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					dto.setTitle(rs.getString("title"));
					return dto;
				}// mapRow()end
			}; // RowMapper end
			
			dto = jt.queryForObject(sql.toString(), rowMapper);
			
		} catch (Exception e) {
			System.out.println("미디어그룹 상세보기 실패 : " + e);
		}// end
		return dto;
	}// read() end
	
	
	public int update(MediagroupDTO dto) {
		int cnt=0;
		try {
			sql = new StringBuilder();
			sql.append(" UPDATE mediagroup ");
			sql.append(" SET title = ? ");
			sql.append(" WHERE mediagroupno = ? ");
			cnt = jt.update(sql.toString(), dto.getTitle(), dto.getMediagroupno());
			
		} catch (Exception e) {
			System.out.println("미디어그룹 수정실패 : " + e);
		}//cnt.end
		return cnt;
	}// update() end
	
}// class end
