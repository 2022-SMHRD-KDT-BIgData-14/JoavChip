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
		dao = new SmbDAO();
//		mp3.play(".\\music\\����-����-�ڸ޵�-����-B005.mp3");

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
				String pw = sc.next();
				System.out.print("NICK_NAME�� �Է��ϼ��� >> ");
				String n_name = sc.next();
				System.out.println("[1] �䳢 [2] ������ [3] ��");
				System.out.print("ĳ���� ��ȣ�� �����ϼ��� >> ");
				int c_no = sc.nextInt();
				dto = new SmbDTO(id, pw, n_name,c_no);

				cnt = dao.join(dto);

				if (cnt > 0) {
					System.out.println("ȸ������ ����");
				} else {
					System.out.println("ID�� �ߺ��Ǿ����ϴ�.");
				}

			} else if (munu == 2) {
				System.out.println("====Login====");
				System.out.print("ID�� �Է��ϼ��� >> ");
				String id = sc.next();
				System.out.print("PW�� �Է��ϼ��� >> ");
				String pw = sc.next();

				dto = new SmbDTO(id, pw);
				StartGame game = new StartGame(); // ���ӽ���
				int num=0;

				int n = dao.login(dto);				
				if (n == 1) {
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
						}game.quiz(id);
						
						if(game.quiz(id))
						break;
						
					}

				} else if (n == 2) {
					System.out.println("�޴��� �����ϼ���");
					System.out.print("[1] Join [2] Login [3] Ranking [4] Exit >> ");
					munu = sc.nextInt();

					System.out.println("====Login====");
					System.out.print("ID�� �Է��ϼ��� >> ");
					id = sc.next();
					System.out.print("PW�� �Է��ϼ��� >> ");
					pw = sc.next();
					dto = new SmbDTO(id, pw);
				


					n = dao.login(dto);
					if(n==1) {
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
							game.quiz(id);
							
							
					
						}
						
					}
				
				}

			}

			else if (munu == 3) {

				// 3. Ranking

				dao = new SmbDAO();
				dao.Ranking();

			}

			else if (munu == 4) {

				System.out.println("���� �Ǿ����ϴ�.");
				break;

			}

		}
	}
}