package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javazoom.jl.player.MP3Player;
import music.SmbMusicVO;

public class SmbDAO {
	int cnt = 0;
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs;

	public int join(SmbDTO dto) {

		// 1. 동적 로딩
		// 1-1. ojdbc6.jar 파일 추가!!
		// 동적 로딩할 class file 찾기!!

		try {
			conn = connect();

			// 3. SQL문장 실행

			String id = dto.getId();
			int pw = dto.getPw();
			String n_name = dto.getName();

			String sql = "insert into j_user(id, pw, n_name) values(?, ?, ?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setInt(2, pw);
			psmt.setString(3, n_name);

			// CRUD
			// C : Create (Insert) 회원가입
			// R : Read (Select) 회원조회
			// U : Update (Update) 회원변경
			// D : Delete (Delete) 회원삭제

			// executeUpdate(); C, U, D
			// executeQuery(); R

			cnt = psmt.executeUpdate();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("로딩 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//		e.printStackTrace();
			System.out.println("회원가입 실패");
		} finally {
			// 4. 연결 종료 : 역순으로 닫는다!
			// pmst 닫기!
			// conn 닫기!

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

		return cnt;
	}

	public int login(SmbDTO dto) {

		conn = null;
		psmt = null;
		rs = null;
		int n = 0;

		try {
			conn = connect();

			String sql = "select * from j_user where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setInt(2, dto.getPw());
			rs = psmt.executeQuery();

			if (rs.next()) {

				System.out.println("=======로그인 성공=======");
				n = 1;
			} else {
				System.out.println("=======로그인 실패=======");
				System.out.println("ID, PW를 확인하세요");
				n = 2;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
		return n;

	}

	public void Ranking(SmbDTO dto) {

		try {
			conn = connect();
			String sql = "select rownum, id, point from (select id, point from J_RANKING order by point desc) where rownum<4";
			psmt = conn.prepareStatement(sql); // conn 통로 안에 prepareStatement()메소드를 psmt에 대입

			rs = psmt.executeQuery(); // executeQuery(): 행변화 x(select) / executeUpdate(): 행 변화를 주는
										// sql문(insert, update, delete)

			while (rs.next()) {// 컬럼명에서 한칸내림 -> rs.next() true일때만 데이터 출력
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);

				System.out.print(id + " \t");
				System.out.print(pw + " \t");
				System.out.println(name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 4. 연결 종료
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rs != null) {
					psmt.close();
				}
				if (rs != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void SmbMusicMain() {

		ArrayList<SmbDTO> musicList = new ArrayList<SmbDTO>();

		String path = ".\\music\\";
		musicList.add(new SmbDTO("시작할 때", path + "경쾌-빠른-코메디-오락-B005.mp3"));
		musicList.add(new SmbDTO("다음 단계로", path + "뾰로롱.mp3"));
		musicList.add(new SmbDTO("맞았을 때", path + "예에에.mp3"));
		musicList.add(new SmbDTO("틀렸을 때", path + "nope.mp3"));
		musicList.add(new SmbDTO("먹을 때", path + "새우깡 먹는 소리1.mp3"));
		musicList.add(new SmbDTO("잠잘 때", path + "빠르게 뻐꾸뻐꾸.mp3"));
		musicList.add(new SmbDTO("이벤트", path + "빠--빠-.mp3"));
		musicList.add(new SmbDTO("레벨업", path + "오케스트라 연주.mp3"));
		musicList.add(new SmbDTO("죽었을 때", path + "좌절의 노래.mp3"));

		MP3Player mp3 = new MP3Player();

//		mp3.play(musicList.get(1).getPath()); // 다음 단계로
//		mp3.play(musicList.get(2).getPath()); // 맞았을 때
//		mp3.play(musicList.get(3).getPath()); // 틀렸을 때
//		mp3.play(musicList.get(4).getPath()); // 먹을 때
//		mp3.play(musicList.get(5).getPath()); // 잠잘 때
//		mp3.play(musicList.get(6).getPath()); // 이벤트
//		mp3.play(musicList.get(7).getPath()); // 레벨업
//		mp3.play(musicList.get(8).getPath()); // 죽었을 때

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
