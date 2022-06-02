package view;


import java.util.Scanner;
import ascii.bird;
import ascii.dog;
import ascii.rabbit;
import javazoom.jl.player.MP3Player;
import model.SmbDAO;
import model.SmbDTO;
import model.StartGame;

public class SmbView {
	public static void main(String[] args) {
		
		MP3Player mp3 = new MP3Player();
		
		

		// join() 메소드 호출!!

		Scanner sc = new Scanner(System.in);

		SmbDTO dto;
		SmbDAO dao;
		bird bird = new bird();
		dog dog = new dog();
		rabbit rabbit = new rabbit();
		
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
		dao = new SmbDAO();
		int c_no = 0;
		mp3.play(".\\music\\경쾌-빠른-코메디-오락-B005.mp3");
		bird.start();			

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
				String pw = sc.next();
				System.out.print("NICK_NAME를 입력하세요 >> ");
				String n_name = sc.next();
				System.out.println("[1] 토끼 [2] 강아지 [3] 새");
				System.out.print("캐릭터 번호를 선택하세요 >> ");
				c_no = sc.nextInt();
				dto = new SmbDTO(id, pw, n_name,c_no);
				

				cnt = dao.join(dto);

				
				
				if (cnt > 0) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("ID가 중복되었습니다.");
				}

			} else if (munu == 2) {
				System.out.println("====Login====");
				System.out.print("ID를 입력하세요 >> ");
				String id = sc.next();
				System.out.print("PW를 입력하세요 >> ");
				String pw = sc.next();
				c_no=dao.c_nopint(id);
				

				dto = new SmbDTO(id, pw);
				StartGame game = new StartGame(mp3); // 게임시작
				int num=0;

				int n = dao.login(dto);				
				if (n == 1) {
					while (true) {
						System.out.print("[1]등교 [2]먹기 [3]훈련 [4]잠자기 >> ");
						int select = sc.nextInt();

						switch (select) {
						case 1:
							game.study(c_no);
							break;
						case 2:
							game.eat(c_no);
							break;
						case 3:
							game.play(c_no);
							break;
						case 4:
							game.sleep(c_no);
							break;
						}game.quiz(id, c_no);
						
						if(game.quiz(id,c_no))
						break;
						
					}

				} else if (n == 2) {
					System.out.println("메뉴를 선택하세요");
					System.out.print("[1] Join [2] Login [3] Ranking [4] Exit >> ");
					munu = sc.nextInt();

					System.out.println("====Login====");
					System.out.print("ID를 입력하세요 >> ");
					id = sc.next();
					System.out.print("PW를 입력하세요 >> ");
					pw = sc.next();
					dto = new SmbDTO(id, pw);
				


					n = dao.login(dto);
					if(n==1) {
						while (true) {
							System.out.print("[1]등교 [2]먹기 [3]훈련 [4]잠자기 >> ");
							int select = sc.nextInt();

							switch (select) {
							case 1:
								game.study(c_no);
								break;
							case 2:
								game.eat(c_no);
								break;
							case 3:
								game.play(c_no);
								break;
							case 4:
								game.sleep(c_no);
								break;
							}
							game.quiz(id,c_no);
							
					
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

				System.out.println("종료 되었습니다.");
				break;

			}

		}
	}
}