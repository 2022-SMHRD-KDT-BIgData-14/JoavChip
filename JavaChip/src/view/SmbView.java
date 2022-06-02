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

		// join() 메소드 호출!!

		Scanner sc = new Scanner(System.in);

		SmbDTO dto;
		SmbDAO dao;
		// 메뉴를 선택하세요
		// int menu = 스캐너를 통해서 정수 입력
		// menu가 1이면

		// ====회원가입====
		// ID를 입력하세요 >>
		// PW를 입력하세요 >>
		// n_name을 입력하세여 >>

		// 회원가입 성공 >> "회원가입 완료"
		// 회원가입 실패 >> "중복된 ID입니다"

		int cnt = 0;
		mp3.play(".\\music\\경쾌-빠른-코메디-오락-B005.mp3");
		
		while (true) {
			
			System.out.println("메뉴를 선택하세요");
			System.out.print("[1] Join [2] Login [3] Ranking [4] Exit >>");
			int munu = sc.nextInt();

			if (munu == 1) {
				// 회원가입 기능
				System.out.println("====JOIN====");
				System.out.print("ID를 입력하세요 >> ");
				String id = sc.next();
				System.out.print("PW를 입력하세요 >> ");
				int pw = sc.nextInt();
				System.out.print("NICK_NAME를 입력하세요 >> ");
				String n_name = sc.next();

				dto = new SmbDTO(id, pw, n_name);
				dao = new SmbDAO();

				cnt = dao.join(dto);

				if (cnt > 0) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("ID가 중복되었습니다.");
				}

			} else if (munu == 2) {
				// 2 Login 기능
				System.out.println("====Login====");
				System.out.print("ID를 입력하세요 >> ");
				String id = sc.next();
				System.out.print("PW를 입력하세요 >> ");
				int pw = sc.nextInt();

				dto = new SmbDTO(id, pw);
				dao = new SmbDAO();

				StartGame game = new StartGame(); // 게임시작

				while (true) {
					System.out.print("[1]등교 [2]먹기 [3]훈련 [4]잠자기 >> ");
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

				System.out.println("종료 되었습니다.");
				break;

			}

		}
	}
}