// 2020-10-23 금 2교시 16:33-17:09 ( 1-4 번 )
// 2020-10-23 금 3교시 17:09-17:40 ( 5-8 번 )
// 2020-10-23 금 3교시 17:40-17:45 ( 9 번 )
// 2020-10-23 금 자습 19:39-19:59 ( 10 번 ) / 20:00-20:12 (2번 보완)
package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

//# 파일 컨트롤러[2단계] : ATM

public class FileEx07_정답 {
	
	public static void main(String[] args) {
		
		final int SIZE = 5;
		String fileName = "atm.txt";

		Scanner scan = new Scanner(System.in);
		FileWriter fw = null;
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		String myId = "";
		String myPw = "";

		String[] accs = new String[SIZE];
		String[]  pws = new String[SIZE];
		int[]  moneys = new int[SIZE];
		
		int accsCnt = 0;
//		int accsCnt = 2;			// test용
		int identifier = -1;
		int money = 0;
		
//		accs[0] = "1"; pws[0] = "11"; moneys[0] = 1000;
//		accs[1] = "2"; pws[1] = "22"; moneys[1] = 1000;
		
		while(true) {
			
			System.out.println("\n[MEGA ATM]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) { 
				System.out.println("\n[회원가입 페이지]");
				if(identifier != -1) {
					System.out.println("[ERROR] 이미 로그인 상태입니다.");
					continue;
				}
				System.out.print("id : ");
				myId = scan.next();
				
				for (int i = 0; i < accsCnt; i++) {
					if(myId.equals(accs[i])) {
						myId = null;
						break;
					}
				}
				if(myId == null) {
					System.out.println("[ERROR] 중복된 아이디가 있습니다.");
					continue;
				}
				
				System.out.print("pw : ");
				myPw = scan.next();
				
				accs[accsCnt] = myId;
				pws[accsCnt] = myPw;
				accsCnt++;				
				System.out.printf("[회원가입 완료] ID : %s, PW : %s\n", myId, myPw);
			} else if (sel == 2) { 
				System.out.println("\n[회원탈퇴 페이지]");
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인 하셔야 접근 가능한 페이지입니다.");
					continue;
				}
				System.out.printf("%s님 정말로 회원탈퇴 하시겠어요? (N:0) : ", identifier);
			
				if(scan.nextInt() == 0) {
					System.out.println("[회원탈퇴 취소] 메인메뉴로 돌아갑니다.");
					continue;
				} else {
					// 회원탈퇴 진행
					System.out.print("탈퇴하기 위해서는 비밀번호를 다시 입력하셔야 합니다 : ");
					String temp = scan.next();
					if (pws[identifier].equals(temp)) {
						// 아이디 비번 날리기 
						String[] tempAccs = new String[SIZE];
						String[] tempPws = new String[SIZE];
						int[] tempInt = new int[SIZE];
						for (int i = 0; i < identifier; i++) {
							tempAccs[i] = accs[i]; 
							tempInt[i] = moneys[i];
							tempPws[i] = pws[i];
						}
						for (int i = identifier+1; i < accsCnt; i++) {
							tempAccs[i-1] = accs[i];
							tempInt[i-1] = moneys[i];
							tempPws[i-1] = pws[i];
						}
						accs = tempAccs;
						pws = tempPws;
						moneys = tempInt;
						accsCnt--;
						
						identifier = -1;
						System.out.println("[회원탈퇴완료] 자동 로그아웃됩니다. ");
					} else {
						System.out.println("[ERROR] 비밀번호를 틀리셨네요!");
					}
				}
			}
			else if (sel == 3) {	
				System.out.println("\n[로그인]");
				if(identifier != -1) {
					System.out.println("[ERROR] 이미 로그인 상태입니다. ");
					continue;
				}
				System.out.print("id : ");
				myId = scan.next();
				
				for (int i = 0; i < accsCnt; i++) {
					if(myId.equals(accs[i])) {
						System.out.print("pw : ");
						myPw = scan.next();
						
						if(myPw.equals(pws[i])) {
							identifier = i;
							System.out.println("[로그인성공]");
						} else {
							System.out.println("[ERROR] 비밀번호 오류");
						}
						break;
					} else {
						identifier = -1;
					}
				}
				if(identifier == -1) {
					System.out.println("[ERROR] 없는 ID");					
				}
			}
			else if (sel == 4) {	
				System.out.println("\n[로그아웃메뉴]");
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인 하셔야 접근 가능한 페이지입니다.");
					continue;
				}
				identifier = -1;
				System.out.println("[로그아웃 완료]");
			}
			else if (sel == 5) {	
				System.out.println("\n[입금메뉴]");
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인 하셔야 접근 가능한 페이지입니다.");
					continue;
				}
				System.out.print("입금하실 금액 : ");
				money = scan.nextInt();
				
				moneys[identifier] += money;
				
				System.out.printf("[입금성공] %d원 입금 후 %s님의 잔액은 %d원\n", money, accs[identifier], moneys[identifier]);
			}
			else if (sel == 6) {	
				System.out.println("\n[출금메뉴]");
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인 하셔야 접근 가능한 페이지입니다.");
					continue;
				}
				System.out.print("출금하실 금액 : ");
				money = scan.nextInt();
				
				if(moneys[identifier] < money) {
					System.out.println("[ERROR] 출금 금액은 잔고보다 적어야 합니다.");
					continue;
				} else { // 잔액 충분
					moneys[identifier] -= money;
				}
				System.out.printf("[출금성공] %d원 인출 후 %s님의 잔액은 %d원\n", money, accs[identifier], moneys[identifier]);
			}
			else if (sel == 7) {	
				System.out.println("\n[이체메뉴]");
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인 하셔야 접근 가능한 페이지입니다.");
					continue;
				}
				System.out.print("받으실 분 ID : ");
				String tempId = scan.next();
				int tempIdx = -1;
				
				for (int i = 0; i < accsCnt; i++) {
					if(tempId.equals(accs[i])) 	tempIdx = i;
					else						tempIdx = -1;
				}
				
				if(tempIdx == -1 || tempIdx == identifier) {
					System.out.println("[ERROR] 받으실 분 ID오류");
				} else {		// 받으실 분 존재
					System.out.print("이체하실 금액 : ");
					money = scan.nextInt();
					
					if(moneys[identifier] < money) {
						System.out.println("[ERROR] 이체 금액은 잔고보다 적어야 합니다.");
						continue;
					} else { // 잔액 충분
						moneys[identifier] -= money;
						moneys[tempIdx] += money;
					}
					System.out.printf("[이체성공] %d원 이체 후 %s님의 잔액은 %d원\n", money, accs[identifier], moneys[identifier]);
				}
			} else if (sel == 8) {	
				// 테스트용 전체회원 잔액조회
				System.out.println("[테스트용 전체회원 잔액조회]");	// 테스트용
				for (int i = 0; i < accsCnt; i++) {
					System.out.printf("%s님의 잔액은 %d원\n", accs[i], moneys[i]);
				} //
				
				System.out.println("\n[잔액조회메뉴]");	// 회원용
				if(identifier == -1) {
					System.out.println("[ERROR] 로그인 하셔야 접근 가능한 페이지입니다.");
					continue;
				}
				System.out.printf("%s님의 잔액은 %d원\n", accs[identifier], moneys[identifier]);
			}
			else if (sel == 9) {	// 저장
				try {
					fw = new FileWriter(fileName);
					String data = "";
					
					for (int i = 0; i < accsCnt; i++) {
						data += accs[i] + "/" + pws[i] + "/" + moneys[i] + "\n";
					} 
					fw.write(data);
					
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("[저장완료]");
			}
			else if (sel == 10) {	// 로드
//				if(identifier == -1) {
//					System.out.println("[ERROR] 로그인 하셔야 접근 가능한 페이지입니다.");
//					continue;
//				}
				String temp = "";
				String data = "";
				int tempIdx = -1;
			
				if(file.exists()) {
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						while(true) {
							temp = br.readLine();
							if(temp == null) {
								break;
							}
							tempIdx++;
							String[] tempArr = temp.split("/");
							accs[tempIdx] = tempArr[0];
							pws[tempIdx] = tempArr[1];
							moneys[tempIdx] = Integer.parseInt(tempArr[2]);
						}
						accsCnt = tempIdx + 1;
						br.close();
						fr.close();
						
//						System.out.println(Arrays.toString(accs));
//						System.out.println(Arrays.toString(pws));
//						System.out.println(Arrays.toString(moneys));
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("[ERROR] 존재하지 않는 파일 ");
				}
			}
			else if (sel == 0) { 	// 종료
				System.out.println("[프로그램 종료]");
				break;
			}
			
		}
		
	}
}
