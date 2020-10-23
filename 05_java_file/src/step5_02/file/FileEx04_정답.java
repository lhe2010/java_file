// 2020-10-23 금 1교시 15:22-15:27
package step5_02.file;

import java.io.FileWriter;

//# 파일 저장하기 : 연습문제2

public class FileEx04_정답 {

	public static void main(String[] args) {
		
		// momk/1111/20000
		// megait/2222/30000
		// github/3333/40000
		
		String[] names = {"momk", "megait", "github"};
		String[] pws   = {"1111",   "2222",   "3333"};
		int[]    moneys= { 20000,    30000,    40000};
		
		String fileName = "fileTest02.txt";
		FileWriter fw = null;
		
		String data = "";
		
		try {
			fw = new FileWriter(fileName);
			
			for (int i = 0; i < names.length; i++) {
				data += (names[i] + "/" + pws[i] + "/" + moneys[i] + "\n");
			}
			fw.write(data);
			
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}