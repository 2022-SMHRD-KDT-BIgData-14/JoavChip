package model;

import java.util.Random;
import java.util.Scanner;

public class StartGame {

	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	int point = 0;
	int lv = 0;

	public void study() { // � ����

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

	public void eat() { // �Ա� ����
		System.out.println("�Ա� �̹��� ���");
		point += r.nextInt(10);
		System.out.println("����Ʈ:" + point);

	}

	public void play() { // �Ʒ� ����
		System.out.print("[1]���� [2] ��ϱ� >> ");
		int play = sc.nextInt();
		if (play == 1) {
			System.out.println("���� ����Ʈ�� ȹ���ϼ̽��ϴ�.");
			point += 5;
		} else {
			System.out.println("��ϱ� �̹��� ���");
			point -= r.nextInt(10); // ����Ʈ �������� +,-

		}
		System.out.println("����Ʈ: " + point);
	}

	public void sleep() { // ���ڱ� ����
		System.out.println("���ڱ� �̹��� ���");
		point += r.nextInt(10); // ����Ʈ �������� +
		System.out.println("����Ʈ: " + point);
	}

	public void exit() {

	}

	public void quiz() {

		if (point >= 25 && point < 35) { // ����Ʈ�� 50�� �̻��� �� ���� �̺�Ʈ
			System.out.println("========= EVENT Quiz ===========");
			System.out.println("Q. �ڹ��� �ƹ����� ? ");
			System.out.print("����̾���� ����̾�㽺 ����̾�ŷ ����̾��̳�� >> ");
			int a = sc.nextInt();
			if (a == 1) {
				System.out.println("����Ʈ: " + (point += 25));
				System.out.println("�����Դϴ�. Level up !!");
				System.out.println("level: " + ++lv);

			} else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
				System.out.println("����Ʈ: " + (point -= 20));
			}

		}if (point >= 75 && point < 90) {

			System.out.println("Q.SQL�� ������ ���ǹ�(DML)�� ������ �ʴ� ����?");
			System.out.print("��CREATE ��DROP ��ALTER ��INSERT >> ");
			int a = sc.nextInt();

			if (a == 4) {
				System.out.println("Q. Commit ���� ���·� �ǵ����� ��ɾ��?");
				System.out.print("��ROLLBACK ��FROM ��SELECT ��DELETE >> ");
				int b = sc.nextInt();

				if (b == 1) {
					System.out.println("�����Դϴ�. Level up !!");
					System.out.println("level: " + ++lv);

				}

			} else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
				System.out.println("����Ʈ: " + (point -= 25));
			}


		}
		if (point >= 150 && point < 165) {
			
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
				
			} else {
				
			}
			
			
			
			
		}
	}
}