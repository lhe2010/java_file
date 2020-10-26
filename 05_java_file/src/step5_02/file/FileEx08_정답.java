// 2020-10-23 금 자습 20:13-20:34 ( 1-2 번 )
// 2020-10-26 월 2교시 15:50-16:09 ( 3-4 번 )
// 2020-10-26 월 3교시 16:51- (  번 )

package step5_02.file;

import java.util.Scanner;

/*# 파일 컨트롤러[3단계] : 장바구니
* 1. 로그인 후 쇼핑 메뉴를 선택하면, 상품목록을 보여준다.
* 2. 번호를 선택해 상품을 장바구니에 담을 수 있다.
* 3. 로그인 회원의 인덱스 번호는 각 행의 첫번째 열에 저장한다.
* 4. 해당 회원이 구매한 상품의 인덱스 번호는 각 행의 두번째 열에 저장한다.
* 예)
* {
* 		{0, 1},				qwer회원 			> 사과구매
* 		{1, 2},				javaking회원 		> 바나나구매
* 		{2, 1},				abcd회원			> 사과구매
* 		{0, 3},				qwer회원			> 딸기구매
* 		...
* }*/

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
				System.out.println("\n...[1]로그인메뉴");
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
						System.out.println("...LOGGED IN");
					}
				}
			}
			else if (sel == 2) {
				System.out.println("\n...[2]로그아웃");
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인이후 이용가능 ");
					continue;
				}
				identifier = -1;
				System.out.println("...LOGGED OUT");

			}
			else if (sel == 3) {
				System.out.println("\n...[3]쇼핑메뉴");
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인이후 이용가능 ");
					continue;
				}
				// 로그인 후 쇼핑 메뉴를 선택하면, 상품목록을 보여준다.
				while(true) {
					System.out.println("[아이템목록]");
					for (int i = 0; i < items.length; i++) {
						System.out.println(i+1 + ") " + items[i]);
					}
					System.out.println(items.length+1 + ") 뒤로가기");
					System.out.println("상품을 선택하세요: ");
					
					int choice = scan.nextInt();
					if(choice == 4) { // 뒤로가기
						System.out.println("...메인메뉴로 이동합니다.");
						break;						
					}
					if(choice > items.length && choice != 4 ) {
						System.out.println("[ERROR] 아이템 목록에서 번호를 확인하세요!");
						continue;
					}
					// 올바른 아이템 목록 확인 
					jang[count][0] = identifier;
					jang[count][1] = choice-1;
					System.out.printf("...%s님이 %s를 장바구니에 넣었습니다. \n\n", ids[jang[count][0]], items[jang[count][1]]);
				}
			}
			else if (sel == 4) {
				System.out.println("...[4]장바구니메뉴");
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인이후 이용가능 ");
					continue;
				}
				// 장바구니 출력
				for (int i = 0; i < items.length; i++) {
					for (int j = 0; j < count; j++) {
						
					}
					System.out.printf("%d) %s : %d개\n", i+1, items[i], 1 );
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
