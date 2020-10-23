// 2020-10-23 금 1교시 15:29-15:43
package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//# 파일 로드하기 : 연습문제

public class FileEx05_정답 {

	public static void main(String[] args) {
		
		String[] ids = null;
		String[] pws = null;
		int[] moneys = null;
		
		String fileName = "fileTest02.txt";
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		if(file.exists()) {
			try {
				
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String data = "";
				
				do {
//					data = br.readLine() + "\n"; // null이어도 \n가 들어가있어서 무한루프.
					data = br.readLine();
					if(data != null)
						System.out.println(data);
//					System.out.println(data); 
					// do-while하면 마지막에 매번 null까지 읽어옴
					// -> 무한루프돌리고 읽어오기전에 null검사해서 나오는 방법(정답T)이 나을듯~
					
				} while(data != null);
				
				br.close();
				fr.close();
				
			} catch (Exception e) {
			}
		} else {
			System.out.println("[ERROR] 파일이 존재하지 않습니다. ");
		}



	}

}
