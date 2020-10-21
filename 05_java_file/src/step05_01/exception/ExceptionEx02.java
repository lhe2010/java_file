// 2020-10-21 수요일 3교시 설명2 
package step05_01.exception;
/*
 * finally
 * 예외발생과 상관없이 무조건 실행할 명령어를 작성한다. 
 * 주로 외부 모듈과의 컨넥션을 종료할 때 사용한다. 
 */

public class ExceptionEx02 {

	public static void main(String[] args) {
		
		try {
			int[] testArr = new int[5];
			
			System.out.println(testArr[0]);		// 일반적인 경우
//			System.out.println(testArr[9990]);	// 배열범위 초과
//			System.out.println(testArr[0]/0);	// 연산에러
			
		} catch ( Exception e) {
			System.out.println("에러 발생 시 동작할 프로시저"); // 프로시저 : DB함수 
		} finally { // db의무적으로 써야함
			System.out.println("예외발생과 상관없이 무조건 실행할 문장을 적는다. ");
			System.out.println("보통 외부 모듈과의 컨넥션을 종료할때 사용 ");
		}
		
		System.out.println("명령어1");
		System.out.println("명령어2");
		System.out.println("명령어3");
	}
}
