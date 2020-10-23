// 2020-10-23 금 1-2교시 15:44-16:25
package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

//# 파일 컨트롤러[1단계] : 벡터

public class FileEx06_정답 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String fileName = "vector.txt";
		FileWriter fw = null;
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		int[] vector = null;
		int elementCnt = 0;
		int input;
		String data = "";
		
		while (true) {
			
			System.out.println("\n[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) { // 벡터 추가
				System.out.print("1-1) 벡터에 추가하고 싶은 값 : ");
				input = scan.nextInt();
				int[] newVector = null;
				
				if(elementCnt == 0){
					newVector = new int[1];
					newVector[0] = input;
					vector = newVector;
				} else {
					newVector = new int[elementCnt+1];
					for (int i = 0; i < elementCnt; i++) 
						newVector[i] = vector[i];
					newVector[elementCnt] = input;
				}
				vector = newVector;
				elementCnt++;
				System.out.println("[추가완료]");
				System.out.println(Arrays.toString(vector));
			}
			else if (sel == 2) { // 삭제
				if(vector == null) {
					System.out.println("[ERROR] 빈 벡터입니다. ");
					continue;
				}
					
				System.out.print("2-1) 벡터에서 삭제하고 싶은 인덱스 : ");
				input = scan.nextInt();
				int[] newVector = null;
				
				if(elementCnt == 1){
					vector = null;
				} else {
					newVector = new int[elementCnt-1];
					for (int i = 0; i < input; i++) 
						newVector[i] = vector[i];
					for (int i = input+1; i < elementCnt; i++) 
						newVector[i-1] = vector[i];
				}
				vector = newVector;
				elementCnt--;
				System.out.println("[삭제완료]");
				System.out.println(Arrays.toString(newVector));				
			}
			else if (sel == 3) { // 저장
				// String으로 만들기 
				for (int i = 0; i < elementCnt; i++) {
					data += (vector[i] + "\n");
				}
				try {
					fw = new FileWriter(fileName);
					
					fw.write(data);
					
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("[저장완료]");
			}
			else if (sel == 4) { // 로드 
				if(file.exists()) {
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						String temp = "";
						data = "";
						
						while(true) {
							temp = br.readLine();
							if(temp == null)
								break;
							data += (temp + "\n"); 
						}
						System.out.println("[로드 결과]");
						System.out.println(data);
						
						br.close();
						fr.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			else if (sel == 5) { // 종료
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}
}
