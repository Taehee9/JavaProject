/*
 * ExceptionTest.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 11. 11
 * Contact : dhstoalfh9509@gmail.com
 */
package javaBasic;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * exception 테스트
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 11. 11.
 */
public class ExceptionTest {
	public static void main(String...args) throws IOException{
		try {
			// throws IOException 없어도 진행 가능 / try catch 로 쌓여져 있으니까
			exceptionTest(-5);
			// 위에서 에러났으므로 -10의 경우 진행 x
			exceptionTest(-10);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("exception!!");
		}
		// 이거 때문에 throws IOException 추가
		exceptionTest(18);
		// 위에서 에러났으므로 5의 경우 진행 x
		exceptionTest(5);
	}
	/**
	 * 0과 10 사이일 떄는 성공, 그 외엔 예외처리
	 * 2019. 11. 11., dhstoalfh9509@gmail.com
	 * @param i 매개변수
	 * @throws IOException, FileNotFoundException 예외처리
	 */
	public static void exceptionTest(int i) throws IOException, FileNotFoundException {
		if(i < 0){
		// 음수이면 FileNotFoundException 에러
			FileNotFoundException myException = new FileNotFoundException(i + " is a negative integer");
			throw myException;
		} else if(i > 10){
		// 10보다 크면 IOException 에러
			throw new IOException(i + " is not allowed. Only allowed index 0 to 10");
		} else{
		// 0과 10 사이일 때
			System.out.println(i + " success");
		}
	}
}
