package model;

import java.util.Random;
import java.util.Scanner;
import ascii.cat;
import ascii.dog;
import ascii.rabbit;
import javazoom.jl.player.MP3Player;

public class StartGame {
	public StartGame(MP3Player mp2) {
		this.mp2 = mp2;
		// TODO Auto-generated constructor stub
	}

	MP3Player mp3 = new MP3Player();
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	int point = 0;
	int lv = 0;
	int num;
	SmbDTO dto;
	cat bird = new cat();
	dog dog = new dog();
	rabbit rabbit = new rabbit();
	MP3Player mp2;

	public void study(int c_no) { // 등교 선택

		System.out.println("★★★★ 등교 완료 ★★★★");

		System.out.print("[1] 수업 [2] 프로젝트 >> ");
		int study = sc.nextInt();

		// 포인트 누적

		if (study == 1) {
			System.out.print("공부하고 싶은 과목을 선택하세요 [1]JAVA [2]DB >> ");
			int s = sc.nextInt();
			if (s == 1) {
				System.out.println("------------------------------------------");
				System.out.println("1. OOP는 캡슐화, 상속, 추상화, 다형성 특징이 있다.");
				System.out.println("2. new 연산자를 사용하여 객체를 생성한다.");
				System.out.println("3. 자바의 아버지는 라이언고슬링이다.");
				System.out.println("4. 인터페이스 구현 키워드는 implements이다.");
				System.out.println("------------------------------------------");

			} else {
				System.out.println("------------------------------------------");
				System.out.println("1. 테이블은 기본 저장단위로 행과 열로 구성되어있다.");
				System.out.println("2. Commit 이전으로 되돌리는 것은 Rollback이다. ");
				System.out.println("3. 트랜젝션은 DB에서 발생하는 작업의 단위이다.");
				System.out.println("4. Distinct는 select로 출력된 테이블에서 중복을 제거한다.");
				System.out.println("------------------------------------------");

			}

			System.out.println("수업 포인트를 획득하셨습니다.");
			point += 5;

		} else if (study == 2) {
			System.out.println("프로젝트 포인트를 획득하셨습니다.");
			point += 10;
		} else {
			System.out.println("다시 입력해주세요~^^");
		}
		System.out.println();
		System.out.println("포인트: " + point);
	}

	public void eat(int c_no) { // 먹기 선택
		switch (c_no) {
		case 1:
			rabbit.rabbitEat();
			break;
		case 2:
			dog.dogEat();
			break;
		case 3:
			bird.catEat();
			break;
		}
		point += r.nextInt(20);
		System.out.println();
		System.out.println("포인트:" + point);

	}

	public void play(int c_no) { // 훈련 선택
		System.out.print("[1]복습 [2] 운동하기 >> ");
		int play = sc.nextInt();
		if (play == 1) {

			System.out.println("복습 포인트를 획득하셨습니다.");
			point += 5;
		} else {
			switch (c_no) {
			case 1:
				rabbit.rabbitPlay();
				
				break;

			case 2:
				dog.dogPlay();
				break;
			case 3:
				bird.catPlay();
				break;
			}
			point -= r.nextInt(10); // 포인트 랜덤으로 +,-

		}
		System.out.println();
		System.out.println("포인트: " + point);
	}

	public void sleep(int c_no) { // 잠자기 선택
		switch (c_no) {
		case 1:
			rabbit.rabbitSleep();
			
			break;

		case 2:
			dog.dogSleep();
			break;
		case 3:
			bird.catSleep();
			break;
		}
		point += r.nextInt(15);
		System.out.println();// 포인트 랜덤으로 +
		System.out.println("포인트: " + point);
	}

	public void exit() {

	}

	public boolean quiz(String id, int c_no) {

		if (point >= 25 && point < 40) { // 포인트가 50점 이상일 시 퀴즈 이벤트
			System.out.println("========= EVENT Quiz ===========");
			System.out.println("Q. 자바의 아버지는 ? ");
			System.out.print("①라이언고슬링 ②라이언긱스 ③라이언킹 ④라이언레이놀드 >> ");
			int a = sc.nextInt();
			if (a == 1) {
				if (mp2.isPlaying()) {
					mp2.stop();
					mp3.play(".\\music\\예에에.mp3");
					mp3.play(".\\music\\경쾌-빠른-코메디-오락-B005.mp3");
				}

				System.out.println("포인트: " + (point += 30));
				System.out.println("★★★★ 정답입니다. Level up !! ★★★★");
				System.out.println("\t  level: " + ++lv);

			} else {
				System.out.println("틀렸습니다.");
				System.out.println("포인트: " + (point -= 20));
			}

		}
		if (point >= 75 && point <=85) {
			System.out.println("========= EVENT Quiz ===========");
			System.out.println("Q.SQL의 데이터 정의문(DML)에 속하지 않는 것은?");
			System.out.print("①CREATE ②DROP ③ALTER ④INSERT >> ");
			int a = sc.nextInt();

			if (a == 4) {
				if (mp2.isPlaying()) {
					mp2.stop();
				}
				mp3.play(".\\music\\빠--빠-.mp3");
				System.out.println("========= EVENT Quiz ===========");
				System.out.println("Q. Commit 이전 상태로 되돌리는 명령어는?");
				System.out.print("①ROLLBACK ②FROM ③SELECT ④DELETE >> ");
				int b = sc.nextInt();

				if (b == 1) {
					if (mp2.isPlaying()) {
						mp2.stop();
					}
					mp3.play(".\\music\\예에에.mp3");
					System.out.println();
					System.out.println("포인트: " + (point += 40));
					System.out.println("★★★★ 정답입니다. Level up !! ★★★★");
					System.out.println("\t  level: " + ++lv);

				}

			} else {
				System.out.println();
				System.out.println("틀렸습니다.");
				System.out.println("포인트: " + (point -= 25));
			}

		}
		if (point >= 150 && point < 171) {
			System.out.println("========= EVENT Quiz ===========");
			System.out.println("Q. 인터페이스를 사용하는 이유로 적절한 것은? ");
			System.out.println("①유지보수 ②다형성 극소화 ③코드수정증가 ④모두정답 >> ");
			int c = sc.nextInt();

			if (c == 1) {
				if (mp2.isPlaying()) {
					mp2.stop();
				}
				mp3.play(".\\music\\빠--빠-.mp3");
				mp3.play(".\\music\\경쾌-빠른-코메디-오락-B005.mp3");
				
				System.out.println();
				System.out.println("포인트: " + (point += 40));
				System.out.println("========= EVENT Quiz ===========");
				System.out.println("Q. 정보은닉에 해당하는 객체의 4대 특성 중 하나는?");
				System.out.print("①상속 ②추상화 ③캡슐화 ④다형성 >> ");
				int b = sc.nextInt();
				System.out.println("포인트: " + (point += 20));
				if (b == 3) {
					mp3.play(".\\music\\빠--빠-.mp3");
					System.out.println("★★★★\t  level: " + (++lv) +"\t ★★★★");
				} else {
					System.out.println();
					System.out.println("틀렸습니다.");
					System.out.println("포인트: " + (point -= 50));
				}

			}

		}
		if (point >= 290 && point < 320) {
			if (mp2.isPlaying()) {
				mp2.stop();
			}
			mp3.play(".\\music\\런닝맨+효과음+뜨헉!.mp3");

			System.out.println("여기까지 왔군.. 이제 진짜 게임을 시작하지 취업하고 싶나?? 그럼 문제를 맞춰!");
			System.out.print("Q. 인터페이스 구현 키워드는(소문자로입력)? ");
			String d = sc.next();
			if (d.equals("implements")) {
					point+=50;
				if (mp2.isPlaying()) {
					mp2.stop();
				}
				mp3.play(".\\music\\y2mate.com - 안녕히 계세요 여러분 퇴사용.mp3");

			}
			System.out.println("게임이 종료되었습니다. 랭킹에 등록하시겠습니까 ? ");
			System.out.print("[1] 등록\t [2] 종료\t ");
			int commit = sc.nextInt();
			if (commit == 1) {
				SmbDAO dao = new SmbDAO();
				dto = new SmbDTO(id, point, lv);
				dao.RankingUpdate(dto);
				System.out.println("랭킹등록을 완료했습니다.");
				return false;
			} else {
				System.out.println("랭킹등록을 하지 않았습니다.");
				return false;
			}

		}
		return true;
	}

}

