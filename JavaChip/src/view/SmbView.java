package view;

import java.util.Scanner;
import model.SmbDAO;
import model.SmbDTO;

public class SmbView {

	public static void main(String[] args) {
		
	
		// join() �޼ҵ� ȣ��!!
		
		Scanner sc = new Scanner(System.in);
			
		// �޴��� �����ϼ���
		// int menu = ��ĳ�ʸ� ���ؼ� ���� �Է�
		// menu�� 1�̸�
		
		// ====ȸ������====
		// ID�� �Է��ϼ��� >>
		// PW�� �Է��ϼ��� >>
		// n_name�� �Է��ϼ��� >>
		
		// ȸ������ ���� >> "ȸ������ �Ϸ�"
		// ȸ������ ���� >> "�ߺ��� ID�Դϴ�"
		
		
		
		while(true) {
			System.out.println("�޴��� �����ϼ���");
			System.out.print("[1] Join [2] Login [3] Ranking [4] Exit >>");
			int munu = sc.nextInt();
			
			if(munu==1) {
				//ȸ������ ���
				System.out.println("====JOIN====");
				System.out.print("ID�� �Է��ϼ��� >> ");
				String id = sc.next();
				System.out.print("PW�� �Է��ϼ��� >> ");
				String pw = sc.next();
				System.out.print("NICK_NAME�� �Է��ϼ��� >> ");
				String n_name = sc.next();
				
				
				SmbDTO dto = new SmbDTO(id, pw, n_name);
				SmbDAO dao = new SmbDAO();
				
				
				int cnt = dao.join(dto);
				if(cnt>0) {
					System.out.println("ȸ������ ����");
				}else {
					System.out.println("ID�� �ߺ��Ǿ����ϴ�.");
				}
								
				
				
				
//			}else if(munu==2){
				//2 Login ���
//				System.out.println("====Login====");
//				System.out.print("ID�� �Է��ϼ��� >> ");
//				String id = sc.next();
//				System.out.print("PW�� �Է��ϼ��� >> ");
//				String pw = sc.next();
//				
//				
//				smbDTO dto = new smbDTO(id, pw);
//				smbDAO dao = new smbDAO();
//				int cnt = dao.login(dto);
//				if(cnt>0) {
//					System.out.println("Login ����");
//				}else {
//					System.out.println("ID �� PW�� Ȯ���ϼ���");
//					
//			}
								
				
				
			}else if(munu==3){
				//3. Ranking
//				System.out.println("====Login====");
//				System.out.print("ID�� �Է��ϼ��� >> ");
//				String id = sc.next();
				
				
	
				
				
				
			}else if(munu==4){
				
				System.out.println("���� �Ǿ����ϴ�.");
				break;
				
				
			}		
	
		}
				
	}

}
