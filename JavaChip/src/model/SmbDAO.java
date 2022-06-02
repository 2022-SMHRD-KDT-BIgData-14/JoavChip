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

		// 1. ���� �ε�
		// 1-1. ojdbc6.jar ���� �߰�!!
		// ���� �ε��� class file ã��!!

		try {
			conn = connect();

			// 3. SQL���� ����

			String id = dto.getId();
			int pw = dto.getPw();
			String n_name = dto.getName();

			String sql = "insert into j_user(id, pw, n_name) values(?, ?, ?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setInt(2, pw);
			psmt.setString(3, n_name);

			// CRUD
			// C : Create (Insert) ȸ������
			// R : Read (Select) ȸ����ȸ
			// U : Update (Update) ȸ������
			// D : Delete (Delete) ȸ������

			// executeUpdate(); C, U, D
			// executeQuery(); R

			cnt = psmt.executeUpdate();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("�ε� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//		e.printStackTrace();
			System.out.println("ȸ������ ����");
		} finally {
			// 4. ���� ���� : �������� �ݴ´�!
			// pmst �ݱ�!
			// conn �ݱ�!

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

				System.out.println("=======�α��� ����=======");
				n = 1;
			} else {
				System.out.println("=======�α��� ����=======");
				System.out.println("ID, PW�� Ȯ���ϼ���");
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
			psmt = conn.prepareStatement(sql); // conn ��� �ȿ� prepareStatement()�޼ҵ带 psmt�� ����

			rs = psmt.executeQuery(); // executeQuery(): �ຯȭ x(select) / executeUpdate(): �� ��ȭ�� �ִ�
										// sql��(insert, update, delete)

			while (rs.next()) {// �÷����� ��ĭ���� -> rs.next() true�϶��� ������ ���
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
		// 4. ���� ����
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
		musicList.add(new SmbDTO("������ ��", path + "����-����-�ڸ޵�-����-B005.mp3"));
		musicList.add(new SmbDTO("���� �ܰ��", path + "�Ϸη�.mp3"));
		musicList.add(new SmbDTO("�¾��� ��", path + "������.mp3"));
		musicList.add(new SmbDTO("Ʋ���� ��", path + "nope.mp3"));
		musicList.add(new SmbDTO("���� ��", path + "����� �Դ� �Ҹ�1.mp3"));
		musicList.add(new SmbDTO("���� ��", path + "������ ���ٻ���.mp3"));
		musicList.add(new SmbDTO("�̺�Ʈ", path + "��--��-.mp3"));
		musicList.add(new SmbDTO("������", path + "���ɽ�Ʈ�� ����.mp3"));
		musicList.add(new SmbDTO("�׾��� ��", path + "������ �뷡.mp3"));

		MP3Player mp3 = new MP3Player();

//		mp3.play(musicList.get(1).getPath()); // ���� �ܰ��
//		mp3.play(musicList.get(2).getPath()); // �¾��� ��
//		mp3.play(musicList.get(3).getPath()); // Ʋ���� ��
//		mp3.play(musicList.get(4).getPath()); // ���� ��
//		mp3.play(musicList.get(5).getPath()); // ���� ��
//		mp3.play(musicList.get(6).getPath()); // �̺�Ʈ
//		mp3.play(musicList.get(7).getPath()); // ������
//		mp3.play(musicList.get(8).getPath()); // �׾��� ��

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
