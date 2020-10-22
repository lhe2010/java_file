// 2020-10-21 수요일 3교시 설명 
package step5_01.exception;
/*
 * 예외 (Exception) 처리
 * 심각한 오류를 발생시킬 수 있는 내용은
 * try/catch 구문 안에 만들도록 강제한다. 
 * 
 * try : 에러가 나지 않을 경우 정상적으로 실행 될 명령어
 * catch : try{} 안의 명령어가 실행되는 중 에러가 발생할 경우 분기되는 명령어 
 * 
 * - try없이 catch가 단독으로 올 수 없고, catch없이 try가 단독으로 올 수 없다. 
 */

public class ExceptionEx01 {

	public static void main(String[] args) {
		
		try {
			int[] testArr = new int[5];
			
			System.out.println(testArr[0]);		// 일반적인 경우
			System.out.println(testArr[9990]);	// 배열범위 초과
//			System.out.println(testArr[0]/0);	// 연산에러
			
		} catch ( ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace(); // ***************
			System.out.println("배열범위 초과에러");
		} catch ( ArithmeticException e) {
			System.out.println("0으로 나눈 에러");
		} catch ( Exception e) {
			System.out.println("모든 에러 처리 (모든 에러클래스의 조상)");
		}
		
		System.out.println("명령어1");
		System.out.println("명령어2");
		System.out.println("명령어3");
	}
}
