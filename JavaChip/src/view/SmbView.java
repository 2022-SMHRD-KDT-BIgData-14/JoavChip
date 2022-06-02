package view;

import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;
import model.SmbDAO;
import model.SmbDTO;
import model.StartGame;
import music.SmbMusicVO;
public class SmbView {
	
	
	public static void main(String[] args) {
		ArrayList<SmbDAO> musicList = new ArrayList<SmbDAO>();
		MP3Player mp3 = new MP3Player();

		// join() �޼ҵ� ȣ��!!

		Scanner sc = new Scanner(System.in);

		SmbDTO dto;
		SmbDAO dao;
		// �޴��� �����ϼ���
		// int menu = ��ĳ�ʸ� ���ؼ� ���� �Է�
		// menu�� 1�̸�

		// ====ȸ������====
		// ID�� �Է��ϼ��� >>
		// PW�� �Է��ϼ��� >>
		// n_name�� �Է��ϼ��� >>

		// ȸ������ ���� >> "ȸ������ �Ϸ�"
		// ȸ������ ���� >> "�ߺ��� ID�Դϴ�"

		int cnt = 0;
		mp3.play(".\\music\\����-����-�ڸ޵�-����-B005.mp3");
		
		while (true) {
			
			System.out.println("�޴��� �����ϼ���");
			System.out.print("[1] Join [2] Login [3] Ranking [4] Exit >>");
			int munu = sc.nextInt();

			if (munu == 1) {
				// ȸ������ ���
				System.out.println("====JOIN====");
				System.out.print("ID�� �Է��ϼ��� >> ");
				String id = sc.next();
				System.out.print("PW�� �Է��ϼ��� >> ");
				int pw = sc.nextInt();
				System.out.print("NICK_NAME�� �Է��ϼ��� >> ");
				String n_name = sc.next();

				dto = new SmbDTO(id, pw, n_name);
				dao = new SmbDAO();

				cnt = dao.join(dto);

				if (cnt > 0) {
					System.out.println("ȸ������ ����");
				} else {
					System.out.println("ID�� �ߺ��Ǿ����ϴ�.");
				}

			} else if (munu == 2) {
				// 2 Login ���
				System.out.println("====Login====");
				System.out.print("ID�� �Է��ϼ��� >> ");
				String id = sc.next();
				System.out.print("PW�� �Է��ϼ��� >> ");
				int pw = sc.nextInt();

				dto = new SmbDTO(id, pw);
				dao = new SmbDAO();

				StartGame game = new StartGame(); // ���ӽ���

				while (true) {
					System.out.print("[1]� [2]�Ա� [3]�Ʒ� [4]���ڱ� >> ");
					int select = sc.nextInt();

					switch (select) {
					case 1:
						game.study();
						break;
					case 2:
						game.eat();
						break;
					case 3:
						game.play();
						break;
					case 4:
						game.sleep();
						break;
					}
					game.quiz();
				}
			}

			else if (munu == 3) {
				
				// 3. Ranking
			
				dto = new SmbDTO();
				dao = new SmbDAO();
				dao.Ranking(dto);
				
				
							}

			else if (munu == 4) {

				System.out.println("���� �Ǿ����ϴ�.");
				break;

			}

		}
	}
}