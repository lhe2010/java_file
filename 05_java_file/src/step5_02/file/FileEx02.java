// 2020-10-22 목 3교시 설명2
package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

// # 파일 로드 (불러오기)

public class FileEx02 {

	public static void main(String[] args) {
		
		String fileName = "ex01.txt";
		
		// [정석] 세가지 필요 	// br = new BufferedReader(new FileReader(new File(fileName)));
		File file 		  = new File(fileName);
		FileReader fr 	  = null; 
		BufferedReader br = null;
		
		if(file.exists()) { // 자바 기본제공
			// 파일이 존재하면
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String data = br.readLine();	// 한줄 읽어오는 메소드 
												// 읽어올 라인이 없으면 null을 반환한다. 
				System.out.println(data);
				
				br.close();
				fr.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("파일이 존재하지 않습니다. ");
		}

	}

}
