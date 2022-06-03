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

	public void study(int c_no) { // � ����

		System.out.println("�ڡڡڡ� � �Ϸ� �ڡڡڡ�");

		System.out.print("[1] ���� [2] ������Ʈ >> ");
		int study = sc.nextInt();

		// ����Ʈ ����

		if (study == 1) {
			System.out.print("�����ϰ� ���� ������ �����ϼ��� [1]JAVA [2]DB >> ");
			int s = sc.nextInt();
			if (s == 1) {
				System.out.println("------------------------------------------");
				System.out.println("1. OOP�� ĸ��ȭ, ���, �߻�ȭ, ������ Ư¡�� �ִ�.");
				System.out.println("2. new �����ڸ� ����Ͽ� ��ü�� �����Ѵ�.");
				System.out.println("3. �ڹ��� �ƹ����� ���̾�����̴�.");
				System.out.println("4. �������̽� ���� Ű����� implements�̴�.");
				System.out.println("------------------------------------------");

			} else {
				System.out.println("------------------------------------------");
				System.out.println("1. ���̺��� �⺻ ��������� ��� ���� �����Ǿ��ִ�.");
				System.out.println("2. Commit �������� �ǵ����� ���� Rollback�̴�. ");
				System.out.println("3. Ʈ�������� DB���� �߻��ϴ� �۾��� �����̴�.");
				System.out.println("4. Distinct�� select�� ��µ� ���̺��� �ߺ��� �����Ѵ�.");
				System.out.println("------------------------------------------");

			}

			System.out.println("���� ����Ʈ�� ȹ���ϼ̽��ϴ�.");
			point += 5;

		} else if (study == 2) {
			System.out.println("������Ʈ ����Ʈ�� ȹ���ϼ̽��ϴ�.");
			point += 10;
		} else {
			System.out.println("�ٽ� �Է����ּ���~^^");
		}
		System.out.println();
		System.out.println("����Ʈ: " + point);
	}

	public void eat(int c_no) { // �Ա� ����
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
			point -= r.nextInt(10); // ����Ʈ �������� +,-

		}
		System.out.println();
		System.out.println("����Ʈ: " + point);
	}

	public void sleep(int c_no) { // ���ڱ� ����
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
		System.out.println();// ����Ʈ �������� +
		System.out.println("����Ʈ: " + point);
	}

	public void exit() {

	}

	public boolean quiz(String id, int c_no) {

		if (point >= 25 && point < 40) { // ����Ʈ�� 50�� �̻��� �� ���� �̺�Ʈ
			System.out.println("========= EVENT Quiz ===========");
			System.out.println("Q. �ڹ��� �ƹ����� ? ");
			System.out.print("����̾���� ����̾�㽺 ����̾�ŷ ����̾��̳�� >> ");
			int a = sc.nextInt();
			if (a == 1) {
				if (mp2.isPlaying()) {
					mp2.stop();
					mp3.play(".\\music\\������.mp3");
					mp3.play(".\\music\\����-����-�ڸ޵�-����-B005.mp3");
				}

				System.out.println("����Ʈ: " + (point += 30));
				System.out.println("�ڡڡڡ� �����Դϴ�. Level up !! �ڡڡڡ�");
				System.out.println("\t  level: " + ++lv);

			} else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
				System.out.println("����Ʈ: " + (point -= 20));
			}

		}
		if (point >= 75 && point <=85) {
			System.out.println("========= EVENT Quiz ===========");
			System.out.println("Q.SQL�� ������ ���ǹ�(DML)�� ������ �ʴ� ����?");
			System.out.print("��CREATE ��DROP ��ALTER ��INSERT >> ");
			int a = sc.nextInt();

			if (a == 4) {
				if (mp2.isPlaying()) {
					mp2.stop();
				}
				mp3.play(".\\music\\��--��-.mp3");
				System.out.println("========= EVENT Quiz ===========");
				System.out.println("Q. Commit ���� ���·� �ǵ����� ��ɾ��?");
				System.out.print("��ROLLBACK ��FROM ��SELECT ��DELETE >> ");
				int b = sc.nextInt();

				if (b == 1) {
					if (mp2.isPlaying()) {
						mp2.stop();
					}
					mp3.play(".\\music\\������.mp3");
					System.out.println();
					System.out.println("����Ʈ: " + (point += 40));
					System.out.println("�ڡڡڡ� �����Դϴ�. Level up !! �ڡڡڡ�");
					System.out.println("\t  level: " + ++lv);

				}

			} else {
				System.out.println();
				System.out.println("Ʋ�Ƚ��ϴ�.");
				System.out.println("����Ʈ: " + (point -= 25));
			}

		}
		if (point >= 150 && point < 171) {
			System.out.println("========= EVENT Quiz ===========");
			System.out.println("Q. �������̽��� ����ϴ� ������ ������ ����? ");
			System.out.println("���������� ������� �ؼ�ȭ ���ڵ�������� �������� >> ");
			int c = sc.nextInt();

			if (c == 1) {
				if (mp2.isPlaying()) {
					mp2.stop();
				}
				mp3.play(".\\music\\��--��-.mp3");
				mp3.play(".\\music\\����-����-�ڸ޵�-����-B005.mp3");
				
				System.out.println();
				System.out.println("����Ʈ: " + (point += 40));
				System.out.println("========= EVENT Quiz ===========");
				System.out.println("Q. �������п� �ش��ϴ� ��ü�� 4�� Ư�� �� �ϳ���?");
				System.out.print("���� ���߻�ȭ ��ĸ��ȭ ������� >> ");
				int b = sc.nextInt();
				System.out.println("����Ʈ: " + (point += 20));
				if (b == 3) {
					mp3.play(".\\music\\��--��-.mp3");
					System.out.println("�ڡڡڡ�\t  level: " + (++lv) +"\t �ڡڡڡ�");
				} else {
					System.out.println();
					System.out.println("Ʋ�Ƚ��ϴ�.");
					System.out.println("����Ʈ: " + (point -= 50));
				}

			}

		}
		if (point >= 290 && point < 320) {
			if (mp2.isPlaying()) {
				mp2.stop();
			}
			mp3.play(".\\music\\���׸�+ȿ����+����!.mp3");

			System.out.println("������� �Ա�.. ���� ��¥ ������ �������� ����ϰ� �ͳ�?? �׷� ������ ����!");
			System.out.print("Q. �������̽� ���� Ű�����(�ҹ��ڷ��Է�)? ");
			String d = sc.next();
			if (d.equals("implements")) {
					point+=50;
				if (mp2.isPlaying()) {
					mp2.stop();
				}
				mp3.play(".\\music\\y2mate.com - �ȳ��� �輼�� ������ ����.mp3");

			}
			System.out.println("������ ����Ǿ����ϴ�. ��ŷ�� ����Ͻðڽ��ϱ� ? ");
			System.out.print("[1] ���\t [2] ����\t ");
			int commit = sc.nextInt();
			if (commit == 1) {
				SmbDAO dao = new SmbDAO();
				dto = new SmbDTO(id, point, lv);
				dao.RankingUpdate(dto);
				System.out.println("��ŷ����� �Ϸ��߽��ϴ�.");
				return false;
			} else {
				System.out.println("��ŷ����� ���� �ʾҽ��ϴ�.");
				return false;
			}

		}
		return true;
	}

}

