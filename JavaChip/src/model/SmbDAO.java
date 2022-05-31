package model;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SmbDAO {
		

	public int join(SmbDTO dto) {

		// 1. 동적 로딩
		// 1-1. ojdbc6.jar 파일 추가!!
		// 동적 로딩할 class file 찾기!!

	
		int cnt = 0;
		Connection conn = null;	
		PreparedStatement psmt=null;

		try {
			conn = connect();	
			
			// 3. SQL문장 실행
			
			String id = dto.getId();
			String pw = dto.getPw();
			String n_name = dto.getName();
			
			
			
			String sql = "insert into j_user values(?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, n_name);					
			
			// CRUD
			// C : Create (Insert) 	회원가입
			// R : Read (Select) 	회원조회
			// U : Update (Update) 	회원변경
			// D : Delete (Delete) 	회원삭제

			// executeUpdate();	C, U, D
			// executeQuery(); 	R

			cnt = psmt.executeUpdate();
		

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("로딩 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("회원가입 실패");
		} finally {
			// 4. 연결 종료 : 역순으로 닫는다!
			// pmst 닫기!
			// conn 닫기!			
			
			try {
				if(psmt != null) {
				psmt.close();
				}
				if(conn!= null) {
					conn.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

		return cnt;
	}

	
	
	
	public int login(SmbDTO dto) {
		
		
		
		
		
		return -1;
		
	}
	
	
	public void Ranking (SmbDTO dto) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Connection connect() throws ClassNotFoundException, SQLException {
		Connection conn;
		// 컴파일(compile) 이후에 알 수 있는 에러들에 대해서도
		// 예외처리를 해줘야 한다
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공");
		// 2. DB 연결

		// 1) url 2)db_id 3) db_pw
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_f_0516_4";
		String db_pw = "smhrd4";

		conn = DriverManager.getConnection(url, db_id, db_pw);
		if (conn != null) {
			System.out.println("접속 성공");
		}

		return conn;
	}

}

	

