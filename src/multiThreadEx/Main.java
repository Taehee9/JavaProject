/*
 * Main.java
 * 
 * Author : taehee Kwon
 * Date : 2019. 10. 31
 * Contact : dhstoalfh9509@gmail.com
 */
package multiThreadEx;

/**
 * MultiThread를 이용한 예제
 * 
 * @author Taehee Kwon, dhstoalfh9509@gmail.com, 2019
 * @since  2019. 10. 31.
 */
public class Main {

	public static void main(String[] args) {
		Bank a = new Bank("송금");
		Bank b = new Bank("카드");
		
		a.start();
		b.start();
	}

}
