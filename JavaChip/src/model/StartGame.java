package model;

import java.util.Random;
import java.util.Scanner;
import ascii.bird;
import ascii.dog;
import ascii.rabbit;

public class StartGame {

	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	int point = 0;
	int lv = 0;
	int num;
	SmbDTO dto;
	bird bird = new bird();
	dog dog = new dog();
	rabbit rabbit = new rabbit();

	public void study(int c_no) { // � ����

		System.out.println("��Ϸ�");

		System.out.println("[1] ���� [2] ������Ʈ");
		int study = sc.nextInt();

		// ����Ʈ ����

		if (study == 1) {
			System.out.print("�����ϰ� ���� ������ �����ϼ���: [1]JAVA [2]DB >> ");
			int s = sc.nextInt();
			if (s == 1) {
				System.out.println("�ڹټ�������");
			} else {
				System.out.println("DB��������");
			}

			System.out.println("���� ����Ʈ�� ȹ���ϼ̽��ϴ�.");
			point += 10;

		} else if (study == 2) {
			System.out.println("������Ʈ ����Ʈ�� ȹ���ϼ̽��ϴ�.");
			point += 15;
		} else {
			System.out.println("�ٽ� �Է����ּ���~^^");
		}

		System.out.println("����Ʈ: " + point);
	}

	public void eat(int c_no) { // �Ա� ����
		switch (c_no) {
		case 1 :
			bird.birdEat();
			break;

		case 2 :
			dog.dogEat();
			break;
		case 3 :
			rabbit.rabbitEat();
			break;
		}
		point += r.nextInt(10);
		System.out.println("����Ʈ:" + point);

	}

	public void play(int c_no) { // �Ʒ� ����
		System.out.print("[1]���� [2] ��ϱ� >> ");
		int play = sc.nextInt();
		if (play == 1) {
			
			
			System.out.println("���� ����Ʈ�� ȹ���ϼ̽��ϴ�.");
			point += 5;
		} else {
			switch (c_no) {
			case 1 :
				bird.birdPlay();
				break;

			case 2 :
				dog.dogPlay();
				break;
			case 3 :
				rabbit.rabbitPlay();
				break;
			}
			point -= r.nextInt(10); // ����Ʈ �������� +,-

		}
		System.out.println("����Ʈ: " + point);
	}

	public void sleep(int c_no) { // ���ڱ� ����
		switch (c_no) {
		case 1 :
			bird.birdSleep();
			break;

		case 2 :
			dog.dogSleep();
			break;
		case 3 :
			rabbit.rabbitSleep();
			break;
		}
		point += r.nextInt(10); // ����Ʈ �������� +
		System.out.println("����Ʈ: " + point);
	}

	public void exit() {

	}

	public boolean quiz(String id, int c_no) {

		
		if (point >= 25 && point < 35) { // ����Ʈ�� 50�� �̻��� �� ���� �̺�Ʈ
			System.out.println("========= EVENT Quiz ===========");
			System.out.println("Q. �ڹ��� �ƹ����� ? ");
			System.out.print("����̾���� ����̾�㽺 ����̾�ŷ ����̾��̳�� >> ");
			int a = sc.nextInt();
			if (a == 1) {
				System.out.println("����Ʈ: " + (point += 30));
				System.out.println("�����Դϴ�. Level up !!");
				System.out.println("level: " + ++lv);

			} else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
				System.out.println("����Ʈ: " + (point -= 20));
			}

		}
		if (point >= 75 && point < 80) {

			System.out.println("Q.SQL�� ������ ���ǹ�(DML)�� ������ �ʴ� ����?");
			System.out.print("��CREATE ��DROP ��ALTER ��INSERT >> ");
			int a = sc.nextInt();

			if (a == 4) {
				System.out.println("Q. Commit ���� ���·� �ǵ����� ��ɾ��?");
				System.out.print("��ROLLBACK ��FROM ��SELECT ��DELETE >> ");
				int b = sc.nextInt();

				if (b == 1) {
					System.out.println("����Ʈ: " + (point += 40));
					System.out.println("�����Դϴ�. Level up !!");
					System.out.println("level: " + ++lv);

				}

			} else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
				System.out.println("����Ʈ: " + (point -= 25));
			}

		}
		if (point >= 150 && point < 180) {

			System.out.println("Q. �������̽��� ����ϴ� ������ ������ ����? ");
			System.out.print("���������� ������� �ؼ�ȭ ���ڵ�������� �������� >> ");
			int c = sc.nextInt();

			if (c == 4) {
				System.out.println("Q. �������п� �ش��ϴ� ��ü�� 4�� Ư�� �� �ϳ���?");
				System.out.print("���� ���߻�ȭ ��ĸ��ȭ ������� >> ");
				int b = sc.nextInt();

				if (b == 3) {
					System.out.println("level: " + ++lv);
				} else {
					System.out.println("Ʋ�Ƚ��ϴ�.");
					System.out.println("����Ʈ: " + (point -= 50));
				}

			}

		}
		if (point >= 300) {
			System.out.println("������� �Ա�.. ���� ��¥ ������ �������� ������ �ͳ�?? �׷� ������ ����!");
			System.out.println("Q. �������̽� ���� Ű�����(�ҹ��ڷ��Է�)? ");
			String d = sc.next();
			if (d.equals("implements")) {
				System.out.println("�ȳ����輼�� ������~~~");
			}
			System.out.println("������ ����Ǿ����ϴ�. ��ŷ�� ����Ͻðڽ��ϱ� ? ");
			System.out.println("[1] ���\t [2] ����\t");
			int commit = sc.nextInt();
			if (commit == 1) {
				SmbDAO dao = new SmbDAO();
				dto = new SmbDTO(id, point, lv);
				dao.RankingUpdate(dto);
				System.out.println("��ŷ����� �Ϸ��߽��ϴ�.");
				return true;
			} else {
				System.out.println("��ŷ����� ���� �ʾҽ��ϴ�.");
				return true;
			}	
			
			
			
		}
	return false;
	}

}
