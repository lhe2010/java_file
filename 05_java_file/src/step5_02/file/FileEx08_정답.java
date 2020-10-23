// 2020-10-23 금 자습 20:13-20:34 ( 1-2 번 )
package step5_02.file;

import java.util.Scanner;

//# 파일 컨트롤러[3단계] : 장바구니

public class FileEx08_정답 {
	
	public static void main(String[] args) {

		final int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];

		Scanner scan = new Scanner(System.in);

		String fileName = "jang.txt";

		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",   "2222", "3333"};
		String[] items = {"사과", "바나나", "딸기"};
		String usrId, usrPw;
	
		int count = 0;
		int log = -1;
		int identifier = -1; 

		while (true) {
			System.out.println("\n[MEGA SHOP] ");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[4]장바구니");
			System.out.println("[5]저장");
			System.out.println("[6]로드");
			System.out.println("[0]종료");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				System.out.println("\n[1]로그인메뉴");
				if(identifier != -1) {
					System.out.println("[ERROR] 이미 로그인하셨습니다.");
					continue;
				}
				System.out.print("ID : ");
				usrId = scan.next();
				for (int i = 0; i < ids.length; i++) {
					if(usrId.equals(ids[i])) {
						identifier = i;
					}
				}
				
				if(identifier == -1) {
					System.out.println("[ERROR] Unvalid ID");
				} else {
					// 아이디 있으면 비밀번호를 물어본다
					System.out.print("PW : ");
					usrPw = scan.next();
					if(!usrPw.equals(pws[identifier])) {
						System.out.println("[ERROR] Unvalid PW");
						identifier = -1;
						continue;
					} else {
						// 아이디와 비밀번호가 유효하므로 로그인
						System.out.println("[LOGGED IN]");
					}
				}
			}
			else if (sel == 2) {
				System.out.println("\n[2]로그아웃");
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인이후 이용가능 ");
					continue;
				}
				identifier = -1;
				System.out.println("[LOGGED OUT]");

			}
			else if (sel == 3) {
				System.out.println("[3]쇼핑");
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인이후 이용가능 ");
					continue;
				}
				
			}
			else if (sel == 4) {
				System.out.println("[4]장바구니");
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인이후 이용가능 ");
					continue;
				}
			}
			else if (sel == 5) {
				System.out.println("[5]저장");
				
			}
			else if (sel == 6) {
				System.out.println("[6]로드");
				
			}
			else if (sel == 0) {
				System.out.println("[0][프로그램 종료]");
				break;
			}
			
		}
		
	}
}
