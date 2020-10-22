// 2020-10-22 목 3교시 17:44-17:49
package step5_02.file;

import java.io.FileWriter;

//# 파일 저장하기 : 연습문제1


public class FileEx03_정답 {

	public static void main(String[] args) {
		
		// 김철수/20,이만수/30,이영희/40
		
		String[] names = {"김철수", "이만수", "이영희"};
		int[]     ages = {	   20,     30,     40};
		
		String fileName = "fileTest01.txt";
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(fileName);
			String data = "";
			for (int i = 0; i < names.length; i++) {
				data += (names[i] + "/" + ages[i]);
				if(i != names.length-1) 
					data += ",";
			}
			
			fw.write(data);
			
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
