// 2020-10-22 목 3교시 설명1
package step5_02.file;

import java.io.FileWriter;
import java.io.IOException;

// # 파일에 저장

public class FileEx01 {

	public static void main(String[] args) {
		
		String fileName = "ex01.txt"; 	// 변수로 따로 넣어야 함
		FileWriter fw = null; 			// 분할하여 try 밖에서 선언하고 안에서 생성 (bc. try안에 만든경우 finally에서 접근불가) 
		try {
			// 파일입출력은 try-catch없이 사용하지 못하게 강제성을 부여해 놓았다. 
			// 
			
			fw = new FileWriter(fileName);		// 파일 객체 생성
			fw.write("파일 저장하기 연습문제"); // 파일에 input (위에서 형식만들어서 한번에 write하는것 추천)
												// 1) 문자열 데이터 형식만 가능하다. 
												// 2) 개행기능이 없기 때문에 \n을 의도적으로 작성해야한다. 
			fw.close(); 						// [중요] 파일 객체 종료 (습관***)
			
			// 파일이 기본적으로 생성되는 위치는 같은 프로젝트이다. (변경가능)
			// 소스를 실행한 후 프로젝트를 선택한 뒤 F5(Refresh)를 누르면 생성된 파일을 확인할 수 있다. 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
