package model;

import java.util.Random;
import java.util.Scanner;

public class StartGame {

	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	int point = 0;
	int lv = 0;

	public void study() { // 등교 선택

		System.out.println("등교완료");

		System.out.println("[1] 수업 [2] 프로젝트");
		int study = sc.nextInt();

		// 포인트 누적

		if (study == 1) {
			System.out.print("공부하고 싶은 과목을 선택하세요: [1]JAVA [2]DB >> ");
			int s = sc.nextInt();
			if (s == 1) {
				System.out.println("자바수업내용");
			} else {
				System.out.println("DB수업내용");
			}

			System.out.println("수업 포인트를 획득하셨습니다.");
			point += 10;

		} else if (study == 2) {
			System.out.println("프로젝트 포인트를 획득하셨습니다.");
			point += 15;
		} else {
			System.out.println("다시 입력해주세요~^^");
		}

		System.out.println("포인트: " + point);
	}

	public void eat() { // 먹기 선택
		System.out.println("먹기 이미지 출력");
		point += r.nextInt(10);
		System.out.println("포인트:" + point);

	}

	public void play() { // 훈련 선택
		System.out.print("[1]복습 [2] 운동하기 >> ");
		int play = sc.nextInt();
		if (play == 1) {
			System.out.println("복습 포인트를 획득하셨습니다.");
			point += 5;
		} else {
			System.out.println("운동하기 이미지 출력");
			point -= r.nextInt(10); // 포인트 랜덤으로 +,-

		}
		System.out.println("포인트: " + point);
	}

	public void sleep() { // 잠자기 선택
		System.out.println("잠자기 이미지 출력");
		point += r.nextInt(10); // 포인트 랜덤으로 +
		System.out.println("포인트: " + point);
	}

	public void exit() {

	}

	public void quiz() {

		if (point >= 25 && point < 35) { // 포인트가 50점 이상일 시 퀴즈 이벤트
			System.out.println("========= EVENT Quiz ===========");
			System.out.println("Q. 자바의 아버지는 ? ");
			System.out.print("①라이언고슬링 ②라이언긱스 ③라이언킹 ④라이언레이놀드 >> ");
			int a = sc.nextInt();
			if (a == 1) {
				System.out.println("포인트: " + (point += 25));
				System.out.println("정답입니다. Level up !!");
				System.out.println("level: " + ++lv);

			} else {
				System.out.println("틀렸습니다.");
				System.out.println("포인트: " + (point -= 20));
			}

		}if (point >= 75 && point < 90) {

			System.out.println("Q.SQL의 데이터 정의문(DML)에 속하지 않는 것은?");
			System.out.print("①CREATE ②DROP ③ALTER ④INSERT >> ");
			int a = sc.nextInt();

			if (a == 4) {
				System.out.println("Q. Commit 이전 상태로 되돌리는 명령어는?");
				System.out.print("①ROLLBACK ②FROM ③SELECT ④DELETE >> ");
				int b = sc.nextInt();

				if (b == 1) {
					System.out.println("정답입니다. Level up !!");
					System.out.println("level: " + ++lv);

				}

			} else {
				System.out.println("틀렸습니다.");
				System.out.println("포인트: " + (point -= 25));
			}


		}
		if (point >= 150 && point < 165) {
			
			System.out.println("Q. 인터페이스를 사용하는 이유로 적절한 것은? ");
			System.out.print("①유지보수 ②다형성 극소화 ③코드수정증가 ④모두정답 >> ");
			int c = sc.nextInt();
			
			if (c == 4) {
				System.out.println("Q. 정보은닉에 해당하는 객체의 4대 특성 중 하나는?");
				System.out.print("①상속 ②추상화 ③캡슐화 ④다형성 >> ");
				int b = sc.nextInt();
				
				if (b == 3) {
					System.out.println("level: " + ++lv);
				} else {
					System.out.println("틀렸습니다.");
					System.out.println("포인트: " + (point -= 50));
				}
				
			}
			
		}
		if (point >= 300) {
			System.out.println("여기까지 왔군.. 이제 진짜 게임을 시작하지 집가고 싶나?? 그럼 문제를 맞춰!");
			System.out.println("Q. 인터페이스 구현 키워드는(소문자로입력)? ");
			String d = sc.next();
			if (d.equals("implements")) {
				System.out.println("안녕히계세요 여러분~~~");
			}
			System.out.println("게임이 종료되었습니다. 랭킹에 등록하시겠습니까 ? ");
			System.out.println("[1] 등록\t [2] 종료\t");
			int commit = sc.nextInt();
			
			if (commit == 1) {
				
			} else {
				
			}
			
			
			
			
		}
	}
}