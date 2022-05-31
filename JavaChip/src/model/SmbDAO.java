package model;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SmbDAO {
		

	public int join(SmbDTO dto) {

		// 1. ���� �ε�
		// 1-1. ojdbc6.jar ���� �߰�!!
		// ���� �ε��� class file ã��!!

	
		int cnt = 0;
		Connection conn = null;	
		PreparedStatement psmt=null;

		try {
			conn = connect();	
			
			// 3. SQL���� ����
			
			String id = dto.getId();
			String pw = dto.getPw();
			String n_name = dto.getName();
			
			
			
			String sql = "insert into j_user values(?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, n_name);					
			
			// CRUD
			// C : Create (Insert) 	ȸ������
			// R : Read (Select) 	ȸ����ȸ
			// U : Update (Update) 	ȸ������
			// D : Delete (Delete) 	ȸ������

			// executeUpdate();	C, U, D
			// executeQuery(); 	R

			cnt = psmt.executeUpdate();
		

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("�ε� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("ȸ������ ����");
		} finally {
			// 4. ���� ���� : �������� �ݴ´�!
			// pmst �ݱ�!
			// conn �ݱ�!			
			
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

	
	
	
	public void login(SmbDTO dto) {

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "select pw from j_user where id = ?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			rs = psmt.executeQuery();

			if (rs.next()) {
				String result = rs.getString("PW");
				if (result.equals(dto.getPw())) {
					System.out.println("=======�α��� ����=======");
				} else {
					System.out.println("=======�α��� ����=======");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	public void Ranking(SmbDTO dto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement psmt = null;

		String sql = "select u.ID, u.N_NAME, r.POINT from ( select u.ID, u.N_NAME, r.POINT from j_user u, j_ranking r where u.ID = r.ID order by point desc) where rownum < 10 = ?";
		try {
			connect();

			psmt.setString(1, dto.getId());

			psmt = conn.prepareStatement(sql);
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB ���� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Connection connect() throws ClassNotFoundException, SQLException {
		Connection conn;
		// ������(compile) ���Ŀ� �� �� �ִ� �����鿡 ���ؼ���
		// ����ó���� ����� �Ѵ�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����");
		// 2. DB ����

		// 1) url 2)db_id 3) db_pw
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_f_0516_4";
		String db_pw = "smhrd4";

		conn = DriverManager.getConnection(url, db_id, db_pw);
		if (conn != null) {
			System.out.println("���� ����");
		}

		return conn;
	}

}

	

